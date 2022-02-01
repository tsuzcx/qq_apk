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
  private TPNativePlayer ZAK;
  private TPNativePlayerInitConfig ZAL;
  a ZAM;
  com.tencent.thumbplayer.a.e ZAN;
  private com.tencent.thumbplayer.a.a.a ZAO;
  TPSubtitleData ZAP;
  private ITPNativePlayerMessageCallback ZAQ;
  private ITPNativePlayerAudioFrameCallback ZAR;
  private ITPNativePlayerVideoFrameCallback ZAS;
  private ITPNativePlayerSubtitleFrameCallback ZAT;
  private ITPNativePlayerPostProcessFrameCallback ZAU;
  com.tencent.thumbplayer.f.a Zyx;
  
  public b(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(219476);
    this.ZAP = new TPSubtitleData();
    this.ZAQ = new ITPNativePlayerMessageCallback()
    {
      public final void onASyncCallResult(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(219395);
        b.this.Zyx.bDy("onASyncCallResult, callType:" + paramAnonymousInt1 + ", opaque:" + paramAnonymousLong + ", errorType:" + paramAnonymousInt2 + ", errorCode:" + paramAnonymousInt3);
        b.b localb = new b.b();
        localb.ZAW = paramAnonymousInt1;
        localb.Zyu = paramAnonymousLong;
        localb.fyO = paramAnonymousInt2;
        localb.errorCode = paramAnonymousInt3;
        Message.obtain(b.this.ZAM, 1, localb).sendToTarget();
        AppMethodBeat.o(219395);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(219404);
        b.this.Zyx.bDy("onError, msgType:" + paramAnonymousInt1 + ", errorCode:" + paramAnonymousInt2);
        b.c localc = new b.c();
        localc.msgType = paramAnonymousInt1;
        localc.errorCode = paramAnonymousInt2;
        Message.obtain(b.this.ZAM, 4, localc).sendToTarget();
        AppMethodBeat.o(219404);
      }
      
      public final void onInfoLong(int paramAnonymousInt, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(219398);
        b.this.Zyx.bDy("onInfoLong, infoType:" + paramAnonymousInt + ", lParam1:" + paramAnonymousLong1 + ", lParam2:" + paramAnonymousLong2);
        b.d locald = new b.d();
        locald.infoType = paramAnonymousInt;
        locald.lParam1 = paramAnonymousLong1;
        locald.ZAX = paramAnonymousLong2;
        Message.obtain(b.this.ZAM, 2, locald).sendToTarget();
        AppMethodBeat.o(219398);
      }
      
      public final void onInfoObject(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(219400);
        b.this.Zyx.bDy("onInfoObject, infoType:" + paramAnonymousInt + ", objParam:" + paramAnonymousObject);
        b.e locale = new b.e();
        locale.infoType = paramAnonymousInt;
        locale.ZAY = paramAnonymousObject;
        Message.obtain(b.this.ZAM, 3, locale).sendToTarget();
        AppMethodBeat.o(219400);
      }
    };
    this.ZAR = new ITPNativePlayerAudioFrameCallback()
    {
      public final void onAudioFrame(TPAudioFrame paramAnonymousTPAudioFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(219407);
        paramAnonymousTPAudioFrame = c.a(paramAnonymousTPAudioFrame);
        b.this.ZAN.a(paramAnonymousTPAudioFrame);
        AppMethodBeat.o(219407);
      }
    };
    this.ZAS = new ITPNativePlayerVideoFrameCallback()
    {
      public final void onVideoFrame(TPVideoFrame paramAnonymousTPVideoFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(219416);
        paramAnonymousTPVideoFrame = c.a(paramAnonymousTPVideoFrame);
        b.this.ZAN.a(paramAnonymousTPVideoFrame);
        AppMethodBeat.o(219416);
      }
    };
    this.ZAT = new ITPNativePlayerSubtitleFrameCallback()
    {
      public final void onSubtitleFrame(TPSubtitleFrame paramAnonymousTPSubtitleFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(219421);
        paramAnonymousTPSubtitleFrame = c.a(paramAnonymousTPSubtitleFrame);
        b.this.ZAN.a(paramAnonymousTPSubtitleFrame);
        AppMethodBeat.o(219421);
      }
    };
    this.ZAU = new ITPNativePlayerPostProcessFrameCallback()
    {
      public final TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame paramAnonymousTPPostProcessFrame, int paramAnonymousInt)
      {
        AppMethodBeat.i(219429);
        TPPostProcessFrameBuffer localTPPostProcessFrameBuffer = c.a(paramAnonymousTPPostProcessFrame);
        localTPPostProcessFrameBuffer.eventFlag = paramAnonymousInt;
        if (paramAnonymousTPPostProcessFrame.mediaType == 0)
        {
          paramAnonymousTPPostProcessFrame = c.c(b.this.ZAN.a(localTPPostProcessFrameBuffer));
          AppMethodBeat.o(219429);
          return paramAnonymousTPPostProcessFrame;
        }
        if (paramAnonymousTPPostProcessFrame.mediaType == 1)
        {
          paramAnonymousTPPostProcessFrame = c.c(b.this.ZAN.b(localTPPostProcessFrameBuffer));
          AppMethodBeat.o(219429);
          return paramAnonymousTPPostProcessFrame;
        }
        AppMethodBeat.o(219429);
        return null;
      }
    };
    this.Zyx = new com.tencent.thumbplayer.f.a(paramb, "TPThumbPlayer");
    this.ZAK = new TPNativePlayer(paramContext);
    this.ZAK.setMessageCallback(this.ZAQ);
    this.ZAK.setAudioFrameCallback(this.ZAR);
    this.ZAK.setVideoFrameCallback(this.ZAS);
    this.ZAK.setSubtitleFrameCallback(this.ZAT);
    this.ZAK.setPostProcessFrameCallback(this.ZAU);
    this.ZAL = new TPNativePlayerInitConfig();
    this.ZAN = new com.tencent.thumbplayer.a.e(this.Zyx.Zyw.tag);
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.ZAM = new a(paramContext, this);
      AppMethodBeat.o(219476);
      return;
    }
    paramContext = Looper.getMainLooper();
    if (paramContext != null)
    {
      this.ZAM = new a(paramContext, this);
      AppMethodBeat.o(219476);
      return;
    }
    this.ZAM = null;
    AppMethodBeat.o(219476);
  }
  
  private void a(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueInt paramOptionalParamQueueInt)
  {
    AppMethodBeat.i(219519);
    c.a locala = com.tencent.thumbplayer.a.b.b.b.aAR(paramInt);
    if (locala == null)
    {
      this.Zyx.error("player optionalIdMapping queue_int is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(219519);
      return;
    }
    if ((paramOptionalParamQueueInt.queueValue == null) || (paramOptionalParamQueueInt.queueValue.length == 0))
    {
      this.Zyx.error("queueint params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(219519);
      return;
    }
    switch (locala.ZAZ)
    {
    default: 
      this.Zyx.error("optionID type:" + locala.ZAZ + " is not implement");
      AppMethodBeat.o(219519);
      return;
    }
    paramInt = 0;
    while (paramInt < paramOptionalParamQueueInt.queueValue.length)
    {
      this.ZAL.addQueueInt(locala.ZBa, paramOptionalParamQueueInt.queueValue[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(219519);
  }
  
  private void a(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueString paramOptionalParamQueueString)
  {
    AppMethodBeat.i(219523);
    c.a locala = com.tencent.thumbplayer.a.b.b.b.aAR(paramInt);
    if (locala == null)
    {
      this.Zyx.error("player optionalIdMapping queue_string is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(219523);
      return;
    }
    if ((paramOptionalParamQueueString.queueValue == null) || (paramOptionalParamQueueString.queueValue.length == 0))
    {
      this.Zyx.error("queue String params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(219523);
      return;
    }
    switch (locala.ZAZ)
    {
    default: 
      this.Zyx.error("optionID type:" + locala.ZAZ + " is not implement");
      AppMethodBeat.o(219523);
      return;
    }
    paramInt = 0;
    while (paramInt < paramOptionalParamQueueString.queueValue.length)
    {
      this.ZAL.addQueueString(locala.ZBa, paramOptionalParamQueueString.queueValue[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(219523);
  }
  
  private void iqD()
  {
    AppMethodBeat.i(219627);
    if (this.ZAK == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("player has release");
      AppMethodBeat.o(219627);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219627);
  }
  
  public final void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(219594);
    this.Zyx.bDy("switchDefinition url:" + paramString + " opaque:" + paramLong);
    iqD();
    paramInt = com.tencent.thumbplayer.a.b.b.b.aAO(paramInt);
    if (this.ZAK.switchDefinitionAsync(paramString, paramInt, paramLong) != 0)
    {
      paramString = new IllegalStateException("switchDefinition in invalid state");
      AppMethodBeat.o(219594);
      throw paramString;
    }
    this.ZAO = new com.tencent.thumbplayer.b.d(paramString);
    AppMethodBeat.o(219594);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(219538);
    this.ZAN.b(parama);
    AppMethodBeat.o(219538);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(219541);
    this.ZAN.b(paramb);
    AppMethodBeat.o(219541);
  }
  
  public final void a(c.c paramc)
  {
    AppMethodBeat.i(219526);
    this.ZAN.a(paramc);
    AppMethodBeat.o(219526);
  }
  
  public final void a(c.d paramd)
  {
    AppMethodBeat.i(219528);
    this.ZAN.a(paramd);
    AppMethodBeat.o(219528);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(219527);
    this.ZAN.a(parame);
    AppMethodBeat.o(219527);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(219524);
    this.ZAN.a(paramf);
    AppMethodBeat.o(219524);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(219530);
    this.ZAN.a(paramg);
    AppMethodBeat.o(219530);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(219533);
    this.ZAN.a(parami);
    AppMethodBeat.o(219533);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(219536);
    this.ZAN.a(paramj);
    AppMethodBeat.o(219536);
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(219537);
    this.ZAN.a(paramk);
    AppMethodBeat.o(219537);
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(219539);
    this.ZAN.b(paraml);
    AppMethodBeat.o(219539);
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(219531);
    this.ZAN.a(paramm);
    AppMethodBeat.o(219531);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(219597);
    this.Zyx.bDy("switchDefinition mediaAsset:" + paramITPMediaAsset + " opaque:" + paramLong);
    iqD();
    if (paramITPMediaAsset != null)
    {
      paramInt = com.tencent.thumbplayer.a.b.b.b.aAO(paramInt);
      if (this.ZAK.switchDefinitionAsync(paramITPMediaAsset.getUrl(), paramInt, paramLong) != 0)
      {
        paramITPMediaAsset = new IllegalStateException("switchDefinition in invalid state");
        AppMethodBeat.o(219597);
        throw paramITPMediaAsset;
      }
      this.ZAO = new com.tencent.thumbplayer.b.d(paramITPMediaAsset.getUrl());
    }
    AppMethodBeat.o(219597);
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219560);
    this.Zyx.bDy("addSubtitleSource");
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219560);
      return;
    }
    this.ZAK.addSubtitleTrackSource(paramString1, paramString3);
    AppMethodBeat.o(219560);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(219626);
    this.Zyx.bDy("captureVideo, params".concat(String.valueOf(paramTPCaptureParams)));
    if (this.ZAO != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      this.ZAO.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramTPCaptureCallBack);
      AppMethodBeat.o(219626);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
    AppMethodBeat.o(219626);
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219569);
    this.Zyx.bDy("selectTrack");
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219569);
      return;
    }
    this.ZAK.deselectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(219569);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(219612);
    if (this.ZAK == null)
    {
      this.Zyx.bDy("player has released, return 0");
      AppMethodBeat.o(219612);
      return 0L;
    }
    long l = this.ZAK.getCurrentPositionMs();
    AppMethodBeat.o(219612);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(219611);
    if (this.ZAK == null)
    {
      this.Zyx.bDy("player has released, return 0");
      AppMethodBeat.o(219611);
      return 0L;
    }
    long l = this.ZAK.getDurationMs();
    AppMethodBeat.o(219611);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(219613);
    if (this.ZAK == null)
    {
      this.Zyx.bDy("player has released, return 0");
      AppMethodBeat.o(219613);
      return 0L;
    }
    long l1 = this.ZAK.getBufferedDurationMs();
    long l2 = this.ZAK.getCurrentPositionMs();
    AppMethodBeat.o(219613);
    return l1 + l2;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(219624);
    this.Zyx.bDy("getProgramInfo");
    if (this.ZAK == null)
    {
      this.Zyx.bDy("player has released, return 0");
      AppMethodBeat.o(219624);
      return null;
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo = this.ZAK.getProgramInfo();
    if ((arrayOfTPNativePlayerProgramInfo == null) || (arrayOfTPNativePlayerProgramInfo.length <= 0))
    {
      AppMethodBeat.o(219624);
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
    AppMethodBeat.o(219624);
    return arrayOfTPProgramInfo;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(219606);
    this.Zyx.bDy("getPropertyLong:".concat(String.valueOf(paramInt)));
    iqD();
    paramInt = com.tencent.thumbplayer.a.b.b.b.aAV(paramInt);
    if (paramInt < 0)
    {
      this.Zyx.bDz("paramId not found, return -1");
      AppMethodBeat.o(219606);
      return -1L;
    }
    long l = this.ZAK.getPropertyLong(paramInt);
    AppMethodBeat.o(219606);
    return l;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(219609);
    this.Zyx.bDy("getPropertyString:".concat(String.valueOf(paramInt)));
    iqD();
    int i;
    try
    {
      i = com.tencent.thumbplayer.a.b.b.b.aAV(paramInt);
      if (i < 0)
      {
        this.Zyx.bDz("getPropertyString, convertToNativePropertyId(" + paramInt + "), return" + i);
        AppMethodBeat.o(219609);
        return "";
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.Zyx.bDz("paramId not found, return");
      AppMethodBeat.o(219609);
      return "";
    }
    String str = this.ZAK.getPropertyString(i);
    AppMethodBeat.o(219609);
    return str;
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(219621);
    this.Zyx.bDy("getTrackInfo");
    if (this.ZAK == null)
    {
      this.Zyx.bDy("player has released, return 0");
      AppMethodBeat.o(219621);
      return null;
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = this.ZAK.getTrackInfo();
    if ((arrayOfTPMediaTrackInfo == null) || (arrayOfTPMediaTrackInfo.length <= 0))
    {
      AppMethodBeat.o(219621);
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
    AppMethodBeat.o(219621);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(219617);
    this.Zyx.bDy("getVideoHeight");
    if (this.ZAK == null)
    {
      this.Zyx.bDy("player has released, return 0");
      AppMethodBeat.o(219617);
      return 0;
    }
    int i = this.ZAK.getVideoHeight();
    AppMethodBeat.o(219617);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(219614);
    this.Zyx.bDy("getVideoWidth");
    if (this.ZAK == null)
    {
      this.Zyx.bDy("player has released, return 0");
      AppMethodBeat.o(219614);
      return 0;
    }
    int i = this.ZAK.getVideoWidth();
    AppMethodBeat.o(219614);
    return i;
  }
  
  public final void h(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(219564);
    this.Zyx.bDy("addAudioTrackSource");
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219564);
      return;
    }
    paramList = new TPPlayerMsg.TPAudioTrackInfo();
    paramList.audioTrackUrl = paramString1;
    paramString1 = this.ZAN;
    if (paramString1 != null) {
      paramString1.a(1012, 0L, 0L, paramList);
    }
    this.ZAK.addAudioTrackSource(paramList.proxyUrl, paramString2);
    AppMethodBeat.o(219564);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(219581);
    this.Zyx.bDy("pause");
    iqD();
    if (this.ZAK.pause() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("pause failed!!");
      AppMethodBeat.o(219581);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219581);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(219573);
    this.Zyx.bDy("prepare");
    iqD();
    this.ZAK.setInitConfig(this.ZAL);
    if (this.ZAK.prepare() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepare failed!!");
      AppMethodBeat.o(219573);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219573);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(219575);
    this.Zyx.bDy("prepareAsync");
    iqD();
    this.ZAK.setInitConfig(this.ZAL);
    if (this.ZAK.prepareAsync() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepareAsync failed!!");
      AppMethodBeat.o(219575);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219575);
  }
  
  public final void release()
  {
    AppMethodBeat.i(219586);
    this.Zyx.bDy("release");
    if (this.ZAK != null)
    {
      this.ZAK.release();
      this.ZAK = null;
    }
    if (this.ZAO != null)
    {
      this.ZAO.release();
      this.ZAO = null;
    }
    AppMethodBeat.o(219586);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(219585);
    this.Zyx.bDy("reset");
    if (this.ZAK == null)
    {
      this.Zyx.bDz("reset, player has released.");
      AppMethodBeat.o(219585);
      return;
    }
    this.Zyx.bDy("reset before");
    this.ZAK.reset();
    this.Zyx.bDy("reset after");
    AppMethodBeat.o(219585);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(219591);
    this.Zyx.bDy("seekTo:".concat(String.valueOf(paramInt)));
    iqD();
    if (this.ZAK.seekToAsync(paramInt, 1, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt + " failed!!");
      AppMethodBeat.o(219591);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219591);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(219593);
    this.Zyx.bDy("seekTo:" + paramInt1 + " mode:" + paramInt2);
    iqD();
    if (this.ZAK.seekToAsync(paramInt1, com.tencent.thumbplayer.a.b.b.b.aAN(paramInt2), 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
      AppMethodBeat.o(219593);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219593);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219623);
    this.Zyx.bDy("selectProgram, programIndex:".concat(String.valueOf(paramInt)));
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219623);
      return;
    }
    this.ZAK.selectProgramAsync(paramInt, paramLong);
    AppMethodBeat.o(219623);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219567);
    this.Zyx.bDy("selectTrack");
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219567);
      return;
    }
    this.ZAK.selectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(219567);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(219600);
    this.Zyx.bDy("setAudioGainRatio:".concat(String.valueOf(paramFloat)));
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219600);
      return;
    }
    this.ZAK.setAudioVolume(paramFloat);
    AppMethodBeat.o(219600);
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(219601);
    this.Zyx.bDy("setAudioNormalizeVolumeParams:".concat(String.valueOf(paramString)));
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219601);
      return;
    }
    this.ZAK.setAudioNormalizeVolumeParams(paramString);
    AppMethodBeat.o(219601);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(219554);
    this.Zyx.bDy("setDataSource: ".concat(String.valueOf(paramParcelFileDescriptor)));
    iqD();
    if (this.ZAK.setDataSource(paramParcelFileDescriptor.getFd()) != 0)
    {
      paramParcelFileDescriptor = new IllegalStateException("setDataSource url pfd failed!!");
      AppMethodBeat.o(219554);
      throw paramParcelFileDescriptor;
    }
    this.ZAO = new com.tencent.thumbplayer.b.d(paramParcelFileDescriptor.getFd());
    AppMethodBeat.o(219554);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(219557);
    this.Zyx.bDy("setDataSource: ".concat(String.valueOf(paramITPMediaAsset)));
    iqD();
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalStateException("media asset is null!");
      AppMethodBeat.o(219557);
      throw paramITPMediaAsset;
    }
    if ((!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.d)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.e)) && (!(paramITPMediaAsset instanceof g)))
    {
      paramITPMediaAsset = new IllegalStateException("media asset is illegal source!");
      AppMethodBeat.o(219557);
      throw paramITPMediaAsset;
    }
    paramITPMediaAsset = paramITPMediaAsset.getUrl();
    if (this.ZAK.setDataSource(paramITPMediaAsset) != 0)
    {
      paramITPMediaAsset = new IllegalStateException("setDataSource mediaAsset failed!!");
      AppMethodBeat.o(219557);
      throw paramITPMediaAsset;
    }
    this.ZAO = new com.tencent.thumbplayer.b.d(paramITPMediaAsset);
    AppMethodBeat.o(219557);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(219550);
    this.Zyx.bDy("setDataSource: ".concat(String.valueOf(paramString)));
    iqD();
    if (this.ZAK.setDataSource(paramString, paramMap) != 0)
    {
      paramString = new IllegalStateException("setDataSource url and header failed!!");
      AppMethodBeat.o(219550);
      throw paramString;
    }
    this.ZAO = new com.tencent.thumbplayer.b.d(paramString);
    AppMethodBeat.o(219550);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(219604);
    this.Zyx.bDy("setLoopback:".concat(String.valueOf(paramBoolean)));
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219604);
      return;
    }
    this.ZAK.setLoopback(paramBoolean, 0L, -1L);
    AppMethodBeat.o(219604);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219605);
    this.Zyx.bDy("setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219605);
      return;
    }
    if (this.ZAK.setLoopback(paramBoolean, paramLong1, paramLong2) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("set loopback failed!!");
      AppMethodBeat.o(219605);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219605);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(219599);
    this.Zyx.bDy("setOutputMute:".concat(String.valueOf(paramBoolean)));
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219599);
      return;
    }
    this.ZAK.setAudioMute(paramBoolean);
    AppMethodBeat.o(219599);
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(219602);
    this.Zyx.bDy("setPlaySpeedRatio:".concat(String.valueOf(paramFloat)));
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219602);
      return;
    }
    this.ZAK.setPlaybackRate(paramFloat);
    AppMethodBeat.o(219602);
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    boolean bool = true;
    AppMethodBeat.i(219515);
    this.Zyx.bDy("setPlayerOptionalParam:".concat(String.valueOf(paramTPOptionalParam)));
    if (this.ZAK == null)
    {
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219515);
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
        locala = com.tencent.thumbplayer.a.b.b.b.aAR(i);
        if (locala == null)
        {
          this.Zyx.error("player optionalIdMapping boolean is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(219515);
          return;
        }
        switch (locala.ZAZ)
        {
        default: 
          this.Zyx.error("optionID type:" + locala.ZAZ + " is not implement");
          AppMethodBeat.o(219515);
          return;
        }
        this.ZAL.setBool(locala.ZBa, paramTPOptionalParam.value);
        AppMethodBeat.o(219515);
        return;
      }
      i = paramTPOptionalParam.getKey();
      paramTPOptionalParam = paramTPOptionalParam.getParamBoolean();
      locala = com.tencent.thumbplayer.a.b.b.b.aAS(i);
      if (locala == null)
      {
        this.Zyx.error("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(219515);
        return;
      }
      switch (locala.ZAZ)
      {
      default: 
        this.Zyx.error("optionID type:" + locala.ZAZ + " is not implement");
        AppMethodBeat.o(219515);
        return;
      }
      localObject = this.ZAK;
      i = locala.ZBa;
      if (paramTPOptionalParam.value) {}
      for (long l = 1L;; l = 0L)
      {
        ((TPNativePlayer)localObject).setOptionLong(i, l, 0L);
        AppMethodBeat.o(219515);
        return;
      }
    }
    if (paramTPOptionalParam.getParamType() == 2)
    {
      if (paramTPOptionalParam.getKey() < 500)
      {
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamLong();
        locala = com.tencent.thumbplayer.a.b.b.b.aAR(i);
        if (locala == null)
        {
          this.Zyx.error("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(219515);
          return;
        }
        switch (locala.ZAZ)
        {
        case 2: 
        default: 
          this.Zyx.error("optionID type:" + locala.ZAZ + " is not implement");
          AppMethodBeat.o(219515);
          return;
        case 1: 
          this.ZAL.setLong(locala.ZBa, paramTPOptionalParam.value);
          AppMethodBeat.o(219515);
          return;
        case 4: 
          this.ZAL.setInt(locala.ZBa, (int)paramTPOptionalParam.value);
          AppMethodBeat.o(219515);
          return;
        }
        localObject = this.ZAL;
        i = locala.ZBa;
        if (paramTPOptionalParam.value > 0L) {}
        for (;;)
        {
          ((TPNativePlayerInitConfig)localObject).setBool(i, bool);
          AppMethodBeat.o(219515);
          return;
          bool = false;
        }
      }
      i = paramTPOptionalParam.getKey();
      paramTPOptionalParam = paramTPOptionalParam.getParamLong();
      locala = com.tencent.thumbplayer.a.b.b.b.aAS(i);
      if (locala == null)
      {
        this.Zyx.error("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(219515);
        return;
      }
      switch (locala.ZAZ)
      {
      case 2: 
      default: 
        this.Zyx.error("optionID type:" + locala.ZAZ + " is not implement");
        AppMethodBeat.o(219515);
        return;
      }
      this.ZAK.setOptionLong(locala.ZBa, paramTPOptionalParam.value, paramTPOptionalParam.param1);
      AppMethodBeat.o(219515);
      return;
    }
    if (paramTPOptionalParam.getParamType() == 6)
    {
      if (paramTPOptionalParam.getKey() < 500)
      {
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamFloat();
        locala = com.tencent.thumbplayer.a.b.b.b.aAR(i);
        if (locala == null)
        {
          this.Zyx.error("player optionalIdMapping float is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(219515);
          return;
        }
        if (7 != locala.ZAZ)
        {
          this.Zyx.error("optionID:" + locala.ZBa + " is not float");
          AppMethodBeat.o(219515);
          return;
        }
        this.ZAL.setFloat(locala.ZBa, paramTPOptionalParam.value);
        AppMethodBeat.o(219515);
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
          this.Zyx.error("init string param type is not implement coz native init config no string setting");
          AppMethodBeat.o(219515);
          return;
        }
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamString();
        locala = com.tencent.thumbplayer.a.b.b.b.aAS(i);
        if (locala == null)
        {
          this.Zyx.error("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(219515);
          return;
        }
        switch (locala.ZAZ)
        {
        default: 
          this.Zyx.error("optionID type:" + locala.ZAZ + " is not implement");
          AppMethodBeat.o(219515);
          return;
        }
        this.ZAK.setOptionObject(locala.ZBa, paramTPOptionalParam.value);
        AppMethodBeat.o(219515);
        return;
      }
      if (paramTPOptionalParam.getParamType() == 4)
      {
        if (paramTPOptionalParam.getKey() < 500)
        {
          a(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueInt());
          AppMethodBeat.o(219515);
        }
      }
      else if (paramTPOptionalParam.getParamType() == 5)
      {
        if (paramTPOptionalParam.getKey() < 500)
        {
          a(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueString());
          AppMethodBeat.o(219515);
        }
      }
      else
      {
        this.Zyx.bDz("optionalParam param type is unknown, return");
        AppMethodBeat.o(219515);
        return;
      }
    }
    AppMethodBeat.o(219515);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(219543);
    com.tencent.thumbplayer.f.a locala = this.Zyx;
    StringBuilder localStringBuilder = new StringBuilder("setSurface, surface is null ? : ");
    if (paramSurface == null) {}
    for (boolean bool = true;; bool = false)
    {
      locala.bDy(bool);
      if (this.ZAK != null) {
        break;
      }
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219543);
      return;
    }
    if (this.ZAK.setVideoSurface(paramSurface) != 0)
    {
      paramSurface = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(219543);
      throw paramSurface;
    }
    AppMethodBeat.o(219543);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(219547);
    com.tencent.thumbplayer.f.a locala = this.Zyx;
    StringBuilder localStringBuilder = new StringBuilder("SurfaceHolder, surfaceHolder is null ? : ");
    if (paramSurfaceHolder == null) {}
    for (boolean bool = true;; bool = false)
    {
      locala.bDy(bool);
      if (this.ZAK != null) {
        break;
      }
      this.Zyx.bDz("player has released, return");
      AppMethodBeat.o(219547);
      return;
    }
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder.getSurface() == null))
    {
      this.Zyx.error("SurfaceHolder，err.");
      AppMethodBeat.o(219547);
      return;
    }
    if (paramSurfaceHolder == null) {}
    for (paramSurfaceHolder = null; this.ZAK.setVideoSurface(paramSurfaceHolder) != 0; paramSurfaceHolder = paramSurfaceHolder.getSurface())
    {
      paramSurfaceHolder = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(219547);
      throw paramSurfaceHolder;
    }
    AppMethodBeat.o(219547);
  }
  
  public final void start()
  {
    AppMethodBeat.i(219580);
    this.Zyx.bDy("start");
    iqD();
    if (this.ZAK.start() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("start failed!!");
      AppMethodBeat.o(219580);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219580);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(219583);
    this.Zyx.bDy("stop");
    iqD();
    this.Zyx.bDy("stop before");
    int i = this.ZAK.stop();
    this.Zyx.bDy("stop after");
    if (i != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("stop failed!!");
      AppMethodBeat.o(219583);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(219583);
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(219480);
    this.Zyx.a(new com.tencent.thumbplayer.f.b(paramb, "TPThumbPlayer"));
    if (paramb != null) {
      this.ZAN.bDr(this.Zyx.Zyw.tag);
    }
    AppMethodBeat.o(219480);
  }
  
  final class a
    extends Handler
  {
    private WeakReference<b> sjt;
    
    public a(Looper paramLooper, b paramb)
    {
      super();
      AppMethodBeat.i(219436);
      this.sjt = new WeakReference(paramb);
      AppMethodBeat.o(219436);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(219456);
      if ((b)this.sjt.get() == null)
      {
        b.this.Zyx.error("mWeakRef is null");
        AppMethodBeat.o(219456);
        return;
      }
      Object localObject;
      switch (paramMessage.what)
      {
      default: 
        b.this.Zyx.bDz("message :" + paramMessage.what + "  not recognition");
        AppMethodBeat.o(219456);
        return;
      case 1: 
        paramMessage = (b.b)paramMessage.obj;
        switch (paramMessage.ZAW)
        {
        default: 
          b.this.ZAN.a(com.tencent.thumbplayer.a.b.b.b.aAQ(paramMessage.ZAW), paramMessage.fyO, paramMessage.errorCode, Long.valueOf(paramMessage.Zyu));
          AppMethodBeat.o(219456);
          return;
        case 1: 
          b.this.ZAN.qX();
          AppMethodBeat.o(219456);
          return;
        }
        b.this.ZAN.cYp();
        AppMethodBeat.o(219456);
        return;
      case 2: 
        paramMessage = (b.d)paramMessage.obj;
        switch (paramMessage.infoType)
        {
        default: 
          localObject = b.this;
          i = paramMessage.infoType;
          j = com.tencent.thumbplayer.a.b.b.b.aAQ(i);
          if (j < 0)
          {
            ((b)localObject).Zyx.bDz("msgType:" + i + ", cannot convert to thumbPlayer Info");
            AppMethodBeat.o(219456);
            return;
          }
          break;
        case 250: 
          localObject = b.this;
          l1 = paramMessage.lParam1;
          l2 = paramMessage.ZAX;
          ((b)localObject).ZAN.ba(l1, l2);
          AppMethodBeat.o(219456);
          return;
        case 154: 
          b.this.ZAN.onCompletion();
          AppMethodBeat.o(219456);
          return;
        }
        long l1 = paramMessage.lParam1;
        long l2 = paramMessage.ZAX;
        switch (j)
        {
        }
        for (;;)
        {
          ((b)localObject).ZAN.a(j, l1, l2, null);
          AppMethodBeat.o(219456);
          return;
          l1 = c.aAM((int)paramMessage.lParam1);
        }
      case 3: 
        b.e locale = (b.e)paramMessage.obj;
        b localb;
        switch (locale.infoType)
        {
        default: 
          localb = b.this;
          i = locale.infoType;
          j = com.tencent.thumbplayer.a.b.b.b.aAQ(i);
          if (j < 0)
          {
            localb.Zyx.bDz("msgType:" + i + ", cannot convert to thumbPlayer Info");
            AppMethodBeat.o(219456);
            return;
          }
          break;
        case 502: 
          if (!(locale.ZAY instanceof String)) {
            break label631;
          }
          b.this.ZAP.subtitleData = ((String)locale.ZAY);
          b.this.ZAN.a(b.this.ZAP);
          AppMethodBeat.o(219456);
          return;
        }
        localObject = locale.ZAY;
        paramMessage = (Message)localObject;
        switch (j)
        {
        default: 
          paramMessage = (Message)localObject;
        }
        for (;;)
        {
          localb.ZAN.a(j, 0L, 0L, paramMessage);
          label631:
          AppMethodBeat.o(219456);
          return;
          paramMessage = (Message)localObject;
          if (locale.ZAY != null)
          {
            paramMessage = c.a((ITPNativePlayerMessageCallback.VideoCropInfo)locale.ZAY);
            continue;
            paramMessage = (Message)localObject;
            if (locale.ZAY != null) {
              paramMessage = c.a((ITPNativePlayerMessageCallback.MediaCodecInfo)locale.ZAY);
            }
          }
        }
      }
      paramMessage = (b.c)paramMessage.obj;
      int i = paramMessage.msgType;
      int j = paramMessage.errorCode;
      b.this.ZAN.a(com.tencent.thumbplayer.a.b.b.b.aAP(i), j, 0L, 0L);
      AppMethodBeat.o(219456);
    }
  }
  
  public static final class b
  {
    @TPCommonEnum.NativeMsgInfo
    int ZAW;
    long Zyu;
    int errorCode;
    int fyO;
  }
  
  public static final class c
  {
    int errorCode;
    int msgType;
  }
  
  public static final class d
  {
    long ZAX;
    int infoType;
    long lParam1;
  }
  
  public static final class e
  {
    Object ZAY;
    int infoType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */