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
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.p;
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

public final class ba
{
  SnsInfo DqO;
  protected SnsAdTouchProgressView.a EzA;
  protected boolean EzB;
  public SnsAdTouchProgressView.a EzC;
  Bitmap Ezt;
  ADXml.p Ezu;
  SnsAdTouchProgressView Ezv;
  SnsAdSphereAnimView Ezw;
  at Ezx;
  View Ezy;
  private volatile boolean Ezz;
  private Context mContext;
  int mScene;
  protected long mStartTime;
  
  public ba(Context paramContext, com.tencent.mm.plugin.sns.ui.item.f.a parama, View paramView)
  {
    AppMethodBeat.i(203477);
    this.Ezz = false;
    this.EzA = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (ba.this.EzB)
        {
          Log.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (ba.this.Ezu == null)
        {
          Log.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        Log.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + ba.this.Ezu.DXc);
        ba.this.Ezx.Ewt.seekTo(ba.this.Ezu.DXc);
        ba.this.vq(true);
        if (ba.this.EzC != null) {
          ba.this.EzC.onCancel();
        }
        ba.a(ba.this.DqO, 1, (int)(System.currentTimeMillis() - ba.this.mStartTime), ba.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        Log.i("SnsAdPressGestureCtrl", "onClick");
        if (ba.this.EzC != null) {
          ba.this.EzC.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!ba.this.EzB)
        {
          ba.this.EzB = true;
          Log.i("SnsAdPressGestureCtrl", "onFinish");
          ba.this.vq(true);
          if (ba.this.EzC != null) {
            ba.this.EzC.onFinish();
          }
          ba.a(ba.this.DqO, 2, (int)(System.currentTimeMillis() - ba.this.mStartTime), ba.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        Log.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        ba.this.mStartTime = System.currentTimeMillis();
        ba.this.EzB = false;
        if (ba.this.Ezu == null)
        {
          Log.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        Log.i("SnsAdPressGestureCtrl", "onStart, seekto=" + ba.this.Ezu.DXd);
        r.e(new long[] { 20L, 100L });
        ba.this.Ezx.Ewt.seekTo(ba.this.Ezu.DXd);
        ba localba = ba.this;
        if ((localba.Ezu != null) && (localba.Ezw != null) && (localba.Ezw.getVisibility() != 0))
        {
          Log.i("SnsAdPressGestureCtrl", "showSphereAnimView, scene=" + localba.mScene);
          if (localba.Ezt != null)
          {
            if ((localba.Ezy != null) && (localba.mScene == 1))
            {
              localObject = localba.Ezw.getLayoutParams();
              i = localba.Ezy.getHeight() - localba.Ezy.getPaddingTop() - localba.Ezy.getPaddingBottom();
              if (((ViewGroup.LayoutParams)localObject).height != i)
              {
                Log.d("SnsAdPressGestureCtrl", "SphereAnimView.h=" + ((ViewGroup.LayoutParams)localObject).height + ", root.h=" + localba.Ezy.getHeight() + ", root.padingTop=" + localba.Ezy.getPaddingTop() + ", root.padingBottom=" + localba.Ezy.getPaddingBottom());
                ((ViewGroup.LayoutParams)localObject).height = i;
                localba.Ezw.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
            }
            Object localObject = localba.Ezw;
            Bitmap localBitmap = localba.Ezt;
            int j = localba.Ezu.DXg;
            int i = localba.Ezu.DXe;
            Log.i("SnsAdSphereAnimView", "setData, sceneType=" + j + ", duration=" + i + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              ((SnsAdSphereAnimView)localObject).Fex = j;
              j = com.tencent.mm.cb.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 30);
              int k = com.tencent.mm.cb.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 36);
              if (((SnsAdSphereAnimView)localObject).Few != null) {
                ((SnsAdSphereAnimView)localObject).Few.clear();
              }
              ((SnsAdSphereAnimView)localObject).DAC.postDelayed(new SnsAdSphereAnimView.1((SnsAdSphereAnimView)localObject, localBitmap, j, k, i), 100L);
            }
            localObject = localba.Ezw;
            Log.i("SnsAdSphereAnimView", "start");
            ((SnsAdSphereAnimView)localObject).invalidate();
            localba.Ezw.setVisibility(0);
          }
        }
        if (ba.this.EzC != null) {
          ba.this.EzC.onStart();
        }
        AppMethodBeat.o(179192);
      }
    };
    this.EzB = false;
    this.mContext = paramContext;
    this.Ezv = parama.EYN;
    this.Ezw = parama.EVt;
    this.Ezx = parama.EUK;
    this.Ezy = paramView;
    this.mScene = 1;
    AppMethodBeat.o(203477);
  }
  
  public ba(Context paramContext, SnsAdTouchProgressView paramSnsAdTouchProgressView, SnsAdSphereAnimView paramSnsAdSphereAnimView, at paramat, View paramView)
  {
    AppMethodBeat.i(203478);
    this.Ezz = false;
    this.EzA = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (ba.this.EzB)
        {
          Log.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (ba.this.Ezu == null)
        {
          Log.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        Log.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + ba.this.Ezu.DXc);
        ba.this.Ezx.Ewt.seekTo(ba.this.Ezu.DXc);
        ba.this.vq(true);
        if (ba.this.EzC != null) {
          ba.this.EzC.onCancel();
        }
        ba.a(ba.this.DqO, 1, (int)(System.currentTimeMillis() - ba.this.mStartTime), ba.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        Log.i("SnsAdPressGestureCtrl", "onClick");
        if (ba.this.EzC != null) {
          ba.this.EzC.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!ba.this.EzB)
        {
          ba.this.EzB = true;
          Log.i("SnsAdPressGestureCtrl", "onFinish");
          ba.this.vq(true);
          if (ba.this.EzC != null) {
            ba.this.EzC.onFinish();
          }
          ba.a(ba.this.DqO, 2, (int)(System.currentTimeMillis() - ba.this.mStartTime), ba.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        Log.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        ba.this.mStartTime = System.currentTimeMillis();
        ba.this.EzB = false;
        if (ba.this.Ezu == null)
        {
          Log.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        Log.i("SnsAdPressGestureCtrl", "onStart, seekto=" + ba.this.Ezu.DXd);
        r.e(new long[] { 20L, 100L });
        ba.this.Ezx.Ewt.seekTo(ba.this.Ezu.DXd);
        ba localba = ba.this;
        if ((localba.Ezu != null) && (localba.Ezw != null) && (localba.Ezw.getVisibility() != 0))
        {
          Log.i("SnsAdPressGestureCtrl", "showSphereAnimView, scene=" + localba.mScene);
          if (localba.Ezt != null)
          {
            if ((localba.Ezy != null) && (localba.mScene == 1))
            {
              localObject = localba.Ezw.getLayoutParams();
              i = localba.Ezy.getHeight() - localba.Ezy.getPaddingTop() - localba.Ezy.getPaddingBottom();
              if (((ViewGroup.LayoutParams)localObject).height != i)
              {
                Log.d("SnsAdPressGestureCtrl", "SphereAnimView.h=" + ((ViewGroup.LayoutParams)localObject).height + ", root.h=" + localba.Ezy.getHeight() + ", root.padingTop=" + localba.Ezy.getPaddingTop() + ", root.padingBottom=" + localba.Ezy.getPaddingBottom());
                ((ViewGroup.LayoutParams)localObject).height = i;
                localba.Ezw.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
            }
            Object localObject = localba.Ezw;
            Bitmap localBitmap = localba.Ezt;
            int j = localba.Ezu.DXg;
            int i = localba.Ezu.DXe;
            Log.i("SnsAdSphereAnimView", "setData, sceneType=" + j + ", duration=" + i + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              ((SnsAdSphereAnimView)localObject).Fex = j;
              j = com.tencent.mm.cb.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 30);
              int k = com.tencent.mm.cb.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 36);
              if (((SnsAdSphereAnimView)localObject).Few != null) {
                ((SnsAdSphereAnimView)localObject).Few.clear();
              }
              ((SnsAdSphereAnimView)localObject).DAC.postDelayed(new SnsAdSphereAnimView.1((SnsAdSphereAnimView)localObject, localBitmap, j, k, i), 100L);
            }
            localObject = localba.Ezw;
            Log.i("SnsAdSphereAnimView", "start");
            ((SnsAdSphereAnimView)localObject).invalidate();
            localba.Ezw.setVisibility(0);
          }
        }
        if (ba.this.EzC != null) {
          ba.this.EzC.onStart();
        }
        AppMethodBeat.o(179192);
      }
    };
    this.EzB = false;
    this.mContext = paramContext;
    this.Ezv = paramSnsAdTouchProgressView;
    this.Ezw = paramSnsAdSphereAnimView;
    this.Ezx = paramat;
    this.Ezy = paramView;
    this.mScene = 2;
    AppMethodBeat.o(203478);
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
      com.tencent.mm.plugin.sns.data.k.jY("timeline_fullcard_longpress_action", paramSnsInfo);
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
      if (paramp.DXc > 0)
      {
        int i = paramp.DXd;
        int j = paramp.DXc;
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
  
  public final void a(com.tencent.mm.plugin.sns.ad.g.k paramk, final long paramLong1, final long paramLong2)
  {
    AppMethodBeat.i(179203);
    if (!this.Ezz)
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
          boolean bool = ba.this.Ezx.Ewt.fgf();
          Log.d("SnsAdPressGestureCtrl", "checkLongPressGesture, start=" + ba.this.Ezu.DXc + ", end=" + ba.this.Ezu.DXd + ", duration=" + ba.this.Ezu.DXe + ", curPlayTime=" + paramLong1 + ", isPlaying=" + bool);
          if ((paramLong1 >= ba.this.Ezu.DXc) && (bool))
          {
            ba localba = ba.this;
            if ((localba.Ezv != null) && (localba.Ezv.getVisibility() != 0))
            {
              Log.i("SnsAdPressGestureCtrl", "enableLongPressGestureView, scene=" + localba.mScene);
              if (localba.Ezy != null)
              {
                ViewGroup.LayoutParams localLayoutParams = localba.Ezv.getLayoutParams();
                int i = localba.Ezy.getHeight() - localba.Ezy.getPaddingTop() - localba.Ezy.getPaddingBottom();
                if (localLayoutParams.height != i)
                {
                  Log.d("SnsAdPressGestureCtrl", "ProgressView.h=" + localLayoutParams.height + ", root.h=" + localba.Ezy.getHeight() + ", root.padingTop=" + localba.Ezy.getPaddingTop() + ", root.padingBottom=" + localba.Ezy.getPaddingBottom());
                  localLayoutParams.height = i;
                  localba.Ezv.setLayoutParams(localLayoutParams);
                }
              }
              localba.Ezv.setVisibility(0);
            }
          }
          for (;;)
          {
            if ((paramLong1 > ba.this.Ezu.DXd - 250) && (!ba.this.Ezv.isAnimating()))
            {
              Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, seekto 0");
              ba.this.Ezx.Ewt.seekTo(0);
              if (paramLong2 != null)
              {
                Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, addIdCount:" + this.EzF);
                paramLong2.I(this.EzF, false);
              }
            }
            AppMethodBeat.o(179191);
            return;
            ba.this.fhy();
            ba.this.vq(false);
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
    AppMethodBeat.i(203479);
    if ((this.DqO == null) || (this.DqO.field_snsId != paramSnsInfo.field_snsId))
    {
      this.Ezu = paramp;
      this.DqO = paramSnsInfo;
      this.Ezt = null;
      this.Ezz = a(paramp, paramSnsInfo);
      Log.i("SnsAdPressGestureCtrl", "initData, isValidGestureAd=" + this.Ezz + ", snsId=" + paramSnsInfo.field_snsId);
      if (!this.Ezz) {
        break label276;
      }
      Log.i("SnsAdPressGestureCtrl", "initData, start=" + this.Ezu.DXc + ", end=" + this.Ezu.DXd + ", duration=" + this.Ezu.DXe + ", pressDuration=" + this.Ezu.DXe + ", touchRect=" + paramRect.toShortString());
      this.Ezv.setActionListener(this.EzA);
      this.Ezv.setDuration(paramp.DXe);
      this.Ezv.setTouchRange(paramRect);
      this.Ezx.Ewt.setTimerInterval(250);
      paramSnsInfo = paramp.DXf;
      Log.i("SnsAdPressGestureCtrl", "loadSpriteImage:".concat(String.valueOf(paramSnsInfo)));
      if (!TextUtils.isEmpty(paramSnsInfo)) {
        h.a(paramSnsInfo, false, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a()
        {
          public final void aNH(String paramAnonymousString)
          {
            AppMethodBeat.i(203476);
            if (ba.this.Ezu != null)
            {
              String str2 = ba.this.Ezu.DXf;
              String str1;
              if (TextUtils.isEmpty(str2)) {
                str1 = "";
              }
              while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str1)))
              {
                paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  ba.this.Ezt = paramAnonymousString;
                  Log.i("SnsAdPressGestureCtrl", "onDownloaded succ, tagUrl=".concat(String.valueOf(str2)));
                  AppMethodBeat.o(203476);
                  return;
                  str1 = h.kz("adId", str2);
                }
                else
                {
                  Log.e("SnsAdPressGestureCtrl", "onDownloaded, bitmap==null");
                  AppMethodBeat.o(203476);
                  return;
                }
              }
              Log.e("SnsAdPressGestureCtrl", "onDownloaded, url changed");
            }
            AppMethodBeat.o(203476);
          }
          
          public final void eWN() {}
          
          public final void eWO()
          {
            AppMethodBeat.i(203475);
            StringBuilder localStringBuilder = new StringBuilder("onDownloadError, snsId=");
            if (ba.this.DqO == null) {}
            for (Object localObject = "";; localObject = Long.valueOf(ba.this.DqO.field_snsId))
            {
              Log.e("SnsAdPressGestureCtrl", localObject + ", url=" + paramSnsInfo);
              AppMethodBeat.o(203475);
              return;
            }
          }
        });
      }
    }
    for (;;)
    {
      boolean bool = this.Ezz;
      AppMethodBeat.o(203479);
      return bool;
      label276:
      this.Ezv.setActionListener(null);
      vq(false);
      fhy();
      this.Ezx.Ewt.setTimerInterval(1000);
    }
  }
  
  public final boolean fhx()
  {
    AppMethodBeat.i(203480);
    if (this.Ezz)
    {
      boolean bool;
      if (this.Ezv != null)
      {
        bool = this.Ezv.isAnimating();
        if (!bool) {
          break label137;
        }
        if (this.DqO != null) {
          break label123;
        }
      }
      label123:
      for (String str = "";; str = r.Jb(this.DqO.field_snsId))
      {
        int i = (int)(System.currentTimeMillis() - this.mStartTime);
        j.b(j.DDZ, str, this.mScene, i, "");
        Log.i("SnsAdPressGestureCtrl", "checkLongPressGesture, videoEnd && isAnimating, snsId=" + str + ", pressDuration=" + i);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203473);
            ba.this.EzA.onFinish();
            AppMethodBeat.o(203473);
          }
        });
        AppMethodBeat.o(203480);
        return true;
        bool = false;
        break;
      }
    }
    label137:
    AppMethodBeat.o(203480);
    return false;
  }
  
  public final void fhy()
  {
    AppMethodBeat.i(179204);
    if ((this.Ezv != null) && (this.Ezv.getVisibility() != 8))
    {
      Log.i("SnsAdPressGestureCtrl", "disableLongPressGestureView");
      this.Ezv.clear();
      this.Ezv.setVisibility(8);
    }
    AppMethodBeat.o(179204);
  }
  
  public final void vq(boolean paramBoolean)
  {
    AppMethodBeat.i(179205);
    if ((this.Ezw != null) && (this.Ezw.getVisibility() != 8))
    {
      Log.i("SnsAdPressGestureCtrl", "hideSphereAnimView");
      if (!paramBoolean)
      {
        this.Ezw.clear();
        this.Ezw.setVisibility(8);
        AppMethodBeat.o(179205);
        return;
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(203474);
          ba.this.Ezw.setVisibility(8);
          ba.this.Ezw.clear();
          AppMethodBeat.o(203474);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Ezw.startAnimation(localAlphaAnimation);
    }
    AppMethodBeat.o(179205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba
 * JD-Core Version:    0.7.0.1
 */