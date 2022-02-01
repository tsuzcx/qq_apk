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
import com.tencent.mm.plugin.sns.storage.b.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView.1;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView.2;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.plugin.sns.ui.widget.a.c;
import com.tencent.mm.plugin.sns.ui.widget.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import org.json.JSONObject;

public final class au
{
  private Context mContext;
  int mScene;
  protected long mStartTime;
  p xHc;
  Bitmap yHN;
  b.n yHO;
  SnsAdTouchProgressView yHP;
  SnsAdSphereAnimView yHQ;
  an yHR;
  int yHS;
  private volatile boolean yHT;
  protected SnsAdTouchProgressView.a yHU;
  protected boolean yHV;
  public SnsAdTouchProgressView.a yHW;
  
  public au(Context paramContext, d.a parama)
  {
    AppMethodBeat.i(179199);
    this.yHT = false;
    this.yHU = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (au.this.yHV)
        {
          ac.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (au.this.yHO == null)
        {
          ac.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        ac.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + au.this.yHO.yhy);
        au.this.yHR.yFe.seekTo(au.this.yHO.yhy);
        au.this.rj(true);
        if (au.this.yHW != null) {
          au.this.yHW.onCancel();
        }
        au.a(au.this.xHc, 1, (int)(System.currentTimeMillis() - au.this.mStartTime), au.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        ac.i("SnsAdPressGestureCtrl", "onClick");
        if (au.this.yHW != null) {
          au.this.yHW.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!au.this.yHV)
        {
          au.this.yHV = true;
          ac.i("SnsAdPressGestureCtrl", "onFinish");
          au.this.rj(true);
          if (au.this.yHW != null) {
            au.this.yHW.onFinish();
          }
          au.a(au.this.xHc, 2, (int)(System.currentTimeMillis() - au.this.mStartTime), au.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        ac.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        au.this.mStartTime = System.currentTimeMillis();
        au.this.yHV = false;
        if (au.this.yHO == null)
        {
          ac.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        ac.i("SnsAdPressGestureCtrl", "onStart, seekto=" + au.this.yHO.yhz);
        q.d(new long[] { 20L, 100L });
        au.this.yHR.yFe.seekTo(au.this.yHO.yhz);
        au localau = au.this;
        SnsAdSphereAnimView localSnsAdSphereAnimView;
        Bitmap localBitmap;
        int i;
        int j;
        int k;
        int m;
        int n;
        if ((localau.yHO != null) && (localau.yHQ != null) && (localau.yHQ.getVisibility() != 0))
        {
          ac.i("SnsAdPressGestureCtrl", "showSphereAnimView");
          if (localau.yHN != null)
          {
            localSnsAdSphereAnimView = localau.yHQ;
            localBitmap = localau.yHN;
            i = localau.yHO.yhC;
            j = localau.yHS;
            k = localau.yHO.yhA;
            ac.i("SnsAdSphereAnimView", "setData, sceneType=" + i + ", duration=" + k + ", h=" + j + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              localSnsAdSphereAnimView.zkr = i;
              m = com.tencent.mm.cc.a.fromDPToPix(localSnsAdSphereAnimView.mContext, 30);
              n = com.tencent.mm.cc.a.fromDPToPix(localSnsAdSphereAnimView.mContext, 36);
              if (i != SnsAdSphereAnimView.zkm) {
                break label380;
              }
              localSnsAdSphereAnimView.zkq = new c(localSnsAdSphereAnimView.mContext, localBitmap, m, n, j, k);
            }
          }
        }
        for (;;)
        {
          localSnsAdSphereAnimView.invalidate();
          localSnsAdSphereAnimView = localau.yHQ;
          ac.i("SnsAdSphereAnimView", "start");
          localSnsAdSphereAnimView.invalidate();
          localau.yHQ.setVisibility(0);
          if (au.this.yHW != null) {
            au.this.yHW.onStart();
          }
          AppMethodBeat.o(179192);
          return;
          label380:
          if (i == SnsAdSphereAnimView.zkn) {
            localSnsAdSphereAnimView.zkq = new d(localSnsAdSphereAnimView.mContext, localBitmap, m, n, j, k);
          } else if (i == SnsAdSphereAnimView.zko) {
            localSnsAdSphereAnimView.zeV.postDelayed(new SnsAdSphereAnimView.1(localSnsAdSphereAnimView, localBitmap, m, n, k), 100L);
          } else if (i == SnsAdSphereAnimView.zkp) {
            localSnsAdSphereAnimView.zeV.postDelayed(new SnsAdSphereAnimView.2(localSnsAdSphereAnimView, localBitmap, m, n, k), 100L);
          }
        }
      }
    };
    this.yHV = false;
    this.mContext = paramContext;
    this.yHP = parama.zcj;
    this.yHQ = parama.zck;
    this.yHR = parama.zbE;
    this.mScene = 1;
    AppMethodBeat.o(179199);
  }
  
  public au(Context paramContext, SnsAdTouchProgressView paramSnsAdTouchProgressView, SnsAdSphereAnimView paramSnsAdSphereAnimView, an paraman)
  {
    AppMethodBeat.i(179200);
    this.yHT = false;
    this.yHU = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (au.this.yHV)
        {
          ac.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (au.this.yHO == null)
        {
          ac.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        ac.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + au.this.yHO.yhy);
        au.this.yHR.yFe.seekTo(au.this.yHO.yhy);
        au.this.rj(true);
        if (au.this.yHW != null) {
          au.this.yHW.onCancel();
        }
        au.a(au.this.xHc, 1, (int)(System.currentTimeMillis() - au.this.mStartTime), au.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        ac.i("SnsAdPressGestureCtrl", "onClick");
        if (au.this.yHW != null) {
          au.this.yHW.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!au.this.yHV)
        {
          au.this.yHV = true;
          ac.i("SnsAdPressGestureCtrl", "onFinish");
          au.this.rj(true);
          if (au.this.yHW != null) {
            au.this.yHW.onFinish();
          }
          au.a(au.this.xHc, 2, (int)(System.currentTimeMillis() - au.this.mStartTime), au.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        ac.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        au.this.mStartTime = System.currentTimeMillis();
        au.this.yHV = false;
        if (au.this.yHO == null)
        {
          ac.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        ac.i("SnsAdPressGestureCtrl", "onStart, seekto=" + au.this.yHO.yhz);
        q.d(new long[] { 20L, 100L });
        au.this.yHR.yFe.seekTo(au.this.yHO.yhz);
        au localau = au.this;
        SnsAdSphereAnimView localSnsAdSphereAnimView;
        Bitmap localBitmap;
        int i;
        int j;
        int k;
        int m;
        int n;
        if ((localau.yHO != null) && (localau.yHQ != null) && (localau.yHQ.getVisibility() != 0))
        {
          ac.i("SnsAdPressGestureCtrl", "showSphereAnimView");
          if (localau.yHN != null)
          {
            localSnsAdSphereAnimView = localau.yHQ;
            localBitmap = localau.yHN;
            i = localau.yHO.yhC;
            j = localau.yHS;
            k = localau.yHO.yhA;
            ac.i("SnsAdSphereAnimView", "setData, sceneType=" + i + ", duration=" + k + ", h=" + j + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              localSnsAdSphereAnimView.zkr = i;
              m = com.tencent.mm.cc.a.fromDPToPix(localSnsAdSphereAnimView.mContext, 30);
              n = com.tencent.mm.cc.a.fromDPToPix(localSnsAdSphereAnimView.mContext, 36);
              if (i != SnsAdSphereAnimView.zkm) {
                break label380;
              }
              localSnsAdSphereAnimView.zkq = new c(localSnsAdSphereAnimView.mContext, localBitmap, m, n, j, k);
            }
          }
        }
        for (;;)
        {
          localSnsAdSphereAnimView.invalidate();
          localSnsAdSphereAnimView = localau.yHQ;
          ac.i("SnsAdSphereAnimView", "start");
          localSnsAdSphereAnimView.invalidate();
          localau.yHQ.setVisibility(0);
          if (au.this.yHW != null) {
            au.this.yHW.onStart();
          }
          AppMethodBeat.o(179192);
          return;
          label380:
          if (i == SnsAdSphereAnimView.zkn) {
            localSnsAdSphereAnimView.zkq = new d(localSnsAdSphereAnimView.mContext, localBitmap, m, n, j, k);
          } else if (i == SnsAdSphereAnimView.zko) {
            localSnsAdSphereAnimView.zeV.postDelayed(new SnsAdSphereAnimView.1(localSnsAdSphereAnimView, localBitmap, m, n, k), 100L);
          } else if (i == SnsAdSphereAnimView.zkp) {
            localSnsAdSphereAnimView.zeV.postDelayed(new SnsAdSphereAnimView.2(localSnsAdSphereAnimView, localBitmap, m, n, k), 100L);
          }
        }
      }
    };
    this.yHV = false;
    this.mContext = paramContext;
    this.yHP = paramSnsAdTouchProgressView;
    this.yHQ = paramSnsAdSphereAnimView;
    this.yHR = paraman;
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
      localJSONObject.put("uxinfo", bs.nullAsNil(paramp.dFQ().dtx));
      localJSONObject.put("scene", paramInt3);
      paramp = new JSONObject();
      paramp.put("result", paramInt1);
      paramp.put("pressTotalTime", paramInt2);
      localJSONObject.put("extInfo", paramp);
      paramp = localJSONObject.toString();
      j.iU("timeline_fullcard_longpress_action", paramp);
      ac.i("SnsAdPressGestureCtrl", "reportAction, content=" + paramp + ", channel=timeline_fullcard_longpress_action");
      AppMethodBeat.o(179206);
      return;
    }
    catch (Exception paramp)
    {
      ac.i("SnsAdPressGestureCtrl", "reportAction, exp=" + paramp.toString());
      AppMethodBeat.o(179206);
    }
  }
  
  private static boolean a(b.n paramn, p paramp)
  {
    AppMethodBeat.i(179202);
    if ((paramn == null) || (paramp == null))
    {
      AppMethodBeat.o(179202);
      return false;
    }
    try
    {
      if (paramn.yhy > 0)
      {
        int i = paramn.yhz;
        int j = paramn.yhy;
        if (i > j) {}
      }
      else
      {
        AppMethodBeat.o(179202);
        return false;
      }
      boolean bool = TextUtils.isEmpty(paramp.dFR().dJT());
      if (bool)
      {
        AppMethodBeat.o(179202);
        return false;
      }
      AppMethodBeat.o(179202);
      return true;
    }
    catch (Exception paramn)
    {
      ac.e("SnsAdPressGestureCtrl", "isValidLongPressGestureAd, exp=" + paramn.toString());
      AppMethodBeat.o(179202);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.d.i parami, final long paramLong1, final long paramLong2)
  {
    AppMethodBeat.i(179203);
    if (!this.yHT)
    {
      AppMethodBeat.o(179203);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179191);
        try
        {
          boolean bool = au.this.yHR.yFe.dNU();
          ac.d("SnsAdPressGestureCtrl", "checkLongPressGesture, start=" + au.this.yHO.yhy + ", end=" + au.this.yHO.yhz + ", duration=" + au.this.yHO.yhA + ", curPlayTime=" + paramLong1 + ", isPlaying=" + bool);
          if ((paramLong1 >= au.this.yHO.yhy) && (bool))
          {
            au localau = au.this;
            if ((localau.yHP != null) && (localau.yHP.getVisibility() != 0))
            {
              ac.i("SnsAdPressGestureCtrl", "enableLongPressGestureView");
              localau.yHP.setVisibility(0);
            }
          }
          for (;;)
          {
            if ((paramLong1 > au.this.yHO.yhz - 250) && (!au.this.yHP.isAnimating()))
            {
              ac.i("SnsAdPressGestureCtrl", "checkLongPressGesture, seekto 0");
              au.this.yHR.yFe.seekTo(0);
              if (paramLong2 != null)
              {
                ac.i("SnsAdPressGestureCtrl", "checkLongPressGesture, addIdCount:" + this.yHZ);
                paramLong2.A(this.yHZ, false);
              }
            }
            AppMethodBeat.o(179191);
            return;
            au.this.dPg();
            au.this.rj(false);
          }
          return;
        }
        catch (Exception localException)
        {
          ac.e("SnsAdPressGestureCtrl", "checkLongPressGesture, exp=" + localException.toString());
          AppMethodBeat.o(179191);
        }
      }
    });
    AppMethodBeat.o(179203);
  }
  
  public final boolean a(final p paramp, b.n paramn, int paramInt)
  {
    AppMethodBeat.i(179201);
    if ((this.xHc == null) || (this.xHc.field_snsId != paramp.field_snsId))
    {
      this.yHO = paramn;
      this.xHc = paramp;
      this.yHN = null;
      this.yHS = paramInt;
      this.yHT = a(paramn, paramp);
      ac.i("SnsAdPressGestureCtrl", "initData, isValidGestureAd=" + this.yHT + ", snsId=" + paramp.field_snsId);
      if (!this.yHT) {
        break label261;
      }
      ac.i("SnsAdPressGestureCtrl", "initData, start=" + this.yHO.yhy + ", end=" + this.yHO.yhz + ", duration=" + this.yHO.yhA + ", pressDuration=" + this.yHO.yhA);
      this.yHP.setActionListener(this.yHU);
      this.yHP.setDuration(paramn.yhA);
      this.yHR.yFe.setTimerInterval(250);
      paramp = paramn.yhB;
      ac.i("SnsAdPressGestureCtrl", "loadSpriteImage:".concat(String.valueOf(paramp)));
      if (!TextUtils.isEmpty(paramp)) {
        h.a(paramp, false, new f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(200477);
            if (au.this.yHO != null)
            {
              String str2 = au.this.yHO.yhB;
              String str1;
              if (TextUtils.isEmpty(str2)) {
                str1 = "";
              }
              while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str1)))
              {
                paramAnonymousString = f.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  au.this.yHN = paramAnonymousString;
                  ac.i("SnsAdPressGestureCtrl", "onDownloaded succ, tagUrl=".concat(String.valueOf(str2)));
                  AppMethodBeat.o(200477);
                  return;
                  str1 = h.js("adId", str2);
                }
                else
                {
                  ac.e("SnsAdPressGestureCtrl", "onDownloaded, bitmap==null");
                  AppMethodBeat.o(200477);
                  return;
                }
              }
              ac.e("SnsAdPressGestureCtrl", "onDownloaded, url changed");
            }
            AppMethodBeat.o(200477);
          }
          
          public final void dFC() {}
          
          public final void dFD()
          {
            AppMethodBeat.i(200476);
            StringBuilder localStringBuilder = new StringBuilder("onDownloadError, snsId=");
            if (au.this.xHc == null) {}
            for (Object localObject = "";; localObject = Long.valueOf(au.this.xHc.field_snsId))
            {
              ac.e("SnsAdPressGestureCtrl", localObject + ", url=" + paramp);
              AppMethodBeat.o(200476);
              return;
            }
          }
        });
      }
    }
    for (;;)
    {
      boolean bool = this.yHT;
      AppMethodBeat.o(179201);
      return bool;
      label261:
      this.yHP.setActionListener(null);
      rj(false);
      dPg();
      this.yHR.yFe.setTimerInterval(1000);
    }
  }
  
  public final boolean dPf()
  {
    AppMethodBeat.i(200478);
    if (this.yHT)
    {
      boolean bool;
      if (this.yHP != null)
      {
        bool = this.yHP.isAnimating();
        if (!bool) {
          break label137;
        }
        if (this.xHc != null) {
          break label123;
        }
      }
      label123:
      for (String str = "";; str = q.wW(this.xHc.field_snsId))
      {
        int i = (int)(System.currentTimeMillis() - this.mStartTime);
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.xNg, str, this.mScene, i, "");
        ac.i("SnsAdPressGestureCtrl", "checkLongPressGesture, videoEnd && isAnimating, snsId=" + str + ", pressDuration=" + i);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200474);
            au.this.yHU.onFinish();
            AppMethodBeat.o(200474);
          }
        });
        AppMethodBeat.o(200478);
        return true;
        bool = false;
        break;
      }
    }
    label137:
    AppMethodBeat.o(200478);
    return false;
  }
  
  public final void dPg()
  {
    AppMethodBeat.i(179204);
    if ((this.yHP != null) && (this.yHP.getVisibility() != 8))
    {
      ac.i("SnsAdPressGestureCtrl", "disableLongPressGestureView");
      this.yHP.clear();
      this.yHP.setVisibility(8);
    }
    AppMethodBeat.o(179204);
  }
  
  public final void rj(boolean paramBoolean)
  {
    AppMethodBeat.i(179205);
    if ((this.yHQ != null) && (this.yHQ.getVisibility() != 8))
    {
      ac.i("SnsAdPressGestureCtrl", "hideSphereAnimView");
      if (!paramBoolean)
      {
        this.yHQ.clear();
        this.yHQ.setVisibility(8);
        AppMethodBeat.o(179205);
        return;
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(200475);
          au.this.yHQ.setVisibility(8);
          au.this.yHQ.clear();
          AppMethodBeat.o(200475);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.yHQ.startAnimation(localAlphaAnimation);
    }
    AppMethodBeat.o(179205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au
 * JD-Core Version:    0.7.0.1
 */