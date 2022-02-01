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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ar;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BitmapItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "color", "", "getColor", "()I", "setColor", "(I)V", "displayRect", "Landroid/graphics/Rect;", "getDisplayRect", "()Landroid/graphics/Rect;", "enableNotify", "", "getEnableNotify", "()Z", "setEnableNotify", "(Z)V", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "location", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "getLocation", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;", "setLocation", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LocationItem;)V", "marginBottom", "getMarginBottom", "setMarginBottom", "navigateBarHeight", "getNavigateBarHeight", "originPivot", "", "paint", "Landroid/graphics/Paint;", "sourceDataType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "getSourceDataType", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "setSourceDataType", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textBg", "getTextBg", "setTextBg", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "touchDownX", "getTouchDownX", "setTouchDownX", "touchDownY", "getTouchDownY", "setTouchDownY", "touchMoved", "getTouchMoved", "setTouchMoved", "touchSlop", "getTouchSlop", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "getValidRect", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getSafeArea", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public abstract class b
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private Bitmap bitmap;
  private int color;
  private boolean gmF;
  private float gmI;
  private float gmJ;
  private final float[] pTB = new float[2];
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pTr = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
  private final Paint paint = new Paint();
  private final int rW;
  private CharSequence text;
  private float textSize = getResources().getDimension(2131166195);
  private final Rect xJu = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
  private final Rect xJv = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
  private EditorItemContainer.b xJw;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a xND;
  private final int xNE = ar.ej(aj.getContext());
  private int xNF;
  private int xNG;
  private k xNH;
  private d xNI = d.xNP;
  private Matrix xNJ;
  private boolean xNK;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.pTr.aXF = 0.5F;
    this.pTr.aXE = 3.0F;
    Resources localResources = getResources();
    p.g(localResources, "resources");
    this.xND = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(localResources);
    paramContext = ViewConfiguration.get(paramContext);
    p.g(paramContext, "ViewConfiguration.get(context)");
    this.rW = paramContext.getScaledTouchSlop();
    this.paint.setAntiAlias(true);
    this.xNK = true;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    p.h(paramRect, "displayRect");
    this.xJv.set(paramRect);
    this.pTr.gR.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
  }
  
  public final boolean avO(String paramString)
  {
    p.h(paramString, "objID");
    return c.a.a(this, paramString);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    p.h(paramRect, "safeRect");
    this.pTr.xul = paramRect;
    this.pTr.xQl = com.tencent.mm.cc.a.fromDPToPix(getContext(), paramInt);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.pTr.gR);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c(this.bitmap, localMatrix);
  }
  
  public a ckw()
  {
    if (this.bitmap == null) {
      return null;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.pTr.gR);
    if ((this.xNI == d.xNP) || (this.xNI == d.xNS)) {
      return (a)new q(this.text, this.color, this.xNF, this.xNG, localMatrix);
    }
    Object localObject1 = this.xNH;
    if (localObject1 == null) {
      p.gfZ();
    }
    localObject1 = ((k)localObject1).xOD;
    Object localObject2 = this.xNH;
    if (localObject2 == null) {
      p.gfZ();
    }
    localObject2 = ((k)localObject2).jDf;
    k localk = this.xNH;
    if (localk == null) {
      p.gfZ();
    }
    float f = localk.dAp;
    localk = this.xNH;
    if (localk == null) {
      p.gfZ();
    }
    return (a)new k((String)localObject1, (String)localObject2, f, localk.dyz, localMatrix);
  }
  
  public final boolean dHt()
  {
    return this.xNK;
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
    return (float[])this.pTr.xQq.clone();
  }
  
  protected final Rect getDisplayRect()
  {
    return this.xJv;
  }
  
  public RectF getDrawRect()
  {
    return new RectF(this.pTr.xQq[0], this.pTr.xQq[1], this.pTr.xQq[2], this.pTr.xQq[3]);
  }
  
  public final boolean getEnableNotify()
  {
    return this.xNK;
  }
  
  public final k getLocation()
  {
    return this.xNH;
  }
  
  public final int getMarginBottom()
  {
    return this.xNG;
  }
  
  protected final int getNavigateBarHeight()
  {
    return this.xNE;
  }
  
  public Rect getSafeArea()
  {
    Rect localRect = this.pTr.xul;
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
    return this.xNI;
  }
  
  public final CharSequence getText()
  {
    return this.text;
  }
  
  public final int getTextBg()
  {
    return this.xNF;
  }
  
  public final float getTextSize()
  {
    return this.textSize;
  }
  
  public final float getTouchDownX()
  {
    return this.gmI;
  }
  
  public final float getTouchDownY()
  {
    return this.gmJ;
  }
  
  public final boolean getTouchMoved()
  {
    return this.gmF;
  }
  
  public final int getTouchSlop()
  {
    return this.rW;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pTr;
  }
  
  protected final Rect getValidRect()
  {
    return this.xJu;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.xNJ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    p.h(paramCanvas, "canvas");
    Matrix localMatrix2 = this.xNJ;
    Matrix localMatrix1 = localMatrix2;
    if (localMatrix2 == null) {
      localMatrix1 = this.pTr.gR;
    }
    paramCanvas.save();
    paramCanvas.setMatrix(localMatrix1);
    if (isActivated()) {
      this.xND.draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.clipRect(this.xJu);
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
      bool2 = this.pTr.W(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
        localObject1 = this.xJw;
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
          this.gmI = paramMotionEvent.getX();
          this.gmJ = paramMotionEvent.getY();
          this.gmF = false;
          this.pTB[0] = (this.pTr.width / 2.0F);
          this.pTB[1] = (this.pTr.height / 2.0F);
          this.pTr.gR.mapPoints(this.pTB);
          return bool1;
          f = Math.max(Math.abs(paramMotionEvent.getX() - this.gmI), Math.abs(paramMotionEvent.getY() - this.gmJ));
        } while (this.gmF);
        if (f > this.rW) {}
        for (bool2 = true;; bool2 = false)
        {
          this.gmF = bool2;
          return bool1;
        }
      }
      localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
      Object localObject2 = this.xJu;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXF = this.pTr.aXF;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXE = this.pTr.aXE;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).n(new float[] { this.pTr.width / 2.0F, this.pTr.height / 2.0F });
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
      localObject2 = new float[2];
      localObject2[0] = (this.pTr.width / 2.0F);
      localObject2[1] = (this.pTr.height / 2.0F);
      this.pTr.gR.mapPoints((float[])localObject2);
      if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).xPV.contains(localObject2[0], localObject2[1])) {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.pTB[0], this.pTB[1], this.pTB[0], this.pTB[1]));
      }
      ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.pTr.gR, (m)new a(this, paramMotionEvent));
      return bool1;
    }
  }
  
  public final void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    if (paramBitmap != null)
    {
      this.pTr.width = paramBitmap.getWidth();
      this.pTr.height = paramBitmap.getHeight();
      this.pTr.gR.preTranslate(-paramBitmap.getWidth() / 2.0F, -paramBitmap.getHeight() / 2.0F);
      this.xND.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      this.pTr.o(new float[] { 0.0F, 0.0F, paramBitmap.getWidth(), 0.0F, 0.0F, paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight() });
    }
  }
  
  public final void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public final void setEnableNotify(boolean paramBoolean)
  {
    this.xNK = paramBoolean;
  }
  
  public final void setLocation(k paramk)
  {
    this.xNH = paramk;
  }
  
  public final void setMarginBottom(int paramInt)
  {
    this.xNG = paramInt;
  }
  
  public final void setSourceDataType(d paramd)
  {
    p.h(paramd, "<set-?>");
    this.xNI = paramd;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    p.h(paramb, "stateResolve");
    this.xJw = paramb;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.text = paramCharSequence;
  }
  
  public final void setTextBg(int paramInt)
  {
    this.xNF = paramInt;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
  
  public final void setTouchDownX(float paramFloat)
  {
    this.gmI = paramFloat;
  }
  
  public final void setTouchDownY(float paramFloat)
  {
    this.gmJ = paramFloat;
  }
  
  public final void setTouchMoved(boolean paramBoolean)
  {
    this.gmF = paramBoolean;
  }
  
  public void setValidArea(Rect paramRect)
  {
    p.h(paramRect, "validRect");
    this.xJu.set(paramRect);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    this.xNJ = paramMatrix;
    if (paramMatrix != null)
    {
      this.pTr.setMatrix(paramMatrix);
      Canvas localCanvas = new Canvas();
      localCanvas.save();
      if (this.xNJ != null) {
        localCanvas.setMatrix(paramMatrix);
      }
      if (isActivated()) {
        this.xND.draw(localCanvas);
      }
      if (this.bitmap != null) {
        localCanvas.drawBitmap(this.bitmap, 0.0F, 0.0F, null);
      }
    }
  }
  
  public final boolean yJ(long paramLong)
  {
    return c.a.a(this, paramLong);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
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