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
  private d YPo;
  private PointF YPp;
  private float YPq;
  private boolean YPr;
  public boolean YPs;
  private float pPK;
  
  public c(Context paramContext, com.tencent.mm.ca.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(9394);
    this.YPo = new d(this);
    this.YPp = new PointF();
    this.YPq = 0.0F;
    this.pPK = 0.0F;
    this.YPr = false;
    this.YPs = false;
    AppMethodBeat.o(9394);
  }
  
  private void aC(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9397);
    RectF localRectF = getCurImageRect();
    float f2 = paramFloat1 - this.YPp.x;
    float f1 = paramFloat2 - this.YPp.y;
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
  
  protected final void aI(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9396);
    float f4 = paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
    float f5 = paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
    if (!getPresenter().hor())
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
            this.YPp.x = f4;
            this.YPp.y = f5;
            AppMethodBeat.o(9396);
            return;
            this.YPp.set(f4, f5);
            this.YPq = 0.0F;
            this.pPK = getCurScale();
            paramMotionEvent = this.YPo;
            Log.d("MicroMsg.StickRoundAnim", "[cancel]");
            if ((paramMotionEvent.eYu != null) && ((paramMotionEvent.eYu.isRunning()) || (paramMotionEvent.eYu.isStarted()))) {
              paramMotionEvent.eYu.cancel();
            }
            this.YPs = false;
          }
          this.YPq = 0.0F;
        } while (!this.YPs);
        paramMotionEvent = this.YPo;
      } while (!paramMotionEvent.eYG);
      Log.d("MicroMsg.StickRoundAnim", "[play] start");
      localRectF = paramMotionEvent.eYN.getCurImageRect();
      localRect = paramMotionEvent.eYN.getBoardRect();
      paramMotionEvent.eYP = localRectF.centerX();
      paramMotionEvent.eYQ = localRectF.centerY();
      f2 = localRect.centerY() - localRectF.centerY();
      f1 = localRect.centerX() - localRectF.centerX();
      f6 = paramMotionEvent.eYN.getCurScale();
      f7 = paramMotionEvent.eYN.getMaxScale();
      f3 = paramMotionEvent.eYN.getMinScale();
      if (f6 > f7)
      {
        paramMotionEvent.eYO = f7;
        paramMotionEvent.eYR = true;
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
      for (paramMotionEvent.eYS = true;; paramMotionEvent.eYS = false)
      {
        paramMotionEvent.eYu = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, f2 }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, f3 }), PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 80.0F }) });
        paramMotionEvent.eYu.addUpdateListener(new d.1(paramMotionEvent, f6));
        paramMotionEvent.eYu.addListener(new d.2(paramMotionEvent));
        paramMotionEvent.eYu.setInterpolator(new LinearInterpolator());
        paramMotionEvent.eYu.setDuration(80L);
        paramMotionEvent.eYu.start();
        break;
        if (f6 < f3)
        {
          paramMotionEvent.eYO = f3;
          paramMotionEvent.eYR = true;
          break label338;
        }
        paramMotionEvent.eYR = false;
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
      this.YPq = 0.0F;
      this.pPK = getCurScale();
      break;
      this.YPq = 0.0F;
      this.YPr = true;
      break;
      if (this.YPr)
      {
        this.YPr = false;
        AppMethodBeat.o(9396);
        return;
      }
      if (paramMotionEvent.getPointerCount() == 2)
      {
        this.YPs = true;
        f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.YPq == 0.0F)
        {
          this.YPq = f1;
          break;
        }
        f2 = f1 / this.YPq * this.pPK;
        if (this.YOW * 0.5F <= f2)
        {
          f1 = f2;
          if (f2 > this.YLO)
          {
            f1 = this.YLO;
            f1 = (f2 - this.YLO) * 0.2F + f1;
          }
          getMainMatrix().postScale(f1 / getCurScale(), f1 / getCurScale(), f4, f5);
        }
        this.YPo.eYG = true;
        aC(f4, f5);
        postInvalidate();
        break;
      }
      if ((paramMotionEvent.getPointerCount() != 1) || (!ihA())) {
        break;
      }
      this.YPs = true;
      this.YPo.eYG = true;
      aC(f4, f5);
      postInvalidate();
      break;
    }
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(9398);
    if (getPresenter().hov().acy() == com.tencent.mm.e.a.fkA)
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
  
  public final boolean ihB()
  {
    return true;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9395);
    paramCanvas.drawColor(-16777216);
    if (this.YOQ != null)
    {
      this.fkF.set(this.YOQ);
      paramCanvas.setMatrix(this.YOQ);
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(getAliveRect());
      Bitmap localBitmap = getPresenter().hoy();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.b.c
 * JD-Core Version:    0.7.0.1
 */