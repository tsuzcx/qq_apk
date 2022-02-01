package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView.1;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class bc
{
  SnsInfo Jws;
  Bitmap KNi;
  ADXml.p KNj;
  SnsAdTouchProgressView KNk;
  SnsAdSphereAnimView KNl;
  av KNm;
  View KNn;
  private volatile boolean KNo;
  protected SnsAdTouchProgressView.a KNp;
  protected boolean KNq;
  public SnsAdTouchProgressView.a KNr;
  private Context mContext;
  int mScene;
  protected long mStartTime;
  
  public bc(Context paramContext, SnsAdTouchProgressView paramSnsAdTouchProgressView, SnsAdSphereAnimView paramSnsAdSphereAnimView, av paramav, int paramInt, View paramView)
  {
    AppMethodBeat.i(203259);
    this.KNo = false;
    this.KNp = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (bc.this.KNq)
        {
          Log.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (bc.this.KNj == null)
        {
          Log.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        Log.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + bc.this.KNj.Kkl);
        bc.this.KNm.KKl.seekTo(bc.this.KNj.Kkl);
        bc.this.yU(true);
        if (bc.this.KNr != null) {
          bc.this.KNr.onCancel();
        }
        bc.a(bc.this.Jws, 1, (int)(System.currentTimeMillis() - bc.this.mStartTime), bc.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        Log.i("SnsAdPressGestureCtrl", "onClick");
        if (bc.this.KNr != null) {
          bc.this.KNr.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!bc.this.KNq)
        {
          bc.this.KNq = true;
          Log.i("SnsAdPressGestureCtrl", "onFinish");
          bc.this.yU(true);
          if (bc.this.KNr != null) {
            bc.this.KNr.onFinish();
          }
          bc.a(bc.this.Jws, 2, (int)(System.currentTimeMillis() - bc.this.mStartTime), bc.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        Log.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        bc.this.mStartTime = System.currentTimeMillis();
        bc.this.KNq = false;
        if (bc.this.KNj == null)
        {
          Log.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        Log.i("SnsAdPressGestureCtrl", "onStart, seekto=" + bc.this.KNj.Kkm);
        t.e(new long[] { 20L, 100L });
        bc.this.KNm.KKl.seekTo(bc.this.KNj.Kkm);
        bc localbc = bc.this;
        if ((localbc.KNj != null) && (localbc.KNl != null) && (localbc.KNl.getVisibility() != 0))
        {
          Log.i("SnsAdPressGestureCtrl", "showSphereAnimView, scene=" + localbc.mScene);
          if (localbc.KNi != null)
          {
            if ((localbc.KNn != null) && (localbc.mScene == 1))
            {
              localObject = localbc.KNl.getLayoutParams();
              i = localbc.KNn.getHeight() - localbc.KNn.getPaddingTop() - localbc.KNn.getPaddingBottom();
              if (((ViewGroup.LayoutParams)localObject).height != i)
              {
                Log.d("SnsAdPressGestureCtrl", "SphereAnimView.h=" + ((ViewGroup.LayoutParams)localObject).height + ", root.h=" + localbc.KNn.getHeight() + ", root.padingTop=" + localbc.KNn.getPaddingTop() + ", root.padingBottom=" + localbc.KNn.getPaddingBottom());
                ((ViewGroup.LayoutParams)localObject).height = i;
                localbc.KNl.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
            }
            Object localObject = localbc.KNl;
            Bitmap localBitmap = localbc.KNi;
            int j = localbc.KNj.Kkp;
            int i = localbc.KNj.Kkn;
            Log.i("SnsAdSphereAnimView", "setData, sceneType=" + j + ", duration=" + i + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              ((SnsAdSphereAnimView)localObject).Ltc = j;
              j = com.tencent.mm.ci.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 30);
              int k = com.tencent.mm.ci.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 36);
              if (((SnsAdSphereAnimView)localObject).Ltb != null) {
                ((SnsAdSphereAnimView)localObject).Ltb.clear();
              }
              ((SnsAdSphereAnimView)localObject).JMp.postDelayed(new SnsAdSphereAnimView.1((SnsAdSphereAnimView)localObject, localBitmap, j, k, i), 100L);
            }
            localObject = localbc.KNl;
            Log.i("SnsAdSphereAnimView", "start");
            ((SnsAdSphereAnimView)localObject).invalidate();
            localbc.KNl.setVisibility(0);
          }
        }
        if (bc.this.KNr != null) {
          bc.this.KNr.onStart();
        }
        AppMethodBeat.o(179192);
      }
    };
    this.KNq = false;
    this.mContext = paramContext;
    this.KNk = paramSnsAdTouchProgressView;
    this.KNl = paramSnsAdSphereAnimView;
    this.KNm = paramav;
    this.KNn = paramView;
    this.mScene = paramInt;
    AppMethodBeat.o(203259);
  }
  
  public static void a(SnsInfo paramSnsInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(179206);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("snsid", paramSnsInfo.field_snsId);
      localJSONObject.put("uxinfo", Util.nullAsNil(paramSnsInfo.getAdInfo().uxInfo));
      localJSONObject.put("scene", paramInt3);
      paramSnsInfo = new JSONObject();
      paramSnsInfo.put("result", paramInt1);
      paramSnsInfo.put("pressTotalTime", paramInt2);
      localJSONObject.put("extInfo", paramSnsInfo);
      paramSnsInfo = localJSONObject.toString();
      m.ks("timeline_fullcard_longpress_action", paramSnsInfo);
      Log.i("SnsAdPressGestureCtrl", "reportAction, content=" + paramSnsInfo + ", channel=timeline_fullcard_longpress_action");
      AppMethodBeat.o(179206);
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.i("SnsAdPressGestureCtrl", "reportAction, exp=" + paramSnsInfo.toString());
      AppMethodBeat.o(179206);
    }
  }
  
  private static boolean a(ADXml.p paramp, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(179202);
    if ((paramp == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(179202);
      return false;
    }
    try
    {
      if (paramp.Kkl > 0)
      {
        int i = paramp.Kkm;
        int j = paramp.Kkl;
        if (i > j) {}
      }
      else
      {
        AppMethodBeat.o(179202);
        return false;
      }
      boolean bool = TextUtils.isEmpty(paramSnsInfo.getAdXml().getGestureCanvasInfo());
      if (bool)
      {
        AppMethodBeat.o(179202);
        return false;
      }
      AppMethodBeat.o(179202);
      return true;
    }
    catch (Exception paramp)
    {
      Log.e("SnsAdPressGestureCtrl", "isValidLongPressGestureAd, exp=" + paramp.toString());
      AppMethodBeat.o(179202);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.f.l paraml, final long paramLong1, final long paramLong2)
  {
    AppMethodBeat.i(179203);
    if (!this.KNo)
    {
      AppMethodBeat.o(179203);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179191);
        try
        {
          boolean bool = bc.this.KNm.KKl.fUc();
          Log.d("SnsAdPressGestureCtrl", "checkLongPressGesture, start=" + bc.this.KNj.Kkl + ", end=" + bc.this.KNj.Kkm + ", duration=" + bc.this.KNj.Kkn + ", curPlayTime=" + paramLong1 + ", isPlaying=" + bool);
          if ((paramLong1 >= bc.this.KNj.Kkl) && (bool))
          {
            bc localbc = bc.this;
            if ((localbc.KNk != null) && (localbc.KNk.getVisibility() != 0))
            {
              Log.i("SnsAdPressGestureCtrl", "enableLongPressGestureView, scene=" + localbc.mScene);
              if (localbc.KNn != null)
              {
                ViewGroup.LayoutParams localLayoutParams = localbc.KNk.getLayoutParams();
                int i = localbc.KNn.getHeight() - localbc.KNn.getPaddingTop() - localbc.KNn.getPaddingBottom();
                if (localLayoutParams.height != i)
                {
                  Log.d("SnsAdPressGestureCtrl", "ProgressView.h=" + localLayoutParams.height + ", root.h=" + localbc.KNn.getHeight() + ", root.padingTop=" + localbc.KNn.getPaddingTop() + ", root.padingBottom=" + localbc.KNn.getPaddingBottom());
                  localLayoutParams.height = i;
                  localbc.KNk.setLayoutParams(localLayoutParams);
                }
              }
              localbc.KNk.setVisibility(0);
            }
          }
          for (;;)
          {
            if ((paramLong1 > bc.this.KNj.Kkm - 250) && (!bc.this.KNk.fEq()))
            {
              Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, seekto 0");
              bc.this.KNm.KKl.seekTo(0);
              if (paramLong2 != null)
              {
                Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, addIdCount:" + this.KNu);
                paramLong2.I(this.KNu, false);
              }
            }
            AppMethodBeat.o(179191);
            return;
            bc.this.fVJ();
            bc.this.yU(false);
          }
          return;
        }
        catch (Exception localException)
        {
          Log.e("SnsAdPressGestureCtrl", "checkLongPressGesture, exp=" + localException.toString());
          AppMethodBeat.o(179191);
        }
      }
    });
    AppMethodBeat.o(179203);
  }
  
  public final boolean a(final SnsInfo paramSnsInfo, ADXml.p paramp, Rect paramRect)
  {
    AppMethodBeat.i(203271);
    if ((this.Jws == null) || (this.Jws.field_snsId != paramSnsInfo.field_snsId))
    {
      this.KNj = paramp;
      this.Jws = paramSnsInfo;
      this.KNi = null;
      this.KNo = a(paramp, paramSnsInfo);
      Log.i("SnsAdPressGestureCtrl", "initData, isValidGestureAd=" + this.KNo + ", snsId=" + paramSnsInfo.field_snsId);
      if (!this.KNo) {
        break label276;
      }
      Log.i("SnsAdPressGestureCtrl", "initData, start=" + this.KNj.Kkl + ", end=" + this.KNj.Kkm + ", duration=" + this.KNj.Kkn + ", pressDuration=" + this.KNj.Kkn + ", touchRect=" + paramRect.toShortString());
      this.KNk.setActionListener(this.KNp);
      this.KNk.setDuration(paramp.Kkn);
      this.KNk.setTouchRange(paramRect);
      this.KNm.KKl.setTimerInterval(250);
      paramSnsInfo = paramp.Kko;
      Log.i("SnsAdPressGestureCtrl", "loadSpriteImage:".concat(String.valueOf(paramSnsInfo)));
      if (!TextUtils.isEmpty(paramSnsInfo)) {
        h.a(paramSnsInfo, false, new f.a()
        {
          public final void aYs(String paramAnonymousString)
          {
            AppMethodBeat.i(269922);
            if (bc.this.KNj != null)
            {
              String str2 = bc.this.KNj.Kko;
              String str1;
              if (TextUtils.isEmpty(str2)) {
                str1 = "";
              }
              while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str1)))
              {
                paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  bc.this.KNi = paramAnonymousString;
                  Log.i("SnsAdPressGestureCtrl", "onDownloaded succ, tagUrl=".concat(String.valueOf(str2)));
                  AppMethodBeat.o(269922);
                  return;
                  str1 = h.kU("adId", str2);
                }
                else
                {
                  Log.e("SnsAdPressGestureCtrl", "onDownloaded, bitmap==null");
                  AppMethodBeat.o(269922);
                  return;
                }
              }
              Log.e("SnsAdPressGestureCtrl", "onDownloaded, url changed");
            }
            AppMethodBeat.o(269922);
          }
          
          public final void fJU() {}
          
          public final void fJV()
          {
            AppMethodBeat.i(269921);
            StringBuilder localStringBuilder = new StringBuilder("onDownloadError, snsId=");
            if (bc.this.Jws == null) {}
            for (Object localObject = "";; localObject = Long.valueOf(bc.this.Jws.field_snsId))
            {
              Log.e("SnsAdPressGestureCtrl", localObject + ", url=" + paramSnsInfo);
              AppMethodBeat.o(269921);
              return;
            }
          }
        });
      }
    }
    for (;;)
    {
      boolean bool = this.KNo;
      AppMethodBeat.o(203271);
      return bool;
      label276:
      this.KNk.setActionListener(null);
      yU(false);
      fVJ();
      this.KNm.KKl.setTimerInterval(1000);
    }
  }
  
  public final boolean fVI()
  {
    AppMethodBeat.i(203281);
    if (this.KNo)
    {
      boolean bool;
      if (this.KNk != null)
      {
        bool = this.KNk.fEq();
        if (!bool) {
          break label137;
        }
        if (this.Jws != null) {
          break label123;
        }
      }
      label123:
      for (String str = "";; str = t.Qu(this.Jws.field_snsId))
      {
        int i = (int)(System.currentTimeMillis() - this.mStartTime);
        com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.JQI, str, this.mScene, i, "");
        Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, videoEnd && isAnimating, snsId=" + str + ", pressDuration=" + i);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(269507);
            bc.this.KNp.onFinish();
            AppMethodBeat.o(269507);
          }
        });
        AppMethodBeat.o(203281);
        return true;
        bool = false;
        break;
      }
    }
    label137:
    AppMethodBeat.o(203281);
    return false;
  }
  
  public final void fVJ()
  {
    AppMethodBeat.i(179204);
    if ((this.KNk != null) && (this.KNk.getVisibility() != 8))
    {
      Log.i("SnsAdPressGestureCtrl", "disableLongPressGestureView");
      this.KNk.clear();
      this.KNk.setVisibility(8);
    }
    AppMethodBeat.o(179204);
  }
  
  public final void yU(boolean paramBoolean)
  {
    AppMethodBeat.i(179205);
    if ((this.KNl != null) && (this.KNl.getVisibility() != 8))
    {
      Log.i("SnsAdPressGestureCtrl", "hideSphereAnimView");
      if (!paramBoolean)
      {
        this.KNl.clear();
        this.KNl.setVisibility(8);
        AppMethodBeat.o(179205);
        return;
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(226304);
          bc.this.KNl.setVisibility(8);
          bc.this.KNl.clear();
          AppMethodBeat.o(226304);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.KNl.startAnimation(localAlphaAnimation);
    }
    AppMethodBeat.o(179205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bc
 * JD-Core Version:    0.7.0.1
 */