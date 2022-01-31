package com.tencent.mm.wallet_core.keyboard;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public class WcPayKeyboardAnimationActionButton
  extends View
{
  AnimatorSet AWA;
  private WcPayKeyboardAnimationActionButton.a AWd;
  private int AWe;
  private int AWf;
  private ColorStateList AWg;
  private ColorStateList AWh;
  private int AWi;
  private int AWj;
  private int AWk;
  private int AWl;
  private int AWm;
  private int AWn;
  private int AWo;
  private int AWp;
  private int AWq;
  String AWr;
  private RectF AWs;
  private Rect AWt;
  private ObjectAnimator AWu;
  private ValueAnimator AWv;
  private ValueAnimator AWw;
  private ObjectAnimator AWx;
  private ValueAnimator AWy;
  private ValueAnimator AWz;
  private Paint Arz;
  private Context context;
  private int height;
  private Paint huv;
  AnimatorSet seX;
  private int width;
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(142637);
    this.AWe = getResources().getColor(2131690701);
    this.AWf = getResources().getColor(2131690799);
    this.AWi = 17;
    this.AWp = 300;
    this.AWq = 300;
    this.AWs = new RectF();
    this.AWt = new Rect();
    this.seX = new AnimatorSet();
    this.AWA = new AnimatorSet();
    init();
    AppMethodBeat.o(142637);
  }
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142638);
    this.AWe = getResources().getColor(2131690701);
    this.AWf = getResources().getColor(2131690799);
    this.AWi = 17;
    this.AWp = 300;
    this.AWq = 300;
    this.AWs = new RectF();
    this.AWt = new Rect();
    this.seX = new AnimatorSet();
    this.AWA = new AnimatorSet();
    init();
    AppMethodBeat.o(142638);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(142640);
    this.context = ah.getContext();
    this.AWj = a.fromDPToPix(this.context, 4);
    this.AWk = a.fromDPToPix(this.context, 16);
    this.AWl = a.fromDPToPix(this.context, 64);
    this.AWm = a.fromDPToPix(this.context, 96);
    this.AWg = getResources().getColorStateList(2131690701);
    this.AWh = getResources().getColorStateList(2131690799);
    AppMethodBeat.o(142640);
  }
  
  private void dRY()
  {
    AppMethodBeat.i(142644);
    dRZ();
    dSa();
    dSb();
    this.seX.play(this.AWw).with(this.AWv).with(this.AWu);
    AppMethodBeat.o(142644);
  }
  
  private void dRZ()
  {
    AppMethodBeat.i(142645);
    float f = getTranslationX();
    this.AWu = ObjectAnimator.ofFloat(this, "translationX", new float[] { f, f - this.AWk });
    this.AWu.setDuration(this.AWp);
    this.AWu.setInterpolator(new AccelerateDecelerateInterpolator());
    AppMethodBeat.o(142645);
  }
  
  private void dSa()
  {
    AppMethodBeat.i(142646);
    this.AWn = this.height;
    this.AWw = ValueAnimator.ofInt(new int[] { this.height, this.AWl });
    this.AWw.setDuration(this.AWq);
    this.AWw.addUpdateListener(new WcPayKeyboardAnimationActionButton.3(this));
    AppMethodBeat.o(142646);
  }
  
  private void dSb()
  {
    AppMethodBeat.i(142647);
    this.AWo = this.width;
    this.AWv = ValueAnimator.ofInt(new int[] { this.width, this.AWm });
    this.AWv.setDuration(this.AWq);
    this.AWv.addUpdateListener(new WcPayKeyboardAnimationActionButton.4(this));
    AppMethodBeat.o(142647);
  }
  
  private void dSd()
  {
    AppMethodBeat.i(155659);
    float f = getTranslationX();
    this.AWx = ObjectAnimator.ofFloat(this, "translationX", new float[] { f, f + this.AWk });
    this.AWx.setDuration(this.AWp);
    this.AWx.setInterpolator(new AccelerateDecelerateInterpolator());
    AppMethodBeat.o(155659);
  }
  
  private void dSe()
  {
    AppMethodBeat.i(155660);
    this.AWn = this.AWl;
    this.AWz = ValueAnimator.ofInt(new int[] { this.AWl, this.height });
    this.AWz.setDuration(this.AWq);
    this.AWz.addUpdateListener(new WcPayKeyboardAnimationActionButton.5(this));
    AppMethodBeat.o(155660);
  }
  
  private void dSf()
  {
    AppMethodBeat.i(155661);
    this.AWo = this.AWm;
    this.AWy = ValueAnimator.ofInt(new int[] { this.AWm, this.width });
    this.AWy.setDuration(this.AWq);
    this.AWy.addUpdateListener(new WcPayKeyboardAnimationActionButton.6(this));
    AppMethodBeat.o(155661);
  }
  
  private void dSg()
  {
    AppMethodBeat.i(142648);
    this.huv = new Paint();
    this.huv.setStrokeWidth(4.0F);
    this.huv.setStyle(Paint.Style.FILL);
    this.huv.setAntiAlias(true);
    this.huv.setColor(this.AWe);
    this.Arz = new Paint(1);
    this.Arz.setTextSize(a.fromDPToPix(this.context, this.AWi));
    this.Arz.setColor(this.AWf);
    this.Arz.setTextAlign(Paint.Align.CENTER);
    this.Arz.setAntiAlias(true);
    this.Arz.setFakeBoldText(true);
    AppMethodBeat.o(142648);
  }
  
  private void init()
  {
    AppMethodBeat.i(142639);
    Kc();
    dSg();
    setOnClickListener(new WcPayKeyboardAnimationActionButton.1(this));
    this.seX.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(142634);
        if (WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this) != null) {
          WcPayKeyboardAnimationActionButton.a(WcPayKeyboardAnimationActionButton.this).dRX();
        }
        AppMethodBeat.o(142634);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    AppMethodBeat.o(142639);
  }
  
  public final void O(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142643);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    if (paramInt1 > this.AWm) {}
    for (int i = paramInt1;; i = this.AWm)
    {
      localLayoutParams.width = i;
      localLayoutParams.height = paramInt2;
      localLayoutParams.topMargin = paramInt3;
      localLayoutParams.leftMargin = paramInt4;
      setLayoutParams(localLayoutParams);
      this.width = paramInt1;
      this.height = paramInt2;
      ab.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
      dRY();
      AppMethodBeat.o(142643);
      return;
    }
  }
  
  public final void dSc()
  {
    AppMethodBeat.i(155658);
    dSd();
    dSe();
    dSf();
    this.AWA.play(this.AWz).with(this.AWy).with(this.AWx);
    AppMethodBeat.o(155658);
  }
  
  public final void dSh()
  {
    AppMethodBeat.i(155662);
    this.AWj = a.fromDPToPix(this.context, 4);
    this.AWn = this.height;
    this.AWo = this.width;
    setTranslationX(getTranslationX() + this.AWk);
    invalidate();
    AppMethodBeat.o(155662);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(142642);
    super.onDraw(paramCanvas);
    Object localObject = getDrawableState();
    int i = this.AWh.getColorForState((int[])localObject, this.AWf);
    int j = this.AWg.getColorForState((int[])localObject, this.AWe);
    this.Arz.setColor(i);
    this.huv.setColor(j);
    this.AWs.left = 0.0F;
    this.AWs.top = ((this.height - this.AWn) / 2);
    this.AWs.right = this.AWo;
    this.AWs.bottom = ((this.height + this.AWn) / 2);
    ab.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", new Object[] { Float.valueOf(this.AWs.left), Float.valueOf(this.AWs.top), Float.valueOf(this.AWs.right), Float.valueOf(this.AWs.bottom), Integer.valueOf(this.AWj) });
    paramCanvas.drawRoundRect(this.AWs, this.AWj, this.AWj, this.huv);
    this.AWt.left = 0;
    this.AWt.top = 0;
    this.AWt.right = this.AWo;
    this.AWt.bottom = this.height;
    localObject = this.Arz.getFontMetricsInt();
    i = (this.AWt.bottom + this.AWt.top - ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
    paramCanvas.drawText(this.AWr, this.AWt.centerX(), i, this.Arz);
    AppMethodBeat.o(142642);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(142641);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(142641);
  }
  
  public void setAnimationButtonListener(WcPayKeyboardAnimationActionButton.a parama)
  {
    this.AWd = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton
 * JD-Core Version:    0.7.0.1
 */