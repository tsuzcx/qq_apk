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
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItemView;", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "displayRect", "Landroid/graphics/Rect;", "emojiItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EmojiItem;", "frameDrawable", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/ActiveFrameDrawable;", "isReshow", "", "originPivot", "", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "validRect", "value", "Landroid/graphics/Matrix;", "viewMatrix", "getViewMatrix", "()Landroid/graphics/Matrix;", "setViewMatrix", "(Landroid/graphics/Matrix;)V", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "getContentBoundary", "getDrawRect", "Landroid/graphics/RectF;", "getEditorData", "getSafeArea", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "initScale", "", "sx", "", "sy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "reshowEmoji", "item", "setDefaultLocation", "heightPercent", "setEmojiItem", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSafeArea", "safeRect", "damp", "", "setStateResolve", "setValidArea", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends EmojiStatusView
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.d
{
  private final Rect NTO;
  private final Rect NTP;
  private EditorItemContainer.b NTQ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.view.a NXT;
  private Matrix NXY;
  private e NYN;
  private boolean NYO;
  private final String TAG;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c yiZ;
  private final float[] yji;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(280363);
    this.TAG = "MicroMsg.EmojiItemView";
    this.yiZ = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.NTO = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.NTP = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.yji = new float[2];
    this.yiZ.minScale = 0.5F;
    this.yiZ.maxScale = 3.0F;
    paramContext = getResources();
    s.s(paramContext, "resources");
    this.NXT = new com.tencent.mm.plugin.recordvideo.ui.editor.view.a(paramContext);
    AppMethodBeat.o(280363);
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(76134);
    s.u(paramRect, "displayRect");
    this.NTP.set(paramRect);
    this.yiZ.matrix.postTranslate(paramRect.width() / 2.0F, paramRect.height() * paramFloat);
    AppMethodBeat.o(76134);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(280424);
    s.u(parame, "item");
    this.NYO = true;
    setViewMatrix(parame.NYM);
    setEmojiInfo(parame.mgK);
    AppMethodBeat.o(280424);
  }
  
  public final void aM(float paramFloat1, float paramFloat2)
  {
    int j = 1;
    AppMethodBeat.i(280402);
    if (paramFloat1 == 0.0F)
    {
      i = 1;
      if (i == 0) {
        if (paramFloat2 != 0.0F) {
          break label56;
        }
      }
    }
    label56:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        this.yiZ.matrix.setScale(paramFloat1, paramFloat2);
      }
      AppMethodBeat.o(280402);
      return;
      i = 0;
      break;
    }
  }
  
  public final boolean aTn(String paramString)
  {
    AppMethodBeat.i(280472);
    boolean bool = d.a.a(this, paramString);
    AppMethodBeat.o(280472);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(280455);
    s.u(paramRect, "safeRect");
    this.yiZ.NDV = paramRect;
    this.yiZ.Oah = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(280455);
  }
  
  public final a dEP()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(280449);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(280449);
      return null;
    }
    Object localObject3;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postConcat(this.yiZ.matrix);
      localObject3 = new e(getEmojiInfo(), (Matrix)localObject1, (Matrix)localObject1);
      localObject1 = this.NYN;
      if (localObject1 != null)
      {
        localObject1 = ((a)localObject1).NXR;
        if (localObject1 != null) {
          ((a)localObject3).NXR.bb(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject1).getEnd());
        }
      }
      localObject1 = this.NYN;
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((a)localObject1).objectId)
      {
        ((a)localObject3).objectId = ((String)localObject1);
        localObject1 = (a)localObject3;
        AppMethodBeat.o(280449);
        return localObject1;
      }
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject2 = getDrawable();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(280449);
        throw ((Throwable)localObject1);
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject2).getEmojiDensityScale();
      localObject2 = new Matrix();
      localObject3 = new Matrix();
      Log.i(this.TAG, "createEditorData displayRect:" + this.NTP + " validRect:" + this.NTO);
      ((Matrix)localObject3).set(this.yiZ.matrix);
      ((Matrix)localObject3).postTranslate(-(this.NTP.width() - this.NTO.width()) / 2.0F, -this.NTO.top);
      ((Matrix)localObject2).setScale(f, f);
      ((Matrix)localObject2).postConcat(this.yiZ.matrix);
      localObject2 = new e(getEmojiInfo(), (Matrix)localObject3, (Matrix)localObject2);
      localObject3 = this.NYN;
      if (localObject3 != null)
      {
        localObject3 = ((a)localObject3).NXR;
        if (localObject3 != null) {
          ((a)localObject2).NXR.bb(((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getStart(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d)localObject3).getEnd());
        }
      }
      localObject3 = this.NYN;
      if (localObject3 != null) {
        break label445;
      }
    }
    for (;;)
    {
      ((a)localObject2).objectId = ((String)localObject1);
      localObject1 = (a)localObject2;
      AppMethodBeat.o(280449);
      return localObject1;
      if (!(getDrawable() instanceof com.tencent.mm.plugin.gif.h)) {
        break;
      }
      localObject2 = getDrawable();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
        AppMethodBeat.o(280449);
        throw ((Throwable)localObject1);
      }
      f = ((com.tencent.mm.plugin.gif.h)localObject2).getEmojiDensityScale();
      break;
      label445:
      localObject1 = ((a)localObject3).objectId;
    }
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a e(Matrix paramMatrix)
  {
    AppMethodBeat.i(280440);
    if (getEmojiInfo() == null)
    {
      AppMethodBeat.o(280440);
      return null;
    }
    Object localObject;
    if ((getDrawable() instanceof BitmapDrawable))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(280440);
        throw paramMatrix;
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
      Matrix localMatrix = new Matrix();
      localMatrix.postConcat(this.yiZ.matrix);
      if (paramMatrix != null) {
        localMatrix.postConcat(paramMatrix);
      }
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.c((Bitmap)localObject, localMatrix);
      AppMethodBeat.o(280440);
      return paramMatrix;
    }
    float f = 1.0F;
    if ((getDrawable() instanceof com.tencent.mm.plugin.gif.d))
    {
      localObject = getDrawable();
      if (localObject == null)
      {
        paramMatrix = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMGIFDrawable");
        AppMethodBeat.o(280440);
        throw paramMatrix;
      }
      f = ((com.tencent.mm.plugin.gif.d)localObject).getEmojiDensityScale();
    }
    for (;;)
    {
      localObject = new Matrix();
      Log.i(this.TAG, "createEditorItem displayRect:" + this.NTP + " validRect:" + this.NTO);
      ((Matrix)localObject).setScale(f, f);
      ((Matrix)localObject).postConcat(this.yiZ.matrix);
      if (paramMatrix != null) {
        ((Matrix)localObject).postConcat(paramMatrix);
      }
      paramMatrix = getEmojiInfo();
      s.checkNotNull(paramMatrix);
      paramMatrix = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a)new com.tencent.mm.plugin.recordvideo.ui.editor.item.a.e(paramMatrix, (Matrix)localObject);
      AppMethodBeat.o(280440);
      return paramMatrix;
      if ((getDrawable() instanceof com.tencent.mm.plugin.gif.h))
      {
        localObject = getDrawable();
        if (localObject == null)
        {
          paramMatrix = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gif.MMWXGFDrawable");
          AppMethodBeat.o(280440);
          throw paramMatrix;
        }
        f = ((com.tencent.mm.plugin.gif.h)localObject).getEmojiDensityScale();
      }
    }
  }
  
  public final boolean gJS()
  {
    AppMethodBeat.i(280471);
    s.u(this, "this");
    AppMethodBeat.o(280471);
    return true;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(76133);
    float[] arrayOfFloat = (float[])this.yiZ.Oam.clone();
    AppMethodBeat.o(76133);
    return arrayOfFloat;
  }
  
  public final RectF getDrawRect()
  {
    AppMethodBeat.i(280469);
    RectF localRectF = new RectF(this.yiZ.Oam[0], this.yiZ.Oam[1], this.yiZ.Oam[2], this.yiZ.Oam[3]);
    AppMethodBeat.o(280469);
    return localRectF;
  }
  
  public final a getEditorData()
  {
    return (a)this.NYN;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(76132);
    Rect localRect = this.yiZ.NDV;
    if (localRect == null)
    {
      localRect = new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
      AppMethodBeat.o(76132);
      return localRect;
    }
    AppMethodBeat.o(76132);
    return localRect;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.yiZ;
  }
  
  public final b getType()
  {
    return b.OaI;
  }
  
  public final Matrix getViewMatrix()
  {
    return this.NXY;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(76127);
    s.u(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.setMatrix(this.yiZ.matrix);
    if (isActivated()) {
      this.NXT.draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.clipRect(this.NTO);
    paramCanvas.save();
    paramCanvas.setMatrix(this.yiZ.matrix);
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
    s.u(paramMotionEvent, "event");
    boolean bool2;
    Object localObject1;
    if ((paramMotionEvent.getActionMasked() != 3) && (paramMotionEvent.getActionMasked() != 1))
    {
      bool2 = this.yiZ.ak(paramMotionEvent);
      bool1 = bool2;
      if (bool2)
      {
        bringToFront();
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
        AppMethodBeat.o(76128);
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
  
  public final void setEmojiItem(e parame)
  {
    AppMethodBeat.i(280416);
    s.u(parame, "item");
    this.NYN = parame;
    setEmojiInfo(parame.mgK);
    AppMethodBeat.o(280416);
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(76129);
    if (paramDrawable != null)
    {
      if ((paramDrawable instanceof com.tencent.mm.plugin.gif.h)) {
        ((com.tencent.mm.plugin.gif.h)paramDrawable).preDraw();
      }
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (!this.NYO)
      {
        this.yiZ.matrix.postTranslate(this.yiZ.width / 2.0F, this.yiZ.height / 2.0F);
        this.yiZ.width = i;
        this.yiZ.height = j;
        this.yiZ.matrix.postTranslate(-i / 2.0F, -((this.NTP.top + this.NTP.bottom) / 2 - (this.NTO.top + this.NTO.bottom) / 2.0F + j / 2.0F));
      }
      this.NXT.setBounds(0, 0, i, j);
      this.yiZ.x(new float[] { 0.0F, 0.0F, i, 0.0F, 0.0F, j, i, j });
    }
    super.setImageDrawable(paramDrawable);
    AppMethodBeat.o(76129);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(76126);
    s.u(paramb, "stateResolve");
    this.NTQ = paramb;
    AppMethodBeat.o(76126);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(76125);
    s.u(paramRect, "validRect");
    this.NTO.set(paramRect);
    AppMethodBeat.o(76125);
  }
  
  public final void setViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(76124);
    if (s.p(this.NXY, paramMatrix))
    {
      AppMethodBeat.o(76124);
      return;
    }
    if (paramMatrix != null) {
      this.yiZ.setMatrix(paramMatrix);
    }
    AppMethodBeat.o(76124);
  }
  
  public final boolean tA(long paramLong)
  {
    AppMethodBeat.i(280474);
    boolean bool = d.a.a(this, paramLong);
    AppMethodBeat.o(280474);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Matrix, Boolean, ah>
  {
    a(f paramf, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.f
 * JD-Core Version:    0.7.0.1
 */