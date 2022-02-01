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
import com.tencent.mm.ah.a.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_CROP_WIDTH_RATIO", "", "TAG", "", "circleAreaPaint", "Landroid/graphics/Paint;", "circleLinePaint", "cropLayerColor", "cropLineColor", "cropLineWidth", "cropWidth", "cropWidthRatio", "imageBitmap", "Landroid/graphics/Bitmap;", "imageView", "Lcom/tencent/mm/ui/base/MultiTouchImageView;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scrollDetector", "Landroid/view/GestureDetector;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getCropBitmap", "onLayout", "changed", "", "left", "top", "right", "bottom", "setBitmap", "bitmap", "setCropLayerColor", "colorValue", "setCropLineColor", "setCropWidth", "width", "setCropWidthRatio", "ratio", "setImagePath", "filePath", "ScrollScaleListener", "SimpleTouchListener", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RoundCropLayout
  extends FrameLayout
{
  private final String TAG;
  private ScaleGestureDetector afVL;
  private final float agdF;
  private float agdG;
  private int agdH;
  private int agdI;
  private int agdJ;
  private Paint agdK;
  private Paint agdL;
  private GestureDetector agdM;
  private Bitmap imageBitmap;
  private int mVP;
  private MultiTouchImageView rUf;
  
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
    this.agdF = 0.9F;
    this.agdH = -1;
    this.agdI = bd.fromDPToPix(getContext(), 1);
    this.agdJ = getResources().getColor(a.d.BW_0_Alpha_0_3);
    this.agdK = new Paint();
    this.agdL = new Paint();
    setWillNotDraw(false);
    this.agdK.setColor(this.agdH);
    this.agdK.setStrokeWidth(this.agdI);
    this.agdK.setAntiAlias(true);
    this.agdK.setStyle(Paint.Style.STROKE);
    this.agdL.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.rUf = new MultiTouchImageView(paramContext, null);
    addView((View)this.rUf, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = new a();
    this.agdM = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)paramAttributeSet);
    this.afVL = new ScaleGestureDetector(paramContext, (ScaleGestureDetector.OnScaleGestureListener)paramAttributeSet);
    this.afVL.setQuickScaleEnabled(true);
    this.rUf.setOnTouchListener((View.OnTouchListener)new RoundCropLayout.b(this));
    setCropWidthRatio(this.agdF);
    AppMethodBeat.o(164466);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164464);
    super.draw(paramCanvas);
    if (paramCanvas != null)
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      paramCanvas.drawColor(this.agdJ);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mVP / 2 + this.agdI, this.agdK);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mVP / 2, this.agdL);
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
      int i = (getWidth() - this.mVP) / 2;
      int j = (getHeight() - this.mVP) / 2;
      Matrix localMatrix = new Matrix();
      this.rUf.getImageMatrix().invert(localMatrix);
      Object localObject = new RectF();
      localMatrix.mapRect((RectF)localObject, new RectF(i, j, getWidth() - i, getHeight() - j));
      Log.i(this.TAG, s.X("cropArea ", localObject));
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
      Log.i(this.TAG, s.X("fix cropArea ", localObject));
      if ((((RectF)localObject).width() > 0.0F) && (((RectF)localObject).height() > 0.0F))
      {
        localBitmap = this.imageBitmap;
        s.checkNotNull(localBitmap);
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
    if (this.mVP == 0) {
      this.mVP = ((int)(this.agdG * getWidth()));
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
      this.rUf.setImageBitmap(paramBitmap);
      this.rUf.dU(paramBitmap.getWidth(), paramBitmap.getHeight());
      this.rUf.jma();
    }
    AppMethodBeat.o(164460);
  }
  
  public final void setCropLayerColor(int paramInt)
  {
    this.agdJ = paramInt;
  }
  
  public final void setCropLineColor(int paramInt)
  {
    this.agdH = paramInt;
  }
  
  public final void setCropWidth(int paramInt)
  {
    this.mVP = paramInt;
  }
  
  public final void setCropWidthRatio(float paramFloat)
  {
    this.agdG = paramFloat;
  }
  
  public final void setImagePath(String paramString)
  {
    AppMethodBeat.i(164461);
    kotlin.c.a.cn((kotlin.g.a.a)new c(paramString, this));
    AppMethodBeat.o(164461);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    extends GestureDetector.SimpleOnGestureListener
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    public a()
    {
      AppMethodBeat.i(252518);
      AppMethodBeat.o(252518);
    }
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252560);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(252560);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252556);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(252556);
      return bool;
    }
    
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252554);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(252554);
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164456);
      if (paramScaleGestureDetector != null)
      {
        RoundCropLayout localRoundCropLayout = this.agdN;
        Log.d(RoundCropLayout.a(localRoundCropLayout), "onScale scaleFactor " + paramScaleGestureDetector.getScaleFactor() + " imageScale " + RoundCropLayout.d(localRoundCropLayout).getScale() + " pivot (" + paramScaleGestureDetector.getFocusX() + ", " + paramScaleGestureDetector.getFocusY() + ')');
        MultiTouchImageView localMultiTouchImageView = RoundCropLayout.d(localRoundCropLayout);
        float f = paramScaleGestureDetector.getScaleFactor();
        localMultiTouchImageView.x(RoundCropLayout.d(localRoundCropLayout).getScale() * f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      }
      AppMethodBeat.o(164456);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164454);
      Log.d(RoundCropLayout.a(this.agdN), "scale begin");
      AppMethodBeat.o(164454);
      return true;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164455);
      Log.d(RoundCropLayout.a(this.agdN), "scale end");
      AppMethodBeat.o(164455);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164453);
      if (paramMotionEvent2 != null)
      {
        paramMotionEvent1 = this.agdN;
        Log.d(RoundCropLayout.a(paramMotionEvent1), "distanceX " + paramFloat1 + " distanceY " + paramFloat2);
        RoundCropLayout.d(paramMotionEvent1).be(-paramFloat1, -paramFloat2);
        AppMethodBeat.o(164453);
        return true;
      }
      AppMethodBeat.o(164453);
      return false;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(252549);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(252549);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(String paramString, RoundCropLayout paramRoundCropLayout)
    {
      super();
    }
    
    private static final void a(RoundCropLayout paramRoundCropLayout, Bitmap paramBitmap)
    {
      AppMethodBeat.i(252522);
      s.u(paramRoundCropLayout, "this$0");
      paramRoundCropLayout.setBitmap(paramBitmap);
      AppMethodBeat.o(252522);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.RoundCropLayout
 * JD-Core Version:    0.7.0.1
 */