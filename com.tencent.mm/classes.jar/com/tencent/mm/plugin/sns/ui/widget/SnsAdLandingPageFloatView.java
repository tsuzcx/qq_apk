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
import com.tencent.mm.g.a.tz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnsAdLandingPageFloatView
  extends FrameLayout
{
  public v ACe;
  public g ACf;
  private l ACg;
  private View ACh;
  private AnimatorSet ACi;
  public boolean ACj;
  boolean Are;
  public String dCk;
  private boolean isResume;
  ValueAnimator rUu;
  private Map<String, String> zAS;
  private List<l> zYe;
  public String zuQ;
  
  public SnsAdLandingPageFloatView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(100462);
    this.zAS = new HashMap();
    this.ACi = new AnimatorSet();
    this.rUu = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.ACj = true;
    AppMethodBeat.o(100462);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(100463);
    this.zAS = new HashMap();
    this.ACi = new AnimatorSet();
    this.rUu = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.ACj = true;
    AppMethodBeat.o(100463);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, -1);
    AppMethodBeat.i(100464);
    this.zAS = new HashMap();
    this.ACi = new AnimatorSet();
    this.rUu = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.ACj = true;
    AppMethodBeat.o(100464);
  }
  
  private void eeV()
  {
    AppMethodBeat.i(100467);
    Map localMap;
    int i;
    if ((this.ACf != null) && (!bt.isNullOrNil(this.zuQ)))
    {
      localMap = bw.M(this.zuQ, "adCardItemList");
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
        String str2 = bt.bI((String)localMap.get(str1 + ".cardTpId"), "");
        str1 = bt.bI((String)localMap.get(str1 + ".cardExt"), "");
        if ((!bt.isNullOrNil(str2)) && (!bt.isNullOrNil(str1))) {
          this.zAS.put(str2, str1);
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
    AppMethodBeat.i(198595);
    int i;
    if (this.ACe != null)
    {
      if (this.ACe.zAf > 0) {
        setBackground(null);
      }
      i = 0;
    }
    try
    {
      int j = Color.parseColor(this.ACf.jVX);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsAdLandingPageFloatView", "parseColor exp=" + localException.toString() + ", colorStr=" + this.ACf.jVX);
      }
    }
    this.ACg = av.a(getContext(), this.ACe, this, i);
    this.ACg.setBackgroundColor(i);
    this.ACh = this.ACg.getView();
    addView(this.ACh);
    this.ACg.dWW();
    if (this.ACe.zAe <= 0) {
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(100460);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/widget/SnsAdLandingPageFloatView$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          paramAnonymousView = new Rect(SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getLeft(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getTop(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getRight(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getBottom());
          ad.i("MicroMsg.SnsAdLandingPageFloatView", "view area %s, (%f,%f)", new Object[] { paramAnonymousView, Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (!paramAnonymousView.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY()))
          {
            if (paramAnonymousMotionEvent.getActionMasked() == 1)
            {
              paramAnonymousView = SnsAdLandingPageFloatView.this;
              if (!paramAnonymousView.Are)
              {
                paramAnonymousView.rUu.start();
                paramAnonymousView.Are = true;
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
    AppMethodBeat.o(198595);
  }
  
  public final void eeU()
  {
    AppMethodBeat.i(198596);
    if (!this.Are)
    {
      this.ACi.start();
      this.Are = true;
    }
    AppMethodBeat.o(198596);
  }
  
  public List<l> getAllComp()
  {
    AppMethodBeat.i(100468);
    if (this.zYe != null)
    {
      localList = this.zYe;
      AppMethodBeat.o(100468);
      return localList;
    }
    this.zYe = new ArrayList();
    this.zYe.add(this.ACg);
    i.fO(this.zYe);
    List localList = this.zYe;
    AppMethodBeat.o(100468);
    return localList;
  }
  
  long getAnimationTimeFactor()
  {
    if (this.ACj) {
      return 1L;
    }
    return 0L;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(198594);
    if (this.ACf != null)
    {
      initPage();
      eeV();
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
      this.ACi.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
      this.ACi.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100456);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          SnsAdLandingPageFloatView.this.onResume();
          paramAnonymousAnimator = new tz();
          paramAnonymousAnimator.dIw.dIx = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.dIw.state = 121;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAnimator);
          AppMethodBeat.o(100456);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100455);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          paramAnonymousAnimator = new tz();
          paramAnonymousAnimator.dIw.dIx = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.dIw.state = 120;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAnimator);
          AppMethodBeat.o(100455);
        }
      });
      this.rUu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.rUu.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100459);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setVisibility(8);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          paramAnonymousAnimator = new tz();
          paramAnonymousAnimator.dIw.dIx = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.dIw.state = 123;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAnimator);
          AppMethodBeat.o(100459);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100458);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          SnsAdLandingPageFloatView.c(SnsAdLandingPageFloatView.this);
          SnsAdLandingPageFloatView.this.onPause();
          paramAnonymousAnimator = new tz();
          paramAnonymousAnimator.dIw.dIx = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.dIw.state = 122;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousAnimator);
          AppMethodBeat.o(100458);
        }
      });
    }
    AppMethodBeat.o(198594);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(100466);
    this.isResume = false;
    if (this.ACf != null) {
      this.ACg.dRn();
    }
    AppMethodBeat.o(100466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100465);
    this.isResume = true;
    if (this.ACf != null)
    {
      this.ACg.dRm();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100461);
          SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).dWm();
          AppMethodBeat.o(100461);
        }
      });
    }
    AppMethodBeat.o(100465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView
 * JD-Core Version:    0.7.0.1
 */