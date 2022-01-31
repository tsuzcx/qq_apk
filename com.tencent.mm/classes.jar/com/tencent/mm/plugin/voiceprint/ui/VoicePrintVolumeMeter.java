package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;

public class VoicePrintVolumeMeter
  extends View
{
  static int oeV;
  private static int tsA;
  private static float tsH;
  private static float tsI;
  private static float tsJ;
  private static float tsK;
  private static int tsy;
  private static int tsz;
  private Context mContext;
  boolean mIsPlaying;
  private Paint mPaint;
  private float mVolume;
  private View oeJ;
  private float tsB;
  private float tsC;
  private float tsD;
  private float tsE;
  private float tsF;
  private float tsG;
  private boolean tsL;
  private int tsu;
  private int tsv;
  al tsw;
  ap tsx;
  
  static
  {
    AppMethodBeat.i(26218);
    tsy = Color.rgb(240, 250, 235);
    tsz = Color.rgb(210, 240, 200);
    tsA = 100;
    oeV = 20;
    tsH = 1.5F;
    tsI = 2.0F;
    tsJ = 0.1F;
    tsK = 0.05F;
    AppMethodBeat.o(26218);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26210);
    this.tsu = -1;
    this.tsv = -1;
    this.tsw = null;
    this.tsx = null;
    this.tsB = 0.0F;
    this.tsC = 0.0F;
    this.tsD = 0.0F;
    this.tsE = 0.0F;
    this.tsF = 0.0F;
    this.tsG = 0.0F;
    this.mVolume = -1.0F;
    this.tsL = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(26210);
  }
  
  public VoicePrintVolumeMeter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26211);
    this.tsu = -1;
    this.tsv = -1;
    this.tsw = null;
    this.tsx = null;
    this.tsB = 0.0F;
    this.tsC = 0.0F;
    this.tsD = 0.0F;
    this.tsE = 0.0F;
    this.tsF = 0.0F;
    this.tsG = 0.0F;
    this.mVolume = -1.0F;
    this.tsL = true;
    this.mIsPlaying = false;
    init(paramContext);
    AppMethodBeat.o(26211);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(26212);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.tsw = new al("VoicePrintVolumeMeter");
    this.tsx = new ap(this.tsw.oNc.getLooper(), new VoicePrintVolumeMeter.1(this), true);
    AppMethodBeat.o(26212);
  }
  
  final void cLv()
  {
    AppMethodBeat.i(26213);
    if ((this.oeJ == null) || (this.oeJ.getVisibility() == 8))
    {
      AppMethodBeat.o(26213);
      return;
    }
    int[] arrayOfInt = new int[2];
    this.oeJ.getLocationOnScreen(arrayOfInt);
    if ((arrayOfInt[0] == 0) || (arrayOfInt[1] == 0))
    {
      ab.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
      AppMethodBeat.o(26213);
      return;
    }
    int i = this.oeJ.getWidth();
    int j = this.oeJ.getHeight();
    if ((j == 0) || (i == 0))
    {
      ab.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
      AppMethodBeat.o(26213);
      return;
    }
    this.tsu = (arrayOfInt[0] + i / 2);
    this.tsv = (arrayOfInt[1] + j / 2 - a.fromDPToPix(this.mContext, 25));
    ab.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[] { Integer.valueOf(this.tsu), Integer.valueOf(this.tsv) });
    this.tsB = (i / 2.0F);
    this.tsC = (this.tsB * tsH);
    this.tsD = (this.tsB * tsI);
    this.tsE = (this.tsC * tsI);
    this.tsG = this.tsC;
    this.tsF = this.tsB;
    AppMethodBeat.o(26213);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(26214);
    super.onDraw(paramCanvas);
    if (!this.mIsPlaying)
    {
      AppMethodBeat.o(26214);
      return;
    }
    if ((this.tsu == -1) || (this.tsv == -1)) {
      cLv();
    }
    this.mPaint.setAlpha(tsA);
    if (this.tsG > this.tsE) {
      this.tsG = this.tsE;
    }
    if (this.tsG < this.tsC) {
      this.tsG = this.tsC;
    }
    this.mPaint.setColor(tsy);
    paramCanvas.drawCircle(this.tsu, this.tsv, this.tsG, this.mPaint);
    if (this.tsF > this.tsD) {
      this.tsF = this.tsD;
    }
    if (this.tsF < this.tsB) {
      this.tsF = this.tsB;
    }
    this.mPaint.setColor(tsz);
    paramCanvas.drawCircle(this.tsu, this.tsv, this.tsF, this.mPaint);
    AppMethodBeat.o(26214);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(26216);
    this.tsL = false;
    this.mVolume = -1.0F;
    this.mIsPlaying = false;
    this.tsF = 0.0F;
    this.tsG = 0.0F;
    postInvalidate();
    AppMethodBeat.o(26216);
  }
  
  public void setArchView(View paramView)
  {
    this.oeJ = paramView;
  }
  
  public void setVolume(float paramFloat)
  {
    if (paramFloat > this.mVolume) {}
    for (this.tsL = true;; this.tsL = false)
    {
      this.mVolume = paramFloat;
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(26215);
    reset();
    this.mIsPlaying = false;
    this.tsx.stopTimer();
    postInvalidate();
    AppMethodBeat.o(26215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter
 * JD-Core Version:    0.7.0.1
 */