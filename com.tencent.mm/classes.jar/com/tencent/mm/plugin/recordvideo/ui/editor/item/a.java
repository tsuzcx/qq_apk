package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mm.media.editor.a.e;
import com.tencent.mm.media.editor.a.h;
import com.tencent.mm.media.editor.a.i;
import com.tencent.mm.media.editor.a.m;
import com.tencent.mm.media.editor.c.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/media/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/media/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/media/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "paint", "Landroid/graphics/Paint;", "sourceDataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "", "getTouchMoved", "()Z", "setTouchMoved", "(Z)V", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validRect", "getValidRect", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "getContentBoundary", "", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public abstract class a
  extends View
  implements h, d
{
  private Bitmap bitmap;
  private int color;
  private boolean fTb;
  private float fTe;
  private float fTf;
  private int gPW;
  private final Paint paint = new Paint();
  private final c ppQ = new c();
  private final int qc;
  private CharSequence text;
  private float textSize = getResources().getDimension(2131166195);
  private final com.tencent.mm.media.editor.view.a wCA;
  private EditorItemContainer.b wCB;
  private final int wCC = ap.ej(ai.getContext());
  private final Rect wCD = new Rect(0, 0, ap.cl(ai.getContext()).x, ap.cl(ai.getContext()).y);
  private final Rect wCE = new Rect(0, 0, ap.cl(ai.getContext()).x, ap.cl(ai.getContext()).y);
  private int wCF;
  private i wCG;
  private e wCH = e.gPo;
  private Matrix wCI;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.ppQ.aNl = 0.5F;
    this.ppQ.aNk = 3.0F;
    Resources localResources = getResources();
    k.g(localResources, "resources");
    this.wCA = new com.tencent.mm.media.editor.view.a(localResources);
    paramContext = ViewConfiguration.get(paramContext);
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.qc = paramContext.getScaledTouchSlop();
    this.paint.setAntiAlias(true);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    k.h(paramRect, "displayRect");
    this.wCE.set(paramRect);
    this.ppQ.eY.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
  }
  
  public final com.tencent.mm.media.editor.a.a aqy()
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.ppQ.eY);
    localMatrix.postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
    if ((this.wCH == e.gPo) || (this.wCH == e.gPr)) {
      return (com.tencent.mm.media.editor.a.a)new m(this.text, this.color, this.wCF, this.gPW, this.wCH, localMatrix);
    }
    Object localObject1 = this.wCG;
    if (localObject1 == null) {
      k.fOy();
    }
    localObject1 = ((i)localObject1).gPx;
    Object localObject2 = this.wCG;
    if (localObject2 == null) {
      k.fOy();
    }
    localObject2 = ((i)localObject2).gPy;
    i locali = this.wCG;
    if (locali == null) {
      k.fOy();
    }
    float f = locali.doB;
    locali = this.wCG;
    if (locali == null) {
      k.fOy();
    }
    return (com.tencent.mm.media.editor.a.a)new i((String)localObject1, (String)localObject2, f, locali.dmL, localMatrix);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    k.h(paramRect, "safeRect");
    this.ppQ.gQo = paramRect;
    this.ppQ.gQp = com.tencent.mm.cc.a.fromDPToPix(getContext(), paramInt);
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.ppQ.eY);
    localMatrix.postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    return (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.d(this.bitmap, localMatrix);
  }
  
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public final int getColor()
  {
    return this.color;
  }
  
  public float[] getContentBoundary()
  {
    return (float[])this.ppQ.gQu.clone();
  }
  
  protected final Rect getDisplayRect()
  {
    return this.wCE;
  }
  
  public final i getLocation()
  {
    return this.wCG;
  }
  
  public final int getMarginBottom()
  {
    return this.gPW;
  }
  
  protected final int getNavigateBarHeight()
  {
    return this.wCC;
  }
  
  public Rect getSafeArea()
  {
    Rect localRect = this.ppQ.gQo;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      k.g(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      k.g(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    return localObject;
  }
  
  public final e getSourceDataType()
  {
    return this.wCH;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextBg()
  {
    return this.wCF;
  }
  
  public final float getTextSize()
  {
    return this.textSize;
  }
  
  public final float getTouchDownX()
  {
    return this.fTe;
  }
  
  public final float getTouchDownY()
  {
    return this.fTf;
  }
  
  public final boolean getTouchMoved()
  {
    return this.fTb;
  }
  
  public final int getTouchSlop()
  {
    return this.qc;
  }
  
  public final c getTouchTracker()
  {
    return this.ppQ;
  }
  
  protected final Rect getValidRect()
  {
    return this.wCD;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.wCI;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    k.h(paramCanvas, "canvas");
    paramCanvas.save();
    if (this.wCI != null) {
      paramCanvas.setMatrix(this.wCI);
    }
    for (;;)
    {
      if (isActivated()) {
        this.wCA.draw(paramCanvas);
      }
      if (this.bitmap != null) {
        paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      return;
      paramCanvas.setMatrix(this.ppQ.eY);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    k.h(paramMotionEvent, "event");
    boolean bool2 = this.ppQ.t(paramMotionEvent);
    if (bool2)
    {
      bringToFront();
      localObject = this.wCB;
      if (localObject != null) {
        ((EditorItemContainer.b)localObject).c((View)this, paramMotionEvent);
      }
      postInvalidate();
    }
    if (bool2) {}
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
    case 2: 
      float f;
      do
      {
        return bool2;
        this.fTe = paramMotionEvent.getX();
        this.fTf = paramMotionEvent.getY();
        this.fTb = false;
        return bool2;
        f = Math.max(Math.abs(paramMotionEvent.getX() - this.fTe), Math.abs(paramMotionEvent.getY() - this.fTf));
      } while (this.fTb);
      if (f > this.qc) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.fTb = bool1;
        return bool2;
      }
    }
    if (!this.fTb)
    {
      performClick();
      return bool2;
    }
    paramMotionEvent = new com.tencent.mm.media.editor.c.a();
    Object localObject = this.wCD;
    paramMotionEvent.aNl = this.ppQ.aNl;
    paramMotionEvent.aNk = this.ppQ.aNk;
    paramMotionEvent.k(new float[] { this.ppQ.width / 2.0F, this.ppQ.height / 2.0F });
    paramMotionEvent.e(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
    paramMotionEvent.a(this.ppQ.eY, (d.g.a.b)new a(this));
    return bool2;
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.ppQ.width = paramBitmap.getWidth();
      this.ppQ.height = paramBitmap.getHeight();
      this.ppQ.eY.preTranslate(-paramBitmap.getWidth() / 2.0F, -paramBitmap.getHeight() / 2.0F);
      this.wCA.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.ppQ.l(new float[] { 0.0F, 0.0F, paramBitmap.getWidth(), 0.0F, 0.0F, paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight() });
    }
  }
  
  public final void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setLocation(i parami)
  {
    this.wCG = parami;
  }
  
  public final void setMarginBottom(int paramInt)
  {
    this.gPW = paramInt;
  }
  
  public final void setSourceDataType(e parame)
  {
    k.h(parame, "<set-?>");
    this.wCH = parame;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    k.h(paramb, "stateResolve");
    this.wCB = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.text = paramCharSequence;
  }
  
  public final void setTextBg(int paramInt)
  {
    this.wCF = paramInt;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
  
  public final void setTouchDownX(float paramFloat)
  {
    this.fTe = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.fTf = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.fTb = paramBoolean;
  }
  
  public void setValidArea(Rect paramRect)
  {
    k.h(paramRect, "validRect");
    this.wCD.set(paramRect);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    this.wCI = paramMatrix;
    if (paramMatrix != null)
    {
      this.ppQ.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.wCI != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.wCA.draw(localCanvas);
      }
      if (this.bitmap != null) {
        localCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Matrix, y>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a
 * JD-Core Version:    0.7.0.1
 */