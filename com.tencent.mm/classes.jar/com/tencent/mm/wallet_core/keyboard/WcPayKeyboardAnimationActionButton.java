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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class WcPayKeyboardAnimationActionButton
  extends View
{
  private int BFx;
  private int BFy;
  private int FPd;
  private int FPe;
  private ColorStateList Lxa;
  private ColorStateList Lxb;
  private int Lxc;
  private int Lxd;
  private int Lxe;
  private int Lxf;
  private int Lxg;
  private int Lxh;
  private int Lxi;
  private int Lxj;
  private int Lxk;
  String Lxl;
  private float Lxm;
  private float Lxn;
  boolean Lxo;
  private int Lxp;
  private int Lxq;
  private RectF Lxr;
  private Rect Lxs;
  private ObjectAnimator Lxt;
  private ValueAnimator Lxu;
  private ValueAnimator Lxv;
  private ObjectAnimator Lxw;
  private ValueAnimator Lxx;
  private ValueAnimator Lxy;
  AnimatorSet Lxz;
  private Paint bWm;
  private Context context;
  private int height;
  private Paint knr;
  private int width;
  AnimatorSet yvH;
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72701);
    this.FPe = getResources().getColor(2131101171);
    this.FPd = getResources().getColor(2131101185);
    this.Lxc = 17;
    this.Lxj = 300;
    this.Lxk = 300;
    this.Lxl = "";
    this.Lxo = true;
    this.Lxr = new RectF();
    this.Lxs = new Rect();
    this.yvH = new AnimatorSet();
    this.Lxz = new AnimatorSet();
    init();
    AppMethodBeat.o(72701);
  }
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72702);
    this.FPe = getResources().getColor(2131101171);
    this.FPd = getResources().getColor(2131101185);
    this.Lxc = 17;
    this.Lxj = 300;
    this.Lxk = 300;
    this.Lxl = "";
    this.Lxo = true;
    this.Lxr = new RectF();
    this.Lxs = new Rect();
    this.yvH = new AnimatorSet();
    this.Lxz = new AnimatorSet();
    init();
    AppMethodBeat.o(72702);
  }
  
  private void U(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.BFx = paramInt1;
    this.BFy = paramInt2;
    this.Lxp = paramInt3;
    this.Lxq = paramInt4;
  }
  
  private void Zd()
  {
    AppMethodBeat.i(72704);
    this.context = aj.getContext();
    this.Lxd = a.fromDPToPix(this.context, 4);
    this.Lxe = a.fromDPToPix(this.context, 16);
    this.Lxf = a.fromDPToPix(this.context, 64);
    this.Lxg = a.fromDPToPix(this.context, 96);
    this.Lxa = getResources().getColorStateList(2131101171);
    this.Lxb = getResources().getColorStateList(2131101185);
    AppMethodBeat.o(72704);
  }
  
  private void fRd()
  {
    AppMethodBeat.i(72707);
    this.Lxn = getTranslationX();
    this.Lxm = (this.Lxn - this.Lxe);
    AppMethodBeat.o(72707);
  }
  
  private void fRg()
  {
    AppMethodBeat.i(72711);
    fRh();
    fRi();
    fRj();
    this.yvH = new AnimatorSet();
    this.yvH.play(this.Lxv).with(this.Lxt);
    AppMethodBeat.o(72711);
  }
  
  private void fRh()
  {
    AppMethodBeat.i(72712);
    if (this.Lxt == null)
    {
      this.Lxt = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.Lxn, this.Lxm });
      this.Lxt.setDuration(this.Lxj);
      this.Lxt.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72712);
  }
  
  private void fRi()
  {
    AppMethodBeat.i(72713);
    this.Lxh = this.height;
    if (this.Lxv == null)
    {
      this.Lxv = ValueAnimator.ofInt(new int[] { this.height, this.Lxf });
      this.Lxv.setDuration(this.Lxk);
      this.Lxv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
  
  private void fRj()
  {
    AppMethodBeat.i(72714);
    this.Lxi = this.width;
    if (this.Lxu == null)
    {
      this.Lxu = ValueAnimator.ofInt(new int[] { this.width, this.Lxg });
      this.Lxu.setDuration(this.Lxk);
      this.Lxu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
  
  private void fRl()
  {
    AppMethodBeat.i(72716);
    if (this.Lxw == null)
    {
      this.Lxw = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.Lxm, this.Lxn });
      this.Lxw.setDuration(this.Lxj);
      this.Lxw.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72716);
  }
  
  private void fRm()
  {
    AppMethodBeat.i(72717);
    this.Lxh = this.Lxf;
    if (this.Lxy == null)
    {
      this.Lxy = ValueAnimator.ofInt(new int[] { this.Lxf, this.height });
      this.Lxy.setDuration(this.Lxk);
      this.Lxy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
  
  private void fRn()
  {
    AppMethodBeat.i(72718);
    this.knr = new Paint();
    this.knr.setStrokeWidth(4.0F);
    this.knr.setStyle(Paint.Style.FILL);
    this.knr.setAntiAlias(true);
    this.knr.setColor(this.FPe);
    this.bWm = new Paint(1);
    this.bWm.setTextSize(a.fromDPToPix(this.context, this.Lxc) * a.eb(this.context));
    this.bWm.setColor(this.FPd);
    this.bWm.setTextAlign(Paint.Align.CENTER);
    this.bWm.setAntiAlias(true);
    this.bWm.setFakeBoldText(true);
    AppMethodBeat.o(72718);
  }
  
  private void init()
  {
    AppMethodBeat.i(72703);
    Zd();
    fRn();
    AppMethodBeat.o(72703);
  }
  
  public final void V(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72709);
    if (this.Lxo)
    {
      this.Lxo = false;
      U(paramInt1, paramInt2, paramInt3, paramInt4);
      fRd();
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.bottomMargin = paramInt3;
    setLayoutParams(localLayoutParams);
    this.width = paramInt1;
    this.height = paramInt2;
    ad.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    this.Lxi = paramInt1;
    fRg();
    AppMethodBeat.o(72709);
  }
  
  public final void fRe()
  {
    AppMethodBeat.i(72708);
    V(this.BFx, this.BFy, this.Lxp, this.Lxq);
    AppMethodBeat.o(72708);
  }
  
  public final boolean fRf()
  {
    AppMethodBeat.i(72710);
    boolean bool1;
    boolean bool2;
    if (this.yvH == null)
    {
      bool1 = false;
      if (this.Lxz != null) {
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
      if ((this.Lxv == null) || (this.Lxu == null) || (this.Lxt == null))
      {
        bool1 = false;
        break;
      }
      bool1 = this.yvH.isRunning();
      break;
      label77:
      if ((this.Lxy == null) || (this.Lxx == null) || (this.Lxw == null)) {
        bool2 = false;
      } else {
        bool2 = this.Lxz.isRunning();
      }
    }
    label114:
    AppMethodBeat.o(72710);
    return false;
  }
  
  public final void fRk()
  {
    AppMethodBeat.i(72715);
    fRl();
    fRm();
    this.Lxz = new AnimatorSet();
    this.Lxz.play(this.Lxy).with(this.Lxw);
    AppMethodBeat.o(72715);
  }
  
  public final void fRo()
  {
    AppMethodBeat.i(72719);
    this.Lxd = a.fromDPToPix(this.context, 4);
    this.Lxh = this.height;
    this.Lxi = this.width;
    setTranslationX(getTranslationX() + this.Lxe);
    invalidate();
    AppMethodBeat.o(72719);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(72706);
    super.onDraw(paramCanvas);
    Object localObject = getDrawableState();
    int i = this.Lxb.getColorForState((int[])localObject, this.FPd);
    int j = this.Lxa.getColorForState((int[])localObject, this.FPe);
    this.bWm.setColor(i);
    this.knr.setColor(j);
    this.Lxr.left = 0.0F;
    this.Lxr.top = ((this.height - this.Lxh) / 2);
    this.Lxr.right = this.Lxi;
    this.Lxr.bottom = ((this.height + this.Lxh) / 2);
    ad.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", new Object[] { Float.valueOf(this.Lxr.left), Float.valueOf(this.Lxr.top), Float.valueOf(this.Lxr.right), Float.valueOf(this.Lxr.bottom), Integer.valueOf(this.Lxd) });
    paramCanvas.drawRoundRect(this.Lxr, this.Lxd, this.Lxd, this.knr);
    this.Lxs.left = 0;
    this.Lxs.top = 0;
    this.Lxs.right = this.Lxi;
    this.Lxs.bottom = this.height;
    localObject = this.bWm.getFontMetricsInt();
    i = (this.Lxs.bottom + this.Lxs.top - ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
    paramCanvas.drawText(this.Lxl, this.Lxs.centerX(), i, this.bWm);
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