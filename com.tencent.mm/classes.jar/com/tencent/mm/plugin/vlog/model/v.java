package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.xeffect.VLogEffectMgr;
import com.tencent.mm.xeffect.e;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "", "origin", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Ljava/util/List;)V", "audioChannelCount", "", "audioSampleRate", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "cropRect", "Landroid/graphics/Rect;", "enableMusic", "", "enableOriginAudio", "enableVideoEnhancement", "fpsUpperLimit", "maxDuration", "", "maxFps", "musicPath", "", "playEnd", "getPlayEnd", "()J", "playStart", "getPlayStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addMusic", "", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "enable", "enableVideoSound", "getComposition", "getCutPlayRange", "Lkotlin/Pair;", "getDurationMs", "getMusicPath", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getSize", "Landroid/util/Size;", "getSourceDuration", "getThumbBitmap", "widthLimit", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getThumbTrackList", "getTrackList", "isEnableMusic", "isEnableOriginSound", "isEnableVideoEnhancement", "kvPlayRateInfo", "kvTransitionInfo", "selectMaxFpsFromTrackList", "setAudioConfig", "sampleRate", "channelCount", "setBlendBitmapProvider", "blendBitmapProvider", "setEffectMgr", "effectMgr", "Lcom/tencent/mm/xeffect/VLogEffectMgr;", "setFilter", "path", "weight", "", "setFpsUpperLimit", "limit", "setMaxDuration", "duration", "setPlayRange", "start", "end", "setRenderCrop", "rect", "setRenderSize", "width", "height", "updateComposition", "Companion", "plugin-vlog_release"})
public final class v
{
  public static final v.a BXO;
  public h BXI;
  public ArrayList<w> BXJ;
  boolean BXK;
  public boolean BXL;
  private int BXM;
  private int BXN;
  private long BXa;
  private int audioChannelCount;
  private int audioSampleRate;
  String hoZ;
  private final Rect hpa;
  public boolean xNM;
  
  static
  {
    AppMethodBeat.i(191263);
    BXO = new v.a((byte)0);
    Object localObject = e.LYF;
    e.I((d.g.a.b)v.b.BXP);
    com.tencent.mm.plugin.xlabeffect.d.fcj();
    localObject = t.BXD;
    t.dlu();
    localObject = TAVKitMuxer.BXE;
    TAVKitMuxer.setup();
    AppMethodBeat.o(191263);
  }
  
  public v(v paramv)
  {
    this((List)paramv.BXJ);
    AppMethodBeat.i(191262);
    Size localSize = paramv.getComposition().fUb();
    ir(localSize.getWidth(), localSize.getHeight());
    aq(paramv.BXI.getPlayStart(), paramv.BXI.evH());
    this.hpa.set(paramv.hpa);
    AppMethodBeat.o(191262);
  }
  
  public v(List<w> paramList)
  {
    AppMethodBeat.i(191261);
    this.BXI = new h();
    this.BXJ = new ArrayList();
    this.hpa = new Rect();
    this.hoZ = "";
    this.BXM = 30;
    this.BXN = -1;
    this.audioSampleRate = 44100;
    this.audioChannelCount = 1;
    this.BXJ.clear();
    this.BXJ.addAll((Collection)paramList);
    paramList = this.BXI;
    Object localObject2 = (Iterable)this.BXJ;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((w)((Iterator)localObject2).next()).BXV);
    }
    localObject1 = (List)localObject1;
    p.h(localObject1, "trackList");
    paramList.BXJ.clear();
    paramList.BXJ.addAll((Collection)localObject1);
    if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPm, 1) == 1) {
      this.BXN = evL();
    }
    AppMethodBeat.o(191261);
  }
  
  public static void aEJ(String paramString)
  {
    AppMethodBeat.i(191258);
    p.h(paramString, "path");
    AppMethodBeat.o(191258);
  }
  
  private void evK()
  {
    AppMethodBeat.i(191248);
    Object localObject = ((Iterable)this.BXJ).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      localw.ydt.ae(localw.BXV.LJm, localw.BXV.LJn);
    }
    long l = this.BXI.getPlayStart();
    if ((this.BXa > 0L) && (this.BXI.evH() - l > this.BXa)) {
      this.BXI.aq(l, this.BXa + l);
    }
    if ((((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPm, 1) == 1) && (this.BXM > 0) && (this.BXN > 0))
    {
      localObject = this.BXI;
      float f = Math.min(this.BXM, this.BXN);
      if (f > 0.0F) {
        ((h)localObject).LJy = f;
      }
    }
    AppMethodBeat.o(191248);
  }
  
  private final int evL()
  {
    int j = 0;
    AppMethodBeat.i(191254);
    Object localObject2 = (Iterable)this.BXJ;
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
      localObject3 = MultiMediaVideoChecker.BXt.ci(((w)localObject3).path, true);
      if (localObject3 != null) {}
      for (i = (int)((MultiMediaVideoChecker.a)localObject3).cwp;; i = 0)
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VLogComposition", "selectMaxFpsFromTrackList maxFps:".concat(String.valueOf(i)));
    AppMethodBeat.o(191254);
    return i;
  }
  
  public final void BF(long paramLong)
  {
    AppMethodBeat.i(191245);
    this.BXa = paramLong;
    paramLong = this.BXI.getPlayStart();
    if ((this.BXa > 0L) && (this.BXI.evH() - paramLong > this.BXa)) {
      this.BXI.aq(paramLong, this.BXa + paramLong);
    }
    AppMethodBeat.o(191245);
  }
  
  public final void F(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(191255);
    p.h(paramb, "blendBitmapProvider");
    this.BXI.F(paramb);
    AppMethodBeat.o(191255);
  }
  
  public final void Uh(int paramInt)
  {
    AppMethodBeat.i(191257);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VLogComposition", "setFpsUpperLimit:".concat(String.valueOf(paramInt)));
    if (paramInt > 0) {
      this.BXM = paramInt;
    }
    AppMethodBeat.o(191257);
  }
  
  public final void a(VLogEffectMgr paramVLogEffectMgr)
  {
    this.BXI.BYQ = paramVLogEffectMgr;
  }
  
  public final void aEI(String paramString)
  {
    AppMethodBeat.i(191252);
    p.h(paramString, "musicPath");
    if (!bu.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      this.xNM = bool;
      this.hoZ = paramString;
      String str = com.tencent.mm.vfs.o.k(paramString, false);
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = new com.tencent.mm.videocomposition.b((String)localObject, 3);
      ((com.tencent.mm.videocomposition.b)localObject).BG(this.BXI.getPlayStart());
      ((com.tencent.mm.videocomposition.b)localObject).BH(this.BXI.fUa());
      ((com.tencent.mm.videocomposition.b)localObject).BI(0L);
      ((com.tencent.mm.videocomposition.b)localObject).BJ(((com.tencent.mm.videocomposition.b)localObject).hlm);
      this.BXI.d((com.tencent.mm.videocomposition.b)localObject);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VLogComposition", "addCompositionMusic musicPath:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(191252);
      return;
    }
  }
  
  public final void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191244);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VLogComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']');
    this.BXI.aq(paramLong1, paramLong2);
    AppMethodBeat.o(191244);
  }
  
  public final long evH()
  {
    AppMethodBeat.i(224097);
    long l = this.BXI.evH();
    AppMethodBeat.o(224097);
    return l;
  }
  
  public final CMTimeRange evI()
  {
    AppMethodBeat.i(224098);
    CMTimeRange localCMTimeRange = this.BXI.evI();
    AppMethodBeat.o(224098);
    return localCMTimeRange;
  }
  
  public final d.o<Long, Long> evJ()
  {
    AppMethodBeat.i(191247);
    d.o localo = new d.o(Long.valueOf(this.BXI.LJu), Long.valueOf(this.BXI.LJv));
    AppMethodBeat.o(191247);
    return localo;
  }
  
  public final List<w> evM()
  {
    return (List)this.BXJ;
  }
  
  public final List<w> evN()
  {
    AppMethodBeat.i(191256);
    Object localObject2 = (Iterable)this.BXJ;
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
    AppMethodBeat.o(191256);
    return localObject1;
  }
  
  public final String evO()
  {
    AppMethodBeat.i(191259);
    if (this.BXJ.isEmpty())
    {
      AppMethodBeat.o(191259);
      return "";
    }
    Object localObject2 = (Iterable)j.G((List)this.BXJ, this.BXJ.size() - 1);
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(f.aEC(((w)((Iterator)localObject2).next()).evT()));
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
      localObject2 = u.R("transCount", Integer.valueOf(j));
      if (i == 0) {
        break label378;
      }
      i = 1;
      localObject1 = new i(d.a.ae.a(new d.o[] { localObject2, u.R("isApplyToAll", Integer.valueOf(i)), u.R("transStatus", j.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      p.g(localObject1, "JSONObject(info).toString()");
      localObject1 = n.h((String)localObject1, ",", ";", false);
      AppMethodBeat.o(191259);
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
        j.gke();
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
  
  public final String evP()
  {
    AppMethodBeat.i(191260);
    if (this.BXJ.isEmpty())
    {
      AppMethodBeat.o(191260);
      return "";
    }
    Object localObject2 = (Iterable)this.BXJ;
    Object localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((w)((Iterator)localObject2).next()).BXV.lqb));
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
      localObject1 = new i(d.a.ae.a(new d.o[] { u.R("usePlayRateTrackCount", Integer.valueOf(j)), u.R("playRateStatus", j.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      p.g(localObject1, "JSONObject(info).toString()");
      localObject1 = n.h((String)localObject1, ",", ";", false);
      AppMethodBeat.o(191260);
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
        j.gke();
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
    AppMethodBeat.i(191249);
    evK();
    h localh = this.BXI;
    AppMethodBeat.o(191249);
    return localh;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(191243);
    long l = this.BXI.getDurationMs();
    AppMethodBeat.o(191243);
    return l;
  }
  
  public final long getPlayStart()
  {
    AppMethodBeat.i(224096);
    long l = this.BXI.getPlayStart();
    AppMethodBeat.o(224096);
    return l;
  }
  
  public final void ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191251);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VLogComposition", "setRenderSize: " + paramInt1 + ", " + paramInt2);
    this.BXI.kz(paramInt1, paramInt2);
    AppMethodBeat.o(191251);
  }
  
  public final void is(int paramInt1, int paramInt2)
  {
    this.audioSampleRate = paramInt1;
    this.audioChannelCount = paramInt2;
  }
  
  public final void o(Rect paramRect)
  {
    AppMethodBeat.i(191250);
    p.h(paramRect, "rect");
    this.hpa.set(paramRect);
    this.BXI.p(this.hpa);
    AppMethodBeat.o(191250);
  }
  
  public final void sX(boolean paramBoolean)
  {
    AppMethodBeat.i(191253);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VLogComposition", "enableVideoSound:".concat(String.valueOf(paramBoolean)));
    this.BXK = paramBoolean;
    this.BXI.sX(this.BXK);
    AppMethodBeat.o(191253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.v
 * JD-Core Version:    0.7.0.1
 */