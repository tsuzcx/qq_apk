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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "displayRect", "Landroid/graphics/Rect;", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isReshow", "", "originPivot", "", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "reshowEmoji", "item", "setDefaultLocation", "heightPercent", "setEmojiItem", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class f
  extends EmojiStatusView
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final Rect Cao;
  private final Rect Cap;
  private EditorItemContainer.b Caq;
  private Matrix CeE;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Cey;
  private e Cfv;
  private boolean Cfw;
  private final String TAG;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT;
  private final float[] rrd;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(237774);
    this.TAG = "MicroMsg.EmojiItemView";
    this.rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    this.Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    this.rrd = new float[2];
    this.rqT.aXu = 0.5F;
    this.rqT.aXt = 3.0F;
    paramContext = getResources();
    p.g(paramContext, "resources");
    this.Cey = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    AppMethodBeat.o(237774);
  }
  
  public final boolean Ig(long paramLong)
  {
    AppMethodBeat.i(237775);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(237775);
    return bool;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76134);
    p.h(paramRect, "displayRect");
    this.Cap.set(paramRect);
    this.rqT.gT.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(76134);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(237769);
    p.h(parame, "item");
    this.Cfw = true;
    setViewMatrix(parame.Cft);
    setEmojiInfo(parame.gWm);
    AppMethodBeat.o(237769);
  }
  
  public final boolean aLB(String paramString)
  {
    AppMethodBeat.i(237776);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(237776);
    return bool;
  }
  
  public final void af(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237767);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      this.rqT.gT.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(237767);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(237772);
    p.h(paramRect, "safeRect");
    this.rqT.BKm = paramRect;
    this.rqT.Chb = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(237772);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(237770);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(237770);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(237770);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.postConcat(this.rqT.gT);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(237770);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(237770);
        throw paramMatrix;
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      Log.i(this.TAG, "createEditorItem displayRect:" + this.Cap + " validRect:" + this.Cao);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.rqT.gT);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      if (paramMatrix == null) {
        p.hyc();
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(237770);
      return paramMatrix;
      if ((getDrawable() instanceof h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(237770);
          throw paramMatrix;
        }
        f = ((h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final a cJO()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(237771);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(237771);
      return null;
    }
    Object localObject3;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postConcat(this.rqT.gT);
      localObject3 = new e(getEmojiInfo(), (Matrix)localObject1, (Matrix)localObject1);
      localObject1 = this.Cfv;
      if (localObject1 != null)
      {
        localObject1 = ((a)localObject1).Cev;
        if (localObject1 != null) {
          ((a)localObject3).Cev.ai(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getEnd());
        }
      }
      e locale = this.Cfv;
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.objectId;
      }
      ((a)localObject3).objectId = ((String)localObject1);
      localObject1 = (a)localObject3;
      AppMethodBeat.o(237771);
      return localObject1;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject2 = getDrawable();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(237771);
        throw ((Throwable)localObject1);
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject2).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject2 = new Matrix();
      localObject3 = new Matrix();
      Log.i(this.TAG, "createEditorData displayRect:" + this.Cap + " validRect:" + this.Cao);
      ((Matrix)localObject3).set(this.rqT.gT);
      ((Matrix)localObject3).postTranslate(-(this.Cap.width() - this.Cao.width()) / 2.0F, -this.Cao.top);
      ((Matrix)localObject2).setScale(f, f);
      ((Matrix)localObject2).postConcat(this.rqT.gT);
      localObject2 = new e(getEmojiInfo(), (Matrix)localObject3, (Matrix)localObject2);
      localObject3 = this.Cfv;
      if (localObject3 != null)
      {
        localObject3 = ((a)localObject3).Cev;
        if (localObject3 != null) {
          ((a)localObject2).Cev.ai(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
        }
      }
      localObject3 = this.Cfv;
      if (localObject3 != null) {
        localObject1 = ((a)localObject3).objectId;
      }
      ((a)localObject2).objectId = ((String)localObject1);
      localObject1 = (a)localObject2;
      AppMethodBeat.o(237771);
      return localObject1;
      if ((getDrawable() instanceof h))
      {
        localObject2 = getDrawable();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(237771);
          throw ((Throwable)localObject1);
        }
        f = ((h)localObject2).getEmojiDensityScale();
      }
    }
  }
  
  public final boolean eLK()
  {
    return true;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76133);
    float[] arrayOfFloat = (float[])this.rqT.Chg.clone();
    AppMethodBeat.o(76133);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(237773);
    RectF localRectF = new RectF(this.rqT.Chg[0], this.rqT.Chg[1], this.rqT.Chg[2], this.rqT.Chg[3]);
    AppMethodBeat.o(237773);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.Cfv;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76132);
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
    AppMethodBeat.o(76132);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.rqT;
  }
  
  public final b getType()
  {
    return b.ChC;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.CeE;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76127);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setMatrix(this.rqT.gT);
    if (isActivated()) {
      this.Cey.draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.clipRect(this.Cao);
    paramCanvas.save();
    paramCanvas.setMatrix(this.rqT.gT);
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
      bool2 = this.rqT.Y(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
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
        AppMethodBeat.o(76128);
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
  
  public final void setEmojiItem(e parame)
  {
    AppMethodBeat.i(237768);
    p.h(parame, "item");
    this.Cfv = parame;
    setEmojiInfo(parame.gWm);
    AppMethodBeat.o(237768);
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(76129);
    if (paramDrawable != null)
    {
      if ((paramDrawable instanceof h)) {
        ((h)paramDrawable).rU();
      }
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (!this.Cfw)
      {
        this.rqT.gT.postTranslate(this.rqT.width / 2.0F, this.rqT.height / 2.0F);
        this.rqT.width = i;
        this.rqT.height = j;
        this.rqT.gT.postTranslate(-i / 2.0F, -((this.Cap.top + this.Cap.bottom) / 2 - (this.Cao.top + this.Cao.bottom) / 2.0F + j / 2.0F));
      }
      this.Cey.setBounds(0, 0, i, j);
      this.rqT.o(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
    }
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(76129);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76126);
    p.h(paramb, "stateResolve");
    this.Caq = paramb;
    AppMethodBeat.o(76126);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76125);
    p.h(paramRect, "validRect");
    this.Cao.set(paramRect);
    AppMethodBeat.o(76125);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76124);
    if (p.j(this.CeE, paramMatrix))
    {
      AppMethodBeat.o(76124);
      return;
    }
    if (paramMatrix != null) {
      this.rqT.setMatrix(paramMatrix);
    }
    AppMethodBeat.o(76124);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class a
    extends q
    implements m<Matrix, Boolean, x>
  {
    a(f paramf, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.f
 * JD-Core Version:    0.7.0.1
 */