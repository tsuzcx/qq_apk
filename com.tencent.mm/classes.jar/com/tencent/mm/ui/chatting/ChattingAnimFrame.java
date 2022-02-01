package com.tencent.mm.ui.chatting;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.d;
import com.tencent.mm.bc.m;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.eggspring.b.c;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String pCI = "";
  MMAnimateView JzA;
  private int JzB;
  private int JzC;
  private int JzD;
  private boolean JzE;
  private boolean JzF;
  ValueAnimator JzG;
  ValueAnimator JzH;
  private ValueAnimator.AnimatorUpdateListener JzI;
  private Animator.AnimatorListener JzJ;
  d JzK;
  private ObjectAnimator JzL;
  private View.OnClickListener JzM;
  private d JzN;
  List<MMAnimateView> Jzv;
  private int Jzw;
  private boolean Jzx;
  private int Jzy;
  private ArrayList<Integer> Jzz;
  private int aYS;
  private int aYT;
  int fJg;
  private int mScreenHeight;
  private int mScreenWidth;
  boolean pzi;
  c pzp;
  private int zbD;
  private int zbE;
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34371);
    this.Jzv = new ArrayList();
    this.fJg = 0;
    this.Jzw = 30;
    this.zbD = 30;
    this.zbE = 40;
    this.Jzx = false;
    this.Jzy = 0;
    this.Jzz = new ArrayList();
    this.JzI = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(34356);
        if (!ChattingAnimFrame.f(ChattingAnimFrame.this))
        {
          AppMethodBeat.o(34356);
          return;
        }
        float f;
        if (paramAnonymousValueAnimator == ChattingAnimFrame.g(ChattingAnimFrame.this))
        {
          f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (ChattingAnimFrame.h(ChattingAnimFrame.this) != null) {
            ChattingAnimFrame.h(ChattingAnimFrame.this).setX(f);
          }
          AppMethodBeat.o(34356);
          return;
        }
        if (paramAnonymousValueAnimator == ChattingAnimFrame.i(ChattingAnimFrame.this))
        {
          f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (ChattingAnimFrame.h(ChattingAnimFrame.this) != null)
          {
            ChattingAnimFrame.h(ChattingAnimFrame.this).setY(f);
            if ((!ChattingAnimFrame.j(ChattingAnimFrame.this)) && (f > ChattingAnimFrame.k(ChattingAnimFrame.this)))
            {
              ad.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", new Object[] { Float.valueOf(f), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this)), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this) * 2) });
              ad.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 1.");
              ChattingAnimFrame.l(ChattingAnimFrame.this);
              ChattingAnimFrame.m(ChattingAnimFrame.this);
            }
            if ((!ChattingAnimFrame.n(ChattingAnimFrame.this)) && (f > ChattingAnimFrame.k(ChattingAnimFrame.this) * 3))
            {
              ad.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", new Object[] { Float.valueOf(f), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this)), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this) * 2) });
              ad.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 2.");
              ChattingAnimFrame.o(ChattingAnimFrame.this);
              ChattingAnimFrame.m(ChattingAnimFrame.this);
            }
          }
        }
        AppMethodBeat.o(34356);
      }
    };
    this.JzJ = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(34357);
        ad.d("MicroMsg.ChattingAnimFrame", "luckyBagAnimEnd!!!");
        if (ChattingAnimFrame.f(ChattingAnimFrame.this)) {
          ChattingAnimFrame.p(ChattingAnimFrame.this);
        }
        AppMethodBeat.o(34357);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.JzM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34358);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.ChattingAnimFrame", "lucky bag click!!!");
        paramAnonymousView = com.tencent.mm.plugin.eggspring.a.pyS;
        com.tencent.mm.plugin.eggspring.a.cfE().BI(4);
        paramAnonymousView = new AlphaAnimation(1.0F, 0.0F);
        paramAnonymousView.setDuration(500L);
        paramAnonymousView.setFillAfter(false);
        paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymous2Animation)
          {
            AppMethodBeat.i(162383);
            ChattingAnimFrame.p(ChattingAnimFrame.this);
            AppMethodBeat.o(162383);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
          
          public final void onAnimationStart(Animation paramAnonymous2Animation)
          {
            AppMethodBeat.i(162382);
            ((Vibrator)ChattingAnimFrame.this.getContext().getSystemService("vibrator")).vibrate(500L);
            if (ChattingAnimFrame.q(ChattingAnimFrame.this) != null) {
              ChattingAnimFrame.q(ChattingAnimFrame.this).a(ChattingAnimFrame.r(ChattingAnimFrame.this), ChattingAnimFrame.s(ChattingAnimFrame.this));
            }
            AppMethodBeat.o(162382);
          }
        });
        ChattingAnimFrame.h(ChattingAnimFrame.this).startAnimation(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34358);
      }
    };
    this.mScreenHeight = com.tencent.mm.cc.a.iq(getContext());
    this.mScreenWidth = com.tencent.mm.cc.a.ip(getContext());
    this.JzD = (this.mScreenHeight / 5);
    this.JzB = com.tencent.mm.cc.a.fromDPToPix(getContext(), 60);
    this.JzC = com.tencent.mm.cc.a.fromDPToPix(getContext(), 80);
    AppMethodBeat.o(34371);
  }
  
  private void acN(int paramInt)
  {
    AppMethodBeat.i(34375);
    if (paramInt <= 0)
    {
      ad.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      AppMethodBeat.o(34375);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.Jzz != null) {
      this.Jzz.clear();
    }
    while (this.Jzz.size() < i)
    {
      int j = (int)ad(0.0F, paramInt);
      if (!this.Jzz.contains(Integer.valueOf(j)))
      {
        this.Jzz.add(Integer.valueOf(j));
        continue;
        this.Jzz = new ArrayList();
      }
    }
    AppMethodBeat.o(34375);
  }
  
  static float ad(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(34377);
    float f = (float)Math.random();
    AppMethodBeat.o(34377);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private void fBi()
  {
    AppMethodBeat.i(160226);
    if ((this.JzA != null) && (this.pzi))
    {
      this.JzA.stop();
      removeView(this.JzA);
      this.pzi = false;
      this.pzp = null;
      if (this.JzG != null)
      {
        this.JzG.end();
        this.JzG = null;
      }
      if (this.JzH != null)
      {
        this.JzH.end();
        this.JzH = null;
      }
      if (this.JzL != null)
      {
        this.JzL.end();
        this.JzL = null;
      }
      this.JzA.setRotation(0.0F);
    }
    AppMethodBeat.o(160226);
  }
  
  private static String getDataEmojiPath()
  {
    AppMethodBeat.i(34370);
    if (bt.isNullOrNil(pCI))
    {
      pCI = com.tencent.mm.loader.j.b.arN().replace("/data/user/0", "/data/data");
      pCI += "/emoji";
    }
    String str = pCI;
    AppMethodBeat.o(34370);
    return str;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(34374);
    stop();
    if (paramd == null)
    {
      ad.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
      AppMethodBeat.o(34374);
      return false;
    }
    int i = 0;
    int j = paramd.iiV.size();
    if (j <= 0)
    {
      ad.e("MicroMsg.ChattingAnimFrame", "wtf!!! no anim!!!");
      AppMethodBeat.o(34374);
      return false;
    }
    if (1 != j)
    {
      i = new Random().nextInt(j);
      ad.d("MicroMsg.ChattingAnimFrame", "random egg: %s, from %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
    Object localObject = (m)paramd.iiV.get(i);
    String str = getDataEmojiPath() + "/egg/" + ((m)localObject).fileName;
    if (!i.fv(str))
    {
      ad.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      AppMethodBeat.o(34374);
      return false;
    }
    this.JzK = paramd;
    setVisibility(0);
    if (z.b(paramd)) {
      g.yhR.dD(1263, 3);
    }
    label248:
    int k;
    label265:
    label341:
    boolean bool;
    if (((m)localObject).ijp > 0)
    {
      this.Jzw = ((m)localObject).ijp;
      if (this.Jzw > 60) {
        this.Jzw = 60;
      }
      if (((m)localObject).ijq <= 0) {
        break label607;
      }
      this.zbD = ((m)localObject).ijq;
      if (((m)localObject).maxSize <= 0) {
        break label616;
      }
      this.zbE = ((m)localObject).maxSize;
      ad.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.Jzw), Integer.valueOf(this.zbD), Integer.valueOf(this.zbE), Integer.valueOf(((m)localObject).ijo), Integer.valueOf(paramd.dFx) });
      l = 0L;
      acN(this.Jzw);
      i = 0;
      if (i >= this.Jzw) {
        break label728;
      }
      j = this.zbD;
      k = this.zbE;
      j = (int)ad(j, k);
      j = com.tencent.mm.cc.a.fromDPToPix(getContext(), j);
      k = ((m)localObject).ijo;
      if ((this.Jzz == null) || (!this.Jzz.contains(Integer.valueOf(i)))) {
        break label625;
      }
      bool = true;
      label410:
      paramd = new c(k, j, l, bool);
      MMAnimateView localMMAnimateView = new MMAnimateView(getContext());
      localMMAnimateView.setImageFilePath(str);
      localMMAnimateView.setAnimation(paramd);
      localMMAnimateView.setLayerType(2, null);
      localMMAnimateView.setVisibility(4);
      paramd.JAa = localMMAnimateView;
      localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(paramd.mSize, paramd.mSize));
      this.Jzv.add(localMMAnimateView);
      this.fJg += 1;
      ad.i("MicroMsg.ChattingAnimFrame", "addImgAnim counter++: [%s].", new Object[] { Integer.valueOf(this.fJg) });
      addView(localMMAnimateView);
      j = ((m)localObject).ijo;
      k = this.Jzw;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(ad(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label341;
        this.Jzw = 30;
        break;
        label607:
        this.zbD = 30;
        break label248;
        label616:
        this.zbE = 40;
        break label265;
        label625:
        bool = false;
        break label410;
      }
    }
    if (i < 2) {}
    for (long l = 800L + l;; l = ((Math.abs(i - k * 0.5D - 5.0D) / (k * 3) + 0.01D) * 1000.0D) + l) {
      break;
    }
    label728:
    if (this.Jzv != null)
    {
      paramd = this.Jzv.iterator();
      while (paramd.hasNext())
      {
        localObject = (View)paramd.next();
        if ((localObject != null) && ((((View)localObject).getAnimation() instanceof c))) {
          c.a((c)((View)localObject).getAnimation());
        }
      }
    }
    AppMethodBeat.o(34374);
    return true;
  }
  
  public final void fBh()
  {
    float f1 = 0.1F;
    AppMethodBeat.i(34379);
    float f3 = -0.2F * this.mScreenHeight;
    float f4 = this.mScreenHeight;
    float f5 = ad(0.1F, 0.9F);
    float f2 = ad(0.1F, 0.9F);
    if (Math.abs(f5 - f2) < 0.5F) {
      if (f5 > 0.5F) {
        if (f5 - 0.5F > 0.1F) {
          f1 = f5 - 0.5F;
        }
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ChattingAnimFrame", "luckyBag, s[%s] e[%s].", new Object[] { Float.valueOf(f5), Float.valueOf(f1) });
      f2 = (int)(this.mScreenWidth * f5);
      f1 = (int)(f1 * this.mScreenWidth);
      ad.d("MicroMsg.ChattingAnimFrame", "luckyBag, init: startX[%s] endX[%s] startY[%s] endY[%s].", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f4) });
      if (this.JzA == null)
      {
        this.JzA = new MMAnimateView(getContext());
        this.JzA.setLayoutParams(new FrameLayout.LayoutParams(this.JzB, this.JzC));
        if (!i.fv(PluginEggSpring.pyK)) {
          break label614;
        }
        this.JzA.setImageFilePath(PluginEggSpring.pyK);
      }
      for (;;)
      {
        this.JzA.setOnClickListener(this.JzM);
        this.JzA.setPivotX(this.JzB / 2);
        this.JzA.setPivotY(this.JzC / 2);
        this.JzA.setRotation(0.0F);
        this.JzA.setX(f2);
        this.JzA.setY(f3);
        int i = (int)ad(7000.0F, 10000.0F);
        this.JzG = ValueAnimator.ofFloat(new float[] { f2, f1 });
        this.JzH = ValueAnimator.ofFloat(new float[] { f3, f4 });
        this.JzG.setDuration(i);
        this.JzH.setDuration(i);
        this.JzG.setInterpolator(new LinearInterpolator());
        this.JzH.setInterpolator(new LinearInterpolator());
        this.JzG.addUpdateListener(this.JzI);
        this.JzH.addUpdateListener(this.JzI);
        this.JzG.setStartDelay(500L);
        this.JzH.setStartDelay(500L);
        this.JzH.addListener(this.JzJ);
        this.JzL = ObjectAnimator.ofFloat(this.JzA, View.ROTATION, new float[] { 0.0F, 15.0F, -15.0F, 15.0F, -15.0F, 0.0F });
        this.JzL.setInterpolator(new AccelerateDecelerateInterpolator());
        this.JzL.setDuration(500L);
        this.JzL.setRepeatCount(1);
        this.JzE = false;
        this.JzF = false;
        AppMethodBeat.o(34379);
        return;
        if (f5 < 0.5F)
        {
          if (f5 + 0.5F < 0.9F)
          {
            f1 = f5 + 0.5F;
            break;
          }
          f1 = 0.9F;
          break;
        }
        if (Math.random() <= 0.5D) {
          break;
        }
        f1 = 0.9F;
        break;
        label614:
        this.JzA.setImageResource(2131232929);
      }
      f1 = f2;
    }
  }
  
  public final boolean fBj()
  {
    AppMethodBeat.i(160227);
    if ((this.JzK != null) && (1 == this.JzK.type))
    {
      if ((this.fJg <= 0) && (!this.pzi))
      {
        AppMethodBeat.o(160227);
        return true;
      }
      AppMethodBeat.o(160227);
      return false;
    }
    AppMethodBeat.o(160227);
    return true;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(34372);
    super.onFinishInflate();
    this.aYT = getMeasuredHeight();
    this.aYS = getMeasuredWidth();
    ad.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.aYS), Integer.valueOf(this.aYT) });
    AppMethodBeat.o(34372);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34373);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.aYT = (paramInt4 - paramInt2);
    this.aYS = (paramInt3 - paramInt1);
    if (this.aYT < this.mScreenHeight) {
      this.Jzx = true;
    }
    for (this.Jzy = (this.mScreenHeight - this.aYT);; this.Jzy = 0)
    {
      ad.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.aYS), Integer.valueOf(this.aYT), Boolean.valueOf(this.Jzx), Integer.valueOf(this.Jzy) });
      AppMethodBeat.o(34373);
      return;
      this.Jzx = false;
    }
  }
  
  public void setOnLuckyBagClick(d paramd)
  {
    this.JzN = paramd;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(34376);
    ad.i("MicroMsg.ChattingAnimFrame", "stop: view: %s, count:%s", new Object[] { Integer.valueOf(this.Jzv.size()), Integer.valueOf(this.fJg) });
    Iterator localIterator = this.Jzv.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
    }
    fBi();
    removeAllViews();
    this.Jzv.clear();
    this.fJg = 0;
    AppMethodBeat.o(34376);
  }
  
  class a
    implements Animation.AnimationListener
  {
    a() {}
    
    public void onAnimationEnd(Animation paramAnimation) {}
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  final class b
    extends Animation
  {
    private View.OnLayoutChangeListener IXX;
    private float JzQ;
    private float JzR;
    private float JzS;
    private float JzT;
    private float JzU;
    private float JzV;
    private int JzW;
    private boolean JzX;
    private float mFromX;
    private float mFromY;
    private int mSize;
    private float mToX;
    private float mToY;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(34360);
      this.JzW = 0;
      this.mSize = 0;
      this.JzX = false;
      this.IXX = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.JzW = paramInt1;
      this.mSize = paramInt2;
      this.JzX = false;
      AppMethodBeat.o(34360);
    }
    
    public b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(34361);
      this.JzW = 0;
      this.mSize = 0;
      this.JzX = false;
      this.IXX = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.JzW = paramInt1;
      this.mSize = paramInt2;
      this.JzX = paramBoolean;
      AppMethodBeat.o(34361);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(34363);
      float f2 = this.JzQ;
      float f1 = this.JzS;
      if (this.JzQ != this.JzR) {
        f2 = this.JzQ + (this.JzR - this.JzQ) * paramFloat;
      }
      if (this.JzS != this.JzT)
      {
        float f3 = this.JzS + (this.JzT - this.JzS) * paramFloat;
        f1 = f3;
        if (this.JzW == 2) {
          f1 = f3 - this.mSize;
        }
      }
      paramTransformation.getMatrix().setTranslate(f2, f1);
      if ((this.JzU != this.JzV) && (3 == this.JzW))
      {
        paramFloat = this.JzU + (this.JzV - this.JzU) * paramFloat;
        paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
      }
      AppMethodBeat.o(34363);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(34364);
      super.finalize();
      ad.i("MicroMsg.ChattingAnimFrame", "finalize!");
      ChattingAnimFrame.this.removeOnLayoutChangeListener(this.IXX);
      AppMethodBeat.o(34364);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(34362);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      switch (this.JzW)
      {
      default: 
        this.mFromX = ChattingAnimFrame.ad(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.ad(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = -0.2F;
        this.mToY = 1.2F;
        setInterpolator(new LinearInterpolator());
      }
      for (;;)
      {
        if ((this.JzW != 0) && (this.JzW != 1)) {
          ChattingAnimFrame.this.addOnLayoutChangeListener(this.IXX);
        }
        resolve();
        AppMethodBeat.o(34362);
        return;
        this.mFromX = ChattingAnimFrame.ad(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.ad(this.mFromX - 0.25F, this.mFromX + 0.25F);
        this.mFromY = 1.5F;
        this.mToY = -0.2F;
        setInterpolator(new LinearInterpolator());
        continue;
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 1.5F;
        if (this.JzX) {}
        for (this.mToY = ChattingAnimFrame.ad(0.4F, 0.55F);; this.mToY = ChattingAnimFrame.ad(0.55F, 0.85F))
        {
          setInterpolator(new com.tencent.mm.ui.c.a.b());
          break;
        }
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 0.0F;
        this.mToY = 1.0F;
        setInterpolator(new com.tencent.mm.ui.c.a.a());
        continue;
        this.mFromX = ChattingAnimFrame.ad(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.ad(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = 0.0F;
        this.mToY = 0.0F;
        this.JzU = 0.8F;
        this.JzV = 1.1F;
        setInterpolator(new LinearInterpolator());
        continue;
        float f = ChattingAnimFrame.ad(0.0F, 1.0F - this.mSize * 1.0F / ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.mFromX = 1.0F;
        this.mToX = (0.0F - this.mSize * 1.0F / ChattingAnimFrame.b(ChattingAnimFrame.this));
        this.mFromY = f;
        this.mToY = f;
        setInterpolator(new LinearInterpolator());
      }
    }
    
    public final void resolve()
    {
      AppMethodBeat.i(34365);
      this.JzQ = (this.mFromX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      this.JzR = (this.mToX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      if (this.JzW == 2)
      {
        this.JzS = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.JzT = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        AppMethodBeat.o(34365);
        return;
      }
      if (this.JzW == 3)
      {
        this.JzS = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.JzT = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        if (ChattingAnimFrame.d(ChattingAnimFrame.this))
        {
          this.JzS = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
          this.JzT = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
        }
        if (this.JzT < 0.0F)
        {
          this.JzT = 0.0F;
          AppMethodBeat.o(34365);
        }
      }
      else
      {
        if (this.JzW == 4)
        {
          this.JzS = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.JzT = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          AppMethodBeat.o(34365);
          return;
        }
        this.JzS = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.JzT = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
      }
      AppMethodBeat.o(34365);
    }
  }
  
  final class c
    extends AnimationSet
  {
    MMAnimateView JAa;
    private long JzZ;
    int mSize;
    
    public c(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
    {
      super();
      AppMethodBeat.i(34368);
      this.mSize = paramInt2;
      switch (paramInt1)
      {
      default: 
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, 0, this.mSize));
      }
      for (;;)
      {
        setAnimationListener(new ChattingAnimFrame.a(ChattingAnimFrame.this)
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(34366);
            paramAnonymousAnimation = ChattingAnimFrame.c.this;
            if (paramAnonymousAnimation.JAa != null)
            {
              paramAnonymousAnimation.JAa.post(new ChattingAnimFrame.c.2(paramAnonymousAnimation));
              AppMethodBeat.o(34366);
              return;
            }
            ad.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
            AppMethodBeat.o(34366);
          }
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(193842);
            ad.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: %s", new Object[] { ChattingAnimFrame.c.this.JAa });
            if (ChattingAnimFrame.c.this.JAa != null) {
              ChattingAnimFrame.c.this.JAa.setVisibility(0);
            }
            AppMethodBeat.o(193842);
          }
        });
        this.JzZ = (500L + paramLong);
        reset();
        setDuration(ChattingAnimFrame.acO(paramInt1));
        AppMethodBeat.o(34368);
        return;
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, 999, this.mSize));
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, paramInt1, this.mSize));
        continue;
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, paramInt1, this.mSize, paramBoolean));
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, 999, this.mSize));
        continue;
        addAnimation(new ChattingAnimFrame.b(ChattingAnimFrame.this, paramInt1, this.mSize));
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(c paramc, d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame
 * JD-Core Version:    0.7.0.1
 */