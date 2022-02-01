package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import org.xwalk.core.Log;

public class CameraFrontSightView
  extends View
{
  public int mHeight;
  private Paint mPaint;
  public int mWidth;
  private int msp;
  private boolean uQR;
  private boolean uQS;
  private boolean uQT;
  private boolean uQU;
  private long uQV;
  private int uQW;
  private int uQX;
  private ViewGroup.LayoutParams uQY;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94503);
    this.mPaint = new Paint();
    this.uQR = false;
    this.uQS = false;
    this.uQT = false;
    this.uQU = false;
    this.uQV = 0L;
    AppMethodBeat.o(94503);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94502);
    this.mPaint = new Paint();
    this.uQR = false;
    this.uQS = false;
    this.uQT = false;
    this.uQU = false;
    this.uQV = 0L;
    AppMethodBeat.o(94502);
  }
  
  public final void U(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(94506);
    Object localObject = getLayoutParams();
    if (!(localObject instanceof ViewGroup.MarginLayoutParams))
    {
      Log.e("MicroMsg.CameraFrontSightView", "LayoutParams is not MarginLayoutParams! use doAimation()");
      AppMethodBeat.o(94506);
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = ((int)paramFloat1 - this.mWidth / 2);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)paramFloat2 - this.mHeight / 2);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    deq();
    AppMethodBeat.o(94506);
  }
  
  public final void deq()
  {
    AppMethodBeat.i(94505);
    setVisibility(0);
    this.uQR = true;
    this.uQS = false;
    this.uQT = false;
    this.uQU = false;
    this.uQV = System.currentTimeMillis();
    invalidate();
    AppMethodBeat.o(94505);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94507);
    paramCanvas.translate(this.uQW / 2, this.uQX / 2);
    long l = System.currentTimeMillis() - this.uQV;
    if (l > 200L)
    {
      this.uQR = false;
      this.uQS = true;
    }
    if (l > 800L)
    {
      this.uQS = false;
      this.uQT = true;
    }
    if (l > 1100L)
    {
      this.uQT = false;
      this.uQU = true;
    }
    if (l > 1300L)
    {
      this.uQU = false;
      setVisibility(8);
      AppMethodBeat.o(94507);
      return;
    }
    float f;
    if (this.uQR)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.uQW / 2, this.uQX / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.uQS) {
        break label491;
      }
      f = (float)((l - 200L) % 200L) / 200.0F * 2.0F;
      Paint localPaint = this.mPaint;
      if (f <= 1.0F) {
        break label484;
      }
      f -= 1.0F;
      label203:
      localPaint.setAlpha((int)(f * 128.0F + 127.0F));
    }
    for (;;)
    {
      if (this.uQU)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.uQW, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.uQX, this.mPaint);
      paramCanvas.drawLine(this.uQW, 0.0F, this.uQW, this.uQX, this.mPaint);
      paramCanvas.drawLine(0.0F, this.uQX, this.uQW, this.uQX, this.mPaint);
      paramCanvas.drawLine(0.0F, this.uQX / 2, this.uQW / 10, this.uQX / 2, this.mPaint);
      paramCanvas.drawLine(this.uQW, this.uQX / 2, this.uQW * 9 / 10, this.uQX / 2, this.mPaint);
      paramCanvas.drawLine(this.uQW / 2, 0.0F, this.uQW / 2, this.uQX / 10, this.mPaint);
      paramCanvas.drawLine(this.uQW / 2, this.uQX, this.uQW / 2, this.uQX * 9 / 10, this.mPaint);
      invalidate();
      AppMethodBeat.o(94507);
      return;
      paramCanvas.scale(1.0F, 1.0F);
      break;
      label484:
      f = 1.0F - f;
      break label203;
      label491:
      this.mPaint.setAlpha(255);
    }
  }
  
  public final void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94504);
    this.uQY = getLayoutParams();
    if (this.uQY != null)
    {
      this.uQY.width = paramInt1;
      this.uQY.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.uQW = (this.mWidth / 2);
    this.uQX = (this.mHeight / 2);
    this.msp = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.msp);
    AppMethodBeat.o(94504);
  }
  
  public void setFocusColor(int paramInt)
  {
    AppMethodBeat.i(209935);
    if (paramInt != 0) {
      this.mPaint.setColor(paramInt);
    }
    AppMethodBeat.o(209935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */