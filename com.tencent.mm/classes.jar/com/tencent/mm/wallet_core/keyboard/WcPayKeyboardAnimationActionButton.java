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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class WcPayKeyboardAnimationActionButton
  extends View
{
  AnimatorSet IVc;
  private int Nme;
  private int Nmf;
  private int Sds;
  private int Sdt;
  private ValueAnimator YUA;
  private ValueAnimator YUB;
  AnimatorSet YUC;
  private ColorStateList YUe;
  private ColorStateList YUf;
  private int YUg;
  private int YUh;
  private int YUi;
  private int YUj;
  private int YUk;
  private int YUl;
  private int YUm;
  private int YUn;
  String YUo;
  private float YUp;
  private float YUq;
  boolean YUr;
  private int YUs;
  private int YUt;
  private RectF YUu;
  private Rect YUv;
  private ObjectAnimator YUw;
  private ValueAnimator YUx;
  private ValueAnimator YUy;
  private ObjectAnimator YUz;
  private Paint ciV;
  private Context context;
  private int height;
  private Paint opo;
  private int text_size;
  private int width;
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(72701);
    this.Sdt = getResources().getColor(a.c.wechat_green);
    this.Sds = getResources().getColor(a.c.white_text_color_selector);
    this.text_size = 17;
    this.YUm = 300;
    this.YUn = 300;
    this.YUo = "";
    this.YUr = true;
    this.YUu = new RectF();
    this.YUv = new Rect();
    this.IVc = new AnimatorSet();
    this.YUC = new AnimatorSet();
    init();
    AppMethodBeat.o(72701);
  }
  
  public WcPayKeyboardAnimationActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(72702);
    this.Sdt = getResources().getColor(a.c.wechat_green);
    this.Sds = getResources().getColor(a.c.white_text_color_selector);
    this.text_size = 17;
    this.YUm = 300;
    this.YUn = 300;
    this.YUo = "";
    this.YUr = true;
    this.YUu = new RectF();
    this.YUv = new Rect();
    this.IVc = new AnimatorSet();
    this.YUC = new AnimatorSet();
    init();
    AppMethodBeat.o(72702);
  }
  
  private void Y(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Nme = paramInt1;
    this.Nmf = paramInt2;
    this.YUs = paramInt3;
    this.YUt = paramInt4;
  }
  
  private void ata()
  {
    AppMethodBeat.i(72704);
    this.context = MMApplicationContext.getContext();
    this.YUg = a.fromDPToPix(this.context, 4);
    this.YUh = a.fromDPToPix(this.context, 16);
    this.YUi = a.fromDPToPix(this.context, 64);
    this.YUj = a.fromDPToPix(this.context, 96);
    this.YUe = getResources().getColorStateList(a.c.wechat_green);
    this.YUf = getResources().getColorStateList(a.c.white_text_color_selector);
    AppMethodBeat.o(72704);
  }
  
  private void iiB()
  {
    AppMethodBeat.i(72711);
    iiC();
    iiD();
    iiE();
    this.IVc = new AnimatorSet();
    this.IVc.play(this.YUy).with(this.YUw);
    AppMethodBeat.o(72711);
  }
  
  private void iiC()
  {
    AppMethodBeat.i(72712);
    if (this.YUw == null)
    {
      this.YUw = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.YUq, this.YUp });
      this.YUw.setDuration(this.YUm);
      this.YUw.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72712);
  }
  
  private void iiD()
  {
    AppMethodBeat.i(72713);
    this.YUk = this.height;
    if (this.YUy == null)
    {
      this.YUy = ValueAnimator.ofInt(new int[] { this.height, this.YUi });
      this.YUy.setDuration(this.YUn);
      this.YUy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
  
  private void iiE()
  {
    AppMethodBeat.i(72714);
    this.YUl = this.width;
    if (this.YUx == null)
    {
      this.YUx = ValueAnimator.ofInt(new int[] { this.width, this.YUj });
      this.YUx.setDuration(this.YUn);
      this.YUx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
  
  private void iiG()
  {
    AppMethodBeat.i(72716);
    if (this.YUz == null)
    {
      this.YUz = ObjectAnimator.ofFloat(this, "translationX", new float[] { this.YUp, this.YUq });
      this.YUz.setDuration(this.YUm);
      this.YUz.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    AppMethodBeat.o(72716);
  }
  
  private void iiH()
  {
    AppMethodBeat.i(72717);
    this.YUk = this.YUi;
    if (this.YUB == null)
    {
      this.YUB = ValueAnimator.ofInt(new int[] { this.YUi, this.height });
      this.YUB.setDuration(this.YUn);
      this.YUB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
  
  private void iiI()
  {
    AppMethodBeat.i(72718);
    this.opo = new Paint();
    this.opo.setStrokeWidth(4.0F);
    this.opo.setStyle(Paint.Style.FILL);
    this.opo.setAntiAlias(true);
    this.opo.setColor(this.Sdt);
    this.ciV = new Paint(1);
    this.ciV.setTextSize(a.fromDPToPix(this.context, this.text_size) * a.ez(this.context));
    this.ciV.setColor(this.Sds);
    this.ciV.setTextAlign(Paint.Align.CENTER);
    this.ciV.setAntiAlias(true);
    this.ciV.setFakeBoldText(true);
    AppMethodBeat.o(72718);
  }
  
  private void iiy()
  {
    AppMethodBeat.i(72707);
    this.YUq = getTranslationX();
    this.YUp = (this.YUq - this.YUh);
    AppMethodBeat.o(72707);
  }
  
  private void init()
  {
    AppMethodBeat.i(72703);
    ata();
    iiI();
    AppMethodBeat.o(72703);
  }
  
  public final void Z(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72709);
    if (this.YUr)
    {
      this.YUr = false;
      Y(paramInt1, paramInt2, paramInt3, paramInt4);
      iiy();
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localLayoutParams.bottomMargin = paramInt3;
    setLayoutParams(localLayoutParams);
    this.width = paramInt1;
    this.height = paramInt2;
    Log.d("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "initialLayoutParams() width:%s height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    this.YUl = paramInt1;
    iiB();
    AppMethodBeat.o(72709);
  }
  
  public final boolean iiA()
  {
    AppMethodBeat.i(72710);
    boolean bool1;
    boolean bool2;
    if (this.IVc == null)
    {
      bool1 = false;
      if (this.YUC != null) {
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
      if ((this.YUy == null) || (this.YUx == null) || (this.YUw == null))
      {
        bool1 = false;
        break;
      }
      bool1 = this.IVc.isRunning();
      break;
      label77:
      if ((this.YUB == null) || (this.YUA == null) || (this.YUz == null)) {
        bool2 = false;
      } else {
        bool2 = this.YUC.isRunning();
      }
    }
    label114:
    AppMethodBeat.o(72710);
    return false;
  }
  
  public final void iiF()
  {
    AppMethodBeat.i(72715);
    iiG();
    iiH();
    this.YUC = new AnimatorSet();
    this.YUC.play(this.YUB).with(this.YUz);
    AppMethodBeat.o(72715);
  }
  
  public final void iiJ()
  {
    AppMethodBeat.i(72719);
    this.YUg = a.fromDPToPix(this.context, 4);
    this.YUk = this.height;
    this.YUl = this.width;
    setTranslationX(getTranslationX() + this.YUh);
    invalidate();
    AppMethodBeat.o(72719);
  }
  
  public final void iiz()
  {
    AppMethodBeat.i(72708);
    Z(this.Nme, this.Nmf, this.YUs, this.YUt);
    AppMethodBeat.o(72708);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(72706);
    super.onDraw(paramCanvas);
    Object localObject = getDrawableState();
    int i = this.YUf.getColorForState((int[])localObject, this.Sds);
    int j = this.YUe.getColorForState((int[])localObject, this.Sdt);
    this.ciV.setColor(i);
    this.opo.setColor(j);
    this.YUu.left = 0.0F;
    this.YUu.top = ((this.height - this.YUk) / 2);
    this.YUu.right = this.YUl;
    this.YUu.bottom = ((this.height + this.YUk) / 2);
    Log.v("MicroMsg.WcPayKeyBoard.WcPayKeyboardAnimationActionButton", "draw_oval_to_circle() left:%s top:%s right:%s bottom:%s circleAngle:%s", new Object[] { Float.valueOf(this.YUu.left), Float.valueOf(this.YUu.top), Float.valueOf(this.YUu.right), Float.valueOf(this.YUu.bottom), Integer.valueOf(this.YUg) });
    paramCanvas.drawRoundRect(this.YUu, this.YUg, this.YUg, this.opo);
    this.YUv.left = 0;
    this.YUv.top = 0;
    this.YUv.right = this.YUl;
    this.YUv.bottom = this.height;
    localObject = this.ciV.getFontMetricsInt();
    i = (this.YUv.bottom + this.YUv.top - ((Paint.FontMetricsInt)localObject).bottom - ((Paint.FontMetricsInt)localObject).top) / 2;
    paramCanvas.drawText(this.YUo, this.YUv.centerX(), i, this.ciV);
    AppMethodBeat.o(72706);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72705);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(72705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton
 * JD-Core Version:    0.7.0.1
 */