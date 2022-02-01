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
import com.tencent.mm.ui.ax;

public class VoicePrintVolumeMeter
  extends View
{
  static int Eox;
  private static float NIB;
  private static float NIC;
  private static float NID;
  private static float NIE;
  private static int NIs;
  private static int NIt;
  private static int NIu;
  private View Eol;
  private int JOL;
  private int JOM;
  private float NIA;
  private boolean NIF;
  private MMHandlerThread NIq;
  MTimerHandler NIr;
  private float NIv;
  private float NIw;
  private float NIx;
  private float NIy;
  private float NIz;
  boolean jxX;
  private Context mContext;
  private Paint mPaint;
  private float mVolume;
  
  static
  {
    AppMethodBeat.i(29900);
    NIs = Color.rgb(240, 250, 235);
    NIt = Color.rgb(210, 240, 200);
    NIu = 100;
    Eox = 20;
    NIB = 1.5F;
    NIC = 2.0F;
    NID = 0.1F;
    NIE = 0.05F;
    AppMethodBeat.o(29900);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29892);
    this.JOL = -1;
    this.JOM = -1;
    this.NIq = null;
    this.NIr = null;
    this.NIv = 0.0F;
    this.NIw = 0.0F;
    this.NIx = 0.0F;
    this.NIy = 0.0F;
    this.NIz = 0.0F;
    this.NIA = 0.0F;
    this.mVolume = -1.0F;
    this.NIF = true;
    this.jxX = false;
    init(paramContext);
    AppMethodBeat.o(29892);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29893);
    this.JOL = -1;
    this.JOM = -1;
    this.NIq = null;
    this.NIr = null;
    this.NIv = 0.0F;
    this.NIw = 0.0F;
    this.NIx = 0.0F;
    this.NIy = 0.0F;
    this.NIz = 0.0F;
    this.NIA = 0.0F;
    this.mVolume = -1.0F;
    this.NIF = true;
    this.jxX = false;
    init(paramContext);
    AppMethodBeat.o(29893);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(29894);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    NIs = paramContext.getResources().getColor(R.e.Brand_Alpha_0_1);
    NIt = paramContext.getResources().getColor(R.e.Brand_Alpha_0_3);
    this.NIr = new MTimerHandler("VoicePrintVolumeMeter", new MTimerHandler.CallBack()
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
  
  final void gxf()
  {
    AppMethodBeat.i(29895);
    if ((this.Eol == null) || (this.Eol.getVisibility() == 8))
    {
      AppMethodBeat.o(29895);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.Eol.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      AppMethodBeat.o(29895);
      return;
    }
    int i = this.Eol.getWidth();
    int j = this.Eol.getHeight();
    if ((j == 0) || (i == 0))
    {
      Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      AppMethodBeat.o(29895);
      return;
    }
    this.JOL = (arrayOfInt[0] + i / 2);
    this.JOM = (arrayOfInt[1] + j / 2 - ax.getStatusBarHeight(this.mContext));
    Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.JOL), Integer.valueOf(this.JOM) });
    this.NIv = (i / 2.0F);
    this.NIw = (this.NIv * NIB);
    this.NIx = (this.NIv * NIC);
    this.NIy = (this.NIw * NIC);
    this.NIA = this.NIw;
    this.NIz = this.NIv;
    AppMethodBeat.o(29895);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29896);
    super.onDraw(paramCanvas);
    if (!this.jxX)
    {
      AppMethodBeat.o(29896);
      return;
    }
    if ((this.JOL == -1) || (this.JOM == -1)) {
      gxf();
    }
    this.mPaint.setAlpha(NIu);
    if (this.NIA > this.NIy) {
      this.NIA = this.NIy;
    }
    if (this.NIA < this.NIw) {
      this.NIA = this.NIw;
    }
    this.mPaint.setColor(NIs);
    paramCanvas.drawCircle(this.JOL, this.JOM, this.NIA, this.mPaint);
    if (this.NIz > this.NIx) {
      this.NIz = this.NIx;
    }
    if (this.NIz < this.NIv) {
      this.NIz = this.NIv;
    }
    this.mPaint.setColor(NIt);
    paramCanvas.drawCircle(this.JOL, this.JOM, this.NIz, this.mPaint);
    AppMethodBeat.o(29896);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29898);
    this.NIF = false;
    this.mVolume = -1.0F;
    this.jxX = false;
    this.NIz = 0.0F;
    this.NIA = 0.0F;
    postInvalidate();
    AppMethodBeat.o(29898);
  }
  
  public void setArchView(View paramView)
  {
    this.Eol = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.NIF = true;; this.NIF = false)
    {
      this.mVolume = paramFloat;
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(29897);
    reset();
    this.jxX = false;
    this.NIr.stopTimer();
    postInvalidate();
    AppMethodBeat.o(29897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */