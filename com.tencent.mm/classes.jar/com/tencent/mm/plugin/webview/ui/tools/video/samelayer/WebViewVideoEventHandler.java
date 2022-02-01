package com.tencent.mm.plugin.webview.ui.tools.video.samelayer;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.a;
import com.tencent.mm.bj.a.a;
import com.tencent.mm.plugin.webview.k.k;
import com.tencent.mm.plugin.webview.ui.tools.video.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "", "()V", "TAG", "", "brightnessObserver", "Landroid/database/ContentObserver;", "currentOrientation", "", "fullscreenStatusListener", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "invokeContext", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewExtendPluginInvokeContext;", "mCurrentVideoPathPlayCount", "mEventDataObject", "Lorg/json/JSONObject;", "mLastPlayVideoPath", "mLastUpdatePos", "mUpdateTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mVideoDuration", "", "orientationListenerHelper", "Lcom/tencent/mm/orientation/OrientationListenerHelper;", "getOrientationListenerHelper", "()Lcom/tencent/mm/orientation/OrientationListenerHelper;", "setOrientationListenerHelper", "(Lcom/tencent/mm/orientation/OrientationListenerHelper;)V", "pluginHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoPluginHandler;", "preOrientation", "volumeBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "destroy", "", "dispatchEvent", "name", "data", "generateWaitingReadyExtInfo", "getBaseEventData", "initBrightnessObserver", "initOrientationListenerHelper", "context", "Landroid/content/Context;", "initVolumeBroadcastReceiver", "isLockRotation", "", "onBufferReadyReport", "onPlayerProcessStateChanged", "event", "onPlayingReport", "onStartDownloadReport", "onStartPlayerReport", "onVideoDownStreamChange", "selectIndex", "onVideoEnded", "onVideoError", "errorMsg", "what", "extra", "onVideoLoadedMetaData", "width", "height", "duration", "onVideoPause", "isStop", "onVideoPlay", "isAutoPlay", "onVideoPreloadedMetaData", "cachedSize", "", "onVideoProgress", "percent", "onVideoSeekEnd", "onVideoSizeChange", "onVideoTimeUpdate", "currentPosition", "onVideoWaiting", "onWaitingBufferReadyReport", "onWaitingMoovReport", "onWaitingPlayReport", "onWaitingPreDataReport", "onWaitingReadyReport", "removeFullScreenListener", "resetInvokeContext", "setFullScreenListener", "setInvokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "setVideoPluginHandler", "handler", "startKeepScreenOn", "startUpdateTimer", "stopKeepScreenOn", "stopUpdateTimer", "unregisterBrightnessObserver", "unregisterVolumeBroadcastReceiver", "BrightnessObserver", "Companion", "VolumeBroadcastReceiver", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WebViewVideoEventHandler
{
  public static final WebViewVideoEventHandler.b Xox;
  private int PSI;
  final String TAG;
  a WXe;
  String XoA;
  int XoB;
  private JSONObject XoC;
  c XoD;
  ContentObserver XoE;
  BroadcastReceiver XoF;
  f Xoy;
  j Xoz;
  private int cEQ;
  private MTimerHandler sEn;
  double sQM;
  private int sQg;
  
  static
  {
    AppMethodBeat.i(297217);
    Xox = new WebViewVideoEventHandler.b((byte)0);
    AppMethodBeat.o(297217);
  }
  
  public WebViewVideoEventHandler()
  {
    AppMethodBeat.i(297152);
    this.TAG = s.X("MicroMsg.WebViewVideoEventHandler:", Integer.valueOf(hashCode()));
    this.XoD = ((c)new d(this));
    this.PSI = -1;
    AppMethodBeat.o(297152);
  }
  
  private static final void a(WebViewVideoEventHandler paramWebViewVideoEventHandler, a.a parama1, a.a parama2)
  {
    AppMethodBeat.i(297197);
    s.u(paramWebViewVideoEventHandler, "this$0");
    if (parama2 == null) {}
    for (int i = -1;; i = c.$EnumSwitchMapping$0[parama2.ordinal()]) {
      switch (i)
      {
      default: 
        AppMethodBeat.o(297197);
        return;
      }
    }
    i = 90;
    for (;;)
    {
      paramWebViewVideoEventHandler.cEQ = i;
      if (paramWebViewVideoEventHandler.cEQ != paramWebViewVideoEventHandler.PSI) {
        break;
      }
      AppMethodBeat.o(297197);
      return;
      i = -90;
      continue;
      i = 0;
      continue;
      i = 180;
    }
    paramWebViewVideoEventHandler.PSI = paramWebViewVideoEventHandler.cEQ;
    Log.i(paramWebViewVideoEventHandler.TAG, s.X("onOrientationsChange currentOrientation=", Integer.valueOf(paramWebViewVideoEventHandler.cEQ)));
    for (;;)
    {
      try
      {
        parama1 = paramWebViewVideoEventHandler.cws();
        parama1.put("newOrientation", paramWebViewVideoEventHandler.cEQ);
        i = Settings.System.getInt(MMApplicationContext.getContext().getContentResolver(), "accelerometer_rotation", 0);
        Log.i(paramWebViewVideoEventHandler.TAG, s.X("accRotation=", Integer.valueOf(i)));
        if (i == 0)
        {
          i = 1;
          break label250;
          parama1.put("sysLock", i);
          paramWebViewVideoEventHandler.n("onOrientationsChange", parama1);
          AppMethodBeat.o(297197);
        }
        else
        {
          i = 0;
        }
      }
      catch (JSONException parama1)
      {
        Log.e(paramWebViewVideoEventHandler.TAG, "OnXWebVideoError fail", new Object[] { parama1 });
        AppMethodBeat.o(297197);
        return;
      }
      i = 0;
      continue;
      label250:
      if (i != 0) {
        i = 1;
      }
    }
  }
  
  private static final boolean a(WebViewVideoEventHandler paramWebViewVideoEventHandler)
  {
    AppMethodBeat.i(297172);
    s.u(paramWebViewVideoEventHandler, "this$0");
    Object localObject;
    int i;
    int j;
    if (paramWebViewVideoEventHandler.Xoz != null)
    {
      localObject = paramWebViewVideoEventHandler.Xoz;
      s.checkNotNull(localObject);
      i = ((j)localObject).getCurrentPosition();
      j = (int)(paramWebViewVideoEventHandler.sQM * 1000.0D);
    }
    try
    {
      if (Math.abs(i - paramWebViewVideoEventHandler.sQg) >= 250)
      {
        paramWebViewVideoEventHandler.sQg = i;
        double d1 = j * 1.0D / 1000.0D;
        double d2 = new BigDecimal(i * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
        localObject = paramWebViewVideoEventHandler.cws();
        ((JSONObject)localObject).put("position", d2);
        ((JSONObject)localObject).put("duration", d1);
        paramWebViewVideoEventHandler.n("onVideoTimeUpdate", (JSONObject)localObject);
      }
      AppMethodBeat.o(297172);
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e(paramWebViewVideoEventHandler.TAG, "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
      }
    }
  }
  
  private static final void b(WebViewVideoEventHandler paramWebViewVideoEventHandler)
  {
    AppMethodBeat.i(297179);
    s.u(paramWebViewVideoEventHandler, "this$0");
    if (paramWebViewVideoEventHandler.Xoy != null)
    {
      f localf = paramWebViewVideoEventHandler.Xoy;
      s.checkNotNull(localf);
      if ((localf.Xnu.context instanceof Activity))
      {
        Log.i(paramWebViewVideoEventHandler.TAG, "startKeepScreenOn");
        try
        {
          localf = paramWebViewVideoEventHandler.Xoy;
          s.checkNotNull(localf);
          ((Activity)localf.Xnu.context).getWindow().addFlags(128);
          AppMethodBeat.o(297179);
          return;
        }
        catch (Exception localException)
        {
          Log.e(paramWebViewVideoEventHandler.TAG, "startKeepScreenOn exception", new Object[] { localException });
        }
      }
    }
    AppMethodBeat.o(297179);
  }
  
  private static final void c(WebViewVideoEventHandler paramWebViewVideoEventHandler)
  {
    AppMethodBeat.i(297186);
    s.u(paramWebViewVideoEventHandler, "this$0");
    if (paramWebViewVideoEventHandler.Xoy != null)
    {
      f localf = paramWebViewVideoEventHandler.Xoy;
      s.checkNotNull(localf);
      if ((localf.Xnu.context instanceof Activity))
      {
        Log.i(paramWebViewVideoEventHandler.TAG, "startKeepScreenOn");
        try
        {
          localf = paramWebViewVideoEventHandler.Xoy;
          s.checkNotNull(localf);
          ((Activity)localf.Xnu.context).getWindow().clearFlags(128);
          AppMethodBeat.o(297186);
          return;
        }
        catch (Exception localException)
        {
          Log.e(paramWebViewVideoEventHandler.TAG, "startKeepScreenOn exception", new Object[] { localException });
        }
      }
    }
    AppMethodBeat.o(297186);
  }
  
  private final void cyR()
  {
    AppMethodBeat.i(297166);
    MMHandlerThread.postToMainThread(new WebViewVideoEventHandler..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(297166);
  }
  
  final JSONObject cws()
  {
    AppMethodBeat.i(297290);
    JSONObject localJSONObject = new JSONObject();
    if (this.XoC != null) {
      localJSONObject.put("data", this.XoC);
    }
    AppMethodBeat.o(297290);
    return localJSONObject;
  }
  
  final void cwt()
  {
    AppMethodBeat.i(297285);
    Log.i(this.TAG, "stop video update timer");
    MTimerHandler localMTimerHandler = this.sEn;
    if (localMTimerHandler != null) {
      localMTimerHandler.stopTimer();
    }
    AppMethodBeat.o(297285);
  }
  
  public final void dx(long paramLong)
  {
    AppMethodBeat.i(297259);
    Log.d(this.TAG, s.X("onVideoPreLoadedMetaData cachedSize=", Long.valueOf(paramLong)));
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 6L, 1L, false);
    if (paramLong > 0L) {
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1379L, 7L, 1L, false);
    }
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("preloadSize", paramLong);
      n("onVideoPreLoadedMetaData", localJSONObject);
      AppMethodBeat.o(297259);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "onVideoPreLoadedMetaData fail", new Object[] { localJSONException });
      AppMethodBeat.o(297259);
    }
  }
  
  public final void fT(String paramString)
  {
    AppMethodBeat.i(297271);
    if (paramString != null) {
      try
      {
        this.XoC = new JSONObject(paramString);
        AppMethodBeat.o(297271);
        return;
      }
      catch (Exception paramString)
      {
        Log.e(this.TAG, "setVideoEventData fail", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(297271);
  }
  
  public final void iBS()
  {
    AppMethodBeat.i(297247);
    Object localObject = this.Xoy;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((f)localObject).Xnu)
    {
      if (localObject != null)
      {
        Context localContext = MMApplicationContext.getContext();
        s.s(localContext, "getContext()");
        ((com.tencent.mm.plugin.webview.jsapi.h)localObject).setContext(localContext);
      }
      AppMethodBeat.o(297247);
      return;
    }
  }
  
  public final void iBT()
  {
    AppMethodBeat.i(297255);
    try
    {
      this.sQg = 0;
      n("onVideoPlay", cws());
      Log.i(this.TAG, "start video update timer");
      if (this.sEn == null)
      {
        Log.i(this.TAG, "start video update timer, create new timer");
        this.sEn = new MTimerHandler("VideoUpdateTimer", new WebViewVideoEventHandler..ExternalSyntheticLambda1(this), true);
      }
      Object localObject = this.sEn;
      if (localObject != null) {
        ((MTimerHandler)localObject).startTimer(0L, 250L);
      }
      MMHandlerThread.postToMainThread(new WebViewVideoEventHandler..ExternalSyntheticLambda3(this));
      Log.i(this.TAG, "onPlayingReport");
      localObject = k.Xtc;
      boolean bool = k.iCU();
      if (bool) {
        try
        {
          q("Playing", null);
          AppMethodBeat.o(297255);
          return;
        }
        catch (JSONException localJSONException1)
        {
          Log.e(this.TAG, "onPlayingReport fail", new Object[] { localJSONException1 });
        }
      }
      AppMethodBeat.o(297255);
      return;
    }
    catch (JSONException localJSONException2)
    {
      Log.e(this.TAG, "OnXWebVideoPlay fail", new Object[] { localJSONException2 });
      AppMethodBeat.o(297255);
    }
  }
  
  public final void iBU()
  {
    AppMethodBeat.i(297262);
    try
    {
      JSONObject localJSONObject = cws();
      s.checkNotNull(localJSONObject);
      n("onVideoPause", localJSONObject);
      cwt();
      cyR();
      AppMethodBeat.o(297262);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e(this.TAG, "OnXWebVideoPause fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void iBV()
  {
    AppMethodBeat.i(297279);
    Log.i(this.TAG, "onBufferReadyReport");
    k localk = k.Xtc;
    if (!k.iCU())
    {
      AppMethodBeat.o(297279);
      return;
    }
    try
    {
      q("BufferReady", null);
      AppMethodBeat.o(297279);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "onBufferReadyReport fail", new Object[] { localJSONException });
      AppMethodBeat.o(297279);
    }
  }
  
  /* Error */
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    // Byte code:
    //   0: ldc_w 523
    //   3: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: instanceof 348
    //   10: ifeq +224 -> 234
    //   13: aload_0
    //   14: aload_1
    //   15: checkcast 348	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/f
    //   18: putfield 346	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:Xoy	Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/f;
    //   21: aload_1
    //   22: checkcast 348	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/f
    //   25: getfield 352	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/f:Xnu	Lcom/tencent/mm/plugin/webview/jsapi/h;
    //   28: getfield 356	com/tencent/mm/plugin/webview/jsapi/h:context	Landroid/content/Context;
    //   31: astore_1
    //   32: aload_1
    //   33: instanceof 525
    //   36: ifeq +205 -> 241
    //   39: aload_1
    //   40: checkcast 525	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/c
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +13 -> 58
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 211	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoD	Lcom/tencent/mm/plugin/webview/ui/tools/video/c;
    //   53: invokeinterface 528 2 0
    //   58: invokestatic 258	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   61: astore_1
    //   62: aload_1
    //   63: ldc_w 456
    //   66: invokestatic 459	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 530	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:WXe	Lcom/tencent/mm/bj/a;
    //   73: ifnonnull +23 -> 96
    //   76: aload_0
    //   77: new 532	com/tencent/mm/bj/a
    //   80: dup
    //   81: aload_1
    //   82: new 534	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$$ExternalSyntheticLambda0
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 535	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;)V
    //   90: invokespecial 538	com/tencent/mm/bj/a:<init>	(Landroid/content/Context;Lcom/tencent/mm/bj/a$b;)V
    //   93: putfield 530	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:WXe	Lcom/tencent/mm/bj/a;
    //   96: aload_0
    //   97: getfield 540	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoE	Landroid/database/ContentObserver;
    //   100: ifnonnull +65 -> 165
    //   103: aload_0
    //   104: new 9	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$a
    //   107: dup
    //   108: new 542	android/os/Handler
    //   111: dup
    //   112: invokespecial 543	android/os/Handler:<init>	()V
    //   115: new 545	java/lang/ref/WeakReference
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 547	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   123: invokespecial 550	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$a:<init>	(Landroid/os/Handler;Ljava/lang/ref/WeakReference;)V
    //   126: checkcast 552	android/database/ContentObserver
    //   129: putfield 540	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoE	Landroid/database/ContentObserver;
    //   132: invokestatic 258	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   135: invokevirtual 555	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   138: invokevirtual 264	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   141: astore_1
    //   142: ldc_w 557
    //   145: invokestatic 561	android/provider/Settings$System:getUriFor	(Ljava/lang/String;)Landroid/net/Uri;
    //   148: astore_2
    //   149: aload_0
    //   150: getfield 540	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoE	Landroid/database/ContentObserver;
    //   153: astore_3
    //   154: aload_3
    //   155: invokestatic 302	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   158: aload_1
    //   159: aload_2
    //   160: iconst_0
    //   161: aload_3
    //   162: invokevirtual 567	android/content/ContentResolver:registerContentObserver	(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
    //   165: aload_0
    //   166: getfield 569	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoF	Landroid/content/BroadcastReceiver;
    //   169: ifnonnull +52 -> 221
    //   172: aload_0
    //   173: new 6	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$VolumeBroadcastReceiver
    //   176: dup
    //   177: new 545	java/lang/ref/WeakReference
    //   180: dup
    //   181: aload_0
    //   182: invokespecial 547	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   185: invokespecial 572	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$VolumeBroadcastReceiver:<init>	(Ljava/lang/ref/WeakReference;)V
    //   188: checkcast 574	android/content/BroadcastReceiver
    //   191: putfield 569	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoF	Landroid/content/BroadcastReceiver;
    //   194: new 576	android/content/IntentFilter
    //   197: dup
    //   198: invokespecial 577	android/content/IntentFilter:<init>	()V
    //   201: astore_1
    //   202: aload_1
    //   203: ldc_w 579
    //   206: invokevirtual 582	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   209: invokestatic 258	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   212: aload_0
    //   213: getfield 569	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:XoF	Landroid/content/BroadcastReceiver;
    //   216: aload_1
    //   217: invokevirtual 586	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   220: pop
    //   221: aload_0
    //   222: getfield 530	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:WXe	Lcom/tencent/mm/bj/a;
    //   225: astore_1
    //   226: aload_1
    //   227: ifnull +7 -> 234
    //   230: aload_1
    //   231: invokevirtual 589	com/tencent/mm/bj/a:enable	()V
    //   234: ldc_w 523
    //   237: invokestatic 158	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: return
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -199 -> 44
    //   246: astore_1
    //   247: aload_0
    //   248: getfield 205	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:TAG	Ljava/lang/String;
    //   251: aload_1
    //   252: ldc_w 590
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 594	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: goto -97 -> 165
    //   265: astore_1
    //   266: aload_0
    //   267: getfield 205	com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler:TAG	Ljava/lang/String;
    //   270: aload_1
    //   271: ldc_w 590
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 594	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: goto -60 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	WebViewVideoEventHandler
    //   0	284	1	parama	com.tencent.luggage.xweb_ext.extendplugin.a
    //   148	12	2	localUri	android.net.Uri
    //   153	9	3	localContentObserver	ContentObserver
    // Exception table:
    //   from	to	target	type
    //   149	165	246	finally
    //   194	221	265	finally
  }
  
  final void n(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(297297);
    Object localObject = this.Xoy;
    if (localObject != null)
    {
      paramJSONObject.put("__timestamp", System.currentTimeMillis());
      String str = ((f)localObject).iBP();
      if (!Util.isNullOrNil(str))
      {
        if ((((f)localObject).Xnu.WDy instanceof com.tencent.mm.plugin.webview.jsapi.j))
        {
          localObject = ((com.tencent.mm.plugin.webview.jsapi.j)((f)localObject).Xnu.WDy).itJ();
          if (localObject != null)
          {
            s.checkNotNull(str);
            ((com.tencent.mm.plugin.webview.l.j)localObject).bw(str, paramString, paramJSONObject.toString());
            AppMethodBeat.o(297297);
          }
        }
      }
      else if ((((f)localObject).Xnu.WDy instanceof com.tencent.mm.plugin.webview.jsapi.j)) {
        ((com.tencent.mm.plugin.webview.jsapi.j)((f)localObject).Xnu.WDy).n(paramString, paramJSONObject);
      }
    }
    AppMethodBeat.o(297297);
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(297281);
    try
    {
      JSONObject localJSONObject = cws();
      s.checkNotNull(localJSONObject);
      n("onVideoEnded", localJSONObject);
      cwt();
      cyR();
      AppMethodBeat.o(297281);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e(this.TAG, "OnXWebVideoEnded fail", new Object[] { localJSONException });
      }
    }
  }
  
  public final void onVideoError(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(297267);
    cwt();
    cyR();
    try
    {
      JSONObject localJSONObject = cws();
      am localam = am.aixg;
      paramString = String.format(Locale.US, "%s(%d,%d)", Arrays.copyOf(new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }, 3));
      s.s(paramString, "java.lang.String.format(locale, format, *args)");
      localJSONObject.put("errMsg", paramString);
      n("onVideoError", localJSONObject);
      AppMethodBeat.o(297267);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e(this.TAG, "OnXWebVideoError fail", new Object[] { paramString });
      AppMethodBeat.o(297267);
    }
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(297252);
    try
    {
      n("onVideoWaiting", cws());
      AppMethodBeat.o(297252);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(297252);
    }
  }
  
  final void q(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(297275);
    Log.i(this.TAG, s.X("onPlayerProcessStateChanged event=", paramString));
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {}
    try
    {
      localJSONObject = cws();
      localJSONObject.put("event", paramString);
      n("onPlayerProcessStateChanged", localJSONObject);
      AppMethodBeat.o(297275);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e(this.TAG, "onPlayerProcessStateChanged " + paramString + " fail", new Object[] { paramJSONObject });
      AppMethodBeat.o(297275);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$VolumeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "weakEventHandler", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "(Ljava/lang/ref/WeakReference;)V", "TAG", "", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class VolumeBroadcastReceiver
    extends BroadcastReceiver
  {
    private final String TAG;
    private final WeakReference<WebViewVideoEventHandler> XoG;
    
    public VolumeBroadcastReceiver(WeakReference<WebViewVideoEventHandler> paramWeakReference)
    {
      AppMethodBeat.i(297120);
      this.XoG = paramWeakReference;
      this.TAG = "MicroMsg.VolumeBroadcastReceiver";
      AppMethodBeat.o(297120);
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(297127);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(297127);
        return;
      }
      if ((s.p("android.media.VOLUME_CHANGED_ACTION", paramIntent.getAction())) && (paramIntent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3))
      {
        Log.d(this.TAG, "onReceive action");
        try
        {
          paramContext = (WebViewVideoEventHandler)this.XoG.get();
          if (paramContext != null) {
            break label95;
          }
          AppMethodBeat.o(297127);
          return;
        }
        catch (JSONException paramContext)
        {
          Log.e(this.TAG, s.X("onVolumeChange fail ", paramContext.getMessage()));
        }
      }
      else
      {
        AppMethodBeat.o(297127);
        return;
      }
      label95:
      WebViewVideoEventHandler.a(paramContext, "onVolumeChange", WebViewVideoEventHandler.d(paramContext));
      AppMethodBeat.o(297127);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$BrightnessObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "weakEventHandler", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler;", "(Landroid/os/Handler;Ljava/lang/ref/WeakReference;)V", "TAG", "", "onChange", "", "selfChange", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ContentObserver
  {
    private final String TAG;
    private final WeakReference<WebViewVideoEventHandler> XoG;
    
    public a(Handler paramHandler, WeakReference<WebViewVideoEventHandler> paramWeakReference)
    {
      super();
      AppMethodBeat.i(297102);
      this.XoG = paramWeakReference;
      this.TAG = "MicroMsg.BrightnessObserver";
      AppMethodBeat.o(297102);
    }
    
    public final void onChange(boolean paramBoolean)
    {
      AppMethodBeat.i(297108);
      Log.d(this.TAG, s.X("onChange selfChange=", Boolean.valueOf(paramBoolean)));
      try
      {
        WebViewVideoEventHandler localWebViewVideoEventHandler = (WebViewVideoEventHandler)this.XoG.get();
        if (localWebViewVideoEventHandler == null)
        {
          AppMethodBeat.o(297108);
          return;
        }
        JSONObject localJSONObject = WebViewVideoEventHandler.d(localWebViewVideoEventHandler);
        localJSONObject.put("selfChange", paramBoolean);
        WebViewVideoEventHandler.a(localWebViewVideoEventHandler, "onBrightnessChange", localJSONObject);
        AppMethodBeat.o(297108);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(this.TAG, s.X("onBrightnessChange fail  ", localJSONException.getMessage()));
        AppMethodBeat.o(297108);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewVideoEventHandler$fullscreenStatusListener$1", "Lcom/tencent/mm/plugin/webview/ui/tools/video/WebViewFullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends c
  {
    d(WebViewVideoEventHandler paramWebViewVideoEventHandler) {}
    
    public final void aqb()
    {
      AppMethodBeat.i(297109);
      try
      {
        JSONObject localJSONObject = WebViewVideoEventHandler.d(this.XoH);
        WebViewVideoEventHandler.a(this.XoH, "onExitFullscreen", localJSONObject);
        AppMethodBeat.o(297109);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(WebViewVideoEventHandler.e(this.XoH), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(297109);
      }
    }
    
    public final void cpc()
    {
      AppMethodBeat.i(297112);
      try
      {
        JSONObject localJSONObject = WebViewVideoEventHandler.d(this.XoH);
        WebViewVideoEventHandler.a(this.XoH, "onEnterFullscreen", localJSONObject);
        AppMethodBeat.o(297112);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(WebViewVideoEventHandler.e(this.XoH), "OnXWebVideoError fail", new Object[] { localJSONException });
        AppMethodBeat.o(297112);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.video.samelayer.WebViewVideoEventHandler
 * JD-Core Version:    0.7.0.1
 */