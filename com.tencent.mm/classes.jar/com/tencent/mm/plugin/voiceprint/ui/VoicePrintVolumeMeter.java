package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.ap;

public class VoicePrintVolumeMeter
  extends View
{
  static int sTI;
  private static int zeI;
  private static int zeJ;
  private static int zeK;
  private static float zeR;
  private static float zeS;
  private static float zeT;
  private static float zeU;
  private Context mContext;
  boolean mIsPlaying;
  private Paint mPaint;
  private float mVolume;
  private View sTw;
  private int zeE;
  private int zeF;
  private aq zeG;
  av zeH;
  private float zeL;
  private float zeM;
  private float zeN;
  private float zeO;
  private float zeP;
  private float zeQ;
  private boolean zeV;
  
  static
  {
    AppMethodBeat.i(29900);
    zeI = Color.rgb(240, 250, 235);
    zeJ = Color.rgb(210, 240, 200);
    zeK = 100;
    sTI = 20;
    zeR = 1.5F;
    zeS = 2.0F;
    zeT = 0.1F;
    zeU = 0.05F;
    AppMethodBeat.o(29900);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29892);
    this.zeE = -1;
    this.zeF = -1;
    this.zeG = null;
    this.zeH = null;
    this.zeL = 0.0F;
    this.zeM = 0.0F;
    this.zeN = 0.0F;
    this.zeO = 0.0F;
    this.zeP = 0.0F;
    this.zeQ = 0.0F;
    this.mVolume = -1.0F;
    this.zeV = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(29892);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29893);
    this.zeE = -1;
    this.zeF = -1;
    this.zeG = null;
    this.zeH = null;
    this.zeL = 0.0F;
    this.zeM = 0.0F;
    this.zeN = 0.0F;
    this.zeO = 0.0F;
    this.zeP = 0.0F;
    this.zeQ = 0.0F;
    this.mVolume = -1.0F;
    this.zeV = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(29893);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(29894);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    zeI = paramContext.getResources().getColor(2131099704);
    zeJ = paramContext.getResources().getColor(2131099706);
    this.zeH = new av("VoicePrintVolumeMeter", new av.a()
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
  
  final void dRD()
  {
    AppMethodBeat.i(29895);
    if ((this.sTw == null) || (this.sTw.getVisibility() == 8))
    {
      AppMethodBeat.o(29895);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.sTw.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      ad.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      AppMethodBeat.o(29895);
      return;
    }
    int i = this.sTw.getWidth();
    int j = this.sTw.getHeight();
    if ((j == 0) || (i == 0))
    {
      ad.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      AppMethodBeat.o(29895);
      return;
    }
    this.zeE = (arrayOfInt[0] + i / 2);
    this.zeF = (arrayOfInt[1] + j / 2 - ap.iX(this.mContext));
    ad.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.zeE), Integer.valueOf(this.zeF) });
    this.zeL = (i / 2.0F);
    this.zeM = (this.zeL * zeR);
    this.zeN = (this.zeL * zeS);
    this.zeO = (this.zeM * zeS);
    this.zeQ = this.zeM;
    this.zeP = this.zeL;
    AppMethodBeat.o(29895);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(29896);
    super.onDraw(paramCanvas);
    if (!this.mIsPlaying)
    {
      AppMethodBeat.o(29896);
      return;
    }
    if ((this.zeE == -1) || (this.zeF == -1)) {
      dRD();
    }
    this.mPaint.setAlpha(zeK);
    if (this.zeQ > this.zeO) {
      this.zeQ = this.zeO;
    }
    if (this.zeQ < this.zeM) {
      this.zeQ = this.zeM;
    }
    this.mPaint.setColor(zeI);
    paramCanvas.drawCircle(this.zeE, this.zeF, this.zeQ, this.mPaint);
    if (this.zeP > this.zeN) {
      this.zeP = this.zeN;
    }
    if (this.zeP < this.zeL) {
      this.zeP = this.zeL;
    }
    this.mPaint.setColor(zeJ);
    paramCanvas.drawCircle(this.zeE, this.zeF, this.zeP, this.mPaint);
    AppMethodBeat.o(29896);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29898);
    this.zeV = false;
    this.mVolume = -1.0F;
    this.mIsPlaying = false;
    this.zeP = 0.0F;
    this.zeQ = 0.0F;
    postInvalidate();
    AppMethodBeat.o(29898);
  }
  
  public void setArchView(View paramView)
  {
    this.sTw = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.zeV = true;; this.zeV = false)
    {
      this.mVolume = paramFloat;
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(29897);
    reset();
    this.mIsPlaying = false;
    this.zeH.stopTimer();
    postInvalidate();
    AppMethodBeat.o(29897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */