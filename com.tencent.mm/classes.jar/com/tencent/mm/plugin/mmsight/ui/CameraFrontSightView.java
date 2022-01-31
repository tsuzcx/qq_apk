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
  private int jas;
  public int mHeight;
  private Paint mPaint;
  public int mWidth;
  private boolean oNm;
  private boolean oNn;
  private boolean oNo;
  private boolean oNp;
  private long oNq;
  private int oNr;
  private int oNs;
  private ViewGroup.LayoutParams oNt;
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(55068);
    this.mPaint = new Paint();
    this.oNm = false;
    this.oNn = false;
    this.oNo = false;
    this.oNp = false;
    this.oNq = 0L;
    AppMethodBeat.o(55068);
  }
  
  public CameraFrontSightView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(55067);
    this.mPaint = new Paint();
    this.oNm = false;
    this.oNn = false;
    this.oNo = false;
    this.oNp = false;
    this.oNq = 0L;
    AppMethodBeat.o(55067);
  }
  
  public final void Z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(55071);
    Object localObject = getLayoutParams();
    if (!(localObject instanceof ViewGroup.MarginLayoutParams))
    {
      Log.e("MicroMsg.CameraFrontSightView", "LayoutParams is not MarginLayoutParams! use doAimation()");
      AppMethodBeat.o(55071);
      return;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = ((int)paramFloat1 - this.mWidth / 2);
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)paramFloat2 - this.mHeight / 2);
    setLayoutParams((ViewGroup.LayoutParams)localObject);
    bRM();
    AppMethodBeat.o(55071);
  }
  
  public final void bRM()
  {
    AppMethodBeat.i(55070);
    setVisibility(0);
    this.oNm = true;
    this.oNn = false;
    this.oNo = false;
    this.oNp = false;
    this.oNq = System.currentTimeMillis();
    invalidate();
    AppMethodBeat.o(55070);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(55072);
    paramCanvas.translate(this.oNr / 2, this.oNs / 2);
    long l = System.currentTimeMillis() - this.oNq;
    if (l > 200L)
    {
      this.oNm = false;
      this.oNn = true;
    }
    if (l > 800L)
    {
      this.oNn = false;
      this.oNo = true;
    }
    if (l > 1100L)
    {
      this.oNo = false;
      this.oNp = true;
    }
    if (l > 1300L)
    {
      this.oNp = false;
      setVisibility(8);
      AppMethodBeat.o(55072);
      return;
    }
    float f;
    if (this.oNm)
    {
      f = (float)(200L - l) / 200.0F + 1.0F;
      paramCanvas.scale(f, f, this.oNr / 2, this.oNs / 2);
      this.mPaint.setAlpha((int)((2.0F - f) * 255.0F));
      if (!this.oNn) {
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
      if (this.oNp)
      {
        f = (float)(l - 1100L) / 200.0F;
        this.mPaint.setAlpha((int)((1.0F - f) * 255.0F));
      }
      paramCanvas.drawLine(0.0F, 0.0F, this.oNr, 0.0F, this.mPaint);
      paramCanvas.drawLine(0.0F, 0.0F, 0.0F, this.oNs, this.mPaint);
      paramCanvas.drawLine(this.oNr, 0.0F, this.oNr, this.oNs, this.mPaint);
      paramCanvas.drawLine(0.0F, this.oNs, this.oNr, this.oNs, this.mPaint);
      paramCanvas.drawLine(0.0F, this.oNs / 2, this.oNr / 10, this.oNs / 2, this.mPaint);
      paramCanvas.drawLine(this.oNr, this.oNs / 2, this.oNr * 9 / 10, this.oNs / 2, this.mPaint);
      paramCanvas.drawLine(this.oNr / 2, 0.0F, this.oNr / 2, this.oNs / 10, this.mPaint);
      paramCanvas.drawLine(this.oNr / 2, this.oNs, this.oNr / 2, this.oNs * 9 / 10, this.mPaint);
      invalidate();
      AppMethodBeat.o(55072);
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
  
  public final void eI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55069);
    this.oNt = getLayoutParams();
    if (this.oNt != null)
    {
      this.oNt.width = paramInt1;
      this.oNt.height = paramInt2;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.oNr = (this.mWidth / 2);
    this.oNs = (this.mHeight / 2);
    this.jas = a.fromDPToPix(getContext(), 1);
    this.mPaint.setColor(-12206054);
    this.mPaint.setStrokeWidth(this.jas);
    AppMethodBeat.o(55069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView
 * JD-Core Version:    0.7.0.1
 */