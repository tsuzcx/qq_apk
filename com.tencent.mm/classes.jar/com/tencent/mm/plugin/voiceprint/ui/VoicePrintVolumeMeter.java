package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public class VoicePrintVolumeMeter
  extends View
{
  private static float AxA;
  private static int Axo;
  private static int Axp;
  private static int Axq;
  private static float Axx;
  private static float Axy;
  private static float Axz;
  static int ubU;
  private boolean AxB;
  private int Axk;
  private int Axl;
  private com.tencent.mm.sdk.platformtools.ap Axm;
  au Axn;
  private float Axr;
  private float Axs;
  private float Axt;
  private float Axu;
  private float Axv;
  private float Axw;
  private Context mContext;
  boolean mIsPlaying;
  private Paint mPaint;
  private float mVolume;
  private View ubI;
  
  static
  {
    AppMethodBeat.i(29900);
    Axo = Color.rgb(240, 250, 235);
    Axp = Color.rgb(210, 240, 200);
    Axq = 100;
    ubU = 20;
    Axx = 1.5F;
    Axy = 2.0F;
    Axz = 0.1F;
    AxA = 0.05F;
    AppMethodBeat.o(29900);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29892);
    this.Axk = -1;
    this.Axl = -1;
    this.Axm = null;
    this.Axn = null;
    this.Axr = 0.0F;
    this.Axs = 0.0F;
    this.Axt = 0.0F;
    this.Axu = 0.0F;
    this.Axv = 0.0F;
    this.Axw = 0.0F;
    this.mVolume = -1.0F;
    this.AxB = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(29892);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29893);
    this.Axk = -1;
    this.Axl = -1;
    this.Axm = null;
    this.Axn = null;
    this.Axr = 0.0F;
    this.Axs = 0.0F;
    this.Axt = 0.0F;
    this.Axu = 0.0F;
    this.Axv = 0.0F;
    this.Axw = 0.0F;
    this.mVolume = -1.0F;
    this.AxB = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(29893);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(29894);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    Axo = paramContext.getResources().getColor(2131099704);
    Axp = paramContext.getResources().getColor(2131099706);
    this.Axn = new au("VoicePrintVolumeMeter", new au.a()
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
  
  final void egN()
  {
    AppMethodBeat.i(29895);
    if ((this.ubI == null) || (this.ubI.getVisibility() == 8))
    {
      AppMethodBeat.o(29895);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.ubI.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      ac.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      AppMethodBeat.o(29895);
      return;
    }
    int i = this.ubI.getWidth();
    int j = this.ubI.getHeight();
    if ((j == 0) || (i == 0))
    {
      ac.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      AppMethodBeat.o(29895);
      return;
    }
    this.Axk = (arrayOfInt[0] + i / 2);
    this.Axl = (arrayOfInt[1] + j / 2 - com.tencent.mm.ui.ap.ji(this.mContext));
    ac.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.Axk), Integer.valueOf(this.Axl) });
    this.Axr = (i / 2.0F);
    this.Axs = (this.Axr * Axx);
    this.Axt = (this.Axr * Axy);
    this.Axu = (this.Axs * Axy);
    this.Axw = this.Axs;
    this.Axv = this.Axr;
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
    if ((this.Axk == -1) || (this.Axl == -1)) {
      egN();
    }
    this.mPaint.setAlpha(Axq);
    if (this.Axw > this.Axu) {
      this.Axw = this.Axu;
    }
    if (this.Axw < this.Axs) {
      this.Axw = this.Axs;
    }
    this.mPaint.setColor(Axo);
    paramCanvas.drawCircle(this.Axk, this.Axl, this.Axw, this.mPaint);
    if (this.Axv > this.Axt) {
      this.Axv = this.Axt;
    }
    if (this.Axv < this.Axr) {
      this.Axv = this.Axr;
    }
    this.mPaint.setColor(Axp);
    paramCanvas.drawCircle(this.Axk, this.Axl, this.Axv, this.mPaint);
    AppMethodBeat.o(29896);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29898);
    this.AxB = false;
    this.mVolume = -1.0F;
    this.mIsPlaying = false;
    this.Axv = 0.0F;
    this.Axw = 0.0F;
    postInvalidate();
    AppMethodBeat.o(29898);
  }
  
  public void setArchView(View paramView)
  {
    this.ubI = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.AxB = true;; this.AxB = false)
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
    this.Axn.stopTimer();
    postInvalidate();
    AppMethodBeat.o(29897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */