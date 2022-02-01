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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.ar;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentRect", "Landroid/graphics/Rect;", "displayRect", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isValid", "", "originPivot", "", "pagItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "paint", "Landroid/graphics/Paint;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onDelete", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onUpdate", "setDefaultLocation", "heightPercent", "", "setEditItem", "setSafeArea", "safeRect", "damp", "", "setSize", "width", "height", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class n
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private boolean cKB;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pZW;
  private final Paint paint;
  private final float[] qag;
  private final Rect qfO;
  private final Rect xZp;
  private final Rect xZq;
  private EditorItemContainer.b xZr;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a ydw;
  private o yeW;
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206973);
    this.pZW = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.xZp = new Rect(0, 0, ar.ck(ak.getContext()).x, ar.ck(ak.getContext()).y);
    this.xZq = new Rect(0, 0, ar.ck(ak.getContext()).x, ar.ck(ak.getContext()).y);
    this.qfO = new Rect();
    this.paint = new Paint();
    this.cKB = true;
    this.qag = new float[2];
    this.pZW.aXF = 0.5F;
    this.pZW.aXE = 3.0F;
    paramContext = getResources();
    p.g(paramContext, "resources");
    this.ydw = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    this.paint.setColor(822083583);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(206973);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(206970);
    p.h(paramRect, "displayRect");
    this.xZq.set(paramRect);
    this.pZW.gR.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    paramRect = this.yeW;
    if (paramRect != null)
    {
      paramRect.g(this.pZW.gR);
      AppMethodBeat.o(206970);
      return;
    }
    AppMethodBeat.o(206970);
  }
  
  public final boolean axd(String paramString)
  {
    AppMethodBeat.i(206975);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(206975);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(206967);
    p.h(paramRect, "safeRect");
    AppMethodBeat.o(206967);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(206965);
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.pZW.gR);
    localMatrix.postTranslate(-(this.xZq.width() - this.xZp.width()) / 2.0F, -(this.xZq.height() - this.xZp.height()) / 2.0F);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new h(localMatrix);
    AppMethodBeat.o(206965);
    return paramMatrix;
  }
  
  public final a clM()
  {
    AppMethodBeat.i(206966);
    Object localObject = this.yeW;
    if (localObject != null) {
      ((a)localObject).gR.set(this.pZW.gR);
    }
    localObject = (a)this.yeW;
    AppMethodBeat.o(206966);
    return localObject;
  }
  
  public final boolean dKK()
  {
    return true;
  }
  
  public final void dLs()
  {
    AppMethodBeat.i(206962);
    Object localObject = this.yeW;
    if (localObject != null)
    {
      localObject = ((o)localObject).yfd;
      if (localObject != null) {
        ((j)localObject).dLs();
      }
    }
    this.cKB = false;
    AppMethodBeat.o(206962);
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(206971);
    float[] arrayOfFloat = (float[])this.pZW.ygj.clone();
    AppMethodBeat.o(206971);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(206972);
    RectF localRectF = new RectF(this.pZW.ygj[0], this.pZW.ygj[1], this.pZW.ygj[2], this.pZW.ygj[3]);
    AppMethodBeat.o(206972);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.yeW;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(206968);
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
    AppMethodBeat.o(206968);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pZW;
  }
  
  public final b getType()
  {
    return b.ygI;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206963);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.setMatrix(this.pZW.gR);
    if (isActivated()) {
      this.ydw.draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(206963);
  }
  
  public final boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206964);
    p.h(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.pZW.U(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        localObject1 = this.yeW;
        if (localObject1 != null) {
          ((o)localObject1).g(this.pZW.gR);
        }
        bringToFront();
        localObject1 = this.yeW;
        if (localObject1 != null)
        {
          localObject1 = ((o)localObject1).yfd;
          if (localObject1 != null) {
            ((j)localObject1).dLr();
          }
        }
        localObject1 = this.xZr;
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
        this.qag[0] = (this.pZW.width / 2.0F);
        this.qag[1] = (this.pZW.height / 2.0F);
        this.pZW.gR.mapPoints(this.qag);
      }
      for (;;)
      {
        AppMethodBeat.o(206964);
        return bool1;
        if (paramMotionEvent.getActionMasked() == 1)
        {
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
        }
      }
    }
  }
  
  public final void setEditItem(o paramo)
  {
    AppMethodBeat.i(206961);
    p.h(paramo, "pagItem");
    this.yeW = paramo;
    this.pZW.gR.postScale(paramo.scale, paramo.scale);
    int i = paramo.width;
    int j = paramo.height;
    this.ydw.setBounds(0, 0, i, j);
    this.qfO.set(0, 0, i, j);
    this.pZW.gR.postTranslate(this.pZW.width / 2.0F, this.pZW.height / 2.0F);
    this.pZW.width = i;
    this.pZW.height = j;
    paramo = this.yeW;
    if (paramo != null) {}
    for (float f1 = paramo.scale;; f1 = 1.0F)
    {
      paramo = this.pZW.gR;
      float f2 = -i * f1 / 2.0F;
      float f3 = (this.xZq.top + this.xZq.bottom) / 2;
      float f4 = (this.xZp.top + this.xZp.bottom) / 2.0F;
      paramo.postTranslate(f2, -(f1 * j / 2.0F + (f3 - f4)));
      this.pZW.o(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
      paramo = this.yeW;
      if (paramo == null) {
        break;
      }
      paramo.g(this.pZW.gR);
      AppMethodBeat.o(206961);
      return;
    }
    AppMethodBeat.o(206961);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(206960);
    p.h(paramb, "stateResolve");
    this.xZr = paramb;
    AppMethodBeat.o(206960);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(206969);
    p.h(paramRect, "validRect");
    this.xZp.set(paramRect);
    AppMethodBeat.o(206969);
  }
  
  public final boolean zi(long paramLong)
  {
    AppMethodBeat.i(206974);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(206974);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
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