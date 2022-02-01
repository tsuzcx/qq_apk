package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.b.a;
import com.tencent.mm.videocomposition.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "callback", "Lkotlin/Function0;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editIndex", "", "editTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "editTrackEnd", "", "editTrackPlayRate", "", "editTrackStart", "isAllImage", "", "()Z", "setAllImage", "(Z)V", "isAllVideo", "setAllVideo", "isLoading", "lastPlayRange", "Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "legendData", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "legendDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "maxDuration", "maxVisibleRect", "Landroid/graphics/RectF;", "normalCropRatio", "normalHeight", "normalWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playingList", "scriptIndex", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "vLogLoaded", "visibleRect", "vlogHeight", "vlogWidth", "createCompositionFromComposition", "refComposition", "cutComposition", "createCompositionFromScript", "index", "maxDurationMs", "createCompositionFromSource", "createCompositionFromTemplate", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "createCompositionFromTrack", "track", "createCompositionFromTrackList", "trackList", "", "ttsResult", "Lkotlin/Triple;", "currentComposition", "currentEditTrack", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "dead", "start", "end", "endEditTrack", "confirm", "cutCnt", "scrollCnt", "clearEdit", "endMoveTrack", "getIndexScript", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getNormalCropRatio", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "getVLogSize", "getVisibleRect", "isVLog", "loadVLogScript", "sid", "fid", "moveTrack", "fromPosition", "toPosition", "refFullScreenRatio", "refFullScreenVisibleRect", "Landroid/graphics/Rect;", "scaleEdit", "playRate", "selectTrack", "setMaxDuration", "duration", "setMaxVisibleRect", "cropToNormalRatio", "setNormalMaxSize", "width", "height", "setVLogSize", "setup", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupFullScreenImageSourceTrackCrop", "screenSize", "setupFullScreenSourceTrackCrop", "byWidth", "setupSourceTrackCrop", "setupSourceTrackCropByVideoTemplate", "transformFullScreenSourceTrackCrop", "updateEdit", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  implements com.tencent.mm.vending.e.a
{
  final LinkedList<Integer> ApQ;
  private final String TAG;
  public ac TYA;
  public final LinkedList<String> TZD;
  private final LinkedList<z> TZE;
  public final LinkedList<ad> TZF;
  public boolean TZG;
  public boolean TZH;
  private int TZI;
  private int TZJ;
  private int TZK;
  private int TZL;
  private float TZM;
  public final RectF TZN;
  private final RectF TZO;
  private final ae TZP;
  private final kotlin.g.a.b<cct, ah> TZQ;
  private boolean TZR;
  private final LinkedList<ad> TZS;
  private int TZT;
  private int TZU;
  public ad TZV;
  private long TZW;
  private long TZX;
  private float TZY;
  private final x TZZ;
  public long Tzj;
  private kotlin.g.a.a<ah> callback;
  private boolean isLoading;
  
  public v()
  {
    AppMethodBeat.i(283590);
    this.TAG = "MicroMsg.MultiMediaModel";
    this.TZD = new LinkedList();
    this.ApQ = new LinkedList();
    this.TZE = new LinkedList();
    this.TZF = new LinkedList();
    com.tencent.mm.plugin.vlog.util.a locala = com.tencent.mm.plugin.vlog.util.a.UsM;
    this.TZM = com.tencent.mm.plugin.vlog.util.a.hUK();
    this.TZN = new RectF();
    this.TZO = new RectF();
    this.TZP = new ae();
    this.TZQ = ((kotlin.g.a.b)new a(this));
    this.TYA = new ac((List)ab.aivy);
    this.TZS = new LinkedList();
    this.TZT = -1;
    this.TZU = -1;
    this.TZY = 1.0F;
    this.TZZ = new x();
    AppMethodBeat.o(283590);
  }
  
  public final void Q(List<ad> paramList, List<kotlin.u<String, Long, Long>> paramList1)
  {
    AppMethodBeat.i(283777);
    kotlin.g.b.s.u(paramList, "trackList");
    Object localObject1 = com.tencent.mm.videocomposition.b.agDF;
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
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).UaI);
    }
    b.a.lS((List)localObject1);
    Object localObject3 = ((Iterable)paramList).iterator();
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = null;
    }
    label234:
    label240:
    do
    {
      localObject1 = (ad)localObject1;
      if (localObject1 != null) {
        break;
      }
      l1 = 9223372036854775807L;
      if (paramList1 != null) {
        break label441;
      }
      paramList1 = null;
      localObject1 = (List)new ArrayList();
      ((List)localObject1).addAll((Collection)paramList);
      if (paramList1 != null) {
        ((List)localObject1).addAll((Collection)paramList1);
      }
      this.TYA = new ac((List)localObject1);
      this.TYA.wz(this.Tzj);
      paramList = this.TYA;
      paramList1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      paramList.a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
      this.TYA.mu(this.TZK, this.TZL);
      AppMethodBeat.o(283777);
      return;
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    long l1 = ((ad)localObject1).UaI.endTimeMs;
    label377:
    localObject2 = ((Iterator)localObject3).next();
    long l2 = ((ad)localObject2).UaI.endTimeMs;
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
        l1 = ((ad)localObject1).UaI.endTimeMs;
        break label234;
        label441:
        localObject1 = (Iterable)paramList1;
        paramList1 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (kotlin.u)((Iterator)localObject1).next();
          localObject3 = (String)((kotlin.u)localObject2).bsC;
          l2 = ((Number)((kotlin.u)localObject2).bsD).longValue();
          long l3 = ((Number)((kotlin.u)localObject2).aiuN).longValue();
          localObject2 = new ad((String)localObject3, 3);
          ((ad)localObject2).setStartTimeMs(l2);
          ((ad)localObject2).wA(Math.min(l3, l1));
          ((ad)localObject2).wB(0L);
          ((ad)localObject2).wC(l3 - l2);
          ((ad)localObject2).setVolume(3.0F);
          paramList1.add(localObject2);
        }
        paramList1 = (List)paramList1;
        break label240;
      }
      break label377;
    }
  }
  
  public final Object a(final List<String> paramList, final List<Integer> paramList1, final List<Integer> paramList2, d<? super ah> paramd)
  {
    AppMethodBeat.i(283637);
    paramList = l.a((f)bg.kCi(), (m)new b(this, paramList, paramList1, paramList2, null), paramd);
    AppMethodBeat.o(283637);
    return paramList;
  }
  
  public final void a(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(283645);
    kotlin.g.b.s.u(paramRectF, "maxVisibleRect");
    this.TZO.set(paramRectF);
    this.TZN.set(paramRectF);
    if (paramBoolean)
    {
      float f = (paramRectF.height() - paramRectF.width() * this.TZM) / 2.0F;
      this.TZN.inset(0.0F, f);
    }
    AppMethodBeat.o(283645);
  }
  
  public final void a(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(283772);
    kotlin.g.b.s.u(paramac, "refComposition");
    paramac = (List)paramac.TDz;
    Object localObject1 = com.tencent.mm.videocomposition.b.agDF;
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
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).UaI);
    }
    b.a.lS((List)localObject1);
    localObject1 = (List)new ArrayList();
    ((List)localObject1).addAll((Collection)paramac);
    this.TYA = new ac((List)localObject1);
    if (paramBoolean) {
      this.TYA.wz(this.Tzj);
    }
    paramac = this.TYA;
    localObject1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    paramac.a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
    this.TYA.mu(this.TZK, this.TZL);
    AppMethodBeat.o(283772);
  }
  
  public final void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(283735);
    Log.i(this.TAG, "endEditTrack editIndex:" + this.TZU + ", confirm:" + paramBoolean1 + ", start:" + paramLong1 + ", end:" + paramLong2);
    if ((this.TZU >= 0) && (this.TZU < this.TZS.size()))
    {
      localObject1 = this.TZS.get(this.TZU);
      kotlin.g.b.s.s(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      localObject2 = ((ad)localObject1).UaH;
      ((MediaEditReportInfo.EditItem)localObject2).clickEditCount += 1;
      localObject2 = ((ad)localObject1).UaH;
      ((MediaEditReportInfo.EditItem)localObject2).durationCutCount += paramInt1;
      localObject2 = ((ad)localObject1).UaH;
      ((MediaEditReportInfo.EditItem)localObject2).durationScrollCount += paramInt2;
      if ((paramBoolean1) && (paramLong1 >= 0L) && (paramLong2 >= 0L))
      {
        ((ad)localObject1).wB(((float)paramLong1 * ((ad)localObject1).UaI.sAn));
        ((ad)localObject1).wC(((float)paramLong2 * ((ad)localObject1).UaI.sAn));
      }
      for (;;)
      {
        paramLong1 = ((float)(((ad)localObject1).UaI.TDx - ((ad)localObject1).UaI.TDw) / ((ad)localObject1).UaI.sAn);
        ((ad)localObject1).UaH.targetDuration = paramLong1;
        if (paramBoolean2)
        {
          this.TZV = null;
          this.TZU = -1;
        }
        localObject1 = com.tencent.mm.videocomposition.b.agDF;
        localObject2 = (Iterable)this.TZS;
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).UaI);
        }
        ((ad)localObject1).wB(this.TZW);
        ((ad)localObject1).wC(this.TZX);
      }
      b.a.lS((List)localObject1);
    }
    this.TYA = new ac((List)this.TZS);
    this.TYA.wz(this.Tzj);
    Object localObject1 = this.TYA;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
    this.TYA.mu(this.TZK, this.TZL);
    AppMethodBeat.o(283735);
  }
  
  public final void a(boolean paramBoolean, Size paramSize)
  {
    AppMethodBeat.i(283661);
    kotlin.g.b.s.u(paramSize, "screenSize");
    Rect localRect1 = new Rect();
    Object localObject1 = (Iterable)this.TZF;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (ad)localObject2;
      i locali = ((ad)localObject2).UaF;
      float f1 = ((ad)localObject2).UaD / ((ad)localObject2).UaC;
      int k;
      int j;
      label115:
      float f2;
      label179:
      Rect localRect2;
      if (i == 0)
      {
        k = paramSize.getWidth();
        j = paramSize.getHeight();
        f2 = j / k;
        if (((i != 0) || (!paramBoolean)) && ((i == 0) || (f1 <= f2))) {
          break label343;
        }
        f1 *= k;
        f2 = (j - f1) / 2.0F;
        locali.yok.set(0, (int)f2, k, (int)(f1 + f2));
        if (i == 0)
        {
          localRect2 = locali.yok;
          if (paramSize.getWidth() * paramSize.getHeight() >= localRect2.width() * localRect2.height()) {
            break label380;
          }
          localRect1.set(0, 0, paramSize.getWidth(), paramSize.getHeight());
        }
      }
      for (;;)
      {
        t.a(locali.matrix, new RectF(0.0F, 0.0F, ((ad)localObject2).UaC, ((ad)localObject2).UaD), new RectF(localRect1));
        locali.HLs = t.g(locali.matrix);
        locali.maxScale = (locali.HLs * 5.0F);
        locali.minScale = (locali.HLs * 0.25F);
        ((ad)localObject2).UaI.agDA = true;
        i += 1;
        break;
        k = localRect1.width();
        j = localRect1.height();
        break label115;
        label343:
        f1 = j / f1;
        f2 = (k - f1) / 2.0F;
        locali.yok.set((int)f2, 0, (int)(f1 + f2), j);
        break label179;
        label380:
        localRect1.set(localRect2);
      }
    }
    AppMethodBeat.o(283661);
  }
  
  public final void apy(int paramInt)
  {
    AppMethodBeat.i(283714);
    Log.i(this.TAG, kotlin.g.b.s.X("editTrack index:", Integer.valueOf(paramInt)));
    this.TZU = paramInt;
    this.TZZ.start = this.TYA.Uaw.getPlayStart();
    this.TZZ.axI = this.TYA.Uaw.hQW();
    if ((this.TZU >= 0) && (this.TZU < this.TZS.size()))
    {
      Object localObject1 = this.TZS.get(this.TZU);
      kotlin.g.b.s.s(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      this.TZV = ((ad)localObject1);
      this.TZW = ((ad)localObject1).UaI.TDw;
      this.TZX = ((ad)localObject1).UaI.TDx;
      this.TZY = ((ad)localObject1).UaI.sAn;
      Object localObject2 = new ad(((ad)localObject1).path, ((ad)localObject1).type);
      ((ad)localObject2).wC(((ad)localObject1).UaI.UjZ);
      ((ad)localObject2).wA(((float)((ad)localObject1).UaI.UjZ / ((ad)localObject1).UaI.sAn));
      ((ad)localObject2).setPlayRate(((ad)localObject1).UaI.sAn);
      ((ad)localObject2).UaC = ((ad)localObject1).UaC;
      ((ad)localObject2).UaD = ((ad)localObject1).UaD;
      ((ad)localObject2).UaF.Gl.set(((ad)localObject1).UaF.Gl);
      ((ad)localObject2).UaF.yok.set(((ad)localObject1).UaF.yok);
      ((ad)localObject2).UaF.viewRect.set(((ad)localObject1).UaF.viewRect);
      ((ad)localObject2).UaF.matrix.set(((ad)localObject1).UaF.matrix);
      ((ad)localObject2).UaI.Gl.set(((ad)localObject1).UaI.Gl);
      ((ad)localObject2).UaI.jLQ();
      kotlin.g.b.s.u(localObject2, "track");
      this.TYA = new ac(p.listOf(localObject2));
      this.TYA.mu(this.TZK, this.TZL);
      localObject1 = this.TYA;
      localObject2 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
      this.TYA.bs(((float)this.TZW / this.TZY), ((float)this.TZX / this.TZY));
    }
    AppMethodBeat.o(283714);
  }
  
  public final void bx(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(283724);
    this.TYA.bs(paramLong1, paramLong2);
    AppMethodBeat.o(283724);
  }
  
  public final void c(a.c paramc)
  {
    AppMethodBeat.i(283765);
    kotlin.g.b.s.u(paramc, "template");
    this.TZT = -1;
    this.TZS.clear();
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    localObject1 = com.tencent.mm.plugin.vlog.model.local.a.a(paramc, (List)this.TZF);
    kotlin.g.b.s.u(paramc, "template");
    kotlin.g.b.s.u(localObject1, "trackList");
    ad localad;
    if (paramc.UbT)
    {
      localObject2 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localad = (ad)((Iterator)localObject2).next();
        Object localObject3 = paramc.Kz;
        double d = 1.0D * ((Size)localObject3).getWidth() / ((Size)localObject3).getHeight();
        localad.UaI.Gl.setEmpty();
        int i;
        if (1.0D * localad.UaI.UaC / localad.UaI.UaD < d)
        {
          i = localad.UaI.UaC;
          d = i / d;
          localObject3 = new Rect();
          ((Rect)localObject3).left = 0;
          ((Rect)localObject3).right = i;
          ((Rect)localObject3).top = ((int)((localad.UaI.UaD - d) / 2.0D));
          ((Rect)localObject3).bottom = ((int)(d + ((Rect)localObject3).top));
          localad.UaI.agDz.set((Rect)localObject3);
        }
        for (;;)
        {
          localad.UaI.agDA = false;
          Log.i(this.TAG, "track source size:[" + localad.UaI.UaC + ", " + localad.UaI.UaD + "], trackCropRect:" + localad.UaI.agDz + ", templateSize:" + paramc.Kz);
          break;
          i = localad.UaI.UaD;
          d *= i;
          localObject3 = new Rect();
          ((Rect)localObject3).top = 0;
          ((Rect)localObject3).bottom = i;
          ((Rect)localObject3).left = ((int)((localad.UaI.UaC - d) / 2.0D));
          ((Rect)localObject3).right = ((int)(d + ((Rect)localObject3).left));
          localad.UaI.agDz.set((Rect)localObject3);
        }
      }
    }
    else
    {
      localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localad = (ad)((Iterator)localObject2).next();
        localad.UaI.agDz.set(0, 0, localad.UaI.UaC, localad.UaI.UaD);
        localad.UaI.agDA = false;
      }
    }
    this.TZS.addAll((Collection)localObject1);
    this.TYA = new ac((List)this.TZS);
    this.TYA.wz(paramc.duration);
    localObject1 = this.TYA;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
    this.TYA.mu(this.TZK, (int)(this.TZK / (1.0D * paramc.Kz.getWidth() / paramc.Kz.getHeight())));
    this.TYA.FO(false);
    ac.a(this.TYA, paramc.nBT);
    AppMethodBeat.o(283765);
  }
  
  public final void dA(float paramFloat)
  {
    AppMethodBeat.i(283721);
    ad localad = this.TZV;
    if (localad != null)
    {
      localad.setPlayRate(paramFloat);
      localad.UaI.jLQ();
    }
    localad = (ad)p.oL((List)this.TYA.TDz);
    if (localad != null)
    {
      localad.setPlayRate(paramFloat);
      localad.UaI.jLQ();
      this.TYA.bs(localad.UaI.startTimeMs, localad.UaI.endTimeMs);
    }
    AppMethodBeat.o(283721);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(283786);
    ae localae = this.TZP;
    localae.UaN = null;
    com.tencent.mm.kernel.h.aZW().b(1469, (com.tencent.mm.am.h)localae);
    com.tencent.mm.kernel.h.aZW().b(2972, (com.tencent.mm.am.h)localae);
    AppMethodBeat.o(283786);
  }
  
  public final void g(Size paramSize)
  {
    AppMethodBeat.i(283674);
    kotlin.g.b.s.u(paramSize, "screenSize");
    int i = paramSize.getWidth();
    int j = paramSize.getHeight();
    Rect localRect1 = new Rect();
    Iterator localIterator = ((Iterable)this.TZF).iterator();
    if (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      i locali = localad.UaF;
      float f1 = localad.UaD / localad.UaC * i;
      float f2 = (j - f1) / 2.0F;
      locali.yok.set(0, (int)f2, i, (int)(f1 + f2));
      Rect localRect2 = locali.yok;
      if (paramSize.getWidth() * paramSize.getHeight() < localRect2.width() * localRect2.height()) {
        localRect1.set(0, 0, paramSize.getWidth(), paramSize.getHeight());
      }
      for (;;)
      {
        t.a(locali.matrix, new RectF(0.0F, 0.0F, localad.UaC, localad.UaD), new RectF(localRect1));
        locali.HLs = t.g(locali.matrix);
        locali.maxScale = (locali.HLs * 5.0F);
        locali.minScale = (locali.HLs * 0.25F);
        localad.UaI.agDA = true;
        break;
        localRect1.set(localRect2);
      }
    }
    AppMethodBeat.o(283674);
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(283684);
    kotlin.g.b.s.u(paramRectF, "maxVisibleRect");
    Object localObject1 = (Iterable)this.TZF;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (ad)localObject2;
      i locali = ((ad)localObject2).UaF;
      if (i == 0) {
        locali.yok.offset(-(int)paramRectF.left, -(int)paramRectF.top);
      }
      ((ad)localObject2).UaI.Gl.set(locali.yok);
      locali.viewRect.set(locali.yok);
      i += 1;
    }
    AppMethodBeat.o(283684);
  }
  
  public final boolean hQD()
  {
    return this.TZG;
  }
  
  public final Rect hQE()
  {
    AppMethodBeat.i(283649);
    Rect localRect = ((ad)this.TZF.getFirst()).UaF.yok;
    AppMethodBeat.o(283649);
    return localRect;
  }
  
  public final void hQF()
  {
    AppMethodBeat.i(283696);
    Iterator localIterator = ((Iterable)this.TZF).iterator();
    if (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      i locali = localad.UaF;
      float f;
      if (locali.matrix.isIdentity())
      {
        f = localad.UaD * 1.0F / localad.UaC;
        this.TZN.round(locali.yok);
        if (f <= this.TZN.height() / this.TZN.width()) {
          break label313;
        }
        f = (this.TZN.width() * 1.0F / localad.UaC * localad.UaD - this.TZN.height()) / 2.0F;
        locali.yok.top = ((int)(this.TZN.top - f));
        locali.yok.bottom = ((int)(f + this.TZN.bottom));
      }
      for (;;)
      {
        this.TZN.round(locali.Gl);
        t.a(locali.matrix, new RectF(0.0F, 0.0F, localad.UaC, localad.UaD), new RectF(locali.yok));
        locali.yok.offset(-(int)this.TZO.left, -(int)this.TZO.top);
        localad.UaI.Gl.set(locali.yok);
        locali.HLs = t.g(locali.matrix);
        locali.maxScale = (locali.HLs * 5.0F);
        locali.minScale = (locali.HLs * 0.25F);
        localad.UaI.agDA = true;
        break;
        label313:
        f = (this.TZN.height() * 1.0F / localad.UaD * localad.UaC - this.TZN.width()) / 2.0F;
        locali.yok.left = ((int)(this.TZN.left - f));
        locali.yok.right = ((int)(f + this.TZN.right));
      }
    }
    AppMethodBeat.o(283696);
  }
  
  public final Size hQG()
  {
    AppMethodBeat.i(283707);
    Size localSize = new Size(this.TZK, this.TZL);
    AppMethodBeat.o(283707);
    return localSize;
  }
  
  public final void hQH()
  {
    AppMethodBeat.i(283749);
    this.TYA = new ac((List)this.TZS);
    this.TYA.mu(this.TZK, this.TZL);
    AppMethodBeat.o(283749);
  }
  
  public final void hQI()
  {
    AppMethodBeat.i(283755);
    this.TZT = -1;
    this.TZS.clear();
    this.TZS.addAll((Collection)this.TZF);
    this.TYA = new ac((List)this.TZS);
    this.TYA.wz(this.Tzj);
    ac localac = this.TYA;
    com.tencent.mm.plugin.vlog.model.local.a locala = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    localac.a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
    this.TYA.mu(this.TZK, this.TZL);
    AppMethodBeat.o(283755);
  }
  
  public final ac hQJ()
  {
    return this.TYA;
  }
  
  public final boolean hQK()
  {
    return this.TZT >= 0;
  }
  
  public final ad hQL()
  {
    return this.TZV;
  }
  
  public final void mr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283702);
    this.TZI = paramInt1;
    this.TZJ = paramInt2;
    ae localae = this.TZP;
    Log.i("MicroMsg.VLogDataManager", "setPreviewSize, width:" + paramInt1 + ", " + paramInt2);
    localae.previewHeight = paramInt2;
    localae.previewWidth = paramInt1;
    AppMethodBeat.o(283702);
  }
  
  public final void ms(int paramInt1, int paramInt2)
  {
    this.TZK = paramInt1;
    this.TZL = paramInt2;
  }
  
  public final void mt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283747);
    Collections.swap((List)this.TZS, paramInt1, paramInt2);
    AppMethodBeat.o(283747);
  }
  
  public final void v(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(283742);
    Log.i(this.TAG, "editTrack editIndex:" + paramInt + ", start:" + paramLong1 + ", end:" + paramLong2);
    if ((paramInt >= 0) && (paramInt < this.TZS.size()))
    {
      localObject1 = this.TZS.get(paramInt);
      kotlin.g.b.s.s(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      if ((paramLong1 >= 0L) && (paramLong2 >= 0L))
      {
        ((ad)localObject1).wB(paramLong1);
        ((ad)localObject1).wC(paramLong2);
      }
      localObject1 = com.tencent.mm.videocomposition.b.agDF;
      localObject2 = (Iterable)this.TZS;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).UaI);
      }
      b.a.lS((List)localObject1);
    }
    this.TYA = new ac((List)this.TZS);
    this.TYA.wz(this.Tzj);
    Object localObject1 = this.TYA;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.hRu());
    this.TYA.mu(this.TZK, this.TZL);
    AppMethodBeat.o(283742);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<cct, ah>
  {
    a(v paramv)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    b(v paramv, List<String> paramList, List<Integer> paramList1, List<Integer> paramList2, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(283285);
      paramObject = (d)new b(this.Uaa, paramList, paramList1, paramList2, paramd);
      AppMethodBeat.o(283285);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(283278);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(283278);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        this.Uaa.TZD.clear();
        this.Uaa.ApQ.clear();
        v.b(this.Uaa).clear();
        v.c(this.Uaa).clear();
        this.Uaa.TZD.addAll((Collection)paramList);
        this.Uaa.ApQ.addAll((Collection)paramList1);
        paramObject = v.b(this.Uaa);
        localObject1 = z.Uai;
        paramObject.addAll((Collection)z.a.e(paramList, paramList1, paramList2));
        paramObject = this.Uaa;
        localObject1 = (Iterable)v.b(this.Uaa);
        int i;
        boolean bool;
        label253:
        float f2;
        label335:
        label343:
        float f1;
        if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext()) {
            if (!((z)((Iterator)localObject1).next() instanceof r))
            {
              i = 0;
              if (i == 0) {
                break label488;
              }
              bool = true;
              paramObject.TZG = bool;
              paramObject = this.Uaa;
              localObject1 = (Iterable)v.b(this.Uaa);
              if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
                break label494;
              }
              localObject1 = ((Iterable)localObject1).iterator();
              while (((Iterator)localObject1).hasNext()) {
                if (!((z)((Iterator)localObject1).next() instanceof al))
                {
                  i = 0;
                  if (i == 0) {
                    break label500;
                  }
                  bool = true;
                  paramObject.TZH = bool;
                  paramObject = this.Uaa;
                  localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
                  i = ((z)v.b(this.Uaa).get(0)).width;
                  f2 = ((z)v.b(this.Uaa).get(0)).height * 1.0F / i;
                  if (f2 <= com.tencent.mm.plugin.vlog.util.a.hUK()) {
                    break label506;
                  }
                  f1 = com.tencent.mm.plugin.vlog.util.a.hUK();
                }
              }
            }
          }
        }
        for (;;)
        {
          v.a(paramObject, f1);
          localObject1 = v.c(this.Uaa);
          paramObject = z.Uai;
          paramObject = (List)v.b(this.Uaa);
          d locald = (d)this;
          this.L$0 = localObject1;
          this.label = 1;
          paramObject = z.a.b(paramObject, locald);
          if (paramObject != localObject2) {
            break label638;
          }
          AppMethodBeat.o(283278);
          return localObject2;
          i = 1;
          break;
          label488:
          bool = false;
          break label253;
          label494:
          i = 1;
          break label335;
          label500:
          bool = false;
          break label343;
          label506:
          f1 = f2;
          if (f2 < 0.5625F) {
            f1 = 0.5625F;
          }
        }
      }
      Object localObject1 = (LinkedList)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      label638:
      for (;;)
      {
        ((LinkedList)localObject1).addAll((Collection)paramObject);
        localObject1 = (ad)p.ae((List)v.c(this.Uaa), 0);
        if (localObject1 == null)
        {
          AppMethodBeat.o(283278);
          return null;
        }
        paramObject = this.Uaa;
        localObject2 = com.tencent.mm.videocomposition.a.agDr;
        localObject1 = a.a.d(((ad)localObject1).UaI);
        ((com.tencent.mm.videocomposition.a)localObject1).setSize(63, 112);
        ((com.tencent.mm.videocomposition.a)localObject1).b(p.listOf(kotlin.d.b.a.b.BF(0L)), (m)new v.b.a(paramObject));
        paramObject = ah.aiuX;
        AppMethodBeat.o(283278);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.v
 * JD-Core Version:    0.7.0.1
 */