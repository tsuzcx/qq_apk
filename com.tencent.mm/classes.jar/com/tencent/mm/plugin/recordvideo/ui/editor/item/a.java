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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/media/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/media/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/media/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "paint", "Landroid/graphics/Paint;", "sourceDataType", "Lcom/tencent/mm/media/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/media/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/media/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "", "getTouchMoved", "()Z", "setTouchMoved", "(Z)V", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validRect", "getValidRect", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "getContentBoundary", "", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public abstract class a
  extends View
  implements h, d
{
  private Bitmap bitmap;
  private int color;
  private boolean fPg;
  private float fPj;
  private float fPk;
  private int gpo;
  private final c oMw = new c();
  private final Paint paint = new Paint();
  private final int pd;
  private CharSequence text;
  private float textSize = getResources().getDimension(2131166195);
  private final com.tencent.mm.media.editor.view.a vsA;
  private EditorItemContainer.b vsB;
  private final int vsC = ap.eb(aj.getContext());
  private final Rect vsD = new Rect(0, 0, ap.cf(aj.getContext()).x, ap.cf(aj.getContext()).y);
  private final Rect vsE = new Rect(0, 0, ap.cf(aj.getContext()).x, ap.cf(aj.getContext()).y);
  private int vsF;
  private i vsG;
  private e vsH = e.goG;
  private Matrix vsI;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.oMw.aMv = 0.5F;
    this.oMw.aMu = 3.0F;
    Resources localResources = getResources();
    k.g(localResources, "resources");
    this.vsA = new com.tencent.mm.media.editor.view.a(localResources);
    paramContext = ViewConfiguration.get(paramContext);
    k.g(paramContext, "ViewConfiguration.get(context)");
    this.pd = paramContext.getScaledTouchSlop();
    this.paint.setAntiAlias(true);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    k.h(paramRect, "displayRect");
    this.vsE.set(paramRect);
    this.oMw.dY.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
  }
  
  public final com.tencent.mm.media.editor.a.a ajz()
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.oMw.dY);
    localMatrix.postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
    if ((this.vsH == e.goG) || (this.vsH == e.goJ)) {
      return (com.tencent.mm.media.editor.a.a)new m(this.text, this.color, this.vsF, this.gpo, this.vsH, localMatrix);
    }
    Object localObject1 = this.vsG;
    if (localObject1 == null) {
      k.fvU();
    }
    localObject1 = ((i)localObject1).goP;
    Object localObject2 = this.vsG;
    if (localObject2 == null) {
      k.fvU();
    }
    localObject2 = ((i)localObject2).goQ;
    i locali = this.vsG;
    if (locali == null) {
      k.fvU();
    }
    float f = locali.dqQ;
    locali = this.vsG;
    if (locali == null) {
      k.fvU();
    }
    return (com.tencent.mm.media.editor.a.a)new i((String)localObject1, (String)localObject2, f, locali.dpb, localMatrix);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    k.h(paramRect, "safeRect");
    this.oMw.gpG = paramRect;
    this.oMw.gpH = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.oMw.dY);
    localMatrix.postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
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
    return (float[])this.oMw.gpM.clone();
  }
  
  protected final Rect getDisplayRect()
  {
    return this.vsE;
  }
  
  public final i getLocation()
  {
    return this.vsG;
  }
  
  public final int getMarginBottom()
  {
    return this.gpo;
  }
  
  protected final int getNavigateBarHeight()
  {
    return this.vsC;
  }
  
  public Rect getSafeArea()
  {
    Rect localRect = this.oMw.gpG;
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
    return this.vsH;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextBg()
  {
    return this.vsF;
  }
  
  public final float getTextSize()
  {
    return this.textSize;
  }
  
  public final float getTouchDownX()
  {
    return this.fPj;
  }
  
  public final float getTouchDownY()
  {
    return this.fPk;
  }
  
  public final boolean getTouchMoved()
  {
    return this.fPg;
  }
  
  public final int getTouchSlop()
  {
    return this.pd;
  }
  
  public final c getTouchTracker()
  {
    return this.oMw;
  }
  
  protected final Rect getValidRect()
  {
    return this.vsD;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.vsI;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    k.h(paramCanvas, "canvas");
    paramCanvas.save();
    if (this.vsI != null) {
      paramCanvas.setMatrix(this.vsI);
    }
    for (;;)
    {
      if (isActivated()) {
        this.vsA.draw(paramCanvas);
      }
      if (this.bitmap != null) {
        paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, this.paint);
      }
      paramCanvas.restore();
      return;
      paramCanvas.setMatrix(this.oMw.dY);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    k.h(paramMotionEvent, "event");
    boolean bool2 = this.oMw.v(paramMotionEvent);
    if (bool2)
    {
      bringToFront();
      localObject = this.vsB;
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
        this.fPj = paramMotionEvent.getX();
        this.fPk = paramMotionEvent.getY();
        this.fPg = false;
        return bool2;
        f = Math.max(Math.abs(paramMotionEvent.getX() - this.fPj), Math.abs(paramMotionEvent.getY() - this.fPk));
      } while (this.fPg);
      if (f > this.pd) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        this.fPg = bool1;
        return bool2;
      }
    }
    if (!this.fPg)
    {
      performClick();
      return bool2;
    }
    paramMotionEvent = new com.tencent.mm.media.editor.c.a();
    Object localObject = this.vsD;
    paramMotionEvent.aMv = this.oMw.aMv;
    paramMotionEvent.aMu = this.oMw.aMu;
    paramMotionEvent.k(new float[] { this.oMw.width / 2.0F, this.oMw.height / 2.0F });
    paramMotionEvent.e(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
    paramMotionEvent.a(this.oMw.dY, (d.g.a.b)new a(this));
    return bool2;
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.oMw.width = paramBitmap.getWidth();
      this.oMw.height = paramBitmap.getHeight();
      this.oMw.dY.preTranslate(-paramBitmap.getWidth() / 2.0F, -paramBitmap.getHeight() / 2.0F);
      this.vsA.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.oMw.l(new float[] { 0.0F, 0.0F, paramBitmap.getWidth(), 0.0F, 0.0F, paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight() });
    }
  }
  
  public final void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setLocation(i parami)
  {
    this.vsG = parami;
  }
  
  public final void setMarginBottom(int paramInt)
  {
    this.gpo = paramInt;
  }
  
  public final void setSourceDataType(e parame)
  {
    k.h(parame, "<set-?>");
    this.vsH = parame;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    k.h(paramb, "stateResolve");
    this.vsB = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.text = paramCharSequence;
  }
  
  public final void setTextBg(int paramInt)
  {
    this.vsF = paramInt;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
  
  public final void setTouchDownX(float paramFloat)
  {
    this.fPj = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.fPk = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.fPg = paramBoolean;
  }
  
  public void setValidArea(Rect paramRect)
  {
    k.h(paramRect, "validRect");
    this.vsD.set(paramRect);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    this.vsI = paramMatrix;
    if (paramMatrix != null)
    {
      this.oMw.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.vsI != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.vsA.draw(localCanvas);
      }
      if (this.bitmap != null) {
        localCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a
 * JD-Core Version:    0.7.0.1
 */