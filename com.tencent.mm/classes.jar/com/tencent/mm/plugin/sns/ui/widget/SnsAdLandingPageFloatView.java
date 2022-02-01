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
import com.tencent.mm.f.a.wd;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnsAdLandingPageFloatView
  extends FrameLayout
{
  private List<m> KLR;
  private Map<String, String> Knw;
  boolean Lgu;
  public y LsQ;
  public g LsR;
  private m LsS;
  private View LsT;
  private AnimatorSet LsU;
  public boolean LsV;
  public String adCanvasExtXml;
  public String fOG;
  private boolean isResume;
  ValueAnimator xwu;
  private boolean zqo;
  
  public SnsAdLandingPageFloatView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(100462);
    this.Knw = new HashMap();
    this.LsU = new AnimatorSet();
    this.xwu = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.LsV = true;
    AppMethodBeat.o(100462);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(100463);
    this.Knw = new HashMap();
    this.LsU = new AnimatorSet();
    this.xwu = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.LsV = true;
    AppMethodBeat.o(100463);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, -1);
    AppMethodBeat.i(100464);
    this.Knw = new HashMap();
    this.LsU = new AnimatorSet();
    this.xwu = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.LsV = true;
    AppMethodBeat.o(100464);
  }
  
  private void fZv()
  {
    AppMethodBeat.i(100467);
    Map localMap;
    int i;
    if ((this.LsR != null) && (!Util.isNullOrNil(this.adCanvasExtXml)))
    {
      localMap = XmlParser.parseXml(this.adCanvasExtXml, "adCardItemList", null);
      i = 0;
      if (i <= 0) {
        break label197;
      }
    }
    label197:
    for (String str1 = ".adCardItemList.cardItem" + i;; str1 = ".adCardItemList.cardItem")
    {
      if (localMap.containsKey(str1 + ".cardTpId"))
      {
        String str2 = Util.nullAs((String)localMap.get(str1 + ".cardTpId"), "");
        str1 = Util.nullAs((String)localMap.get(str1 + ".cardExt"), "");
        if ((!Util.isNullOrNil(str2)) && (!Util.isNullOrNil(str1))) {
          this.Knw.put(str2, str1);
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
    AppMethodBeat.i(263078);
    int i;
    if (this.LsQ != null)
    {
      if (this.LsQ.Kmz > 0) {
        setBackground(null);
      }
      i = 0;
    }
    try
    {
      int j = Color.parseColor(this.LsR.nWx);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsAdLandingPageFloatView", "parseColor exp=" + localException.toString() + ", colorStr=" + this.LsR.nWx);
      }
    }
    this.LsS = ba.a(getContext(), this.LsQ, this, i);
    this.LsS.setBackgroundColor(i);
    this.LsT = this.LsS.getView();
    addView(this.LsT);
    this.LsS.fRm();
    if (this.LsQ.Kmy <= 0) {
      setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(100460);
          paramAnonymousView = new Rect(SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getLeft(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getTop(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getRight(), SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).getView().getBottom());
          Log.i("MicroMsg.SnsAdLandingPageFloatView", "view area %s, (%f,%f)", new Object[] { paramAnonymousView, Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (!paramAnonymousView.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY()))
          {
            if (paramAnonymousMotionEvent.getActionMasked() == 1)
            {
              paramAnonymousView = SnsAdLandingPageFloatView.this;
              if (!paramAnonymousView.Lgu)
              {
                paramAnonymousView.xwu.start();
                paramAnonymousView.Lgu = true;
              }
            }
            AppMethodBeat.o(100460);
            return true;
          }
          AppMethodBeat.o(100460);
          return false;
        }
      });
    }
    AppMethodBeat.o(263078);
  }
  
  public final void fZu()
  {
    AppMethodBeat.i(263085);
    if (!this.Lgu)
    {
      this.LsU.start();
      this.Lgu = true;
    }
    AppMethodBeat.o(263085);
  }
  
  public List<m> getAllComp()
  {
    AppMethodBeat.i(100468);
    if (this.KLR != null)
    {
      localList = this.KLR;
      AppMethodBeat.o(100468);
      return localList;
    }
    this.KLR = new ArrayList();
    this.KLR.add(this.LsS);
    i.hD(this.KLR);
    List localList = this.KLR;
    AppMethodBeat.o(100468);
    return localList;
  }
  
  long getAnimationTimeFactor()
  {
    if (this.LsV) {
      return 1L;
    }
    return 0L;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(263075);
    if (this.LsR != null)
    {
      initPage();
      fZv();
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
      this.LsU.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
      this.LsU.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100456);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          SnsAdLandingPageFloatView.this.onResume();
          paramAnonymousAnimator = new wd();
          paramAnonymousAnimator.fVp.fVq = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.fVp.state = 121;
          EventCenter.instance.publish(paramAnonymousAnimator);
          AppMethodBeat.o(100456);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100455);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          paramAnonymousAnimator = new wd();
          paramAnonymousAnimator.fVp.fVq = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.fVp.state = 120;
          EventCenter.instance.publish(paramAnonymousAnimator);
          AppMethodBeat.o(100455);
        }
      });
      this.xwu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.xwu.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100459);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setVisibility(8);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          paramAnonymousAnimator = new wd();
          paramAnonymousAnimator.fVp.fVq = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.fVp.state = 123;
          EventCenter.instance.publish(paramAnonymousAnimator);
          AppMethodBeat.o(100459);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100458);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          SnsAdLandingPageFloatView.c(SnsAdLandingPageFloatView.this);
          SnsAdLandingPageFloatView.this.onPause();
          SnsAdLandingPageFloatView.this.onDestroy();
          paramAnonymousAnimator = new wd();
          paramAnonymousAnimator.fVp.fVq = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.fVp.state = 122;
          EventCenter.instance.publish(paramAnonymousAnimator);
          AppMethodBeat.o(100458);
        }
      });
    }
    AppMethodBeat.o(263075);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(263082);
    this.isResume = false;
    if ((this.LsQ != null) && (!this.zqo))
    {
      this.zqo = true;
      this.LsS.fKo();
    }
    AppMethodBeat.o(263082);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(100466);
    this.isResume = false;
    if (this.LsR != null) {
      this.LsS.fKl();
    }
    AppMethodBeat.o(100466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100465);
    this.isResume = true;
    if (this.LsR != null)
    {
      this.LsS.fKk();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100461);
          SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).fKm();
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