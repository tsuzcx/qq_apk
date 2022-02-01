package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends m
{
  public int FO;
  protected ak KpW;
  protected RoundedCornerFrameLayout KpX;
  int KpY;
  protected TextView Kpl;
  protected FrameLayout Kpm;
  protected ViewGroup Kpo;
  protected p Kpp;
  protected boolean Kpq;
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  
  public g(Context paramContext, ak paramak, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramContext, paramak, paramViewGroup);
    AppMethodBeat.i(222881);
    this.Kpq = false;
    this.clickCount = 0;
    this.KpY = 0;
    this.FO = 0;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(243405);
        if (paramAnonymousMessage.what == 1)
        {
          if (g.this.KpY == 0)
          {
            g.this.B(((Boolean)paramAnonymousMessage.obj).booleanValue());
            AppMethodBeat.o(243405);
            return;
          }
          g.this.ah(((Boolean)paramAnonymousMessage.obj).booleanValue(), g.this.FO);
          AppMethodBeat.o(243405);
          return;
        }
        if (paramAnonymousMessage.what == 2)
        {
          if (g.this.KpY == 0)
          {
            g.this.C(((Boolean)paramAnonymousMessage.obj).booleanValue());
            AppMethodBeat.o(243405);
            return;
          }
          g.this.ai(((Boolean)paramAnonymousMessage.obj).booleanValue(), g.this.FO);
        }
        AppMethodBeat.o(243405);
      }
    };
    this.mContext = paramContext;
    this.Kpo = paramViewGroup;
    this.KpW = paramak;
    this.KpY = paramInt;
    fKp();
    fKe();
    Log.i("AdLandingFullScreenFloatBarComp", "refreshView, cid=" + paramak.KmB + ", hash=" + hashCode());
    AppMethodBeat.o(222881);
  }
  
  private void fQQ()
  {
    AppMethodBeat.i(222953);
    if (this.Kpp != null)
    {
      this.Kpp.clickCount -= this.clickCount;
      Log.i("AdLandingFullScreenFloatBarComp", "btn kv, clickCount=" + this.Kpp.clickCount + ", stayTime=" + this.Kpp.fRk());
    }
    AppMethodBeat.o(222953);
  }
  
  private static ai fQU()
  {
    AppMethodBeat.i(222922);
    if (ae.JWV != null)
    {
      localai = ae.JWV;
      AppMethodBeat.o(222922);
      return localai;
    }
    ai localai = new ai();
    AppMethodBeat.o(222922);
    return localai;
  }
  
  protected final void B(boolean paramBoolean)
  {
    AppMethodBeat.i(222909);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      fKk();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
        localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
        localTranslateAnimation.setDuration(700L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(222909);
  }
  
  protected final void C(boolean paramBoolean)
  {
    AppMethodBeat.i(222918);
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      fKl();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
        localTranslateAnimation.setDuration(400L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(222918);
  }
  
  protected final void ah(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(222943);
    float f;
    TranslateAnimation localTranslateAnimation;
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      fKk();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        f = this.mContentView.getHeight() * 1.5F / this.mContentView.getWidth();
        if (paramInt != 0) {
          break label117;
        }
        localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
      }
    }
    for (;;)
    {
      localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
      localTranslateAnimation.setDuration(700L);
      this.mContentView.startAnimation(localTranslateAnimation);
      AppMethodBeat.o(222943);
      return;
      label117:
      if (paramInt == 90) {
        localTranslateAnimation = new TranslateAnimation(1, -f, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      } else {
        localTranslateAnimation = new TranslateAnimation(1, f, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      }
    }
  }
  
  protected final void ai(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(222948);
    float f;
    TranslateAnimation localTranslateAnimation;
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      fKl();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        f = this.mContentView.getHeight() * 1.5F / this.mContentView.getWidth();
        if (paramInt != 0) {
          break label105;
        }
        localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
      }
    }
    for (;;)
    {
      localTranslateAnimation.setDuration(400L);
      this.mContentView.startAnimation(localTranslateAnimation);
      AppMethodBeat.o(222948);
      return;
      label105:
      if (paramInt == 90) {
        localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, -f, 1, 0.0F, 1, 0.0F);
      } else {
        localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, f, 1, 0.0F, 1, 0.0F);
      }
    }
  }
  
  public final List<Animator> b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    AppMethodBeat.i(222967);
    LinkedList localLinkedList = new LinkedList();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mContentView, "rotation", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mContentView, "translationX", new float[] { paramFloat3, paramFloat4 });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mContentView, "translationY", new float[] { paramFloat5, paramFloat6 });
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat7, paramFloat8 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(263776);
        if (g.this.mContentView != null)
        {
          paramAnonymousValueAnimator = (Float)paramAnonymousValueAnimator.getAnimatedValue();
          ViewGroup.LayoutParams localLayoutParams = g.this.mContentView.getLayoutParams();
          localLayoutParams.width = ((int)paramAnonymousValueAnimator.floatValue());
          g.this.mContentView.setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(263776);
      }
    });
    localLinkedList.add(localObjectAnimator1);
    localLinkedList.add(localObjectAnimator2);
    localLinkedList.add(localObjectAnimator3);
    localLinkedList.add(localValueAnimator);
    AppMethodBeat.o(222967);
    return localLinkedList;
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(222898);
    if (!TextUtils.isEmpty(this.KpW.desc))
    {
      this.Kpl.setText(this.KpW.desc);
      this.Kpl.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.KpW.KmX)) {}
      try
      {
        this.Kpl.setTextColor(Color.parseColor(this.KpW.KmX));
        this.Kpm.removeAllViews();
        Object localObject = ba.a(this.mContext, this.KpW.Knc, this.Kpm, 0);
        if ((localObject instanceof p))
        {
          this.Kpp = ((p)localObject);
          if (this.KpY == 0) {
            this.Kpp.a(this.KpW.Knc, fQU());
          }
          if (this.Kpp != null)
          {
            localObject = this.Kpp.getView();
            this.Kpm.addView((View)localObject);
          }
          this.Kpq = this.KpW.KmY;
          this.mContentView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(267709);
              b localb = new b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (!g.this.Kpq)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(267709);
                return;
              }
              paramAnonymousView = g.this;
              paramAnonymousView.clickCount += 1;
              if (g.this.Kpp != null) {
                paramAnonymousView = null;
              }
              for (;;)
              {
                try
                {
                  if ((g.this.Kpp instanceof q))
                  {
                    paramAnonymousView = ((q)g.this.Kpp).KqS;
                    if (paramAnonymousView != null)
                    {
                      paramAnonymousView.performClick();
                      i = g.this.Kpp.clickCount;
                      Log.i("AdLandingFullScreenFloatBarComp", "onClick, clickCount=" + g.this.clickCount + ", btnClickCount=" + i);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(267709);
                    }
                  }
                  else
                  {
                    if (!(g.this.Kpp instanceof s)) {
                      continue;
                    }
                    paramAnonymousView = ((s)g.this.Kpp).Kre;
                    continue;
                  }
                  Log.e("AdLandingFullScreenFloatBarComp", "onClick noBtn found, comp=" + g.this.Kpp);
                  continue;
                  int i = 0;
                }
                catch (Exception paramAnonymousView)
                {
                  Log.e("AdLandingFullScreenFloatBarComp", "onClick exp=" + paramAnonymousView.toString());
                }
              }
            }
          });
          AppMethodBeat.o(222898);
          return;
          this.Kpl.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("AdLandingFullScreenFloatBarComp", "refreshView descColor, exp=" + localException.toString() + ", color=" + this.KpW.KmX);
          continue;
          Log.e("AdLandingFullScreenFloatBarComp", "btnComp=".concat(String.valueOf(localException)));
        }
      }
    }
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(222925);
    super.fKk();
    if (this.Kpp != null) {
      this.Kpp.fKk();
    }
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillAppear");
    AppMethodBeat.o(222925);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(222928);
    super.fKl();
    if (this.Kpp != null)
    {
      this.Kpp.fKl();
      Log.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, mBtnComponent exposureCount = " + this.Kpp.fRl() + ", mBtnComponent stayTime = " + this.Kpp.fRk() + ", mBtnComponent cid = " + this.Kpp.KqB.KmB);
    }
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, exposureCount = " + fRl() + ", stayTime = " + fRk());
    AppMethodBeat.o(222928);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(222930);
    super.fKo();
    if (this.Kpp != null)
    {
      this.Kpp.fKo();
      Log.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy, mBtnComponent exposureCount = " + this.Kpp.fRl() + ", mBtnComponent stayTime = " + this.Kpp.fRk() + ", mBtnComponent cid = " + this.Kpp.KqB.KmB);
    }
    this.mHandler.removeCallbacksAndMessages(null);
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy");
    AppMethodBeat.o(222930);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(222888);
    View localView = LayoutInflater.from(this.mContext).inflate(i.g.sns_ad_native_landing_pages_item_fullscreen_floatbar, this.Kpo, false);
    this.mContentView = localView;
    this.Kpl = ((TextView)localView.findViewById(i.f.float_desc_txt));
    this.Kpm = ((FrameLayout)localView.findViewById(i.f.float_btn_container));
    this.KpX = ((RoundedCornerFrameLayout)localView.findViewById(i.f.float_bar_corner_container));
    this.KpX.setRadius(0.0F);
    this.Kpo.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(222888);
  }
  
  public final void fQT()
  {
    AppMethodBeat.i(222902);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(222902);
  }
  
  public final void fQV()
  {
    AppMethodBeat.i(222932);
    if (this.Kpo != null) {
      this.Kpo.removeView(this.mContentView);
    }
    AppMethodBeat.o(222932);
  }
  
  public final void fQW()
  {
    AppMethodBeat.i(222958);
    int i = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 44);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
    }
    if ((this.Kpm.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)this.Kpm.getLayoutParams()).leftMargin = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 24);
    }
    AppMethodBeat.o(222958);
  }
  
  public final void fQX()
  {
    AppMethodBeat.i(222961);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
    AppMethodBeat.o(222961);
  }
  
  public final String fQY()
  {
    AppMethodBeat.i(222975);
    try
    {
      Object localObject = this.Kpp;
      if (localObject != null)
      {
        fQQ();
        localObject = new a(fRl(), fRk(), this.clickCount, ((m)localObject).KqB.KmB, ((p)localObject).fRl(), ((p)localObject).fRk(), ((p)localObject).clickCount).Kqa.toString();
        AppMethodBeat.o(222975);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingFullScreenFloatBarComp", localThrowable.toString());
      AppMethodBeat.o(222975);
    }
    return "";
  }
  
  public final com.tencent.mm.plugin.sns.ad.f.a.a getAdLandingVideoFullScreenFloatBarReportInfo()
  {
    AppMethodBeat.i(222971);
    p localp = this.Kpp;
    if (localp != null)
    {
      com.tencent.mm.plugin.sns.ad.f.a.a locala = new com.tencent.mm.plugin.sns.ad.f.a.a();
      fQQ();
      locala.JGz = localp.KqB.KmB;
      locala.JGA = localp.fRl();
      locala.JGB = localp.fRk();
      locala.JGC = localp.clickCount;
      locala.JGy = fRl();
      locala.fOa = fRk();
      locala.clickCount = this.clickCount;
      AppMethodBeat.o(222971);
      return locala;
    }
    AppMethodBeat.o(222971);
    return null;
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(222920);
    if (this.mContentView.getVisibility() == 0)
    {
      AppMethodBeat.o(222920);
      return true;
    }
    AppMethodBeat.o(222920);
    return false;
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(222882);
    this.Kpo.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(222882);
  }
  
  public final void yL(boolean paramBoolean)
  {
    AppMethodBeat.i(222914);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(2, Boolean.valueOf(paramBoolean));
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(222914);
  }
  
  public static final class a
  {
    i Kqa;
    
    public a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, long paramLong2, int paramInt4)
    {
      AppMethodBeat.i(200574);
      this.Kqa = new i();
      try
      {
        i locali = new i();
        locali.g("cid", paramString);
        locali.al("exposureCount", paramInt3);
        locali.s("stayTime", paramLong2);
        locali.al("clickCount", paramInt4);
        this.Kqa.al("exposureCount", paramInt1);
        this.Kqa.s("stayTime", paramLong1);
        this.Kqa.al("clickCount", paramInt2);
        this.Kqa.g("btnInfo", locali);
        AppMethodBeat.o(200574);
        return;
      }
      catch (Throwable paramString)
      {
        Log.e("AdLandingFullScreenFloatBarComp", paramString.toString());
        AppMethodBeat.o(200574);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g
 * JD-Core Version:    0.7.0.1
 */