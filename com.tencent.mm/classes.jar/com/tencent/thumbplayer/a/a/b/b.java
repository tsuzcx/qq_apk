package com.tencent.thumbplayer.a.a.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Looper;
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
import com.tencent.thumbplayer.api.TPCommonEnum.TPOptionalId;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSurfaceType;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamBoolean;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamFloat;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamInt;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueString;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamString;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPAudioTrackInfo;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.c.g;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import java.util.List;
import java.util.Map;

public final class b
  implements com.tencent.thumbplayer.a.a.b
{
  com.tencent.thumbplayer.f.a ahDA;
  private TPNativePlayer ahFN;
  private TPNativePlayerInitConfig ahFO;
  b.a ahFP;
  com.tencent.thumbplayer.a.e ahFQ;
  private com.tencent.thumbplayer.a.a.a ahFR;
  TPSubtitleData ahFS;
  private ITPNativePlayerMessageCallback ahFT;
  private ITPNativePlayerAudioFrameCallback ahFU;
  private ITPNativePlayerVideoFrameCallback ahFV;
  private ITPNativePlayerSubtitleFrameCallback ahFW;
  private ITPNativePlayerPostProcessFrameCallback ahFX;
  
  public b(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228735);
    this.ahFS = new TPSubtitleData();
    this.ahFT = new b.1(this);
    this.ahFU = new b.2(this);
    this.ahFV = new b.3(this);
    this.ahFW = new b.4(this);
    this.ahFX = new b.5(this);
    this.ahDA = new com.tencent.thumbplayer.f.a(paramb, "TPThumbPlayer");
    this.ahFN = new TPNativePlayer(paramContext);
    this.ahFN.setMessageCallback(this.ahFT);
    this.ahFN.setAudioFrameCallback(this.ahFU);
    this.ahFN.setVideoFrameCallback(this.ahFV);
    this.ahFN.setSubtitleFrameCallback(this.ahFW);
    this.ahFN.setPostProcessFrameCallback(this.ahFX);
    this.ahFO = new TPNativePlayerInitConfig();
    this.ahFQ = new com.tencent.thumbplayer.a.e(this.ahDA.ahDz.tag);
    paramContext = Looper.myLooper();
    if (paramContext != null)
    {
      this.ahFP = new b.a(this, paramContext, this);
      AppMethodBeat.o(228735);
      return;
    }
    paramContext = Looper.getMainLooper();
    if (paramContext != null)
    {
      this.ahFP = new b.a(this, paramContext, this);
      AppMethodBeat.o(228735);
      return;
    }
    this.ahFP = null;
    AppMethodBeat.o(228735);
  }
  
  private void a(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueInt paramOptionalParamQueueInt)
  {
    AppMethodBeat.i(228750);
    c.a locala = com.tencent.thumbplayer.a.b.b.b.aHE(paramInt);
    if (locala == null)
    {
      this.ahDA.error("player optionalIdMapping queue_int is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(228750);
      return;
    }
    if ((paramOptionalParamQueueInt.queueValue == null) || (paramOptionalParamQueueInt.queueValue.length == 0))
    {
      this.ahDA.error("queueint params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(228750);
      return;
    }
    switch (locala.ahGc)
    {
    default: 
      this.ahDA.error("optionID type:" + locala.ahGc + " is not implement");
      AppMethodBeat.o(228750);
      return;
    }
    paramInt = 0;
    while (paramInt < paramOptionalParamQueueInt.queueValue.length)
    {
      this.ahFO.addQueueInt(locala.ahGd, paramOptionalParamQueueInt.queueValue[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(228750);
  }
  
  private void a(@TPCommonEnum.TPOptionalId int paramInt, TPOptionalParam.OptionalParamQueueString paramOptionalParamQueueString)
  {
    AppMethodBeat.i(228751);
    c.a locala = com.tencent.thumbplayer.a.b.b.b.aHE(paramInt);
    if (locala == null)
    {
      this.ahDA.error("player optionalIdMapping queue_string is invalid, not found in array, id: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(228751);
      return;
    }
    if ((paramOptionalParamQueueString.queueValue == null) || (paramOptionalParamQueueString.queueValue.length == 0))
    {
      this.ahDA.error("queue String params is empty in".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(228751);
      return;
    }
    switch (locala.ahGc)
    {
    default: 
      this.ahDA.error("optionID type:" + locala.ahGc + " is not implement");
      AppMethodBeat.o(228751);
      return;
    }
    paramInt = 0;
    while (paramInt < paramOptionalParamQueueString.queueValue.length)
    {
      this.ahFO.addQueueString(locala.ahGd, paramOptionalParamQueueString.queueValue[paramInt]);
      paramInt += 1;
    }
    AppMethodBeat.o(228751);
  }
  
  private void jZY()
  {
    AppMethodBeat.i(228754);
    if (this.ahFN == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("player has release");
      AppMethodBeat.o(228754);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228754);
  }
  
  public final void N(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(228907);
    this.ahDA.bGe("switchDefinition url:" + paramString + " opaque:" + paramLong);
    jZY();
    paramInt = com.tencent.thumbplayer.a.b.b.b.aHB(paramInt);
    if (this.ahFN.switchDefinitionAsync(paramString, paramInt, paramLong) != 0)
    {
      paramString = new IllegalStateException("switchDefinition in invalid state");
      AppMethodBeat.o(228907);
      throw paramString;
    }
    this.ahFR = new com.tencent.thumbplayer.b.d(paramString);
    AppMethodBeat.o(228907);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(228792);
    this.ahFQ.b(parama);
    AppMethodBeat.o(228792);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(228798);
    this.ahFQ.b(paramb);
    AppMethodBeat.o(228798);
  }
  
  public final void a(c.c paramc)
  {
    AppMethodBeat.i(228764);
    this.ahFQ.a(paramc);
    AppMethodBeat.o(228764);
  }
  
  public final void a(c.d paramd)
  {
    AppMethodBeat.i(228772);
    this.ahFQ.a(paramd);
    AppMethodBeat.o(228772);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(228768);
    this.ahFQ.a(parame);
    AppMethodBeat.o(228768);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(228762);
    this.ahFQ.a(paramf);
    AppMethodBeat.o(228762);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(228774);
    this.ahFQ.a(paramg);
    AppMethodBeat.o(228774);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(228782);
    this.ahFQ.a(parami);
    AppMethodBeat.o(228782);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(228788);
    this.ahFQ.a(paramj);
    AppMethodBeat.o(228788);
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(228791);
    this.ahFQ.a(paramk);
    AppMethodBeat.o(228791);
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(228794);
    this.ahFQ.b(paraml);
    AppMethodBeat.o(228794);
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(228778);
    this.ahFQ.a(paramm);
    AppMethodBeat.o(228778);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(228912);
    this.ahDA.bGe("switchDefinition mediaAsset:" + paramITPMediaAsset + " opaque:" + paramLong);
    jZY();
    if (paramITPMediaAsset != null)
    {
      paramInt = com.tencent.thumbplayer.a.b.b.b.aHB(paramInt);
      if (this.ahFN.switchDefinitionAsync(paramITPMediaAsset.getUrl(), paramInt, paramLong) != 0)
      {
        paramITPMediaAsset = new IllegalStateException("switchDefinition in invalid state");
        AppMethodBeat.o(228912);
        throw paramITPMediaAsset;
      }
      this.ahFR = new com.tencent.thumbplayer.b.d(paramITPMediaAsset.getUrl());
    }
    AppMethodBeat.o(228912);
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228839);
    this.ahDA.bGe("addSubtitleSource");
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228839);
      return;
    }
    this.ahFN.addSubtitleTrackSource(paramString1, paramString3);
    AppMethodBeat.o(228839);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(228981);
    this.ahDA.bGe("captureVideo, params".concat(String.valueOf(paramTPCaptureParams)));
    if (this.ahFR != null)
    {
      TPImageGeneratorParams localTPImageGeneratorParams = new TPImageGeneratorParams();
      localTPImageGeneratorParams.width = paramTPCaptureParams.width;
      localTPImageGeneratorParams.height = paramTPCaptureParams.height;
      localTPImageGeneratorParams.format = paramTPCaptureParams.format;
      localTPImageGeneratorParams.requestedTimeMsToleranceAfter = paramTPCaptureParams.requestedTimeMsToleranceAfter;
      localTPImageGeneratorParams.requestedTimeMsToleranceBefore = paramTPCaptureParams.requestedTimeMsToleranceBefore;
      this.ahFR.a(getCurrentPositionMs(), localTPImageGeneratorParams, paramTPCaptureCallBack);
      AppMethodBeat.o(228981);
      return;
    }
    paramTPCaptureCallBack.onCaptureVideoFailed(1000013);
    AppMethodBeat.o(228981);
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228855);
    this.ahDA.bGe("selectTrack");
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228855);
      return;
    }
    this.ahFN.deselectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(228855);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(228954);
    if (this.ahFN == null)
    {
      this.ahDA.bGe("player has released, return 0");
      AppMethodBeat.o(228954);
      return 0L;
    }
    long l = this.ahFN.getCurrentPositionMs();
    AppMethodBeat.o(228954);
    return l;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(228952);
    if (this.ahFN == null)
    {
      this.ahDA.bGe("player has released, return 0");
      AppMethodBeat.o(228952);
      return 0L;
    }
    long l = this.ahFN.getDurationMs();
    AppMethodBeat.o(228952);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(228959);
    if (this.ahFN == null)
    {
      this.ahDA.bGe("player has released, return 0");
      AppMethodBeat.o(228959);
      return 0L;
    }
    long l1 = this.ahFN.getBufferedDurationMs();
    long l2 = this.ahFN.getCurrentPositionMs();
    AppMethodBeat.o(228959);
    return l1 + l2;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(228977);
    this.ahDA.bGe("getProgramInfo");
    if (this.ahFN == null)
    {
      this.ahDA.bGe("player has released, return 0");
      AppMethodBeat.o(228977);
      return null;
    }
    TPNativePlayerProgramInfo[] arrayOfTPNativePlayerProgramInfo = this.ahFN.getProgramInfo();
    if ((arrayOfTPNativePlayerProgramInfo == null) || (arrayOfTPNativePlayerProgramInfo.length <= 0))
    {
      AppMethodBeat.o(228977);
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
    AppMethodBeat.o(228977);
    return arrayOfTPProgramInfo;
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(228946);
    this.ahDA.bGe("getPropertyLong:".concat(String.valueOf(paramInt)));
    jZY();
    paramInt = com.tencent.thumbplayer.a.b.b.b.aHI(paramInt);
    if (paramInt < 0)
    {
      this.ahDA.bGf("paramId not found, return -1");
      AppMethodBeat.o(228946);
      return -1L;
    }
    long l = this.ahFN.getPropertyLong(paramInt);
    AppMethodBeat.o(228946);
    return l;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(228948);
    this.ahDA.bGe("getPropertyString:".concat(String.valueOf(paramInt)));
    jZY();
    int i;
    try
    {
      i = com.tencent.thumbplayer.a.b.b.b.aHI(paramInt);
      if (i < 0)
      {
        this.ahDA.bGf("getPropertyString, convertToNativePropertyId(" + paramInt + "), return" + i);
        AppMethodBeat.o(228948);
        return "";
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.ahDA.bGf("paramId not found, return");
      AppMethodBeat.o(228948);
      return "";
    }
    String str = this.ahFN.getPropertyString(i);
    AppMethodBeat.o(228948);
    return str;
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(228971);
    this.ahDA.bGe("getTrackInfo");
    if (this.ahFN == null)
    {
      this.ahDA.bGe("player has released, return 0");
      AppMethodBeat.o(228971);
      return null;
    }
    TPMediaTrackInfo[] arrayOfTPMediaTrackInfo = this.ahFN.getTrackInfo();
    if ((arrayOfTPMediaTrackInfo == null) || (arrayOfTPMediaTrackInfo.length <= 0))
    {
      AppMethodBeat.o(228971);
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
    AppMethodBeat.o(228971);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(228964);
    this.ahDA.bGe("getVideoHeight");
    if (this.ahFN == null)
    {
      this.ahDA.bGe("player has released, return 0");
      AppMethodBeat.o(228964);
      return 0;
    }
    int i = this.ahFN.getVideoHeight();
    AppMethodBeat.o(228964);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(228962);
    this.ahDA.bGe("getVideoWidth");
    if (this.ahFN == null)
    {
      this.ahDA.bGe("player has released, return 0");
      AppMethodBeat.o(228962);
      return 0;
    }
    int i = this.ahFN.getVideoWidth();
    AppMethodBeat.o(228962);
    return i;
  }
  
  public final void j(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(228848);
    this.ahDA.bGe("addAudioTrackSource");
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228848);
      return;
    }
    paramList = new TPPlayerMsg.TPAudioTrackInfo();
    paramList.audioTrackUrl = paramString1;
    paramString1 = this.ahFQ;
    if (paramString1 != null) {
      paramString1.a(1012, 0L, 0L, paramList);
    }
    this.ahFN.addAudioTrackSource(paramList.proxyUrl, paramString2);
    AppMethodBeat.o(228848);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(228878);
    this.ahDA.bGe("pause");
    jZY();
    if (this.ahFN.pause() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("pause failed!!");
      AppMethodBeat.o(228878);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228878);
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(228859);
    this.ahDA.bGe("prepare");
    jZY();
    this.ahFN.setInitConfig(this.ahFO);
    if (this.ahFN.prepare() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepare failed!!");
      AppMethodBeat.o(228859);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228859);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(228864);
    this.ahDA.bGe("prepareAsync");
    jZY();
    this.ahFN.setInitConfig(this.ahFO);
    if (this.ahFN.prepareAsync() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("prepareAsync failed!!");
      AppMethodBeat.o(228864);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228864);
  }
  
  public final void release()
  {
    AppMethodBeat.i(228892);
    this.ahDA.bGe("release");
    if (this.ahFN != null)
    {
      this.ahFN.release();
      this.ahFN = null;
    }
    if (this.ahFR != null)
    {
      this.ahFR.release();
      this.ahFR = null;
    }
    AppMethodBeat.o(228892);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(228889);
    this.ahDA.bGe("reset");
    if (this.ahFN == null)
    {
      this.ahDA.bGf("reset, player has released.");
      AppMethodBeat.o(228889);
      return;
    }
    this.ahDA.bGe("reset before");
    this.ahFN.reset();
    this.ahDA.bGe("reset after");
    AppMethodBeat.o(228889);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(228895);
    this.ahDA.bGe("seekTo:".concat(String.valueOf(paramInt)));
    jZY();
    if (this.ahFN.seekToAsync(paramInt, 1, 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt + " failed!!");
      AppMethodBeat.o(228895);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228895);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(228901);
    this.ahDA.bGe("seekTo:" + paramInt1 + " mode:" + paramInt2);
    jZY();
    if (this.ahFN.seekToAsync(paramInt1, com.tencent.thumbplayer.a.b.b.b.aHz(paramInt2), 0L) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("seek to position:" + paramInt1 + " failed!!");
      AppMethodBeat.o(228901);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228901);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228973);
    this.ahDA.bGe("selectProgram, programIndex:".concat(String.valueOf(paramInt)));
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228973);
      return;
    }
    this.ahFN.selectProgramAsync(paramInt, paramLong);
    AppMethodBeat.o(228973);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228851);
    this.ahDA.bGe("selectTrack");
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228851);
      return;
    }
    this.ahFN.selectTrackAsync(paramInt, paramLong);
    AppMethodBeat.o(228851);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(228918);
    this.ahDA.bGe("setAudioGainRatio:".concat(String.valueOf(paramFloat)));
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228918);
      return;
    }
    this.ahFN.setAudioVolume(paramFloat);
    AppMethodBeat.o(228918);
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(228922);
    this.ahDA.bGe("setAudioNormalizeVolumeParams:".concat(String.valueOf(paramString)));
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228922);
      return;
    }
    this.ahFN.setAudioNormalizeVolumeParams(paramString);
    AppMethodBeat.o(228922);
  }
  
  public final void setDataSource(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(228827);
    if (paramAssetFileDescriptor == null)
    {
      paramAssetFileDescriptor = new IllegalStateException("setDataSource url afd is null!!");
      AppMethodBeat.o(228827);
      throw paramAssetFileDescriptor;
    }
    int i = paramAssetFileDescriptor.getParcelFileDescriptor().detachFd();
    long l1 = paramAssetFileDescriptor.getStartOffset();
    long l2 = paramAssetFileDescriptor.getDeclaredLength();
    this.ahDA.bGe("setDataSource: " + paramAssetFileDescriptor + ", fd: " + i + ", offset: " + l1 + ", length:" + l2);
    paramAssetFileDescriptor.close();
    jZY();
    if (this.ahFN.setDataSource(i, l1, l2) != 0)
    {
      paramAssetFileDescriptor = new IllegalStateException("setDataSource url afd failed!!");
      AppMethodBeat.o(228827);
      throw paramAssetFileDescriptor;
    }
    this.ahFR = new com.tencent.thumbplayer.b.d(i);
    AppMethodBeat.o(228827);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(228822);
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalStateException("setDataSource url pfd is null!!");
      AppMethodBeat.o(228822);
      throw paramParcelFileDescriptor;
    }
    int i = paramParcelFileDescriptor.detachFd();
    paramParcelFileDescriptor.close();
    this.ahDA.bGe("setDataSource: " + paramParcelFileDescriptor + ", fd:" + i);
    jZY();
    if (this.ahFN.setDataSource(i, 0L, 0L) != 0)
    {
      paramParcelFileDescriptor = new IllegalStateException("setDataSource url pfd failed!!");
      AppMethodBeat.o(228822);
      throw paramParcelFileDescriptor;
    }
    this.ahFR = new com.tencent.thumbplayer.b.d(i);
    AppMethodBeat.o(228822);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(228833);
    this.ahDA.bGe("setDataSource: ".concat(String.valueOf(paramITPMediaAsset)));
    jZY();
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalStateException("media asset is null!");
      AppMethodBeat.o(228833);
      throw paramITPMediaAsset;
    }
    if ((!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.d)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.e)) && (!(paramITPMediaAsset instanceof g)))
    {
      paramITPMediaAsset = new IllegalStateException("media asset is illegal source!");
      AppMethodBeat.o(228833);
      throw paramITPMediaAsset;
    }
    paramITPMediaAsset = paramITPMediaAsset.getUrl();
    if (this.ahFN.setDataSource(paramITPMediaAsset) != 0)
    {
      paramITPMediaAsset = new IllegalStateException("setDataSource mediaAsset failed!!");
      AppMethodBeat.o(228833);
      throw paramITPMediaAsset;
    }
    this.ahFR = new com.tencent.thumbplayer.b.d(paramITPMediaAsset);
    AppMethodBeat.o(228833);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228814);
    this.ahDA.bGe("setDataSource: ".concat(String.valueOf(paramString)));
    jZY();
    if (this.ahFN.setDataSource(paramString, paramMap) != 0)
    {
      paramString = new IllegalStateException("setDataSource url and header failed!!");
      AppMethodBeat.o(228814);
      throw paramString;
    }
    this.ahFR = new com.tencent.thumbplayer.b.d(paramString);
    AppMethodBeat.o(228814);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(228936);
    this.ahDA.bGe("setLoopback:".concat(String.valueOf(paramBoolean)));
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228936);
      return;
    }
    this.ahFN.setLoopback(paramBoolean, 0L, -1L);
    AppMethodBeat.o(228936);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228939);
    this.ahDA.bGe("setLoopback:" + paramBoolean + " loopStartPositionMs:" + paramLong1 + " loopEndPositionMs:" + paramLong2);
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228939);
      return;
    }
    if (this.ahFN.setLoopback(paramBoolean, paramLong1, paramLong2) != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("set loopback failed!!");
      AppMethodBeat.o(228939);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228939);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(228916);
    this.ahDA.bGe("setOutputMute:".concat(String.valueOf(paramBoolean)));
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228916);
      return;
    }
    this.ahFN.setAudioMute(paramBoolean);
    AppMethodBeat.o(228916);
  }
  
  public final void setPlaySharpenSwitch()
  {
    AppMethodBeat.i(228933);
    this.ahDA.bGe("setPlaySharpenSwitch");
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228933);
      return;
    }
    this.ahFN.setPlaySharpenSwitch();
    AppMethodBeat.o(228933);
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(228929);
    this.ahDA.bGe("setPlaySpeedRatio:".concat(String.valueOf(paramFloat)));
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228929);
      return;
    }
    this.ahFN.setPlaybackRate(paramFloat);
    AppMethodBeat.o(228929);
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    boolean bool = true;
    AppMethodBeat.i(228759);
    this.ahDA.bGe("setPlayerOptionalParam:".concat(String.valueOf(paramTPOptionalParam)));
    if (this.ahFN == null)
    {
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228759);
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
        locala = com.tencent.thumbplayer.a.b.b.b.aHE(i);
        if (locala == null)
        {
          this.ahDA.error("player optionalIdMapping boolean is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(228759);
          return;
        }
        switch (locala.ahGc)
        {
        default: 
          this.ahDA.error("optionID type:" + locala.ahGc + " is not implement");
          AppMethodBeat.o(228759);
          return;
        }
        this.ahFO.setBool(locala.ahGd, paramTPOptionalParam.value);
        AppMethodBeat.o(228759);
        return;
      }
      i = paramTPOptionalParam.getKey();
      paramTPOptionalParam = paramTPOptionalParam.getParamBoolean();
      locala = com.tencent.thumbplayer.a.b.b.b.aHF(i);
      if (locala == null)
      {
        this.ahDA.error("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(228759);
        return;
      }
      switch (locala.ahGc)
      {
      default: 
        this.ahDA.error("optionID type:" + locala.ahGc + " is not implement");
        AppMethodBeat.o(228759);
        return;
      }
      localObject = this.ahFN;
      i = locala.ahGd;
      if (paramTPOptionalParam.value) {}
      for (long l = 1L;; l = 0L)
      {
        ((TPNativePlayer)localObject).setOptionLong(i, l, 0L);
        AppMethodBeat.o(228759);
        return;
      }
    }
    if (paramTPOptionalParam.getParamType() == 2)
    {
      if (paramTPOptionalParam.getKey() < 500)
      {
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamLong();
        locala = com.tencent.thumbplayer.a.b.b.b.aHE(i);
        if (locala == null)
        {
          this.ahDA.error("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(228759);
          return;
        }
        switch (locala.ahGc)
        {
        case 2: 
        default: 
          this.ahDA.error("optionID type:" + locala.ahGc + " is not implement");
          AppMethodBeat.o(228759);
          return;
        case 1: 
          this.ahFO.setLong(locala.ahGd, paramTPOptionalParam.value);
          AppMethodBeat.o(228759);
          return;
        case 4: 
          this.ahFO.setInt(locala.ahGd, (int)paramTPOptionalParam.value);
          AppMethodBeat.o(228759);
          return;
        }
        localObject = this.ahFO;
        i = locala.ahGd;
        if (paramTPOptionalParam.value > 0L) {}
        for (;;)
        {
          ((TPNativePlayerInitConfig)localObject).setBool(i, bool);
          AppMethodBeat.o(228759);
          return;
          bool = false;
        }
      }
      i = paramTPOptionalParam.getKey();
      paramTPOptionalParam = paramTPOptionalParam.getParamLong();
      locala = com.tencent.thumbplayer.a.b.b.b.aHF(i);
      if (locala == null)
      {
        this.ahDA.error("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(228759);
        return;
      }
      switch (locala.ahGc)
      {
      case 2: 
      default: 
        this.ahDA.error("optionID type:" + locala.ahGc + " is not implement");
        AppMethodBeat.o(228759);
        return;
      }
      this.ahFN.setOptionLong(locala.ahGd, paramTPOptionalParam.value, paramTPOptionalParam.param1);
      AppMethodBeat.o(228759);
      return;
    }
    if (paramTPOptionalParam.getParamType() == 6)
    {
      if (paramTPOptionalParam.getKey() < 500)
      {
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamFloat();
        locala = com.tencent.thumbplayer.a.b.b.b.aHE(i);
        if (locala == null)
        {
          this.ahDA.error("player optionalIdMapping float is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(228759);
          return;
        }
        if (7 != locala.ahGc)
        {
          this.ahDA.error("optionID:" + locala.ahGd + " is not float");
          AppMethodBeat.o(228759);
          return;
        }
        this.ahFO.setFloat(locala.ahGd, paramTPOptionalParam.value);
        AppMethodBeat.o(228759);
      }
    }
    else if (paramTPOptionalParam.getParamType() == 7)
    {
      if (paramTPOptionalParam.getKey() < 500)
      {
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamInt();
        locala = com.tencent.thumbplayer.a.b.b.b.aHE(i);
        if (locala == null)
        {
          this.ahDA.error("player optionalIdMapping int is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(228759);
          return;
        }
        if (4 != locala.ahGc)
        {
          this.ahDA.error("optionID:" + locala.ahGd + " is not int");
          AppMethodBeat.o(228759);
          return;
        }
        this.ahFO.setInt(locala.ahGd, paramTPOptionalParam.value);
        AppMethodBeat.o(228759);
      }
    }
    else
    {
      if (paramTPOptionalParam.getParamType() == 3)
      {
        if (paramTPOptionalParam.getKey() < 500)
        {
          i = paramTPOptionalParam.getKey();
          paramTPOptionalParam = paramTPOptionalParam.getParamString();
          locala = com.tencent.thumbplayer.a.b.b.b.aHE(i);
          if (locala == null)
          {
            this.ahDA.error("player optionalIdMapping int is invalid, not found in array, id: ".concat(String.valueOf(i)));
            AppMethodBeat.o(228759);
            return;
          }
          if (2 != locala.ahGc)
          {
            this.ahDA.error("optionID:" + locala.ahGd + " is not string");
            AppMethodBeat.o(228759);
            return;
          }
          this.ahFO.setString(locala.ahGd, paramTPOptionalParam.value);
          AppMethodBeat.o(228759);
          return;
        }
        i = paramTPOptionalParam.getKey();
        paramTPOptionalParam = paramTPOptionalParam.getParamString();
        locala = com.tencent.thumbplayer.a.b.b.b.aHF(i);
        if (locala == null)
        {
          this.ahDA.error("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
          AppMethodBeat.o(228759);
          return;
        }
        switch (locala.ahGc)
        {
        default: 
          this.ahDA.error("optionID type:" + locala.ahGc + " is not implement");
          AppMethodBeat.o(228759);
          return;
        }
        this.ahFN.setOptionObject(locala.ahGd, paramTPOptionalParam.value);
        AppMethodBeat.o(228759);
        return;
      }
      if (paramTPOptionalParam.getParamType() == 4)
      {
        if (paramTPOptionalParam.getKey() < 500)
        {
          a(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueInt());
          AppMethodBeat.o(228759);
        }
      }
      else if (paramTPOptionalParam.getParamType() == 5)
      {
        if (paramTPOptionalParam.getKey() < 500)
        {
          a(paramTPOptionalParam.getKey(), paramTPOptionalParam.getParamQueueString());
          AppMethodBeat.o(228759);
        }
      }
      else
      {
        this.ahDA.bGf("optionalParam param type is unknown, return");
        AppMethodBeat.o(228759);
        return;
      }
    }
    AppMethodBeat.o(228759);
  }
  
  public final void setSurface(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt)
  {
    AppMethodBeat.i(228803);
    com.tencent.thumbplayer.f.a locala = this.ahDA;
    StringBuilder localStringBuilder = new StringBuilder("setSurface, surface is null ? : ");
    if (paramSurface == null) {}
    for (boolean bool = true;; bool = false)
    {
      locala.bGe(bool);
      if (this.ahFN != null) {
        break;
      }
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228803);
      return;
    }
    if (this.ahFN.setVideoSurfaceWithType(paramSurface, com.tencent.thumbplayer.a.b.b.b.aHA(paramInt)) != 0)
    {
      paramSurface = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(228803);
      throw paramSurface;
    }
    AppMethodBeat.o(228803);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(228809);
    com.tencent.thumbplayer.f.a locala = this.ahDA;
    StringBuilder localStringBuilder = new StringBuilder("SurfaceHolder, surfaceHolder is null ? : ");
    if (paramSurfaceHolder == null) {}
    for (boolean bool = true;; bool = false)
    {
      locala.bGe(bool);
      if (this.ahFN != null) {
        break;
      }
      this.ahDA.bGf("player has released, return");
      AppMethodBeat.o(228809);
      return;
    }
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder.getSurface() == null))
    {
      this.ahDA.error("SurfaceHolder，err.");
      AppMethodBeat.o(228809);
      return;
    }
    if (paramSurfaceHolder == null) {}
    for (paramSurfaceHolder = null; this.ahFN.setVideoSurface(paramSurfaceHolder) != 0; paramSurfaceHolder = paramSurfaceHolder.getSurface())
    {
      paramSurfaceHolder = new IllegalStateException("setSurface failed!!");
      AppMethodBeat.o(228809);
      throw paramSurfaceHolder;
    }
    AppMethodBeat.o(228809);
  }
  
  public final void start()
  {
    AppMethodBeat.i(228874);
    this.ahDA.bGe("start");
    jZY();
    if (this.ahFN.start() != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("start failed!!");
      AppMethodBeat.o(228874);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228874);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(228884);
    this.ahDA.bGe("stop");
    jZY();
    this.ahDA.bGe("stop before");
    int i = this.ahFN.stop();
    this.ahDA.bGe("stop after");
    if (i != 0)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("stop failed!!");
      AppMethodBeat.o(228884);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(228884);
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228755);
    this.ahDA.a(new com.tencent.thumbplayer.f.b(paramb, "TPThumbPlayer"));
    if (paramb != null) {
      this.ahFQ.ayz(this.ahDA.ahDz.tag);
    }
    AppMethodBeat.o(228755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.b.b
 * JD-Core Version:    0.7.0.1
 */