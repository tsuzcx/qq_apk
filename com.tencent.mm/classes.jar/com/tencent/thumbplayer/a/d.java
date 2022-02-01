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
  private boolean ZyA;
  private e ZyB;
  private a ZyC;
  private c ZyD;
  private g ZyE;
  private com.tencent.thumbplayer.a.b.a ZyF;
  private b ZyG;
  private int ZyH;
  private com.tencent.thumbplayer.f.b Zyw;
  private com.tencent.thumbplayer.f.a Zyx;
  private com.tencent.thumbplayer.a.a.b Zyy;
  private TPPlayerState Zyz;
  private Context mContext;
  
  public d(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(218692);
    this.Zyw = new com.tencent.thumbplayer.f.b(paramb, "TPPlayerAdapter");
    this.Zyx = new com.tencent.thumbplayer.f.a(this.Zyw);
    this.mContext = paramContext;
    this.Zyz = new TPPlayerState();
    this.Zyz.setOnPlayerStateChangeListener(this);
    this.ZyD = new c();
    this.ZyC = new a((byte)0);
    this.ZyB = new e(this.Zyw.tag);
    this.ZyE = new g(this.Zyz);
    this.ZyG = new b();
    AppMethodBeat.o(218692);
  }
  
  private com.tencent.thumbplayer.a.a.b a(int paramInt, com.tencent.thumbplayer.f.b paramb)
  {
    int i = 1;
    AppMethodBeat.i(218789);
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.Zyx.bDy("to create androidPlayer");
        localContext = this.mContext;
        c localc = this.ZyD;
        if (localc.Zyi == null) {
          continue;
        }
        if (localc.Zyi.mType != 2) {
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
        this.Zyx.bDy("to create Player," + paramb.toString());
        paramb = null;
        continue;
      }
      if (paramb != null) {
        break;
      }
      this.Zyx.bDy("play is null!");
      AppMethodBeat.o(218789);
      return null;
      i = 0;
      continue;
      i = 0;
      continue;
      paramb = new com.tencent.thumbplayer.a.a.a.e(localContext, paramb);
      continue;
      if (paramInt == 2)
      {
        this.Zyx.bDy("to create thumbPlayer");
        paramb = com.tencent.thumbplayer.a.a.d.a(this.mContext, paramb);
      }
      else if (paramInt == 3)
      {
        this.Zyx.bDy("to create thumbPlayer software dec");
        paramb = com.tencent.thumbplayer.a.a.d.a(this.mContext, paramb);
      }
      else
      {
        this.Zyx.bDy("to create no Player");
        paramb = null;
      }
    }
    this.ZyH = paramInt;
    a(paramb);
    AppMethodBeat.o(218789);
    return paramb;
  }
  
  private static com.tencent.thumbplayer.a.b.a a(c paramc)
  {
    AppMethodBeat.i(218796);
    try
    {
      paramc = new com.tencent.thumbplayer.a.b.a.a(paramc);
      if (paramc.ZBg)
      {
        paramc = new com.tencent.thumbplayer.a.b.d(paramc);
        AppMethodBeat.o(218796);
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
      AppMethodBeat.o(218796);
    }
    return paramc;
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(218795);
    paramb.a(this.ZyC);
    paramb.a(this.ZyC);
    paramb.a(this.ZyC);
    paramb.a(this.ZyC);
    paramb.a(this.ZyC);
    paramb.a(this.ZyC);
    paramb.a(this.ZyC);
    if (iqr())
    {
      paramb.a(this.ZyC);
      paramb.a(this.ZyC);
      paramb.a(this.ZyC);
      paramb.a(this.ZyC);
      paramb.a(this.ZyC);
    }
    if (1 == this.ZyD.Zyi.mType)
    {
      paramb.setDataSource(this.ZyD.Zyi.ZyX);
      localObject1 = this.ZyD.iqp().iterator();
    }
    Object localObject2;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label389;
      }
      localObject2 = (TPOptionalParam)((Iterator)localObject1).next();
      if ((com.tencent.thumbplayer.a.b.b.b.aAR(((TPOptionalParam)localObject2).getKey()) == null) && (com.tencent.thumbplayer.a.b.b.b.aAS(((TPOptionalParam)localObject2).getKey()) == null))
      {
        this.Zyx.bDz("init param=[" + localObject2 + "] is not valid native param");
        continue;
        if (3 == this.ZyD.Zyi.mType)
        {
          if (this.ZyH == 2)
          {
            paramb.setDataSource(this.ZyD.Zyi.Zza.Zzd, this.ZyD.Zyi.ZyY);
            break;
          }
          if (this.ZyH != 1) {
            break;
          }
          paramb.setDataSource(this.ZyD.Zyi.Zza.Zzc, this.ZyD.Zyi.ZyY);
          break;
        }
        if (2 != this.ZyD.Zyi.mType) {
          break;
        }
        paramb.setDataSource(this.ZyD.Zyi.ZyZ);
        break;
      }
      paramb.setPlayerOptionalParam((TPOptionalParam)localObject2);
    }
    label389:
    int i = 0;
    Object localObject3;
    if (i < this.ZyD.Zyp.size())
    {
      localObject1 = (TPTrackInfo)this.ZyD.Zyp.get(i);
      if (((TPTrackInfo)localObject1).trackType == 3)
      {
        localObject2 = this.ZyD.iqn().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (c.d)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(((c.d)localObject3).name)) && (((c.d)localObject3).name.equals(((TPTrackInfo)localObject1).name)))
          {
            paramb.addSubtitleSource(((c.d)localObject3).url, ((c.d)localObject3).mimeType, ((c.d)localObject3).name);
            label510:
            break label540;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (((TPTrackInfo)localObject1).trackType == 2)
        {
          localObject2 = this.ZyD.iqo().iterator();
          label540:
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (c.a)((Iterator)localObject2).next();
            if ((TextUtils.isEmpty(((c.a)localObject3).name)) || (!((c.a)localObject3).name.equals(((TPTrackInfo)localObject1).name))) {
              break label510;
            }
            paramb.h(((c.a)localObject3).url, ((c.a)localObject3).name, ((c.a)localObject3).Zyr);
          }
        }
      }
    }
    Object localObject1 = this.ZyD.Zyg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (c.c)((Iterator)localObject1).next();
      if (((c.c)localObject2).Zyv.isSelected)
      {
        localObject3 = paramb.getTrackInfo();
        if (localObject3 == null)
        {
          this.Zyx.error("playerTrackInfoList is null.");
        }
        else
        {
          i = 0;
          while (i < localObject3.length)
          {
            if (((c.c)localObject2).Zyv.name.equals(localObject3[i].name)) {
              paramb.selectTrack(i, ((c.c)localObject2).Zyu);
            }
            i += 1;
          }
        }
      }
    }
    if (this.ZyD.Zyj != null) {
      paramb.setLoopback(this.ZyD.Zyj.Zys, this.ZyD.Zyj.startPositionMs, this.ZyD.Zyj.Zyt);
    }
    paramb.setOutputMute(this.ZyD.Zyk);
    if (this.ZyD.Zyl != 0.0F) {
      paramb.setAudioGainRatio(this.ZyD.Zyl);
    }
    if (this.ZyD.Zyn != 0.0F) {
      paramb.setPlaySpeedRatio(this.ZyD.Zyn);
    }
    if (!"".equals(this.ZyD.Zym)) {
      paramb.setAudioNormalizeVolumeParams(this.ZyD.Zym);
    }
    if ((this.ZyD.Zyd instanceof SurfaceHolder)) {
      paramb.setSurfaceHolder((SurfaceHolder)this.ZyD.Zyd);
    }
    for (;;)
    {
      paramb.setPlayerOptionalParam(new TPOptionalParam().buildQueueInt(204, this.ZyF.iqE()));
      AppMethodBeat.o(218795);
      return;
      if ((this.ZyD.Zyd instanceof Surface)) {
        paramb.setSurface((Surface)this.ZyD.Zyd);
      }
    }
  }
  
  private int iqq()
  {
    AppMethodBeat.i(218785);
    if (this.ZyF == null) {
      this.ZyF = a(this.ZyD);
    }
    int i = this.ZyF.a(this.ZyG);
    AppMethodBeat.o(218785);
    return i;
  }
  
  private boolean iqr()
  {
    return (this.ZyH == 2) || (this.ZyH == 3);
  }
  
  public final void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(218780);
    this.ZyB.b(parama);
    AppMethodBeat.o(218780);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    AppMethodBeat.i(218782);
    this.ZyB.b(paramb);
    AppMethodBeat.o(218782);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.c paramc)
  {
    AppMethodBeat.i(218769);
    this.ZyB.a(paramc);
    AppMethodBeat.o(218769);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    AppMethodBeat.i(218772);
    this.ZyB.a(paramd);
    AppMethodBeat.o(218772);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(218771);
    this.ZyB.a(parame);
    AppMethodBeat.o(218771);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(218768);
    this.ZyB.a(paramf);
    AppMethodBeat.o(218768);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(218773);
    this.ZyB.a(paramg);
    AppMethodBeat.o(218773);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(218775);
    this.ZyB.a(parami);
    AppMethodBeat.o(218775);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(218777);
    this.ZyB.a(paramj);
    AppMethodBeat.o(218777);
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(218779);
    this.ZyB.a(paramk);
    AppMethodBeat.o(218779);
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(218781);
    this.ZyB.b(paraml);
    AppMethodBeat.o(218781);
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(218774);
    this.ZyB.a(paramm);
    AppMethodBeat.o(218774);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame)
  {
    AppMethodBeat.i(218704);
    a(parame, null);
    AppMethodBeat.o(218704);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame, int paramInt, long paramLong)
  {
    AppMethodBeat.i(218744);
    if (!this.ZyE.aAF(17))
    {
      parame = new IllegalStateException("error , switch definition , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218744);
      throw parame;
    }
    this.ZyD.a(parame, null);
    if (this.Zyy != null)
    {
      String str = "";
      if (this.ZyH == 2) {
        str = parame.Zzd;
      }
      for (;;)
      {
        this.Zyy.L(str, paramInt, paramLong);
        AppMethodBeat.o(218744);
        return;
        if (this.ZyH == 1) {
          str = parame.Zzc;
        }
      }
    }
    this.Zyx.bDz("switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(218744);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.e parame, Map<String, String> paramMap)
  {
    AppMethodBeat.i(218705);
    if (!this.ZyE.aAF(2))
    {
      parame = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(218705);
      throw parame;
    }
    if (parame == null)
    {
      parame = new IllegalArgumentException("error : setDataSource , data source invalid");
      AppMethodBeat.o(218705);
      throw parame;
    }
    this.ZyD.a(parame, paramMap);
    this.Zyz.changeState(2);
    AppMethodBeat.o(218705);
  }
  
  public final void a(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(218712);
    if (!this.ZyE.aAF(3)) {
      this.Zyx.error("updateVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.ZyG.height = paramTPVideoInfo.getHeight();
      this.ZyG.width = paramTPVideoInfo.getWidth();
      this.ZyG.definition = paramTPVideoInfo.getDefinition();
      this.ZyG.ZxU = com.tencent.thumbplayer.utils.d.aBr(paramTPVideoInfo.getVideoCodecId());
    }
    AppMethodBeat.o(218712);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(218745);
    if (!this.ZyE.aAF(17))
    {
      paramITPMediaAsset = new IllegalStateException("error , switch definition , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218745);
      throw paramITPMediaAsset;
    }
    this.ZyD.setDataSource(paramITPMediaAsset);
    if (this.Zyy != null)
    {
      this.Zyy.a(paramITPMediaAsset, paramInt, paramLong);
      AppMethodBeat.o(218745);
      return;
    }
    this.Zyx.bDz("switchDefinition, mPlayerBase = null!");
    AppMethodBeat.o(218745);
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(218721);
    if (!this.ZyE.aAF(3))
    {
      paramString1 = new IllegalStateException("error : addSubtitleSource , state invalid");
      AppMethodBeat.o(218721);
      throw paramString1;
    }
    if (this.Zyy != null) {
      this.Zyy.addSubtitleSource(paramString1, paramString2, paramString3);
    }
    c localc = this.ZyD;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)))
    {
      c.d locald = new c.d();
      locald.url = paramString1;
      locald.mimeType = paramString2;
      locald.name = paramString3;
      localc.Zye.put(paramString1, locald);
      localc.trackId += 1;
      paramString1 = new TPTrackInfo();
      paramString1.trackType = 3;
      paramString1.name = paramString3;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.Zyp.add(paramString1);
    }
    AppMethodBeat.o(218721);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(218767);
    if (this.Zyy != null)
    {
      this.Zyy.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
      AppMethodBeat.o(218767);
      return;
    }
    paramTPCaptureParams = new IllegalStateException("error , no player for capture :" + this.Zyz);
    AppMethodBeat.o(218767);
    throw paramTPCaptureParams;
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(218731);
    if (!this.ZyE.aAF(3))
    {
      localObject = new IllegalStateException("error : deselectTrack , state invalid");
      AppMethodBeat.o(218731);
      throw ((Throwable)localObject);
    }
    Object localObject = getTrackInfo();
    if (localObject == null)
    {
      this.Zyx.error("fatal err, tpTrackInfos is null");
      AppMethodBeat.o(218731);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(218731);
      throw ((Throwable)localObject);
    }
    if (this.Zyy != null) {
      this.Zyy.deselectTrack(paramInt, paramLong);
    }
    this.ZyD.a(paramInt, localObject[paramInt]);
    AppMethodBeat.o(218731);
  }
  
  public final int getCurrentPlayClipNo()
  {
    if (this.ZyG != null) {
      return this.ZyG.Zyc;
    }
    return 0;
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(218757);
    if (!this.ZyE.aAF(12))
    {
      if (this.ZyG != null)
      {
        l = this.ZyG.Zya;
        AppMethodBeat.o(218757);
        return l;
      }
      AppMethodBeat.o(218757);
      return 0L;
    }
    if (this.Zyy == null)
    {
      this.Zyx.bDz("getCurrentPositionMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(218757);
      return 0L;
    }
    long l = this.Zyy.getCurrentPositionMs();
    if (this.ZyG != null) {
      this.ZyG.Zya = l;
    }
    AppMethodBeat.o(218757);
    return l;
  }
  
  public final int getCurrentState()
  {
    AppMethodBeat.i(218714);
    int i = this.Zyz.state();
    AppMethodBeat.o(218714);
    return i;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(218755);
    if ((this.ZyG != null) && (this.ZyG.durationMs > 0L))
    {
      l = this.ZyG.durationMs;
      AppMethodBeat.o(218755);
      return l;
    }
    if (!this.ZyE.aAF(11))
    {
      AppMethodBeat.o(218755);
      return 0L;
    }
    if (this.Zyy == null)
    {
      this.Zyx.bDz("getDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(218755);
      return 0L;
    }
    long l = this.Zyy.getDurationMs();
    if (this.ZyG != null) {
      this.ZyG.durationMs = l;
    }
    AppMethodBeat.o(218755);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(218758);
    if (!this.ZyE.aAF(12))
    {
      AppMethodBeat.o(218758);
      return 0L;
    }
    if (this.Zyy == null)
    {
      this.Zyx.bDz("getBufferedDurationMs, mPlayerBase = null, return 0!");
      AppMethodBeat.o(218758);
      return 0L;
    }
    long l = this.Zyy.getPlayableDurationMs();
    if (this.ZyG != null) {
      this.ZyG.Zyb = l;
    }
    AppMethodBeat.o(218758);
    return l;
  }
  
  public final int getPlayerType()
  {
    return this.ZyH;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(218766);
    if ((this.Zyy != null) && (this.Zyy.getProgramInfo() != null))
    {
      TPProgramInfo[] arrayOfTPProgramInfo = this.Zyy.getProgramInfo();
      AppMethodBeat.o(218766);
      return arrayOfTPProgramInfo;
    }
    AppMethodBeat.o(218766);
    return new TPProgramInfo[0];
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(218753);
    if (this.Zyy != null)
    {
      long l = this.Zyy.getPropertyLong(paramInt);
      AppMethodBeat.o(218753);
      return l;
    }
    this.Zyx.bDz("getPropertyLong, mPlayerBase = null, return !");
    AppMethodBeat.o(218753);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(218754);
    if (this.Zyy != null)
    {
      String str = this.Zyy.getPropertyString(paramInt);
      AppMethodBeat.o(218754);
      return str;
    }
    this.Zyx.bDz("getPropertyString, mPlayerBase = null, return !");
    AppMethodBeat.o(218754);
    return "";
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(218762);
    if (this.Zyy != null)
    {
      arrayOfTPTrackInfo = this.Zyy.getTrackInfo();
      AppMethodBeat.o(218762);
      return arrayOfTPTrackInfo;
    }
    TPTrackInfo[] arrayOfTPTrackInfo = (TPTrackInfo[])this.ZyD.Zyp.toArray(new TPTrackInfo[0]);
    AppMethodBeat.o(218762);
    return arrayOfTPTrackInfo;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(218761);
    if ((this.ZyG != null) && (this.ZyG.height > 0L))
    {
      i = (int)this.ZyG.height;
      AppMethodBeat.o(218761);
      return i;
    }
    if (!this.ZyE.aAF(13))
    {
      this.Zyx.bDz("getVideoHeight, state error!");
      AppMethodBeat.o(218761);
      return 0;
    }
    if (this.Zyy == null)
    {
      this.Zyx.bDz("getVideoHeight, mPlayerBase = null, return 0!");
      AppMethodBeat.o(218761);
      return 0;
    }
    int i = this.Zyy.getVideoHeight();
    if (this.ZyG != null) {
      this.ZyG.height = i;
    }
    AppMethodBeat.o(218761);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(218759);
    if ((this.ZyG != null) && (this.ZyG.width > 0L))
    {
      i = (int)this.ZyG.width;
      AppMethodBeat.o(218759);
      return i;
    }
    if (!this.ZyE.aAF(13))
    {
      this.Zyx.bDz("getVideoWidth, state error!");
      AppMethodBeat.o(218759);
      return 0;
    }
    if (this.Zyy == null)
    {
      this.Zyx.bDz("getVideoWidth, mPlayerBase = null, return 0!");
      AppMethodBeat.o(218759);
      return 0;
    }
    int i = this.Zyy.getVideoWidth();
    if (this.ZyG != null) {
      this.ZyG.width = i;
    }
    AppMethodBeat.o(218759);
    return i;
  }
  
  public final void h(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(218728);
    if (!this.ZyE.aAF(3))
    {
      paramString1 = new IllegalStateException("error : addAudioTrackSource , state invalid");
      AppMethodBeat.o(218728);
      throw paramString1;
    }
    if (this.Zyy != null) {
      this.Zyy.h(paramString1, paramString2, paramList);
    }
    c localc = this.ZyD;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      c.a locala = new c.a();
      locala.url = paramString1;
      locala.name = paramString2;
      locala.Zyr = paramList;
      localc.Zyf.put(paramString1, locala);
      localc.trackId += 1;
      paramString1 = new TPTrackInfo();
      paramString1.trackType = 2;
      paramString1.name = paramString2;
      paramString1.isSelected = false;
      paramString1.isExclusive = true;
      paramString1.isInternal = false;
      localc.Zyp.add(paramString1);
    }
    AppMethodBeat.o(218728);
  }
  
  public final b iql()
  {
    return this.ZyG;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(218715);
    if ((this.Zyz != null) && (this.Zyz.state() == 5))
    {
      AppMethodBeat.o(218715);
      return true;
    }
    AppMethodBeat.o(218715);
    return false;
  }
  
  public final void onStateChange(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218798);
    this.ZyB.onStateChange(paramInt1, paramInt2);
    AppMethodBeat.o(218798);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(218737);
    IllegalStateException localIllegalStateException1;
    if (!this.ZyE.aAF(6))
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218737);
      throw localIllegalStateException1;
    }
    if (this.Zyy == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(218737);
      throw localIllegalStateException1;
    }
    if (this.ZyA)
    {
      this.Zyz.changeState(6);
      AppMethodBeat.o(218737);
      return;
    }
    try
    {
      this.Zyy.pause();
      this.Zyz.changeState(6);
      AppMethodBeat.o(218737);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(218737);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(218733);
    Object localObject;
    if (!this.ZyE.aAF(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218733);
      throw ((Throwable)localObject);
    }
    if (!this.ZyD.iqm())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(218733);
      throw ((Throwable)localObject);
    }
    this.Zyy = a(iqq(), this.Zyw);
    if (this.Zyy == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(218733);
      throw ((Throwable)localObject);
    }
    this.Zyz.setInnerPlayStateState(3);
    this.Zyz.changeState(3);
    this.Zyy.prepare();
    AppMethodBeat.o(218733);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(218734);
    Object localObject;
    if (!this.ZyE.aAF(1))
    {
      localObject = new IllegalStateException("error , prepare , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218734);
      throw ((Throwable)localObject);
    }
    if (!this.ZyD.iqm())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(218734);
      throw ((Throwable)localObject);
    }
    this.Zyy = a(iqq(), this.Zyw);
    if (this.Zyy == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(218734);
      throw ((Throwable)localObject);
    }
    this.Zyz.setInnerPlayStateState(3);
    this.Zyz.changeState(3);
    this.Zyy.prepareAsync();
    AppMethodBeat.o(218734);
  }
  
  public final void release()
  {
    AppMethodBeat.i(218741);
    this.Zyx.bDy("release, current state :" + this.Zyz);
    if (this.Zyy != null)
    {
      this.Zyy.release();
      this.Zyy = null;
    }
    this.ZyD.reset();
    this.ZyB.clear();
    this.ZyG = null;
    this.ZyF = null;
    this.ZyA = false;
    this.Zyz.changeState(11);
    AppMethodBeat.o(218741);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(218739);
    this.Zyx.bDy("reset, current state :" + this.Zyz);
    if (this.Zyy != null)
    {
      this.Zyy.reset();
      this.Zyy.release();
      this.Zyy = null;
    }
    this.ZyD.reset();
    b localb = this.ZyG;
    localb.ZxR = null;
    localb.ZxS = null;
    localb.ZxT = 0;
    localb.ZxU = 0;
    localb.width = 0L;
    localb.height = 0L;
    localb.ZxV = 0L;
    localb.ZxW = null;
    localb.ZxX = 0;
    localb.ZxY = 0L;
    localb.channels = 0;
    localb.sampleRate = 0L;
    localb.ZxZ = 0;
    localb.Zya = 0L;
    localb.durationMs = 0L;
    localb.Zyb = 0L;
    localb.Zyc = 0;
    this.ZyF = null;
    this.ZyA = false;
    this.Zyz.changeState(1);
    this.Zyz.setLastState(1);
    AppMethodBeat.o(218739);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(218742);
    if (!this.ZyE.aAF(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218742);
      throw localIllegalStateException;
    }
    if (this.Zyy != null)
    {
      if (this.Zyz.state() == 7) {
        this.Zyz.changeState(5);
      }
      this.Zyy.seekTo(paramInt);
      AppMethodBeat.o(218742);
      return;
    }
    this.Zyx.bDz("seekTo, mPlayerBase = null!");
    AppMethodBeat.o(218742);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(218743);
    if (!this.ZyE.aAF(9))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , seek to , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218743);
      throw localIllegalStateException;
    }
    if (this.Zyy != null)
    {
      if (this.Zyz.state() == 7) {
        this.Zyz.changeState(5);
      }
      this.Zyy.seekTo(paramInt1, paramInt2);
      AppMethodBeat.o(218743);
      return;
    }
    this.Zyx.bDz("seekTo, mPlayerBase = null!");
    AppMethodBeat.o(218743);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(218765);
    if (!this.ZyE.aAF(18))
    {
      localObject = new IllegalStateException("error : selectProgram , state invalid");
      AppMethodBeat.o(218765);
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
      AppMethodBeat.o(218765);
      throw ((Throwable)localObject);
    }
    if (this.Zyy != null) {
      this.Zyy.selectProgram(paramInt, paramLong);
    }
    this.ZyD.Zyq = localObject[paramInt];
    AppMethodBeat.o(218765);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(218729);
    if (!this.ZyE.aAF(3))
    {
      localObject = new IllegalStateException("error : selectTrack , state invalid");
      AppMethodBeat.o(218729);
      throw ((Throwable)localObject);
    }
    Object localObject = getTrackInfo();
    if (localObject == null)
    {
      this.Zyx.error("fatal err, tpTrackInfos is null");
      AppMethodBeat.o(218729);
      return;
    }
    if ((paramInt < 0) || (paramInt > localObject.length - 1))
    {
      localObject = new IllegalArgumentException("error : track not found");
      AppMethodBeat.o(218729);
      throw ((Throwable)localObject);
    }
    if (this.Zyy != null) {
      this.Zyy.selectTrack(paramInt, paramLong);
    }
    this.ZyD.a(paramInt, paramLong, localObject[paramInt]);
    AppMethodBeat.o(218729);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(218747);
    if (!this.ZyE.aAF(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218747);
      throw localIllegalStateException;
    }
    if (this.Zyy != null) {
      this.Zyy.setAudioGainRatio(paramFloat);
    }
    for (;;)
    {
      this.ZyD.Zyl = paramFloat;
      AppMethodBeat.o(218747);
      return;
      this.Zyx.bDy("setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString)
  {
    AppMethodBeat.i(218749);
    if (!this.ZyE.aAF(3))
    {
      paramString = new IllegalStateException("error , setAudioNormalizeVolumeParams , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218749);
      throw paramString;
    }
    if (this.Zyy != null) {
      this.Zyy.setAudioNormalizeVolumeParams(paramString);
    }
    for (;;)
    {
      this.ZyD.Zym = paramString;
      AppMethodBeat.o(218749);
      return;
      this.Zyx.bDy("setAudioGainRatio, mPlayerBase = null!");
    }
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(218707);
    if (!this.ZyE.aAF(2))
    {
      paramParcelFileDescriptor = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(218707);
      throw paramParcelFileDescriptor;
    }
    if (paramParcelFileDescriptor == null)
    {
      paramParcelFileDescriptor = new IllegalArgumentException("error : setDataSource , pfd invalid");
      AppMethodBeat.o(218707);
      throw paramParcelFileDescriptor;
    }
    this.ZyD.setDataSource(paramParcelFileDescriptor);
    this.Zyz.changeState(2);
    AppMethodBeat.o(218707);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(218710);
    if (!this.ZyE.aAF(2))
    {
      paramITPMediaAsset = new IllegalStateException("error : setDataSource , state invalid");
      AppMethodBeat.o(218710);
      throw paramITPMediaAsset;
    }
    if (paramITPMediaAsset == null)
    {
      paramITPMediaAsset = new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
      AppMethodBeat.o(218710);
      throw paramITPMediaAsset;
    }
    this.ZyD.setDataSource(paramITPMediaAsset);
    this.Zyz.changeState(2);
    AppMethodBeat.o(218710);
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap) {}
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(218751);
    if (!this.ZyE.aAF(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218751);
      throw localIllegalStateException;
    }
    if (this.Zyy != null) {
      this.Zyy.setLoopback(paramBoolean);
    }
    for (;;)
    {
      this.ZyD.setLoopback(paramBoolean);
      AppMethodBeat.o(218751);
      return;
      this.Zyx.bDy("setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(218752);
    if (!this.ZyE.aAF(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setLoopback , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218752);
      throw localIllegalStateException;
    }
    if (this.Zyy != null) {
      this.Zyy.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    for (;;)
    {
      this.ZyD.setLoopback(paramBoolean, paramLong1, paramLong2);
      AppMethodBeat.o(218752);
      return;
      this.Zyx.bDy("setLoopback, mPlayerBase = null!");
    }
  }
  
  public final void setOnPlayerStateChangeListener(c.h paramh)
  {
    this.ZyB.ZyV = paramh;
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(218746);
    if (!this.ZyE.aAF(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218746);
      throw localIllegalStateException;
    }
    if (this.Zyy != null) {
      this.Zyy.setOutputMute(paramBoolean);
    }
    for (;;)
    {
      this.ZyD.Zyk = paramBoolean;
      AppMethodBeat.o(218746);
      return;
      this.Zyx.bDy("setOutputMute, mPlayerBase = null!");
    }
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(218750);
    if (!this.ZyE.aAF(3))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218750);
      throw localIllegalStateException;
    }
    if (this.Zyy != null) {
      this.Zyy.setPlaySpeedRatio(paramFloat);
    }
    for (;;)
    {
      this.ZyD.Zyn = paramFloat;
      AppMethodBeat.o(218750);
      return;
      this.Zyx.bDy("setPlaySpeedRatio, mPlayerBase = null!");
    }
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(218697);
    if (!this.ZyE.aAF(3))
    {
      paramTPOptionalParam = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(218697);
      throw paramTPOptionalParam;
    }
    if (this.Zyy != null) {
      this.Zyy.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.ZyD.a(paramTPOptionalParam);
    AppMethodBeat.o(218697);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(218701);
    if (!this.ZyE.aAF(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(218701);
      throw paramSurface;
    }
    if (this.Zyy != null) {
      this.Zyy.setSurface(paramSurface);
    }
    this.ZyD.Zyd = paramSurface;
    AppMethodBeat.o(218701);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(218703);
    if (!this.ZyE.aAF(4))
    {
      paramSurfaceHolder = new IllegalStateException("setSurfaceHolder , state invalid");
      AppMethodBeat.o(218703);
      throw paramSurfaceHolder;
    }
    if (this.Zyy != null) {
      this.Zyy.setSurfaceHolder(paramSurfaceHolder);
    }
    this.ZyD.Zyd = paramSurfaceHolder;
    AppMethodBeat.o(218703);
  }
  
  public final void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    AppMethodBeat.i(218711);
    if (!this.ZyE.aAF(2)) {
      this.Zyx.error("setVideoInfo state invalid");
    }
    if (paramTPVideoInfo != null)
    {
      this.ZyG.height = paramTPVideoInfo.getHeight();
      this.ZyG.width = paramTPVideoInfo.getWidth();
      this.ZyG.definition = paramTPVideoInfo.getDefinition();
      this.ZyG.ZxU = com.tencent.thumbplayer.utils.d.aBr(paramTPVideoInfo.getVideoCodecId());
    }
    AppMethodBeat.o(218711);
  }
  
  public final void start()
  {
    AppMethodBeat.i(218735);
    IllegalStateException localIllegalStateException1;
    if (!this.ZyE.aAF(5))
    {
      localIllegalStateException1 = new IllegalStateException("error , start , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218735);
      throw localIllegalStateException1;
    }
    if (this.Zyy == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(218735);
      throw localIllegalStateException1;
    }
    try
    {
      this.Zyy.start();
      this.Zyz.changeState(5);
      AppMethodBeat.o(218735);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(218735);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(218738);
    IllegalStateException localIllegalStateException1;
    if (!this.ZyE.aAF(7))
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , state invalid , current state :" + this.Zyz);
      AppMethodBeat.o(218738);
      throw localIllegalStateException1;
    }
    if (this.Zyy == null)
    {
      localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(218738);
      throw localIllegalStateException1;
    }
    try
    {
      this.Zyz.changeState(8);
      this.Zyy.stop();
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , stop ,state invalid");
      AppMethodBeat.o(218738);
      throw localIllegalStateException3;
    }
    finally
    {
      this.Zyz.changeState(9);
      AppMethodBeat.o(218738);
    }
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(218694);
    this.Zyw.a(paramb, "TPPlayerAdapter");
    this.Zyx.a(this.Zyw);
    this.ZyB.bDr(this.Zyw.tag);
    if (this.Zyy != null) {
      this.Zyy.updateLoggerContext(this.Zyw);
    }
    AppMethodBeat.o(218694);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, com.tencent.thumbplayer.a.a.c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.g, c.i, c.j, c.k, c.l, c.m
  {
    private a() {}
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(218687);
      paramTPPostProcessFrameBuffer = d.a(d.this, paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(218687);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(218679);
      d.a(d.this, paramInt1, paramInt2, paramLong1, paramLong2);
      AppMethodBeat.o(218679);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(218677);
      d.a(d.this, paramInt, paramLong1, paramLong2, paramObject);
      AppMethodBeat.o(218677);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(218686);
      d.a(d.this, paramTPAudioFrameBuffer);
      AppMethodBeat.o(218686);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(218683);
      d.a(d.this, paramTPSubtitleData);
      AppMethodBeat.o(218683);
    }
    
    public final void a(TPSubtitleFrameBuffer paramTPSubtitleFrameBuffer)
    {
      AppMethodBeat.i(218684);
      d.a(d.this, paramTPSubtitleFrameBuffer);
      AppMethodBeat.o(218684);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(218685);
      d.a(d.this, paramTPVideoFrameBuffer);
      AppMethodBeat.o(218685);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(218688);
      paramTPPostProcessFrameBuffer = d.b(d.this, paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(218688);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void ba(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(218681);
      d.a(d.this, paramLong1, paramLong2);
      AppMethodBeat.o(218681);
    }
    
    public final void cYp()
    {
      AppMethodBeat.i(218680);
      d.c(d.this);
      AppMethodBeat.o(218680);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(218675);
      d.b(d.this);
      AppMethodBeat.o(218675);
    }
    
    public final void qX()
    {
      AppMethodBeat.i(218671);
      d.a(d.this);
      AppMethodBeat.o(218671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.d
 * JD-Core Version:    0.7.0.1
 */