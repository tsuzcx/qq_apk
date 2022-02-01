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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public class WcPayKeyboardAnimationActionButton
  extends View
{
  private int BWV;
  private int BWW;
  private int GhC;
  private int GhD;
  private ColorStateList LTO;
  private ColorStateList LTP;
  private int LTQ;
  private int LTS;
  private int LTT;
  private int LTU;
  private int LTV;
  private int LTW;
  private int LTX;
  private int LTY;
  private int LTZ;
  String LUa;
  private float LUb;
  private float LUc;
  boolean LUd;
  private int LUe;
  private int LUf;
  private RectF LUg;
  private Rect LUh;
  private ObjectAnimator LUi;
  private ValueAnimator LUj;
  private ValueAnimator LUk;
  private ObjectAnimator LUl;
  private ValueAnimator LUm;
  private ValueAnimator LUn;
  AnimatorSet LUo;
  private Paint bWm;
  private Context context;
  private int height;
  private Paint kqH;
  private int width;
  AnimatorSet yLH;
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72701);
    this.GhD = getResources().getColor(2131101171);
    this.GhC = getResources().getColor(2131101185);
    this.LTQ = 17;
    this.LTY = 300;
    this.LTZ = 300;
    this.LUa = "";
    this.LUd = true;
    this.LUg = new RectF();
    this.LUh = new Rect();
    this.yLH = new AnimatorSet();
    this.LUo = new AnimatorSet();
    init();
    AppMethodBeat.o(72701);
  }
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72702);
    this.GhD = getResources().getColor(2131101171);
    this.GhC = getResources().getColor(2131101185);
    this.LTQ = 17;
    this.LTY = 300;
    this.LTZ = 300;
    this.LUa = "";
    this.LUd = true;
    this.LUg = new RectF();
    this.LUh = new Rect();
    this.yLH = new AnimatorSet();
    this.LUo = new AnimatorSet();
    init();
    AppMethodBeat.o(72702);
  }
  
  private void U(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.BWV = paramInt1;
    this.BWW = paramInt2;
    this.LUe = paramInt3;
    this.LUf = paramInt4;
  }
  
  private void Zm()
  {
    AppMethodBeat.i(72704);
    this.context = ak.getContext();
    this.LTS = a.fromDPToPix(this.context, 4);
    this.LTT = a.fromDPToPix(this.context, 16);
    this.LTU = a.fromDPToPix(this.context, 64);
    this.LTV = a.fromDPToPix(this.context, 96);
    this.LTO = getResources().getColorStateList(2131101171);
    this.LTP = getResources().getColorStateList(2131101185);
    AppMethodBeat.o(72704);
  }
  
  private void fVC()
  {
    AppMethodBeat.i(72711);
    fVD();
    fVE();
    fVF();
    this.yLH = new AnimatorSet();
    this.yLH.play(this.LUk).with(this.LUi);
    AppMethodBeat.o(72711);
  }
  
  private void fVD()
  {
    AppMethodBeat.i(72712);
    if (this.LUi == null)
    {
      this.LUi = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.LUc, this.LUb });
      this.LUi.setDuration(this.LTY);
      this.LUi.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72712);
  }
  
  private void fVE()
  {
    AppMethodBeat.i(72713);
    this.LTW = this.height;
    if (this.LUk == null)
    {
      this.LUk = ValueAnimator.ofInt(new int[] { this.height, this.LTU });
      this.LUk.setDuration(this.LTZ);
      this.LUk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72698);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ae.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72698);
        }
      });
    }
    AppMethodBeat.o(72713);
  }
  
  private void fVF()
  {
    AppMethodBeat.i(72714);
    this.LTX = this.width;
    if (this.LUj == null)
    {
      this.LUj = ValueAnimator.ofInt(new int[] { this.width, this.LTV });
      this.LUj.setDuration(this.LTZ);
      this.LUj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72699);
          WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ae.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_width:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72699);
        }
      });
    }
    AppMethodBeat.o(72714);
  }
  
  private void fVH()
  {
    AppMethodBeat.i(72716);
    if (this.LUl == null)
    {
      this.LUl = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.LUb, this.LUc });
      this.LUl.setDuration(this.LTY);
      this.LUl.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72716);
  }
  
  private void fVI()
  {
    AppMethodBeat.i(72717);
    this.LTW = this.LTU;
    if (this.LUn == null)
    {
      this.LUn = ValueAnimator.ofInt(new int[] { this.LTU, this.height });
      this.LUn.setDuration(this.LTZ);
      this.LUn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72700);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          ae.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72700);
        }
      });
    }
    AppMethodBeat.o(72717);
  }
  
  private void fVJ()
  {
    AppMethodBeat.i(72718);
    this.kqH = new Paint();
    this.kqH.setStrokeWidth(4.0F);
    this.kqH.setStyle(Paint.Style.FILL);
    this.kqH.setAntiAlias(true);
    this.kqH.setColor(this.GhD);
    this.bWm = new Paint(1);
    this.bWm.setTextSize(a.fromDPToPix(this.context, this.LTQ) * a.ef(this.context));
    this.bWm.setColor(this.GhC);
    this.bWm.setTextAlign(Paint.Align.CENTER);
    this.bWm.setAntiAlias(true);
    this.bWm.setFakeBoldText(true);
    AppMethodBeat.o(72718);
  }
  
  private void fVz()
  {
    AppMethodBeat.i(72707);
    this.LUc = getTranslationX();
    this.LUb = (this.LUc - this.LTT);
    AppMethodBeat.o(72707);
  }
  
  private void init()
  {
    AppMethodBeat.i(72703);
    Zm();
    fVJ();
    AppMethodBeat.o(72703);
  }
  
  public final void V(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72709);
    if (this.LUd)
    {
      this.LUd = false;
      U(paramInt1, paramInt2, paramInt3, paramInt4);
      fVz();
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.bottomMargin = paramInt3;
    setLayoutParams(localLayoutParams);
    this.width = paramInt1;
    this.height = paramInt2;
    ae.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    this.LTX = paramInt1;
    fVC();
    AppMethodBeat.o(72709);
  }
  
  public final void fVA()
  {
    AppMethodBeat.i(72708);
    V(this.BWV, this.BWW, this.LUe, this.LUf);
    AppMethodBeat.o(72708);
  }
  
  public final boolean fVB()
  {
    AppMethodBeat.i(72710);
    boolean bool1;
    boolean bool2;
    if (this.yLH == null)
    {
      bool1 = false;
      if (this.LUo != null) {
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
      if ((this.LUk == null) || (this.LUj == null) || (this.LUi == null))
      {
        bool1 = false;
        break;
      }
      bool1 = this.yLH.isRunning();
      break;
      label77:
      if ((this.LUn == null) || (this.LUm == null) || (this.LUl == null)) {
        bool2 = false;
      } else {
        bool2 = this.LUo.isRunning();
      }
    }
    label114:
    AppMethodBeat.o(72710);
    return false;
  }
  
  public final void fVG()
  {
    AppMethodBeat.i(72715);
    fVH();
    fVI();
    this.LUo = new AnimatorSet();
    this.LUo.play(this.LUn).with(this.LUl);
    AppMethodBeat.o(72715);
  }
  
  public final void fVK()
  {
    AppMethodBeat.i(72719);
    this.LTS = a.fromDPToPix(this.context, 4);
    this.LTW = this.height;
    this.LTX = this.width;
    setTranslationX(getTranslationX() + this.LTT);
    invalidate();
    AppMethodBeat.o(72719);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(72706);
    super.onDraw(paramCanvas);
    Object localObject = getDrawableState();
    int i = this.LTP.getColorForState((int[])localObject, this.GhC);
    int j = this.LTO.getColorForState((int[])localObject, this.GhD);
    this.bWm.setColor(i);
    this.kqH.setColor(j);
    this.LUg.left = 0.0F;
    this.LUg.top = ((this.height - this.LTW) / 2);
    this.LUg.right = this.LTX;
    this.LUg.bottom = ((this.height + this.LTW) / 2);
    ae.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", new Object[] { Float.valueOf(this.LUg.left), Float.valueOf(this.LUg.top), Float.valueOf(this.LUg.right), Float.valueOf(this.LUg.bottom), Integer.valueOf(this.LTS) });
    paramCanvas.drawRoundRect(this.LUg, this.LTS, this.LTS, this.kqH);
    this.LUh.left = 0;
    this.LUh.top = 0;
    this.LUh.right = this.LTX;
    this.LUh.bottom = this.height;
    localObject = this.bWm.getFontMetricsInt();
    i = (this.LUh.bottom + this.LUh.top - ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
    paramCanvas.drawText(this.LUa, this.LUh.centerX(), i, this.bWm);
    AppMethodBeat.o(72706);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72705);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(72705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton
 * JD-Core Version:    0.7.0.1
 */