package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public class VoicePrintVolumeMeter
  extends View
{
  private static int Cok;
  private static int Col;
  private static int Com;
  private static float Cot;
  private static float Cou;
  private static float Cov;
  private static float Cow;
  static int vqO;
  private int Cog;
  private int Coh;
  private com.tencent.mm.sdk.platformtools.ar Coi;
  aw Coj;
  private float Con;
  private float Coo;
  private float Cop;
  private float Coq;
  private float Cor;
  private float Cos;
  private boolean Cox;
  private Context mContext;
  boolean mIsPlaying;
  private Paint mPaint;
  private float mVolume;
  private View vqC;
  
  static
  {
    AppMethodBeat.i(29900);
    Cok = Color.rgb(240, 250, 235);
    Col = Color.rgb(210, 240, 200);
    Com = 100;
    vqO = 20;
    Cot = 1.5F;
    Cou = 2.0F;
    Cov = 0.1F;
    Cow = 0.05F;
    AppMethodBeat.o(29900);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29892);
    this.Cog = -1;
    this.Coh = -1;
    this.Coi = null;
    this.Coj = null;
    this.Con = 0.0F;
    this.Coo = 0.0F;
    this.Cop = 0.0F;
    this.Coq = 0.0F;
    this.Cor = 0.0F;
    this.Cos = 0.0F;
    this.mVolume = -1.0F;
    this.Cox = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(29892);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29893);
    this.Cog = -1;
    this.Coh = -1;
    this.Coi = null;
    this.Coj = null;
    this.Con = 0.0F;
    this.Coo = 0.0F;
    this.Cop = 0.0F;
    this.Coq = 0.0F;
    this.Cor = 0.0F;
    this.Cos = 0.0F;
    this.mVolume = -1.0F;
    this.Cox = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(29893);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(29894);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    Cok = paramContext.getResources().getColor(2131099704);
    Col = paramContext.getResources().getColor(2131099706);
    this.Coj = new aw("VoicePrintVolumeMeter", new aw.a()
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
  
  final void eye()
  {
    AppMethodBeat.i(29895);
    if ((this.vqC == null) || (this.vqC.getVisibility() == 8))
    {
      AppMethodBeat.o(29895);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.vqC.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      ae.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      AppMethodBeat.o(29895);
      return;
    }
    int i = this.vqC.getWidth();
    int j = this.vqC.getHeight();
    if ((j == 0) || (i == 0))
    {
      ae.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      AppMethodBeat.o(29895);
      return;
    }
    this.Cog = (arrayOfInt[0] + i / 2);
    this.Coh = (arrayOfInt[1] + j / 2 - com.tencent.mm.ui.ar.jN(this.mContext));
    ae.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.Cog), Integer.valueOf(this.Coh) });
    this.Con = (i / 2.0F);
    this.Coo = (this.Con * Cot);
    this.Cop = (this.Con * Cou);
    this.Coq = (this.Coo * Cou);
    this.Cos = this.Coo;
    this.Cor = this.Con;
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
    if ((this.Cog == -1) || (this.Coh == -1)) {
      eye();
    }
    this.mPaint.setAlpha(Com);
    if (this.Cos > this.Coq) {
      this.Cos = this.Coq;
    }
    if (this.Cos < this.Coo) {
      this.Cos = this.Coo;
    }
    this.mPaint.setColor(Cok);
    paramCanvas.drawCircle(this.Cog, this.Coh, this.Cos, this.mPaint);
    if (this.Cor > this.Cop) {
      this.Cor = this.Cop;
    }
    if (this.Cor < this.Con) {
      this.Cor = this.Con;
    }
    this.mPaint.setColor(Col);
    paramCanvas.drawCircle(this.Cog, this.Coh, this.Cor, this.mPaint);
    AppMethodBeat.o(29896);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29898);
    this.Cox = false;
    this.mVolume = -1.0F;
    this.mIsPlaying = false;
    this.Cor = 0.0F;
    this.Cos = 0.0F;
    postInvalidate();
    AppMethodBeat.o(29898);
  }
  
  public void setArchView(View paramView)
  {
    this.vqC = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.Cox = true;; this.Cox = false)
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
    this.Coj.stopTimer();
    postInvalidate();
    AppMethodBeat.o(29897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */