package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

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
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class g
  extends l
{
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  protected TextView zCG;
  protected FrameLayout zCH;
  protected ViewGroup zCJ;
  protected o zCK;
  protected boolean zCL;
  protected ag zDm;
  protected RoundedCornerFrameLayout zDn;
  
  public g(Context paramContext, ag paramag, ViewGroup paramViewGroup)
  {
    super(paramContext, paramag, paramViewGroup);
    AppMethodBeat.i(197918);
    this.zCL = false;
    this.clickCount = 0;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(197916);
        if (paramAnonymousMessage.what == 1)
        {
          g.this.W(((Boolean)paramAnonymousMessage.obj).booleanValue());
          AppMethodBeat.o(197916);
          return;
        }
        if (paramAnonymousMessage.what == 2) {
          g.this.X(((Boolean)paramAnonymousMessage.obj).booleanValue());
        }
        AppMethodBeat.o(197916);
      }
    };
    this.mContext = paramContext;
    this.zCJ = paramViewGroup;
    this.zDm = paramag;
    dRk();
    dRl();
    ad.i("AdLandingFullScreenFloatBarComp", "refreshView, cid=" + paramag.zAg + ", hash=" + hashCode());
    AppMethodBeat.o(197918);
  }
  
  private static ae dWJ()
  {
    AppMethodBeat.i(197925);
    if (ac.ziT != null)
    {
      localae = ac.ziT;
      AppMethodBeat.o(197925);
      return localae;
    }
    ae localae = new ae();
    AppMethodBeat.o(197925);
    return localae;
  }
  
  protected final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(197922);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      dRm();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
        localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
        localTranslateAnimation.setDuration(700L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(197922);
  }
  
  protected final void X(boolean paramBoolean)
  {
    AppMethodBeat.i(197924);
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      dRn();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
        localTranslateAnimation.setDuration(400L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(197924);
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(197919);
    View localView = LayoutInflater.from(this.mContext).inflate(2131496426, this.zCJ, false);
    this.mContentView = localView;
    this.zCG = ((TextView)localView.findViewById(2131300136));
    this.zCH = ((FrameLayout)localView.findViewById(2131300135));
    this.zDn = ((RoundedCornerFrameLayout)localView.findViewById(2131300132));
    this.zDn.setRadius(0.0F);
    this.zCJ.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(197919);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(197920);
    if (!TextUtils.isEmpty(this.zDm.desc))
    {
      this.zCG.setText(this.zDm.desc);
      this.zCG.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.zDm.zAw)) {}
      try
      {
        this.zCG.setTextColor(Color.parseColor(this.zDm.zAw));
        this.zCH.removeAllViews();
        Object localObject = av.a(this.mContext, this.zDm.zAB, this.zCH, 0);
        if ((localObject instanceof o))
        {
          this.zCK = ((o)localObject);
          this.zCK.a(this.zDm.zAB, dWJ());
          if (this.zCK != null)
          {
            localObject = this.zCK.getView();
            this.zCH.addView((View)localObject);
          }
          this.zCL = this.zDm.zAx;
          this.mContentView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(197915);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (!g.this.zCL)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(197915);
                return;
              }
              paramAnonymousView = g.this;
              paramAnonymousView.clickCount += 1;
              if (g.this.zCK != null) {
                paramAnonymousView = null;
              }
              for (;;)
              {
                try
                {
                  if ((g.this.zCK instanceof p))
                  {
                    paramAnonymousView = ((p)g.this.zCK).zEd;
                    if (paramAnonymousView != null)
                    {
                      paramAnonymousView.performClick();
                      i = g.this.zCK.clickCount;
                      ad.i("AdLandingFullScreenFloatBarComp", "onClick, clickCount=" + g.this.clickCount + ", btnClickCount=" + i);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(197915);
                    }
                  }
                  else
                  {
                    if (!(g.this.zCK instanceof r)) {
                      continue;
                    }
                    paramAnonymousView = ((r)g.this.zCK).zEo;
                    continue;
                  }
                  ad.e("AdLandingFullScreenFloatBarComp", "onClick noBtn found, comp=" + g.this.zCK);
                  continue;
                  int i = 0;
                }
                catch (Exception paramAnonymousView)
                {
                  ad.e("AdLandingFullScreenFloatBarComp", "onClick exp=" + paramAnonymousView.toString());
                }
              }
            }
          });
          AppMethodBeat.o(197920);
          return;
          this.zCG.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("AdLandingFullScreenFloatBarComp", "refreshView descColor, exp=" + localException.toString() + ", color=" + this.zDm.zAw);
          continue;
          ad.e("AdLandingFullScreenFloatBarComp", "btnComp=".concat(String.valueOf(localException)));
        }
      }
    }
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(197926);
    super.dRm();
    if (this.zCK != null) {
      this.zCK.dRm();
    }
    ad.i("AdLandingFullScreenFloatBarComp", "viewWillAppear");
    AppMethodBeat.o(197926);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(197927);
    super.dRn();
    if (this.zCK != null)
    {
      this.zCK.dRn();
      ad.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, mBtnComponent exposureCount = " + this.zCK.zDL + ", mBtnComponent stayTime = " + this.zCK.dBD + ", mBtnComponent cid = " + this.zCK.dWV());
    }
    ad.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, exposureCount = " + this.zDL + ", stayTime = " + this.dBD);
    AppMethodBeat.o(197927);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(197928);
    super.dRo();
    if (this.zCK != null)
    {
      this.zCK.dRo();
      ad.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy, mBtnComponent exposureCount = " + this.zCK.zDL + ", mBtnComponent stayTime = " + this.zCK.dBD + ", mBtnComponent cid = " + this.zCK.dWV());
    }
    this.mHandler.removeCallbacksAndMessages(null);
    ad.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy");
    AppMethodBeat.o(197928);
  }
  
  public final void dWI()
  {
    AppMethodBeat.i(197921);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(197921);
  }
  
  public final void dWK()
  {
    AppMethodBeat.i(197929);
    int i = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 44);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
    }
    if ((this.zCH.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)this.zCH.getLayoutParams()).leftMargin = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 24);
    }
    AppMethodBeat.o(197929);
  }
  
  public final void dWL()
  {
    AppMethodBeat.i(197930);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
    AppMethodBeat.o(197930);
  }
  
  public final String dWM()
  {
    AppMethodBeat.i(197931);
    try
    {
      Object localObject = this.zCK;
      if (localObject != null)
      {
        if (this.zCK != null)
        {
          this.zCK.clickCount -= this.clickCount;
          ad.i("AdLandingFullScreenFloatBarComp", "btn kv, clickCount=" + this.zCK.clickCount + ", stayTime=" + this.zCK.dBD);
        }
        localObject = new a(this.zDL, this.dBD, this.clickCount, ((o)localObject).dWV(), ((l)localObject).zDL, ((l)localObject).dBD, ((o)localObject).clickCount).zDp.toString();
        AppMethodBeat.o(197931);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      ad.e("AdLandingFullScreenFloatBarComp", localThrowable.toString());
      AppMethodBeat.o(197931);
    }
    return "";
  }
  
  public final void rC(boolean paramBoolean)
  {
    AppMethodBeat.i(197923);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(2, Boolean.valueOf(paramBoolean));
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(197923);
  }
  
  public static final class a
  {
    i zDp;
    
    public a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, long paramLong2, int paramInt4)
    {
      AppMethodBeat.i(197917);
      this.zDp = new i();
      try
      {
        i locali = new i();
        locali.h("cid", paramString);
        locali.R("exposureCount", paramInt3);
        locali.u("stayTime", paramLong2);
        locali.R("clickCount", paramInt4);
        this.zDp.R("exposureCount", paramInt1);
        this.zDp.u("stayTime", paramLong1);
        this.zDp.R("clickCount", paramInt2);
        this.zDp.h("btnInfo", locali);
        AppMethodBeat.o(197917);
        return;
      }
      catch (Throwable paramString)
      {
        ad.e("AdLandingFullScreenFloatBarComp", paramString.toString());
        AppMethodBeat.o(197917);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g
 * JD-Core Version:    0.7.0.1
 */