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
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.b.p;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.e.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView.1;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class ax
{
  private volatile boolean AqA;
  protected SnsAdTouchProgressView.a AqB;
  protected boolean AqC;
  public SnsAdTouchProgressView.a AqD;
  Bitmap Aqu;
  b.p Aqv;
  SnsAdTouchProgressView Aqw;
  SnsAdSphereAnimView Aqx;
  aq Aqy;
  View Aqz;
  private Context mContext;
  int mScene;
  protected long mStartTime;
  p zlW;
  
  public ax(Context paramContext, e.a parama, View paramView)
  {
    AppMethodBeat.i(219842);
    this.AqA = false;
    this.AqB = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (ax.this.AqC)
        {
          ae.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (ax.this.Aqv == null)
        {
          ae.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        ae.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + ax.this.Aqv.zPe);
        ax.this.Aqy.AnI.seekTo(ax.this.Aqv.zPe);
        ax.this.rU(true);
        if (ax.this.AqD != null) {
          ax.this.AqD.onCancel();
        }
        ax.a(ax.this.zlW, 1, (int)(System.currentTimeMillis() - ax.this.mStartTime), ax.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        ae.i("SnsAdPressGestureCtrl", "onClick");
        if (ax.this.AqD != null) {
          ax.this.AqD.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!ax.this.AqC)
        {
          ax.this.AqC = true;
          ae.i("SnsAdPressGestureCtrl", "onFinish");
          ax.this.rU(true);
          if (ax.this.AqD != null) {
            ax.this.AqD.onFinish();
          }
          ax.a(ax.this.zlW, 2, (int)(System.currentTimeMillis() - ax.this.mStartTime), ax.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        ae.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        ax.this.mStartTime = System.currentTimeMillis();
        ax.this.AqC = false;
        if (ax.this.Aqv == null)
        {
          ae.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        ae.i("SnsAdPressGestureCtrl", "onStart, seekto=" + ax.this.Aqv.zPf);
        r.e(new long[] { 20L, 100L });
        ax.this.Aqy.AnI.seekTo(ax.this.Aqv.zPf);
        ax localax = ax.this;
        if ((localax.Aqv != null) && (localax.Aqx != null) && (localax.Aqx.getVisibility() != 0))
        {
          ae.i("SnsAdPressGestureCtrl", "showSphereAnimView, scene=" + localax.mScene);
          if (localax.Aqu != null)
          {
            if ((localax.Aqz != null) && (localax.mScene == 1))
            {
              localObject = localax.Aqx.getLayoutParams();
              i = localax.Aqz.getHeight() - localax.Aqz.getPaddingTop() - localax.Aqz.getPaddingBottom();
              if (((ViewGroup.LayoutParams)localObject).height != i)
              {
                ae.d("SnsAdPressGestureCtrl", "SphereAnimView.h=" + ((ViewGroup.LayoutParams)localObject).height + ", root.h=" + localax.Aqz.getHeight() + ", root.padingTop=" + localax.Aqz.getPaddingTop() + ", root.padingBottom=" + localax.Aqz.getPaddingBottom());
                ((ViewGroup.LayoutParams)localObject).height = i;
                localax.Aqx.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
            }
            Object localObject = localax.Aqx;
            Bitmap localBitmap = localax.Aqu;
            int j = localax.Aqv.zPi;
            int i = localax.Aqv.zPg;
            ae.i("SnsAdSphereAnimView", "setData, sceneType=" + j + ", duration=" + i + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              ((SnsAdSphereAnimView)localObject).ATR = j;
              j = com.tencent.mm.cb.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 30);
              int k = com.tencent.mm.cb.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 36);
              if (((SnsAdSphereAnimView)localObject).ATQ != null) {
                ((SnsAdSphereAnimView)localObject).ATQ.clear();
              }
              ((SnsAdSphereAnimView)localObject).AOj.postDelayed(new SnsAdSphereAnimView.1((SnsAdSphereAnimView)localObject, localBitmap, j, k, i), 100L);
            }
            localObject = localax.Aqx;
            ae.i("SnsAdSphereAnimView", "start");
            ((SnsAdSphereAnimView)localObject).invalidate();
            localax.Aqx.setVisibility(0);
          }
        }
        if (ax.this.AqD != null) {
          ax.this.AqD.onStart();
        }
        AppMethodBeat.o(179192);
      }
    };
    this.AqC = false;
    this.mContext = paramContext;
    this.Aqw = parama.AOt;
    this.Aqx = parama.ALp;
    this.Aqy = parama.AKJ;
    this.Aqz = paramView;
    this.mScene = 1;
    AppMethodBeat.o(219842);
  }
  
  public ax(Context paramContext, SnsAdTouchProgressView paramSnsAdTouchProgressView, SnsAdSphereAnimView paramSnsAdSphereAnimView, aq paramaq, View paramView)
  {
    AppMethodBeat.i(219843);
    this.AqA = false;
    this.AqB = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (ax.this.AqC)
        {
          ae.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (ax.this.Aqv == null)
        {
          ae.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        ae.i("SnsAdPressGestureCtrl", "onCancel, seekto=" + ax.this.Aqv.zPe);
        ax.this.Aqy.AnI.seekTo(ax.this.Aqv.zPe);
        ax.this.rU(true);
        if (ax.this.AqD != null) {
          ax.this.AqD.onCancel();
        }
        ax.a(ax.this.zlW, 1, (int)(System.currentTimeMillis() - ax.this.mStartTime), ax.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        ae.i("SnsAdPressGestureCtrl", "onClick");
        if (ax.this.AqD != null) {
          ax.this.AqD.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        if (!ax.this.AqC)
        {
          ax.this.AqC = true;
          ae.i("SnsAdPressGestureCtrl", "onFinish");
          ax.this.rU(true);
          if (ax.this.AqD != null) {
            ax.this.AqD.onFinish();
          }
          ax.a(ax.this.zlW, 2, (int)(System.currentTimeMillis() - ax.this.mStartTime), ax.this.mScene);
          AppMethodBeat.o(179195);
          return;
        }
        ae.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        ax.this.mStartTime = System.currentTimeMillis();
        ax.this.AqC = false;
        if (ax.this.Aqv == null)
        {
          ae.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        ae.i("SnsAdPressGestureCtrl", "onStart, seekto=" + ax.this.Aqv.zPf);
        r.e(new long[] { 20L, 100L });
        ax.this.Aqy.AnI.seekTo(ax.this.Aqv.zPf);
        ax localax = ax.this;
        if ((localax.Aqv != null) && (localax.Aqx != null) && (localax.Aqx.getVisibility() != 0))
        {
          ae.i("SnsAdPressGestureCtrl", "showSphereAnimView, scene=" + localax.mScene);
          if (localax.Aqu != null)
          {
            if ((localax.Aqz != null) && (localax.mScene == 1))
            {
              localObject = localax.Aqx.getLayoutParams();
              i = localax.Aqz.getHeight() - localax.Aqz.getPaddingTop() - localax.Aqz.getPaddingBottom();
              if (((ViewGroup.LayoutParams)localObject).height != i)
              {
                ae.d("SnsAdPressGestureCtrl", "SphereAnimView.h=" + ((ViewGroup.LayoutParams)localObject).height + ", root.h=" + localax.Aqz.getHeight() + ", root.padingTop=" + localax.Aqz.getPaddingTop() + ", root.padingBottom=" + localax.Aqz.getPaddingBottom());
                ((ViewGroup.LayoutParams)localObject).height = i;
                localax.Aqx.setLayoutParams((ViewGroup.LayoutParams)localObject);
              }
            }
            Object localObject = localax.Aqx;
            Bitmap localBitmap = localax.Aqu;
            int j = localax.Aqv.zPi;
            int i = localax.Aqv.zPg;
            ae.i("SnsAdSphereAnimView", "setData, sceneType=" + j + ", duration=" + i + ", bmp=" + localBitmap);
            if (localBitmap != null)
            {
              ((SnsAdSphereAnimView)localObject).ATR = j;
              j = com.tencent.mm.cb.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 30);
              int k = com.tencent.mm.cb.a.fromDPToPix(((SnsAdSphereAnimView)localObject).mContext, 36);
              if (((SnsAdSphereAnimView)localObject).ATQ != null) {
                ((SnsAdSphereAnimView)localObject).ATQ.clear();
              }
              ((SnsAdSphereAnimView)localObject).AOj.postDelayed(new SnsAdSphereAnimView.1((SnsAdSphereAnimView)localObject, localBitmap, j, k, i), 100L);
            }
            localObject = localax.Aqx;
            ae.i("SnsAdSphereAnimView", "start");
            ((SnsAdSphereAnimView)localObject).invalidate();
            localax.Aqx.setVisibility(0);
          }
        }
        if (ax.this.AqD != null) {
          ax.this.AqD.onStart();
        }
        AppMethodBeat.o(179192);
      }
    };
    this.AqC = false;
    this.mContext = paramContext;
    this.Aqw = paramSnsAdTouchProgressView;
    this.Aqx = paramSnsAdSphereAnimView;
    this.Aqy = paramaq;
    this.Aqz = paramView;
    this.mScene = 2;
    AppMethodBeat.o(219843);
  }
  
  public static void a(p paramp, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(179206);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("snsid", paramp.field_snsId);
      localJSONObject.put("uxinfo", bu.nullAsNil(paramp.dVi().dGD));
      localJSONObject.put("scene", paramInt3);
      paramp = new JSONObject();
      paramp.put("result", paramInt1);
      paramp.put("pressTotalTime", paramInt2);
      localJSONObject.put("extInfo", paramp);
      paramp = localJSONObject.toString();
      k.jm("timeline_fullcard_longpress_action", paramp);
      ae.i("SnsAdPressGestureCtrl", "reportAction, content=" + paramp + ", channel=timeline_fullcard_longpress_action");
      AppMethodBeat.o(179206);
      return;
    }
    catch (Exception paramp)
    {
      ae.i("SnsAdPressGestureCtrl", "reportAction, exp=" + paramp.toString());
      AppMethodBeat.o(179206);
    }
  }
  
  private static boolean a(b.p paramp, p paramp1)
  {
    AppMethodBeat.i(179202);
    if ((paramp == null) || (paramp1 == null))
    {
      AppMethodBeat.o(179202);
      return false;
    }
    try
    {
      if (paramp.zPe > 0)
      {
        int i = paramp.zPf;
        int j = paramp.zPe;
        if (i > j) {}
      }
      else
      {
        AppMethodBeat.o(179202);
        return false;
      }
      boolean bool = TextUtils.isEmpty(paramp1.dVj().dZK());
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
      ae.e("SnsAdPressGestureCtrl", "isValidLongPressGestureAd, exp=" + paramp.toString());
      AppMethodBeat.o(179202);
    }
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.sns.ad.e.j paramj, final long paramLong1, final long paramLong2)
  {
    AppMethodBeat.i(179203);
    if (!this.AqA)
    {
      AppMethodBeat.o(179203);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179191);
        try
        {
          boolean bool = ax.this.Aqy.AnI.edN();
          ae.d("SnsAdPressGestureCtrl", "checkLongPressGesture, start=" + ax.this.Aqv.zPe + ", end=" + ax.this.Aqv.zPf + ", duration=" + ax.this.Aqv.zPg + ", curPlayTime=" + paramLong1 + ", isPlaying=" + bool);
          if ((paramLong1 >= ax.this.Aqv.zPe) && (bool))
          {
            ax localax = ax.this;
            if ((localax.Aqw != null) && (localax.Aqw.getVisibility() != 0))
            {
              ae.i("SnsAdPressGestureCtrl", "enableLongPressGestureView, scene=" + localax.mScene);
              if (localax.Aqz != null)
              {
                ViewGroup.LayoutParams localLayoutParams = localax.Aqw.getLayoutParams();
                int i = localax.Aqz.getHeight() - localax.Aqz.getPaddingTop() - localax.Aqz.getPaddingBottom();
                if (localLayoutParams.height != i)
                {
                  ae.d("SnsAdPressGestureCtrl", "ProgressView.h=" + localLayoutParams.height + ", root.h=" + localax.Aqz.getHeight() + ", root.padingTop=" + localax.Aqz.getPaddingTop() + ", root.padingBottom=" + localax.Aqz.getPaddingBottom());
                  localLayoutParams.height = i;
                  localax.Aqw.setLayoutParams(localLayoutParams);
                }
              }
              localax.Aqw.setVisibility(0);
            }
          }
          for (;;)
          {
            if ((paramLong1 > ax.this.Aqv.zPf - 250) && (!ax.this.Aqw.isAnimating()))
            {
              ae.i("SnsAdPressGestureCtrl", "checkLongPressGesture, seekto 0");
              ax.this.Aqy.AnI.seekTo(0);
              if (paramLong2 != null)
              {
                ae.i("SnsAdPressGestureCtrl", "checkLongPressGesture, addIdCount:" + this.AqG);
                paramLong2.C(this.AqG, false);
              }
            }
            AppMethodBeat.o(179191);
            return;
            ax.this.efe();
            ax.this.rU(false);
          }
          return;
        }
        catch (Exception localException)
        {
          ae.e("SnsAdPressGestureCtrl", "checkLongPressGesture, exp=" + localException.toString());
          AppMethodBeat.o(179191);
        }
      }
    });
    AppMethodBeat.o(179203);
  }
  
  public final boolean a(final p paramp, b.p paramp1, Rect paramRect)
  {
    AppMethodBeat.i(219844);
    if ((this.zlW == null) || (this.zlW.field_snsId != paramp.field_snsId))
    {
      this.Aqv = paramp1;
      this.zlW = paramp;
      this.Aqu = null;
      this.AqA = a(paramp1, paramp);
      ae.i("SnsAdPressGestureCtrl", "initData, isValidGestureAd=" + this.AqA + ", snsId=" + paramp.field_snsId);
      if (!this.AqA) {
        break label276;
      }
      ae.i("SnsAdPressGestureCtrl", "initData, start=" + this.Aqv.zPe + ", end=" + this.Aqv.zPf + ", duration=" + this.Aqv.zPg + ", pressDuration=" + this.Aqv.zPg + ", touchRect=" + paramRect.toShortString());
      this.Aqw.setActionListener(this.AqB);
      this.Aqw.setDuration(paramp1.zPg);
      this.Aqw.setTouchRange(paramRect);
      this.Aqy.AnI.setTimerInterval(250);
      paramp = paramp1.zPh;
      ae.i("SnsAdPressGestureCtrl", "loadSpriteImage:".concat(String.valueOf(paramp)));
      if (!TextUtils.isEmpty(paramp)) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramp, false, new f.a()
        {
          public final void ayY(String paramAnonymousString)
          {
            AppMethodBeat.i(219841);
            if (ax.this.Aqv != null)
            {
              String str2 = ax.this.Aqv.zPh;
              String str1;
              if (TextUtils.isEmpty(str2)) {
                str1 = "";
              }
              while ((!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.equals(str1)))
              {
                paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString, null);
                if (paramAnonymousString != null)
                {
                  ax.this.Aqu = paramAnonymousString;
                  ae.i("SnsAdPressGestureCtrl", "onDownloaded succ, tagUrl=".concat(String.valueOf(str2)));
                  AppMethodBeat.o(219841);
                  return;
                  str1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", str2);
                }
                else
                {
                  ae.e("SnsAdPressGestureCtrl", "onDownloaded, bitmap==null");
                  AppMethodBeat.o(219841);
                  return;
                }
              }
              ae.e("SnsAdPressGestureCtrl", "onDownloaded, url changed");
            }
            AppMethodBeat.o(219841);
          }
          
          public final void dVu() {}
          
          public final void dVv()
          {
            AppMethodBeat.i(219840);
            StringBuilder localStringBuilder = new StringBuilder("onDownloadError, snsId=");
            if (ax.this.zlW == null) {}
            for (Object localObject = "";; localObject = Long.valueOf(ax.this.zlW.field_snsId))
            {
              ae.e("SnsAdPressGestureCtrl", localObject + ", url=" + paramp);
              AppMethodBeat.o(219840);
              return;
            }
          }
        });
      }
    }
    for (;;)
    {
      boolean bool = this.AqA;
      AppMethodBeat.o(219844);
      return bool;
      label276:
      this.Aqw.setActionListener(null);
      rU(false);
      efe();
      this.Aqy.AnI.setTimerInterval(1000);
    }
  }
  
  public final boolean efd()
  {
    AppMethodBeat.i(219845);
    if (this.AqA)
    {
      boolean bool;
      if (this.Aqw != null)
      {
        bool = this.Aqw.isAnimating();
        if (!bool) {
          break label137;
        }
        if (this.zlW != null) {
          break label123;
        }
      }
      label123:
      for (String str = "";; str = r.zV(this.zlW.field_snsId))
      {
        int i = (int)(System.currentTimeMillis() - this.mStartTime);
        com.tencent.mm.plugin.sns.data.j.b(com.tencent.mm.plugin.sns.data.j.ztP, str, this.mScene, i, "");
        ae.i("SnsAdPressGestureCtrl", "checkLongPressGesture, videoEnd && isAnimating, snsId=" + str + ", pressDuration=" + i);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219838);
            ax.this.AqB.onFinish();
            AppMethodBeat.o(219838);
          }
        });
        AppMethodBeat.o(219845);
        return true;
        bool = false;
        break;
      }
    }
    label137:
    AppMethodBeat.o(219845);
    return false;
  }
  
  public final void efe()
  {
    AppMethodBeat.i(179204);
    if ((this.Aqw != null) && (this.Aqw.getVisibility() != 8))
    {
      ae.i("SnsAdPressGestureCtrl", "disableLongPressGestureView");
      this.Aqw.clear();
      this.Aqw.setVisibility(8);
    }
    AppMethodBeat.o(179204);
  }
  
  public final void rU(boolean paramBoolean)
  {
    AppMethodBeat.i(179205);
    if ((this.Aqx != null) && (this.Aqx.getVisibility() != 8))
    {
      ae.i("SnsAdPressGestureCtrl", "hideSphereAnimView");
      if (!paramBoolean)
      {
        this.Aqx.clear();
        this.Aqx.setVisibility(8);
        AppMethodBeat.o(179205);
        return;
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(219839);
          ax.this.Aqx.setVisibility(8);
          ax.this.Aqx.clear();
          AppMethodBeat.o(219839);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Aqx.startAnimation(localAlphaAnimation);
    }
    AppMethodBeat.o(179205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ax
 * JD-Core Version:    0.7.0.1
 */