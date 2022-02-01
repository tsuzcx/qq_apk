package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ar;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "displayRect", "Landroid/graphics/Rect;", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isReshow", "", "originPivot", "", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "reshowEmoji", "item", "setDefaultLocation", "heightPercent", "setEmojiItem", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class f
  extends EmojiStatusView
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final String TAG;
  private final float[] pTB;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pTr;
  private final Rect xJu;
  private final Rect xJv;
  private EditorItemContainer.b xJw;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a xND;
  private Matrix xNJ;
  private e xOA;
  private boolean xOB;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200675);
    this.TAG = "MicroMsg.EmojiItemView";
    this.pTr = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.xJu = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    this.xJv = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    this.pTB = new float[2];
    this.pTr.aXF = 0.5F;
    this.pTr.aXE = 3.0F;
    paramContext = getResources();
    p.g(paramContext, "resources");
    this.xND = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    AppMethodBeat.o(200675);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76134);
    p.h(paramRect, "displayRect");
    this.xJv.set(paramRect);
    this.pTr.gR.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(76134);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(200670);
    p.h(parame, "item");
    this.xOB = true;
    setViewMatrix(parame.xOy);
    setEmojiInfo(parame.gjb);
    AppMethodBeat.o(200670);
  }
  
  public final void aa(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200668);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      this.pTr.gR.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(200668);
  }
  
  public final boolean avO(String paramString)
  {
    AppMethodBeat.i(200677);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(200677);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(200673);
    p.h(paramRect, "safeRect");
    this.pTr.xul = paramRect;
    this.pTr.xQl = com.tencent.mm.cc.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(200673);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(200671);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(200671);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(200671);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.postConcat(this.pTr.gR);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(200671);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(200671);
        throw paramMatrix;
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      ad.i(this.TAG, "createEditorItem displayRect:" + this.xJv + " validRect:" + this.xJu);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.pTr.gR);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      if (paramMatrix == null) {
        p.gfZ();
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(200671);
      return paramMatrix;
      if ((getDrawable() instanceof h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(200671);
          throw paramMatrix;
        }
        f = ((h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final a ckw()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(200672);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(200672);
      return null;
    }
    Object localObject3;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postConcat(this.pTr.gR);
      localObject3 = new e(getEmojiInfo(), (Matrix)localObject1, (Matrix)localObject1);
      localObject1 = this.xOA;
      if (localObject1 != null)
      {
        localObject1 = ((a)localObject1).xNA;
        if (localObject1 != null) {
          ((a)localObject3).xNA.af(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getEnd());
        }
      }
      e locale = this.xOA;
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.objectId;
      }
      ((a)localObject3).objectId = ((String)localObject1);
      localObject1 = (a)localObject3;
      AppMethodBeat.o(200672);
      return localObject1;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject2 = getDrawable();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(200672);
        throw ((Throwable)localObject1);
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject2).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject2 = new Matrix();
      localObject3 = new Matrix();
      ad.i(this.TAG, "createEditorData displayRect:" + this.xJv + " validRect:" + this.xJu);
      ((Matrix)localObject3).set(this.pTr.gR);
      ((Matrix)localObject3).postTranslate(-(this.xJv.width() - this.xJu.width()) / 2.0F, -this.xJu.top);
      ((Matrix)localObject2).setScale(f, f);
      ((Matrix)localObject2).postConcat(this.pTr.gR);
      localObject2 = new e(getEmojiInfo(), (Matrix)localObject3, (Matrix)localObject2);
      localObject3 = this.xOA;
      if (localObject3 != null)
      {
        localObject3 = ((a)localObject3).xNA;
        if (localObject3 != null) {
          ((a)localObject2).xNA.af(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
        }
      }
      localObject3 = this.xOA;
      if (localObject3 != null) {
        localObject1 = ((a)localObject3).objectId;
      }
      ((a)localObject2).objectId = ((String)localObject1);
      localObject1 = (a)localObject2;
      AppMethodBeat.o(200672);
      return localObject1;
      if ((getDrawable() instanceof h))
      {
        localObject2 = getDrawable();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(200672);
          throw ((Throwable)localObject1);
        }
        f = ((h)localObject2).getEmojiDensityScale();
      }
    }
  }
  
  public final boolean dHt()
  {
    return true;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76133);
    float[] arrayOfFloat = (float[])this.pTr.xQq.clone();
    AppMethodBeat.o(76133);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(200674);
    RectF localRectF = new RectF(this.pTr.xQq[0], this.pTr.xQq[1], this.pTr.xQq[2], this.pTr.xQq[3]);
    AppMethodBeat.o(200674);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.xOA;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76132);
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
    AppMethodBeat.o(76132);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pTr;
  }
  
  public final b getType()
  {
    return b.xQM;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.xNJ;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76127);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setMatrix(this.pTr.gR);
    if (isActivated()) {
      this.xND.draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.clipRect(this.xJu);
    paramCanvas.save();
    paramCanvas.setMatrix(this.pTr.gR);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(76127);
  }
  
  public final boolean onTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76128);
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
      if (paramMotionEvent.getActionMasked() == 0)
      {
        this.pTB[0] = (this.pTr.width / 2.0F);
        this.pTB[1] = (this.pTr.height / 2.0F);
        this.pTr.gR.mapPoints(this.pTB);
      }
      for (;;)
      {
        AppMethodBeat.o(76128);
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
  
  public final void setEmojiItem(e parame)
  {
    AppMethodBeat.i(200669);
    p.h(parame, "item");
    this.xOA = parame;
    setEmojiInfo(parame.gjb);
    AppMethodBeat.o(200669);
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(76129);
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (!this.xOB)
      {
        this.pTr.gR.postTranslate(this.pTr.width / 2.0F, this.pTr.height / 2.0F);
        this.pTr.width = i;
        this.pTr.height = j;
        this.pTr.gR.postTranslate(-i / 2.0F, -((this.xJv.top + this.xJv.bottom) / 2 - (this.xJu.top + this.xJu.bottom) / 2.0F + j / 2.0F));
      }
      this.xND.setBounds(0, 0, i, j);
      this.pTr.o(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
    }
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(76129);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76126);
    p.h(paramb, "stateResolve");
    this.xJw = paramb;
    AppMethodBeat.o(76126);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76125);
    p.h(paramRect, "validRect");
    this.xJu.set(paramRect);
    AppMethodBeat.o(76125);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76124);
    if (p.i(this.xNJ, paramMatrix))
    {
      AppMethodBeat.o(76124);
      return;
    }
    if (paramMatrix != null) {
      this.pTr.setMatrix(paramMatrix);
    }
    AppMethodBeat.o(76124);
  }
  
  public final boolean yJ(long paramLong)
  {
    AppMethodBeat.i(200676);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(200676);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class a
    extends q
    implements m<Matrix, Boolean, z>
  {
    a(f paramf, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.f
 * JD-Core Version:    0.7.0.1
 */