package com.tencent.mm.wallet_core.keyboard;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class WcPayKeyboardAnimationActionButton
  extends View
{
  AnimatorSet Div;
  private int TZK;
  private int TZL;
  private int Zbm;
  private int Zbn;
  private ColorStateList agRY;
  private ColorStateList agRZ;
  private int agSa;
  private int agSb;
  private int agSc;
  private int agSd;
  private int agSe;
  private int agSf;
  private int agSg;
  private int agSh;
  String agSi;
  private float agSj;
  private float agSk;
  boolean agSl;
  private boolean agSm;
  private int agSn;
  private int agSo;
  private RectF agSp;
  private Rect agSq;
  private ObjectAnimator agSr;
  private ValueAnimator agSs;
  private ValueAnimator agSt;
  private ObjectAnimator agSu;
  private ValueAnimator agSv;
  private ValueAnimator agSw;
  AnimatorSet agSx;
  private Context context;
  private Paint dZu;
  private int height;
  private Paint rsW;
  private int text_size;
  private int width;
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72701);
    this.Zbn = getResources().getColor(a.c.wechat_green);
    this.Zbm = getResources().getColor(a.c.white_text_color_selector);
    this.text_size = 17;
    this.agSg = 300;
    this.agSh = 300;
    this.agSi = "";
    this.agSl = true;
    this.agSm = false;
    this.agSp = new RectF();
    this.agSq = new Rect();
    this.Div = new AnimatorSet();
    this.agSx = new AnimatorSet();
    init();
    AppMethodBeat.o(72701);
  }
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72702);
    this.Zbn = getResources().getColor(a.c.wechat_green);
    this.Zbm = getResources().getColor(a.c.white_text_color_selector);
    this.text_size = 17;
    this.agSg = 300;
    this.agSh = 300;
    this.agSi = "";
    this.agSl = true;
    this.agSm = false;
    this.agSp = new RectF();
    this.agSq = new Rect();
    this.Div = new AnimatorSet();
    this.agSx = new AnimatorSet();
    init();
    AppMethodBeat.o(72702);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(72704);
    this.context = MMApplicationContext.getContext();
    this.agSa = a.fromDPToPix(this.context, 4);
    this.agSb = a.fromDPToPix(this.context, 16);
    this.agSc = a.fromDPToPix(this.context, 64);
    this.agSd = a.fromDPToPix(this.context, 96);
    this.agRY = getResources().getColorStateList(a.c.wechat_green);
    this.agRZ = getResources().getColorStateList(a.c.white_text_color_selector);
    AppMethodBeat.o(72704);
  }
  
  private void ai(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.TZK = paramInt1;
    this.TZL = paramInt2;
    this.agSn = paramInt3;
    this.agSo = paramInt4;
  }
  
  private void init()
  {
    AppMethodBeat.i(72703);
    aNi();
    jOD();
    AppMethodBeat.o(72703);
  }
  
  private void jOB()
  {
    AppMethodBeat.i(72716);
    if (this.agSu == null)
    {
      this.agSu = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.agSj, this.agSk });
      this.agSu.setDuration(this.agSg);
      this.agSu.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72716);
  }
  
  private void jOC()
  {
    AppMethodBeat.i(72717);
    this.agSe = this.agSc;
    if (this.agSw == null)
    {
      this.agSw = ValueAnimator.ofInt(new int[] { this.agSc, this.height });
      this.agSw.setDuration(this.agSh);
      this.agSw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(242116);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(242116);
        }
      });
    }
    AppMethodBeat.o(72717);
  }
  
  private void jOD()
  {
    AppMethodBeat.i(72718);
    this.rsW = new Paint();
    this.rsW.setStrokeWidth(4.0F);
    this.rsW.setStyle(Paint.Style.FILL);
    this.rsW.setAntiAlias(true);
    this.rsW.setColor(this.Zbn);
    this.dZu = new Paint(1);
    this.dZu.setTextSize(a.fromDPToPix(this.context, this.text_size) * a.getScaleSize(this.context));
    this.dZu.setColor(this.Zbm);
    this.dZu.setTextAlign(Paint.Align.CENTER);
    this.dZu.setAntiAlias(true);
    this.dZu.setFakeBoldText(true);
    AppMethodBeat.o(72718);
  }
  
  private void jOt()
  {
    AppMethodBeat.i(72707);
    this.agSk = getTranslationX();
    this.agSj = (this.agSk - this.agSb);
    AppMethodBeat.o(72707);
  }
  
  private void jOw()
  {
    AppMethodBeat.i(72711);
    jOx();
    jOy();
    jOz();
    this.Div = new AnimatorSet();
    this.Div.play(this.agSt).with(this.agSr);
    AppMethodBeat.o(72711);
  }
  
  private void jOx()
  {
    AppMethodBeat.i(72712);
    if (this.agSr == null)
    {
      this.agSr = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.agSk, this.agSj });
      this.agSr.setDuration(this.agSg);
      this.agSr.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72712);
  }
  
  private void jOy()
  {
    AppMethodBeat.i(72713);
    this.agSe = this.height;
    if (this.agSt == null)
    {
      this.agSt = ValueAnimator.ofInt(new int[] { this.height, this.agSc });
      this.agSt.setDuration(this.agSh);
      this.agSt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72698);
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_height:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this)) });
          if (WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this) <= WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this))
          {
            WcPayKeyboardAnimationActionButton.c(WcPayKeyboardAnimationActionButton.this);
            paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)WcPayKeyboardAnimationActionButton.this.getLayoutParams();
            paramAnonymousValueAnimator.height = ((WcPayKeyboardAnimationActionButton.d(WcPayKeyboardAnimationActionButton.this) - WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this)) / 2 + WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this));
            WcPayKeyboardAnimationActionButton.this.setLayoutParams(paramAnonymousValueAnimator);
          }
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72698);
        }
      });
      this.agSt.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(242120);
          WcPayKeyboardAnimationActionButton.c(WcPayKeyboardAnimationActionButton.this);
          paramAnonymousAnimator = (RelativeLayout.LayoutParams)WcPayKeyboardAnimationActionButton.this.getLayoutParams();
          paramAnonymousAnimator.height = ((WcPayKeyboardAnimationActionButton.d(WcPayKeyboardAnimationActionButton.this) - WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this)) / 2 + WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this));
          WcPayKeyboardAnimationActionButton.this.setLayoutParams(paramAnonymousAnimator);
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(242120);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    AppMethodBeat.o(72713);
  }
  
  private void jOz()
  {
    AppMethodBeat.i(72714);
    this.agSf = this.width;
    if (this.agSs == null)
    {
      this.agSs = ValueAnimator.ofInt(new int[] { this.width, this.agSd });
      this.agSs.setDuration(this.agSh);
      this.agSs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(72700);
          WcPayKeyboardAnimationActionButton.b(WcPayKeyboardAnimationActionButton.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "interim_width:%s", new Object[] { Integer.valueOf(WcPayKeyboardAnimationActionButton.e(WcPayKeyboardAnimationActionButton.this)) });
          WcPayKeyboardAnimationActionButton.this.invalidate();
          AppMethodBeat.o(72700);
        }
      });
    }
    AppMethodBeat.o(72714);
  }
  
  public final void aj(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72709);
    if (this.agSl)
    {
      this.agSl = false;
      ai(paramInt1, paramInt2, paramInt3, paramInt4);
      jOt();
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.bottomMargin = paramInt3;
    setLayoutParams(localLayoutParams);
    this.width = paramInt1;
    this.height = paramInt2;
    Log.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    this.agSf = paramInt1;
    jOw();
    AppMethodBeat.o(72709);
  }
  
  public final void jOA()
  {
    AppMethodBeat.i(72715);
    jOB();
    jOC();
    this.agSm = false;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.height = this.height;
    setLayoutParams(localLayoutParams);
    this.agSx = new AnimatorSet();
    this.agSx.play(this.agSw).with(this.agSu);
    AppMethodBeat.o(72715);
  }
  
  public final void jOE()
  {
    AppMethodBeat.i(72719);
    this.agSa = a.fromDPToPix(this.context, 4);
    this.agSe = this.height;
    this.agSf = this.width;
    setTranslationX(getTranslationX() + this.agSb);
    invalidate();
    AppMethodBeat.o(72719);
  }
  
  public final void jOu()
  {
    AppMethodBeat.i(72708);
    aj(this.TZK, this.TZL, this.agSn, this.agSo);
    AppMethodBeat.o(72708);
  }
  
  public final boolean jOv()
  {
    AppMethodBeat.i(72710);
    boolean bool1;
    boolean bool2;
    if (this.Div == null)
    {
      bool1 = false;
      if (this.agSx != null) {
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
      if ((this.agSt == null) || (this.agSs == null) || (this.agSr == null))
      {
        bool1 = false;
        break;
      }
      bool1 = this.Div.isRunning();
      break;
      label77:
      if ((this.agSw == null) || (this.agSv == null) || (this.agSu == null)) {
        bool2 = false;
      } else {
        bool2 = this.agSx.isRunning();
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
    int i = this.agRZ.getColorForState((int[])localObject, this.Zbm);
    int j = this.agRY.getColorForState((int[])localObject, this.Zbn);
    this.dZu.setColor(i);
    this.rsW.setColor(j);
    if (this.agSm)
    {
      this.agSp.left = 0.0F;
      this.agSp.top = 0.0F;
      this.agSp.right = this.agSf;
      this.agSp.bottom = this.agSe;
      Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", new Object[] { Float.valueOf(this.agSp.left), Float.valueOf(this.agSp.top), Float.valueOf(this.agSp.right), Float.valueOf(this.agSp.bottom), Integer.valueOf(this.agSa) });
      paramCanvas.drawRoundRect(this.agSp, this.agSa, this.agSa, this.rsW);
      if (!this.agSm) {
        break label379;
      }
      this.agSq.left = 0;
      this.agSq.top = 0;
      this.agSq.right = this.agSf;
    }
    for (this.agSq.bottom = this.agSc;; this.agSq.bottom = this.height)
    {
      localObject = this.dZu.getFontMetricsInt();
      i = (this.agSq.bottom + this.agSq.top - ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
      paramCanvas.drawText(this.agSi, this.agSq.centerX(), i, this.dZu);
      AppMethodBeat.o(72706);
      return;
      this.agSp.left = 0.0F;
      this.agSp.top = ((this.height - this.agSe) / 2);
      this.agSp.right = this.agSf;
      this.agSp.bottom = ((this.height + this.agSe) / 2);
      break;
      label379:
      this.agSq.left = 0;
      this.agSq.top = 0;
      this.agSq.right = this.agSf;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72705);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(72705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton
 * JD-Core Version:    0.7.0.1
 */