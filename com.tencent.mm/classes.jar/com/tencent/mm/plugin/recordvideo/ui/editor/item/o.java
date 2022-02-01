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
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.i;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagItemView;", "Landroid/view/View;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentRect", "Landroid/graphics/Rect;", "displayRect", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isValid", "", "originPivot", "", "pagItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/PagStickerItem;", "paint", "Landroid/graphics/Paint;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "onDelete", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "onUpdate", "setDefaultLocation", "heightPercent", "", "setEditItem", "setSafeArea", "safeRect", "damp", "", "setSize", "width", "height", "setStateResolve", "setValidArea", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends View
  implements h, d
{
  private final Rect NTO;
  private final Rect NTP;
  private EditorItemContainer.b NTQ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a NXT;
  private p NZk;
  private boolean clZ;
  private final Paint paint;
  private final c yiZ;
  private final float[] yji;
  private final Rect yok;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(280275);
    this.yiZ = new c();
    this.NTO = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.NTP = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.yok = new Rect();
    this.paint = new Paint();
    this.clZ = true;
    this.yji = new float[2];
    this.yiZ.minScale = 0.5F;
    this.yiZ.maxScale = 3.0F;
    paramContext = getResources();
    s.s(paramContext, "resources");
    this.NXT = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    this.paint.setColor(822083583);
    this.paint.setStyle(Paint.Style.FILL);
    AppMethodBeat.o(280275);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(280370);
    s.u(paramRect, "displayRect");
    this.NTP.set(paramRect);
    this.yiZ.matrix.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    paramRect = this.NZk;
    if (paramRect != null) {
      paramRect.i(this.yiZ.matrix);
    }
    AppMethodBeat.o(280370);
  }
  
  public final boolean aTn(String paramString)
  {
    AppMethodBeat.i(280407);
    boolean bool = d.a.a(this, paramString);
    AppMethodBeat.o(280407);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(280358);
    s.u(paramRect, "safeRect");
    AppMethodBeat.o(280358);
  }
  
  public final a dEP()
  {
    AppMethodBeat.i(280352);
    Object localObject = this.NZk;
    if (localObject != null) {
      ((a)localObject).matrix.set(getTouchTracker().matrix);
    }
    localObject = (a)this.NZk;
    AppMethodBeat.o(280352);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a e(Matrix paramMatrix)
  {
    AppMethodBeat.i(280349);
    Matrix localMatrix = new Matrix();
    localMatrix.postConcat(this.yiZ.matrix);
    localMatrix.postTranslate(-(this.NTP.width() - this.NTO.width()) / 2.0F, -(this.NTP.height() - this.NTO.height()) / 2.0F);
    if (paramMatrix != null) {
      localMatrix.postConcat(paramMatrix);
    }
    paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new i(localMatrix);
    AppMethodBeat.o(280349);
    return paramMatrix;
  }
  
  public final boolean gJS()
  {
    AppMethodBeat.i(280401);
    s.u(this, "this");
    AppMethodBeat.o(280401);
    return true;
  }
  
  public final void gKC()
  {
    AppMethodBeat.i(280316);
    Object localObject = this.NZk;
    if (localObject != null)
    {
      localObject = ((p)localObject).NZp;
      if (localObject != null) {
        ((k)localObject).gKC();
      }
    }
    this.clZ = false;
    AppMethodBeat.o(280316);
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(280379);
    float[] arrayOfFloat = (float[])this.yiZ.Oam.clone();
    AppMethodBeat.o(280379);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(280390);
    RectF localRectF = new RectF(this.yiZ.Oam[0], this.yiZ.Oam[1], this.yiZ.Oam[2], this.yiZ.Oam[3]);
    AppMethodBeat.o(280390);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.NZk;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(280362);
    Rect localRect = this.yiZ.NDV;
    if (localRect == null)
    {
      localRect = new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
      AppMethodBeat.o(280362);
      return localRect;
    }
    AppMethodBeat.o(280362);
    return localRect;
  }
  
  public final c getTouchTracker()
  {
    return this.yiZ;
  }
  
  public final b getType()
  {
    return b.OaL;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(280324);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.setMatrix(this.yiZ.matrix);
    if (isActivated()) {
      this.NXT.draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(280324);
  }
  
  public final boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280338);
    s.u(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.yiZ.ak(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        localObject1 = this.NZk;
        if (localObject1 != null) {
          ((p)localObject1).i(this.yiZ.matrix);
        }
        bringToFront();
        localObject1 = this.NZk;
        if (localObject1 != null)
        {
          localObject1 = ((p)localObject1).NZp;
          if (localObject1 != null) {
            ((k)localObject1).gKB();
          }
        }
        localObject1 = this.NTQ;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).l((View)this, paramMotionEvent);
        }
        postInvalidate();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (paramMotionEvent.getActionMasked() == 0)
      {
        this.yji[0] = (this.yiZ.width / 2.0F);
        this.yji[1] = (this.yiZ.height / 2.0F);
        this.yiZ.matrix.mapPoints(this.yji);
      }
      for (;;)
      {
        AppMethodBeat.o(280338);
        return bool1;
        if (paramMotionEvent.getActionMasked() == 1)
        {
          localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
          Object localObject2 = this.NTO;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).minScale = this.yiZ.minScale;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).maxScale = this.yiZ.maxScale;
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).w(new float[] { this.yiZ.width / 2.0F, this.yiZ.height / 2.0F });
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).g(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
          localObject2 = new float[2];
          localObject2[0] = (this.yiZ.width / 2.0F);
          localObject2[1] = (this.yiZ.height / 2.0F);
          this.yiZ.matrix.mapPoints((float[])localObject2);
          if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).NZY.contains(localObject2[0], localObject2[1])) {
            ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).g(new RectF(this.yji[0], this.yji[1], this.yji[0], this.yji[1]));
          }
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.yiZ.matrix, (m)new a(this, paramMotionEvent));
        }
      }
    }
  }
  
  public final void setEditItem(p paramp)
  {
    AppMethodBeat.i(280309);
    s.u(paramp, "pagItem");
    this.NZk = paramp;
    this.yiZ.matrix.postScale(paramp.scale, paramp.scale);
    int i = paramp.width;
    int j = paramp.height;
    this.NXT.setBounds(0, 0, i, j);
    this.yok.set(0, 0, i, j);
    this.yiZ.matrix.postTranslate(this.yiZ.width / 2.0F, this.yiZ.height / 2.0F);
    this.yiZ.width = i;
    this.yiZ.height = j;
    paramp = this.NZk;
    if (paramp == null) {}
    for (float f1 = 1.0F;; f1 = paramp.scale)
    {
      paramp = this.yiZ.matrix;
      float f2 = -i * f1 / 2.0F;
      float f3 = (this.NTP.top + this.NTP.bottom) / 2;
      float f4 = (this.NTO.top + this.NTO.bottom) / 2.0F;
      paramp.postTranslate(f2, -(f1 * j / 2.0F + (f3 - f4)));
      this.yiZ.x(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
      paramp = this.NZk;
      if (paramp != null) {
        paramp.i(this.yiZ.matrix);
      }
      AppMethodBeat.o(280309);
      return;
    }
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(280297);
    s.u(paramb, "stateResolve");
    this.NTQ = paramb;
    AppMethodBeat.o(280297);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(280365);
    s.u(paramRect, "validRect");
    this.NTO.set(paramRect);
    AppMethodBeat.o(280365);
  }
  
  public final boolean tA(long paramLong)
  {
    AppMethodBeat.i(280413);
    boolean bool = d.a.a(this, paramLong);
    AppMethodBeat.o(280413);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Matrix, Boolean, ah>
  {
    a(o paramo, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.o
 * JD-Core Version:    0.7.0.1
 */