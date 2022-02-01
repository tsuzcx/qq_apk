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
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.m;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.eggspring.b.c;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String oYY = "";
  List<MMAnimateView> HLE;
  private int HLF;
  private boolean HLG;
  private int HLH;
  private ArrayList<Integer> HLI;
  MMAnimateView HLJ;
  private int HLK;
  private int HLL;
  private int HLM;
  private boolean HLN;
  private boolean HLO;
  ValueAnimator HLP;
  ValueAnimator HLQ;
  private ValueAnimator.AnimatorUpdateListener HLR;
  private Animator.AnimatorListener HLT;
  d HLU;
  private ObjectAnimator HLV;
  private View.OnClickListener HLW;
  private d HLX;
  private int aOy;
  private int aOz;
  int fqZ;
  private int mScreenHeight;
  private int mScreenWidth;
  c oVF;
  boolean oVy;
  private int zlY;
  private int zlZ;
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34371);
    this.HLE = new ArrayList();
    this.fqZ = 0;
    this.HLF = 30;
    this.zlY = 30;
    this.zlZ = 40;
    this.HLG = false;
    this.HLH = 0;
    this.HLI = new ArrayList();
    this.HLR = new ValueAnimator.AnimatorUpdateListener()
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
              ac.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", new Object[] { Float.valueOf(f), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this)), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this) * 2) });
              ac.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 1.");
              ChattingAnimFrame.l(ChattingAnimFrame.this);
              ChattingAnimFrame.m(ChattingAnimFrame.this);
            }
            if ((!ChattingAnimFrame.n(ChattingAnimFrame.this)) && (f > ChattingAnimFrame.k(ChattingAnimFrame.this) * 3))
            {
              ac.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", new Object[] { Float.valueOf(f), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this)), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this) * 2) });
              ac.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 2.");
              ChattingAnimFrame.o(ChattingAnimFrame.this);
              ChattingAnimFrame.m(ChattingAnimFrame.this);
            }
          }
        }
        AppMethodBeat.o(34356);
      }
    };
    this.HLT = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(34357);
        ac.d("MicroMsg.ChattingAnimFrame", "luckyBagAnimEnd!!!");
        if (ChattingAnimFrame.f(ChattingAnimFrame.this)) {
          ChattingAnimFrame.p(ChattingAnimFrame.this);
        }
        AppMethodBeat.o(34357);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.HLW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34358);
        ac.d("MicroMsg.ChattingAnimFrame", "lucky bag click!!!");
        paramAnonymousView = com.tencent.mm.plugin.eggspring.a.oVi;
        com.tencent.mm.plugin.eggspring.a.cba().Ba(4);
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
        AppMethodBeat.o(34358);
      }
    };
    this.mScreenHeight = com.tencent.mm.cc.a.ih(getContext());
    this.mScreenWidth = com.tencent.mm.cc.a.ig(getContext());
    this.HLM = (this.mScreenHeight / 5);
    this.HLK = com.tencent.mm.cc.a.fromDPToPix(getContext(), 60);
    this.HLL = com.tencent.mm.cc.a.fromDPToPix(getContext(), 80);
    AppMethodBeat.o(34371);
  }
  
  static float Z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(34377);
    float f = (float)Math.random();
    AppMethodBeat.o(34377);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private void aaD(int paramInt)
  {
    AppMethodBeat.i(34375);
    if (paramInt <= 0)
    {
      ac.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      AppMethodBeat.o(34375);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.HLI != null) {
      this.HLI.clear();
    }
    while (this.HLI.size() < i)
    {
      int j = (int)Z(0.0F, paramInt);
      if (!this.HLI.contains(Integer.valueOf(j)))
      {
        this.HLI.add(Integer.valueOf(j));
        continue;
        this.HLI = new ArrayList();
      }
    }
    AppMethodBeat.o(34375);
  }
  
  private void fkT()
  {
    AppMethodBeat.i(160226);
    if ((this.HLJ != null) && (this.oVy))
    {
      this.HLJ.stop();
      removeView(this.HLJ);
      this.oVy = false;
      this.oVF = null;
      if (this.HLP != null)
      {
        this.HLP.end();
        this.HLP = null;
      }
      if (this.HLQ != null)
      {
        this.HLQ.end();
        this.HLQ = null;
      }
      if (this.HLV != null)
      {
        this.HLV.end();
        this.HLV = null;
      }
      this.HLJ.setRotation(0.0F);
    }
    AppMethodBeat.o(160226);
  }
  
  private static String getDataEmojiPath()
  {
    AppMethodBeat.i(34370);
    if (bs.isNullOrNil(oYY))
    {
      oYY = com.tencent.mm.loader.j.b.apa().replace("/data/user/0", "/data/data");
      oYY += "/emoji";
    }
    String str = oYY;
    AppMethodBeat.o(34370);
    return str;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(34374);
    stop();
    if (paramd == null)
    {
      ac.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
      AppMethodBeat.o(34374);
      return false;
    }
    int i = 0;
    int j = paramd.hPH.size();
    if (j <= 0)
    {
      ac.e("MicroMsg.ChattingAnimFrame", "wtf!!! no anim!!!");
      AppMethodBeat.o(34374);
      return false;
    }
    if (1 != j)
    {
      i = new Random().nextInt(j);
      ac.d("MicroMsg.ChattingAnimFrame", "random egg: %s, from %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
    Object localObject = (m)paramd.hPH.get(i);
    String str = getDataEmojiPath() + "/egg/" + ((m)localObject).fileName;
    if (!i.eA(str))
    {
      ac.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      AppMethodBeat.o(34374);
      return false;
    }
    this.HLU = paramd;
    setVisibility(0);
    if (z.b(paramd)) {
      h.wUl.dB(1263, 3);
    }
    label248:
    int k;
    label265:
    label341:
    boolean bool;
    if (((m)localObject).hQb > 0)
    {
      this.HLF = ((m)localObject).hQb;
      if (this.HLF > 60) {
        this.HLF = 60;
      }
      if (((m)localObject).hQc <= 0) {
        break label607;
      }
      this.zlY = ((m)localObject).hQc;
      if (((m)localObject).maxSize <= 0) {
        break label616;
      }
      this.zlZ = ((m)localObject).maxSize;
      ac.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.HLF), Integer.valueOf(this.zlY), Integer.valueOf(this.zlZ), Integer.valueOf(((m)localObject).hQa), Integer.valueOf(paramd.dtw) });
      l = 0L;
      aaD(this.HLF);
      i = 0;
      if (i >= this.HLF) {
        break label728;
      }
      j = this.zlY;
      k = this.zlZ;
      j = (int)Z(j, k);
      j = com.tencent.mm.cc.a.fromDPToPix(getContext(), j);
      k = ((m)localObject).hQa;
      if ((this.HLI == null) || (!this.HLI.contains(Integer.valueOf(i)))) {
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
      paramd.HMk = localMMAnimateView;
      localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(paramd.mSize, paramd.mSize));
      this.HLE.add(localMMAnimateView);
      this.fqZ += 1;
      ac.i("MicroMsg.ChattingAnimFrame", "addImgAnim counter++: [%s].", new Object[] { Integer.valueOf(this.fqZ) });
      addView(localMMAnimateView);
      j = ((m)localObject).hQa;
      k = this.HLF;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(Z(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label341;
        this.HLF = 30;
        break;
        label607:
        this.zlY = 30;
        break label248;
        label616:
        this.zlZ = 40;
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
    if (this.HLE != null)
    {
      paramd = this.HLE.iterator();
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
  
  public final void fkS()
  {
    float f1 = 0.1F;
    AppMethodBeat.i(34379);
    float f3 = -0.2F * this.mScreenHeight;
    float f4 = this.mScreenHeight;
    float f5 = Z(0.1F, 0.9F);
    float f2 = Z(0.1F, 0.9F);
    if (Math.abs(f5 - f2) < 0.5F) {
      if (f5 > 0.5F) {
        if (f5 - 0.5F > 0.1F) {
          f1 = f5 - 0.5F;
        }
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.ChattingAnimFrame", "luckyBag, s[%s] e[%s].", new Object[] { Float.valueOf(f5), Float.valueOf(f1) });
      f2 = (int)(this.mScreenWidth * f5);
      f1 = (int)(f1 * this.mScreenWidth);
      ac.d("MicroMsg.ChattingAnimFrame", "luckyBag, init: startX[%s] endX[%s] startY[%s] endY[%s].", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f4) });
      if (this.HLJ == null)
      {
        this.HLJ = new MMAnimateView(getContext());
        this.HLJ.setLayoutParams(new FrameLayout.LayoutParams(this.HLK, this.HLL));
        if (!i.eA(PluginEggSpring.oVa)) {
          break label614;
        }
        this.HLJ.setImageFilePath(PluginEggSpring.oVa);
      }
      for (;;)
      {
        this.HLJ.setOnClickListener(this.HLW);
        this.HLJ.setPivotX(this.HLK / 2);
        this.HLJ.setPivotY(this.HLL / 2);
        this.HLJ.setRotation(0.0F);
        this.HLJ.setX(f2);
        this.HLJ.setY(f3);
        int i = (int)Z(7000.0F, 10000.0F);
        this.HLP = ValueAnimator.ofFloat(new float[] { f2, f1 });
        this.HLQ = ValueAnimator.ofFloat(new float[] { f3, f4 });
        this.HLP.setDuration(i);
        this.HLQ.setDuration(i);
        this.HLP.setInterpolator(new LinearInterpolator());
        this.HLQ.setInterpolator(new LinearInterpolator());
        this.HLP.addUpdateListener(this.HLR);
        this.HLQ.addUpdateListener(this.HLR);
        this.HLP.setStartDelay(500L);
        this.HLQ.setStartDelay(500L);
        this.HLQ.addListener(this.HLT);
        this.HLV = ObjectAnimator.ofFloat(this.HLJ, View.ROTATION, new float[] { 0.0F, 15.0F, -15.0F, 15.0F, -15.0F, 0.0F });
        this.HLV.setInterpolator(new AccelerateDecelerateInterpolator());
        this.HLV.setDuration(500L);
        this.HLV.setRepeatCount(1);
        this.HLN = false;
        this.HLO = false;
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
        this.HLJ.setImageResource(2131232929);
      }
      f1 = f2;
    }
  }
  
  public final boolean fkU()
  {
    AppMethodBeat.i(160227);
    if ((this.HLU != null) && (1 == this.HLU.type))
    {
      if ((this.fqZ <= 0) && (!this.oVy))
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
    this.aOz = getMeasuredHeight();
    this.aOy = getMeasuredWidth();
    ac.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.aOy), Integer.valueOf(this.aOz) });
    AppMethodBeat.o(34372);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34373);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.aOz = (paramInt4 - paramInt2);
    this.aOy = (paramInt3 - paramInt1);
    if (this.aOz < this.mScreenHeight) {
      this.HLG = true;
    }
    for (this.HLH = (this.mScreenHeight - this.aOz);; this.HLH = 0)
    {
      ac.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.aOy), Integer.valueOf(this.aOz), Boolean.valueOf(this.HLG), Integer.valueOf(this.HLH) });
      AppMethodBeat.o(34373);
      return;
      this.HLG = false;
    }
  }
  
  public void setOnLuckyBagClick(d paramd)
  {
    this.HLX = paramd;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(34376);
    Iterator localIterator = this.HLE.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
    }
    fkT();
    removeAllViews();
    this.HLE.clear();
    this.fqZ = 0;
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
    private float HMa;
    private float HMb;
    private float HMc;
    private float HMd;
    private float HMe;
    private float HMf;
    private int HMg;
    private boolean HMh;
    private View.OnLayoutChangeListener Hkq;
    private float mFromX;
    private float mFromY;
    private int mSize;
    private float mToX;
    private float mToY;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(34360);
      this.HMg = 0;
      this.mSize = 0;
      this.HMh = false;
      this.Hkq = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.HMg = paramInt1;
      this.mSize = paramInt2;
      this.HMh = false;
      AppMethodBeat.o(34360);
    }
    
    public b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(34361);
      this.HMg = 0;
      this.mSize = 0;
      this.HMh = false;
      this.Hkq = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.HMg = paramInt1;
      this.mSize = paramInt2;
      this.HMh = paramBoolean;
      AppMethodBeat.o(34361);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(34363);
      float f2 = this.HMa;
      float f1 = this.HMc;
      if (this.HMa != this.HMb) {
        f2 = this.HMa + (this.HMb - this.HMa) * paramFloat;
      }
      if (this.HMc != this.HMd)
      {
        float f3 = this.HMc + (this.HMd - this.HMc) * paramFloat;
        f1 = f3;
        if (this.HMg == 2) {
          f1 = f3 - this.mSize;
        }
      }
      paramTransformation.getMatrix().setTranslate(f2, f1);
      if ((this.HMe != this.HMf) && (3 == this.HMg))
      {
        paramFloat = this.HMe + (this.HMf - this.HMe) * paramFloat;
        paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
      }
      AppMethodBeat.o(34363);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(34364);
      super.finalize();
      ac.i("MicroMsg.ChattingAnimFrame", "finalize!");
      ChattingAnimFrame.this.removeOnLayoutChangeListener(this.Hkq);
      AppMethodBeat.o(34364);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(34362);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      switch (this.HMg)
      {
      default: 
        this.mFromX = ChattingAnimFrame.Z(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.Z(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = -0.2F;
        this.mToY = 1.2F;
        setInterpolator(new LinearInterpolator());
      }
      for (;;)
      {
        if ((this.HMg != 0) && (this.HMg != 1)) {
          ChattingAnimFrame.this.addOnLayoutChangeListener(this.Hkq);
        }
        resolve();
        AppMethodBeat.o(34362);
        return;
        this.mFromX = ChattingAnimFrame.Z(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.Z(this.mFromX - 0.25F, this.mFromX + 0.25F);
        this.mFromY = 1.5F;
        this.mToY = -0.2F;
        setInterpolator(new LinearInterpolator());
        continue;
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 1.5F;
        if (this.HMh) {}
        for (this.mToY = ChattingAnimFrame.Z(0.4F, 0.55F);; this.mToY = ChattingAnimFrame.Z(0.55F, 0.85F))
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
        this.mFromX = ChattingAnimFrame.Z(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.Z(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = 0.0F;
        this.mToY = 0.0F;
        this.HMe = 0.8F;
        this.HMf = 1.1F;
        setInterpolator(new LinearInterpolator());
        continue;
        float f = ChattingAnimFrame.Z(0.0F, 1.0F - this.mSize * 1.0F / ChattingAnimFrame.a(ChattingAnimFrame.this));
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
      this.HMa = (this.mFromX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      this.HMb = (this.mToX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      if (this.HMg == 2)
      {
        this.HMc = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.HMd = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        AppMethodBeat.o(34365);
        return;
      }
      if (this.HMg == 3)
      {
        this.HMc = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.HMd = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        if (ChattingAnimFrame.d(ChattingAnimFrame.this))
        {
          this.HMc = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
          this.HMd = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
        }
        if (this.HMd < 0.0F)
        {
          this.HMd = 0.0F;
          AppMethodBeat.o(34365);
        }
      }
      else
      {
        if (this.HMg == 4)
        {
          this.HMc = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.HMd = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          AppMethodBeat.o(34365);
          return;
        }
        this.HMc = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.HMd = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
      }
      AppMethodBeat.o(34365);
    }
  }
  
  final class c
    extends AnimationSet
  {
    private long HMj;
    MMAnimateView HMk;
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
            if (paramAnonymousAnimation.HMk != null)
            {
              paramAnonymousAnimation.HMk.post(new ChattingAnimFrame.c.2(paramAnonymousAnimation));
              AppMethodBeat.o(34366);
              return;
            }
            ac.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
            AppMethodBeat.o(34366);
          }
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(196421);
            if (ChattingAnimFrame.c.this.HMk != null) {
              ChattingAnimFrame.c.this.HMk.setVisibility(0);
            }
            AppMethodBeat.o(196421);
          }
        });
        this.HMj = (500L + paramLong);
        reset();
        setDuration(ChattingAnimFrame.aaE(paramInt1));
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