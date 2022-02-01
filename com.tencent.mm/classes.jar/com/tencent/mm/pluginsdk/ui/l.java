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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Random;

public final class l
  extends Drawable
{
  private int BRn;
  private int BRo;
  private int BRp;
  private int BRq;
  private int BRr;
  private int BRs;
  private int BRt;
  private boolean BRu;
  private int BRv;
  private float CMo;
  private Drawable RdG;
  private Interpolator RdH;
  private Interpolator RdI;
  private int RdJ;
  private int RdK;
  private int RdL;
  private int RdM;
  private int RdN;
  private int RdO;
  private float RdP;
  private float RdQ;
  private int RdR;
  private int RdS;
  private RectF RdT;
  private ValueAnimator animator;
  private float bEl;
  private float bEm;
  private Context context;
  private int currentState;
  private Paint paint;
  private Random random;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(31245);
    this.RdG = null;
    this.BRn = 0;
    this.BRo = 0;
    this.paint = new Paint(1);
    this.RdH = new LinearInterpolator();
    this.RdI = new AccelerateDecelerateInterpolator();
    this.random = new Random(System.currentTimeMillis());
    this.BRt = 0;
    this.CMo = 0.0F;
    this.bEl = -90.0F;
    this.RdP = 0.0F;
    this.bEm = 0.0F;
    this.RdQ = 5.0F;
    this.BRu = false;
    this.currentState = 2;
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.animator.setInterpolator(this.RdH);
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
    this.RdT = new RectF();
    this.context = paramContext;
    this.BRn = a.w(paramContext, R.e.wechat_green);
    this.BRo = a.w(paramContext, R.e.normal_color);
    this.RdG = paramContext.getResources().getDrawable(R.k.voiceinput_icon_button);
    this.RdL = a.aZ(paramContext, R.f.dlU);
    this.RdM = a.aZ(paramContext, R.f.dlT);
    this.RdN = a.aZ(paramContext, R.f.dlQ);
    this.BRt = a.aZ(paramContext, R.f.voice_input_btn_radius);
    this.BRp = a.w(paramContext, R.e.voice_input_btn_outer_color);
    this.RdK = a.aZ(paramContext, R.f.dlS);
    this.RdO = a.aZ(paramContext, R.f.dlR);
    this.BRs = a.w(paramContext, R.e.voice_input_btn_pressed_mask);
    this.RdR = this.RdO;
    this.RdS = this.RdR;
    this.BRv = a.aZ(paramContext, R.f.voice_input_btn_outer_radius_minpressed);
    this.BRq = a.aZ(paramContext, R.f.voice_input_btn_outer_radius_minpressed);
    this.BRr = a.aZ(paramContext, R.f.voice_input_btn_outer_radius_maxpressed);
    this.RdJ = a.aZ(paramContext, R.f.dlV);
    AppMethodBeat.o(31245);
  }
  
  private static boolean u(Canvas paramCanvas)
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
  
  public final void DU(boolean paramBoolean)
  {
    AppMethodBeat.i(31249);
    Log.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.currentState = 3;
    }
    this.BRu = true;
    invalidateSelf();
    AppMethodBeat.o(31249);
  }
  
  public final void aqd(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(31250);
    Log.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.BRu = bool;
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
    if (((this.currentState == 6) || (this.currentState == 7)) && (!u(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.BRp);
      if (this.currentState != 7) {
        break label457;
      }
      if (this.BRu)
      {
        this.BRv -= 4;
        this.BRv = Math.min(Math.max(this.BRq, this.BRv), this.BRr);
        paramCanvas.drawCircle(i, j, this.BRv, this.paint);
      }
    }
    else
    {
      label140:
      if ((this.RdG != null) && (!u(paramCanvas))) {
        break label477;
      }
      if ((this.currentState == 4) && (paramCanvas != null))
      {
        this.paint.setColor(this.BRn);
        this.paint.setStrokeWidth(this.RdJ);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.clearShadowLayer();
        this.paint.setShader(null);
        this.RdT.left = (paramCanvas.getWidth() / 2 - this.RdO);
        this.RdT.top = (paramCanvas.getHeight() / 2 - this.RdO);
        this.RdT.right = (paramCanvas.getWidth() / 2 + this.RdO);
        this.RdT.bottom = (paramCanvas.getHeight() / 2 + this.RdO);
        paramCanvas.drawArc(this.RdT, this.bEl, this.bEm, false, this.paint);
        this.bEl += this.RdP;
        this.bEm += this.RdQ;
        if (this.bEm < 360.0F) {
          break label572;
        }
        this.RdQ = (-this.RdQ);
        this.RdP = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!u(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.BRs);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.BRt, this.paint);
      }
      AppMethodBeat.o(31253);
      return;
      this.BRv += 4;
      break;
      label457:
      paramCanvas.drawCircle(i, j, this.BRq, this.paint);
      break label140;
      label477:
      if (this.currentState == 5) {
        this.RdG.setColorFilter(this.BRo, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.RdG.setBounds(i - this.BRt, j - this.BRt, i + this.BRt, j + this.BRt);
        this.RdG.draw(paramCanvas);
        break;
        this.RdG.setColorFilter(this.BRn, PorterDuff.Mode.SRC_ATOP);
      }
      label572:
      if (this.bEm <= 0.0F)
      {
        this.RdQ = (-this.RdQ);
        this.RdP = 0.0F;
        this.bEl = -90.0F;
        this.bEm = 0.0F;
      }
    }
  }
  
  public final void esk()
  {
    AppMethodBeat.i(31247);
    Log.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.animator.cancel();
    this.CMo = 0.0F;
    this.bEl = -90.0F;
    this.RdP = 0.0F;
    this.bEm = 0.0F;
    this.RdQ = 5.0F;
    invalidateSelf();
    AppMethodBeat.o(31247);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.BRt * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(31254);
    if (this.context == null)
    {
      AppMethodBeat.o(31254);
      return 0;
    }
    int i = a.kr(this.context);
    AppMethodBeat.o(31254);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void hjP()
  {
    AppMethodBeat.i(31246);
    Log.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 7;
    this.animator.cancel();
    this.CMo = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31246);
  }
  
  public final void hjQ()
  {
    AppMethodBeat.i(31248);
    Log.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 6;
    this.animator.cancel();
    this.CMo = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31248);
  }
  
  public final void hjR()
  {
    AppMethodBeat.i(31251);
    Log.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 4;
    this.animator.cancel();
    this.CMo = 0.0F;
    this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.animator.setDuration(1000L);
    this.animator.setRepeatCount(-1);
    this.animator.start();
    AppMethodBeat.o(31251);
  }
  
  public final void hjS()
  {
    AppMethodBeat.i(31252);
    Log.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 5;
    this.animator.cancel();
    this.CMo = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31252);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */