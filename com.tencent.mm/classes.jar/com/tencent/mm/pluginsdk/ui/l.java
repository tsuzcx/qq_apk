package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Random;

public final class l
  extends Drawable
{
  private Context context;
  private float fLC = -90.0F;
  private float fLD = 0.0F;
  private Paint gaZ = new Paint(1);
  private ValueAnimator hsF = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
  private Interpolator kFA = new LinearInterpolator();
  private Interpolator kFB = new AccelerateDecelerateInterpolator();
  private int kFC;
  private int kFD;
  private int kFE;
  private int kFF;
  private int kFG;
  private int kFH;
  private int kFI;
  private int kFJ;
  private int kFK;
  private int kFL;
  private int kFM = 0;
  private float kFN = 0.0F;
  private float kFO = 0.0F;
  private float kFP = 5.0F;
  private boolean kFQ = false;
  private int kFR;
  private int kFS;
  private int kFT;
  private int kFU = 2;
  private RectF kFV;
  private Drawable kFx = null;
  private int kFy = 0;
  private int kFz = 0;
  private Random random = new Random(System.currentTimeMillis());
  
  public l(Context paramContext)
  {
    this.hsF.setInterpolator(this.kFA);
    this.hsF.addUpdateListener(new l.1(this));
    this.kFV = new RectF();
    this.context = paramContext;
    this.kFy = a.i(paramContext, R.e.wechat_green);
    this.kFz = a.i(paramContext, R.e.normal_color);
    this.kFx = paramContext.getResources().getDrawable(R.k.voiceinput_icon_button);
    this.kFF = a.ab(paramContext, R.f.voice_input_min_circle_radius);
    this.kFG = a.ab(paramContext, R.f.voice_input_max_circle_radius);
    this.kFH = a.ab(paramContext, R.f.voice_input_breathe_circle_radius);
    this.kFM = a.ab(paramContext, R.f.voice_input_btn_radius);
    this.kFD = a.i(paramContext, R.e.voice_input_btn_outer_color);
    this.kFE = a.ab(paramContext, R.f.voice_input_btn_outer_radius);
    this.kFK = a.ab(paramContext, R.f.voice_input_btn_inner_radius);
    this.kFL = a.i(paramContext, R.e.voice_input_btn_pressed_mask);
    this.kFR = this.kFK;
    this.kFS = this.kFR;
    this.kFT = a.ab(paramContext, R.f.voice_input_btn_outer_radius_minpressed);
    this.kFI = a.ab(paramContext, R.f.voice_input_btn_outer_radius_minpressed);
    this.kFJ = a.ab(paramContext, R.f.voice_input_btn_outer_radius_maxpressed);
    this.kFC = a.ab(paramContext, R.f.voice_input_paint_stroke_width);
  }
  
  private static boolean j(Canvas paramCanvas)
  {
    return (paramCanvas == null) || (paramCanvas.getWidth() == 0) || (paramCanvas.getHeight() == 0);
  }
  
  public final void DW(int paramInt)
  {
    boolean bool = true;
    y.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.kFQ = bool;
      invalidateSelf();
      return;
      bool = false;
    }
  }
  
  public final void aWU()
  {
    y.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.kFU) });
    this.kFU = 2;
    this.hsF.cancel();
    this.kFN = 0.0F;
    this.fLC = -90.0F;
    this.kFO = 0.0F;
    this.fLD = 0.0F;
    this.kFP = 5.0F;
    invalidateSelf();
  }
  
  public final void cmw()
  {
    y.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.kFU) });
    this.kFU = 7;
    this.hsF.cancel();
    this.kFN = 0.0F;
    invalidateSelf();
  }
  
  public final void cmx()
  {
    y.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.kFU) });
    this.kFU = 6;
    this.hsF.cancel();
    this.kFN = 0.0F;
    invalidateSelf();
  }
  
  public final void cmy()
  {
    y.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.kFU) });
    this.kFU = 4;
    this.hsF.cancel();
    this.kFN = 0.0F;
    this.hsF.setInterpolator(new AccelerateDecelerateInterpolator());
    this.hsF.setDuration(1000L);
    this.hsF.setRepeatCount(-1);
    this.hsF.start();
  }
  
  public final void cmz()
  {
    y.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.kFU) });
    this.kFU = 5;
    this.hsF.cancel();
    this.kFN = 0.0F;
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int i;
    int j;
    if (((this.kFU == 6) || (this.kFU == 7)) && (!j(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.gaZ.setShader(null);
      this.gaZ.setStyle(Paint.Style.FILL);
      this.gaZ.setColor(this.kFD);
      if (this.kFU != 7) {
        break label445;
      }
      if (this.kFQ)
      {
        this.kFT -= 4;
        this.kFT = Math.min(Math.max(this.kFI, this.kFT), this.kFJ);
        paramCanvas.drawCircle(i, j, this.kFT, this.gaZ);
      }
    }
    else
    {
      label134:
      if ((this.kFx != null) && (!j(paramCanvas))) {
        break label465;
      }
      if ((this.kFU == 4) && (paramCanvas != null))
      {
        this.gaZ.setColor(this.kFy);
        this.gaZ.setStrokeWidth(this.kFC);
        this.gaZ.setStyle(Paint.Style.STROKE);
        this.gaZ.clearShadowLayer();
        this.gaZ.setShader(null);
        this.kFV.left = (paramCanvas.getWidth() / 2 - this.kFK);
        this.kFV.top = (paramCanvas.getHeight() / 2 - this.kFK);
        this.kFV.right = (paramCanvas.getWidth() / 2 + this.kFK);
        this.kFV.bottom = (paramCanvas.getHeight() / 2 + this.kFK);
        paramCanvas.drawArc(this.kFV, this.fLC, this.fLD, false, this.gaZ);
        this.fLC += this.kFO;
        this.fLD += this.kFP;
        if (this.fLD < 360.0F) {
          break label560;
        }
        this.kFP = (-this.kFP);
        this.kFO = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.kFU == 6) || (this.kFU == 7)) && (!j(paramCanvas)))
      {
        this.gaZ.setStyle(Paint.Style.FILL);
        this.gaZ.setColor(this.kFL);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.kFM, this.gaZ);
      }
      return;
      this.kFT += 4;
      break;
      label445:
      paramCanvas.drawCircle(i, j, this.kFI, this.gaZ);
      break label134;
      label465:
      if (this.kFU == 5) {
        this.kFx.setColorFilter(this.kFz, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.kFx.setBounds(i - this.kFM, j - this.kFM, i + this.kFM, j + this.kFM);
        this.kFx.draw(paramCanvas);
        break;
        this.kFx.setColorFilter(this.kFy, PorterDuff.Mode.SRC_ATOP);
      }
      label560:
      if (this.fLD <= 0.0F)
      {
        this.kFP = (-this.kFP);
        this.kFO = 0.0F;
        this.fLC = -90.0F;
        this.fLD = 0.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.kFM * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    if (this.context == null) {
      return 0;
    }
    return a.fj(this.context);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void lQ(boolean paramBoolean)
  {
    y.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.kFU = 3;
    }
    this.kFQ = true;
    invalidateSelf();
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */