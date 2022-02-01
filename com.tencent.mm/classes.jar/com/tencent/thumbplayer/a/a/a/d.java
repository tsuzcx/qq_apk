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
  com.tencent.thumbplayer.a.e ZyB;
  c ZyD;
  g ZyE;
  com.tencent.thumbplayer.a.b ZyG;
  private com.tencent.thumbplayer.f.b Zyw;
  a Zyx;
  com.tencent.thumbplayer.a.a.b Zyy;
  TPPlayerState Zyz;
  private a Zzs;
  List<ITPMediaTrackClip> Zzt;
  int Zzu;
  boolean Zzv;
  boolean Zzw;
  LinkedList<Long> Zzx;
  private Context mContext;
  
  public d(Context paramContext, com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(219011);
    this.Zzu = 0;
    this.Zyw = new com.tencent.thumbplayer.f.b(paramb, "TPSystemClipPlayer");
    this.Zyx = new a(this.Zyw);
    this.mContext = paramContext;
    this.Zyz = new TPPlayerState();
    this.ZyD = new c();
    this.Zzs = new a((byte)0);
    this.ZyB = new com.tencent.thumbplayer.a.e(this.Zyx.Zyw.tag);
    this.ZyE = new g(this.Zyz);
    this.Zzt = new ArrayList();
    AppMethodBeat.o(219011);
  }
  
  private static List<ITPMediaTrackClip> a(ITPMediaAsset paramITPMediaAsset)
  {
    int i = 0;
    AppMethodBeat.i(219054);
    if ((!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.d)) && (!(paramITPMediaAsset instanceof com.tencent.thumbplayer.c.e)))
    {
      paramITPMediaAsset = new IllegalStateException("system mediaPlayer : media asset is illegal source!");
      AppMethodBeat.o(219054);
      throw paramITPMediaAsset;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramITPMediaAsset instanceof com.tencent.thumbplayer.c.b))
    {
      paramITPMediaAsset = ((com.tencent.thumbplayer.c.b)paramITPMediaAsset).getAllAVTracks();
      if ((com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset)) || (paramITPMediaAsset.get(0) == null))
      {
        paramITPMediaAsset = new IllegalStateException("empty av tracks when set data source!");
        AppMethodBeat.o(219054);
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
    AppMethodBeat.o(219054);
    return paramITPMediaAsset;
  }
  
  private void a(com.tencent.thumbplayer.a.a.b paramb)
  {
    AppMethodBeat.i(219124);
    if (1 == this.ZyD.Zyi.mType) {
      paramb.setDataSource(this.ZyD.Zyi.ZyX);
    }
    if (this.ZyD.Zyi.mType == 0) {
      paramb.setDataSource(this.ZyD.Zyi.mUrl, this.ZyD.Zyi.ZyY);
    }
    Iterator localIterator = this.ZyD.iqp().iterator();
    while (localIterator.hasNext()) {
      paramb.setPlayerOptionalParam((TPOptionalParam)localIterator.next());
    }
    localIterator = this.ZyD.iqn().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.d)localIterator.next();
      paramb.addSubtitleSource(((com.tencent.thumbplayer.a.c.d)localObject).url, ((com.tencent.thumbplayer.a.c.d)localObject).mimeType, ((com.tencent.thumbplayer.a.c.d)localObject).name);
    }
    localIterator = this.ZyD.iqo().iterator();
    while (localIterator.hasNext())
    {
      localObject = (com.tencent.thumbplayer.a.c.a)localIterator.next();
      paramb.h(((com.tencent.thumbplayer.a.c.a)localObject).url, ((com.tencent.thumbplayer.a.c.a)localObject).name, ((com.tencent.thumbplayer.a.c.a)localObject).Zyr);
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
    if ((this.ZyD.Zyd instanceof SurfaceHolder)) {
      paramb.setSurfaceHolder((SurfaceHolder)this.ZyD.Zyd);
    }
    for (;;)
    {
      paramb.a(this.Zzs);
      paramb.a(this.Zzs);
      paramb.a(this.Zzs);
      paramb.a(this.Zzs);
      paramb.a(this.Zzs);
      paramb.a(this.Zzs);
      paramb.a(this.Zzs);
      AppMethodBeat.o(219124);
      return;
      if ((this.ZyD.Zyd instanceof Surface)) {
        paramb.setSurface((Surface)this.ZyD.Zyd);
      }
    }
  }
  
  private void aAH(int paramInt)
  {
    AppMethodBeat.i(219058);
    int i = 0;
    for (;;)
    {
      if (i < this.Zzt.size())
      {
        long l;
        if ((((ITPMediaTrackClip)this.Zzt.get(i)).getStartPositionMs() <= paramInt) && (paramInt <= ((ITPMediaTrackClip)this.Zzt.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.Zzt.get(i)).getOriginalDurationMs())) {
          l = paramInt;
        }
        try
        {
          bi(i, l - ((ITPMediaTrackClip)this.Zzt.get(i)).getStartPositionMs());
          i += 1;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            this.Zyx.bDy("selectClipPlayer:" + localIOException.toString());
          }
        }
      }
    }
    AppMethodBeat.o(219058);
  }
  
  private ITPMediaTrackClip iqs()
  {
    AppMethodBeat.i(219103);
    ITPMediaTrackClip localITPMediaTrackClip = (ITPMediaTrackClip)this.Zzt.get(this.Zzu);
    AppMethodBeat.o(219103);
    return localITPMediaTrackClip;
  }
  
  private com.tencent.thumbplayer.a.a.b iqt()
  {
    AppMethodBeat.i(219105);
    e locale = new e(this.mContext, this.Zyw);
    if (this.ZyG == null) {
      this.ZyG = new com.tencent.thumbplayer.a.b();
    }
    a(locale);
    AppMethodBeat.o(219105);
    return locale;
  }
  
  public final void L(String paramString, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong) {}
  
  public final void a(com.tencent.thumbplayer.a.a.c.a parama)
  {
    AppMethodBeat.i(219098);
    parama = new IllegalStateException("system Mediaplayer cannot support audio frame out");
    AppMethodBeat.o(219098);
    throw parama;
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.b paramb)
  {
    AppMethodBeat.i(219100);
    paramb = new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    AppMethodBeat.o(219100);
    throw paramb;
  }
  
  public final void a(c.c paramc)
  {
    AppMethodBeat.i(219090);
    this.ZyB.a(paramc);
    AppMethodBeat.o(219090);
  }
  
  public final void a(com.tencent.thumbplayer.a.a.c.d paramd)
  {
    AppMethodBeat.i(219092);
    this.ZyB.a(paramd);
    AppMethodBeat.o(219092);
  }
  
  public final void a(c.e parame)
  {
    AppMethodBeat.i(219091);
    this.ZyB.a(parame);
    AppMethodBeat.o(219091);
  }
  
  public final void a(c.f paramf)
  {
    AppMethodBeat.i(219089);
    this.ZyB.a(paramf);
    AppMethodBeat.o(219089);
  }
  
  public final void a(c.g paramg)
  {
    AppMethodBeat.i(219093);
    this.ZyB.a(paramg);
    AppMethodBeat.o(219093);
  }
  
  public final void a(c.i parami)
  {
    AppMethodBeat.i(219095);
    this.ZyB.a(parami);
    AppMethodBeat.o(219095);
  }
  
  public final void a(c.j paramj)
  {
    AppMethodBeat.i(219096);
    paramj = new IllegalStateException("system Mediaplayer now not support subtitle frame out");
    AppMethodBeat.o(219096);
    throw paramj;
  }
  
  public final void a(c.k paramk)
  {
    AppMethodBeat.i(219097);
    paramk = new IllegalStateException("system Mediaplayer cannot support video frame out");
    AppMethodBeat.o(219097);
    throw paramk;
  }
  
  public final void a(c.l paraml)
  {
    AppMethodBeat.i(219099);
    paraml = new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    AppMethodBeat.o(219099);
    throw paraml;
  }
  
  public final void a(c.m paramm)
  {
    AppMethodBeat.i(219094);
    this.ZyB.a(paramm);
    AppMethodBeat.o(219094);
  }
  
  public final void a(ITPMediaAsset paramITPMediaAsset, @TPCommonEnum.TPSwitchDefMode int paramInt, long paramLong)
  {
    AppMethodBeat.i(219047);
    paramITPMediaAsset = a(paramITPMediaAsset);
    if (com.tencent.thumbplayer.utils.b.isEmpty(paramITPMediaAsset))
    {
      paramITPMediaAsset = new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
      AppMethodBeat.o(219047);
      throw paramITPMediaAsset;
    }
    long l = getCurrentPositionMs();
    try
    {
      this.Zzt = paramITPMediaAsset;
      this.Zzw = true;
      if (com.tencent.thumbplayer.utils.b.isEmpty(this.Zzx)) {
        this.Zzx = new LinkedList();
      }
      this.Zzx.offer(Long.valueOf(paramLong));
      this.Zyx.bDy("try to switch definition with system clip player, current clipNo:" + this.Zzu);
      aAH((int)l);
      AppMethodBeat.o(219047);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.Zyx.n(paramITPMediaAsset);
      paramITPMediaAsset = new IllegalStateException("exception when system clip player switch definition!");
      AppMethodBeat.o(219047);
      throw paramITPMediaAsset;
    }
  }
  
  public final void addSubtitleSource(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(219022);
    this.Zyx.error("addSubtitleSource not supported.");
    AppMethodBeat.o(219022);
  }
  
  final void bi(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219102);
    this.Zyx.bDx("switchPlayer: clipNo:" + paramInt + "   startPostion:" + paramLong);
    if (this.Zyy != null) {
      this.Zyy.release();
    }
    this.Zzv = true;
    this.Zzu = paramInt;
    this.ZyD.setDataSource(((ITPMediaTrackClip)this.Zzt.get(this.Zzu)).getFilePath());
    this.Zyy = iqt();
    if (this.Zyy == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(219102);
      throw ((Throwable)localObject);
    }
    Object localObject = new TPOptionalParam().buildLong(100, paramLong);
    this.Zyy.setPlayerOptionalParam((TPOptionalParam)localObject);
    this.Zyy.prepare();
    AppMethodBeat.o(219102);
  }
  
  public final void captureVideo(TPCaptureParams paramTPCaptureParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    AppMethodBeat.i(219088);
    if (this.Zyy != null) {
      this.Zyy.captureVideo(paramTPCaptureParams, paramTPCaptureCallBack);
    }
    AppMethodBeat.o(219088);
  }
  
  public final void deselectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219026);
    this.Zyx.error("deselectTrack not supported.");
    AppMethodBeat.o(219026);
  }
  
  public final long getCurrentPositionMs()
  {
    AppMethodBeat.i(219076);
    long l1 = 0L;
    int i = 0;
    while ((i < this.Zzt.size()) && (i < this.Zzu))
    {
      l1 += ((ITPMediaTrackClip)this.Zzt.get(i)).getOriginalDurationMs();
      i += 1;
    }
    if (!this.ZyE.aAF(12))
    {
      AppMethodBeat.o(219076);
      return l1;
    }
    long l2 = this.Zyy.getCurrentPositionMs();
    AppMethodBeat.o(219076);
    return l1 + l2;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(219074);
    Iterator localIterator = this.Zzt.iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((ITPMediaTrackClip)localIterator.next()).getOriginalDurationMs() + l) {}
    AppMethodBeat.o(219074);
    return l;
  }
  
  public final long getPlayableDurationMs()
  {
    AppMethodBeat.i(219078);
    if (!this.ZyE.aAF(15))
    {
      if (this.ZyG != null)
      {
        l = this.ZyG.Zyb;
        AppMethodBeat.o(219078);
        return l;
      }
      AppMethodBeat.o(219078);
      return 0L;
    }
    long l = this.Zyy.getPlayableDurationMs();
    AppMethodBeat.o(219078);
    return l;
  }
  
  public final TPProgramInfo[] getProgramInfo()
  {
    AppMethodBeat.i(219087);
    this.Zyx.error("getProgramInfo not supported.");
    AppMethodBeat.o(219087);
    return new TPProgramInfo[0];
  }
  
  public final long getPropertyLong(int paramInt)
  {
    AppMethodBeat.i(219071);
    if (this.Zyy != null)
    {
      long l = this.Zyy.getPropertyLong(paramInt);
      AppMethodBeat.o(219071);
      return l;
    }
    AppMethodBeat.o(219071);
    return -1L;
  }
  
  public final String getPropertyString(int paramInt)
  {
    AppMethodBeat.i(219072);
    if (this.Zyy != null)
    {
      String str = this.Zyy.getPropertyString(paramInt);
      AppMethodBeat.o(219072);
      return str;
    }
    AppMethodBeat.o(219072);
    return "";
  }
  
  public final TPTrackInfo[] getTrackInfo()
  {
    AppMethodBeat.i(219084);
    this.Zyx.error("getTrackInfo not supported.");
    AppMethodBeat.o(219084);
    return new TPTrackInfo[0];
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(219083);
    if (this.ZyG == null)
    {
      AppMethodBeat.o(219083);
      return 0;
    }
    if (this.ZyG.height > 0L)
    {
      i = (int)this.ZyG.height;
      AppMethodBeat.o(219083);
      return i;
    }
    if (!this.ZyE.aAF(13))
    {
      AppMethodBeat.o(219083);
      return 0;
    }
    this.ZyG.height = this.Zyy.getVideoHeight();
    int i = (int)this.ZyG.height;
    AppMethodBeat.o(219083);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(219079);
    if (this.ZyG == null)
    {
      AppMethodBeat.o(219079);
      return 0;
    }
    if (this.ZyG.width > 0L)
    {
      i = (int)this.ZyG.width;
      AppMethodBeat.o(219079);
      return i;
    }
    if (!this.ZyE.aAF(13))
    {
      AppMethodBeat.o(219079);
      return 0;
    }
    this.ZyG.width = this.Zyy.getVideoWidth();
    int i = (int)this.ZyG.width;
    AppMethodBeat.o(219079);
    return i;
  }
  
  public final void h(String paramString1, String paramString2, List<TPOptionalParam> paramList)
  {
    AppMethodBeat.i(219024);
    this.Zyx.error("addAudioTrackSource not supported.");
    AppMethodBeat.o(219024);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(219037);
    if (!this.ZyE.aAF(6))
    {
      AppMethodBeat.o(219037);
      return;
    }
    if (this.Zyy == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , pause , player is null");
      AppMethodBeat.o(219037);
      throw localIllegalStateException1;
    }
    try
    {
      this.Zyy.pause();
      this.Zyz.changeState(6);
      AppMethodBeat.o(219037);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(219037);
      throw localIllegalStateException3;
    }
  }
  
  public final void prepare()
  {
    AppMethodBeat.i(219029);
    if (!this.ZyE.aAF(1))
    {
      AppMethodBeat.o(219029);
      return;
    }
    Object localObject;
    if (!this.ZyD.iqm())
    {
      localObject = new IOException("error , prepare , data source invalid");
      AppMethodBeat.o(219029);
      throw ((Throwable)localObject);
    }
    this.Zyy = iqt();
    if (this.Zyy == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(219029);
      throw ((Throwable)localObject);
    }
    this.Zyz.changeState(3);
    this.Zyy.prepare();
    AppMethodBeat.o(219029);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(219033);
    if (!this.ZyE.aAF(1))
    {
      AppMethodBeat.o(219033);
      return;
    }
    Object localObject;
    if (!this.ZyD.iqm())
    {
      localObject = new IllegalStateException("error , prepare , state invalid , data source invalid");
      AppMethodBeat.o(219033);
      throw ((Throwable)localObject);
    }
    this.Zyy = iqt();
    if (this.Zyy == null)
    {
      localObject = new RuntimeException("error , create player failed");
      AppMethodBeat.o(219033);
      throw ((Throwable)localObject);
    }
    this.Zyz.changeState(3);
    this.Zyy.prepareAsync();
    AppMethodBeat.o(219033);
  }
  
  public final void release()
  {
    AppMethodBeat.i(219043);
    this.Zyx.bDy("release, current state:" + this.Zyz);
    if (this.Zyy != null)
    {
      this.Zyy.release();
      this.Zyy = null;
    }
    this.ZyD.reset();
    this.ZyB.clear();
    this.Zyz.changeState(11);
    AppMethodBeat.o(219043);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(219041);
    this.Zyx.bDy("reset, current state:" + this.Zyz);
    if (this.Zyy != null) {
      this.Zyy.reset();
    }
    this.ZyD.reset();
    this.ZyB.clear();
    this.Zyz.changeState(1);
    AppMethodBeat.o(219041);
  }
  
  public final void seekTo(int paramInt)
  {
    AppMethodBeat.i(219044);
    if (!this.ZyE.aAF(9))
    {
      AppMethodBeat.o(219044);
      return;
    }
    if ((paramInt >= iqs().getStartPositionMs()) && (paramInt <= iqs().getStartPositionMs() + iqs().getOriginalDurationMs()))
    {
      if (this.Zyy != null)
      {
        this.Zyx.bDx("seek to:".concat(String.valueOf(paramInt)));
        this.Zyy.seekTo((int)(paramInt - iqs().getStartPositionMs()));
        AppMethodBeat.o(219044);
      }
    }
    else {
      aAH(paramInt);
    }
    AppMethodBeat.o(219044);
  }
  
  public final void seekTo(int paramInt1, @TPCommonEnum.TPSeekMode int paramInt2)
  {
    AppMethodBeat.i(219045);
    if (!this.ZyE.aAF(9))
    {
      AppMethodBeat.o(219045);
      return;
    }
    if ((paramInt1 >= iqs().getStartPositionMs()) && (paramInt1 <= iqs().getStartPositionMs() + iqs().getOriginalDurationMs()))
    {
      if (this.Zyy != null)
      {
        this.Zyx.bDx("seek to:" + paramInt1 + "/mode=" + paramInt2);
        this.Zyy.seekTo((int)(paramInt1 - iqs().getStartPositionMs()), paramInt2);
        AppMethodBeat.o(219045);
      }
    }
    else {
      aAH(paramInt1);
    }
    AppMethodBeat.o(219045);
  }
  
  public final void selectProgram(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219086);
    this.Zyx.error("selectProgram not supported.");
    AppMethodBeat.o(219086);
  }
  
  public final void selectTrack(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219025);
    this.Zyx.error("selectTrack not supported.");
    AppMethodBeat.o(219025);
  }
  
  public final void setAudioGainRatio(float paramFloat)
  {
    AppMethodBeat.i(219063);
    if (!this.ZyE.aAF(3))
    {
      AppMethodBeat.o(219063);
      return;
    }
    if (this.Zyy != null) {
      this.Zyy.setAudioGainRatio(paramFloat);
    }
    this.ZyD.Zyl = paramFloat;
    AppMethodBeat.o(219063);
  }
  
  public final void setAudioNormalizeVolumeParams(String paramString) {}
  
  public final void setDataSource(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    AppMethodBeat.i(219019);
    this.ZyD.setDataSource(paramParcelFileDescriptor);
    this.Zyz.changeState(2);
    AppMethodBeat.o(219019);
  }
  
  public final void setDataSource(ITPMediaAsset paramITPMediaAsset)
  {
    AppMethodBeat.i(219021);
    paramITPMediaAsset = a(paramITPMediaAsset);
    try
    {
      this.Zzt = paramITPMediaAsset;
      this.ZyD.setDataSource(((ITPMediaTrackClip)this.Zzt.get(this.Zzu)).getFilePath());
      this.Zyz.changeState(2);
      AppMethodBeat.o(219021);
      return;
    }
    catch (Exception paramITPMediaAsset)
    {
      this.Zyx.n(paramITPMediaAsset);
      paramITPMediaAsset = new IllegalStateException("exception when system clip player set data source!");
      AppMethodBeat.o(219021);
      throw paramITPMediaAsset;
    }
  }
  
  public final void setDataSource(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(219018);
    this.ZyD.setDataSource(paramString, paramMap);
    this.Zyz.changeState(2);
    AppMethodBeat.o(219018);
  }
  
  public final void setLoopback(boolean paramBoolean)
  {
    AppMethodBeat.i(219067);
    if (!this.ZyE.aAF(3))
    {
      AppMethodBeat.o(219067);
      return;
    }
    if (this.Zyy != null) {
      this.Zyy.setLoopback(paramBoolean);
    }
    this.ZyD.setLoopback(paramBoolean);
    AppMethodBeat.o(219067);
  }
  
  public final void setLoopback(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219068);
    if (!this.ZyE.aAF(3))
    {
      AppMethodBeat.o(219068);
      return;
    }
    if (this.Zyy != null) {
      this.Zyy.setLoopback(paramBoolean, paramLong1, paramLong2);
    }
    this.ZyD.setLoopback(paramBoolean, paramLong1, paramLong2);
    AppMethodBeat.o(219068);
  }
  
  public final void setOutputMute(boolean paramBoolean)
  {
    AppMethodBeat.i(219061);
    if (!this.ZyE.aAF(3))
    {
      AppMethodBeat.o(219061);
      return;
    }
    if (this.Zyy != null) {
      this.Zyy.setOutputMute(paramBoolean);
    }
    this.ZyD.Zyk = paramBoolean;
    AppMethodBeat.o(219061);
  }
  
  public final void setPlaySpeedRatio(float paramFloat)
  {
    AppMethodBeat.i(219066);
    if (!this.ZyE.aAF(3))
    {
      AppMethodBeat.o(219066);
      return;
    }
    if (this.Zyy != null) {
      this.Zyy.setPlaySpeedRatio(paramFloat);
    }
    this.ZyD.Zyn = paramFloat;
    AppMethodBeat.o(219066);
  }
  
  public final void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    AppMethodBeat.i(219014);
    if (!this.ZyE.aAF(3))
    {
      paramTPOptionalParam = new IllegalStateException("setPlayerOptionalParam , state invalid");
      AppMethodBeat.o(219014);
      throw paramTPOptionalParam;
    }
    if (paramTPOptionalParam.getKey() == 100)
    {
      int j = (int)paramTPOptionalParam.getParamLong().value;
      this.Zyx.bDx("start position:".concat(String.valueOf(j)));
      int i = 0;
      while (i < this.Zzt.size())
      {
        if ((((ITPMediaTrackClip)this.Zzt.get(i)).getStartPositionMs() <= j) && (j <= ((ITPMediaTrackClip)this.Zzt.get(i)).getStartPositionMs() + ((ITPMediaTrackClip)this.Zzt.get(i)).getOriginalDurationMs()))
        {
          this.Zzu = i;
          this.ZyD.setDataSource(((ITPMediaTrackClip)this.Zzt.get(i)).getFilePath());
          paramTPOptionalParam.getParamLong().value = (j - ((ITPMediaTrackClip)this.Zzt.get(i)).getStartPositionMs());
        }
        i += 1;
      }
    }
    if (this.Zyy != null) {
      this.Zyy.setPlayerOptionalParam(paramTPOptionalParam);
    }
    this.ZyD.a(paramTPOptionalParam);
    AppMethodBeat.o(219014);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(219015);
    if (!this.ZyE.aAF(4))
    {
      paramSurface = new IllegalStateException("setSurface , state invalid");
      AppMethodBeat.o(219015);
      throw paramSurface;
    }
    if (this.Zyy != null) {
      this.Zyy.setSurface(paramSurface);
    }
    this.ZyD.Zyd = paramSurface;
    AppMethodBeat.o(219015);
  }
  
  public final void setSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(219017);
    if (!this.ZyE.aAF(4))
    {
      paramSurfaceHolder = new IllegalStateException("setSurfaceHolder , state invalid");
      AppMethodBeat.o(219017);
      throw paramSurfaceHolder;
    }
    if (this.Zyy != null) {
      this.Zyy.setSurfaceHolder(paramSurfaceHolder);
    }
    this.ZyD.Zyd = paramSurfaceHolder;
    AppMethodBeat.o(219017);
  }
  
  public final void start()
  {
    AppMethodBeat.i(219035);
    if (!this.ZyE.aAF(5))
    {
      AppMethodBeat.o(219035);
      return;
    }
    if (this.Zyy == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , start , player is null");
      AppMethodBeat.o(219035);
      throw localIllegalStateException1;
    }
    try
    {
      this.Zyy.start();
      this.Zyz.changeState(5);
      AppMethodBeat.o(219035);
      return;
    }
    catch (IllegalStateException localIllegalStateException2)
    {
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , start ,state invalid");
      AppMethodBeat.o(219035);
      throw localIllegalStateException3;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(219039);
    if (!this.ZyE.aAF(7))
    {
      AppMethodBeat.o(219039);
      return;
    }
    if (this.Zyy == null)
    {
      IllegalStateException localIllegalStateException1 = new IllegalStateException("error , stop , player is null");
      AppMethodBeat.o(219039);
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
      IllegalStateException localIllegalStateException3 = new IllegalStateException("error , pause ,state invalid");
      AppMethodBeat.o(219039);
      throw localIllegalStateException3;
    }
    finally
    {
      this.Zyz.changeState(9);
      AppMethodBeat.o(219039);
    }
  }
  
  public final void updateLoggerContext(com.tencent.thumbplayer.f.b paramb)
  {
    AppMethodBeat.i(219012);
    this.Zyx.a(new com.tencent.thumbplayer.f.b(paramb, "TPSystemClipPlayer"));
    if ((this.ZyB != null) && (paramb != null)) {
      this.ZyB.bDr(this.Zyx.Zyw.tag);
    }
    AppMethodBeat.o(219012);
  }
  
  final class a
    implements com.tencent.thumbplayer.a.a.c.a, com.tencent.thumbplayer.a.a.c.b, c.c, com.tencent.thumbplayer.a.a.c.d, c.e, c.f, c.g, c.i, c.k, c.l, c.m
  {
    private a() {}
    
    public final TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(218999);
      d locald = d.this;
      if (!locald.ZyE.aAG(7))
      {
        AppMethodBeat.o(218999);
        return null;
      }
      paramTPPostProcessFrameBuffer = locald.ZyB.a(paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(218999);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(218989);
      d locald = d.this;
      if (locald.ZyE.aAG(4)) {
        locald.ZyB.a(paramInt1, paramInt2, paramLong1, paramLong2);
      }
      AppMethodBeat.o(218989);
    }
    
    public final void a(int paramInt, long paramLong1, long paramLong2, Object paramObject)
    {
      AppMethodBeat.i(218988);
      d locald = d.this;
      if (locald.ZyE.aAG(3)) {
        locald.ZyB.a(paramInt, paramLong1, paramLong2, paramObject);
      }
      AppMethodBeat.o(218988);
    }
    
    public final void a(TPAudioFrameBuffer paramTPAudioFrameBuffer)
    {
      AppMethodBeat.i(218998);
      d locald = d.this;
      if (locald.ZyE.aAG(7)) {
        locald.ZyB.a(paramTPAudioFrameBuffer);
      }
      AppMethodBeat.o(218998);
    }
    
    public final void a(TPSubtitleData paramTPSubtitleData)
    {
      AppMethodBeat.i(218995);
      d locald = d.this;
      if (locald.ZyE.aAG(7)) {
        locald.ZyB.a(paramTPSubtitleData);
      }
      AppMethodBeat.o(218995);
    }
    
    public final void a(TPVideoFrameBuffer paramTPVideoFrameBuffer)
    {
      AppMethodBeat.i(218997);
      d locald = d.this;
      if (locald.ZyE.aAG(7)) {
        locald.ZyB.a(paramTPVideoFrameBuffer);
      }
      AppMethodBeat.o(218997);
    }
    
    public final TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
    {
      AppMethodBeat.i(219001);
      d locald = d.this;
      if (!locald.ZyE.aAG(7))
      {
        AppMethodBeat.o(219001);
        return null;
      }
      paramTPPostProcessFrameBuffer = locald.ZyB.b(paramTPPostProcessFrameBuffer);
      AppMethodBeat.o(219001);
      return paramTPPostProcessFrameBuffer;
    }
    
    public final void ba(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(218993);
      d locald = d.this;
      if (locald.ZyE.aAG(6))
      {
        locald.ZyG.height = paramLong2;
        locald.ZyG.width = paramLong1;
        locald.ZyB.ba(paramLong1, paramLong2);
      }
      AppMethodBeat.o(218993);
    }
    
    public final void cYp()
    {
      AppMethodBeat.i(218991);
      d locald = d.this;
      if (locald.ZyE.aAG(5)) {
        locald.ZyB.cYp();
      }
      AppMethodBeat.o(218991);
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(218987);
      d locald = d.this;
      if (locald.ZyE.aAG(2))
      {
        if (locald.Zzu >= locald.Zzt.size() - 1)
        {
          locald.Zyz.changeState(7);
          locald.ZyB.onCompletion();
          AppMethodBeat.o(218987);
          return;
        }
        try
        {
          locald.bi(locald.Zzu + 1, 0L);
          AppMethodBeat.o(218987);
          return;
        }
        catch (IOException localIOException)
        {
          locald.Zyx.bDy("handleOnComplete:" + localIOException.toString());
        }
      }
      AppMethodBeat.o(218987);
    }
    
    public final void qX()
    {
      AppMethodBeat.i(218984);
      d locald = d.this;
      if (locald.ZyB != null) {
        locald.ZyB.a(152, locald.Zzu, 0L, null);
      }
      Object localObject;
      if (locald.Zzv)
      {
        locald.start();
        if ((locald.Zzw) && (locald.ZyB != null) && (!com.tencent.thumbplayer.utils.b.isEmpty(locald.Zzx)))
        {
          localObject = (Long)locald.Zzx.poll();
          if (localObject != null) {
            locald.ZyB.a(3, ((Long)localObject).longValue(), 0L, null);
          }
          locald.Zzw = false;
        }
        AppMethodBeat.o(218984);
        return;
      }
      if (locald.ZyE.aAG(1))
      {
        locald.Zyz.changeState(4);
        if (locald.ZyB != null) {
          locald.ZyB.qX();
        }
        localObject = locald.Zyy;
        TPTrackInfo[] arrayOfTPTrackInfo = locald.getTrackInfo();
        if (arrayOfTPTrackInfo != null)
        {
          int i = 0;
          while (i < arrayOfTPTrackInfo.length)
          {
            int j = arrayOfTPTrackInfo[i].getTrackType();
            TPTrackInfo localTPTrackInfo = (TPTrackInfo)locald.ZyD.Zyo.get(Integer.valueOf(j));
            if (arrayOfTPTrackInfo[i].equals(localTPTrackInfo)) {
              ((com.tencent.thumbplayer.a.a.b)localObject).selectTrack(i, -1L);
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(218984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */