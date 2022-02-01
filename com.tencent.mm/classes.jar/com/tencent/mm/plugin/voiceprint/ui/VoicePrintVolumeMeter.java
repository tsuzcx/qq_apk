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
import com.tencent.mm.ui.ar;

public class VoicePrintVolumeMeter
  extends View
{
  private static int BWJ;
  private static int BWK;
  private static int BWL;
  private static float BWS;
  private static float BWT;
  private static float BWU;
  private static float BWV;
  static int veE;
  private int BWF;
  private int BWG;
  private aq BWH;
  av BWI;
  private float BWM;
  private float BWN;
  private float BWO;
  private float BWP;
  private float BWQ;
  private float BWR;
  private boolean BWW;
  private Context mContext;
  boolean mIsPlaying;
  private Paint mPaint;
  private float mVolume;
  private View ves;
  
  static
  {
    AppMethodBeat.i(29900);
    BWJ = Color.rgb(240, 250, 235);
    BWK = Color.rgb(210, 240, 200);
    BWL = 100;
    veE = 20;
    BWS = 1.5F;
    BWT = 2.0F;
    BWU = 0.1F;
    BWV = 0.05F;
    AppMethodBeat.o(29900);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29892);
    this.BWF = -1;
    this.BWG = -1;
    this.BWH = null;
    this.BWI = null;
    this.BWM = 0.0F;
    this.BWN = 0.0F;
    this.BWO = 0.0F;
    this.BWP = 0.0F;
    this.BWQ = 0.0F;
    this.BWR = 0.0F;
    this.mVolume = -1.0F;
    this.BWW = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(29892);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29893);
    this.BWF = -1;
    this.BWG = -1;
    this.BWH = null;
    this.BWI = null;
    this.BWM = 0.0F;
    this.BWN = 0.0F;
    this.BWO = 0.0F;
    this.BWP = 0.0F;
    this.BWQ = 0.0F;
    this.BWR = 0.0F;
    this.mVolume = -1.0F;
    this.BWW = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(29893);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(29894);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    BWJ = paramContext.getResources().getColor(2131099704);
    BWK = paramContext.getResources().getColor(2131099706);
    this.BWI = new av("VoicePrintVolumeMeter", new av.a()
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
  
  final void euy()
  {
    AppMethodBeat.i(29895);
    if ((this.ves == null) || (this.ves.getVisibility() == 8))
    {
      AppMethodBeat.o(29895);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.ves.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      ad.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      AppMethodBeat.o(29895);
      return;
    }
    int i = this.ves.getWidth();
    int j = this.ves.getHeight();
    if ((j == 0) || (i == 0))
    {
      ad.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      AppMethodBeat.o(29895);
      return;
    }
    this.BWF = (arrayOfInt[0] + i / 2);
    this.BWG = (arrayOfInt[1] + j / 2 - ar.jG(this.mContext));
    ad.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.BWF), Integer.valueOf(this.BWG) });
    this.BWM = (i / 2.0F);
    this.BWN = (this.BWM * BWS);
    this.BWO = (this.BWM * BWT);
    this.BWP = (this.BWN * BWT);
    this.BWR = this.BWN;
    this.BWQ = this.BWM;
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
    if ((this.BWF == -1) || (this.BWG == -1)) {
      euy();
    }
    this.mPaint.setAlpha(BWL);
    if (this.BWR > this.BWP) {
      this.BWR = this.BWP;
    }
    if (this.BWR < this.BWN) {
      this.BWR = this.BWN;
    }
    this.mPaint.setColor(BWJ);
    paramCanvas.drawCircle(this.BWF, this.BWG, this.BWR, this.mPaint);
    if (this.BWQ > this.BWO) {
      this.BWQ = this.BWO;
    }
    if (this.BWQ < this.BWM) {
      this.BWQ = this.BWM;
    }
    this.mPaint.setColor(BWK);
    paramCanvas.drawCircle(this.BWF, this.BWG, this.BWQ, this.mPaint);
    AppMethodBeat.o(29896);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29898);
    this.BWW = false;
    this.mVolume = -1.0F;
    this.mIsPlaying = false;
    this.BWQ = 0.0F;
    this.BWR = 0.0F;
    postInvalidate();
    AppMethodBeat.o(29898);
  }
  
  public void setArchView(View paramView)
  {
    this.ves = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.BWW = true;; this.BWW = false)
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
    this.BWI.stopTimer();
    postInvalidate();
    AppMethodBeat.o(29897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */