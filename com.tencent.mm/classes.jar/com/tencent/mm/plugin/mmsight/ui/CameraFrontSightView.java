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
  public int mHeight;
  private Paint mPaint;
  private int mStrokeWidth;
  public int mWidth;
  private boolean nxb;
  private boolean nxc;
  private boolean nxd;
  private boolean nxe;
  private long nxf;
  private int nxg;
  private int nxh;
  private ViewGroup.LayoutParams nxi;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94503);
    this.mPaint = new Paint();
    this.nxb = false;
    this.nxc = false;
    this.nxd = false;
    this.nxe = false;
    this.nxf = 0L;
    AppMethodBeat.o(94503);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(94502);
    this.mPaint = new Paint();
    this.nxb = false;
    this.nxc = false;
    this.nxd = false;
    this.nxe = false;
    this.nxf = 0L;
    AppMethodBeat.o(94502);
  }
  
  public final void aG(float paramFloat1, float paramFloat2)
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
    gda();
    AppMethodBeat.o(94506);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94507);
    paramCanvas.translate(this.nxg / 2, this.nxh / 2);
    long l = System.currentTimeMillis() - this.nxf;
    if (l > 200L)
    {
      this.nxb = false;
      this.nxc = true;
    }
    if (l > 800L)
    {
      this.nxc = false;
      this.nxd = true;
    }
    if (l > 1100L)
    {
      this.nxd = false;
      this.nxe = true;
    }
    if (l > 1300L)
    {
      this.nxe = false;
      paramCanvas.drawColor(0);
      AppMethodBeat.o(94507);
      return;
    }
    float f;
    if (this.nxb)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.nxg / 2, this.nxh / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.nxc) {
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
      if (this.nxe)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.nxg, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.nxh, this.mPaint);
      paramCanvas.drawLine(this.nxg, 0.0F, this.nxg, this.nxh, this.mPaint);
      paramCanvas.drawLine(0.0F, this.nxh, this.nxg, this.nxh, this.mPaint);
      paramCanvas.drawLine(0.0F, this.nxh / 2, this.nxg / 10, this.nxh / 2, this.mPaint);
      paramCanvas.drawLine(this.nxg, this.nxh / 2, this.nxg * 9 / 10, this.nxh / 2, this.mPaint);
      paramCanvas.drawLine(this.nxg / 2, 0.0F, this.nxg / 2, this.nxh / 10, this.mPaint);
      paramCanvas.drawLine(this.nxg / 2, this.nxh, this.nxg / 2, this.nxh * 9 / 10, this.mPaint);
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
  
  public final void gda()
  {
    AppMethodBeat.i(94505);
    setVisibility(0);
    this.nxb = true;
    this.nxc = false;
    this.nxd = false;
    this.nxe = false;
    this.nxf = System.currentTimeMillis();
    invalidate();
    AppMethodBeat.o(94505);
  }
  
  public final void jN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94504);
    this.nxi = getLayoutParams();
    if (this.nxi != null)
    {
      this.nxi.width = paramInt1;
      this.nxi.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.nxg = (this.mWidth / 2);
    this.nxh = (this.mHeight / 2);
    this.mStrokeWidth = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
    setLayerType(1, null);
    AppMethodBeat.o(94504);
  }
  
  public void setFocusColor(int paramInt)
  {
    AppMethodBeat.i(303608);
    if (paramInt != 0) {
      this.mPaint.setColor(paramInt);
    }
    AppMethodBeat.o(303608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */