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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class WcPayKeyboardAnimationActionButton
  extends View
{
  private int BBm;
  private int CeA;
  private int IcA;
  private int IcB;
  private int IcC;
  private int IcD;
  private int IcE;
  String IcF;
  private float IcG;
  private float IcH;
  boolean IcI;
  private int IcJ;
  private int IcK;
  private RectF IcL;
  private Rect IcM;
  private ObjectAnimator IcN;
  private ValueAnimator IcO;
  private ValueAnimator IcP;
  private ObjectAnimator IcQ;
  private ValueAnimator IcR;
  private ValueAnimator IcS;
  AnimatorSet IcT;
  private int Ics;
  private int Ict;
  private ColorStateList Icu;
  private ColorStateList Icv;
  private int Icw;
  private int Icx;
  private int Icy;
  private int Icz;
  private Paint bOr;
  private Context context;
  private int height;
  private Paint jsJ;
  AnimatorSet vWT;
  private int width;
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72701);
    this.Ics = getResources().getColor(2131101171);
    this.Ict = getResources().getColor(2131101185);
    this.Icw = 17;
    this.IcD = 300;
    this.IcE = 300;
    this.IcF = "";
    this.IcI = true;
    this.IcL = new RectF();
    this.IcM = new Rect();
    this.vWT = new AnimatorSet();
    this.IcT = new AnimatorSet();
    init();
    AppMethodBeat.o(72701);
  }
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72702);
    this.Ics = getResources().getColor(2131101171);
    this.Ict = getResources().getColor(2131101185);
    this.Icw = 17;
    this.IcD = 300;
    this.IcE = 300;
    this.IcF = "";
    this.IcI = true;
    this.IcL = new RectF();
    this.IcM = new Rect();
    this.vWT = new AnimatorSet();
    this.IcT = new AnimatorSet();
    init();
    AppMethodBeat.o(72702);
  }
  
  private void S(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.BBm = paramInt1;
    this.CeA = paramInt2;
    this.IcJ = paramInt3;
    this.IcK = paramInt4;
  }
  
  private void VL()
  {
    AppMethodBeat.i(72704);
    this.context = aj.getContext();
    this.Icx = a.fromDPToPix(this.context, 4);
    this.Icy = a.fromDPToPix(this.context, 16);
    this.Icz = a.fromDPToPix(this.context, 64);
    this.IcA = a.fromDPToPix(this.context, 96);
    this.Icu = getResources().getColorStateList(2131101171);
    this.Icv = getResources().getColorStateList(2131101185);
    AppMethodBeat.o(72704);
  }
  
  private void fjE()
  {
    AppMethodBeat.i(72707);
    this.IcH = getTranslationX();
    this.IcG = (this.IcH - this.Icy);
    AppMethodBeat.o(72707);
  }
  
  private void fjH()
  {
    AppMethodBeat.i(72711);
    fjI();
    fjJ();
    fjK();
    this.vWT = new AnimatorSet();
    this.vWT.play(this.IcP).with(this.IcN);
    AppMethodBeat.o(72711);
  }
  
  private void fjI()
  {
    AppMethodBeat.i(72712);
    if (this.IcN == null)
    {
      this.IcN = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.IcH, this.IcG });
      this.IcN.setDuration(this.IcD);
      this.IcN.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72712);
  }
  
  private void fjJ()
  {
    AppMethodBeat.i(72713);
    this.IcB = this.height;
    if (this.IcP == null)
    {
      this.IcP = ValueAnimator.ofInt(new int[] { this.height, this.Icz });
      this.IcP.setDuration(this.IcE);
      this.IcP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72698);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ad.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72698);
        }
      });
    }
    AppMethodBeat.o(72713);
  }
  
  private void fjK()
  {
    AppMethodBeat.i(72714);
    this.IcC = this.width;
    if (this.IcO == null)
    {
      this.IcO = ValueAnimator.ofInt(new int[] { this.width, this.IcA });
      this.IcO.setDuration(this.IcE);
      this.IcO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72699);
          WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ad.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_width:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72699);
        }
      });
    }
    AppMethodBeat.o(72714);
  }
  
  private void fjM()
  {
    AppMethodBeat.i(72716);
    if (this.IcQ == null)
    {
      this.IcQ = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.IcG, this.IcH });
      this.IcQ.setDuration(this.IcD);
      this.IcQ.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72716);
  }
  
  private void fjN()
  {
    AppMethodBeat.i(72717);
    this.IcB = this.Icz;
    if (this.IcS == null)
    {
      this.IcS = ValueAnimator.ofInt(new int[] { this.Icz, this.height });
      this.IcS.setDuration(this.IcE);
      this.IcS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72700);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ad.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72700);
        }
      });
    }
    AppMethodBeat.o(72717);
  }
  
  private void fjO()
  {
    AppMethodBeat.i(72718);
    this.jsJ = new Paint();
    this.jsJ.setStrokeWidth(4.0F);
    this.jsJ.setStyle(Paint.Style.FILL);
    this.jsJ.setAntiAlias(true);
    this.jsJ.setColor(this.Ics);
    this.bOr = new Paint(1);
    this.bOr.setTextSize(a.fromDPToPix(this.context, this.Icw) * a.dT(this.context));
    this.bOr.setColor(this.Ict);
    this.bOr.setTextAlign(Paint.Align.CENTER);
    this.bOr.setAntiAlias(true);
    this.bOr.setFakeBoldText(true);
    AppMethodBeat.o(72718);
  }
  
  private void init()
  {
    AppMethodBeat.i(72703);
    VL();
    fjO();
    AppMethodBeat.o(72703);
  }
  
  public final void T(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72709);
    if (this.IcI)
    {
      this.IcI = false;
      S(paramInt1, paramInt2, paramInt3, paramInt4);
      fjE();
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.bottomMargin = paramInt3;
    setLayoutParams(localLayoutParams);
    this.width = paramInt1;
    this.height = paramInt2;
    ad.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    this.IcC = paramInt1;
    fjH();
    AppMethodBeat.o(72709);
  }
  
  public final void fjF()
  {
    AppMethodBeat.i(72708);
    T(this.BBm, this.CeA, this.IcJ, this.IcK);
    AppMethodBeat.o(72708);
  }
  
  public final boolean fjG()
  {
    AppMethodBeat.i(72710);
    boolean bool1;
    boolean bool2;
    if (this.vWT == null)
    {
      bool1 = false;
      if (this.IcT != null) {
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
      if ((this.IcP == null) || (this.IcO == null) || (this.IcN == null))
      {
        bool1 = false;
        break;
      }
      bool1 = this.vWT.isRunning();
      break;
      label77:
      if ((this.IcS == null) || (this.IcR == null) || (this.IcQ == null)) {
        bool2 = false;
      } else {
        bool2 = this.IcT.isRunning();
      }
    }
    label114:
    AppMethodBeat.o(72710);
    return false;
  }
  
  public final void fjL()
  {
    AppMethodBeat.i(72715);
    fjM();
    fjN();
    this.IcT = new AnimatorSet();
    this.IcT.play(this.IcS).with(this.IcQ);
    AppMethodBeat.o(72715);
  }
  
  public final void fjP()
  {
    AppMethodBeat.i(72719);
    this.Icx = a.fromDPToPix(this.context, 4);
    this.IcB = this.height;
    this.IcC = this.width;
    setTranslationX(getTranslationX() + this.Icy);
    invalidate();
    AppMethodBeat.o(72719);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(72706);
    super.onDraw(paramCanvas);
    Object localObject = getDrawableState();
    int i = this.Icv.getColorForState((int[])localObject, this.Ict);
    int j = this.Icu.getColorForState((int[])localObject, this.Ics);
    this.bOr.setColor(i);
    this.jsJ.setColor(j);
    this.IcL.left = 0.0F;
    this.IcL.top = ((this.height - this.IcB) / 2);
    this.IcL.right = this.IcC;
    this.IcL.bottom = ((this.height + this.IcB) / 2);
    ad.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", new Object[] { Float.valueOf(this.IcL.left), Float.valueOf(this.IcL.top), Float.valueOf(this.IcL.right), Float.valueOf(this.IcL.bottom), Integer.valueOf(this.Icx) });
    paramCanvas.drawRoundRect(this.IcL, this.Icx, this.Icx, this.jsJ);
    this.IcM.left = 0;
    this.IcM.top = 0;
    this.IcM.right = this.IcC;
    this.IcM.bottom = this.height;
    localObject = this.bOr.getFontMetricsInt();
    i = (this.IcM.bottom + this.IcM.top - ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
    paramCanvas.drawText(this.IcF, this.IcM.centerX(), i, this.bOr);
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