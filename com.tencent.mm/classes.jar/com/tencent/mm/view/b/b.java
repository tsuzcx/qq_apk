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
import com.tencent.mm.b.d;
import com.tencent.mm.b.d.1;
import com.tencent.mm.b.d.2;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
  extends a
{
  private d ASQ;
  private PointF ASR;
  private float ASS;
  private float AST;
  private boolean ASU;
  public boolean ASV;
  
  public b(Context paramContext, com.tencent.mm.bs.b paramb)
  {
    super(paramContext, paramb);
    AppMethodBeat.i(116416);
    this.ASQ = new d(this);
    this.ASR = new PointF();
    this.ASS = 0.0F;
    this.AST = 0.0F;
    this.ASU = false;
    this.ASV = false;
    AppMethodBeat.o(116416);
  }
  
  private void translate(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(116419);
    RectF localRectF = getCurImageRect();
    float f2 = paramFloat1 - this.ASR.x;
    float f1 = paramFloat2 - this.ASR.y;
    if (f2 > 0.0F) {
      if (getBoardRect().left <= localRectF.left)
      {
        paramFloat1 = f2 * 0.5F;
        if (f1 <= 0.0F) {
          break label271;
        }
        if (getBoardRect().top > localRectF.top) {
          break label226;
        }
        paramFloat2 = f1 * 0.5F;
      }
    }
    for (;;)
    {
      getMainMatrix().postTranslate(paramFloat1, paramFloat2);
      AppMethodBeat.o(116419);
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
      label226:
      paramFloat2 = f1;
      if (Math.abs(f1) > Math.abs(localRectF.top - getBoardRect().top))
      {
        paramFloat2 = getBoardRect().top - localRectF.top;
        continue;
        label271:
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
  
  protected final void aa(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(116418);
    float f4 = paramMotionEvent.getX(paramMotionEvent.getPointerCount() - 1);
    float f5 = paramMotionEvent.getY(paramMotionEvent.getPointerCount() - 1);
    RectF localRectF;
    Rect localRect;
    float f2;
    float f1;
    float f6;
    float f7;
    float f3;
    label317:
    int i;
    label335:
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
            this.ASR.x = f4;
            this.ASR.y = f5;
            AppMethodBeat.o(116418);
            return;
            this.ASR.set(f4, f5);
            this.ASS = 0.0F;
            this.AST = getCurScale();
            paramMotionEvent = this.ASQ;
            ab.d("MicroMsg.StickRoundAnim", "[cancel]");
            if ((paramMotionEvent.kO != null) && ((paramMotionEvent.kO.isRunning()) || (paramMotionEvent.kO.isStarted()))) {
              paramMotionEvent.kO.cancel();
            }
            this.ASV = false;
          }
          this.ASS = 0.0F;
        } while (!this.ASV);
        paramMotionEvent = this.ASQ;
      } while (!paramMotionEvent.bVC);
      ab.d("MicroMsg.StickRoundAnim", "[play] start");
      localRectF = paramMotionEvent.bVK.getCurImageRect();
      localRect = paramMotionEvent.bVK.getBoardRect();
      paramMotionEvent.bVL = localRectF.centerX();
      paramMotionEvent.bVM = localRectF.centerY();
      f2 = localRect.centerY() - localRectF.centerY();
      f1 = localRect.centerX() - localRectF.centerX();
      f6 = paramMotionEvent.bVK.getCurScale();
      f7 = paramMotionEvent.bVK.getMaxScale();
      f3 = paramMotionEvent.bVK.getMinScale();
      if (f6 > f7)
      {
        paramMotionEvent.mScale = f7;
        paramMotionEvent.bVN = true;
        if (localRect.height() >= localRectF.height()) {
          break label640;
        }
        i = 1;
        if (localRect.width() >= localRectF.width()) {
          break label646;
        }
        j = 1;
        label353:
        if (i != 0) {
          f2 = 0.0F;
        }
        if (j != 0) {
          f1 = 0.0F;
        }
        if ((localRectF.top <= localRect.top) || (i == 0)) {
          break label652;
        }
        f2 = localRect.top - localRectF.top;
      }
      break;
    }
    label400:
    label434:
    label731:
    label996:
    for (;;)
    {
      if ((localRectF.left > localRect.left) && (j != 0))
      {
        f3 = localRect.left - localRectF.left;
        ab.d("MicroMsg.StickRoundAnim", "%s %s ", new Object[] { Float.valueOf(f3), Float.valueOf(f2) });
        if (f6 <= f7) {
          break label731;
        }
      }
      for (paramMotionEvent.bVO = true;; paramMotionEvent.bVO = false)
      {
        paramMotionEvent.kO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { 0.0F, f2 }), PropertyValuesHolder.ofFloat("deltaX", new float[] { 0.0F, f3 }), PropertyValuesHolder.ofFloat("scale", new float[] { 0.0F, 80.0F }) });
        paramMotionEvent.kO.addUpdateListener(new d.1(paramMotionEvent, f6));
        paramMotionEvent.kO.addListener(new d.2(paramMotionEvent));
        paramMotionEvent.kO.setInterpolator(new LinearInterpolator());
        paramMotionEvent.kO.setDuration(80L);
        paramMotionEvent.kO.start();
        break;
        if (f6 < f3)
        {
          paramMotionEvent.mScale = f3;
          paramMotionEvent.bVN = true;
          break label317;
        }
        paramMotionEvent.bVN = false;
        break label317;
        i = 0;
        break label335;
        j = 0;
        break label353;
        if ((localRectF.bottom >= localRect.bottom) || (i == 0)) {
          break label996;
        }
        f2 = localRect.bottom - localRectF.bottom;
        break label400;
        f3 = f1;
        if (localRectF.right >= localRect.right) {
          break label434;
        }
        f3 = f1;
        if (j == 0) {
          break label434;
        }
        f3 = localRect.right - localRectF.right;
        break label434;
      }
      this.ASS = 0.0F;
      this.AST = getCurScale();
      break;
      this.ASS = 0.0F;
      this.ASU = true;
      break;
      if (this.ASU)
      {
        this.ASU = false;
        AppMethodBeat.o(116418);
        return;
      }
      if (paramMotionEvent.getPointerCount() == 2)
      {
        this.ASV = true;
        f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
        f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
        f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.ASS == 0.0F)
        {
          this.ASS = f1;
          break;
        }
        f2 = f1 / this.ASS * this.AST;
        if (this.ASH * 0.5F <= f2)
        {
          f1 = f2;
          if (f2 > this.ASG)
          {
            f1 = this.ASG;
            f1 = (f2 - this.ASG) * 0.2F + f1;
          }
          getMainMatrix().postScale(f1 / getCurScale(), f1 / getCurScale(), f4, f5);
        }
        this.ASQ.bVC = true;
        translate(f4, f5);
        postInvalidate();
        break;
      }
      if ((paramMotionEvent.getPointerCount() != 1) || (!dQR())) {
        break;
      }
      this.ASV = true;
      this.ASQ.bVC = true;
      translate(f4, f5);
      postInvalidate();
      break;
    }
  }
  
  public final boolean dQS()
  {
    return true;
  }
  
  public final float getMinScale()
  {
    AppMethodBeat.i(116420);
    if (getPresenter().dqd().Cz() == com.tencent.mm.e.a.ccP)
    {
      f1 = getBoardRect().width() / getCurImageRect().width();
      float f2 = getBoardRect().height() / getCurImageRect().height();
      if (f1 > f2) {}
      for (;;)
      {
        f2 = getCurScale();
        AppMethodBeat.o(116420);
        return f1 * f2;
        f1 = f2;
      }
    }
    float f1 = super.getMinScale();
    AppMethodBeat.o(116420);
    return f1;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116417);
    paramCanvas.drawColor(-16777216);
    paramCanvas.setMatrix(getMainMatrix());
    paramCanvas.save();
    paramCanvas.clipRect(getAliveRect());
    Bitmap localBitmap = getPresenter().dqf();
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {
      paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, null);
    }
    paramCanvas.restore();
    getPresenter().onDraw(paramCanvas);
    AppMethodBeat.o(116417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.b.b
 * JD-Core Version:    0.7.0.1
 */