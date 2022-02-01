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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Random;

public final class l
  extends Drawable
{
  private Drawable Kda;
  private Interpolator Kdb;
  private Interpolator Kdc;
  private int Kdd;
  private int Kde;
  private int Kdf;
  private int Kdg;
  private int Kdh;
  private int Kdi;
  private float Kdj;
  private float Kdk;
  private int Kdl;
  private int Kdm;
  private RectF Kdn;
  private ValueAnimator animator;
  private Context context;
  private int currentState;
  private float mj;
  private float mk;
  private Paint paint;
  private Random random;
  private float xIk;
  private int xfc;
  private int xfd;
  private int xfe;
  private int xff;
  private int xfg;
  private int xfh;
  private int xfi;
  private boolean xfj;
  private int xfk;
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(31245);
    this.Kda = null;
    this.xfc = 0;
    this.xfd = 0;
    this.paint = new Paint(1);
    this.Kdb = new LinearInterpolator();
    this.Kdc = new AccelerateDecelerateInterpolator();
    this.random = new Random(System.currentTimeMillis());
    this.xfi = 0;
    this.xIk = 0.0F;
    this.mj = -90.0F;
    this.Kdj = 0.0F;
    this.mk = 0.0F;
    this.Kdk = 5.0F;
    this.xfj = false;
    this.currentState = 2;
    this.animator = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.animator.setInterpolator(this.Kdb);
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
    this.Kdn = new RectF();
    this.context = paramContext;
    this.xfc = a.n(paramContext, 2131101414);
    this.xfd = a.n(paramContext, 2131100900);
    this.Kda = paramContext.getResources().getDrawable(2131691718);
    this.Kdf = a.aH(paramContext, 2131167124);
    this.Kdg = a.aH(paramContext, 2131167123);
    this.Kdh = a.aH(paramContext, 2131167113);
    this.xfi = a.aH(paramContext, 2131167118);
    this.xfe = a.n(paramContext, 2131101321);
    this.Kde = a.aH(paramContext, 2131167115);
    this.Kdi = a.aH(paramContext, 2131167114);
    this.xfh = a.n(paramContext, 2131101322);
    this.Kdl = this.Kdi;
    this.Kdm = this.Kdl;
    this.xfk = a.aH(paramContext, 2131167117);
    this.xff = a.aH(paramContext, 2131167117);
    this.xfg = a.aH(paramContext, 2131167116);
    this.Kdd = a.aH(paramContext, 2131167125);
    AppMethodBeat.o(31245);
  }
  
  private static boolean s(Canvas paramCanvas)
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
  
  public final void aic(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(31250);
    Log.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.xfj = bool;
      invalidateSelf();
      AppMethodBeat.o(31250);
      return;
      bool = false;
    }
  }
  
  public final void dPL()
  {
    AppMethodBeat.i(31247);
    Log.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.animator.cancel();
    this.xIk = 0.0F;
    this.mj = -90.0F;
    this.Kdj = 0.0F;
    this.mk = 0.0F;
    this.Kdk = 5.0F;
    invalidateSelf();
    AppMethodBeat.o(31247);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(31253);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!s(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.xfe);
      if (this.currentState != 7) {
        break label457;
      }
      if (this.xfj)
      {
        this.xfk -= 4;
        this.xfk = Math.min(Math.max(this.xff, this.xfk), this.xfg);
        paramCanvas.drawCircle(i, j, this.xfk, this.paint);
      }
    }
    else
    {
      label140:
      if ((this.Kda != null) && (!s(paramCanvas))) {
        break label477;
      }
      if ((this.currentState == 4) && (paramCanvas != null))
      {
        this.paint.setColor(this.xfc);
        this.paint.setStrokeWidth(this.Kdd);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.clearShadowLayer();
        this.paint.setShader(null);
        this.Kdn.left = (paramCanvas.getWidth() / 2 - this.Kdi);
        this.Kdn.top = (paramCanvas.getHeight() / 2 - this.Kdi);
        this.Kdn.right = (paramCanvas.getWidth() / 2 + this.Kdi);
        this.Kdn.bottom = (paramCanvas.getHeight() / 2 + this.Kdi);
        paramCanvas.drawArc(this.Kdn, this.mj, this.mk, false, this.paint);
        this.mj += this.Kdj;
        this.mk += this.Kdk;
        if (this.mk < 360.0F) {
          break label572;
        }
        this.Kdk = (-this.Kdk);
        this.Kdj = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!s(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.xfh);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.xfi, this.paint);
      }
      AppMethodBeat.o(31253);
      return;
      this.xfk += 4;
      break;
      label457:
      paramCanvas.drawCircle(i, j, this.xff, this.paint);
      break label140;
      label477:
      if (this.currentState == 5) {
        this.Kda.setColorFilter(this.xfd, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.Kda.setBounds(i - this.xfi, j - this.xfi, i + this.xfi, j + this.xfi);
        this.Kda.draw(paramCanvas);
        break;
        this.Kda.setColorFilter(this.xfc, PorterDuff.Mode.SRC_ATOP);
      }
      label572:
      if (this.mk <= 0.0F)
      {
        this.Kdk = (-this.Kdk);
        this.Kdj = 0.0F;
        this.mj = -90.0F;
        this.mk = 0.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.xfi * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(31254);
    if (this.context == null)
    {
      AppMethodBeat.o(31254);
      return 0;
    }
    int i = a.jn(this.context);
    AppMethodBeat.o(31254);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void goW()
  {
    AppMethodBeat.i(31246);
    Log.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 7;
    this.animator.cancel();
    this.xIk = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31246);
  }
  
  public final void goX()
  {
    AppMethodBeat.i(31248);
    Log.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 6;
    this.animator.cancel();
    this.xIk = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31248);
  }
  
  public final void goY()
  {
    AppMethodBeat.i(31251);
    Log.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 4;
    this.animator.cancel();
    this.xIk = 0.0F;
    this.animator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.animator.setDuration(1000L);
    this.animator.setRepeatCount(-1);
    this.animator.start();
    AppMethodBeat.o(31251);
  }
  
  public final void goZ()
  {
    AppMethodBeat.i(31252);
    Log.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 5;
    this.animator.cancel();
    this.xIk = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(31252);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void zP(boolean paramBoolean)
  {
    AppMethodBeat.i(31249);
    Log.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.currentState = 3;
    }
    this.xfj = true;
    invalidateSelf();
    AppMethodBeat.o(31249);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */