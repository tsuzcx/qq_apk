package com.tencent.mm.ui.widget.cropview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MultiTouchImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_CROP_WIDTH_RATIO", "", "TAG", "", "circleAreaPaint", "Landroid/graphics/Paint;", "circleLinePaint", "cropLayerColor", "cropLineColor", "cropLineWidth", "cropWidth", "cropWidthRatio", "imageBitmap", "Landroid/graphics/Bitmap;", "imageView", "Lcom/tencent/mm/ui/base/MultiTouchImageView;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scrollDetector", "Landroid/view/GestureDetector;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getCropBitmap", "onLayout", "changed", "", "left", "top", "right", "bottom", "setBitmap", "bitmap", "setCropLayerColor", "colorValue", "setCropLineColor", "setCropWidth", "width", "setCropWidthRatio", "ratio", "setImagePath", "filePath", "ScrollScaleListener", "SimpleTouchListener", "libmmui_release"})
public final class RoundCropLayout
  extends FrameLayout
{
  private ScaleGestureDetector QFu;
  private final float QMY;
  private float QMZ;
  private int QNa;
  private int QNb;
  private int QNc;
  private Paint QNd;
  private Paint QNe;
  private GestureDetector QNf;
  private final String TAG;
  private int hDQ;
  private Bitmap imageBitmap;
  private MultiTouchImageView lTJ;
  
  public RoundCropLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(164465);
    AppMethodBeat.o(164465);
  }
  
  public RoundCropLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164466);
    this.TAG = "MicroMsg.RoundCropLayout";
    this.QMY = 0.9F;
    this.QNa = -1;
    this.QNb = at.fromDPToPix(getContext(), 1);
    this.QNc = getResources().getColor(2131099662);
    this.QNd = new Paint();
    this.QNe = new Paint();
    setWillNotDraw(false);
    this.QNd.setColor(this.QNa);
    this.QNd.setStrokeWidth(this.QNb);
    this.QNd.setAntiAlias(true);
    this.QNd.setStyle(Paint.Style.STROKE);
    this.QNe.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.lTJ = new MultiTouchImageView(paramContext, null);
    addView((View)this.lTJ, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = new a();
    this.QNf = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)paramAttributeSet);
    this.QFu = new ScaleGestureDetector(paramContext, (ScaleGestureDetector.OnScaleGestureListener)paramAttributeSet);
    this.QFu.setQuickScaleEnabled(true);
    this.lTJ.setOnTouchListener((View.OnTouchListener)new b());
    setCropWidthRatio(this.QMY);
    AppMethodBeat.o(164466);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164464);
    super.draw(paramCanvas);
    if (paramCanvas != null)
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      paramCanvas.drawColor(this.QNc);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.hDQ / 2 + this.QNb, this.QNd);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.hDQ / 2, this.QNe);
      paramCanvas.restoreToCount(i);
    }
    AppMethodBeat.o(164464);
  }
  
  public final Bitmap getCropBitmap()
  {
    AppMethodBeat.i(164462);
    Bitmap localBitmap = this.imageBitmap;
    if (localBitmap != null)
    {
      int i = (getWidth() - this.hDQ) / 2;
      int j = (getHeight() - this.hDQ) / 2;
      Matrix localMatrix = new Matrix();
      this.lTJ.getImageMatrix().invert(localMatrix);
      Object localObject = new RectF();
      localMatrix.mapRect((RectF)localObject, new RectF(i, j, getWidth() - i, getHeight() - j));
      Log.i(this.TAG, "cropArea ".concat(String.valueOf(localObject)));
      if (((RectF)localObject).left < 0.0F) {
        ((RectF)localObject).left = 0.0F;
      }
      if (((RectF)localObject).top < 0.0F) {
        ((RectF)localObject).top = 0.0F;
      }
      if (((RectF)localObject).right > localBitmap.getWidth()) {
        ((RectF)localObject).right = localBitmap.getWidth();
      }
      if (((RectF)localObject).bottom > localBitmap.getHeight()) {
        ((RectF)localObject).bottom = localBitmap.getHeight();
      }
      Log.i(this.TAG, "fix cropArea ".concat(String.valueOf(localObject)));
      if ((((RectF)localObject).width() > 0.0F) && (((RectF)localObject).height() > 0.0F))
      {
        localBitmap = this.imageBitmap;
        if (localBitmap == null) {
          p.hyc();
        }
        localObject = Bitmap.createBitmap(localBitmap, (int)((RectF)localObject).left, (int)((RectF)localObject).top, (int)((RectF)localObject).width(), (int)((RectF)localObject).height());
        AppMethodBeat.o(164462);
        return localObject;
      }
    }
    AppMethodBeat.o(164462);
    return null;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164463);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.hDQ == 0) {
      this.hDQ = ((int)(this.QMZ * getWidth()));
    }
    AppMethodBeat.o(164463);
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(164460);
    this.imageBitmap = paramBitmap;
    paramBitmap = this.imageBitmap;
    if (paramBitmap != null)
    {
      this.lTJ.setImageBitmap(paramBitmap);
      this.lTJ.cN(paramBitmap.getWidth(), paramBitmap.getHeight());
      this.lTJ.gKy();
      AppMethodBeat.o(164460);
      return;
    }
    AppMethodBeat.o(164460);
  }
  
  public final void setCropLayerColor(int paramInt)
  {
    this.QNc = paramInt;
  }
  
  public final void setCropLineColor(int paramInt)
  {
    this.QNa = paramInt;
  }
  
  public final void setCropWidth(int paramInt)
  {
    this.hDQ = paramInt;
  }
  
  public final void setCropWidthRatio(float paramFloat)
  {
    this.QMZ = paramFloat;
  }
  
  public final void setImagePath(final String paramString)
  {
    AppMethodBeat.i(164461);
    kotlin.c.a.ai((kotlin.g.a.a)new c(this, paramString));
    AppMethodBeat.o(164461);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "libmmui_release"})
  final class a
    extends GestureDetector.SimpleOnGestureListener
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204908);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(204908);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204907);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(204907);
      return bool;
    }
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204906);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(204906);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164456);
      if (paramScaleGestureDetector != null)
      {
        Log.d(RoundCropLayout.a(this.QNg), "onScale scaleFactor " + paramScaleGestureDetector.getScaleFactor() + " imageScale " + RoundCropLayout.d(this.QNg).getScale() + " pivot (" + paramScaleGestureDetector.getFocusX() + ", " + paramScaleGestureDetector.getFocusY() + ')');
        RoundCropLayout.d(this.QNg).r(paramScaleGestureDetector.getScaleFactor() * RoundCropLayout.d(this.QNg).getScale(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      }
      AppMethodBeat.o(164456);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164454);
      Log.d(RoundCropLayout.a(this.QNg), "scale begin");
      AppMethodBeat.o(164454);
      return true;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164455);
      Log.d(RoundCropLayout.a(this.QNg), "scale end");
      AppMethodBeat.o(164455);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164453);
      if (paramMotionEvent2 != null)
      {
        Log.d(RoundCropLayout.a(this.QNg), "distanceX " + paramFloat1 + " distanceY " + paramFloat2);
        RoundCropLayout.d(this.QNg).au(-paramFloat1, -paramFloat2);
        AppMethodBeat.o(164453);
        return true;
      }
      AppMethodBeat.o(164453);
      return false;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(204905);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(204905);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener;", "Landroid/view/View$OnTouchListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "isScale", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
  final class b
    implements View.OnTouchListener
  {
    private boolean hDM;
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(164457);
      if (paramMotionEvent != null)
      {
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        Log.d(RoundCropLayout.a(this.QNg), "action ".concat(String.valueOf(paramView)));
        if (paramView != null) {
          break label144;
        }
        label40:
        if (paramView != null) {
          break label159;
        }
      }
      for (;;)
      {
        RoundCropLayout.b(this.QNg).onTouchEvent(paramMotionEvent);
        if (!this.hDM)
        {
          paramView = RoundCropLayout.c(this.QNg);
          paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(paramView, paramMotionEvent.axQ(), "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        }
        AppMethodBeat.o(164457);
        return true;
        paramView = null;
        break;
        label144:
        if (paramView.intValue() != 0) {
          break label40;
        }
        this.hDM = false;
        continue;
        label159:
        if ((paramView.intValue() == 5) && (paramMotionEvent.getPointerCount() == 2)) {
          this.hDM = true;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(RoundCropLayout paramRoundCropLayout, String paramString)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/ui/widget/cropview/RoundCropLayout$setImagePath$1$1$1"})
    static final class a
      implements Runnable
    {
      a(RoundCropLayout.c paramc, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(164458);
        this.QNh.QNg.setBitmap(this.zZz);
        AppMethodBeat.o(164458);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.RoundCropLayout
 * JD-Core Version:    0.7.0.1
 */