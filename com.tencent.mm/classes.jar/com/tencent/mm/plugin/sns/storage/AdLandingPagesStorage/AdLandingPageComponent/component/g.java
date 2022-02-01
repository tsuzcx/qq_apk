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
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class g
  extends m
{
  int clickCount;
  protected View mContentView;
  protected Context mContext;
  protected Handler mHandler;
  protected TextView zTI;
  protected FrameLayout zTJ;
  protected ViewGroup zTL;
  protected p zTM;
  protected boolean zTN;
  protected ah zUo;
  protected RoundedCornerFrameLayout zUp;
  
  public g(Context paramContext, ah paramah, ViewGroup paramViewGroup)
  {
    super(paramContext, paramah, paramViewGroup);
    AppMethodBeat.i(219415);
    this.zTN = false;
    this.clickCount = 0;
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(219413);
        if (paramAnonymousMessage.what == 1)
        {
          g.this.W(((Boolean)paramAnonymousMessage.obj).booleanValue());
          AppMethodBeat.o(219413);
          return;
        }
        if (paramAnonymousMessage.what == 2) {
          g.this.X(((Boolean)paramAnonymousMessage.obj).booleanValue());
        }
        AppMethodBeat.o(219413);
      }
    };
    this.mContext = paramContext;
    this.zTL = paramViewGroup;
    this.zUo = paramah;
    dUI();
    dUJ();
    ae.i("AdLandingFullScreenFloatBarComp", "refreshView, cid=" + paramah.zRg + ", hash=" + hashCode());
    AppMethodBeat.o(219415);
  }
  
  private static af eal()
  {
    AppMethodBeat.i(219422);
    if (ad.zAi != null)
    {
      localaf = ad.zAi;
      AppMethodBeat.o(219422);
      return localaf;
    }
    af localaf = new af();
    AppMethodBeat.o(219422);
    return localaf;
  }
  
  protected final void W(boolean paramBoolean)
  {
    AppMethodBeat.i(219419);
    if (this.mContentView.getVisibility() != 0)
    {
      this.mContentView.setVisibility(0);
      dUK();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.5F, 1, 0.0F);
        localTranslateAnimation.setInterpolator(new OvershootInterpolator(1.0F));
        localTranslateAnimation.setDuration(700L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(219419);
  }
  
  protected final void X(boolean paramBoolean)
  {
    AppMethodBeat.i(219421);
    if (this.mContentView.getVisibility() == 0)
    {
      this.mContentView.setVisibility(8);
      dUL();
      this.mContentView.clearAnimation();
      if (paramBoolean)
      {
        TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.5F);
        localTranslateAnimation.setDuration(400L);
        this.mContentView.startAnimation(localTranslateAnimation);
      }
    }
    AppMethodBeat.o(219421);
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(219416);
    View localView = LayoutInflater.from(this.mContext).inflate(2131496426, this.zTL, false);
    this.mContentView = localView;
    this.zTI = ((TextView)localView.findViewById(2131300136));
    this.zTJ = ((FrameLayout)localView.findViewById(2131300135));
    this.zUp = ((RoundedCornerFrameLayout)localView.findViewById(2131300132));
    this.zUp.setRadius(0.0F);
    this.zTL.addView(this.mContentView);
    this.mContentView.setVisibility(8);
    AppMethodBeat.o(219416);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(219417);
    if (!TextUtils.isEmpty(this.zUo.desc))
    {
      this.zTI.setText(this.zUo.desc);
      this.zTI.setVisibility(0);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.zUo.zRw)) {}
      try
      {
        this.zTI.setTextColor(Color.parseColor(this.zUo.zRw));
        this.zTJ.removeAllViews();
        Object localObject = av.a(this.mContext, this.zUo.zRB, this.zTJ, 0);
        if ((localObject instanceof p))
        {
          this.zTM = ((p)localObject);
          this.zTM.a(this.zUo.zRB, eal());
          if (this.zTM != null)
          {
            localObject = this.zTM.getView();
            this.zTJ.addView((View)localObject);
          }
          this.zTN = this.zUo.zRx;
          this.mContentView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(219412);
              b localb = new b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (!g.this.zTN)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(219412);
                return;
              }
              paramAnonymousView = g.this;
              paramAnonymousView.clickCount += 1;
              if (g.this.zTM != null) {
                paramAnonymousView = null;
              }
              for (;;)
              {
                try
                {
                  if ((g.this.zTM instanceof q))
                  {
                    paramAnonymousView = ((q)g.this.zTM).zVi;
                    if (paramAnonymousView != null)
                    {
                      paramAnonymousView.performClick();
                      i = g.this.zTM.clickCount;
                      ae.i("AdLandingFullScreenFloatBarComp", "onClick, clickCount=" + g.this.clickCount + ", btnClickCount=" + i);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingFullScreenFloatBarComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(219412);
                    }
                  }
                  else
                  {
                    if (!(g.this.zTM instanceof s)) {
                      continue;
                    }
                    paramAnonymousView = ((s)g.this.zTM).zVu;
                    continue;
                  }
                  ae.e("AdLandingFullScreenFloatBarComp", "onClick noBtn found, comp=" + g.this.zTM);
                  continue;
                  int i = 0;
                }
                catch (Exception paramAnonymousView)
                {
                  ae.e("AdLandingFullScreenFloatBarComp", "onClick exp=" + paramAnonymousView.toString());
                }
              }
            }
          });
          AppMethodBeat.o(219417);
          return;
          this.zTI.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("AdLandingFullScreenFloatBarComp", "refreshView descColor, exp=" + localException.toString() + ", color=" + this.zUo.zRw);
          continue;
          ae.e("AdLandingFullScreenFloatBarComp", "btnComp=".concat(String.valueOf(localException)));
        }
      }
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(219423);
    super.dUK();
    if (this.zTM != null) {
      this.zTM.dUK();
    }
    ae.i("AdLandingFullScreenFloatBarComp", "viewWillAppear");
    AppMethodBeat.o(219423);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(219424);
    super.dUL();
    if (this.zTM != null)
    {
      this.zTM.dUL();
      ae.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, mBtnComponent exposureCount = " + this.zTM.zUQ + ", mBtnComponent stayTime = " + this.zTM.dCI + ", mBtnComponent cid = " + this.zTM.eaz());
    }
    ae.i("AdLandingFullScreenFloatBarComp", "viewWillDisappear, exposureCount = " + this.zUQ + ", stayTime = " + this.dCI);
    AppMethodBeat.o(219424);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(219425);
    super.dUM();
    if (this.zTM != null)
    {
      this.zTM.dUM();
      ae.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy, mBtnComponent exposureCount = " + this.zTM.zUQ + ", mBtnComponent stayTime = " + this.zTM.dCI + ", mBtnComponent cid = " + this.zTM.eaz());
    }
    this.mHandler.removeCallbacksAndMessages(null);
    ae.i("AdLandingFullScreenFloatBarComp", "viewWillDestroy");
    AppMethodBeat.o(219425);
  }
  
  public final void eak()
  {
    AppMethodBeat.i(219418);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(1, Boolean.TRUE);
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(219418);
  }
  
  public final void eam()
  {
    AppMethodBeat.i(219426);
    int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 44);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
    }
    if ((this.zTJ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)this.zTJ.getLayoutParams()).leftMargin = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 24);
    }
    AppMethodBeat.o(219426);
  }
  
  public final void ean()
  {
    AppMethodBeat.i(219427);
    if ((this.mContentView.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mContentView.getLayoutParams();
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = 0;
    }
    AppMethodBeat.o(219427);
  }
  
  public final String eao()
  {
    AppMethodBeat.i(219428);
    try
    {
      Object localObject = this.zTM;
      if (localObject != null)
      {
        if (this.zTM != null)
        {
          this.zTM.clickCount -= this.clickCount;
          ae.i("AdLandingFullScreenFloatBarComp", "btn kv, clickCount=" + this.zTM.clickCount + ", stayTime=" + this.zTM.dCI);
        }
        localObject = new g.a(this.zUQ, this.dCI, this.clickCount, ((p)localObject).eaz(), ((m)localObject).zUQ, ((m)localObject).dCI, ((p)localObject).clickCount).zUr.toString();
        AppMethodBeat.o(219428);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      ae.e("AdLandingFullScreenFloatBarComp", localThrowable.toString());
      AppMethodBeat.o(219428);
    }
    return "";
  }
  
  public final void rJ(boolean paramBoolean)
  {
    AppMethodBeat.i(219420);
    this.mHandler.removeCallbacksAndMessages(null);
    Message localMessage = this.mHandler.obtainMessage(2, Boolean.valueOf(paramBoolean));
    this.mHandler.sendMessageDelayed(localMessage, 0L);
    AppMethodBeat.o(219420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g
 * JD-Core Version:    0.7.0.1
 */