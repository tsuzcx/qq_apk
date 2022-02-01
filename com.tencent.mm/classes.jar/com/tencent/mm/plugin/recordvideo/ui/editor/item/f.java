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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.ar;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "displayRect", "Landroid/graphics/Rect;", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isReshow", "", "originPivot", "", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "reshowEmoji", "item", "setDefaultLocation", "heightPercent", "setEmojiItem", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class f
  extends EmojiStatusView
  implements g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final String TAG;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pZW;
  private final float[] qag;
  private final Rect xZp;
  private final Rect xZq;
  private EditorItemContainer.b xZr;
  private Matrix ydC;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a ydw;
  private e yet;
  private boolean yeu;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206933);
    this.TAG = "MicroMsg.EmojiItemView";
    this.pZW = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.xZp = new Rect(0, 0, ar.ck(ak.getContext()).x, ar.ck(ak.getContext()).y);
    this.xZq = new Rect(0, 0, ar.ck(ak.getContext()).x, ar.ck(ak.getContext()).y);
    this.qag = new float[2];
    this.pZW.aXF = 0.5F;
    this.pZW.aXE = 3.0F;
    paramContext = getResources();
    p.g(paramContext, "resources");
    this.ydw = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    AppMethodBeat.o(206933);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76134);
    p.h(paramRect, "displayRect");
    this.xZq.set(paramRect);
    this.pZW.gR.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(76134);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(206928);
    p.h(parame, "item");
    this.yeu = true;
    setViewMatrix(parame.yer);
    setEmojiInfo(parame.glt);
    AppMethodBeat.o(206928);
  }
  
  public final void aa(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206926);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      this.pZW.gR.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(206926);
  }
  
  public final boolean axd(String paramString)
  {
    AppMethodBeat.i(206935);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(206935);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(206931);
    p.h(paramRect, "safeRect");
    this.pZW.xKi = paramRect;
    this.pZW.yge = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(206931);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(206929);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(206929);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(206929);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.postConcat(this.pZW.gR);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(206929);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(206929);
        throw paramMatrix;
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      ae.i(this.TAG, "createEditorItem displayRect:" + this.xZq + " validRect:" + this.xZp);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.pZW.gR);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      if (paramMatrix == null) {
        p.gkB();
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(206929);
      return paramMatrix;
      if ((getDrawable() instanceof h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(206929);
          throw paramMatrix;
        }
        f = ((h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final a clM()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(206930);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(206930);
      return null;
    }
    Object localObject3;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postConcat(this.pZW.gR);
      localObject3 = new e(getEmojiInfo(), (Matrix)localObject1, (Matrix)localObject1);
      localObject1 = this.yet;
      if (localObject1 != null)
      {
        localObject1 = ((a)localObject1).ydt;
        if (localObject1 != null) {
          ((a)localObject3).ydt.ae(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getEnd());
        }
      }
      e locale = this.yet;
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.objectId;
      }
      ((a)localObject3).objectId = ((String)localObject1);
      localObject1 = (a)localObject3;
      AppMethodBeat.o(206930);
      return localObject1;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject2 = getDrawable();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(206930);
        throw ((Throwable)localObject1);
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject2).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject2 = new Matrix();
      localObject3 = new Matrix();
      ae.i(this.TAG, "createEditorData displayRect:" + this.xZq + " validRect:" + this.xZp);
      ((Matrix)localObject3).set(this.pZW.gR);
      ((Matrix)localObject3).postTranslate(-(this.xZq.width() - this.xZp.width()) / 2.0F, -this.xZp.top);
      ((Matrix)localObject2).setScale(f, f);
      ((Matrix)localObject2).postConcat(this.pZW.gR);
      localObject2 = new e(getEmojiInfo(), (Matrix)localObject3, (Matrix)localObject2);
      localObject3 = this.yet;
      if (localObject3 != null)
      {
        localObject3 = ((a)localObject3).ydt;
        if (localObject3 != null) {
          ((a)localObject2).ydt.ae(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
        }
      }
      localObject3 = this.yet;
      if (localObject3 != null) {
        localObject1 = ((a)localObject3).objectId;
      }
      ((a)localObject2).objectId = ((String)localObject1);
      localObject1 = (a)localObject2;
      AppMethodBeat.o(206930);
      return localObject1;
      if ((getDrawable() instanceof h))
      {
        localObject2 = getDrawable();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(206930);
          throw ((Throwable)localObject1);
        }
        f = ((h)localObject2).getEmojiDensityScale();
      }
    }
  }
  
  public final boolean dKK()
  {
    return true;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76133);
    float[] arrayOfFloat = (float[])this.pZW.ygj.clone();
    AppMethodBeat.o(76133);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(206932);
    RectF localRectF = new RectF(this.pZW.ygj[0], this.pZW.ygj[1], this.pZW.ygj[2], this.pZW.ygj[3]);
    AppMethodBeat.o(206932);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.yet;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76132);
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
    AppMethodBeat.o(76132);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pZW;
  }
  
  public final b getType()
  {
    return b.ygF;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.ydC;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76127);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setMatrix(this.pZW.gR);
    if (isActivated()) {
      this.ydw.draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.clipRect(this.xZp);
    paramCanvas.save();
    paramCanvas.setMatrix(this.pZW.gR);
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
      bool2 = this.pZW.U(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
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
        AppMethodBeat.o(76128);
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
  
  public final void setEmojiItem(e parame)
  {
    AppMethodBeat.i(206927);
    p.h(parame, "item");
    this.yet = parame;
    setEmojiInfo(parame.glt);
    AppMethodBeat.o(206927);
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(76129);
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (!this.yeu)
      {
        this.pZW.gR.postTranslate(this.pZW.width / 2.0F, this.pZW.height / 2.0F);
        this.pZW.width = i;
        this.pZW.height = j;
        this.pZW.gR.postTranslate(-i / 2.0F, -((this.xZq.top + this.xZq.bottom) / 2 - (this.xZp.top + this.xZp.bottom) / 2.0F + j / 2.0F));
      }
      this.ydw.setBounds(0, 0, i, j);
      this.pZW.o(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
    }
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(76129);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76126);
    p.h(paramb, "stateResolve");
    this.xZr = paramb;
    AppMethodBeat.o(76126);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76125);
    p.h(paramRect, "validRect");
    this.xZp.set(paramRect);
    AppMethodBeat.o(76125);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76124);
    if (p.i(this.ydC, paramMatrix))
    {
      AppMethodBeat.o(76124);
      return;
    }
    if (paramMatrix != null) {
      this.pZW.setMatrix(paramMatrix);
    }
    AppMethodBeat.o(76124);
  }
  
  public final boolean zi(long paramLong)
  {
    AppMethodBeat.i(206934);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(206934);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
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