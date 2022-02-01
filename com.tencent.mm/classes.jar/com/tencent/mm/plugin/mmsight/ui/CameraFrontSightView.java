package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import org.xwalk.core.Log;

public class CameraFrontSightView
  extends View
{
  private int lQm;
  public int mHeight;
  private Paint mPaint;
  public int mWidth;
  private int tIA;
  private int tIB;
  private ViewGroup.LayoutParams tIC;
  private boolean tIv;
  private boolean tIw;
  private boolean tIx;
  private boolean tIy;
  private long tIz;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94503);
    this.mPaint = new Paint();
    this.tIv = false;
    this.tIw = false;
    this.tIx = false;
    this.tIy = false;
    this.tIz = 0L;
    AppMethodBeat.o(94503);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94502);
    this.mPaint = new Paint();
    this.tIv = false;
    this.tIw = false;
    this.tIx = false;
    this.tIy = false;
    this.tIz = 0L;
    AppMethodBeat.o(94502);
  }
  
  public final void Q(float paramFloat1, float paramFloat2)
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
    cQG();
    AppMethodBeat.o(94506);
  }
  
  public final void cQG()
  {
    AppMethodBeat.i(94505);
    setVisibility(0);
    this.tIv = true;
    this.tIw = false;
    this.tIx = false;
    this.tIy = false;
    this.tIz = System.currentTimeMillis();
    invalidate();
    AppMethodBeat.o(94505);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94507);
    paramCanvas.translate(this.tIA / 2, this.tIB / 2);
    long l = System.currentTimeMillis() - this.tIz;
    if (l > 200L)
    {
      this.tIv = false;
      this.tIw = true;
    }
    if (l > 800L)
    {
      this.tIw = false;
      this.tIx = true;
    }
    if (l > 1100L)
    {
      this.tIx = false;
      this.tIy = true;
    }
    if (l > 1300L)
    {
      this.tIy = false;
      setVisibility(8);
      AppMethodBeat.o(94507);
      return;
    }
    float f;
    if (this.tIv)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.tIA / 2, this.tIB / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.tIw) {
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
      if (this.tIy)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.tIA, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.tIB, this.mPaint);
      paramCanvas.drawLine(this.tIA, 0.0F, this.tIA, this.tIB, this.mPaint);
      paramCanvas.drawLine(0.0F, this.tIB, this.tIA, this.tIB, this.mPaint);
      paramCanvas.drawLine(0.0F, this.tIB / 2, this.tIA / 10, this.tIB / 2, this.mPaint);
      paramCanvas.drawLine(this.tIA, this.tIB / 2, this.tIA * 9 / 10, this.tIB / 2, this.mPaint);
      paramCanvas.drawLine(this.tIA / 2, 0.0F, this.tIA / 2, this.tIB / 10, this.mPaint);
      paramCanvas.drawLine(this.tIA / 2, this.tIB, this.tIA / 2, this.tIB * 9 / 10, this.mPaint);
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
  
  public final void ge(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94504);
    this.tIC = getLayoutParams();
    if (this.tIC != null)
    {
      this.tIC.width = paramInt1;
      this.tIC.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.tIA = (this.mWidth / 2);
    this.tIB = (this.mHeight / 2);
    this.lQm = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.lQm);
    AppMethodBeat.o(94504);
  }
  
  public void setFocusColor(int paramInt)
  {
    AppMethodBeat.i(205852);
    if (paramInt != 0) {
      this.mPaint.setColor(paramInt);
    }
    AppMethodBeat.o(205852);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */