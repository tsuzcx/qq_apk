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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/media/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditView;", "context", "Landroid/content/Context;", "isReshow", "", "(Landroid/content/Context;Z)V", "TAG", "", "displayRect", "Landroid/graphics/Rect;", "frameDrawable", "Lcom/tencent/mm/media/editor/view/ActiveFrameDrawable;", "()Z", "setReshow", "(Z)V", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/media/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/media/editor/touch/TouchTracker;", "validRect", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "matrix", "getContentBoundary", "", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditItemType;", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setDefaultLocation", "heightPercent", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class c
  extends EmojiStatusView
  implements com.tencent.mm.media.editor.a.h, d
{
  private final String TAG;
  private final com.tencent.mm.media.editor.c.c oMw;
  private final com.tencent.mm.media.editor.view.a vsA;
  private EditorItemContainer.b vsB;
  private final Rect vsD;
  private final Rect vsE;
  private Matrix vsI;
  private boolean vtq;
  
  public c(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(76135);
    this.vtq = paramBoolean;
    this.TAG = "MicroMsg.EmojiItemView";
    this.oMw = new com.tencent.mm.media.editor.c.c();
    this.vsD = new Rect(0, 0, ap.cf(aj.getContext()).x, ap.cf(aj.getContext()).y);
    this.vsE = new Rect(0, 0, ap.cf(aj.getContext()).x, ap.cf(aj.getContext()).y);
    this.oMw.aMv = 0.5F;
    this.oMw.aMu = 3.0F;
    paramContext = getResources();
    k.g(paramContext, "resources");
    this.vsA = new com.tencent.mm.media.editor.view.a(paramContext);
    AppMethodBeat.o(76135);
  }
  
  public final void U(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204325);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      this.oMw.dY.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(204325);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76134);
    k.h(paramRect, "displayRect");
    this.vsE.set(paramRect);
    this.oMw.dY.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(76134);
  }
  
  public final com.tencent.mm.media.editor.a.a ajz()
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
      ((Matrix)localObject).postConcat(this.oMw.dY);
      ((Matrix)localObject).postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
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
      ad.i(this.TAG, "createEditorData displayRect:" + this.vsE + " validRect:" + this.vsD);
      localMatrix.set(this.oMw.dY);
      localMatrix.postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.oMw.dY);
      ((Matrix)localObject).postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
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
    AppMethodBeat.i(204326);
    k.h(paramRect, "safeRect");
    this.oMw.gpG = paramRect;
    this.oMw.gpH = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(204326);
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
      localMatrix.postConcat(this.oMw.dY);
      localMatrix.postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
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
      ad.i(this.TAG, "createEditorItem displayRect:" + this.vsE + " validRect:" + this.vsD);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.oMw.dY);
      ((Matrix)localObject).postTranslate(-(this.vsE.width() - this.vsD.width()) / 2.0F, -(this.vsE.height() - this.vsD.height()) / 2.0F);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      if (paramMatrix == null) {
        k.fvU();
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
    float[] arrayOfFloat = (float[])this.oMw.gpM.clone();
    AppMethodBeat.o(76133);
    return arrayOfFloat;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76132);
    Rect localRect = this.oMw.gpG;
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
    return this.oMw;
  }
  
  public final b getType()
  {
    return b.vsO;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.vsI;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76127);
    k.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setMatrix(this.oMw.dY);
    if (isActivated()) {
      this.vsA.draw(paramCanvas);
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
    boolean bool = this.oMw.v(paramMotionEvent);
    Object localObject;
    if (bool)
    {
      bringToFront();
      localObject = this.vsB;
      if (localObject != null) {
        ((EditorItemContainer.b)localObject).c((View)this, paramMotionEvent);
      }
      postInvalidate();
    }
    if (paramMotionEvent.getActionMasked() == 1)
    {
      paramMotionEvent = new com.tencent.mm.media.editor.c.a();
      localObject = this.vsD;
      paramMotionEvent.aMv = this.oMw.aMv;
      paramMotionEvent.aMu = this.oMw.aMu;
      paramMotionEvent.k(new float[] { this.oMw.width / 2.0F, this.oMw.height / 2.0F });
      paramMotionEvent.e(new RectF(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom));
      paramMotionEvent.a(this.oMw.dY, (d.g.a.b)new a(this));
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
      if (!this.vtq)
      {
        this.oMw.dY.postTranslate(this.oMw.width / 2.0F, this.oMw.height / 2.0F);
        this.oMw.width = i;
        this.oMw.height = j;
        this.oMw.dY.postTranslate(-i / 2.0F, -((this.vsE.top + this.vsE.bottom) / 2 - (this.vsD.top + this.vsD.bottom) / 2.0F + j / 2.0F));
      }
      this.vsA.setBounds(0, 0, i, j);
      this.oMw.l(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
    }
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(76129);
  }
  
  public final void setReshow(boolean paramBoolean)
  {
    this.vtq = paramBoolean;
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76126);
    k.h(paramb, "stateResolve");
    this.vsB = paramb;
    AppMethodBeat.o(76126);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76125);
    k.h(paramRect, "validRect");
    this.vsD.set(paramRect);
    AppMethodBeat.o(76125);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76124);
    if (k.g(this.vsI, paramMatrix))
    {
      AppMethodBeat.o(76124);
      return;
    }
    if (paramMatrix != null) {
      this.oMw.setMatrix(paramMatrix);
    }
    AppMethodBeat.o(76124);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.c
 * JD-Core Version:    0.7.0.1
 */