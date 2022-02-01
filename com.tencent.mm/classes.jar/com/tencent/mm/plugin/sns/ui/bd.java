package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.j.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class bd
{
  View KKQ;
  SnsInfo PJQ;
  Handler PRJ;
  ADXml.p RmV;
  SnsAdTouchProgressView RmW;
  aw RmX;
  public volatile boolean RmY;
  Drawable RmZ;
  protected SnsAdTouchProgressView.a Rna;
  protected boolean Rnb;
  private String Rnc;
  public SnsAdTouchProgressView.a Rnd;
  private Context mContext;
  int mScene;
  protected long mStartTime;
  
  public bd(Context paramContext, SnsAdTouchProgressView paramSnsAdTouchProgressView, aw paramaw, int paramInt, View paramView)
  {
    AppMethodBeat.i(308357);
    this.RmY = false;
    this.Rna = new SnsAdTouchProgressView.a()
    {
      public final void onCancel()
      {
        AppMethodBeat.i(179193);
        if (bd.this.KKQ != null) {
          bd.this.KKQ.setBackground(null);
        }
        bd.this.PRJ.removeCallbacksAndMessages(null);
        Log.i("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish=" + bd.this.Rnb);
        if (bd.this.Rnb)
        {
          Log.e("SnsAdPressGestureCtrl", "onCancel, isCalledOnFinish==true");
          AppMethodBeat.o(179193);
          return;
        }
        if (bd.this.RmV == null)
        {
          Log.e("SnsAdPressGestureCtrl", "onCancel, mGestureInfo == null");
          AppMethodBeat.o(179193);
          return;
        }
        if (bd.this.Rnd != null) {
          bd.this.Rnd.onCancel();
        }
        bd.a(bd.this.PJQ, 1, (int)(System.currentTimeMillis() - bd.this.mStartTime), bd.this.mScene);
        AppMethodBeat.o(179193);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179194);
        Log.i("SnsAdPressGestureCtrl", "onClick");
        if (bd.this.Rnd != null) {
          bd.this.Rnd.onClick(paramAnonymousView);
        }
        AppMethodBeat.o(179194);
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179195);
        Log.i("SnsAdPressGestureCtrl", "onFinish, isCalledOnFinish=" + bd.this.Rnb);
        if (!bd.this.Rnb)
        {
          bd.this.Rnb = true;
          bd.this.PRJ.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(307929);
              Log.i("SnsAdPressGestureCtrl", "onFinish, vabriate");
              t.g(new long[] { 0L, 60L });
              if (bd.this.KKQ != null) {
                bd.this.KKQ.setBackground(null);
              }
              AppMethodBeat.o(307929);
            }
          }, 100L);
          if (bd.this.Rnd != null) {
            bd.this.Rnd.onFinish();
          }
          if (bd.this.RmW == null) {}
          for (int i = 0;; i = bd.this.RmW.getLongPressTime())
          {
            bd.a(bd.this.PJQ, 2, (int)(i + System.currentTimeMillis() - bd.this.mStartTime), bd.this.mScene);
            AppMethodBeat.o(179195);
            return;
          }
        }
        Log.e("SnsAdPressGestureCtrl", "onFinish, secondTimes");
        AppMethodBeat.o(179195);
      }
      
      public final void onStart()
      {
        AppMethodBeat.i(179192);
        bd.this.mStartTime = System.currentTimeMillis();
        bd.this.Rnb = false;
        bd.this.PRJ.removeCallbacksAndMessages(null);
        if (bd.this.RmV == null)
        {
          Log.e("SnsAdPressGestureCtrl", "onStart, mGestureInfo == null");
          AppMethodBeat.o(179192);
          return;
        }
        Log.i("SnsAdPressGestureCtrl", "onStart, isCalledOnFinish=" + bd.this.Rnb);
        if (bd.this.Rnd != null) {
          bd.this.Rnd.onStart();
        }
        t.g(new long[] { 0L, 60L });
        if (bd.this.KKQ != null)
        {
          bd.this.KKQ.setVisibility(0);
          bd.this.KKQ.setBackground(bd.this.RmZ);
        }
        AppMethodBeat.o(179192);
      }
    };
    this.Rnb = false;
    this.Rnc = "";
    this.mContext = paramContext;
    this.RmW = paramSnsAdTouchProgressView;
    this.RmX = paramaw;
    this.mScene = paramInt;
    this.KKQ = paramView;
    this.PRJ = new Handler(Looper.getMainLooper());
    this.RmZ = new ColorDrawable(Color.parseColor("#1a000000"));
    AppMethodBeat.o(308357);
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
      m.lU("timeline_fullcard_longpress_action", paramSnsInfo);
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
      if (paramp.QIj > 0)
      {
        int i = paramp.QIk;
        int j = paramp.QIj;
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
  
  public final boolean a(final SnsInfo paramSnsInfo, ADXml.p paramp)
  {
    AppMethodBeat.i(308362);
    if ((this.PJQ == null) || (this.PJQ.field_snsId != paramSnsInfo.field_snsId))
    {
      this.RmV = paramp;
      this.PJQ = paramSnsInfo;
      this.RmY = a(paramp, paramSnsInfo);
      Log.i("SnsAdPressGestureCtrl", "initData, isValidGestureAd=" + this.RmY + ", snsId=" + paramSnsInfo.field_snsId);
      if (this.RmW == null)
      {
        Log.e("SnsAdPressGestureCtrl", "initData, imLongTouchProgressView==null");
        AppMethodBeat.o(308362);
        return false;
      }
      if (!this.RmY) {
        break label306;
      }
      Log.i("SnsAdPressGestureCtrl", "initData, start=" + this.RmV.QIj + ", end=" + this.RmV.QIk + ", minimumDuration=" + this.RmV.QIm + ", pressDuration=" + this.RmV.QIl);
      this.RmW.setActionListener(this.Rna);
      this.RmW.setPressDuration(paramp.QIm);
      this.RmX.RjN.setTimerInterval(250);
      paramSnsInfo = paramp.PMx;
      if (!TextUtils.isEmpty(paramSnsInfo))
      {
        if (!paramSnsInfo.equals(this.Rnc)) {
          break label267;
        }
        Log.d("SnsAdPressGestureCtrl", "loadSpriteImage, hasPreload, url=".concat(String.valueOf(paramSnsInfo)));
      }
    }
    for (;;)
    {
      boolean bool = this.RmY;
      AppMethodBeat.o(308362);
      return bool;
      label267:
      this.Rnc = paramSnsInfo;
      Log.i("SnsAdPressGestureCtrl", "loadSpriteImage:".concat(String.valueOf(paramSnsInfo)));
      a.a(paramSnsInfo, "adId", new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(308350);
          Log.i("SnsAdPressGestureCtrl", "onDownloaded succ");
          AppMethodBeat.o(308350);
        }
        
        public final void gZM() {}
        
        public final void gZN()
        {
          AppMethodBeat.i(308346);
          StringBuilder localStringBuilder = new StringBuilder("onDownloadError, snsId=");
          if (bd.this.PJQ == null) {}
          for (Object localObject = "";; localObject = Long.valueOf(bd.this.PJQ.field_snsId))
          {
            Log.e("SnsAdPressGestureCtrl", localObject + ", url=" + paramSnsInfo);
            AppMethodBeat.o(308346);
            return;
          }
        }
      });
      continue;
      label306:
      this.RmW.setActionListener(null);
      hnX();
      this.RmX.RjN.setTimerInterval(1000);
    }
  }
  
  public final void hnX()
  {
    AppMethodBeat.i(179204);
    if ((this.RmW != null) && (this.RmW.getVisibility() != 8))
    {
      Log.i("SnsAdPressGestureCtrl", "disableLongPressGestureView, w=" + this.RmW.getWidth() + ", h=" + this.RmW.getHeight());
      this.RmW.clear();
      this.RmW.setVisibility(8);
    }
    AppMethodBeat.o(179204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bd
 * JD-Core Version:    0.7.0.1
 */