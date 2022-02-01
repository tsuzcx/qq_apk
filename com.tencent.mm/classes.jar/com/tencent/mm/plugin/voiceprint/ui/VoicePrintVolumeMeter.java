package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.au;

public class VoicePrintVolumeMeter
  extends View
{
  private static int GSh;
  private static int GSi;
  private static int GSj;
  private static float GSq;
  private static float GSr;
  private static float GSs;
  private static float GSt;
  static int yKE;
  private int DCs;
  private int DCt;
  private MMHandlerThread GSf;
  MTimerHandler GSg;
  private float GSk;
  private float GSl;
  private float GSm;
  private float GSn;
  private float GSo;
  private float GSp;
  private boolean GSu;
  boolean gNC;
  private Context mContext;
  private Paint mPaint;
  private float mVolume;
  private View yKs;
  
  static
  {
    AppMethodBeat.i(29900);
    GSh = Color.rgb(240, 250, 235);
    GSi = Color.rgb(210, 240, 200);
    GSj = 100;
    yKE = 20;
    GSq = 1.5F;
    GSr = 2.0F;
    GSs = 0.1F;
    GSt = 0.05F;
    AppMethodBeat.o(29900);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29892);
    this.DCs = -1;
    this.DCt = -1;
    this.GSf = null;
    this.GSg = null;
    this.GSk = 0.0F;
    this.GSl = 0.0F;
    this.GSm = 0.0F;
    this.GSn = 0.0F;
    this.GSo = 0.0F;
    this.GSp = 0.0F;
    this.mVolume = -1.0F;
    this.GSu = true;
    this.gNC = false;
    init(paramContext);
    AppMethodBeat.o(29892);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29893);
    this.DCs = -1;
    this.DCt = -1;
    this.GSf = null;
    this.GSg = null;
    this.GSk = 0.0F;
    this.GSl = 0.0F;
    this.GSm = 0.0F;
    this.GSn = 0.0F;
    this.GSo = 0.0F;
    this.GSp = 0.0F;
    this.mVolume = -1.0F;
    this.GSu = true;
    this.gNC = false;
    init(paramContext);
    AppMethodBeat.o(29893);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(29894);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    GSh = paramContext.getResources().getColor(2131099716);
    GSi = paramContext.getResources().getColor(2131099718);
    this.GSg = new MTimerHandler("VoicePrintVolumeMeter", new MTimerHandler.CallBack()
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
  
  final void fES()
  {
    AppMethodBeat.i(29895);
    if ((this.yKs == null) || (this.yKs.getVisibility() == 8))
    {
      AppMethodBeat.o(29895);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.yKs.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      AppMethodBeat.o(29895);
      return;
    }
    int i = this.yKs.getWidth();
    int j = this.yKs.getHeight();
    if ((j == 0) || (i == 0))
    {
      Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      AppMethodBeat.o(29895);
      return;
    }
    this.DCs = (arrayOfInt[0] + i / 2);
    this.DCt = (arrayOfInt[1] + j / 2 - au.getStatusBarHeight(this.mContext));
    Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.DCs), Integer.valueOf(this.DCt) });
    this.GSk = (i / 2.0F);
    this.GSl = (this.GSk * GSq);
    this.GSm = (this.GSk * GSr);
    this.GSn = (this.GSl * GSr);
    this.GSp = this.GSl;
    this.GSo = this.GSk;
    AppMethodBeat.o(29895);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29896);
    super.onDraw(paramCanvas);
    if (!this.gNC)
    {
      AppMethodBeat.o(29896);
      return;
    }
    if ((this.DCs == -1) || (this.DCt == -1)) {
      fES();
    }
    this.mPaint.setAlpha(GSj);
    if (this.GSp > this.GSn) {
      this.GSp = this.GSn;
    }
    if (this.GSp < this.GSl) {
      this.GSp = this.GSl;
    }
    this.mPaint.setColor(GSh);
    paramCanvas.drawCircle(this.DCs, this.DCt, this.GSp, this.mPaint);
    if (this.GSo > this.GSm) {
      this.GSo = this.GSm;
    }
    if (this.GSo < this.GSk) {
      this.GSo = this.GSk;
    }
    this.mPaint.setColor(GSi);
    paramCanvas.drawCircle(this.DCs, this.DCt, this.GSo, this.mPaint);
    AppMethodBeat.o(29896);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29898);
    this.GSu = false;
    this.mVolume = -1.0F;
    this.gNC = false;
    this.GSo = 0.0F;
    this.GSp = 0.0F;
    postInvalidate();
    AppMethodBeat.o(29898);
  }
  
  public void setArchView(View paramView)
  {
    this.yKs = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.GSu = true;; this.GSu = false)
    {
      this.mVolume = paramFloat;
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(29897);
    reset();
    this.gNC = false;
    this.GSg.stopTimer();
    postInvalidate();
    AppMethodBeat.o(29897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */