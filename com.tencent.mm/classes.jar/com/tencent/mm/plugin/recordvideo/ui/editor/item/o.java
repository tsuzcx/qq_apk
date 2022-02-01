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
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.i;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentRect", "Landroid/graphics/Rect;", "displayRect", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isValid", "", "originPivot", "", "pagItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "paint", "Landroid/graphics/Paint;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onDelete", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onUpdate", "setDefaultLocation", "heightPercent", "", "setEditItem", "setSafeArea", "safeRect", "damp", "", "setSize", "width", "height", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class o
  extends View
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final Rect HXd;
  private final Rect HXe;
  private EditorItemContainer.b HXf;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Ibu;
  private p IcO;
  private boolean cSY;
  private final Paint paint;
  private final float[] uWJ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c uWz;
  private final Rect vcr;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(224572);
    this.uWz = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.HXd = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.HXe = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.vcr = new Rect();
    this.paint = new Paint();
    this.cSY = true;
    this.uWJ = new float[2];
    this.uWz.aGO = 0.5F;
    this.uWz.aGN = 3.0F;
    paramContext = getResources();
    kotlin.g.b.p.j(paramContext, "resources");
    this.Ibu = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    this.paint.setColor(822083583);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(224572);
  }
  
  public final boolean PA(long paramLong)
  {
    AppMethodBeat.i(224575);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(224575);
    return bool;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(224551);
    kotlin.g.b.p.k(paramRect, "displayRect");
    this.HXe.set(paramRect);
    this.uWz.aHZ.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    paramRect = this.IcO;
    if (paramRect != null)
    {
      paramRect.g(this.uWz.aHZ);
      AppMethodBeat.o(224551);
      return;
    }
    AppMethodBeat.o(224551);
  }
  
  public final boolean aWf(String paramString)
  {
    AppMethodBeat.i(224578);
    kotlin.g.b.p.k(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(224578);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(224542);
    kotlin.g.b.p.k(paramRect, "safeRect");
    AppMethodBeat.o(224542);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(224535);
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.uWz.aHZ);
    localMatrix.postTranslate(-(this.HXe.width() - this.HXd.width()) / 2.0F, -(this.HXe.height() - this.HXd.height()) / 2.0F);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new i(localMatrix);
    AppMethodBeat.o(224535);
    return paramMatrix;
  }
  
  public final a cYy()
  {
    AppMethodBeat.i(224540);
    Object localObject = this.IcO;
    if (localObject != null) {
      ((a)localObject).aHZ.set(this.uWz.aHZ);
    }
    localObject = (a)this.IcO;
    AppMethodBeat.o(224540);
    return localObject;
  }
  
  public final void fyQ()
  {
    AppMethodBeat.i(224513);
    Object localObject = this.IcO;
    if (localObject != null)
    {
      localObject = ((p)localObject).IcT;
      if (localObject != null) {
        ((k)localObject).fyQ();
      }
    }
    this.cSY = false;
    AppMethodBeat.o(224513);
  }
  
  public final boolean fyf()
  {
    return true;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(224553);
    float[] arrayOfFloat = (float[])this.uWz.IdW.clone();
    AppMethodBeat.o(224553);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(224560);
    RectF localRectF = new RectF(this.uWz.IdW[0], this.uWz.IdW[1], this.uWz.IdW[2], this.uWz.IdW[3]);
    AppMethodBeat.o(224560);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.IcO;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(224544);
    Rect localRect = this.uWz.HGw;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      kotlin.g.b.p.j(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      kotlin.g.b.p.j(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(224544);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.uWz;
  }
  
  public final b getType()
  {
    return b.Iev;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(224516);
    kotlin.g.b.p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.setMatrix(this.uWz.aHZ);
    if (isActivated()) {
      this.Ibu.draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(224516);
  }
  
  public final boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(224531);
    kotlin.g.b.p.k(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.uWz.ah(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        localObject1 = this.IcO;
        if (localObject1 != null) {
          ((p)localObject1).g(this.uWz.aHZ);
        }
        bringToFront();
        localObject1 = this.IcO;
        if (localObject1 != null)
        {
          localObject1 = ((p)localObject1).IcT;
          if (localObject1 != null) {
            ((k)localObject1).fyP();
          }
        }
        localObject1 = this.HXf;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).e((View)this, paramMotionEvent);
        }
        postInvalidate();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (paramMotionEvent.getActionMasked() == 0)
      {
        this.uWJ[0] = (this.uWz.width / 2.0F);
        this.uWJ[1] = (this.uWz.height / 2.0F);
        this.uWz.aHZ.mapPoints(this.uWJ);
      }
      for (;;)
      {
        AppMethodBeat.o(224531);
        return bool1;
        if (paramMotionEvent.getActionMasked() == 1)
        {
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
          Object localObject2 = this.HXd;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aGO = this.uWz.aGO;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aGN = this.uWz.aGN;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).o(new float[] { this.uWz.width / 2.0F, this.uWz.height / 2.0F });
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
          localObject2 = new float[2];
          localObject2[0] = (this.uWz.width / 2.0F);
          localObject2[1] = (this.uWz.height / 2.0F);
          this.uWz.aHZ.mapPoints((float[])localObject2);
          if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).IdC.contains(localObject2[0], localObject2[1])) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.uWJ[0], this.uWJ[1], this.uWJ[0], this.uWJ[1]));
          }
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.uWz.aHZ, (m)new a(this, paramMotionEvent));
        }
      }
    }
  }
  
  public final void setEditItem(p paramp)
  {
    AppMethodBeat.i(224511);
    kotlin.g.b.p.k(paramp, "pagItem");
    this.IcO = paramp;
    this.uWz.aHZ.postScale(paramp.scale, paramp.scale);
    int i = paramp.width;
    int j = paramp.height;
    this.Ibu.setBounds(0, 0, i, j);
    this.vcr.set(0, 0, i, j);
    this.uWz.aHZ.postTranslate(this.uWz.width / 2.0F, this.uWz.height / 2.0F);
    this.uWz.width = i;
    this.uWz.height = j;
    paramp = this.IcO;
    if (paramp != null) {}
    for (float f1 = paramp.scale;; f1 = 1.0F)
    {
      paramp = this.uWz.aHZ;
      float f2 = -i * f1 / 2.0F;
      float f3 = (this.HXe.top + this.HXe.bottom) / 2;
      float f4 = (this.HXd.top + this.HXd.bottom) / 2.0F;
      paramp.postTranslate(f2, -(f1 * j / 2.0F + (f3 - f4)));
      this.uWz.p(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
      paramp = this.IcO;
      if (paramp == null) {
        break;
      }
      paramp.g(this.uWz.aHZ);
      AppMethodBeat.o(224511);
      return;
    }
    AppMethodBeat.o(224511);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(224494);
    kotlin.g.b.p.k(paramb, "stateResolve");
    this.HXf = paramb;
    AppMethodBeat.o(224494);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(224547);
    kotlin.g.b.p.k(paramRect, "validRect");
    this.HXd.set(paramRect);
    AppMethodBeat.o(224547);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class a
    extends q
    implements m<Matrix, Boolean, x>
  {
    a(o paramo, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.o
 * JD-Core Version:    0.7.0.1
 */