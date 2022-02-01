package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.xlabeffect.g;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.j.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "", "origin", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Ljava/util/List;)V", "audioChannelCount", "", "audioSampleRate", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "cropRect", "Landroid/graphics/Rect;", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "enableMusic", "", "enableOriginAudio", "enableVideoEnhancement", "fpsUpperLimit", "maxDuration", "", "maxFps", "musicPath", "", "playEnd", "getPlayEnd", "()J", "playStart", "getPlayStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addMusic", "", "fillUp", "addRenderProcessCallback", "callback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "enable", "enableVideoSound", "getComposition", "getCutPlayRange", "Lkotlin/Pair;", "getDurationMs", "getMusicPath", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderSize", "Landroid/util/Size;", "getSize", "getSourceDuration", "getThumbBitmap", "widthLimit", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getThumbTrackList", "getTrackList", "isEnableMusic", "isEnableOriginSound", "isEnableVideoEnhancement", "kvPlayRateInfo", "kvTransitionInfo", "selectMaxFpsFromTrackList", "setAudioConfig", "sampleRate", "channelCount", "setBlendBitmapProvider", "blendBitmapProvider", "setEffectMgr", "setFilter", "path", "weight", "", "setFpsUpperLimit", "limit", "setMaxDuration", "duration", "setPlayRange", "start", "end", "setRenderCrop", "rect", "setRenderSize", "width", "height", "updateComposition", "Companion", "plugin-vlog_release"})
public final class ac
{
  public static final a NmY;
  private EffectManager AJU;
  private long MMU;
  public ArrayList<ad> MQY;
  public com.tencent.mm.videocomposition.j NmT;
  boolean NmU;
  public volatile boolean NmV;
  private int NmW;
  private int NmX;
  int audioChannelCount;
  int audioSampleRate;
  String kXi;
  private final Rect kXj;
  public boolean ynt;
  
  static
  {
    AppMethodBeat.i(225928);
    NmY = new a((byte)0);
    Object localObject = com.tencent.mm.xeffect.e.YZt;
    com.tencent.mm.xeffect.e.ah((kotlin.g.a.b)ac.b.NmZ);
    g.hfh();
    localObject = com.tencent.mm.plugin.xlabeffect.c.QPp;
    com.tencent.mm.plugin.xlabeffect.c.eON();
    localObject = TAVKitMuxer.NmK;
    TAVKitMuxer.setup();
    if ((((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbM, 0) == 1) || (WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      Log.i("MicroMsg.VLogComposition", "use custom extractor");
      com.tencent.tav.extractor.AssetExtractor.DOWNGRADING = true;
      localObject = ab.NmS;
      ab.setup();
      AppMethodBeat.o(225928);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vLH, 28);
    if ((i > 0) && (com.tencent.mm.compatible.util.d.qV(i)))
    {
      Log.i("MicroMsg.VLogComposition", "extractor config: ".concat(String.valueOf(i)));
      com.tencent.tav.extractor.AssetExtractor.DOWNGRADING = true;
      AppMethodBeat.o(225928);
      return;
    }
    com.tencent.tav.extractor.AssetExtractor.DOWNGRADING = false;
    AppMethodBeat.o(225928);
  }
  
  public ac(ac paramac)
  {
    this((List)paramac.MQY);
    AppMethodBeat.i(225925);
    Size localSize = paramac.getComposition().igI();
    kH(localSize.getWidth(), localSize.getHeight());
    aG(paramac.NmT.getPlayStart(), paramac.NmT.gtw());
    this.kXj.set(paramac.kXj);
    this.NmV = paramac.NmV;
    AppMethodBeat.o(225925);
  }
  
  public ac(List<ad> paramList)
  {
    AppMethodBeat.i(225923);
    this.NmT = new com.tencent.mm.videocomposition.j();
    this.MQY = new ArrayList();
    this.kXj = new Rect();
    this.NmU = true;
    this.kXi = "";
    this.NmW = 30;
    this.NmX = -1;
    this.audioSampleRate = 44100;
    this.audioChannelCount = 1;
    this.MQY.clear();
    this.MQY.addAll((Collection)paramList);
    paramList = this.NmT;
    Object localObject2 = (Iterable)this.MQY;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).Nng);
    }
    localObject1 = (List)localObject1;
    p.k(localObject1, "trackList");
    paramList.MQY.clear();
    paramList.MQY.addAll((Collection)localObject1);
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXq, 1) == 1) {
      this.NmX = gtz();
    }
    this.NmT.Ap(this.NmU);
    AppMethodBeat.o(225923);
  }
  
  public static void bfx(String paramString)
  {
    AppMethodBeat.i(225904);
    p.k(paramString, "path");
    AppMethodBeat.o(225904);
  }
  
  private void gty()
  {
    AppMethodBeat.i(225878);
    Object localObject = ((Iterable)this.MQY).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ad localad = (ad)((Iterator)localObject).next();
      localad.Ibr.ar(localad.Nng.YHU, localad.Nng.YHV);
    }
    long l = this.NmT.getPlayStart();
    if ((this.MMU > 0L) && (this.NmT.gtw() - l > this.MMU)) {
      this.NmT.aG(l, this.MMU + l);
    }
    if ((((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXq, 1) == 1) && (this.NmW > 0) && (this.NmX > 0))
    {
      localObject = this.NmT;
      float f = Math.min(this.NmW, this.NmX);
      if (f > 0.0F) {
        ((com.tencent.mm.videocomposition.j)localObject).YIi = f;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWt, 1) == 1) {
      this.NmT.YIm = ((com.tencent.mm.videocomposition.a.b)new com.tencent.mm.videocomposition.a.a((com.tencent.mm.videocomposition.a.c)new d(this.audioSampleRate, this.audioChannelCount)));
    }
    AppMethodBeat.o(225878);
  }
  
  private final int gtz()
  {
    int j = 0;
    AppMethodBeat.i(225898);
    Object localObject2 = (Iterable)this.MQY;
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
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ad)((Iterator)localObject2).next();
      localObject3 = MultiMediaVideoChecker.NmA.cO(((ad)localObject3).path, true);
      if (localObject3 != null) {}
      for (i = (int)((MultiMediaVideoChecker.a)localObject3).cLa;; i = 0)
      {
        ((Collection)localObject1).add(Integer.valueOf(i));
        break;
      }
    }
    localObject1 = (Integer)kotlin.a.j.w((Iterable)localObject1);
    int i = j;
    if (localObject1 != null) {
      i = ((Integer)localObject1).intValue();
    }
    Log.i("MicroMsg.VLogComposition", "selectMaxFpsFromTrackList maxFps:".concat(String.valueOf(i)));
    AppMethodBeat.o(225898);
    return i;
  }
  
  public final void Ap(boolean paramBoolean)
  {
    AppMethodBeat.i(225895);
    Log.i("MicroMsg.VLogComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)));
    this.NmU = paramBoolean;
    this.NmT.Ap(this.NmU);
    AppMethodBeat.o(225895);
  }
  
  public final void Sk(long paramLong)
  {
    AppMethodBeat.i(225875);
    this.MMU = paramLong;
    paramLong = this.NmT.getPlayStart();
    if ((this.MMU > 0L) && (this.NmT.gtw() - paramLong > this.MMU)) {
      this.NmT.aG(paramLong, this.MMU + paramLong);
    }
    AppMethodBeat.o(225875);
  }
  
  public final void a(com.tencent.mm.videocomposition.b.e parame)
  {
    AppMethodBeat.i(225900);
    this.NmT.a(parame);
    AppMethodBeat.o(225900);
  }
  
  public final void a(EffectManager paramEffectManager)
  {
    this.AJU = paramEffectManager;
    this.NmT.Noe = paramEffectManager;
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(225874);
    Log.i("MicroMsg.VLogComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']');
    this.NmT.aG(paramLong1, paramLong2);
    AppMethodBeat.o(225874);
  }
  
  public final void aa(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(225899);
    p.k(paramb, "blendBitmapProvider");
    this.NmT.a((com.tencent.mm.videocomposition.b.e)new e(paramb, this.AJU));
    AppMethodBeat.o(225899);
  }
  
  public final void akf(int paramInt)
  {
    AppMethodBeat.i(225903);
    Log.i("MicroMsg.VLogComposition", "setFpsUpperLimit:".concat(String.valueOf(paramInt)));
    if (paramInt > 0) {
      this.NmW = paramInt;
    }
    AppMethodBeat.o(225903);
  }
  
  public final void cP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(225890);
    p.k(paramString, "musicPath");
    boolean bool;
    Object localObject2;
    Object localObject1;
    long l;
    if (!Util.isNullOrNil(paramString))
    {
      bool = true;
      this.ynt = bool;
      this.kXi = paramString;
      localObject2 = u.n(paramString, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      p.j(localObject1, "VFSFileOp.exportExternal…h(musicPath, false) ?: \"\"");
      localObject2 = MultiMediaVideoChecker.NmA;
      localObject2 = MultiMediaVideoChecker.bft((String)localObject1);
      if (localObject2 == null) {
        break label201;
      }
      l = ((MultiMediaVideoChecker.a)localObject2).duration;
      label85:
      if ((paramBoolean) && (l != 0L)) {
        break label207;
      }
      localObject1 = new com.tencent.mm.videocomposition.b((String)localObject1, 3);
      ((com.tencent.mm.videocomposition.b)localObject1).Sl(this.NmT.getPlayStart());
      ((com.tencent.mm.videocomposition.b)localObject1).Sm(this.NmT.getSourceDuration());
      ((com.tencent.mm.videocomposition.b)localObject1).Sn(0L);
      ((com.tencent.mm.videocomposition.b)localObject1).So(((com.tencent.mm.videocomposition.b)localObject1).endTimeMs);
      this.NmT.g((com.tencent.mm.videocomposition.b)localObject1);
    }
    for (;;)
    {
      Log.i("MicroMsg.VLogComposition", "addCompositionMusic musicPath:" + paramString + ", fillUp:" + paramBoolean);
      AppMethodBeat.o(225890);
      return;
      bool = false;
      break;
      label201:
      l = 0L;
      break label85;
      label207:
      for (l = this.NmT.getPlayStart(); l <= this.NmT.gtw(); l += ((com.tencent.mm.videocomposition.b)localObject2).NwS)
      {
        localObject2 = new com.tencent.mm.videocomposition.b((String)localObject1, 3);
        ((com.tencent.mm.videocomposition.b)localObject2).Sl(l);
        ((com.tencent.mm.videocomposition.b)localObject2).Sm(((com.tencent.mm.videocomposition.b)localObject2).NwS + l);
        this.NmT.g((com.tencent.mm.videocomposition.b)localObject2);
      }
    }
  }
  
  public final void d(int paramInt, kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    AppMethodBeat.i(225910);
    p.k(paramb, "callback");
    com.tencent.mm.videocomposition.j localj = this.NmT;
    p.k(paramb, "callback");
    Object localObject = com.tencent.mm.videocomposition.a.YHM;
    localObject = a.a.e(localj);
    if (!localj.YIj.isEmpty()) {}
    for (int i = (int)(localj.YIj.height() * 1.0F / localj.YIj.width() * paramInt);; i = (int)(localj.YIh * 1.0F / localj.YIg * paramInt))
    {
      ((com.tencent.mm.videocomposition.a)localObject).setSize(paramInt, i);
      com.tencent.mm.videocomposition.c.b.i("VideoComposition", "getThumbBitmap request width:" + paramInt + ", height:" + i, new Object[0]);
      ((com.tencent.mm.videocomposition.a)localObject).b(kotlin.a.j.listOf(Long.valueOf(localj.getPlayStart())), (m)new j.d(paramb));
      AppMethodBeat.o(225910);
      return;
    }
  }
  
  public final com.tencent.mm.videocomposition.j getComposition()
  {
    AppMethodBeat.i(225880);
    gty();
    com.tencent.mm.videocomposition.j localj = this.NmT;
    AppMethodBeat.o(225880);
    return localj;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(292990);
    long l = this.NmT.getDurationMs();
    AppMethodBeat.o(292990);
    return l;
  }
  
  public final long getSourceDuration()
  {
    AppMethodBeat.i(225873);
    long l = this.NmT.getSourceDuration();
    AppMethodBeat.o(225873);
    return l;
  }
  
  public final List<ad> gtA()
  {
    AppMethodBeat.i(225902);
    Object localObject2 = (Iterable)this.MQY;
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
    AppMethodBeat.o(225902);
    return localObject1;
  }
  
  public final String gtB()
  {
    AppMethodBeat.i(225917);
    if (this.MQY.isEmpty())
    {
      AppMethodBeat.o(225917);
      return "";
    }
    Object localObject2 = (Iterable)kotlin.a.j.O((List)this.MQY, this.MQY.size() - 1);
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(i.bfr(((ad)((Iterator)localObject2).next()).gtE()));
    }
    localObject1 = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    int j;
    if (((Collection)localObject2).isEmpty()) {
      j = 0;
    }
    int i;
    label186:
    label204:
    do
    {
      localObject2 = kotlin.a.j.r((Iterable)localObject1);
      if (((Set)localObject2).size() != 1) {
        break label374;
      }
      if (((CharSequence)kotlin.a.j.e((Iterable)localObject2)).length() <= 0) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label374;
      }
      i = 1;
      localObject2 = s.M("transCount", Integer.valueOf(j));
      if (i == 0) {
        break label379;
      }
      i = 1;
      localObject1 = new com.tencent.mm.ad.i(ae.e(new o[] { localObject2, s.M("isApplyToAll", Integer.valueOf(i)), s.M("transStatus", kotlin.a.j.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      p.j(localObject1, "JSONObject(info).toString()");
      localObject1 = n.l((String)localObject1, ",", ";", false);
      AppMethodBeat.o(225917);
      return localObject1;
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      j = i;
    } while (!((Iterator)localObject2).hasNext());
    label307:
    if (((CharSequence)((Iterator)localObject2).next()).length() > 0)
    {
      j = 1;
      label342:
      if (j == 0) {
        break label384;
      }
      j = i + 1;
      i = j;
      if (j < 0)
      {
        kotlin.a.j.iBP();
        i = j;
      }
    }
    label384:
    for (;;)
    {
      break label307;
      j = 0;
      break label342;
      i = 0;
      break;
      label374:
      i = 0;
      break label186;
      label379:
      i = 0;
      break label204;
    }
  }
  
  public final String gtC()
  {
    AppMethodBeat.i(225922);
    if (this.MQY.isEmpty())
    {
      AppMethodBeat.o(225922);
      return "";
    }
    Object localObject2 = (Iterable)this.MQY;
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((ad)((Iterator)localObject2).next()).Nng.pvh));
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
      localObject1 = new com.tencent.mm.ad.i(ae.e(new o[] { s.M("usePlayRateTrackCount", Integer.valueOf(j)), s.M("playRateStatus", kotlin.a.j.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      p.j(localObject1, "JSONObject(info).toString()");
      localObject1 = n.l((String)localObject1, ",", ";", false);
      AppMethodBeat.o(225922);
      return localObject1;
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      j = i;
    } while (!((Iterator)localObject2).hasNext());
    if (((Number)((Iterator)localObject2).next()).floatValue() != 1.0F)
    {
      j = 1;
      label257:
      if (j == 0) {
        break label284;
      }
      j = i + 1;
      i = j;
      if (j < 0)
      {
        kotlin.a.j.iBP();
        i = j;
      }
    }
    label284:
    for (;;)
    {
      break;
      j = 0;
      break label257;
    }
  }
  
  public final long gtw()
  {
    AppMethodBeat.i(292989);
    long l = this.NmT.gtw();
    AppMethodBeat.o(292989);
    return l;
  }
  
  public final o<Long, Long> gtx()
  {
    AppMethodBeat.i(225877);
    o localo = new o(Long.valueOf(this.NmT.YIe), Long.valueOf(this.NmT.YIf));
    AppMethodBeat.o(225877);
    return localo;
  }
  
  public final void kH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225884);
    Log.i("MicroMsg.VLogComposition", "setRenderSize: " + paramInt1 + ", " + paramInt2);
    this.NmT.nn(paramInt1, paramInt2);
    AppMethodBeat.o(225884);
  }
  
  public final void x(Rect paramRect)
  {
    AppMethodBeat.i(225883);
    p.k(paramRect, "rect");
    this.kXj.set(paramRect);
    this.NmT.D(this.kXj);
    AppMethodBeat.o(225883);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition$Companion;", "", "()V", "EXTRA_TRACK", "", "IMAGE_SIZE_LIMIT", "", "TAG", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ac
 * JD-Core Version:    0.7.0.1
 */