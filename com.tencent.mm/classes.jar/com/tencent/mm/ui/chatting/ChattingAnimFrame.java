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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ChattingAnimFrame
  extends FrameLayout
{
  private static String pJm = "";
  d JUA;
  private ObjectAnimator JUB;
  private View.OnClickListener JUC;
  private ChattingAnimFrame.d JUD;
  List<MMAnimateView> JUl;
  private int JUm;
  private boolean JUn;
  private int JUo;
  private ArrayList<Integer> JUp;
  MMAnimateView JUq;
  private int JUr;
  private int JUs;
  private int JUt;
  private boolean JUu;
  private boolean JUv;
  ValueAnimator JUw;
  ValueAnimator JUx;
  private ValueAnimator.AnimatorUpdateListener JUy;
  private Animator.AnimatorListener JUz;
  private int aYS;
  private int aYT;
  int cpF;
  private int mScreenHeight;
  private int mScreenWidth;
  boolean pFM;
  c pFT;
  private int zsg;
  private int zsh;
  
  public ChattingAnimFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34371);
    this.JUl = new ArrayList();
    this.cpF = 0;
    this.JUm = 30;
    this.zsg = 30;
    this.zsh = 40;
    this.JUn = false;
    this.JUo = 0;
    this.JUp = new ArrayList();
    this.JUy = new ValueAnimator.AnimatorUpdateListener()
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
              ae.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", new Object[] { Float.valueOf(f), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this)), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this) * 2) });
              ae.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 1.");
              ChattingAnimFrame.l(ChattingAnimFrame.this);
              ChattingAnimFrame.m(ChattingAnimFrame.this);
            }
            if ((!ChattingAnimFrame.n(ChattingAnimFrame.this)) && (f > ChattingAnimFrame.k(ChattingAnimFrame.this) * 3))
            {
              ae.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", new Object[] { Float.valueOf(f), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this)), Integer.valueOf(ChattingAnimFrame.k(ChattingAnimFrame.this) * 2) });
              ae.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 2.");
              ChattingAnimFrame.o(ChattingAnimFrame.this);
              ChattingAnimFrame.m(ChattingAnimFrame.this);
            }
          }
        }
        AppMethodBeat.o(34356);
      }
    };
    this.JUz = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(34357);
        ae.d("MicroMsg.ChattingAnimFrame", "luckyBagAnimEnd!!!");
        if (ChattingAnimFrame.f(ChattingAnimFrame.this)) {
          ChattingAnimFrame.p(ChattingAnimFrame.this);
        }
        AppMethodBeat.o(34357);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    this.JUC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34358);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.ChattingAnimFrame", "lucky bag click!!!");
        paramAnonymousView = com.tencent.mm.plugin.eggspring.a.pFw;
        com.tencent.mm.plugin.eggspring.a.cgU().BU(4);
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
    this.mScreenHeight = com.tencent.mm.cb.a.iv(getContext());
    this.mScreenWidth = com.tencent.mm.cb.a.iu(getContext());
    this.JUt = (this.mScreenHeight / 5);
    this.JUr = com.tencent.mm.cb.a.fromDPToPix(getContext(), 60);
    this.JUs = com.tencent.mm.cb.a.fromDPToPix(getContext(), 80);
    AppMethodBeat.o(34371);
  }
  
  static float ad(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(34377);
    float f = (float)Math.random();
    AppMethodBeat.o(34377);
    return f * (paramFloat2 - paramFloat1) + paramFloat1;
  }
  
  private void adv(int paramInt)
  {
    AppMethodBeat.i(34375);
    if (paramInt <= 0)
    {
      ae.w("MicroMsg.ChattingAnimFrame", "count is zero.");
      AppMethodBeat.o(34375);
      return;
    }
    int i = (int)(paramInt * 0.1D);
    if (this.JUp != null) {
      this.JUp.clear();
    }
    while (this.JUp.size() < i)
    {
      int j = (int)ad(0.0F, paramInt);
      if (!this.JUp.contains(Integer.valueOf(j)))
      {
        this.JUp.add(Integer.valueOf(j));
        continue;
        this.JUp = new ArrayList();
      }
    }
    AppMethodBeat.o(34375);
  }
  
  private void fFk()
  {
    AppMethodBeat.i(160226);
    if ((this.JUq != null) && (this.pFM))
    {
      this.JUq.stop();
      removeView(this.JUq);
      this.pFM = false;
      this.pFT = null;
      if (this.JUw != null)
      {
        this.JUw.end();
        this.JUw = null;
      }
      if (this.JUx != null)
      {
        this.JUx.end();
        this.JUx = null;
      }
      if (this.JUB != null)
      {
        this.JUB.end();
        this.JUB = null;
      }
      this.JUq.setRotation(0.0F);
    }
    AppMethodBeat.o(160226);
  }
  
  private static String getDataEmojiPath()
  {
    AppMethodBeat.i(34370);
    if (bu.isNullOrNil(pJm))
    {
      pJm = com.tencent.mm.loader.j.b.asc().replace("/data/user/0", "/data/data");
      pJm += "/emoji";
    }
    String str = pJm;
    AppMethodBeat.o(34370);
    return str;
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(34374);
    stop();
    if (paramd == null)
    {
      ae.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
      AppMethodBeat.o(34374);
      return false;
    }
    int i = 0;
    int j = paramd.ilO.size();
    if (j <= 0)
    {
      ae.e("MicroMsg.ChattingAnimFrame", "wtf!!! no anim!!!");
      AppMethodBeat.o(34374);
      return false;
    }
    if (1 != j)
    {
      i = new Random().nextInt(j);
      ae.d("MicroMsg.ChattingAnimFrame", "random egg: %s, from %s.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
    Object localObject = (m)paramd.ilO.get(i);
    String str = getDataEmojiPath() + "/egg/" + ((m)localObject).fileName;
    if (!o.fB(str))
    {
      ae.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
      AppMethodBeat.o(34374);
      return false;
    }
    this.JUA = paramd;
    setVisibility(0);
    if (aa.b(paramd)) {
      g.yxI.dD(1263, 3);
    }
    label248:
    int k;
    label265:
    label341:
    boolean bool;
    if (((m)localObject).imi > 0)
    {
      this.JUm = ((m)localObject).imi;
      if (this.JUm > 60) {
        this.JUm = 60;
      }
      if (((m)localObject).imj <= 0) {
        break label607;
      }
      this.zsg = ((m)localObject).imj;
      if (((m)localObject).maxSize <= 0) {
        break label616;
      }
      this.zsh = ((m)localObject).maxSize;
      ae.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[] { Integer.valueOf(this.JUm), Integer.valueOf(this.zsg), Integer.valueOf(this.zsh), Integer.valueOf(((m)localObject).imh), Integer.valueOf(paramd.dGC) });
      l = 0L;
      adv(this.JUm);
      i = 0;
      if (i >= this.JUm) {
        break label728;
      }
      j = this.zsg;
      k = this.zsh;
      j = (int)ad(j, k);
      j = com.tencent.mm.cb.a.fromDPToPix(getContext(), j);
      k = ((m)localObject).imh;
      if ((this.JUp == null) || (!this.JUp.contains(Integer.valueOf(i)))) {
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
      paramd.JUQ = localMMAnimateView;
      localMMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(paramd.mSize, paramd.mSize));
      this.JUl.add(localMMAnimateView);
      this.cpF += 1;
      ae.i("MicroMsg.ChattingAnimFrame", "addImgAnim counter++: [%s].", new Object[] { Integer.valueOf(this.cpF) });
      addView(localMMAnimateView);
      j = ((m)localObject).imh;
      k = this.JUm;
    }
    switch (j)
    {
    default: 
    case 3: 
      for (l = (int)(ad(0.0F, 4.0F) * 1000.0F);; l += ((Math.abs(i - k * 0.5D - 5.0D) / (k * 6) + 0.06D) * 1000.0D))
      {
        i += 1;
        break label341;
        this.JUm = 30;
        break;
        label607:
        this.zsg = 30;
        break label248;
        label616:
        this.zsh = 40;
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
    if (this.JUl != null)
    {
      paramd = this.JUl.iterator();
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
  
  public final void fFj()
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
      ae.d("MicroMsg.ChattingAnimFrame", "luckyBag, s[%s] e[%s].", new Object[] { Float.valueOf(f5), Float.valueOf(f1) });
      f2 = (int)(this.mScreenWidth * f5);
      f1 = (int)(f1 * this.mScreenWidth);
      ae.d("MicroMsg.ChattingAnimFrame", "luckyBag, init: startX[%s] endX[%s] startY[%s] endY[%s].", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(f3), Float.valueOf(f4) });
      if (this.JUq == null)
      {
        this.JUq = new MMAnimateView(getContext());
        this.JUq.setLayoutParams(new FrameLayout.LayoutParams(this.JUr, this.JUs));
        if (!o.fB(PluginEggSpring.pFo)) {
          break label614;
        }
        this.JUq.setImageFilePath(PluginEggSpring.pFo);
      }
      for (;;)
      {
        this.JUq.setOnClickListener(this.JUC);
        this.JUq.setPivotX(this.JUr / 2);
        this.JUq.setPivotY(this.JUs / 2);
        this.JUq.setRotation(0.0F);
        this.JUq.setX(f2);
        this.JUq.setY(f3);
        int i = (int)ad(7000.0F, 10000.0F);
        this.JUw = ValueAnimator.ofFloat(new float[] { f2, f1 });
        this.JUx = ValueAnimator.ofFloat(new float[] { f3, f4 });
        this.JUw.setDuration(i);
        this.JUx.setDuration(i);
        this.JUw.setInterpolator(new LinearInterpolator());
        this.JUx.setInterpolator(new LinearInterpolator());
        this.JUw.addUpdateListener(this.JUy);
        this.JUx.addUpdateListener(this.JUy);
        this.JUw.setStartDelay(500L);
        this.JUx.setStartDelay(500L);
        this.JUx.addListener(this.JUz);
        this.JUB = ObjectAnimator.ofFloat(this.JUq, View.ROTATION, new float[] { 0.0F, 15.0F, -15.0F, 15.0F, -15.0F, 0.0F });
        this.JUB.setInterpolator(new AccelerateDecelerateInterpolator());
        this.JUB.setDuration(500L);
        this.JUB.setRepeatCount(1);
        this.JUu = false;
        this.JUv = false;
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
        this.JUq.setImageResource(2131232929);
      }
      f1 = f2;
    }
  }
  
  public final boolean fFl()
  {
    AppMethodBeat.i(160227);
    if ((this.JUA != null) && (1 == this.JUA.type))
    {
      if ((this.cpF <= 0) && (!this.pFM))
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
    ae.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[] { Integer.valueOf(this.aYS), Integer.valueOf(this.aYT) });
    AppMethodBeat.o(34372);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34373);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.aYT = (paramInt4 - paramInt2);
    this.aYS = (paramInt3 - paramInt1);
    if (this.aYT < this.mScreenHeight) {
      this.JUn = true;
    }
    for (this.JUo = (this.mScreenHeight - this.aYT);; this.JUo = 0)
    {
      ae.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[] { Integer.valueOf(this.aYS), Integer.valueOf(this.aYT), Boolean.valueOf(this.JUn), Integer.valueOf(this.JUo) });
      AppMethodBeat.o(34373);
      return;
      this.JUn = false;
    }
  }
  
  public void setOnLuckyBagClick(ChattingAnimFrame.d paramd)
  {
    this.JUD = paramd;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(34376);
    ae.i("MicroMsg.ChattingAnimFrame", "stop: view: %s, count:%s", new Object[] { Integer.valueOf(this.JUl.size()), Integer.valueOf(this.cpF) });
    Iterator localIterator = this.JUl.iterator();
    while (localIterator.hasNext())
    {
      MMAnimateView localMMAnimateView = (MMAnimateView)localIterator.next();
      localMMAnimateView.clearAnimation();
      localMMAnimateView.recycle();
    }
    fFk();
    removeAllViews();
    this.JUl.clear();
    this.cpF = 0;
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
    private float JUG;
    private float JUH;
    private float JUI;
    private float JUJ;
    private float JUK;
    private float JUL;
    private int JUM;
    private boolean JUN;
    private View.OnLayoutChangeListener JsF;
    private float mFromX;
    private float mFromY;
    private int mSize;
    private float mToX;
    private float mToY;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(34360);
      this.JUM = 0;
      this.mSize = 0;
      this.JUN = false;
      this.JsF = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.JUM = paramInt1;
      this.mSize = paramInt2;
      this.JUN = false;
      AppMethodBeat.o(34360);
    }
    
    public b(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(34361);
      this.JUM = 0;
      this.mSize = 0;
      this.JUN = false;
      this.JsF = new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(34359);
          ChattingAnimFrame.b.this.resolve();
          AppMethodBeat.o(34359);
        }
      };
      this.JUM = paramInt1;
      this.mSize = paramInt2;
      this.JUN = paramBoolean;
      AppMethodBeat.o(34361);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AppMethodBeat.i(34363);
      float f2 = this.JUG;
      float f1 = this.JUI;
      if (this.JUG != this.JUH) {
        f2 = this.JUG + (this.JUH - this.JUG) * paramFloat;
      }
      if (this.JUI != this.JUJ)
      {
        float f3 = this.JUI + (this.JUJ - this.JUI) * paramFloat;
        f1 = f3;
        if (this.JUM == 2) {
          f1 = f3 - this.mSize;
        }
      }
      paramTransformation.getMatrix().setTranslate(f2, f1);
      if ((this.JUK != this.JUL) && (3 == this.JUM))
      {
        paramFloat = this.JUK + (this.JUL - this.JUK) * paramFloat;
        paramTransformation.getMatrix().postScale(paramFloat, paramFloat);
      }
      AppMethodBeat.o(34363);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(34364);
      super.finalize();
      ae.i("MicroMsg.ChattingAnimFrame", "finalize!");
      ChattingAnimFrame.this.removeOnLayoutChangeListener(this.JsF);
      AppMethodBeat.o(34364);
    }
    
    public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(34362);
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      switch (this.JUM)
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
        if ((this.JUM != 0) && (this.JUM != 1)) {
          ChattingAnimFrame.this.addOnLayoutChangeListener(this.JsF);
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
        if (this.JUN) {}
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
        this.JUK = 0.8F;
        this.JUL = 1.1F;
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
      this.JUG = (this.mFromX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      this.JUH = (this.mToX * ChattingAnimFrame.b(ChattingAnimFrame.this));
      if (this.JUM == 2)
      {
        this.JUI = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        this.JUJ = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
        AppMethodBeat.o(34365);
        return;
      }
      if (this.JUM == 3)
      {
        this.JUI = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.JUJ = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        if (ChattingAnimFrame.d(ChattingAnimFrame.this))
        {
          this.JUI = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
          this.JUJ = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this) - ChattingAnimFrame.e(ChattingAnimFrame.this));
        }
        if (this.JUJ < 0.0F)
        {
          this.JUJ = 0.0F;
          AppMethodBeat.o(34365);
        }
      }
      else
      {
        if (this.JUM == 4)
        {
          this.JUI = (this.mFromY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          this.JUJ = (this.mToY * ChattingAnimFrame.a(ChattingAnimFrame.this));
          AppMethodBeat.o(34365);
          return;
        }
        this.JUI = (this.mFromY * ChattingAnimFrame.c(ChattingAnimFrame.this));
        this.JUJ = (this.mToY * ChattingAnimFrame.c(ChattingAnimFrame.this));
      }
      AppMethodBeat.o(34365);
    }
  }
  
  final class c
    extends AnimationSet
  {
    private long JUP;
    MMAnimateView JUQ;
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
            if (paramAnonymousAnimation.JUQ != null)
            {
              paramAnonymousAnimation.JUQ.post(new ChattingAnimFrame.c.2(paramAnonymousAnimation));
              AppMethodBeat.o(34366);
              return;
            }
            ae.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
            AppMethodBeat.o(34366);
          }
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(187138);
            ae.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: %s", new Object[] { ChattingAnimFrame.c.this.JUQ });
            if (ChattingAnimFrame.c.this.JUQ != null) {
              ChattingAnimFrame.c.this.JUQ.setVisibility(0);
            }
            AppMethodBeat.o(187138);
          }
        });
        this.JUP = (500L + paramLong);
        reset();
        setDuration(ChattingAnimFrame.adw(paramInt1));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingAnimFrame
 * JD-Core Version:    0.7.0.1
 */