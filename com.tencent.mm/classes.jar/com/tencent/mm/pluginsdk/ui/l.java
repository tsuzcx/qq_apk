package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.ce.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Random;

public final class l
  extends Drawable
{
  private int Giy;
  private int HCW;
  private int HCX;
  private int HCY;
  private int HCZ;
  private int HDa;
  private int HDb;
  private boolean HDc;
  private int HDd;
  private Drawable XZM;
  private Interpolator XZN;
  private Interpolator XZO;
  private int XZP;
  private int XZQ;
  private int XZR;
  private int XZS;
  private int XZT;
  private int XZU;
  private float XZV;
  private float XZW;
  private int XZX;
  private int XZY;
  private RectF XZZ;
  private float agH;
  private ValueAnimator animator;
  private Context context;
  private int currentState;
  private float dxm;
  private float dxn;
  private Paint paint;
  private Random random;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(31245);
    this.XZM = null;
    this.HCW = 0;
    this.Giy = 0;
    this.paint = new Paint(1);
    this.XZN = new LinearInterpolator();
    this.XZO = new AccelerateDecelerateInterpolator();
    this.random = new Random(System.currentTimeMillis());
    this.HDb = 0;
    this.agH = 0.0F;
    this.dxm = -90.0F;
    this.XZV = 0.0F;
    this.dxn = 0.0F;
    this.XZW = 5.0F;
    this.HDc = false;
    this.currentState = 2;
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.animator.setInterpolator(this.XZN);
    this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(31244);
        l.a(l.this, ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        l.this.invalidateSelf();
        AppMethodBeat.o(31244);
      }
    });
    this.XZZ = new RectF();
    this.context = paramContext;
    this.HCW = a.w(paramContext, R.e.wechat_green);
    this.Giy = a.w(paramContext, R.e.normal_color);
    Resources localResources = paramContext.getResources();
    if (b.iRp()) {}
    for (int i = R.k.voiceinput_icon_button_care;; i = R.k.voiceinput_icon_button)
    {
      this.XZM = localResources.getDrawable(i);
      this.XZR = a.bs(paramContext, R.f.fmm);
      this.XZS = a.bs(paramContext, R.f.fml);
      this.XZT = a.bs(paramContext, R.f.fmi);
      this.HDb = a.bs(paramContext, R.f.voice_input_btn_radius);
      this.HCX = a.w(paramContext, R.e.voice_input_btn_outer_color);
      this.XZQ = a.bs(paramContext, R.f.fmk);
      this.XZU = a.bs(paramContext, R.f.fmj);
      this.HDa = a.w(paramContext, R.e.voice_input_btn_pressed_mask);
      this.XZX = this.XZU;
      this.XZY = this.XZX;
      this.HDd = a.bs(paramContext, R.f.voice_input_btn_outer_radius_minpressed);
      this.HCY = a.bs(paramContext, R.f.voice_input_btn_outer_radius_minpressed);
      this.HCZ = a.bs(paramContext, R.f.voice_input_btn_outer_radius_maxpressed);
      this.XZP = a.bs(paramContext, R.f.fmn);
      AppMethodBeat.o(31245);
      return;
    }
  }
  
  private static boolean p(Canvas paramCanvas)
  {
    AppMethodBeat.i(31255);
    if ((paramCanvas == null) || (paramCanvas.getWidth() == 0) || (paramCanvas.getHeight() == 0))
    {
      AppMethodBeat.o(31255);
      return true;
    }
    AppMethodBeat.o(31255);
    return false;
  }
  
  public final void JD(boolean paramBoolean)
  {
    AppMethodBeat.i(31249);
    Log.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.currentState = 3;
    }
    this.HDc = true;
    invalidateSelf();
    AppMethodBeat.o(31249);
  }
  
  public final void awh(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(31250);
    Log.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.HDc = bool;
      invalidateSelf();
      AppMethodBeat.o(31250);
      return;
      bool = false;
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(31253);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!p(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.HCX);
      if (this.currentState != 7) {
        break label457;
      }
      if (this.HDc)
      {
        this.HDd -= 4;
        this.HDd = Math.min(Math.max(this.HCY, this.HDd), this.HCZ);
        paramCanvas.drawCircle(i, j, this.HDd, this.paint);
      }
    }
    else
    {
      label140:
      if ((this.XZM != null) && (!p(paramCanvas))) {
        break label477;
      }
      if ((this.currentState == 4) && (paramCanvas != null))
      {
        this.paint.setColor(this.HCW);
        this.paint.setStrokeWidth(this.XZP);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.clearShadowLayer();
        this.paint.setShader(null);
        this.XZZ.left = (paramCanvas.getWidth() / 2 - this.XZU);
        this.XZZ.top = (paramCanvas.getHeight() / 2 - this.XZU);
        this.XZZ.right = (paramCanvas.getWidth() / 2 + this.XZU);
        this.XZZ.bottom = (paramCanvas.getHeight() / 2 + this.XZU);
        paramCanvas.drawArc(this.XZZ, this.dxm, this.dxn, false, this.paint);
        this.dxm += this.XZV;
        this.dxn += this.XZW;
        if (this.dxn < 360.0F) {
          break label572;
        }
        this.XZW = (-this.XZW);
        this.XZV = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!p(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.HDa);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.HDb, this.paint);
      }
      AppMethodBeat.o(31253);
      return;
      this.HDd += 4;
      break;
      label457:
      paramCanvas.drawCircle(i, j, this.HCY, this.paint);
      break label140;
      label477:
      if (this.currentState == 5) {
        this.XZM.setColorFilter(this.Giy, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.XZM.setBounds(i - this.HDb, j - this.HDb, i + this.HDb, j + this.HDb);
        this.XZM.draw(paramCanvas);
        break;
        this.XZM.setColorFilter(this.HCW, PorterDuff.Mode.SRC_ATOP);
      }
      label572:
      if (this.dxn <= 0.0F)
      {
        this.XZW = (-this.XZW);
        this.XZV = 0.0F;
        this.dxm = -90.0F;
        this.dxn = 0.0F;
      }
    }
  }
  
  public final void fzj()
  {
    AppMethodBeat.i(31247);
    Log.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.animator.cancel();
    this.agH = 0.0F;
    this.dxm = -90.0F;
    this.XZV = 0.0F;
    this.dxn = 0.0F;
    this.XZW = 5.0F;
    invalidateSelf();
    AppMethodBeat.o(31247);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.HDb * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(31254);
    if (this.context == null)
    {
      AppMethodBeat.o(31254);
      return 0;
    }
    int i = a.ms(this.context);
    AppMethodBeat.o(31254);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void iKH()
  {
    AppMethodBeat.i(31246);
    Log.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 7;
    this.animator.cancel();
    this.agH = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31246);
  }
  
  public final void iKI()
  {
    AppMethodBeat.i(31248);
    Log.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 6;
    this.animator.cancel();
    this.agH = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31248);
  }
  
  public final void iKJ()
  {
    AppMethodBeat.i(31251);
    Log.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 4;
    this.animator.cancel();
    this.agH = 0.0F;
    this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.animator.setDuration(1000L);
    this.animator.setRepeatCount(-1);
    this.animator.start();
    AppMethodBeat.o(31251);
  }
  
  public final void iKK()
  {
    AppMethodBeat.i(31252);
    Log.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 5;
    this.animator.cancel();
    this.agH = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31252);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */