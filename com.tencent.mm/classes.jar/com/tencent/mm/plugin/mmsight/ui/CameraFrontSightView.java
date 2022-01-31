package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.cb.a;
import org.xwalk.core.Log;

public class CameraFrontSightView
  extends View
{
  private int bka;
  public int mHeight;
  private Paint mPaint = new Paint();
  public int mWidth;
  private boolean moe = false;
  private boolean mof = false;
  private boolean mog = false;
  private boolean moh = false;
  private long moi = 0L;
  private int moj;
  private int mok;
  private ViewGroup.LayoutParams mol;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void W(float paramFloat1, float paramFloat2)
  {
    Object localObject = getLayoutParams();
    if (!(localObject instanceof ViewGroup.MarginLayoutParams))
    {
      Log.e("MicroMsg.CameraFrontSightView", "LayoutParams is not MarginLayoutParams! use doAimation()");
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = ((int)paramFloat1 - this.mWidth / 2);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)paramFloat2 - this.mHeight / 2);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    bjZ();
  }
  
  public final void bjZ()
  {
    setVisibility(0);
    this.moe = true;
    this.mof = false;
    this.mog = false;
    this.moh = false;
    this.moi = System.currentTimeMillis();
    invalidate();
  }
  
  public final void dj(int paramInt1, int paramInt2)
  {
    this.mol = getLayoutParams();
    if (this.mol != null)
    {
      this.mol.width = paramInt1;
      this.mol.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.moj = (this.mWidth / 2);
    this.mok = (this.mHeight / 2);
    this.bka = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.bka);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.translate(this.moj / 2, this.mok / 2);
    long l = System.currentTimeMillis() - this.moi;
    if (l > 200L)
    {
      this.moe = false;
      this.mof = true;
    }
    if (l > 800L)
    {
      this.mof = false;
      this.mog = true;
    }
    if (l > 1100L)
    {
      this.mog = false;
      this.moh = true;
    }
    if (l > 1300L)
    {
      this.moh = false;
      setVisibility(8);
      return;
    }
    float f;
    if (this.moe)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.moj / 2, this.mok / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.mof) {
        break label476;
      }
      f = (float)((l - 200L) % 200L) / 200.0F * 2.0F;
      Paint localPaint = this.mPaint;
      if (f <= 1.0F) {
        break label469;
      }
      f -= 1.0F;
      label193:
      localPaint.setAlpha((int)(f * 128.0F + 127.0F));
    }
    for (;;)
    {
      if (this.moh)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.moj, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.mok, this.mPaint);
      paramCanvas.drawLine(this.moj, 0.0F, this.moj, this.mok, this.mPaint);
      paramCanvas.drawLine(0.0F, this.mok, this.moj, this.mok, this.mPaint);
      paramCanvas.drawLine(0.0F, this.mok / 2, this.moj / 10, this.mok / 2, this.mPaint);
      paramCanvas.drawLine(this.moj, this.mok / 2, this.moj * 9 / 10, this.mok / 2, this.mPaint);
      paramCanvas.drawLine(this.moj / 2, 0.0F, this.moj / 2, this.mok / 10, this.mPaint);
      paramCanvas.drawLine(this.moj / 2, this.mok, this.moj / 2, this.mok * 9 / 10, this.mPaint);
      invalidate();
      return;
      paramCanvas.scale(1.0F, 1.0F);
      break;
      label469:
      f = 1.0F - f;
      break label193;
      label476:
      this.mPaint.setAlpha(255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */