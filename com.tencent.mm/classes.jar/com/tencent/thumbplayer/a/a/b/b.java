package com.tencent.thumbplayer.a.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.b;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.d;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.a.a.c.k;
import com.tencent.thumbplayer.a.a.c.l;
import com.tencent.thumbplayer.a.a.c.m;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeMsgInfo;
import com.tencent.thumbplayer.api.TPCommonEnum.TPOptionalId;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamFloat;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueString;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.c.g;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.thumbplayer.a.a.b
{
  com.tencent.thumbplayer.f.a RVN;
  private TPNativePlayer RYa;
  private TPNativePlayerInitConfig RYb;
  a RYc;
  com.tencent.thumbplayer.a.e RYd;
  private com.tencent.thumbplayer.a.a.a RYe;
  TPSubtitleData RYf;
  private ITPNativePlayerMessageCallback RYg;
  private ITPNativePlayerAudioFrameCallback RYh;
  private ITPNativePlayerVideoFrameCallback RYi;
  private ITPNativePlayerSubtitleFrameCallback RYj;
  private ITPNativePlayerPostProcessFrameCallback RYk;
  
  public b(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(188926);
    this.RYf = new TPSubtitleData();
    this.RYg = new ITPNativePlayerMessageCallback()
    {
      public final void onASyncCallResult(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(188916);
        b.this.RVN.info("onASyncCallResult, callType:" + paramAnonymousInt1 + ", opaque:" + paramAnonymousLong + ", errorType:" + paramAnonymousInt2 + ", errorCode:" + paramAnonymousInt3);
        b.b localb = new b.b();
        localb.RYm = paramAnonymousInt1;
        localb.RVK = paramAnonymousLong;
        localb.dGe = paramAnonymousInt2;
        localb.errorCode = paramAnonymousInt3;
        Message.obtain(b.this.RYc, 1, localb).sendToTarget();
        AppMethodBeat.o(188916);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(188919);
        b.this.RVN.info("onError, msgType:" + paramAnonymousInt1 + ", errorCode:" + paramAnonymousInt2);
        b.c localc = new b.c();
        localc.msgType = paramAnonymousInt1;
        localc.errorCode = paramAnonymousInt2;
        Message.obtain(b.this.RYc, 4, localc).sendToTarget();
        AppMethodBeat.o(188919);
      }
      
      public final void onInfoLong(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(188917);
        b.this.RVN.info("onInfoLong, infoType:" + paramAnonymousInt + ", lParam1:" + paramAnonymousLong1 + ", lParam2:" + paramAnonymousLong2);
        b.d locald = new b.d();
        locald.infoType = paramAnonymousInt;
        locald.lParam1 = paramAnonymousLong1;
        locald.RYn = paramAnonymousLong2;
        Message.obtain(b.this.RYc, 2, locald).sendToTarget();
        AppMethodBeat.o(188917);
      }
      
      public final void onInfoObject(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(188918);
        b.this.RVN.info("onInfoObject, infoType:" + paramAnonymousInt + ", objParam:" + paramAnonymousObject);
        b.e locale = new b.e();
        locale.infoType = paramAnonymousInt;
        locale.RYo = paramAnonymousObject;
        Message.obtain(b.this.RYc, 3, locale).sendToTarget();
        AppMethodBeat.o(188918);
      }
    };
    this.RYh = new ITPNativePlayerAudioFrameCallback()
    {
      public final void onAudioFrame(TPAudioFrame paramAnonymousTPAudioFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(188920);
        paramAnonymousTPAudioFrame = c.a(paramAnonymousTPAudioFrame);
        b.this.RYd.a(paramAnonymousTPAudioFrame);
        AppMethodBeat.o(188920);
      }
    };
    this.RYi = new ITPNativePlayerVideoFrameCallback()
    {
      public final void onVideoFrame(TPVideoFrame paramAnonymousTPVideoFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(188921);
        paramAnonymousTPVideoFrame = c.a(paramAnonymousTPVideoFrame);
        b.this.RYd.a(paramAnonymousTPVideoFrame);
        AppMethodBeat.o(188921);
      }
    };
    this.RYj = new ITPNativePlayerSubtitleFrameCallback()
    {
      public final void onSubtitleFrame(TPSubtitleFrame paramAnonymousTPSubtitleFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(188922);
        paramAnonymousTPSubtitleFrame = c.a(paramAnonymousTPSubtitleFrame);
        b.this.RYd.a(paramAnonymousTPSubtitleFrame);
        AppMethodBeat.o(188922);
      }
    };
    this.RYk = new ITPNativePlayerPostProcessFrameCallback()
    {
      public final TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame paramAnonymousTPPostProcessFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(188923);
        TPPostProcessFrameBuffer localTPPostProcessFrameBuffer = c.a(paramAnonymousTPPostProcessFrame);
        localTPPostProcessFrameBuffer.eventFlag = paramAnonymousInt;
        if (paramAnonymousTPPostProcessFrame.mediaType == 0)
        {
          paramAnonymousTPPostProcessFrame = c.c(b.this.RYd.a(localTPPostProcessFrameBuffer));
          AppMethodBeat.o(188923);
          return paramAnonymousTPPostProcessFrame;
        }
        if (paramAnonymousTPPostProcessFrame.mediaType == 1)
        {
          paramAnonymousTPPostProcessFrame = c.c(b.this.RYd.b(localTPPostProcessFrameBuffer));
          AppMethodBeat.o(188923);
          return paramAnonymousTPPostProcessFrame;
        }
        AppMethodBeat.o(188923);
        return null;
      }
    };
    this.RVN = new com.tencent.thumbplayer.f.a(paramb, "TPThumbPlayer");
    this.RYa = new TPNativePlayer(paramContext);
    this.RYa.setMessageCallback(this.RYg);
    this.RYa.setAudioFrameCallback(this.RYh);
    this.RYa.setVideoFrameCallback(this.RYi);
    this.RYa.setSubtitleFrameCallback(this.RYj);
    this.RYa.setPostProcessFrameCallback(this.RYk);
    this.RYb = new TPNativePlayerInitConfig();
    this.RYd = new com.tencent.thumbplayer.a.e(this.RVN.RVM.tag);
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.RYc = new a(paramContext, this);
      AppMethodBeat.o(188926);
      return;
    }
    paramContext = Looper.getMainLooper();
    if (paramContext != null)
    {
      this.RYc = new a(paramContext, this);
      AppMethodBeat.o(188926);
      return;
    }
    this.RYc = null;
    AppMethodBeat.o(188926);
  }
  
  private void a(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueInt paramOptionalParamQueueInt)
  {
    AppMethodBeat.i(188929);
    c.a locala = com.tencent.thumbplayer.a.b.b.b.are(paramInt);
    if (locala == null)
    {
      this.RVN.error("player optionalIdMapping queue_int is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(188929);
      return;
    }
    if ((paramOptionalParamQueueInt.queueValue == null) || (paramOptionalParamQueueInt.queueValue.length == 0))
    {
      this.RVN.error("queueint params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(188929);
      return;
    }
    switch (locala.RYp)
    {
    default: 
      this.RVN.error("optionID type:" + locala.RYp + " is not implement");
      AppMethodBeat.o(188929);
      return;
    }
    paramInt = 0;
    while (paramInt < paramOptionalParamQueueInt.queueValue.length)
    {
      this.RYb.addQueueInt(locala.RYq, paramOptionalParamQueueInt.queueValue[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(188929);
  }
  
  private void a(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueString paramOptionalParamQueueString)
  {
    AppMethodBeat.i(188930);
    c.a locala = com.tencent.thumbplayer.a.b.b.b.are(paramInt);
    if (locala == null)
    {
      this.RVN.error("player optionalIdMapping queue_string is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(188930);
      return;
    }
    if ((paramOptionalParamQueueString.queueValue == null) || (paramOptionalParamQueueString.queueValue.length == 0))
    {
      this.RVN.error("queue String params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(188930);
      return;
    }
    switch (locala.RYp)
    {
    default: 
      this.RVN.error("optionID type:" + locala.RYp + " is not implement");
      AppMethodBeat.o(188930);
      return;
    }
    paramInt = 0;
    while (paramInt < paramOptionalParamQueueString.queueValue.length)
    {
      this.RYb.addQueueString(locala.RYq, paramOptionalParamQueueString.queueValue[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(188930);
  }
  
  private void hnc()
  {
    AppMethodBeat.i(188980);
    if (this.RYa == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("player has release");
      AppMethodBeat.o(188980);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188980);
  }
  
  public final void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(188961);
    this.RVN.info("switchDefinition url:" + paramString + " opaque:" + paramLong);
    hnc();
    paramInt = com.tencent.thumbplayer.a.b.b.b.arb(paramInt);
    if (this.RYa.switchDefinitionAsync(paramString, paramInt, paramLong) != 0)
    {
      paramString = new IllegalStateException("switchDefinition in invalid state");
      AppMethodBeat.o(188961);
      throw paramString;
    }
    this.RYe = new com.tencent.thumbplayer.b.d(paramString);
    AppMethodBeat.o(188961);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(188940);
    this.RYd.b(parama);
    AppMethodBeat.o(188940);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(188942);
    this.RYd.b(paramb);
    AppMethodBeat.o(188942);
  }
  
  public final void a(c.c paramc)
  {
    AppMethodBeat.i(188932);
    this.RYd.a(paramc);
    AppMethodBeat.o(188932);
  }
  
  public final void a(c.d paramd)
  {
    AppMethodBeat.i(188934);
    this.RYd.a(paramd);
    AppMethodBeat.o(188934);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(188933);
    this.RYd.a(parame);
    AppMethodBeat.o(188933);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(188931);
    this.RYd.a(paramf);
    AppMethodBeat.o(188931);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(188935);
    this.RYd.a(paramg);
    AppMethodBeat.o(188935);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(188937);
    this.RYd.a(parami);
    AppMethodBeat.o(188937);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(188938);
    this.RYd.a(paramj);
    AppMethodBeat.o(188938);
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(188939);
    this.RYd.a(paramk);
    AppMethodBeat.o(188939);
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(188941);
    this.RYd.b(paraml);
    AppMethodBeat.o(188941);
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(188936);
    this.RYd.a(paramm);
    AppMethodBeat.o(188936);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(188962);
    this.RVN.info("switchDefinition mediaAsset:" + paramITPMediaAsset + " opaque:" + paramLong);
    hnc();
    if (paramITPMediaAsset != null)
    {
      paramInt = com.tencent.thumbplayer.a.b.b.b.arb(paramInt);
      if (this.RYa.switchDefinitionAsync(paramITPMediaAsset.getUrl(), paramInt, paramLong) != 0)
      {
        paramITPMediaAsset = new IllegalStateException("switchDefinition in invalid state");
        AppMethodBeat.o(188962);
        throw paramITPMediaAsset;
      }
      this.RYe = new com.tencent.thumbplayer.b.d(paramITPMediaAsset.getUrl());
    }
    AppMethodBeat.o(188962);
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188948);
    this.RVN.info("addSubtitleSource");
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188948);
      return;
    }
    this.RYa.addSubtitleTrackSource(paramString1, paramString3);
    AppMethodBeat.o(188948);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(188979);
    this.RVN.info("captureVideo, params".concat(String.valueOf(paramTPCaptureParams)));
    if (this.RYe != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      this.RYe.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramTPCaptureCallBack);
      AppMethodBeat.o(188979);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
    AppMethodBeat.o(188979);
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188951);
    this.RVN.info("selectTrack");
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188951);
      return;
    }
    this.RYa.deselectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(188951);
  }
  
  public final void g(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(188949);
    this.RVN.info("addAudioTrackSource");
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188949);
      return;
    }
    paramList = new TPPlayerMsg.TPAudioTrackInfo();
    paramList.audioTrackUrl = paramString1;
    paramString1 = this.RYd;
    if (paramString1 != null) {
      paramString1.a(1012, 0L, 0L, paramList);
    }
    this.RYa.addAudioTrackSource(paramList.proxyUrl, paramString2);
    AppMethodBeat.o(188949);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(188972);
    if (this.RYa == null)
    {
      this.RVN.info("player has released, return 0");
      AppMethodBeat.o(188972);
      return 0L;
    }
    long l = this.RYa.getCurrentPositionMs();
    AppMethodBeat.o(188972);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(188971);
    if (this.RYa == null)
    {
      this.RVN.info("player has released, return 0");
      AppMethodBeat.o(188971);
      return 0L;
    }
    long l = this.RYa.getDurationMs();
    AppMethodBeat.o(188971);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(188973);
    if (this.RYa == null)
    {
      this.RVN.info("player has released, return 0");
      AppMethodBeat.o(188973);
      return 0L;
    }
    long l1 = this.RYa.getBufferedDurationMs();
    long l2 = this.RYa.getCurrentPositionMs();
    AppMethodBeat.o(188973);
    return l1 + l2;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(188978);
    this.RVN.info("getProgramInfo");
    if (this.RYa == null)
    {
      this.RVN.info("player has released, return 0");
      AppMethodBeat.o(188978);
      return null;
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo = this.RYa.getProgramInfo();
    if ((arrayOfTPNativePlayerProgramInfo == null) || (arrayOfTPNativePlayerProgramInfo.length <= 0))
    {
      AppMethodBeat.o(188978);
      return null;
    }
    TPProgramInfo[] arrayOfTPProgramInfo = new TPProgramInfo[arrayOfTPNativePlayerProgramInfo.length];
    int i = 0;
    if (i < arrayOfTPNativePlayerProgramInfo.length)
    {
      TPNativePlayerProgramInfo localTPNativePlayerProgramInfo = arrayOfTPNativePlayerProgramInfo[i];
      TPProgramInfo localTPProgramInfo;
      if (localTPNativePlayerProgramInfo != null)
      {
        localTPProgramInfo = new TPProgramInfo();
        localTPProgramInfo.name = localTPNativePlayerProgramInfo.name;
        localTPProgramInfo.bandwidth = localTPNativePlayerProgramInfo.bandwidth;
        localTPProgramInfo.resolution = localTPNativePlayerProgramInfo.resolution;
      }
      for (;;)
      {
        arrayOfTPProgramInfo[i] = localTPProgramInfo;
        i += 1;
        break;
        localTPProgramInfo = null;
      }
    }
    AppMethodBeat.o(188978);
    return arrayOfTPProgramInfo;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(188969);
    this.RVN.info("getPropertyLong:".concat(String.valueOf(paramInt)));
    hnc();
    paramInt = com.tencent.thumbplayer.a.b.b.b.ari(paramInt);
    if (paramInt < 0)
    {
      this.RVN.warn("paramId not found, return -1");
      AppMethodBeat.o(188969);
      return -1L;
    }
    long l = this.RYa.getPropertyLong(paramInt);
    AppMethodBeat.o(188969);
    return l;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(188970);
    this.RVN.info("getPropertyString:".concat(String.valueOf(paramInt)));
    hnc();
    int i;
    try
    {
      i = com.tencent.thumbplayer.a.b.b.b.ari(paramInt);
      if (i < 0)
      {
        this.RVN.warn("getPropertyString, convertToNativePropertyId(" + paramInt + "), return" + i);
        AppMethodBeat.o(188970);
        return "";
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.RVN.warn("paramId not found, return");
      AppMethodBeat.o(188970);
      return "";
    }
    String str = this.RYa.getPropertyString(i);
    AppMethodBeat.o(188970);
    return str;
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(188976);
    this.RVN.info("getTrackInfo");
    if (this.RYa == null)
    {
      this.RVN.info("player has released, return 0");
      AppMethodBeat.o(188976);
      return null;
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = this.RYa.getTrackInfo();
    if ((arrayOfTPMediaTrackInfo == null) || (arrayOfTPMediaTrackInfo.length <= 0))
    {
      AppMethodBeat.o(188976);
      return null;
    }
    TPTrackInfo[] arrayOfTPTrackInfo = new TPTrackInfo[arrayOfTPMediaTrackInfo.length];
    int i = 0;
    while (i < arrayOfTPMediaTrackInfo.length)
    {
      TPMediaTrackInfo localTPMediaTrackInfo = arrayOfTPMediaTrackInfo[i];
      TPTrackInfo localTPTrackInfo = new TPTrackInfo();
      localTPTrackInfo.name = localTPMediaTrackInfo.trackName;
      localTPTrackInfo.trackType = localTPMediaTrackInfo.trackType;
      localTPTrackInfo.isExclusive = localTPMediaTrackInfo.isExclusive;
      localTPTrackInfo.isSelected = localTPMediaTrackInfo.isSelected;
      localTPTrackInfo.isInternal = localTPMediaTrackInfo.isInternal;
      arrayOfTPTrackInfo[i] = localTPTrackInfo;
      i += 1;
    }
    AppMethodBeat.o(188976);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(188975);
    this.RVN.info("getVideoHeight");
    if (this.RYa == null)
    {
      this.RVN.info("player has released, return 0");
      AppMethodBeat.o(188975);
      return 0;
    }
    int i = this.RYa.getVideoHeight();
    AppMethodBeat.o(188975);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(188974);
    this.RVN.info("getVideoWidth");
    if (this.RYa == null)
    {
      this.RVN.info("player has released, return 0");
      AppMethodBeat.o(188974);
      return 0;
    }
    int i = this.RYa.getVideoWidth();
    AppMethodBeat.o(188974);
    return i;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(188955);
    this.RVN.info("pause");
    hnc();
    if (this.RYa.pause() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("pause failed!!");
      AppMethodBeat.o(188955);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188955);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(188952);
    this.RVN.info("prepare");
    hnc();
    this.RYa.setInitConfig(this.RYb);
    if (this.RYa.prepare() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepare failed!!");
      AppMethodBeat.o(188952);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188952);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(188953);
    this.RVN.info("prepareAsync");
    hnc();
    this.RYa.setInitConfig(this.RYb);
    if (this.RYa.prepareAsync() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepareAsync failed!!");
      AppMethodBeat.o(188953);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188953);
  }
  
  public final void release()
  {
    AppMethodBeat.i(188958);
    this.RVN.info("release");
    if (this.RYa != null)
    {
      this.RYa.release();
      this.RYa = null;
    }
    if (this.RYe != null)
    {
      this.RYe.release();
      this.RYe = null;
    }
    AppMethodBeat.o(188958);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(188957);
    this.RVN.info("reset");
    if (this.RYa == null)
    {
      this.RVN.warn("reset, player has released.");
      AppMethodBeat.o(188957);
      return;
    }
    this.RVN.info("reset before");
    this.RYa.reset();
    this.RVN.info("reset after");
    AppMethodBeat.o(188957);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(188959);
    this.RVN.info("seekTo:".concat(String.valueOf(paramInt)));
    hnc();
    if (this.RYa.seekToAsync(paramInt, 1, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt + " failed!!");
      AppMethodBeat.o(188959);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188959);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(188960);
    this.RVN.info("seekTo:" + paramInt1 + " mode:" + paramInt2);
    hnc();
    if (this.RYa.seekToAsync(paramInt1, com.tencent.thumbplayer.a.b.b.b.ara(paramInt2), 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
      AppMethodBeat.o(188960);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188960);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188977);
    this.RVN.info("selectProgram, programIndex:".concat(String.valueOf(paramInt)));
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188977);
      return;
    }
    this.RYa.selectProgramAsync(paramInt, paramLong);
    AppMethodBeat.o(188977);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188950);
    this.RVN.info("selectTrack");
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188950);
      return;
    }
    this.RYa.selectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(188950);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(188964);
    this.RVN.info("setAudioGainRatio:".concat(String.valueOf(paramFloat)));
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188964);
      return;
    }
    this.RYa.setAudioVolume(paramFloat);
    AppMethodBeat.o(188964);
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(188965);
    this.RVN.info("setAudioNormalizeVolumeParams:".concat(String.valueOf(paramString)));
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188965);
      return;
    }
    this.RYa.setAudioNormalizeVolumeParams(paramString);
    AppMethodBeat.o(188965);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(188946);
    this.RVN.info("setDataSource: ".concat(String.valueOf(paramParcelFileDescriptor)));
    hnc();
    if (this.RYa.setDataSource(paramParcelFileDescriptor.getFd()) != 0)
    {
      paramParcelFileDescriptor = new IllegalStateException("setDataSource url pfd failed!!");
      AppMethodBeat.o(188946);
      throw paramParcelFileDescriptor;
    }
    this.RYe = new com.tencent.thumbplayer.b.d(paramParcelFileDescriptor.getFd());
    AppMethodBeat.o(188946);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(188947);
    this.RVN.info("setDataSource: ".concat(String.valueOf(paramITPMediaAsset)));
    hnc();
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalStateException("media asset is null!");
      AppMethodBeat.o(188947);
      throw paramITPMediaAsset;
    }
    if ((!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.d)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.e)) && (!(paramITPMediaAsset instanceof g)))
    {
      paramITPMediaAsset = new IllegalStateException("media asset is illegal source!");
      AppMethodBeat.o(188947);
      throw paramITPMediaAsset;
    }
    paramITPMediaAsset = paramITPMediaAsset.getUrl();
    if (this.RYa.setDataSource(paramITPMediaAsset) != 0)
    {
      paramITPMediaAsset = new IllegalStateException("setDataSource mediaAsset failed!!");
      AppMethodBeat.o(188947);
      throw paramITPMediaAsset;
    }
    this.RYe = new com.tencent.thumbplayer.b.d(paramITPMediaAsset);
    AppMethodBeat.o(188947);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188945);
    this.RVN.info("setDataSource: ".concat(String.valueOf(paramString)));
    hnc();
    if (this.RYa.setDataSource(paramString, paramMap) != 0)
    {
      paramString = new IllegalStateException("setDataSource url and header failed!!");
      AppMethodBeat.o(188945);
      throw paramString;
    }
    this.RYe = new com.tencent.thumbplayer.b.d(paramString);
    AppMethodBeat.o(188945);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(188967);
    this.RVN.info("setLoopback:".concat(String.valueOf(paramBoolean)));
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188967);
      return;
    }
    this.RYa.setLoopback(paramBoolean, 0L, -1L);
    AppMethodBeat.o(188967);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188968);
    this.RVN.info("setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188968);
      return;
    }
    if (this.RYa.setLoopback(paramBoolean, paramLong1, paramLong2) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("set loopback failed!!");
      AppMethodBeat.o(188968);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188968);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(188963);
    this.RVN.info("setOutputMute:".concat(String.valueOf(paramBoolean)));
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188963);
      return;
    }
    this.RYa.setAudioMute(paramBoolean);
    AppMethodBeat.o(188963);
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(188966);
    this.RVN.info("setPlaySpeedRatio:".concat(String.valueOf(paramFloat)));
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188966);
      return;
    }
    this.RYa.setPlaybackRate(paramFloat);
    AppMethodBeat.o(188966);
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    boolean bool = true;
    AppMethodBeat.i(188928);
    this.RVN.info("setPlayerOptionalParam:".concat(String.valueOf(paramTPOptionalParam)));
    if (this.RYa == null)
    {
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188928);
      return;
    }
    int i;
    c.a locala;
    Object localObject;
    if (paramTPOptionalParam.getParamType() == 1)
    {
      if (paramTPOptionalParam.getKey() < 500)
      {
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamBoolean();
        locala = com.tencent.thumbplayer.a.b.b.b.are(i);
        if (locala == null)
        {
          this.RVN.error("player optionalIdMapping boolean is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(188928);
          return;
        }
        switch (locala.RYp)
        {
        default: 
          this.RVN.error("optionID type:" + locala.RYp + " is not implement");
          AppMethodBeat.o(188928);
          return;
        }
        this.RYb.setBool(locala.RYq, paramTPOptionalParam.value);
        AppMethodBeat.o(188928);
        return;
      }
      i = paramTPOptionalParam.getKey();
      paramTPOptionalParam = paramTPOptionalParam.getParamBoolean();
      locala = com.tencent.thumbplayer.a.b.b.b.arf(i);
      if (locala == null)
      {
        this.RVN.error("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(188928);
        return;
      }
      switch (locala.RYp)
      {
      default: 
        this.RVN.error("optionID type:" + locala.RYp + " is not implement");
        AppMethodBeat.o(188928);
        return;
      }
      localObject = this.RYa;
      i = locala.RYq;
      if (paramTPOptionalParam.value) {}
      for (long l = 1L;; l = 0L)
      {
        ((TPNativePlayer)localObject).setOptionLong(i, l, 0L);
        AppMethodBeat.o(188928);
        return;
      }
    }
    if (paramTPOptionalParam.getParamType() == 2)
    {
      if (paramTPOptionalParam.getKey() < 500)
      {
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamLong();
        locala = com.tencent.thumbplayer.a.b.b.b.are(i);
        if (locala == null)
        {
          this.RVN.error("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(188928);
          return;
        }
        switch (locala.RYp)
        {
        case 2: 
        default: 
          this.RVN.error("optionID type:" + locala.RYp + " is not implement");
          AppMethodBeat.o(188928);
          return;
        case 1: 
          this.RYb.setLong(locala.RYq, paramTPOptionalParam.value);
          AppMethodBeat.o(188928);
          return;
        case 4: 
          this.RYb.setInt(locala.RYq, (int)paramTPOptionalParam.value);
          AppMethodBeat.o(188928);
          return;
        }
        localObject = this.RYb;
        i = locala.RYq;
        if (paramTPOptionalParam.value > 0L) {}
        for (;;)
        {
          ((TPNativePlayerInitConfig)localObject).setBool(i, bool);
          AppMethodBeat.o(188928);
          return;
          bool = false;
        }
      }
      i = paramTPOptionalParam.getKey();
      paramTPOptionalParam = paramTPOptionalParam.getParamLong();
      locala = com.tencent.thumbplayer.a.b.b.b.arf(i);
      if (locala == null)
      {
        this.RVN.error("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(188928);
        return;
      }
      switch (locala.RYp)
      {
      case 2: 
      default: 
        this.RVN.error("optionID type:" + locala.RYp + " is not implement");
        AppMethodBeat.o(188928);
        return;
      }
      this.RYa.setOptionLong(locala.RYq, paramTPOptionalParam.value, paramTPOptionalParam.param1);
      AppMethodBeat.o(188928);
      return;
    }
    if (paramTPOptionalParam.getParamType() == 6)
    {
      if (paramTPOptionalParam.getKey() < 500)
      {
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamFloat();
        locala = com.tencent.thumbplayer.a.b.b.b.are(i);
        if (locala == null)
        {
          this.RVN.error("player optionalIdMapping float is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(188928);
          return;
        }
        if (7 != locala.RYp)
        {
          this.RVN.error("optionID:" + locala.RYq + " is not float");
          AppMethodBeat.o(188928);
          return;
        }
        this.RYb.setFloat(locala.RYq, paramTPOptionalParam.value);
        AppMethodBeat.o(188928);
      }
    }
    else
    {
      if (paramTPOptionalParam.getParamType() == 3)
      {
        if (paramTPOptionalParam.getKey() < 500)
        {
          paramTPOptionalParam.getKey();
          paramTPOptionalParam.getParamString();
          this.RVN.error("init string param type is not implement coz native init config no string setting");
          AppMethodBeat.o(188928);
          return;
        }
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamString();
        locala = com.tencent.thumbplayer.a.b.b.b.arf(i);
        if (locala == null)
        {
          this.RVN.error("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(188928);
          return;
        }
        switch (locala.RYp)
        {
        default: 
          this.RVN.error("optionID type:" + locala.RYp + " is not implement");
          AppMethodBeat.o(188928);
          return;
        }
        this.RYa.setOptionObject(locala.RYq, paramTPOptionalParam.value);
        AppMethodBeat.o(188928);
        return;
      }
      if (paramTPOptionalParam.getParamType() == 4)
      {
        if (paramTPOptionalParam.getKey() < 500)
        {
          a(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueInt());
          AppMethodBeat.o(188928);
        }
      }
      else if (paramTPOptionalParam.getParamType() == 5)
      {
        if (paramTPOptionalParam.getKey() < 500)
        {
          a(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueString());
          AppMethodBeat.o(188928);
        }
      }
      else
      {
        this.RVN.warn("optionalParam param type is unknown, return");
        AppMethodBeat.o(188928);
        return;
      }
    }
    AppMethodBeat.o(188928);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(188943);
    com.tencent.thumbplayer.f.a locala = this.RVN;
    StringBuilder localStringBuilder = new StringBuilder("setSurface, surface is null ? : ");
    if (paramSurface == null) {}
    for (boolean bool = true;; bool = false)
    {
      locala.info(bool);
      if (this.RYa != null) {
        break;
      }
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188943);
      return;
    }
    if (this.RYa.setVideoSurface(paramSurface) != 0)
    {
      paramSurface = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(188943);
      throw paramSurface;
    }
    AppMethodBeat.o(188943);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(188944);
    com.tencent.thumbplayer.f.a locala = this.RVN;
    StringBuilder localStringBuilder = new StringBuilder("SurfaceHolder, surfaceHolder is null ? : ");
    if (paramSurfaceHolder == null) {}
    for (boolean bool = true;; bool = false)
    {
      locala.info(bool);
      if (this.RYa != null) {
        break;
      }
      this.RVN.warn("player has released, return");
      AppMethodBeat.o(188944);
      return;
    }
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder.getSurface() == null))
    {
      this.RVN.error("SurfaceHolder，err.");
      AppMethodBeat.o(188944);
      return;
    }
    if (paramSurfaceHolder == null) {}
    for (paramSurfaceHolder = null; this.RYa.setVideoSurface(paramSurfaceHolder) != 0; paramSurfaceHolder = paramSurfaceHolder.getSurface())
    {
      paramSurfaceHolder = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(188944);
      throw paramSurfaceHolder;
    }
    AppMethodBeat.o(188944);
  }
  
  public final void start()
  {
    AppMethodBeat.i(188954);
    this.RVN.info("start");
    hnc();
    if (this.RYa.start() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("start failed!!");
      AppMethodBeat.o(188954);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188954);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(188956);
    this.RVN.info("stop");
    hnc();
    this.RVN.info("stop before");
    int i = this.RYa.stop();
    this.RVN.info("stop after");
    if (i != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("stop failed!!");
      AppMethodBeat.o(188956);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(188956);
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(188927);
    this.RVN.a(new com.tencent.thumbplayer.f.b(paramb, "TPThumbPlayer"));
    if (paramb != null) {
      this.RYd.bqx(this.RVN.RVM.tag);
    }
    AppMethodBeat.o(188927);
  }
  
  final class a
    extends Handler
  {
    private WeakReference<b> phi;
    
    public a(Looper paramLooper, b paramb)
    {
      super();
      AppMethodBeat.i(188924);
      this.phi = new WeakReference(paramb);
      AppMethodBeat.o(188924);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(188925);
      if ((b)this.phi.get() == null)
      {
        b.this.RVN.error("mWeakRef is null");
        AppMethodBeat.o(188925);
        return;
      }
      Object localObject;
      switch (paramMessage.what)
      {
      default: 
        b.this.RVN.warn("message :" + paramMessage.what + "  not recognition");
        AppMethodBeat.o(188925);
        return;
      case 1: 
        paramMessage = (b.b)paramMessage.obj;
        switch (paramMessage.RYm)
        {
        default: 
          b.this.RYd.a(com.tencent.thumbplayer.a.b.b.b.ard(paramMessage.RYm), paramMessage.dGe, paramMessage.errorCode, Long.valueOf(paramMessage.RVK));
          AppMethodBeat.o(188925);
          return;
        case 1: 
          b.this.RYd.tf();
          AppMethodBeat.o(188925);
          return;
        }
        b.this.RYd.cJH();
        AppMethodBeat.o(188925);
        return;
      case 2: 
        paramMessage = (b.d)paramMessage.obj;
        switch (paramMessage.infoType)
        {
        default: 
          localObject = b.this;
          i = paramMessage.infoType;
          j = com.tencent.thumbplayer.a.b.b.b.ard(i);
          if (j < 0)
          {
            ((b)localObject).RVN.warn("msgType:" + i + ", cannot convert to thumbPlayer Info");
            AppMethodBeat.o(188925);
            return;
          }
          break;
        case 250: 
          localObject = b.this;
          l1 = paramMessage.lParam1;
          l2 = paramMessage.RYn;
          ((b)localObject).RYd.aI(l1, l2);
          AppMethodBeat.o(188925);
          return;
        case 154: 
          b.this.RYd.onCompletion();
          AppMethodBeat.o(188925);
          return;
        }
        long l1 = paramMessage.lParam1;
        long l2 = paramMessage.RYn;
        switch (j)
        {
        }
        for (;;)
        {
          ((b)localObject).RYd.a(j, l1, l2, null);
          AppMethodBeat.o(188925);
          return;
          l1 = c.aqZ((int)paramMessage.lParam1);
        }
      case 3: 
        b.e locale = (b.e)paramMessage.obj;
        b localb;
        switch (locale.infoType)
        {
        default: 
          localb = b.this;
          i = locale.infoType;
          j = com.tencent.thumbplayer.a.b.b.b.ard(i);
          if (j < 0)
          {
            localb.RVN.warn("msgType:" + i + ", cannot convert to thumbPlayer Info");
            AppMethodBeat.o(188925);
            return;
          }
          break;
        case 502: 
          if (!(locale.RYo instanceof String)) {
            break label631;
          }
          b.this.RYf.subtitleData = ((String)locale.RYo);
          b.this.RYd.a(b.this.RYf);
          AppMethodBeat.o(188925);
          return;
        }
        localObject = locale.RYo;
        paramMessage = (Message)localObject;
        switch (j)
        {
        default: 
          paramMessage = (Message)localObject;
        }
        for (;;)
        {
          localb.RYd.a(j, 0L, 0L, paramMessage);
          label631:
          AppMethodBeat.o(188925);
          return;
          paramMessage = (Message)localObject;
          if (locale.RYo != null)
          {
            paramMessage = c.a((ITPNativePlayerMessageCallback.VideoCropInfo)locale.RYo);
            continue;
            paramMessage = (Message)localObject;
            if (locale.RYo != null) {
              paramMessage = c.a((ITPNativePlayerMessageCallback.MediaCodecInfo)locale.RYo);
            }
          }
        }
      }
      paramMessage = (b.c)paramMessage.obj;
      int i = paramMessage.msgType;
      int j = paramMessage.errorCode;
      b.this.RYd.a(com.tencent.thumbplayer.a.b.b.b.arc(i), j, 0L, 0L);
      AppMethodBeat.o(188925);
    }
  }
  
  public static final class b
  {
    long RVK;
    @TPCommonEnum.NativeMsgInfo
    int RYm;
    int dGe;
    int errorCode;
  }
  
  public static final class c
  {
    int errorCode;
    int msgType;
  }
  
  public static final class d
  {
    long RYn;
    int infoType;
    long lParam1;
  }
  
  public static final class e
  {
    Object RYo;
    int infoType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */