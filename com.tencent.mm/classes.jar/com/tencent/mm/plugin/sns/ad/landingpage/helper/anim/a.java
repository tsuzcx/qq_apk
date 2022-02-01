package com.tencent.mm.plugin.sns.ad.landingpage.helper.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xu;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.adxml.d;
import com.tencent.mm.plugin.sns.ad.adxml.d.b;
import com.tencent.mm.plugin.sns.ad.adxml.d.c;
import com.tencent.mm.plugin.sns.ad.adxml.d.e;
import com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatJumpCompHelper;
import com.tencent.mm.plugin.sns.ad.widget.gllib.e;
import com.tencent.mm.plugin.sns.ad.widget.shakead.CardAnimView;
import com.tencent.mm.plugin.sns.ad.widget.shakead.GLCardAnimView;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCardAnimView;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCardAnimView.a;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.GLTwistRoateCardsView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.GLTwistRoateCardsView.1;
import com.tencent.mm.plugin.sns.ad.widget.twistad.GLTwistRoateCardsView.a;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistRoateCardsView.a;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;

public final class a
{
  public static int PUb = 1;
  public Handler PRJ;
  public SnsAdNativeLandingPagesUI PTA;
  public TwistRoateCardsView PTB;
  public GLTwistRoateCardsView PTC;
  public boolean PTD;
  public boolean PTE;
  private View PTF;
  public com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b PTG;
  public String PTH;
  private String PTI;
  private ShakeCardAnimView PTJ;
  public boolean PTK;
  public boolean PTL;
  public SnsAdSphereAnimView PTM;
  public boolean PTN;
  private Bitmap PTO;
  public View PTP;
  public View PTQ;
  public View PTR;
  public View PTS;
  public boolean PTT;
  public d PTU;
  public boolean PTV;
  public boolean PTW;
  public boolean PTX;
  public com.tencent.mm.plugin.sns.ad.d.a.c PTY;
  private AnimatorSet PTZ;
  private ObjectAnimator PUa;
  public IListener<xu> PUc;
  public int xOq;
  
  public a(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI)
  {
    AppMethodBeat.i(310945);
    this.PTD = false;
    this.PTE = false;
    this.PTH = "";
    this.PTI = "";
    this.PTK = false;
    this.PTL = false;
    this.PTN = false;
    this.PTT = false;
    this.PUc = new AdLandingPageEggCardHelper.13(this, com.tencent.mm.app.f.hfK);
    this.PRJ = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(310967);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(310967);
          return;
          a.a(a.this, new com.tencent.mm.plugin.sns.ad.widget.b()
          {
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(310882);
              a.h(a.this).sendEmptyMessageDelayed(2, 2000L);
              AppMethodBeat.o(310882);
            }
          });
          AppMethodBeat.o(310967);
          return;
          a.a(a.this, new com.tencent.mm.plugin.sns.ad.widget.b()
          {
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(310886);
              a.h(a.this).sendEmptyMessageDelayed(3, 1000L);
              AppMethodBeat.o(310886);
            }
          });
          AppMethodBeat.o(310967);
          return;
          a.g(a.this).hah();
          a.a(a.this, true);
        }
      }
    };
    this.PTA = paramSnsAdNativeLandingPagesUI;
    AppMethodBeat.o(310945);
  }
  
  private boolean a(ContentFragment paramContentFragment, final boolean paramBoolean)
  {
    AppMethodBeat.i(310975);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "tryPlayShakeAdAnimation, isFromEncoreShake=".concat(String.valueOf(paramBoolean)));
    if (this.PTJ == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "tryPlayShakeAdAnimation, ShakeAdCardView==null");
      AppMethodBeat.o(310975);
      return false;
    }
    b(paramContentFragment);
    if (this.PTG != null)
    {
      paramContentFragment = this.PTG.PPG.PMk;
      if ((paramContentFragment == null) && (this.PTU.PMk == null))
      {
        AppMethodBeat.o(310975);
        return false;
      }
      if (this.PTU.PMk == null) {
        this.PTU.PMk = paramContentFragment;
      }
      if ((TextUtils.isEmpty(this.PTH)) && (!paramBoolean)) {
        haR();
      }
      if (this.PTA.isSupportNavigationSwipeBack())
      {
        this.PTA.getSwipeBackLayout().setEnableGesture(false);
        this.PTA.getSwipeBackLayout().Nl(true);
      }
      if (!paramBoolean)
      {
        this.PTJ.setVisibility(0);
        this.PTJ.a(this.PTU.PMk);
        this.PTJ.hdw();
        com.tencent.threadpool.h.ahAA.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310919);
            if (!a.e(a.this))
            {
              ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a.b(a.this), "alpha", new float[] { 0.0F, 1.0F });
              localObjectAnimator.setDuration(200L);
              localObjectAnimator.start();
            }
            a.f(a.this).hds();
            AppMethodBeat.o(310919);
          }
        }, 1300L);
      }
      for (;;)
      {
        this.PTJ.setOnCardAnimListener(new ShakeCardAnimView.a()
        {
          public final void haT()
          {
            AppMethodBeat.i(310926);
            boolean bool = a.f(a.this).Qix;
            com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "onEndFlip, isPagAniming=".concat(String.valueOf(bool)));
            if (a.a(a.this).isSupportNavigationSwipeBack()) {
              a.a(a.this).getSwipeBackLayout().setEnableGesture(true);
            }
            a.c(a.this).setVisibility(0);
            if (!paramBoolean)
            {
              ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a.c(a.this), "alpha", new float[] { 0.0F, 1.0F });
              localObjectAnimator.setDuration(500L);
              localObjectAnimator.start();
            }
            if (!paramBoolean)
            {
              a.a(a.this).hnG();
              a.a(a.this).hnq();
              if (bool) {}
            }
            else
            {
              a.f(a.this).setVisibility(8);
            }
            if (a.g(a.this) != null)
            {
              a.g(a.this).har();
              if (!a.g(a.this).haf()) {
                break label281;
              }
              a.g(a.this).Dm(true);
              a.g(a.this).hag();
              a.h(a.this).removeCallbacksAndMessages(null);
              if (!a.g(a.this).PPN) {
                break label263;
              }
              a.h(a.this).sendEmptyMessageDelayed(3, 7000L);
            }
            for (;;)
            {
              a.g(a.this).hae();
              AppMethodBeat.o(310926);
              return;
              label263:
              a.h(a.this).sendEmptyMessageDelayed(1, 3000L);
              continue;
              label281:
              a.a(a.this, true);
            }
          }
          
          public final void haU()
          {
            AppMethodBeat.i(310933);
            ShakeCardAnimView localShakeCardAnimView = a.f(a.this);
            if (localShakeCardAnimView.Qiw) {}
            for (boolean bool = localShakeCardAnimView.Qiv.Qii;; bool = localShakeCardAnimView.Qiu.Qii)
            {
              com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "onPagAnimEnd, isCardAniming=".concat(String.valueOf(bool)));
              if (!bool) {
                a.f(a.this).setVisibility(8);
              }
              AppMethodBeat.o(310933);
              return;
            }
          }
          
          public final void haV()
          {
            AppMethodBeat.i(310946);
            String str1 = a.i(a.this);
            String str2 = a.j(a.this);
            com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "onPrepareCard, shakeCardId=" + str1 + ", ext=" + str2);
            try
            {
              if (TextUtils.isEmpty(str1))
              {
                ShakeCoverView.a(a.a(a.this).hjn(), 2, paramBoolean);
                if (paramBoolean) {
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 14);
                }
                for (;;)
                {
                  if (a.g(a.this) == null) {
                    break label311;
                  }
                  a.g(a.this).lM(str1, str2);
                  a.a(a.this, com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b.b(a.g(a.this).PPL));
                  com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "findAnimCardView, view=" + a.k(a.this));
                  if (a.k(a.this) == null) {
                    break;
                  }
                  a.k(a.this).setAlpha(0.0F);
                  a.f(a.this).setAnimCardView(a.k(a.this));
                  AppMethodBeat.o(310946);
                  return;
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 6);
                }
              }
            }
            finally
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "shake report exp=" + localObject.toString());
                continue;
                ShakeCoverView.a(a.a(a.this).hjn(), 1, paramBoolean);
                if (paramBoolean) {
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 13);
                } else {
                  com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 5);
                }
              }
              com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "mShakeCardAnimView==null");
              label311:
              AppMethodBeat.o(310946);
            }
          }
        });
        AppMethodBeat.o(310975);
        return true;
        this.PTJ.setVisibility(0);
        this.PTJ.eow();
        this.PTJ.hds();
      }
    }
    com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "tryPlayShakeAdAnimation, mEggCardComponent==null");
    AppMethodBeat.o(310975);
    return false;
  }
  
  private void aT(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(311034);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "setFloatJumpCompVisible, visible=" + paramBoolean1 + ", withAnim=" + paramBoolean2);
    try
    {
      if (this.PTA == null)
      {
        com.tencent.mm.sdk.platformtools.Log.w("AdLandingPageEggCardHelper", "setFloatJumpCompVisible, mLandingPagesUI==null");
        AppMethodBeat.o(311034);
        return;
      }
      Object localObject1 = this.PTA.Rms;
      if (localObject1 == null) {
        break label361;
      }
      localObject1 = ((FloatJumpCompHelper)localObject1).haY();
      if (localObject1 == null) {
        break label346;
      }
      if ((localObject1 instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.comp.f)) {
        if (!paramBoolean1) {
          break label140;
        }
      }
      label140:
      for (((com.tencent.mm.plugin.sns.ad.landingpage.component.comp.f)localObject1).PQp = true;; ((com.tencent.mm.plugin.sns.ad.landingpage.component.comp.f)localObject1).PQp = false)
      {
        localObject1 = ((n)localObject1).getContentView();
        if (localObject1 == null) {
          break label331;
        }
        if (paramBoolean1) {
          break label262;
        }
        i = ((View)localObject1).getVisibility();
        if (i == 0) {
          break;
        }
        AppMethodBeat.o(311034);
        return;
      }
      if (!paramBoolean2) {
        break label248;
      }
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "setFloatJumpCompVisible exp=" + localObject2.toString());
      AppMethodBeat.o(311034);
      return;
    }
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator2.addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310953);
        localObject2.setVisibility(8);
        AppMethodBeat.o(310953);
      }
    });
    localObjectAnimator2.setDuration(400L);
    localObjectAnimator2.start();
    AppMethodBeat.o(311034);
    return;
    label248:
    localObject2.setVisibility(8);
    AppMethodBeat.o(311034);
    return;
    label262:
    int i = localObject2.getVisibility();
    if (i == 0)
    {
      AppMethodBeat.o(311034);
      return;
    }
    localObject2.setVisibility(0);
    if (paramBoolean2)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator1.setDuration(400L);
      localObjectAnimator1.start();
      AppMethodBeat.o(311034);
      return;
      label331:
      com.tencent.mm.sdk.platformtools.Log.w("AdLandingPageEggCardHelper", "setFloatJumpCompVisible, view==null");
    }
    AppMethodBeat.o(311034);
    return;
    label346:
    com.tencent.mm.sdk.platformtools.Log.w("AdLandingPageEggCardHelper", "setFloatJumpCompVisible, comp==null");
    AppMethodBeat.o(311034);
    return;
    label361:
    com.tencent.mm.sdk.platformtools.Log.w("AdLandingPageEggCardHelper", "setFloatJumpCompVisible, FloatJumpCompHelper==null");
    AppMethodBeat.o(311034);
  }
  
  private void b(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(310956);
    if (this.PTG == null)
    {
      paramContentFragment = paramContentFragment.hjV().iterator();
      while (paramContentFragment.hasNext())
      {
        com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b localb = com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b.c((n)paramContentFragment.next());
        if (localb != null)
        {
          this.PTG = localb;
          AppMethodBeat.o(310956);
          return;
        }
      }
    }
    AppMethodBeat.o(310956);
  }
  
  private boolean b(ContentFragment paramContentFragment, final boolean paramBoolean)
  {
    AppMethodBeat.i(311005);
    if (this.PTB == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "tryPlayTwistAdAnimation, TwistAdCardView==null");
      AppMethodBeat.o(311005);
      return false;
    }
    b(paramContentFragment);
    if (this.PTG != null)
    {
      paramContentFragment = this.PTG.PPG.PMi;
      if ((TextUtils.isEmpty(this.PTU.PMi.PMy)) && (paramContentFragment != null))
      {
        this.PTU.PMi.PMy = paramContentFragment.PMy;
        this.PTU.PMi.PMz = paramContentFragment.PMz;
      }
      if ((TextUtils.isEmpty(this.PTH)) && (!paramBoolean)) {
        haR();
      }
      for (;;)
      {
        if (this.PTA.isSupportNavigationSwipeBack())
        {
          this.PTA.getSwipeBackLayout().setEnableGesture(false);
          this.PTA.getSwipeBackLayout().Nl(true);
        }
        if (this.PTX) {
          this.PTG.getContentView().setVisibility(4);
        }
        this.PTB.setVisibility(0);
        this.PTB.setOnCardAnimListener(new TwistRoateCardsView.a()
        {
          public final void haT()
          {
            AppMethodBeat.i(310920);
            if (a.a(a.this).isSupportNavigationSwipeBack()) {
              a.a(a.this).getSwipeBackLayout().setEnableGesture(true);
            }
            a.a(a.this).hnG();
            a.a(a.this).hnq();
            a.m(a.this).setVisibility(8);
            if (a.g(a.this) != null)
            {
              a.g(a.this).har();
              if (!a.g(a.this).haf()) {
                break label191;
              }
              a.g(a.this).Dm(true);
              a.g(a.this).hag();
              a.h(a.this).removeCallbacksAndMessages(null);
              if (!a.g(a.this).PPN) {
                break label173;
              }
              a.h(a.this).sendEmptyMessageDelayed(3, 7000L);
            }
            for (;;)
            {
              a.g(a.this).hae();
              AppMethodBeat.o(310920);
              return;
              label173:
              a.h(a.this).sendEmptyMessageDelayed(1, 3000L);
              continue;
              label191:
              a.a(a.this, true);
            }
          }
          
          public final void haV()
          {
            AppMethodBeat.i(310935);
            String str3 = a.i(a.this);
            String str2 = a.j(a.this);
            String str1 = str2;
            if (a.n(a.this) == 5)
            {
              str1 = str2;
              if (a.o(a.this) != null) {
                str1 = a.o(a.this).gZZ();
              }
            }
            com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "onPrepareCard, twistId=" + str3 + ", ext=" + str1);
            a.g(a.this).lM(str3, str1);
            try
            {
              if (TextUtils.isEmpty(str3))
              {
                TwistCoverView.a(a.a(a.this).hjn(), 2);
                com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 8);
              }
              for (;;)
              {
                a.a(a.this, com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b.b(a.g(a.this).PPL));
                if (a.k(a.this) == null) {
                  break;
                }
                a.m(a.this).setAnimCardView(a.k(a.this));
                a.k(a.this).setAlpha(0.0F);
                AppMethodBeat.o(310935);
                return;
                TwistCoverView.a(a.a(a.this).hjn(), 1);
                com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 7);
              }
            }
            finally
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "twist report exp=" + localObject.toString());
              }
              com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "mTwistCardAnimView==null");
              AppMethodBeat.o(310935);
            }
          }
          
          public final void haW()
          {
            AppMethodBeat.i(310912);
            ObjectAnimator localObjectAnimator;
            if ((!a.e(a.this)) && (!paramBoolean))
            {
              localObjectAnimator = ObjectAnimator.ofFloat(a.b(a.this), "alpha", new float[] { 0.0F, 1.0F });
              localObjectAnimator.setDuration(500L);
              localObjectAnimator.start();
              localObjectAnimator = ObjectAnimator.ofFloat(a.l(a.this), "alpha", new float[] { a.l(a.this).getAlpha(), 0.0F });
              localObjectAnimator.setDuration(300L);
              localObjectAnimator.start();
            }
            if (!paramBoolean)
            {
              a.c(a.this).setVisibility(0);
              localObjectAnimator = ObjectAnimator.ofFloat(a.c(a.this), "alpha", new float[] { 0.0F, 1.0F });
              localObjectAnimator.setDuration(500L);
              localObjectAnimator.start();
            }
            a.g(a.this).getContentView().setVisibility(0);
            AppMethodBeat.o(310912);
          }
        });
        paramContentFragment = this.PTG.hak();
        this.PTB.a(((Integer)paramContentFragment.first).intValue(), ((Integer)paramContentFragment.second).intValue(), this.PTU.PMi.isClockwise, this.PTU.PMi.PMy, this.PTU.PMi.PMz);
        this.PTB.cKI();
        AppMethodBeat.o(311005);
        return true;
        com.tencent.mm.sdk.platformtools.Log.w("AdLandingPageEggCardHelper", "skip reqTwistCardId, twistCardId=" + this.PTH);
      }
    }
    com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "mEggCardComponent==null");
    AppMethodBeat.o(311005);
    return false;
  }
  
  public static boolean haQ()
  {
    AppMethodBeat.i(310988);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIx, 0);
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "isTwistAnimUseGL, exptValue=".concat(String.valueOf(i)));
        AppMethodBeat.o(310988);
        return bool;
      }
      return false;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "isTwistAnimUseGL, exp=" + localObject.toString());
      AppMethodBeat.o(310988);
    }
  }
  
  public final boolean a(ContentFragment paramContentFragment)
  {
    AppMethodBeat.i(311415);
    Object localObject;
    boolean bool;
    if (this.PTD)
    {
      if (this.PTX)
      {
        this.PTQ.setVisibility(8);
        localObject = ObjectAnimator.ofFloat(this.PTR, "alpha", new float[] { 0.0F, 1.0F });
        ((ObjectAnimator)localObject).setDuration(1000L);
        ((ObjectAnimator)localObject).start();
      }
      aT(false, false);
      if (this.PTT)
      {
        if (this.PTC == null)
        {
          com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "tryPlayGLTwistAdAnimation, TwistAdCardView==null");
          AppMethodBeat.o(311415);
          return false;
        }
        b(paramContentFragment);
        if (this.PTG != null)
        {
          paramContentFragment = this.PTG.PPG.PMi;
          if ((TextUtils.isEmpty(this.PTU.PMi.PMy)) && (paramContentFragment != null))
          {
            this.PTU.PMi.PMy = paramContentFragment.PMy;
            this.PTU.PMi.PMz = paramContentFragment.PMz;
          }
          if (TextUtils.isEmpty(this.PTH)) {
            haR();
          }
          for (;;)
          {
            if (this.PTA.isSupportNavigationSwipeBack())
            {
              this.PTA.getSwipeBackLayout().setEnableGesture(false);
              this.PTA.getSwipeBackLayout().Nl(true);
            }
            if (this.PTX) {
              this.PTG.getContentView().setVisibility(4);
            }
            this.PTC.setVisibility(0);
            this.PTC.setOnCardAnimListener(new GLTwistRoateCardsView.a()
            {
              public final void haT()
              {
                AppMethodBeat.i(310937);
                if (a.a(a.this).isSupportNavigationSwipeBack()) {
                  a.a(a.this).getSwipeBackLayout().setEnableGesture(true);
                }
                a.a(a.this).hnG();
                a.a(a.this).hnq();
                if (a.p(a.this) != null) {
                  ((FrameLayout)a.a(a.this).findViewById(b.f.root)).removeView(a.p(a.this));
                }
                if (a.g(a.this) != null) {
                  a.g(a.this).har();
                }
                AppMethodBeat.o(310937);
              }
              
              public final void haV()
              {
                AppMethodBeat.i(310954);
                String str1 = a.i(a.this);
                String str2 = a.j(a.this);
                com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "onPrepareCard, twistId=" + str1 + ", ext=" + str2);
                a.g(a.this).lM(str1, str2);
                try
                {
                  if (TextUtils.isEmpty(str1))
                  {
                    TwistCoverView.a(a.a(a.this).hjn(), 2);
                    com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 8);
                  }
                  for (;;)
                  {
                    a.a(a.this, com.tencent.mm.plugin.sns.ad.landingpage.component.comp.b.b(a.g(a.this).PPL));
                    if (a.k(a.this) == null) {
                      break;
                    }
                    a.p(a.this).setAnimCardView(a.k(a.this));
                    a.k(a.this).setAlpha(0.0F);
                    AppMethodBeat.o(310954);
                    return;
                    TwistCoverView.a(a.a(a.this).hjn(), 1);
                    com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 7);
                  }
                }
                finally
                {
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "twist report exp=" + localObject.toString());
                  }
                  com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "mTwistCardAnimView==null");
                  AppMethodBeat.o(310954);
                }
              }
              
              public final void haW()
              {
                AppMethodBeat.i(310924);
                if (!a.e(a.this))
                {
                  localObjectAnimator = ObjectAnimator.ofFloat(a.b(a.this), "alpha", new float[] { 0.0F, 1.0F });
                  localObjectAnimator.setDuration(500L);
                  localObjectAnimator.start();
                  localObjectAnimator = ObjectAnimator.ofFloat(a.l(a.this), "alpha", new float[] { a.l(a.this).getAlpha(), 0.0F });
                  localObjectAnimator.setDuration(300L);
                  localObjectAnimator.start();
                }
                a.c(a.this).setVisibility(0);
                ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a.c(a.this), "alpha", new float[] { 0.0F, 1.0F });
                localObjectAnimator.setDuration(500L);
                localObjectAnimator.start();
                a.g(a.this).getContentView().setVisibility(0);
                AppMethodBeat.o(310924);
              }
            });
            paramContentFragment = this.PTG.hak();
            GLTwistRoateCardsView localGLTwistRoateCardsView = this.PTC;
            int i = ((Integer)paramContentFragment.first).intValue();
            int j = ((Integer)paramContentFragment.second).intValue();
            bool = this.PTU.PMi.isClockwise;
            paramContentFragment = this.PTU.PMi.PMy;
            localObject = this.PTU.PMi.PMz;
            com.tencent.mm.sdk.platformtools.Log.i("GLTwistRoateCardsView", "initData, defBgColor=" + (String)localObject + ", imgUrl=" + paramContentFragment);
            localGLTwistRoateCardsView.Qjj = paramContentFragment;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {}
            try
            {
              localGLTwistRoateCardsView.Qjk = Color.parseColor((String)localObject);
              if ((i <= 0) || (j <= 0))
              {
                com.tencent.mm.sdk.platformtools.Log.e("GLTwistRoateCardsView", "initData, size is 0, w=" + i + ", h=" + j);
                localGLTwistRoateCardsView.Qic = com.tencent.mm.cd.a.fromDPToPix(localGLTwistRoateCardsView.mContext, 221);
                localGLTwistRoateCardsView.Qid = com.tencent.mm.cd.a.fromDPToPix(localGLTwistRoateCardsView.mContext, 375);
                localContext = localGLTwistRoateCardsView.mContext;
                str = localGLTwistRoateCardsView.Qjj;
                j = localGLTwistRoateCardsView.Qic;
                k = localGLTwistRoateCardsView.Qid;
                m = localGLTwistRoateCardsView.Qjf;
                n = localGLTwistRoateCardsView.Qjk;
                i1 = localGLTwistRoateCardsView.Qjg;
                l = System.currentTimeMillis();
                paramContentFragment = BitmapUtil.decodeFile(k.mC("twist_card_shadow", str), null);
                if ((paramContentFragment == null) || (paramContentFragment.isRecycled())) {
                  break label736;
                }
                com.tencent.mm.sdk.platformtools.Log.i("CardImgCacheUtil", "use cache shadow file");
                localGLTwistRoateCardsView.Qjl = paramContentFragment;
                localGLTwistRoateCardsView.Qjd = (com.tencent.mm.cd.a.fromDPToPix(localGLTwistRoateCardsView.mContext, 200) + localGLTwistRoateCardsView.Qid / 2);
                localGLTwistRoateCardsView.Qje = localGLTwistRoateCardsView.Qjd;
                localGLTwistRoateCardsView.POw = bool;
                if (!localGLTwistRoateCardsView.POw) {
                  break label971;
                }
                localGLTwistRoateCardsView.Qji = 3;
                localGLTwistRoateCardsView.removeAllViews();
                localGLTwistRoateCardsView.hdG();
                paramContentFragment = this.PTC;
                paramContentFragment.Qjm.postDelayed(new GLTwistRoateCardsView.1(paramContentFragment), 100L);
                AppMethodBeat.o(311415);
                return true;
                com.tencent.mm.sdk.platformtools.Log.w("AdLandingPageEggCardHelper", "skip reqTwistCardId, twistCardId=" + this.PTH);
              }
            }
            catch (Exception paramContentFragment)
            {
              for (;;)
              {
                Context localContext;
                String str;
                int k;
                int m;
                int n;
                int i1;
                long l;
                com.tencent.mm.sdk.platformtools.Log.e("GLTwistRoateCardsView", "parseColor exp=" + paramContentFragment.toString());
                continue;
                localGLTwistRoateCardsView.Qic = ((int)(i * 0.75F));
                localGLTwistRoateCardsView.Qid = ((int)(j * 0.75F));
                continue;
                label736:
                i = 0;
                localObject = BitmapUtil.decodeFileWithSample(k.mC("adId", str), j, k);
                if (localObject != null)
                {
                  paramContentFragment = BitmapUtil.getRoundedCornerBitmap(BitmapUtil.getCenterCropBitmap((Bitmap)localObject, j, k, true), true, i1, true);
                  label777:
                  if ((paramContentFragment != null) && (!paramContentFragment.isRecycled())) {
                    break label959;
                  }
                  com.tencent.mm.sdk.platformtools.Log.i("CardImgCacheUtil", "create defColor bmp");
                  i = 1;
                  paramContentFragment = e.X(j, k, n, i1);
                }
                for (;;)
                {
                  localObject = paramContentFragment;
                  if (paramContentFragment != null)
                  {
                    localObject = paramContentFragment;
                    if (!paramContentFragment.isRecycled())
                    {
                      com.tencent.mm.sdk.platformtools.Log.i("CardImgCacheUtil", "createShadowBmp");
                      localObject = com.tencent.mm.plugin.sns.ad.widget.twistad.a.a(localContext, paramContentFragment, j + m * 2, k + m * 2, m);
                    }
                  }
                  if ((localObject != null) && (!((Bitmap)localObject).isRecycled()) && (i == 0)) {
                    com.tencent.threadpool.h.ahAA.bm(new com.tencent.mm.plugin.sns.ad.widget.twistad.a.2((Bitmap)localObject, str));
                  }
                  com.tencent.mm.sdk.platformtools.Log.i("CardImgCacheUtil", "getCardBitmap, cost=" + (System.currentTimeMillis() - l));
                  paramContentFragment = (ContentFragment)localObject;
                  break;
                  com.tencent.mm.sdk.platformtools.Log.i("CardImgCacheUtil", "start download");
                  k.b("adId", str, new com.tencent.mm.plugin.sns.ad.widget.twistad.a.1(str));
                  break label777;
                  label959:
                  com.tencent.mm.sdk.platformtools.Log.i("CardImgCacheUtil", "create url bmp");
                }
                label971:
                localGLTwistRoateCardsView.Qji = 9;
              }
            }
          }
        }
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "mEggCardComponent==null");
        AppMethodBeat.o(311415);
        return false;
      }
      bool = b(paramContentFragment, false);
      AppMethodBeat.o(311415);
      return bool;
    }
    if (this.PTK)
    {
      if (this.PTX)
      {
        this.PTQ.setVisibility(8);
        localObject = ObjectAnimator.ofFloat(this.PTR, "alpha", new float[] { 0.0F, 1.0F });
        ((ObjectAnimator)localObject).setDuration(1000L);
        ((ObjectAnimator)localObject).start();
      }
      aT(false, false);
      bool = a(paramContentFragment, false);
      AppMethodBeat.o(311415);
      return bool;
    }
    if (this.PTL)
    {
      AppMethodBeat.o(311415);
      return true;
    }
    if (this.PTN)
    {
      AppMethodBeat.o(311415);
      return true;
    }
    AppMethodBeat.o(311415);
    return false;
  }
  
  public final boolean aWC(final String paramString)
  {
    AppMethodBeat.i(311373);
    com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "loadSpriteImage:".concat(String.valueOf(paramString)));
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(311373);
      return false;
    }
    try
    {
      String str = k.aZH(paramString);
      if (!y.ZC(str))
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "loadLongSpriteImage, !fileExists");
        k.b("adId", paramString, new g.a()
        {
          public final void aWn(String paramAnonymousString)
          {
            AppMethodBeat.i(310955);
            com.tencent.mm.sdk.platformtools.Log.d("AdLandingPageEggCardHelper", "doDownloadSpriteImg img succ");
            AppMethodBeat.o(310955);
          }
          
          public final void gZM() {}
          
          public final void gZN()
          {
            AppMethodBeat.i(310948);
            com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "doDownloadSpriteImg img err, url=" + paramString);
            AppMethodBeat.o(310948);
          }
        });
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 19);
        AppMethodBeat.o(311373);
        return false;
      }
      paramString = BitmapUtil.decodeFile(str, null);
      if (paramString != null)
      {
        this.PTO = paramString;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 18);
        com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "loadLongSpriteImage succ");
        AppMethodBeat.o(311373);
        return true;
      }
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "loadLongSpriteImage, bitmap==null");
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1572, 19);
    }
    finally
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "loadLongSpriteImage, exp=" + paramString.toString());
      }
    }
    AppMethodBeat.o(311373);
    return false;
  }
  
  public final boolean haM()
  {
    AppMethodBeat.i(311388);
    ObjectAnimator localObjectAnimator;
    if (this.PTD)
    {
      this.PTP.setVisibility(8);
      if (!this.PTX)
      {
        localObjectAnimator = ObjectAnimator.ofFloat(this.PTQ, "alpha", new float[] { 0.0F, 0.2F });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.start();
        this.PTR.setAlpha(0.0F);
      }
      com.tencent.mm.ui.base.b.a(this.PTA, null);
      AppMethodBeat.o(311388);
      return true;
    }
    if (this.PTK)
    {
      this.PTP.setVisibility(8);
      if (!this.PTX)
      {
        localObjectAnimator = ObjectAnimator.ofFloat(this.PTQ, "alpha", new float[] { 0.0F, 0.2F });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.start();
        this.PTR.setAlpha(0.0F);
      }
      com.tencent.mm.ui.base.b.a(this.PTA, null);
      AppMethodBeat.o(311388);
      return true;
    }
    if (this.PTL)
    {
      this.PTP.setVisibility(8);
      localObjectAnimator = ObjectAnimator.ofFloat(this.PTQ, "alpha", new float[] { 0.0F, 0.2F });
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.start();
      this.PTR.setAlpha(0.0F);
      com.tencent.mm.ui.base.b.a(this.PTA, null);
      AppMethodBeat.o(311388);
      return true;
    }
    if (this.PTN)
    {
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "initBeforeAnimation, longpressAnim");
      this.PTP.setVisibility(8);
      this.PTQ.setVisibility(8);
      this.PTR.setAlpha(0.0F);
      com.tencent.mm.ui.base.b.a(this.PTA, null);
      AppMethodBeat.o(311388);
      return true;
    }
    AppMethodBeat.o(311388);
    return false;
  }
  
  public final int haN()
  {
    if ((this.PTU != null) && (this.PTU.PMm != null)) {
      return this.PTU.PMm.PMw;
    }
    return 0;
  }
  
  public final boolean haO()
  {
    AppMethodBeat.i(311435);
    Object localObject1;
    Object localObject2;
    if (this.PTL)
    {
      haP();
      if (this.PTJ == null)
      {
        AppMethodBeat.o(311435);
        return false;
      }
      this.PTJ.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(310944);
          a.a(a.this).hnp();
          a.f(a.this).getViewTreeObserver().removeOnPreDrawListener(this);
          AppMethodBeat.o(310944);
          return false;
        }
      });
      this.PTJ.setVisibility(0);
      localObject1 = this.PTJ;
      localObject2 = this.PTU.PMl;
      if (localObject2 == null) {
        org.xwalk.core.Log.e("ShakeCardAnimView", "initData, pagThemeAnimInfo==null");
      }
      for (;;)
      {
        this.PTJ.hdw();
        com.tencent.threadpool.h.ahAA.o(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310949);
            a.b(a.this).setVisibility(0);
            a.c(a.this).setVisibility(0);
            a.c(a.this).setAlpha(0.0F);
            ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a.b(a.this), "alpha", new float[] { 0.0F, 1.0F });
            localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                AppMethodBeat.i(310895);
                float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                a.c(a.this).setAlpha(f);
                AppMethodBeat.o(310895);
              }
            });
            localObjectAnimator.addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
            {
              public final void onAnimationEnd(Animator paramAnonymous2Animator)
              {
                AppMethodBeat.i(310892);
                a.a(a.this).RlG = false;
                a.d(a.this).setVisibility(8);
                a.a(a.this).hnG();
                a.a(a.this).hnq();
                if ((!a.a(a.this).RlW) && (a.a(a.this).isSupportNavigationSwipeBack())) {
                  a.a(a.this).getSwipeBackLayout().setEnableGesture(true);
                }
                AppMethodBeat.o(310892);
              }
            });
            localObjectAnimator.setDuration(300L);
            localObjectAnimator.start();
            AppMethodBeat.o(310949);
          }
        }, 1000L);
        AppMethodBeat.o(311435);
        return true;
        org.xwalk.core.Log.i("ShakeCardAnimView", "initData, simple anim");
        ((ShakeCardAnimView)localObject1).lR(((d.b)localObject2).PMs, ((d.b)localObject2).PMt);
      }
    }
    if (this.PTN)
    {
      if ((this.PTM != null) && (this.PTO != null))
      {
        com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "tryPlayLongPressAnim");
        this.PTM.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(310925);
            if (a.a(a.this).isSupportNavigationSwipeBack())
            {
              a.a(a.this).getSwipeBackLayout().setEnableGesture(false);
              a.a(a.this).getSwipeBackLayout().Nl(true);
            }
            a.a(a.this).hnp();
            a.this.PTM.getViewTreeObserver().removeOnPreDrawListener(this);
            AppMethodBeat.o(310925);
            return false;
          }
        });
        localObject1 = this.PTU.PMm;
        this.PTM.setVisibility(0);
        localObject2 = this.PTM;
        Bitmap localBitmap = this.PTO;
        int i = ((d.c)localObject1).PMu;
        int j = ((d.c)localObject1).PMw;
        int k = ((d.c)localObject1).PMv;
        com.tencent.mm.sdk.platformtools.Log.i("SnsAdSphereAnimView", "setData, sceneType=" + i + ", duration=" + j + ", bmp=" + localBitmap);
        ((SnsAdSphereAnimView)localObject2).RWD = false;
        if (localBitmap == null) {
          com.tencent.mm.sdk.platformtools.Log.e("SnsAdSphereAnimView", "setData, bmp==null");
        }
        for (;;)
        {
          localObject2 = this.PTM;
          com.tencent.mm.sdk.platformtools.Log.i("SnsAdSphereAnimView", "start");
          ((SnsAdSphereAnimView)localObject2).invalidate();
          com.tencent.threadpool.h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(310940);
              com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "tryPlayLongPressAnim, after delay");
              a.b(a.this).setVisibility(0);
              a.c(a.this).setVisibility(0);
              a.c(a.this).setAlpha(0.0F);
              ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a.b(a.this), "alpha", new float[] { 0.0F, 1.0F });
              localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
              {
                public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
                {
                  AppMethodBeat.i(310902);
                  float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                  a.c(a.this).setAlpha(f);
                  AppMethodBeat.o(310902);
                }
              });
              localObjectAnimator.addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
              {
                public final void onAnimationEnd(Animator paramAnonymous2Animator)
                {
                  AppMethodBeat.i(310906);
                  com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "tryPlayLongPressAnim, onAnimationEnd, loadLandingPages");
                  a.a(a.this).RlG = false;
                  a.d(a.this).setVisibility(8);
                  a.a(a.this).hnG();
                  a.a(a.this).hnq();
                  if ((!a.a(a.this).RlW) && (a.a(a.this).isSupportNavigationSwipeBack())) {
                    a.a(a.this).getSwipeBackLayout().setEnableGesture(true);
                  }
                  AppMethodBeat.o(310906);
                }
              });
              localObjectAnimator.setDuration(500L);
              localObjectAnimator.start();
              AppMethodBeat.o(310940);
            }
          }, ((d.c)localObject1).PMw + 50);
          com.tencent.threadpool.h.ahAA.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(310936);
              ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(a.this.PTM, "alpha", new float[] { 1.0F, 0.0F });
              localObjectAnimator.addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
              {
                public final void onAnimationEnd(Animator paramAnonymous2Animator)
                {
                  AppMethodBeat.i(310885);
                  try
                  {
                    a.this.PTM.setVisibility(4);
                    paramAnonymous2Animator = a.a(a.this).RlA;
                    if (paramAnonymous2Animator != null)
                    {
                      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "removeView LongPressAnimView");
                      paramAnonymous2Animator.removeView(a.this.PTM);
                    }
                    AppMethodBeat.o(310885);
                    return;
                  }
                  finally
                  {
                    com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "remove LongPressAnimView, exp=" + paramAnonymous2Animator.toString());
                    AppMethodBeat.o(310885);
                  }
                }
              });
              localObjectAnimator.setDuration(300L);
              localObjectAnimator.start();
              AppMethodBeat.o(310936);
            }
          }, ((d.c)localObject1).PMw - 300);
          AppMethodBeat.o(311435);
          return true;
          ((SnsAdSphereAnimView)localObject2).RWE = localBitmap;
          ((SnsAdSphereAnimView)localObject2).RWB = i;
          ((SnsAdSphereAnimView)localObject2).hbT = j;
          ((SnsAdSphereAnimView)localObject2).RWC = k;
          i = ((SnsAdSphereAnimView)localObject2).getWidth();
          j = ((SnsAdSphereAnimView)localObject2).getHeight();
          if ((i == 0) || (j == 0))
          {
            com.tencent.mm.sdk.platformtools.Log.w("SnsAdSphereAnimView", "setData, w,h==0");
            ((SnsAdSphereAnimView)localObject2).RWD = true;
          }
          else
          {
            ((SnsAdSphereAnimView)localObject2).lT(i, j);
          }
        }
      }
      AppMethodBeat.o(311435);
      return false;
    }
    AppMethodBeat.o(311435);
    return false;
  }
  
  public final void haP()
  {
    AppMethodBeat.i(311441);
    try
    {
      if (this.PTJ == null)
      {
        ViewStub localViewStub = (ViewStub)this.PTA.findViewById(b.f.shake_card_layout_stub);
        if (localViewStub != null) {
          this.PTJ = ((ShakeCardAnimView)localViewStub.inflate());
        }
      }
      AppMethodBeat.o(311441);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "inflateShakeCardView, exp=" + localObject.toString());
      AppMethodBeat.o(311441);
    }
  }
  
  public final void haR()
  {
    AppMethodBeat.i(311447);
    try
    {
      int i = this.PTA.hjn().source;
      String str1 = Util.nullAsNil(this.PTA.hjn().uxInfo);
      String str2 = Util.nullAsNil(this.PTA.QLy);
      String str3 = Util.nullAsNil(this.PTA.hjn().rzx);
      com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "start reqTwistCardId, source=" + i + ", rawSnsId=" + str2 + ", canvasId=" + str3 + ", uxInfo=" + str1);
      final long l = System.currentTimeMillis();
      AdLandingPagesProxy.getInstance().getTwistAdCard(str1, str2, i, str3, "", new AdLandingPagesProxy.e()
      {
        public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          int i = 0;
          AppMethodBeat.i(310951);
          Object localObject = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.f.j(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
          String str = ((Bundle)localObject).getString("card_id", "");
          localObject = ((Bundle)localObject).getString("card_ext_info", "");
          a.a(a.this, str);
          a.b(a.this, (String)localObject);
          long l = System.currentTimeMillis() - l;
          com.tencent.mm.sdk.platformtools.Log.i("AdLandingPageEggCardHelper", "reqTwistCardId rsp, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", cardId=" + str + ", timeCost=" + l + ", extInfo=" + (String)localObject);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousObject != null)) {
            paramAnonymousInt1 = 1;
          }
          try
          {
            str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            if (a.q(a.this))
            {
              paramAnonymousObject = "1";
              label163:
              localObject = l.Qnu;
              paramAnonymousInt2 = (int)l;
              if (paramAnonymousInt1 == 0) {
                break label231;
              }
            }
            label231:
            for (paramAnonymousInt1 = i;; paramAnonymousInt1 = 1)
            {
              l.a((String)localObject, str, paramAnonymousInt2, paramAnonymousInt1, paramAnonymousObject + "|" + this.vHo);
              AppMethodBeat.o(310951);
              return;
              paramAnonymousInt1 = 0;
              break;
              paramAnonymousObject = "";
              break label163;
            }
            return;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "reqTwistCardId exp=" + paramAnonymousObject.toString());
            AppMethodBeat.o(310951);
          }
        }
        
        public final void onCallback(Object paramAnonymousObject) {}
      });
      AppMethodBeat.o(311447);
      return;
    }
    finally
    {
      com.tencent.mm.sdk.platformtools.Log.e("AdLandingPageEggCardHelper", "reqTwistCardId, exp=" + localObject.toString());
      AppMethodBeat.o(311447);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.anim.a
 * JD-Core Version:    0.7.0.1
 */