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
  private int mSV;
  public int mWidth;
  private boolean vUb;
  private boolean vUc;
  private boolean vUd;
  private boolean vUe;
  private long vUf;
  private int vUg;
  private int vUh;
  private ViewGroup.LayoutParams vUi;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94503);
    this.mPaint = new Paint();
    this.vUb = false;
    this.vUc = false;
    this.vUd = false;
    this.vUe = false;
    this.vUf = 0L;
    AppMethodBeat.o(94503);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94502);
    this.mPaint = new Paint();
    this.vUb = false;
    this.vUc = false;
    this.vUd = false;
    this.vUe = false;
    this.vUf = 0L;
    AppMethodBeat.o(94502);
  }
  
  public final void W(float paramFloat1, float paramFloat2)
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
    dnO();
    AppMethodBeat.o(94506);
  }
  
  public final void dnO()
  {
    AppMethodBeat.i(94505);
    setVisibility(0);
    this.vUb = true;
    this.vUc = false;
    this.vUd = false;
    this.vUe = false;
    this.vUf = System.currentTimeMillis();
    invalidate();
    AppMethodBeat.o(94505);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94507);
    paramCanvas.translate(this.vUg / 2, this.vUh / 2);
    long l = System.currentTimeMillis() - this.vUf;
    if (l > 200L)
    {
      this.vUb = false;
      this.vUc = true;
    }
    if (l > 800L)
    {
      this.vUc = false;
      this.vUd = true;
    }
    if (l > 1100L)
    {
      this.vUd = false;
      this.vUe = true;
    }
    if (l > 1300L)
    {
      this.vUe = false;
      setVisibility(8);
      AppMethodBeat.o(94507);
      return;
    }
    float f;
    if (this.vUb)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.vUg / 2, this.vUh / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.vUc) {
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
      if (this.vUe)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.vUg, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.vUh, this.mPaint);
      paramCanvas.drawLine(this.vUg, 0.0F, this.vUg, this.vUh, this.mPaint);
      paramCanvas.drawLine(0.0F, this.vUh, this.vUg, this.vUh, this.mPaint);
      paramCanvas.drawLine(0.0F, this.vUh / 2, this.vUg / 10, this.vUh / 2, this.mPaint);
      paramCanvas.drawLine(this.vUg, this.vUh / 2, this.vUg * 9 / 10, this.vUh / 2, this.mPaint);
      paramCanvas.drawLine(this.vUg / 2, 0.0F, this.vUg / 2, this.vUh / 10, this.mPaint);
      paramCanvas.drawLine(this.vUg / 2, this.vUh, this.vUg / 2, this.vUh * 9 / 10, this.mPaint);
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
  
  public final void gC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94504);
    this.vUi = getLayoutParams();
    if (this.vUi != null)
    {
      this.vUi.width = paramInt1;
      this.vUi.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.vUg = (this.mWidth / 2);
    this.vUh = (this.mHeight / 2);
    this.mSV = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.mSV);
    AppMethodBeat.o(94504);
  }
  
  public void setFocusColor(int paramInt)
  {
    AppMethodBeat.i(214494);
    if (paramInt != 0) {
      this.mPaint.setColor(paramInt);
    }
    AppMethodBeat.o(214494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */