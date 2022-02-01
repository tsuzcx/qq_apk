package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.bf;

public class VoicePrintVolumeMeter
  extends View
{
  static int Khd;
  private static float UuD;
  private static float UuE;
  private static float UuF;
  private static float UuG;
  private static int Uuu;
  private static int Uuv;
  private static int Uuw;
  private View KgR;
  private int Qjb;
  private int Qjc;
  private float UuA;
  private float UuB;
  private float UuC;
  private boolean UuH;
  private MMHandlerThread Uus;
  MTimerHandler Uut;
  private float Uux;
  private float Uuy;
  private float Uuz;
  private Context mContext;
  private Paint mPaint;
  private float mVolume;
  boolean qRV;
  
  static
  {
    AppMethodBeat.i(29900);
    Uuu = Color.rgb(240, 250, 235);
    Uuv = Color.rgb(210, 240, 200);
    Uuw = 100;
    Khd = 20;
    UuD = 1.5F;
    UuE = 2.0F;
    UuF = 0.1F;
    UuG = 0.05F;
    AppMethodBeat.o(29900);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29892);
    this.Qjb = -1;
    this.Qjc = -1;
    this.Uus = null;
    this.Uut = null;
    this.Uux = 0.0F;
    this.Uuy = 0.0F;
    this.Uuz = 0.0F;
    this.UuA = 0.0F;
    this.UuB = 0.0F;
    this.UuC = 0.0F;
    this.mVolume = -1.0F;
    this.UuH = true;
    this.qRV = false;
    init(paramContext);
    AppMethodBeat.o(29892);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29893);
    this.Qjb = -1;
    this.Qjc = -1;
    this.Uus = null;
    this.Uut = null;
    this.Uux = 0.0F;
    this.Uuy = 0.0F;
    this.Uuz = 0.0F;
    this.UuA = 0.0F;
    this.UuB = 0.0F;
    this.UuC = 0.0F;
    this.mVolume = -1.0F;
    this.UuH = true;
    this.qRV = false;
    init(paramContext);
    AppMethodBeat.o(29893);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(29894);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    Uuu = paramContext.getResources().getColor(R.e.Brand_Alpha_0_1);
    Uuv = paramContext.getResources().getColor(R.e.Brand_Alpha_0_3);
    this.Uut = new MTimerHandler("VoicePrintVolumeMeter", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(29891);
        VoicePrintVolumeMeter.a(VoicePrintVolumeMeter.this);
        boolean bool = VoicePrintVolumeMeter.b(VoicePrintVolumeMeter.this);
        AppMethodBeat.o(29891);
        return bool;
      }
    }, true);
    AppMethodBeat.o(29894);
  }
  
  final void hVc()
  {
    AppMethodBeat.i(29895);
    if ((this.KgR == null) || (this.KgR.getVisibility() == 8))
    {
      AppMethodBeat.o(29895);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.KgR.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      AppMethodBeat.o(29895);
      return;
    }
    int i = this.KgR.getWidth();
    int j = this.KgR.getHeight();
    if ((j == 0) || (i == 0))
    {
      Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      AppMethodBeat.o(29895);
      return;
    }
    this.Qjb = (arrayOfInt[0] + i / 2);
    this.Qjc = (arrayOfInt[1] + j / 2 - bf.getStatusBarHeight(this.mContext));
    Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.Qjb), Integer.valueOf(this.Qjc) });
    this.Uux = (i / 2.0F);
    this.Uuy = (this.Uux * UuD);
    this.Uuz = (this.Uux * UuE);
    this.UuA = (this.Uuy * UuE);
    this.UuC = this.Uuy;
    this.UuB = this.Uux;
    AppMethodBeat.o(29895);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29896);
    super.onDraw(paramCanvas);
    if (!this.qRV)
    {
      AppMethodBeat.o(29896);
      return;
    }
    if ((this.Qjb == -1) || (this.Qjc == -1)) {
      hVc();
    }
    this.mPaint.setAlpha(Uuw);
    if (this.UuC > this.UuA) {
      this.UuC = this.UuA;
    }
    if (this.UuC < this.Uuy) {
      this.UuC = this.Uuy;
    }
    this.mPaint.setColor(Uuu);
    paramCanvas.drawCircle(this.Qjb, this.Qjc, this.UuC, this.mPaint);
    if (this.UuB > this.Uuz) {
      this.UuB = this.Uuz;
    }
    if (this.UuB < this.Uux) {
      this.UuB = this.Uux;
    }
    this.mPaint.setColor(Uuv);
    paramCanvas.drawCircle(this.Qjb, this.Qjc, this.UuB, this.mPaint);
    AppMethodBeat.o(29896);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29898);
    this.UuH = false;
    this.mVolume = -1.0F;
    this.qRV = false;
    this.UuB = 0.0F;
    this.UuC = 0.0F;
    postInvalidate();
    AppMethodBeat.o(29898);
  }
  
  public void setArchView(View paramView)
  {
    this.KgR = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.UuH = true;; this.UuH = false)
    {
      this.mVolume = paramFloat;
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(29897);
    reset();
    this.qRV = false;
    this.Uut.stopTimer();
    postInvalidate();
    AppMethodBeat.o(29897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */