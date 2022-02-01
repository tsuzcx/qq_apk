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
import com.tencent.mm.media.editor.a.f;
import com.tencent.mm.media.editor.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditView;", "context", "Landroid/content/Context;", "isReshow", "", "(Landroid/content/Context;Z)V", "TAG", "", "displayRect", "Landroid/graphics/Rect;", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "()Z", "setReshow", "(Z)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validRect", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "getContentBoundary", "", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class c
  extends EmojiStatusView
  implements com.tencent.mm.media.editor.a.h, d
{
  private final String TAG;
  private final com.tencent.mm.media.editor.c.c ppQ;
  private final com.tencent.mm.media.editor.view.a wCA;
  private EditorItemContainer.b wCB;
  private final Rect wCD;
  private final Rect wCE;
  private Matrix wCI;
  private boolean wDq;
  
  public c(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(76135);
    this.wDq = paramBoolean;
    this.TAG = "MicroMsg.EmojiItemView";
    this.ppQ = new com.tencent.mm.media.editor.c.c();
    this.wCD = new Rect(0, 0, ap.cl(ai.getContext()).x, ap.cl(ai.getContext()).y);
    this.wCE = new Rect(0, 0, ap.cl(ai.getContext()).x, ap.cl(ai.getContext()).y);
    this.ppQ.aNl = 0.5F;
    this.ppQ.aNk = 3.0F;
    paramContext = getResources();
    k.g(paramContext, "resources");
    this.wCA = new com.tencent.mm.media.editor.view.a(paramContext);
    AppMethodBeat.o(76135);
  }
  
  public final void Y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(199445);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      this.ppQ.eY.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(199445);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76134);
    k.h(paramRect, "displayRect");
    this.wCE.set(paramRect);
    this.ppQ.eY.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(76134);
  }
  
  public final com.tencent.mm.media.editor.a.a aqy()
  {
    AppMethodBeat.i(76131);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(76131);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = new Matrix();
      ((Matrix)localObject).postConcat(this.ppQ.eY);
      ((Matrix)localObject).postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
      localObject = (com.tencent.mm.media.editor.a.a)new g(getEmojiInfo(), (Matrix)localObject, (Matrix)localObject);
      AppMethodBeat.o(76131);
      return localObject;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(76131);
        throw ((Throwable)localObject);
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      Matrix localMatrix = new Matrix();
      ac.i(this.TAG, "createEditorData displayRect:" + this.wCE + " validRect:" + this.wCD);
      localMatrix.set(this.ppQ.eY);
      localMatrix.postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.ppQ.eY);
      ((Matrix)localObject).postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
      localObject = (com.tencent.mm.media.editor.a.a)new g(getEmojiInfo(), localMatrix, (Matrix)localObject);
      AppMethodBeat.o(76131);
      return localObject;
      if ((getDrawable() instanceof com.tencent.mm.plugin.gif.h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(76131);
          throw ((Throwable)localObject);
        }
        f = ((com.tencent.mm.plugin.gif.h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(199446);
    k.h(paramRect, "safeRect");
    this.ppQ.gQo = paramRect;
    this.ppQ.gQp = com.tencent.mm.cc.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(199446);
  }
  
  public final com.tencent.mm.media.editor.a.b c(Matrix paramMatrix)
  {
    AppMethodBeat.i(163470);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(163470);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(163470);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.postConcat(this.ppQ.eY);
      localMatrix.postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.media.editor.a.b)new com.tencent.mm.media.editor.a.d((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(163470);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(163470);
        throw paramMatrix;
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      ac.i(this.TAG, "createEditorItem displayRect:" + this.wCE + " validRect:" + this.wCD);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.ppQ.eY);
      ((Matrix)localObject).postTranslate(-(this.wCE.width() - this.wCD.width()) / 2.0F, -(this.wCE.height() - this.wCD.height()) / 2.0F);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      if (paramMatrix == null) {
        k.fOy();
      }
      paramMatrix = (com.tencent.mm.media.editor.a.b)new f(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(163470);
      return paramMatrix;
      if ((getDrawable() instanceof com.tencent.mm.plugin.gif.h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(163470);
          throw paramMatrix;
        }
        f = ((com.tencent.mm.plugin.gif.h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76133);
    float[] arrayOfFloat = (float[])this.ppQ.gQu.clone();
    AppMethodBeat.o(76133);
    return arrayOfFloat;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76132);
    Rect localRect = this.ppQ.gQo;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      k.g(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      k.g(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(76132);
    return localObject;
  }
  
  public final com.tencent.mm.media.editor.c.c getTouchTracker()
  {
    return this.ppQ;
  }
  
  public final b getType()
  {
    return b.wCO;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.wCI;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76127);
    k.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setMatrix(this.ppQ.eY);
    if (isActivated()) {
      this.wCA.draw(paramCanvas);
    }
    Drawable localDrawable = getDrawable();
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    paramCanvas.restore();
    AppMethodBeat.o(76127);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(76128);
    k.h(paramMotionEvent, "event");
    boolean bool = this.ppQ.t(paramMotionEvent);
    Object localObject;
    if (bool)
    {
      bringToFront();
      localObject = this.wCB;
      if (localObject != null) {
        ((EditorItemContainer.b)localObject).c((View)this, paramMotionEvent);
      }
      postInvalidate();
    }
    if (paramMotionEvent.getActionMasked() == 1)
    {
      paramMotionEvent = new com.tencent.mm.media.editor.c.a();
      localObject = this.wCD;
      paramMotionEvent.aNl = this.ppQ.aNl;
      paramMotionEvent.aNk = this.ppQ.aNk;
      paramMotionEvent.k(new float[] { this.ppQ.width / 2.0F, this.ppQ.height / 2.0F });
      paramMotionEvent.e(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
      paramMotionEvent.a(this.ppQ.eY, (d.g.a.b)new a(this));
    }
    AppMethodBeat.o(76128);
    return bool;
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(76129);
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (!this.wDq)
      {
        this.ppQ.eY.postTranslate(this.ppQ.width / 2.0F, this.ppQ.height / 2.0F);
        this.ppQ.width = i;
        this.ppQ.height = j;
        this.ppQ.eY.postTranslate(-i / 2.0F, -((this.wCE.top + this.wCE.bottom) / 2 - (this.wCD.top + this.wCD.bottom) / 2.0F + j / 2.0F));
      }
      this.wCA.setBounds(0, 0, i, j);
      this.ppQ.l(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
    }
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(76129);
  }
  
  public final void setReshow(boolean paramBoolean)
  {
    this.wDq = paramBoolean;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76126);
    k.h(paramb, "stateResolve");
    this.wCB = paramb;
    AppMethodBeat.o(76126);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76125);
    k.h(paramRect, "validRect");
    this.wCD.set(paramRect);
    AppMethodBeat.o(76125);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76124);
    if (k.g(this.wCI, paramMatrix))
    {
      AppMethodBeat.o(76124);
      return;
    }
    if (paramMatrix != null) {
      this.ppQ.setMatrix(paramMatrix);
    }
    AppMethodBeat.o(76124);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Matrix, y>
  {
    a(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.c
 * JD-Core Version:    0.7.0.1
 */