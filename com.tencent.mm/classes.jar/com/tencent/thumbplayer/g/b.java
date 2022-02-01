package com.tencent.thumbplayer.g;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
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
import com.tencent.thumbplayer.api.TPCommonEnum.TPSurfaceType;
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
  private static String ahId;
  private static AtomicInteger ahIt;
  private com.tencent.thumbplayer.f.a ahDA;
  private com.tencent.thumbplayer.a.a ahIe;
  private c ahIf;
  private d ahIg;
  private com.tencent.thumbplayer.e.a ahIh;
  private com.tencent.thumbplayer.g.a.a.c ahIi;
  private com.tencent.thumbplayer.e.a.a ahIj;
  private com.tencent.thumbplayer.g.a.b ahIk;
  private Looper ahIl;
  private a ahIm;
  private boolean ahIn;
  private int ahIo;
  private ArrayList<String> ahIp;
  private long ahIq;
  private long ahIr;
  private long ahIs;
  private AtomicInteger ahIu;
  private boolean ahIv;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private String mUrl;
  
  static
  {
    AppMethodBeat.i(227383);
    ahId = "api call:";
    ahIt = new AtomicInteger(1000);
    AppMethodBeat.o(227383);
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
    AppMethodBeat.i(227237);
    this.mUrl = null;
    this.ahIn = true;
    this.ahIo = -1;
    this.ahIu = new AtomicInteger(1000);
    this.ahIv = false;
    b localb;
    if (paramb != null)
    {
      paramb = new com.tencent.thumbplayer.f.b(paramb, "TPPlayer");
      this.ahDA = new com.tencent.thumbplayer.f.a(paramb);
      this.ahDA.bGe("create TPPlayer");
      this.mContext = paramContext.getApplicationContext();
      this.ahIk = new com.tencent.thumbplayer.g.a.c();
      this.ahIi = new com.tencent.thumbplayer.g.a.a.c(this.mContext);
      a(100, 0, 0, null, new f().X("stime", Long.valueOf(System.currentTimeMillis())).map);
      localb = new b();
      this.ahIg = new d(this.ahDA.ahDz.tag);
      this.ahIe = new com.tencent.thumbplayer.a.d(this.mContext, paramb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.a(localb);
      this.ahIe.setOnPlayerStateChangeListener(localb);
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
      this.ahIl = paramb;
      if (paramLooper2 != null) {
        break label596;
      }
      if (Looper.myLooper() != null) {
        break label580;
      }
      this.ahIm = new a(this, this.ahIl);
    }
    for (;;)
    {
      this.ahIf = new c(paramb, this);
      a(101, 0, 0, null, new f().X("etime", Long.valueOf(System.currentTimeMillis())).map);
      this.ahIh = new com.tencent.thumbplayer.e.c(paramContext);
      this.ahIh.a(localb);
      this.ahIk.a(new com.tencent.thumbplayer.g.a.a.e()).a(new com.tencent.thumbplayer.g.a.a.b());
      this.ahIp = new ArrayList();
      AppMethodBeat.o(227237);
      return;
      paramb = new com.tencent.thumbplayer.f.b("ThumbPlayer", String.valueOf(ahIt.incrementAndGet()), String.valueOf(this.ahIu.incrementAndGet()), "TPPlayer");
      this.ahIv = true;
      break;
      label580:
      this.ahIm = new a(this);
      continue;
      label596:
      this.ahIm = new a(this, paramLooper2);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    AppMethodBeat.i(227267);
    try
    {
      if (this.ahIk != null) {
        this.ahIk.b(paramInt1, paramInt2, paramInt3, paramString, paramObject);
      }
      AppMethodBeat.o(227267);
      return;
    }
    catch (Exception paramString)
    {
      this.ahDA.p(paramString);
      AppMethodBeat.o(227267);
    }
  }
  
  private void f(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(227272);
    if (this.ahIm != null)
    {
      Message localMessage = this.ahIm.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.ahIm.sendMessage(localMessage);
    }
    AppMethodBeat.o(227272);
  }
  
  private void kbc()
  {
    AppMethodBeat.i(227244);
    try
    {
      this.ahIe.stop();
      a(107, 0, 0, null, new f().X("etime", Long.valueOf(System.currentTimeMillis())).X("reason", Integer.valueOf(1)).map);
      this.ahIh.aHO(5);
      this.ahIq = -1L;
      this.ahIr = -1L;
      this.ahIs = -1L;
      AppMethodBeat.o(227244);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.ahDA.p(localException);
      }
    }
  }
  
  private boolean kbd()
  {
    AppMethodBeat.i(227250);
    if ((this.ahIh.isEnable()) && (com.tencent.thumbplayer.d.a.kag()) && (this.ahIn))
    {
      AppMethodBeat.o(227250);
      return true;
    }
    AppMethodBeat.o(227250);
    return false;
  }
  
  private void kbe()
  {
    AppMethodBeat.i(227262);
    if (this.ahIe.isPlaying()) {}
    for (int i = 0;; i = 5)
    {
      this.ahIh.aHO(i);
      AppMethodBeat.o(227262);
      return;
    }
  }
  
  private void pO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227256);
    a(108, paramInt1, paramInt2, "", new f().X("etime", Long.valueOf(System.currentTimeMillis())).X("reason", Integer.valueOf(3)).X("code", paramInt1 + "." + paramInt2).map);
    this.ahIh.aHO(3);
    AppMethodBeat.o(227256);
  }
  
  public final int H(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(228079);
    if (this.ahIj == null)
    {
      this.ahDA.error("mAssetResourceLoader not set");
      AppMethodBeat.o(228079);
      return -1;
    }
    paramInt1 = this.ahIj.onStopReadData(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(228079);
    return paramInt1;
  }
  
  public final void OA(boolean paramBoolean)
  {
    AppMethodBeat.i(228137);
    try
    {
      this.ahIe.setOutputMute(paramBoolean);
      AppMethodBeat.o(228137);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228137);
    }
  }
  
  public final void OB(boolean paramBoolean)
  {
    AppMethodBeat.i(228163);
    try
    {
      this.ahIe.setLoopback(paramBoolean);
      AppMethodBeat.o(228163);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228163);
    }
  }
  
  public final int a(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228062);
    if (this.ahIj == null)
    {
      this.ahDA.error("mAssetResourceLoader not set");
      AppMethodBeat.o(228062);
      return -1;
    }
    paramInt = this.ahIj.onStartReadData(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(228062);
    return paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(228248);
    this.ahIq = paramInt1;
    this.ahIr = paramLong1;
    this.ahIs = paramLong2;
    TPPlayerMsg.TPDownLoadProgressInfo localTPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
    localTPDownLoadProgressInfo.playableDurationMS = paramInt1;
    localTPDownLoadProgressInfo.downloadSpeedKBps = paramInt2;
    localTPDownLoadProgressInfo.currentDownloadSize = paramLong1;
    localTPDownLoadProgressInfo.totalFileSize = paramLong2;
    localTPDownLoadProgressInfo.extraInfo = paramString;
    this.ahDA.bGe("handleOnDownloadProgressUpdate");
    a(200, 0, 0, null, new f().X("speed", Integer.valueOf(paramInt2)).X("spanId", paramString).map);
    f(274, 0, 0, localTPDownLoadProgressInfo);
    AppMethodBeat.o(228248);
  }
  
  public final void a(ITPSurface paramITPSurface)
  {
    AppMethodBeat.i(227950);
    try
    {
      if ((paramITPSurface instanceof e)) {
        this.ahIe.setSurface(((e)paramITPSurface).ahJf, 0);
      }
      AppMethodBeat.o(227950);
      return;
    }
    catch (Exception paramITPSurface)
    {
      this.ahDA.p(paramITPSurface);
      AppMethodBeat.o(227950);
    }
  }
  
  public final void a(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(228234);
    try
    {
      this.ahIe.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      AppMethodBeat.o(228234);
      return;
    }
    catch (Exception paramTPCaptureParams)
    {
      this.ahDA.p(paramTPCaptureParams);
      AppMethodBeat.o(228234);
    }
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(228243);
    paramITPMediaAsset = this.ahIh.a(paramITPMediaAsset, paramLong, paramTPVideoInfo);
    if (paramITPMediaAsset != null) {
      try
      {
        this.ahDA.bGe("handleSwitchDef, proxyMediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong);
        this.ahIe.a(paramTPVideoInfo);
        this.ahIe.a(paramITPMediaAsset, paramInt, paramLong);
        a(120, 0, 0, null, new f().X("switch", String.valueOf(paramLong)).map);
        AppMethodBeat.o(228243);
        return;
      }
      catch (Exception paramITPMediaAsset)
      {
        this.ahDA.p(paramITPMediaAsset);
      }
    }
    AppMethodBeat.o(228243);
  }
  
  public final void a(f.b paramb)
  {
    AppMethodBeat.i(227964);
    if (paramb != null)
    {
      try
      {
        if (TextUtils.isEmpty(paramb.url)) {
          break label203;
        }
        this.mUrl = paramb.url;
        com.tencent.thumbplayer.a.a.e locale = new com.tencent.thumbplayer.a.a.e(paramb.url);
        this.ahDA.bGe("handleSetDataSource originalUrl=" + paramb.url);
        if (kbd())
        {
          locale = this.ahIh.bGd(paramb.url);
          this.ahDA.bGe("handleSetDataSource selfPlayerUrl=" + locale.ahEf);
          this.ahDA.bGe("handleSetDataSource systemPlayerUrl=" + locale.ahEe);
        }
        if (paramb.ahJk != null)
        {
          this.ahIe.a(locale, paramb.ahJk);
          AppMethodBeat.o(227964);
          return;
        }
        this.ahIe.a(locale);
        AppMethodBeat.o(227964);
        return;
      }
      catch (Exception paramb)
      {
        this.ahDA.p(paramb);
      }
    }
    else
    {
      AppMethodBeat.o(227964);
      return;
    }
    label203:
    if (paramb.ahJm != null)
    {
      if (kbd()) {
        paramb.ahJm = this.ahIh.b(paramb.ahJm);
      }
      if (paramb.ahJm != null)
      {
        this.ahDA.bGe("handleSetDataSource mediaAsset=" + paramb.ahJm.getUrl());
        this.ahIe.setDataSource(paramb.ahJm);
      }
      AppMethodBeat.o(227964);
      return;
    }
    this.ahIe.setDataSource(paramb.ahJl);
    AppMethodBeat.o(227964);
  }
  
  public final void a(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(228239);
    com.tencent.thumbplayer.a.a.e locale = this.ahIh.a(paramLong, paramString, paramTPVideoInfo);
    try
    {
      this.ahDA.bGe("handleSwitchDef, proxyUrl:" + paramString + ", defID:" + paramLong);
      this.ahIe.a(paramTPVideoInfo);
      this.ahIe.a(locale, paramInt, paramLong);
      a(120, 0, 0, null, new f().X("switch", String.valueOf(paramLong)).map);
      AppMethodBeat.o(228239);
      return;
    }
    catch (Exception paramString)
    {
      this.ahDA.p(paramString);
      AppMethodBeat.o(228239);
    }
  }
  
  public final void a(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(227998);
    if (!kbd())
    {
      this.ahDA.error("handleAddAudioSource, proxy is not enable.");
      AppMethodBeat.o(227998);
      return;
    }
    if ((TextUtils.isEmpty(paramString2)) || (!com.tencent.thumbplayer.utils.b.bCj(paramString1)))
    {
      this.ahDA.error("handleAddAudioSource, illegal argument.");
      AppMethodBeat.o(227998);
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
      this.ahIe.j(paramString1, paramString2, localArrayList);
      AppMethodBeat.o(227998);
      return;
    }
    catch (Exception paramString1)
    {
      this.ahDA.p(paramString1);
      AppMethodBeat.o(227998);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(227985);
    try
    {
      long l = System.currentTimeMillis();
      if ((kbd()) && (com.tencent.thumbplayer.utils.b.bCj(paramString1)))
      {
        paramTPDownloadParamData = this.ahIh.a(3, paramString1, paramTPDownloadParamData);
        this.ahIp.add(paramTPDownloadParamData);
        this.ahIe.addSubtitleSource(paramTPDownloadParamData, paramString2, paramString3);
      }
      for (;;)
      {
        a(118, 0, 0, null, new f().X("stime", Long.valueOf(l)).X("etime", Long.valueOf(System.currentTimeMillis())).X("url", paramString1).map);
        AppMethodBeat.o(227985);
        return;
        this.ahIe.addSubtitleSource(paramString1, paramString2, paramString3);
      }
      return;
    }
    catch (Exception paramString1)
    {
      this.ahDA.p(paramString1);
      AppMethodBeat.o(227985);
    }
  }
  
  public final long aHX(int paramInt)
  {
    AppMethodBeat.i(228178);
    try
    {
      long l = this.ahIe.getPropertyLong(paramInt);
      AppMethodBeat.o(228178);
      return l;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228178);
    }
    return 0L;
  }
  
  public final String aHY(int paramInt)
  {
    AppMethodBeat.i(228186);
    try
    {
      String str = this.ahIe.getPropertyString(paramInt);
      AppMethodBeat.o(228186);
      return str;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228186);
    }
    return null;
  }
  
  public final void aHZ(int paramInt)
  {
    AppMethodBeat.i(228276);
    f(272, paramInt, 0, null);
    AppMethodBeat.o(228276);
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2)
  {
    AppMethodBeat.i(227642);
    this.ahDA.bGe(ahId + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2);
    this.ahIf.addAudioTrackSource(paramString1, paramString2, null);
    AppMethodBeat.o(227642);
  }
  
  public void addAudioTrackSource(String paramString1, String paramString2, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(227648);
    this.ahDA.bGe(ahId + "addAudioTrackSource, url:" + paramString1 + ", name:" + paramString2 + ", downloadParamData:" + paramTPDownloadParamData);
    this.ahIf.addAudioTrackSource(paramString1, paramString2, paramTPDownloadParamData);
    AppMethodBeat.o(227648);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(227630);
    this.ahDA.bGe(ahId + "addSubtitleSource, url:" + paramString1 + ", mimeType:" + paramString2 + ", name:" + paramString3);
    this.ahIf.addSubtitleSource(paramString1, paramString2, paramString3, null);
    AppMethodBeat.o(227630);
  }
  
  public void addSubtitleSource(String paramString1, String paramString2, String paramString3, TPDownloadParamData paramTPDownloadParamData)
  {
    AppMethodBeat.i(227636);
    this.ahDA.bGe(ahId + "addSubtitleSource, url:" + paramString1 + ", name:" + paramString3 + ", downloadParamData:" + paramTPDownloadParamData);
    this.ahIf.addSubtitleSource(paramString1, paramString2, paramString3, paramTPDownloadParamData);
    AppMethodBeat.o(227636);
  }
  
  public final void ae(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(228259);
    this.ahDA.bGe("handleOnDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
    pO(paramInt1, paramInt2);
    f(268, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(228259);
  }
  
  public final int b(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228071);
    if (this.ahIj == null)
    {
      this.ahDA.error("mAssetResourceLoader not set");
      AppMethodBeat.o(228071);
      return -1;
    }
    paramInt = this.ahIj.onReadData(paramInt, paramString, paramLong1, paramLong2);
    AppMethodBeat.o(228071);
    return paramInt;
  }
  
  public final void b(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt)
  {
    AppMethodBeat.i(227933);
    try
    {
      this.ahIe.setSurface(paramSurface, paramInt);
      AppMethodBeat.o(227933);
      return;
    }
    catch (Exception paramSurface)
    {
      this.ahDA.p(paramSurface);
      AppMethodBeat.o(227933);
    }
  }
  
  public final void b(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(227922);
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 206))
    {
      this.ahIn = paramTPOptionalParam.getParamBoolean().value;
      AppMethodBeat.o(227922);
      return;
    }
    this.ahIh.setPlayerOptionalParam(paramTPOptionalParam);
    try
    {
      this.ahIe.setPlayerOptionalParam(paramTPOptionalParam);
      AppMethodBeat.o(227922);
      return;
    }
    catch (Exception paramTPOptionalParam)
    {
      this.ahDA.p(paramTPOptionalParam);
      AppMethodBeat.o(227922);
    }
  }
  
  public final void b(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(227974);
    if (paramTPVideoInfo != null) {}
    try
    {
      this.ahIh.setVideoInfo(paramTPVideoInfo);
      this.ahIe.setVideoInfo(paramTPVideoInfo);
      AppMethodBeat.o(227974);
      return;
    }
    catch (Exception paramTPVideoInfo)
    {
      this.ahDA.p(paramTPVideoInfo);
      AppMethodBeat.o(227974);
    }
  }
  
  public final void bGg(String paramString)
  {
    AppMethodBeat.i(228146);
    try
    {
      this.ahIe.setAudioNormalizeVolumeParams(paramString);
      AppMethodBeat.o(228146);
      return;
    }
    catch (Exception paramString)
    {
      this.ahDA.p(paramString);
      AppMethodBeat.o(228146);
    }
  }
  
  public final void bGh(String paramString)
  {
    AppMethodBeat.i(228264);
    this.ahDA.bGe("handleOnDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
    f(269, 0, 0, paramString);
    AppMethodBeat.o(228264);
  }
  
  public final void bP(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228270);
    TPPlayerMsg.TPCDNURLInfo localTPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
    localTPCDNURLInfo.url = paramString1;
    localTPCDNURLInfo.cdnIp = paramString2;
    localTPCDNURLInfo.uIp = paramString3;
    a(201, 0, 0, null, new f().X("url", paramString1).X("cdnip", paramString2).X("cdnuip", paramString3).map);
    f(270, 0, 0, localTPCDNURLInfo);
    AppMethodBeat.o(228270);
  }
  
  public final void bs(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228009);
    try
    {
      TPTrackInfo[] arrayOfTPTrackInfo = this.ahIe.getTrackInfo();
      if ((arrayOfTPTrackInfo != null) && (arrayOfTPTrackInfo.length > paramInt)) {
        a(122, 0, 0, null, new f().X("opaque", Long.valueOf(paramLong)).X("tracktype", Integer.valueOf(arrayOfTPTrackInfo[paramInt].getTrackType())).X("stime", Long.valueOf(System.currentTimeMillis())).map);
      }
      this.ahIe.selectTrack(paramInt, paramLong);
      AppMethodBeat.o(228009);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228009);
    }
  }
  
  public final void bt(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228017);
    try
    {
      this.ahIe.deselectTrack(paramInt, paramLong);
      AppMethodBeat.o(228017);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228017);
    }
  }
  
  public final void bu(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228027);
    try
    {
      this.ahIe.selectProgram(paramInt, paramLong);
      AppMethodBeat.o(228027);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228027);
    }
  }
  
  public void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(227909);
    this.ahDA.bGe(ahId + "captureVideo, params:" + paramTPCaptureParams + ", captureCallBack:" + paramTPCaptureCallBack);
    c localc = this.ahIf;
    localc.kbi();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : captureVideo");
    f.l locall = new f.l();
    locall.ahJC = paramTPCaptureCallBack;
    locall.ahJB = paramTPCaptureParams;
    localc.a(30, 0, 0, locall, true, false);
    localc.kbk();
    localc.kbj();
    AppMethodBeat.o(227909);
  }
  
  public final void d(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228171);
    try
    {
      this.ahIe.setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(228171);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228171);
    }
  }
  
  public void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(227665);
    this.ahDA.bGe(ahId + "deselectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    this.ahIf.a(36, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(227665);
  }
  
  public final void dn(Map<String, String> paramMap)
  {
    AppMethodBeat.i(228286);
    this.ahDA.bGe("onDownloadCdnUrlExpired");
    f(275, 0, 0, paramMap);
    AppMethodBeat.o(228286);
  }
  
  public final void eE(float paramFloat)
  {
    AppMethodBeat.i(228141);
    try
    {
      this.ahIe.setAudioGainRatio(paramFloat);
      AppMethodBeat.o(228141);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228141);
    }
  }
  
  public final void eF(float paramFloat)
  {
    AppMethodBeat.i(228151);
    try
    {
      this.ahIe.setPlaySpeedRatio(paramFloat);
      a(116, 0, 0, null, new f().X("scene", Float.valueOf(paramFloat)).map);
      AppMethodBeat.o(228151);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.ahDA.p(localException);
      }
    }
  }
  
  public void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener, Looper paramLooper)
  {
    AppMethodBeat.i(227429);
    if (paramITPAssetResourceLoaderListener != null)
    {
      this.ahIh.Oy(true);
      if (this.ahIj != null)
      {
        this.ahIj.release();
        this.ahIj = null;
      }
      this.ahIj = new com.tencent.thumbplayer.e.a.b(this.mContext, paramLooper);
      this.ahIj.a(paramITPAssetResourceLoaderListener);
      this.ahIj.kay();
      AppMethodBeat.o(227429);
      return;
    }
    this.ahIh.Oy(false);
    AppMethodBeat.o(227429);
  }
  
  public void enableTPAssetResourceLoader(com.tencent.thumbplayer.e.a.a parama)
  {
    AppMethodBeat.i(227441);
    this.ahDA.bGe(ahId + "enableTPAssetResourceLoader, assetResourceLoader:" + parama);
    if (parama != null)
    {
      this.ahIh.Oy(true);
      if (this.ahIj != null)
      {
        this.ahIj.release();
        this.ahIj = null;
      }
      this.ahIj = parama;
      AppMethodBeat.o(227441);
      return;
    }
    this.ahIh.Oy(false);
    AppMethodBeat.o(227441);
  }
  
  public final long er(int paramInt, String paramString)
  {
    AppMethodBeat.i(228090);
    if (this.ahIj == null)
    {
      this.ahDA.error("mAssetResourceLoader not set");
      AppMethodBeat.o(228090);
      return -1L;
    }
    long l = this.ahIj.getDataTotalSize(paramInt, paramString);
    AppMethodBeat.o(228090);
    return l;
  }
  
  public final String es(int paramInt, String paramString)
  {
    AppMethodBeat.i(228097);
    if (this.ahIj == null)
    {
      this.ahDA.error("mAssetResourceLoader not set");
      AppMethodBeat.o(228097);
      return "";
    }
    paramString = this.ahIj.getDataFilePath(paramInt, paramString);
    AppMethodBeat.o(228097);
    return paramString;
  }
  
  public final String et(int paramInt, String paramString)
  {
    AppMethodBeat.i(228102);
    if (this.ahIj == null)
    {
      this.ahDA.error("mAssetResourceLoader not set");
      AppMethodBeat.o(228102);
      return "";
    }
    paramString = this.ahIj.getContentType(paramInt, paramString);
    AppMethodBeat.o(228102);
    return paramString;
  }
  
  public final void f(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(227940);
    try
    {
      this.ahIe.setSurfaceHolder(paramSurfaceHolder);
      AppMethodBeat.o(227940);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      this.ahDA.p(paramSurfaceHolder);
      AppMethodBeat.o(227940);
    }
  }
  
  public final Object g(int paramInt, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(228296);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(228296);
      return null;
      this.ahDA.bGe("onDownloadNoMoreData");
      f(276, 0, 0, paramObject1);
      continue;
      if (!(paramObject2 instanceof Integer)) {
        this.ahDA.bGe("MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3.");
      } else {
        f(278, ((Integer)paramObject2).intValue(), 0, null);
      }
    }
  }
  
  public int getBufferPercent()
  {
    AppMethodBeat.i(227822);
    int i = this.ahIf.getBufferPercent();
    AppMethodBeat.o(227822);
    return i;
  }
  
  public long getCurrentPositionMs()
  {
    AppMethodBeat.i(227811);
    long l = this.ahIf.getCurrentPositionMs();
    AppMethodBeat.o(227811);
    return l;
  }
  
  public int getCurrentState()
  {
    AppMethodBeat.i(227818);
    c localc = this.ahIf;
    localc.kbi();
    localc.ahIK = 1;
    localc.a(43, 0, 0, null, false, false);
    localc.kbk();
    localc.kbj();
    int i = localc.ahIK;
    AppMethodBeat.o(227818);
    return i;
  }
  
  public long getDurationMs()
  {
    AppMethodBeat.i(227807);
    long l = this.ahIf.getDurationMs();
    AppMethodBeat.o(227807);
    return l;
  }
  
  public long getPlayableDurationMs()
  {
    AppMethodBeat.i(227826);
    long l = this.ahIf.getPlayableDurationMs();
    AppMethodBeat.o(227826);
    return l;
  }
  
  public ITPPlayerProxy getPlayerProxy()
  {
    return this.ahIh;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(227898);
    this.ahDA.bGe(ahId + "getPlayerType");
    c localc = this.ahIf;
    localc.kbi();
    localc.ahIL = 0;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get player type");
    localc.a(40, 0, 0, null, false, false);
    localc.kbk();
    localc.kbj();
    int i = localc.ahIL;
    AppMethodBeat.o(227898);
    return i;
  }
  
  public TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(227681);
    this.ahDA.bGe(ahId + "getProgramInfo");
    Object localObject = this.ahIf;
    ((c)localObject).kbi();
    ((c)localObject).ahIA.ahJu = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get program info");
    ((c)localObject).a(33, 0, 0, null, false, false);
    ((c)localObject).kbk();
    ((c)localObject).kbj();
    localObject = ((c)localObject).ahIA.ahJu;
    AppMethodBeat.o(227681);
    return localObject;
  }
  
  public long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(227801);
    this.ahDA.bGe(ahId + "getPropertyLong, paramId:" + paramInt);
    c localc = this.ahIf;
    localc.kbi();
    localc.ahIB = 0L;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property long");
    localc.a(27, paramInt, 0, null, false, false);
    localc.kbk();
    localc.kbj();
    long l = localc.ahIB;
    AppMethodBeat.o(227801);
    return l;
  }
  
  public String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(227805);
    this.ahDA.bGe(ahId + "getPropertyString, paramId:" + paramInt);
    Object localObject = this.ahIf;
    ((c)localObject).kbi();
    ((c)localObject).ahIC = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get property string");
    ((c)localObject).a(28, paramInt, 0, null, false, false);
    ((c)localObject).kbk();
    ((c)localObject).kbj();
    localObject = ((c)localObject).ahIC;
    AppMethodBeat.o(227805);
    return localObject;
  }
  
  public ITPBusinessReportManager getReportManager()
  {
    return this.ahIi;
  }
  
  public TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(227848);
    this.ahDA.bGe(ahId + "getTrackInfo");
    Object localObject = this.ahIf;
    ((c)localObject).kbi();
    ((c)localObject).ahIz.ahJA = null;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : get trackInfo");
    ((c)localObject).a(23, 0, 0, null, false, false);
    ((c)localObject).kbk();
    ((c)localObject).kbj();
    localObject = ((c)localObject).ahIz.ahJA;
    AppMethodBeat.o(227848);
    return localObject;
  }
  
  public int getVideoHeight()
  {
    AppMethodBeat.i(227840);
    this.ahDA.bGe(ahId + "getVideoHeight");
    c localc = this.ahIf;
    localc.kbi();
    localc.a(22, 0, 0, null, false, false);
    localc.kbk();
    localc.kbj();
    int i = localc.ahIy.height;
    AppMethodBeat.o(227840);
    return i;
  }
  
  public int getVideoWidth()
  {
    AppMethodBeat.i(227833);
    this.ahDA.bGe(ahId + "getVideoWidth");
    c localc = this.ahIf;
    localc.kbi();
    localc.a(21, 0, 0, null, false, false);
    localc.kbk();
    localc.kbj();
    int i = localc.ahIy.width;
    AppMethodBeat.o(227833);
    return i;
  }
  
  public final void kaC()
  {
    AppMethodBeat.i(227867);
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 0L);
    try
    {
      this.ahIe.setPlayerOptionalParam(localTPOptionalParam);
      this.ahIh.pauseDownload();
      AppMethodBeat.o(227867);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.ahDA.p(localException);
      }
    }
  }
  
  public final void kaD()
  {
    AppMethodBeat.i(227886);
    this.ahIh.resumeDownload();
    TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(502, 1L);
    try
    {
      this.ahIe.setPlayerOptionalParam(localTPOptionalParam);
      AppMethodBeat.o(227886);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(227886);
    }
  }
  
  public final void kaE()
  {
    AppMethodBeat.i(228039);
    try
    {
      this.ahIe.prepareAsync();
      Object localObject = UUID.randomUUID().toString() + System.nanoTime() + "_" + com.tencent.thumbplayer.d.a.getPlatform();
      a(102, 0, 0, null, new f().X("stime", Long.valueOf(System.currentTimeMillis())).X("url", this.mUrl).X("p2p", Boolean.valueOf(kbd())).X("flowid", localObject).map);
      localObject = new f.i();
      if (kbd()) {}
      for (long l = 1L;; l = 0L)
      {
        ((f.i)localObject).idB = l;
        f(261, 1009, 0, localObject);
        AppMethodBeat.o(228039);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228039);
    }
  }
  
  public final void kaF()
  {
    AppMethodBeat.i(228046);
    try
    {
      this.ahIe.start();
      a(104, 0, 0, null, new f().X("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.ahIh.aHO(0);
      AppMethodBeat.o(228046);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228046);
    }
  }
  
  public final void kaG()
  {
    AppMethodBeat.i(228056);
    try
    {
      this.ahIe.pause();
      a(106, 0, 0, null, new f().X("stime", Long.valueOf(System.currentTimeMillis())).map);
      this.ahIh.aHO(5);
      AppMethodBeat.o(228056);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228056);
    }
  }
  
  public final void kaH()
  {
    AppMethodBeat.i(228106);
    kbc();
    AppMethodBeat.o(228106);
  }
  
  public final void kaI()
  {
    AppMethodBeat.i(228112);
    kbc();
    f(280, 0, 0, null);
    AppMethodBeat.o(228112);
  }
  
  public final void kaJ()
  {
    AppMethodBeat.i(228117);
    this.ahIe.reset();
    a(113, 0, 0, null, new f().X("etime", Long.valueOf(System.currentTimeMillis())).X("reason", Integer.valueOf(1)).map);
    this.ahIh.stopDownload();
    this.ahIo = -1;
    this.ahIp.clear();
    if (this.ahIj != null) {
      this.ahIj.reset();
    }
    this.ahIq = -1L;
    this.ahIr = -1L;
    this.ahIs = -1L;
    AppMethodBeat.o(228117);
  }
  
  public final void kaK()
  {
    AppMethodBeat.i(228123);
    this.ahIe.release();
    a(112, 0, 0, null, new f().X("etime", Long.valueOf(System.currentTimeMillis())).X("reason", Integer.valueOf(1)).map);
    if (this.ahIm != null)
    {
      this.ahIm.removeCallbacksAndMessages(null);
      this.ahIm = null;
    }
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      locald.ahIQ = locald.ahJe;
      locald.ahIR = locald.ahJe;
      locald.ahIS = locald.ahJe;
      locald.ahIT = locald.ahJe;
      locald.ahIU = locald.ahJe;
      locald.ahIV = locald.ahJe;
      locald.ahIW = locald.ahJe;
      locald.ahIY = locald.ahJe;
      locald.ahIZ = locald.ahJe;
      locald.ahJc = locald.ahJe;
      locald.ahJd = locald.ahJe;
      this.ahIg = null;
    }
    this.ahIh.release();
    this.ahIp.clear();
    if (this.ahIj != null)
    {
      this.ahIj.release();
      this.ahIj = null;
    }
    this.ahIq = -1L;
    this.ahIr = -1L;
    this.ahIs = -1L;
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    AppMethodBeat.o(228123);
  }
  
  public final void kaL()
  {
    AppMethodBeat.i(228159);
    try
    {
      this.ahIe.setPlaySharpenSwitch();
      AppMethodBeat.o(228159);
      return;
    }
    catch (Exception localException)
    {
      this.ahDA.p(localException);
      AppMethodBeat.o(228159);
    }
  }
  
  public final long kaM()
  {
    AppMethodBeat.i(228192);
    long l = this.ahIe.getDurationMs();
    AppMethodBeat.o(228192);
    return l;
  }
  
  public final long kaN()
  {
    AppMethodBeat.i(228198);
    long l = this.ahIe.getCurrentPositionMs();
    AppMethodBeat.o(228198);
    return l;
  }
  
  public final int kaO()
  {
    AppMethodBeat.i(228202);
    int i = this.ahIe.getCurrentState();
    AppMethodBeat.o(228202);
    return i;
  }
  
  public final int kaP()
  {
    AppMethodBeat.i(228207);
    if (this.ahIe.getDurationMs() == 0L)
    {
      AppMethodBeat.o(228207);
      return 0;
    }
    int i = (int)(100.0F * (float)(this.ahIe.getPlayableDurationMs() - this.ahIe.getCurrentPositionMs()) / (float)this.ahIe.getDurationMs());
    AppMethodBeat.o(228207);
    return i;
  }
  
  public final long kaQ()
  {
    AppMethodBeat.i(228211);
    if (kbd())
    {
      if ((this.ahIr > 0L) && (this.ahIs > 0L))
      {
        l = (this.ahIr * 1.0D / this.ahIs * this.ahIe.getDurationMs());
        AppMethodBeat.o(228211);
        return l;
      }
      l = this.ahIq;
      AppMethodBeat.o(228211);
      return l;
    }
    long l = this.ahIe.getPlayableDurationMs();
    AppMethodBeat.o(228211);
    return l;
  }
  
  public final int kaR()
  {
    AppMethodBeat.i(228216);
    int i = this.ahIe.getVideoWidth();
    AppMethodBeat.o(228216);
    return i;
  }
  
  public final int kaS()
  {
    AppMethodBeat.i(228220);
    int i = this.ahIe.getVideoHeight();
    AppMethodBeat.o(228220);
    return i;
  }
  
  public final int kaT()
  {
    AppMethodBeat.i(228224);
    int i = this.ahIe.getPlayerType();
    AppMethodBeat.o(228224);
    return i;
  }
  
  public final TPTrackInfo[] kaU()
  {
    AppMethodBeat.i(228227);
    TPTrackInfo[] arrayOfTPTrackInfo = this.ahIe.getTrackInfo();
    AppMethodBeat.o(228227);
    return arrayOfTPTrackInfo;
  }
  
  public final TPProgramInfo[] kaV()
  {
    AppMethodBeat.i(228232);
    TPProgramInfo[] arrayOfTPProgramInfo = this.ahIe.getProgramInfo();
    AppMethodBeat.o(228232);
    return arrayOfTPProgramInfo;
  }
  
  public final void kaW()
  {
    AppMethodBeat.i(228252);
    this.ahDA.bGe("onDownloadFinish");
    f(271, 0, 0, Integer.valueOf(0));
    AppMethodBeat.o(228252);
  }
  
  public final long kaX()
  {
    AppMethodBeat.i(228298);
    com.tencent.thumbplayer.a.a locala = this.ahIe;
    if (locala != null)
    {
      long l1 = locala.getPlayableDurationMs();
      long l2 = this.ahIe.getCurrentPositionMs();
      AppMethodBeat.o(228298);
      return l1 - l2;
    }
    AppMethodBeat.o(228298);
    return 0L;
  }
  
  public final int kaY()
  {
    AppMethodBeat.i(228304);
    com.tencent.thumbplayer.a.a locala = this.ahIe;
    if (locala != null)
    {
      int i = locala.getCurrentPlayClipNo();
      AppMethodBeat.o(228304);
      return i;
    }
    AppMethodBeat.o(228304);
    return 0;
  }
  
  public final long kaZ()
  {
    AppMethodBeat.i(228312);
    ITPPlayerProxyListener localITPPlayerProxyListener = this.ahIh.kat();
    if (localITPPlayerProxyListener != null)
    {
      long l = localITPPlayerProxyListener.getAdvRemainTimeMs();
      AppMethodBeat.o(228312);
      return l;
    }
    AppMethodBeat.o(228312);
    return -1L;
  }
  
  public final Object kba()
  {
    return null;
  }
  
  public final Object kbb()
  {
    return null;
  }
  
  public final void pN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228130);
    a(109, 0, 0, null, new f().X("stime", Long.valueOf(System.currentTimeMillis())).X("format", Integer.valueOf(0)).X("pstime", Long.valueOf(kaN())).map);
    if (paramInt2 > 0) {}
    try
    {
      this.ahIe.seekTo(paramInt1, paramInt2);
      for (;;)
      {
        this.ahIh.aHO(1);
        AppMethodBeat.o(228130);
        return;
        this.ahIe.seekTo(paramInt1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.ahDA.p(localException);
      }
    }
  }
  
  public void pause()
  {
    AppMethodBeat.i(227704);
    this.ahDA.bGe(ahId + "pause");
    this.ahIf.a(12, 0, 0, null, false, false);
    AppMethodBeat.o(227704);
  }
  
  public void pauseDownload()
  {
    AppMethodBeat.i(227857);
    this.ahDA.bGe(ahId + "pauseDownload");
    this.ahIf.a(41, 0, 0, null, false, false);
    AppMethodBeat.o(227857);
  }
  
  public void prepareAsync()
  {
    AppMethodBeat.i(227687);
    this.ahDA.bGe(ahId + "prepareAsync");
    this.ahIf.a(10, 0, 0, null, false, false);
    AppMethodBeat.o(227687);
  }
  
  public final void qI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(228280);
    this.ahDA.bGe("onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
    TPPlayerMsg.TPProtocolInfo localTPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
    localTPProtocolInfo.protocolVersion = paramString2;
    localTPProtocolInfo.protocolName = paramString1;
    f(273, 0, 0, localTPProtocolInfo);
    AppMethodBeat.o(228280);
  }
  
  public void release()
  {
    AppMethodBeat.i(227722);
    this.ahDA.bGe(ahId + "release");
    c localc = this.ahIf;
    localc.kbi();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : release");
    localc.a(15, 0, 0, null, false, false);
    localc.kbk();
    localc.kbj();
    this.ahIk.release();
    AppMethodBeat.o(227722);
  }
  
  public void reset()
  {
    AppMethodBeat.i(227717);
    this.ahDA.bGe(ahId + "reset");
    if (this.ahIv)
    {
      localObject = this.ahDA;
      int i = this.ahIu.incrementAndGet();
      localObject = ((com.tencent.thumbplayer.f.a)localObject).ahDz;
      ((com.tencent.thumbplayer.f.b)localObject).taskId = String.valueOf(i);
      ((com.tencent.thumbplayer.f.b)localObject).kaB();
      this.ahIe.updateLoggerContext(this.ahDA.ahDz);
      if (this.ahIg != null) {
        this.ahIg.ayz(this.ahDA.ahDz.tag);
      }
    }
    Object localObject = this.ahIf;
    ((c)localObject).kbi();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : reset");
    ((c)localObject).a(14, 0, 0, null, false, false);
    ((c)localObject).kbk();
    ((c)localObject).kbj();
    AppMethodBeat.o(227717);
  }
  
  public void resumeDownload()
  {
    AppMethodBeat.i(227876);
    this.ahDA.bGe(ahId + "resumeDownload");
    this.ahIf.a(42, 0, 0, null, false, false);
    AppMethodBeat.o(227876);
  }
  
  public void seekTo(int paramInt)
  {
    AppMethodBeat.i(227728);
    this.ahDA.bGe(ahId + "seekTo, positionMs:" + paramInt);
    this.ahIf.a(16, paramInt, 0, null, false, false);
    AppMethodBeat.o(227728);
  }
  
  public void seekTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227732);
    this.ahDA.bGe(ahId + "seekTo, positionMs:" + paramInt1 + ", mode:" + paramInt2);
    this.ahIf.a(16, paramInt1, paramInt2, null, false, false);
    AppMethodBeat.o(227732);
  }
  
  public void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(227672);
    this.ahDA.bGe(ahId + "selectProgram, programIndex:" + paramInt + ", opaque:" + paramLong);
    this.ahIf.a(32, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(227672);
  }
  
  public void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(227655);
    this.ahDA.bGe(ahId + "selectTrack, trackIndex:" + paramInt + ", opaque:" + paramLong);
    this.ahIf.a(8, paramInt, (int)paramLong, null, false, false);
    AppMethodBeat.o(227655);
  }
  
  public void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(227740);
    this.ahDA.bGe(ahId + "setAudioGainRatio, gainRatio:" + paramFloat);
    this.ahIf.a(18, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(227740);
  }
  
  public void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(227749);
    this.ahDA.bGe(ahId + "setAudioNormalizeVolumeParams, audioNormalizeVolumeParams:" + paramString);
    this.ahIf.a(38, 0, 0, paramString, false, true);
    AppMethodBeat.o(227749);
  }
  
  public void setDataSource(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(227607);
    if (paramAssetFileDescriptor == null)
    {
      paramAssetFileDescriptor = new IllegalArgumentException("error : setDataSource , param is null");
      AppMethodBeat.o(227607);
      throw paramAssetFileDescriptor;
    }
    this.ahDA.bGe(ahId + "setDataSource, AssetFileDescriptor");
    try
    {
      this.ahIe.setDataSource(paramAssetFileDescriptor);
      AppMethodBeat.o(227607);
      return;
    }
    catch (Exception paramAssetFileDescriptor)
    {
      this.ahDA.p(paramAssetFileDescriptor);
      AppMethodBeat.o(227607);
    }
  }
  
  public void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(227598);
    this.ahDA.bGe(ahId + "setDataSource, ParcelFileDescriptor");
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(227598);
      throw paramParcelFileDescriptor;
    }
    c localc = this.ahIf;
    f.b localb = new f.b();
    localb.ahJl = ParcelFileDescriptor.fromFd(paramParcelFileDescriptor.detachFd());
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(227598);
  }
  
  public void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(227614);
    this.ahDA.bGe(ahId + "setDataSource, ITPMediaAsset");
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalArgumentException("asset is null");
      AppMethodBeat.o(227614);
      throw paramITPMediaAsset;
    }
    if (((paramITPMediaAsset instanceof ITPMediaDRMAsset)) && ((TextUtils.isEmpty(paramITPMediaAsset.getUrl())) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties() == null) || (((ITPMediaDRMAsset)paramITPMediaAsset).getDrmAllProperties().isEmpty())))
    {
      paramITPMediaAsset = new IllegalArgumentException("drm asset url is null or drm property is null");
      AppMethodBeat.o(227614);
      throw paramITPMediaAsset;
    }
    c localc = this.ahIf;
    f.b localb = new f.b();
    localb.ahJm = paramITPMediaAsset;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(227614);
  }
  
  public void setDataSource(String paramString)
  {
    AppMethodBeat.i(227579);
    this.ahDA.bGe(ahId + "setDataSource, url:" + paramString);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(227579);
      throw paramString;
    }
    c localc = this.ahIf;
    f.b localb = new f.b();
    localb.url = paramString;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(227579);
  }
  
  public void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(227590);
    this.ahDA.bGe(ahId + "setDataSource, url:" + paramString + ", httpHeader:" + paramMap);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(227590);
      throw paramString;
    }
    c localc = this.ahIf;
    f.b localb = new f.b();
    localb.url = paramString;
    localb.ahJk = paramMap;
    localc.a(5, 0, 0, localb, true, false);
    AppMethodBeat.o(227590);
  }
  
  public void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(227766);
    this.ahDA.bGe(ahId + "setLoopback, isLoopback:" + paramBoolean);
    this.ahIf.a(35, 0, 0, Boolean.valueOf(paramBoolean), true, true);
    AppMethodBeat.o(227766);
  }
  
  public void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227772);
    this.ahDA.bGe(ahId + "setLoopback, isLoopback:" + paramBoolean + ", loopStartPositionMs:" + paramLong1 + ", loopEndPositionMs:" + paramLong2);
    c localc = this.ahIf;
    f.c localc1 = new f.c();
    localc1.ahDv = paramBoolean;
    localc1.ahJn = paramLong1;
    localc1.ahJo = paramLong2;
    localc.a(20, 0, 0, localc1, true, true);
    AppMethodBeat.o(227772);
  }
  
  public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener paramIOnAudioFrameOutputListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnAudioFrameOutputListener;
      if (paramIOnAudioFrameOutputListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIZ = ((ITPPlayerListener.IOnAudioFrameOutputListener)localObject);
    }
  }
  
  public void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener paramIOnAudioProcessFrameOutputListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnAudioProcessFrameOutputListener;
      if (paramIOnAudioProcessFrameOutputListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahJb = ((ITPPlayerListener.IOnAudioProcessFrameOutputListener)localObject);
    }
  }
  
  public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnCompletionListener;
      if (paramIOnCompletionListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIR = ((ITPPlayerListener.IOnCompletionListener)localObject);
    }
  }
  
  public void setOnErrorListener(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnErrorListener;
      if (paramIOnErrorListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIT = ((ITPPlayerListener.IOnErrorListener)localObject);
    }
  }
  
  public void setOnInfoListener(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnInfoListener;
      if (paramIOnInfoListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIS = ((ITPPlayerListener.IOnInfoListener)localObject);
    }
  }
  
  public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener paramIOnStateChangeListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnStateChangeListener;
      if (paramIOnStateChangeListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahJc = ((ITPPlayerListener.IOnStateChangeListener)localObject);
    }
  }
  
  public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnPreparedListener;
      if (paramIOnPreparedListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIQ = ((ITPPlayerListener.IOnPreparedListener)localObject);
    }
  }
  
  public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnSeekCompleteListener;
      if (paramIOnSeekCompleteListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIU = ((ITPPlayerListener.IOnSeekCompleteListener)localObject);
    }
  }
  
  public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnStopAsyncCompleteListener;
      if (paramIOnStopAsyncCompleteListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahJd = ((ITPPlayerListener.IOnStopAsyncCompleteListener)localObject);
    }
  }
  
  public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener paramIOnSubtitleDataListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnSubtitleDataListener;
      if (paramIOnSubtitleDataListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIW = ((ITPPlayerListener.IOnSubtitleDataListener)localObject);
    }
  }
  
  public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener paramIOnSubtitleFrameOutListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnSubtitleFrameOutListener;
      if (paramIOnSubtitleFrameOutListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIX = ((ITPPlayerListener.IOnSubtitleFrameOutListener)localObject);
    }
  }
  
  public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener paramIOnVideoFrameOutListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnVideoFrameOutListener;
      if (paramIOnVideoFrameOutListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIY = ((ITPPlayerListener.IOnVideoFrameOutListener)localObject);
    }
  }
  
  public void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener paramIOnVideoProcessFrameOutputListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnVideoProcessFrameOutputListener;
      if (paramIOnVideoProcessFrameOutputListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahJa = ((ITPPlayerListener.IOnVideoProcessFrameOutputListener)localObject);
    }
  }
  
  public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener paramIOnVideoSizeChangedListener)
  {
    if (this.ahIg != null)
    {
      d locald = this.ahIg;
      Object localObject = paramIOnVideoSizeChangedListener;
      if (paramIOnVideoSizeChangedListener == null) {
        localObject = locald.ahJe;
      }
      locald.ahIV = ((ITPPlayerListener.IOnVideoSizeChangedListener)localObject);
    }
  }
  
  public void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(227736);
    this.ahDA.bGe(ahId + "setOutputMute, isOutputMute:" + paramBoolean);
    this.ahIf.a(17, 0, 0, Boolean.valueOf(paramBoolean), false, true);
    AppMethodBeat.o(227736);
  }
  
  public void setPlaySharpenSwitch()
  {
    AppMethodBeat.i(227759);
    this.ahDA.bGe(ahId + "setPlaySharpenSwitch");
    this.ahIf.a(200, 0, 0, Integer.valueOf(0), false, true);
    AppMethodBeat.o(227759);
  }
  
  public void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(227755);
    this.ahDA.bGe(ahId + "setPlaySpeedRatio, speedRatio:" + paramFloat);
    this.ahIf.a(19, 0, 0, Float.valueOf(paramFloat), false, true);
    AppMethodBeat.o(227755);
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(227403);
    this.ahIf.a(1, 0, 0, paramTPOptionalParam, true, false);
    AppMethodBeat.o(227403);
  }
  
  public void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(227542);
    this.ahDA.bGe(ahId + "setSurface, surface:" + paramSurface);
    this.ahIf.setSurface(paramSurface, 0);
    AppMethodBeat.o(227542);
  }
  
  public void setSurface(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt)
  {
    AppMethodBeat.i(227555);
    this.ahDA.bGe(ahId + "setSurface, surface:" + paramSurface + ", type:" + paramInt);
    this.ahIf.setSurface(paramSurface, paramInt);
    AppMethodBeat.o(227555);
  }
  
  public void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(227563);
    this.ahDA.bGe(ahId + "setSurfaceHolder, SurfaceHolder:" + paramSurfaceHolder);
    this.ahIf.a(39, 0, 0, paramSurfaceHolder, false, false);
    AppMethodBeat.o(227563);
  }
  
  public void setTPSurface(ITPSurface paramITPSurface)
  {
    AppMethodBeat.i(227572);
    this.ahDA.bGe(ahId + "setTPSurface, tpSurface:" + paramITPSurface);
    this.ahIf.a(44, 0, 0, paramITPSurface, false, false);
    AppMethodBeat.o(227572);
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(227623);
    this.ahIf.a(29, 0, 0, paramTPVideoInfo, true, false);
    AppMethodBeat.o(227623);
  }
  
  public void start()
  {
    AppMethodBeat.i(227695);
    this.ahDA.bGe(ahId + "start");
    this.ahIf.a(11, 0, 0, null, false, false);
    AppMethodBeat.o(227695);
  }
  
  public void stop()
  {
    AppMethodBeat.i(227709);
    this.ahDA.bGe(ahId + "stop");
    c localc = this.ahIf;
    localc.kbi();
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stop");
    localc.a(13, 0, 0, null, false, false);
    localc.kbk();
    localc.kbj();
    AppMethodBeat.o(227709);
  }
  
  public void stopAsync()
  {
    AppMethodBeat.i(227713);
    this.ahDA.bGe(ahId + "stopAsync");
    c localc = this.ahIf;
    g.i("TPThumbPlayer[TPPlayerInternal.java]", "api call : stopAsync");
    localc.a(37, 0, 0, null, false, false);
    AppMethodBeat.o(227713);
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(227786);
    this.ahDA.bGe(ahId + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo);
    this.ahIf.switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, 2);
    AppMethodBeat.o(227786);
  }
  
  public void switchDefinition(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(227796);
    this.ahDA.bGe(ahId + "switchDefinition, mediaAsset:" + paramITPMediaAsset + ", defID:" + paramLong + ", videoInfo:" + paramTPVideoInfo + ", mode:" + paramInt);
    this.ahIf.switchDefinition(paramITPMediaAsset, paramLong, paramTPVideoInfo, paramInt);
    AppMethodBeat.o(227796);
  }
  
  public void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(227778);
    this.ahDA.bGe(ahId + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong);
    this.ahIf.switchDefinition(paramString, paramLong, paramTPVideoInfo, 2);
    AppMethodBeat.o(227778);
  }
  
  public void switchDefinition(String paramString, long paramLong, TPVideoInfo paramTPVideoInfo, int paramInt)
  {
    AppMethodBeat.i(227791);
    this.ahDA.bGe(ahId + "switchDefinition, defUrl:" + paramString + ", defID:" + paramLong + ", mode:" + paramInt);
    this.ahIf.switchDefinition(paramString, paramLong, paramTPVideoInfo, paramInt);
    AppMethodBeat.o(227791);
  }
  
  public void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(227394);
    if (paramb != null)
    {
      this.ahIv = false;
      this.ahDA.a(new com.tencent.thumbplayer.f.b(paramb, "TPPlayer"));
      this.ahIe.updateLoggerContext(this.ahDA.ahDz);
      if (this.ahIg != null) {
        this.ahIg.ayz(this.ahDA.ahDz.tag);
      }
    }
    AppMethodBeat.o(227394);
  }
  
  final class a
    extends Handler
  {
    private b ahIw;
    
    a(b paramb)
    {
      this.ahIw = paramb;
    }
    
    a(b paramb, Looper paramLooper)
    {
      super();
      this.ahIw = paramb;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(227157);
      b.c(b.this).debug("mTransformHandler msg : " + paramMessage.what);
      d locald = b.e(b.this);
      if (locald == null)
      {
        AppMethodBeat.o(227157);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(227157);
        return;
        b.c(b.this).bGe("onPrepared");
        locald.onPrepared(this.ahIw);
        AppMethodBeat.o(227157);
        return;
        locald.onCompletion(this.ahIw);
        AppMethodBeat.o(227157);
        return;
        f.i locali = (f.i)paramMessage.obj;
        if ((locali != null) && (!b.a(b.this).kar()))
        {
          locald.onInfo(this.ahIw, paramMessage.arg1, locali.idB, locali.ahJw, locali.ahJx);
          AppMethodBeat.o(227157);
          return;
        }
        if (locali != null)
        {
          locald.onInfo(this.ahIw, paramMessage.arg1, locali.idB, locali.ahJw, locali.ahJx);
          AppMethodBeat.o(227157);
          return;
          locali = (f.i)paramMessage.obj;
          if (locali != null)
          {
            locald.onError(this.ahIw, paramMessage.arg1, paramMessage.arg2, locali.idB, locali.ahJw);
            AppMethodBeat.o(227157);
            return;
            locald.onSeekComplete(this.ahIw);
            AppMethodBeat.o(227157);
            return;
            paramMessage = (f.i)paramMessage.obj;
            if (paramMessage != null)
            {
              locald.onVideoSizeChanged(this.ahIw, paramMessage.idB, paramMessage.ahJw);
              AppMethodBeat.o(227157);
              return;
              locald.onSubtitleData(this.ahIw, (TPSubtitleData)paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onSubtitleFrameOut(this.ahIw, (TPSubtitleFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onVideoFrameOut(this.ahIw, (TPVideoFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onAudioFrameOut(this.ahIw, (TPAudioFrameBuffer)paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onError(this.ahIw, paramMessage.arg1, paramMessage.arg2, 0L, 0L);
              AppMethodBeat.o(227157);
              return;
              locald.onInfo(this.ahIw, 1002, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onInfo(this.ahIw, 1003, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onInfo(this.ahIw, 1001, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onInfo(this.ahIw, 1004, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onInfo(this.ahIw, 1005, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onInfo(this.ahIw, 1006, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onInfo(this.ahIw, 1007, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onInfo(this.ahIw, 1008, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              if (b.b(b.this) != null) {
                b.b(b.this).setPlayerOptionalParam(new TPOptionalParam().buildLong(8000, paramMessage.arg1));
              }
              locald.onInfo(this.ahIw, 1010, paramMessage.arg1, paramMessage.arg2, paramMessage.obj);
              AppMethodBeat.o(227157);
              return;
              locald.onStateChange(paramMessage.arg1, paramMessage.arg2);
              AppMethodBeat.o(227157);
              return;
              locald.onStopAsyncComplete(this.ahIw);
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
    
    public final void Qz()
    {
      AppMethodBeat.i(227151);
      b.a(b.this).aHO(0);
      Object localObject1 = b.b(b.this).jZG();
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
      localObject1 = new f().X("playertype", Integer.valueOf(b.b(b.this).getPlayerType())).X("definition", str).X("rate", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).Gpr)).X("duration", Long.valueOf(((com.tencent.thumbplayer.a.b)localObject1).durationMs)).X("fmt", ((com.tencent.thumbplayer.a.b)localObject1).ahCV).X("etime", Long.valueOf(System.currentTimeMillis()));
      if (k > 1) {}
      for (boolean bool = true;; bool = false)
      {
        b.a((b)localObject2, 103, ((f)localObject1).X("multitrack", Boolean.valueOf(bool)).map);
        b.a(b.this, 257, 0, 0, null);
        AppMethodBeat.o(227151);
        return;
      }
    }
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(227228);
      d locald = b.e(b.this);
      if (locald != null)
      {
        paramTPPostProcessFrameBuffer = locald.onVideoProcessFrameOut(b.this, paramTPPostProcessFrameBuffer);
        AppMethodBeat.o(227228);
        return paramTPPostProcessFrameBuffer;
      }
      AppMethodBeat.o(227228);
      return null;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227181);
      Object localObject = b.a(b.this).kas();
      b.c(b.this).bGe("onError playerErrorCodeStr=".concat(String.valueOf(localObject)));
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
          b.c(b.this).p(localException);
          j = paramInt1;
          i = paramInt2;
        }
      }
      b.a(b.this, j, i);
      b.c(b.this).bGe("onError errorTypeReal=" + j + ", errorCodeReal=" + i);
      localObject = new f.i();
      ((f.i)localObject).idB = paramLong1;
      ((f.i)localObject).ahJw = paramLong2;
      b.a(b.this, 262, j, i, localObject);
      AppMethodBeat.o(227181);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(227171);
      b.a(b.this, paramInt, paramLong1, paramLong2, paramObject);
      if (paramInt == 1011)
      {
        b.a(b.this, paramObject);
        AppMethodBeat.o(227171);
        return;
      }
      if (paramInt == 1012)
      {
        b.b(b.this, paramObject);
        AppMethodBeat.o(227171);
        return;
      }
      f.i locali = new f.i();
      locali.idB = paramLong1;
      locali.ahJw = paramLong2;
      locali.ahJx = paramObject;
      b.a(b.this, 261, paramInt, 0, locali);
      AppMethodBeat.o(227171);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(227223);
      d locald = b.e(b.this);
      if (locald != null) {
        locald.onAudioFrameOut(b.this, paramTPAudioFrameBuffer);
      }
      AppMethodBeat.o(227223);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(227205);
      b.a(b.this, 265, 0, 0, paramTPSubtitleData);
      AppMethodBeat.o(227205);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(227208);
      b.a(b.this, 279, 0, 0, paramTPSubtitleFrameBuffer);
      AppMethodBeat.o(227208);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(227216);
      d locald = b.e(b.this);
      if (locald != null) {
        locald.onVideoFrameOut(b.this, paramTPVideoFrameBuffer);
      }
      AppMethodBeat.o(227216);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(227235);
      d locald = b.e(b.this);
      if (locald != null)
      {
        paramTPPostProcessFrameBuffer = locald.onAudioProcessFrameOut(b.this, paramTPPostProcessFrameBuffer);
        AppMethodBeat.o(227235);
        return paramTPPostProcessFrameBuffer;
      }
      AppMethodBeat.o(227235);
      return null;
    }
    
    public final void bN(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227194);
      f.i locali = new f.i();
      locali.idB = paramLong1;
      locali.ahJw = paramLong2;
      b.a(b.this, 264, 0, 0, locali);
      AppMethodBeat.o(227194);
    }
    
    public final void dEH()
    {
      AppMethodBeat.i(227189);
      b.d(b.this);
      b.a(b.this, 110, new f().X("etime", Long.valueOf(System.currentTimeMillis())).X("petime", Long.valueOf(b.this.kaN())).map);
      b.a(b.this, 263, 0, 0, null);
      AppMethodBeat.o(227189);
    }
    
    public final long getAdvRemainTime()
    {
      AppMethodBeat.i(227310);
      long l = b.f(b.this).getAdvRemainTime();
      AppMethodBeat.o(227310);
      return l;
    }
    
    public final String getContentType(int paramInt, String paramString)
    {
      AppMethodBeat.i(227369);
      paramString = b.f(b.this).getContentType(paramInt, paramString);
      AppMethodBeat.o(227369);
      return paramString;
    }
    
    public final int getCurrentPlayClipNo()
    {
      AppMethodBeat.i(227306);
      int i = b.f(b.this).getCurrentPlayClipNo();
      AppMethodBeat.o(227306);
      return i;
    }
    
    public final long getCurrentPosition()
    {
      AppMethodBeat.i(227298);
      long l = b.f(b.this).getCurrentPosition();
      AppMethodBeat.o(227298);
      return l;
    }
    
    public final String getDataFilePath(int paramInt, String paramString)
    {
      AppMethodBeat.i(227360);
      paramString = b.f(b.this).getDataFilePath(paramInt, paramString);
      AppMethodBeat.o(227360);
      return paramString;
    }
    
    public final long getDataTotalSize(int paramInt, String paramString)
    {
      AppMethodBeat.i(227351);
      long l = b.f(b.this).getDataTotalSize(paramInt, paramString);
      AppMethodBeat.o(227351);
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
      AppMethodBeat.i(227292);
      long l = b.f(b.this).getPlayerBufferLength();
      AppMethodBeat.o(227292);
      return l;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(227159);
      b.a(b.this, 111, new f().X("etime", Long.valueOf(System.currentTimeMillis())).X("reason", Integer.valueOf(0)).map);
      b.a(b.this, 260, 0, 0, null);
      AppMethodBeat.o(227159);
    }
    
    public final void onDownloadCdnUrlExpired(Map<String, String> paramMap)
    {
      AppMethodBeat.i(227278);
      b.c(b.this).bGe("onDownloadCdnUrlExpired");
      b.f(b.this).onDownloadCdnUrlExpired(paramMap);
      AppMethodBeat.o(227278);
    }
    
    public final void onDownloadCdnUrlInfoUpdate(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      AppMethodBeat.i(227263);
      b.c(b.this).bGe("onDownloadCdnUrlInfoUpdate, url:" + paramString1 + ", cdnIp:" + paramString2 + ", uip:" + paramString3 + ", errorCodeStr:" + paramString4);
      b.f(b.this).onDownloadCdnUrlInfoUpdate(paramString1, paramString2, paramString3, paramString4);
      AppMethodBeat.o(227263);
    }
    
    public final void onDownloadCdnUrlUpdate(String paramString)
    {
      AppMethodBeat.i(227259);
      b.c(b.this).bGe("onDownloadCdnUrlUpdate, url:".concat(String.valueOf(paramString)));
      b.f(b.this).onDownloadCdnUrlUpdate(paramString);
      AppMethodBeat.o(227259);
    }
    
    public final void onDownloadError(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(227252);
      b.c(b.this).bGe("onDownloadError, moduleID:" + paramInt1 + ", errorCode:" + paramInt2 + ", extInfo:" + paramString);
      b.f(b.this).onDownloadError(4000, paramInt2, paramString);
      AppMethodBeat.o(227252);
    }
    
    public final void onDownloadFinish()
    {
      AppMethodBeat.i(227247);
      b.c(b.this).bGe("onDownloadFinish");
      b.f(b.this).onDownloadFinish();
      AppMethodBeat.o(227247);
    }
    
    public final void onDownloadProgressUpdate(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString)
    {
      AppMethodBeat.i(227239);
      b.f(b.this).onDownloadProgressUpdate(paramInt1, paramInt2, paramLong1, paramLong2, paramString);
      AppMethodBeat.o(227239);
    }
    
    public final void onDownloadProtocolUpdate(String paramString1, String paramString2)
    {
      AppMethodBeat.i(227273);
      b.c(b.this).bGe("onDownloadProtocolUpdate, protocol:" + paramString1 + ", protocolVer:" + paramString2);
      b.f(b.this).onDownloadProtocolUpdate(paramString1, paramString2);
      AppMethodBeat.o(227273);
    }
    
    public final void onDownloadStatusUpdate(int paramInt)
    {
      AppMethodBeat.i(227270);
      if (paramInt != b.g(b.this))
      {
        b.c(b.this).bGe("onDownloadStatusUpdate, status:".concat(String.valueOf(paramInt)));
        b.a(b.this, paramInt);
      }
      b.f(b.this).onDownloadStatusUpdate(paramInt);
      AppMethodBeat.o(227270);
    }
    
    public final Object onPlayCallback(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
    {
      AppMethodBeat.i(227286);
      paramObject1 = b.f(b.this).onPlayCallback(paramInt, paramObject1, paramObject2, paramObject3, paramObject4);
      AppMethodBeat.o(227286);
      return paramObject1;
    }
    
    public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227333);
      paramInt = b.f(b.this).onReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(227333);
      return paramInt;
    }
    
    public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(227328);
      paramInt = b.f(b.this).onStartReadData(paramInt, paramString, paramLong1, paramLong2);
      AppMethodBeat.o(227328);
      return paramInt;
    }
    
    public final void onStateChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(227199);
      b.a(b.this, 277, paramInt1, paramInt2, null);
      AppMethodBeat.o(227199);
    }
    
    public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(227341);
      paramInt1 = b.f(b.this).onStopReadData(paramInt1, paramString, paramInt2);
      AppMethodBeat.o(227341);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.g.b
 * JD-Core Version:    0.7.0.1
 */