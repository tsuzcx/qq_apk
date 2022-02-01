package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.a.c;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "", "origin", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Ljava/util/List;)V", "audioChannelCount", "", "audioSampleRate", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "cropRect", "Landroid/graphics/Rect;", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "enableMusic", "", "enableOriginAudio", "enableVideoEnhancement", "fpsUpperLimit", "maxDuration", "", "maxFps", "musicPath", "", "playEnd", "getPlayEnd", "()J", "playStart", "getPlayStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addMusic", "", "fillUp", "addRenderProcessCallback", "callback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "enable", "enableVideoSound", "getComposition", "getCutPlayRange", "Lkotlin/Pair;", "getDurationMs", "getMusicPath", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getSize", "Landroid/util/Size;", "getSourceDuration", "getThumbBitmap", "widthLimit", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getThumbTrackList", "getTrackList", "isEnableMusic", "isEnableOriginSound", "isEnableVideoEnhancement", "kvPlayRateInfo", "kvTransitionInfo", "selectMaxFpsFromTrackList", "setAudioConfig", "sampleRate", "channelCount", "setBlendBitmapProvider", "blendBitmapProvider", "setEffectMgr", "setFilter", "path", "weight", "", "setFpsUpperLimit", "limit", "setMaxDuration", "duration", "setPlayRange", "start", "end", "setRenderCrop", "rect", "setRenderSize", "width", "height", "updateComposition", "Companion", "plugin-vlog_release"})
public final class ac
{
  public static final ac.a Gzs;
  boolean BNS;
  public com.tencent.mm.videocomposition.n Gez;
  private long Gfd;
  public ArrayList<ad> Gzn;
  boolean Gzo;
  public volatile boolean Gzp;
  private int Gzq;
  private int Gzr;
  private int audioChannelCount;
  private int audioSampleRate;
  String iiv;
  private final Rect iiw;
  private EffectManager wbk;
  
  static
  {
    AppMethodBeat.i(190702);
    Gzs = new ac.a((byte)0);
    Object localObject = com.tencent.mm.xeffect.d.RxN;
    com.tencent.mm.xeffect.d.R((kotlin.g.a.b)ac.b.Gzt);
    com.tencent.mm.plugin.xlabeffect.d.gls();
    localObject = aa.Gzi;
    aa.efp();
    localObject = TAVKitMuxer.Gzj;
    TAVKitMuxer.setup();
    AppMethodBeat.o(190702);
  }
  
  public ac(ac paramac)
  {
    this((List)paramac.Gzn);
    AppMethodBeat.i(190701);
    Size localSize = paramac.getComposition().hfp();
    jt(localSize.getWidth(), localSize.getHeight());
    at(paramac.Gez.getPlayStart(), paramac.Gez.fBz());
    this.iiw.set(paramac.iiw);
    this.Gzp = paramac.Gzp;
    AppMethodBeat.o(190701);
  }
  
  public ac(List<ad> paramList)
  {
    AppMethodBeat.i(190700);
    this.Gez = new com.tencent.mm.videocomposition.n();
    this.Gzn = new ArrayList();
    this.iiw = new Rect();
    this.Gzo = true;
    this.iiv = "";
    this.Gzq = 30;
    this.Gzr = -1;
    this.audioSampleRate = 44100;
    this.audioChannelCount = 1;
    int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scP, 28);
    if ((i > 0) && (com.tencent.mm.compatible.util.d.oD(i))) {
      Log.i("MicroMsg.VLogComposition", "extractor config: ".concat(String.valueOf(i)));
    }
    for (com.tencent.tav.extractor.AssetExtractor.DOWNGRADING = true;; com.tencent.tav.extractor.AssetExtractor.DOWNGRADING = false)
    {
      this.Gzn.clear();
      this.Gzn.addAll((Collection)paramList);
      paramList = this.Gez;
      Object localObject2 = (Iterable)this.Gzn;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).GzA);
      }
    }
    Object localObject1 = (List)localObject1;
    p.h(localObject1, "trackList");
    paramList.Gzn.clear();
    paramList.Gzn.addAll((Collection)localObject1);
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smv, 1) == 1) {
      this.Gzr = fBC();
    }
    this.Gez.wB(this.Gzo);
    AppMethodBeat.o(190700);
  }
  
  public static void aUa(String paramString)
  {
    AppMethodBeat.i(190696);
    p.h(paramString, "path");
    AppMethodBeat.o(190696);
  }
  
  private void fBB()
  {
    AppMethodBeat.i(190684);
    Object localObject = ((Iterable)this.Gzn).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ad localad = (ad)((Iterator)localObject).next();
      localad.Cev.ai(localad.GzA.Rhd, localad.GzA.Rhe);
    }
    long l = this.Gez.getPlayStart();
    if ((this.Gfd > 0L) && (this.Gez.fBz() - l > this.Gfd)) {
      this.Gez.at(l, this.Gfd + l);
    }
    if ((((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smv, 1) == 1) && (this.Gzq > 0) && (this.Gzr > 0))
    {
      localObject = this.Gez;
      float f = Math.min(this.Gzq, this.Gzr);
      if (f > 0.0F) {
        ((com.tencent.mm.videocomposition.n)localObject).Rhp = f;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slG, 1) == 1) {
      this.Gez.Rht = ((com.tencent.mm.videocomposition.a.b)new a((c)new d(this.audioSampleRate, this.audioChannelCount)));
    }
    AppMethodBeat.o(190684);
  }
  
  private final int fBC()
  {
    int j = 0;
    AppMethodBeat.i(190691);
    Object localObject2 = (Iterable)this.Gzn;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label89:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((ad)localObject3).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label89;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ad)((Iterator)localObject2).next();
      localObject3 = MultiMediaVideoChecker.GyY.cA(((ad)localObject3).path, true);
      if (localObject3 != null) {}
      for (i = (int)((MultiMediaVideoChecker.a)localObject3).cKu;; i = 0)
      {
        ((Collection)localObject1).add(Integer.valueOf(i));
        break;
      }
    }
    localObject1 = (Integer)j.w((Iterable)localObject1);
    int i = j;
    if (localObject1 != null) {
      i = ((Integer)localObject1).intValue();
    }
    Log.i("MicroMsg.VLogComposition", "selectMaxFpsFromTrackList maxFps:".concat(String.valueOf(i)));
    AppMethodBeat.o(190691);
    return i;
  }
  
  public final void KN(long paramLong)
  {
    AppMethodBeat.i(190682);
    this.Gfd = paramLong;
    paramLong = this.Gez.getPlayStart();
    if ((this.Gfd > 0L) && (this.Gez.fBz() - paramLong > this.Gfd)) {
      this.Gez.at(paramLong, this.Gfd + paramLong);
    }
    AppMethodBeat.o(190682);
  }
  
  public final void O(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(190692);
    p.h(paramb, "blendBitmapProvider");
    this.Gez.a((com.tencent.mm.videocomposition.b.e)new e(paramb, this.wbk));
    AppMethodBeat.o(190692);
  }
  
  public final void a(com.tencent.mm.videocomposition.b.e parame)
  {
    AppMethodBeat.i(190693);
    this.Gez.a(parame);
    AppMethodBeat.o(190693);
  }
  
  public final void a(EffectManager paramEffectManager)
  {
    this.wbk = paramEffectManager;
    this.Gez.GAw = paramEffectManager;
  }
  
  public final void acz(int paramInt)
  {
    AppMethodBeat.i(190695);
    Log.i("MicroMsg.VLogComposition", "setFpsUpperLimit:".concat(String.valueOf(paramInt)));
    if (paramInt > 0) {
      this.Gzq = paramInt;
    }
    AppMethodBeat.o(190695);
  }
  
  public final void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(190681);
    Log.i("MicroMsg.VLogComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']');
    this.Gez.at(paramLong1, paramLong2);
    AppMethodBeat.o(190681);
  }
  
  public final void c(int paramInt, kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(190697);
    p.h(paramb, "callback");
    this.Gez.c(paramInt, paramb);
    AppMethodBeat.o(190697);
  }
  
  public final void cB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(190688);
    p.h(paramString, "musicPath");
    boolean bool;
    Object localObject2;
    Object localObject1;
    long l;
    if (!Util.isNullOrNil(paramString))
    {
      bool = true;
      this.BNS = bool;
      this.iiv = paramString;
      localObject2 = com.tencent.mm.vfs.s.k(paramString, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.g(localObject1, "VFSFileOp.exportExternal…h(musicPath, false) ?: \"\"");
      localObject2 = MultiMediaVideoChecker.GyY;
      localObject2 = MultiMediaVideoChecker.aTW((String)localObject1);
      if (localObject2 == null) {
        break label201;
      }
      l = ((MultiMediaVideoChecker.a)localObject2).duration;
      label84:
      if ((paramBoolean) && (l != 0L)) {
        break label207;
      }
      localObject1 = new com.tencent.mm.videocomposition.d((String)localObject1, 3);
      ((com.tencent.mm.videocomposition.d)localObject1).KO(this.Gez.getPlayStart());
      ((com.tencent.mm.videocomposition.d)localObject1).KP(this.Gez.getSourceDuration());
      ((com.tencent.mm.videocomposition.d)localObject1).KQ(0L);
      ((com.tencent.mm.videocomposition.d)localObject1).KR(((com.tencent.mm.videocomposition.d)localObject1).endTimeMs);
      this.Gez.e((com.tencent.mm.videocomposition.d)localObject1);
    }
    for (;;)
    {
      Log.i("MicroMsg.VLogComposition", "addCompositionMusic musicPath:" + paramString + ", fillUp:" + paramBoolean);
      AppMethodBeat.o(190688);
      return;
      bool = false;
      break;
      label201:
      l = 0L;
      break label84;
      label207:
      for (l = this.Gez.getPlayStart(); l <= this.Gez.fBz(); l += ((com.tencent.mm.videocomposition.d)localObject2).GJB)
      {
        localObject2 = new com.tencent.mm.videocomposition.d((String)localObject1, 3);
        ((com.tencent.mm.videocomposition.d)localObject2).KO(l);
        ((com.tencent.mm.videocomposition.d)localObject2).KP(((com.tencent.mm.videocomposition.d)localObject2).GJB + l);
        this.Gez.e((com.tencent.mm.videocomposition.d)localObject2);
      }
    }
  }
  
  public final o<Long, Long> fBA()
  {
    AppMethodBeat.i(190683);
    o localo = new o(Long.valueOf(this.Gez.Rhl), Long.valueOf(this.Gez.Rhm));
    AppMethodBeat.o(190683);
    return localo;
  }
  
  public final List<ad> fBD()
  {
    AppMethodBeat.i(190694);
    Object localObject2 = (Iterable)this.Gzn;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label95:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      ad localad = (ad)localObject3;
      if ((localad.type == 1) || (localad.type == 2)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label95;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(190694);
    return localObject1;
  }
  
  public final String fBE()
  {
    AppMethodBeat.i(190698);
    if (this.Gzn.isEmpty())
    {
      AppMethodBeat.o(190698);
      return "";
    }
    Object localObject2 = (Iterable)j.N((List)this.Gzn, this.Gzn.size() - 1);
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(i.aTT(((ad)((Iterator)localObject2).next()).fBH()));
    }
    localObject1 = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    int j;
    if (((Collection)localObject2).isEmpty()) {
      j = 0;
    }
    int i;
    label185:
    label203:
    do
    {
      localObject2 = j.r((Iterable)localObject1);
      if (((Set)localObject2).size() != 1) {
        break label373;
      }
      if (((CharSequence)j.e((Iterable)localObject2)).length() <= 0) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label373;
      }
      i = 1;
      localObject2 = kotlin.s.U("transCount", Integer.valueOf(j));
      if (i == 0) {
        break label378;
      }
      i = 1;
      localObject1 = new com.tencent.mm.ab.i(ae.e(new o[] { localObject2, kotlin.s.U("isApplyToAll", Integer.valueOf(i)), kotlin.s.U("transStatus", j.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      p.g(localObject1, "JSONObject(info).toString()");
      localObject1 = kotlin.n.n.j((String)localObject1, ",", ";", false);
      AppMethodBeat.o(190698);
      return localObject1;
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      j = i;
    } while (!((Iterator)localObject2).hasNext());
    label306:
    if (((CharSequence)((Iterator)localObject2).next()).length() > 0)
    {
      j = 1;
      label341:
      if (j == 0) {
        break label383;
      }
      j = i + 1;
      i = j;
      if (j < 0)
      {
        j.hxI();
        i = j;
      }
    }
    label373:
    label378:
    label383:
    for (;;)
    {
      break label306;
      j = 0;
      break label341;
      i = 0;
      break;
      i = 0;
      break label185;
      i = 0;
      break label203;
    }
  }
  
  public final String fBF()
  {
    AppMethodBeat.i(190699);
    if (this.Gzn.isEmpty())
    {
      AppMethodBeat.o(190699);
      return "";
    }
    Object localObject2 = (Iterable)this.Gzn;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((ad)((Iterator)localObject2).next()).GzA.mwH));
    }
    localObject1 = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    int j;
    if (((Collection)localObject2).isEmpty()) {
      j = 0;
    }
    int i;
    do
    {
      localObject1 = new com.tencent.mm.ab.i(ae.e(new o[] { kotlin.s.U("usePlayRateTrackCount", Integer.valueOf(j)), kotlin.s.U("playRateStatus", j.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      p.g(localObject1, "JSONObject(info).toString()");
      localObject1 = kotlin.n.n.j((String)localObject1, ",", ";", false);
      AppMethodBeat.o(190699);
      return localObject1;
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      j = i;
    } while (!((Iterator)localObject2).hasNext());
    if (((Number)((Iterator)localObject2).next()).floatValue() != 1.0F)
    {
      j = 1;
      label256:
      if (j == 0) {
        break label283;
      }
      j = i + 1;
      i = j;
      if (j < 0)
      {
        j.hxI();
        i = j;
      }
    }
    label283:
    for (;;)
    {
      break;
      j = 0;
      break label256;
    }
  }
  
  public final long fBz()
  {
    AppMethodBeat.i(258353);
    long l = this.Gez.fBz();
    AppMethodBeat.o(258353);
    return l;
  }
  
  public final com.tencent.mm.videocomposition.n getComposition()
  {
    AppMethodBeat.i(190685);
    fBB();
    com.tencent.mm.videocomposition.n localn = this.Gez;
    AppMethodBeat.o(190685);
    return localn;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(190679);
    long l = this.Gez.getDurationMs();
    AppMethodBeat.o(190679);
    return l;
  }
  
  public final long getSourceDuration()
  {
    AppMethodBeat.i(190680);
    long l = this.Gez.getSourceDuration();
    AppMethodBeat.o(190680);
    return l;
  }
  
  public final void jt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190687);
    Log.i("MicroMsg.VLogComposition", "setRenderSize: " + paramInt1 + ", " + paramInt2);
    this.Gez.lW(paramInt1, paramInt2);
    AppMethodBeat.o(190687);
  }
  
  public final void ju(int paramInt1, int paramInt2)
  {
    this.audioSampleRate = paramInt1;
    this.audioChannelCount = paramInt2;
  }
  
  public final void q(Rect paramRect)
  {
    AppMethodBeat.i(190686);
    p.h(paramRect, "rect");
    this.iiw.set(paramRect);
    this.Gez.t(this.iiw);
    AppMethodBeat.o(190686);
  }
  
  public final void wB(boolean paramBoolean)
  {
    AppMethodBeat.i(190690);
    Log.i("MicroMsg.VLogComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)));
    this.Gzo = paramBoolean;
    this.Gez.wB(this.Gzo);
    AppMethodBeat.o(190690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ac
 * JD-Core Version:    0.7.0.1
 */