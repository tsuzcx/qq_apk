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
import com.tencent.mm.autogen.a.xv;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.ui.bb;
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
  ValueAnimator ATZ;
  private boolean EsR;
  private Map<String, String> QLC;
  boolean RGE;
  public y RWg;
  public h RWh;
  private n RWi;
  private View RWj;
  private AnimatorSet RWk;
  public boolean RWl;
  private List<n> RlD;
  public String adCanvasExtXml;
  public String hUz;
  private boolean isResume;
  
  public SnsAdLandingPageFloatView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(100462);
    this.QLC = new HashMap();
    this.RWk = new AnimatorSet();
    this.ATZ = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.RWl = true;
    AppMethodBeat.o(100462);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(100463);
    this.QLC = new HashMap();
    this.RWk = new AnimatorSet();
    this.ATZ = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.RWl = true;
    AppMethodBeat.o(100463);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, -1);
    AppMethodBeat.i(100464);
    this.QLC = new HashMap();
    this.RWk = new AnimatorSet();
    this.ATZ = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.RWl = true;
    AppMethodBeat.o(100464);
  }
  
  private void hsK()
  {
    AppMethodBeat.i(100467);
    Map localMap;
    int i;
    if ((this.RWh != null) && (!Util.isNullOrNil(this.adCanvasExtXml)))
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
          this.QLC.put(str2, str1);
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
    AppMethodBeat.i(309325);
    int i;
    if (this.RWg != null)
    {
      if (this.RWg.QKE > 0) {
        setBackground(null);
      }
      i = 0;
    }
    try
    {
      int j = Color.parseColor(this.RWh.qWk);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsAdLandingPageFloatView", "parseColor exp=" + localException.toString() + ", colorStr=" + this.RWh.qWk);
      }
    }
    this.RWi = bb.a(getContext(), this.RWg, this, i);
    this.RWi.setBackgroundColor(i);
    this.RWj = this.RWi.getView();
    addView(this.RWj);
    this.RWi.haC();
    if (this.RWg.QKD <= 0) {
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
              if (!paramAnonymousView.RGE)
              {
                paramAnonymousView.ATZ.start();
                paramAnonymousView.RGE = true;
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
    AppMethodBeat.o(309325);
  }
  
  public List<n> getAllComp()
  {
    AppMethodBeat.i(100468);
    if (this.RlD != null)
    {
      localList = this.RlD;
      AppMethodBeat.o(100468);
      return localList;
    }
    this.RlD = new ArrayList();
    this.RlD.add(this.RWi);
    l.kE(this.RlD);
    List localList = this.RlD;
    AppMethodBeat.o(100468);
    return localList;
  }
  
  long getAnimationTimeFactor()
  {
    if (this.RWl) {
      return 1L;
    }
    return 0L;
  }
  
  public final void hsJ()
  {
    AppMethodBeat.i(309366);
    if (!this.RGE)
    {
      this.RWk.start();
      this.RGE = true;
    }
    AppMethodBeat.o(309366);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(309353);
    if (this.RWh != null)
    {
      initPage();
      hsK();
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
      this.RWk.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
      this.RWk.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100456);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          SnsAdLandingPageFloatView.this.onResume();
          paramAnonymousAnimator = new xv();
          paramAnonymousAnimator.ibn.ibo = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.ibn.state = 121;
          paramAnonymousAnimator.publish();
          AppMethodBeat.o(100456);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100455);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          paramAnonymousAnimator = new xv();
          paramAnonymousAnimator.ibn.ibo = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.ibn.state = 120;
          paramAnonymousAnimator.publish();
          AppMethodBeat.o(100455);
        }
      });
      this.ATZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.ATZ.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100459);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setVisibility(8);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          paramAnonymousAnimator = new xv();
          paramAnonymousAnimator.ibn.ibo = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.ibn.state = 123;
          paramAnonymousAnimator.publish();
          AppMethodBeat.o(100459);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100458);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          SnsAdLandingPageFloatView.c(SnsAdLandingPageFloatView.this);
          SnsAdLandingPageFloatView.this.onPause();
          SnsAdLandingPageFloatView.this.onDestroy();
          paramAnonymousAnimator = new xv();
          paramAnonymousAnimator.ibn.ibo = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.ibn.state = 122;
          paramAnonymousAnimator.publish();
          AppMethodBeat.o(100458);
        }
      });
    }
    AppMethodBeat.o(309353);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(309363);
    this.isResume = false;
    if ((this.RWg != null) && (!this.EsR))
    {
      this.EsR = true;
      this.RWi.has();
    }
    AppMethodBeat.o(309363);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(100466);
    this.isResume = false;
    if (this.RWh != null) {
      this.RWi.hap();
    }
    AppMethodBeat.o(100466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100465);
    this.isResume = true;
    if (this.RWh != null)
    {
      this.RWi.hao();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100461);
          SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).haq();
          AppMethodBeat.o(100461);
        }
      });
    }
    AppMethodBeat.o(100465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView
 * JD-Core Version:    0.7.0.1
 */