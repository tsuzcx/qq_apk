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
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.ar;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "enableNotify", "", "getEnableNotify", "()Z", "setEnableNotify", "(Z)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "originPivot", "", "paint", "Landroid/graphics/Paint;", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public abstract class b
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private Bitmap bitmap;
  private int color;
  private boolean gpb;
  private float gpe;
  private float gpf;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pZW = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
  private final Paint paint = new Paint();
  private final float[] qag = new float[2];
  private final int rW;
  private CharSequence text;
  private float textSize = getResources().getDimension(2131166195);
  private final Rect xZp = new Rect(0, 0, ar.ck(ak.getContext()).x, ar.ck(ak.getContext()).y);
  private final Rect xZq = new Rect(0, 0, ar.ck(ak.getContext()).x, ar.ck(ak.getContext()).y);
  private EditorItemContainer.b xZr;
  private k ydA;
  private d ydB = d.ydI;
  private Matrix ydC;
  private boolean ydD;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a ydw;
  private final int ydx = ar.en(ak.getContext());
  private int ydy;
  private int ydz;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.pZW.aXF = 0.5F;
    this.pZW.aXE = 3.0F;
    Resources localResources = getResources();
    p.g(localResources, "resources");
    this.ydw = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(localResources);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rW = paramContext.getScaledTouchSlop();
    this.paint.setAntiAlias(true);
    this.ydD = true;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    p.h(paramRect, "displayRect");
    this.xZq.set(paramRect);
    this.pZW.gR.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
  }
  
  public final boolean axd(String paramString)
  {
    p.h(paramString, "objID");
    return c.a.a(this, paramString);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    p.h(paramRect, "safeRect");
    this.pZW.xKi = paramRect;
    this.pZW.yge = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.pZW.gR);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(this.bitmap, localMatrix);
  }
  
  public a clM()
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.pZW.gR);
    if ((this.ydB == d.ydI) || (this.ydB == d.ydL)) {
      return (a)new q(this.text, this.color, this.ydy, this.ydz, localMatrix);
    }
    Object localObject1 = this.ydA;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = ((k)localObject1).yew;
    Object localObject2 = this.ydA;
    if (localObject2 == null) {
      p.gkB();
    }
    localObject2 = ((k)localObject2).jGd;
    k localk = this.ydA;
    if (localk == null) {
      p.gkB();
    }
    float f = localk.dBu;
    localk = this.ydA;
    if (localk == null) {
      p.gkB();
    }
    return (a)new k((String)localObject1, (String)localObject2, f, localk.dzE, localMatrix);
  }
  
  public final boolean dKK()
  {
    return this.ydD;
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
    return (float[])this.pZW.ygj.clone();
  }
  
  protected final Rect getDisplayRect()
  {
    return this.xZq;
  }
  
  public RectF getDrawRect()
  {
    return new RectF(this.pZW.ygj[0], this.pZW.ygj[1], this.pZW.ygj[2], this.pZW.ygj[3]);
  }
  
  public final boolean getEnableNotify()
  {
    return this.ydD;
  }
  
  public final k getLocation()
  {
    return this.ydA;
  }
  
  public final int getMarginBottom()
  {
    return this.ydz;
  }
  
  protected final int getNavigateBarHeight()
  {
    return this.ydx;
  }
  
  public Rect getSafeArea()
  {
    Rect localRect = this.pZW.xKi;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      p.g(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      p.g(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    return localObject;
  }
  
  public final d getSourceDataType()
  {
    return this.ydB;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextBg()
  {
    return this.ydy;
  }
  
  public final float getTextSize()
  {
    return this.textSize;
  }
  
  public final float getTouchDownX()
  {
    return this.gpe;
  }
  
  public final float getTouchDownY()
  {
    return this.gpf;
  }
  
  public final boolean getTouchMoved()
  {
    return this.gpb;
  }
  
  public final int getTouchSlop()
  {
    return this.rW;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pZW;
  }
  
  protected final Rect getValidRect()
  {
    return this.xZp;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.ydC;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    p.h(paramCanvas, "canvas");
    Matrix localMatrix2 = this.ydC;
    Matrix localMatrix1 = localMatrix2;
    if (localMatrix2 == null) {
      localMatrix1 = this.pZW.gR;
    }
    paramCanvas.save();
    paramCanvas.setMatrix(localMatrix1);
    if (isActivated()) {
      this.ydw.draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.clipRect(this.xZp);
    paramCanvas.save();
    paramCanvas.setMatrix(localMatrix1);
    if (this.bitmap != null) {
      paramCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, this.paint);
    }
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    p.h(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.pZW.U(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
        localObject1 = this.xZr;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).c((View)this, paramMotionEvent);
        }
        postInvalidate();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (bool1) {}
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
      case 0: 
      case 2: 
        float f;
        do
        {
          return bool1;
          this.gpe = paramMotionEvent.getX();
          this.gpf = paramMotionEvent.getY();
          this.gpb = false;
          this.qag[0] = (this.pZW.width / 2.0F);
          this.qag[1] = (this.pZW.height / 2.0F);
          this.pZW.gR.mapPoints(this.qag);
          return bool1;
          f = Math.max(Math.abs(paramMotionEvent.getX() - this.gpe), Math.abs(paramMotionEvent.getY() - this.gpf));
        } while (this.gpb);
        if (f > this.rW) {}
        for (bool2 = true;; bool2 = false)
        {
          this.gpb = bool2;
          return bool1;
        }
      }
      localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      Object localObject2 = this.xZp;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXF = this.pZW.aXF;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXE = this.pZW.aXE;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).n(new float[] { this.pZW.width / 2.0F, this.pZW.height / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
      localObject2 = new float[2];
      localObject2[0] = (this.pZW.width / 2.0F);
      localObject2[1] = (this.pZW.height / 2.0F);
      this.pZW.gR.mapPoints((float[])localObject2);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).yfO.contains(localObject2[0], localObject2[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.qag[0], this.qag[1], this.qag[0], this.qag[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.pZW.gR, (m)new a(this, paramMotionEvent));
      return bool1;
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.pZW.width = paramBitmap.getWidth();
      this.pZW.height = paramBitmap.getHeight();
      this.pZW.gR.preTranslate(-paramBitmap.getWidth() / 2.0F, -paramBitmap.getHeight() / 2.0F);
      this.ydw.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.pZW.o(new float[] { 0.0F, 0.0F, paramBitmap.getWidth(), 0.0F, 0.0F, paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight() });
    }
  }
  
  public final void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setEnableNotify(boolean paramBoolean)
  {
    this.ydD = paramBoolean;
  }
  
  public final void setLocation(k paramk)
  {
    this.ydA = paramk;
  }
  
  public final void setMarginBottom(int paramInt)
  {
    this.ydz = paramInt;
  }
  
  public final void setSourceDataType(d paramd)
  {
    p.h(paramd, "<set-?>");
    this.ydB = paramd;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    p.h(paramb, "stateResolve");
    this.xZr = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.text = paramCharSequence;
  }
  
  public final void setTextBg(int paramInt)
  {
    this.ydy = paramInt;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
  
  public final void setTouchDownX(float paramFloat)
  {
    this.gpe = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.gpf = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.gpb = paramBoolean;
  }
  
  public void setValidArea(Rect paramRect)
  {
    p.h(paramRect, "validRect");
    this.xZp.set(paramRect);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    this.ydC = paramMatrix;
    if (paramMatrix != null)
    {
      this.pZW.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.ydC != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.ydw.draw(localCanvas);
      }
      if (this.bitmap != null) {
        localCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
      }
    }
  }
  
  public final boolean zi(long paramLong)
  {
    return c.a.a(this, paramLong);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements m<Matrix, Boolean, z>
  {
    a(b paramb, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.b
 * JD-Core Version:    0.7.0.1
 */