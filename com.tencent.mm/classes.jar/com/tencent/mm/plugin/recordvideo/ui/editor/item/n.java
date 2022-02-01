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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentRect", "Landroid/graphics/Rect;", "displayRect", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isValid", "", "originPivot", "", "pagItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "paint", "Landroid/graphics/Paint;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onDelete", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onUpdate", "setDefaultLocation", "heightPercent", "", "setEditItem", "setSafeArea", "safeRect", "damp", "", "setSize", "width", "height", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class n
  extends View
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final Rect Cao;
  private final Rect Cap;
  private EditorItemContainer.b Caq;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Cey;
  private o CfY;
  private boolean daZ;
  private final Paint paint;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT;
  private final float[] rrd;
  private final Rect rwL;
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(237814);
    this.rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    this.Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    this.rwL = new Rect();
    this.paint = new Paint();
    this.daZ = true;
    this.rrd = new float[2];
    this.rqT.aXu = 0.5F;
    this.rqT.aXt = 3.0F;
    paramContext = getResources();
    p.g(paramContext, "resources");
    this.Cey = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    this.paint.setColor(822083583);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(237814);
  }
  
  public final boolean Ig(long paramLong)
  {
    AppMethodBeat.i(237815);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(237815);
    return bool;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(237811);
    p.h(paramRect, "displayRect");
    this.Cap.set(paramRect);
    this.rqT.gT.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    paramRect = this.CfY;
    if (paramRect != null)
    {
      paramRect.g(this.rqT.gT);
      AppMethodBeat.o(237811);
      return;
    }
    AppMethodBeat.o(237811);
  }
  
  public final boolean aLB(String paramString)
  {
    AppMethodBeat.i(237816);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(237816);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(237808);
    p.h(paramRect, "safeRect");
    AppMethodBeat.o(237808);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(237806);
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.rqT.gT);
    localMatrix.postTranslate(-(this.Cap.width() - this.Cao.width()) / 2.0F, -(this.Cap.height() - this.Cao.height()) / 2.0F);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new h(localMatrix);
    AppMethodBeat.o(237806);
    return paramMatrix;
  }
  
  public final a cJO()
  {
    AppMethodBeat.i(237807);
    Object localObject = this.CfY;
    if (localObject != null) {
      ((a)localObject).gT.set(this.rqT.gT);
    }
    localObject = (a)this.CfY;
    AppMethodBeat.o(237807);
    return localObject;
  }
  
  public final boolean eLK()
  {
    return true;
  }
  
  public final void eMs()
  {
    AppMethodBeat.i(237803);
    Object localObject = this.CfY;
    if (localObject != null)
    {
      localObject = ((o)localObject).Cgd;
      if (localObject != null) {
        ((j)localObject).eMs();
      }
    }
    this.daZ = false;
    AppMethodBeat.o(237803);
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(237812);
    float[] arrayOfFloat = (float[])this.rqT.Chg.clone();
    AppMethodBeat.o(237812);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(237813);
    RectF localRectF = new RectF(this.rqT.Chg[0], this.rqT.Chg[1], this.rqT.Chg[2], this.rqT.Chg[3]);
    AppMethodBeat.o(237813);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.CfY;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(237809);
    Rect localRect = this.rqT.BKm;
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
    AppMethodBeat.o(237809);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.rqT;
  }
  
  public final b getType()
  {
    return b.ChF;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237804);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.setMatrix(this.rqT.gT);
    if (isActivated()) {
      this.Cey.draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(237804);
  }
  
  public final boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237805);
    p.h(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.rqT.Y(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        localObject1 = this.CfY;
        if (localObject1 != null) {
          ((o)localObject1).g(this.rqT.gT);
        }
        bringToFront();
        localObject1 = this.CfY;
        if (localObject1 != null)
        {
          localObject1 = ((o)localObject1).Cgd;
          if (localObject1 != null) {
            ((j)localObject1).eMr();
          }
        }
        localObject1 = this.Caq;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).d((View)this, paramMotionEvent);
        }
        postInvalidate();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (paramMotionEvent.getActionMasked() == 0)
      {
        this.rrd[0] = (this.rqT.width / 2.0F);
        this.rrd[1] = (this.rqT.height / 2.0F);
        this.rqT.gT.mapPoints(this.rrd);
      }
      for (;;)
      {
        AppMethodBeat.o(237805);
        return bool1;
        if (paramMotionEvent.getActionMasked() == 1)
        {
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
          Object localObject2 = this.Cao;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXu = this.rqT.aXu;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXt = this.rqT.aXt;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).n(new float[] { this.rqT.width / 2.0F, this.rqT.height / 2.0F });
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
          localObject2 = new float[2];
          localObject2[0] = (this.rqT.width / 2.0F);
          localObject2[1] = (this.rqT.height / 2.0F);
          this.rqT.gT.mapPoints((float[])localObject2);
          if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).CgM.contains(localObject2[0], localObject2[1])) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
          }
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.rqT.gT, (m)new a(this, paramMotionEvent));
        }
      }
    }
  }
  
  public final void setEditItem(o paramo)
  {
    AppMethodBeat.i(237802);
    p.h(paramo, "pagItem");
    this.CfY = paramo;
    this.rqT.gT.postScale(paramo.scale, paramo.scale);
    int i = paramo.width;
    int j = paramo.height;
    this.Cey.setBounds(0, 0, i, j);
    this.rwL.set(0, 0, i, j);
    this.rqT.gT.postTranslate(this.rqT.width / 2.0F, this.rqT.height / 2.0F);
    this.rqT.width = i;
    this.rqT.height = j;
    paramo = this.CfY;
    if (paramo != null) {}
    for (float f1 = paramo.scale;; f1 = 1.0F)
    {
      paramo = this.rqT.gT;
      float f2 = -i * f1 / 2.0F;
      float f3 = (this.Cap.top + this.Cap.bottom) / 2;
      float f4 = (this.Cao.top + this.Cao.bottom) / 2.0F;
      paramo.postTranslate(f2, -(f1 * j / 2.0F + (f3 - f4)));
      this.rqT.o(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
      paramo = this.CfY;
      if (paramo == null) {
        break;
      }
      paramo.g(this.rqT.gT);
      AppMethodBeat.o(237802);
      return;
    }
    AppMethodBeat.o(237802);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(237801);
    p.h(paramb, "stateResolve");
    this.Caq = paramb;
    AppMethodBeat.o(237801);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(237810);
    p.h(paramRect, "validRect");
    this.Cao.set(paramRect);
    AppMethodBeat.o(237810);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class a
    extends q
    implements m<Matrix, Boolean, x>
  {
    a(n paramn, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.n
 * JD-Core Version:    0.7.0.1
 */