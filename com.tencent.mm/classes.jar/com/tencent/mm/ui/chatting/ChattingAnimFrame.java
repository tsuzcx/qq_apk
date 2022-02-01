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
import com.tencent.mm.modelpackage.e;
import com.tencent.mm.modelpackage.q;
import com.tencent.mm.plugin.eggspring.c.c;
import com.tencent.mm.plugin.eggspring.f;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String xLe = "";
  private int JAb;
  c aegA;
  ObjectAnimator aegB;
  View.OnClickListener aegC;
  private d aegD;
  List<MMAnimateView> aege;
  private int aegf;
  private boolean aegg;
  private int aegh;
  private ArrayList<Integer> aegi;
  MMAnimateView aegj;
  int aegk;
  int aegl;
  private float aegm;
  boolean aegn;
  boolean aego;
  float aegp;
  float aegq;
  float aegr;
  float aegs;
  private Interpolator aegt;
  Interpolator aegu;
  int aegv;
  int aegw;
  ValueAnimator aegx;
  ValueAnimator.AnimatorUpdateListener aegy;
  Animator.AnimatorListener aegz;
  float cxD;
  float cxE;
  float dxj;
  float dxk;
  int evg;
  private int mMaxSize;
  int mScreenHeight;
  int mScreenWidth;
  int mViewHeight;
  private int mViewWidth;
  e mdu;
  boolean xED;
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34371);
    this.aege = new ArrayList();
    this.evg = 0;
    this.aegf = 30;
    this.JAb = 30;
    this.mMaxSize = 40;
    this.aegg = false;
    this.aegh = 0;
    this.aegi = new ArrayList();
    this.aegm = 0.2F;
    this.aegy = new ValueAnimator.AnimatorUpdateListener()
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
    this.aegz = new Animator.AnimatorListener()
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
        AppMethodBeat.i(253728);
        Log.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: luckyBag");
        if (ChattingAnimFrame.i(ChattingAnimFrame.this) == 1)
        {
          ChattingAnimFrame.b(ChattingAnimFrame.this, ChattingAnimFrame.a(ChattingAnimFrame.this) * ChattingAnimFrame.k(ChattingAnimFrame.this));
          ChattingAnimFrame.a(ChattingAnimFrame.this, -ChattingAnimFrame.j(ChattingAnimFrame.this));
        }
        AppMethodBeat.o(253728);
      }
    };
    this.aegC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34358);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.ChattingAnimFrame", "lucky bag click!!!");
        paramAnonymousView = f.xEl;
        f.bb(4, f.oQy);
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
    this.mScreenHeight = com.tencent.mm.cd.a.mt(getContext());
    this.mScreenWidth = com.tencent.mm.cd.a.ms(getContext());
    this.aegk = com.tencent.mm.cd.a.fromDPToPix(getContext(), 60);
    this.aegl = com.tencent.mm.cd.a.fromDPToPix(getContext(), 80);
    AppMethodBeat.o(34371);
  }
  
  private void aBI(int paramInt)
  {
    AppMethodBeat.i(34375);
    if (paramInt <= 0)
    {
      Log.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      AppMethodBeat.o(34375);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.aegi != null) {
      this.aegi.clear();
    }
    while (this.aegi.size() < i)
    {
      int j = (int)aQ(0.0F, paramInt);
      if (!this.aegi.contains(Integer.valueOf(j)))
      {
        this.aegi.add(Integer.valueOf(j));
        continue;
        this.aegi = new ArrayList();
      }
    }
    AppMethodBeat.o(34375);
  }
  
  static float aQ(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(34377);
    float f = (float)Math.random();
    AppMethodBeat.o(34377);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  static float bh(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(253683);
    paramFloat1 = Math.max(0.1F, Math.min(paramFloat1, paramFloat2));
    AppMethodBeat.o(253683);
    return paramFloat1;
  }
  
  static String getDataEmojiPath()
  {
    AppMethodBeat.i(34370);
    if (Util.isNullOrNil(xLe))
    {
      xLe = com.tencent.mm.loader.i.b.bms();
      xLe += "/emoji";
    }
    String str = xLe;
    AppMethodBeat.o(34370);
    return str;
  }
  
  private void jpd()
  {
    AppMethodBeat.i(160226);
    if ((this.aegj != null) && (this.xED))
    {
      this.aegj.stop();
      removeView(this.aegj);
      this.xED = false;
      this.aegA = null;
      if (this.aegx != null)
      {
        this.aegx.end();
        this.aegx = null;
      }
      if (this.aegB != null)
      {
        this.aegB.end();
        this.aegB = null;
      }
      this.aegj.setRotation(0.0F);
    }
    AppMethodBeat.o(160226);
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
    int j = parame.oQv.size();
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
    Object localObject = (q)parame.oQv.get(i);
    String str = getDataEmojiPath() + "/egg/" + ((q)localObject).fileName;
    if (!y.ZC(str))
    {
      Log.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      AppMethodBeat.o(34374);
      return false;
    }
    this.mdu = parame;
    setVisibility(0);
    if (ac.b(parame)) {
      h.OAn.kJ(1263, 3);
    }
    label248:
    int k;
    label265:
    label341:
    boolean bool;
    if (((q)localObject).oQX > 0)
    {
      this.aegf = ((q)localObject).oQX;
      if (this.aegf > 60) {
        this.aegf = 60;
      }
      if (((q)localObject).oQY <= 0) {
        break label595;
      }
      this.JAb = ((q)localObject).oQY;
      if (((q)localObject).maxSize <= 0) {
        break label604;
      }
      this.mMaxSize = ((q)localObject).maxSize;
      Log.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.aegf), Integer.valueOf(this.JAb), Integer.valueOf(this.mMaxSize), Integer.valueOf(((q)localObject).oQU), Integer.valueOf(parame.hYb) });
      l = 0L;
      aBI(this.aegf);
      i = 0;
      if (i >= this.aegf) {
        break label716;
      }
      j = or(this.JAb, this.mMaxSize);
      k = ((q)localObject).oQU;
      if ((this.aegi == null) || (!this.aegi.contains(Integer.valueOf(i)))) {
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
      parame.aegP = localMMAnimateView;
      localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(parame.mSize, parame.mSize));
      this.aege.add(localMMAnimateView);
      this.evg += 1;
      Log.i("MicroMsg.ChattingAnimFrame", "addView counter++: [%s]. %s", new Object[] { Integer.valueOf(this.evg), localMMAnimateView });
      addView(localMMAnimateView);
      j = ((q)localObject).oQU;
      k = this.aegf;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(aQ(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label341;
        this.aegf = 30;
        break;
        label595:
        this.JAb = 30;
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
    if (this.aege != null)
    {
      parame = this.aege.iterator();
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
  
  public final boolean isPlaying()
  {
    return (this.mdu != null) && ((this.evg > 0) || (this.xED));
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(34372);
    super.onFinishInflate();
    this.mViewHeight = getMeasuredHeight();
    this.mViewWidth = getMeasuredWidth();
    Log.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.mViewWidth), Integer.valueOf(this.mViewHeight) });
    AppMethodBeat.o(34372);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34373);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mViewHeight = (paramInt4 - paramInt2);
    this.mViewWidth = (paramInt3 - paramInt1);
    if (this.mViewHeight < this.mScreenHeight) {
      this.aegg = true;
    }
    for (this.aegh = (this.mScreenHeight - this.mViewHeight);; this.aegh = 0)
    {
      Log.i("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.mViewWidth), Integer.valueOf(this.mViewHeight), Boolean.valueOf(this.aegg), Integer.valueOf(this.aegh) });
      AppMethodBeat.o(34373);
      return;
      this.aegg = false;
    }
  }
  
  final int or(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253751);
    paramInt1 = (int)aQ(paramInt1, paramInt2);
    paramInt1 = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt1);
    AppMethodBeat.o(253751);
    return paramInt1;
  }
  
  public void setOnLuckyBagClick(d paramd)
  {
    this.aegD = paramd;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(34376);
    Log.i("MicroMsg.ChattingAnimFrame", "stop: view: %s, count:%s", new Object[] { Integer.valueOf(this.aege.size()), Integer.valueOf(this.evg) });
    Iterator localIterator = this.aege.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
      removeView(localMMAnimateView);
      Log.i("MicroMsg.ChattingAnimFrame", "stop: remove view %s", new Object[] { localMMAnimateView });
    }
    this.aege.clear();
    jpd();
    this.evg = 0;
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
    private int RWB;
    private View.OnLayoutChangeListener adAI;
    private float aegG;
    private float aegH;
    private float aegI;
    private float aegJ;
    private float aegK;
    private float aegL;
    private boolean aegM;
    private float mFromX;
    private float mFromY;
    private boolean mIsRunning;
    private int mSize;
    private float mToX;
    private float mToY;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(34360);
      this.RWB = 0;
      this.mSize = 0;
      this.aegM = false;
      this.mIsRunning = false;
      this.adAI = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.CB();
          AppMethodBeat.o(34359);
        }
      };
      this.RWB = paramInt1;
      this.mSize = paramInt2;
      this.aegM = false;
      AppMethodBeat.o(34360);
    }
    
    public b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(34361);
      this.RWB = 0;
      this.mSize = 0;
      this.aegM = false;
      this.mIsRunning = false;
      this.adAI = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.CB();
          AppMethodBeat.o(34359);
        }
      };
      this.RWB = paramInt1;
      this.mSize = paramInt2;
      this.aegM = paramBoolean;
      AppMethodBeat.o(34361);
    }
    
    public final void CB()
    {
      AppMethodBeat.i(34365);
      this.aegG = (this.mFromX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      this.aegH = (this.mToX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      if (this.RWB == 2)
      {
        this.aegI = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.aegJ = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        AppMethodBeat.o(34365);
        return;
      }
      if (this.RWB == 3)
      {
        this.aegI = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.aegJ = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        if (ChattingAnimFrame.d(ChattingAnimFrame.this))
        {
          this.aegI = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
          this.aegJ = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
        }
        if (this.aegJ < 0.0F)
        {
          this.aegJ = 0.0F;
          AppMethodBeat.o(34365);
        }
      }
      else
      {
        if (this.RWB == 4)
        {
          this.aegI = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.aegJ = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          AppMethodBeat.o(34365);
          return;
        }
        this.aegI = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.aegJ = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
      }
      AppMethodBeat.o(34365);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(34363);
      if ((paramFloat > 0.0F) && (!this.mIsRunning))
      {
        if (this.RWB == 1)
        {
          this.aegI = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.aegJ = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        }
        this.mIsRunning = true;
      }
      float f2 = this.aegG;
      float f1 = this.aegI;
      if (this.aegG != this.aegH) {
        f2 = this.aegG + (this.aegH - this.aegG) * paramFloat;
      }
      if (this.aegI != this.aegJ)
      {
        float f3 = this.aegI + (this.aegJ - this.aegI) * paramFloat;
        f1 = f3;
        if (this.RWB == 2) {
          f1 = f3 - this.mSize;
        }
      }
      paramTransformation.getMatrix().setTranslate(f2, f1);
      if ((this.aegK != this.aegL) && (3 == this.RWB))
      {
        paramFloat = this.aegK + (this.aegL - this.aegK) * paramFloat;
        paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
      }
      AppMethodBeat.o(34363);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(34364);
      super.finalize();
      Log.i("MicroMsg.ChattingAnimFrame", "finalize!");
      ChattingAnimFrame.this.removeOnLayoutChangeListener(this.adAI);
      AppMethodBeat.o(34364);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(34362);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      switch (this.RWB)
      {
      default: 
        this.mFromX = ChattingAnimFrame.aQ(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.aQ(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = -0.2F;
        this.mToY = 1.1F;
        setInterpolator(new LinearInterpolator());
      }
      for (;;)
      {
        if ((this.RWB != 0) && (this.RWB != 1)) {
          ChattingAnimFrame.this.addOnLayoutChangeListener(this.adAI);
        }
        CB();
        AppMethodBeat.o(34362);
        return;
        this.mFromX = ChattingAnimFrame.aQ(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.aQ(this.mFromX - 0.25F, this.mFromX + 0.25F);
        this.mFromY = 1.1F;
        this.mToY = -0.2F;
        setInterpolator(new LinearInterpolator());
        continue;
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 1.5F;
        if (this.aegM) {}
        for (this.mToY = ChattingAnimFrame.aQ(0.4F, 0.55F);; this.mToY = ChattingAnimFrame.aQ(0.55F, 0.85F))
        {
          setInterpolator(new com.tencent.mm.ui.anim.e.b());
          break;
        }
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 0.0F;
        this.mToY = 1.0F;
        setInterpolator(new com.tencent.mm.ui.anim.e.a());
        continue;
        this.mFromX = ChattingAnimFrame.aQ(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.aQ(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = 0.0F;
        this.mToY = 0.0F;
        this.aegK = 0.8F;
        this.aegL = 1.1F;
        setInterpolator(new LinearInterpolator());
        continue;
        float f = ChattingAnimFrame.aQ(0.0F, 1.0F - this.mSize * 1.0F / ChattingAnimFrame.a(ChattingAnimFrame.this));
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
    private long aegO;
    MMAnimateView aegP;
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
            Log.i("MicroMsg.ChattingAnimFrame", "onAnimationEnd: %s", new Object[] { ChattingAnimFrame.c.this.aegP });
            paramAnonymousAnimation = ChattingAnimFrame.c.this;
            if (paramAnonymousAnimation.aegP != null)
            {
              paramAnonymousAnimation.aegP.post(new ChattingAnimFrame.c.2(paramAnonymousAnimation));
              AppMethodBeat.o(34366);
              return;
            }
            Log.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
            AppMethodBeat.o(34366);
          }
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(254024);
            Log.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: %s", new Object[] { ChattingAnimFrame.c.this.aegP });
            if (ChattingAnimFrame.c.this.aegP != null) {
              ChattingAnimFrame.c.this.aegP.postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(254267);
                  ChattingAnimFrame.c.this.aegP.setVisibility(0);
                  AppMethodBeat.o(254267);
                }
              }, ChattingAnimFrame.c.b(ChattingAnimFrame.c.this));
            }
            AppMethodBeat.o(254024);
          }
        });
        this.aegO = (500L + paramLong);
        reset();
        setDuration(ChattingAnimFrame.aBJ(paramInt1));
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
    public abstract void a(c paramc, e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame
 * JD-Core Version:    0.7.0.1
 */