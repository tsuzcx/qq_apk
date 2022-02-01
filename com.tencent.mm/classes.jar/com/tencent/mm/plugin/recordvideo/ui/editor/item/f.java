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
import com.tencent.mm.plugin.recordvideo.ui.editor.view.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "displayRect", "Landroid/graphics/Rect;", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isReshow", "", "originPivot", "", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "reshowEmoji", "item", "setDefaultLocation", "heightPercent", "setEmojiItem", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "plugin-recordvideo_release"})
public final class f
  extends EmojiStatusView
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  private final Rect HXd;
  private final Rect HXe;
  private EditorItemContainer.b HXf;
  private Matrix IbA;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a Ibu;
  private e Icr;
  private boolean Ics;
  private final String TAG;
  private final float[] uWJ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c uWz;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(216781);
    this.TAG = "MicroMsg.EmojiItemView";
    this.uWz = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.HXd = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.HXe = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.uWJ = new float[2];
    this.uWz.aGO = 0.5F;
    this.uWz.aGN = 3.0F;
    paramContext = getResources();
    p.j(paramContext, "resources");
    this.Ibu = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    AppMethodBeat.o(216781);
  }
  
  public final boolean PA(long paramLong)
  {
    AppMethodBeat.i(216782);
    boolean bool = c.a.a(this, paramLong);
    AppMethodBeat.o(216782);
    return bool;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76134);
    p.k(paramRect, "displayRect");
    this.HXe.set(paramRect);
    this.uWz.aHZ.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(76134);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(216775);
    p.k(parame, "item");
    this.Ics = true;
    setViewMatrix(parame.Icp);
    setEmojiInfo(parame.jHh);
    AppMethodBeat.o(216775);
  }
  
  public final boolean aWf(String paramString)
  {
    AppMethodBeat.i(216783);
    p.k(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(216783);
    return bool;
  }
  
  public final void ah(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(216773);
    if ((paramFloat1 != 0.0F) && (paramFloat2 != 0.0F)) {
      this.uWz.aHZ.setScale(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(216773);
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(216779);
    p.k(paramRect, "safeRect");
    this.uWz.HGw = paramRect;
    this.uWz.IdR = com.tencent.mm.ci.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(216779);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    AppMethodBeat.i(216776);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(216776);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(216776);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.postConcat(this.uWz.aHZ);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(216776);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(216776);
        throw paramMatrix;
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      Log.i(this.TAG, "createEditorItem displayRect:" + this.HXe + " validRect:" + this.HXd);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.uWz.aHZ);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      if (paramMatrix == null) {
        p.iCn();
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(216776);
      return paramMatrix;
      if ((getDrawable() instanceof com.tencent.mm.plugin.gif.h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(216776);
          throw paramMatrix;
        }
        f = ((com.tencent.mm.plugin.gif.h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final a cYy()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(216778);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(216778);
      return null;
    }
    Object localObject3;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postConcat(this.uWz.aHZ);
      localObject3 = new e(getEmojiInfo(), (Matrix)localObject1, (Matrix)localObject1);
      localObject1 = this.Icr;
      if (localObject1 != null)
      {
        localObject1 = ((a)localObject1).Ibr;
        if (localObject1 != null) {
          ((a)localObject3).Ibr.ar(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getEnd());
        }
      }
      e locale = this.Icr;
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.objectId;
      }
      ((a)localObject3).objectId = ((String)localObject1);
      localObject1 = (a)localObject3;
      AppMethodBeat.o(216778);
      return localObject1;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject2 = getDrawable();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(216778);
        throw ((Throwable)localObject1);
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject2).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject2 = new Matrix();
      localObject3 = new Matrix();
      Log.i(this.TAG, "createEditorData displayRect:" + this.HXe + " validRect:" + this.HXd);
      ((Matrix)localObject3).set(this.uWz.aHZ);
      ((Matrix)localObject3).postTranslate(-(this.HXe.width() - this.HXd.width()) / 2.0F, -this.HXd.top);
      ((Matrix)localObject2).setScale(f, f);
      ((Matrix)localObject2).postConcat(this.uWz.aHZ);
      localObject2 = new e(getEmojiInfo(), (Matrix)localObject3, (Matrix)localObject2);
      localObject3 = this.Icr;
      if (localObject3 != null)
      {
        localObject3 = ((a)localObject3).Ibr;
        if (localObject3 != null) {
          ((a)localObject2).Ibr.ar(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
        }
      }
      localObject3 = this.Icr;
      if (localObject3 != null) {
        localObject1 = ((a)localObject3).objectId;
      }
      ((a)localObject2).objectId = ((String)localObject1);
      localObject1 = (a)localObject2;
      AppMethodBeat.o(216778);
      return localObject1;
      if ((getDrawable() instanceof com.tencent.mm.plugin.gif.h))
      {
        localObject2 = getDrawable();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(216778);
          throw ((Throwable)localObject1);
        }
        f = ((com.tencent.mm.plugin.gif.h)localObject2).getEmojiDensityScale();
      }
    }
  }
  
  public final boolean fyf()
  {
    return true;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76133);
    float[] arrayOfFloat = (float[])this.uWz.IdW.clone();
    AppMethodBeat.o(76133);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(216780);
    RectF localRectF = new RectF(this.uWz.IdW[0], this.uWz.IdW[1], this.uWz.IdW[2], this.uWz.IdW[3]);
    AppMethodBeat.o(216780);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.Icr;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76132);
    Rect localRect = this.uWz.HGw;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      p.j(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      p.j(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(76132);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.uWz;
  }
  
  public final b getType()
  {
    return b.Ies;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.IbA;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76127);
    p.k(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setMatrix(this.uWz.aHZ);
    if (isActivated()) {
      this.Ibu.draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.clipRect(this.HXd);
    paramCanvas.save();
    paramCanvas.setMatrix(this.uWz.aHZ);
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
    p.k(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.uWz.ah(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
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
        AppMethodBeat.o(76128);
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
  
  public final void setEmojiItem(e parame)
  {
    AppMethodBeat.i(216774);
    p.k(parame, "item");
    this.Icr = parame;
    setEmojiInfo(parame.jHh);
    AppMethodBeat.o(216774);
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(76129);
    if (paramDrawable != null)
    {
      if ((paramDrawable instanceof com.tencent.mm.plugin.gif.h)) {
        ((com.tencent.mm.plugin.gif.h)paramDrawable).pI();
      }
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (!this.Ics)
      {
        this.uWz.aHZ.postTranslate(this.uWz.width / 2.0F, this.uWz.height / 2.0F);
        this.uWz.width = i;
        this.uWz.height = j;
        this.uWz.aHZ.postTranslate(-i / 2.0F, -((this.HXe.top + this.HXe.bottom) / 2 - (this.HXd.top + this.HXd.bottom) / 2.0F + j / 2.0F));
      }
      this.Ibu.setBounds(0, 0, i, j);
      this.uWz.p(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
    }
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(76129);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76126);
    p.k(paramb, "stateResolve");
    this.HXf = paramb;
    AppMethodBeat.o(76126);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76125);
    p.k(paramRect, "validRect");
    this.HXd.set(paramRect);
    AppMethodBeat.o(76125);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76124);
    if (p.h(this.IbA, paramMatrix))
    {
      AppMethodBeat.o(76124);
      return;
    }
    if (paramMatrix != null) {
      this.uWz.setMatrix(paramMatrix);
    }
    AppMethodBeat.o(76124);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.f
 * JD-Core Version:    0.7.0.1
 */