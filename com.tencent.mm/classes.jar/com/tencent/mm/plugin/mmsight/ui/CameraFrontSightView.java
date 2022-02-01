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
  private boolean wgf;
  private boolean wgg;
  private boolean wgh;
  private boolean wgi;
  private long wgj;
  private int wgk;
  private int wgl;
  private ViewGroup.LayoutParams wgm;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94503);
    this.mPaint = new Paint();
    this.wgf = false;
    this.wgg = false;
    this.wgh = false;
    this.wgi = false;
    this.wgj = 0L;
    AppMethodBeat.o(94503);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94502);
    this.mPaint = new Paint();
    this.wgf = false;
    this.wgg = false;
    this.wgh = false;
    this.wgi = false;
    this.wgj = 0L;
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
    dqM();
    AppMethodBeat.o(94506);
  }
  
  public final void dqM()
  {
    AppMethodBeat.i(94505);
    setVisibility(0);
    this.wgf = true;
    this.wgg = false;
    this.wgh = false;
    this.wgi = false;
    this.wgj = System.currentTimeMillis();
    invalidate();
    AppMethodBeat.o(94505);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94507);
    paramCanvas.translate(this.wgk / 2, this.wgl / 2);
    long l = System.currentTimeMillis() - this.wgj;
    if (l > 200L)
    {
      this.wgf = false;
      this.wgg = true;
    }
    if (l > 800L)
    {
      this.wgg = false;
      this.wgh = true;
    }
    if (l > 1100L)
    {
      this.wgh = false;
      this.wgi = true;
    }
    if (l > 1300L)
    {
      this.wgi = false;
      setVisibility(8);
      AppMethodBeat.o(94507);
      return;
    }
    float f;
    if (this.wgf)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.wgk / 2, this.wgl / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.wgg) {
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
      if (this.wgi)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.wgk, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.wgl, this.mPaint);
      paramCanvas.drawLine(this.wgk, 0.0F, this.wgk, this.wgl, this.mPaint);
      paramCanvas.drawLine(0.0F, this.wgl, this.wgk, this.wgl, this.mPaint);
      paramCanvas.drawLine(0.0F, this.wgl / 2, this.wgk / 10, this.wgl / 2, this.mPaint);
      paramCanvas.drawLine(this.wgk, this.wgl / 2, this.wgk * 9 / 10, this.wgl / 2, this.mPaint);
      paramCanvas.drawLine(this.wgk / 2, 0.0F, this.wgk / 2, this.wgl / 10, this.mPaint);
      paramCanvas.drawLine(this.wgk / 2, this.wgl, this.wgk / 2, this.wgl * 9 / 10, this.mPaint);
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
    this.wgm = getLayoutParams();
    if (this.wgm != null)
    {
      this.wgm.width = paramInt1;
      this.wgm.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.wgk = (this.mWidth / 2);
    this.wgl = (this.mHeight / 2);
    this.mStrokeWidth = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
    AppMethodBeat.o(94504);
  }
  
  public void setFocusColor(int paramInt)
  {
    AppMethodBeat.i(189030);
    if (paramInt != 0) {
      this.mPaint.setColor(paramInt);
    }
    AppMethodBeat.o(189030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */