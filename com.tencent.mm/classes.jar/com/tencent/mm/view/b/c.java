package com.tencent.mm.view.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends a
{
  private d agLb;
  private PointF agLc;
  private float agLd;
  private boolean agLe;
  public boolean agLf;
  private float sUk;
  
  public c(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9394);
    this.agLb = new d(this);
    this.agLc = new PointF();
    this.agLd = 0.0F;
    this.sUk = 0.0F;
    this.agLe = false;
    this.agLf = false;
    AppMethodBeat.o(9394);
  }
  
  private void A(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9397);
    RectF localRectF = getCurImageRect();
    float f2 = paramFloat1 - this.agLc.x;
    float f1 = paramFloat2 - this.agLc.y;
    if (f2 > 0.0F) {
      if (getBoardRect().left <= localRectF.left)
      {
        paramFloat1 = f2 * 0.5F;
        if (f1 <= 0.0F) {
          break label273;
        }
        if (getBoardRect().top > localRectF.top) {
          break label228;
        }
        paramFloat2 = f1 * 0.5F;
      }
    }
    for (;;)
    {
      getMainMatrix().postTranslate(paramFloat1, paramFloat2);
      AppMethodBeat.o(9397);
      return;
      paramFloat1 = f2;
      if (Math.abs(f2) <= Math.abs(localRectF.left - getBoardRect().left)) {
        break;
      }
      paramFloat1 = getBoardRect().left - localRectF.left;
      break;
      if (getBoardRect().right >= localRectF.right)
      {
        paramFloat1 = f2 * 0.5F;
        break;
      }
      paramFloat1 = f2;
      if (Math.abs(f2) <= Math.abs(getBoardRect().right - localRectF.right)) {
        break;
      }
      paramFloat1 = getBoardRect().right - localRectF.right;
      break;
      label228:
      paramFloat2 = f1;
      if (Math.abs(f1) > Math.abs(localRectF.top - getBoardRect().top))
      {
        paramFloat2 = getBoardRect().top - localRectF.top;
        continue;
        label273:
        if (getBoardRect().bottom >= localRectF.bottom)
        {
          paramFloat2 = f1 * 0.5F;
        }
        else
        {
          paramFloat2 = f1;
          if (Math.abs(f1) > Math.abs(getBoardRect().bottom - localRectF.bottom)) {
            paramFloat2 = getBoardRect().bottom - localRectF.bottom;
          }
        }
      }
    }
  }
  
  protected final void aL(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9396);
    float f3 = paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
    float f4 = paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
    if (!getPresenter().iPl())
    {
      AppMethodBeat.o(9396);
      return;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      this.agLc.x = f3;
      this.agLc.y = f4;
      AppMethodBeat.o(9396);
      return;
      this.agLc.set(f3, f4);
      this.agLd = 0.0F;
      this.sUk = getCurScale();
      paramMotionEvent = this.agLb;
      Log.d("MicroMsg.StickRoundAnim", "[cancel]");
      if ((paramMotionEvent.hbU != null) && ((paramMotionEvent.hbU.isRunning()) || (paramMotionEvent.hbU.isStarted()))) {
        paramMotionEvent.hbU.cancel();
      }
      this.agLf = false;
      continue;
      this.agLd = 0.0F;
      if (this.agLf)
      {
        this.agLb.play();
        continue;
        this.agLd = 0.0F;
        this.sUk = getCurScale();
        continue;
        this.agLd = 0.0F;
        this.agLe = true;
        continue;
        if (this.agLe)
        {
          this.agLe = false;
          AppMethodBeat.o(9396);
          return;
        }
        if (paramMotionEvent.getPointerCount() == 2)
        {
          this.agLf = true;
          float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
          float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
          f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
          if (this.agLd == 0.0F)
          {
            this.agLd = f1;
          }
          else
          {
            f2 = f1 / this.agLd * this.sUk;
            if (this.agKJ * 0.5F <= f2)
            {
              f1 = f2;
              if (f2 > this.agHA)
              {
                f1 = this.agHA;
                f1 = (f2 - this.agHA) * 0.2F + f1;
              }
              getMainMatrix().postScale(f1 / getCurScale(), f1 / getCurScale(), f3, f4);
            }
            this.agLb.hcg = true;
            A(f3, f4);
            postInvalidate();
          }
        }
        else if ((paramMotionEvent.getPointerCount() == 1) && (jMN()))
        {
          this.agLf = true;
          this.agLb.hcg = true;
          A(f3, f4);
          postInvalidate();
        }
      }
    }
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(9398);
    if (getPresenter().iPp().aEy() == com.tencent.mm.e.a.hoN)
    {
      f1 = getBoardRect().width() / getCurImageRect().width();
      float f2 = getBoardRect().height() / getCurImageRect().height();
      if (f1 > f2) {}
      for (;;)
      {
        f2 = getCurScale();
        AppMethodBeat.o(9398);
        return f1 * f2;
        f1 = f2;
      }
    }
    float f1 = super.getMinScale();
    AppMethodBeat.o(9398);
    return f1;
  }
  
  public final boolean jMO()
  {
    return true;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(234844);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(234844);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9395);
    paramCanvas.drawColor(-16777216);
    if (this.agKC != null)
    {
      this.hoS.set(this.agKC);
      paramCanvas.setMatrix(this.agKC);
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(getAliveRect());
      Bitmap localBitmap = getPresenter().iPu();
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
      }
      paramCanvas.restore();
      getPresenter().onDraw(paramCanvas);
      AppMethodBeat.o(9395);
      return;
      paramCanvas.setMatrix(getMainMatrix());
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234848);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.agLb.hcg = true;
      this.agLb.play();
    }
    AppMethodBeat.o(234848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.view.b.c
 * JD-Core Version:    0.7.0.1
 */