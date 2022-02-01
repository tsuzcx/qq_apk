package com.tencent.mm.view.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.d;
import com.tencent.mm.c.d.1;
import com.tencent.mm.c.d.2;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  extends a
{
  private d RnT;
  private PointF RnU;
  private float RnV;
  private boolean RnW;
  public boolean RnX;
  private float mOR;
  
  public c(Context paramContext, com.tencent.mm.bt.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9394);
    this.RnT = new d(this);
    this.RnU = new PointF();
    this.RnV = 0.0F;
    this.mOR = 0.0F;
    this.RnW = false;
    this.RnX = false;
    AppMethodBeat.o(9394);
  }
  
  private void translate(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9397);
    RectF localRectF = getCurImageRect();
    float f2 = paramFloat1 - this.RnU.x;
    float f1 = paramFloat2 - this.RnU.y;
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
  
  protected final void aA(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9396);
    float f4 = paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
    float f5 = paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
    if (!getPresenter().gte())
    {
      AppMethodBeat.o(9396);
      return;
    }
    RectF localRectF;
    Rect localRect;
    float f2;
    float f1;
    float f6;
    float f7;
    float f3;
    label338:
    int i;
    label356:
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          for (;;)
          {
            this.RnU.x = f4;
            this.RnU.y = f5;
            AppMethodBeat.o(9396);
            return;
            this.RnU.set(f4, f5);
            this.RnV = 0.0F;
            this.mOR = getCurScale();
            paramMotionEvent = this.RnT;
            Log.d("MicroMsg.StickRoundAnim", "[cancel]");
            if ((paramMotionEvent.dgN != null) && ((paramMotionEvent.dgN.isRunning()) || (paramMotionEvent.dgN.isStarted()))) {
              paramMotionEvent.dgN.cancel();
            }
            this.RnX = false;
          }
          this.RnV = 0.0F;
        } while (!this.RnX);
        paramMotionEvent = this.RnT;
      } while (!paramMotionEvent.dgZ);
      Log.d("MicroMsg.StickRoundAnim", "[play] start");
      localRectF = paramMotionEvent.dhg.getCurImageRect();
      localRect = paramMotionEvent.dhg.getBoardRect();
      paramMotionEvent.dhi = localRectF.centerX();
      paramMotionEvent.dhj = localRectF.centerY();
      f2 = localRect.centerY() - localRectF.centerY();
      f1 = localRect.centerX() - localRectF.centerX();
      f6 = paramMotionEvent.dhg.getCurScale();
      f7 = paramMotionEvent.dhg.getMaxScale();
      f3 = paramMotionEvent.dhg.getMinScale();
      if (f6 > f7)
      {
        paramMotionEvent.dhh = f7;
        paramMotionEvent.dhk = true;
        if (localRect.height() >= localRectF.height()) {
          break label661;
        }
        i = 1;
        if (localRect.width() >= localRectF.width()) {
          break label667;
        }
        j = 1;
        label374:
        if (i != 0) {
          f2 = 0.0F;
        }
        if (j != 0) {
          f1 = 0.0F;
        }
        if ((localRectF.top <= localRect.top) || (i == 0)) {
          break label673;
        }
        f2 = localRect.top - localRectF.top;
      }
      break;
    }
    label421:
    label455:
    label752:
    label1018:
    for (;;)
    {
      if ((localRectF.left > localRect.left) && (j != 0))
      {
        f3 = localRect.left - localRectF.left;
        Log.d("MicroMsg.StickRoundAnim", "%s %s ", new Object[] { Float.valueOf(f3), Float.valueOf(f2) });
        if (f6 <= f7) {
          break label752;
        }
      }
      for (paramMotionEvent.dhl = true;; paramMotionEvent.dhl = false)
      {
        paramMotionEvent.dgN = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, f2 }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, f3 }), PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 80.0F }) });
        paramMotionEvent.dgN.addUpdateListener(new d.1(paramMotionEvent, f6));
        paramMotionEvent.dgN.addListener(new d.2(paramMotionEvent));
        paramMotionEvent.dgN.setInterpolator(new LinearInterpolator());
        paramMotionEvent.dgN.setDuration(80L);
        paramMotionEvent.dgN.start();
        break;
        if (f6 < f3)
        {
          paramMotionEvent.dhh = f3;
          paramMotionEvent.dhk = true;
          break label338;
        }
        paramMotionEvent.dhk = false;
        break label338;
        i = 0;
        break label356;
        j = 0;
        break label374;
        if ((localRectF.bottom >= localRect.bottom) || (i == 0)) {
          break label1018;
        }
        f2 = localRect.bottom - localRectF.bottom;
        break label421;
        f3 = f1;
        if (localRectF.right >= localRect.right) {
          break label455;
        }
        f3 = f1;
        if (j == 0) {
          break label455;
        }
        f3 = localRect.right - localRectF.right;
        break label455;
      }
      this.RnV = 0.0F;
      this.mOR = getCurScale();
      break;
      this.RnV = 0.0F;
      this.RnW = true;
      break;
      if (this.RnW)
      {
        this.RnW = false;
        AppMethodBeat.o(9396);
        return;
      }
      if (paramMotionEvent.getPointerCount() == 2)
      {
        this.RnX = true;
        f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.RnV == 0.0F)
        {
          this.RnV = f1;
          break;
        }
        f2 = f1 / this.RnV * this.mOR;
        if (this.RnB * 0.5F <= f2)
        {
          f1 = f2;
          if (f2 > this.Rkj)
          {
            f1 = this.Rkj;
            f1 = (f2 - this.Rkj) * 0.2F + f1;
          }
          getMainMatrix().postScale(f1 / getCurScale(), f1 / getCurScale(), f4, f5);
        }
        this.RnT.dgZ = true;
        translate(f4, f5);
        postInvalidate();
        break;
      }
      if ((paramMotionEvent.getPointerCount() != 1) || (!hga())) {
        break;
      }
      this.RnX = true;
      this.RnT.dgZ = true;
      translate(f4, f5);
      postInvalidate();
      break;
    }
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(9398);
    if (getPresenter().gti().XS() == com.tencent.mm.e.a.drO)
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
  
  public final boolean hgb()
  {
    return true;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9395);
    paramCanvas.drawColor(-16777216);
    if (this.Rnv != null)
    {
      this.drT.set(this.Rnv);
      paramCanvas.setMatrix(this.Rnv);
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(getAliveRect());
      Bitmap localBitmap = getPresenter().gtm();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.b.c
 * JD-Core Version:    0.7.0.1
 */