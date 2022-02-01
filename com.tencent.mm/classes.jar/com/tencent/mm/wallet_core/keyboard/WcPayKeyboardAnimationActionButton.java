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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public class WcPayKeyboardAnimationActionButton
  extends View
{
  private int Ank;
  private int Anl;
  private int JDU;
  private int JDV;
  private ColorStateList JDW;
  private ColorStateList JDX;
  private int JDY;
  private int JDZ;
  private int JEa;
  private int JEb;
  private int JEc;
  private int JEd;
  private int JEe;
  private int JEf;
  private int JEg;
  String JEh;
  private float JEi;
  private float JEj;
  boolean JEk;
  private int JEl;
  private int JEm;
  private RectF JEn;
  private Rect JEo;
  private ObjectAnimator JEp;
  private ValueAnimator JEq;
  private ValueAnimator JEr;
  private ObjectAnimator JEs;
  private ValueAnimator JEt;
  private ValueAnimator JEu;
  AnimatorSet JEv;
  private Paint bLZ;
  private Context context;
  private int height;
  private Paint jTd;
  private int width;
  AnimatorSet xhG;
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72701);
    this.JDU = getResources().getColor(2131101171);
    this.JDV = getResources().getColor(2131101185);
    this.JDY = 17;
    this.JEf = 300;
    this.JEg = 300;
    this.JEh = "";
    this.JEk = true;
    this.JEn = new RectF();
    this.JEo = new Rect();
    this.xhG = new AnimatorSet();
    this.JEv = new AnimatorSet();
    init();
    AppMethodBeat.o(72701);
  }
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72702);
    this.JDU = getResources().getColor(2131101171);
    this.JDV = getResources().getColor(2131101185);
    this.JDY = 17;
    this.JEf = 300;
    this.JEg = 300;
    this.JEh = "";
    this.JEk = true;
    this.JEn = new RectF();
    this.JEo = new Rect();
    this.xhG = new AnimatorSet();
    this.JEv = new AnimatorSet();
    init();
    AppMethodBeat.o(72702);
  }
  
  private void U(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Ank = paramInt1;
    this.Anl = paramInt2;
    this.JEl = paramInt3;
    this.JEm = paramInt4;
  }
  
  private void WJ()
  {
    AppMethodBeat.i(72704);
    this.context = ai.getContext();
    this.JDZ = a.fromDPToPix(this.context, 4);
    this.JEa = a.fromDPToPix(this.context, 16);
    this.JEb = a.fromDPToPix(this.context, 64);
    this.JEc = a.fromDPToPix(this.context, 96);
    this.JDW = getResources().getColorStateList(2131101171);
    this.JDX = getResources().getColorStateList(2131101185);
    AppMethodBeat.o(72704);
  }
  
  private void fAb()
  {
    AppMethodBeat.i(72716);
    if (this.JEs == null)
    {
      this.JEs = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.JEi, this.JEj });
      this.JEs.setDuration(this.JEf);
      this.JEs.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72716);
  }
  
  private void fAc()
  {
    AppMethodBeat.i(72717);
    this.JEd = this.JEb;
    if (this.JEu == null)
    {
      this.JEu = ValueAnimator.ofInt(new int[] { this.JEb, this.height });
      this.JEu.setDuration(this.JEg);
      this.JEu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72700);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ac.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72700);
        }
      });
    }
    AppMethodBeat.o(72717);
  }
  
  private void fAd()
  {
    AppMethodBeat.i(72718);
    this.jTd = new Paint();
    this.jTd.setStrokeWidth(4.0F);
    this.jTd.setStyle(Paint.Style.FILL);
    this.jTd.setAntiAlias(true);
    this.jTd.setColor(this.JDU);
    this.bLZ = new Paint(1);
    this.bLZ.setTextSize(a.fromDPToPix(this.context, this.JDY) * a.eb(this.context));
    this.bLZ.setColor(this.JDV);
    this.bLZ.setTextAlign(Paint.Align.CENTER);
    this.bLZ.setAntiAlias(true);
    this.bLZ.setFakeBoldText(true);
    AppMethodBeat.o(72718);
  }
  
  private void fzT()
  {
    AppMethodBeat.i(72707);
    this.JEj = getTranslationX();
    this.JEi = (this.JEj - this.JEa);
    AppMethodBeat.o(72707);
  }
  
  private void fzW()
  {
    AppMethodBeat.i(72711);
    fzX();
    fzY();
    fzZ();
    this.xhG = new AnimatorSet();
    this.xhG.play(this.JEr).with(this.JEp);
    AppMethodBeat.o(72711);
  }
  
  private void fzX()
  {
    AppMethodBeat.i(72712);
    if (this.JEp == null)
    {
      this.JEp = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.JEj, this.JEi });
      this.JEp.setDuration(this.JEf);
      this.JEp.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72712);
  }
  
  private void fzY()
  {
    AppMethodBeat.i(72713);
    this.JEd = this.height;
    if (this.JEr == null)
    {
      this.JEr = ValueAnimator.ofInt(new int[] { this.height, this.JEb });
      this.JEr.setDuration(this.JEg);
      this.JEr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72698);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ac.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72698);
        }
      });
    }
    AppMethodBeat.o(72713);
  }
  
  private void fzZ()
  {
    AppMethodBeat.i(72714);
    this.JEe = this.width;
    if (this.JEq == null)
    {
      this.JEq = ValueAnimator.ofInt(new int[] { this.width, this.JEc });
      this.JEq.setDuration(this.JEg);
      this.JEq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72699);
          WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ac.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_width:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72699);
        }
      });
    }
    AppMethodBeat.o(72714);
  }
  
  private void init()
  {
    AppMethodBeat.i(72703);
    WJ();
    fAd();
    AppMethodBeat.o(72703);
  }
  
  public final void V(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72709);
    if (this.JEk)
    {
      this.JEk = false;
      U(paramInt1, paramInt2, paramInt3, paramInt4);
      fzT();
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.bottomMargin = paramInt3;
    setLayoutParams(localLayoutParams);
    this.width = paramInt1;
    this.height = paramInt2;
    ac.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    this.JEe = paramInt1;
    fzW();
    AppMethodBeat.o(72709);
  }
  
  public final void fAa()
  {
    AppMethodBeat.i(72715);
    fAb();
    fAc();
    this.JEv = new AnimatorSet();
    this.JEv.play(this.JEu).with(this.JEs);
    AppMethodBeat.o(72715);
  }
  
  public final void fAe()
  {
    AppMethodBeat.i(72719);
    this.JDZ = a.fromDPToPix(this.context, 4);
    this.JEd = this.height;
    this.JEe = this.width;
    setTranslationX(getTranslationX() + this.JEa);
    invalidate();
    AppMethodBeat.o(72719);
  }
  
  public final void fzU()
  {
    AppMethodBeat.i(72708);
    V(this.Ank, this.Anl, this.JEl, this.JEm);
    AppMethodBeat.o(72708);
  }
  
  public final boolean fzV()
  {
    AppMethodBeat.i(72710);
    boolean bool1;
    boolean bool2;
    if (this.xhG == null)
    {
      bool1 = false;
      if (this.JEv != null) {
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
      if ((this.JEr == null) || (this.JEq == null) || (this.JEp == null))
      {
        bool1 = false;
        break;
      }
      bool1 = this.xhG.isRunning();
      break;
      label77:
      if ((this.JEu == null) || (this.JEt == null) || (this.JEs == null)) {
        bool2 = false;
      } else {
        bool2 = this.JEv.isRunning();
      }
    }
    label114:
    AppMethodBeat.o(72710);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(72706);
    super.onDraw(paramCanvas);
    Object localObject = getDrawableState();
    int i = this.JDX.getColorForState((int[])localObject, this.JDV);
    int j = this.JDW.getColorForState((int[])localObject, this.JDU);
    this.bLZ.setColor(i);
    this.jTd.setColor(j);
    this.JEn.left = 0.0F;
    this.JEn.top = ((this.height - this.JEd) / 2);
    this.JEn.right = this.JEe;
    this.JEn.bottom = ((this.height + this.JEd) / 2);
    ac.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", new Object[] { Float.valueOf(this.JEn.left), Float.valueOf(this.JEn.top), Float.valueOf(this.JEn.right), Float.valueOf(this.JEn.bottom), Integer.valueOf(this.JDZ) });
    paramCanvas.drawRoundRect(this.JEn, this.JDZ, this.JDZ, this.jTd);
    this.JEo.left = 0;
    this.JEo.top = 0;
    this.JEo.right = this.JEe;
    this.JEo.bottom = this.height;
    localObject = this.bLZ.getFontMetricsInt();
    i = (this.JEo.bottom + this.JEo.top - ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
    paramCanvas.drawText(this.JEh, this.JEo.centerX(), i, this.bLZ);
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