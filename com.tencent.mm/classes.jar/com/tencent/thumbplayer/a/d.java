package com.tencent.thumbplayer.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
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
import com.tencent.thumbplayer.api.TPCommonEnum.TPSurfaceType;
import com.tencent.thumbplayer.api.TPCommonEnum.TPSwitchDefMode;
import com.tencent.thumbplayer.api.TPOptionalParam;
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
  private com.tencent.thumbplayer.f.a ahDA;
  private com.tencent.thumbplayer.a.a.b ahDB;
  private TPPlayerState ahDC;
  private boolean ahDD;
  private e ahDE;
  private a ahDF;
  private c ahDG;
  private g ahDH;
  private com.tencent.thumbplayer.a.b.a ahDI;
  private b ahDJ;
  private int ahDK;
  private com.tencent.thumbplayer.f.b ahDz;
  private Context mContext;
  
  public d(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228489);
    this.ahDz = new com.tencent.thumbplayer.f.b(paramb, "TPPlayerAdapter");
    this.ahDA = new com.tencent.thumbplayer.f.a(this.ahDz);
    this.mContext = paramContext;
    this.ahDC = new TPPlayerState();
    this.ahDC.setOnPlayerStateChangeListener(this);
    this.ahDG = new c();
    this.ahDF = new a((byte)0);
    this.ahDE = new e(this.ahDz.tag);
    this.ahDH = new g(this.ahDC);
    this.ahDJ = new b();
    AppMethodBeat.o(228489);
  }
  
  private com.tencent.thumbplayer.a.a.b a(int paramInt, com.tencent.thumbplayer.f.b paramb)
  {
    int i = 1;
    AppMethodBeat.i(228504);
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.ahDA.bGe("to create androidPlayer");
        localContext = this.mContext;
        c localc = this.ahDG;
        if (localc.ahDl == null) {
          continue;
        }
        if (localc.ahDl.mType != 2) {
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
        this.ahDA.bGe("to create Player," + paramb.toString());
        paramb = null;
        continue;
      }
      if (paramb != null) {
        break;
      }
      this.ahDA.bGe("play is null!");
      AppMethodBeat.o(228504);
      return null;
      i = 0;
      continue;
      i = 0;
      continue;
      paramb = new com.tencent.thumbplayer.a.a.a.e(localContext, paramb);
      continue;
      if (paramInt == 2)
      {
        this.ahDA.bGe("to create thumbPlayer");
        paramb = com.tencent.thumbplayer.a.a.d.a(this.mContext, paramb);
      }
      else if (paramInt == 3)
      {
        this.ahDA.bGe("to create thumbPlayer software dec");
        paramb = com.tencent.thumbplayer.a.a.d.a(this.mContext, paramb);
      }
      else
      {
        this.ahDA.bGe("to create no Player");
        paramb = null;
      }
    }
    this.ahDK = paramInt;
    a(paramb);
    AppMethodBeat.o(228504);
    return paramb;
  }
  
  private static com.tencent.thumbplayer.a.b.a a(c paramc)
  {
    AppMethodBeat.i(228535);
    try
    {
      paramc = new com.tencent.thumbplayer.a.b.a.a(paramc);
      if (paramc.ahGj)
      {
        paramc = new com.tencent.thumbplayer.a.b.d(paramc);
        AppMethodBeat.o(228535);
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
      AppMethodBeat.o(228535);
    }
    return paramc;
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(228522);
    paramb.a(this.ahDF);
    paramb.a(this.ahDF);
    paramb.a(this.ahDF);
    paramb.a(this.ahDF);
    paramb.a(this.ahDF);
    paramb.a(this.ahDF);
    paramb.a(this.ahDF);
    if (jZM())
    {
      paramb.a(this.ahDF);
      paramb.a(this.ahDF);
      paramb.a(this.ahDF);
      paramb.a(this.ahDF);
      paramb.a(this.ahDF);
    }
    if (1 == this.ahDG.ahDl.mType)
    {
      paramb.setDataSource(this.ahDG.ahDl.ahEa);
      localObject1 = this.ahDG.jZK().iterator();
    }
    Object localObject2;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label422;
      }
      localObject2 = (TPOptionalParam)((Iterator)localObject1).next();
      if ((com.tencent.thumbplayer.a.b.b.b.aHE(((TPOptionalParam)localObject2).getKey()) == null) && (com.tencent.thumbplayer.a.b.b.b.aHF(((TPOptionalParam)localObject2).getKey()) == null))
      {
        this.ahDA.bGf("init param=[" + localObject2 + "] is not valid native param");
        continue;
        if (4 == this.ahDG.ahDl.mType)
        {
          paramb.setDataSource(this.ahDG.ahDl.JgJ);
          break;
        }
        if (3 == this.ahDG.ahDl.mType)
        {
          if (this.ahDK == 2)
          {
            paramb.setDataSource(this.ahDG.ahDl.ahEc.ahEf, this.ahDG.ahDl.mHttpHeaders);
            break;
          }
          if (this.ahDK != 1) {
            break;
          }
          paramb.setDataSource(this.ahDG.ahDl.ahEc.ahEe, this.ahDG.ahDl.mHttpHeaders);
          break;
        }
        if (2 != this.ahDG.ahDl.mType) {
          break;
        }
        paramb.setDataSource(this.ahDG.ahDl.ahEb);
        break;
      }
      paramb.setPlayerOptionalParam((TPOptionalParam)localObject2);
    }
    label422:
    int i = 0;
    Object localObject3;
    if (i < this.ahDG.ahDs.size())
    {
      localObject1 = (TPTrackInfo)this.ahDG.ahDs.get(i);
      if (((TPTrackInfo)localObject1).trackType == 3)
      {
        localObject2 = this.ahDG.jZI().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (c.d)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((c.d)localObject3).name)) && (((c.d)localObject3).name.equals(((TPTrackInfo)localObject1).name)))
          {
            paramb.addSubtitleSource(((c.d)localObject3).url, ((c.d)localObject3).mimeType, ((c.d)localObject3).name);
            label543:
            break label573;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((TPTrackInfo)localObject1).trackType == 2)
        {
          localObject2 = this.ahDG.jZJ().iterator();
          label573:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (c.a)((Iterator)localObject2).next();
            if ((TextUtils.isEmpty(((c.a)localObject3).name)) || (!((c.a)localObject3).name.equals(((TPTrackInfo)localObject1).name))) {
              break label543;
            }
            paramb.j(((c.a)localObject3).url, ((c.a)localObject3).name, ((c.a)localObject3).ahDu);
          }
        }
      }
    }
    Object localObject1 = this.ahDG.ahDj.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.c)((Iterator)localObject1).next();
      if (((c.c)localObject2).ahDy.isSelected)
      {
        localObject3 = paramb.getTrackInfo();
        if (localObject3 == null)
        {
          this.ahDA.error("playerTrackInfoList is null.");
        }
        else
        {
          i = 0;
          while (i < localObject3.length)
          {
            if (((c.c)localObject2).ahDy.name.equals(localObject3[i].name)) {
              paramb.selectTrack(i, ((c.c)localObject2).ahDx);
            }
            i += 1;
          }
        }
      }
    }
    if (this.ahDG.ahDm != null) {
      paramb.setLoopback(this.ahDG.ahDm.ahDv, this.ahDG.ahDm.startPositionMs, this.ahDG.ahDm.ahDw);
    }
    paramb.setOutputMute(this.ahDG.ahDn);
    if (this.ahDG.ahDo != 0.0F) {
      paramb.setAudioGainRatio(this.ahDG.ahDo);
    }
    if (this.ahDG.ahDq != 0.0F) {
      paramb.setPlaySpeedRatio(this.ahDG.ahDq);
    }
    if (!"".equals(this.ahDG.ahDp)) {
      paramb.setAudioNormalizeVolumeParams(this.ahDG.ahDp);
    }
    if ((this.ahDG.ahDg instanceof SurfaceHolder)) {
      paramb.setSurfaceHolder((SurfaceHolder)this.ahDG.ahDg);
    }
    for (;;)
    {
      paramb.setPlayerOptionalParam(new TPOptionalParam().buildQueueInt(204, this.ahDI.jZZ()));
      AppMethodBeat.o(228522);
      return;
      if ((this.ahDG.ahDg instanceof Surface)) {
        paramb.setSurface((Surface)this.ahDG.ahDg, this.ahDG.lSR);
      }
    }
  }
  
  private int jZL()
  {
    AppMethodBeat.i(228492);
    if (this.ahDI == null) {
      this.ahDI = a(this.ahDG);
    }
    int i = this.ahDI.a(this.ahDJ);
    AppMethodBeat.o(228492);
    return i;
  }
  
  private boolean jZM()
  {
    return (this.ahDK == 2) || (this.ahDK == 3);
  }
  
  public final void N(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(228953);
    this.ahDE.b(parama);
    AppMethodBeat.o(228953);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    AppMethodBeat.i(228960);
    this.ahDE.b(paramb);
    AppMethodBeat.o(228960);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    AppMethodBeat.i(228928);
    this.ahDE.a(paramc);
    AppMethodBeat.o(228928);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    AppMethodBeat.i(228935);
    this.ahDE.a(paramd);
    AppMethodBeat.o(228935);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(228932);
    this.ahDE.a(parame);
    AppMethodBeat.o(228932);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(228925);
    this.ahDE.a(paramf);
    AppMethodBeat.o(228925);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(228937);
    this.ahDE.a(paramg);
    AppMethodBeat.o(228937);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(228945);
    this.ahDE.a(parami);
    AppMethodBeat.o(228945);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(228947);
    this.ahDE.a(paramj);
    AppMethodBeat.o(228947);
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(228950);
    this.ahDE.a(paramk);
    AppMethodBeat.o(228950);
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(228957);
    this.ahDE.b(paraml);
    AppMethodBeat.o(228957);
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(228940);
    this.ahDE.a(paramm);
    AppMethodBeat.o(228940);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame)
  {
    AppMethodBeat.i(228661);
    a(parame, null);
    AppMethodBeat.o(228661);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame, int paramInt, long paramLong)
  {
    AppMethodBeat.i(228824);
    if (!this.ahDH.aHr(17))
    {
      parame = new IllegalStateException("error , switch definition , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228824);
      throw parame;
    }
    this.ahDG.a(parame, null);
    if (this.ahDB != null)
    {
      String str = "";
      if (this.ahDK == 2) {
        str = parame.ahEf;
      }
      for (;;)
      {
        this.ahDB.N(str, paramInt, paramLong);
        AppMethodBeat.o(228824);
        return;
        if (this.ahDK == 1) {
          str = parame.ahEe;
        }
      }
    }
    this.ahDA.bGf("switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(228824);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228666);
    if (!this.ahDH.aHr(2))
    {
      parame = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(228666);
      throw parame;
    }
    if (parame == null)
    {
      parame = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(228666);
      throw parame;
    }
    this.ahDG.a(parame, paramMap);
    this.ahDC.changeState(2);
    AppMethodBeat.o(228666);
  }
  
  public final void a(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(228712);
    if (!this.ahDH.aHr(3)) {
      this.ahDA.error("updateVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.ahDJ.height = paramTPVideoInfo.getHeight();
      this.ahDJ.width = paramTPVideoInfo.getWidth();
      this.ahDJ.definition = paramTPVideoInfo.getDefinition();
      this.ahDJ.ahCY = com.tencent.thumbplayer.utils.d.aId(paramTPVideoInfo.getVideoCodecId());
    }
    AppMethodBeat.o(228712);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(228835);
    if (!this.ahDH.aHr(17))
    {
      paramITPMediaAsset = new IllegalStateException("error , switch definition , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228835);
      throw paramITPMediaAsset;
    }
    this.ahDG.setDataSource(paramITPMediaAsset);
    if (this.ahDB != null)
    {
      this.ahDB.a(paramITPMediaAsset, paramInt, paramLong);
      AppMethodBeat.o(228835);
      return;
    }
    this.ahDA.bGf("switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(228835);
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228761);
    if (!this.ahDH.aHr(3))
    {
      paramString1 = new IllegalStateException("error : addSubtitleSource , state invalid");
      AppMethodBeat.o(228761);
      throw paramString1;
    }
    if (this.ahDB != null) {
      this.ahDB.addSubtitleSource(paramString1, paramString2, paramString3);
    }
    c localc = this.ahDG;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      c.d locald = new c.d();
      locald.url = paramString1;
      locald.mimeType = paramString2;
      locald.name = paramString3;
      localc.ahDh.put(paramString1, locald);
      localc.trackId += 1;
      paramString1 = new TPTrackInfo();
      paramString1.trackType = 3;
      paramString1.name = paramString3;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.ahDs.add(paramString1);
    }
    AppMethodBeat.o(228761);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(228921);
    if (this.ahDB != null)
    {
      this.ahDB.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      AppMethodBeat.o(228921);
      return;
    }
    paramTPCaptureParams = new IllegalStateException("error , no player for capture :" + this.ahDC);
    AppMethodBeat.o(228921);
    throw paramTPCaptureParams;
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228775);
    if (!this.ahDH.aHr(3))
    {
      localObject = new IllegalStateException("error : deselectTrack , state invalid");
      AppMethodBeat.o(228775);
      throw ((Throwable)localObject);
    }
    Object localObject = getTrackInfo();
    if (localObject == null)
    {
      this.ahDA.error("fatal err, tpTrackInfos is null");
      AppMethodBeat.o(228775);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(228775);
      throw ((Throwable)localObject);
    }
    if (this.ahDB != null) {
      this.ahDB.deselectTrack(paramInt, paramLong);
    }
    this.ahDG.a(paramInt, localObject[paramInt]);
    AppMethodBeat.o(228775);
  }
  
  public final int getCurrentPlayClipNo()
  {
    if (this.ahDJ != null) {
      return this.ahDJ.ahDf;
    }
    return 0;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(228893);
    if (!this.ahDH.aHr(12))
    {
      if (this.ahDJ != null)
      {
        l = this.ahDJ.ahDd;
        AppMethodBeat.o(228893);
        return l;
      }
      AppMethodBeat.o(228893);
      return 0L;
    }
    if (this.ahDB == null)
    {
      this.ahDA.bGf("getCurrentPositionMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(228893);
      return 0L;
    }
    long l = this.ahDB.getCurrentPositionMs();
    if (this.ahDJ != null) {
      this.ahDJ.ahDd = l;
    }
    AppMethodBeat.o(228893);
    return l;
  }
  
  public final int getCurrentState()
  {
    AppMethodBeat.i(228723);
    int i = this.ahDC.state();
    AppMethodBeat.o(228723);
    return i;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(228890);
    if ((this.ahDJ != null) && (this.ahDJ.durationMs > 0L))
    {
      l = this.ahDJ.durationMs;
      AppMethodBeat.o(228890);
      return l;
    }
    if (!this.ahDH.aHr(11))
    {
      AppMethodBeat.o(228890);
      return 0L;
    }
    if (this.ahDB == null)
    {
      this.ahDA.bGf("getDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(228890);
      return 0L;
    }
    long l = this.ahDB.getDurationMs();
    if (this.ahDJ != null) {
      this.ahDJ.durationMs = l;
    }
    AppMethodBeat.o(228890);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(228896);
    if (!this.ahDH.aHr(12))
    {
      AppMethodBeat.o(228896);
      return 0L;
    }
    if (this.ahDB == null)
    {
      this.ahDA.bGf("getBufferedDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(228896);
      return 0L;
    }
    long l = this.ahDB.getPlayableDurationMs();
    if (this.ahDJ != null) {
      this.ahDJ.ahDe = l;
    }
    AppMethodBeat.o(228896);
    return l;
  }
  
  public final int getPlayerType()
  {
    return this.ahDK;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(228917);
    if ((this.ahDB != null) && (this.ahDB.getProgramInfo() != null))
    {
      TPProgramInfo[] arrayOfTPProgramInfo = this.ahDB.getProgramInfo();
      AppMethodBeat.o(228917);
      return arrayOfTPProgramInfo;
    }
    AppMethodBeat.o(228917);
    return new TPProgramInfo[0];
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(228879);
    if (this.ahDB != null)
    {
      long l = this.ahDB.getPropertyLong(paramInt);
      AppMethodBeat.o(228879);
      return l;
    }
    this.ahDA.bGf("getPropertyLong, mPlayerBase = null, return !");
    AppMethodBeat.o(228879);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(228885);
    if (this.ahDB != null)
    {
      String str = this.ahDB.getPropertyString(paramInt);
      AppMethodBeat.o(228885);
      return str;
    }
    this.ahDA.bGf("getPropertyString, mPlayerBase = null, return !");
    AppMethodBeat.o(228885);
    return "";
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(228911);
    if (this.ahDB != null)
    {
      arrayOfTPTrackInfo = this.ahDB.getTrackInfo();
      AppMethodBeat.o(228911);
      return arrayOfTPTrackInfo;
    }
    TPTrackInfo[] arrayOfTPTrackInfo = (TPTrackInfo[])this.ahDG.ahDs.toArray(new TPTrackInfo[0]);
    AppMethodBeat.o(228911);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(228906);
    if ((this.ahDJ != null) && (this.ahDJ.height > 0L))
    {
      i = (int)this.ahDJ.height;
      AppMethodBeat.o(228906);
      return i;
    }
    if (!this.ahDH.aHr(13))
    {
      this.ahDA.bGf("getVideoHeight, state error!");
      AppMethodBeat.o(228906);
      return 0;
    }
    if (this.ahDB == null)
    {
      this.ahDA.bGf("getVideoHeight, mPlayerBase = null, return 0!");
      AppMethodBeat.o(228906);
      return 0;
    }
    int i = this.ahDB.getVideoHeight();
    if (this.ahDJ != null) {
      this.ahDJ.height = i;
    }
    AppMethodBeat.o(228906);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(228900);
    if ((this.ahDJ != null) && (this.ahDJ.width > 0L))
    {
      i = (int)this.ahDJ.width;
      AppMethodBeat.o(228900);
      return i;
    }
    if (!this.ahDH.aHr(13))
    {
      this.ahDA.bGf("getVideoWidth, state error!");
      AppMethodBeat.o(228900);
      return 0;
    }
    if (this.ahDB == null)
    {
      this.ahDA.bGf("getVideoWidth, mPlayerBase = null, return 0!");
      AppMethodBeat.o(228900);
      return 0;
    }
    int i = this.ahDB.getVideoWidth();
    if (this.ahDJ != null) {
      this.ahDJ.width = i;
    }
    AppMethodBeat.o(228900);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(228730);
    if ((this.ahDC != null) && (this.ahDC.state() == 5))
    {
      AppMethodBeat.o(228730);
      return true;
    }
    AppMethodBeat.o(228730);
    return false;
  }
  
  public final void j(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(228765);
    if (!this.ahDH.aHr(3))
    {
      paramString1 = new IllegalStateException("error : addAudioTrackSource , state invalid");
      AppMethodBeat.o(228765);
      throw paramString1;
    }
    if (this.ahDB != null) {
      this.ahDB.j(paramString1, paramString2, paramList);
    }
    c localc = this.ahDG;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      c.a locala = new c.a();
      locala.url = paramString1;
      locala.name = paramString2;
      locala.ahDu = paramList;
      localc.ahDi.put(paramString1, locala);
      localc.trackId += 1;
      paramString1 = new TPTrackInfo();
      paramString1.trackType = 2;
      paramString1.name = paramString2;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.ahDs.add(paramString1);
    }
    AppMethodBeat.o(228765);
  }
  
  public final b jZG()
  {
    return this.ahDJ;
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228965);
    this.ahDE.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(228965);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(228793);
    IllegalStateException localIllegalStateException1;
    if (!this.ahDH.aHr(6))
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228793);
      throw localIllegalStateException1;
    }
    if (this.ahDB == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(228793);
      throw localIllegalStateException1;
    }
    if (this.ahDD)
    {
      this.ahDC.changeState(6);
      AppMethodBeat.o(228793);
      return;
    }
    try
    {
      this.ahDB.pause();
      this.ahDC.changeState(6);
      AppMethodBeat.o(228793);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(228793);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(228780);
    Object localObject;
    if (!this.ahDH.aHr(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228780);
      throw ((Throwable)localObject);
    }
    if (!this.ahDG.jZH())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(228780);
      throw ((Throwable)localObject);
    }
    this.ahDB = a(jZL(), this.ahDz);
    if (this.ahDB == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(228780);
      throw ((Throwable)localObject);
    }
    this.ahDC.setInnerPlayStateState(3);
    this.ahDC.changeState(3);
    this.ahDB.prepare();
    AppMethodBeat.o(228780);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(228786);
    Object localObject;
    if (!this.ahDH.aHr(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228786);
      throw ((Throwable)localObject);
    }
    if (!this.ahDG.jZH())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(228786);
      throw ((Throwable)localObject);
    }
    this.ahDB = a(jZL(), this.ahDz);
    if (this.ahDB == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(228786);
      throw ((Throwable)localObject);
    }
    this.ahDC.setInnerPlayStateState(3);
    this.ahDC.changeState(3);
    this.ahDB.prepareAsync();
    AppMethodBeat.o(228786);
  }
  
  public final void release()
  {
    AppMethodBeat.i(228808);
    this.ahDA.bGe("release, current state :" + this.ahDC);
    if (this.ahDB != null)
    {
      this.ahDB.release();
      this.ahDB = null;
    }
    this.ahDG.reset();
    this.ahDE.clear();
    this.ahDJ = null;
    this.ahDI = null;
    this.ahDD = false;
    this.ahDC.changeState(11);
    AppMethodBeat.o(228808);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(228802);
    this.ahDA.bGe("reset, current state :" + this.ahDC);
    if (this.ahDB != null)
    {
      this.ahDB.reset();
      this.ahDB.release();
      this.ahDB = null;
    }
    this.ahDG.reset();
    b localb = this.ahDJ;
    localb.ahCV = null;
    localb.ahCW = null;
    localb.ahCX = 0;
    localb.ahCY = 0;
    localb.width = 0L;
    localb.height = 0L;
    localb.Gpr = 0L;
    localb.ahCZ = null;
    localb.ahDa = 0;
    localb.ahDb = 0L;
    localb.channels = 0;
    localb.sampleRate = 0L;
    localb.ahDc = 0;
    localb.ahDd = 0L;
    localb.durationMs = 0L;
    localb.ahDe = 0L;
    localb.ahDf = 0;
    this.ahDI = null;
    this.ahDD = false;
    this.ahDC.changeState(1);
    this.ahDC.setLastState(1);
    AppMethodBeat.o(228802);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(228811);
    if (!this.ahDH.aHr(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228811);
      throw localIllegalStateException;
    }
    if (this.ahDB != null)
    {
      if (this.ahDC.state() == 7) {
        this.ahDC.changeState(5);
      }
      this.ahDB.seekTo(paramInt);
      AppMethodBeat.o(228811);
      return;
    }
    this.ahDA.bGf("seekTo, mPlayerBase = null!");
    AppMethodBeat.o(228811);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(228816);
    if (!this.ahDH.aHr(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228816);
      throw localIllegalStateException;
    }
    if (this.ahDB != null)
    {
      if (this.ahDC.state() == 7) {
        this.ahDC.changeState(5);
      }
      this.ahDB.seekTo(paramInt1, paramInt2);
      AppMethodBeat.o(228816);
      return;
    }
    this.ahDA.bGf("seekTo, mPlayerBase = null!");
    AppMethodBeat.o(228816);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228914);
    if (!this.ahDH.aHr(18))
    {
      localObject = new IllegalStateException("error : selectProgram , state invalid");
      AppMethodBeat.o(228914);
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
      AppMethodBeat.o(228914);
      throw ((Throwable)localObject);
    }
    if (this.ahDB != null) {
      this.ahDB.selectProgram(paramInt, paramLong);
    }
    this.ahDG.ahDt = localObject[paramInt];
    AppMethodBeat.o(228914);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228771);
    if (!this.ahDH.aHr(3))
    {
      localObject = new IllegalStateException("error : selectTrack , state invalid");
      AppMethodBeat.o(228771);
      throw ((Throwable)localObject);
    }
    Object localObject = getTrackInfo();
    if (localObject == null)
    {
      this.ahDA.error("fatal err, tpTrackInfos is null");
      AppMethodBeat.o(228771);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(228771);
      throw ((Throwable)localObject);
    }
    if (this.ahDB != null) {
      this.ahDB.selectTrack(paramInt, paramLong);
    }
    this.ahDG.a(paramInt, paramLong, localObject[paramInt]);
    AppMethodBeat.o(228771);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(228847);
    if (!this.ahDH.aHr(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228847);
      throw localIllegalStateException;
    }
    if (this.ahDB != null) {
      this.ahDB.setAudioGainRatio(paramFloat);
    }
    for (;;)
    {
      this.ahDG.ahDo = paramFloat;
      AppMethodBeat.o(228847);
      return;
      this.ahDA.bGe("setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(228852);
    if (!this.ahDH.aHr(3))
    {
      paramString = new IllegalStateException("error , setAudioNormalizeVolumeParams , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228852);
      throw paramString;
    }
    if (this.ahDB != null) {
      this.ahDB.setAudioNormalizeVolumeParams(paramString);
    }
    for (;;)
    {
      this.ahDG.ahDp = paramString;
      AppMethodBeat.o(228852);
      return;
      this.ahDA.bGe("setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void setDataSource(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(228689);
    if (!this.ahDH.aHr(2))
    {
      paramAssetFileDescriptor = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(228689);
      throw paramAssetFileDescriptor;
    }
    if (paramAssetFileDescriptor == null)
    {
      paramAssetFileDescriptor = new IllegalArgumentException("error : setDataSource , afd invalid");
      AppMethodBeat.o(228689);
      throw paramAssetFileDescriptor;
    }
    this.ahDG.setDataSource(paramAssetFileDescriptor);
    this.ahDC.changeState(2);
    AppMethodBeat.o(228689);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(228679);
    if (!this.ahDH.aHr(2))
    {
      paramParcelFileDescriptor = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(228679);
      throw paramParcelFileDescriptor;
    }
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(228679);
      throw paramParcelFileDescriptor;
    }
    this.ahDG.setDataSource(paramParcelFileDescriptor);
    this.ahDC.changeState(2);
    AppMethodBeat.o(228679);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(228697);
    if (!this.ahDH.aHr(2))
    {
      paramITPMediaAsset = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(228697);
      throw paramITPMediaAsset;
    }
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
      AppMethodBeat.o(228697);
      throw paramITPMediaAsset;
    }
    this.ahDG.setDataSource(paramITPMediaAsset);
    this.ahDC.changeState(2);
    AppMethodBeat.o(228697);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap) {}
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(228866);
    if (!this.ahDH.aHr(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228866);
      throw localIllegalStateException;
    }
    if (this.ahDB != null) {
      this.ahDB.setLoopback(paramBoolean);
    }
    for (;;)
    {
      this.ahDG.setLoopback(paramBoolean);
      AppMethodBeat.o(228866);
      return;
      this.ahDA.bGe("setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228875);
    if (!this.ahDH.aHr(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228875);
      throw localIllegalStateException;
    }
    if (this.ahDB != null) {
      this.ahDB.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    for (;;)
    {
      this.ahDG.setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(228875);
      return;
      this.ahDA.bGe("setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void setOnPlayerStateChangeListener(c.h paramh)
  {
    this.ahDE.ahDY = paramh;
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(228840);
    if (!this.ahDH.aHr(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228840);
      throw localIllegalStateException;
    }
    if (this.ahDB != null) {
      this.ahDB.setOutputMute(paramBoolean);
    }
    for (;;)
    {
      this.ahDG.ahDn = paramBoolean;
      AppMethodBeat.o(228840);
      return;
      this.ahDA.bGe("setOutputMute, mPlayerBase = null!");
    }
  }
  
  public final void setPlaySharpenSwitch()
  {
    AppMethodBeat.i(228861);
    if (!this.ahDH.aHr(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setSharpenSwitch , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228861);
      throw localIllegalStateException;
    }
    if (this.ahDB != null)
    {
      this.ahDB.setPlaySharpenSwitch();
      AppMethodBeat.o(228861);
      return;
    }
    this.ahDA.bGe("setSharpenSwitch, mPlayerBase = null!");
    AppMethodBeat.o(228861);
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(228856);
    if (!this.ahDH.aHr(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228856);
      throw localIllegalStateException;
    }
    if (this.ahDB != null) {
      this.ahDB.setPlaySpeedRatio(paramFloat);
    }
    for (;;)
    {
      this.ahDG.ahDq = paramFloat;
      AppMethodBeat.o(228856);
      return;
      this.ahDA.bGe("setPlaySpeedRatio, mPlayerBase = null!");
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(228638);
    if (!this.ahDH.aHr(3))
    {
      paramTPOptionalParam = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(228638);
      throw paramTPOptionalParam;
    }
    if (this.ahDB != null) {
      this.ahDB.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.ahDG.a(paramTPOptionalParam);
    AppMethodBeat.o(228638);
  }
  
  public final void setSurface(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt)
  {
    AppMethodBeat.i(228647);
    if (!this.ahDH.aHr(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(228647);
      throw paramSurface;
    }
    if (this.ahDB != null) {
      this.ahDB.setSurface(paramSurface, paramInt);
    }
    this.ahDG.v(paramSurface);
    AppMethodBeat.o(228647);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(228654);
    if (!this.ahDH.aHr(4))
    {
      paramSurfaceHolder = new IllegalStateException("setSurfaceHolder , state invalid");
      AppMethodBeat.o(228654);
      throw paramSurfaceHolder;
    }
    if (this.ahDB != null) {
      this.ahDB.setSurfaceHolder(paramSurfaceHolder);
    }
    this.ahDG.ahDg = paramSurfaceHolder;
    AppMethodBeat.o(228654);
  }
  
  public final void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(228706);
    if (!this.ahDH.aHr(2)) {
      this.ahDA.error("setVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.ahDJ.height = paramTPVideoInfo.getHeight();
      this.ahDJ.width = paramTPVideoInfo.getWidth();
      this.ahDJ.definition = paramTPVideoInfo.getDefinition();
      this.ahDJ.ahCY = com.tencent.thumbplayer.utils.d.aId(paramTPVideoInfo.getVideoCodecId());
    }
    AppMethodBeat.o(228706);
  }
  
  public final void start()
  {
    AppMethodBeat.i(228790);
    IllegalStateException localIllegalStateException1;
    if (!this.ahDH.aHr(5))
    {
      localIllegalStateException1 = new IllegalStateException("error , start , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228790);
      throw localIllegalStateException1;
    }
    if (this.ahDB == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(228790);
      throw localIllegalStateException1;
    }
    try
    {
      this.ahDB.start();
      this.ahDC.changeState(5);
      AppMethodBeat.o(228790);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(228790);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(228795);
    IllegalStateException localIllegalStateException1;
    if (!this.ahDH.aHr(7))
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , state invalid , current state :" + this.ahDC);
      AppMethodBeat.o(228795);
      throw localIllegalStateException1;
    }
    if (this.ahDB == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(228795);
      throw localIllegalStateException1;
    }
    try
    {
      this.ahDC.changeState(8);
      this.ahDB.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , stop ,state invalid");
      AppMethodBeat.o(228795);
      throw localIllegalStateException3;
    }
    finally
    {
      this.ahDC.changeState(9);
      AppMethodBeat.o(228795);
    }
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228633);
    this.ahDz.a(paramb, "TPPlayerAdapter");
    this.ahDA.a(this.ahDz);
    this.ahDE.ayz(this.ahDz.tag);
    if (this.ahDB != null) {
      this.ahDB.updateLoggerContext(this.ahDz);
    }
    AppMethodBeat.o(228633);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, com.tencent.thumbplayer.a.a.c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.g, c.i, c.j, c.k, c.l, c.m
  {
    private a() {}
    
    public final void Qz()
    {
      AppMethodBeat.i(228460);
      d.a(d.this);
      AppMethodBeat.o(228460);
    }
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(228550);
      paramTPPostProcessFrameBuffer = d.a(d.this, paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(228550);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(228486);
      d.a(d.this, paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(228486);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(228476);
      d.a(d.this, paramInt, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(228476);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(228538);
      d.a(d.this, paramTPAudioFrameBuffer);
      AppMethodBeat.o(228538);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(228511);
      d.a(d.this, paramTPSubtitleData);
      AppMethodBeat.o(228511);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(228520);
      d.a(d.this, paramTPSubtitleFrameBuffer);
      AppMethodBeat.o(228520);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(228529);
      d.a(d.this, paramTPVideoFrameBuffer);
      AppMethodBeat.o(228529);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(228562);
      paramTPPostProcessFrameBuffer = d.b(d.this, paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(228562);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void bN(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(228503);
      d.a(d.this, paramLong1, paramLong2);
      AppMethodBeat.o(228503);
    }
    
    public final void dEH()
    {
      AppMethodBeat.i(228495);
      d.c(d.this);
      AppMethodBeat.o(228495);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(228468);
      d.b(d.this);
      AppMethodBeat.o(228468);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.d
 * JD-Core Version:    0.7.0.1
 */