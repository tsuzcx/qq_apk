package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import org.xwalk.core.Log;

public class CameraFrontSightView
  extends View
{
  public int mHeight;
  private Paint mPaint;
  private int mStrokeWidth;
  public int mWidth;
  private boolean zAF;
  private boolean zAG;
  private boolean zAH;
  private boolean zAI;
  private long zAJ;
  private int zAK;
  private int zAL;
  private ViewGroup.LayoutParams zAM;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94503);
    this.mPaint = new Paint();
    this.zAF = false;
    this.zAG = false;
    this.zAH = false;
    this.zAI = false;
    this.zAJ = 0L;
    AppMethodBeat.o(94503);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94502);
    this.mPaint = new Paint();
    this.zAF = false;
    this.zAG = false;
    this.zAH = false;
    this.zAI = false;
    this.zAJ = 0L;
    AppMethodBeat.o(94502);
  }
  
  public final void aa(float paramFloat1, float paramFloat2)
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
    ekE();
    AppMethodBeat.o(94506);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94507);
    paramCanvas.translate(this.zAK / 2, this.zAL / 2);
    long l = System.currentTimeMillis() - this.zAJ;
    if (l > 200L)
    {
      this.zAF = false;
      this.zAG = true;
    }
    if (l > 800L)
    {
      this.zAG = false;
      this.zAH = true;
    }
    if (l > 1100L)
    {
      this.zAH = false;
      this.zAI = true;
    }
    if (l > 1300L)
    {
      this.zAI = false;
      setVisibility(8);
      AppMethodBeat.o(94507);
      return;
    }
    float f;
    if (this.zAF)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.zAK / 2, this.zAL / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.zAG) {
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
      if (this.zAI)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.zAK, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.zAL, this.mPaint);
      paramCanvas.drawLine(this.zAK, 0.0F, this.zAK, this.zAL, this.mPaint);
      paramCanvas.drawLine(0.0F, this.zAL, this.zAK, this.zAL, this.mPaint);
      paramCanvas.drawLine(0.0F, this.zAL / 2, this.zAK / 10, this.zAL / 2, this.mPaint);
      paramCanvas.drawLine(this.zAK, this.zAL / 2, this.zAK * 9 / 10, this.zAL / 2, this.mPaint);
      paramCanvas.drawLine(this.zAK / 2, 0.0F, this.zAK / 2, this.zAL / 10, this.mPaint);
      paramCanvas.drawLine(this.zAK / 2, this.zAL, this.zAK / 2, this.zAL * 9 / 10, this.mPaint);
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
  
  public final void ekE()
  {
    AppMethodBeat.i(94505);
    setVisibility(0);
    this.zAF = true;
    this.zAG = false;
    this.zAH = false;
    this.zAI = false;
    this.zAJ = System.currentTimeMillis();
    invalidate();
    AppMethodBeat.o(94505);
  }
  
  public final void hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94504);
    this.zAM = getLayoutParams();
    if (this.zAM != null)
    {
      this.zAM.width = paramInt1;
      this.zAM.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.zAK = (this.mWidth / 2);
    this.zAL = (this.mHeight / 2);
    this.mStrokeWidth = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
    AppMethodBeat.o(94504);
  }
  
  public void setFocusColor(int paramInt)
  {
    AppMethodBeat.i(187075);
    if (paramInt != 0) {
      this.mPaint.setColor(paramInt);
    }
    AppMethodBeat.o(187075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */