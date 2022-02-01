package com.tencent.mm.view.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/board/MultiTalkBoardView;", "Lcom/tencent/mm/view/board/BaseBoardView;", "context", "Landroid/content/Context;", "presenter", "Lcom/tencent/mm/presenter/IPresenter;", "(Landroid/content/Context;Lcom/tencent/mm/presenter/IPresenter;)V", "callback", "Lkotlin/Function0;", "", "isLockRefresh", "", "mBaseScale", "", "mBaseTranslateX", "mBaseTranslateY", "mFilePath", "", "mFileToken", "mSlidForbidden", "clearScreen", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getMinScale", "isCanAdapted", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSelfTouch", "onSizeChanged", "w", "", "h", "oldw", "oldh", "onViewStatusChange", "zoom", "transX", "transY", "refreshEditLayout", "setEnableToResponseSlid", "enable", "setScreenFileParams", "filePath", "fileToken", "Companion", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final b.a agKU;
  public boolean agKV;
  private float agKW;
  private float agKX;
  private float agKY;
  private boolean agKZ;
  private String agLa;
  public kotlin.g.a.a<ah> callback;
  private String mFilePath;
  
  static
  {
    AppMethodBeat.i(234822);
    agKU = new b.a((byte)0);
    AppMethodBeat.o(234822);
  }
  
  public b(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(234819);
    this.agKW = 1.0F;
    this.agKC = this.hoS;
    this.agKL = false;
    AppMethodBeat.o(234819);
  }
  
  protected final void aL(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234854);
    s.u(paramMotionEvent, "event");
    AppMethodBeat.o(234854);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(234825);
    if (getPresenter().iPv()) {
      aM(paramMotionEvent);
    }
    getPresenter().Z(paramMotionEvent);
    if (this.agKZ) {
      j.b(this.agLa, this.mFilePath, paramMotionEvent);
    }
    boolean bool = this.agKZ;
    AppMethodBeat.o(234825);
    return bool;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(234860);
    if (getPresenter().iPp().aEy() == com.tencent.mm.e.a.hoN)
    {
      int i = getBoardRect().width() / getRawLayoutRect().width();
      int j = getBoardRect().height() / getRawLayoutRect().height();
      if (i > j) {}
      for (;;)
      {
        f1 = i;
        float f2 = getCurScale();
        AppMethodBeat.o(234860);
        return f1 * f2;
        i = j;
      }
    }
    float f1 = super.getMinScale();
    AppMethodBeat.o(234860);
    return f1;
  }
  
  public final void i(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234829);
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(this.agKW * paramFloat, this.agKW * paramFloat, 0.0F, 0.0F);
    localMatrix.postTranslate(paramInt1, paramInt2);
    this.agKC = localMatrix;
    invalidate();
    AppMethodBeat.o(234829);
  }
  
  public final boolean jMO()
  {
    return true;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(234849);
    s.u(paramCanvas, "canvas");
    if (this.agKC != null)
    {
      this.hoS.set(this.agKC);
      paramCanvas.setMatrix(this.agKC);
    }
    for (;;)
    {
      Bitmap localBitmap = getPresenter().iPu();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      }
      getPresenter().onDraw(paramCanvas);
      if (this.agKV)
      {
        this.agKV = false;
        paramCanvas = this.callback;
        if (paramCanvas != null) {
          paramCanvas.invoke();
        }
      }
      AppMethodBeat.o(234849);
      return;
      paramCanvas.setMatrix(getMainMatrix());
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234838);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.MultiTalkBoardView", "onSizeChanged " + getRawLayoutRect().flattenToString() + ", " + paramInt1 + ',' + paramInt3);
    Rect localRect;
    float f;
    if (getRawLayoutRect() != null)
    {
      localRect = getRawLayoutRect();
      s.checkNotNull(localRect);
      f = localRect.width();
      localRect = getRawLayoutRect();
      s.checkNotNull(localRect);
      if (f * 1.0F / localRect.height() <= getWidth() * 1.0F / getHeight()) {
        break label213;
      }
      f = getWidth();
      localRect = getRawLayoutRect();
      s.checkNotNull(localRect);
      this.agKW = (f * 1.0F / (localRect.width() * 1.0F));
      this.agKX = 0.0F;
      f = getHeight();
      localRect = getRawLayoutRect();
      s.checkNotNull(localRect);
    }
    for (this.agKY = ((f - localRect.height() * this.agKW) / 2.0F);; this.agKY = 0.0F)
    {
      invalidate();
      AppMethodBeat.o(234838);
      return;
      label213:
      f = getHeight();
      localRect = getRawLayoutRect();
      s.checkNotNull(localRect);
      this.agKW = (f * 1.0F / (localRect.height() * 1.0F));
      f = getWidth();
      localRect = getRawLayoutRect();
      s.checkNotNull(localRect);
      this.agKX = ((f - localRect.width() * this.agKW) / 2.0F);
    }
  }
  
  public final void setEnableToResponseSlid(boolean paramBoolean)
  {
    this.agKZ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.b.b
 * JD-Core Version:    0.7.0.1
 */