package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.aa.c;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlinx.coroutines.bc;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "callback", "Lkotlin/Function0;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editIndex", "", "editTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "editTrackEnd", "", "editTrackPlayRate", "", "editTrackStart", "isAllImage", "", "()Z", "setAllImage", "(Z)V", "isAllVideo", "setAllVideo", "isLoading", "lastPlayRange", "Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "legendData", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "legendDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "maxDuration", "maxVisibleRect", "Landroid/graphics/RectF;", "normalCropRatio", "normalHeight", "normalWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playingList", "scriptIndex", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "vLogLoaded", "visibleRect", "vlogHeight", "vlogWidth", "createCompositionFromComposition", "refComposition", "cutComposition", "createCompositionFromScript", "index", "maxDurationMs", "createCompositionFromSource", "createCompositionFromTemplate", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "createCompositionFromTrack", "track", "createCompositionFromTrackList", "trackList", "", "ttsResult", "Lkotlin/Triple;", "currentComposition", "currentEditTrack", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "dead", "start", "end", "endEditTrack", "confirm", "cutCnt", "scrollCnt", "clearEdit", "endMoveTrack", "getIndexScript", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getNormalCropRatio", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "getVLogSize", "getVisibleRect", "isVLog", "loadVLogScript", "sid", "fid", "moveTrack", "fromPosition", "toPosition", "refFullScreenRatio", "refFullScreenVisibleRect", "Landroid/graphics/Rect;", "scaleEdit", "playRate", "selectTrack", "setMaxDuration", "duration", "setMaxVisibleRect", "cropToNormalRatio", "setNormalMaxSize", "width", "height", "setVLogSize", "setup", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupFullScreenSourceTrackCrop", "byWidth", "screenSize", "setupSourceTrackCrop", "setupSourceTrackCropByVideoTemplate", "transformFullScreenSourceTrackCrop", "updateEdit", "plugin-vlog_release"})
public final class v
  implements com.tencent.mm.vending.e.a
{
  public long MMU;
  public final LinkedList<String> NlX;
  private final LinkedList<z> NlY;
  public final LinkedList<ad> NlZ;
  public ac Nlb;
  public boolean Nma;
  public boolean Nmb;
  private int Nmc;
  private int Nmd;
  private int Nme;
  private int Nmf;
  private float Nmg;
  public final RectF Nmh;
  private final RectF Nmi;
  private final ae Nmj;
  private final kotlin.g.a.b<boi, kotlin.x> Nmk;
  private boolean Nml;
  private final LinkedList<ad> Nmm;
  private int Nmn;
  private int Nmo;
  public ad Nmp;
  private long Nmq;
  private long Nmr;
  private float Nms;
  private final x Nmt;
  private final String TAG;
  private boolean isLoading;
  final LinkedList<Integer> wTn;
  private kotlin.g.a.a<kotlin.x> zoa;
  
  public v()
  {
    AppMethodBeat.i(231094);
    this.TAG = "MicroMsg.MultiMediaModel";
    this.NlX = new LinkedList();
    this.wTn = new LinkedList();
    this.NlY = new LinkedList();
    this.NlZ = new LinkedList();
    com.tencent.mm.plugin.vlog.util.a locala = com.tencent.mm.plugin.vlog.util.a.NGN;
    this.Nmg = com.tencent.mm.plugin.vlog.util.a.gwN();
    this.Nmh = new RectF();
    this.Nmi = new RectF();
    this.Nmj = new ae();
    this.Nmk = ((kotlin.g.a.b)new a(this));
    this.Nlb = new ac((List)kotlin.a.v.aaAd);
    this.Nmm = new LinkedList();
    this.Nmn = -1;
    this.Nmo = -1;
    this.Nms = 1.0F;
    this.Nmt = new x();
    AppMethodBeat.o(231094);
  }
  
  public final void D(List<ad> paramList, List<kotlin.r<String, Long, Long>> paramList1)
  {
    AppMethodBeat.i(231090);
    p.k(paramList, "trackList");
    Object localObject1 = com.tencent.mm.videocomposition.b.YHY;
    Object localObject2 = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label111:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ad localad = (ad)localObject3;
      if ((localad.type == 2) || (localad.type == 1)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label111;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).Nng);
    }
    b.a.iK((List)localObject1);
    Object localObject3 = ((Iterable)paramList).iterator();
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = null;
    }
    label239:
    do
    {
      localObject1 = (ad)localObject1;
      if (localObject1 == null) {
        break;
      }
      l1 = ((ad)localObject1).Nng.endTimeMs;
      if (paramList1 == null) {
        break label602;
      }
      localObject1 = (Iterable)paramList1;
      paramList1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (kotlin.r)((Iterator)localObject1).next();
        localObject3 = (String)((kotlin.r)localObject2).Mx;
        l2 = ((Number)((kotlin.r)localObject2).My).longValue();
        long l3 = ((Number)((kotlin.r)localObject2).aazK).longValue();
        localObject2 = new ad((String)localObject3, 3);
        ((ad)localObject2).Sl(l2);
        ((ad)localObject2).Sm(Math.min(l3, l1));
        ((ad)localObject2).Sn(0L);
        ((ad)localObject2).So(l3 - l2);
        ((ad)localObject2).setVolume(3.0F);
        paramList1.add(localObject2);
      }
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    long l1 = ((ad)localObject1).Nng.endTimeMs;
    label436:
    localObject2 = ((Iterator)localObject3).next();
    long l2 = ((ad)localObject2).Nng.endTimeMs;
    if (l1 < l2)
    {
      l1 = l2;
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext())
      {
        break;
        l1 = 9223372036854775807L;
        break label239;
        label602:
        for (paramList1 = (List)paramList1;; paramList1 = null)
        {
          localObject1 = (List)new ArrayList();
          ((List)localObject1).addAll((Collection)paramList);
          if (paramList1 != null) {
            ((List)localObject1).addAll((Collection)paramList1);
          }
          this.Nlb = new ac((List)localObject1);
          this.Nlb.Sk(this.MMU);
          paramList = this.Nlb;
          paramList1 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
          paramList.a(com.tencent.mm.plugin.vlog.model.local.a.gtM());
          this.Nlb.kH(this.Nme, this.Nmf);
          AppMethodBeat.o(231090);
          return;
        }
      }
      break label436;
    }
  }
  
  public final Object a(final List<String> paramList, final List<Integer> paramList1, final List<Integer> paramList2, d<? super kotlin.x> paramd)
  {
    AppMethodBeat.i(231027);
    paramList = kotlinx.coroutines.i.a((f)bc.iRs(), (m)new b(this, paramList, paramList1, paramList2, null), paramd);
    AppMethodBeat.o(231027);
    return paramList;
  }
  
  public final void a(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(231028);
    p.k(paramRectF, "maxVisibleRect");
    this.Nmi.set(paramRectF);
    this.Nmh.set(paramRectF);
    if (paramBoolean)
    {
      float f = (paramRectF.height() - paramRectF.width() * this.Nmg) / 2.0F;
      this.Nmh.inset(0.0F, f);
    }
    AppMethodBeat.o(231028);
  }
  
  public final void a(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(231084);
    p.k(paramac, "refComposition");
    paramac = (List)paramac.MQY;
    Object localObject1 = com.tencent.mm.videocomposition.b.YHY;
    Object localObject2 = (Iterable)paramac;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label119:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      ad localad = (ad)localObject3;
      if ((localad.type == 2) || (localad.type == 1)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label119;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).Nng);
    }
    b.a.iK((List)localObject1);
    localObject1 = (List)new ArrayList();
    ((List)localObject1).addAll((Collection)paramac);
    this.Nlb = new ac((List)localObject1);
    if (paramBoolean) {
      this.Nlb.Sk(this.MMU);
    }
    paramac = this.Nlb;
    localObject1 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    paramac.a(com.tencent.mm.plugin.vlog.model.local.a.gtM());
    this.Nlb.kH(this.Nme, this.Nmf);
    AppMethodBeat.o(231084);
  }
  
  public final void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(231064);
    Log.i(this.TAG, "endEditTrack editIndex:" + this.Nmo + ", confirm:" + paramBoolean1 + ", start:" + paramLong1 + ", end:" + paramLong2);
    if ((this.Nmo >= 0) && (this.Nmo < this.Nmm.size()))
    {
      localObject1 = this.Nmm.get(this.Nmo);
      p.j(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      localObject2 = ((ad)localObject1).Nnf;
      ((MediaEditReportInfo.EditItem)localObject2).clickEditCount += 1;
      localObject2 = ((ad)localObject1).Nnf;
      ((MediaEditReportInfo.EditItem)localObject2).durationCutCount += paramInt1;
      localObject2 = ((ad)localObject1).Nnf;
      ((MediaEditReportInfo.EditItem)localObject2).durationScrollCount += paramInt2;
      if ((paramBoolean1) && (paramLong1 >= 0L) && (paramLong2 >= 0L))
      {
        ((ad)localObject1).Sn(((float)paramLong1 * ((ad)localObject1).Nng.pvh));
        ((ad)localObject1).So(((float)paramLong2 * ((ad)localObject1).Nng.pvh));
      }
      for (;;)
      {
        paramLong1 = ((float)(((ad)localObject1).Nng.MQW - ((ad)localObject1).Nng.MQV) / ((ad)localObject1).Nng.pvh);
        ((ad)localObject1).Nnf.targetDuration = paramLong1;
        if (paramBoolean2)
        {
          this.Nmp = null;
          this.Nmo = -1;
        }
        localObject1 = com.tencent.mm.videocomposition.b.YHY;
        localObject2 = (Iterable)this.Nmm;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).Nng);
        }
        ((ad)localObject1).Sn(this.Nmq);
        ((ad)localObject1).So(this.Nmr);
      }
      b.a.iK((List)localObject1);
    }
    this.Nlb = new ac((List)this.Nmm);
    this.Nlb.Sk(this.MMU);
    Object localObject1 = this.Nlb;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.gtM());
    this.Nlb.kH(this.Nme, this.Nmf);
    AppMethodBeat.o(231064);
  }
  
  public final void a(boolean paramBoolean, Size paramSize)
  {
    AppMethodBeat.i(231038);
    p.k(paramSize, "screenSize");
    aa.c localc = new aa.c();
    aa.d locald1 = new aa.d();
    aa.d locald2 = new aa.d();
    Rect localRect1 = new Rect();
    Object localObject1 = (Iterable)this.NlZ;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (ad)localObject2;
      j localj = ((ad)localObject2).Nnd;
      float f1 = ((ad)localObject2).Nnb / ((ad)localObject2).Nna;
      label148:
      float f2;
      label233:
      Rect localRect2;
      if (i == 0)
      {
        locald1.aaBA = paramSize.getWidth();
        locald2.aaBA = paramSize.getHeight();
        localc.aaBz = (locald2.aaBA / locald1.aaBA);
        if (((i != 0) || (!paramBoolean)) && ((i == 0) || (f1 <= localc.aaBz))) {
          break label403;
        }
        f1 *= locald1.aaBA;
        f2 = (locald2.aaBA - f1) / 2.0F;
        localj.vcr.set(0, (int)f2, locald1.aaBA, (int)(f1 + f2));
        if (i == 0)
        {
          localRect2 = localj.vcr;
          if (paramSize.getWidth() * paramSize.getHeight() >= localRect2.width() * localRect2.height()) {
            break label449;
          }
          localRect1.set(0, 0, paramSize.getWidth(), paramSize.getHeight());
        }
      }
      for (;;)
      {
        t.a(localj.aHZ, new RectF(0.0F, 0.0F, ((ad)localObject2).Nna, ((ad)localObject2).Nnb), new RectF(localRect1));
        localj.BZx = t.e(localj.aHZ);
        localj.aGN = (localj.BZx * 5.0F);
        localj.aGO = (localj.BZx * 0.25F);
        ((ad)localObject2).Nng.YHT = true;
        i += 1;
        break;
        locald1.aaBA = localRect1.width();
        locald2.aaBA = localRect1.height();
        break label148;
        label403:
        f1 = locald2.aaBA / f1;
        f2 = (locald1.aaBA - f1) / 2.0F;
        localj.vcr.set((int)f2, 0, (int)(f1 + f2), locald2.aaBA);
        break label233;
        label449:
        localRect1.set(localRect2);
      }
    }
    AppMethodBeat.o(231038);
  }
  
  public final void aL(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(231060);
    this.Nlb.aG(paramLong1, paramLong2);
    AppMethodBeat.o(231060);
  }
  
  public final void akd(int paramInt)
  {
    AppMethodBeat.i(231057);
    Log.i(this.TAG, "editTrack index:".concat(String.valueOf(paramInt)));
    this.Nmo = paramInt;
    this.Nmt.start = this.Nlb.NmT.getPlayStart();
    this.Nmt.aYz = this.Nlb.NmT.gtw();
    if ((this.Nmo >= 0) && (this.Nmo < this.Nmm.size()))
    {
      Object localObject1 = this.Nmm.get(this.Nmo);
      p.j(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      this.Nmp = ((ad)localObject1);
      this.Nmq = ((ad)localObject1).Nng.MQV;
      this.Nmr = ((ad)localObject1).Nng.MQW;
      this.Nms = ((ad)localObject1).Nng.pvh;
      Object localObject2 = new ad(((ad)localObject1).path, ((ad)localObject1).type);
      ((ad)localObject2).So(((ad)localObject1).Nng.NwS);
      ((ad)localObject2).Sm(((float)((ad)localObject1).Nng.NwS / ((ad)localObject1).Nng.pvh));
      ((ad)localObject2).setPlayRate(((ad)localObject1).Nng.pvh);
      ((ad)localObject2).Nna = ((ad)localObject1).Nna;
      ((ad)localObject2).Nnb = ((ad)localObject1).Nnb;
      ((ad)localObject2).Nnd.kXj.set(((ad)localObject1).Nnd.kXj);
      ((ad)localObject2).Nnd.vcr.set(((ad)localObject1).Nnd.vcr);
      ((ad)localObject2).Nnd.viewRect.set(((ad)localObject1).Nnd.viewRect);
      ((ad)localObject2).Nnd.aHZ.set(((ad)localObject1).Nnd.aHZ);
      ((ad)localObject2).Nng.kXj.set(((ad)localObject1).Nng.kXj);
      ((ad)localObject2).Nng.igC();
      p.k(localObject2, "track");
      this.Nlb = new ac(kotlin.a.j.listOf(localObject2));
      this.Nlb.kH(this.Nme, this.Nmf);
      localObject1 = this.Nlb;
      localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
      ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.gtM());
      this.Nlb.aG(((float)this.Nmq / this.Nms), ((float)this.Nmr / this.Nms));
    }
    AppMethodBeat.o(231057);
  }
  
  public final void c(a.c paramc)
  {
    AppMethodBeat.i(231081);
    p.k(paramc, "template");
    this.Nmn = -1;
    this.Nmm.clear();
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    localObject1 = com.tencent.mm.plugin.vlog.model.local.a.a(paramc, (List)this.NlZ);
    p.k(paramc, "template");
    p.k(localObject1, "trackList");
    ad localad;
    if (paramc.Nop)
    {
      localObject2 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localad = (ad)((Iterator)localObject2).next();
        Object localObject3 = paramc.GbH;
        double d = 1.0D * ((Size)localObject3).getWidth() / ((Size)localObject3).getHeight();
        localad.Nng.kXj.setEmpty();
        int i;
        if (1.0D * localad.Nng.Nna / localad.Nng.Nnb < d)
        {
          i = localad.Nng.Nna;
          d = i / d;
          localObject3 = new Rect();
          ((Rect)localObject3).left = 0;
          ((Rect)localObject3).right = i;
          ((Rect)localObject3).top = ((int)((localad.Nng.Nnb - d) / 2.0D));
          ((Rect)localObject3).bottom = ((int)(d + ((Rect)localObject3).top));
          localad.Nng.YHS.set((Rect)localObject3);
        }
        for (;;)
        {
          localad.Nng.YHT = false;
          Log.i(this.TAG, "track source size:[" + localad.Nng.Nna + ", " + localad.Nng.Nnb + "], trackCropRect:" + localad.Nng.YHS + ", templateSize:" + paramc.GbH);
          break;
          i = localad.Nng.Nnb;
          d *= i;
          localObject3 = new Rect();
          ((Rect)localObject3).top = 0;
          ((Rect)localObject3).bottom = i;
          ((Rect)localObject3).left = ((int)((localad.Nng.Nna - d) / 2.0D));
          ((Rect)localObject3).right = ((int)(d + ((Rect)localObject3).left));
          localad.Nng.YHS.set((Rect)localObject3);
        }
      }
    }
    else
    {
      localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localad = (ad)((Iterator)localObject2).next();
        localad.Nng.YHS.set(0, 0, localad.Nng.Nna, localad.Nng.Nnb);
        localad.Nng.YHT = false;
      }
    }
    this.Nmm.addAll((Collection)localObject1);
    this.Nlb = new ac((List)this.Nmm);
    this.Nlb.Sk(paramc.duration);
    localObject1 = this.Nlb;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.gtM());
    this.Nlb.kH(this.Nme, (int)(this.Nme / (1.0D * paramc.GbH.getWidth() / paramc.GbH.getHeight())));
    this.Nlb.Ap(false);
    ac.a(this.Nlb, paramc.kXi);
    AppMethodBeat.o(231081);
  }
  
  public final void co(float paramFloat)
  {
    AppMethodBeat.i(231059);
    ad localad = this.Nmp;
    if (localad != null)
    {
      localad.setPlayRate(paramFloat);
      localad.Nng.igC();
    }
    localad = (ad)kotlin.a.j.lp((List)this.Nlb.MQY);
    if (localad != null)
    {
      localad.setPlayRate(paramFloat);
      localad.Nng.igC();
      this.Nlb.aG(localad.Nng.startTimeMs, localad.Nng.endTimeMs);
      AppMethodBeat.o(231059);
      return;
    }
    AppMethodBeat.o(231059);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(231092);
    ae localae = this.Nmj;
    localae.Nnl = null;
    h.aGY().b(1469, (com.tencent.mm.an.i)localae);
    h.aGY().b(2972, (com.tencent.mm.an.i)localae);
    AppMethodBeat.o(231092);
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(231041);
    p.k(paramRectF, "maxVisibleRect");
    Object localObject1 = (Iterable)this.NlZ;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (ad)localObject2;
      j localj = ((ad)localObject2).Nnd;
      if (i == 0) {
        localj.vcr.offset(-(int)paramRectF.left, -(int)paramRectF.top);
      }
      ((ad)localObject2).Nng.kXj.set(localj.vcr);
      localj.viewRect.set(localj.vcr);
      i += 1;
    }
    AppMethodBeat.o(231041);
  }
  
  public final float gtg()
  {
    AppMethodBeat.i(231031);
    Object localObject = (ad)this.NlZ.getFirst();
    if (localObject != null)
    {
      f = ((ad)localObject).Nna / ((ad)localObject).Nnb;
      AppMethodBeat.o(231031);
      return f;
    }
    localObject = com.tencent.mm.plugin.vlog.util.a.NGN;
    float f = com.tencent.mm.plugin.vlog.util.a.gwN();
    AppMethodBeat.o(231031);
    return f;
  }
  
  public final Rect gth()
  {
    AppMethodBeat.i(231033);
    Rect localRect = ((ad)this.NlZ.getFirst()).Nnd.vcr;
    AppMethodBeat.o(231033);
    return localRect;
  }
  
  public final void gti()
  {
    AppMethodBeat.i(231045);
    Iterator localIterator = ((Iterable)this.NlZ).iterator();
    if (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      j localj = localad.Nnd;
      float f;
      if (localj.aHZ.isIdentity())
      {
        f = localad.Nnb * 1.0F / localad.Nna;
        this.Nmh.round(localj.vcr);
        if (f <= this.Nmh.height() / this.Nmh.width()) {
          break label313;
        }
        f = (this.Nmh.width() * 1.0F / localad.Nna * localad.Nnb - this.Nmh.height()) / 2.0F;
        localj.vcr.top = ((int)(this.Nmh.top - f));
        localj.vcr.bottom = ((int)(f + this.Nmh.bottom));
      }
      for (;;)
      {
        this.Nmh.round(localj.kXj);
        t.a(localj.aHZ, new RectF(0.0F, 0.0F, localad.Nna, localad.Nnb), new RectF(localj.vcr));
        localj.vcr.offset(-(int)this.Nmi.left, -(int)this.Nmi.top);
        localad.Nng.kXj.set(localj.vcr);
        localj.BZx = t.e(localj.aHZ);
        localj.aGN = (localj.BZx * 5.0F);
        localj.aGO = (localj.BZx * 0.25F);
        localad.Nng.YHT = true;
        break;
        label313:
        f = (this.Nmh.height() * 1.0F / localad.Nnb * localad.Nna - this.Nmh.width()) / 2.0F;
        localj.vcr.left = ((int)(this.Nmh.left - f));
        localj.vcr.right = ((int)(f + this.Nmh.right));
      }
    }
    AppMethodBeat.o(231045);
  }
  
  public final Size gtj()
  {
    AppMethodBeat.i(231053);
    Size localSize = new Size(this.Nme, this.Nmf);
    AppMethodBeat.o(231053);
    return localSize;
  }
  
  public final void gtk()
  {
    AppMethodBeat.i(231073);
    this.Nlb = new ac((List)this.Nmm);
    this.Nlb.kH(this.Nme, this.Nmf);
    AppMethodBeat.o(231073);
  }
  
  public final void gtl()
  {
    AppMethodBeat.i(231076);
    this.Nmn = -1;
    this.Nmm.clear();
    this.Nmm.addAll((Collection)this.NlZ);
    this.Nlb = new ac((List)this.Nmm);
    this.Nlb.Sk(this.MMU);
    ac localac = this.Nlb;
    com.tencent.mm.plugin.vlog.model.local.a locala = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    localac.a(com.tencent.mm.plugin.vlog.model.local.a.gtM());
    this.Nlb.kH(this.Nme, this.Nmf);
    AppMethodBeat.o(231076);
  }
  
  public final boolean gtm()
  {
    return this.Nmn >= 0;
  }
  
  public final void kE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231049);
    this.Nmc = paramInt1;
    this.Nmd = paramInt2;
    ae localae = this.Nmj;
    Log.i("MicroMsg.VLogDataManager", "setPreviewSize, width:" + paramInt1 + ", " + paramInt2);
    localae.previewHeight = paramInt2;
    localae.previewWidth = paramInt1;
    AppMethodBeat.o(231049);
  }
  
  public final void kF(int paramInt1, int paramInt2)
  {
    this.Nme = paramInt1;
    this.Nmf = paramInt2;
  }
  
  public final void kG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231072);
    Collections.swap((List)this.Nmm, paramInt1, paramInt2);
    AppMethodBeat.o(231072);
  }
  
  public final void w(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(231068);
    Log.i(this.TAG, "editTrack editIndex:" + paramInt + ", start:" + paramLong1 + ", end:" + paramLong2);
    if ((paramInt >= 0) && (paramInt < this.Nmm.size()))
    {
      localObject1 = this.Nmm.get(paramInt);
      p.j(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      if ((paramLong1 >= 0L) && (paramLong2 >= 0L))
      {
        ((ad)localObject1).Sn(paramLong1);
        ((ad)localObject1).So(paramLong2);
      }
      localObject1 = com.tencent.mm.videocomposition.b.YHY;
      localObject2 = (Iterable)this.Nmm;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).Nng);
      }
      b.a.iK((List)localObject1);
    }
    this.Nlb = new ac((List)this.Nmm);
    this.Nlb.Sk(this.MMU);
    Object localObject1 = this.Nlb;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.gtM());
    this.Nlb.kH(this.Nme, this.Nmf);
    AppMethodBeat.o(231068);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<boi, kotlin.x>
  {
    a(v paramv)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<kotlinx.coroutines.ak, d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private kotlinx.coroutines.ak p$;
    
    b(v paramv, List paramList1, List paramList2, List paramList3, d paramd)
    {
      super(paramd);
    }
    
    public final d<kotlin.x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(242534);
      p.k(paramd, "completion");
      paramd = new b(this.Nmu, paramList, paramList1, paramList2, paramd);
      paramd.p$ = ((kotlinx.coroutines.ak)paramObject);
      AppMethodBeat.o(242534);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(242537);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(242537);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(242525);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(242525);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        this.Nmu.NlX.clear();
        this.Nmu.wTn.clear();
        v.b(this.Nmu).clear();
        v.c(this.Nmu).clear();
        this.Nmu.NlX.addAll((Collection)paramList);
        this.Nmu.wTn.addAll((Collection)paramList1);
        localObject1 = v.b(this.Nmu);
        Object localObject2 = z.NmH;
        ((LinkedList)localObject1).addAll((Collection)z.a.e(paramList, paramList1, paramList2));
        localObject1 = this.Nmu;
        localObject2 = (Iterable)v.b(this.Nmu);
        boolean bool;
        label337:
        float f2;
        float f1;
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (!((z)((Iterator)localObject2).next() instanceof r))
            {
              bool = false;
              ((v)localObject1).Nma = bool;
              localObject1 = this.Nmu;
              localObject2 = (Iterable)v.b(this.Nmu);
              if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                break label486;
              }
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                if (!((z)((Iterator)localObject2).next() instanceof ak))
                {
                  bool = false;
                  ((v)localObject1).Nmb = bool;
                  localObject1 = this.Nmu;
                  localObject2 = com.tencent.mm.plugin.vlog.util.a.NGN;
                  int i = ((z)v.b(this.Nmu).get(0)).width;
                  f2 = ((z)v.b(this.Nmu).get(0)).height * 1.0F / i;
                  if (f2 <= com.tencent.mm.plugin.vlog.util.a.gwN()) {
                    break label492;
                  }
                  f1 = com.tencent.mm.plugin.vlog.util.a.gwN();
                }
              }
            }
          }
        }
        for (;;)
        {
          v.a((v)localObject1, f1);
          localObject1 = v.c(this.Nmu);
          localObject2 = z.NmH;
          localObject2 = (List)v.b(this.Nmu);
          this.L$0 = paramObject;
          this.oDA = localObject1;
          this.label = 1;
          paramObject = z.a.a((List)localObject2, this);
          if (paramObject != locala) {
            break label613;
          }
          AppMethodBeat.o(242525);
          return locala;
          bool = true;
          break;
          label486:
          bool = true;
          break label337;
          label492:
          f1 = f2;
          if (f2 < 0.5625F) {
            f1 = 0.5625F;
          }
        }
      }
      Object localObject1 = (LinkedList)this.oDA;
      ResultKt.throwOnFailure(paramObject);
      label613:
      for (;;)
      {
        ((LinkedList)localObject1).addAll((Collection)paramObject);
        paramObject = (ad)kotlin.a.j.M((List)v.c(this.Nmu), 0);
        if (paramObject != null)
        {
          localObject1 = com.tencent.mm.videocomposition.a.YHM;
          paramObject = a.a.d(paramObject.Nng);
          paramObject.setSize(63, 112);
          paramObject.b(kotlin.a.j.listOf(kotlin.d.b.a.b.Xu(0L)), (m)new a(this));
          paramObject = kotlin.x.aazN;
          AppMethodBeat.o(242525);
          return paramObject;
        }
        AppMethodBeat.o(242525);
        return null;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/model/MultiMediaModel$setup$2$3$1"})
    static final class a
      extends q
      implements m<Long, Bitmap, kotlin.x>
    {
      a(v.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.v
 * JD-Core Version:    0.7.0.1
 */