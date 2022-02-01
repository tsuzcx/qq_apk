package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.decoder.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.j.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "", "origin", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;)V", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Ljava/util/List;)V", "audioChannelCount", "", "audioSampleRate", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "cropRect", "Landroid/graphics/Rect;", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "enableMusic", "", "enableOriginAudio", "enableVideoEnhancement", "fpsUpperLimit", "maxDuration", "", "maxFps", "musicPath", "", "playEnd", "getPlayEnd", "()J", "playStart", "getPlayStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addMusic", "", "fillUp", "addRenderProcessCallback", "callback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "enable", "enableVideoSound", "getComposition", "getCutPlayRange", "Lkotlin/Pair;", "getDurationMs", "getMusicPath", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderSize", "Landroid/util/Size;", "getSize", "getSourceDuration", "getThumbBitmap", "widthLimit", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getThumbTrackList", "getTrackList", "isEnableMusic", "isEnableOriginSound", "isEnableVideoEnhancement", "kvPlayRateInfo", "kvTransitionInfo", "selectMaxFpsFromTrackList", "setAudioConfig", "sampleRate", "channelCount", "setBlendBitmapProvider", "blendBitmapProvider", "setEffectMgr", "setFilter", "path", "weight", "", "setFpsUpperLimit", "limit", "setMaxDuration", "duration", "setPlayRange", "start", "end", "setRenderCrop", "rect", "setRenderSize", "width", "height", "updateComposition", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac.a Uav;
  public boolean CWm;
  private final Rect Gl;
  private EffectManager GmF;
  public ArrayList<ad> TDz;
  private long Tzj;
  private int UaA;
  public j Uaw;
  boolean Uax;
  public volatile boolean Uay;
  private int Uaz;
  private int audioChannelCount;
  private int audioSampleRate;
  String nBT;
  
  static
  {
    AppMethodBeat.i(283641);
    Uav = new ac.a((byte)0);
    AppMethodBeat.o(283641);
  }
  
  public ac(ac paramac)
  {
    this((List)paramac.TDz);
    AppMethodBeat.i(283613);
    Size localSize = paramac.getComposition().jLW();
    mu(localSize.getWidth(), localSize.getHeight());
    bs(paramac.Uaw.getPlayStart(), paramac.Uaw.hQW());
    this.Gl.set(paramac.Gl);
    this.Uay = paramac.Uay;
    AppMethodBeat.o(283613);
  }
  
  public ac(List<ad> paramList)
  {
    AppMethodBeat.i(283607);
    this.Uaw = new j();
    this.TDz = new ArrayList();
    this.Gl = new Rect();
    this.Uax = true;
    this.nBT = "";
    this.Uaz = 30;
    this.UaA = -1;
    this.audioSampleRate = 44100;
    this.audioChannelCount = 1;
    this.TDz.clear();
    this.TDz.addAll((Collection)paramList);
    paramList = this.Uaw;
    Object localObject2 = (Iterable)this.TDz;
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).UaI);
    }
    localObject1 = (List)localObject1;
    s.t(localObject1, "trackList");
    paramList.TDz.clear();
    paramList.TDz.addAll((Collection)localObject1);
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpX, 1) == 1) {
      this.UaA = hQZ();
    }
    this.Uaw.FO(this.Uax);
    AppMethodBeat.o(283607);
  }
  
  public static void bfe(String paramString)
  {
    AppMethodBeat.i(283636);
    s.u(paramString, "path");
    AppMethodBeat.o(283636);
  }
  
  private void hQY()
  {
    AppMethodBeat.i(283623);
    Object localObject1 = ((Iterable)this.TDz).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ad)((Iterator)localObject1).next();
      ((ad)localObject2).NXR.bb(((ad)localObject2).UaI.agDB, ((ad)localObject2).UaI.agDC);
    }
    long l = this.Uaw.getPlayStart();
    if ((this.Tzj > 0L) && (this.Uaw.hQW() - l > this.Tzj)) {
      this.Uaw.bs(l, this.Tzj + l);
    }
    if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpX, 1) == 1) && (this.Uaz > 0) && (this.UaA > 0))
    {
      localObject1 = this.Uaw;
      float f = Math.min(this.Uaz, this.UaA);
      if (f > 0.0F) {
        ((j)localObject1).agDP = f;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zoZ, 1) == 1) {
      this.Uaw.agDT = ((com.tencent.mm.videocomposition.a.b)new com.tencent.mm.videocomposition.a.a((com.tencent.mm.videocomposition.a.c)new com.tencent.mm.ca.a.a(this.audioSampleRate, this.audioChannelCount)));
    }
    localObject1 = this.Uaw;
    Object localObject2 = com.tencent.mm.plugin.vlog.decoder.e.TXJ;
    ((j)localObject1).mediaFactory = e.a.hQm();
    AppMethodBeat.o(283623);
  }
  
  private final int hQZ()
  {
    int j = 0;
    AppMethodBeat.i(283630);
    Object localObject2 = (Iterable)this.TDz;
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
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ad)((Iterator)localObject2).next();
      localObject3 = MultiMediaVideoChecker.ObB.cI(((ad)localObject3).path, true);
      if (localObject3 == null) {}
      for (i = 0;; i = (int)((MultiMediaVideoChecker.a)localObject3).eGw)
      {
        ((Collection)localObject1).add(Integer.valueOf(i));
        break;
      }
    }
    localObject1 = (Integer)p.x((Iterable)localObject1);
    if (localObject1 == null) {}
    for (int i = j;; i = ((Integer)localObject1).intValue())
    {
      Log.i("MicroMsg.VLogComposition", s.X("selectMaxFpsFromTrackList maxFps:", Integer.valueOf(i)));
      AppMethodBeat.o(283630);
      return i;
    }
  }
  
  public final void F(Rect paramRect)
  {
    AppMethodBeat.i(283699);
    s.u(paramRect, "rect");
    this.Gl.set(paramRect);
    this.Uaw.L(this.Gl);
    AppMethodBeat.o(283699);
  }
  
  public final void FO(boolean paramBoolean)
  {
    AppMethodBeat.i(283710);
    Log.i("MicroMsg.VLogComposition", s.X("enableVideoSound:", Boolean.valueOf(paramBoolean)));
    this.Uax = paramBoolean;
    this.Uaw.FO(this.Uax);
    AppMethodBeat.o(283710);
  }
  
  public final void a(com.tencent.mm.videocomposition.c.e parame)
  {
    AppMethodBeat.i(283720);
    this.Uaw.a(parame);
    AppMethodBeat.o(283720);
  }
  
  public final void a(EffectManager paramEffectManager)
  {
    this.GmF = paramEffectManager;
    this.Uaw.UbK = paramEffectManager;
  }
  
  public final void aK(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(283715);
    s.u(paramb, "blendBitmapProvider");
    this.Uaw.a((com.tencent.mm.videocomposition.c.e)new d(paramb, this.GmF));
    AppMethodBeat.o(283715);
  }
  
  public final void apz(int paramInt)
  {
    AppMethodBeat.i(283734);
    Log.i("MicroMsg.VLogComposition", s.X("setFpsUpperLimit:", Integer.valueOf(paramInt)));
    if (paramInt > 0) {
      this.Uaz = paramInt;
    }
    AppMethodBeat.o(283734);
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(283672);
    Log.i("MicroMsg.VLogComposition", "setPlayRange:[" + paramLong1 + ", " + paramLong2 + ']');
    this.Uaw.bs(paramLong1, paramLong2);
    AppMethodBeat.o(283672);
  }
  
  public final void dv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(283708);
    s.u(paramString, "musicPath");
    boolean bool;
    Object localObject2;
    Object localObject1;
    long l;
    if (!Util.isNullOrNil(paramString))
    {
      bool = true;
      this.CWm = bool;
      this.nBT = paramString;
      localObject2 = y.n(paramString, false);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = MultiMediaVideoChecker.ObB;
      localObject2 = MultiMediaVideoChecker.aTH((String)localObject1);
      if (localObject2 != null) {
        break label189;
      }
      l = 0L;
      label72:
      if ((paramBoolean) && (l != 0L)) {
        break label199;
      }
      localObject1 = new com.tencent.mm.videocomposition.b((String)localObject1, 3);
      ((com.tencent.mm.videocomposition.b)localObject1).setStartTimeMs(this.Uaw.getPlayStart());
      ((com.tencent.mm.videocomposition.b)localObject1).wA(this.Uaw.getSourceDuration());
      ((com.tencent.mm.videocomposition.b)localObject1).wB(0L);
      ((com.tencent.mm.videocomposition.b)localObject1).wC(((com.tencent.mm.videocomposition.b)localObject1).endTimeMs);
      this.Uaw.g((com.tencent.mm.videocomposition.b)localObject1);
    }
    for (;;)
    {
      Log.i("MicroMsg.VLogComposition", "addCompositionMusic musicPath:" + paramString + ", fillUp:" + paramBoolean);
      AppMethodBeat.o(283708);
      return;
      bool = false;
      break;
      label189:
      l = ((MultiMediaVideoChecker.a)localObject2).duration;
      break label72;
      label199:
      for (l = this.Uaw.getPlayStart(); l <= this.Uaw.hQW(); l += ((com.tencent.mm.videocomposition.b)localObject2).UjZ)
      {
        localObject2 = new com.tencent.mm.videocomposition.b((String)localObject1, 3);
        ((com.tencent.mm.videocomposition.b)localObject2).setStartTimeMs(l);
        ((com.tencent.mm.videocomposition.b)localObject2).wA(((com.tencent.mm.videocomposition.b)localObject2).UjZ + l);
        this.Uaw.g((com.tencent.mm.videocomposition.b)localObject2);
      }
    }
  }
  
  public final void e(int paramInt, kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(283745);
    s.u(paramb, "callback");
    j localj = this.Uaw;
    s.t(paramb, "callback");
    Object localObject = com.tencent.mm.videocomposition.a.agDr;
    localObject = a.a.e(localj);
    if (!localj.agDQ.isEmpty()) {}
    for (int i = (int)(localj.agDQ.height() * 1.0F / localj.agDQ.width() * paramInt);; i = (int)(localj.agDO * 1.0F / localj.agDN * paramInt))
    {
      ((com.tencent.mm.videocomposition.a)localObject).setSize(paramInt, i);
      com.tencent.mm.videocomposition.d.b.i("VideoComposition", "getThumbBitmap request width:" + paramInt + ", height:" + i, new Object[0]);
      ((com.tencent.mm.videocomposition.a)localObject).b(p.listOf(Long.valueOf(localj.getPlayStart())), (m)new j.d(paramb));
      AppMethodBeat.o(283745);
      return;
    }
  }
  
  public final j getComposition()
  {
    AppMethodBeat.i(283691);
    hQY();
    j localj = this.Uaw;
    AppMethodBeat.o(283691);
    return localj;
  }
  
  public final long getDurationMs()
  {
    AppMethodBeat.i(369806);
    long l = this.Uaw.getDurationMs();
    AppMethodBeat.o(369806);
    return l;
  }
  
  public final long getPlayStart()
  {
    AppMethodBeat.i(369804);
    long l = this.Uaw.getPlayStart();
    AppMethodBeat.o(369804);
    return l;
  }
  
  public final long getSourceDuration()
  {
    AppMethodBeat.i(283662);
    long l = this.Uaw.getSourceDuration();
    AppMethodBeat.o(283662);
    return l;
  }
  
  public final long hQW()
  {
    AppMethodBeat.i(369805);
    long l = this.Uaw.hQW();
    AppMethodBeat.o(369805);
    return l;
  }
  
  public final r<Long, Long> hQX()
  {
    AppMethodBeat.i(283685);
    r localr = new r(Long.valueOf(this.Uaw.agDL), Long.valueOf(this.Uaw.agDM));
    AppMethodBeat.o(283685);
    return localr;
  }
  
  public final List<ad> hRa()
  {
    return (List)this.TDz;
  }
  
  public final List<ad> hRb()
  {
    AppMethodBeat.i(283729);
    Object localObject2 = (Iterable)this.TDz;
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
    AppMethodBeat.o(283729);
    return localObject1;
  }
  
  public final String hRc()
  {
    AppMethodBeat.i(283760);
    if (this.TDz.isEmpty())
    {
      AppMethodBeat.o(283760);
      return "";
    }
    Object localObject2 = (Iterable)p.ag((List)this.TDz, this.TDz.size() - 1);
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(h.beZ(((ad)((Iterator)localObject2).next()).hRf()));
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
      localObject2 = p.r((Iterable)localObject1);
      if (((Set)localObject2).size() != 1) {
        break label372;
      }
      if (((CharSequence)p.e((Iterable)localObject2)).length() <= 0) {
        break;
      }
      i = 1;
      if (i == 0) {
        break label372;
      }
      i = 1;
      localObject2 = v.Y("transCount", Integer.valueOf(j));
      if (i == 0) {
        break label377;
      }
      i = 1;
      localObject1 = new i(ak.e(new r[] { localObject2, v.Y("isApplyToAll", Integer.valueOf(i)), v.Y("transStatus", p.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      s.s(localObject1, "JSONObject(info).toString()");
      localObject1 = n.bV((String)localObject1, ",", ";");
      AppMethodBeat.o(283760);
      return localObject1;
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      j = i;
    } while (!((Iterator)localObject2).hasNext());
    label305:
    if (((CharSequence)((Iterator)localObject2).next()).length() > 0)
    {
      j = 1;
      label340:
      if (j == 0) {
        break label382;
      }
      j = i + 1;
      i = j;
      if (j < 0)
      {
        p.kkX();
        i = j;
      }
    }
    label372:
    label377:
    label382:
    for (;;)
    {
      break label305;
      j = 0;
      break label340;
      i = 0;
      break;
      i = 0;
      break label185;
      i = 0;
      break label203;
    }
  }
  
  public final String hRd()
  {
    AppMethodBeat.i(283767);
    if (this.TDz.isEmpty())
    {
      AppMethodBeat.o(283767);
      return "";
    }
    Object localObject2 = (Iterable)this.TDz;
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(Float.valueOf(((ad)((Iterator)localObject2).next()).UaI.sAn));
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
      localObject1 = new i(ak.e(new r[] { v.Y("usePlayRateTrackCount", Integer.valueOf(j)), v.Y("playRateStatus", p.a((Iterable)localObject1, (CharSequence)"|", null, null, 0, null, null, 62)) })).toString();
      s.s(localObject1, "JSONObject(info).toString()");
      localObject1 = n.bV((String)localObject1, ",", ";");
      AppMethodBeat.o(283767);
      return localObject1;
      localObject2 = ((Iterable)localObject2).iterator();
      i = 0;
      j = i;
    } while (!((Iterator)localObject2).hasNext());
    if (((Number)((Iterator)localObject2).next()).floatValue() == 1.0F)
    {
      j = 1;
      label255:
      if (j != 0) {
        break label288;
      }
      j = 1;
      label261:
      if (j == 0) {
        break label293;
      }
      j = i + 1;
      i = j;
      if (j < 0)
      {
        p.kkX();
        i = j;
      }
    }
    label288:
    label293:
    for (;;)
    {
      break;
      j = 0;
      break label255;
      j = 0;
      break label261;
    }
  }
  
  public final void mu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283703);
    Log.i("MicroMsg.VLogComposition", "setRenderSize: " + paramInt1 + ", " + paramInt2);
    this.Uaw.pk(paramInt1, paramInt2);
    AppMethodBeat.o(283703);
  }
  
  public final void mv(int paramInt1, int paramInt2)
  {
    this.audioSampleRate = paramInt1;
    this.audioChannelCount = paramInt2;
  }
  
  public final void wz(long paramLong)
  {
    AppMethodBeat.i(283682);
    this.Tzj = paramLong;
    paramLong = this.Uaw.getPlayStart();
    if ((this.Tzj > 0L) && (this.Uaw.hQW() - paramLong > this.Tzj)) {
      this.Uaw.bs(paramLong, this.Tzj + paramLong);
    }
    AppMethodBeat.o(283682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ac
 * JD-Core Version:    0.7.0.1
 */