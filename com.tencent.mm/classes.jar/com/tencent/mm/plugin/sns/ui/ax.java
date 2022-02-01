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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.b.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.e.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView.1;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import org.json.JSONObject;

public final class ax
{
  private Context mContext;
  int mScene;
  protected long mStartTime;
  p yVM;
  Bitmap zZh;
  b.n zZi;
  SnsAdTouchProgressView zZj;
  SnsAdSphereAnimView zZk;
  aq zZl;
  View zZm;
  private volatile boolean zZn;
  protected SnsAdTouchProgressView.a zZo;
  protected boolean zZp;
  public SnsAdTouchProgressView.a zZq;
  
  public ax(Context paramContext, e.a parama, View paramView)
  {
    AppMethodBeat.i(198307);
    this.zZn = false;
    this.zZo = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (ax.this.zZp)
        {
          ad.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (ax.this.zZi == null)
        {
          ad.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        ad.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + ax.this.zZi.zxF);
        ax.this.zZl.zWz.seekTo(ax.this.zZi.zxF);
        ax.this.rN(true);
        if (ax.this.zZq != null) {
          ax.this.zZq.onCancel();
        }
        ax.a(ax.this.yVM, 1, (int)(System.currentTimeMillis() - ax.this.mStartTime), ax.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        ad.i("SnsAdPressGestureCtrl", "onClick");
        if (ax.this.zZq != null) {
          ax.this.zZq.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!ax.this.zZp)
        {
          ax.this.zZp = true;
          ad.i("SnsAdPressGestureCtrl", "onFinish");
          ax.this.rN(true);
          if (ax.this.zZq != null) {
            ax.this.zZq.onFinish();
          }
          ax.a(ax.this.yVM, 2, (int)(System.currentTimeMillis() - ax.this.mStartTime), ax.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        ad.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        ax.this.mStartTime = System.currentTimeMillis();
        ax.this.zZp = false;
        if (ax.this.zZi == null)
        {
          ad.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        ad.i("SnsAdPressGestureCtrl", "onStart, seekto=" + ax.this.zZi.zxG);
        q.d(new long[] { 20L, 100L });
        ax.this.zZl.zWz.seekTo(ax.this.zZi.zxG);
        ax localax = ax.this;
        if ((localax.zZi != null) && (localax.zZk != null) && (localax.zZk.getVisibility() != 0))
        {
          ad.i("SnsAdPressGestureCtrl", "showSphereAnimView, scene=" + localax.mScene);
          if (localax.zZh != null)
          {
            if ((localax.zZm != null) && (localax.mScene == 1))
            {
              localObject = localax.zZk.getLayoutParams();
              i = localax.zZm.getHeight() - localax.zZm.getPaddingTop() - localax.zZm.getPaddingBottom();
              if (((ViewGroup.LayoutParams)localObject).height != i)
              {
                ad.d("SnsAdPressGestureCtrl", "SphereAnimView.h=" + ((ViewGroup.LayoutParams)localObject).height + ", root.h=" + localax.zZm.getHeight() + ", root.padingTop=" + localax.zZm.getPaddingTop() + ", root.padingBottom=" + localax.zZm.getPaddingBottom());
                ((ViewGroup.LayoutParams)localObject).height = i;
                localax.zZk.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
            }
            Object localObject = localax.zZk;
            Bitmap localBitmap = localax.zZh;
            int j = localax.zZi.zxJ;
            int i = localax.zZi.zxH;
            ad.i("SnsAdSphereAnimView", "setData, sceneType=" + j + ", duration=" + i + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              ((SnsAdSphereAnimView)localObject).ACq = j;
              j = com.tencent.mm.cc.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 30);
              int k = com.tencent.mm.cc.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 36);
              if (((SnsAdSphereAnimView)localObject).ACp != null) {
                ((SnsAdSphereAnimView)localObject).ACp.clear();
              }
              ((SnsAdSphereAnimView)localObject).AwR.postDelayed(new SnsAdSphereAnimView.1((SnsAdSphereAnimView)localObject, localBitmap, j, k, i), 100L);
            }
            localObject = localax.zZk;
            ad.i("SnsAdSphereAnimView", "start");
            ((SnsAdSphereAnimView)localObject).invalidate();
            localax.zZk.setVisibility(0);
          }
        }
        if (ax.this.zZq != null) {
          ax.this.zZq.onStart();
        }
        AppMethodBeat.o(179192);
      }
    };
    this.zZp = false;
    this.mContext = paramContext;
    this.zZj = parama.Axb;
    this.zZk = parama.Aua;
    this.zZl = parama.Atv;
    this.zZm = paramView;
    this.mScene = 1;
    AppMethodBeat.o(198307);
  }
  
  public ax(Context paramContext, SnsAdTouchProgressView paramSnsAdTouchProgressView, SnsAdSphereAnimView paramSnsAdSphereAnimView, aq paramaq, View paramView)
  {
    AppMethodBeat.i(198308);
    this.zZn = false;
    this.zZo = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (ax.this.zZp)
        {
          ad.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (ax.this.zZi == null)
        {
          ad.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        ad.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + ax.this.zZi.zxF);
        ax.this.zZl.zWz.seekTo(ax.this.zZi.zxF);
        ax.this.rN(true);
        if (ax.this.zZq != null) {
          ax.this.zZq.onCancel();
        }
        ax.a(ax.this.yVM, 1, (int)(System.currentTimeMillis() - ax.this.mStartTime), ax.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        ad.i("SnsAdPressGestureCtrl", "onClick");
        if (ax.this.zZq != null) {
          ax.this.zZq.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!ax.this.zZp)
        {
          ax.this.zZp = true;
          ad.i("SnsAdPressGestureCtrl", "onFinish");
          ax.this.rN(true);
          if (ax.this.zZq != null) {
            ax.this.zZq.onFinish();
          }
          ax.a(ax.this.yVM, 2, (int)(System.currentTimeMillis() - ax.this.mStartTime), ax.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        ad.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        ax.this.mStartTime = System.currentTimeMillis();
        ax.this.zZp = false;
        if (ax.this.zZi == null)
        {
          ad.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        ad.i("SnsAdPressGestureCtrl", "onStart, seekto=" + ax.this.zZi.zxG);
        q.d(new long[] { 20L, 100L });
        ax.this.zZl.zWz.seekTo(ax.this.zZi.zxG);
        ax localax = ax.this;
        if ((localax.zZi != null) && (localax.zZk != null) && (localax.zZk.getVisibility() != 0))
        {
          ad.i("SnsAdPressGestureCtrl", "showSphereAnimView, scene=" + localax.mScene);
          if (localax.zZh != null)
          {
            if ((localax.zZm != null) && (localax.mScene == 1))
            {
              localObject = localax.zZk.getLayoutParams();
              i = localax.zZm.getHeight() - localax.zZm.getPaddingTop() - localax.zZm.getPaddingBottom();
              if (((ViewGroup.LayoutParams)localObject).height != i)
              {
                ad.d("SnsAdPressGestureCtrl", "SphereAnimView.h=" + ((ViewGroup.LayoutParams)localObject).height + ", root.h=" + localax.zZm.getHeight() + ", root.padingTop=" + localax.zZm.getPaddingTop() + ", root.padingBottom=" + localax.zZm.getPaddingBottom());
                ((ViewGroup.LayoutParams)localObject).height = i;
                localax.zZk.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
            }
            Object localObject = localax.zZk;
            Bitmap localBitmap = localax.zZh;
            int j = localax.zZi.zxJ;
            int i = localax.zZi.zxH;
            ad.i("SnsAdSphereAnimView", "setData, sceneType=" + j + ", duration=" + i + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              ((SnsAdSphereAnimView)localObject).ACq = j;
              j = com.tencent.mm.cc.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 30);
              int k = com.tencent.mm.cc.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 36);
              if (((SnsAdSphereAnimView)localObject).ACp != null) {
                ((SnsAdSphereAnimView)localObject).ACp.clear();
              }
              ((SnsAdSphereAnimView)localObject).AwR.postDelayed(new SnsAdSphereAnimView.1((SnsAdSphereAnimView)localObject, localBitmap, j, k, i), 100L);
            }
            localObject = localax.zZk;
            ad.i("SnsAdSphereAnimView", "start");
            ((SnsAdSphereAnimView)localObject).invalidate();
            localax.zZk.setVisibility(0);
          }
        }
        if (ax.this.zZq != null) {
          ax.this.zZq.onStart();
        }
        AppMethodBeat.o(179192);
      }
    };
    this.zZp = false;
    this.mContext = paramContext;
    this.zZj = paramSnsAdTouchProgressView;
    this.zZk = paramSnsAdSphereAnimView;
    this.zZl = paramaq;
    this.zZm = paramView;
    this.mScene = 2;
    AppMethodBeat.o(198308);
  }
  
  public static void a(p paramp, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(179206);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("snsid", paramp.field_snsId);
      localJSONObject.put("uxinfo", bt.nullAsNil(paramp.dRK().dFy));
      localJSONObject.put("scene", paramInt3);
      paramp = new JSONObject();
      paramp.put("result", paramInt1);
      paramp.put("pressTotalTime", paramInt2);
      localJSONObject.put("extInfo", paramp);
      paramp = localJSONObject.toString();
      j.jf("timeline_fullcard_longpress_action", paramp);
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
      if (paramn.zxF > 0)
      {
        int i = paramn.zxG;
        int j = paramn.zxF;
        if (i > j) {}
      }
      else
      {
        AppMethodBeat.o(179202);
        return false;
      }
      boolean bool = TextUtils.isEmpty(paramp.dRL().dWj());
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
      ad.e("SnsAdPressGestureCtrl", "isValidLongPressGestureAd, exp=" + paramn.toString());
      AppMethodBeat.o(179202);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.d.i parami, final long paramLong1, final long paramLong2)
  {
    AppMethodBeat.i(179203);
    if (!this.zZn)
    {
      AppMethodBeat.o(179203);
      return;
    }
    com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179191);
        try
        {
          boolean bool = ax.this.zZl.zWz.eah();
          ad.d("SnsAdPressGestureCtrl", "checkLongPressGesture, start=" + ax.this.zZi.zxF + ", end=" + ax.this.zZi.zxG + ", duration=" + ax.this.zZi.zxH + ", curPlayTime=" + paramLong1 + ", isPlaying=" + bool);
          if ((paramLong1 >= ax.this.zZi.zxF) && (bool))
          {
            ax localax = ax.this;
            if ((localax.zZj != null) && (localax.zZj.getVisibility() != 0))
            {
              ad.i("SnsAdPressGestureCtrl", "enableLongPressGestureView, scene=" + localax.mScene);
              if (localax.zZm != null)
              {
                ViewGroup.LayoutParams localLayoutParams = localax.zZj.getLayoutParams();
                int i = localax.zZm.getHeight() - localax.zZm.getPaddingTop() - localax.zZm.getPaddingBottom();
                if (localLayoutParams.height != i)
                {
                  ad.d("SnsAdPressGestureCtrl", "ProgressView.h=" + localLayoutParams.height + ", root.h=" + localax.zZm.getHeight() + ", root.padingTop=" + localax.zZm.getPaddingTop() + ", root.padingBottom=" + localax.zZm.getPaddingBottom());
                  localLayoutParams.height = i;
                  localax.zZj.setLayoutParams(localLayoutParams);
                }
              }
              localax.zZj.setVisibility(0);
            }
          }
          for (;;)
          {
            if ((paramLong1 > ax.this.zZi.zxG - 250) && (!ax.this.zZj.isAnimating()))
            {
              ad.i("SnsAdPressGestureCtrl", "checkLongPressGesture, seekto 0");
              ax.this.zZl.zWz.seekTo(0);
              if (paramLong2 != null)
              {
                ad.i("SnsAdPressGestureCtrl", "checkLongPressGesture, addIdCount:" + this.zZt);
                paramLong2.A(this.zZt, false);
              }
            }
            AppMethodBeat.o(179191);
            return;
            ax.this.ebx();
            ax.this.rN(false);
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
  
  public final boolean a(final p paramp, b.n paramn, Rect paramRect)
  {
    AppMethodBeat.i(198309);
    if ((this.yVM == null) || (this.yVM.field_snsId != paramp.field_snsId))
    {
      this.zZi = paramn;
      this.yVM = paramp;
      this.zZh = null;
      this.zZn = a(paramn, paramp);
      ad.i("SnsAdPressGestureCtrl", "initData, isValidGestureAd=" + this.zZn + ", snsId=" + paramp.field_snsId);
      if (!this.zZn) {
        break label276;
      }
      ad.i("SnsAdPressGestureCtrl", "initData, start=" + this.zZi.zxF + ", end=" + this.zZi.zxG + ", duration=" + this.zZi.zxH + ", pressDuration=" + this.zZi.zxH + ", touchRect=" + paramRect.toShortString());
      this.zZj.setActionListener(this.zZo);
      this.zZj.setDuration(paramn.zxH);
      this.zZj.setTouchRange(paramRect);
      this.zZl.zWz.setTimerInterval(250);
      paramp = paramn.zxI;
      ad.i("SnsAdPressGestureCtrl", "loadSpriteImage:".concat(String.valueOf(paramp)));
      if (!TextUtils.isEmpty(paramp)) {
        h.a(paramp, false, new f.a()
        {
          public final void axG(String paramAnonymousString)
          {
            AppMethodBeat.i(198306);
            if (ax.this.zZi != null)
            {
              String str2 = ax.this.zZi.zxI;
              String str1;
              if (TextUtils.isEmpty(str2)) {
                str1 = "";
              }
              while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str1)))
              {
                paramAnonymousString = g.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  ax.this.zZh = paramAnonymousString;
                  ad.i("SnsAdPressGestureCtrl", "onDownloaded succ, tagUrl=".concat(String.valueOf(str2)));
                  AppMethodBeat.o(198306);
                  return;
                  str1 = h.jF("adId", str2);
                }
                else
                {
                  ad.e("SnsAdPressGestureCtrl", "onDownloaded, bitmap==null");
                  AppMethodBeat.o(198306);
                  return;
                }
              }
              ad.e("SnsAdPressGestureCtrl", "onDownloaded, url changed");
            }
            AppMethodBeat.o(198306);
          }
          
          public final void dRW() {}
          
          public final void dRX()
          {
            AppMethodBeat.i(198305);
            StringBuilder localStringBuilder = new StringBuilder("onDownloadError, snsId=");
            if (ax.this.yVM == null) {}
            for (Object localObject = "";; localObject = Long.valueOf(ax.this.yVM.field_snsId))
            {
              ad.e("SnsAdPressGestureCtrl", localObject + ", url=" + paramp);
              AppMethodBeat.o(198305);
              return;
            }
          }
        });
      }
    }
    for (;;)
    {
      boolean bool = this.zZn;
      AppMethodBeat.o(198309);
      return bool;
      label276:
      this.zZj.setActionListener(null);
      rN(false);
      ebx();
      this.zZl.zWz.setTimerInterval(1000);
    }
  }
  
  public final boolean ebw()
  {
    AppMethodBeat.i(198310);
    if (this.zZn)
    {
      boolean bool;
      if (this.zZj != null)
      {
        bool = this.zZj.isAnimating();
        if (!bool) {
          break label137;
        }
        if (this.yVM != null) {
          break label123;
        }
      }
      label123:
      for (String str = "";; str = q.zw(this.yVM.field_snsId))
      {
        int i = (int)(System.currentTimeMillis() - this.mStartTime);
        com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zcZ, str, this.mScene, i, "");
        ad.i("SnsAdPressGestureCtrl", "checkLongPressGesture, videoEnd && isAnimating, snsId=" + str + ", pressDuration=" + i);
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198303);
            ax.this.zZo.onFinish();
            AppMethodBeat.o(198303);
          }
        });
        AppMethodBeat.o(198310);
        return true;
        bool = false;
        break;
      }
    }
    label137:
    AppMethodBeat.o(198310);
    return false;
  }
  
  public final void ebx()
  {
    AppMethodBeat.i(179204);
    if ((this.zZj != null) && (this.zZj.getVisibility() != 8))
    {
      ad.i("SnsAdPressGestureCtrl", "disableLongPressGestureView");
      this.zZj.clear();
      this.zZj.setVisibility(8);
    }
    AppMethodBeat.o(179204);
  }
  
  public final void rN(boolean paramBoolean)
  {
    AppMethodBeat.i(179205);
    if ((this.zZk != null) && (this.zZk.getVisibility() != 8))
    {
      ad.i("SnsAdPressGestureCtrl", "hideSphereAnimView");
      if (!paramBoolean)
      {
        this.zZk.clear();
        this.zZk.setVisibility(8);
        AppMethodBeat.o(179205);
        return;
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(198304);
          ax.this.zZk.setVisibility(8);
          ax.this.zZk.clear();
          AppMethodBeat.o(198304);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.zZk.startAnimation(localAlphaAnimation);
    }
    AppMethodBeat.o(179205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ax
 * JD-Core Version:    0.7.0.1
 */