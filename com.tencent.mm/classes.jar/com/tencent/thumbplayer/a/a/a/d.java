package com.tencent.thumbplayer.a.a.a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.c.c;
import com.tencent.thumbplayer.a.a.c.e;
import com.tencent.thumbplayer.a.a.c.f;
import com.tencent.thumbplayer.a.a.c.g;
import com.tencent.thumbplayer.a.a.c.i;
import com.tencent.thumbplayer.a.a.c.j;
import com.tencent.thumbplayer.a.a.c.k;
import com.tencent.thumbplayer.a.a.c.l;
import com.tencent.thumbplayer.a.a.c.m;
import com.tencent.thumbplayer.a.c;
import com.tencent.thumbplayer.a.f;
import com.tencent.thumbplayer.a.g;
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
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.f.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d
  implements com.tencent.thumbplayer.a.a.b
{
  private com.tencent.thumbplayer.f.b RVM;
  a RVN;
  com.tencent.thumbplayer.a.a.b RVO;
  TPPlayerState RVP;
  com.tencent.thumbplayer.a.e RVR;
  c RVT;
  g RVU;
  com.tencent.thumbplayer.a.b RVW;
  private a RWI;
  List<ITPMediaTrackClip> RWJ;
  int RWK;
  boolean RWL;
  boolean RWM;
  LinkedList<Long> RWN;
  private Context mContext;
  
  public d(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(188790);
    this.RWK = 0;
    this.RVM = new com.tencent.thumbplayer.f.b(paramb, "TPSystemClipPlayer");
    this.RVN = new a(this.RVM);
    this.mContext = paramContext;
    this.RVP = new TPPlayerState();
    this.RVT = new c();
    this.RWI = new a((byte)0);
    this.RVR = new com.tencent.thumbplayer.a.e(this.RVN.RVM.tag);
    this.RVU = new g(this.RVP);
    this.RWJ = new ArrayList();
    AppMethodBeat.o(188790);
  }
  
  private static List<ITPMediaTrackClip> a(ITPMediaAsset paramITPMediaAsset)
  {
    int i = 0;
    AppMethodBeat.i(188812);
    if ((!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.d)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.e)))
    {
      paramITPMediaAsset = new IllegalStateException("system mediaPlayer : media asset is illegal source!");
      AppMethodBeat.o(188812);
      throw paramITPMediaAsset;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b))
    {
      paramITPMediaAsset = ((com.tencent.thumbplayer.c.b)paramITPMediaAsset).getAllAVTracks();
      if ((com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset)) || (paramITPMediaAsset.get(0) == null))
      {
        paramITPMediaAsset = new IllegalStateException("empty av tracks when set data source!");
        AppMethodBeat.o(188812);
        throw paramITPMediaAsset;
      }
      paramITPMediaAsset = ((ITPMediaTrack)paramITPMediaAsset.get(0)).getAllTrackClips();
    }
    for (;;)
    {
      long l = 0L;
      while (i < paramITPMediaAsset.size())
      {
        ((ITPMediaTrackClip)paramITPMediaAsset.get(i)).setStartPositionMs(l);
        l += ((ITPMediaTrackClip)paramITPMediaAsset.get(i)).getOriginalDurationMs();
        i += 1;
      }
      if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.d))
      {
        paramITPMediaAsset = ((com.tencent.thumbplayer.c.d)paramITPMediaAsset).getAllTrackClips();
      }
      else
      {
        localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
        paramITPMediaAsset = localArrayList;
      }
    }
    AppMethodBeat.o(188812);
    return paramITPMediaAsset;
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(188845);
    if (1 == this.RVT.RVy.mType) {
      paramb.setDataSource(this.RVT.RVy.RWn);
    }
    if (this.RVT.RVy.mType == 0) {
      paramb.setDataSource(this.RVT.RVy.mUrl, this.RVT.RVy.RWo);
    }
    Iterator localIterator = this.RVT.hmO().iterator();
    while (localIterator.hasNext()) {
      paramb.setPlayerOptionalParam((TPOptionalParam)localIterator.next());
    }
    localIterator = this.RVT.hmM().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.d)localIterator.next();
      paramb.addSubtitleSource(((com.tencent.thumbplayer.a.c.d)localObject).url, ((com.tencent.thumbplayer.a.c.d)localObject).mimeType, ((com.tencent.thumbplayer.a.c.d)localObject).name);
    }
    localIterator = this.RVT.hmN().iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.a)localIterator.next();
      paramb.g(((com.tencent.thumbplayer.a.c.a)localObject).url, ((com.tencent.thumbplayer.a.c.a)localObject).name, ((com.tencent.thumbplayer.a.c.a)localObject).RVH);
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
    if ((this.RVT.RVt instanceof SurfaceHolder)) {
      paramb.setSurfaceHolder((SurfaceHolder)this.RVT.RVt);
    }
    for (;;)
    {
      paramb.a(this.RWI);
      paramb.a(this.RWI);
      paramb.a(this.RWI);
      paramb.a(this.RWI);
      paramb.a(this.RWI);
      paramb.a(this.RWI);
      paramb.a(this.RWI);
      AppMethodBeat.o(188845);
      return;
      if ((this.RVT.RVt instanceof Surface)) {
        paramb.setSurface((Surface)this.RVT.RVt);
      }
    }
  }
  
  private void aqU(int paramInt)
  {
    AppMethodBeat.i(188813);
    int i = 0;
    for (;;)
    {
      if (i < this.RWJ.size())
      {
        long l;
        if ((((ITPMediaTrackClip)this.RWJ.get(i)).getStartPositionMs() <= paramInt) && (paramInt <= ((ITPMediaTrackClip)this.RWJ.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.RWJ.get(i)).getOriginalDurationMs())) {
          l = paramInt;
        }
        try
        {
          aX(i, l - ((ITPMediaTrackClip)this.RWJ.get(i)).getStartPositionMs());
          i += 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.RVN.info("selectClipPlayer:" + localIOException.toString());
          }
        }
      }
    }
    AppMethodBeat.o(188813);
  }
  
  private ITPMediaTrackClip hmR()
  {
    AppMethodBeat.i(188843);
    ITPMediaTrackClip localITPMediaTrackClip = (ITPMediaTrackClip)this.RWJ.get(this.RWK);
    AppMethodBeat.o(188843);
    return localITPMediaTrackClip;
  }
  
  private com.tencent.thumbplayer.a.a.b hmS()
  {
    AppMethodBeat.i(188844);
    e locale = new e(this.mContext, this.RVM);
    if (this.RVW == null) {
      this.RVW = new com.tencent.thumbplayer.a.b();
    }
    a(locale);
    AppMethodBeat.o(188844);
    return locale;
  }
  
  public final void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(188839);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(188839);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    AppMethodBeat.i(188841);
    paramb = new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    AppMethodBeat.o(188841);
    throw paramb;
  }
  
  public final void a(c.c paramc)
  {
    AppMethodBeat.i(188831);
    this.RVR.a(paramc);
    AppMethodBeat.o(188831);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    AppMethodBeat.i(188833);
    this.RVR.a(paramd);
    AppMethodBeat.o(188833);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(188832);
    this.RVR.a(parame);
    AppMethodBeat.o(188832);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(188830);
    this.RVR.a(paramf);
    AppMethodBeat.o(188830);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(188834);
    this.RVR.a(paramg);
    AppMethodBeat.o(188834);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(188836);
    this.RVR.a(parami);
    AppMethodBeat.o(188836);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(188837);
    paramj = new IllegalStateException("system Mediaplayer now not support subtitle frame out");
    AppMethodBeat.o(188837);
    throw paramj;
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(188838);
    paramk = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(188838);
    throw paramk;
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(188840);
    paraml = new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    AppMethodBeat.o(188840);
    throw paraml;
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(188835);
    this.RVR.a(paramm);
    AppMethodBeat.o(188835);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(188811);
    paramITPMediaAsset = a(paramITPMediaAsset);
    if (com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset))
    {
      paramITPMediaAsset = new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
      AppMethodBeat.o(188811);
      throw paramITPMediaAsset;
    }
    long l = getCurrentPositionMs();
    try
    {
      this.RWJ = paramITPMediaAsset;
      this.RWM = true;
      if (com.tencent.thumbplayer.utils.b.isEmpty(this.RWN)) {
        this.RWN = new LinkedList();
      }
      this.RWN.offer(Long.valueOf(paramLong));
      this.RVN.info("try to switch definition with system clip player, current clipNo:" + this.RWK);
      aqU((int)l);
      AppMethodBeat.o(188811);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.RVN.r(paramITPMediaAsset);
      paramITPMediaAsset = new IllegalStateException("exception when system clip player switch definition!");
      AppMethodBeat.o(188811);
      throw paramITPMediaAsset;
    }
  }
  
  final void aX(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188842);
    this.RVN.debug("switchPlayer: clipNo:" + paramInt + "   startPostion:" + paramLong);
    if (this.RVO != null) {
      this.RVO.release();
    }
    this.RWL = true;
    this.RWK = paramInt;
    this.RVT.setDataSource(((ITPMediaTrackClip)this.RWJ.get(this.RWK)).getFilePath());
    this.RVO = hmS();
    if (this.RVO == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(188842);
      throw ((Throwable)localObject);
    }
    Object localObject = new TPOptionalParam().buildLong(100, paramLong);
    this.RVO.setPlayerOptionalParam((TPOptionalParam)localObject);
    this.RVO.prepare();
    AppMethodBeat.o(188842);
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(188798);
    this.RVN.error("addSubtitleSource not supported.");
    AppMethodBeat.o(188798);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(188829);
    if (this.RVO != null) {
      this.RVO.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
    }
    AppMethodBeat.o(188829);
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188801);
    this.RVN.error("deselectTrack not supported.");
    AppMethodBeat.o(188801);
  }
  
  public final void g(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(188799);
    this.RVN.error("addAudioTrackSource not supported.");
    AppMethodBeat.o(188799);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(188822);
    long l1 = 0L;
    int i = 0;
    while ((i < this.RWJ.size()) && (i < this.RWK))
    {
      l1 += ((ITPMediaTrackClip)this.RWJ.get(i)).getOriginalDurationMs();
      i += 1;
    }
    if (!this.RVU.aqS(12))
    {
      AppMethodBeat.o(188822);
      return l1;
    }
    long l2 = this.RVO.getCurrentPositionMs();
    AppMethodBeat.o(188822);
    return l1 + l2;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(188821);
    Iterator localIterator = this.RWJ.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((ITPMediaTrackClip)localIterator.next()).getOriginalDurationMs() + l) {}
    AppMethodBeat.o(188821);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(188823);
    if (!this.RVU.aqS(15))
    {
      if (this.RVW != null)
      {
        l = this.RVW.RVr;
        AppMethodBeat.o(188823);
        return l;
      }
      AppMethodBeat.o(188823);
      return 0L;
    }
    long l = this.RVO.getPlayableDurationMs();
    AppMethodBeat.o(188823);
    return l;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(188828);
    this.RVN.error("getProgramInfo not supported.");
    AppMethodBeat.o(188828);
    return new TPProgramInfo[0];
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(188819);
    if (this.RVO != null)
    {
      long l = this.RVO.getPropertyLong(paramInt);
      AppMethodBeat.o(188819);
      return l;
    }
    AppMethodBeat.o(188819);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(188820);
    if (this.RVO != null)
    {
      String str = this.RVO.getPropertyString(paramInt);
      AppMethodBeat.o(188820);
      return str;
    }
    AppMethodBeat.o(188820);
    return "";
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(188826);
    this.RVN.error("getTrackInfo not supported.");
    AppMethodBeat.o(188826);
    return new TPTrackInfo[0];
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(188825);
    if (this.RVW == null)
    {
      AppMethodBeat.o(188825);
      return 0;
    }
    if (this.RVW.height > 0L)
    {
      i = (int)this.RVW.height;
      AppMethodBeat.o(188825);
      return i;
    }
    if (!this.RVU.aqS(13))
    {
      AppMethodBeat.o(188825);
      return 0;
    }
    this.RVW.height = this.RVO.getVideoHeight();
    int i = (int)this.RVW.height;
    AppMethodBeat.o(188825);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(188824);
    if (this.RVW == null)
    {
      AppMethodBeat.o(188824);
      return 0;
    }
    if (this.RVW.width > 0L)
    {
      i = (int)this.RVW.width;
      AppMethodBeat.o(188824);
      return i;
    }
    if (!this.RVU.aqS(13))
    {
      AppMethodBeat.o(188824);
      return 0;
    }
    this.RVW.width = this.RVO.getVideoWidth();
    int i = (int)this.RVW.width;
    AppMethodBeat.o(188824);
    return i;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(188805);
    if (!this.RVU.aqS(6))
    {
      AppMethodBeat.o(188805);
      return;
    }
    if (this.RVO == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(188805);
      throw localIllegalStateException1;
    }
    try
    {
      this.RVO.pause();
      this.RVP.changeState(6);
      AppMethodBeat.o(188805);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(188805);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(188802);
    if (!this.RVU.aqS(1))
    {
      AppMethodBeat.o(188802);
      return;
    }
    Object localObject;
    if (!this.RVT.hmL())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(188802);
      throw ((Throwable)localObject);
    }
    this.RVO = hmS();
    if (this.RVO == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(188802);
      throw ((Throwable)localObject);
    }
    this.RVP.changeState(3);
    this.RVO.prepare();
    AppMethodBeat.o(188802);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(188803);
    if (!this.RVU.aqS(1))
    {
      AppMethodBeat.o(188803);
      return;
    }
    Object localObject;
    if (!this.RVT.hmL())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(188803);
      throw ((Throwable)localObject);
    }
    this.RVO = hmS();
    if (this.RVO == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(188803);
      throw ((Throwable)localObject);
    }
    this.RVP.changeState(3);
    this.RVO.prepareAsync();
    AppMethodBeat.o(188803);
  }
  
  public final void release()
  {
    AppMethodBeat.i(188808);
    this.RVN.info("release, current state:" + this.RVP);
    if (this.RVO != null)
    {
      this.RVO.release();
      this.RVO = null;
    }
    this.RVT.reset();
    this.RVR.clear();
    this.RVP.changeState(11);
    AppMethodBeat.o(188808);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(188807);
    this.RVN.info("reset, current state:" + this.RVP);
    if (this.RVO != null) {
      this.RVO.reset();
    }
    this.RVT.reset();
    this.RVR.clear();
    this.RVP.changeState(1);
    AppMethodBeat.o(188807);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(188809);
    if (!this.RVU.aqS(9))
    {
      AppMethodBeat.o(188809);
      return;
    }
    if ((paramInt >= hmR().getStartPositionMs()) && (paramInt <= hmR().getStartPositionMs() + hmR().getOriginalDurationMs()))
    {
      if (this.RVO != null)
      {
        this.RVN.debug("seek to:".concat(String.valueOf(paramInt)));
        this.RVO.seekTo((int)(paramInt - hmR().getStartPositionMs()));
        AppMethodBeat.o(188809);
      }
    }
    else {
      aqU(paramInt);
    }
    AppMethodBeat.o(188809);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(188810);
    if (!this.RVU.aqS(9))
    {
      AppMethodBeat.o(188810);
      return;
    }
    if ((paramInt1 >= hmR().getStartPositionMs()) && (paramInt1 <= hmR().getStartPositionMs() + hmR().getOriginalDurationMs()))
    {
      if (this.RVO != null)
      {
        this.RVN.debug("seek to:" + paramInt1 + "/mode=" + paramInt2);
        this.RVO.seekTo((int)(paramInt1 - hmR().getStartPositionMs()), paramInt2);
        AppMethodBeat.o(188810);
      }
    }
    else {
      aqU(paramInt1);
    }
    AppMethodBeat.o(188810);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188827);
    this.RVN.error("selectProgram not supported.");
    AppMethodBeat.o(188827);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(188800);
    this.RVN.error("selectTrack not supported.");
    AppMethodBeat.o(188800);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(188815);
    if (!this.RVU.aqS(3))
    {
      AppMethodBeat.o(188815);
      return;
    }
    if (this.RVO != null) {
      this.RVO.setAudioGainRatio(paramFloat);
    }
    this.RVT.RVB = paramFloat;
    AppMethodBeat.o(188815);
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString) {}
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(188796);
    this.RVT.setDataSource(paramParcelFileDescriptor);
    this.RVP.changeState(2);
    AppMethodBeat.o(188796);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(188797);
    paramITPMediaAsset = a(paramITPMediaAsset);
    try
    {
      this.RWJ = paramITPMediaAsset;
      this.RVT.setDataSource(((ITPMediaTrackClip)this.RWJ.get(this.RWK)).getFilePath());
      this.RVP.changeState(2);
      AppMethodBeat.o(188797);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.RVN.r(paramITPMediaAsset);
      paramITPMediaAsset = new IllegalStateException("exception when system clip player set data source!");
      AppMethodBeat.o(188797);
      throw paramITPMediaAsset;
    }
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(188795);
    this.RVT.setDataSource(paramString, paramMap);
    this.RVP.changeState(2);
    AppMethodBeat.o(188795);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(188817);
    if (!this.RVU.aqS(3))
    {
      AppMethodBeat.o(188817);
      return;
    }
    if (this.RVO != null) {
      this.RVO.setLoopback(paramBoolean);
    }
    this.RVT.setLoopback(paramBoolean);
    AppMethodBeat.o(188817);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(188818);
    if (!this.RVU.aqS(3))
    {
      AppMethodBeat.o(188818);
      return;
    }
    if (this.RVO != null) {
      this.RVO.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    this.RVT.setLoopback(paramBoolean, paramLong1, paramLong2);
    AppMethodBeat.o(188818);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(188814);
    if (!this.RVU.aqS(3))
    {
      AppMethodBeat.o(188814);
      return;
    }
    if (this.RVO != null) {
      this.RVO.setOutputMute(paramBoolean);
    }
    this.RVT.RVA = paramBoolean;
    AppMethodBeat.o(188814);
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(188816);
    if (!this.RVU.aqS(3))
    {
      AppMethodBeat.o(188816);
      return;
    }
    if (this.RVO != null) {
      this.RVO.setPlaySpeedRatio(paramFloat);
    }
    this.RVT.RVD = paramFloat;
    AppMethodBeat.o(188816);
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(188792);
    if (!this.RVU.aqS(3))
    {
      paramTPOptionalParam = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(188792);
      throw paramTPOptionalParam;
    }
    if (paramTPOptionalParam.getKey() == 100)
    {
      int j = (int)paramTPOptionalParam.getParamLong().value;
      this.RVN.debug("start position:".concat(String.valueOf(j)));
      int i = 0;
      while (i < this.RWJ.size())
      {
        if ((((ITPMediaTrackClip)this.RWJ.get(i)).getStartPositionMs() <= j) && (j <= ((ITPMediaTrackClip)this.RWJ.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.RWJ.get(i)).getOriginalDurationMs()))
        {
          this.RWK = i;
          this.RVT.setDataSource(((ITPMediaTrackClip)this.RWJ.get(i)).getFilePath());
          paramTPOptionalParam.getParamLong().value = (j - ((ITPMediaTrackClip)this.RWJ.get(i)).getStartPositionMs());
        }
        i += 1;
      }
    }
    if (this.RVO != null) {
      this.RVO.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.RVT.a(paramTPOptionalParam);
    AppMethodBeat.o(188792);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(188793);
    if (!this.RVU.aqS(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(188793);
      throw paramSurface;
    }
    if (this.RVO != null) {
      this.RVO.setSurface(paramSurface);
    }
    this.RVT.RVt = paramSurface;
    AppMethodBeat.o(188793);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(188794);
    if (!this.RVU.aqS(4))
    {
      paramSurfaceHolder = new IllegalStateException("setSurfaceHolder , state invalid");
      AppMethodBeat.o(188794);
      throw paramSurfaceHolder;
    }
    if (this.RVO != null) {
      this.RVO.setSurfaceHolder(paramSurfaceHolder);
    }
    this.RVT.RVt = paramSurfaceHolder;
    AppMethodBeat.o(188794);
  }
  
  public final void start()
  {
    AppMethodBeat.i(188804);
    if (!this.RVU.aqS(5))
    {
      AppMethodBeat.o(188804);
      return;
    }
    if (this.RVO == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(188804);
      throw localIllegalStateException1;
    }
    try
    {
      this.RVO.start();
      this.RVP.changeState(5);
      AppMethodBeat.o(188804);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(188804);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(188806);
    if (!this.RVU.aqS(7))
    {
      AppMethodBeat.o(188806);
      return;
    }
    if (this.RVO == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(188806);
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
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(188806);
      throw localIllegalStateException3;
    }
    finally
    {
      this.RVP.changeState(9);
      AppMethodBeat.o(188806);
    }
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(188791);
    this.RVN.a(new com.tencent.thumbplayer.f.b(paramb, "TPSystemClipPlayer"));
    if ((this.RVR != null) && (paramb != null)) {
      this.RVR.bqx(this.RVN.RVM.tag);
    }
    AppMethodBeat.o(188791);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.g, c.i, c.k, c.l, c.m
  {
    private a() {}
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(188788);
      d locald = d.this;
      if (!locald.RVU.aqT(7))
      {
        AppMethodBeat.o(188788);
        return null;
      }
      paramTPPostProcessFrameBuffer = locald.RVR.a(paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(188788);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(188782);
      d locald = d.this;
      if (locald.RVU.aqT(4)) {
        locald.RVR.a(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      AppMethodBeat.o(188782);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(188781);
      d locald = d.this;
      if (locald.RVU.aqT(3)) {
        locald.RVR.a(paramInt, paramLong1, paramLong2, paramObject);
      }
      AppMethodBeat.o(188781);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(188787);
      d locald = d.this;
      if (locald.RVU.aqT(7)) {
        locald.RVR.a(paramTPAudioFrameBuffer);
      }
      AppMethodBeat.o(188787);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(188785);
      d locald = d.this;
      if (locald.RVU.aqT(7)) {
        locald.RVR.a(paramTPSubtitleData);
      }
      AppMethodBeat.o(188785);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(188786);
      d locald = d.this;
      if (locald.RVU.aqT(7)) {
        locald.RVR.a(paramTPVideoFrameBuffer);
      }
      AppMethodBeat.o(188786);
    }
    
    public final void aI(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(188784);
      d locald = d.this;
      if (locald.RVU.aqT(6))
      {
        locald.RVW.height = paramLong2;
        locald.RVW.width = paramLong1;
        locald.RVR.aI(paramLong1, paramLong2);
      }
      AppMethodBeat.o(188784);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(188789);
      d locald = d.this;
      if (!locald.RVU.aqT(7))
      {
        AppMethodBeat.o(188789);
        return null;
      }
      paramTPPostProcessFrameBuffer = locald.RVR.b(paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(188789);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void cJH()
    {
      AppMethodBeat.i(188783);
      d locald = d.this;
      if (locald.RVU.aqT(5)) {
        locald.RVR.cJH();
      }
      AppMethodBeat.o(188783);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(188780);
      d locald = d.this;
      if (locald.RVU.aqT(2))
      {
        if (locald.RWK >= locald.RWJ.size() - 1)
        {
          locald.RVP.changeState(7);
          locald.RVR.onCompletion();
          AppMethodBeat.o(188780);
          return;
        }
        try
        {
          locald.aX(locald.RWK + 1, 0L);
          AppMethodBeat.o(188780);
          return;
        }
        catch (IOException localIOException)
        {
          locald.RVN.info("handleOnComplete:" + localIOException.toString());
        }
      }
      AppMethodBeat.o(188780);
    }
    
    public final void tf()
    {
      AppMethodBeat.i(188779);
      d locald = d.this;
      if (locald.RVR != null) {
        locald.RVR.a(152, locald.RWK, 0L, null);
      }
      Object localObject;
      if (locald.RWL)
      {
        locald.start();
        if ((locald.RWM) && (locald.RVR != null) && (!com.tencent.thumbplayer.utils.b.isEmpty(locald.RWN)))
        {
          localObject = (Long)locald.RWN.poll();
          if (localObject != null) {
            locald.RVR.a(3, ((Long)localObject).longValue(), 0L, null);
          }
          locald.RWM = false;
        }
        AppMethodBeat.o(188779);
        return;
      }
      if (locald.RVU.aqT(1))
      {
        locald.RVP.changeState(4);
        if (locald.RVR != null) {
          locald.RVR.tf();
        }
        localObject = locald.RVO;
        TPTrackInfo[] arrayOfTPTrackInfo = locald.getTrackInfo();
        if (arrayOfTPTrackInfo != null)
        {
          int i = 0;
          while (i < arrayOfTPTrackInfo.length)
          {
            int j = arrayOfTPTrackInfo[i].getTrackType();
            TPTrackInfo localTPTrackInfo = (TPTrackInfo)locald.RVT.RVE.get(Integer.valueOf(j));
            if (arrayOfTPTrackInfo[i].equals(localTPTrackInfo)) {
              ((com.tencent.thumbplayer.a.a.b)localObject).selectTrack(i, -1L);
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(188779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */