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
import com.tencent.mm.g.a.uz;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.ay;
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
  boolean ESr;
  private Map<String, String> Eaa;
  private List<m> ExZ;
  public x Fel;
  public g Fem;
  private m Fen;
  private View Feo;
  private AnimatorSet Fep;
  public boolean Feq;
  public String adCanvasExtXml;
  public String dVe;
  private boolean isResume;
  ValueAnimator tMD;
  
  public SnsAdLandingPageFloatView(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(100462);
    this.Eaa = new HashMap();
    this.Fep = new AnimatorSet();
    this.tMD = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.Feq = true;
    AppMethodBeat.o(100462);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, -1);
    AppMethodBeat.i(100463);
    this.Eaa = new HashMap();
    this.Fep = new AnimatorSet();
    this.tMD = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.Feq = true;
    AppMethodBeat.o(100463);
  }
  
  public SnsAdLandingPageFloatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, -1);
    AppMethodBeat.i(100464);
    this.Eaa = new HashMap();
    this.Fep = new AnimatorSet();
    this.tMD = ValueAnimator.ofFloat(new float[] { 1.0F, 0.4F }).setDuration(100L);
    this.Feq = true;
    AppMethodBeat.o(100464);
  }
  
  private void flc()
  {
    AppMethodBeat.i(100467);
    Map localMap;
    int i;
    if ((this.Fem != null) && (!Util.isNullOrNil(this.adCanvasExtXml)))
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
          this.Eaa.put(str2, str1);
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
    AppMethodBeat.i(203986);
    int i;
    if (this.Fel != null)
    {
      if (this.Fel.DZg > 0) {
        setBackground(null);
      }
      i = 0;
    }
    try
    {
      int j = Color.parseColor(this.Fem.lco);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsAdLandingPageFloatView", "parseColor exp=" + localException.toString() + ", colorStr=" + this.Fem.lco);
      }
    }
    this.Fen = ay.a(getContext(), this.Fel, this, i);
    this.Fen.setBackgroundColor(i);
    this.Feo = this.Fen.getView();
    addView(this.Feo);
    this.Fen.fdp();
    if (this.Fel.DZf <= 0) {
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
              if (!paramAnonymousView.ESr)
              {
                paramAnonymousView.tMD.start();
                paramAnonymousView.ESr = true;
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
    AppMethodBeat.o(203986);
  }
  
  public final void flb()
  {
    AppMethodBeat.i(203987);
    if (!this.ESr)
    {
      this.Fep.start();
      this.ESr = true;
    }
    AppMethodBeat.o(203987);
  }
  
  public List<m> getAllComp()
  {
    AppMethodBeat.i(100468);
    if (this.ExZ != null)
    {
      localList = this.ExZ;
      AppMethodBeat.o(100468);
      return localList;
    }
    this.ExZ = new ArrayList();
    this.ExZ.add(this.Fen);
    i.gU(this.ExZ);
    List localList = this.ExZ;
    AppMethodBeat.o(100468);
    return localList;
  }
  
  long getAnimationTimeFactor()
  {
    if (this.Feq) {
      return 1L;
    }
    return 0L;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(203985);
    if (this.Fem != null)
    {
      initPage();
      flc();
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
      this.Fep.playSequentially(new Animator[] { localValueAnimator1, localValueAnimator2 });
      this.Fep.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100456);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          SnsAdLandingPageFloatView.this.onResume();
          paramAnonymousAnimator = new uz();
          paramAnonymousAnimator.ebq.ebr = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.ebq.state = 121;
          EventCenter.instance.publish(paramAnonymousAnimator);
          AppMethodBeat.o(100456);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100455);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          paramAnonymousAnimator = new uz();
          paramAnonymousAnimator.ebq.ebr = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.ebq.state = 120;
          EventCenter.instance.publish(paramAnonymousAnimator);
          AppMethodBeat.o(100455);
        }
      });
      this.tMD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
      this.tMD.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100459);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this).setVisibility(8);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, false);
          paramAnonymousAnimator = new uz();
          paramAnonymousAnimator.ebq.ebr = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.ebq.state = 123;
          EventCenter.instance.publish(paramAnonymousAnimator);
          AppMethodBeat.o(100459);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(100458);
          SnsAdLandingPageFloatView.a(SnsAdLandingPageFloatView.this, true);
          SnsAdLandingPageFloatView.c(SnsAdLandingPageFloatView.this);
          SnsAdLandingPageFloatView.this.onPause();
          paramAnonymousAnimator = new uz();
          paramAnonymousAnimator.ebq.ebr = SnsAdLandingPageFloatView.b(SnsAdLandingPageFloatView.this);
          paramAnonymousAnimator.ebq.state = 122;
          EventCenter.instance.publish(paramAnonymousAnimator);
          AppMethodBeat.o(100458);
        }
      });
    }
    AppMethodBeat.o(203985);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(100466);
    this.isResume = false;
    if (this.Fem != null) {
      this.Fen.eXa();
    }
    AppMethodBeat.o(100466);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(100465);
    this.isResume = true;
    if (this.Fem != null)
    {
      this.Fen.eWZ();
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(100461);
          SnsAdLandingPageFloatView.d(SnsAdLandingPageFloatView.this).eXb();
          AppMethodBeat.o(100461);
        }
      });
    }
    AppMethodBeat.o(100465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView
 * JD-Core Version:    0.7.0.1
 */