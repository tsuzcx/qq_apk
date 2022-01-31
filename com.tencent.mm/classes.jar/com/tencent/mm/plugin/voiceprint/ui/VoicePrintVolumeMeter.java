package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public class VoicePrintVolumeMeter
  extends View
{
  static int lHI = 20;
  private static int pME = Color.rgb(240, 250, 235);
  private static int pMF = Color.rgb(210, 240, 200);
  private static int pMG = 100;
  private static float pMN = 1.5F;
  private static float pMO = 2.0F;
  private static float pMP = 0.1F;
  private static float pMQ = 0.05F;
  private View lHw;
  private Context mContext;
  boolean mIsPlaying = false;
  private Paint mPaint;
  private float mVolume = -1.0F;
  private int pMA = -1;
  private int pMB = -1;
  ai pMC = null;
  am pMD = null;
  private float pMH = 0.0F;
  private float pMI = 0.0F;
  private float pMJ = 0.0F;
  private float pMK = 0.0F;
  private float pML = 0.0F;
  private float pMM = 0.0F;
  private boolean pMR = true;
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.pMC = new ai("VoicePrintVolumeMeter");
    this.pMD = new am(this.pMC.mnU.getLooper(), new VoicePrintVolumeMeter.1(this), true);
  }
  
  final void bPo()
  {
    if ((this.lHw == null) || (this.lHw.getVisibility() == 8)) {
      return;
    }
    int[] arrayOfInt = new int[2];
    this.lHw.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      y.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      return;
    }
    int i = this.lHw.getWidth();
    int j = this.lHw.getHeight();
    if ((j == 0) || (i == 0))
    {
      y.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      return;
    }
    this.pMA = (arrayOfInt[0] + i / 2);
    this.pMB = (arrayOfInt[1] + j / 2 - a.fromDPToPix(this.mContext, 25));
    y.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.pMA), Integer.valueOf(this.pMB) });
    this.pMH = (i / 2.0F);
    this.pMI = (this.pMH * pMN);
    this.pMJ = (this.pMH * pMO);
    this.pMK = (this.pMI * pMO);
    this.pMM = this.pMI;
    this.pML = this.pMH;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.mIsPlaying) {
      return;
    }
    if ((this.pMA == -1) || (this.pMB == -1)) {
      bPo();
    }
    this.mPaint.setAlpha(pMG);
    if (this.pMM > this.pMK) {
      this.pMM = this.pMK;
    }
    if (this.pMM < this.pMI) {
      this.pMM = this.pMI;
    }
    this.mPaint.setColor(pME);
    paramCanvas.drawCircle(this.pMA, this.pMB, this.pMM, this.mPaint);
    if (this.pML > this.pMJ) {
      this.pML = this.pMJ;
    }
    if (this.pML < this.pMH) {
      this.pML = this.pMH;
    }
    this.mPaint.setColor(pMF);
    paramCanvas.drawCircle(this.pMA, this.pMB, this.pML, this.mPaint);
  }
  
  public final void reset()
  {
    this.pMR = false;
    this.mVolume = -1.0F;
    this.mIsPlaying = false;
    this.pML = 0.0F;
    this.pMM = 0.0F;
    postInvalidate();
  }
  
  public void setArchView(View paramView)
  {
    this.lHw = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.pMR = true;; this.pMR = false)
    {
      this.mVolume = paramFloat;
      return;
    }
  }
  
  public final void stop()
  {
    reset();
    this.mIsPlaying = false;
    this.pMD.stopTimer();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */