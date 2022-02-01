package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.b.a;
import com.tencent.mm.videocomposition.h;
import d.d.d;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.az;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "callback", "Lkotlin/Function0;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editIndex", "", "editTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "editTrackEnd", "", "editTrackPlayRate", "", "editTrackStart", "isAllImage", "", "()Z", "setAllImage", "(Z)V", "isAllVideo", "setAllVideo", "isLoading", "lastPlayRange", "Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "legendData", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "legendDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "maxDuration", "maxVisibleRect", "Landroid/graphics/RectF;", "normalCropRatio", "normalHeight", "normalWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playingList", "scriptIndex", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "vLogLoaded", "visibleRect", "vlogHeight", "vlogWidth", "createCompositionFromScript", "index", "maxDurationMs", "createCompositionFromSource", "createCompositionFromTemplate", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "createCompositionFromTrack", "track", "createCompositionFromTrackList", "trackList", "", "recordResult", "Lkotlin/Triple;", "ttsResult", "currentComposition", "currentEditTrack", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "dead", "endEditTrack", "confirm", "start", "end", "cutCnt", "scrollCnt", "clearEdit", "endMoveTrack", "getIndexScript", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getNormalCropRatio", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "getVLogSize", "getVisibleRect", "isVLog", "loadVLogScript", "sid", "fid", "moveTrack", "fromPosition", "toPosition", "scaleEdit", "playRate", "selectTrack", "setMaxDuration", "duration", "setMaxVisibleRect", "setNormalMaxSize", "width", "height", "setVLogSize", "setup", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupSourceTrackCrop", "setupSourceTrackCropByVideoTemplate", "updateEdit", "plugin-vlog_release"})
public final class o
  implements com.tencent.mm.vending.e.a
{
  public final RectF BFA;
  public final RectF BFB;
  public long BFC;
  d.g.a.a<z> BFD;
  public final x BFE;
  private final d.g.a.b<ava, z> BFF;
  boolean BFG;
  public final LinkedList<w> BFH;
  public int BFI;
  private int BFJ;
  public w BFK;
  private long BFL;
  private long BFM;
  private float BFN;
  private final q BFO;
  public v BFd;
  public final LinkedList<String> BFq;
  final LinkedList<s> BFr;
  public final LinkedList<w> BFs;
  public boolean BFt;
  public boolean BFu;
  public int BFv;
  public int BFw;
  public int BFx;
  public int BFy;
  public float BFz;
  public final String TAG;
  boolean isLoading;
  final LinkedList<Integer> rET;
  
  public o()
  {
    AppMethodBeat.i(195736);
    this.TAG = "MicroMsg.MultiMediaModel";
    this.BFq = new LinkedList();
    this.rET = new LinkedList();
    this.BFr = new LinkedList();
    this.BFs = new LinkedList();
    com.tencent.mm.plugin.vlog.util.a locala = com.tencent.mm.plugin.vlog.util.a.BVa;
    this.BFz = com.tencent.mm.plugin.vlog.util.a.euh();
    this.BFA = new RectF();
    this.BFB = new RectF();
    this.BFE = new x();
    this.BFF = ((d.g.a.b)new a(this));
    this.BFd = new v((List)d.a.v.MKE);
    this.BFH = new LinkedList();
    this.BFI = -1;
    this.BFJ = -1;
    this.BFN = 1.0F;
    this.BFO = new q();
    AppMethodBeat.o(195736);
  }
  
  public final void Tz(int paramInt)
  {
    AppMethodBeat.i(195730);
    ad.i(this.TAG, "editTrack index:".concat(String.valueOf(paramInt)));
    this.BFJ = paramInt;
    this.BFO.start = this.BFd.BGk.getPlayStart();
    this.BFO.bpc = this.BFd.BGk.esa();
    if ((this.BFJ >= 0) && (this.BFJ < this.BFH.size()))
    {
      Object localObject1 = this.BFH.get(this.BFJ);
      p.g(localObject1, "playingList[editIndex]");
      localObject1 = (w)localObject1;
      this.BFK = ((w)localObject1);
      this.BFL = ((w)localObject1).BGw.HCU;
      this.BFM = ((w)localObject1).BGw.HCV;
      this.BFN = ((w)localObject1).BGw.llC;
      Object localObject2 = new w(((w)localObject1).path, ((w)localObject1).type);
      ((w)localObject2).Bl(((w)localObject1).BGw.BMD);
      ((w)localObject2).Bj(((float)((w)localObject1).BGw.BMD / ((w)localObject1).BGw.llC));
      ((w)localObject2).setPlayRate(((w)localObject1).BGw.llC);
      ((w)localObject2).BGr = ((w)localObject1).BGr;
      ((w)localObject2).BGs = ((w)localObject1).BGs;
      ((w)localObject2).BGu.hmm.set(((w)localObject1).BGu.hmm);
      ((w)localObject2).BGu.pZj.set(((w)localObject1).BGu.pZj);
      ((w)localObject2).BGu.viewRect.set(((w)localObject1).BGu.viewRect);
      ((w)localObject2).BGu.gR.set(((w)localObject1).BGu.gR);
      ((w)localObject2).BGw.hmm.set(((w)localObject1).BGw.hmm);
      ((w)localObject2).BGw.fyp();
      p.h(localObject2, "track");
      this.BFd = new v(d.a.j.listOf(localObject2));
      this.BFd.io(this.BFx, this.BFy);
      localObject1 = this.BFd;
      localObject2 = com.tencent.mm.plugin.vlog.model.local.a.BHu;
      ((v)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.esu());
      this.BFd.ar(((float)this.BFL / this.BFN), ((float)this.BFM / this.BFN));
    }
    AppMethodBeat.o(195730);
  }
  
  public final void a(w paramw)
  {
    this.BFK = paramw;
  }
  
  public final void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(195733);
    ad.i(this.TAG, "endEditTrack editIndex:" + this.BFJ + ", confirm:" + paramBoolean1 + ", start:" + paramLong1 + ", end:" + paramLong2);
    if ((this.BFJ >= 0) && (this.BFJ < this.BFH.size()))
    {
      localObject1 = this.BFH.get(this.BFJ);
      p.g(localObject1, "playingList[editIndex]");
      localObject1 = (w)localObject1;
      localObject2 = ((w)localObject1).BGv;
      ((MediaEditReportInfo.EditItem)localObject2).clickEditCount += 1;
      localObject2 = ((w)localObject1).BGv;
      ((MediaEditReportInfo.EditItem)localObject2).durationCutCount += paramInt1;
      localObject2 = ((w)localObject1).BGv;
      ((MediaEditReportInfo.EditItem)localObject2).durationScrollCount += paramInt2;
      if ((paramBoolean1) && (paramLong1 >= 0L) && (paramLong2 >= 0L))
      {
        ((w)localObject1).Bk(((float)paramLong1 * ((w)localObject1).BGw.llC));
        ((w)localObject1).Bl(((float)paramLong2 * ((w)localObject1).BGw.llC));
      }
      for (;;)
      {
        paramLong1 = ((float)(((w)localObject1).BGw.HCV - ((w)localObject1).BGw.HCU) / ((w)localObject1).BGw.llC);
        ((w)localObject1).BGv.targetDuration = paramLong1;
        if (paramBoolean2)
        {
          this.BFK = null;
          this.BFJ = -1;
        }
        localObject1 = com.tencent.mm.videocomposition.b.LmE;
        localObject2 = (Iterable)this.BFH;
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((w)((Iterator)localObject2).next()).BGw);
        }
        ((w)localObject1).Bk(this.BFL);
        ((w)localObject1).Bl(this.BFM);
      }
      b.a.iM((List)localObject1);
    }
    this.BFd = new v((List)this.BFH);
    this.BFd.Bh(this.BFC);
    Object localObject1 = this.BFd;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.BHu;
    ((v)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.esu());
    this.BFd.io(this.BFx, this.BFy);
    AppMethodBeat.o(195733);
  }
  
  public final void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(195732);
    this.BFd.ar(paramLong1, paramLong2);
    AppMethodBeat.o(195732);
  }
  
  public final void bK(float paramFloat)
  {
    AppMethodBeat.i(195731);
    w localw = this.BFK;
    if (localw != null)
    {
      localw.setPlayRate(paramFloat);
      localw.BGw.fyp();
    }
    localw = (w)d.a.j.jd((List)this.BFd.BGl);
    if (localw != null)
    {
      localw.setPlayRate(paramFloat);
      localw.BGw.fyp();
      this.BFd.ar(localw.BGw.startTimeMs, localw.BGw.hiy);
      AppMethodBeat.o(195731);
      return;
    }
    AppMethodBeat.o(195731);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(195735);
    x localx = this.BFE;
    localx.BGB = null;
    com.tencent.mm.kernel.g.aiU().b(1469, (com.tencent.mm.al.f)localx);
    com.tencent.mm.kernel.g.aiU().b(2972, (com.tencent.mm.al.f)localx);
    AppMethodBeat.o(195735);
  }
  
  public final List<bxd> dsR()
  {
    AppMethodBeat.i(195729);
    List localList = this.BFE.dsR();
    AppMethodBeat.o(195729);
    return localList;
  }
  
  public final boolean erQ()
  {
    return this.BFt;
  }
  
  public final void erR()
  {
    AppMethodBeat.i(195727);
    Iterator localIterator = ((Iterable)this.BFs).iterator();
    if (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      g localg = localw.BGu;
      float f;
      if (localg.gR.isIdentity())
      {
        f = localw.BGs * 1.0F / localw.BGr;
        this.BFA.round(localg.pZj);
        if (f <= this.BFA.height() / this.BFA.width()) {
          break label305;
        }
        f = (this.BFA.width() * 1.0F / localw.BGr * localw.BGs - this.BFA.height()) / 2.0F;
        localg.pZj.top = ((int)(this.BFA.top - f));
        localg.pZj.bottom = ((int)(f + this.BFA.bottom));
      }
      for (;;)
      {
        this.BFA.round(localg.hmm);
        m.a(localg.gR, new RectF(0.0F, 0.0F, localw.BGr, localw.BGs), new RectF(localg.pZj));
        localg.pZj.offset(0, -(int)this.BFB.top);
        localw.BGw.hmm.set(localg.pZj);
        localg.tLe = m.e(localg.gR);
        localg.aXE = (localg.tLe * 5.0F);
        localg.aXF = (localg.tLe * 0.25F);
        localw.BGw.LmA = true;
        break;
        label305:
        f = (this.BFA.height() * 1.0F / localw.BGs * localw.BGr - this.BFA.width()) / 2.0F;
        localg.pZj.left = ((int)(this.BFA.left - f));
        localg.pZj.right = ((int)(f + this.BFA.right));
      }
    }
    AppMethodBeat.o(195727);
  }
  
  public final Size erS()
  {
    AppMethodBeat.i(195728);
    Size localSize = new Size(this.BFx, this.BFy);
    AppMethodBeat.o(195728);
    return localSize;
  }
  
  public final v erT()
  {
    return this.BFd;
  }
  
  public final boolean erU()
  {
    return this.BFI >= 0;
  }
  
  public final w erV()
  {
    return this.BFK;
  }
  
  public final void in(int paramInt1, int paramInt2)
  {
    this.BFx = paramInt1;
    this.BFy = paramInt2;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.b<ava, z>
  {
    a(o paramo)
    {
      super();
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.MultiMediaModel$setup$2", f="MultiMediaModel.kt", gfL={79}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class b
    extends d.d.b.a.j
    implements d.g.a.m<ah, d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    Object olg;
    
    public b(o paramo, List paramList1, List paramList2, List paramList3, d paramd)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(195725);
      p.h(paramd, "completion");
      paramd = new b(this.BFP, this.BFQ, this.BFR, this.BFS, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(195725);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(195724);
      d.d.a.a locala = d.d.a.a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(195724);
        throw paramObject;
      case 0: 
        paramObject = this.nWQ;
        this.BFP.BFq.clear();
        this.BFP.rET.clear();
        this.BFP.BFr.clear();
        this.BFP.BFs.clear();
        this.BFP.BFq.addAll((Collection)this.BFQ);
        this.BFP.rET.addAll((Collection)this.BFR);
        localObject1 = this.BFP.BFr;
        Object localObject2 = s.BGc;
        Object localObject3 = this.BFQ;
        localObject2 = this.BFR;
        List localList = this.BFS;
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
            d.a.j.gfB();
          }
          localObject4 = (String)localObject4;
          Object localObject5 = (Integer)d.a.j.E((List)localObject2, i);
          if (localObject5 == null) {}
          while (((Integer)localObject5).intValue() != 2)
          {
            localObject5 = s.BGc;
            p.h(localObject4, "path");
            localObject5 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject5).inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile((String)localObject4, (BitmapFactory.Options)localObject5);
            int n = s.a.aDm((String)localObject4);
            int m = ((BitmapFactory.Options)localObject5).outWidth;
            int k = ((BitmapFactory.Options)localObject5).outHeight;
            if ((n == 90) || (n == 270))
            {
              m = ((BitmapFactory.Options)localObject5).outHeight;
              k = ((BitmapFactory.Options)localObject5).outWidth;
            }
            localObject4 = new k(m, k, (String)localObject4);
            ((s)localObject4).BGb = ((Number)localList.get(i)).intValue();
            localLinkedList.add(localObject4);
            i = j;
            break;
          }
          localObject5 = s.BGc;
          localObject4 = s.a.aDn((String)localObject4);
          if (localObject4 != null)
          {
            ((s)localObject4).BGb = ((Number)localList.get(i)).intValue();
            localLinkedList.add(localObject4);
            i = j;
          }
          else
          {
            i = j;
          }
        }
        ((LinkedList)localObject1).addAll((Collection)localLinkedList);
        localObject1 = this.BFP;
        localObject2 = (Iterable)this.BFP.BFr;
        boolean bool;
        label646:
        float f2;
        float f1;
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (!((s)((Iterator)localObject2).next() instanceof k))
            {
              bool = false;
              ((o)localObject1).BFt = bool;
              localObject1 = this.BFP;
              localObject2 = (Iterable)this.BFP.BFr;
              if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                break label812;
              }
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                if (!((s)((Iterator)localObject2).next() instanceof ac))
                {
                  bool = false;
                  ((o)localObject1).BFu = bool;
                  localObject1 = this.BFP;
                  localObject2 = com.tencent.mm.plugin.vlog.util.a.BVa;
                  i = ((s)this.BFP.BFr.get(0)).width;
                  f2 = ((s)this.BFP.BFr.get(0)).height * 1.0F / i;
                  if (f2 <= com.tencent.mm.plugin.vlog.util.a.euh()) {
                    break label818;
                  }
                  f1 = com.tencent.mm.plugin.vlog.util.a.euh();
                }
              }
            }
          }
        }
        for (;;)
        {
          ((o)localObject1).BFz = f1;
          localObject1 = this.BFP.BFs;
          localObject2 = s.BGc;
          localObject2 = (List)this.BFP.BFr;
          this.nWR = paramObject;
          this.olg = localObject1;
          this.label = 1;
          paramObject = kotlinx.coroutines.g.a((d.d.f)az.gvp(), (d.g.a.m)new s.a.a((List)localObject2, null), this);
          if (paramObject != locala) {
            break label937;
          }
          AppMethodBeat.o(195724);
          return locala;
          bool = true;
          break;
          label812:
          bool = true;
          break label646;
          label818:
          f1 = f2;
          if (f2 < 0.5625F) {
            f1 = 0.5625F;
          }
        }
      }
      Object localObject1 = (LinkedList)this.olg;
      label937:
      for (;;)
      {
        ((LinkedList)localObject1).addAll((Collection)paramObject);
        paramObject = (w)d.a.j.E((List)this.BFP.BFs, 0);
        if (paramObject != null)
        {
          localObject1 = com.tencent.mm.videocomposition.a.Lmq;
          paramObject = a.a.a(paramObject.BGw);
          paramObject.setSize(63, 112);
          paramObject.b(d.a.j.listOf(d.d.b.a.b.Fu(0L)), (d.g.a.m)new a(this));
          paramObject = z.MKo;
          AppMethodBeat.o(195724);
          return paramObject;
        }
        AppMethodBeat.o(195724);
        return null;
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(195726);
      paramObject1 = ((b)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(195726);
      return paramObject1;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/model/MultiMediaModel$setup$2$3$1"})
    static final class a
      extends d.g.b.q
      implements d.g.a.m<Long, Bitmap, z>
    {
      a(o.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.o
 * JD-Core Version:    0.7.0.1
 */