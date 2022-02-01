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
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.k;
import com.tencent.mm.bb.l;
import com.tencent.mm.bb.o;
import com.tencent.mm.plugin.eggspring.c.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String qZH = "";
  private int DAQ;
  private boolean PfA;
  private float PfB;
  private float PfC;
  private float PfD;
  private float PfE;
  private Interpolator PfF;
  private Interpolator PfG;
  private int PfH;
  private int PfI;
  private ValueAnimator PfJ;
  private ValueAnimator.AnimatorUpdateListener PfK;
  private Animator.AnimatorListener PfL;
  private e PfM;
  private ObjectAnimator PfN;
  private View.OnClickListener PfO;
  private d PfP;
  List<MMAnimateView> Pfq;
  private int Pfr;
  private boolean Pfs;
  private int Pft;
  private ArrayList<Integer> Pfu;
  private MMAnimateView Pfv;
  private int Pfw;
  private int Pfx;
  private float Pfy;
  private boolean Pfz;
  private int aYN;
  private int aYO;
  int cBY;
  private int mMaxSize;
  private int mScreenHeight;
  private int mScreenWidth;
  private float me;
  private float mf;
  private float mg;
  private float mh;
  private boolean qVe;
  private com.tencent.mm.plugin.eggspring.c.c qVj;
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34371);
    this.Pfq = new ArrayList();
    this.cBY = 0;
    this.Pfr = 30;
    this.DAQ = 30;
    this.mMaxSize = 40;
    this.Pfs = false;
    this.Pft = 0;
    this.Pfu = new ArrayList();
    this.Pfy = 0.2F;
    this.PfK = new ValueAnimator.AnimatorUpdateListener()
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
    this.PfL = new Animator.AnimatorListener()
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
        AppMethodBeat.i(232849);
        Log.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: luckyBag");
        if (ChattingAnimFrame.i(ChattingAnimFrame.this) == 1)
        {
          ChattingAnimFrame.b(ChattingAnimFrame.this, ChattingAnimFrame.a(ChattingAnimFrame.this) * ChattingAnimFrame.k(ChattingAnimFrame.this));
          ChattingAnimFrame.a(ChattingAnimFrame.this, -ChattingAnimFrame.j(ChattingAnimFrame.this));
        }
        AppMethodBeat.o(232849);
      }
    };
    this.PfO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34358);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.ChattingAnimFrame", "lucky bag click!!!");
        paramAnonymousView = com.tencent.mm.plugin.eggspring.c.qUO;
        com.tencent.mm.plugin.eggspring.c.cEH().FE(4);
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
    this.mScreenHeight = com.tencent.mm.cb.a.jo(getContext());
    this.mScreenWidth = com.tencent.mm.cb.a.jn(getContext());
    this.Pfw = com.tencent.mm.cb.a.fromDPToPix(getContext(), 60);
    this.Pfx = com.tencent.mm.cb.a.fromDPToPix(getContext(), 80);
    AppMethodBeat.o(34371);
  }
  
  static float ak(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(34377);
    float f = (float)Math.random();
    AppMethodBeat.o(34377);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private void amf(int paramInt)
  {
    AppMethodBeat.i(34375);
    if (paramInt <= 0)
    {
      Log.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      AppMethodBeat.o(34375);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.Pfu != null) {
      this.Pfu.clear();
    }
    while (this.Pfu.size() < i)
    {
      int j = (int)ak(0.0F, paramInt);
      if (!this.Pfu.contains(Integer.valueOf(j)))
      {
        this.Pfu.add(Integer.valueOf(j));
        continue;
        this.Pfu = new ArrayList();
      }
    }
    AppMethodBeat.o(34375);
  }
  
  private void gNs()
  {
    AppMethodBeat.i(160226);
    if ((this.Pfv != null) && (this.qVe))
    {
      this.Pfv.stop();
      removeView(this.Pfv);
      this.qVe = false;
      this.qVj = null;
      if (this.PfJ != null)
      {
        this.PfJ.end();
        this.PfJ = null;
      }
      if (this.PfN != null)
      {
        this.PfN.end();
        this.PfN = null;
      }
      this.Pfv.setRotation(0.0F);
    }
    AppMethodBeat.o(160226);
  }
  
  private static String getDataEmojiPath()
  {
    AppMethodBeat.i(34370);
    if (Util.isNullOrNil(qZH))
    {
      qZH = com.tencent.mm.loader.j.b.aKC().replace("/data/user/0", "/data/data");
      qZH += "/emoji";
    }
    String str = qZH;
    AppMethodBeat.o(34370);
    return str;
  }
  
  private static float j(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(232852);
    paramFloat1 = Math.max(0.1F, Math.min(paramFloat1, paramFloat2));
    AppMethodBeat.o(232852);
    return paramFloat1;
  }
  
  private int le(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(232853);
    paramInt1 = (int)ak(paramInt1, paramInt2);
    paramInt1 = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt1);
    AppMethodBeat.o(232853);
    return paramInt1;
  }
  
  public final void a(com.tencent.mm.plugin.eggspring.c.c paramc)
  {
    AppMethodBeat.i(232854);
    Log.i("MicroMsg.ChattingAnimFrame", "showLuckyBag: ");
    if ((this.Pfv != null) && (this.PfJ != null) && (!this.qVe))
    {
      c.a locala = com.tencent.mm.plugin.eggspring.c.qUO;
      com.tencent.mm.plugin.eggspring.c.cEH().FE(3);
      this.qVe = true;
      this.qVj = paramc;
      addView(this.Pfv);
      Log.i("MicroMsg.ChattingAnimFrame", "lucky bag start anim!!!");
      this.PfJ.start();
      this.Pfv.start();
    }
    AppMethodBeat.o(232854);
  }
  
  public final boolean a(e parame)
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
    int j = parame.jgQ.size();
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
    Object localObject = (o)parame.jgQ.get(i);
    String str = getDataEmojiPath() + "/egg/" + ((o)localObject).fileName;
    if (!s.YS(str))
    {
      Log.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      AppMethodBeat.o(34374);
      return false;
    }
    this.PfM = parame;
    setVisibility(0);
    if (aa.b(parame)) {
      h.CyF.dN(1263, 3);
    }
    label248:
    int k;
    label265:
    label341:
    boolean bool;
    if (((o)localObject).jhq > 0)
    {
      this.Pfr = ((o)localObject).jhq;
      if (this.Pfr > 60) {
        this.Pfr = 60;
      }
      if (((o)localObject).jhr <= 0) {
        break label595;
      }
      this.DAQ = ((o)localObject).jhr;
      if (((o)localObject).maxSize <= 0) {
        break label604;
      }
      this.mMaxSize = ((o)localObject).maxSize;
      Log.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.Pfr), Integer.valueOf(this.DAQ), Integer.valueOf(this.mMaxSize), Integer.valueOf(((o)localObject).jhn), Integer.valueOf(parame.dYn) });
      l = 0L;
      amf(this.Pfr);
      i = 0;
      if (i >= this.Pfr) {
        break label716;
      }
      j = le(this.DAQ, this.mMaxSize);
      k = ((o)localObject).jhn;
      if ((this.Pfu == null) || (!this.Pfu.contains(Integer.valueOf(i)))) {
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
      parame.Pgc = localMMAnimateView;
      localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(parame.mSize, parame.mSize));
      this.Pfq.add(localMMAnimateView);
      this.cBY += 1;
      Log.i("MicroMsg.ChattingAnimFrame", "addView counter++: [%s]. %s", new Object[] { Integer.valueOf(this.cBY), localMMAnimateView });
      addView(localMMAnimateView);
      j = ((o)localObject).jhn;
      k = this.Pfr;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(ak(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label341;
        this.Pfr = 30;
        break;
        label595:
        this.DAQ = 30;
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
    if (this.Pfq != null)
    {
      parame = this.Pfq.iterator();
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
  
  public final void gNr()
  {
    AppMethodBeat.i(34379);
    Object localObject;
    float f1;
    float f2;
    if (this.PfM.gWY != null)
    {
      localObject = this.PfM.gWY.jgJ;
      this.PfH = ((o)localObject).jhn;
      this.PfI = le(((o)localObject).jhr, ((o)localObject).maxSize);
      localObject = ((o)localObject).fileName;
      this.Pfw = this.PfI;
      this.Pfx = this.PfI;
      this.me = 0.0F;
      this.mg = this.mScreenWidth;
      this.mf = 0.0F;
      this.mh = this.mScreenHeight;
      f1 = 0.9F - this.PfI * 1.0F / this.mScreenWidth;
      f2 = -this.PfI * 1.1F / this.mScreenHeight;
      this.PfG = new LinearInterpolator();
      switch (this.PfH)
      {
      default: 
        this.me = ak(0.1F, f1);
        this.mg = ak(this.me - 0.5F, this.me + 0.5F);
        this.mg = j(this.mg, f1);
        this.mf = f2;
        this.mh = 1.0F;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ChattingAnimFrame", "luckyBag, s[%s] e[%s].", new Object[] { Float.valueOf(this.me), Float.valueOf(this.mg) });
      this.PfB = (this.mScreenWidth * this.me);
      this.PfC = (this.mScreenWidth * this.mg);
      this.PfD = (this.mScreenHeight * this.mf);
      this.PfE = (this.mScreenHeight * this.mh);
      if (this.PfH == 4)
      {
        this.PfD = (this.aYO * this.mf);
        this.PfE = (this.aYO * this.mh);
      }
      Log.i("MicroMsg.ChattingAnimFrame", "luckyBag, init: startX[%s] endX[%s] startY[%s] endY[%s].", new Object[] { Float.valueOf(this.PfB), Float.valueOf(this.PfC), Float.valueOf(this.PfD), Float.valueOf(this.PfE) });
      if (this.Pfv == null)
      {
        this.Pfv = new MMAnimateView(getContext());
        this.Pfv.setOnClickListener(this.PfO);
      }
      this.Pfv.setPivotX(this.Pfw / 2.0F);
      this.Pfv.setPivotY(this.Pfx / 2.0F);
      this.Pfv.setRotation(0.0F);
      localObject = getDataEmojiPath() + "/egg/" + (String)localObject;
      this.Pfv.setImageFilePath((String)localObject);
      this.Pfv.setLayoutParams(new FrameLayout.LayoutParams(this.Pfw, this.Pfx));
      this.Pfv.setX(this.PfB);
      this.Pfv.setY(this.PfD);
      int i = (int)ak(7000.0F, 10000.0F);
      this.PfJ = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.PfJ.setDuration(i);
      this.PfJ.setInterpolator(new LinearInterpolator());
      this.PfJ.addUpdateListener(this.PfK);
      this.PfJ.setStartDelay(1500L);
      this.PfJ.addListener(this.PfL);
      this.PfN = ObjectAnimator.ofFloat(this.Pfv, View.ROTATION, new float[] { 0.0F, 15.0F, -15.0F, 15.0F, -15.0F, 0.0F });
      this.PfN.setInterpolator(new AccelerateDecelerateInterpolator());
      this.PfN.setDuration(500L);
      this.PfN.setRepeatCount(1);
      this.Pfz = false;
      this.PfA = false;
      AppMethodBeat.o(34379);
      return;
      localObject = this.PfM.gXT.jhm;
      this.PfH = ((l)localObject).jhn;
      this.PfI = com.tencent.mm.cb.a.fromDPToPix(getContext(), ((l)localObject).size);
      localObject = ((l)localObject).fileName;
      break;
      this.me = ak(0.1F, f1);
      this.mg = ak(this.me - 0.25F, this.me + 0.25F);
      this.mg = j(this.mg, f1);
      this.mf = 1.0F;
      this.mh = f2;
      continue;
      this.me = ak(0.1F, f1);
      this.mg = ak(this.me - 0.25F, this.me + 0.25F);
      this.mg = j(this.mg, f1);
      this.mf = f2;
      this.mh = 1.0F;
      this.PfG = new com.tencent.mm.ui.c.b.a();
      continue;
      this.me = ak(0.1F, f1);
      this.mg = ak(this.me - 0.25F, this.me + 0.25F);
      this.mg = j(this.mg, f1);
      this.mf = 1.5F;
      this.mh = ak(0.25F, 0.55F);
      this.PfG = new com.tencent.mm.ui.c.b.b();
      continue;
      f1 = ak(f2, 1.0F - this.PfI * 1.0F / this.aYO);
      this.me = 1.0F;
      this.mg = (0.0F - this.PfI * 1.0F / this.mScreenWidth);
      this.mf = f1;
      this.mh = f1;
    }
  }
  
  public final boolean gNt()
  {
    AppMethodBeat.i(160227);
    if ((this.PfM != null) && (this.PfM.type > 0))
    {
      if ((this.cBY <= 0) && (!this.qVe))
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
    this.aYO = getMeasuredHeight();
    this.aYN = getMeasuredWidth();
    Log.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.aYN), Integer.valueOf(this.aYO) });
    AppMethodBeat.o(34372);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34373);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.aYO = (paramInt4 - paramInt2);
    this.aYN = (paramInt3 - paramInt1);
    if (this.aYO < this.mScreenHeight) {
      this.Pfs = true;
    }
    for (this.Pft = (this.mScreenHeight - this.aYO);; this.Pft = 0)
    {
      Log.i("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.aYN), Integer.valueOf(this.aYO), Boolean.valueOf(this.Pfs), Integer.valueOf(this.Pft) });
      AppMethodBeat.o(34373);
      return;
      this.Pfs = false;
    }
  }
  
  public void setOnLuckyBagClick(d paramd)
  {
    this.PfP = paramd;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(34376);
    Log.i("MicroMsg.ChattingAnimFrame", "stop: view: %s, count:%s", new Object[] { Integer.valueOf(this.Pfq.size()), Integer.valueOf(this.cBY) });
    Iterator localIterator = this.Pfq.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
      removeView(localMMAnimateView);
      Log.i("MicroMsg.ChattingAnimFrame", "stop: remove view %s", new Object[] { localMMAnimateView });
    }
    this.Pfq.clear();
    gNs();
    this.cBY = 0;
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
    private View.OnLayoutChangeListener OCV;
    private float PfS;
    private float PfT;
    private float PfU;
    private float PfV;
    private float PfW;
    private float PfX;
    private int PfY;
    private boolean PfZ;
    private float mFromX;
    private float mFromY;
    private boolean mIsRunning;
    private int mSize;
    private float mToX;
    private float mToY;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(34360);
      this.PfY = 0;
      this.mSize = 0;
      this.PfZ = false;
      this.mIsRunning = false;
      this.OCV = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.PfY = paramInt1;
      this.mSize = paramInt2;
      this.PfZ = false;
      AppMethodBeat.o(34360);
    }
    
    public b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(34361);
      this.PfY = 0;
      this.mSize = 0;
      this.PfZ = false;
      this.mIsRunning = false;
      this.OCV = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.PfY = paramInt1;
      this.mSize = paramInt2;
      this.PfZ = paramBoolean;
      AppMethodBeat.o(34361);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(34363);
      if ((paramFloat > 0.0F) && (!this.mIsRunning))
      {
        if (this.PfY == 1)
        {
          this.PfU = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.PfV = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        }
        this.mIsRunning = true;
      }
      float f2 = this.PfS;
      float f1 = this.PfU;
      if (this.PfS != this.PfT) {
        f2 = this.PfS + (this.PfT - this.PfS) * paramFloat;
      }
      if (this.PfU != this.PfV)
      {
        float f3 = this.PfU + (this.PfV - this.PfU) * paramFloat;
        f1 = f3;
        if (this.PfY == 2) {
          f1 = f3 - this.mSize;
        }
      }
      paramTransformation.getMatrix().setTranslate(f2, f1);
      if ((this.PfW != this.PfX) && (3 == this.PfY))
      {
        paramFloat = this.PfW + (this.PfX - this.PfW) * paramFloat;
        paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
      }
      AppMethodBeat.o(34363);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(34364);
      super.finalize();
      Log.i("MicroMsg.ChattingAnimFrame", "finalize!");
      ChattingAnimFrame.this.removeOnLayoutChangeListener(this.OCV);
      AppMethodBeat.o(34364);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(34362);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      switch (this.PfY)
      {
      default: 
        this.mFromX = ChattingAnimFrame.ak(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.ak(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = -0.2F;
        this.mToY = 1.1F;
        setInterpolator(new LinearInterpolator());
      }
      for (;;)
      {
        if ((this.PfY != 0) && (this.PfY != 1)) {
          ChattingAnimFrame.this.addOnLayoutChangeListener(this.OCV);
        }
        resolve();
        AppMethodBeat.o(34362);
        return;
        this.mFromX = ChattingAnimFrame.ak(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.ak(this.mFromX - 0.25F, this.mFromX + 0.25F);
        this.mFromY = 1.1F;
        this.mToY = -0.2F;
        setInterpolator(new LinearInterpolator());
        continue;
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 1.5F;
        if (this.PfZ) {}
        for (this.mToY = ChattingAnimFrame.ak(0.4F, 0.55F);; this.mToY = ChattingAnimFrame.ak(0.55F, 0.85F))
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
        this.mFromX = ChattingAnimFrame.ak(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.ak(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = 0.0F;
        this.mToY = 0.0F;
        this.PfW = 0.8F;
        this.PfX = 1.1F;
        setInterpolator(new LinearInterpolator());
        continue;
        float f = ChattingAnimFrame.ak(0.0F, 1.0F - this.mSize * 1.0F / ChattingAnimFrame.a(ChattingAnimFrame.this));
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
      this.PfS = (this.mFromX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      this.PfT = (this.mToX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      if (this.PfY == 2)
      {
        this.PfU = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.PfV = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        AppMethodBeat.o(34365);
        return;
      }
      if (this.PfY == 3)
      {
        this.PfU = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.PfV = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        if (ChattingAnimFrame.d(ChattingAnimFrame.this))
        {
          this.PfU = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
          this.PfV = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
        }
        if (this.PfV < 0.0F)
        {
          this.PfV = 0.0F;
          AppMethodBeat.o(34365);
        }
      }
      else
      {
        if (this.PfY == 4)
        {
          this.PfU = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.PfV = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          AppMethodBeat.o(34365);
          return;
        }
        this.PfU = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.PfV = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
      }
      AppMethodBeat.o(34365);
    }
  }
  
  final class c
    extends AnimationSet
  {
    private long Pgb;
    MMAnimateView Pgc;
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
            Log.i("MicroMsg.ChattingAnimFrame", "onAnimationEnd: %s", new Object[] { ChattingAnimFrame.c.this.Pgc });
            paramAnonymousAnimation = ChattingAnimFrame.c.this;
            if (paramAnonymousAnimation.Pgc != null)
            {
              paramAnonymousAnimation.Pgc.post(new ChattingAnimFrame.c.2(paramAnonymousAnimation));
              AppMethodBeat.o(34366);
              return;
            }
            Log.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
            AppMethodBeat.o(34366);
          }
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(232851);
            Log.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: %s", new Object[] { ChattingAnimFrame.c.this.Pgc });
            if (ChattingAnimFrame.c.this.Pgc != null) {
              ChattingAnimFrame.c.this.Pgc.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(232850);
                  ChattingAnimFrame.c.this.Pgc.setVisibility(0);
                  AppMethodBeat.o(232850);
                }
              }, ChattingAnimFrame.c.b(ChattingAnimFrame.c.this));
            }
            AppMethodBeat.o(232851);
          }
        });
        this.Pgb = (500L + paramLong);
        reset();
        setDuration(ChattingAnimFrame.amg(paramInt1));
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
    public abstract void a(com.tencent.mm.plugin.eggspring.c.c paramc, e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame
 * JD-Core Version:    0.7.0.1
 */