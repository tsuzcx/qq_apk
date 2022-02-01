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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/board/MultiTalkBoardView;", "Lcom/tencent/mm/view/board/BaseBoardView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "(Landroid/content/Context;Lcom/tencent/mm/presenter/IPresenter;)V", "callback", "Lkotlin/Function0;", "", "isLockRefresh", "", "mBaseScale", "", "mBaseTranslateX", "mBaseTranslateY", "mFilePath", "", "mFileToken", "mSlidForbidden", "clearScreen", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getMinScale", "isCanAdapted", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSelfTouch", "onSizeChanged", "w", "", "h", "oldw", "oldh", "onViewStatusChange", "zoom", "transX", "transY", "refreshEditLayout", "setEnableToResponseSlid", "enable", "setScreenFileParams", "filePath", "fileToken", "Companion", "plugin-photoedit-sdk_release"})
public final class b
  extends a
{
  public static final b.a RnS;
  public boolean RnM;
  private float RnN;
  private float RnO;
  private float RnP;
  private boolean RnQ;
  private String RnR;
  private String mFilePath;
  public kotlin.g.a.a<x> uGD;
  
  static
  {
    AppMethodBeat.i(204712);
    RnS = new b.a((byte)0);
    AppMethodBeat.o(204712);
  }
  
  public b(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(204711);
    this.RnN = 1.0F;
    this.Rnv = this.drT;
    this.RnD = false;
    AppMethodBeat.o(204711);
  }
  
  protected final void aA(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204709);
    p.h(paramMotionEvent, "event");
    AppMethodBeat.o(204709);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204705);
    com.tencent.mm.bt.b localb = getPresenter();
    p.g(localb, "presenter");
    if (localb.gtn()) {
      aB(paramMotionEvent);
    }
    getPresenter().R(paramMotionEvent);
    if (this.RnQ) {
      h.b(this.RnR, this.mFilePath, paramMotionEvent);
    }
    boolean bool = this.RnQ;
    AppMethodBeat.o(204705);
    return bool;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(204710);
    com.tencent.mm.e.b localb = getPresenter().gti();
    p.g(localb, "presenter.getCurArtist<BaseArtist<*>>()");
    if (localb.XS() == com.tencent.mm.e.a.drO)
    {
      int i = getBoardRect().width() / getRawLayoutRect().width();
      int j = getBoardRect().height() / getRawLayoutRect().height();
      if (i > j) {}
      for (;;)
      {
        f1 = i;
        float f2 = getCurScale();
        AppMethodBeat.o(204710);
        return f1 * f2;
        i = j;
      }
    }
    float f1 = super.getMinScale();
    AppMethodBeat.o(204710);
    return f1;
  }
  
  public final void h(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204706);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(this.RnN * paramFloat, this.RnN * paramFloat, 0.0F, 0.0F);
    localMatrix.postTranslate(paramInt1, paramInt2);
    this.Rnv = localMatrix;
    invalidate();
    AppMethodBeat.o(204706);
  }
  
  public final boolean hgb()
  {
    return true;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(204708);
    p.h(paramCanvas, "canvas");
    if (this.Rnv != null)
    {
      this.drT.set(this.Rnv);
      paramCanvas.setMatrix(this.Rnv);
    }
    for (;;)
    {
      Object localObject = getPresenter();
      p.g(localObject, "presenter");
      localObject = ((com.tencent.mm.bt.b)localObject).gtm();
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
      }
      getPresenter().onDraw(paramCanvas);
      if (!this.RnM) {
        break;
      }
      this.RnM = false;
      paramCanvas = this.uGD;
      if (paramCanvas == null) {
        break;
      }
      paramCanvas.invoke();
      AppMethodBeat.o(204708);
      return;
      paramCanvas.setMatrix(getMainMatrix());
    }
    AppMethodBeat.o(204708);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204707);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.MultiTalkBoardView", "onSizeChanged " + getRawLayoutRect().flattenToString() + ", " + paramInt1 + ',' + paramInt3);
    Rect localRect;
    float f;
    if (getRawLayoutRect() != null)
    {
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.hyc();
      }
      f = localRect.width();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.hyc();
      }
      if (f * 1.0F / localRect.height() <= getWidth() * 1.0F / getHeight()) {
        break label226;
      }
      f = getWidth();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.hyc();
      }
      this.RnN = (f * 1.0F / (localRect.width() * 1.0F));
      this.RnO = 0.0F;
      f = getHeight();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.hyc();
      }
    }
    for (this.RnP = ((f - localRect.height() * this.RnN) / 2.0F);; this.RnP = 0.0F)
    {
      invalidate();
      AppMethodBeat.o(204707);
      return;
      label226:
      f = getHeight();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.hyc();
      }
      this.RnN = (f * 1.0F / (localRect.height() * 1.0F));
      f = getWidth();
      localRect = getRawLayoutRect();
      if (localRect == null) {
        p.hyc();
      }
      this.RnO = ((f - localRect.width() * this.RnN) / 2.0F);
    }
  }
  
  public final void setEnableToResponseSlid(boolean paramBoolean)
  {
    this.RnQ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.b.b
 * JD-Core Version:    0.7.0.1
 */