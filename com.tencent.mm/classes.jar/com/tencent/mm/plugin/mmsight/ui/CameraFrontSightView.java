package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import org.xwalk.core.Log;

public class CameraFrontSightView
  extends View
{
  private boolean FfA;
  private boolean FfB;
  private boolean FfC;
  private boolean FfD;
  private long FfE;
  private int FfF;
  private int FfG;
  private ViewGroup.LayoutParams FfH;
  public int mHeight;
  private Paint mPaint;
  private int mStrokeWidth;
  public int mWidth;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94503);
    this.mPaint = new Paint();
    this.FfA = false;
    this.FfB = false;
    this.FfC = false;
    this.FfD = false;
    this.FfE = 0L;
    AppMethodBeat.o(94503);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94502);
    this.mPaint = new Paint();
    this.FfA = false;
    this.FfB = false;
    this.FfC = false;
    this.FfD = false;
    this.FfE = 0L;
    AppMethodBeat.o(94502);
  }
  
  public final void ab(float paramFloat1, float paramFloat2)
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
    eUm();
    AppMethodBeat.o(94506);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94507);
    paramCanvas.translate(this.FfF / 2, this.FfG / 2);
    long l = System.currentTimeMillis() - this.FfE;
    if (l > 200L)
    {
      this.FfA = false;
      this.FfB = true;
    }
    if (l > 800L)
    {
      this.FfB = false;
      this.FfC = true;
    }
    if (l > 1100L)
    {
      this.FfC = false;
      this.FfD = true;
    }
    if (l > 1300L)
    {
      this.FfD = false;
      paramCanvas.drawColor(0);
      AppMethodBeat.o(94507);
      return;
    }
    float f;
    if (this.FfA)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.FfF / 2, this.FfG / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.FfB) {
        break label490;
      }
      f = (float)((l - 200L) % 200L) / 200.0F * 2.0F;
      Paint localPaint = this.mPaint;
      if (f <= 1.0F) {
        break label483;
      }
      f -= 1.0F;
      label202:
      localPaint.setAlpha((int)(f * 128.0F + 127.0F));
    }
    for (;;)
    {
      if (this.FfD)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.FfF, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.FfG, this.mPaint);
      paramCanvas.drawLine(this.FfF, 0.0F, this.FfF, this.FfG, this.mPaint);
      paramCanvas.drawLine(0.0F, this.FfG, this.FfF, this.FfG, this.mPaint);
      paramCanvas.drawLine(0.0F, this.FfG / 2, this.FfF / 10, this.FfG / 2, this.mPaint);
      paramCanvas.drawLine(this.FfF, this.FfG / 2, this.FfF * 9 / 10, this.FfG / 2, this.mPaint);
      paramCanvas.drawLine(this.FfF / 2, 0.0F, this.FfF / 2, this.FfG / 10, this.mPaint);
      paramCanvas.drawLine(this.FfF / 2, this.FfG, this.FfF / 2, this.FfG * 9 / 10, this.mPaint);
      invalidate();
      AppMethodBeat.o(94507);
      return;
      paramCanvas.scale(1.0F, 1.0F);
      break;
      label483:
      f = 1.0F - f;
      break label202;
      label490:
      this.mPaint.setAlpha(255);
    }
  }
  
  public final void eUm()
  {
    AppMethodBeat.i(94505);
    setVisibility(0);
    this.FfA = true;
    this.FfB = false;
    this.FfC = false;
    this.FfD = false;
    this.FfE = System.currentTimeMillis();
    invalidate();
    AppMethodBeat.o(94505);
  }
  
  public final void ii(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94504);
    this.FfH = getLayoutParams();
    if (this.FfH != null)
    {
      this.FfH.width = paramInt1;
      this.FfH.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.FfF = (this.mWidth / 2);
    this.FfG = (this.mHeight / 2);
    this.mStrokeWidth = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
    setLayerType(1, null);
    AppMethodBeat.o(94504);
  }
  
  public void setFocusColor(int paramInt)
  {
    AppMethodBeat.i(248869);
    if (paramInt != 0) {
      this.mPaint.setColor(paramInt);
    }
    AppMethodBeat.o(248869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */