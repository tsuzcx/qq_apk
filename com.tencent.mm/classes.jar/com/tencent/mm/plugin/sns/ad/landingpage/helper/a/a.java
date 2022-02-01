package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.b.a;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCardAnimView;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCardAnimView.1;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCardAnimView.5;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCardAnimView.a;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.2;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.3;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.4;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.a;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.libpag.PAGView;

public final class a
{
  public SnsAdNativeLandingPagesUI JCQ;
  public TwistRoateCardsView JCR;
  public ADXml.k JCS;
  public boolean JCT = false;
  public boolean JCU = false;
  public boolean JCV = false;
  View JCW;
  com.tencent.mm.plugin.sns.ad.landingpage.component.a.b JCX;
  public String JCY = "";
  String JCZ = "";
  public ShakeCardAnimView JDa;
  public boolean JDb = false;
  public com.tencent.mm.plugin.sns.ad.widget.shakead.a JDc;
  public boolean JDd = false;
  public boolean JDe = false;
  public View JDf;
  public View JDg;
  public View JDh;
  public View JDi;
  
  public a(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI)
  {
    this.JCQ = paramSnsAdNativeLandingPagesUI;
  }
  
  private void b(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(199060);
    if (this.JCX == null)
    {
      paramContentFragment = paramContentFragment.fRQ().iterator();
      while (paramContentFragment.hasNext())
      {
        com.tencent.mm.plugin.sns.ad.landingpage.component.a.b localb = com.tencent.mm.plugin.sns.ad.landingpage.component.a.b.b((m)paramContentFragment.next());
        if (localb != null)
        {
          this.JCX = localb;
          AppMethodBeat.o(199060);
          return;
        }
      }
    }
    AppMethodBeat.o(199060);
  }
  
  private void fKE()
  {
    AppMethodBeat.i(199064);
    try
    {
      int i = this.JCQ.fRp().source;
      String str1 = Util.nullAsNil(this.JCQ.fRp().uxInfo);
      String str2 = Util.nullAsNil(this.JCQ.KLz);
      String str3 = Util.nullAsNil(this.JCQ.fRp().owd);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "start reqTwistCardId, source=" + i + ", rawSnsId=" + str2 + ", canvasId=" + str3 + ", uxInfo=" + str1);
      final long l = System.currentTimeMillis();
      AdLandingPagesProxy.getInstance().getTwistAdCard(str1, str2, i, str3, "", new AdLandingPagesProxy.e()
      {
        public final void aH(Object paramAnonymousObject) {}
        
        public final void i(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          int i = 0;
          AppMethodBeat.i(268282);
          Object localObject = f.j(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          String str = ((Bundle)localObject).getString("card_id", "");
          localObject = ((Bundle)localObject).getString("card_ext_info", "");
          a.this.JCY = str;
          a.this.JCZ = ((String)localObject);
          long l = System.currentTimeMillis() - l;
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "reqTwistCardId rsp, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", cardId=" + str + ", timeCost=" + l + ", extInfo=" + (String)localObject);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousObject != null)) {
            paramAnonymousInt1 = 1;
          }
          try
          {
            str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            if (a.this.JDb)
            {
              paramAnonymousObject = "1";
              label161:
              localObject = l.JQP;
              paramAnonymousInt2 = (int)l;
              if (paramAnonymousInt1 == 0) {
                break label204;
              }
            }
            label204:
            for (paramAnonymousInt1 = i;; paramAnonymousInt1 = 1)
            {
              l.a((String)localObject, str, paramAnonymousInt2, paramAnonymousInt1, paramAnonymousObject);
              AppMethodBeat.o(268282);
              return;
              paramAnonymousInt1 = 0;
              break;
              paramAnonymousObject = "";
              break label161;
            }
            return;
          }
          catch (Throwable paramAnonymousObject)
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "reqTwistCardId exp=" + paramAnonymousObject.toString());
            AppMethodBeat.o(268282);
          }
        }
      });
      AppMethodBeat.o(199064);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "reqTwistCardId, exp=" + localThrowable.toString());
      AppMethodBeat.o(199064);
    }
  }
  
  public final boolean a(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(199059);
    int i;
    if (this.JCT)
    {
      Object localObject1;
      if (this.JCU)
      {
        this.JDg.setVisibility(8);
        localObject1 = ObjectAnimator.ofFloat(this.JDh, "alpha", new float[] { 0.0F, 1.0F });
        ((ObjectAnimator)localObject1).setDuration(1000L);
        ((ObjectAnimator)localObject1).start();
      }
      if (this.JCR == null)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "tryPlayTwistAdAnimation, TwistAdCardView==null");
        AppMethodBeat.o(199059);
        return false;
      }
      b(paramContentFragment);
      if ((this.JCX != null) && (this.JCS != null))
      {
        if (TextUtils.isEmpty(this.JCY)) {
          fKE();
        }
        for (;;)
        {
          if (this.JCQ.isSupportNavigationSwipeBack())
          {
            this.JCQ.getSwipeBackLayout().setEnableGesture(false);
            this.JCQ.getSwipeBackLayout().Hp(true);
          }
          if (this.JCU) {
            this.JCX.getContentView().setVisibility(4);
          }
          this.JCR.setVisibility(0);
          this.JCR.setOnCardAnimListener(new TwistRoateCardsView.a()
          {
            public final void fKF()
            {
              AppMethodBeat.i(210890);
              if (a.this.JCQ.isSupportNavigationSwipeBack()) {
                a.this.JCQ.getSwipeBackLayout().setEnableGesture(true);
              }
              a.this.JCQ.fVq();
              a.this.JCQ.fUZ();
              a.this.JCR.setVisibility(8);
              if (a.this.JCX != null) {
                a.this.JCX.fKn();
              }
              AppMethodBeat.o(210890);
            }
            
            public final void fKG()
            {
              AppMethodBeat.i(210891);
              String str = a.this.JCY;
              com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "onPrepareCard, twistId=".concat(String.valueOf(str)));
              a.this.JCX.km(str, "");
              try
              {
                if (TextUtils.isEmpty(str))
                {
                  TwistCoverView.b(a.this.JCQ.fRp(), 2);
                  h.IzE.el(1572, 8);
                }
                for (;;)
                {
                  a.this.JCW = com.tencent.mm.plugin.sns.ad.landingpage.component.a.b.a(a.this.JCX);
                  if (a.this.JCW == null) {
                    break;
                  }
                  a.this.JCR.setAnimCardView(a.this.JCW);
                  AppMethodBeat.o(210891);
                  return;
                  TwistCoverView.b(a.this.JCQ.fRp(), 1);
                  h.IzE.el(1572, 7);
                }
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "twist report exp=" + localThrowable.toString());
                }
                com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "mTwistCardAnimView==null");
                AppMethodBeat.o(210891);
              }
            }
            
            public final void fKH()
            {
              AppMethodBeat.i(210889);
              if (!a.this.JCU)
              {
                localObjectAnimator = ObjectAnimator.ofFloat(a.this.JDh, "alpha", new float[] { 0.0F, 1.0F });
                localObjectAnimator.setDuration(500L);
                localObjectAnimator.start();
                localObjectAnimator = ObjectAnimator.ofFloat(a.this.JDg, "alpha", new float[] { a.this.JDg.getAlpha(), 0.0F });
                localObjectAnimator.setDuration(300L);
                localObjectAnimator.start();
              }
              a.this.JDi.setVisibility(0);
              ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a.this.JDi, "alpha", new float[] { 0.0F, 1.0F });
              localObjectAnimator.setDuration(500L);
              localObjectAnimator.start();
              a.this.JCX.getContentView().setVisibility(0);
              AppMethodBeat.o(210889);
            }
          });
          localObject1 = this.JCX.fKh();
          paramContentFragment = this.JCR;
          i = ((Integer)((Pair)localObject1).first).intValue();
          int j = ((Integer)((Pair)localObject1).second).intValue();
          boolean bool = this.JCS.Kke;
          localObject1 = this.JCX.JAf.JBF;
          Object localObject3 = this.JCX.JAf.JBG;
          org.xwalk.core.Log.i("TwistRoateCardsView", "initData, defBgColor=" + (String)localObject3 + ", imgUrl=" + (String)localObject1);
          paramContentFragment.JOT = ((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
          try
          {
            paramContentFragment.JOU = Color.parseColor((String)localObject3);
            if ((i <= 0) || (j <= 0))
            {
              org.xwalk.core.Log.e("TwistRoateCardsView", "initData, size is 0, w=" + i + ", h=" + j);
              paramContentFragment.JNB = com.tencent.mm.ci.a.fromDPToPix(paramContentFragment.mContext, 221);
              paramContentFragment.JNC = com.tencent.mm.ci.a.fromDPToPix(paramContentFragment.mContext, 375);
              paramContentFragment.JON = (com.tencent.mm.ci.a.fromDPToPix(paramContentFragment.mContext, 200) + paramContentFragment.JNC / 2);
              paramContentFragment.JzI = bool;
              if (!paramContentFragment.JzI) {
                break label694;
              }
              paramContentFragment.JOS = 3;
              paramContentFragment.removeAllViews();
              paramContentFragment.fMK();
              paramContentFragment = this.JCR;
              localObject1 = ObjectAnimator.ofFloat(paramContentFragment, "alpha", new float[] { 0.0F, 1.0F });
              ((ObjectAnimator)localObject1).setDuration(1500L);
              if (!paramContentFragment.JzI) {
                break label703;
              }
              f = -180.0F;
              localObject3 = ValueAnimator.ofFloat(new float[] { f, 0.0F });
              ((ValueAnimator)localObject3).setDuration(1500L);
              ((ValueAnimator)localObject3).addUpdateListener(new TwistRoateCardsView.2(paramContentFragment));
              ((ValueAnimator)localObject3).addListener(new TwistRoateCardsView.3(paramContentFragment));
              ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.3F, 1.0F });
              localValueAnimator.setDuration(1500L);
              localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
              localValueAnimator.addUpdateListener(new TwistRoateCardsView.4(paramContentFragment));
              ((ValueAnimator)localObject3).start();
              localValueAnimator.start();
              ((ObjectAnimator)localObject1).start();
              AppMethodBeat.o(199059);
              return true;
              com.tencent.mm.sdk.platformtools.Log.w("AdLandingPageEggCardHelper", "skip reqTwistCardId, twistCardId=" + this.JCY);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              org.xwalk.core.Log.e("TwistRoateCardsView", "parseColor exp=" + localException.toString());
              continue;
              paramContentFragment.JNB = ((int)(i * 0.75F));
              paramContentFragment.JNC = ((int)(j * 0.75F));
              continue;
              label694:
              paramContentFragment.JOS = 9;
              continue;
              label703:
              float f = 180.0F;
            }
          }
        }
      }
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "mEggCardComponent==null");
      AppMethodBeat.o(199059);
      return false;
    }
    if (this.JDb)
    {
      Object localObject2;
      if (this.JDe)
      {
        this.JDg.setVisibility(8);
        localObject2 = ObjectAnimator.ofFloat(this.JDh, "alpha", new float[] { 0.0F, 1.0F });
        ((ObjectAnimator)localObject2).setDuration(1000L);
        ((ObjectAnimator)localObject2).start();
      }
      if (this.JDa == null) {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "tryPlayShakeAdAnimation, ShakeAdCardView==null");
      }
      do
      {
        do
        {
          AppMethodBeat.o(199059);
          return false;
          b(paramContentFragment);
        } while (this.JCX == null);
        localObject2 = this.JCX.JAf.JBH;
      } while (localObject2 == null);
      if (TextUtils.isEmpty(this.JCY)) {
        fKE();
      }
      if (this.JCQ.isSupportNavigationSwipeBack())
      {
        this.JCQ.getSwipeBackLayout().setEnableGesture(false);
        this.JCQ.getSwipeBackLayout().Hp(true);
      }
      this.JDa.setVisibility(0);
      paramContentFragment = this.JDa;
      if (localObject2 == null) {
        org.xwalk.core.Log.e("ShakeCardAnimView", "initData, ShakeCardInfo==null");
      }
      for (;;)
      {
        this.JDa.fMv();
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213953);
            if (!a.this.JDe)
            {
              localObject1 = ObjectAnimator.ofFloat(a.this.JDh, "alpha", new float[] { 0.0F, 1.0F });
              ((ObjectAnimator)localObject1).setDuration(200L);
              ((ObjectAnimator)localObject1).start();
            }
            Object localObject1 = a.this.JDa;
            int i = com.tencent.mm.ci.a.fromDPToPix(((ShakeCardAnimView)localObject1).mContext, 140);
            Object localObject2 = ((ShakeCardAnimView)localObject1).getChildAt(0);
            Object localObject3 = ((ShakeCardAnimView)localObject1).getChildAt(4);
            ((ShakeCardAnimView)localObject1).w((View)localObject2, 0, -i);
            ((ShakeCardAnimView)localObject1).w((View)localObject3, 0, i);
            Object localObject4 = ((ShakeCardAnimView)localObject1).getChildAt(2);
            ((ShakeCardAnimView)localObject1).JNG = ((View)localObject4);
            if (((ShakeCardAnimView)localObject1).JNJ != null)
            {
              org.xwalk.core.Log.i("ShakeCardAnimView", "onPrepareCard");
              ((ShakeCardAnimView)localObject1).JNJ.fKG();
            }
            if (((ShakeCardAnimView)localObject1).JNF == null) {
              org.xwalk.core.Log.e("ShakeCardAnimView", "playMainCardAnim, targetView==null");
            }
            for (;;)
            {
              localObject2 = ((ShakeCardAnimView)localObject1).getChildAt(1);
              localObject3 = ((ShakeCardAnimView)localObject1).getChildAt(3);
              ((ShakeCardAnimView)localObject1).w((View)localObject2, 50, -i);
              ((ShakeCardAnimView)localObject1).w((View)localObject3, 50, i);
              AppMethodBeat.o(213953);
              return;
              localObject2 = ObjectAnimator.ofFloat(localObject4, "translationY", new float[] { 0.0F, ((ShakeCardAnimView)localObject1).getHeight() / 2 + ((ShakeCardAnimView)localObject1).JNC / 2 + ((ShakeCardAnimView)localObject1).JNE });
              ((ObjectAnimator)localObject2).setDuration(500L);
              localObject3 = ObjectAnimator.ofFloat(localObject4, "scaleX", new float[] { 1.0F, 3.0F });
              ((ObjectAnimator)localObject3).setDuration(500L);
              ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject4, "scaleY", new float[] { 1.0F, 3.0F });
              localObjectAnimator1.setDuration(500L);
              ((ObjectAnimator)localObject2).addListener(new ShakeCardAnimView.5((ShakeCardAnimView)localObject1));
              ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject4, "scaleX", new float[] { 3.0F, 10.0F });
              localObjectAnimator2.setDuration(500L);
              localObject4 = ObjectAnimator.ofFloat(localObject4, "scaleY", new float[] { 3.0F, 10.0F });
              ((ObjectAnimator)localObject4).setDuration(500L);
              ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(((ShakeCardAnimView)localObject1).JNF, "scaleX", new float[] { 0.333F, 1.0F });
              localObjectAnimator3.setDuration(500L);
              ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(((ShakeCardAnimView)localObject1).JNF, "scaleY", new float[] { 0.333F, 1.0F });
              localObjectAnimator4.setDuration(500L);
              AnimatorSet localAnimatorSet = new AnimatorSet();
              localAnimatorSet.playTogether(new Animator[] { localObject2, localObject3, localObjectAnimator1 });
              localAnimatorSet.play(localObjectAnimator2).with((Animator)localObject4).with(localObjectAnimator3).with(localObjectAnimator4).after((Animator)localObject3);
              localAnimatorSet.setStartDelay(100L);
              localAnimatorSet.start();
            }
          }
        }, 1300L);
        this.JDa.setOnCardAnimListener(new ShakeCardAnimView.a()
        {
          public final void fKF()
          {
            AppMethodBeat.i(193766);
            if (a.this.JCQ.isSupportNavigationSwipeBack()) {
              a.this.JCQ.getSwipeBackLayout().setEnableGesture(true);
            }
            a.this.JDi.setVisibility(0);
            ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a.this.JDi, "alpha", new float[] { 0.0F, 1.0F });
            localObjectAnimator.setDuration(500L);
            localObjectAnimator.start();
            a.this.JCQ.fVq();
            a.this.JCQ.fUZ();
            if (a.this.JCX != null) {
              a.this.JCX.fKn();
            }
            AppMethodBeat.o(193766);
          }
          
          public final void fKG()
          {
            AppMethodBeat.i(193768);
            String str1 = a.this.JCY;
            String str2 = a.this.JCZ;
            com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "onPrepareCard, shakeCardId=" + str1 + ", ext=" + str2);
            try
            {
              if (TextUtils.isEmpty(str1))
              {
                ShakeCoverView.a(a.this.JCQ.fRp(), 2);
                h.IzE.el(1572, 6);
              }
              for (;;)
              {
                if (a.this.JCX == null) {
                  break label255;
                }
                a.this.JCX.km(str1, str2);
                a.this.JCW = com.tencent.mm.plugin.sns.ad.landingpage.component.a.b.a(a.this.JCX);
                com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "findAnimCardView, view=" + a.this.JCW);
                if (a.this.JCW == null) {
                  break;
                }
                a.this.JCW.setAlpha(0.0F);
                a.this.JDa.setAnimCardView(a.this.JCW);
                AppMethodBeat.o(193768);
                return;
                ShakeCoverView.a(a.this.JCQ.fRp(), 1);
                h.IzE.el(1572, 5);
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "shake report exp=" + localThrowable.toString());
              }
              com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "mShakeCardAnimView==null");
              label255:
              AppMethodBeat.o(193768);
            }
          }
        });
        AppMethodBeat.o(199059);
        return true;
        paramContentFragment.JNI = ((b.a)localObject2);
        if ((paramContentFragment.JNI.JBI == null) || (paramContentFragment.JNI.JBI.size() != 5))
        {
          localObject2 = new StringBuilder("initData, cardItem.size=");
          if (paramContentFragment.JNI.JBI == null) {}
          for (i = 0;; i = paramContentFragment.JNI.JBI.size())
          {
            org.xwalk.core.Log.e("ShakeCardAnimView", i);
            break;
          }
        }
        paramContentFragment.bb(ShakeCardAnimView.bc(paramContentFragment.JNI.JBI));
        paramContentFragment.JND.post(new ShakeCardAnimView.1(paramContentFragment));
      }
    }
    AppMethodBeat.o(199059);
    return false;
  }
  
  public final boolean fKD()
  {
    AppMethodBeat.i(199050);
    ObjectAnimator localObjectAnimator;
    if (this.JCT)
    {
      this.JDf.setVisibility(8);
      if (!this.JCU)
      {
        localObjectAnimator = ObjectAnimator.ofFloat(this.JDg, "alpha", new float[] { 0.0F, 0.2F });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.start();
        this.JDh.setAlpha(0.0F);
      }
      com.tencent.mm.ui.base.b.a(this.JCQ, null);
      AppMethodBeat.o(199050);
      return true;
    }
    if (this.JDb)
    {
      this.JDf.setVisibility(8);
      if (!this.JDe)
      {
        localObjectAnimator = ObjectAnimator.ofFloat(this.JDg, "alpha", new float[] { 0.0F, 0.2F });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.start();
        this.JDh.setAlpha(0.0F);
      }
      com.tencent.mm.ui.base.b.a(this.JCQ, null);
      AppMethodBeat.o(199050);
      return true;
    }
    AppMethodBeat.o(199050);
    return false;
  }
  
  public final void gEo()
  {
    AppMethodBeat.i(292751);
    try
    {
      if (this.JDa == null)
      {
        ViewStub localViewStub = (ViewStub)this.JCQ.findViewById(i.f.shake_card_layout_stub);
        if (localViewStub != null) {
          this.JDa = ((ShakeCardAnimView)localViewStub.inflate());
        }
      }
      AppMethodBeat.o(292751);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "inflateShakeCardView, exp=" + localThrowable.toString());
      AppMethodBeat.o(292751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a
 * JD-Core Version:    0.7.0.1
 */