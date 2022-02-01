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
  private static AtomicInteger SaF;
  private static String Saq;
  private com.tencent.thumbplayer.f.a RVN;
  private int SaA;
  private ArrayList<String> SaB;
  private long SaC;
  private long SaD;
  private long SaE;
  private AtomicInteger SaG;
  private boolean SaH;
  private com.tencent.thumbplayer.a.a Sar;
  private c Sas;
  private d Sat;
  private com.tencent.thumbplayer.e.a Sau;
  private com.tencent.thumbplayer.g.a.a.c Sav;
  private com.tencent.thumbplayer.e.a.a Saw;
  private com.tencent.thumbplayer.g.a.b Sax;
  private a Say;
  private boolean Saz;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(189440);
    Saq = "api call:";
    SaF = new AtomicInteger(1000);
    AppMethodBeat.o(189440);
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
    AppMethodBeat.i(189313);
    this.mUrl = null;
    this.Saz = true;
    this.SaA = -1;
    this.SaG = new AtomicInteger(1000);
    this.SaH = false;
    if (paramb != null)
    {
      paramb = new com.tencent.thumbplayer.f.b(paramb, "TPPlayer");
      this.RVN = new com.tencent.thumbplayer.f.a(paramb);
      this.RVN.info("create TPPlayer");
      this.mContext = paramContext.getApplicationContext();
      this.Sax = new com.tencent.thumbplayer.g.a.c();
      this.Sav = new com.tencent.thumbplayer.g.a.a.c(this.mContext);
      this.Sax.a(this.Sav);
      a(100, 0, 0, null, new f().S("stime", Long.valueOf(System.currentTimeMillis())).map);
      if (paramLooper2 != null) {
        break label575;
      }
    }
    label575:
    for (this.Say = new a(this);; this.Say = new a(this, paramLooper2))
    {
      b localb = new b();
      this.Sat = new d(this.RVN.RVM.tag);
      this.Sar = new com.tencent.thumbplayer.a.d(this.mContext, paramb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.a(localb);
      this.Sar.setOnPlayerStateChangeListener(localb);
      if (paramLooper1 != null)
      {
        paramLooper2 = paramLooper1;
        if (paramLooper1 != Looper.getMainLooper()) {}
      }
      else
      {
        this.mHandlerThread = new HandlerThread("TP-workthread");
        this.mHandlerThread.start();
        paramLooper2 = this.mHandlerThread.getLooper();
      }
      this.Sas = new c(paramLooper2, this);
      a(101, 0, 0, null, new f().S("etime", Long.valueOf(System.currentTimeMillis())).map);
      this.Sau = new com.tencent.thumbplayer.e.c(paramContext);
      this.Sau.a(localb);
      this.Sax.a(new com.tencent.thumbplayer.g.a.a.e()).a(new com.tencent.thumbplayer.g.a.a.b());
      this.SaB = new ArrayList();
      AppMethodBeat.o(189313);
      return;
      paramb = new com.tencent.thumbplayer.f.b("ThumbPlayer", String.valueOf(SaF.incrementAndGet()), String.valueOf(this.SaG.incrementAndGet()), "TPPlayer");
      this.SaH = true;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(189431);
    try
    {
      if (this.Sax != null) {
        this.Sax.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      AppMethodBeat.o(189431);
      return;
    }
    catch (Exception paramString)
    {
      this.RVN.r(paramString);
      AppMethodBeat.o(189431);
    }
  }
  
  private void f(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(189432);
    if (this.Say != null)
    {
      Message localMessage = this.Say.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.Say.sendMessage(localMessage);
    }
    AppMethodBeat.o(189432);
  }
  
  private void hob()
  {
    AppMethodBeat.i(189427);
    try
    {
      this.Sar.stop();
      a(107, 0, 0, null, new f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", Integer.valueOf(1)).map);
      this.Sau.aro(5);
      this.SaC = -1L;
      this.SaD = -1L;
      this.SaE = -1L;
      AppMethodBeat.o(189427);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.RVN.r(localException);
      }
    }
  }
  
  private boolean hoc()
  {
    AppMethodBeat.i(189428);
    if ((this.Sau.isEnable()) && (com.tencent.thumbplayer.d.a.hnj()) && (this.Saz))
    {
      AppMethodBeat.o(189428);
      return true;
    }
    AppMethodBeat.o(189428);
    return false;
  }
  
  private void hod()
  {
    AppMethodBeat.i(189430);
    if (this.Sar.isPlaying()) {}
    for (int i = 0;; i = 5)
    {
      this.Sau.aro(i);
      AppMethodBeat.o(189430);
      return;
    }
  }
  
  private void mA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189429);
    a(108, paramInt1, paramInt2, "", new f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", Integer.valueOf(3)).S("code", paramInt1 + "." + paramInt2).map);
    this.Sau.aro(3);
    AppMethodBeat.o(189429);
  }
  
  public final int A(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(189385);
    if (this.Saw == null)
    {
      this.RVN.error("mAssetResourceLoader not set");
      AppMethodBeat.o(189385);
      return -1;
    }
    paramInt1 = this.Saw.onStopReadData(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(189385);
    return paramInt1;
  }
  
  public final void DX(boolean paramBoolean)
  {
    AppMethodBeat.i(189394);
    try
    {
      this.Sar.setOutputMute(paramBoolean);
      AppMethodBeat.o(189394);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189394);
    }
  }
  
  public final void DY(boolean paramBoolean)
  {
    AppMethodBeat.i(189398);
    try
    {
      this.Sar.setLoopback(paramBoolean);
      AppMethodBeat.o(189398);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189398);
    }
  }
  
  public final void V(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(189417);
    this.RVN.info("handleOnDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
    mA(paramInt1, paramInt2);
    f(268, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(189417);
  }
  
  public final Object a(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(189423);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(189423);
      return null;
      this.RVN.info("onDownloadNoMoreData");
      f(276, 0, 0, paramObject1);
      continue;
      if (!(paramObject2 instanceof Integer)) {
        this.RVN.info("MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3.");
      } else {
        f(278, ((Integer)paramObject2).intValue(), 0, null);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(189415);
    this.SaC = paramInt1;
    this.SaD = paramLong1;
    this.SaE = paramLong2;
    TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
    localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
    localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
    localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
    localTPDownLoadProgressInfo.totalFileSize = paramLong2;
    localTPDownLoadProgressInfo.extraInfo = paramString;
    this.RVN.info("handleOnDownloadProgressUpdate");
    a(200, 0, 0, null, new f().S("speed", Integer.valueOf(paramInt2)).S("spanId", paramString).map);
    f(274, 0, 0, localTPDownLoadProgressInfo);
    AppMethodBeat.o(189415);
  }
  
  public final void a(ITPSurface paramITPSurface)
  {
    AppMethodBeat.i(189372);
    try
    {
      if ((paramITPSurface instanceof e)) {
        this.Sar.setSurface(((e)paramITPSurface).Sbr);
      }
      AppMethodBeat.o(189372);
      return;
    }
    catch (Exception paramITPSurface)
    {
      this.RVN.r(paramITPSurface);
      AppMethodBeat.o(189372);
    }
  }
  
  public final void a(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(189412);
    try
    {
      this.Sar.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      AppMethodBeat.o(189412);
      return;
    }
    catch (Exception paramTPCaptureParams)
    {
      this.RVN.r(paramTPCaptureParams);
      AppMethodBeat.o(189412);
    }
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(189414);
    paramITPMediaAsset = this.Sau.a(paramITPMediaAsset, paramLong, paramTPVideoInfo);
    if (paramITPMediaAsset != null) {
      try
      {
        this.RVN.info("handleSwitchDef, proxyMediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong);
        this.Sar.a(paramTPVideoInfo);
        this.Sar.a(paramITPMediaAsset, paramInt, paramLong);
        a(120, 0, 0, null, new f().S("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(189414);
        return;
      }
      catch (Exception paramITPMediaAsset)
      {
        this.RVN.r(paramITPMediaAsset);
      }
    }
    AppMethodBeat.o(189414);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(189373);
    if (paramb != null)
    {
      try
      {
        if (TextUtils.isEmpty(paramb.url)) {
          break label203;
        }
        this.mUrl = paramb.url;
        com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramb.url);
        this.RVN.info("handleSetDataSource originalUrl=" + paramb.url);
        if (hoc())
        {
          locale = this.Sau.bqC(paramb.url);
          this.RVN.info("handleSetDataSource selfPlayerUrl=" + locale.RWt);
          this.RVN.info("handleSetDataSource systemPlayerUrl=" + locale.RWs);
        }
        if (paramb.Sbw != null)
        {
          this.Sar.a(locale, paramb.Sbw);
          AppMethodBeat.o(189373);
          return;
        }
        this.Sar.a(locale);
        AppMethodBeat.o(189373);
        return;
      }
      catch (Exception paramb)
      {
        this.RVN.r(paramb);
      }
    }
    else
    {
      AppMethodBeat.o(189373);
      return;
    }
    label203:
    if (paramb.Sby != null)
    {
      if (hoc()) {
        paramb.Sby = this.Sau.b(paramb.Sby);
      }
      if (paramb.Sby != null)
      {
        this.RVN.info("handleSetDataSource mediaAsset=" + paramb.Sby.getUrl());
        this.Sar.setDataSource(paramb.Sby);
      }
      AppMethodBeat.o(189373);
      return;
    }
    this.Sar.setDataSource(paramb.Sbx);
    AppMethodBeat.o(189373);
  }
  
  public final void a(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(189413);
    com.tencent.thumbplayer.a.a.e locale = this.Sau.a(paramLong, paramString, paramTPVideoInfo);
    try
    {
      this.RVN.info("handleSwitchDef, proxyUrl:" + paramString + ", defID:" + paramLong);
      this.Sar.a(paramTPVideoInfo);
      this.Sar.a(locale, paramInt, paramLong);
      a(120, 0, 0, null, new f().S("switch", String.valueOf(paramLong)).map);
      AppMethodBeat.o(189413);
      return;
    }
    catch (Exception paramString)
    {
      this.RVN.r(paramString);
      AppMethodBeat.o(189413);
    }
  }
  
  public final void a(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(189376);
    if (!hoc())
    {
      this.RVN.error("handleAddAudioSource, proxy is not enable.");
      AppMethodBeat.o(189376);
      return;
    }
    if ((TextUtils.isEmpty(paramString2)) || (!com.tencent.thumbplayer.utils.b.bnL(paramString1)))
    {
      this.RVN.error("handleAddAudioSource, illegal argument.");
      AppMethodBeat.o(189376);
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
      this.Sar.g(paramString1, paramString2, localArrayList);
      AppMethodBeat.o(189376);
      return;
    }
    catch (Exception paramString1)
    {
      this.RVN.r(paramString1);
      AppMethodBeat.o(189376);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(189375);
    try
    {
      long l = System.currentTimeMillis();
      if ((hoc()) && (com.tencent.thumbplayer.utils.b.bnL(paramString1)))
      {
        paramTPDownloadParamData = this.Sau.a(3, paramString1, paramTPDownloadParamData);
        this.SaB.add(paramTPDownloadParamData);
        this.Sar.addSubtitleSource(paramTPDownloadParamData, paramString2, paramString3);
      }
      for (;;)
      {
        a(118, 0, 0, null, new f().S("stime", Long.valueOf(l)).S("etime", Long.valueOf(System.currentTimeMillis())).S("url", paramString1).map);
        AppMethodBeat.o(189375);
        return;
        this.Sar.addSubtitleSource(paramString1, paramString2, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      this.RVN.r(paramString1);
      AppMethodBeat.o(189375);
    }
  }
  
  public final void aY(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189377);
    try
    {
      TPTrackInfo[] arrayOfTPTrackInfo = this.Sar.getTrackInfo();
      if ((arrayOfTPTrackInfo != null) && (arrayOfTPTrackInfo.length > paramInt)) {
        a(122, 0, 0, null, new f().S("opaque", Long.valueOf(paramLong)).S("tracktype", Integer.valueOf(arrayOfTPTrackInfo[paramInt].getTrackType())).S("stime", Long.valueOf(System.currentTimeMillis())).map);
      }
      this.Sar.selectTrack(paramInt, paramLong);
      AppMethodBeat.o(189377);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189377);
    }
  }
  
  public final void aZ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189378);
    try
    {
      this.Sar.deselectTrack(paramInt, paramLong);
      AppMethodBeat.o(189378);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189378);
    }
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189328);
    this.RVN.info(Saq + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2);
    this.Sas.addAudioTrackSource(paramString1, paramString2, null);
    AppMethodBeat.o(189328);
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(189329);
    this.RVN.info(Saq + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2 + ", downloadParamData:" + paramTPDownloadParamData);
    this.Sas.addAudioTrackSource(paramString1, paramString2, paramTPDownloadParamData);
    AppMethodBeat.o(189329);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(189326);
    this.RVN.info(Saq + "addSubtitleSource, url:" + paramString1 + ", mimeType:" + paramString2 + ", name:" + paramString3);
    this.Sas.addSubtitleSource(paramString1, paramString2, paramString3, null);
    AppMethodBeat.o(189326);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(189327);
    this.RVN.info(Saq + "addSubtitleSource, url:" + paramString1 + ", name:" + paramString3 + ", downloadParamData:" + paramTPDownloadParamData);
    this.Sas.addSubtitleSource(paramString1, paramString2, paramString3, paramTPDownloadParamData);
    AppMethodBeat.o(189327);
  }
  
  public final void arA(int paramInt)
  {
    AppMethodBeat.i(189420);
    f(272, paramInt, 0, null);
    AppMethodBeat.o(189420);
  }
  
  public final String arx(int paramInt)
  {
    AppMethodBeat.i(189387);
    if (this.Saw == null)
    {
      this.RVN.error("mAssetResourceLoader not set");
      AppMethodBeat.o(189387);
      return "";
    }
    String str = this.Saw.Mf(paramInt);
    AppMethodBeat.o(189387);
    return str;
  }
  
  public final long ary(int paramInt)
  {
    AppMethodBeat.i(189400);
    try
    {
      long l = this.Sar.getPropertyLong(paramInt);
      AppMethodBeat.o(189400);
      return l;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189400);
    }
    return 0L;
  }
  
  public final String arz(int paramInt)
  {
    AppMethodBeat.i(189401);
    try
    {
      String str = this.Sar.getPropertyString(paramInt);
      AppMethodBeat.o(189401);
      return str;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189401);
    }
    return null;
  }
  
  public final void asf()
  {
    AppMethodBeat.i(189382);
    try
    {
      this.Sar.pause();
      a(106, 0, 0, null, new f().S("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.Sau.aro(5);
      AppMethodBeat.o(189382);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189382);
    }
  }
  
  public final int b(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189383);
    if (this.Saw == null)
    {
      this.RVN.error("mAssetResourceLoader not set");
      AppMethodBeat.o(189383);
      return -1;
    }
    paramInt = this.Saw.onStartReadData(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(189383);
    return paramInt;
  }
  
  public final void b(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(189369);
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 205))
    {
      this.Saz = paramTPOptionalParam.getParamBoolean().value;
      AppMethodBeat.o(189369);
      return;
    }
    this.Sau.setPlayerOptionalParam(paramTPOptionalParam);
    try
    {
      this.Sar.setPlayerOptionalParam(paramTPOptionalParam);
      AppMethodBeat.o(189369);
      return;
    }
    catch (Exception paramTPOptionalParam)
    {
      this.RVN.r(paramTPOptionalParam);
      AppMethodBeat.o(189369);
    }
  }
  
  public final void b(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(189374);
    if (paramTPVideoInfo != null) {}
    try
    {
      this.Sau.setVideoInfo(paramTPVideoInfo);
      this.Sar.setVideoInfo(paramTPVideoInfo);
      AppMethodBeat.o(189374);
      return;
    }
    catch (Exception paramTPVideoInfo)
    {
      this.RVN.r(paramTPVideoInfo);
      AppMethodBeat.o(189374);
    }
  }
  
  public final void ba(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189379);
    try
    {
      this.Sar.selectProgram(paramInt, paramLong);
      AppMethodBeat.o(189379);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189379);
    }
  }
  
  public final void bqD(String paramString)
  {
    AppMethodBeat.i(189396);
    try
    {
      this.Sar.setAudioNormalizeVolumeParams(paramString);
      AppMethodBeat.o(189396);
      return;
    }
    catch (Exception paramString)
    {
      this.RVN.r(paramString);
      AppMethodBeat.o(189396);
    }
  }
  
  public final void bqE(String paramString)
  {
    AppMethodBeat.i(189418);
    this.RVN.info("handleOnDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
    f(269, 0, 0, paramString);
    AppMethodBeat.o(189418);
  }
  
  public final void bu(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(189419);
    TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
    localTPCDNURLInfo.url = paramString1;
    localTPCDNURLInfo.cdnIp = paramString2;
    localTPCDNURLInfo.uIp = paramString3;
    a(201, 0, 0, null, new f().S("url", paramString1).S("cdnip", paramString2).S("cdnuip", paramString3).map);
    f(270, 0, 0, localTPCDNURLInfo);
    AppMethodBeat.o(189419);
  }
  
  public final void c(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(189371);
    try
    {
      this.Sar.setSurfaceHolder(paramSurfaceHolder);
      AppMethodBeat.o(189371);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      this.RVN.r(paramSurfaceHolder);
      AppMethodBeat.o(189371);
    }
  }
  
  public final void cN(float paramFloat)
  {
    AppMethodBeat.i(189395);
    try
    {
      this.Sar.setAudioGainRatio(paramFloat);
      AppMethodBeat.o(189395);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189395);
    }
  }
  
  public final void cO(float paramFloat)
  {
    AppMethodBeat.i(189397);
    try
    {
      this.Sar.setPlaySpeedRatio(paramFloat);
      a(116, 0, 0, null, new f().S("scene", Float.valueOf(paramFloat)).map);
      AppMethodBeat.o(189397);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.RVN.r(localException);
      }
    }
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(189368);
    this.RVN.info(Saq + "captureVideo, params:" + paramTPCaptureParams + ", captureCallBack:" + paramTPCaptureCallBack);
    c localc = this.Sas;
    localc.hoh();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : captureVideo");
    f.l locall = new f.l();
    locall.SbO = paramTPCaptureCallBack;
    locall.SbN = paramTPCaptureParams;
    localc.a(30, 0, 0, locall, true, false);
    localc.hoj();
    localc.hoi();
    AppMethodBeat.o(189368);
  }
  
  public final void co(Map<String, String> paramMap)
  {
    AppMethodBeat.i(189422);
    this.RVN.info("onDownloadCdnUrlExpired");
    f(275, 0, 0, paramMap);
    AppMethodBeat.o(189422);
  }
  
  public final void d(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189399);
    try
    {
      this.Sar.setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(189399);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189399);
    }
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189331);
    this.RVN.info(Saq + "deselectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    this.Sas.a(36, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(189331);
  }
  
  public final long dw(int paramInt, String paramString)
  {
    AppMethodBeat.i(189386);
    if (this.Saw == null)
    {
      this.RVN.error("mAssetResourceLoader not set");
      AppMethodBeat.o(189386);
      return -1L;
    }
    long l = this.Saw.getDataTotalSize(paramInt, paramString);
    AppMethodBeat.o(189386);
    return l;
  }
  
  public final String dx(int paramInt, String paramString)
  {
    AppMethodBeat.i(189388);
    if (this.Saw == null)
    {
      this.RVN.error("mAssetResourceLoader not set");
      AppMethodBeat.o(189388);
      return "";
    }
    paramString = this.Saw.getContentType(paramInt, paramString);
    AppMethodBeat.o(189388);
    return paramString;
  }
  
  public void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener, Looper paramLooper)
  {
    AppMethodBeat.i(189316);
    if (paramITPAssetResourceLoaderListener != null)
    {
      this.Sau.DV(true);
      if (this.Saw != null)
      {
        this.Saw.release();
        this.Saw = null;
      }
      this.Saw = new com.tencent.thumbplayer.e.a.b(this.mContext, paramLooper);
      this.Saw.a(paramITPAssetResourceLoaderListener);
      this.Saw.hnB();
      AppMethodBeat.o(189316);
      return;
    }
    this.Sau.DV(false);
    AppMethodBeat.o(189316);
  }
  
  public void enableTPAssetResourceLoader(com.tencent.thumbplayer.e.a.a parama)
  {
    AppMethodBeat.i(189317);
    this.RVN.info(Saq + "enableTPAssetResourceLoader, assetResourceLoader:" + parama);
    if (parama != null)
    {
      this.Sau.DV(true);
      if (this.Saw != null)
      {
        this.Saw.release();
        this.Saw = null;
      }
      this.Saw = parama;
      AppMethodBeat.o(189317);
      return;
    }
    this.Sau.DV(false);
    AppMethodBeat.o(189317);
  }
  
  public int getBufferPercent()
  {
    AppMethodBeat.i(189358);
    int i = this.Sas.getBufferPercent();
    AppMethodBeat.o(189358);
    return i;
  }
  
  public long getCurrentPositionMs()
  {
    AppMethodBeat.i(189356);
    long l = this.Sas.getCurrentPositionMs();
    AppMethodBeat.o(189356);
    return l;
  }
  
  public int getCurrentState()
  {
    AppMethodBeat.i(189357);
    c localc = this.Sas;
    localc.hoh();
    localc.SaW = 1;
    localc.a(43, 0, 0, null, false, false);
    localc.hoj();
    localc.hoi();
    int i = localc.SaW;
    AppMethodBeat.o(189357);
    return i;
  }
  
  public long getDurationMs()
  {
    AppMethodBeat.i(189355);
    long l = this.Sas.getDurationMs();
    AppMethodBeat.o(189355);
    return l;
  }
  
  public long getPlayableDurationMs()
  {
    AppMethodBeat.i(189359);
    long l = this.Sas.getPlayableDurationMs();
    AppMethodBeat.o(189359);
    return l;
  }
  
  public ITPPlayerProxy getPlayerProxy()
  {
    return this.Sau;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(189367);
    this.RVN.info(Saq + "getPlayerType");
    c localc = this.Sas;
    localc.hoh();
    localc.SaX = 0;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get player type");
    localc.a(40, 0, 0, null, false, false);
    localc.hoj();
    localc.hoi();
    int i = localc.SaX;
    AppMethodBeat.o(189367);
    return i;
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(189333);
    this.RVN.info(Saq + "getProgramInfo");
    Object localObject = this.Sas;
    ((c)localObject).hoh();
    ((c)localObject).SaM.SbG = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get program info");
    ((c)localObject).a(33, 0, 0, null, false, false);
    ((c)localObject).hoj();
    ((c)localObject).hoi();
    localObject = ((c)localObject).SaM.SbG;
    AppMethodBeat.o(189333);
    return localObject;
  }
  
  public long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(189353);
    this.RVN.info(Saq + "getPropertyLong, paramId:" + paramInt);
    c localc = this.Sas;
    localc.hoh();
    localc.SaN = 0L;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property long");
    localc.a(27, paramInt, 0, null, false, false);
    localc.hoj();
    localc.hoi();
    long l = localc.SaN;
    AppMethodBeat.o(189353);
    return l;
  }
  
  public String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(189354);
    this.RVN.info(Saq + "getPropertyString, paramId:" + paramInt);
    Object localObject = this.Sas;
    ((c)localObject).hoh();
    ((c)localObject).SaO = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property string");
    ((c)localObject).a(28, paramInt, 0, null, false, false);
    ((c)localObject).hoj();
    ((c)localObject).hoi();
    localObject = ((c)localObject).SaO;
    AppMethodBeat.o(189354);
    return localObject;
  }
  
  public ITPBusinessReportManager getReportManager()
  {
    return this.Sav;
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(189362);
    this.RVN.info(Saq + "getTrackInfo");
    Object localObject = this.Sas;
    ((c)localObject).hoh();
    ((c)localObject).SaL.SbM = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get trackInfo");
    ((c)localObject).a(23, 0, 0, null, false, false);
    ((c)localObject).hoj();
    ((c)localObject).hoi();
    localObject = ((c)localObject).SaL.SbM;
    AppMethodBeat.o(189362);
    return localObject;
  }
  
  public int getVideoHeight()
  {
    AppMethodBeat.i(189361);
    this.RVN.info(Saq + "getVideoHeight");
    c localc = this.Sas;
    localc.hoh();
    localc.a(22, 0, 0, null, false, false);
    localc.hoj();
    localc.hoi();
    int i = localc.SaK.height;
    AppMethodBeat.o(189361);
    return i;
  }
  
  public int getVideoWidth()
  {
    AppMethodBeat.i(189360);
    this.RVN.info(Saq + "getVideoWidth");
    c localc = this.Sas;
    localc.hoh();
    localc.a(21, 0, 0, null, false, false);
    localc.hoj();
    localc.hoi();
    int i = localc.SaK.width;
    AppMethodBeat.o(189360);
    return i;
  }
  
  public final void hnF()
  {
    AppMethodBeat.i(189364);
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 0L);
    try
    {
      this.Sar.setPlayerOptionalParam(localTPOptionalParam);
      this.Sau.pauseDownload();
      AppMethodBeat.o(189364);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.RVN.r(localException);
      }
    }
  }
  
  public final void hnG()
  {
    AppMethodBeat.i(189366);
    this.Sau.resumeDownload();
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 1L);
    try
    {
      this.Sar.setPlayerOptionalParam(localTPOptionalParam);
      AppMethodBeat.o(189366);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189366);
    }
  }
  
  public final void hnH()
  {
    AppMethodBeat.i(189380);
    try
    {
      this.Sar.prepareAsync();
      Object localObject = UUID.randomUUID().toString() + System.nanoTime() + "_" + com.tencent.thumbplayer.d.a.getPlatform();
      a(102, 0, 0, null, new f().S("stime", Long.valueOf(System.currentTimeMillis())).S("url", this.mUrl).S("p2p", Boolean.valueOf(hoc())).S("flowid", localObject).map);
      localObject = new f.i();
      if (hoc()) {}
      for (long l = 1L;; l = 0L)
      {
        ((f.i)localObject).edr = l;
        f(261, 1009, 0, localObject);
        AppMethodBeat.o(189380);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189380);
    }
  }
  
  public final void hnI()
  {
    AppMethodBeat.i(189381);
    try
    {
      this.Sar.start();
      a(104, 0, 0, null, new f().S("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.Sau.aro(0);
      AppMethodBeat.o(189381);
      return;
    }
    catch (Exception localException)
    {
      this.RVN.r(localException);
      AppMethodBeat.o(189381);
    }
  }
  
  public final void hnJ()
  {
    AppMethodBeat.i(189389);
    hob();
    AppMethodBeat.o(189389);
  }
  
  public final void hnK()
  {
    AppMethodBeat.i(189390);
    hob();
    f(280, 0, 0, null);
    AppMethodBeat.o(189390);
  }
  
  public final void hnL()
  {
    AppMethodBeat.i(189391);
    this.Sar.reset();
    a(113, 0, 0, null, new f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", Integer.valueOf(1)).map);
    this.Sau.stopDownload();
    this.SaA = -1;
    this.SaB.clear();
    if (this.Saw != null) {
      this.Saw.reset();
    }
    this.SaC = -1L;
    this.SaD = -1L;
    this.SaE = -1L;
    AppMethodBeat.o(189391);
  }
  
  public final void hnM()
  {
    AppMethodBeat.i(189392);
    this.Sar.release();
    a(112, 0, 0, null, new f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", Integer.valueOf(1)).map);
    if (this.Say != null)
    {
      this.Say.removeCallbacksAndMessages(null);
      this.Say = null;
    }
    if (this.Sat != null)
    {
      d locald = this.Sat;
      locald.Sbc = locald.Sbq;
      locald.Sbd = locald.Sbq;
      locald.Sbe = locald.Sbq;
      locald.Sbf = locald.Sbq;
      locald.Sbg = locald.Sbq;
      locald.Sbh = locald.Sbq;
      locald.Sbi = locald.Sbq;
      locald.Sbk = locald.Sbq;
      locald.Sbl = locald.Sbq;
      locald.Sbo = locald.Sbq;
      locald.Sbp = locald.Sbq;
      this.Sat = null;
    }
    this.Sau.release();
    this.SaB.clear();
    if (this.Saw != null)
    {
      this.Saw.release();
      this.Saw = null;
    }
    this.SaC = -1L;
    this.SaD = -1L;
    this.SaE = -1L;
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(189392);
  }
  
  public final long hnN()
  {
    AppMethodBeat.i(189402);
    long l = this.Sar.getDurationMs();
    AppMethodBeat.o(189402);
    return l;
  }
  
  public final long hnO()
  {
    AppMethodBeat.i(189403);
    long l = this.Sar.getCurrentPositionMs();
    AppMethodBeat.o(189403);
    return l;
  }
  
  public final int hnP()
  {
    AppMethodBeat.i(189404);
    int i = this.Sar.getCurrentState();
    AppMethodBeat.o(189404);
    return i;
  }
  
  public final int hnQ()
  {
    AppMethodBeat.i(189405);
    if (this.Sar.getDurationMs() == 0L)
    {
      AppMethodBeat.o(189405);
      return 0;
    }
    int i = (int)(100.0F * (float)(this.Sar.getPlayableDurationMs() - this.Sar.getCurrentPositionMs()) / (float)this.Sar.getDurationMs());
    AppMethodBeat.o(189405);
    return i;
  }
  
  public final long hnR()
  {
    AppMethodBeat.i(189406);
    if (hoc())
    {
      if ((this.SaD > 0L) && (this.SaE > 0L))
      {
        l = (this.SaD * 1.0D / this.SaE * this.Sar.getDurationMs());
        AppMethodBeat.o(189406);
        return l;
      }
      l = this.SaC;
      AppMethodBeat.o(189406);
      return l;
    }
    long l = this.Sar.getPlayableDurationMs();
    AppMethodBeat.o(189406);
    return l;
  }
  
  public final int hnS()
  {
    AppMethodBeat.i(189407);
    int i = this.Sar.getVideoWidth();
    AppMethodBeat.o(189407);
    return i;
  }
  
  public final int hnT()
  {
    AppMethodBeat.i(189408);
    int i = this.Sar.getVideoHeight();
    AppMethodBeat.o(189408);
    return i;
  }
  
  public final int hnU()
  {
    AppMethodBeat.i(189409);
    int i = this.Sar.getPlayerType();
    AppMethodBeat.o(189409);
    return i;
  }
  
  public final TPTrackInfo[] hnV()
  {
    AppMethodBeat.i(189410);
    TPTrackInfo[] arrayOfTPTrackInfo = this.Sar.getTrackInfo();
    AppMethodBeat.o(189410);
    return arrayOfTPTrackInfo;
  }
  
  public final TPProgramInfo[] hnW()
  {
    AppMethodBeat.i(189411);
    TPProgramInfo[] arrayOfTPProgramInfo = this.Sar.getProgramInfo();
    AppMethodBeat.o(189411);
    return arrayOfTPProgramInfo;
  }
  
  public final void hnX()
  {
    AppMethodBeat.i(189416);
    this.RVN.info("onDownloadFinish");
    f(271, 0, 0, Integer.valueOf(0));
    AppMethodBeat.o(189416);
  }
  
  public final long hnY()
  {
    AppMethodBeat.i(189424);
    com.tencent.thumbplayer.a.a locala = this.Sar;
    if (locala != null)
    {
      long l1 = locala.getPlayableDurationMs();
      long l2 = this.Sar.getCurrentPositionMs();
      AppMethodBeat.o(189424);
      return l1 - l2;
    }
    AppMethodBeat.o(189424);
    return 0L;
  }
  
  public final int hnZ()
  {
    AppMethodBeat.i(189425);
    com.tencent.thumbplayer.a.a locala = this.Sar;
    if (locala != null)
    {
      int i = locala.getCurrentPlayClipNo();
      AppMethodBeat.o(189425);
      return i;
    }
    AppMethodBeat.o(189425);
    return 0;
  }
  
  public final long hoa()
  {
    AppMethodBeat.i(189426);
    ITPPlayerProxyListener localITPPlayerProxyListener = this.Sau.hnw();
    if (localITPPlayerProxyListener != null)
    {
      long l = localITPPlayerProxyListener.getAdvRemainTimeMs();
      AppMethodBeat.o(189426);
      return l;
    }
    AppMethodBeat.o(189426);
    return -1L;
  }
  
  public final void l(Surface paramSurface)
  {
    AppMethodBeat.i(189370);
    try
    {
      this.Sar.setSurface(paramSurface);
      AppMethodBeat.o(189370);
      return;
    }
    catch (Exception paramSurface)
    {
      this.RVN.r(paramSurface);
      AppMethodBeat.o(189370);
    }
  }
  
  public final void mz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189393);
    a(109, 0, 0, null, new f().S("stime", Long.valueOf(System.currentTimeMillis())).S("format", Integer.valueOf(0)).S("pstime", Long.valueOf(hnO())).map);
    if (paramInt2 > 0) {}
    try
    {
      this.Sar.seekTo(paramInt1, paramInt2);
      for (;;)
      {
        this.Sau.aro(1);
        AppMethodBeat.o(189393);
        return;
        this.Sar.seekTo(paramInt1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.RVN.r(localException);
      }
    }
  }
  
  public final void nO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(189421);
    this.RVN.info("onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    f(273, 0, 0, localTPProtocolInfo);
    AppMethodBeat.o(189421);
  }
  
  public void pause()
  {
    AppMethodBeat.i(189336);
    this.RVN.info(Saq + "pause");
    this.Sas.a(12, 0, 0, null, false, false);
    AppMethodBeat.o(189336);
  }
  
  public void pauseDownload()
  {
    AppMethodBeat.i(189363);
    this.RVN.info(Saq + "pauseDownload");
    this.Sas.a(41, 0, 0, null, false, false);
    AppMethodBeat.o(189363);
  }
  
  public void prepareAsync()
  {
    AppMethodBeat.i(189334);
    this.RVN.info(Saq + "prepareAsync");
    this.Sas.a(10, 0, 0, null, false, false);
    AppMethodBeat.o(189334);
  }
  
  public void release()
  {
    AppMethodBeat.i(189340);
    this.RVN.info(Saq + "release");
    c localc = this.Sas;
    localc.hoh();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : release");
    localc.a(15, 0, 0, null, false, false);
    localc.hoj();
    localc.hoi();
    this.Sax.release();
    AppMethodBeat.o(189340);
  }
  
  public void reset()
  {
    AppMethodBeat.i(189339);
    this.RVN.info(Saq + "reset");
    if (this.SaH)
    {
      localObject = this.RVN;
      int i = this.SaG.incrementAndGet();
      localObject = ((com.tencent.thumbplayer.f.a)localObject).RVM;
      ((com.tencent.thumbplayer.f.b)localObject).taskId = String.valueOf(i);
      ((com.tencent.thumbplayer.f.b)localObject).hnE();
      this.Sar.updateLoggerContext(this.RVN.RVM);
      if (this.Sat != null) {
        this.Sat.bqx(this.RVN.RVM.tag);
      }
    }
    Object localObject = this.Sas;
    ((c)localObject).hoh();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : reset");
    ((c)localObject).a(14, 0, 0, null, false, false);
    ((c)localObject).hoj();
    ((c)localObject).hoi();
    AppMethodBeat.o(189339);
  }
  
  public void resumeDownload()
  {
    AppMethodBeat.i(189365);
    this.RVN.info(Saq + "resumeDownload");
    this.Sas.a(42, 0, 0, null, false, false);
    AppMethodBeat.o(189365);
  }
  
  public void seekTo(int paramInt)
  {
    AppMethodBeat.i(189341);
    this.RVN.info(Saq + "seekTo, positionMs:" + paramInt);
    this.Sas.a(16, paramInt, 0, null, false, false);
    AppMethodBeat.o(189341);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189342);
    this.RVN.info(Saq + "seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.Sas.a(16, paramInt1, paramInt2, null, false, false);
    AppMethodBeat.o(189342);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189332);
    this.RVN.info(Saq + "selectProgram, programIndex:" + paramInt + ", opaque:" + paramLong);
    this.Sas.a(32, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(189332);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(189330);
    this.RVN.info(Saq + "selectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    this.Sas.a(8, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(189330);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(189344);
    this.RVN.info(Saq + "setAudioGainRatio, gainRatio:" + paramFloat);
    this.Sas.a(18, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(189344);
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(189345);
    this.RVN.info(Saq + "setAudioNormalizeVolumeParams, audioNormalizeVolumeParams:" + paramString);
    this.Sas.a(38, 0, 0, paramString, false, true);
    AppMethodBeat.o(189345);
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(189323);
    this.RVN.info(Saq + "setDataSource, ParcelFileDescriptor");
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(189323);
      throw paramParcelFileDescriptor;
    }
    c localc = this.Sas;
    f.b localb = new f.b();
    localb.Sbx = paramParcelFileDescriptor;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(189323);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(189324);
    this.RVN.info(Saq + "setDataSource, ITPMediaAsset");
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalArgumentException("asset is null");
      AppMethodBeat.o(189324);
      throw paramITPMediaAsset;
    }
    if (((paramITPMediaAsset instanceof ITPMediaDRMAsset)) && ((TextUtils.isEmpty(paramITPMediaAsset.getUrl())) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties() == null) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties().isEmpty())))
    {
      paramITPMediaAsset = new IllegalArgumentException("drm asset url is null or drm property is null");
      AppMethodBeat.o(189324);
      throw paramITPMediaAsset;
    }
    c localc = this.Sas;
    f.b localb = new f.b();
    localb.Sby = paramITPMediaAsset;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(189324);
  }
  
  public void setDataSource(String paramString)
  {
    AppMethodBeat.i(189321);
    this.RVN.info(Saq + "setDataSource, url:" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(189321);
      throw paramString;
    }
    c localc = this.Sas;
    f.b localb = new f.b();
    localb.url = paramString;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(189321);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(189322);
    this.RVN.info(Saq + "setDataSource, url:" + paramString + ", httpHeader:" + paramMap);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(189322);
      throw paramString;
    }
    c localc = this.Sas;
    f.b localb = new f.b();
    localb.url = paramString;
    localb.Sbw = paramMap;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(189322);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(189347);
    this.RVN.info(Saq + "setLoopback, isLoopback:" + paramBoolean);
    this.Sas.a(35, 0, 0, Boolean.valueOf(paramBoolean), true, true);
    AppMethodBeat.o(189347);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189348);
    this.RVN.info(Saq + "setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    c localc = this.Sas;
    f.c localc1 = new f.c();
    localc1.RVI = paramBoolean;
    localc1.Sbz = paramLong1;
    localc1.SbA = paramLong2;
    localc.a(20, 0, 0, localc1, true, true);
    AppMethodBeat.o(189348);
  }
  
  public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnAudioFrameOutputListener;
      if (paramIOnAudioFrameOutputListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbl = ((ITPPlayerListener.IOnAudioFrameOutputListener)localObject);
    }
  }
  
  public void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener paramIOnAudioProcessFrameOutputListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnAudioProcessFrameOutputListener;
      if (paramIOnAudioProcessFrameOutputListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbn = ((ITPPlayerListener.IOnAudioProcessFrameOutputListener)localObject);
    }
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnCompletionListener;
      if (paramIOnCompletionListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbd = ((ITPPlayerListener.IOnCompletionListener)localObject);
    }
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnErrorListener;
      if (paramIOnErrorListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbf = ((ITPPlayerListener.IOnErrorListener)localObject);
    }
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnInfoListener;
      if (paramIOnInfoListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbe = ((ITPPlayerListener.IOnInfoListener)localObject);
    }
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnStateChangeListener;
      if (paramIOnStateChangeListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbo = ((ITPPlayerListener.IOnStateChangeListener)localObject);
    }
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnPreparedListener;
      if (paramIOnPreparedListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbc = ((ITPPlayerListener.IOnPreparedListener)localObject);
    }
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnSeekCompleteListener;
      if (paramIOnSeekCompleteListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbg = ((ITPPlayerListener.IOnSeekCompleteListener)localObject);
    }
  }
  
  public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnStopAsyncCompleteListener;
      if (paramIOnStopAsyncCompleteListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbp = ((ITPPlayerListener.IOnStopAsyncCompleteListener)localObject);
    }
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnSubtitleDataListener;
      if (paramIOnSubtitleDataListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbi = ((ITPPlayerListener.IOnSubtitleDataListener)localObject);
    }
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnSubtitleFrameOutListener;
      if (paramIOnSubtitleFrameOutListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbj = ((ITPPlayerListener.IOnSubtitleFrameOutListener)localObject);
    }
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnVideoFrameOutListener;
      if (paramIOnVideoFrameOutListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbk = ((ITPPlayerListener.IOnVideoFrameOutListener)localObject);
    }
  }
  
  public void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener paramIOnVideoProcessFrameOutputListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnVideoProcessFrameOutputListener;
      if (paramIOnVideoProcessFrameOutputListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbm = ((ITPPlayerListener.IOnVideoProcessFrameOutputListener)localObject);
    }
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    if (this.Sat != null)
    {
      d locald = this.Sat;
      Object localObject = paramIOnVideoSizeChangedListener;
      if (paramIOnVideoSizeChangedListener == null) {
        localObject = locald.Sbq;
      }
      locald.Sbh = ((ITPPlayerListener.IOnVideoSizeChangedListener)localObject);
    }
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(189343);
    this.RVN.info(Saq + "setOutputMute, isOutputMute:" + paramBoolean);
    this.Sas.a(17, 0, 0, Boolean.valueOf(paramBoolean), false, true);
    AppMethodBeat.o(189343);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(189346);
    this.RVN.info(Saq + "setPlaySpeedRatio, speedRatio:" + paramFloat);
    this.Sas.a(19, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(189346);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(189315);
    this.Sas.a(1, 0, 0, paramTPOptionalParam, true, false);
    AppMethodBeat.o(189315);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(189318);
    this.RVN.info(Saq + "setSurface, surface:" + paramSurface);
    this.Sas.a(4, 0, 0, paramSurface, false, false);
    AppMethodBeat.o(189318);
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(189319);
    this.RVN.info(Saq + "setSurfaceHolder, SurfaceHolder:" + paramSurfaceHolder);
    this.Sas.a(39, 0, 0, paramSurfaceHolder, false, false);
    AppMethodBeat.o(189319);
  }
  
  public void setTPSurface(ITPSurface paramITPSurface)
  {
    AppMethodBeat.i(189320);
    this.RVN.info(Saq + "setTPSurface, tpSurface:" + paramITPSurface);
    this.Sas.a(44, 0, 0, paramITPSurface, false, false);
    AppMethodBeat.o(189320);
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(189325);
    this.Sas.a(29, 0, 0, paramTPVideoInfo, true, false);
    AppMethodBeat.o(189325);
  }
  
  public void start()
  {
    AppMethodBeat.i(189335);
    this.RVN.info(Saq + "start");
    this.Sas.a(11, 0, 0, null, false, false);
    AppMethodBeat.o(189335);
  }
  
  public void stop()
  {
    AppMethodBeat.i(189337);
    this.RVN.info(Saq + "stop");
    c localc = this.Sas;
    localc.hoh();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stop");
    localc.a(13, 0, 0, null, false, false);
    localc.hoj();
    localc.hoi();
    AppMethodBeat.o(189337);
  }
  
  public void stopAsync()
  {
    AppMethodBeat.i(189338);
    this.RVN.info(Saq + "stopAsync");
    c localc = this.Sas;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stopAsync");
    localc.a(37, 0, 0, null, false, false);
    AppMethodBeat.o(189338);
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(189350);
    this.RVN.info(Saq + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo);
    this.Sas.switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, 2);
    AppMethodBeat.o(189350);
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(189352);
    this.RVN.info(Saq + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo + ", mode:" + paramInt);
    this.Sas.switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, paramInt);
    AppMethodBeat.o(189352);
  }
  
  public void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(189349);
    this.RVN.info(Saq + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong);
    this.Sas.switchDefinition(paramString, paramLong, paramTPVideoInfo, 2);
    AppMethodBeat.o(189349);
  }
  
  public void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(189351);
    this.RVN.info(Saq + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong + ", mode:" + paramInt);
    this.Sas.switchDefinition(paramString, paramLong, paramTPVideoInfo, paramInt);
    AppMethodBeat.o(189351);
  }
  
  public final int t(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189384);
    if (this.Saw == null)
    {
      this.RVN.error("mAssetResourceLoader not set");
      AppMethodBeat.o(189384);
      return -1;
    }
    paramInt = this.Saw.k(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(189384);
    return paramInt;
  }
  
  public void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(189314);
    if (paramb != null)
    {
      this.SaH = false;
      this.RVN.a(new com.tencent.thumbplayer.f.b(paramb, "TPPlayer"));
      this.Sar.updateLoggerContext(this.RVN.RVM);
      if (this.Sat != null) {
        this.Sat.bqx(this.RVN.RVM.tag);
      }
    }
    AppMethodBeat.o(189314);
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private b SaI;
    
    a(b paramb)
    {
      this.SaI = paramb;
    }
    
    a(b paramb, Looper paramLooper)
    {
      super();
      this.SaI = paramb;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(189280);
      b.c(b.this).debug("mTransformHandler msg : " + paramMessage.what);
      d locald = b.e(b.this);
      if (locald == null)
      {
        AppMethodBeat.o(189280);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(189280);
        return;
        b.c(b.this).info("onPrepared");
        locald.onPrepared(this.SaI);
        AppMethodBeat.o(189280);
        return;
        locald.onCompletion(this.SaI);
        AppMethodBeat.o(189280);
        return;
        f.i locali = (f.i)paramMessage.obj;
        if ((locali != null) && (!b.a(b.this).hnu()))
        {
          locald.onInfo(this.SaI, paramMessage.arg1, locali.edr, locali.SbI, locali.SbJ);
          AppMethodBeat.o(189280);
          return;
        }
        if (locali != null)
        {
          locald.onInfo(this.SaI, paramMessage.arg1, locali.edr, locali.SbI, locali.SbJ);
          AppMethodBeat.o(189280);
          return;
          locali = (f.i)paramMessage.obj;
          if (locali != null)
          {
            locald.onError(this.SaI, paramMessage.arg1, paramMessage.arg2, locali.edr, locali.SbI);
            AppMethodBeat.o(189280);
            return;
            locald.onSeekComplete(this.SaI);
            AppMethodBeat.o(189280);
            return;
            paramMessage = (f.i)paramMessage.obj;
            if (paramMessage != null)
            {
              locald.onVideoSizeChanged(this.SaI, paramMessage.edr, paramMessage.SbI);
              AppMethodBeat.o(189280);
              return;
              locald.onSubtitleData(this.SaI, (TPSubtitleData)paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onSubtitleFrameOut(this.SaI, (TPSubtitleFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onVideoFrameOut(this.SaI, (TPVideoFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onAudioFrameOut(this.SaI, (TPAudioFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onError(this.SaI, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
              AppMethodBeat.o(189280);
              return;
              locald.onInfo(this.SaI, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onInfo(this.SaI, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onInfo(this.SaI, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onInfo(this.SaI, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onInfo(this.SaI, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onInfo(this.SaI, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onInfo(this.SaI, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onInfo(this.SaI, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              if (b.b(b.this) != null) {
                b.b(b.this).setPlayerOptionalParam(new TPOptionalParam().buildLong(8000, paramMessage.arg1));
              }
              locald.onInfo(this.SaI, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(189280);
              return;
              locald.onStateChange(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(189280);
              return;
              locald.onStopAsyncComplete(this.SaI);
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
      AppMethodBeat.i(189292);
      d locald = b.e(b.this);
      if (locald != null)
      {
        paramTPPostProcessFrameBuffer = locald.onVideoProcessFrameOut(b.this, paramTPPostProcessFrameBuffer);
        AppMethodBeat.o(189292);
        return paramTPPostProcessFrameBuffer;
      }
      AppMethodBeat.o(189292);
      return null;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189284);
      Object localObject = b.a(b.this).hnv();
      b.c(b.this).info("onError playerErrorCodeStr=".concat(String.valueOf(localObject)));
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
          b.c(b.this).r(localException);
          j = paramInt1;
          i = paramInt2;
        }
      }
      b.a(b.this, j, i);
      b.c(b.this).info("onError errorTypeReal=" + j + ", errorCodeReal=" + i);
      localObject = new f.i();
      ((f.i)localObject).edr = paramLong1;
      ((f.i)localObject).SbI = paramLong2;
      b.a(b.this, 262, j, i, localObject);
      AppMethodBeat.o(189284);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(189283);
      b.a(b.this, paramInt, paramLong1, paramLong2, paramObject);
      if (paramInt == 1011)
      {
        b.a(b.this, paramObject);
        AppMethodBeat.o(189283);
        return;
      }
      if (paramInt == 1012)
      {
        b.b(b.this, paramObject);
        AppMethodBeat.o(189283);
        return;
      }
      f.i locali = new f.i();
      locali.edr = paramLong1;
      locali.SbI = paramLong2;
      locali.SbJ = paramObject;
      b.a(b.this, 261, paramInt, 0, locali);
      AppMethodBeat.o(189283);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(189291);
      d locald = b.e(b.this);
      if (locald != null) {
        locald.onAudioFrameOut(b.this, paramTPAudioFrameBuffer);
      }
      AppMethodBeat.o(189291);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(189288);
      b.a(b.this, 265, 0, 0, paramTPSubtitleData);
      AppMethodBeat.o(189288);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(189289);
      b.a(b.this, 279, 0, 0, paramTPSubtitleFrameBuffer);
      AppMethodBeat.o(189289);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(189290);
      d locald = b.e(b.this);
      if (locald != null) {
        locald.onVideoFrameOut(b.this, paramTPVideoFrameBuffer);
      }
      AppMethodBeat.o(189290);
    }
    
    public final void aI(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189286);
      f.i locali = new f.i();
      locali.edr = paramLong1;
      locali.SbI = paramLong2;
      b.a(b.this, 264, 0, 0, locali);
      AppMethodBeat.o(189286);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(189293);
      d locald = b.e(b.this);
      if (locald != null)
      {
        paramTPPostProcessFrameBuffer = locald.onAudioProcessFrameOut(b.this, paramTPPostProcessFrameBuffer);
        AppMethodBeat.o(189293);
        return paramTPPostProcessFrameBuffer;
      }
      AppMethodBeat.o(189293);
      return null;
    }
    
    public final void cJH()
    {
      AppMethodBeat.i(189285);
      b.d(b.this);
      b.a(b.this, 110, new f().S("etime", Long.valueOf(System.currentTimeMillis())).S("petime", Long.valueOf(b.this.hnO())).map);
      b.a(b.this, 263, 0, 0, null);
      AppMethodBeat.o(189285);
    }
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(189306);
      long l = b.f(b.this).getAdvRemainTime();
      AppMethodBeat.o(189306);
      return l;
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(189312);
      paramString = b.f(b.this).getContentType(paramInt, paramString);
      AppMethodBeat.o(189312);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(189305);
      int i = b.f(b.this).getCurrentPlayClipNo();
      AppMethodBeat.o(189305);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(189304);
      long l = b.f(b.this).getCurrentPosition();
      AppMethodBeat.o(189304);
      return l;
    }
    
    public final String getDataFilePath(int paramInt, String paramString)
    {
      AppMethodBeat.i(189311);
      paramString = b.f(b.this).getDataFilePath(paramInt, paramString);
      AppMethodBeat.o(189311);
      return paramString;
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(189310);
      long l = b.f(b.this).getDataTotalSize(paramInt, paramString);
      AppMethodBeat.o(189310);
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
      AppMethodBeat.i(189303);
      long l = b.f(b.this).getPlayerBufferLength();
      AppMethodBeat.o(189303);
      return l;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(189282);
      b.a(b.this, 111, new f().S("etime", Long.valueOf(System.currentTimeMillis())).S("reason", Integer.valueOf(0)).map);
      b.a(b.this, 260, 0, 0, null);
      AppMethodBeat.o(189282);
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(189301);
      b.c(b.this).info("onDownloadCdnUrlExpired");
      b.f(b.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(189301);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(189298);
      b.c(b.this).info("onDownloadCdnUrlInfoUpdate, url:" + paramString1 + ", cdnIp:" + paramString2 + ", uip:" + paramString3 + ", errorCodeStr:" + paramString4);
      b.f(b.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(189298);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(189297);
      b.c(b.this).info("onDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
      b.f(b.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(189297);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(189296);
      b.c(b.this).info("onDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
      b.f(b.this).onDownloadError(4000, paramInt2, paramString);
      AppMethodBeat.o(189296);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(189295);
      b.c(b.this).info("onDownloadFinish");
      b.f(b.this).onDownloadFinish();
      AppMethodBeat.o(189295);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(189294);
      b.f(b.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
      AppMethodBeat.o(189294);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(189300);
      b.c(b.this).info("onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
      b.f(b.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(189300);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(189299);
      if (paramInt != b.g(b.this))
      {
        b.c(b.this).info("onDownloadStatusUpdate, status:".concat(String.valueOf(paramInt)));
        b.a(b.this, paramInt);
      }
      b.f(b.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(189299);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(189302);
      paramObject1 = b.f(b.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(189302);
      return paramObject1;
    }
    
    public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189308);
      paramInt = b.f(b.this).onReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(189308);
      return paramInt;
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(189307);
      paramInt = b.f(b.this).onStartReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(189307);
      return paramInt;
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(189287);
      b.a(b.this, 277, paramInt1, paramInt2, null);
      AppMethodBeat.o(189287);
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(189309);
      paramInt1 = b.f(b.this).onStopReadData(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(189309);
      return paramInt1;
    }
    
    public final void tf()
    {
      AppMethodBeat.i(189281);
      b.a(b.this).aro(0);
      Object localObject1 = b.b(b.this).hmK();
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
      localObject1 = new f().S("playertype", Integer.valueOf(b.b(b.this).getPlayerType())).S("definition", str).S("rate", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).RVl)).S("duration", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).durationMs)).S("fmt", ((com.tencent.thumbplayer.a.b)localObject1).RVh).S("etime", Long.valueOf(System.currentTimeMillis()));
      if (k > 1) {}
      for (boolean bool = true;; bool = false)
      {
        b.a((b)localObject2, 103, ((f)localObject1).S("multitrack", Boolean.valueOf(bool)).map);
        b.a(b.this, 257, 0, 0, null);
        AppMethodBeat.o(189281);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.g.b
 * JD-Core Version:    0.7.0.1
 */