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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_CROP_WIDTH_RATIO", "", "TAG", "", "circleAreaPaint", "Landroid/graphics/Paint;", "circleLinePaint", "cropLayerColor", "cropLineColor", "cropLineWidth", "cropWidth", "cropWidthRatio", "imageBitmap", "Landroid/graphics/Bitmap;", "imageView", "Lcom/tencent/mm/ui/base/MultiTouchImageView;", "scaleDetector", "Landroid/view/ScaleGestureDetector;", "scrollDetector", "Landroid/view/GestureDetector;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getCropBitmap", "onLayout", "changed", "", "left", "top", "right", "bottom", "setBitmap", "bitmap", "setCropLayerColor", "colorValue", "setCropLineColor", "setCropWidth", "width", "setCropWidthRatio", "ratio", "setImagePath", "filePath", "ScrollScaleListener", "SimpleTouchListener", "libmmui_release"})
public final class RoundCropLayout
  extends FrameLayout
{
  private ScaleGestureDetector HCB;
  private final float HEe;
  private float HEf;
  private int HEg;
  private int HEh;
  private int HEi;
  private int HEj;
  private Paint HEk;
  private Paint HEl;
  private GestureDetector HEm;
  private final String TAG;
  private Bitmap imageBitmap;
  private MultiTouchImageView jPH;
  
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
    this.HEe = 0.9F;
    this.HEh = -1;
    this.HEi = ao.fromDPToPix(getContext(), 1);
    this.HEj = getResources().getColor(2131099660);
    this.HEk = new Paint();
    this.HEl = new Paint();
    setWillNotDraw(false);
    this.HEk.setColor(this.HEh);
    this.HEk.setStrokeWidth(this.HEi);
    this.HEk.setAntiAlias(true);
    this.HEk.setStyle(Paint.Style.STROKE);
    this.HEl.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jPH = new MultiTouchImageView(paramContext, null);
    addView((View)this.jPH, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = new a();
    this.HEm = new GestureDetector(paramContext, (GestureDetector.OnGestureListener)paramAttributeSet);
    this.HCB = new ScaleGestureDetector(paramContext, (ScaleGestureDetector.OnScaleGestureListener)paramAttributeSet);
    this.HCB.setQuickScaleEnabled(true);
    this.jPH.setOnTouchListener((View.OnTouchListener)new RoundCropLayout.b(this));
    setCropWidthRatio(this.HEe);
    AppMethodBeat.o(164466);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(164464);
    super.draw(paramCanvas);
    if (paramCanvas != null)
    {
      int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
      paramCanvas.drawColor(this.HEj);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.HEg / 2 + this.HEi, this.HEk);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.HEg / 2, this.HEl);
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
      int i = (getWidth() - this.HEg) / 2;
      int j = (getHeight() - this.HEg) / 2;
      Matrix localMatrix = new Matrix();
      this.jPH.getImageMatrix().invert(localMatrix);
      RectF localRectF = new RectF();
      localMatrix.mapRect(localRectF, new RectF(i, j, getWidth() - i, getHeight() - j));
      ad.i(this.TAG, "cropArea ".concat(String.valueOf(localRectF)));
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
      ad.i(this.TAG, "fix cropArea ".concat(String.valueOf(localRectF)));
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
    if (this.HEg == 0) {
      this.HEg = ((int)(this.HEf * getWidth()));
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
      this.jPH.setImageBitmap(paramBitmap);
      this.jPH.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
      this.jPH.eSz();
      AppMethodBeat.o(164460);
      return;
    }
    AppMethodBeat.o(164460);
  }
  
  public final void setCropLayerColor(int paramInt)
  {
    this.HEj = paramInt;
  }
  
  public final void setCropLineColor(int paramInt)
  {
    this.HEh = paramInt;
  }
  
  public final void setCropWidth(int paramInt)
  {
    this.HEg = paramInt;
  }
  
  public final void setCropWidthRatio(float paramFloat)
  {
    this.HEf = paramFloat;
  }
  
  public final void setImagePath(final String paramString)
  {
    AppMethodBeat.i(164461);
    d.c.a.V((d.g.a.a)new c(this, paramString));
    AppMethodBeat.o(164461);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout$ScrollScaleListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "(Lcom/tencent/mm/ui/widget/cropview/RoundCropLayout;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "onScroll", "e1", "e2", "distanceX", "", "distanceY", "libmmui_release"})
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
        ad.d(RoundCropLayout.a(this.HEn), "onScale scaleFactor " + paramScaleGestureDetector.getScaleFactor() + " imageScale " + RoundCropLayout.d(this.HEn).getScale() + " pivot (" + paramScaleGestureDetector.getFocusX() + ", " + paramScaleGestureDetector.getFocusY() + ')');
        RoundCropLayout.d(this.HEn).m(paramScaleGestureDetector.getScaleFactor() * RoundCropLayout.d(this.HEn).getScale(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
      }
      AppMethodBeat.o(164456);
      return true;
    }
    
    public final boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164454);
      ad.d(RoundCropLayout.a(this.HEn), "scale begin");
      AppMethodBeat.o(164454);
      return true;
    }
    
    public final void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      AppMethodBeat.i(164455);
      ad.d(RoundCropLayout.a(this.HEn), "scale end");
      AppMethodBeat.o(164455);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(164453);
      if (paramMotionEvent2 != null)
      {
        ad.d(RoundCropLayout.a(this.HEn), "distanceX " + paramFloat1 + " distanceY " + paramFloat2);
        RoundCropLayout.d(this.HEn).ag(-paramFloat1, -paramFloat2);
        AppMethodBeat.o(164453);
        return true;
      }
      AppMethodBeat.o(164453);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(RoundCropLayout paramRoundCropLayout, String paramString)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/ui/widget/cropview/RoundCropLayout$setImagePath$1$1$1"})
    static final class a
      implements Runnable
    {
      a(RoundCropLayout.c paramc, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(164458);
        this.HEp.HEn.setBitmap(this.HEq);
        AppMethodBeat.o(164458);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cropview.RoundCropLayout
 * JD-Core Version:    0.7.0.1
 */