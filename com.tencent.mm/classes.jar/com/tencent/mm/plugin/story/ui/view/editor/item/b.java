package com.tencent.mm.plugin.story.ui.view.editor.item;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.media.editor.a.f;
import com.tencent.mm.media.editor.a.g;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/IEditView;", "context", "Landroid/content/Context;", "isReshow", "", "(Landroid/content/Context;Z)V", "TAG", "", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "()Z", "setReshow", "(Z)V", "newRect", "Landroid/graphics/Rect;", "stateResolve", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "getContentBoundary", "", "getSafeArea", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "validRect", "heightPercent", "plugin-story_release"})
public final class b
  extends BaseEmojiView
  implements com.tencent.mm.media.editor.a.h, c
{
  private final String TAG;
  private final com.tencent.mm.media.editor.c.c lwb;
  private Rect sQW;
  private boolean sQX;
  private final com.tencent.mm.media.editor.view.a sQp;
  private EditorItemContainer.b sQq;
  private Matrix sQv;
  
  public b(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(110675);
    this.sQX = paramBoolean;
    this.TAG = "MicroMsg.EmojiItemView";
    this.lwb = new com.tencent.mm.media.editor.c.c();
    this.sQW = new Rect();
    this.lwb.arK = 0.5F;
    this.lwb.arJ = 3.0F;
    paramContext = getResources();
    j.p(paramContext, "resources");
    this.sQp = new com.tencent.mm.media.editor.view.a(paramContext);
    AppMethodBeat.o(110675);
  }
  
  public final com.tencent.mm.media.editor.a.b UH()
  {
    AppMethodBeat.i(110670);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(110670);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(110670);
        throw ((Throwable)localObject);
      }
      localObject = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.d(((BitmapDrawable)localObject).getBitmap(), this.lwb.asO);
      AppMethodBeat.o(110670);
      return localObject;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(110670);
        throw ((Throwable)localObject);
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.lwb.asO);
      EmojiInfo localEmojiInfo = getEmojiInfo();
      if (localEmojiInfo == null) {
        j.ebi();
      }
      localObject = (com.tencent.mm.media.editor.a.b)new f(localEmojiInfo, (Matrix)localObject);
      AppMethodBeat.o(110670);
      return localObject;
      if ((getDrawable() instanceof com.tencent.mm.plugin.gif.h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(110670);
          throw ((Throwable)localObject);
        }
        f = ((com.tencent.mm.plugin.gif.h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final com.tencent.mm.media.editor.a.a UI()
  {
    AppMethodBeat.i(110671);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(110671);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = (com.tencent.mm.media.editor.a.a)new g(getEmojiInfo(), this.lwb.asO, this.lwb.asO);
      AppMethodBeat.o(110671);
      return localObject;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(110671);
        throw ((Throwable)localObject);
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      Matrix localMatrix = new Matrix();
      localMatrix.set(this.lwb.asO);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.lwb.asO);
      localObject = (com.tencent.mm.media.editor.a.a)new g(getEmojiInfo(), localMatrix, (Matrix)localObject);
      AppMethodBeat.o(110671);
      return localObject;
      if ((getDrawable() instanceof com.tencent.mm.plugin.gif.h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(110671);
          throw ((Throwable)localObject);
        }
        f = ((com.tencent.mm.plugin.gif.h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(151263);
    j.q(paramRect, "validRect");
    this.sQW = paramRect;
    this.lwb.asO.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(151263);
  }
  
  public final void ai(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(151264);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      this.lwb.asO.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(151264);
  }
  
  public final void c(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(151265);
    j.q(paramRect, "safeRect");
    this.lwb.eTC = paramRect;
    this.lwb.eTD = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(151265);
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(110674);
    float[] arrayOfFloat = (float[])this.lwb.eTI.clone();
    AppMethodBeat.o(110674);
    return arrayOfFloat;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(110673);
    Rect localRect = this.lwb.eTC;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      j.p(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      j.p(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(110673);
    return localObject;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.sQv;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(110667);
    j.q(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setMatrix(this.lwb.asO);
    if (isActivated()) {
      this.sQp.draw(paramCanvas);
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(110667);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(110668);
    j.q(paramMotionEvent, "event");
    boolean bool = this.lwb.u(paramMotionEvent);
    Object localObject;
    if (bool)
    {
      bringToFront();
      localObject = this.sQq;
      if (localObject != null) {
        ((EditorItemContainer.b)localObject).e((View)this, paramMotionEvent);
      }
      postInvalidate();
    }
    if (paramMotionEvent.getActionMasked() == 1)
    {
      paramMotionEvent = new com.tencent.mm.media.editor.c.a();
      localObject = k.sCp;
      localObject = k.cCr();
      paramMotionEvent.arK = this.lwb.arK;
      paramMotionEvent.arJ = this.lwb.arJ;
      paramMotionEvent.g(new float[] { this.lwb.width / 2.0F, this.lwb.height / 2.0F });
      paramMotionEvent.b(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
      paramMotionEvent.a(this.lwb.asO, (a.f.a.b)new b.a(this));
    }
    AppMethodBeat.o(110668);
    return bool;
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(110669);
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (!this.sQX)
      {
        this.lwb.width = i;
        this.lwb.height = j;
        this.lwb.asO.postTranslate(-i / 2.0F, -j / 2.0F);
      }
      this.sQp.setBounds(0, 0, i, j);
      this.lwb.h(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
    }
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(110669);
  }
  
  public final void setReshow(boolean paramBoolean)
  {
    this.sQX = paramBoolean;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(110666);
    j.q(paramb, "stateResolve");
    this.sQq = paramb;
    AppMethodBeat.o(110666);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(110664);
    if (j.e(this.sQv, paramMatrix))
    {
      AppMethodBeat.o(110664);
      return;
    }
    if (paramMatrix != null) {
      this.lwb.setMatrix(paramMatrix);
    }
    AppMethodBeat.o(110664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.item.b
 * JD-Core Version:    0.7.0.1
 */