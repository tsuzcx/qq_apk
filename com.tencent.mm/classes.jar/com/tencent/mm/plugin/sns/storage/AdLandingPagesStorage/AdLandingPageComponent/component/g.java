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
import com.tencent.mm.ab.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class g
  extends m
{
  protected TextView EbQ;
  protected FrameLayout EbR;
  protected ViewGroup EbT;
  protected p EbU;
  protected boolean EbV;
  protected aj Ecv;
  protected RoundedCornerFrameLayout Ecw;
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  
  public g(Context paramContext, aj paramaj, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaj, paramViewGroup);
    AppMethodBeat.i(202865);
    this.EbV = false;
    this.clickCount = 0;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(202863);
        if (paramAnonymousMessage.what == 1)
        {
          g.this.V(((Boolean)paramAnonymousMessage.obj).booleanValue());
          AppMethodBeat.o(202863);
          return;
        }
        if (paramAnonymousMessage.what == 2) {
          g.this.W(((Boolean)paramAnonymousMessage.obj).booleanValue());
        }
        AppMethodBeat.o(202863);
      }
    };
    this.mContext = paramContext;
    this.EbT = paramViewGroup;
    this.Ecv = paramaj;
    eXe();
    eWT();
    Log.i("AdLandingFullScreenFloatBarComp", "refreshView, cid=" + paramaj.DZi + ", hash=" + hashCode());
    AppMethodBeat.o(202865);
  }
  
  private static ah fcZ()
  {
    AppMethodBeat.i(202872);
    if (ae.DJT != null)
    {
      localah = ae.DJT;
      AppMethodBeat.o(202872);
      return localah;
    }
    ah localah = new ah();
    AppMethodBeat.o(202872);
    return localah;
  }
  
  protected final void V(boolean paramBoolean)
  {
    AppMethodBeat.i(202869);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      eWZ();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
        localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
        localTranslateAnimation.setDuration(700L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(202869);
  }
  
  protected final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(202871);
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      eXa();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
        localTranslateAnimation.setDuration(400L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(202871);
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(202867);
    if (!TextUtils.isEmpty(this.Ecv.desc))
    {
      this.EbQ.setText(this.Ecv.desc);
      this.EbQ.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.Ecv.DZC)) {}
      try
      {
        this.EbQ.setTextColor(Color.parseColor(this.Ecv.DZC));
        this.EbR.removeAllViews();
        Object localObject = ay.a(this.mContext, this.Ecv.DZH, this.EbR, 0);
        if ((localObject instanceof p))
        {
          this.EbU = ((p)localObject);
          this.EbU.a(this.Ecv.DZH, fcZ());
          if (this.EbU != null)
          {
            localObject = this.EbU.getView();
            this.EbR.addView((View)localObject);
          }
          this.EbV = this.Ecv.DZD;
          this.mContentView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(202862);
              b localb = new b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (!g.this.EbV)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(202862);
                return;
              }
              paramAnonymousView = g.this;
              paramAnonymousView.clickCount += 1;
              if (g.this.EbU != null) {
                paramAnonymousView = null;
              }
              for (;;)
              {
                try
                {
                  if ((g.this.EbU instanceof q))
                  {
                    paramAnonymousView = ((q)g.this.EbU).Edp;
                    if (paramAnonymousView != null)
                    {
                      paramAnonymousView.performClick();
                      i = g.this.EbU.clickCount;
                      Log.i("AdLandingFullScreenFloatBarComp", "onClick, clickCount=" + g.this.clickCount + ", btnClickCount=" + i);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(202862);
                    }
                  }
                  else
                  {
                    if (!(g.this.EbU instanceof s)) {
                      continue;
                    }
                    paramAnonymousView = ((s)g.this.EbU).EdB;
                    continue;
                  }
                  Log.e("AdLandingFullScreenFloatBarComp", "onClick noBtn found, comp=" + g.this.EbU);
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
          AppMethodBeat.o(202867);
          return;
          this.EbQ.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("AdLandingFullScreenFloatBarComp", "refreshView descColor, exp=" + localException.toString() + ", color=" + this.Ecv.DZC);
          continue;
          Log.e("AdLandingFullScreenFloatBarComp", "btnComp=".concat(String.valueOf(localException)));
        }
      }
    }
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(202873);
    super.eWZ();
    if (this.EbU != null) {
      this.EbU.eWZ();
    }
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillAppear");
    AppMethodBeat.o(202873);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(202874);
    super.eXa();
    if (this.EbU != null)
    {
      this.EbU.eXa();
      Log.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, mBtnComponent exposureCount = " + this.EbU.Dzo + ", mBtnComponent stayTime = " + this.EbU.fdo() + ", mBtnComponent cid = " + this.EbU.fdn());
    }
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, exposureCount = " + this.Dzo + ", stayTime = " + fdo());
    AppMethodBeat.o(202874);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(202875);
    super.eXd();
    if (this.EbU != null)
    {
      this.EbU.eXd();
      Log.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy, mBtnComponent exposureCount = " + this.EbU.Dzo + ", mBtnComponent stayTime = " + this.EbU.fdo() + ", mBtnComponent cid = " + this.EbU.fdn());
    }
    this.mHandler.removeCallbacksAndMessages(null);
    Log.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy");
    AppMethodBeat.o(202875);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(202866);
    View localView = LayoutInflater.from(this.mContext).inflate(2131496386, this.EbT, false);
    this.mContentView = localView;
    this.EbQ = ((TextView)localView.findViewById(2131301587));
    this.EbR = ((FrameLayout)localView.findViewById(2131301586));
    this.Ecw = ((RoundedCornerFrameLayout)localView.findViewById(2131301583));
    this.Ecw.setRadius(0.0F);
    this.EbT.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(202866);
  }
  
  public final void fcY()
  {
    AppMethodBeat.i(202868);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(202868);
  }
  
  public final void fda()
  {
    AppMethodBeat.i(202876);
    int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 44);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
    }
    if ((this.EbR.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)this.EbR.getLayoutParams()).leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 24);
    }
    AppMethodBeat.o(202876);
  }
  
  public final void fdb()
  {
    AppMethodBeat.i(202877);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
    AppMethodBeat.o(202877);
  }
  
  public final String fdc()
  {
    AppMethodBeat.i(202878);
    try
    {
      Object localObject = this.EbU;
      if (localObject != null)
      {
        if (this.EbU != null)
        {
          this.EbU.clickCount -= this.clickCount;
          Log.i("AdLandingFullScreenFloatBarComp", "btn kv, clickCount=" + this.EbU.clickCount + ", stayTime=" + this.EbU.fdo());
        }
        localObject = new a(this.Dzo, fdo(), this.clickCount, ((p)localObject).fdn(), ((m)localObject).Dzo, ((p)localObject).fdo(), ((p)localObject).clickCount).Ecy.toString();
        AppMethodBeat.o(202878);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("AdLandingFullScreenFloatBarComp", localThrowable.toString());
      AppMethodBeat.o(202878);
    }
    return "";
  }
  
  public final void vf(boolean paramBoolean)
  {
    AppMethodBeat.i(202870);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(2, Boolean.valueOf(paramBoolean));
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(202870);
  }
  
  public static final class a
  {
    i Ecy;
    
    public a(int paramInt1, long paramLong1, int paramInt2, String paramString, int paramInt3, long paramLong2, int paramInt4)
    {
      AppMethodBeat.i(202864);
      this.Ecy = new i();
      try
      {
        i locali = new i();
        locali.h("cid", paramString);
        locali.U("exposureCount", paramInt3);
        locali.v("stayTime", paramLong2);
        locali.U("clickCount", paramInt4);
        this.Ecy.U("exposureCount", paramInt1);
        this.Ecy.v("stayTime", paramLong1);
        this.Ecy.U("clickCount", paramInt2);
        this.Ecy.h("btnInfo", locali);
        AppMethodBeat.o(202864);
        return;
      }
      catch (Throwable paramString)
      {
        Log.e("AdLandingFullScreenFloatBarComp", paramString.toString());
        AppMethodBeat.o(202864);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g
 * JD-Core Version:    0.7.0.1
 */