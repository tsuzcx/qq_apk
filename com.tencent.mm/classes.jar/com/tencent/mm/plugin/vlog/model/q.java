package com.tencent.mm.plugin.vlog.model;

import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.protocal.protobuf.aoa;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import d.d.d<-Ld.y;>;
import d.g.a.b;
import d.g.b.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.at;
import kotlinx.coroutines.e;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "callback", "Lkotlin/Function0;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editIndex", "", "editTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "isAllImage", "", "()Z", "setAllImage", "(Z)V", "isAllVideo", "setAllVideo", "isLoading", "legendData", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "legendDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "normalCropRatio", "", "normalHeight", "normalWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "kotlin.jvm.PlatformType", "playingList", "scriptIndex", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "vLogLoaded", "visibleRect", "Landroid/graphics/RectF;", "vlogHeight", "vlogWidth", "asyncCreateCompositionFromSource", "maxDurationMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCompositionFromScript", "index", "createCompositionFromSource", "createCompositionFromTrack", "track", "currentComposition", "currentEditTrack", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "dead", "doCreateCompositionFromSource", "endEditTrack", "confirm", "cutCnt", "scrollCnt", "endMoveTrack", "getIndexScript", "getMusicList", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getNormalCropRatio", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "getVLogSize", "getVisibleRect", "isVLog", "loadVLogScript", "sid", "fid", "moveTrack", "fromPosition", "toPosition", "setMaxVisibleRect", "maxVisibleRect", "setNormalMaxSize", "width", "height", "setVLogSize", "setup", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupSourceTrackCrop", "plugin-vlog_release"})
public final class q
  implements com.tencent.mm.vending.e.a
{
  public int BBm;
  public int CeA;
  public v Lqf;
  public final LinkedList<String> Lqg;
  final LinkedList<s> Lqh;
  public final LinkedList<y> Lqi;
  public boolean Lqj;
  public boolean Lqk;
  private int Lql;
  private int Lqm;
  public float Lqn;
  public final RectF Lqo;
  public d.g.a.a<d.y> Lqp;
  public final z Lqq;
  public final b<aoa, d.y> Lqr;
  public boolean Lqs;
  public final LinkedList<y> Lqt;
  private int Lqu;
  private int Lqv;
  private y Lqw;
  private final String TAG;
  public boolean isLoading;
  private CMTimeRange playRange;
  final LinkedList<Integer> qmd;
  
  public q()
  {
    AppMethodBeat.i(200848);
    this.TAG = "MicroMsg.MultiMediaModel";
    this.Lqg = new LinkedList();
    this.qmd = new LinkedList();
    this.Lqh = new LinkedList();
    this.Lqi = new LinkedList();
    this.Lqn = 1.166667F;
    this.Lqo = new RectF();
    this.Lqq = new z();
    this.Lqr = ((b)new b(this));
    this.Lqf = new v((List)d.a.v.Jgl, null, 6);
    this.Lqt = new LinkedList();
    this.Lqu = -1;
    this.playRange = CMTimeRange.fromMs(0L, 0L);
    this.Lqv = -1;
    AppMethodBeat.o(200848);
  }
  
  private void a(y paramy)
  {
    AppMethodBeat.i(200846);
    k.h(paramy, "track");
    this.Lqf = new v(d.a.j.listOf(paramy), null, 6);
    AppMethodBeat.o(200846);
  }
  
  public final void aI(int paramInt, long paramLong)
  {
    AppMethodBeat.i(200844);
    this.Lqu = paramInt;
    h localh = aif(paramInt);
    com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "videoView render script: ".concat(String.valueOf(localh)));
    this.Lqt.clear();
    this.Lqt.addAll((Collection)m.a(localh, (List)this.Lqi));
    this.Lqf = new v((List)this.Lqt, localh.yZu, 4);
    if (paramLong > 0L)
    {
      com.tencent.mm.sdk.platformtools.ad.i(this.TAG, "createCompositionFromScript maxDurationMs:".concat(String.valueOf(paramLong)));
      this.playRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.fromMs(Math.min(paramLong, this.Lqf.cuR())));
      localObject = this.Lqf;
      CMTimeRange localCMTimeRange = this.playRange;
      k.g(localCMTimeRange, "playRange");
      paramLong = localCMTimeRange.getStartUs() / 1000L;
      localCMTimeRange = this.playRange;
      k.g(localCMTimeRange, "playRange");
      ((v)localObject).aD(paramLong, localCMTimeRange.getEndUs() / 1000L);
    }
    Object localObject = j.yZD;
    j.a(localh);
    AppMethodBeat.o(200844);
  }
  
  public final h aif(int paramInt)
  {
    AppMethodBeat.i(200841);
    h localh = this.Lqq.aif(paramInt);
    AppMethodBeat.o(200841);
    return localh;
  }
  
  public final void aig(int paramInt)
  {
    AppMethodBeat.i(200842);
    this.Lqv = paramInt;
    this.playRange = this.Lqf.fYI();
    if ((this.Lqv >= 0) && (this.Lqv < this.Lqt.size()))
    {
      Object localObject = this.Lqt.get(paramInt);
      k.g(localObject, "playingList[index]");
      localObject = (y)localObject;
      y localy = new y(((y)localObject).path, ((y)localObject).type);
      localy.bxw = 0L;
      localy.gnO = ((y)localObject).Lrq;
      localy.Lro = 0L;
      localy.Lrp = ((y)localObject).Lrq;
      localy.Lrq = ((y)localObject).Lrq;
      localy.Lru.viewRect.set(((y)localObject).Lru.viewRect);
      localy.Lru.oSt.set(((y)localObject).Lru.oSt);
      localy.Lru.dY.set(((y)localObject).Lru.dY);
      this.Lqw = localy;
      localy = this.Lqw;
      if (localy == null) {
        k.fvU();
      }
      a(localy);
      this.Lqf.aD(((y)localObject).Lro, ((y)localObject).Lrp);
    }
    AppMethodBeat.o(200842);
  }
  
  public final Object b(long paramLong, d.d.d<? super d.y> paramd)
  {
    AppMethodBeat.i(200845);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (d.d.d<? super d.y>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = d.d.a.a.JgJ;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(200845);
        throw paramd;
      }
    }
    this.Lqu = -1;
    this.Lqt.clear();
    this.Lqt.addAll((Collection)this.Lqi);
    Object localObject1 = v.LqS;
    List localList = (List)this.Lqt;
    paramd.mTb = this;
    paramd.Lqy = paramLong;
    paramd.nfO = this;
    paramd.label = 1;
    localObject1 = ((v.b)localObject1).a(localList, paramd);
    if (localObject1 == localObject2)
    {
      AppMethodBeat.o(200845);
      return localObject2;
      localObject2 = (q)paramd.nfO;
      paramLong = paramd.Lqy;
    }
    for (paramd = (q)paramd.mTb;; paramd = this)
    {
      ((q)localObject2).Lqf = ((v)localObject1);
      if (paramLong > 0L)
      {
        com.tencent.mm.sdk.platformtools.ad.i(paramd.TAG, "createCompositionFromSource maxDurationMs:" + paramLong + ", composition.duration:" + paramd.Lqf.cuR());
        paramd.playRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.fromMs(Math.min(paramLong, paramd.Lqf.cuR())));
        localObject1 = paramd.Lqf;
        localObject2 = paramd.playRange;
        k.g(localObject2, "playRange");
        paramLong = ((CMTimeRange)localObject2).getStartUs() / 1000L;
        paramd = paramd.playRange;
        k.g(paramd, "playRange");
        ((v)localObject1).aD(paramLong, paramd.getEndUs() / 1000L);
      }
      paramd = d.y.JfV;
      AppMethodBeat.o(200845);
      return paramd;
      localObject2 = this;
    }
  }
  
  public final List<boa> cUZ()
  {
    AppMethodBeat.i(200840);
    List localList = this.Lqq.cUZ();
    AppMethodBeat.o(200840);
    return localList;
  }
  
  public final void dead()
  {
    AppMethodBeat.i(200847);
    z localz = this.Lqq;
    localz.LrA = null;
    com.tencent.mm.kernel.g.aeS().b(1469, (com.tencent.mm.al.g)localz);
    com.tencent.mm.kernel.g.aeS().b(2972, (com.tencent.mm.al.g)localz);
    AppMethodBeat.o(200847);
  }
  
  public final void fYB()
  {
    AppMethodBeat.i(200836);
    Iterator localIterator = ((Iterable)this.Lqi).iterator();
    while (localIterator.hasNext())
    {
      y localy = (y)localIterator.next();
      n localn = localy.Lru;
      if (localn.dY.isIdentity())
      {
        float f = localy.Lrs * 1.0F / localy.Lrr;
        this.Lqo.round(localn.oSt);
        if (f > this.Lqo.height() / this.Lqo.width())
        {
          f = (this.Lqo.width() * 1.0F / localy.Lrr * localy.Lrs - this.Lqo.height()) / 2.0F;
          localn.oSt.top = ((int)(this.Lqo.top - f));
          localn.oSt.bottom = ((int)(f + this.Lqo.bottom));
        }
        for (;;)
        {
          this.Lqo.round(localn.gtE);
          p.a(localn.dY, new RectF(0.0F, 0.0F, localy.Lrr, localy.Lrs), new RectF(localn.oSt));
          localn.rGL = p.f(localn.dY);
          localn.aMu = (localn.rGL * 5.0F);
          localn.aMv = (localn.rGL * 0.25F);
          break;
          f = (this.Lqo.height() * 1.0F / localy.Lrs * localy.Lrr - this.Lqo.width()) / 2.0F;
          localn.oSt.left = ((int)(this.Lqo.left - f));
          localn.oSt.right = ((int)(f + this.Lqo.right));
        }
      }
    }
    AppMethodBeat.o(200836);
  }
  
  public final Size fYC()
  {
    AppMethodBeat.i(200838);
    Size localSize = new Size(this.Lql, this.Lqm);
    AppMethodBeat.o(200838);
    return localSize;
  }
  
  public final Size fYD()
  {
    AppMethodBeat.i(200839);
    Size localSize = new Size(this.BBm, this.CeA);
    AppMethodBeat.o(200839);
    return localSize;
  }
  
  public final boolean fYE()
  {
    return this.Lqu >= 0;
  }
  
  public final void k(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200843);
    Object localObject1;
    long l1;
    Object localObject2;
    if (paramBoolean)
    {
      long l2 = this.Lqf.fYI().getStartUs() / 1000L;
      long l3 = this.Lqf.fYI().getEndUs() / 1000L;
      if ((this.Lqv >= 0) && (this.Lqv < this.Lqt.size()))
      {
        if (this.Lqw != null)
        {
          localObject1 = this.Lqt.get(this.Lqv);
          k.g(localObject1, "playingList[editIndex]");
          localObject1 = (y)localObject1;
          l1 = ((y)localObject1).cuR();
          ((y)localObject1).Lro = l2;
          ((y)localObject1).Lrp = l3;
          l2 = l3 - l2;
          localObject2 = ((y)localObject1).Lrv;
          ((MediaEditReportInfo.EditItem)localObject2).clickEditCount += 1;
          localObject2 = ((y)localObject1).Lrv;
          ((MediaEditReportInfo.EditItem)localObject2).durationCutCount += paramInt1;
          localObject2 = ((y)localObject1).Lrv;
          ((MediaEditReportInfo.EditItem)localObject2).durationScrollCount += paramInt2;
          ((y)localObject1).Lrv.targetDuration = l2;
          ((y)localObject1).gnO = (((y)localObject1).bxw + l2);
          if (l1 != l2)
          {
            l1 = l2 - l1;
            paramInt1 = this.Lqv;
            paramInt2 = this.Lqt.size();
            paramInt1 += 1;
            while (paramInt1 < paramInt2)
            {
              localObject1 = (y)this.Lqt.get(paramInt1);
              ((y)localObject1).bxw += l1;
              localObject1 = (y)this.Lqt.get(paramInt1);
              ((y)localObject1).gnO += l1;
              paramInt1 += 1;
            }
            l2 = 0L;
            l1 = 0L;
            if (this.Lqt.size() > 0)
            {
              l2 = ((y)this.Lqt.get(0)).bxw;
              l1 = ((y)this.Lqt.get(this.Lqt.size() - 1)).gnO;
              localObject1 = this.playRange;
              k.g(localObject1, "playRange");
              l1 = Math.min(l1, ((CMTimeRange)localObject1).getEndUs() / 1000L);
            }
            localObject1 = this.playRange;
            k.g(localObject1, "playRange");
            ((CMTimeRange)localObject1).setStart(CMTime.fromMs(l2));
            localObject1 = this.playRange;
            k.g(localObject1, "playRange");
            ((CMTimeRange)localObject1).setDuration(CMTime.fromMs(l1 - l2));
          }
        }
        this.Lqw = null;
        this.Lqv = -1;
      }
    }
    else
    {
      if (this.Lqu < 0) {
        break label619;
      }
      localObject1 = aif(this.Lqu);
    }
    label619:
    for (this.Lqf = new v((List)this.Lqt, ((h)localObject1).yZu, 4);; this.Lqf = new v((List)this.Lqt, null, 6))
    {
      localObject1 = this.Lqf;
      localObject2 = this.playRange;
      k.g(localObject2, "playRange");
      l1 = ((CMTimeRange)localObject2).getStartUs() / 1000L;
      localObject2 = this.playRange;
      k.g(localObject2, "playRange");
      ((v)localObject1).aD(l1, ((CMTimeRange)localObject2).getEndUs() / 1000L);
      AppMethodBeat.o(200843);
      return;
      localObject1 = this.playRange;
      k.g(localObject1, "playRange");
      ((CMTimeRange)localObject1).setStart(this.Lqf.fYI().getStart());
      localObject1 = this.playRange;
      k.g(localObject1, "playRange");
      ((CMTimeRange)localObject1).setDuration(this.Lqf.fYI().getDuration());
      break;
    }
  }
  
  public final void lf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200837);
    this.Lql = paramInt1;
    this.Lqm = paramInt2;
    this.Lqq.setPreviewSize(paramInt1, paramInt2);
    AppMethodBeat.o(200837);
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.MultiMediaModel", f="MultiMediaModel.kt", l={270}, m="asyncCreateCompositionFromSource")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"asyncCreateCompositionFromSource", "", "maxDurationMs", "", "continuation", "Lkotlin/coroutines/Continuation;", ""})
  static final class a
    extends d.d.b.a.d
  {
    long Lqy;
    int label;
    Object mTb;
    Object nfO;
    
    a(q paramq, d.d.d paramd)
    {
      super();
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(200831);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.Lqx.b(0L, this);
      AppMethodBeat.o(200831);
      return paramObject;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<aoa, d.y>
  {
    b(q paramq)
    {
      super();
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.MultiMediaModel$setup$2", f="MultiMediaModel.kt", l={69}, m="invokeSuspend")
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class c
    extends d.d.b.a.j
    implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super Boolean>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    Object nfO;
    
    public c(q paramq, List paramList1, List paramList2, List paramList3, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(200834);
      k.h(paramd, "completion");
      paramd = new c(this.Lqx, this.Lqz, this.LqA, this.LqB, paramd);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(200834);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(200833);
      d.d.a.a locala = d.d.a.a.JgJ;
      boolean bool;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(200833);
        throw paramObject;
      case 0: 
        paramObject = this.mTa;
        this.Lqx.Lqg.clear();
        this.Lqx.qmd.clear();
        this.Lqx.Lqh.clear();
        this.Lqx.Lqi.clear();
        this.Lqx.Lqg.addAll((Collection)this.Lqz);
        this.Lqx.qmd.addAll((Collection)this.LqA);
        localObject1 = this.Lqx.Lqh;
        Object localObject2 = s.LqE;
        Object localObject3 = this.Lqz;
        localObject2 = this.LqA;
        List localList = this.LqB;
        k.h(localObject3, "paths");
        k.h(localObject2, "types");
        k.h(localList, "sourceFrom");
        LinkedList localLinkedList = new LinkedList();
        localObject3 = ((Iterable)localObject3).iterator();
        int i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = ((Iterator)localObject3).next();
          int j = i + 1;
          if (i < 0) {
            d.a.j.fvx();
          }
          localObject4 = (String)localObject4;
          Object localObject5 = (Integer)d.a.j.C((List)localObject2, i);
          if (localObject5 == null) {}
          while (((Integer)localObject5).intValue() != 2)
          {
            localObject5 = s.LqE;
            k.h(localObject4, "path");
            localObject5 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject5).inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile((String)localObject4, (BitmapFactory.Options)localObject5);
            int n = s.a.aVS((String)localObject4);
            int m = ((BitmapFactory.Options)localObject5).outWidth;
            int k = ((BitmapFactory.Options)localObject5).outHeight;
            if ((n == 90) || (n == 270))
            {
              m = ((BitmapFactory.Options)localObject5).outHeight;
              k = ((BitmapFactory.Options)localObject5).outWidth;
            }
            localObject4 = new o(m, k, (String)localObject4);
            ((s)localObject4).LqD = ((Number)localList.get(i)).intValue();
            localLinkedList.add(localObject4);
            i = j;
            break;
          }
          localObject5 = s.LqE;
          localObject4 = s.a.aVT((String)localObject4);
          if (localObject4 != null)
          {
            ((s)localObject4).LqD = ((Number)localList.get(i)).intValue();
            localLinkedList.add(localObject4);
            i = j;
          }
          else
          {
            i = j;
          }
        }
        ((LinkedList)localObject1).addAll((Collection)localLinkedList);
        localObject1 = this.Lqx;
        localObject2 = (Iterable)this.Lqx.Lqh;
        if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            if (!((s)((Iterator)localObject2).next() instanceof o))
            {
              bool = false;
              ((q)localObject1).Lqj = bool;
              localObject1 = this.Lqx;
              localObject2 = (Iterable)this.Lqx.Lqh;
              if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                break label779;
              }
              localObject2 = ((Iterable)localObject2).iterator();
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
              } while (((s)((Iterator)localObject2).next() instanceof ab));
            }
          }
        }
        label779:
        for (bool = false;; bool = true)
        {
          ((q)localObject1).Lqk = bool;
          localObject1 = this.Lqx;
          localObject2 = com.tencent.mm.plugin.vlog.a.a.LvS;
          ((q)localObject1).Lqn = com.tencent.mm.plugin.vlog.a.a.lj(((s)this.Lqx.Lqh.get(0)).width, ((s)this.Lqx.Lqh.get(0)).height);
          localObject1 = this.Lqx.Lqi;
          localObject2 = s.LqE;
          localObject2 = (List)this.Lqx.Lqh;
          this.mTb = paramObject;
          this.nfO = localObject1;
          this.label = 1;
          paramObject = e.a((d.d.f)at.fLg(), (d.g.a.m)new s.a.a((List)localObject2, null), this);
          if (paramObject != locala) {
            break label816;
          }
          AppMethodBeat.o(200833);
          return locala;
          bool = true;
          break;
        }
      }
      Object localObject1 = (LinkedList)this.nfO;
      label816:
      for (;;)
      {
        bool = ((LinkedList)localObject1).addAll((Collection)paramObject);
        AppMethodBeat.o(200833);
        return Boolean.valueOf(bool);
      }
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(200835);
      paramObject1 = ((c)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
      AppMethodBeat.o(200835);
      return paramObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.q
 * JD-Core Version:    0.7.0.1
 */