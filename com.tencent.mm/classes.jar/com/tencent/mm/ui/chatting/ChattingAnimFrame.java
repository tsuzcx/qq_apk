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
import com.tencent.mm.plugin.report.service.h;
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
  private static String ovy = "";
  List<MMAnimateView> GlP;
  private int GlQ;
  private boolean GlR;
  private int GlS;
  private ArrayList<Integer> GlT;
  MMAnimateView GlU;
  private int GlV;
  private int GlW;
  private int GlX;
  private boolean GlY;
  private boolean GlZ;
  ValueAnimator Gma;
  ValueAnimator Gmb;
  private ValueAnimator.AnimatorUpdateListener Gmc;
  private Animator.AnimatorListener Gmd;
  d Gme;
  private ObjectAnimator Gmf;
  private View.OnClickListener Gmg;
  private d Gmh;
  private int aNI;
  private int aNJ;
  int fnF;
  private int mScreenHeight;
  private int mScreenWidth;
  boolean orY;
  c osf;
  private int xZa;
  private int xZb;
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34371);
    this.GlP = new ArrayList();
    this.fnF = 0;
    this.GlQ = 30;
    this.xZa = 30;
    this.xZb = 40;
    this.GlR = false;
    this.GlS = 0;
    this.GlT = new ArrayList();
    this.Gmc = new ValueAnimator.AnimatorUpdateListener()
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
    this.Gmd = new Animator.AnimatorListener()
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
    this.Gmg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34358);
        ad.d("MicroMsg.ChattingAnimFrame", "lucky bag click!!!");
        paramAnonymousView = com.tencent.mm.plugin.eggspring.a.orI;
        com.tencent.mm.plugin.eggspring.a.bTM().Ai(4);
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
    this.mScreenHeight = com.tencent.mm.cd.a.hW(getContext());
    this.mScreenWidth = com.tencent.mm.cd.a.hV(getContext());
    this.GlX = (this.mScreenHeight / 5);
    this.GlV = com.tencent.mm.cd.a.fromDPToPix(getContext(), 60);
    this.GlW = com.tencent.mm.cd.a.fromDPToPix(getContext(), 80);
    AppMethodBeat.o(34371);
  }
  
  static float V(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(34377);
    float f = (float)Math.random();
    AppMethodBeat.o(34377);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private void Ys(int paramInt)
  {
    AppMethodBeat.i(34375);
    if (paramInt <= 0)
    {
      ad.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      AppMethodBeat.o(34375);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.GlT != null) {
      this.GlT.clear();
    }
    while (this.GlT.size() < i)
    {
      int j = (int)V(0.0F, paramInt);
      if (!this.GlT.contains(Integer.valueOf(j)))
      {
        this.GlT.add(Integer.valueOf(j));
        continue;
        this.GlT = new ArrayList();
      }
    }
    AppMethodBeat.o(34375);
  }
  
  private void eVh()
  {
    AppMethodBeat.i(160226);
    if ((this.GlU != null) && (this.orY))
    {
      this.GlU.stop();
      removeView(this.GlU);
      this.orY = false;
      this.osf = null;
      if (this.Gma != null)
      {
        this.Gma.end();
        this.Gma = null;
      }
      if (this.Gmb != null)
      {
        this.Gmb.end();
        this.Gmb = null;
      }
      if (this.Gmf != null)
      {
        this.Gmf.end();
        this.Gmf = null;
      }
      this.GlU.setRotation(0.0F);
    }
    AppMethodBeat.o(160226);
  }
  
  private static String getDataEmojiPath()
  {
    AppMethodBeat.i(34370);
    if (bt.isNullOrNil(ovy))
    {
      ovy = com.tencent.mm.loader.j.b.aia().replace("/data/user/0", "/data/data");
      ovy += "/emoji";
    }
    String str = ovy;
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
    int j = paramd.hpf.size();
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
    Object localObject = (m)paramd.hpf.get(i);
    String str = getDataEmojiPath() + "/egg/" + ((m)localObject).fileName;
    if (!i.eK(str))
    {
      ad.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      AppMethodBeat.o(34374);
      return false;
    }
    this.Gme = paramd;
    setVisibility(0);
    if (z.b(paramd)) {
      h.vKh.dB(1263, 3);
    }
    label248:
    int k;
    label265:
    label341:
    boolean bool;
    if (((m)localObject).hpz > 0)
    {
      this.GlQ = ((m)localObject).hpz;
      if (this.GlQ > 60) {
        this.GlQ = 60;
      }
      if (((m)localObject).hpA <= 0) {
        break label607;
      }
      this.xZa = ((m)localObject).hpA;
      if (((m)localObject).maxSize <= 0) {
        break label616;
      }
      this.xZb = ((m)localObject).maxSize;
      ad.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.GlQ), Integer.valueOf(this.xZa), Integer.valueOf(this.xZb), Integer.valueOf(((m)localObject).hpy), Integer.valueOf(paramd.dvJ) });
      l = 0L;
      Ys(this.GlQ);
      i = 0;
      if (i >= this.GlQ) {
        break label728;
      }
      j = this.xZa;
      k = this.xZb;
      j = (int)V(j, k);
      j = com.tencent.mm.cd.a.fromDPToPix(getContext(), j);
      k = ((m)localObject).hpy;
      if ((this.GlT == null) || (!this.GlT.contains(Integer.valueOf(i)))) {
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
      paramd.Gmu = localMMAnimateView;
      localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(paramd.mSize, paramd.mSize));
      this.GlP.add(localMMAnimateView);
      this.fnF += 1;
      ad.i("MicroMsg.ChattingAnimFrame", "addImgAnim counter++: [%s].", new Object[] { Integer.valueOf(this.fnF) });
      addView(localMMAnimateView);
      j = ((m)localObject).hpy;
      k = this.GlQ;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(V(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label341;
        this.GlQ = 30;
        break;
        label607:
        this.xZa = 30;
        break label248;
        label616:
        this.xZb = 40;
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
    if (this.GlP != null)
    {
      paramd = this.GlP.iterator();
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
  
  public final void eVg()
  {
    float f1 = 0.1F;
    AppMethodBeat.i(34379);
    float f3 = -0.2F * this.mScreenHeight;
    float f4 = this.mScreenHeight;
    float f5 = V(0.1F, 0.9F);
    float f2 = V(0.1F, 0.9F);
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
      if (this.GlU == null)
      {
        this.GlU = new MMAnimateView(getContext());
        this.GlU.setLayoutParams(new FrameLayout.LayoutParams(this.GlV, this.GlW));
        if (!i.eK(PluginEggSpring.orA)) {
          break label614;
        }
        this.GlU.setImageFilePath(PluginEggSpring.orA);
      }
      for (;;)
      {
        this.GlU.setOnClickListener(this.Gmg);
        this.GlU.setPivotX(this.GlV / 2);
        this.GlU.setPivotY(this.GlW / 2);
        this.GlU.setRotation(0.0F);
        this.GlU.setX(f2);
        this.GlU.setY(f3);
        int i = (int)V(7000.0F, 10000.0F);
        this.Gma = ValueAnimator.ofFloat(new float[] { f2, f1 });
        this.Gmb = ValueAnimator.ofFloat(new float[] { f3, f4 });
        this.Gma.setDuration(i);
        this.Gmb.setDuration(i);
        this.Gma.setInterpolator(new LinearInterpolator());
        this.Gmb.setInterpolator(new LinearInterpolator());
        this.Gma.addUpdateListener(this.Gmc);
        this.Gmb.addUpdateListener(this.Gmc);
        this.Gma.setStartDelay(500L);
        this.Gmb.setStartDelay(500L);
        this.Gmb.addListener(this.Gmd);
        this.Gmf = ObjectAnimator.ofFloat(this.GlU, View.ROTATION, new float[] { 0.0F, 15.0F, -15.0F, 15.0F, -15.0F, 0.0F });
        this.Gmf.setInterpolator(new AccelerateDecelerateInterpolator());
        this.Gmf.setDuration(500L);
        this.Gmf.setRepeatCount(1);
        this.GlY = false;
        this.GlZ = false;
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
        this.GlU.setImageResource(2131232929);
      }
      f1 = f2;
    }
  }
  
  public final boolean eVi()
  {
    AppMethodBeat.i(160227);
    if ((this.Gme != null) && (1 == this.Gme.type))
    {
      if ((this.fnF <= 0) && (!this.orY))
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
    this.aNJ = getMeasuredHeight();
    this.aNI = getMeasuredWidth();
    ad.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.aNI), Integer.valueOf(this.aNJ) });
    AppMethodBeat.o(34372);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34373);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.aNJ = (paramInt4 - paramInt2);
    this.aNI = (paramInt3 - paramInt1);
    if (this.aNJ < this.mScreenHeight) {
      this.GlR = true;
    }
    for (this.GlS = (this.mScreenHeight - this.aNJ);; this.GlS = 0)
    {
      ad.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.aNI), Integer.valueOf(this.aNJ), Boolean.valueOf(this.GlR), Integer.valueOf(this.GlS) });
      AppMethodBeat.o(34373);
      return;
      this.GlR = false;
    }
  }
  
  public void setOnLuckyBagClick(d paramd)
  {
    this.Gmh = paramd;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(34376);
    Iterator localIterator = this.GlP.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
    }
    eVh();
    removeAllViews();
    this.GlP.clear();
    this.fnF = 0;
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
    private View.OnLayoutChangeListener FLi;
    private float Gmk;
    private float Gml;
    private float Gmm;
    private float Gmn;
    private float Gmo;
    private float Gmp;
    private int Gmq;
    private boolean Gmr;
    private float mFromX;
    private float mFromY;
    private int mSize;
    private float mToX;
    private float mToY;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(34360);
      this.Gmq = 0;
      this.mSize = 0;
      this.Gmr = false;
      this.FLi = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.Gmq = paramInt1;
      this.mSize = paramInt2;
      this.Gmr = false;
      AppMethodBeat.o(34360);
    }
    
    public b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(34361);
      this.Gmq = 0;
      this.mSize = 0;
      this.Gmr = false;
      this.FLi = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.Gmq = paramInt1;
      this.mSize = paramInt2;
      this.Gmr = paramBoolean;
      AppMethodBeat.o(34361);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(34363);
      float f2 = this.Gmk;
      float f1 = this.Gmm;
      if (this.Gmk != this.Gml) {
        f2 = this.Gmk + (this.Gml - this.Gmk) * paramFloat;
      }
      if (this.Gmm != this.Gmn)
      {
        float f3 = this.Gmm + (this.Gmn - this.Gmm) * paramFloat;
        f1 = f3;
        if (this.Gmq == 2) {
          f1 = f3 - this.mSize;
        }
      }
      paramTransformation.getMatrix().setTranslate(f2, f1);
      if ((this.Gmo != this.Gmp) && (3 == this.Gmq))
      {
        paramFloat = this.Gmo + (this.Gmp - this.Gmo) * paramFloat;
        paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
      }
      AppMethodBeat.o(34363);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(34364);
      super.finalize();
      ad.i("MicroMsg.ChattingAnimFrame", "finalize!");
      ChattingAnimFrame.this.removeOnLayoutChangeListener(this.FLi);
      AppMethodBeat.o(34364);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(34362);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      switch (this.Gmq)
      {
      default: 
        this.mFromX = ChattingAnimFrame.V(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.V(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = -0.2F;
        this.mToY = 1.2F;
        setInterpolator(new LinearInterpolator());
      }
      for (;;)
      {
        if ((this.Gmq != 0) && (this.Gmq != 1)) {
          ChattingAnimFrame.this.addOnLayoutChangeListener(this.FLi);
        }
        resolve();
        AppMethodBeat.o(34362);
        return;
        this.mFromX = ChattingAnimFrame.V(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.V(this.mFromX - 0.25F, this.mFromX + 0.25F);
        this.mFromY = 1.5F;
        this.mToY = -0.2F;
        setInterpolator(new LinearInterpolator());
        continue;
        this.mFromX = 0.0F;
        this.mToX = 0.0F;
        this.mFromY = 1.5F;
        if (this.Gmr) {}
        for (this.mToY = ChattingAnimFrame.V(0.4F, 0.55F);; this.mToY = ChattingAnimFrame.V(0.55F, 0.85F))
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
        this.mFromX = ChattingAnimFrame.V(0.1F, 0.9F);
        this.mToX = ChattingAnimFrame.V(this.mFromX - 0.5F, this.mFromX + 0.5F);
        this.mFromY = 0.0F;
        this.mToY = 0.0F;
        this.Gmo = 0.8F;
        this.Gmp = 1.1F;
        setInterpolator(new LinearInterpolator());
        continue;
        float f = ChattingAnimFrame.V(0.0F, 1.0F - this.mSize * 1.0F / ChattingAnimFrame.a(ChattingAnimFrame.this));
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
      this.Gmk = (this.mFromX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      this.Gml = (this.mToX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      if (this.Gmq == 2)
      {
        this.Gmm = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.Gmn = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        AppMethodBeat.o(34365);
        return;
      }
      if (this.Gmq == 3)
      {
        this.Gmm = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.Gmn = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        if (ChattingAnimFrame.d(ChattingAnimFrame.this))
        {
          this.Gmm = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
          this.Gmn = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
        }
        if (this.Gmn < 0.0F)
        {
          this.Gmn = 0.0F;
          AppMethodBeat.o(34365);
        }
      }
      else
      {
        if (this.Gmq == 4)
        {
          this.Gmm = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.Gmn = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          AppMethodBeat.o(34365);
          return;
        }
        this.Gmm = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.Gmn = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
      }
      AppMethodBeat.o(34365);
    }
  }
  
  final class c
    extends AnimationSet
  {
    private long Gmt;
    MMAnimateView Gmu;
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
            if (paramAnonymousAnimation.Gmu != null)
            {
              paramAnonymousAnimation.Gmu.post(new ChattingAnimFrame.c.2(paramAnonymousAnimation));
              AppMethodBeat.o(34366);
              return;
            }
            ad.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
            AppMethodBeat.o(34366);
          }
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(191479);
            if (ChattingAnimFrame.c.this.Gmu != null) {
              ChattingAnimFrame.c.this.Gmu.setVisibility(0);
            }
            AppMethodBeat.o(191479);
          }
        });
        this.Gmt = (500L + paramLong);
        reset();
        setDuration(ChattingAnimFrame.Yt(paramInt1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame
 * JD-Core Version:    0.7.0.1
 */