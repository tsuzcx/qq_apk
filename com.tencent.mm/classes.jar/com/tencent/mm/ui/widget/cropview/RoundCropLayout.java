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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_CROP_WIDTH_RATIO", "", "TAG", "", "circleAreaPaint", "Landroid/graphics/Paint;", "circleLinePaint", "cropLayerColor", "cropLineColor", "cropLineWidth", "cropWidth", "cropWidthRatio", "imageBitmap", "Landroid/graphics/Bitmap;", "imageView", "Lcom/tencent/mm/ui/base/MultiTouchImageView;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scrollDetector", "Landroid/view/GestureDetector;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getCropBitmap", "onLayout", "changed", "", "left", "top", "right", "bottom", "setBitmap", "bitmap", "setCropLayerColor", "colorValue", "setCropLineColor", "setCropWidth", "width", "setCropWidthRatio", "ratio", "setImagePath", "filePath", "ScrollScaleListener", "SimpleTouchListener", "libmmui_release"})
public final class RoundCropLayout
  extends FrameLayout
{
  private ScaleGestureDetector JcX;
  private final float JeB;
  private float JeC;
  private int JeD;
  private int JeE;
  private int JeF;
  private Paint JeG;
  private Paint JeH;
  private GestureDetector JeI;
  private final String TAG;
  private int gry;
  private Bitmap imageBitmap;
  private MultiTouchImageView kqu;
  
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
    this.JeB = 0.9F;
    this.JeD = -1;
    this.JeE = ao.fromDPToPix(getContext(), 1);
    this.JeF = getResources().getColor(2131099660);
    this.JeG = new Paint();
    this.JeH = new Paint();
    setWillNotDraw(false);
    this.JeG.setColor(this.JeD);
    this.JeG.setStrokeWidth(this.JeE);
    this.JeG.setAntiAlias(true);
    this.JeG.setStyle(Paint.Style.STROKE);
    this.JeH.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.kqu = new MultiTouchImageView(paramContext, null);
    addView((View)this.kqu, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = new a();
    this.JeI = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)paramAttributeSet);
    this.JcX = new ScaleGestureDetector(paramContext, (ScaleGestureDetector.OnScaleGestureListener)paramAttributeSet);
    this.JcX.setQuickScaleEnabled(true);
    this.kqu.setOnTouchListener((View.OnTouchListener)new b());
    setCropWidthRatio(this.JeB);
    AppMethodBeat.o(164466);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164464);
    super.draw(paramCanvas);
    if (paramCanvas != null)
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      paramCanvas.drawColor(this.JeF);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.gry / 2 + this.JeE, this.JeG);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.gry / 2, this.JeH);
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
      int i = (getWidth() - this.gry) / 2;
      int j = (getHeight() - this.gry) / 2;
      Matrix localMatrix = new Matrix();
      this.kqu.getImageMatrix().invert(localMatrix);
      RectF localRectF = new RectF();
      localMatrix.mapRect(localRectF, new RectF(i, j, getWidth() - i, getHeight() - j));
      ac.i(this.TAG, "cropArea ".concat(String.valueOf(localRectF)));
      if (localRectF.left < 0.0F) {
        localRectF.left = 0.0F;
      }
      if (localRectF.top < 0.0F) {
        localRectF.top = 0.0F;
      }
      if (localRectF.right > localBitmap.getWidth()) {
        localRectF.right = localBitmap.getWidth();
      }
      if (localRectF.bottom > localBitmap.getHeight()) {
        localRectF.bottom = localBitmap.getHeight();
      }
      ac.i(this.TAG, "fix cropArea ".concat(String.valueOf(localRectF)));
      if ((localRectF.width() > 0.0F) && (localRectF.height() > 0.0F))
      {
        localBitmap = Bitmap.createBitmap(this.imageBitmap, (int)localRectF.left, (int)localRectF.top, (int)localRectF.width(), (int)localRectF.height());
        AppMethodBeat.o(164462);
        return localBitmap;
      }
    }
    AppMethodBeat.o(164462);
    return null;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(164463);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.gry == 0) {
      this.gry = ((int)(this.JeC * getWidth()));
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
      this.kqu.setImageBitmap(paramBitmap);
      this.kqu.cF(paramBitmap.getWidth(), paramBitmap.getHeight());
      this.kqu.fij();
      AppMethodBeat.o(164460);
      return;
    }
    AppMethodBeat.o(164460);
  }
  
  public final void setCropLayerColor(int paramInt)
  {
    this.JeF = paramInt;
  }
  
  public final void setCropLineColor(int paramInt)
  {
    this.JeD = paramInt;
  }
  
  public final void setCropWidth(int paramInt)
  {
    this.gry = paramInt;
  }
  
  public final void setCropWidthRatio(float paramFloat)
  {
    this.JeC = paramFloat;
  }
  
  public final void setImagePath(final String paramString)
  {
    AppMethodBeat.i(164461);
    d.c.a.L((d.g.a.a)new c(this, paramString));
    AppMethodBeat.o(164461);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "libmmui_release"})
  final class a
    extends GestureDetector.SimpleOnGestureListener
    implements ScaleGestureDetector.OnScaleGestureListener
  {
    public final boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164456);
      if (paramScaleGestureDetector != null)
      {
        ac.d(RoundCropLayout.a(this.JeJ), "onScale scaleFactor " + paramScaleGestureDetector.getScaleFactor() + " imageScale " + RoundCropLayout.d(this.JeJ).getScale() + " pivot (" + paramScaleGestureDetector.getFocusX() + ", " + paramScaleGestureDetector.getFocusY() + ')');
        RoundCropLayout.d(this.JeJ).m(paramScaleGestureDetector.getScaleFactor() * RoundCropLayout.d(this.JeJ).getScale(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      }
      AppMethodBeat.o(164456);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164454);
      ac.d(RoundCropLayout.a(this.JeJ), "scale begin");
      AppMethodBeat.o(164454);
      return true;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164455);
      ac.d(RoundCropLayout.a(this.JeJ), "scale end");
      AppMethodBeat.o(164455);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164453);
      if (paramMotionEvent2 != null)
      {
        ac.d(RoundCropLayout.a(this.JeJ), "distanceX " + paramFloat1 + " distanceY " + paramFloat2);
        RoundCropLayout.d(this.JeJ).ak(-paramFloat1, -paramFloat2);
        AppMethodBeat.o(164453);
        return true;
      }
      AppMethodBeat.o(164453);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$SimpleTouchListener;", "Landroid/view/View$OnTouchListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "isScale", "", "onTouch", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "libmmui_release"})
  final class b
    implements View.OnTouchListener
  {
    private boolean gru;
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(164457);
      if (paramMotionEvent != null)
      {
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        ac.d(RoundCropLayout.a(this.JeJ), "action ".concat(String.valueOf(paramView)));
        if (paramView != null) {
          break label87;
        }
        label40:
        if (paramView != null) {
          break label102;
        }
      }
      for (;;)
      {
        RoundCropLayout.b(this.JeJ).onTouchEvent(paramMotionEvent);
        if (!this.gru) {
          RoundCropLayout.c(this.JeJ).onTouchEvent(paramMotionEvent);
        }
        AppMethodBeat.o(164457);
        return true;
        paramView = null;
        break;
        label87:
        if (paramView.intValue() != 0) {
          break label40;
        }
        this.gru = false;
        continue;
        label102:
        if ((paramView.intValue() == 5) && (paramMotionEvent.getPointerCount() == 2)) {
          this.gru = true;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(RoundCropLayout paramRoundCropLayout, String paramString)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/ui/widget/cropview/RoundCropLayout$setImagePath$1$1$1"})
    static final class a
      implements Runnable
    {
      a(RoundCropLayout.c paramc, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(164458);
        this.JeK.JeJ.setBitmap(this.Aov);
        AppMethodBeat.o(164458);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.RoundCropLayout
 * JD-Core Version:    0.7.0.1
 */