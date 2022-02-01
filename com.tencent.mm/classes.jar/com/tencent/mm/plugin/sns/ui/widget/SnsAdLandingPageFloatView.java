package com.tencent.mm.plugin.sns.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnsAdLandingPageFloatView
  extends FrameLayout
{
  boolean AIs;
  public w ATF;
  public g ATG;
  private m ATH;
  private View ATI;
  private AnimatorSet ATJ;
  public boolean ATK;
  private List<m> App;
  public String dDp;
  private boolean isResume;
  ValueAnimator scY;
  public String zMl;
  private Map<String, String> zRS;
  
  public SnsAdLandingPageFloatView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(100462);
    this.zRS = new HashMap();
    this.ATJ = new AnimatorSet();
    this.scY = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.ATK = true;
    AppMethodBeat.o(100462);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(100463);
    this.zRS = new HashMap();
    this.ATJ = new AnimatorSet();
    this.scY = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.ATK = true;
    AppMethodBeat.o(100463);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, -1);
    AppMethodBeat.i(100464);
    this.zRS = new HashMap();
    this.ATJ = new AnimatorSet();
    this.scY = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.ATK = true;
    AppMethodBeat.o(100464);
  }
  
  private void eiC()
  {
    AppMethodBeat.i(100467);
    Map localMap;
    int i;
    if ((this.ATG != null) && (!bu.isNullOrNil(this.zMl)))
    {
      localMap = bx.M(this.zMl, "adCardItemList");
      i = 0;
      if (i <= 0) {
        break label196;
      }
    }
    label196:
    for (String str1 = ".adCardItemList.cardItem" + i;; str1 = ".adCardItemList.cardItem")
    {
      if (localMap.containsKey(str1 + ".cardTpId"))
      {
        String str2 = bu.bI((String)localMap.get(str1 + ".cardTpId"), "");
        str1 = bu.bI((String)localMap.get(str1 + ".cardExt"), "");
        if ((!bu.isNullOrNil(str2)) && (!bu.isNullOrNil(str1))) {
          this.zRS.put(str2, str1);
        }
        i += 1;
        break;
      }
      AppMethodBeat.o(100467);
      return;
    }
  }
  
  private void initPage()
  {
    AppMethodBeat.i(220142);
    int i;
    if (this.ATF != null)
    {
      if (this.ATF.zRe > 0) {
        setBackground(null);
      }
      i = 0;
    }
    try
    {
      int j = Color.parseColor(this.ATG.jZm);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SnsAdLandingPageFloatView", "parseColor exp=" + localException.toString() + ", colorStr=" + this.ATG.jZm);
      }
    }
    this.ATH = av.a(getContext(), this.ATF, this, i);
    this.ATH.setBackgroundColor(i);
    this.ATI = this.ATH.getView();
    addView(this.ATI);
    this.ATH.eaA();
    if (this.ATF.zRd <= 0) {
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(100460);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          paramAnonymousView = new Rect(SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getLeft(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getTop(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getRight(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getBottom());
          ae.i("MicroMsg.SnsAdLandingPageFloatView", "view area %s, (%f,%f)", new Object[] { paramAnonymousView, Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (!paramAnonymousView.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY()))
          {
            if (paramAnonymousMotionEvent.getActionMasked() == 1)
            {
              paramAnonymousView = SnsAdLandingPageFloatView.this;
              if (!paramAnonymousView.AIs)
              {
                paramAnonymousView.scY.start();
                paramAnonymousView.AIs = true;
              }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(100460);
            return true;
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(100460);
          return false;
        }
      });
    }
    AppMethodBeat.o(220142);
  }
  
  public final void eiB()
  {
    AppMethodBeat.i(220143);
    if (!this.AIs)
    {
      this.ATJ.start();
      this.AIs = true;
    }
    AppMethodBeat.o(220143);
  }
  
  public List<m> getAllComp()
  {
    AppMethodBeat.i(100468);
    if (this.App != null)
    {
      localList = this.App;
      AppMethodBeat.o(100468);
      return localList;
    }
    this.App = new ArrayList();
    this.App.add(this.ATH);
    i.fX(this.App);
    List localList = this.App;
    AppMethodBeat.o(100468);
    return localList;
  }
  
  long getAnimationTimeFactor()
  {
    if (this.ATK) {
      return 1L;
    }
    return 0L;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(220141);
    if (this.ATG != null)
    {
      initPage();
      eiC();
      ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.4F, 0.96F }).setDuration(200L * getAnimationTimeFactor());
      localValueAnimator1.setInterpolator(new OvershootInterpolator());
      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.96F, 1.0F }).setDuration(100L * getAnimationTimeFactor());
      localValueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(100453);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setScaleX(f);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setScaleY(f);
          AppMethodBeat.o(100453);
        }
      });
      localValueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(100454);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setScaleX(f);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setScaleY(f);
          AppMethodBeat.o(100454);
        }
      });
      this.ATJ.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
      this.ATJ.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100456);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          SnsAdLandingPageFloatView.this.onResume();
          paramAnonymousAnimator = new ub();
          paramAnonymousAnimator.dJD.dJE = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.dJD.state = 121;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousAnimator);
          AppMethodBeat.o(100456);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100455);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          paramAnonymousAnimator = new ub();
          paramAnonymousAnimator.dJD.dJE = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.dJD.state = 120;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousAnimator);
          AppMethodBeat.o(100455);
        }
      });
      this.scY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(100457);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setScaleX(f);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setScaleY(f);
          AppMethodBeat.o(100457);
        }
      });
      this.scY.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100459);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setVisibility(8);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          paramAnonymousAnimator = new ub();
          paramAnonymousAnimator.dJD.dJE = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.dJD.state = 123;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousAnimator);
          AppMethodBeat.o(100459);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100458);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          SnsAdLandingPageFloatView.c(SnsAdLandingPageFloatView.this);
          SnsAdLandingPageFloatView.this.onPause();
          paramAnonymousAnimator = new ub();
          paramAnonymousAnimator.dJD.dJE = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.dJD.state = 122;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousAnimator);
          AppMethodBeat.o(100458);
        }
      });
    }
    AppMethodBeat.o(220141);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(100466);
    this.isResume = false;
    if (this.ATG != null) {
      this.ATH.dUL();
    }
    AppMethodBeat.o(100466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100465);
    this.isResume = true;
    if (this.ATG != null)
    {
      this.ATH.dUK();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100461);
          SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).dZO();
          AppMethodBeat.o(100461);
        }
      });
    }
    AppMethodBeat.o(100465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView
 * JD-Core Version:    0.7.0.1
 */