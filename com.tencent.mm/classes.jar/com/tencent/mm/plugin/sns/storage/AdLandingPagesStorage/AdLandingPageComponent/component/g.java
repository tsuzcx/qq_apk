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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n
{
  protected TextView QNs;
  protected FrameLayout QNt;
  protected ViewGroup QNv;
  protected q QNw;
  protected boolean QNx;
  protected al QOd;
  protected RoundedCornerFrameLayout QOe;
  int QOf;
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  public int orientation;
  
  public g(Context paramContext, al paramal, ViewGroup paramViewGroup, int paramInt)
  {
    super(paramContext, paramal, paramViewGroup);
    AppMethodBeat.i(307102);
    this.QNx = false;
    this.clickCount = 0;
    this.QOf = 0;
    this.orientation = 0;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(306926);
        if (paramAnonymousMessage.what == 1)
        {
          if (g.this.QOf == 0)
          {
            g.this.F(((Boolean)paramAnonymousMessage.obj).booleanValue());
            AppMethodBeat.o(306926);
            return;
          }
          g.this.aj(((Boolean)paramAnonymousMessage.obj).booleanValue(), g.this.orientation);
          AppMethodBeat.o(306926);
          return;
        }
        if (paramAnonymousMessage.what == 2)
        {
          if (g.this.QOf == 0)
          {
            g.this.G(((Boolean)paramAnonymousMessage.obj).booleanValue());
            AppMethodBeat.o(306926);
            return;
          }
          g.this.ak(((Boolean)paramAnonymousMessage.obj).booleanValue(), g.this.orientation);
        }
        AppMethodBeat.o(306926);
      }
    };
    this.mContext = paramContext;
    this.QNv = paramViewGroup;
    this.QOd = paramal;
    this.QOf = paramInt;
    Gs();
    had();
    Log.i("AdLandingFullScreenFloatBarComp", "refreshView, cid=" + paramal.QKG + ", hash=" + hashCode());
    AppMethodBeat.o(307102);
  }
  
  private void hiO()
  {
    AppMethodBeat.i(307110);
    if (this.QNw != null)
    {
      this.QNw.clickCount -= this.clickCount;
      Log.i("AdLandingFullScreenFloatBarComp", "btn kv, clickCount=" + this.QNw.clickCount + ", stayTime=" + this.QNw.hjj());
    }
    AppMethodBeat.o(307110);
  }
  
  private static ai hiS()
  {
    AppMethodBeat.i(307106);
    if (ag.Qud != null)
    {
      localai = ag.Qud;
      AppMethodBeat.o(307106);
      return localai;
    }
    ai localai = new ai();
    AppMethodBeat.o(307106);
    return localai;
  }
  
  public final void DU(boolean paramBoolean)
  {
    AppMethodBeat.i(307136);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(2, Boolean.valueOf(paramBoolean));
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(307136);
  }
  
  protected final void F(boolean paramBoolean)
  {
    AppMethodBeat.i(307131);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      hao();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
        localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
        localTranslateAnimation.setDuration(700L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(307131);
  }
  
  protected final void G(boolean paramBoolean)
  {
    AppMethodBeat.i(307141);
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      hap();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
        localTranslateAnimation.setDuration(400L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(307141);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(307117);
    View localView = LayoutInflater.from(this.mContext).inflate(b.g.sns_ad_native_landing_pages_item_fullscreen_floatbar, this.QNv, false);
    this.mContentView = localView;
    this.QNs = ((TextView)localView.findViewById(b.f.float_desc_txt));
    this.QNt = ((FrameLayout)localView.findViewById(b.f.float_btn_container));
    this.QOe = ((RoundedCornerFrameLayout)localView.findViewById(b.f.float_bar_corner_container));
    this.QOe.setRadius(0.0F);
    this.QNv.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(307117);
  }
  
  protected final void aj(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(307168);
    float f;
    TranslateAnimation localTranslateAnimation;
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      hao();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        f = this.mContentView.getHeight() * 1.5F / this.mContentView.getWidth();
        if (paramInt != 0) {
          break label119;
        }
        localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
      }
    }
    for (;;)
    {
      localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
      localTranslateAnimation.setDuration(700L);
      this.mContentView.startAnimation(localTranslateAnimation);
      AppMethodBeat.o(307168);
      return;
      label119:
      if (paramInt == 90) {
        localTranslateAnimation = new TranslateAnimation(1, -f, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      } else {
        localTranslateAnimation = new TranslateAnimation(1, f, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      }
    }
  }
  
  protected final void ak(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(307170);
    float f;
    TranslateAnimation localTranslateAnimation;
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      hap();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        f = this.mContentView.getHeight() * 1.5F / this.mContentView.getWidth();
        if (paramInt != 0) {
          break label107;
        }
        localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
      }
    }
    for (;;)
    {
      localTranslateAnimation.setDuration(400L);
      this.mContentView.startAnimation(localTranslateAnimation);
      AppMethodBeat.o(307170);
      return;
      label107:
      if (paramInt == 90) {
        localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, -f, 1, 0.0F, 1, 0.0F);
      } else {
        localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, f, 1, 0.0F, 1, 0.0F);
      }
    }
  }
  
  public final List<Animator> b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    AppMethodBeat.i(307183);
    LinkedList localLinkedList = new LinkedList();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.mContentView, "rotation", new float[] { paramFloat1, paramFloat2 });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mContentView, "translationX", new float[] { paramFloat3, paramFloat4 });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.mContentView, "translationY", new float[] { paramFloat5, paramFloat6 });
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat7, paramFloat8 });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(306919);
        if (g.this.mContentView != null)
        {
          paramAnonymousValueAnimator = (Float)paramAnonymousValueAnimator.getAnimatedValue();
          ViewGroup.LayoutParams localLayoutParams = g.this.mContentView.getLayoutParams();
          localLayoutParams.width = ((int)paramAnonymousValueAnimator.floatValue());
          g.this.mContentView.setLayoutParams(localLayoutParams);
        }
        AppMethodBeat.o(306919);
      }
    });
    localLinkedList.add(localObjectAnimator1);
    localLinkedList.add(localObjectAnimator2);
    localLinkedList.add(localObjectAnimator3);
    localLinkedList.add(localValueAnimator);
    AppMethodBeat.o(307183);
    return localLinkedList;
  }
  
  public final com.tencent.mm.plugin.sns.ad.g.a.a getAdLandingVideoFullScreenFloatBarReportInfo()
  {
    AppMethodBeat.i(307190);
    q localq = this.QNw;
    if (localq != null)
    {
      com.tencent.mm.plugin.sns.ad.g.a.a locala = new com.tencent.mm.plugin.sns.ad.g.a.a();
      hiO();
      locala.PXz = localq.QOV.QKG;
      locala.PXA = localq.hjk();
      locala.PXB = localq.hjj();
      locala.PXC = localq.clickCount;
      locala.PXy = hjk();
      locala.hTS = hjj();
      locala.clickCount = this.clickCount;
      AppMethodBeat.o(307190);
      return locala;
    }
    AppMethodBeat.o(307190);
    return null;
  }
  
  public final View getContentView()
  {
    return this.mContentView;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(307124);
    if (!TextUtils.isEmpty(this.QOd.desc))
    {
      this.QNs.setText(this.QOd.desc);
      this.QNs.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.QOd.QLc)) {}
      try
      {
        this.QNs.setTextColor(Color.parseColor(this.QOd.QLc));
        this.QNt.removeAllViews();
        Object localObject = bb.a(this.mContext, this.QOd.QLh, this.QNt, 0);
        if ((localObject instanceof q))
        {
          this.QNw = ((q)localObject);
          if (this.QOf == 0) {
            this.QNw.a(this.QOd.QLh, hiS());
          }
          if (this.QNw != null)
          {
            localObject = this.QNw.getView();
            this.QNt.addView((View)localObject);
          }
          this.QNx = this.QOd.QLd;
          this.mContentView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(306934);
              b localb = new b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (!g.this.QNx)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(306934);
                return;
              }
              paramAnonymousView = g.this;
              paramAnonymousView.clickCount += 1;
              if (g.this.QNw != null) {
                paramAnonymousView = null;
              }
              for (;;)
              {
                try
                {
                  if ((g.this.QNw instanceof r))
                  {
                    paramAnonymousView = ((r)g.this.QNw).QPn;
                    if (paramAnonymousView != null)
                    {
                      paramAnonymousView.performClick();
                      i = g.this.QNw.clickCount;
                      Log.i("AdLandingFullScreenFloatBarComp", "onClick, clickCount=" + g.this.clickCount + ", btnClickCount=" + i);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(306934);
                    }
                  }
                  else
                  {
                    if (!(g.this.QNw instanceof t)) {
                      continue;
                    }
                    paramAnonymousView = ((t)g.this.QNw).QPz;
                    continue;
                  }
                  Log.e("AdLandingFullScreenFloatBarComp", "onClick noBtn found, comp=" + g.this.QNw);
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
          AppMethodBeat.o(307124);
          return;
          this.QNs.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("AdLandingFullScreenFloatBarComp", "refreshView descColor, exp=" + localException.toString() + ", color=" + this.QOd.QLc);
          continue;
          Log.e("AdLandingFullScreenFloatBarComp", "btnComp=".concat(String.valueOf(localException)));
        }
      }
    }
  }
  
  public final void hao()
  {
    AppMethodBeat.i(307151);
    super.hao();
    if (this.QNw != null) {
      this.QNw.hao();
    }
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillAppear");
    AppMethodBeat.o(307151);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(307155);
    super.hap();
    if (this.QNw != null)
    {
      this.QNw.hap();
      Log.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, mBtnComponent exposureCount = " + this.QNw.hjk() + ", mBtnComponent stayTime = " + this.QNw.hjj() + ", mBtnComponent cid = " + this.QNw.QOV.QKG);
    }
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, exposureCount = " + hjk() + ", stayTime = " + hjj());
    AppMethodBeat.o(307155);
  }
  
  public final void has()
  {
    AppMethodBeat.i(307156);
    super.has();
    if (this.QNw != null)
    {
      this.QNw.has();
      Log.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy, mBtnComponent exposureCount = " + this.QNw.hjk() + ", mBtnComponent stayTime = " + this.QNw.hjj() + ", mBtnComponent cid = " + this.QNw.QOV.QKG);
    }
    this.mHandler.removeCallbacksAndMessages(null);
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy");
    AppMethodBeat.o(307156);
  }
  
  public final void hiR()
  {
    AppMethodBeat.i(307127);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(307127);
  }
  
  public final void hiT()
  {
    AppMethodBeat.i(307163);
    if (this.QNv != null) {
      this.QNv.removeView(this.mContentView);
    }
    AppMethodBeat.o(307163);
  }
  
  public final void hiU()
  {
    AppMethodBeat.i(307175);
    int i = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 44);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
    }
    if ((this.QNt.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)this.QNt.getLayoutParams()).leftMargin = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 24);
    }
    AppMethodBeat.o(307175);
  }
  
  public final void hiV()
  {
    AppMethodBeat.i(307177);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
    AppMethodBeat.o(307177);
  }
  
  public final String hiW()
  {
    AppMethodBeat.i(307195);
    try
    {
      Object localObject1 = this.QNw;
      if (localObject1 != null)
      {
        hiO();
        localObject1 = new a(hjk(), hjj(), this.clickCount, ((n)localObject1).QOV.QKG, ((q)localObject1).hjk(), ((q)localObject1).hjj(), ((q)localObject1).clickCount).QOh.toString();
        AppMethodBeat.o(307195);
        return localObject1;
      }
    }
    finally
    {
      Log.e("AdLandingFullScreenFloatBarComp", localObject2.toString());
      AppMethodBeat.o(307195);
    }
    return "";
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(307148);
    if (this.mContentView.getVisibility() == 0)
    {
      AppMethodBeat.o(307148);
      return true;
    }
    AppMethodBeat.o(307148);
    return false;
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(307114);
    this.QNv.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(307114);
  }
  
  public static final class a
  {
    i QOh;
    
    public a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, long paramLong2, int paramInt4)
    {
      AppMethodBeat.i(307009);
      this.QOh = new i();
      try
      {
        i locali = new i();
        locali.m("cid", paramString);
        locali.au("exposureCount", paramInt3);
        locali.t("stayTime", paramLong2);
        locali.au("clickCount", paramInt4);
        this.QOh.au("exposureCount", paramInt1);
        this.QOh.t("stayTime", paramLong1);
        this.QOh.au("clickCount", paramInt2);
        this.QOh.m("btnInfo", locali);
        AppMethodBeat.o(307009);
        return;
      }
      finally
      {
        Log.e("AdLandingFullScreenFloatBarComp", paramString.toString());
        AppMethodBeat.o(307009);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g
 * JD-Core Version:    0.7.0.1
 */