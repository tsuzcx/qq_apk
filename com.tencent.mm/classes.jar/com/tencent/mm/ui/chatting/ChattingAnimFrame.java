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
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.d;
import com.tencent.mm.be.l;
import com.tencent.mm.be.m;
import com.tencent.mm.be.p;
import com.tencent.mm.plugin.eggspring.c.c;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String uCI = "";
  private int DIY;
  List<MMAnimateView> WyI;
  private int WyJ;
  private boolean WyK;
  private int WyL;
  private ArrayList<Integer> WyM;
  private MMAnimateView WyN;
  private int WyO;
  private int WyP;
  private float WyQ;
  private boolean WyR;
  private boolean WyS;
  private float WyT;
  private float WyU;
  private float WyV;
  private float WyW;
  private Interpolator WyX;
  private Interpolator WyY;
  private int WyZ;
  private int Wza;
  private ValueAnimator Wzb;
  private ValueAnimator.AnimatorUpdateListener Wzc;
  private Animator.AnimatorListener Wzd;
  private com.tencent.mm.be.e Wze;
  private c Wzf;
  private ObjectAnimator Wzg;
  private View.OnClickListener Wzh;
  private d Wzi;
  private float aBO;
  private float aBP;
  private int aIj;
  private int aIk;
  private float bEi;
  private float bEj;
  int cCC;
  private int mMaxSize;
  private int mScreenHeight;
  private int mScreenWidth;
  private boolean uxR;
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34371);
    this.WyI = new ArrayList();
    this.cCC = 0;
    this.WyJ = 30;
    this.DIY = 30;
    this.mMaxSize = 40;
    this.WyK = false;
    this.WyL = 0;
    this.WyM = new ArrayList();
    this.WyQ = 0.2F;
    this.Wzc = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(34356);
        if (!ChattingAnimFrame.f(ChattingAnimFrame.this))
        {
          AppMethodBeat.o(34356);
          return;
        }
        if (ChattingAnimFrame.g(ChattingAnimFrame.this) == null) {
          ChattingAnimFrame.a(ChattingAnimFrame.this, new LinearInterpolator());
        }
        if (ChattingAnimFrame.h(ChattingAnimFrame.this) == null) {
          ChattingAnimFrame.b(ChattingAnimFrame.this, new LinearInterpolator());
        }
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (ChattingAnimFrame.i(ChattingAnimFrame.this) == 2) {
          ChattingAnimFrame.a(ChattingAnimFrame.this, ChattingAnimFrame.a(ChattingAnimFrame.this) - ChattingAnimFrame.j(ChattingAnimFrame.this));
        }
        for (;;)
        {
          float f2 = ChattingAnimFrame.m(ChattingAnimFrame.this);
          float f3 = ChattingAnimFrame.n(ChattingAnimFrame.this);
          float f4 = ChattingAnimFrame.m(ChattingAnimFrame.this);
          float f5 = ChattingAnimFrame.g(ChattingAnimFrame.this).getInterpolation(f1);
          float f6 = ChattingAnimFrame.o(ChattingAnimFrame.this);
          float f7 = ChattingAnimFrame.p(ChattingAnimFrame.this);
          float f8 = ChattingAnimFrame.o(ChattingAnimFrame.this);
          float f9 = ChattingAnimFrame.h(ChattingAnimFrame.this).getInterpolation(f1);
          if (ChattingAnimFrame.q(ChattingAnimFrame.this) != null)
          {
            ChattingAnimFrame.q(ChattingAnimFrame.this).setX(f2 + (f3 - f4) * f5);
            ChattingAnimFrame.q(ChattingAnimFrame.this).setY(f6 + (f7 - f8) * f9);
            if ((!ChattingAnimFrame.r(ChattingAnimFrame.this)) && (f1 > ChattingAnimFrame.s(ChattingAnimFrame.this)))
            {
              Log.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", new Object[] { Float.valueOf(f1), Float.valueOf(ChattingAnimFrame.s(ChattingAnimFrame.this)), Float.valueOf(ChattingAnimFrame.s(ChattingAnimFrame.this) * 2.0F) });
              Log.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 1.");
              ChattingAnimFrame.t(ChattingAnimFrame.this);
              ChattingAnimFrame.u(ChattingAnimFrame.this);
            }
            if ((!ChattingAnimFrame.v(ChattingAnimFrame.this)) && (f1 > ChattingAnimFrame.s(ChattingAnimFrame.this) * 3.0F))
            {
              Log.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", new Object[] { Float.valueOf(f1), Float.valueOf(ChattingAnimFrame.s(ChattingAnimFrame.this)), Float.valueOf(ChattingAnimFrame.s(ChattingAnimFrame.this) * 2.0F) });
              Log.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 2.");
              ChattingAnimFrame.w(ChattingAnimFrame.this);
              ChattingAnimFrame.u(ChattingAnimFrame.this);
            }
          }
          AppMethodBeat.o(34356);
          return;
          if (ChattingAnimFrame.i(ChattingAnimFrame.this) == 3)
          {
            ChattingAnimFrame.b(ChattingAnimFrame.this, ChattingAnimFrame.a(ChattingAnimFrame.this) * ChattingAnimFrame.k(ChattingAnimFrame.this));
            ChattingAnimFrame.a(ChattingAnimFrame.this, ChattingAnimFrame.a(ChattingAnimFrame.this) * ChattingAnimFrame.l(ChattingAnimFrame.this));
          }
        }
      }
    };
    this.Wzd = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(34357);
        Log.i("MicroMsg.ChattingAnimFrame", "onAnimationEnd: luckBag");
        if (ChattingAnimFrame.f(ChattingAnimFrame.this)) {
          ChattingAnimFrame.x(ChattingAnimFrame.this);
        }
        AppMethodBeat.o(34357);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(285548);
        Log.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: luckyBag");
        if (ChattingAnimFrame.i(ChattingAnimFrame.this) == 1)
        {
          ChattingAnimFrame.b(ChattingAnimFrame.this, ChattingAnimFrame.a(ChattingAnimFrame.this) * ChattingAnimFrame.k(ChattingAnimFrame.this));
          ChattingAnimFrame.a(ChattingAnimFrame.this, -ChattingAnimFrame.j(ChattingAnimFrame.this));
        }
        AppMethodBeat.o(285548);
      }
    };
    this.Wzh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34358);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.ChattingAnimFrame", "lucky bag click!!!");
        paramAnonymousView = com.tencent.mm.plugin.eggspring.e.uxF;
        com.tencent.mm.plugin.eggspring.e.aO(4, com.tencent.mm.plugin.eggspring.e.lXu);
        paramAnonymousView = new AlphaAnimation(1.0F, 0.0F);
        paramAnonymousView.setDuration(500L);
        paramAnonymousView.setFillAfter(false);
        paramAnonymousView.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymous2Animation)
          {
            AppMethodBeat.i(162383);
            ChattingAnimFrame.x(ChattingAnimFrame.this);
            AppMethodBeat.o(162383);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
          
          public final void onAnimationStart(Animation paramAnonymous2Animation)
          {
            AppMethodBeat.i(162382);
            ((Vibrator)ChattingAnimFrame.this.getContext().getSystemService("vibrator")).vibrate(500L);
            if (ChattingAnimFrame.y(ChattingAnimFrame.this) != null) {
              ChattingAnimFrame.y(ChattingAnimFrame.this).a(ChattingAnimFrame.z(ChattingAnimFrame.this), ChattingAnimFrame.A(ChattingAnimFrame.this));
            }
            AppMethodBeat.o(162382);
          }
        });
        ChattingAnimFrame.q(ChattingAnimFrame.this).startAnimation(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34358);
      }
    };
    this.mScreenHeight = com.tencent.mm.ci.a.ks(getContext());
    this.mScreenWidth = com.tencent.mm.ci.a.kr(getContext());
    this.WyO = com.tencent.mm.ci.a.fromDPToPix(getContext(), 60);
    this.WyP = com.tencent.mm.ci.a.fromDPToPix(getContext(), 80);
    AppMethodBeat.o(34371);
  }
  
  private static float aD(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(265246);
    paramFloat1 = Math.max(0.1F, Math.min(paramFloat1, paramFloat2));
    AppMethodBeat.o(265246);
    return paramFloat1;
  }
  
  static float am(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(34377);
    float f = (float)Math.random();
    AppMethodBeat.o(34377);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private void avg(int paramInt)
  {
    AppMethodBeat.i(34375);
    if (paramInt <= 0)
    {
      Log.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      AppMethodBeat.o(34375);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.WyM != null) {
      this.WyM.clear();
    }
    while (this.WyM.size() < i)
    {
      int j = (int)am(0.0F, paramInt);
      if (!this.WyM.contains(Integer.valueOf(j)))
      {
        this.WyM.add(Integer.valueOf(j));
        continue;
        this.WyM = new ArrayList();
      }
    }
    AppMethodBeat.o(34375);
  }
  
  private static String getDataEmojiPath()
  {
    AppMethodBeat.i(34370);
    if (Util.isNullOrNil(uCI))
    {
      uCI = com.tencent.mm.loader.j.b.aSE();
      uCI += "/emoji";
    }
    String str = uCI;
    AppMethodBeat.o(34370);
    return str;
  }
  
  private void hMB()
  {
    AppMethodBeat.i(160226);
    if ((this.WyN != null) && (this.uxR))
    {
      this.WyN.stop();
      removeView(this.WyN);
      this.uxR = false;
      this.Wzf = null;
      if (this.Wzb != null)
      {
        this.Wzb.end();
        this.Wzb = null;
      }
      if (this.Wzg != null)
      {
        this.Wzg.end();
        this.Wzg = null;
      }
      this.WyN.setRotation(0.0F);
    }
    AppMethodBeat.o(160226);
  }
  
  private int mx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(265247);
    paramInt1 = (int)am(paramInt1, paramInt2);
    paramInt1 = com.tencent.mm.ci.a.fromDPToPix(getContext(), paramInt1);
    AppMethodBeat.o(265247);
    return paramInt1;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(265248);
    Log.i("MicroMsg.ChattingAnimFrame", "showLuckyBag: ");
    if ((this.WyN != null) && (this.Wzb != null) && (!this.uxR))
    {
      com.tencent.mm.plugin.eggspring.e locale = com.tencent.mm.plugin.eggspring.e.uxF;
      com.tencent.mm.plugin.eggspring.e.aO(3, com.tencent.mm.plugin.eggspring.e.lXu);
      this.uxR = true;
      this.Wzf = paramc;
      addView(this.WyN);
      Log.i("MicroMsg.ChattingAnimFrame", "lucky bag start anim!!!");
      this.Wzb.start();
      this.WyN.start();
    }
    AppMethodBeat.o(265248);
  }
  
  public final boolean a(com.tencent.mm.be.e parame)
  {
    AppMethodBeat.i(34374);
    stop();
    if (parame == null)
    {
      Log.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
      AppMethodBeat.o(34374);
      return false;
    }
    int i = 0;
    int j = parame.lXt.size();
    if (j <= 0)
    {
      Log.e("MicroMsg.ChattingAnimFrame", "wtf!!! no anim!!!");
      AppMethodBeat.o(34374);
      return false;
    }
    if (1 != j)
    {
      i = new Random().nextInt(j);
      Log.d("MicroMsg.ChattingAnimFrame", "random egg: %s, from %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
    Object localObject = (p)parame.lXt.get(i);
    String str = getDataEmojiPath() + "/egg/" + ((p)localObject).fileName;
    if (!u.agG(str))
    {
      Log.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      AppMethodBeat.o(34374);
      return false;
    }
    this.Wze = parame;
    setVisibility(0);
    if (aa.b(parame)) {
      com.tencent.mm.plugin.report.service.h.IzE.el(1263, 3);
    }
    label248:
    int k;
    label265:
    label341:
    boolean bool;
    if (((p)localObject).lXT > 0)
    {
      this.WyJ = ((p)localObject).lXT;
      if (this.WyJ > 60) {
        this.WyJ = 60;
      }
      if (((p)localObject).lXU <= 0) {
        break label595;
      }
      this.DIY = ((p)localObject).lXU;
      if (((p)localObject).maxSize <= 0) {
        break label604;
      }
      this.mMaxSize = ((p)localObject).maxSize;
      Log.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.WyJ), Integer.valueOf(this.DIY), Integer.valueOf(this.mMaxSize), Integer.valueOf(((p)localObject).lXQ), Integer.valueOf(parame.fSe) });
      l = 0L;
      avg(this.WyJ);
      i = 0;
      if (i >= this.WyJ) {
        break label716;
      }
      j = mx(this.DIY, this.mMaxSize);
      k = ((p)localObject).lXQ;
      if ((this.WyM == null) || (!this.WyM.contains(Integer.valueOf(i)))) {
        break label613;
      }
      bool = true;
      label393:
      parame = new c(k, j, l, bool);
      MMAnimateView localMMAnimateView = new MMAnimateView(getContext());
      localMMAnimateView.setImageFilePath(str);
      localMMAnimateView.setAnimation(parame);
      localMMAnimateView.setLayerType(2, null);
      localMMAnimateView.setVisibility(4);
      parame.Wzv = localMMAnimateView;
      localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(parame.mSize, parame.mSize));
      this.WyI.add(localMMAnimateView);
      this.cCC += 1;
      Log.i("MicroMsg.ChattingAnimFrame", "addView counter++: [%s]. %s", new Object[] { Integer.valueOf(this.cCC), localMMAnimateView });
      addView(localMMAnimateView);
      j = ((p)localObject).lXQ;
      k = this.WyJ;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(am(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label341;
        this.WyJ = 30;
        break;
        label595:
        this.DIY = 30;
        break label248;
        label604:
        this.mMaxSize = 40;
        break label265;
        label613:
        bool = false;
        break label393;
      }
    }
    if (i < 2) {}
    for (long l = 800L + l;; l = ((Math.abs(i - k * 0.5D - 5.0D) / (k * 3) + 0.01D) * 1000.0D) + l) {
      break;
    }
    label716:
    if (this.WyI != null)
    {
      parame = this.WyI.iterator();
      while (parame.hasNext())
      {
        localObject = (View)parame.next();
        if ((localObject != null) && ((((View)localObject).getAnimation() instanceof c))) {
          c.a((c)((View)localObject).getAnimation());
        }
      }
    }
    AppMethodBeat.o(34374);
    return true;
  }
  
  public final void hMA()
  {
    AppMethodBeat.i(34379);
    Object localObject;
    float f1;
    float f2;
    if (this.Wze.jHW != null)
    {
      localObject = this.Wze.jHW.lXm;
      this.WyZ = ((p)localObject).lXQ;
      this.Wza = mx(((p)localObject).lXU, ((p)localObject).maxSize);
      localObject = ((p)localObject).fileName;
      this.WyO = this.Wza;
      this.WyP = this.Wza;
      this.aBO = 0.0F;
      this.bEi = this.mScreenWidth;
      this.aBP = 0.0F;
      this.bEj = this.mScreenHeight;
      f1 = 0.9F - this.Wza * 1.0F / this.mScreenWidth;
      f2 = -this.Wza * 1.1F / this.mScreenHeight;
      this.WyY = new LinearInterpolator();
      switch (this.WyZ)
      {
      default: 
        this.aBO = am(0.1F, f1);
        this.bEi = am(this.aBO - 0.5F, this.aBO + 0.5F);
        this.bEi = aD(this.bEi, f1);
        this.aBP = f2;
        this.bEj = 1.0F;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ChattingAnimFrame", "luckyBag, s[%s] e[%s].", new Object[] { Float.valueOf(this.aBO), Float.valueOf(this.bEi) });
      this.WyT = (this.mScreenWidth * this.aBO);
      this.WyU = (this.mScreenWidth * this.bEi);
      this.WyV = (this.mScreenHeight * this.aBP);
      this.WyW = (this.mScreenHeight * this.bEj);
      if (this.WyZ == 4)
      {
        this.WyV = (this.aIk * this.aBP);
        this.WyW = (this.aIk * this.bEj);
      }
      Log.i("MicroMsg.ChattingAnimFrame", "luckyBag, init: startX[%s] endX[%s] startY[%s] endY[%s].", new Object[] { Float.valueOf(this.WyT), Float.valueOf(this.WyU), Float.valueOf(this.WyV), Float.valueOf(this.WyW) });
      if (this.WyN == null)
      {
        this.WyN = new MMAnimateView(getContext());
        this.WyN.setOnClickListener(this.Wzh);
      }
      this.WyN.setPivotX(this.WyO / 2.0F);
      this.WyN.setPivotY(this.WyP / 2.0F);
      this.WyN.setRotation(0.0F);
      localObject = getDataEmojiPath() + "/egg/" + (String)localObject;
      this.WyN.setImageFilePath((String)localObject);
      this.WyN.setLayoutParams(new FrameLayout.LayoutParams(this.WyO, this.WyP));
      this.WyN.setX(this.WyT);
      this.WyN.setY(this.WyV);
      int i = (int)am(7000.0F, 10000.0F);
      this.Wzb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Wzb.setDuration(i);
      this.Wzb.setInterpolator(new LinearInterpolator());
      this.Wzb.addUpdateListener(this.Wzc);
      this.Wzb.setStartDelay(1500L);
      this.Wzb.addListener(this.Wzd);
      this.Wzg = ObjectAnimator.ofFloat(this.WyN, View.ROTATION, new float[] { 0.0F, 15.0F, -15.0F, 15.0F, -15.0F, 0.0F });
      this.Wzg.setInterpolator(new AccelerateDecelerateInterpolator());
      this.Wzg.setDuration(500L);
      this.Wzg.setRepeatCount(1);
      this.WyR = false;
      this.WyS = false;
      AppMethodBeat.o(34379);
      return;
      if (this.Wze.jIc != null)
      {
        localObject = this.Wze.jIc.lXm;
        this.WyZ = ((p)localObject).lXQ;
        this.Wza = mx(((p)localObject).lXU, ((p)localObject).maxSize);
        localObject = ((p)localObject).fileName;
        break;
      }
      localObject = this.Wze.jIS.lXO;
      this.WyZ = ((m)localObject).lXQ;
      this.Wza = com.tencent.mm.ci.a.fromDPToPix(getContext(), ((m)localObject).size);
      localObject = ((m)localObject).fileName;
      break;
      this.aBO = am(0.1F, f1);
      this.bEi = am(this.aBO - 0.25F, this.aBO + 0.25F);
      this.bEi = aD(this.bEi, f1);
      this.aBP = 1.0F;
      this.bEj = f2;
      continue;
      this.aBO = am(0.1F, f1);
      this.bEi = am(this.aBO - 0.25F, this.aBO + 0.25F);
      this.bEi = aD(this.bEi, f1);
      this.aBP = f2;
      this.bEj = 1.0F;
      this.WyY = new com.tencent.mm.ui.c.b.a();
      continue;
      this.aBO = am(0.1F, f1);
      this.bEi = am(this.aBO - 0.25F, this.aBO + 0.25F);
      this.bEi = aD(this.bEi, f1);
      this.aBP = 1.5F;
      this.bEj = am(0.25F, 0.55F);
      this.WyY = new com.tencent.mm.ui.c.b.b();
      continue;
      f1 = am(f2, 1.0F - this.Wza * 1.0F / this.aIk);
      this.aBO = 1.0F;
      this.bEi = (0.0F - this.Wza * 1.0F / this.mScreenWidth);
      this.aBP = f1;
      this.bEj = f1;
    }
  }
  
  public final boolean hMC()
  {
    AppMethodBeat.i(160227);
    if ((this.Wze != null) && (this.Wze.type > 0))
    {
      if ((this.cCC <= 0) && (!this.uxR))
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
    this.aIk = getMeasuredHeight();
    this.aIj = getMeasuredWidth();
    Log.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.aIj), Integer.valueOf(this.aIk) });
    AppMethodBeat.o(34372);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34373);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.aIk = (paramInt4 - paramInt2);
    this.aIj = (paramInt3 - paramInt1);
    if (this.aIk < this.mScreenHeight) {
      this.WyK = true;
    }
    for (this.WyL = (this.mScreenHeight - this.aIk);; this.WyL = 0)
    {
      Log.i("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.aIj), Integer.valueOf(this.aIk), Boolean.valueOf(this.WyK), Integer.valueOf(this.WyL) });
      AppMethodBeat.o(34373);
      return;
      this.WyK = false;
    }
  }
  
  public void setOnLuckyBagClick(d paramd)
  {
    this.Wzi = paramd;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(34376);
    Log.i("MicroMsg.ChattingAnimFrame", "stop: view: %s, count:%s", new Object[] { Integer.valueOf(this.WyI.size()), Integer.valueOf(this.cCC) });
    Iterator localIterator = this.WyI.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
      removeView(localMMAnimateView);
      Log.i("MicroMsg.ChattingAnimFrame", "stop: remove view %s", new Object[] { localMMAnimateView });
    }
    this.WyI.clear();
    hMB();
    this.cCC = 0;
    Log.i("MicroMsg.ChattingAnimFrame", "stop: end child count %s", new Object[] { Integer.valueOf(getChildCount()) });
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
    private View.OnLayoutChangeListener VWm;
    private float Wzl;
    private float Wzm;
    private float Wzn;
    private float Wzo;
    private float Wzp;
    private float Wzq;
    private int Wzr;
    private boolean Wzs;
    private float mFromX;
    private float mFromY;
    private boolean mIsRunning;
    private int mSize;
    private float mToX;
    private float mToY;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(34360);
      this.Wzr = 0;
      this.mSize = 0;
      this.Wzs = false;
      this.mIsRunning = false;
      this.VWm = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.fs();
          AppMethodBeat.o(34359);
        }
      };
      this.Wzr = paramInt1;
      this.mSize = paramInt2;
      this.Wzs = false;
      AppMethodBeat.o(34360);
    }
    
    public b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(34361);
      this.Wzr = 0;
      this.mSize = 0;
      this.Wzs = false;
      this.mIsRunning = false;
      this.VWm = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.fs();
          AppMethodBeat.o(34359);
        }
      };
      this.Wzr = paramInt1;
      this.mSize = paramInt2;
      this.Wzs = paramBoolean;
      AppMethodBeat.o(34361);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(34363);
      if ((paramFloat > 0.0F) && (!this.mIsRunning))
      {
        if (this.Wzr == 1)
        {
          this.Wzn = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.Wzo = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        }
        this.mIsRunning = true;
      }
      float f2 = this.Wzl;
      float f1 = this.Wzn;
      if (this.Wzl != this.Wzm) {
        f2 = this.Wzl + (this.Wzm - this.Wzl) * paramFloat;
      }
      if (this.Wzn != this.Wzo)
      {
        float f3 = this.Wzn + (this.Wzo - this.Wzn) * paramFloat;
        f1 = f3;
        if (this.Wzr == 2) {
          f1 = f3 - this.mSize;
        }
      }
      paramTransformation.getMatrix().setTranslate(f2, f1);
      if ((this.Wzp != this.Wzq) && (3 == this.Wzr))
      {
        paramFloat = this.Wzp + (this.Wzq - this.Wzp) * paramFloat;
        paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
      }
      AppMethodBeat.o(34363);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(34364);
      super.finalize();
      Log.i("MicroMsg.ChattingAnimFrame", "finalize!");
      ChattingAnimFrame.this.removeOnLayoutChangeListener(this.VWm);
      AppMethodBeat.o(34364);
    }
    
    public final void fs()
    {
      AppMethodBeat.i(34365);
      this.Wzl = (this.mFromX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      this.Wzm = (this.mToX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      if (this.Wzr == 2)
      {
        this.Wzn = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.Wzo = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        AppMethodBeat.o(34365);
        return;
      }
      if (this.Wzr == 3)
      {
        this.Wzn = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.Wzo = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        if (ChattingAnimFrame.d(ChattingAnimFrame.this))
        {
          this.Wzn = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
          this.Wzo = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
        }
        if (this.Wzo < 0.0F)
        {
          this.Wzo = 0.0F;
          AppMethodBeat.o(34365);
        }
      }
      else
      {
        if (this.Wzr == 4)
        {
          this.Wzn = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.Wzo = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          AppMethodBeat.o(34365);
          return;
        }
        this.Wzn = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.Wzo = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
      }
      AppMethodBeat.o(34365);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(34362);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      switch (this.Wzr)
      {
      default: 
        this.mFromX = ChattingAnimFrame.am(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.am(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = -0.2F;
        this.mToY = 1.1F;
        setInterpolator(new LinearInterpolator());
      }
      for (;;)
      {
        if ((this.Wzr != 0) && (this.Wzr != 1)) {
          ChattingAnimFrame.this.addOnLayoutChangeListener(this.VWm);
        }
        fs();
        AppMethodBeat.o(34362);
        return;
        this.mFromX = ChattingAnimFrame.am(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.am(this.mFromX - 0.25F, this.mFromX + 0.25F);
        this.mFromY = 1.1F;
        this.mToY = -0.2F;
        setInterpolator(new LinearInterpolator());
        continue;
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 1.5F;
        if (this.Wzs) {}
        for (this.mToY = ChattingAnimFrame.am(0.4F, 0.55F);; this.mToY = ChattingAnimFrame.am(0.55F, 0.85F))
        {
          setInterpolator(new com.tencent.mm.ui.c.b.b());
          break;
        }
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 0.0F;
        this.mToY = 1.0F;
        setInterpolator(new com.tencent.mm.ui.c.b.a());
        continue;
        this.mFromX = ChattingAnimFrame.am(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.am(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = 0.0F;
        this.mToY = 0.0F;
        this.Wzp = 0.8F;
        this.Wzq = 1.1F;
        setInterpolator(new LinearInterpolator());
        continue;
        float f = ChattingAnimFrame.am(0.0F, 1.0F - this.mSize * 1.0F / ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.mFromX = 1.0F;
        this.mToX = (0.0F - this.mSize * 1.0F / ChattingAnimFrame.b(ChattingAnimFrame.this));
        this.mFromY = f;
        this.mToY = f;
        setInterpolator(new LinearInterpolator());
      }
    }
  }
  
  final class c
    extends AnimationSet
  {
    private long Wzu;
    MMAnimateView Wzv;
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
            Log.i("MicroMsg.ChattingAnimFrame", "onAnimationEnd: %s", new Object[] { ChattingAnimFrame.c.this.Wzv });
            paramAnonymousAnimation = ChattingAnimFrame.c.this;
            if (paramAnonymousAnimation.Wzv != null)
            {
              paramAnonymousAnimation.Wzv.post(new ChattingAnimFrame.c.2(paramAnonymousAnimation));
              AppMethodBeat.o(34366);
              return;
            }
            Log.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
            AppMethodBeat.o(34366);
          }
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(275186);
            Log.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: %s", new Object[] { ChattingAnimFrame.c.this.Wzv });
            if (ChattingAnimFrame.c.this.Wzv != null) {
              ChattingAnimFrame.c.this.Wzv.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(278583);
                  ChattingAnimFrame.c.this.Wzv.setVisibility(0);
                  AppMethodBeat.o(278583);
                }
              }, ChattingAnimFrame.c.b(ChattingAnimFrame.c.this));
            }
            AppMethodBeat.o(275186);
          }
        });
        this.Wzu = (500L + paramLong);
        reset();
        setDuration(ChattingAnimFrame.avh(paramInt1));
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
    public abstract void a(c paramc, com.tencent.mm.be.e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame
 * JD-Core Version:    0.7.0.1
 */