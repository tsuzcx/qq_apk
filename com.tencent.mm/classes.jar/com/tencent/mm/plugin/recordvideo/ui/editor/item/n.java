package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ar;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentRect", "Landroid/graphics/Rect;", "displayRect", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isValid", "", "originPivot", "", "pagItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "paint", "Landroid/graphics/Paint;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onDelete", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onUpdate", "setDefaultLocation", "heightPercent", "", "setEditItem", "setSafeArea", "safeRect", "damp", "", "setSize", "width", "height", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class n
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private boolean cJS;
  private final float[] pTB;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pTr;
  private final Rect pZj;
  private final Paint paint;
  private final Rect xJu;
  private final Rect xJv;
  private EditorItemContainer.b xJw;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a xND;
  private o xPd;
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200715);
    this.pTr = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.xJu = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    this.xJv = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    this.pZj = new Rect();
    this.paint = new Paint();
    this.cJS = true;
    this.pTB = new float[2];
    this.pTr.aXF = 0.5F;
    this.pTr.aXE = 3.0F;
    paramContext = getResources();
    p.g(paramContext, "resources");
    this.xND = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    this.paint.setColor(822083583);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(200715);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(200712);
    p.h(paramRect, "displayRect");
    this.xJv.set(paramRect);
    this.pTr.gR.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    paramRect = this.xPd;
    if (paramRect != null)
    {
      paramRect.g(this.pTr.gR);
      AppMethodBeat.o(200712);
      return;
    }
    AppMethodBeat.o(200712);
  }
  
  public final boolean avO(String paramString)
  {
    AppMethodBeat.i(200717);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(200717);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(200709);
    p.h(paramRect, "safeRect");
    AppMethodBeat.o(200709);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(200707);
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.pTr.gR);
    localMatrix.postTranslate(-(this.xJv.width() - this.xJu.width()) / 2.0F, -(this.xJv.height() - this.xJu.height()) / 2.0F);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new h(localMatrix);
    AppMethodBeat.o(200707);
    return paramMatrix;
  }
  
  public final a ckw()
  {
    AppMethodBeat.i(200708);
    Object localObject = this.xPd;
    if (localObject != null) {
      ((a)localObject).gR.set(this.pTr.gR);
    }
    localObject = (a)this.xPd;
    AppMethodBeat.o(200708);
    return localObject;
  }
  
  public final boolean dHt()
  {
    return true;
  }
  
  public final void dIb()
  {
    AppMethodBeat.i(200704);
    Object localObject = this.xPd;
    if (localObject != null)
    {
      localObject = ((o)localObject).xPk;
      if (localObject != null) {
        ((j)localObject).dIb();
      }
    }
    this.cJS = false;
    AppMethodBeat.o(200704);
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(200713);
    float[] arrayOfFloat = (float[])this.pTr.xQq.clone();
    AppMethodBeat.o(200713);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(200714);
    RectF localRectF = new RectF(this.pTr.xQq[0], this.pTr.xQq[1], this.pTr.xQq[2], this.pTr.xQq[3]);
    AppMethodBeat.o(200714);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.xPd;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(200710);
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
    AppMethodBeat.o(200710);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pTr;
  }
  
  public final b getType()
  {
    return b.xQP;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200705);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.setMatrix(this.pTr.gR);
    if (isActivated()) {
      this.xND.draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(200705);
  }
  
  public final boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200706);
    p.h(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.pTr.W(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        localObject1 = this.xPd;
        if (localObject1 != null) {
          ((o)localObject1).g(this.pTr.gR);
        }
        bringToFront();
        localObject1 = this.xPd;
        if (localObject1 != null)
        {
          localObject1 = ((o)localObject1).xPk;
          if (localObject1 != null) {
            ((j)localObject1).dIa();
          }
        }
        localObject1 = this.xJw;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).c((View)this, paramMotionEvent);
        }
        postInvalidate();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (paramMotionEvent.getActionMasked() == 0)
      {
        this.pTB[0] = (this.pTr.width / 2.0F);
        this.pTB[1] = (this.pTr.height / 2.0F);
        this.pTr.gR.mapPoints(this.pTB);
      }
      for (;;)
      {
        AppMethodBeat.o(200706);
        return bool1;
        if (paramMotionEvent.getActionMasked() == 1)
        {
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
        }
      }
    }
  }
  
  public final void setEditItem(o paramo)
  {
    AppMethodBeat.i(200703);
    p.h(paramo, "pagItem");
    this.xPd = paramo;
    this.pTr.gR.postScale(paramo.scale, paramo.scale);
    int i = paramo.width;
    int j = paramo.height;
    this.xND.setBounds(0, 0, i, j);
    this.pZj.set(0, 0, i, j);
    this.pTr.gR.postTranslate(this.pTr.width / 2.0F, this.pTr.height / 2.0F);
    this.pTr.width = i;
    this.pTr.height = j;
    paramo = this.xPd;
    if (paramo != null) {}
    for (float f1 = paramo.scale;; f1 = 1.0F)
    {
      paramo = this.pTr.gR;
      float f2 = -i * f1 / 2.0F;
      float f3 = (this.xJv.top + this.xJv.bottom) / 2;
      float f4 = (this.xJu.top + this.xJu.bottom) / 2.0F;
      paramo.postTranslate(f2, -(f1 * j / 2.0F + (f3 - f4)));
      this.pTr.o(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
      paramo = this.xPd;
      if (paramo == null) {
        break;
      }
      paramo.g(this.pTr.gR);
      AppMethodBeat.o(200703);
      return;
    }
    AppMethodBeat.o(200703);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(200702);
    p.h(paramb, "stateResolve");
    this.xJw = paramb;
    AppMethodBeat.o(200702);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(200711);
    p.h(paramRect, "validRect");
    this.xJu.set(paramRect);
    AppMethodBeat.o(200711);
  }
  
  public final boolean yJ(long paramLong)
  {
    AppMethodBeat.i(200716);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(200716);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class a
    extends q
    implements m<Matrix, Boolean, z>
  {
    a(n paramn, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.n
 * JD-Core Version:    0.7.0.1
 */