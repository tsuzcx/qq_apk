package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.h;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/board/MultiTalkBoardView;", "Lcom/tencent/mm/view/board/BaseBoardView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "(Landroid/content/Context;Lcom/tencent/mm/presenter/IPresenter;)V", "callback", "Lkotlin/Function0;", "", "isLockRefresh", "", "mBaseScale", "", "mBaseTranslateX", "mBaseTranslateY", "mFilePath", "", "mFileToken", "mSlidForbidden", "clearScreen", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getMinScale", "isCanAdapted", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSelfTouch", "onSizeChanged", "w", "", "h", "oldw", "oldh", "onViewStatusChange", "zoom", "transX", "transY", "refreshEditLayout", "setEnableToResponseSlid", "enable", "setScreenFileParams", "filePath", "fileToken", "Companion", "plugin-photoedit-sdk_release"})
public final class b
  extends a
{
  public static final a YPn;
  public boolean YPh;
  private float YPi;
  private float YPj;
  private float YPk;
  private boolean YPl;
  private String YPm;
  private String mFilePath;
  public kotlin.g.a.a<x> zoa;
  
  static
  {
    AppMethodBeat.i(260171);
    YPn = new a((byte)0);
    AppMethodBeat.o(260171);
  }
  
  public b(Context paramContext, com.tencent.mm.ca.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(260170);
    this.YPi = 1.0F;
    this.YOQ = this.fkF;
    this.YOY = false;
    AppMethodBeat.o(260170);
  }
  
  protected final void aI(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(260168);
    p.k(paramMotionEvent, "event");
    AppMethodBeat.o(260168);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(260164);
    com.tencent.mm.ca.b localb = getPresenter();
    p.j(localb, "presenter");
    if (localb.hoz()) {
      aJ(paramMotionEvent);
    }
    getPresenter().X(paramMotionEvent);
    if (this.YPl) {
      h.b(this.YPm, this.mFilePath, paramMotionEvent);
    }
    boolean bool = this.YPl;
    AppMethodBeat.o(260164);
    return bool;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(260169);
    com.tencent.mm.e.b localb = getPresenter().hov();
    p.j(localb, "presenter.getCurArtist<BaseArtist<*>>()");
    if (localb.acy() == com.tencent.mm.e.a.fkA)
    {
      int i = getBoardRect().width() / getRawLayoutRect().width();
      int j = getBoardRect().height() / getRawLayoutRect().height();
      if (i > j) {}
      for (;;)
      {
        f1 = i;
        float f2 = getCurScale();
        AppMethodBeat.o(260169);
        return f1 * f2;
        i = j;
      }
    }
    float f1 = super.getMinScale();
    AppMethodBeat.o(260169);
    return f1;
  }
  
  public final void h(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(260165);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(this.YPi * paramFloat, this.YPi * paramFloat, 0.0F, 0.0F);
    localMatrix.postTranslate(paramInt1, paramInt2);
    this.YOQ = localMatrix;
    invalidate();
    AppMethodBeat.o(260165);
  }
  
  public final boolean ihB()
  {
    return true;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(260167);
    p.k(paramCanvas, "canvas");
    if (this.YOQ != null)
    {
      this.fkF.set(this.YOQ);
      paramCanvas.setMatrix(this.YOQ);
    }
    for (;;)
    {
      Object localObject = getPresenter();
      p.j(localObject, "presenter");
      localObject = ((com.tencent.mm.ca.b)localObject).hoy();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
      }
      getPresenter().onDraw(paramCanvas);
      if (!this.YPh) {
        break;
      }
      this.YPh = false;
      paramCanvas = this.zoa;
      if (paramCanvas == null) {
        break;
      }
      paramCanvas.invoke();
      AppMethodBeat.o(260167);
      return;
      paramCanvas.setMatrix(getMainMatrix());
    }
    AppMethodBeat.o(260167);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(260166);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.MultiTalkBoardView", "onSizeChanged " + getRawLayoutRect().flattenToString() + ", " + paramInt1 + ',' + paramInt3);
    Rect localRect;
    float f;
    if (getRawLayoutRect() != null)
    {
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.iCn();
      }
      f = localRect.width();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.iCn();
      }
      if (f * 1.0F / localRect.height() <= getWidth() * 1.0F / getHeight()) {
        break label227;
      }
      f = getWidth();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.iCn();
      }
      this.YPi = (f * 1.0F / (localRect.width() * 1.0F));
      this.YPj = 0.0F;
      f = getHeight();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.iCn();
      }
    }
    for (this.YPk = ((f - localRect.height() * this.YPi) / 2.0F);; this.YPk = 0.0F)
    {
      invalidate();
      AppMethodBeat.o(260166);
      return;
      label227:
      f = getHeight();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.iCn();
      }
      this.YPi = (f * 1.0F / (localRect.height() * 1.0F));
      f = getWidth();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.iCn();
      }
      this.YPj = ((f - localRect.width() * this.YPi) / 2.0F);
    }
  }
  
  public final void setEnableToResponseSlid(boolean paramBoolean)
  {
    this.YPl = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/board/MultiTalkBoardView$Companion;", "", "()V", "TAG", "", "plugin-photoedit-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.b.b
 * JD-Core Version:    0.7.0.1
 */