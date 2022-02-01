package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.b.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView.1;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.plugin.sns.ui.widget.a.c;
import com.tencent.mm.plugin.sns.ui.widget.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import org.json.JSONObject;

public final class au
{
  private Context mContext;
  int mScene;
  protected long mStartTime;
  p wvM;
  Bitmap xuX;
  b.m xuY;
  SnsAdTouchProgressView xuZ;
  SnsAdSphereAnimView xva;
  an xvb;
  int xvc;
  private volatile boolean xvd;
  protected SnsAdTouchProgressView.a xve;
  protected boolean xvf;
  public SnsAdTouchProgressView.a xvg;
  
  public au(Context paramContext, d.a parama)
  {
    AppMethodBeat.i(179199);
    this.xvd = false;
    this.xve = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (au.this.xvf)
        {
          ad.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (au.this.xuY == null)
        {
          ad.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        ad.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + au.this.xuY.wUK);
        au.this.xvb.xso.seekTo(au.this.xuY.wUK);
        au.this.qk(true);
        if (au.this.xvg != null) {
          au.this.xvg.onCancel();
        }
        au.a(au.this.wvM, 1, (int)(System.currentTimeMillis() - au.this.mStartTime), au.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        ad.i("SnsAdPressGestureCtrl", "onClick");
        if (au.this.xvg != null) {
          au.this.xvg.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!au.this.xvf)
        {
          au.this.xvf = true;
          ad.i("SnsAdPressGestureCtrl", "onFinish");
          au.this.qk(true);
          if (au.this.xvg != null) {
            au.this.xvg.onFinish();
          }
          au.a(au.this.wvM, 2, (int)(System.currentTimeMillis() - au.this.mStartTime), au.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        ad.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        au.this.mStartTime = System.currentTimeMillis();
        au.this.xvf = false;
        if (au.this.xuY == null)
        {
          ad.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        ad.i("SnsAdPressGestureCtrl", "onStart, seekto=" + au.this.xuY.wUL);
        q.d(new long[] { 20L, 100L });
        au.this.xvb.xso.seekTo(au.this.xuY.wUL);
        au localau = au.this;
        SnsAdSphereAnimView localSnsAdSphereAnimView;
        Bitmap localBitmap;
        int i;
        int j;
        int k;
        int m;
        int n;
        if ((localau.xuY != null) && (localau.xva != null) && (localau.xva.getVisibility() != 0))
        {
          ad.i("SnsAdPressGestureCtrl", "showSphereAnimView");
          if (localau.xuX != null)
          {
            localSnsAdSphereAnimView = localau.xva;
            localBitmap = localau.xuX;
            i = localau.xuY.wUO;
            j = localau.xvc;
            k = localau.xuY.wUM;
            ad.i("SnsAdSphereAnimView", "setData, sceneType=" + i + ", duration=" + k + ", h=" + j + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              localSnsAdSphereAnimView.xXv = i;
              m = com.tencent.mm.cd.a.fromDPToPix(localSnsAdSphereAnimView.mContext, 30);
              n = com.tencent.mm.cd.a.fromDPToPix(localSnsAdSphereAnimView.mContext, 36);
              if (i != SnsAdSphereAnimView.xXr) {
                break label380;
              }
              localSnsAdSphereAnimView.xXu = new c(localSnsAdSphereAnimView.getContext(), localBitmap, m, n, j, k);
            }
          }
        }
        for (;;)
        {
          localSnsAdSphereAnimView.invalidate();
          localSnsAdSphereAnimView = localau.xva;
          ad.i("SnsAdSphereAnimView", "start");
          localSnsAdSphereAnimView.invalidate();
          localau.xva.setVisibility(0);
          if (au.this.xvg != null) {
            au.this.xvg.onStart();
          }
          AppMethodBeat.o(179192);
          return;
          label380:
          if (i == SnsAdSphereAnimView.xXs) {
            localSnsAdSphereAnimView.xXu = new d(localSnsAdSphereAnimView.mContext, localBitmap, m, n, j, k);
          } else if (i == SnsAdSphereAnimView.xXt) {
            localSnsAdSphereAnimView.xSa.postDelayed(new SnsAdSphereAnimView.1(localSnsAdSphereAnimView, localBitmap, m, n, k), 50L);
          }
        }
      }
    };
    this.xvf = false;
    this.mContext = paramContext;
    this.xuZ = parama.xPt;
    this.xva = parama.xPu;
    this.xvb = parama.xOO;
    this.mScene = 1;
    AppMethodBeat.o(179199);
  }
  
  public au(Context paramContext, SnsAdTouchProgressView paramSnsAdTouchProgressView, SnsAdSphereAnimView paramSnsAdSphereAnimView, an paraman)
  {
    AppMethodBeat.i(179200);
    this.xvd = false;
    this.xve = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (au.this.xvf)
        {
          ad.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (au.this.xuY == null)
        {
          ad.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        ad.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + au.this.xuY.wUK);
        au.this.xvb.xso.seekTo(au.this.xuY.wUK);
        au.this.qk(true);
        if (au.this.xvg != null) {
          au.this.xvg.onCancel();
        }
        au.a(au.this.wvM, 1, (int)(System.currentTimeMillis() - au.this.mStartTime), au.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        ad.i("SnsAdPressGestureCtrl", "onClick");
        if (au.this.xvg != null) {
          au.this.xvg.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!au.this.xvf)
        {
          au.this.xvf = true;
          ad.i("SnsAdPressGestureCtrl", "onFinish");
          au.this.qk(true);
          if (au.this.xvg != null) {
            au.this.xvg.onFinish();
          }
          au.a(au.this.wvM, 2, (int)(System.currentTimeMillis() - au.this.mStartTime), au.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        ad.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        au.this.mStartTime = System.currentTimeMillis();
        au.this.xvf = false;
        if (au.this.xuY == null)
        {
          ad.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        ad.i("SnsAdPressGestureCtrl", "onStart, seekto=" + au.this.xuY.wUL);
        q.d(new long[] { 20L, 100L });
        au.this.xvb.xso.seekTo(au.this.xuY.wUL);
        au localau = au.this;
        SnsAdSphereAnimView localSnsAdSphereAnimView;
        Bitmap localBitmap;
        int i;
        int j;
        int k;
        int m;
        int n;
        if ((localau.xuY != null) && (localau.xva != null) && (localau.xva.getVisibility() != 0))
        {
          ad.i("SnsAdPressGestureCtrl", "showSphereAnimView");
          if (localau.xuX != null)
          {
            localSnsAdSphereAnimView = localau.xva;
            localBitmap = localau.xuX;
            i = localau.xuY.wUO;
            j = localau.xvc;
            k = localau.xuY.wUM;
            ad.i("SnsAdSphereAnimView", "setData, sceneType=" + i + ", duration=" + k + ", h=" + j + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              localSnsAdSphereAnimView.xXv = i;
              m = com.tencent.mm.cd.a.fromDPToPix(localSnsAdSphereAnimView.mContext, 30);
              n = com.tencent.mm.cd.a.fromDPToPix(localSnsAdSphereAnimView.mContext, 36);
              if (i != SnsAdSphereAnimView.xXr) {
                break label380;
              }
              localSnsAdSphereAnimView.xXu = new c(localSnsAdSphereAnimView.getContext(), localBitmap, m, n, j, k);
            }
          }
        }
        for (;;)
        {
          localSnsAdSphereAnimView.invalidate();
          localSnsAdSphereAnimView = localau.xva;
          ad.i("SnsAdSphereAnimView", "start");
          localSnsAdSphereAnimView.invalidate();
          localau.xva.setVisibility(0);
          if (au.this.xvg != null) {
            au.this.xvg.onStart();
          }
          AppMethodBeat.o(179192);
          return;
          label380:
          if (i == SnsAdSphereAnimView.xXs) {
            localSnsAdSphereAnimView.xXu = new d(localSnsAdSphereAnimView.mContext, localBitmap, m, n, j, k);
          } else if (i == SnsAdSphereAnimView.xXt) {
            localSnsAdSphereAnimView.xSa.postDelayed(new SnsAdSphereAnimView.1(localSnsAdSphereAnimView, localBitmap, m, n, k), 50L);
          }
        }
      }
    };
    this.xvf = false;
    this.mContext = paramContext;
    this.xuZ = paramSnsAdTouchProgressView;
    this.xva = paramSnsAdSphereAnimView;
    this.xvb = paraman;
    this.mScene = 2;
    AppMethodBeat.o(179200);
  }
  
  public static void a(p paramp, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(179206);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("snsid", paramp.field_snsId);
      localJSONObject.put("uxinfo", bt.nullAsNil(paramp.dxu().dvK));
      localJSONObject.put("scene", paramInt3);
      paramp = new JSONObject();
      paramp.put("result", paramInt1);
      paramp.put("pressTotalTime", paramInt2);
      localJSONObject.put("extInfo", paramp);
      paramp = localJSONObject.toString();
      j.ix("timeline_fullcard_longpress_action", paramp);
      ad.i("SnsAdPressGestureCtrl", "reportAction, content=" + paramp + ", channel=timeline_fullcard_longpress_action");
      AppMethodBeat.o(179206);
      return;
    }
    catch (Exception paramp)
    {
      ad.i("SnsAdPressGestureCtrl", "reportAction, exp=" + paramp.toString());
      AppMethodBeat.o(179206);
    }
  }
  
  private static boolean a(b.m paramm, p paramp)
  {
    AppMethodBeat.i(179202);
    if ((paramm == null) || (paramp == null))
    {
      AppMethodBeat.o(179202);
      return false;
    }
    try
    {
      if (paramm.wUK > 0)
      {
        int i = paramm.wUL;
        int j = paramm.wUK;
        if (i > j) {}
      }
      else
      {
        AppMethodBeat.o(179202);
        return false;
      }
      boolean bool = TextUtils.isEmpty(paramp.dxs().dvu());
      if (bool)
      {
        AppMethodBeat.o(179202);
        return false;
      }
      AppMethodBeat.o(179202);
      return true;
    }
    catch (Exception paramm)
    {
      ad.e("SnsAdPressGestureCtrl", "isValidLongPressGestureAd, exp=" + paramm.toString());
      AppMethodBeat.o(179202);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.sns.a.b.i parami, final long paramLong1, final long paramLong2)
  {
    AppMethodBeat.i(179203);
    if (!this.xvd)
    {
      AppMethodBeat.o(179203);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179191);
        try
        {
          boolean bool = au.this.xvb.xso.dzx();
          ad.d("SnsAdPressGestureCtrl", "checkLongPressGesture, start=" + au.this.xuY.wUK + ", end=" + au.this.xuY.wUL + ", duration=" + au.this.xuY.wUM + ", curPlayTime=" + paramLong1 + ", isPlaying=" + bool);
          if ((paramLong1 >= au.this.xuY.wUK) && (bool))
          {
            au localau = au.this;
            if ((localau.xuZ != null) && (localau.xuZ.getVisibility() != 0))
            {
              ad.i("SnsAdPressGestureCtrl", "enableLongPressGestureView");
              localau.xuZ.setVisibility(0);
            }
          }
          for (;;)
          {
            if ((paramLong1 > au.this.xuY.wUL - 250) && (!au.this.xuZ.isAnimating()))
            {
              ad.i("SnsAdPressGestureCtrl", "checkLongPressGesture, seekto 0");
              au.this.xvb.xso.seekTo(0);
              if (paramLong2 != null)
              {
                ad.i("SnsAdPressGestureCtrl", "checkLongPressGesture, addIdCount:" + this.xvj);
                paramLong2.A(this.xvj, false);
              }
            }
            AppMethodBeat.o(179191);
            return;
            au.this.dAJ();
            au.this.qk(false);
          }
          return;
        }
        catch (Exception localException)
        {
          ad.e("SnsAdPressGestureCtrl", "checkLongPressGesture, exp=" + localException.toString());
          AppMethodBeat.o(179191);
        }
      }
    });
    AppMethodBeat.o(179203);
  }
  
  public final boolean a(final p paramp, b.m paramm, int paramInt)
  {
    AppMethodBeat.i(179201);
    if ((this.wvM == null) || (this.wvM.field_snsId != paramp.field_snsId))
    {
      this.xuY = paramm;
      this.wvM = paramp;
      this.xuX = null;
      this.xvc = paramInt;
      this.xvd = a(paramm, paramp);
      ad.i("SnsAdPressGestureCtrl", "initData, isValidGestureAd=" + this.xvd + ", snsId=" + paramp.field_snsId);
      if (!this.xvd) {
        break label260;
      }
      ad.i("SnsAdPressGestureCtrl", "initData, start=" + this.xuY.wUK + ", end=" + this.xuY.wUL + ", duration=" + this.xuY.wUM + ", pressDuration=" + this.xuY.wUM);
      this.xuZ.setActionListener(this.xve);
      this.xuZ.setDuration(paramm.wUM);
      this.xvb.xso.setTimerInterval(250);
      paramp = paramm.wUN;
      ad.i("SnsAdPressGestureCtrl", "loadSpriteImage:".concat(String.valueOf(paramp)));
      if (!TextUtils.isEmpty(paramp)) {
        h.a(paramp, new f.a()
        {
          public final void apm(String paramAnonymousString)
          {
            AppMethodBeat.i(187662);
            if (au.this.xuY != null)
            {
              String str2 = au.this.xuY.wUN;
              String str1;
              if (TextUtils.isEmpty(str2)) {
                str1 = "";
              }
              while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str1)))
              {
                paramAnonymousString = f.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  au.this.xuX = paramAnonymousString;
                  ad.i("SnsAdPressGestureCtrl", "onDownloaded succ, tagUrl=".concat(String.valueOf(str2)));
                  AppMethodBeat.o(187662);
                  return;
                  str1 = h.iU("adId", str2);
                }
                else
                {
                  ad.e("SnsAdPressGestureCtrl", "onDownloaded, bitmap==null");
                  AppMethodBeat.o(187662);
                  return;
                }
              }
              ad.e("SnsAdPressGestureCtrl", "onDownloaded, url changed");
            }
            AppMethodBeat.o(187662);
          }
          
          public final void dsA()
          {
            AppMethodBeat.i(187661);
            StringBuilder localStringBuilder = new StringBuilder("onDownloadError, snsId=");
            if (au.this.wvM == null) {}
            for (Object localObject = "";; localObject = Long.valueOf(au.this.wvM.field_snsId))
            {
              ad.e("SnsAdPressGestureCtrl", localObject + ", url=" + paramp);
              AppMethodBeat.o(187661);
              return;
            }
          }
          
          public final void duP() {}
        });
      }
    }
    for (;;)
    {
      boolean bool = this.xvd;
      AppMethodBeat.o(179201);
      return bool;
      label260:
      this.xuZ.setActionListener(null);
      qk(false);
      dAJ();
      this.xvb.xso.setTimerInterval(1000);
    }
  }
  
  public final boolean dAI()
  {
    AppMethodBeat.i(187663);
    if (this.xvd)
    {
      boolean bool;
      if (this.xuZ != null)
      {
        bool = this.xuZ.isAnimating();
        if (!bool) {
          break label137;
        }
        if (this.wvM != null) {
          break label123;
        }
      }
      label123:
      for (String str = "";; str = q.st(this.wvM.field_snsId))
      {
        int i = (int)(System.currentTimeMillis() - this.mStartTime);
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.wAM, str, this.mScene, i, "");
        ad.i("SnsAdPressGestureCtrl", "checkLongPressGesture, videoEnd && isAnimating, snsId=" + str + ", pressDuration=" + i);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187659);
            au.this.xve.onFinish();
            AppMethodBeat.o(187659);
          }
        });
        AppMethodBeat.o(187663);
        return true;
        bool = false;
        break;
      }
    }
    label137:
    AppMethodBeat.o(187663);
    return false;
  }
  
  public final void dAJ()
  {
    AppMethodBeat.i(179204);
    if ((this.xuZ != null) && (this.xuZ.getVisibility() != 8))
    {
      ad.i("SnsAdPressGestureCtrl", "disableLongPressGestureView");
      this.xuZ.clear();
      this.xuZ.setVisibility(8);
    }
    AppMethodBeat.o(179204);
  }
  
  public final void qk(boolean paramBoolean)
  {
    AppMethodBeat.i(179205);
    if ((this.xva != null) && (this.xva.getVisibility() != 8))
    {
      ad.i("SnsAdPressGestureCtrl", "hideSphereAnimView");
      if (!paramBoolean)
      {
        this.xva.clear();
        this.xva.setVisibility(8);
        AppMethodBeat.o(179205);
        return;
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(187660);
          au.this.xva.setVisibility(8);
          au.this.xva.clear();
          AppMethodBeat.o(187660);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.xva.startAnimation(localAlphaAnimation);
    }
    AppMethodBeat.o(179205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */