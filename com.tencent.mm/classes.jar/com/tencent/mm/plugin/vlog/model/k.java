package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import d.d.d<-Ld.y;>;
import d.g.a.b;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "callback", "Lkotlin/Function0;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editIndex", "", "editTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "isAllImage", "", "()Z", "setAllImage", "(Z)V", "isAllVideo", "setAllVideo", "isLoading", "legendData", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "legendDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "normalCropRatio", "", "normalHeight", "normalWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "kotlin.jvm.PlatformType", "playingList", "scriptIndex", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "vLogLoaded", "visibleRect", "Landroid/graphics/RectF;", "vlogHeight", "vlogWidth", "asyncCreateCompositionFromSource", "maxDurationMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCompositionFromScript", "index", "createCompositionFromSource", "createCompositionFromTrack", "track", "currentComposition", "currentEditTrack", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "dead", "doCreateCompositionFromSource", "endEditTrack", "confirm", "cutCnt", "scrollCnt", "endMoveTrack", "getIndexScript", "getMusicList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getNormalCropRatio", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "getVLogSize", "getVisibleRect", "isVLog", "loadVLogScript", "sid", "fid", "moveTrack", "fromPosition", "toPosition", "setMaxVisibleRect", "maxVisibleRect", "setNormalMaxSize", "width", "height", "setVLogSize", "setup", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupSourceTrackCrop", "plugin-vlog_release"})
public final class k
  implements com.tencent.mm.vending.e.a
{
  public r AmR;
  public final LinkedList<String> And;
  final LinkedList<n> Ane;
  public final LinkedList<u> Anf;
  public boolean Ang;
  public boolean Anh;
  private int Ani;
  private int Anj;
  public int Ank;
  public int Anl;
  public float Anm;
  public final RectF Ann;
  public d.g.a.a<d.y> Ano;
  public final v Anp;
  public final b<are, d.y> Anq;
  public boolean Ans;
  public final LinkedList<u> Ant;
  private int Anu;
  private int Anv;
  public u Anw;
  private final String TAG;
  public boolean isLoading;
  private CMTimeRange playRange;
  final LinkedList<Integer> qUF;
  
  public k()
  {
    AppMethodBeat.i(207534);
    this.TAG = "MicroMsg.MultiMediaModel";
    this.And = new LinkedList();
    this.qUF = new LinkedList();
    this.Ane = new LinkedList();
    this.Anf = new LinkedList();
    this.Anm = 1.166667F;
    this.Ann = new RectF();
    this.Anp = new v();
    this.Anq = ((b)new k.b(this));
    this.AmR = new r((List)d.a.v.KTF, null, 6);
    this.Ant = new LinkedList();
    this.Anu = -1;
    this.playRange = CMTimeRange.fromMs(0L, 0L);
    this.Anv = -1;
    AppMethodBeat.o(207534);
  }
  
  private void a(u paramu)
  {
    AppMethodBeat.i(207532);
    d.g.b.k.h(paramu, "track");
    this.AmR = new r(d.a.j.listOf(paramu), null, 6);
    AppMethodBeat.o(207532);
  }
  
  public final y RP(int paramInt)
  {
    AppMethodBeat.i(207527);
    y localy = this.Anp.RP(paramInt);
    AppMethodBeat.o(207527);
    return localy;
  }
  
  public final void RQ(int paramInt)
  {
    AppMethodBeat.i(207528);
    if (((List)this.AmR.AnT).size() == 1) {}
    for (this.Anv = 0;; this.Anv = paramInt)
    {
      this.playRange = this.AmR.efA().clone();
      if ((this.Anv < 0) || (this.Anv >= this.Ant.size())) {
        break;
      }
      Object localObject = this.Ant.get(this.Anv);
      d.g.b.k.g(localObject, "playingList[editIndex]");
      localObject = (u)localObject;
      u localu = new u(((u)localObject).path, ((u)localObject).type);
      localu.bvf = 0L;
      localu.gOz = ((u)localObject).Aoz;
      localu.Aox = 0L;
      localu.Aoy = ((u)localObject).Aoz;
      localu.Aoz = ((u)localObject).Aoz;
      localu.AoD.viewRect.set(((u)localObject).AoD.viewRect);
      localu.AoD.pvE.set(((u)localObject).AoD.pvE);
      localu.AoD.eY.set(((u)localObject).AoD.eY);
      this.Anw = localu;
      localu = this.Anw;
      if (localu == null) {
        d.g.b.k.fOy();
      }
      a(localu);
      this.AmR.an(((u)localObject).Aox, ((u)localObject).Aoy);
      AppMethodBeat.o(207528);
      return;
    }
    this.AmR = new r(this.AmR);
    AppMethodBeat.o(207528);
  }
  
  public final Object a(long paramLong, d.d.d<? super d.y> paramd)
  {
    AppMethodBeat.i(207531);
    if ((paramd instanceof k.a))
    {
      localObject1 = (k.a)paramd;
      if ((((k.a)localObject1).label & 0x80000000) != 0) {
        ((k.a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (d.d.d<? super d.y>)localObject1;; paramd = new k.a(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = d.d.a.a.KUd;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(207531);
        throw paramd;
      }
    }
    this.Anu = -1;
    this.Ant.clear();
    this.Ant.addAll((Collection)this.Anf);
    Object localObject1 = r.Aoa;
    List localList = (List)this.Ant;
    paramd.nvt = this;
    paramd.Any = paramLong;
    paramd.nIC = this;
    paramd.label = 1;
    localObject1 = ((r.b)localObject1).a(localList, paramd);
    if (localObject1 == localObject2)
    {
      AppMethodBeat.o(207531);
      return localObject2;
      localObject2 = (k)paramd.nIC;
      paramLong = paramd.Any;
    }
    for (paramd = (k)paramd.nvt;; paramd = this)
    {
      ((k)localObject2).AmR = ((r)localObject1);
      if (paramLong > 0L)
      {
        ac.i(paramd.TAG, "createCompositionFromSource maxDurationMs:" + paramLong + ", composition.duration:" + paramd.AmR.getDurationMs());
        paramd.playRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.fromMs(Math.min(paramLong, paramd.AmR.getDurationMs())));
        localObject1 = paramd.AmR;
        localObject2 = paramd.playRange;
        d.g.b.k.g(localObject2, "playRange");
        paramLong = ((CMTimeRange)localObject2).getStartUs() / 1000L;
        paramd = paramd.playRange;
        d.g.b.k.g(paramd, "playRange");
        ((r)localObject1).an(paramLong, paramd.getEndUs() / 1000L);
      }
      paramd = d.y.KTp;
      AppMethodBeat.o(207531);
      return paramd;
      localObject2 = this;
    }
  }
  
  public final void ay(int paramInt, long paramLong)
  {
    AppMethodBeat.i(207530);
    this.Anu = paramInt;
    y localy = RP(paramInt);
    ac.i(this.TAG, "videoView render script: ".concat(String.valueOf(localy)));
    this.Ant.clear();
    this.Ant.addAll((Collection)c.a(localy, (List)this.Anf));
    this.AmR = new r((List)this.Ant, localy.AoX, 4);
    if (paramLong > 0L)
    {
      ac.i(this.TAG, "createCompositionFromScript maxDurationMs:".concat(String.valueOf(paramLong)));
      this.playRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.fromMs(Math.min(paramLong, this.AmR.getDurationMs())));
      localObject = this.AmR;
      CMTimeRange localCMTimeRange = this.playRange;
      d.g.b.k.g(localCMTimeRange, "playRange");
      paramLong = localCMTimeRange.getStartUs() / 1000L;
      localCMTimeRange = this.playRange;
      d.g.b.k.g(localCMTimeRange, "playRange");
      ((r)localObject).an(paramLong, localCMTimeRange.getEndUs() / 1000L);
    }
    Object localObject = ab.Apg;
    ab.a(localy);
    AppMethodBeat.o(207530);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(207533);
    v localv = this.Anp;
    localv.AoK = null;
    com.tencent.mm.kernel.g.agi().b(1469, (com.tencent.mm.ak.g)localv);
    com.tencent.mm.kernel.g.agi().b(2972, (com.tencent.mm.ak.g)localv);
    AppMethodBeat.o(207533);
  }
  
  public final void eft()
  {
    AppMethodBeat.i(207523);
    Iterator localIterator = ((Iterable)this.Anf).iterator();
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      d locald = localu.AoD;
      if (locald.eY.isIdentity())
      {
        float f = localu.AoB * 1.0F / localu.AoA;
        this.Ann.round(locald.pvE);
        if (f > this.Ann.height() / this.Ann.width())
        {
          f = (this.Ann.width() * 1.0F / localu.AoA * localu.AoB - this.Ann.height()) / 2.0F;
          locald.pvE.top = ((int)(this.Ann.top - f));
          locald.pvE.bottom = ((int)(f + this.Ann.bottom));
        }
        for (;;)
        {
          this.Ann.round(locald.gUl);
          j.a(locald.eY, new RectF(0.0F, 0.0F, localu.AoA, localu.AoB), new RectF(locald.pvE));
          locald.sOy = j.e(locald.eY);
          locald.aNk = (locald.sOy * 5.0F);
          locald.aNl = (locald.sOy * 0.25F);
          break;
          f = (this.Ann.height() * 1.0F / localu.AoB * localu.AoA - this.Ann.width()) / 2.0F;
          locald.pvE.left = ((int)(this.Ann.left - f));
          locald.pvE.right = ((int)(f + this.Ann.right));
        }
      }
    }
    AppMethodBeat.o(207523);
  }
  
  public final Size efu()
  {
    AppMethodBeat.i(207525);
    Size localSize = new Size(this.Ani, this.Anj);
    AppMethodBeat.o(207525);
    return localSize;
  }
  
  public final Size efv()
  {
    AppMethodBeat.i(207526);
    Size localSize = new Size(this.Ank, this.Anl);
    AppMethodBeat.o(207526);
    return localSize;
  }
  
  public final boolean efw()
  {
    return this.Anu >= 0;
  }
  
  public final void hX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207524);
    this.Ani = paramInt1;
    this.Anj = paramInt2;
    this.Anp.setPreviewSize(paramInt1, paramInt2);
    AppMethodBeat.o(207524);
  }
  
  public final void j(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207529);
    Object localObject1;
    long l1;
    Object localObject2;
    if (paramBoolean)
    {
      long l2 = this.AmR.efA().getStartUs() / 1000L;
      long l3 = this.AmR.efA().getEndUs() / 1000L;
      if ((this.Anv >= 0) && (this.Anv < this.Ant.size()))
      {
        if (this.Anw != null)
        {
          localObject1 = this.Ant.get(this.Anv);
          d.g.b.k.g(localObject1, "playingList[editIndex]");
          localObject1 = (u)localObject1;
          l1 = ((u)localObject1).getDurationMs();
          ((u)localObject1).Aox = l2;
          ((u)localObject1).Aoy = l3;
          l2 = l3 - l2;
          localObject2 = ((u)localObject1).AoE;
          ((MediaEditReportInfo.EditItem)localObject2).clickEditCount += 1;
          localObject2 = ((u)localObject1).AoE;
          ((MediaEditReportInfo.EditItem)localObject2).durationCutCount += paramInt1;
          localObject2 = ((u)localObject1).AoE;
          ((MediaEditReportInfo.EditItem)localObject2).durationScrollCount += paramInt2;
          ((u)localObject1).AoE.targetDuration = l2;
          ((u)localObject1).gOz = (((u)localObject1).bvf + l2);
          if (l1 != l2)
          {
            l1 = l2 - l1;
            paramInt1 = this.Anv;
            paramInt2 = this.Ant.size();
            paramInt1 += 1;
            while (paramInt1 < paramInt2)
            {
              localObject1 = (u)this.Ant.get(paramInt1);
              ((u)localObject1).bvf += l1;
              localObject1 = (u)this.Ant.get(paramInt1);
              ((u)localObject1).gOz += l1;
              paramInt1 += 1;
            }
            l2 = 0L;
            l1 = 0L;
            if (this.Ant.size() > 0)
            {
              localObject1 = this.playRange;
              d.g.b.k.g(localObject1, "playRange");
              l2 = ((CMTimeRange)localObject1).getStartUs() / 1000L;
              l1 = ((u)this.Ant.get(this.Ant.size() - 1)).gOz;
              localObject1 = this.playRange;
              d.g.b.k.g(localObject1, "playRange");
              l1 = Math.min(l1, ((CMTimeRange)localObject1).getEndUs() / 1000L);
            }
            localObject1 = this.playRange;
            d.g.b.k.g(localObject1, "playRange");
            ((CMTimeRange)localObject1).setStart(CMTime.fromMs(l2));
            localObject1 = this.playRange;
            d.g.b.k.g(localObject1, "playRange");
            ((CMTimeRange)localObject1).setDuration(CMTime.fromMs(l1 - l2));
          }
        }
        this.Anw = null;
        this.Anv = -1;
      }
    }
    else
    {
      if (this.Anu < 0) {
        break label628;
      }
      localObject1 = RP(this.Anu);
    }
    label628:
    for (this.AmR = new r((List)this.Ant, ((y)localObject1).AoX, 4);; this.AmR = new r((List)this.Ant, null, 6))
    {
      localObject1 = this.AmR;
      localObject2 = this.playRange;
      d.g.b.k.g(localObject2, "playRange");
      l1 = ((CMTimeRange)localObject2).getStartUs() / 1000L;
      localObject2 = this.playRange;
      d.g.b.k.g(localObject2, "playRange");
      ((r)localObject1).an(l1, ((CMTimeRange)localObject2).getEndUs() / 1000L);
      AppMethodBeat.o(207529);
      return;
      localObject1 = this.playRange;
      d.g.b.k.g(localObject1, "playRange");
      ((CMTimeRange)localObject1).setStart(this.AmR.efA().getStart());
      localObject1 = this.playRange;
      d.g.b.k.g(localObject1, "playRange");
      ((CMTimeRange)localObject1).setDuration(this.AmR.efA().getDuration());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.k
 * JD-Core Version:    0.7.0.1
 */