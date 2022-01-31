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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Random;

public final class k
  extends Drawable
{
  private Context context;
  private int currentState;
  private ValueAnimator ggX;
  private float heN;
  private float heO;
  private int nbA;
  private int nbB;
  private int nbC;
  private int nbD;
  private int nbE;
  private int nbF;
  private int nbG;
  private boolean nbH;
  private int nbI;
  private float npG;
  private Paint paint;
  private Random random;
  private Drawable vRO;
  private Interpolator vRP;
  private Interpolator vRQ;
  private int vRR;
  private int vRS;
  private int vRT;
  private int vRU;
  private int vRV;
  private int vRW;
  private float vRX;
  private float vRY;
  private int vRZ;
  private int vSa;
  private RectF vSb;
  
  public k(Context paramContext)
  {
    AppMethodBeat.i(27543);
    this.vRO = null;
    this.nbA = 0;
    this.nbB = 0;
    this.paint = new Paint(1);
    this.vRP = new LinearInterpolator();
    this.vRQ = new AccelerateDecelerateInterpolator();
    this.random = new Random(System.currentTimeMillis());
    this.nbG = 0;
    this.npG = 0.0F;
    this.heN = -90.0F;
    this.vRX = 0.0F;
    this.heO = 0.0F;
    this.vRY = 5.0F;
    this.nbH = false;
    this.currentState = 2;
    this.ggX = ValueAnimator.ofFloat(new float[] { 0.0F, 100.0F });
    this.ggX.setInterpolator(this.vRP);
    this.ggX.addUpdateListener(new k.1(this));
    this.vSb = new RectF();
    this.context = paramContext;
    this.nbA = a.m(paramContext, 2131690701);
    this.nbB = a.m(paramContext, 2131690318);
    this.vRO = paramContext.getResources().getDrawable(2131232174);
    this.vRT = a.ap(paramContext, 2131428812);
    this.vRU = a.ap(paramContext, 2131428811);
    this.vRV = a.ap(paramContext, 2131428801);
    this.nbG = a.ap(paramContext, 2131428806);
    this.nbC = a.m(paramContext, 2131690626);
    this.vRS = a.ap(paramContext, 2131428803);
    this.vRW = a.ap(paramContext, 2131428802);
    this.nbF = a.m(paramContext, 2131690627);
    this.vRZ = this.vRW;
    this.vSa = this.vRZ;
    this.nbI = a.ap(paramContext, 2131428805);
    this.nbD = a.ap(paramContext, 2131428805);
    this.nbE = a.ap(paramContext, 2131428804);
    this.vRR = a.ap(paramContext, 2131428813);
    AppMethodBeat.o(27543);
  }
  
  private static boolean j(Canvas paramCanvas)
  {
    AppMethodBeat.i(27553);
    if ((paramCanvas == null) || (paramCanvas.getWidth() == 0) || (paramCanvas.getHeight() == 0))
    {
      AppMethodBeat.o(27553);
      return true;
    }
    AppMethodBeat.o(27553);
    return false;
  }
  
  public final void LT(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(27548);
    ab.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 28) {}
    for (;;)
    {
      this.nbH = bool;
      invalidateSelf();
      AppMethodBeat.o(27548);
      return;
      bool = false;
    }
  }
  
  public final void bDo()
  {
    AppMethodBeat.i(27545);
    ab.d("MicroMsg.VoiceInputDrawable", "readyState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 2;
    this.ggX.cancel();
    this.npG = 0.0F;
    this.heN = -90.0F;
    this.vRX = 0.0F;
    this.heO = 0.0F;
    this.vRY = 5.0F;
    invalidateSelf();
    AppMethodBeat.o(27545);
  }
  
  public final void dnm()
  {
    AppMethodBeat.i(27544);
    ab.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 7;
    this.ggX.cancel();
    this.npG = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(27544);
  }
  
  public final void dnn()
  {
    AppMethodBeat.i(27546);
    ab.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 6;
    this.ggX.cancel();
    this.npG = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(27546);
  }
  
  public final void dno()
  {
    AppMethodBeat.i(27549);
    ab.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 4;
    this.ggX.cancel();
    this.npG = 0.0F;
    this.ggX.setInterpolator(new AccelerateDecelerateInterpolator());
    this.ggX.setDuration(1000L);
    this.ggX.setRepeatCount(-1);
    this.ggX.start();
    AppMethodBeat.o(27549);
  }
  
  public final void dnp()
  {
    AppMethodBeat.i(27550);
    ab.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(this.currentState) });
    this.currentState = 5;
    this.ggX.cancel();
    this.npG = 0.0F;
    invalidateSelf();
    AppMethodBeat.o(27550);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(27551);
    int i;
    int j;
    if (((this.currentState == 6) || (this.currentState == 7)) && (!j(paramCanvas)))
    {
      i = paramCanvas.getWidth() >> 1;
      j = paramCanvas.getHeight() >> 1;
      this.paint.setShader(null);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.nbC);
      if (this.currentState != 7) {
        break label457;
      }
      if (this.nbH)
      {
        this.nbI -= 4;
        this.nbI = Math.min(Math.max(this.nbD, this.nbI), this.nbE);
        paramCanvas.drawCircle(i, j, this.nbI, this.paint);
      }
    }
    else
    {
      label140:
      if ((this.vRO != null) && (!j(paramCanvas))) {
        break label477;
      }
      if ((this.currentState == 4) && (paramCanvas != null))
      {
        this.paint.setColor(this.nbA);
        this.paint.setStrokeWidth(this.vRR);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.clearShadowLayer();
        this.paint.setShader(null);
        this.vSb.left = (paramCanvas.getWidth() / 2 - this.vRW);
        this.vSb.top = (paramCanvas.getHeight() / 2 - this.vRW);
        this.vSb.right = (paramCanvas.getWidth() / 2 + this.vRW);
        this.vSb.bottom = (paramCanvas.getHeight() / 2 + this.vRW);
        paramCanvas.drawArc(this.vSb, this.heN, this.heO, false, this.paint);
        this.heN += this.vRX;
        this.heO += this.vRY;
        if (this.heO < 360.0F) {
          break label572;
        }
        this.vRY = (-this.vRY);
        this.vRX = 5.0F;
      }
    }
    for (;;)
    {
      if (((this.currentState == 6) || (this.currentState == 7)) && (!j(paramCanvas)))
      {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.nbF);
        paramCanvas.drawCircle(paramCanvas.getWidth() >> 1, paramCanvas.getHeight() >> 1, this.nbG, this.paint);
      }
      AppMethodBeat.o(27551);
      return;
      this.nbI += 4;
      break;
      label457:
      paramCanvas.drawCircle(i, j, this.nbD, this.paint);
      break label140;
      label477:
      if (this.currentState == 5) {
        this.vRO.setColorFilter(this.nbB, PorterDuff.Mode.SRC_ATOP);
      }
      for (;;)
      {
        i = paramCanvas.getWidth() / 2;
        j = paramCanvas.getHeight() / 2;
        this.vRO.setBounds(i - this.nbG, j - this.nbG, i + this.nbG, j + this.nbG);
        this.vRO.draw(paramCanvas);
        break;
        this.vRO.setColorFilter(this.nbA, PorterDuff.Mode.SRC_ATOP);
      }
      label572:
      if (this.heO <= 0.0F)
      {
        this.vRY = (-this.vRY);
        this.vRX = 0.0F;
        this.heN = -90.0F;
        this.heO = 0.0F;
      }
    }
  }
  
  public final int getIntrinsicHeight()
  {
    return this.nbG * 2;
  }
  
  public final int getIntrinsicWidth()
  {
    AppMethodBeat.i(27552);
    if (this.context == null)
    {
      AppMethodBeat.o(27552);
      return 0;
    }
    int i = a.gw(this.context);
    AppMethodBeat.o(27552);
    return i;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void pc(boolean paramBoolean)
  {
    AppMethodBeat.i(27547);
    ab.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      this.currentState = 3;
    }
    this.nbH = true;
    invalidateSelf();
    AppMethodBeat.o(27547);
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.k
 * JD-Core Version:    0.7.0.1
 */