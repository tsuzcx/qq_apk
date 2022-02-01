package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.videocomposition.c.a;
import com.tencent.mm.videocomposition.d.a;
import com.tencent.mm.videocomposition.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.c;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "callback", "Lkotlin/Function0;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editIndex", "", "editTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "editTrackEnd", "", "editTrackPlayRate", "", "editTrackStart", "isAllImage", "", "()Z", "setAllImage", "(Z)V", "isAllVideo", "setAllVideo", "isLoading", "lastPlayRange", "Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "legendData", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "legendDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "maxDuration", "maxVisibleRect", "Landroid/graphics/RectF;", "normalCropRatio", "normalHeight", "normalWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playingList", "scriptIndex", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "vLogLoaded", "visibleRect", "vlogHeight", "vlogWidth", "createCompositionFromComposition", "refComposition", "cutComposition", "createCompositionFromScript", "index", "maxDurationMs", "createCompositionFromSource", "createCompositionFromTemplate", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "createCompositionFromTrack", "track", "createCompositionFromTrackList", "trackList", "", "recordResult", "Lkotlin/Triple;", "ttsResult", "currentComposition", "currentEditTrack", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "dead", "start", "end", "endEditTrack", "confirm", "cutCnt", "scrollCnt", "clearEdit", "endMoveTrack", "getIndexScript", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getNormalCropRatio", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "getVLogSize", "getVisibleRect", "isVLog", "loadVLogScript", "sid", "fid", "moveTrack", "fromPosition", "toPosition", "refFullScreenRatio", "refFullScreenVisibleRect", "Landroid/graphics/Rect;", "scaleEdit", "playRate", "selectTrack", "setMaxDuration", "duration", "setMaxVisibleRect", "cropToNormalRatio", "setNormalMaxSize", "width", "height", "setVLogSize", "setup", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupFullScreenSourceTrackCrop", "byWidth", "screenSize", "setupSourceTrackCrop", "setupSourceTrackCropByVideoTemplate", "transformFullScreenSourceTrackCrop", "updateEdit", "plugin-vlog_release"})
public final class v
  implements com.tencent.mm.vending.e.a
{
  public long Gfd;
  public ac GxA;
  private int GyA;
  private int GyB;
  private int GyC;
  private int GyD;
  float GyE;
  public final RectF GyF;
  private final RectF GyG;
  private final ae GyH;
  private final kotlin.g.a.b<bha, kotlin.x> GyI;
  boolean GyJ;
  private final LinkedList<ad> GyK;
  private int GyL;
  private int GyM;
  public ad GyN;
  private long GyO;
  private long GyP;
  private float GyQ;
  private final x GyR;
  public final LinkedList<String> Gyv;
  final LinkedList<z> Gyw;
  public final LinkedList<ad> Gyx;
  public boolean Gyy;
  public boolean Gyz;
  final String TAG;
  boolean isLoading;
  final LinkedList<Integer> tmP;
  kotlin.g.a.a<kotlin.x> uGD;
  
  public v()
  {
    AppMethodBeat.i(190618);
    this.TAG = "MicroMsg.MultiMediaModel";
    this.Gyv = new LinkedList();
    this.tmP = new LinkedList();
    this.Gyw = new LinkedList();
    this.Gyx = new LinkedList();
    com.tencent.mm.plugin.vlog.util.a locala = com.tencent.mm.plugin.vlog.util.a.GQC;
    this.GyE = com.tencent.mm.plugin.vlog.util.a.fEA();
    this.GyF = new RectF();
    this.GyG = new RectF();
    this.GyH = new ae();
    this.GyI = ((kotlin.g.a.b)new a(this));
    this.GxA = new ac((List)kotlin.a.v.SXr);
    this.GyK = new LinkedList();
    this.GyL = -1;
    this.GyM = -1;
    this.GyQ = 1.0F;
    this.GyR = new x();
    AppMethodBeat.o(190618);
  }
  
  public final Object a(final List<String> paramList, final List<Integer> paramList1, final List<Integer> paramList2, kotlin.d.d<? super kotlin.x> paramd)
  {
    AppMethodBeat.i(190596);
    paramList = kotlinx.coroutines.g.a((kotlin.d.f)ba.hMW(), (m)new b(this, paramList, paramList1, paramList2, null), paramd);
    AppMethodBeat.o(190596);
    return paramList;
  }
  
  public final void a(RectF paramRectF, boolean paramBoolean)
  {
    AppMethodBeat.i(190597);
    p.h(paramRectF, "maxVisibleRect");
    this.GyG.set(paramRectF);
    this.GyF.set(paramRectF);
    if (paramBoolean)
    {
      float f = (paramRectF.height() - paramRectF.width() * this.GyE) / 2.0F;
      this.GyF.inset(0.0F, f);
    }
    AppMethodBeat.o(190597);
  }
  
  public final void a(ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(190615);
    p.h(paramac, "refComposition");
    paramac = (List)paramac.Gzn;
    Object localObject1 = com.tencent.mm.videocomposition.d.Rhf;
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
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).GzA);
    }
    d.a.jZ((List)localObject1);
    localObject1 = (List)new ArrayList();
    ((List)localObject1).addAll((Collection)paramac);
    this.GxA = new ac((List)localObject1);
    if (paramBoolean) {
      this.GxA.KN(this.Gfd);
    }
    paramac = this.GxA;
    localObject1 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    paramac.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
    this.GxA.jt(this.GyC, this.GyD);
    AppMethodBeat.o(190615);
  }
  
  public final void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(190608);
    Log.i(this.TAG, "endEditTrack editIndex:" + this.GyM + ", confirm:" + paramBoolean1 + ", start:" + paramLong1 + ", end:" + paramLong2);
    if ((this.GyM >= 0) && (this.GyM < this.GyK.size()))
    {
      localObject1 = this.GyK.get(this.GyM);
      p.g(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      localObject2 = ((ad)localObject1).Gzz;
      ((MediaEditReportInfo.EditItem)localObject2).clickEditCount += 1;
      localObject2 = ((ad)localObject1).Gzz;
      ((MediaEditReportInfo.EditItem)localObject2).durationCutCount += paramInt1;
      localObject2 = ((ad)localObject1).Gzz;
      ((MediaEditReportInfo.EditItem)localObject2).durationScrollCount += paramInt2;
      if ((paramBoolean1) && (paramLong1 >= 0L) && (paramLong2 >= 0L))
      {
        ((ad)localObject1).KQ(((float)paramLong1 * ((ad)localObject1).GzA.mwH));
        ((ad)localObject1).KR(((float)paramLong2 * ((ad)localObject1).GzA.mwH));
      }
      for (;;)
      {
        paramLong1 = ((float)(((ad)localObject1).GzA.GGA - ((ad)localObject1).GzA.GGz) / ((ad)localObject1).GzA.mwH);
        ((ad)localObject1).Gzz.targetDuration = paramLong1;
        if (paramBoolean2)
        {
          this.GyN = null;
          this.GyM = -1;
        }
        localObject1 = com.tencent.mm.videocomposition.d.Rhf;
        localObject2 = (Iterable)this.GyK;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).GzA);
        }
        ((ad)localObject1).KQ(this.GyO);
        ((ad)localObject1).KR(this.GyP);
      }
      d.a.jZ((List)localObject1);
    }
    this.GxA = new ac((List)this.GyK);
    this.GxA.KN(this.Gfd);
    Object localObject1 = this.GxA;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
    this.GxA.jt(this.GyC, this.GyD);
    AppMethodBeat.o(190608);
  }
  
  public final void a(boolean paramBoolean, Size paramSize)
  {
    AppMethodBeat.i(190600);
    p.h(paramSize, "screenSize");
    z.c localc = new z.c();
    z.d locald1 = new z.d();
    z.d locald2 = new z.d();
    Rect localRect1 = new Rect();
    Object localObject1 = (Iterable)this.Gyx;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject2 = (ad)localObject2;
      j localj = ((ad)localObject2).Gzx;
      float f1 = ((ad)localObject2).Gzv / ((ad)localObject2).Gzu;
      label148:
      float f2;
      label233:
      Rect localRect2;
      if (i == 0)
      {
        locald1.SYE = paramSize.getWidth();
        locald2.SYE = paramSize.getHeight();
        localc.SYD = (locald2.SYE / locald1.SYE);
        if (((i != 0) || (!paramBoolean)) && ((i == 0) || (f1 <= localc.SYD))) {
          break label403;
        }
        f1 *= locald1.SYE;
        f2 = (locald2.SYE - f1) / 2.0F;
        localj.rwL.set(0, (int)f2, locald1.SYE, (int)(f1 + f2));
        if (i == 0)
        {
          localRect2 = localj.rwL;
          if (paramSize.getWidth() * paramSize.getHeight() >= localRect2.width() * localRect2.height()) {
            break label449;
          }
          localRect1.set(0, 0, paramSize.getWidth(), paramSize.getHeight());
        }
      }
      for (;;)
      {
        t.a(localj.gT, new RectF(0.0F, 0.0F, ((ad)localObject2).Gzu, ((ad)localObject2).Gzv), new RectF(localRect1));
        localj.xnf = t.e(localj.gT);
        localj.aXt = (localj.xnf * 5.0F);
        localj.aXu = (localj.xnf * 0.25F);
        ((ad)localObject2).GzA.Rhb = true;
        i += 1;
        break;
        locald1.SYE = localRect1.width();
        locald2.SYE = localRect1.height();
        break label148;
        label403:
        f1 = locald2.SYE / f1;
        f2 = (locald1.SYE - f1) / 2.0F;
        localj.rwL.set((int)f2, 0, (int)(f1 + f2), locald2.SYE);
        break label233;
        label449:
        localRect1.set(localRect2);
      }
    }
    AppMethodBeat.o(190600);
  }
  
  public final void acx(int paramInt)
  {
    AppMethodBeat.i(190605);
    Log.i(this.TAG, "editTrack index:".concat(String.valueOf(paramInt)));
    this.GyM = paramInt;
    this.GyR.start = this.GxA.Gez.getPlayStart();
    this.GyR.boX = this.GxA.Gez.fBz();
    if ((this.GyM >= 0) && (this.GyM < this.GyK.size()))
    {
      Object localObject1 = this.GyK.get(this.GyM);
      p.g(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      this.GyN = ((ad)localObject1);
      this.GyO = ((ad)localObject1).GzA.GGz;
      this.GyP = ((ad)localObject1).GzA.GGA;
      this.GyQ = ((ad)localObject1).GzA.mwH;
      Object localObject2 = new ad(((ad)localObject1).path, ((ad)localObject1).type);
      ((ad)localObject2).KR(((ad)localObject1).GzA.GJB);
      ((ad)localObject2).KP(((float)((ad)localObject1).GzA.GJB / ((ad)localObject1).GzA.mwH));
      ((ad)localObject2).setPlayRate(((ad)localObject1).GzA.mwH);
      ((ad)localObject2).Gzu = ((ad)localObject1).Gzu;
      ((ad)localObject2).Gzv = ((ad)localObject1).Gzv;
      ((ad)localObject2).Gzx.iiw.set(((ad)localObject1).Gzx.iiw);
      ((ad)localObject2).Gzx.rwL.set(((ad)localObject1).Gzx.rwL);
      ((ad)localObject2).Gzx.viewRect.set(((ad)localObject1).Gzx.viewRect);
      ((ad)localObject2).Gzx.gT.set(((ad)localObject1).Gzx.gT);
      ((ad)localObject2).GzA.iiw.set(((ad)localObject1).GzA.iiw);
      ((ad)localObject2).GzA.gKp();
      p.h(localObject2, "track");
      this.GxA = new ac(kotlin.a.j.listOf(localObject2));
      this.GxA.jt(this.GyC, this.GyD);
      localObject1 = this.GxA;
      localObject2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
      ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
      this.GxA.at(((float)this.GyO / this.GyQ), ((float)this.GyP / this.GyQ));
    }
    AppMethodBeat.o(190605);
  }
  
  public final void aw(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(190607);
    this.GxA.at(paramLong1, paramLong2);
    AppMethodBeat.o(190607);
  }
  
  public final void c(a.c paramc)
  {
    AppMethodBeat.i(190614);
    p.h(paramc, "template");
    this.GyL = -1;
    this.GyK.clear();
    Object localObject1 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    localObject1 = com.tencent.mm.plugin.vlog.model.local.a.a(paramc, (List)this.Gyx);
    p.h(paramc, "template");
    p.h(localObject1, "trackList");
    ad localad;
    if (paramc.GAH)
    {
      localObject2 = ((Iterable)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localad = (ad)((Iterator)localObject2).next();
        Object localObject3 = paramc.ApT;
        double d = 1.0D * ((Size)localObject3).getWidth() / ((Size)localObject3).getHeight();
        localad.GzA.iiw.setEmpty();
        int i;
        if (1.0D * localad.GzA.Gzu / localad.GzA.Gzv < d)
        {
          i = localad.GzA.Gzu;
          d = i / d;
          localObject3 = new Rect();
          ((Rect)localObject3).left = 0;
          ((Rect)localObject3).right = i;
          ((Rect)localObject3).top = ((int)((localad.GzA.Gzv - d) / 2.0D));
          ((Rect)localObject3).bottom = ((int)(d + ((Rect)localObject3).top));
          localad.GzA.Rha.set((Rect)localObject3);
        }
        for (;;)
        {
          localad.GzA.Rhb = false;
          Log.i(this.TAG, "track source size:[" + localad.GzA.Gzu + ", " + localad.GzA.Gzv + "], trackCropRect:" + localad.GzA.Rha + ", templateSize:" + paramc.ApT);
          break;
          i = localad.GzA.Gzv;
          d *= i;
          localObject3 = new Rect();
          ((Rect)localObject3).top = 0;
          ((Rect)localObject3).bottom = i;
          ((Rect)localObject3).left = ((int)((localad.GzA.Gzu - d) / 2.0D));
          ((Rect)localObject3).right = ((int)(d + ((Rect)localObject3).left));
          localad.GzA.Rha.set((Rect)localObject3);
        }
      }
    }
    else
    {
      localObject2 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localad = (ad)((Iterator)localObject2).next();
        localad.GzA.Rha.set(0, 0, localad.GzA.Gzu, localad.GzA.Gzv);
        localad.GzA.Rhb = false;
      }
    }
    this.GyK.addAll((Collection)localObject1);
    this.GxA = new ac((List)this.GyK);
    this.GxA.KN(paramc.duration);
    localObject1 = this.GxA;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
    this.GxA.jt(this.GyC, (int)(this.GyC / (1.0D * paramc.ApT.getWidth() / paramc.ApT.getHeight())));
    this.GxA.wB(false);
    ac.a(this.GxA, paramc.iiv);
    AppMethodBeat.o(190614);
  }
  
  public final void cf(float paramFloat)
  {
    AppMethodBeat.i(190606);
    ad localad = this.GyN;
    if (localad != null)
    {
      localad.setPlayRate(paramFloat);
      localad.GzA.gKp();
    }
    localad = (ad)kotlin.a.j.kt((List)this.GxA.Gzn);
    if (localad != null)
    {
      localad.setPlayRate(paramFloat);
      localad.GzA.gKp();
      this.GxA.at(localad.GzA.startTimeMs, localad.GzA.endTimeMs);
      AppMethodBeat.o(190606);
      return;
    }
    AppMethodBeat.o(190606);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(190617);
    ae localae = this.GyH;
    localae.GzF = null;
    com.tencent.mm.kernel.g.azz().b(1469, (i)localae);
    com.tencent.mm.kernel.g.azz().b(2972, (i)localae);
    AppMethodBeat.o(190617);
  }
  
  public final void e(List<ad> paramList, List<kotlin.r<String, Long, Long>> paramList1, List<kotlin.r<String, Long, Long>> paramList2)
  {
    AppMethodBeat.i(190616);
    p.h(paramList, "trackList");
    Object localObject1 = com.tencent.mm.videocomposition.d.Rhf;
    Object localObject2 = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label114:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ad localad = (ad)localObject3;
      if ((localad.type == 2) || (localad.type == 1)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label114;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).GzA);
    }
    d.a.jZ((List)localObject1);
    Object localObject3 = ((Iterable)paramList).iterator();
    if (!((Iterator)localObject3).hasNext()) {
      localObject1 = null;
    }
    label242:
    long l3;
    do
    {
      localObject1 = (ad)localObject1;
      if (localObject1 == null) {
        break;
      }
      l1 = ((ad)localObject1).GzA.endTimeMs;
      if (paramList1 == null) {
        break label660;
      }
      localObject1 = (Iterable)paramList1;
      paramList1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (kotlin.r)((Iterator)localObject1).next();
        localObject3 = (String)((kotlin.r)localObject2).first;
        l2 = ((Number)((kotlin.r)localObject2).second).longValue();
        l3 = ((Number)((kotlin.r)localObject2).SWY).longValue();
        localObject2 = new ad((String)localObject3, 3);
        ((ad)localObject2).KO(l2);
        ((ad)localObject2).KP(l3);
        ((ad)localObject2).KQ(0L);
        ((ad)localObject2).KR(l3 - l2);
        ((ad)localObject2).setVolume(3.0F);
        paramList1.add(localObject2);
      }
      localObject1 = ((Iterator)localObject3).next();
    } while (!((Iterator)localObject3).hasNext());
    long l1 = ((ad)localObject1).GzA.endTimeMs;
    label434:
    localObject2 = ((Iterator)localObject3).next();
    long l2 = ((ad)localObject2).GzA.endTimeMs;
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
        break label242;
        label660:
        for (paramList1 = (List)paramList1;; paramList1 = null)
        {
          if (paramList2 == null) {
            break label788;
          }
          localObject1 = (Iterable)paramList2;
          paramList2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (kotlin.r)((Iterator)localObject1).next();
            localObject3 = (String)((kotlin.r)localObject2).first;
            l2 = ((Number)((kotlin.r)localObject2).second).longValue();
            l3 = ((Number)((kotlin.r)localObject2).SWY).longValue();
            localObject2 = new ad((String)localObject3, 3);
            ((ad)localObject2).KO(l2);
            ((ad)localObject2).KP(Math.min(l3, l1));
            ((ad)localObject2).KQ(0L);
            ((ad)localObject2).KR(l3 - l2);
            ((ad)localObject2).setVolume(3.0F);
            paramList2.add(localObject2);
          }
        }
        label788:
        for (paramList2 = (List)paramList2;; paramList2 = null)
        {
          localObject1 = (List)new ArrayList();
          ((List)localObject1).addAll((Collection)paramList);
          if (paramList1 != null) {
            ((List)localObject1).addAll((Collection)paramList1);
          }
          if (paramList2 != null) {
            ((List)localObject1).addAll((Collection)paramList2);
          }
          this.GxA = new ac((List)localObject1);
          this.GxA.KN(this.Gfd);
          paramList = this.GxA;
          paramList1 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
          paramList.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
          this.GxA.jt(this.GyC, this.GyD);
          AppMethodBeat.o(190616);
          return;
        }
      }
      break label434;
    }
  }
  
  public final float fBk()
  {
    AppMethodBeat.i(190598);
    Object localObject = (ad)this.Gyx.getFirst();
    if (localObject != null)
    {
      f = ((ad)localObject).Gzu / ((ad)localObject).Gzv;
      AppMethodBeat.o(190598);
      return f;
    }
    localObject = com.tencent.mm.plugin.vlog.util.a.GQC;
    float f = com.tencent.mm.plugin.vlog.util.a.fEA();
    AppMethodBeat.o(190598);
    return f;
  }
  
  public final Rect fBl()
  {
    AppMethodBeat.i(190599);
    Rect localRect = ((ad)this.Gyx.getFirst()).Gzx.rwL;
    AppMethodBeat.o(190599);
    return localRect;
  }
  
  public final void fBm()
  {
    AppMethodBeat.i(190602);
    Iterator localIterator = ((Iterable)this.Gyx).iterator();
    if (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      j localj = localad.Gzx;
      float f;
      if (localj.gT.isIdentity())
      {
        f = localad.Gzv * 1.0F / localad.Gzu;
        this.GyF.round(localj.rwL);
        if (f <= this.GyF.height() / this.GyF.width()) {
          break label305;
        }
        f = (this.GyF.width() * 1.0F / localad.Gzu * localad.Gzv - this.GyF.height()) / 2.0F;
        localj.rwL.top = ((int)(this.GyF.top - f));
        localj.rwL.bottom = ((int)(f + this.GyF.bottom));
      }
      for (;;)
      {
        this.GyF.round(localj.iiw);
        t.a(localj.gT, new RectF(0.0F, 0.0F, localad.Gzu, localad.Gzv), new RectF(localj.rwL));
        localj.rwL.offset(0, -(int)this.GyG.top);
        localad.GzA.iiw.set(localj.rwL);
        localj.xnf = t.e(localj.gT);
        localj.aXt = (localj.xnf * 5.0F);
        localj.aXu = (localj.xnf * 0.25F);
        localad.GzA.Rhb = true;
        break;
        label305:
        f = (this.GyF.height() * 1.0F / localad.Gzv * localad.Gzu - this.GyF.width()) / 2.0F;
        localj.rwL.left = ((int)(this.GyF.left - f));
        localj.rwL.right = ((int)(f + this.GyF.right));
      }
    }
    AppMethodBeat.o(190602);
  }
  
  public final Size fBn()
  {
    AppMethodBeat.i(190604);
    Size localSize = new Size(this.GyC, this.GyD);
    AppMethodBeat.o(190604);
    return localSize;
  }
  
  public final void fBo()
  {
    AppMethodBeat.i(190612);
    this.GxA = new ac((List)this.GyK);
    this.GxA.jt(this.GyC, this.GyD);
    AppMethodBeat.o(190612);
  }
  
  public final void fBp()
  {
    AppMethodBeat.i(190613);
    this.GyL = -1;
    this.GyK.clear();
    this.GyK.addAll((Collection)this.Gyx);
    this.GxA = new ac((List)this.GyK);
    this.GxA.KN(this.Gfd);
    ac localac = this.GxA;
    com.tencent.mm.plugin.vlog.model.local.a locala = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    localac.a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
    this.GxA.jt(this.GyC, this.GyD);
    AppMethodBeat.o(190613);
  }
  
  public final boolean fBq()
  {
    return this.GyL >= 0;
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(190601);
    p.h(paramRectF, "maxVisibleRect");
    Iterator localIterator = ((Iterable)this.Gyx).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      localObject = (ad)localObject;
      j localj = ((ad)localObject).Gzx;
      if (i == 0) {
        localj.rwL.offset(0, -(int)paramRectF.top);
      }
      ((ad)localObject).GzA.iiw.set(localj.rwL);
      localj.viewRect.set(localj.rwL);
      i += 1;
    }
    AppMethodBeat.o(190601);
  }
  
  public final void jq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190603);
    this.GyA = paramInt1;
    this.GyB = paramInt2;
    ae localae = this.GyH;
    Log.i("MicroMsg.VLogDataManager", "setPreviewSize, width:" + paramInt1 + ", " + paramInt2);
    localae.previewHeight = paramInt2;
    localae.previewWidth = paramInt1;
    AppMethodBeat.o(190603);
  }
  
  public final void jr(int paramInt1, int paramInt2)
  {
    this.GyC = paramInt1;
    this.GyD = paramInt2;
  }
  
  public final void js(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190611);
    Collections.swap((List)this.GyK, paramInt1, paramInt2);
    AppMethodBeat.o(190611);
  }
  
  public final void p(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(190610);
    Log.i(this.TAG, "editTrack editIndex:" + paramInt + ", start:" + paramLong1 + ", end:" + paramLong2);
    if ((paramInt >= 0) && (paramInt < this.GyK.size()))
    {
      localObject1 = this.GyK.get(paramInt);
      p.g(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      if ((paramLong1 >= 0L) && (paramLong2 >= 0L))
      {
        ((ad)localObject1).KQ(paramLong1);
        ((ad)localObject1).KR(paramLong2);
      }
      localObject1 = com.tencent.mm.videocomposition.d.Rhf;
      localObject2 = (Iterable)this.GyK;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).GzA);
      }
      d.a.jZ((List)localObject1);
    }
    this.GxA = new ac((List)this.GyK);
    this.GxA.KN(this.Gfd);
    Object localObject1 = this.GxA;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    ((ac)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.fBP());
    this.GxA.jt(this.GyC, this.GyD);
    AppMethodBeat.o(190610);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<bha, kotlin.x>
  {
    a(v paramv)
    {
      super();
    }
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.MultiMediaModel$setup$2", f="MultiMediaModel.kt", hxM={80}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ai, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    
    b(v paramv, List paramList1, List paramList2, List paramList3, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(190594);
      p.h(paramd, "completion");
      paramd = new b(this.GyS, paramList, paramList1, paramList2, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(190594);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(190595);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.SXb);
      AppMethodBeat.o(190595);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(190593);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(190593);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        this.GyS.Gyv.clear();
        this.GyS.tmP.clear();
        this.GyS.Gyw.clear();
        this.GyS.Gyx.clear();
        this.GyS.Gyv.addAll((Collection)paramList);
        this.GyS.tmP.addAll((Collection)paramList1);
        localObject1 = this.GyS.Gyw;
        Object localObject2 = z.Gzf;
        Object localObject3 = paramList;
        localObject2 = paramList1;
        List localList = paramList2;
        p.h(localObject3, "paths");
        p.h(localObject2, "types");
        p.h(localList, "sourceFrom");
        LinkedList localLinkedList = new LinkedList();
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          int j = i + 1;
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          localObject4 = (String)localObject4;
          Object localObject5 = (Integer)kotlin.a.j.L((List)localObject2, i);
          if (localObject5 == null) {}
          while (((Integer)localObject5).intValue() != 2)
          {
            localObject5 = z.Gzf;
            p.h(localObject4, "path");
            localObject5 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject5).inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile((String)localObject4, (BitmapFactory.Options)localObject5);
            int n = z.a.aTX((String)localObject4);
            int m = ((BitmapFactory.Options)localObject5).outWidth;
            int k = ((BitmapFactory.Options)localObject5).outHeight;
            if ((n == 90) || (n == 270))
            {
              m = ((BitmapFactory.Options)localObject5).outHeight;
              k = ((BitmapFactory.Options)localObject5).outWidth;
            }
            localObject4 = new r(m, k, (String)localObject4);
            ((z)localObject4).Gze = ((Number)localList.get(i)).intValue();
            localLinkedList.add(localObject4);
            i = j;
            break;
          }
          localObject5 = z.Gzf;
          localObject4 = z.a.aTY((String)localObject4);
          if (localObject4 != null)
          {
            ((z)localObject4).Gze = ((Number)localList.get(i)).intValue();
            localLinkedList.add(localObject4);
            i = j;
          }
          else
          {
            i = j;
          }
        }
        ((LinkedList)localObject1).addAll((Collection)localLinkedList);
        localObject1 = this.GyS;
        localObject2 = (Iterable)this.GyS.Gyw;
        boolean bool;
        label650:
        float f2;
        float f1;
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (!((z)((Iterator)localObject2).next() instanceof r))
            {
              bool = false;
              ((v)localObject1).Gyy = bool;
              localObject1 = this.GyS;
              localObject2 = (Iterable)this.GyS.Gyw;
              if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                break label816;
              }
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                if (!((z)((Iterator)localObject2).next() instanceof ak))
                {
                  bool = false;
                  ((v)localObject1).Gyz = bool;
                  localObject1 = this.GyS;
                  localObject2 = com.tencent.mm.plugin.vlog.util.a.GQC;
                  i = ((z)this.GyS.Gyw.get(0)).width;
                  f2 = ((z)this.GyS.Gyw.get(0)).height * 1.0F / i;
                  if (f2 <= com.tencent.mm.plugin.vlog.util.a.fEA()) {
                    break label822;
                  }
                  f1 = com.tencent.mm.plugin.vlog.util.a.fEA();
                }
              }
            }
          }
        }
        for (;;)
        {
          ((v)localObject1).GyE = f1;
          localObject1 = this.GyS.Gyx;
          localObject2 = z.Gzf;
          localObject2 = (List)this.GyS.Gyw;
          this.L$0 = paramObject;
          this.pED = localObject1;
          this.label = 1;
          paramObject = kotlinx.coroutines.g.a((kotlin.d.f)ba.hMW(), (m)new z.a.a((List)localObject2, null), this);
          if (paramObject != locala) {
            break label945;
          }
          AppMethodBeat.o(190593);
          return locala;
          bool = true;
          break;
          label816:
          bool = true;
          break label650;
          label822:
          f1 = f2;
          if (f2 < 0.5625F) {
            f1 = 0.5625F;
          }
        }
      }
      Object localObject1 = (LinkedList)this.pED;
      ResultKt.throwOnFailure(paramObject);
      label945:
      for (;;)
      {
        ((LinkedList)localObject1).addAll((Collection)paramObject);
        paramObject = (ad)kotlin.a.j.L((List)this.GyS.Gyx, 0);
        if (paramObject != null)
        {
          localObject1 = c.RgU;
          paramObject = c.a.b(paramObject.GzA);
          paramObject.setSize(63, 112);
          paramObject.b(kotlin.a.j.listOf(kotlin.d.b.a.b.Pe(0L)), (m)new a(this));
          paramObject = kotlin.x.SXb;
          AppMethodBeat.o(190593);
          return paramObject;
        }
        AppMethodBeat.o(190593);
        return null;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/model/MultiMediaModel$setup$2$3$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.v
 * JD-Core Version:    0.7.0.1
 */