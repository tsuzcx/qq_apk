package com.tencent.mm.wallet_core.keyboard;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class WcPayKeyboardAnimationActionButton
  extends View
{
  AnimatorSet CPA;
  private int GyC;
  private int GyD;
  private int Lcf;
  private int Lcg;
  private ColorStateList RsF;
  private ColorStateList RsG;
  private int RsH;
  private int RsI;
  private int RsJ;
  private int RsK;
  private int RsL;
  private int RsM;
  private int RsN;
  private int RsO;
  private int RsP;
  String RsQ;
  private float RsR;
  private float RsS;
  boolean RsT;
  private int RsU;
  private int RsV;
  private RectF RsW;
  private Rect RsX;
  private ObjectAnimator RsY;
  private ValueAnimator RsZ;
  private ValueAnimator Rta;
  private ObjectAnimator Rtb;
  private ValueAnimator Rtc;
  private ValueAnimator Rtd;
  AnimatorSet Rte;
  private Paint cgU;
  private Context context;
  private int height;
  private Paint lup;
  private int width;
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72701);
    this.Lcg = getResources().getColor(2131101414);
    this.Lcf = getResources().getColor(2131101430);
    this.RsH = 17;
    this.RsO = 300;
    this.RsP = 300;
    this.RsQ = "";
    this.RsT = true;
    this.RsW = new RectF();
    this.RsX = new Rect();
    this.CPA = new AnimatorSet();
    this.Rte = new AnimatorSet();
    init();
    AppMethodBeat.o(72701);
  }
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72702);
    this.Lcg = getResources().getColor(2131101414);
    this.Lcf = getResources().getColor(2131101430);
    this.RsH = 17;
    this.RsO = 300;
    this.RsP = 300;
    this.RsQ = "";
    this.RsT = true;
    this.RsW = new RectF();
    this.RsX = new Rect();
    this.CPA = new AnimatorSet();
    this.Rte = new AnimatorSet();
    init();
    AppMethodBeat.o(72702);
  }
  
  private void T(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.GyC = paramInt1;
    this.GyD = paramInt2;
    this.RsU = paramInt3;
    this.RsV = paramInt4;
  }
  
  private void amZ()
  {
    AppMethodBeat.i(72704);
    this.context = MMApplicationContext.getContext();
    this.RsI = a.fromDPToPix(this.context, 4);
    this.RsJ = a.fromDPToPix(this.context, 16);
    this.RsK = a.fromDPToPix(this.context, 64);
    this.RsL = a.fromDPToPix(this.context, 96);
    this.RsF = getResources().getColorStateList(2131101414);
    this.RsG = getResources().getColorStateList(2131101430);
    AppMethodBeat.o(72704);
  }
  
  private void hgW()
  {
    AppMethodBeat.i(72707);
    this.RsS = getTranslationX();
    this.RsR = (this.RsS - this.RsJ);
    AppMethodBeat.o(72707);
  }
  
  private void hgZ()
  {
    AppMethodBeat.i(72711);
    hha();
    hhb();
    hhc();
    this.CPA = new AnimatorSet();
    this.CPA.play(this.Rta).with(this.RsY);
    AppMethodBeat.o(72711);
  }
  
  private void hha()
  {
    AppMethodBeat.i(72712);
    if (this.RsY == null)
    {
      this.RsY = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.RsS, this.RsR });
      this.RsY.setDuration(this.RsO);
      this.RsY.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72712);
  }
  
  private void hhb()
  {
    AppMethodBeat.i(72713);
    this.RsM = this.height;
    if (this.Rta == null)
    {
      this.Rta = ValueAnimator.ofInt(new int[] { this.height, this.RsK });
      this.Rta.setDuration(this.RsP);
      this.Rta.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72698);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72698);
        }
      });
    }
    AppMethodBeat.o(72713);
  }
  
  private void hhc()
  {
    AppMethodBeat.i(72714);
    this.RsN = this.width;
    if (this.RsZ == null)
    {
      this.RsZ = ValueAnimator.ofInt(new int[] { this.width, this.RsL });
      this.RsZ.setDuration(this.RsP);
      this.RsZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72699);
          WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_width:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72699);
        }
      });
    }
    AppMethodBeat.o(72714);
  }
  
  private void hhe()
  {
    AppMethodBeat.i(72716);
    if (this.Rtb == null)
    {
      this.Rtb = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.RsR, this.RsS });
      this.Rtb.setDuration(this.RsO);
      this.Rtb.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72716);
  }
  
  private void hhf()
  {
    AppMethodBeat.i(72717);
    this.RsM = this.RsK;
    if (this.Rtd == null)
    {
      this.Rtd = ValueAnimator.ofInt(new int[] { this.RsK, this.height });
      this.Rtd.setDuration(this.RsP);
      this.Rtd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72700);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72700);
        }
      });
    }
    AppMethodBeat.o(72717);
  }
  
  private void hhg()
  {
    AppMethodBeat.i(72718);
    this.lup = new Paint();
    this.lup.setStrokeWidth(4.0F);
    this.lup.setStyle(Paint.Style.FILL);
    this.lup.setAntiAlias(true);
    this.lup.setColor(this.Lcg);
    this.cgU = new Paint(1);
    this.cgU.setTextSize(a.fromDPToPix(this.context, this.RsH) * a.ez(this.context));
    this.cgU.setColor(this.Lcf);
    this.cgU.setTextAlign(Paint.Align.CENTER);
    this.cgU.setAntiAlias(true);
    this.cgU.setFakeBoldText(true);
    AppMethodBeat.o(72718);
  }
  
  private void init()
  {
    AppMethodBeat.i(72703);
    amZ();
    hhg();
    AppMethodBeat.o(72703);
  }
  
  public final void U(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72709);
    if (this.RsT)
    {
      this.RsT = false;
      T(paramInt1, paramInt2, paramInt3, paramInt4);
      hgW();
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.bottomMargin = paramInt3;
    setLayoutParams(localLayoutParams);
    this.width = paramInt1;
    this.height = paramInt2;
    Log.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    this.RsN = paramInt1;
    hgZ();
    AppMethodBeat.o(72709);
  }
  
  public final void hgX()
  {
    AppMethodBeat.i(72708);
    U(this.GyC, this.GyD, this.RsU, this.RsV);
    AppMethodBeat.o(72708);
  }
  
  public final boolean hgY()
  {
    AppMethodBeat.i(72710);
    boolean bool1;
    boolean bool2;
    if (this.CPA == null)
    {
      bool1 = false;
      if (this.Rte != null) {
        break label77;
      }
      bool2 = false;
    }
    for (;;)
    {
      if ((!bool1) && (!bool2)) {
        break label114;
      }
      AppMethodBeat.o(72710);
      return true;
      if ((this.Rta == null) || (this.RsZ == null) || (this.RsY == null))
      {
        bool1 = false;
        break;
      }
      bool1 = this.CPA.isRunning();
      break;
      label77:
      if ((this.Rtd == null) || (this.Rtc == null) || (this.Rtb == null)) {
        bool2 = false;
      } else {
        bool2 = this.Rte.isRunning();
      }
    }
    label114:
    AppMethodBeat.o(72710);
    return false;
  }
  
  public final void hhd()
  {
    AppMethodBeat.i(72715);
    hhe();
    hhf();
    this.Rte = new AnimatorSet();
    this.Rte.play(this.Rtd).with(this.Rtb);
    AppMethodBeat.o(72715);
  }
  
  public final void hhh()
  {
    AppMethodBeat.i(72719);
    this.RsI = a.fromDPToPix(this.context, 4);
    this.RsM = this.height;
    this.RsN = this.width;
    setTranslationX(getTranslationX() + this.RsJ);
    invalidate();
    AppMethodBeat.o(72719);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(72706);
    super.onDraw(paramCanvas);
    Object localObject = getDrawableState();
    int i = this.RsG.getColorForState((int[])localObject, this.Lcf);
    int j = this.RsF.getColorForState((int[])localObject, this.Lcg);
    this.cgU.setColor(i);
    this.lup.setColor(j);
    this.RsW.left = 0.0F;
    this.RsW.top = ((this.height - this.RsM) / 2);
    this.RsW.right = this.RsN;
    this.RsW.bottom = ((this.height + this.RsM) / 2);
    Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", new Object[] { Float.valueOf(this.RsW.left), Float.valueOf(this.RsW.top), Float.valueOf(this.RsW.right), Float.valueOf(this.RsW.bottom), Integer.valueOf(this.RsI) });
    paramCanvas.drawRoundRect(this.RsW, this.RsI, this.RsI, this.lup);
    this.RsX.left = 0;
    this.RsX.top = 0;
    this.RsX.right = this.RsN;
    this.RsX.bottom = this.height;
    localObject = this.cgU.getFontMetricsInt();
    i = (this.RsX.bottom + this.RsX.top - ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
    paramCanvas.drawText(this.RsQ, this.RsX.centerX(), i, this.cgU);
    AppMethodBeat.o(72706);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72705);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(72705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton
 * JD-Core Version:    0.7.0.1
 */