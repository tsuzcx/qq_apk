package com.tencent.thumbplayer.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.a;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.d;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.a.a.c.k;
import com.tencent.thumbplayer.a.a.c.l;
import com.tencent.thumbplayer.a.a.c.m;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener;
import com.tencent.thumbplayer.api.ITPSurface;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPProtocolInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.utils.f;
import com.tencent.thumbplayer.utils.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class b
  implements ITPPlayer, c.b
{
  private static String ZDa;
  private static AtomicInteger ZDq;
  private com.tencent.thumbplayer.a.a ZDb;
  private c ZDc;
  private d ZDd;
  private com.tencent.thumbplayer.e.a ZDe;
  private com.tencent.thumbplayer.g.a.a.c ZDf;
  private com.tencent.thumbplayer.e.a.a ZDg;
  private com.tencent.thumbplayer.g.a.b ZDh;
  private Looper ZDi;
  private a ZDj;
  private boolean ZDk;
  private int ZDl;
  private ArrayList<String> ZDm;
  private long ZDn;
  private long ZDo;
  private long ZDp;
  private AtomicInteger ZDr;
  private boolean ZDs;
  private com.tencent.thumbplayer.f.a Zyx;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(221330);
    ZDa = "api call:";
    ZDq = new AtomicInteger(1000);
    AppMethodBeat.o(221330);
  }
  
  public b(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public b(Context paramContext, Looper paramLooper)
  {
    this(paramContext, paramLooper, null);
  }
  
  public b(Context paramContext, Looper paramLooper1, Looper paramLooper2)
  {
    this(paramContext, paramLooper1, paramLooper2, null);
  }
  
  public b(Context paramContext, Looper paramLooper1, Looper paramLooper2, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(220892);
    this.mUrl = null;
    this.ZDk = true;
    this.ZDl = -1;
    this.ZDr = new AtomicInteger(1000);
    this.ZDs = false;
    b localb;
    if (paramb != null)
    {
      paramb = new com.tencent.thumbplayer.f.b(paramb, "TPPlayer");
      this.Zyx = new com.tencent.thumbplayer.f.a(paramb);
      this.Zyx.bDy("create TPPlayer");
      this.mContext = paramContext.getApplicationContext();
      this.ZDh = new com.tencent.thumbplayer.g.a.c();
      this.ZDf = new com.tencent.thumbplayer.g.a.a.c(this.mContext);
      a(100, 0, 0, null, new f().L("stime", Long.valueOf(System.currentTimeMillis())).map);
      localb = new b();
      this.ZDd = new d(this.Zyx.Zyw.tag);
      this.ZDb = new com.tencent.thumbplayer.a.d(this.mContext, paramb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.a(localb);
      this.ZDb.setOnPlayerStateChangeListener(localb);
      if (paramLooper1 != null)
      {
        paramb = paramLooper1;
        if (paramLooper1 != Looper.getMainLooper()) {}
      }
      else
      {
        this.mHandlerThread = new HandlerThread("TP-workthread");
        this.mHandlerThread.start();
        paramb = this.mHandlerThread.getLooper();
      }
      this.ZDi = paramb;
      if (paramLooper2 != null) {
        break label596;
      }
      if (Looper.myLooper() != null) {
        break label580;
      }
      this.ZDj = new a(this, this.ZDi);
    }
    for (;;)
    {
      this.ZDc = new c(paramb, this);
      a(101, 0, 0, null, new f().L("etime", Long.valueOf(System.currentTimeMillis())).map);
      this.ZDe = new com.tencent.thumbplayer.e.c(paramContext);
      this.ZDe.a(localb);
      this.ZDh.a(new com.tencent.thumbplayer.g.a.a.e()).a(new com.tencent.thumbplayer.g.a.a.b());
      this.ZDm = new ArrayList();
      AppMethodBeat.o(220892);
      return;
      paramb = new com.tencent.thumbplayer.f.b("ThumbPlayer", String.valueOf(ZDq.incrementAndGet()), String.valueOf(this.ZDr.incrementAndGet()), "TPPlayer");
      this.ZDs = true;
      break;
      label580:
      this.ZDj = new a(this);
      continue;
      label596:
      this.ZDj = new a(this, paramLooper2);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(221297);
    try
    {
      if (this.ZDh != null) {
        this.ZDh.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      AppMethodBeat.o(221297);
      return;
    }
    catch (Exception paramString)
    {
      this.Zyx.n(paramString);
      AppMethodBeat.o(221297);
    }
  }
  
  private void f(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(221300);
    if (this.ZDj != null)
    {
      Message localMessage = this.ZDj.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.ZDj.sendMessage(localMessage);
    }
    AppMethodBeat.o(221300);
  }
  
  private void irC()
  {
    AppMethodBeat.i(221278);
    try
    {
      this.ZDb.stop();
      a(107, 0, 0, null, new f().L("etime", Long.valueOf(System.currentTimeMillis())).L("reason", Integer.valueOf(1)).map);
      this.ZDe.aBb(5);
      this.ZDn = -1L;
      this.ZDo = -1L;
      this.ZDp = -1L;
      AppMethodBeat.o(221278);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Zyx.n(localException);
      }
    }
  }
  
  private boolean irD()
  {
    AppMethodBeat.i(221283);
    if ((this.ZDe.isEnable()) && (com.tencent.thumbplayer.d.a.iqK()) && (this.ZDk))
    {
      AppMethodBeat.o(221283);
      return true;
    }
    AppMethodBeat.o(221283);
    return false;
  }
  
  private void irE()
  {
    AppMethodBeat.i(221296);
    if (this.ZDb.isPlaying()) {}
    for (int i = 0;; i = 5)
    {
      this.ZDe.aBb(i);
      AppMethodBeat.o(221296);
      return;
    }
  }
  
  private void nR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221294);
    a(108, paramInt1, paramInt2, "", new f().L("etime", Long.valueOf(System.currentTimeMillis())).L("reason", Integer.valueOf(3)).L("code", paramInt1 + "." + paramInt2).map);
    this.ZDe.aBb(3);
    AppMethodBeat.o(221294);
  }
  
  public final int C(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(221147);
    if (this.ZDg == null)
    {
      this.Zyx.error("mAssetResourceLoader not set");
      AppMethodBeat.o(221147);
      return -1;
    }
    paramInt1 = this.ZDg.onStopReadData(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(221147);
    return paramInt1;
  }
  
  public final void Iy(boolean paramBoolean)
  {
    AppMethodBeat.i(221177);
    try
    {
      this.ZDb.setOutputMute(paramBoolean);
      AppMethodBeat.o(221177);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221177);
    }
  }
  
  public final void Iz(boolean paramBoolean)
  {
    AppMethodBeat.i(221184);
    try
    {
      this.ZDb.setLoopback(paramBoolean);
      AppMethodBeat.o(221184);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221184);
    }
  }
  
  public final void T(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(221239);
    this.Zyx.bDy("handleOnDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
    nR(paramInt1, paramInt2);
    f(268, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(221239);
  }
  
  public final int a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221144);
    if (this.ZDg == null)
    {
      this.Zyx.error("mAssetResourceLoader not set");
      AppMethodBeat.o(221144);
      return -1;
    }
    paramInt = this.ZDg.onStartReadData(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(221144);
    return paramInt;
  }
  
  public final Object a(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(221261);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(221261);
      return null;
      this.Zyx.bDy("onDownloadNoMoreData");
      f(276, 0, 0, paramObject1);
      continue;
      if (!(paramObject2 instanceof Integer)) {
        this.Zyx.bDy("MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3.");
      } else {
        f(278, ((Integer)paramObject2).intValue(), 0, null);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(221232);
    this.ZDn = paramInt1;
    this.ZDo = paramLong1;
    this.ZDp = paramLong2;
    TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
    localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
    localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
    localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
    localTPDownLoadProgressInfo.totalFileSize = paramLong2;
    localTPDownLoadProgressInfo.extraInfo = paramString;
    this.Zyx.bDy("handleOnDownloadProgressUpdate");
    a(200, 0, 0, null, new f().L("speed", Integer.valueOf(paramInt2)).L("spanId", paramString).map);
    f(274, 0, 0, localTPDownLoadProgressInfo);
    AppMethodBeat.o(221232);
  }
  
  public final void a(ITPSurface paramITPSurface)
  {
    AppMethodBeat.i(221099);
    try
    {
      if ((paramITPSurface instanceof e)) {
        this.ZDb.setSurface(((e)paramITPSurface).ZEc);
      }
      AppMethodBeat.o(221099);
      return;
    }
    catch (Exception paramITPSurface)
    {
      this.Zyx.n(paramITPSurface);
      AppMethodBeat.o(221099);
    }
  }
  
  public final void a(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(221211);
    try
    {
      this.ZDb.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      AppMethodBeat.o(221211);
      return;
    }
    catch (Exception paramTPCaptureParams)
    {
      this.Zyx.n(paramTPCaptureParams);
      AppMethodBeat.o(221211);
    }
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(221223);
    paramITPMediaAsset = this.ZDe.a(paramITPMediaAsset, paramLong, paramTPVideoInfo);
    if (paramITPMediaAsset != null) {
      try
      {
        this.Zyx.bDy("handleSwitchDef, proxyMediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong);
        this.ZDb.a(paramTPVideoInfo);
        this.ZDb.a(paramITPMediaAsset, paramInt, paramLong);
        a(120, 0, 0, null, new f().L("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(221223);
        return;
      }
      catch (Exception paramITPMediaAsset)
      {
        this.Zyx.n(paramITPMediaAsset);
      }
    }
    AppMethodBeat.o(221223);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(221108);
    if (paramb != null)
    {
      try
      {
        if (TextUtils.isEmpty(paramb.url)) {
          break label203;
        }
        this.mUrl = paramb.url;
        com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramb.url);
        this.Zyx.bDy("handleSetDataSource originalUrl=" + paramb.url);
        if (irD())
        {
          locale = this.ZDe.bDw(paramb.url);
          this.Zyx.bDy("handleSetDataSource selfPlayerUrl=" + locale.Zzd);
          this.Zyx.bDy("handleSetDataSource systemPlayerUrl=" + locale.Zzc);
        }
        if (paramb.ZEh != null)
        {
          this.ZDb.a(locale, paramb.ZEh);
          AppMethodBeat.o(221108);
          return;
        }
        this.ZDb.a(locale);
        AppMethodBeat.o(221108);
        return;
      }
      catch (Exception paramb)
      {
        this.Zyx.n(paramb);
      }
    }
    else
    {
      AppMethodBeat.o(221108);
      return;
    }
    label203:
    if (paramb.ZEj != null)
    {
      if (irD()) {
        paramb.ZEj = this.ZDe.b(paramb.ZEj);
      }
      if (paramb.ZEj != null)
      {
        this.Zyx.bDy("handleSetDataSource mediaAsset=" + paramb.ZEj.getUrl());
        this.ZDb.setDataSource(paramb.ZEj);
      }
      AppMethodBeat.o(221108);
      return;
    }
    this.ZDb.setDataSource(paramb.ZEi);
    AppMethodBeat.o(221108);
  }
  
  public final void a(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(221216);
    com.tencent.thumbplayer.a.a.e locale = this.ZDe.a(paramLong, paramString, paramTPVideoInfo);
    try
    {
      this.Zyx.bDy("handleSwitchDef, proxyUrl:" + paramString + ", defID:" + paramLong);
      this.ZDb.a(paramTPVideoInfo);
      this.ZDb.a(locale, paramInt, paramLong);
      a(120, 0, 0, null, new f().L("switch", String.valueOf(paramLong)).map);
      AppMethodBeat.o(221216);
      return;
    }
    catch (Exception paramString)
    {
      this.Zyx.n(paramString);
      AppMethodBeat.o(221216);
    }
  }
  
  public final void a(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(221119);
    if (!irD())
    {
      this.Zyx.error("handleAddAudioSource, proxy is not enable.");
      AppMethodBeat.o(221119);
      return;
    }
    if ((TextUtils.isEmpty(paramString2)) || (!com.tencent.thumbplayer.utils.b.bAx(paramString1)))
    {
      this.Zyx.error("handleAddAudioSource, illegal argument.");
      AppMethodBeat.o(221119);
      return;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      TPOptionalParam localTPOptionalParam = new TPOptionalParam();
      if (paramTPDownloadParamData != null) {
        localTPOptionalParam.buildString(6, paramTPDownloadParamData.getAudioTrackKeyId());
      }
      localArrayList.add(localTPOptionalParam);
      this.ZDb.h(paramString1, paramString2, localArrayList);
      AppMethodBeat.o(221119);
      return;
    }
    catch (Exception paramString1)
    {
      this.Zyx.n(paramString1);
      AppMethodBeat.o(221119);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(221116);
    try
    {
      long l = System.currentTimeMillis();
      if ((irD()) && (com.tencent.thumbplayer.utils.b.bAx(paramString1)))
      {
        paramTPDownloadParamData = this.ZDe.a(3, paramString1, paramTPDownloadParamData);
        this.ZDm.add(paramTPDownloadParamData);
        this.ZDb.addSubtitleSource(paramTPDownloadParamData, paramString2, paramString3);
      }
      for (;;)
      {
        a(118, 0, 0, null, new f().L("stime", Long.valueOf(l)).L("etime", Long.valueOf(System.currentTimeMillis())).L("url", paramString1).map);
        AppMethodBeat.o(221116);
        return;
        this.ZDb.addSubtitleSource(paramString1, paramString2, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      this.Zyx.n(paramString1);
      AppMethodBeat.o(221116);
    }
  }
  
  public final String aBk(int paramInt)
  {
    AppMethodBeat.i(221151);
    if (this.ZDg == null)
    {
      this.Zyx.error("mAssetResourceLoader not set");
      AppMethodBeat.o(221151);
      return "";
    }
    String str = this.ZDg.Rv(paramInt);
    AppMethodBeat.o(221151);
    return str;
  }
  
  public final long aBl(int paramInt)
  {
    AppMethodBeat.i(221191);
    try
    {
      long l = this.ZDb.getPropertyLong(paramInt);
      AppMethodBeat.o(221191);
      return l;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221191);
    }
    return 0L;
  }
  
  public final String aBm(int paramInt)
  {
    AppMethodBeat.i(221194);
    try
    {
      String str = this.ZDb.getPropertyString(paramInt);
      AppMethodBeat.o(221194);
      return str;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221194);
    }
    return null;
  }
  
  public final void aBn(int paramInt)
  {
    AppMethodBeat.i(221252);
    f(272, paramInt, 0, null);
    AppMethodBeat.o(221252);
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220978);
    this.Zyx.bDy(ZDa + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2);
    this.ZDc.addAudioTrackSource(paramString1, paramString2, null);
    AppMethodBeat.o(220978);
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(220981);
    this.Zyx.bDy(ZDa + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2 + ", downloadParamData:" + paramTPDownloadParamData);
    this.ZDc.addAudioTrackSource(paramString1, paramString2, paramTPDownloadParamData);
    AppMethodBeat.o(220981);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(220971);
    this.Zyx.bDy(ZDa + "addSubtitleSource, url:" + paramString1 + ", mimeType:" + paramString2 + ", name:" + paramString3);
    this.ZDc.addSubtitleSource(paramString1, paramString2, paramString3, null);
    AppMethodBeat.o(220971);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(220974);
    this.Zyx.bDy(ZDa + "addSubtitleSource, url:" + paramString1 + ", name:" + paramString3 + ", downloadParamData:" + paramTPDownloadParamData);
    this.ZDc.addSubtitleSource(paramString1, paramString2, paramString3, paramTPDownloadParamData);
    AppMethodBeat.o(220974);
  }
  
  public final void ayS()
  {
    AppMethodBeat.i(221142);
    try
    {
      this.ZDb.pause();
      a(106, 0, 0, null, new f().L("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.ZDe.aBb(5);
      AppMethodBeat.o(221142);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221142);
    }
  }
  
  public final void b(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(221092);
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 205))
    {
      this.ZDk = paramTPOptionalParam.getParamBoolean().value;
      AppMethodBeat.o(221092);
      return;
    }
    this.ZDe.setPlayerOptionalParam(paramTPOptionalParam);
    try
    {
      this.ZDb.setPlayerOptionalParam(paramTPOptionalParam);
      AppMethodBeat.o(221092);
      return;
    }
    catch (Exception paramTPOptionalParam)
    {
      this.Zyx.n(paramTPOptionalParam);
      AppMethodBeat.o(221092);
    }
  }
  
  public final void b(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(221110);
    if (paramTPVideoInfo != null) {}
    try
    {
      this.ZDe.setVideoInfo(paramTPVideoInfo);
      this.ZDb.setVideoInfo(paramTPVideoInfo);
      AppMethodBeat.o(221110);
      return;
    }
    catch (Exception paramTPVideoInfo)
    {
      this.Zyx.n(paramTPVideoInfo);
      AppMethodBeat.o(221110);
    }
  }
  
  public final void bDA(String paramString)
  {
    AppMethodBeat.i(221181);
    try
    {
      this.ZDb.setAudioNormalizeVolumeParams(paramString);
      AppMethodBeat.o(221181);
      return;
    }
    catch (Exception paramString)
    {
      this.Zyx.n(paramString);
      AppMethodBeat.o(221181);
    }
  }
  
  public final void bDB(String paramString)
  {
    AppMethodBeat.i(221241);
    this.Zyx.bDy("handleOnDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
    f(269, 0, 0, paramString);
    AppMethodBeat.o(221241);
  }
  
  public final void bj(int paramInt, long paramLong)
  {
    AppMethodBeat.i(221125);
    try
    {
      TPTrackInfo[] arrayOfTPTrackInfo = this.ZDb.getTrackInfo();
      if ((arrayOfTPTrackInfo != null) && (arrayOfTPTrackInfo.length > paramInt)) {
        a(122, 0, 0, null, new f().L("opaque", Long.valueOf(paramLong)).L("tracktype", Integer.valueOf(arrayOfTPTrackInfo[paramInt].getTrackType())).L("stime", Long.valueOf(System.currentTimeMillis())).map);
      }
      this.ZDb.selectTrack(paramInt, paramLong);
      AppMethodBeat.o(221125);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221125);
    }
  }
  
  public final void bk(int paramInt, long paramLong)
  {
    AppMethodBeat.i(221126);
    try
    {
      this.ZDb.deselectTrack(paramInt, paramLong);
      AppMethodBeat.o(221126);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221126);
    }
  }
  
  public final void bl(int paramInt, long paramLong)
  {
    AppMethodBeat.i(221129);
    try
    {
      this.ZDb.selectProgram(paramInt, paramLong);
      AppMethodBeat.o(221129);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221129);
    }
  }
  
  public final void bs(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221248);
    TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
    localTPCDNURLInfo.url = paramString1;
    localTPCDNURLInfo.cdnIp = paramString2;
    localTPCDNURLInfo.uIp = paramString3;
    a(201, 0, 0, null, new f().L("url", paramString1).L("cdnip", paramString2).L("cdnuip", paramString3).map);
    f(270, 0, 0, localTPCDNURLInfo);
    AppMethodBeat.o(221248);
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(221091);
    this.Zyx.bDy(ZDa + "captureVideo, params:" + paramTPCaptureParams + ", captureCallBack:" + paramTPCaptureCallBack);
    c localc = this.ZDc;
    localc.irI();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : captureVideo");
    f.l locall = new f.l();
    locall.ZEz = paramTPCaptureCallBack;
    locall.ZEy = paramTPCaptureParams;
    localc.a(30, 0, 0, locall, true, false);
    localc.irK();
    localc.irJ();
    AppMethodBeat.o(221091);
  }
  
  public final void cu(Map<String, String> paramMap)
  {
    AppMethodBeat.i(221257);
    this.Zyx.bDy("onDownloadCdnUrlExpired");
    f(275, 0, 0, paramMap);
    AppMethodBeat.o(221257);
  }
  
  public final void d(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221186);
    try
    {
      this.ZDb.setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(221186);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221186);
    }
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220985);
    this.Zyx.bDy(ZDa + "deselectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    this.ZDc.a(36, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(220985);
  }
  
  public final void di(float paramFloat)
  {
    AppMethodBeat.i(221178);
    try
    {
      this.ZDb.setAudioGainRatio(paramFloat);
      AppMethodBeat.o(221178);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221178);
    }
  }
  
  public final void dj(float paramFloat)
  {
    AppMethodBeat.i(221182);
    try
    {
      this.ZDb.setPlaySpeedRatio(paramFloat);
      a(116, 0, 0, null, new f().L("scene", Float.valueOf(paramFloat)).map);
      AppMethodBeat.o(221182);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Zyx.n(localException);
      }
    }
  }
  
  public final long dx(int paramInt, String paramString)
  {
    AppMethodBeat.i(221149);
    if (this.ZDg == null)
    {
      this.Zyx.error("mAssetResourceLoader not set");
      AppMethodBeat.o(221149);
      return -1L;
    }
    long l = this.ZDg.getDataTotalSize(paramInt, paramString);
    AppMethodBeat.o(221149);
    return l;
  }
  
  public final String dy(int paramInt, String paramString)
  {
    AppMethodBeat.i(221153);
    if (this.ZDg == null)
    {
      this.Zyx.error("mAssetResourceLoader not set");
      AppMethodBeat.o(221153);
      return "";
    }
    paramString = this.ZDg.getContentType(paramInt, paramString);
    AppMethodBeat.o(221153);
    return paramString;
  }
  
  public void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener, Looper paramLooper)
  {
    AppMethodBeat.i(220906);
    if (paramITPAssetResourceLoaderListener != null)
    {
      this.ZDe.Iw(true);
      if (this.ZDg != null)
      {
        this.ZDg.release();
        this.ZDg = null;
      }
      this.ZDg = new com.tencent.thumbplayer.e.a.b(this.mContext, paramLooper);
      this.ZDg.a(paramITPAssetResourceLoaderListener);
      this.ZDg.irc();
      AppMethodBeat.o(220906);
      return;
    }
    this.ZDe.Iw(false);
    AppMethodBeat.o(220906);
  }
  
  public void enableTPAssetResourceLoader(com.tencent.thumbplayer.e.a.a parama)
  {
    AppMethodBeat.i(220911);
    this.Zyx.bDy(ZDa + "enableTPAssetResourceLoader, assetResourceLoader:" + parama);
    if (parama != null)
    {
      this.ZDe.Iw(true);
      if (this.ZDg != null)
      {
        this.ZDg.release();
        this.ZDg = null;
      }
      this.ZDg = parama;
      AppMethodBeat.o(220911);
      return;
    }
    this.ZDe.Iw(false);
    AppMethodBeat.o(220911);
  }
  
  public final void f(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(221094);
    try
    {
      this.ZDb.setSurfaceHolder(paramSurfaceHolder);
      AppMethodBeat.o(221094);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      this.Zyx.n(paramSurfaceHolder);
      AppMethodBeat.o(221094);
    }
  }
  
  public int getBufferPercent()
  {
    AppMethodBeat.i(221053);
    int i = this.ZDc.getBufferPercent();
    AppMethodBeat.o(221053);
    return i;
  }
  
  public long getCurrentPositionMs()
  {
    AppMethodBeat.i(221048);
    long l = this.ZDc.getCurrentPositionMs();
    AppMethodBeat.o(221048);
    return l;
  }
  
  public int getCurrentState()
  {
    AppMethodBeat.i(221051);
    c localc = this.ZDc;
    localc.irI();
    localc.ZDH = 1;
    localc.a(43, 0, 0, null, false, false);
    localc.irK();
    localc.irJ();
    int i = localc.ZDH;
    AppMethodBeat.o(221051);
    return i;
  }
  
  public long getDurationMs()
  {
    AppMethodBeat.i(221044);
    long l = this.ZDc.getDurationMs();
    AppMethodBeat.o(221044);
    return l;
  }
  
  public long getPlayableDurationMs()
  {
    AppMethodBeat.i(221055);
    long l = this.ZDc.getPlayableDurationMs();
    AppMethodBeat.o(221055);
    return l;
  }
  
  public ITPPlayerProxy getPlayerProxy()
  {
    return this.ZDe;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(221085);
    this.Zyx.bDy(ZDa + "getPlayerType");
    c localc = this.ZDc;
    localc.irI();
    localc.ZDI = 0;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get player type");
    localc.a(40, 0, 0, null, false, false);
    localc.irK();
    localc.irJ();
    int i = localc.ZDI;
    AppMethodBeat.o(221085);
    return i;
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(220989);
    this.Zyx.bDy(ZDa + "getProgramInfo");
    Object localObject = this.ZDc;
    ((c)localObject).irI();
    ((c)localObject).ZDx.ZEr = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get program info");
    ((c)localObject).a(33, 0, 0, null, false, false);
    ((c)localObject).irK();
    ((c)localObject).irJ();
    localObject = ((c)localObject).ZDx.ZEr;
    AppMethodBeat.o(220989);
    return localObject;
  }
  
  public long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(221037);
    this.Zyx.bDy(ZDa + "getPropertyLong, paramId:" + paramInt);
    c localc = this.ZDc;
    localc.irI();
    localc.ZDy = 0L;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property long");
    localc.a(27, paramInt, 0, null, false, false);
    localc.irK();
    localc.irJ();
    long l = localc.ZDy;
    AppMethodBeat.o(221037);
    return l;
  }
  
  public String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(221041);
    this.Zyx.bDy(ZDa + "getPropertyString, paramId:" + paramInt);
    Object localObject = this.ZDc;
    ((c)localObject).irI();
    ((c)localObject).ZDz = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property string");
    ((c)localObject).a(28, paramInt, 0, null, false, false);
    ((c)localObject).irK();
    ((c)localObject).irJ();
    localObject = ((c)localObject).ZDz;
    AppMethodBeat.o(221041);
    return localObject;
  }
  
  public ITPBusinessReportManager getReportManager()
  {
    return this.ZDf;
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(221067);
    this.Zyx.bDy(ZDa + "getTrackInfo");
    Object localObject = this.ZDc;
    ((c)localObject).irI();
    ((c)localObject).ZDw.ZEx = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get trackInfo");
    ((c)localObject).a(23, 0, 0, null, false, false);
    ((c)localObject).irK();
    ((c)localObject).irJ();
    localObject = ((c)localObject).ZDw.ZEx;
    AppMethodBeat.o(221067);
    return localObject;
  }
  
  public int getVideoHeight()
  {
    AppMethodBeat.i(221063);
    this.Zyx.bDy(ZDa + "getVideoHeight");
    c localc = this.ZDc;
    localc.irI();
    localc.a(22, 0, 0, null, false, false);
    localc.irK();
    localc.irJ();
    int i = localc.ZDv.height;
    AppMethodBeat.o(221063);
    return i;
  }
  
  public int getVideoWidth()
  {
    AppMethodBeat.i(221060);
    this.Zyx.bDy(ZDa + "getVideoWidth");
    c localc = this.ZDc;
    localc.irI();
    localc.a(21, 0, 0, null, false, false);
    localc.irK();
    localc.irJ();
    int i = localc.ZDv.width;
    AppMethodBeat.o(221060);
    return i;
  }
  
  public final int irA()
  {
    AppMethodBeat.i(221266);
    com.tencent.thumbplayer.a.a locala = this.ZDb;
    if (locala != null)
    {
      int i = locala.getCurrentPlayClipNo();
      AppMethodBeat.o(221266);
      return i;
    }
    AppMethodBeat.o(221266);
    return 0;
  }
  
  public final long irB()
  {
    AppMethodBeat.i(221268);
    ITPPlayerProxyListener localITPPlayerProxyListener = this.ZDe.iqX();
    if (localITPPlayerProxyListener != null)
    {
      long l = localITPPlayerProxyListener.getAdvRemainTimeMs();
      AppMethodBeat.o(221268);
      return l;
    }
    AppMethodBeat.o(221268);
    return -1L;
  }
  
  public final void irg()
  {
    AppMethodBeat.i(221072);
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 0L);
    try
    {
      this.ZDb.setPlayerOptionalParam(localTPOptionalParam);
      this.ZDe.pauseDownload();
      AppMethodBeat.o(221072);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Zyx.n(localException);
      }
    }
  }
  
  public final void irh()
  {
    AppMethodBeat.i(221077);
    this.ZDe.resumeDownload();
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 1L);
    try
    {
      this.ZDb.setPlayerOptionalParam(localTPOptionalParam);
      AppMethodBeat.o(221077);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221077);
    }
  }
  
  public final void iri()
  {
    AppMethodBeat.i(221136);
    try
    {
      this.ZDb.prepareAsync();
      Object localObject = UUID.randomUUID().toString() + System.nanoTime() + "_" + com.tencent.thumbplayer.d.a.getPlatform();
      a(102, 0, 0, null, new f().L("stime", Long.valueOf(System.currentTimeMillis())).L("url", this.mUrl).L("p2p", Boolean.valueOf(irD())).L("flowid", localObject).map);
      localObject = new f.i();
      if (irD()) {}
      for (long l = 1L;; l = 0L)
      {
        ((f.i)localObject).fXA = l;
        f(261, 1009, 0, localObject);
        AppMethodBeat.o(221136);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221136);
    }
  }
  
  public final void irj()
  {
    AppMethodBeat.i(221140);
    try
    {
      this.ZDb.start();
      a(104, 0, 0, null, new f().L("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.ZDe.aBb(0);
      AppMethodBeat.o(221140);
      return;
    }
    catch (Exception localException)
    {
      this.Zyx.n(localException);
      AppMethodBeat.o(221140);
    }
  }
  
  public final void irk()
  {
    AppMethodBeat.i(221155);
    irC();
    AppMethodBeat.o(221155);
  }
  
  public final void irl()
  {
    AppMethodBeat.i(221157);
    irC();
    f(280, 0, 0, null);
    AppMethodBeat.o(221157);
  }
  
  public final void irm()
  {
    AppMethodBeat.i(221161);
    this.ZDb.reset();
    a(113, 0, 0, null, new f().L("etime", Long.valueOf(System.currentTimeMillis())).L("reason", Integer.valueOf(1)).map);
    this.ZDe.stopDownload();
    this.ZDl = -1;
    this.ZDm.clear();
    if (this.ZDg != null) {
      this.ZDg.reset();
    }
    this.ZDn = -1L;
    this.ZDo = -1L;
    this.ZDp = -1L;
    AppMethodBeat.o(221161);
  }
  
  public final void irn()
  {
    AppMethodBeat.i(221169);
    this.ZDb.release();
    a(112, 0, 0, null, new f().L("etime", Long.valueOf(System.currentTimeMillis())).L("reason", Integer.valueOf(1)).map);
    if (this.ZDj != null)
    {
      this.ZDj.removeCallbacksAndMessages(null);
      this.ZDj = null;
    }
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      locald.ZDN = locald.ZEb;
      locald.ZDO = locald.ZEb;
      locald.ZDP = locald.ZEb;
      locald.ZDQ = locald.ZEb;
      locald.ZDR = locald.ZEb;
      locald.ZDS = locald.ZEb;
      locald.ZDT = locald.ZEb;
      locald.ZDV = locald.ZEb;
      locald.ZDW = locald.ZEb;
      locald.ZDZ = locald.ZEb;
      locald.ZEa = locald.ZEb;
      this.ZDd = null;
    }
    this.ZDe.release();
    this.ZDm.clear();
    if (this.ZDg != null)
    {
      this.ZDg.release();
      this.ZDg = null;
    }
    this.ZDn = -1L;
    this.ZDo = -1L;
    this.ZDp = -1L;
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(221169);
  }
  
  public final long iro()
  {
    AppMethodBeat.i(221195);
    long l = this.ZDb.getDurationMs();
    AppMethodBeat.o(221195);
    return l;
  }
  
  public final long irp()
  {
    AppMethodBeat.i(221196);
    long l = this.ZDb.getCurrentPositionMs();
    AppMethodBeat.o(221196);
    return l;
  }
  
  public final int irq()
  {
    AppMethodBeat.i(221197);
    int i = this.ZDb.getCurrentState();
    AppMethodBeat.o(221197);
    return i;
  }
  
  public final int irr()
  {
    AppMethodBeat.i(221198);
    if (this.ZDb.getDurationMs() == 0L)
    {
      AppMethodBeat.o(221198);
      return 0;
    }
    int i = (int)(100.0F * (float)(this.ZDb.getPlayableDurationMs() - this.ZDb.getCurrentPositionMs()) / (float)this.ZDb.getDurationMs());
    AppMethodBeat.o(221198);
    return i;
  }
  
  public final long irs()
  {
    AppMethodBeat.i(221202);
    if (irD())
    {
      if ((this.ZDo > 0L) && (this.ZDp > 0L))
      {
        l = (this.ZDo * 1.0D / this.ZDp * this.ZDb.getDurationMs());
        AppMethodBeat.o(221202);
        return l;
      }
      l = this.ZDn;
      AppMethodBeat.o(221202);
      return l;
    }
    long l = this.ZDb.getPlayableDurationMs();
    AppMethodBeat.o(221202);
    return l;
  }
  
  public final int irt()
  {
    AppMethodBeat.i(221203);
    int i = this.ZDb.getVideoWidth();
    AppMethodBeat.o(221203);
    return i;
  }
  
  public final int iru()
  {
    AppMethodBeat.i(221204);
    int i = this.ZDb.getVideoHeight();
    AppMethodBeat.o(221204);
    return i;
  }
  
  public final int irv()
  {
    AppMethodBeat.i(221206);
    int i = this.ZDb.getPlayerType();
    AppMethodBeat.o(221206);
    return i;
  }
  
  public final TPTrackInfo[] irw()
  {
    AppMethodBeat.i(221208);
    TPTrackInfo[] arrayOfTPTrackInfo = this.ZDb.getTrackInfo();
    AppMethodBeat.o(221208);
    return arrayOfTPTrackInfo;
  }
  
  public final TPProgramInfo[] irx()
  {
    AppMethodBeat.i(221209);
    TPProgramInfo[] arrayOfTPProgramInfo = this.ZDb.getProgramInfo();
    AppMethodBeat.o(221209);
    return arrayOfTPProgramInfo;
  }
  
  public final void iry()
  {
    AppMethodBeat.i(221236);
    this.Zyx.bDy("onDownloadFinish");
    f(271, 0, 0, Integer.valueOf(0));
    AppMethodBeat.o(221236);
  }
  
  public final long irz()
  {
    AppMethodBeat.i(221263);
    com.tencent.thumbplayer.a.a locala = this.ZDb;
    if (locala != null)
    {
      long l1 = locala.getPlayableDurationMs();
      long l2 = this.ZDb.getCurrentPositionMs();
      AppMethodBeat.o(221263);
      return l1 - l2;
    }
    AppMethodBeat.o(221263);
    return 0L;
  }
  
  public final void nQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221175);
    a(109, 0, 0, null, new f().L("stime", Long.valueOf(System.currentTimeMillis())).L("format", Integer.valueOf(0)).L("pstime", Long.valueOf(irp())).map);
    if (paramInt2 > 0) {}
    try
    {
      this.ZDb.seekTo(paramInt1, paramInt2);
      for (;;)
      {
        this.ZDe.aBb(1);
        AppMethodBeat.o(221175);
        return;
        this.ZDb.seekTo(paramInt1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.Zyx.n(localException);
      }
    }
  }
  
  public final void oK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221255);
    this.Zyx.bDy("onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    f(273, 0, 0, localTPProtocolInfo);
    AppMethodBeat.o(221255);
  }
  
  public final void p(Surface paramSurface)
  {
    AppMethodBeat.i(221093);
    try
    {
      this.ZDb.setSurface(paramSurface);
      AppMethodBeat.o(221093);
      return;
    }
    catch (Exception paramSurface)
    {
      this.Zyx.n(paramSurface);
      AppMethodBeat.o(221093);
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(220996);
    this.Zyx.bDy(ZDa + "pause");
    this.ZDc.a(12, 0, 0, null, false, false);
    AppMethodBeat.o(220996);
  }
  
  public void pauseDownload()
  {
    AppMethodBeat.i(221069);
    this.Zyx.bDy(ZDa + "pauseDownload");
    this.ZDc.a(41, 0, 0, null, false, false);
    AppMethodBeat.o(221069);
  }
  
  public void prepareAsync()
  {
    AppMethodBeat.i(220991);
    this.Zyx.bDy(ZDa + "prepareAsync");
    this.ZDc.a(10, 0, 0, null, false, false);
    AppMethodBeat.o(220991);
  }
  
  public void release()
  {
    AppMethodBeat.i(221005);
    this.Zyx.bDy(ZDa + "release");
    c localc = this.ZDc;
    localc.irI();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : release");
    localc.a(15, 0, 0, null, false, false);
    localc.irK();
    localc.irJ();
    this.ZDh.release();
    AppMethodBeat.o(221005);
  }
  
  public void reset()
  {
    AppMethodBeat.i(221004);
    this.Zyx.bDy(ZDa + "reset");
    if (this.ZDs)
    {
      localObject = this.Zyx;
      int i = this.ZDr.incrementAndGet();
      localObject = ((com.tencent.thumbplayer.f.a)localObject).Zyw;
      ((com.tencent.thumbplayer.f.b)localObject).taskId = String.valueOf(i);
      ((com.tencent.thumbplayer.f.b)localObject).irf();
      this.ZDb.updateLoggerContext(this.Zyx.Zyw);
      if (this.ZDd != null) {
        this.ZDd.bDr(this.Zyx.Zyw.tag);
      }
    }
    Object localObject = this.ZDc;
    ((c)localObject).irI();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : reset");
    ((c)localObject).a(14, 0, 0, null, false, false);
    ((c)localObject).irK();
    ((c)localObject).irJ();
    AppMethodBeat.o(221004);
  }
  
  public void resumeDownload()
  {
    AppMethodBeat.i(221074);
    this.Zyx.bDy(ZDa + "resumeDownload");
    this.ZDc.a(42, 0, 0, null, false, false);
    AppMethodBeat.o(221074);
  }
  
  public void seekTo(int paramInt)
  {
    AppMethodBeat.i(221006);
    this.Zyx.bDy(ZDa + "seekTo, positionMs:" + paramInt);
    this.ZDc.a(16, paramInt, 0, null, false, false);
    AppMethodBeat.o(221006);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221009);
    this.Zyx.bDy(ZDa + "seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.ZDc.a(16, paramInt1, paramInt2, null, false, false);
    AppMethodBeat.o(221009);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220987);
    this.Zyx.bDy(ZDa + "selectProgram, programIndex:" + paramInt + ", opaque:" + paramLong);
    this.ZDc.a(32, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(220987);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(220984);
    this.Zyx.bDy(ZDa + "selectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    this.ZDc.a(8, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(220984);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(221015);
    this.Zyx.bDy(ZDa + "setAudioGainRatio, gainRatio:" + paramFloat);
    this.ZDc.a(18, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(221015);
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(221016);
    this.Zyx.bDy(ZDa + "setAudioNormalizeVolumeParams, audioNormalizeVolumeParams:" + paramString);
    this.ZDc.a(38, 0, 0, paramString, false, true);
    AppMethodBeat.o(221016);
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(220947);
    this.Zyx.bDy(ZDa + "setDataSource, ParcelFileDescriptor");
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(220947);
      throw paramParcelFileDescriptor;
    }
    c localc = this.ZDc;
    f.b localb = new f.b();
    localb.ZEi = paramParcelFileDescriptor;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(220947);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(220956);
    this.Zyx.bDy(ZDa + "setDataSource, ITPMediaAsset");
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalArgumentException("asset is null");
      AppMethodBeat.o(220956);
      throw paramITPMediaAsset;
    }
    if (((paramITPMediaAsset instanceof ITPMediaDRMAsset)) && ((TextUtils.isEmpty(paramITPMediaAsset.getUrl())) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties() == null) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties().isEmpty())))
    {
      paramITPMediaAsset = new IllegalArgumentException("drm asset url is null or drm property is null");
      AppMethodBeat.o(220956);
      throw paramITPMediaAsset;
    }
    c localc = this.ZDc;
    f.b localb = new f.b();
    localb.ZEj = paramITPMediaAsset;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(220956);
  }
  
  public void setDataSource(String paramString)
  {
    AppMethodBeat.i(220940);
    this.Zyx.bDy(ZDa + "setDataSource, url:" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(220940);
      throw paramString;
    }
    c localc = this.ZDc;
    f.b localb = new f.b();
    localb.url = paramString;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(220940);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(220945);
    this.Zyx.bDy(ZDa + "setDataSource, url:" + paramString + ", httpHeader:" + paramMap);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(220945);
      throw paramString;
    }
    c localc = this.ZDc;
    f.b localb = new f.b();
    localb.url = paramString;
    localb.ZEh = paramMap;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(220945);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(221023);
    this.Zyx.bDy(ZDa + "setLoopback, isLoopback:" + paramBoolean);
    this.ZDc.a(35, 0, 0, Boolean.valueOf(paramBoolean), true, true);
    AppMethodBeat.o(221023);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221026);
    this.Zyx.bDy(ZDa + "setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    c localc = this.ZDc;
    f.c localc1 = new f.c();
    localc1.Zys = paramBoolean;
    localc1.ZEk = paramLong1;
    localc1.ZEl = paramLong2;
    localc.a(20, 0, 0, localc1, true, true);
    AppMethodBeat.o(221026);
  }
  
  public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnAudioFrameOutputListener;
      if (paramIOnAudioFrameOutputListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDW = ((ITPPlayerListener.IOnAudioFrameOutputListener)localObject);
    }
  }
  
  public void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener paramIOnAudioProcessFrameOutputListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnAudioProcessFrameOutputListener;
      if (paramIOnAudioProcessFrameOutputListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDY = ((ITPPlayerListener.IOnAudioProcessFrameOutputListener)localObject);
    }
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnCompletionListener;
      if (paramIOnCompletionListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDO = ((ITPPlayerListener.IOnCompletionListener)localObject);
    }
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnErrorListener;
      if (paramIOnErrorListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDQ = ((ITPPlayerListener.IOnErrorListener)localObject);
    }
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnInfoListener;
      if (paramIOnInfoListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDP = ((ITPPlayerListener.IOnInfoListener)localObject);
    }
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnStateChangeListener;
      if (paramIOnStateChangeListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDZ = ((ITPPlayerListener.IOnStateChangeListener)localObject);
    }
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnPreparedListener;
      if (paramIOnPreparedListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDN = ((ITPPlayerListener.IOnPreparedListener)localObject);
    }
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnSeekCompleteListener;
      if (paramIOnSeekCompleteListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDR = ((ITPPlayerListener.IOnSeekCompleteListener)localObject);
    }
  }
  
  public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnStopAsyncCompleteListener;
      if (paramIOnStopAsyncCompleteListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZEa = ((ITPPlayerListener.IOnStopAsyncCompleteListener)localObject);
    }
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnSubtitleDataListener;
      if (paramIOnSubtitleDataListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDT = ((ITPPlayerListener.IOnSubtitleDataListener)localObject);
    }
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnSubtitleFrameOutListener;
      if (paramIOnSubtitleFrameOutListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDU = ((ITPPlayerListener.IOnSubtitleFrameOutListener)localObject);
    }
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnVideoFrameOutListener;
      if (paramIOnVideoFrameOutListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDV = ((ITPPlayerListener.IOnVideoFrameOutListener)localObject);
    }
  }
  
  public void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener paramIOnVideoProcessFrameOutputListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnVideoProcessFrameOutputListener;
      if (paramIOnVideoProcessFrameOutputListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDX = ((ITPPlayerListener.IOnVideoProcessFrameOutputListener)localObject);
    }
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    if (this.ZDd != null)
    {
      d locald = this.ZDd;
      Object localObject = paramIOnVideoSizeChangedListener;
      if (paramIOnVideoSizeChangedListener == null) {
        localObject = locald.ZEb;
      }
      locald.ZDS = ((ITPPlayerListener.IOnVideoSizeChangedListener)localObject);
    }
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(221013);
    this.Zyx.bDy(ZDa + "setOutputMute, isOutputMute:" + paramBoolean);
    this.ZDc.a(17, 0, 0, Boolean.valueOf(paramBoolean), false, true);
    AppMethodBeat.o(221013);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(221018);
    this.Zyx.bDy(ZDa + "setPlaySpeedRatio, speedRatio:" + paramFloat);
    this.ZDc.a(19, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(221018);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(220902);
    this.ZDc.a(1, 0, 0, paramTPOptionalParam, true, false);
    AppMethodBeat.o(220902);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(220934);
    this.Zyx.bDy(ZDa + "setSurface, surface:" + paramSurface);
    this.ZDc.a(4, 0, 0, paramSurface, false, false);
    AppMethodBeat.o(220934);
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(220936);
    this.Zyx.bDy(ZDa + "setSurfaceHolder, SurfaceHolder:" + paramSurfaceHolder);
    this.ZDc.a(39, 0, 0, paramSurfaceHolder, false, false);
    AppMethodBeat.o(220936);
  }
  
  public void setTPSurface(ITPSurface paramITPSurface)
  {
    AppMethodBeat.i(220937);
    this.Zyx.bDy(ZDa + "setTPSurface, tpSurface:" + paramITPSurface);
    this.ZDc.a(44, 0, 0, paramITPSurface, false, false);
    AppMethodBeat.o(220937);
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(220962);
    this.ZDc.a(29, 0, 0, paramTPVideoInfo, true, false);
    AppMethodBeat.o(220962);
  }
  
  public void start()
  {
    AppMethodBeat.i(220993);
    this.Zyx.bDy(ZDa + "start");
    this.ZDc.a(11, 0, 0, null, false, false);
    AppMethodBeat.o(220993);
  }
  
  public void stop()
  {
    AppMethodBeat.i(220999);
    this.Zyx.bDy(ZDa + "stop");
    c localc = this.ZDc;
    localc.irI();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stop");
    localc.a(13, 0, 0, null, false, false);
    localc.irK();
    localc.irJ();
    AppMethodBeat.o(220999);
  }
  
  public void stopAsync()
  {
    AppMethodBeat.i(221002);
    this.Zyx.bDy(ZDa + "stopAsync");
    c localc = this.ZDc;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stopAsync");
    localc.a(37, 0, 0, null, false, false);
    AppMethodBeat.o(221002);
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(221028);
    this.Zyx.bDy(ZDa + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo);
    this.ZDc.switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, 2);
    AppMethodBeat.o(221028);
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(221033);
    this.Zyx.bDy(ZDa + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo + ", mode:" + paramInt);
    this.ZDc.switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, paramInt);
    AppMethodBeat.o(221033);
  }
  
  public void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(221027);
    this.Zyx.bDy(ZDa + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong);
    this.ZDc.switchDefinition(paramString, paramLong, paramTPVideoInfo, 2);
    AppMethodBeat.o(221027);
  }
  
  public void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(221031);
    this.Zyx.bDy(ZDa + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong + ", mode:" + paramInt);
    this.ZDc.switchDefinition(paramString, paramLong, paramTPVideoInfo, paramInt);
    AppMethodBeat.o(221031);
  }
  
  public void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(220896);
    if (paramb != null)
    {
      this.ZDs = false;
      this.Zyx.a(new com.tencent.thumbplayer.f.b(paramb, "TPPlayer"));
      this.ZDb.updateLoggerContext(this.Zyx.Zyw);
      if (this.ZDd != null) {
        this.ZDd.bDr(this.Zyx.Zyw.tag);
      }
    }
    AppMethodBeat.o(220896);
  }
  
  public final int z(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221146);
    if (this.ZDg == null)
    {
      this.Zyx.error("mAssetResourceLoader not set");
      AppMethodBeat.o(221146);
      return -1;
    }
    paramInt = this.ZDg.n(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(221146);
    return paramInt;
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private b ZDt;
    
    a(b paramb)
    {
      this.ZDt = paramb;
    }
    
    a(b paramb, Looper paramLooper)
    {
      super();
      this.ZDt = paramb;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(220803);
      b.c(b.this).bDx("mTransformHandler msg : " + paramMessage.what);
      d locald = b.e(b.this);
      if (locald == null)
      {
        AppMethodBeat.o(220803);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(220803);
        return;
        b.c(b.this).bDy("onPrepared");
        locald.onPrepared(this.ZDt);
        AppMethodBeat.o(220803);
        return;
        locald.onCompletion(this.ZDt);
        AppMethodBeat.o(220803);
        return;
        f.i locali = (f.i)paramMessage.obj;
        if ((locali != null) && (!b.a(b.this).iqV()))
        {
          locald.onInfo(this.ZDt, paramMessage.arg1, locali.fXA, locali.ZEt, locali.ZEu);
          AppMethodBeat.o(220803);
          return;
        }
        if (locali != null)
        {
          locald.onInfo(this.ZDt, paramMessage.arg1, locali.fXA, locali.ZEt, locali.ZEu);
          AppMethodBeat.o(220803);
          return;
          locali = (f.i)paramMessage.obj;
          if (locali != null)
          {
            locald.onError(this.ZDt, paramMessage.arg1, paramMessage.arg2, locali.fXA, locali.ZEt);
            AppMethodBeat.o(220803);
            return;
            locald.onSeekComplete(this.ZDt);
            AppMethodBeat.o(220803);
            return;
            paramMessage = (f.i)paramMessage.obj;
            if (paramMessage != null)
            {
              locald.onVideoSizeChanged(this.ZDt, paramMessage.fXA, paramMessage.ZEt);
              AppMethodBeat.o(220803);
              return;
              locald.onSubtitleData(this.ZDt, (TPSubtitleData)paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onSubtitleFrameOut(this.ZDt, (TPSubtitleFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onVideoFrameOut(this.ZDt, (TPVideoFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onAudioFrameOut(this.ZDt, (TPAudioFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onError(this.ZDt, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
              AppMethodBeat.o(220803);
              return;
              locald.onInfo(this.ZDt, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onInfo(this.ZDt, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onInfo(this.ZDt, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onInfo(this.ZDt, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onInfo(this.ZDt, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onInfo(this.ZDt, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onInfo(this.ZDt, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onInfo(this.ZDt, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              if (b.b(b.this) != null) {
                b.b(b.this).setPlayerOptionalParam(new TPOptionalParam().buildLong(8000, paramMessage.arg1));
              }
              locald.onInfo(this.ZDt, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(220803);
              return;
              locald.onStateChange(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(220803);
              return;
              locald.onStopAsyncComplete(this.ZDt);
            }
          }
        }
      }
    }
  }
  
  final class b
    implements c.a, com.tencent.thumbplayer.a.a.c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m, ITPPlayListener
  {
    b() {}
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(220835);
      d locald = b.e(b.this);
      if (locald != null)
      {
        paramTPPostProcessFrameBuffer = locald.onVideoProcessFrameOut(b.this, paramTPPostProcessFrameBuffer);
        AppMethodBeat.o(220835);
        return paramTPPostProcessFrameBuffer;
      }
      AppMethodBeat.o(220835);
      return null;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(220824);
      Object localObject = b.a(b.this).iqW();
      b.c(b.this).bDy("onError playerErrorCodeStr=".concat(String.valueOf(localObject)));
      j = paramInt1;
      i = paramInt2;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        i = Integer.parseInt((String)localObject);
        j = 4000;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          b.c(b.this).n(localException);
          j = paramInt1;
          i = paramInt2;
        }
      }
      b.a(b.this, j, i);
      b.c(b.this).bDy("onError errorTypeReal=" + j + ", errorCodeReal=" + i);
      localObject = new f.i();
      ((f.i)localObject).fXA = paramLong1;
      ((f.i)localObject).ZEt = paramLong2;
      b.a(b.this, 262, j, i, localObject);
      AppMethodBeat.o(220824);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(220819);
      b.a(b.this, paramInt, paramLong1, paramLong2, paramObject);
      if (paramInt == 1011)
      {
        b.a(b.this, paramObject);
        AppMethodBeat.o(220819);
        return;
      }
      if (paramInt == 1012)
      {
        b.b(b.this, paramObject);
        AppMethodBeat.o(220819);
        return;
      }
      f.i locali = new f.i();
      locali.fXA = paramLong1;
      locali.ZEt = paramLong2;
      locali.ZEu = paramObject;
      b.a(b.this, 261, paramInt, 0, locali);
      AppMethodBeat.o(220819);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(220834);
      d locald = b.e(b.this);
      if (locald != null) {
        locald.onAudioFrameOut(b.this, paramTPAudioFrameBuffer);
      }
      AppMethodBeat.o(220834);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(220829);
      b.a(b.this, 265, 0, 0, paramTPSubtitleData);
      AppMethodBeat.o(220829);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(220830);
      b.a(b.this, 279, 0, 0, paramTPSubtitleFrameBuffer);
      AppMethodBeat.o(220830);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(220831);
      d locald = b.e(b.this);
      if (locald != null) {
        locald.onVideoFrameOut(b.this, paramTPVideoFrameBuffer);
      }
      AppMethodBeat.o(220831);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(220836);
      d locald = b.e(b.this);
      if (locald != null)
      {
        paramTPPostProcessFrameBuffer = locald.onAudioProcessFrameOut(b.this, paramTPPostProcessFrameBuffer);
        AppMethodBeat.o(220836);
        return paramTPPostProcessFrameBuffer;
      }
      AppMethodBeat.o(220836);
      return null;
    }
    
    public final void ba(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(220827);
      f.i locali = new f.i();
      locali.fXA = paramLong1;
      locali.ZEt = paramLong2;
      b.a(b.this, 264, 0, 0, locali);
      AppMethodBeat.o(220827);
    }
    
    public final void cYp()
    {
      AppMethodBeat.i(220826);
      b.d(b.this);
      b.a(b.this, 110, new f().L("etime", Long.valueOf(System.currentTimeMillis())).L("petime", Long.valueOf(b.this.irp())).map);
      b.a(b.this, 263, 0, 0, null);
      AppMethodBeat.o(220826);
    }
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(220858);
      long l = b.f(b.this).getAdvRemainTime();
      AppMethodBeat.o(220858);
      return l;
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(220868);
      paramString = b.f(b.this).getContentType(paramInt, paramString);
      AppMethodBeat.o(220868);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(220856);
      int i = b.f(b.this).getCurrentPlayClipNo();
      AppMethodBeat.o(220856);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(220852);
      long l = b.f(b.this).getCurrentPosition();
      AppMethodBeat.o(220852);
      return l;
    }
    
    public final String getDataFilePath(int paramInt, String paramString)
    {
      AppMethodBeat.i(220867);
      paramString = b.f(b.this).getDataFilePath(paramInt, paramString);
      AppMethodBeat.o(220867);
      return paramString;
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(220866);
      long l = b.f(b.this).getDataTotalSize(paramInt, paramString);
      AppMethodBeat.o(220866);
      return l;
    }
    
    public final Object getPlayInfo(long paramLong)
    {
      return null;
    }
    
    public final Object getPlayInfo(String paramString)
    {
      return null;
    }
    
    public final long getPlayerBufferLength()
    {
      AppMethodBeat.i(220850);
      long l = b.f(b.this).getPlayerBufferLength();
      AppMethodBeat.o(220850);
      return l;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(220815);
      b.a(b.this, 111, new f().L("etime", Long.valueOf(System.currentTimeMillis())).L("reason", Integer.valueOf(0)).map);
      b.a(b.this, 260, 0, 0, null);
      AppMethodBeat.o(220815);
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(220847);
      b.c(b.this).bDy("onDownloadCdnUrlExpired");
      b.f(b.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(220847);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(220841);
      b.c(b.this).bDy("onDownloadCdnUrlInfoUpdate, url:" + paramString1 + ", cdnIp:" + paramString2 + ", uip:" + paramString3 + ", errorCodeStr:" + paramString4);
      b.f(b.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(220841);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(220840);
      b.c(b.this).bDy("onDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
      b.f(b.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(220840);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(220839);
      b.c(b.this).bDy("onDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
      b.f(b.this).onDownloadError(4000, paramInt2, paramString);
      AppMethodBeat.o(220839);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(220838);
      b.c(b.this).bDy("onDownloadFinish");
      b.f(b.this).onDownloadFinish();
      AppMethodBeat.o(220838);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(220837);
      b.f(b.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
      AppMethodBeat.o(220837);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220846);
      b.c(b.this).bDy("onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
      b.f(b.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(220846);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(220844);
      if (paramInt != b.g(b.this))
      {
        b.c(b.this).bDy("onDownloadStatusUpdate, status:".concat(String.valueOf(paramInt)));
        b.a(b.this, paramInt);
      }
      b.f(b.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(220844);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(220849);
      paramObject1 = b.f(b.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(220849);
      return paramObject1;
    }
    
    public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(220863);
      paramInt = b.f(b.this).onReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(220863);
      return paramInt;
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(220861);
      paramInt = b.f(b.this).onStartReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(220861);
      return paramInt;
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(220828);
      b.a(b.this, 277, paramInt1, paramInt2, null);
      AppMethodBeat.o(220828);
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(220865);
      paramInt1 = b.f(b.this).onStopReadData(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(220865);
      return paramInt1;
    }
    
    public final void qX()
    {
      AppMethodBeat.i(220810);
      b.a(b.this).aBb(0);
      Object localObject1 = b.b(b.this).iql();
      String str = ((com.tencent.thumbplayer.a.b)localObject1).width + "*" + ((com.tencent.thumbplayer.a.b)localObject1).height;
      Object localObject2 = b.b(b.this).getTrackInfo();
      if (localObject2 != null)
      {
        int m = localObject2.length;
        int j = 0;
        for (int i = 0;; i = k)
        {
          k = i;
          if (j >= m) {
            break;
          }
          k = i;
          if (localObject2[j].trackType == 2) {
            k = i + 1;
          }
          j += 1;
        }
      }
      int k = 0;
      localObject2 = b.this;
      localObject1 = new f().L("playertype", Integer.valueOf(b.b(b.this).getPlayerType())).L("definition", str).L("rate", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).ZxV)).L("duration", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).durationMs)).L("fmt", ((com.tencent.thumbplayer.a.b)localObject1).ZxR).L("etime", Long.valueOf(System.currentTimeMillis()));
      if (k > 1) {}
      for (boolean bool = true;; bool = false)
      {
        b.a((b)localObject2, 103, ((f)localObject1).L("multitrack", Boolean.valueOf(bool)).map);
        b.a(b.this, 257, 0, 0, null);
        AppMethodBeat.o(220810);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.b
 * JD-Core Version:    0.7.0.1
 */