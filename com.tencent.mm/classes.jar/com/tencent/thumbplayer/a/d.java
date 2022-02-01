package com.tencent.thumbplayer.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.h;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.a.a.c.k;
import com.tencent.thumbplayer.a.a.c.l;
import com.tencent.thumbplayer.a.a.c.m;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPPlayerState;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d
  implements a, c.h
{
  com.tencent.thumbplayer.f.b RVM;
  com.tencent.thumbplayer.f.a RVN;
  com.tencent.thumbplayer.a.a.b RVO;
  TPPlayerState RVP;
  boolean RVQ;
  e RVR;
  private a RVS;
  c RVT;
  g RVU;
  com.tencent.thumbplayer.a.b.a RVV;
  b RVW;
  int RVX;
  private Context mContext;
  
  public d(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(188632);
    this.RVM = new com.tencent.thumbplayer.f.b(paramb, "TPPlayerAdapter");
    this.RVN = new com.tencent.thumbplayer.f.a(this.RVM);
    this.mContext = paramContext;
    this.RVP = new TPPlayerState();
    this.RVP.setOnPlayerStateChangeListener(this);
    this.RVT = new c();
    this.RVS = new a((byte)0);
    this.RVR = new e(this.RVM.tag);
    this.RVU = new g(this.RVP);
    this.RVW = new b();
    AppMethodBeat.o(188632);
  }
  
  private static com.tencent.thumbplayer.a.b.a a(c paramc)
  {
    AppMethodBeat.i(188692);
    try
    {
      paramc = new com.tencent.thumbplayer.a.b.a.a(paramc);
      if (paramc.RYw)
      {
        paramc = new com.tencent.thumbplayer.a.b.d(paramc);
        AppMethodBeat.o(188692);
        return paramc;
      }
    }
    catch (IllegalArgumentException paramc)
    {
      for (;;)
      {
        paramc = new com.tencent.thumbplayer.a.b.a.a(null);
      }
      paramc = new com.tencent.thumbplayer.a.b.c(paramc);
      AppMethodBeat.o(188692);
    }
    return paramc;
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(188691);
    paramb.a(this.RVS);
    paramb.a(this.RVS);
    paramb.a(this.RVS);
    paramb.a(this.RVS);
    paramb.a(this.RVS);
    paramb.a(this.RVS);
    paramb.a(this.RVS);
    if (hmQ())
    {
      paramb.a(this.RVS);
      paramb.a(this.RVS);
      paramb.a(this.RVS);
      paramb.a(this.RVS);
      paramb.a(this.RVS);
    }
    if (1 == this.RVT.RVy.mType)
    {
      paramb.setDataSource(this.RVT.RVy.RWn);
      localObject1 = this.RVT.hmO().iterator();
    }
    Object localObject2;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label387;
      }
      localObject2 = (TPOptionalParam)((Iterator)localObject1).next();
      if ((com.tencent.thumbplayer.a.b.b.b.are(((TPOptionalParam)localObject2).getKey()) == null) && (com.tencent.thumbplayer.a.b.b.b.arf(((TPOptionalParam)localObject2).getKey()) == null))
      {
        this.RVN.warn("init param=[" + localObject2 + "] is not valid native param");
        continue;
        if (3 == this.RVT.RVy.mType)
        {
          if (this.RVX == 2)
          {
            paramb.setDataSource(this.RVT.RVy.RWq.RWt, this.RVT.RVy.RWo);
            break;
          }
          if (this.RVX != 1) {
            break;
          }
          paramb.setDataSource(this.RVT.RVy.RWq.RWs, this.RVT.RVy.RWo);
          break;
        }
        if (2 != this.RVT.RVy.mType) {
          break;
        }
        paramb.setDataSource(this.RVT.RVy.RWp);
        break;
      }
      paramb.setPlayerOptionalParam((TPOptionalParam)localObject2);
    }
    label387:
    int i = 0;
    Object localObject3;
    if (i < this.RVT.RVF.size())
    {
      localObject1 = (TPTrackInfo)this.RVT.RVF.get(i);
      if (((TPTrackInfo)localObject1).trackType == 3)
      {
        localObject2 = this.RVT.hmM().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (c.d)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((c.d)localObject3).name)) && (((c.d)localObject3).name.equals(((TPTrackInfo)localObject1).name)))
          {
            paramb.addSubtitleSource(((c.d)localObject3).url, ((c.d)localObject3).mimeType, ((c.d)localObject3).name);
            label508:
            break label538;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((TPTrackInfo)localObject1).trackType == 2)
        {
          localObject2 = this.RVT.hmN().iterator();
          label538:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (c.a)((Iterator)localObject2).next();
            if ((TextUtils.isEmpty(((c.a)localObject3).name)) || (!((c.a)localObject3).name.equals(((TPTrackInfo)localObject1).name))) {
              break label508;
            }
            paramb.g(((c.a)localObject3).url, ((c.a)localObject3).name, ((c.a)localObject3).RVH);
          }
        }
      }
    }
    Object localObject1 = this.RVT.RVw.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.c)((Iterator)localObject1).next();
      if (((c.c)localObject2).RVL.isSelected)
      {
        localObject3 = paramb.getTrackInfo();
        if (localObject3 == null)
        {
          this.RVN.error("playerTrackInfoList is null.");
        }
        else
        {
          i = 0;
          while (i < localObject3.length)
          {
            if (((c.c)localObject2).RVL.name.equals(localObject3[i].name)) {
              paramb.selectTrack(i, ((c.c)localObject2).RVK);
            }
            i += 1;
          }
        }
      }
    }
    if (this.RVT.RVz != null) {
      paramb.setLoopback(this.RVT.RVz.RVI, this.RVT.RVz.startPositionMs, this.RVT.RVz.RVJ);
    }
    paramb.setOutputMute(this.RVT.RVA);
    if (this.RVT.RVB != 0.0F) {
      paramb.setAudioGainRatio(this.RVT.RVB);
    }
    if (this.RVT.RVD != 0.0F) {
      paramb.setPlaySpeedRatio(this.RVT.RVD);
    }
    if (!"".equals(this.RVT.RVC)) {
      paramb.setAudioNormalizeVolumeParams(this.RVT.RVC);
    }
    if ((this.RVT.RVt instanceof SurfaceHolder)) {
      paramb.setSurfaceHolder((SurfaceHolder)this.RVT.RVt);
    }
    for (;;)
    {
      paramb.setPlayerOptionalParam(new TPOptionalParam().buildQueueInt(204, this.RVV.hnd()));
      AppMethodBeat.o(188691);
      return;
      if ((this.RVT.RVt instanceof Surface)) {
        paramb.setSurface((Surface)this.RVT.RVt);
      }
    }
  }
  
  private int hmP()
  {
    AppMethodBeat.i(188689);
    if (this.RVV == null) {
      this.RVV = a(this.RVT);
    }
    int i = this.RVV.a(this.RVW);
    AppMethodBeat.o(188689);
    return i;
  }
  
  public final void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  final com.tencent.thumbplayer.a.a.b a(int paramInt, com.tencent.thumbplayer.f.b paramb)
  {
    int i = 1;
    AppMethodBeat.i(188690);
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.RVN.info("to create androidPlayer");
        localContext = this.mContext;
        c localc = this.RVT;
        if (localc.RVy == null) {
          continue;
        }
        if (localc.RVy.mType != 2) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramb = new com.tencent.thumbplayer.a.a.a.d(localContext, paramb);
      }
      catch (Exception paramb)
      {
        Context localContext;
        this.RVN.info("to create Player," + paramb.toString());
        paramb = null;
        continue;
      }
      if (paramb != null) {
        break;
      }
      this.RVN.info("play is null!");
      AppMethodBeat.o(188690);
      return null;
      i = 0;
      continue;
      i = 0;
      continue;
      paramb = new com.tencent.thumbplayer.a.a.a.e(localContext, paramb);
      continue;
      if (paramInt == 2)
      {
        this.RVN.info("to create thumbPlayer");
        paramb = com.tencent.thumbplayer.a.a.d.a(this.mContext, paramb);
      }
      else if (paramInt == 3)
      {
        this.RVN.info("to create thumbPlayer software dec");
        paramb = com.tencent.thumbplayer.a.a.d.a(this.mContext, paramb);
      }
      else
      {
        this.RVN.info("to create no Player");
        paramb = null;
      }
    }
    this.RVX = paramInt;
    a(paramb);
    AppMethodBeat.o(188690);
    return paramb;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(188686);
    this.RVR.b(parama);
    AppMethodBeat.o(188686);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    AppMethodBeat.i(188688);
    this.RVR.b(paramb);
    AppMethodBeat.o(188688);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    AppMethodBeat.i(188678);
    this.RVR.a(paramc);
    AppMethodBeat.o(188678);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    AppMethodBeat.i(188680);
    this.RVR.a(paramd);
    AppMethodBeat.o(188680);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(188679);
    this.RVR.a(parame);
    AppMethodBeat.o(188679);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(188677);
    this.RVR.a(paramf);
    AppMethodBeat.o(188677);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(188681);
    this.RVR.a(paramg);
    AppMethodBeat.o(188681);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(188683);
    this.RVR.a(parami);
    AppMethodBeat.o(188683);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(188684);
    this.RVR.a(paramj);
    AppMethodBeat.o(188684);
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(188685);
    this.RVR.a(paramk);
    AppMethodBeat.o(188685);
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(188687);
    this.RVR.b(paraml);
    AppMethodBeat.o(188687);
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(188682);
    this.RVR.a(paramm);
    AppMethodBeat.o(188682);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame)
  {
    AppMethodBeat.i(188637);
    a(parame, null);
    AppMethodBeat.o(188637);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame, int paramInt, long paramLong)
  {
    AppMethodBeat.i(188658);
    if (!this.RVU.aqS(17))
    {
      parame = new IllegalStateException("error , switch definition , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188658);
      throw parame;
    }
    this.RVT.a(parame, null);
    if (this.RVO != null)
    {
      String str = "";
      if (this.RVX == 2) {
        str = parame.RWt;
      }
      for (;;)
      {
        this.RVO.L(str, paramInt, paramLong);
        AppMethodBeat.o(188658);
        return;
        if (this.RVX == 1) {
          str = parame.RWs;
        }
      }
    }
    this.RVN.warn("switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(188658);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188638);
    if (!this.RVU.aqS(2))
    {
      parame = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(188638);
      throw parame;
    }
    if (parame == null)
    {
      parame = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(188638);
      throw parame;
    }
    this.RVT.a(parame, paramMap);
    this.RVP.changeState(2);
    AppMethodBeat.o(188638);
  }
  
  public final void a(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(188642);
    if (!this.RVU.aqS(3)) {
      this.RVN.error("updateVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.RVW.height = paramTPVideoInfo.getHeight();
      this.RVW.width = paramTPVideoInfo.getWidth();
      this.RVW.definition = paramTPVideoInfo.getDefinition();
      this.RVW.RVk = com.tencent.thumbplayer.utils.d.arD(paramTPVideoInfo.getVideoCodecId());
    }
    AppMethodBeat.o(188642);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(188659);
    if (!this.RVU.aqS(17))
    {
      paramITPMediaAsset = new IllegalStateException("error , switch definition , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188659);
      throw paramITPMediaAsset;
    }
    this.RVT.setDataSource(paramITPMediaAsset);
    if (this.RVO != null)
    {
      this.RVO.a(paramITPMediaAsset, paramInt, paramLong);
      AppMethodBeat.o(188659);
      return;
    }
    this.RVN.warn("switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(188659);
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188645);
    if (!this.RVU.aqS(3))
    {
      paramString1 = new IllegalStateException("error : addSubtitleSource , state invalid");
      AppMethodBeat.o(188645);
      throw paramString1;
    }
    if (this.RVO != null) {
      this.RVO.addSubtitleSource(paramString1, paramString2, paramString3);
    }
    c localc = this.RVT;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      c.d locald = new c.d();
      locald.url = paramString1;
      locald.mimeType = paramString2;
      locald.name = paramString3;
      localc.RVu.put(paramString1, locald);
      localc.trackId += 1;
      paramString1 = new TPTrackInfo();
      paramString1.trackType = 3;
      paramString1.name = paramString3;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.RVF.add(paramString1);
    }
    AppMethodBeat.o(188645);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(188676);
    if (this.RVO != null)
    {
      this.RVO.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      AppMethodBeat.o(188676);
      return;
    }
    paramTPCaptureParams = new IllegalStateException("error , no player for capture :" + this.RVP);
    AppMethodBeat.o(188676);
    throw paramTPCaptureParams;
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188648);
    if (!this.RVU.aqS(3))
    {
      localObject = new IllegalStateException("error : deselectTrack , state invalid");
      AppMethodBeat.o(188648);
      throw ((Throwable)localObject);
    }
    Object localObject = getTrackInfo();
    if (localObject == null)
    {
      this.RVN.error("fatal err, tpTrackInfos is null");
      AppMethodBeat.o(188648);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(188648);
      throw ((Throwable)localObject);
    }
    if (this.RVO != null) {
      this.RVO.deselectTrack(paramInt, paramLong);
    }
    this.RVT.a(paramInt, localObject[paramInt]);
    AppMethodBeat.o(188648);
  }
  
  public final void g(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(188646);
    if (!this.RVU.aqS(3))
    {
      paramString1 = new IllegalStateException("error : addAudioTrackSource , state invalid");
      AppMethodBeat.o(188646);
      throw paramString1;
    }
    if (this.RVO != null) {
      this.RVO.g(paramString1, paramString2, paramList);
    }
    c localc = this.RVT;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      c.a locala = new c.a();
      locala.url = paramString1;
      locala.name = paramString2;
      locala.RVH = paramList;
      localc.RVv.put(paramString1, locala);
      localc.trackId += 1;
      paramString1 = new TPTrackInfo();
      paramString1.trackType = 2;
      paramString1.name = paramString2;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.RVF.add(paramString1);
    }
    AppMethodBeat.o(188646);
  }
  
  public final int getCurrentPlayClipNo()
  {
    if (this.RVW != null) {
      return this.RVW.RVs;
    }
    return 0;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(188669);
    if (!this.RVU.aqS(12))
    {
      if (this.RVW != null)
      {
        l = this.RVW.RVq;
        AppMethodBeat.o(188669);
        return l;
      }
      AppMethodBeat.o(188669);
      return 0L;
    }
    if (this.RVO == null)
    {
      this.RVN.warn("getCurrentPositionMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(188669);
      return 0L;
    }
    long l = this.RVO.getCurrentPositionMs();
    if (this.RVW != null) {
      this.RVW.RVq = l;
    }
    AppMethodBeat.o(188669);
    return l;
  }
  
  public final int getCurrentState()
  {
    AppMethodBeat.i(188643);
    int i = this.RVP.state();
    AppMethodBeat.o(188643);
    return i;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(188668);
    if ((this.RVW != null) && (this.RVW.durationMs > 0L))
    {
      l = this.RVW.durationMs;
      AppMethodBeat.o(188668);
      return l;
    }
    if (!this.RVU.aqS(11))
    {
      AppMethodBeat.o(188668);
      return 0L;
    }
    if (this.RVO == null)
    {
      this.RVN.warn("getDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(188668);
      return 0L;
    }
    long l = this.RVO.getDurationMs();
    if (this.RVW != null) {
      this.RVW.durationMs = l;
    }
    AppMethodBeat.o(188668);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(188670);
    if (!this.RVU.aqS(12))
    {
      AppMethodBeat.o(188670);
      return 0L;
    }
    if (this.RVO == null)
    {
      this.RVN.warn("getBufferedDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(188670);
      return 0L;
    }
    long l = this.RVO.getPlayableDurationMs();
    if (this.RVW != null) {
      this.RVW.RVr = l;
    }
    AppMethodBeat.o(188670);
    return l;
  }
  
  public final int getPlayerType()
  {
    return this.RVX;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(188675);
    if ((this.RVO != null) && (this.RVO.getProgramInfo() != null))
    {
      TPProgramInfo[] arrayOfTPProgramInfo = this.RVO.getProgramInfo();
      AppMethodBeat.o(188675);
      return arrayOfTPProgramInfo;
    }
    AppMethodBeat.o(188675);
    return new TPProgramInfo[0];
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(188666);
    if (this.RVO != null)
    {
      long l = this.RVO.getPropertyLong(paramInt);
      AppMethodBeat.o(188666);
      return l;
    }
    this.RVN.warn("getPropertyLong, mPlayerBase = null, return !");
    AppMethodBeat.o(188666);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(188667);
    if (this.RVO != null)
    {
      String str = this.RVO.getPropertyString(paramInt);
      AppMethodBeat.o(188667);
      return str;
    }
    this.RVN.warn("getPropertyString, mPlayerBase = null, return !");
    AppMethodBeat.o(188667);
    return "";
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(188673);
    if (this.RVO != null)
    {
      arrayOfTPTrackInfo = this.RVO.getTrackInfo();
      AppMethodBeat.o(188673);
      return arrayOfTPTrackInfo;
    }
    TPTrackInfo[] arrayOfTPTrackInfo = (TPTrackInfo[])this.RVT.RVF.toArray(new TPTrackInfo[0]);
    AppMethodBeat.o(188673);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(188672);
    if ((this.RVW != null) && (this.RVW.height > 0L))
    {
      i = (int)this.RVW.height;
      AppMethodBeat.o(188672);
      return i;
    }
    if (!this.RVU.aqS(13))
    {
      this.RVN.warn("getVideoHeight, state error!");
      AppMethodBeat.o(188672);
      return 0;
    }
    if (this.RVO == null)
    {
      this.RVN.warn("getVideoHeight, mPlayerBase = null, return 0!");
      AppMethodBeat.o(188672);
      return 0;
    }
    int i = this.RVO.getVideoHeight();
    if (this.RVW != null) {
      this.RVW.height = i;
    }
    AppMethodBeat.o(188672);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(188671);
    if ((this.RVW != null) && (this.RVW.width > 0L))
    {
      i = (int)this.RVW.width;
      AppMethodBeat.o(188671);
      return i;
    }
    if (!this.RVU.aqS(13))
    {
      this.RVN.warn("getVideoWidth, state error!");
      AppMethodBeat.o(188671);
      return 0;
    }
    if (this.RVO == null)
    {
      this.RVN.warn("getVideoWidth, mPlayerBase = null, return 0!");
      AppMethodBeat.o(188671);
      return 0;
    }
    int i = this.RVO.getVideoWidth();
    if (this.RVW != null) {
      this.RVW.width = i;
    }
    AppMethodBeat.o(188671);
    return i;
  }
  
  public final b hmK()
  {
    return this.RVW;
  }
  
  final boolean hmQ()
  {
    return (this.RVX == 2) || (this.RVX == 3);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(188644);
    if ((this.RVP != null) && (this.RVP.state() == 5))
    {
      AppMethodBeat.o(188644);
      return true;
    }
    AppMethodBeat.o(188644);
    return false;
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188693);
    this.RVR.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(188693);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(188652);
    IllegalStateException localIllegalStateException1;
    if (!this.RVU.aqS(6))
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188652);
      throw localIllegalStateException1;
    }
    if (this.RVO == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(188652);
      throw localIllegalStateException1;
    }
    if (this.RVQ)
    {
      this.RVP.changeState(6);
      AppMethodBeat.o(188652);
      return;
    }
    try
    {
      this.RVO.pause();
      this.RVP.changeState(6);
      AppMethodBeat.o(188652);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(188652);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(188649);
    Object localObject;
    if (!this.RVU.aqS(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188649);
      throw ((Throwable)localObject);
    }
    if (!this.RVT.hmL())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(188649);
      throw ((Throwable)localObject);
    }
    this.RVO = a(hmP(), this.RVM);
    if (this.RVO == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(188649);
      throw ((Throwable)localObject);
    }
    this.RVP.setInnerPlayStateState(3);
    this.RVP.changeState(3);
    this.RVO.prepare();
    AppMethodBeat.o(188649);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(188650);
    Object localObject;
    if (!this.RVU.aqS(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188650);
      throw ((Throwable)localObject);
    }
    if (!this.RVT.hmL())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(188650);
      throw ((Throwable)localObject);
    }
    this.RVO = a(hmP(), this.RVM);
    if (this.RVO == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(188650);
      throw ((Throwable)localObject);
    }
    this.RVP.setInnerPlayStateState(3);
    this.RVP.changeState(3);
    this.RVO.prepareAsync();
    AppMethodBeat.o(188650);
  }
  
  public final void release()
  {
    AppMethodBeat.i(188655);
    this.RVN.info("release, current state :" + this.RVP);
    if (this.RVO != null)
    {
      this.RVO.release();
      this.RVO = null;
    }
    this.RVT.reset();
    this.RVR.clear();
    this.RVW = null;
    this.RVV = null;
    this.RVQ = false;
    this.RVP.changeState(11);
    AppMethodBeat.o(188655);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(188654);
    this.RVN.info("reset, current state :" + this.RVP);
    if (this.RVO != null)
    {
      this.RVO.reset();
      this.RVO.release();
      this.RVO = null;
    }
    this.RVT.reset();
    b localb = this.RVW;
    localb.RVh = null;
    localb.RVi = null;
    localb.RVj = 0;
    localb.RVk = 0;
    localb.width = 0L;
    localb.height = 0L;
    localb.RVl = 0L;
    localb.RVm = null;
    localb.RVn = 0;
    localb.RVo = 0L;
    localb.channels = 0;
    localb.sampleRate = 0L;
    localb.RVp = 0;
    localb.RVq = 0L;
    localb.durationMs = 0L;
    localb.RVr = 0L;
    localb.RVs = 0;
    this.RVV = null;
    this.RVQ = false;
    this.RVP.changeState(1);
    this.RVP.setLastState(1);
    AppMethodBeat.o(188654);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(188656);
    if (!this.RVU.aqS(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188656);
      throw localIllegalStateException;
    }
    if (this.RVO != null)
    {
      this.RVO.seekTo(paramInt);
      AppMethodBeat.o(188656);
      return;
    }
    this.RVN.warn("seekTo, mPlayerBase = null!");
    AppMethodBeat.o(188656);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(188657);
    if (!this.RVU.aqS(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188657);
      throw localIllegalStateException;
    }
    if (this.RVO != null)
    {
      this.RVO.seekTo(paramInt1, paramInt2);
      AppMethodBeat.o(188657);
      return;
    }
    this.RVN.warn("seekTo, mPlayerBase = null!");
    AppMethodBeat.o(188657);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188674);
    if (!this.RVU.aqS(18))
    {
      localObject = new IllegalStateException("error : selectProgram , state invalid");
      AppMethodBeat.o(188674);
      throw ((Throwable)localObject);
    }
    TPProgramInfo[] arrayOfTPProgramInfo = getProgramInfo();
    Object localObject = arrayOfTPProgramInfo;
    if (arrayOfTPProgramInfo == null) {
      localObject = new TPProgramInfo[0];
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : program index not found");
      AppMethodBeat.o(188674);
      throw ((Throwable)localObject);
    }
    if (this.RVO != null) {
      this.RVO.selectProgram(paramInt, paramLong);
    }
    this.RVT.RVG = localObject[paramInt];
    AppMethodBeat.o(188674);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188647);
    if (!this.RVU.aqS(3))
    {
      localObject = new IllegalStateException("error : selectTrack , state invalid");
      AppMethodBeat.o(188647);
      throw ((Throwable)localObject);
    }
    Object localObject = getTrackInfo();
    if (localObject == null)
    {
      this.RVN.error("fatal err, tpTrackInfos is null");
      AppMethodBeat.o(188647);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(188647);
      throw ((Throwable)localObject);
    }
    if (this.RVO != null) {
      this.RVO.selectTrack(paramInt, paramLong);
    }
    this.RVT.a(paramInt, paramLong, localObject[paramInt]);
    AppMethodBeat.o(188647);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(188661);
    if (!this.RVU.aqS(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188661);
      throw localIllegalStateException;
    }
    if (this.RVO != null) {
      this.RVO.setAudioGainRatio(paramFloat);
    }
    for (;;)
    {
      this.RVT.RVB = paramFloat;
      AppMethodBeat.o(188661);
      return;
      this.RVN.info("setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(188662);
    if (!this.RVU.aqS(3))
    {
      paramString = new IllegalStateException("error , setAudioNormalizeVolumeParams , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188662);
      throw paramString;
    }
    if (this.RVO != null) {
      this.RVO.setAudioNormalizeVolumeParams(paramString);
    }
    for (;;)
    {
      this.RVT.RVC = paramString;
      AppMethodBeat.o(188662);
      return;
      this.RVN.info("setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(188639);
    if (!this.RVU.aqS(2))
    {
      paramParcelFileDescriptor = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(188639);
      throw paramParcelFileDescriptor;
    }
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(188639);
      throw paramParcelFileDescriptor;
    }
    this.RVT.setDataSource(paramParcelFileDescriptor);
    this.RVP.changeState(2);
    AppMethodBeat.o(188639);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(188640);
    if (!this.RVU.aqS(2))
    {
      paramITPMediaAsset = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(188640);
      throw paramITPMediaAsset;
    }
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
      AppMethodBeat.o(188640);
      throw paramITPMediaAsset;
    }
    this.RVT.setDataSource(paramITPMediaAsset);
    this.RVP.changeState(2);
    AppMethodBeat.o(188640);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap) {}
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(188664);
    if (!this.RVU.aqS(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188664);
      throw localIllegalStateException;
    }
    if (this.RVO != null) {
      this.RVO.setLoopback(paramBoolean);
    }
    for (;;)
    {
      this.RVT.setLoopback(paramBoolean);
      AppMethodBeat.o(188664);
      return;
      this.RVN.info("setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188665);
    if (!this.RVU.aqS(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188665);
      throw localIllegalStateException;
    }
    if (this.RVO != null) {
      this.RVO.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    for (;;)
    {
      this.RVT.setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(188665);
      return;
      this.RVN.info("setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void setOnPlayerStateChangeListener(c.h paramh)
  {
    this.RVR.RWl = paramh;
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(188660);
    if (!this.RVU.aqS(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188660);
      throw localIllegalStateException;
    }
    if (this.RVO != null) {
      this.RVO.setOutputMute(paramBoolean);
    }
    for (;;)
    {
      this.RVT.RVA = paramBoolean;
      AppMethodBeat.o(188660);
      return;
      this.RVN.info("setOutputMute, mPlayerBase = null!");
    }
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(188663);
    if (!this.RVU.aqS(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188663);
      throw localIllegalStateException;
    }
    if (this.RVO != null) {
      this.RVO.setPlaySpeedRatio(paramFloat);
    }
    for (;;)
    {
      this.RVT.RVD = paramFloat;
      AppMethodBeat.o(188663);
      return;
      this.RVN.info("setPlaySpeedRatio, mPlayerBase = null!");
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(188634);
    if (!this.RVU.aqS(3))
    {
      paramTPOptionalParam = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(188634);
      throw paramTPOptionalParam;
    }
    if (this.RVO != null) {
      this.RVO.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.RVT.a(paramTPOptionalParam);
    AppMethodBeat.o(188634);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(188635);
    if (!this.RVU.aqS(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(188635);
      throw paramSurface;
    }
    if (this.RVO != null) {
      this.RVO.setSurface(paramSurface);
    }
    this.RVT.RVt = paramSurface;
    AppMethodBeat.o(188635);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(188636);
    if (!this.RVU.aqS(4))
    {
      paramSurfaceHolder = new IllegalStateException("setSurfaceHolder , state invalid");
      AppMethodBeat.o(188636);
      throw paramSurfaceHolder;
    }
    if (this.RVO != null) {
      this.RVO.setSurfaceHolder(paramSurfaceHolder);
    }
    this.RVT.RVt = paramSurfaceHolder;
    AppMethodBeat.o(188636);
  }
  
  public final void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(188641);
    if (!this.RVU.aqS(2)) {
      this.RVN.error("setVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.RVW.height = paramTPVideoInfo.getHeight();
      this.RVW.width = paramTPVideoInfo.getWidth();
      this.RVW.definition = paramTPVideoInfo.getDefinition();
      this.RVW.RVk = com.tencent.thumbplayer.utils.d.arD(paramTPVideoInfo.getVideoCodecId());
    }
    AppMethodBeat.o(188641);
  }
  
  public final void start()
  {
    AppMethodBeat.i(188651);
    IllegalStateException localIllegalStateException1;
    if (!this.RVU.aqS(5))
    {
      localIllegalStateException1 = new IllegalStateException("error , start , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188651);
      throw localIllegalStateException1;
    }
    if (this.RVO == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(188651);
      throw localIllegalStateException1;
    }
    try
    {
      this.RVO.start();
      this.RVP.changeState(5);
      AppMethodBeat.o(188651);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(188651);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(188653);
    IllegalStateException localIllegalStateException1;
    if (!this.RVU.aqS(7))
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , state invalid , current state :" + this.RVP);
      AppMethodBeat.o(188653);
      throw localIllegalStateException1;
    }
    if (this.RVO == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(188653);
      throw localIllegalStateException1;
    }
    try
    {
      this.RVP.changeState(8);
      this.RVO.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , stop ,state invalid");
      AppMethodBeat.o(188653);
      throw localIllegalStateException3;
    }
    finally
    {
      this.RVP.changeState(9);
      AppMethodBeat.o(188653);
    }
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(188633);
    this.RVM.a(paramb, "TPPlayerAdapter");
    this.RVN.a(this.RVM);
    this.RVR.bqx(this.RVM.tag);
    if (this.RVO != null) {
      this.RVO.updateLoggerContext(this.RVM);
    }
    AppMethodBeat.o(188633);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, com.tencent.thumbplayer.a.a.c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.g, c.i, c.j, c.k, c.l, c.m
  {
    private a() {}
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(188630);
      d locald = d.this;
      if (!locald.RVU.aqT(7))
      {
        AppMethodBeat.o(188630);
        return null;
      }
      paramTPPostProcessFrameBuffer = locald.RVR.a(paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(188630);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(188623);
      d locald = d.this;
      if (locald.RVU.aqT(4))
      {
        int i = locald.RVV.a(locald.RVW, new com.tencent.thumbplayer.a.b.a.b(locald.RVX, paramInt1, paramInt2, locald.RVW.definition));
        if (i == 0)
        {
          locald.RVR.a(paramInt1, paramInt2, paramLong1, paramLong2);
          AppMethodBeat.o(188623);
          return;
        }
        try
        {
          locald.RVR.a(1013, i, 0L, null);
          locald.RVP.setLastState(locald.RVP.state());
          if (locald.RVO != null)
          {
            long l = locald.RVO.getCurrentPositionMs();
            locald.RVN.info("switchPlayer, current position:".concat(String.valueOf(l)));
            locald.RVW.RVq = l;
            locald.RVW.RVr = locald.RVO.getPlayableDurationMs();
            locald.RVO.reset();
            locald.RVO.release();
          }
          locald.RVO = locald.a(i, locald.RVM);
          if (locald.RVO == null)
          {
            RuntimeException localRuntimeException = new RuntimeException("error , create player failed");
            AppMethodBeat.o(188623);
            throw localRuntimeException;
          }
        }
        catch (IOException localIOException)
        {
          locald.RVN.r(localIOException);
          locald.RVR.a(paramInt1, paramInt2, paramLong1, paramLong2);
          AppMethodBeat.o(188623);
          return;
          locald.RVQ = true;
          locald.RVN.info("switch player to type:" + locald.RVX);
          if (locald.RVW != null)
          {
            TPOptionalParam localTPOptionalParam = new TPOptionalParam().buildLong(100, locald.RVW.RVq);
            locald.RVO.setPlayerOptionalParam(localTPOptionalParam);
          }
          locald.RVP.setInnerPlayStateState(3);
          locald.RVO.prepareAsync();
          AppMethodBeat.o(188623);
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          locald.RVN.r(localIllegalStateException);
          locald.RVR.a(paramInt1, paramInt2, paramLong1, paramLong2);
        }
      }
      AppMethodBeat.o(188623);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(188622);
      d locald = d.this;
      if (locald.RVQ)
      {
        locald.RVN.info("handleOnInfo, mIsRetrying");
        AppMethodBeat.o(188622);
        return;
      }
      if ((paramInt == 152) && (locald.RVW != null)) {
        locald.RVW.RVs = ((int)paramLong1 + 1);
      }
      locald.RVR.a(paramInt, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(188622);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(188629);
      d locald = d.this;
      if (locald.RVU.aqT(7)) {
        locald.RVR.a(paramTPAudioFrameBuffer);
      }
      AppMethodBeat.o(188629);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(188626);
      d locald = d.this;
      if (!locald.RVU.aqT(7))
      {
        locald.RVN.info("handleOnSubtitleData, invalid state");
        AppMethodBeat.o(188626);
        return;
      }
      locald.RVR.a(paramTPSubtitleData);
      AppMethodBeat.o(188626);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(188627);
      d locald = d.this;
      if (!locald.RVU.aqT(7))
      {
        locald.RVN.info("handleOnSubtitleFrameOut, invalid state");
        AppMethodBeat.o(188627);
        return;
      }
      locald.RVR.a(paramTPSubtitleFrameBuffer);
      AppMethodBeat.o(188627);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(188628);
      d locald = d.this;
      if (!locald.RVU.aqT(7))
      {
        locald.RVN.info("handleOnVideoFrameOut, invalid state");
        AppMethodBeat.o(188628);
        return;
      }
      locald.RVR.a(paramTPVideoFrameBuffer);
      AppMethodBeat.o(188628);
    }
    
    public final void aI(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(188625);
      d locald = d.this;
      if (!locald.RVU.aqT(6))
      {
        locald.RVN.info("handleOnVideoSizeChange, invalid state");
        AppMethodBeat.o(188625);
        return;
      }
      locald.RVW.height = paramLong2;
      locald.RVW.width = paramLong1;
      locald.RVR.aI(paramLong1, paramLong2);
      AppMethodBeat.o(188625);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(188631);
      d locald = d.this;
      if (!locald.RVU.aqT(7))
      {
        AppMethodBeat.o(188631);
        return null;
      }
      paramTPPostProcessFrameBuffer = locald.RVR.b(paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(188631);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void cJH()
    {
      AppMethodBeat.i(188624);
      d locald = d.this;
      if (locald.RVU.aqT(5)) {
        locald.RVR.cJH();
      }
      AppMethodBeat.o(188624);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(188621);
      d locald = d.this;
      if (!locald.RVU.aqT(2))
      {
        locald.RVN.info("handleOnComplete, invalid state");
        AppMethodBeat.o(188621);
        return;
      }
      locald.RVP.changeState(7);
      locald.RVR.onCompletion();
      AppMethodBeat.o(188621);
    }
    
    public final void tf()
    {
      AppMethodBeat.i(188620);
      d locald = d.this;
      locald.RVR.a(1000, locald.RVX, 0L, null);
      if (locald.RVQ)
      {
        if (locald.RVP.innerPlayState() != 3)
        {
          locald.RVN.warn("handleOnPrepared, invalid state, mIsRetrying.");
          AppMethodBeat.o(188620);
        }
      }
      else if (!locald.RVU.aqT(1))
      {
        locald.RVN.info("handleOnPrepared, invalid state");
        AppMethodBeat.o(188620);
        return;
      }
      if (locald.hmQ())
      {
        locald.RVW = b.bqw(locald.getPropertyString(0));
        locald.RVW.RVp = ((int)locald.RVO.getPropertyLong(204));
        locald.RVW.RVj = ((int)locald.RVO.getPropertyLong(203));
        locald.RVW.RVn = ((int)locald.RVO.getPropertyLong(102));
        locald.RVW.RVk = ((int)locald.RVO.getPropertyLong(201));
      }
      if (locald.RVW == null) {
        locald.RVW = new b();
      }
      locald.RVW.durationMs = locald.RVO.getDurationMs();
      Object localObject = locald.RVT.aqR(100);
      if (localObject != null) {
        locald.RVW.RVq = ((TPOptionalParam)localObject).getParamLong().value;
      }
      localObject = locald.RVO;
      TPProgramInfo[] arrayOfTPProgramInfo = locald.getProgramInfo();
      int i;
      if (arrayOfTPProgramInfo != null)
      {
        TPProgramInfo localTPProgramInfo = locald.RVT.RVG;
        if (localTPProgramInfo != null)
        {
          i = 0;
          if (i < arrayOfTPProgramInfo.length)
          {
            if ((TextUtils.isEmpty(localTPProgramInfo.name)) || (arrayOfTPProgramInfo[i] == null) || (!localTPProgramInfo.name.equals(arrayOfTPProgramInfo[i].name))) {
              break label451;
            }
            ((com.tencent.thumbplayer.a.a.b)localObject).selectProgram(i, -1L);
          }
        }
      }
      if (locald.RVQ)
      {
        locald.RVQ = false;
        locald.RVN.info("handleOnPrepared, mIsRetrying, recoverState, state:" + locald.RVP.state());
        i = locald.RVP.state();
        locald.RVP.changeState(4);
        if (locald.RVP.lastState() == 3) {
          locald.RVR.tf();
        }
        locald.RVR.a(1014, 0L, 0L, null);
        switch (i)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(188620);
          return;
          label451:
          i += 1;
          break;
          try
          {
            locald.RVO.start();
            locald.RVP.changeState(5);
            AppMethodBeat.o(188620);
            return;
          }
          catch (IllegalStateException localIllegalStateException)
          {
            locald.RVN.r(localIllegalStateException);
          }
        }
      }
      locald.RVP.setInnerPlayStateState(4);
      locald.RVP.changeState(4);
      locald.RVR.tf();
      AppMethodBeat.o(188620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.d
 * JD-Core Version:    0.7.0.1
 */