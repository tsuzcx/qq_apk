package com.tencent.thumbplayer.a.a.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
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
import com.tencent.thumbplayer.api.TPCommonEnum.TPSurfaceType;
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
  a ahDA;
  com.tencent.thumbplayer.a.a.b ahDB;
  TPPlayerState ahDC;
  com.tencent.thumbplayer.a.e ahDE;
  c ahDG;
  g ahDH;
  com.tencent.thumbplayer.a.b ahDJ;
  private com.tencent.thumbplayer.f.b ahDz;
  private a ahEu;
  List<ITPMediaTrackClip> ahEv;
  int ahEw;
  boolean ahEx;
  boolean ahEy;
  LinkedList<Long> ahEz;
  private Context mContext;
  
  public d(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228665);
    this.ahEw = 0;
    this.ahDz = new com.tencent.thumbplayer.f.b(paramb, "TPSystemClipPlayer");
    this.ahDA = new a(this.ahDz);
    this.mContext = paramContext;
    this.ahDC = new TPPlayerState();
    this.ahDG = new c();
    this.ahEu = new a((byte)0);
    this.ahDE = new com.tencent.thumbplayer.a.e(this.ahDA.ahDz.tag);
    this.ahDH = new g(this.ahDC);
    this.ahEv = new ArrayList();
    AppMethodBeat.o(228665);
  }
  
  private static List<ITPMediaTrackClip> a(ITPMediaAsset paramITPMediaAsset)
  {
    int i = 0;
    AppMethodBeat.i(228674);
    if ((!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.d)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.e)))
    {
      paramITPMediaAsset = new IllegalStateException("system mediaPlayer : media asset is illegal source!");
      AppMethodBeat.o(228674);
      throw paramITPMediaAsset;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b))
    {
      paramITPMediaAsset = ((com.tencent.thumbplayer.c.b)paramITPMediaAsset).getAllAVTracks();
      if ((com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset)) || (paramITPMediaAsset.get(0) == null))
      {
        paramITPMediaAsset = new IllegalStateException("empty av tracks when set data source!");
        AppMethodBeat.o(228674);
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
    AppMethodBeat.o(228674);
    return paramITPMediaAsset;
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(228717);
    if (1 == this.ahDG.ahDl.mType) {
      paramb.setDataSource(this.ahDG.ahDl.ahEa);
    }
    for (;;)
    {
      if (this.ahDG.ahDl.mType == 0) {
        paramb.setDataSource(this.ahDG.ahDl.mUrl, this.ahDG.ahDl.mHttpHeaders);
      }
      localIterator = this.ahDG.jZK().iterator();
      while (localIterator.hasNext()) {
        paramb.setPlayerOptionalParam((TPOptionalParam)localIterator.next());
      }
      if (4 == this.ahDG.ahDl.mType) {
        paramb.setDataSource(this.ahDG.ahDl.JgJ);
      }
    }
    Iterator localIterator = this.ahDG.jZI().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.d)localIterator.next();
      paramb.addSubtitleSource(((com.tencent.thumbplayer.a.c.d)localObject).url, ((com.tencent.thumbplayer.a.c.d)localObject).mimeType, ((com.tencent.thumbplayer.a.c.d)localObject).name);
    }
    localIterator = this.ahDG.jZJ().iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.a)localIterator.next();
      paramb.j(((com.tencent.thumbplayer.a.c.a)localObject).url, ((com.tencent.thumbplayer.a.c.a)localObject).name, ((com.tencent.thumbplayer.a.c.a)localObject).ahDu);
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
    if ((this.ahDG.ahDg instanceof SurfaceHolder)) {
      paramb.setSurfaceHolder((SurfaceHolder)this.ahDG.ahDg);
    }
    for (;;)
    {
      paramb.a(this.ahEu);
      paramb.a(this.ahEu);
      paramb.a(this.ahEu);
      paramb.a(this.ahEu);
      paramb.a(this.ahEu);
      paramb.a(this.ahEu);
      paramb.a(this.ahEu);
      AppMethodBeat.o(228717);
      return;
      if ((this.ahDG.ahDg instanceof Surface)) {
        paramb.setSurface((Surface)this.ahDG.ahDg, this.ahDG.lSR);
      }
    }
  }
  
  private void aHt(int paramInt)
  {
    AppMethodBeat.i(228685);
    int i = 0;
    for (;;)
    {
      if (i < this.ahEv.size())
      {
        long l;
        if ((((ITPMediaTrackClip)this.ahEv.get(i)).getStartPositionMs() <= paramInt) && (paramInt <= ((ITPMediaTrackClip)this.ahEv.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.ahEv.get(i)).getOriginalDurationMs())) {
          l = paramInt;
        }
        try
        {
          br(i, l - ((ITPMediaTrackClip)this.ahEv.get(i)).getStartPositionMs());
          i += 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.ahDA.bGe("selectClipPlayer:" + localIOException.toString());
          }
        }
      }
    }
    AppMethodBeat.o(228685);
  }
  
  private ITPMediaTrackClip jZN()
  {
    AppMethodBeat.i(228694);
    ITPMediaTrackClip localITPMediaTrackClip = (ITPMediaTrackClip)this.ahEv.get(this.ahEw);
    AppMethodBeat.o(228694);
    return localITPMediaTrackClip;
  }
  
  private com.tencent.thumbplayer.a.a.b jZO()
  {
    AppMethodBeat.i(228702);
    e locale = new e(this.mContext, this.ahDz);
    if (this.ahDJ == null) {
      this.ahDJ = new com.tencent.thumbplayer.a.b();
    }
    a(locale);
    AppMethodBeat.o(228702);
    return locale;
  }
  
  public final void N(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(229064);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(229064);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    AppMethodBeat.i(229076);
    paramb = new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    AppMethodBeat.o(229076);
    throw paramb;
  }
  
  public final void a(c.c paramc)
  {
    AppMethodBeat.i(229020);
    this.ahDE.a(paramc);
    AppMethodBeat.o(229020);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    AppMethodBeat.i(229026);
    this.ahDE.a(paramd);
    AppMethodBeat.o(229026);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(229022);
    this.ahDE.a(parame);
    AppMethodBeat.o(229022);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(229017);
    this.ahDE.a(paramf);
    AppMethodBeat.o(229017);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(229031);
    this.ahDE.a(paramg);
    AppMethodBeat.o(229031);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(229041);
    this.ahDE.a(parami);
    AppMethodBeat.o(229041);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(229052);
    paramj = new IllegalStateException("system Mediaplayer now not support subtitle frame out");
    AppMethodBeat.o(229052);
    throw paramj;
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(229056);
    paramk = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(229056);
    throw paramk;
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(229069);
    paraml = new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    AppMethodBeat.o(229069);
    throw paraml;
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(229034);
    this.ahDE.a(paramm);
    AppMethodBeat.o(229034);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(228944);
    paramITPMediaAsset = a(paramITPMediaAsset);
    if (com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset))
    {
      paramITPMediaAsset = new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
      AppMethodBeat.o(228944);
      throw paramITPMediaAsset;
    }
    long l = getCurrentPositionMs();
    try
    {
      this.ahEv = paramITPMediaAsset;
      this.ahEy = true;
      if (com.tencent.thumbplayer.utils.b.isEmpty(this.ahEz)) {
        this.ahEz = new LinkedList();
      }
      this.ahEz.offer(Long.valueOf(paramLong));
      this.ahDA.bGe("try to switch definition with system clip player, current clipNo:" + this.ahEw);
      aHt((int)l);
      AppMethodBeat.o(228944);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.ahDA.p(paramITPMediaAsset);
      paramITPMediaAsset = new IllegalStateException("exception when system clip player switch definition!");
      AppMethodBeat.o(228944);
      throw paramITPMediaAsset;
    }
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(228821);
    this.ahDA.error("addSubtitleSource not supported.");
    AppMethodBeat.o(228821);
  }
  
  final void br(int paramInt, long paramLong)
  {
    AppMethodBeat.i(229089);
    this.ahDA.debug("switchPlayer: clipNo:" + paramInt + "   startPostion:" + paramLong);
    if (this.ahDB != null) {
      this.ahDB.release();
    }
    this.ahEx = true;
    this.ahEw = paramInt;
    this.ahDG.setDataSource(((ITPMediaTrackClip)this.ahEv.get(this.ahEw)).getFilePath());
    this.ahDB = jZO();
    if (this.ahDB == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(229089);
      throw ((Throwable)localObject);
    }
    Object localObject = new TPOptionalParam().buildLong(100, paramLong);
    this.ahDB.setPlayerOptionalParam((TPOptionalParam)localObject);
    this.ahDB.prepare();
    AppMethodBeat.o(229089);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(229014);
    if (this.ahDB != null) {
      this.ahDB.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
    }
    AppMethodBeat.o(229014);
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228850);
    this.ahDA.error("deselectTrack not supported.");
    AppMethodBeat.o(228850);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(228997);
    long l1 = 0L;
    int i = 0;
    while ((i < this.ahEv.size()) && (i < this.ahEw))
    {
      l1 += ((ITPMediaTrackClip)this.ahEv.get(i)).getOriginalDurationMs();
      i += 1;
    }
    if (!this.ahDH.aHr(12))
    {
      AppMethodBeat.o(228997);
      return l1;
    }
    long l2 = this.ahDB.getCurrentPositionMs();
    AppMethodBeat.o(228997);
    return l1 + l2;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(228994);
    Iterator localIterator = this.ahEv.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((ITPMediaTrackClip)localIterator.next()).getOriginalDurationMs() + l) {}
    AppMethodBeat.o(228994);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(229001);
    if (!this.ahDH.aHr(15))
    {
      if (this.ahDJ != null)
      {
        l = this.ahDJ.ahDe;
        AppMethodBeat.o(229001);
        return l;
      }
      AppMethodBeat.o(229001);
      return 0L;
    }
    long l = this.ahDB.getPlayableDurationMs();
    AppMethodBeat.o(229001);
    return l;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(229012);
    this.ahDA.error("getProgramInfo not supported.");
    AppMethodBeat.o(229012);
    return new TPProgramInfo[0];
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(228988);
    if (this.ahDB != null)
    {
      long l = this.ahDB.getPropertyLong(paramInt);
      AppMethodBeat.o(228988);
      return l;
    }
    AppMethodBeat.o(228988);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(228992);
    if (this.ahDB != null)
    {
      String str = this.ahDB.getPropertyString(paramInt);
      AppMethodBeat.o(228992);
      return str;
    }
    AppMethodBeat.o(228992);
    return "";
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(229008);
    this.ahDA.error("getTrackInfo not supported.");
    AppMethodBeat.o(229008);
    return new TPTrackInfo[0];
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(229006);
    if (this.ahDJ == null)
    {
      AppMethodBeat.o(229006);
      return 0;
    }
    if (this.ahDJ.height > 0L)
    {
      i = (int)this.ahDJ.height;
      AppMethodBeat.o(229006);
      return i;
    }
    if (!this.ahDH.aHr(13))
    {
      AppMethodBeat.o(229006);
      return 0;
    }
    this.ahDJ.height = this.ahDB.getVideoHeight();
    int i = (int)this.ahDJ.height;
    AppMethodBeat.o(229006);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(229004);
    if (this.ahDJ == null)
    {
      AppMethodBeat.o(229004);
      return 0;
    }
    if (this.ahDJ.width > 0L)
    {
      i = (int)this.ahDJ.width;
      AppMethodBeat.o(229004);
      return i;
    }
    if (!this.ahDH.aHr(13))
    {
      AppMethodBeat.o(229004);
      return 0;
    }
    this.ahDJ.width = this.ahDB.getVideoWidth();
    int i = (int)this.ahDJ.width;
    AppMethodBeat.o(229004);
    return i;
  }
  
  public final void j(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(228830);
    this.ahDA.error("addAudioTrackSource not supported.");
    AppMethodBeat.o(228830);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(228887);
    if (!this.ahDH.aHr(6))
    {
      AppMethodBeat.o(228887);
      return;
    }
    if (this.ahDB == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(228887);
      throw localIllegalStateException1;
    }
    try
    {
      this.ahDB.pause();
      this.ahDC.changeState(6);
      AppMethodBeat.o(228887);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(228887);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(228857);
    if (!this.ahDH.aHr(1))
    {
      AppMethodBeat.o(228857);
      return;
    }
    Object localObject;
    if (!this.ahDG.jZH())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(228857);
      throw ((Throwable)localObject);
    }
    this.ahDB = jZO();
    if (this.ahDB == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(228857);
      throw ((Throwable)localObject);
    }
    this.ahDC.changeState(3);
    this.ahDB.prepare();
    AppMethodBeat.o(228857);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(228867);
    if (!this.ahDH.aHr(1))
    {
      AppMethodBeat.o(228867);
      return;
    }
    Object localObject;
    if (!this.ahDG.jZH())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(228867);
      throw ((Throwable)localObject);
    }
    this.ahDB = jZO();
    if (this.ahDB == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(228867);
      throw ((Throwable)localObject);
    }
    this.ahDC.changeState(3);
    this.ahDB.prepareAsync();
    AppMethodBeat.o(228867);
  }
  
  public final void release()
  {
    AppMethodBeat.i(228913);
    this.ahDA.bGe("release, current state:" + this.ahDC);
    if (this.ahDB != null)
    {
      this.ahDB.release();
      this.ahDB = null;
    }
    this.ahDG.reset();
    this.ahDE.clear();
    this.ahDC.changeState(11);
    AppMethodBeat.o(228913);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(228904);
    this.ahDA.bGe("reset, current state:" + this.ahDC);
    if (this.ahDB != null) {
      this.ahDB.reset();
    }
    this.ahDG.reset();
    this.ahDE.clear();
    this.ahDC.changeState(1);
    AppMethodBeat.o(228904);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(228919);
    if (!this.ahDH.aHr(9))
    {
      AppMethodBeat.o(228919);
      return;
    }
    if ((paramInt >= jZN().getStartPositionMs()) && (paramInt <= jZN().getStartPositionMs() + jZN().getOriginalDurationMs()))
    {
      if (this.ahDB != null)
      {
        this.ahDA.debug("seek to:".concat(String.valueOf(paramInt)));
        this.ahDB.seekTo((int)(paramInt - jZN().getStartPositionMs()));
        AppMethodBeat.o(228919);
      }
    }
    else {
      aHt(paramInt);
    }
    AppMethodBeat.o(228919);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(228927);
    if (!this.ahDH.aHr(9))
    {
      AppMethodBeat.o(228927);
      return;
    }
    if ((paramInt1 >= jZN().getStartPositionMs()) && (paramInt1 <= jZN().getStartPositionMs() + jZN().getOriginalDurationMs()))
    {
      if (this.ahDB != null)
      {
        this.ahDA.debug("seek to:" + paramInt1 + "/mode=" + paramInt2);
        this.ahDB.seekTo((int)(paramInt1 - jZN().getStartPositionMs()), paramInt2);
        AppMethodBeat.o(228927);
      }
    }
    else {
      aHt(paramInt1);
    }
    AppMethodBeat.o(228927);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(229010);
    this.ahDA.error("selectProgram not supported.");
    AppMethodBeat.o(229010);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(228838);
    this.ahDA.error("selectTrack not supported.");
    AppMethodBeat.o(228838);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(228956);
    if (!this.ahDH.aHr(3))
    {
      AppMethodBeat.o(228956);
      return;
    }
    if (this.ahDB != null) {
      this.ahDB.setAudioGainRatio(paramFloat);
    }
    this.ahDG.ahDo = paramFloat;
    AppMethodBeat.o(228956);
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString) {}
  
  public final void setDataSource(AssetFileDescriptor paramAssetFileDescriptor)
  {
    AppMethodBeat.i(228805);
    this.ahDG.setDataSource(paramAssetFileDescriptor);
    this.ahDC.changeState(2);
    AppMethodBeat.o(228805);
  }
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(228799);
    this.ahDG.setDataSource(paramParcelFileDescriptor);
    this.ahDC.changeState(2);
    AppMethodBeat.o(228799);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(228813);
    paramITPMediaAsset = a(paramITPMediaAsset);
    try
    {
      this.ahEv = paramITPMediaAsset;
      this.ahDG.setDataSource(((ITPMediaTrackClip)this.ahEv.get(this.ahEw)).getFilePath());
      this.ahDC.changeState(2);
      AppMethodBeat.o(228813);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.ahDA.p(paramITPMediaAsset);
      paramITPMediaAsset = new IllegalStateException("exception when system clip player set data source!");
      AppMethodBeat.o(228813);
      throw paramITPMediaAsset;
    }
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(228787);
    this.ahDG.setDataSource(paramString, paramMap);
    this.ahDC.changeState(2);
    AppMethodBeat.o(228787);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(228978);
    if (!this.ahDH.aHr(3))
    {
      AppMethodBeat.o(228978);
      return;
    }
    if (this.ahDB != null) {
      this.ahDB.setLoopback(paramBoolean);
    }
    this.ahDG.setLoopback(paramBoolean);
    AppMethodBeat.o(228978);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(228983);
    if (!this.ahDH.aHr(3))
    {
      AppMethodBeat.o(228983);
      return;
    }
    if (this.ahDB != null) {
      this.ahDB.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    this.ahDG.setLoopback(paramBoolean, paramLong1, paramLong2);
    AppMethodBeat.o(228983);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(228949);
    if (!this.ahDH.aHr(3))
    {
      AppMethodBeat.o(228949);
      return;
    }
    if (this.ahDB != null) {
      this.ahDB.setOutputMute(paramBoolean);
    }
    this.ahDG.ahDn = paramBoolean;
    AppMethodBeat.o(228949);
  }
  
  public final void setPlaySharpenSwitch() {}
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(228967);
    if (!this.ahDH.aHr(3))
    {
      AppMethodBeat.o(228967);
      return;
    }
    if (this.ahDB != null) {
      this.ahDB.setPlaySpeedRatio(paramFloat);
    }
    this.ahDG.ahDq = paramFloat;
    AppMethodBeat.o(228967);
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(228732);
    if (!this.ahDH.aHr(3))
    {
      paramTPOptionalParam = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(228732);
      throw paramTPOptionalParam;
    }
    if (paramTPOptionalParam.getKey() == 100)
    {
      int j = (int)paramTPOptionalParam.getParamLong().value;
      this.ahDA.debug("start position:".concat(String.valueOf(j)));
      int i = 0;
      while (i < this.ahEv.size())
      {
        if ((((ITPMediaTrackClip)this.ahEv.get(i)).getStartPositionMs() <= j) && (j <= ((ITPMediaTrackClip)this.ahEv.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.ahEv.get(i)).getOriginalDurationMs()))
        {
          this.ahEw = i;
          this.ahDG.setDataSource(((ITPMediaTrackClip)this.ahEv.get(i)).getFilePath());
          paramTPOptionalParam.getParamLong().value = (j - ((ITPMediaTrackClip)this.ahEv.get(i)).getStartPositionMs());
        }
        i += 1;
      }
    }
    if (this.ahDB != null) {
      this.ahDB.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.ahDG.a(paramTPOptionalParam);
    AppMethodBeat.o(228732);
  }
  
  public final void setSurface(Surface paramSurface, @TPCommonEnum.TPSurfaceType int paramInt)
  {
    AppMethodBeat.i(228769);
    if (!this.ahDH.aHr(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(228769);
      throw paramSurface;
    }
    if (this.ahDB != null) {
      this.ahDB.setSurface(paramSurface, paramInt);
    }
    this.ahDG.v(paramSurface);
    AppMethodBeat.o(228769);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(228777);
    if (!this.ahDH.aHr(4))
    {
      paramSurfaceHolder = new IllegalStateException("setSurfaceHolder , state invalid");
      AppMethodBeat.o(228777);
      throw paramSurfaceHolder;
    }
    if (this.ahDB != null) {
      this.ahDB.setSurfaceHolder(paramSurfaceHolder);
    }
    this.ahDG.ahDg = paramSurfaceHolder;
    AppMethodBeat.o(228777);
  }
  
  public final void start()
  {
    AppMethodBeat.i(228877);
    if (!this.ahDH.aHr(5))
    {
      AppMethodBeat.o(228877);
      return;
    }
    if (this.ahDB == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(228877);
      throw localIllegalStateException1;
    }
    try
    {
      this.ahDB.start();
      this.ahDC.changeState(5);
      AppMethodBeat.o(228877);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(228877);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(228894);
    if (!this.ahDH.aHr(7))
    {
      AppMethodBeat.o(228894);
      return;
    }
    if (this.ahDB == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(228894);
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
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(228894);
      throw localIllegalStateException3;
    }
    finally
    {
      this.ahDC.changeState(9);
      AppMethodBeat.o(228894);
    }
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(228722);
    this.ahDA.a(new com.tencent.thumbplayer.f.b(paramb, "TPSystemClipPlayer"));
    if ((this.ahDE != null) && (paramb != null)) {
      this.ahDE.ayz(this.ahDA.ahDz.tag);
    }
    AppMethodBeat.o(228722);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.g, c.i, c.k, c.l, c.m
  {
    private a() {}
    
    public final void Qz()
    {
      AppMethodBeat.i(228632);
      d locald = d.this;
      if (locald.ahDE != null) {
        locald.ahDE.a(152, locald.ahEw, 0L, null);
      }
      Object localObject;
      if (locald.ahEx)
      {
        locald.start();
        if ((locald.ahEy) && (locald.ahDE != null) && (!com.tencent.thumbplayer.utils.b.isEmpty(locald.ahEz)))
        {
          localObject = (Long)locald.ahEz.poll();
          if (localObject != null) {
            locald.ahDE.a(3, ((Long)localObject).longValue(), 0L, null);
          }
          locald.ahEy = false;
        }
        AppMethodBeat.o(228632);
        return;
      }
      if (locald.ahDH.aHs(1))
      {
        locald.ahDC.changeState(4);
        if (locald.ahDE != null) {
          locald.ahDE.Qz();
        }
        localObject = locald.ahDB;
        TPTrackInfo[] arrayOfTPTrackInfo = locald.getTrackInfo();
        if (arrayOfTPTrackInfo != null)
        {
          int i = 0;
          while (i < arrayOfTPTrackInfo.length)
          {
            int j = arrayOfTPTrackInfo[i].getTrackType();
            TPTrackInfo localTPTrackInfo = (TPTrackInfo)locald.ahDG.ahDr.get(Integer.valueOf(j));
            if (arrayOfTPTrackInfo[i].equals(localTPTrackInfo)) {
              ((com.tencent.thumbplayer.a.a.b)localObject).selectTrack(i, -1L);
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(228632);
    }
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(228726);
      d locald = d.this;
      if (!locald.ahDH.aHs(7))
      {
        AppMethodBeat.o(228726);
        return null;
      }
      paramTPPostProcessFrameBuffer = locald.ahDE.a(paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(228726);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(228660);
      d locald = d.this;
      if (locald.ahDH.aHs(4)) {
        locald.ahDE.a(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      AppMethodBeat.o(228660);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(228650);
      d locald = d.this;
      if (locald.ahDH.aHs(3)) {
        locald.ahDE.a(paramInt, paramLong1, paramLong2, paramObject);
      }
      AppMethodBeat.o(228650);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(228716);
      d locald = d.this;
      if (locald.ahDH.aHs(7)) {
        locald.ahDE.a(paramTPAudioFrameBuffer);
      }
      AppMethodBeat.o(228716);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(228693);
      d locald = d.this;
      if (locald.ahDH.aHs(7)) {
        locald.ahDE.a(paramTPSubtitleData);
      }
      AppMethodBeat.o(228693);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(228709);
      d locald = d.this;
      if (locald.ahDH.aHs(7)) {
        locald.ahDE.a(paramTPVideoFrameBuffer);
      }
      AppMethodBeat.o(228709);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(228738);
      d locald = d.this;
      if (!locald.ahDH.aHs(7))
      {
        AppMethodBeat.o(228738);
        return null;
      }
      paramTPPostProcessFrameBuffer = locald.ahDE.b(paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(228738);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void bN(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(228680);
      d locald = d.this;
      if (locald.ahDH.aHs(6))
      {
        locald.ahDJ.height = paramLong2;
        locald.ahDJ.width = paramLong1;
        locald.ahDE.bN(paramLong1, paramLong2);
      }
      AppMethodBeat.o(228680);
    }
    
    public final void dEH()
    {
      AppMethodBeat.i(228669);
      d locald = d.this;
      if (locald.ahDH.aHs(5)) {
        locald.ahDE.dEH();
      }
      AppMethodBeat.o(228669);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(228642);
      d locald = d.this;
      if (locald.ahDH.aHs(2))
      {
        if (locald.ahEw >= locald.ahEv.size() - 1)
        {
          locald.ahDC.changeState(7);
          locald.ahDE.onCompletion();
          AppMethodBeat.o(228642);
          return;
        }
        try
        {
          locald.br(locald.ahEw + 1, 0L);
          AppMethodBeat.o(228642);
          return;
        }
        catch (IOException localIOException)
        {
          locald.ahDA.bGe("handleOnComplete:" + localIOException.toString());
        }
      }
      AppMethodBeat.o(228642);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */