package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.xeffect.VLogEffectMgr;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "", "origin", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Ljava/util/List;)V", "audioChannelCount", "", "audioSampleRate", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "cropRect", "Landroid/graphics/Rect;", "enableMusic", "", "enableOriginAudio", "enableVideoEnhancement", "fpsUpperLimit", "maxDuration", "", "maxFps", "musicPath", "", "playEnd", "getPlayEnd", "()J", "playStart", "getPlayStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addMusic", "", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "enable", "enableVideoSound", "getComposition", "getCutPlayRange", "Lkotlin/Pair;", "getDurationMs", "getMusicPath", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getSize", "Landroid/util/Size;", "getSourceDuration", "getThumbBitmap", "widthLimit", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getThumbTrackList", "getTrackList", "isEnableMusic", "isEnableOriginSound", "isEnableVideoEnhancement", "kvPlayRateInfo", "kvTransitionInfo", "selectMaxFpsFromTrackList", "setAudioConfig", "sampleRate", "channelCount", "setBlendBitmapProvider", "blendBitmapProvider", "setEffectMgr", "effectMgr", "Lcom/tencent/mm/xeffect/VLogEffectMgr;", "setFilter", "path", "weight", "", "setFpsUpperLimit", "limit", "setMaxDuration", "duration", "setPlayRange", "start", "end", "setRenderCrop", "rect", "setRenderSize", "width", "height", "updateComposition", "Companion", "plugin-vlog_release"})
public final class v
{
  public static final v.a BGq;
  private long BFC;
  public h BGk;
  public ArrayList<w> BGl;
  boolean BGm;
  public boolean BGn;
  private int BGo;
  private int BGp;
  private int audioChannelCount;
  private int audioSampleRate;
  String hml;
  private final Rect hmm;
  boolean xxP;
  
  static
  {
    AppMethodBeat.i(195804);
    BGq = new v.a((byte)0);
    Object localObject = com.tencent.mm.xeffect.e.OfL;
    com.tencent.mm.xeffect.e.N((d.g.a.b)v.b.OdH);
    com.tencent.mm.plugin.xlabeffect.e.ftw();
    localObject = t.BGf;
    t.div();
    localObject = TAVKitMuxer.BGg;
    TAVKitMuxer.setup();
    AppMethodBeat.o(195804);
  }
  
  public v(v paramv)
  {
    this((List)paramv.BGl);
    AppMethodBeat.i(195803);
    Size localSize = paramv.getComposition().fPF();
    io(localSize.getWidth(), localSize.getHeight());
    ar(paramv.BGk.getPlayStart(), paramv.BGk.esa());
    this.hmm.set(paramv.hmm);
    AppMethodBeat.o(195803);
  }
  
  public v(List<w> paramList)
  {
    AppMethodBeat.i(195802);
    this.BGk = new h();
    this.BGl = new ArrayList();
    this.hmm = new Rect();
    this.hml = "";
    this.BGo = 30;
    this.BGp = -1;
    this.audioSampleRate = 44100;
    this.audioChannelCount = 1;
    this.BGl.clear();
    this.BGl.addAll((Collection)paramList);
    paramList = this.BGk;
    Object localObject2 = (Iterable)this.BGl;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((w)((Iterator)localObject2).next()).BGw);
    }
    localObject1 = (List)localObject1;
    p.h(localObject1, "trackList");
    paramList.BGl.clear();
    paramList.BGl.addAll((Collection)localObject1);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHG, 1) == 1) {
      this.BGp = ese();
    }
    AppMethodBeat.o(195802);
  }
  
  public static void aDq(String paramString)
  {
    AppMethodBeat.i(195799);
    p.h(paramString, "path");
    AppMethodBeat.o(195799);
  }
  
  private void esd()
  {
    AppMethodBeat.i(195789);
    Object localObject = ((Iterable)this.BGl).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      localw.xNA.af(localw.BGw.LmC, localw.BGw.LmD);
    }
    long l = this.BGk.getPlayStart();
    if ((this.BFC > 0L) && (this.BGk.esa() - l > this.BFC)) {
      this.BGk.ar(l, this.BFC + l);
    }
    if ((((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHG, 1) == 1) && (this.BGo > 0) && (this.BGp > 0))
    {
      localObject = this.BGk;
      float f = Math.min(this.BGo, this.BGp);
      if (f > 0.0F) {
        ((h)localObject).LmO = f;
      }
    }
    AppMethodBeat.o(195789);
  }
  
  private final int ese()
  {
    int j = 0;
    AppMethodBeat.i(195795);
    Object localObject2 = (Iterable)this.BGl;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label89:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((w)localObject3).type == 2) {}
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
      localObject3 = (w)((Iterator)localObject2).next();
      localObject3 = MultiMediaVideoChecker.BFV.ce(((w)localObject3).path, true);
      if (localObject3 != null) {}
      for (i = (int)((MultiMediaVideoChecker.a)localObject3).cvL;; i = 0)
      {
        ((Collection)localObject1).add(Integer.valueOf(i));
        break;
      }
    }
    localObject1 = (Integer)j.s((Iterable)localObject1);
    int i = j;
    if (localObject1 != null) {
      i = ((Integer)localObject1).intValue();
    }
    ad.i("MicroMsg.VLogComposition", "selectMaxFpsFromTrackList maxFps:".concat(String.valueOf(i)));
    AppMethodBeat.o(195795);
    return i;
  }
  
  public final void Bh(long paramLong)
  {
    AppMethodBeat.i(195786);
    this.BFC = paramLong;
    paramLong = this.BGk.getPlayStart();
    if ((this.BFC > 0L) && (this.BGk.esa() - paramLong > this.BFC)) {
      this.BGk.ar(paramLong, this.BFC + paramLong);
    }
    AppMethodBeat.o(195786);
  }
  
  public final void E(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(195796);
    p.h(paramb, "blendBitmapProvider");
    this.BGk.E(paramb);
    AppMethodBeat.o(195796);
  }
  
  public final void TA(int paramInt)
  {
    AppMethodBeat.i(195798);
    ad.i("MicroMsg.VLogComposition", "setFpsUpperLimit:".concat(String.valueOf(paramInt)));
    if (paramInt > 0) {
      this.BGo = paramInt;
    }
    AppMethodBeat.o(195798);
  }
  
  public final void a(VLogEffectMgr paramVLogEffectMgr)
  {
    this.BGk.BHr = paramVLogEffectMgr;
  }
  
  public final void aDp(String paramString)
  {
    AppMethodBeat.i(195793);
    p.h(paramString, "musicPath");
    if (!bt.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.xxP = bool;
      this.hml = paramString;
      String str = com.tencent.mm.vfs.i.k(paramString, false);
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = new com.tencent.mm.videocomposition.b((String)localObject, 3);
      ((com.tencent.mm.videocomposition.b)localObject).Bi(this.BGk.getPlayStart());
      ((com.tencent.mm.videocomposition.b)localObject).Bj(this.BGk.fPE());
      ((com.tencent.mm.videocomposition.b)localObject).Bk(0L);
      ((com.tencent.mm.videocomposition.b)localObject).Bl(((com.tencent.mm.videocomposition.b)localObject).hiy);
      this.BGk.d((com.tencent.mm.videocomposition.b)localObject);
      ad.i("MicroMsg.VLogComposition", "addCompositionMusic musicPath:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(195793);
      return;
    }
  }
  
  public final void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195785);
    ad.i("MicroMsg.VLogComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']');
    this.BGk.ar(paramLong1, paramLong2);
    AppMethodBeat.o(195785);
  }
  
  public final long esa()
  {
    AppMethodBeat.i(221626);
    long l = this.BGk.esa();
    AppMethodBeat.o(221626);
    return l;
  }
  
  public final CMTimeRange esb()
  {
    AppMethodBeat.i(221627);
    CMTimeRange localCMTimeRange = this.BGk.esb();
    AppMethodBeat.o(221627);
    return localCMTimeRange;
  }
  
  public final o<Long, Long> esc()
  {
    AppMethodBeat.i(195788);
    o localo = new o(Long.valueOf(this.BGk.LmK), Long.valueOf(this.BGk.LmL));
    AppMethodBeat.o(195788);
    return localo;
  }
  
  public final List<w> esf()
  {
    return (List)this.BGl;
  }
  
  public final List<w> esg()
  {
    AppMethodBeat.i(195797);
    Object localObject2 = (Iterable)this.BGl;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label95:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      w localw = (w)localObject3;
      if ((localw.type == 1) || (localw.type == 2)) {}
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
    AppMethodBeat.o(195797);
    return localObject1;
  }
  
  public final String esh()
  {
    AppMethodBeat.i(195800);
    if (this.BGl.isEmpty())
    {
      AppMethodBeat.o(195800);
      return "";
    }
    Object localObject2 = (Iterable)j.F((List)this.BGl, this.BGl.size() - 1);
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(f.aDj(((w)((Iterator)localObject2).next()).esm()));
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
      localObject2 = j.n((Iterable)localObject1);
      if (((Set)localObject2).size() != 1) {
        break label373;
      }
      if (((CharSequence)j.c((Iterable)localObject2)).length() <= 0) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label373;
      }
      i = 1;
      localObject2 = u.S("transCount", Integer.valueOf(j));
      if (i == 0) {
        break label378;
      }
      i = 1;
      localObject1 = new com.tencent.mm.ac.i(ae.a(new o[] { localObject2, u.S("isApplyToAll", Integer.valueOf(i)), u.S("transStatus", j.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      p.g(localObject1, "JSONObject(info).toString()");
      localObject1 = n.h((String)localObject1, ",", ";", false);
      AppMethodBeat.o(195800);
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
        j.gfC();
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
  
  public final String esi()
  {
    AppMethodBeat.i(195801);
    if (this.BGl.isEmpty())
    {
      AppMethodBeat.o(195801);
      return "";
    }
    Object localObject2 = (Iterable)this.BGl;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((w)((Iterator)localObject2).next()).BGw.llC));
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
      localObject1 = new com.tencent.mm.ac.i(ae.a(new o[] { u.S("usePlayRateTrackCount", Integer.valueOf(j)), u.S("playRateStatus", j.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      p.g(localObject1, "JSONObject(info).toString()");
      localObject1 = n.h((String)localObject1, ",", ";", false);
      AppMethodBeat.o(195801);
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
        j.gfC();
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
  
  public final h getComposition()
  {
    AppMethodBeat.i(195790);
    esd();
    h localh = this.BGk;
    AppMethodBeat.o(195790);
    return localh;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(195784);
    long l = this.BGk.getDurationMs();
    AppMethodBeat.o(195784);
    return l;
  }
  
  public final long getPlayStart()
  {
    AppMethodBeat.i(221625);
    long l = this.BGk.getPlayStart();
    AppMethodBeat.o(221625);
    return l;
  }
  
  public final void io(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195792);
    ad.i("MicroMsg.VLogComposition", "setRenderSize: " + paramInt1 + ", " + paramInt2);
    this.BGk.ks(paramInt1, paramInt2);
    AppMethodBeat.o(195792);
  }
  
  public final void lF(int paramInt1, int paramInt2)
  {
    this.audioSampleRate = paramInt1;
    this.audioChannelCount = paramInt2;
  }
  
  public final void o(Rect paramRect)
  {
    AppMethodBeat.i(195791);
    p.h(paramRect, "rect");
    this.hmm.set(paramRect);
    this.BGk.p(this.hmm);
    AppMethodBeat.o(195791);
  }
  
  public final void sQ(boolean paramBoolean)
  {
    AppMethodBeat.i(195794);
    ad.i("MicroMsg.VLogComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)));
    this.BGm = paramBoolean;
    this.BGk.sQ(this.BGm);
    AppMethodBeat.o(195794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.v
 * JD-Core Version:    0.7.0.1
 */