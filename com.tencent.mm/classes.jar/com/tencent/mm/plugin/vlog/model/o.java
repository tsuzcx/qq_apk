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
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "()V", "TAG", "", "callback", "Lkotlin/Function0;", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "editIndex", "", "editTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "editTrackEnd", "", "editTrackPlayRate", "", "editTrackStart", "isAllImage", "", "()Z", "setAllImage", "(Z)V", "isAllVideo", "setAllVideo", "isLoading", "lastPlayRange", "Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "legendData", "Lcom/tencent/mm/plugin/vlog/model/VLogDataManager;", "legendDataCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "Lkotlin/ParameterName;", "name", "result", "maxDuration", "maxVisibleRect", "Landroid/graphics/RectF;", "normalCropRatio", "normalHeight", "normalWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playingList", "scriptIndex", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "vLogLoaded", "visibleRect", "vlogHeight", "vlogWidth", "createCompositionFromScript", "index", "maxDurationMs", "createCompositionFromSource", "createCompositionFromTemplate", "template", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "createCompositionFromTrack", "track", "createCompositionFromTrackList", "trackList", "", "recordResult", "Lkotlin/Triple;", "ttsResult", "currentComposition", "currentEditTrack", "currentScript", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "dead", "endEditTrack", "confirm", "start", "end", "cutCnt", "scrollCnt", "clearEdit", "endMoveTrack", "getIndexScript", "getMusicList", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicInfo;", "getNormalCropRatio", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "getVLogSize", "getVisibleRect", "isVLog", "loadVLogScript", "sid", "fid", "moveTrack", "fromPosition", "toPosition", "scaleEdit", "playRate", "selectTrack", "setMaxDuration", "duration", "setMaxVisibleRect", "setNormalMaxSize", "width", "height", "setVLogSize", "setup", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupSourceTrackCrop", "setupSourceTrackCropByVideoTemplate", "updateEdit", "plugin-vlog_release"})
public final class o
  implements com.tencent.mm.vending.e.a
{
  public v BWB;
  public final LinkedList<String> BWO;
  final LinkedList<s> BWP;
  public final LinkedList<w> BWQ;
  public boolean BWR;
  public boolean BWS;
  public int BWT;
  public int BWU;
  public int BWV;
  public int BWW;
  public float BWX;
  public final RectF BWY;
  public final RectF BWZ;
  public long BXa;
  d.g.a.a<z> BXb;
  public final x BXc;
  private final d.g.a.b<avq, z> BXd;
  boolean BXe;
  public final LinkedList<w> BXf;
  public int BXg;
  private int BXh;
  public w BXi;
  private long BXj;
  private long BXk;
  private float BXl;
  private final q BXm;
  public final String TAG;
  boolean isLoading;
  final LinkedList<Integer> rNe;
  
  public o()
  {
    AppMethodBeat.i(191193);
    this.TAG = "MicroMsg.MultiMediaModel";
    this.BWO = new LinkedList();
    this.rNe = new LinkedList();
    this.BWP = new LinkedList();
    this.BWQ = new LinkedList();
    com.tencent.mm.plugin.vlog.util.a locala = com.tencent.mm.plugin.vlog.util.a.CmB;
    this.BWX = com.tencent.mm.plugin.vlog.util.a.exN();
    this.BWY = new RectF();
    this.BWZ = new RectF();
    this.BXc = new x();
    this.BXd = ((d.g.a.b)new a(this));
    this.BWB = new v((List)d.a.v.NhH);
    this.BXf = new LinkedList();
    this.BXg = -1;
    this.BXh = -1;
    this.BXl = 1.0F;
    this.BXm = new q();
    AppMethodBeat.o(191193);
  }
  
  public final void Ug(int paramInt)
  {
    AppMethodBeat.i(191187);
    ae.i(this.TAG, "editTrack index:".concat(String.valueOf(paramInt)));
    this.BXh = paramInt;
    this.BXm.start = this.BWB.BXI.getPlayStart();
    this.BXm.bpc = this.BWB.BXI.evH();
    if ((this.BXh >= 0) && (this.BXh < this.BXf.size()))
    {
      Object localObject1 = this.BXf.get(this.BXh);
      p.g(localObject1, "playingList[editIndex]");
      localObject1 = (w)localObject1;
      this.BXi = ((w)localObject1);
      this.BXj = ((w)localObject1).BXV.HWH;
      this.BXk = ((w)localObject1).BXV.HWI;
      this.BXl = ((w)localObject1).BXV.lqb;
      Object localObject2 = new w(((w)localObject1).path, ((w)localObject1).type);
      ((w)localObject2).BJ(((w)localObject1).BXV.Cec);
      ((w)localObject2).BH(((float)((w)localObject1).BXV.Cec / ((w)localObject1).BXV.lqb));
      ((w)localObject2).setPlayRate(((w)localObject1).BXV.lqb);
      ((w)localObject2).BXQ = ((w)localObject1).BXQ;
      ((w)localObject2).BXR = ((w)localObject1).BXR;
      ((w)localObject2).BXT.hpa.set(((w)localObject1).BXT.hpa);
      ((w)localObject2).BXT.qfO.set(((w)localObject1).BXT.qfO);
      ((w)localObject2).BXT.viewRect.set(((w)localObject1).BXT.viewRect);
      ((w)localObject2).BXT.gR.set(((w)localObject1).BXT.gR);
      ((w)localObject2).BXV.hpa.set(((w)localObject1).BXV.hpa);
      ((w)localObject2).BXV.fCr();
      p.h(localObject2, "track");
      this.BWB = new v(d.a.j.listOf(localObject2));
      this.BWB.ir(this.BWV, this.BWW);
      localObject1 = this.BWB;
      localObject2 = com.tencent.mm.plugin.vlog.model.local.a.BYT;
      ((v)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.ewb());
      this.BWB.aq(((float)this.BXj / this.BXl), ((float)this.BXk / this.BXl));
    }
    AppMethodBeat.o(191187);
  }
  
  public final void a(w paramw)
  {
    this.BXi = paramw;
  }
  
  public final void a(boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(191190);
    ae.i(this.TAG, "endEditTrack editIndex:" + this.BXh + ", confirm:" + paramBoolean1 + ", start:" + paramLong1 + ", end:" + paramLong2);
    if ((this.BXh >= 0) && (this.BXh < this.BXf.size()))
    {
      localObject1 = this.BXf.get(this.BXh);
      p.g(localObject1, "playingList[editIndex]");
      localObject1 = (w)localObject1;
      localObject2 = ((w)localObject1).BXU;
      ((MediaEditReportInfo.EditItem)localObject2).clickEditCount += 1;
      localObject2 = ((w)localObject1).BXU;
      ((MediaEditReportInfo.EditItem)localObject2).durationCutCount += paramInt1;
      localObject2 = ((w)localObject1).BXU;
      ((MediaEditReportInfo.EditItem)localObject2).durationScrollCount += paramInt2;
      if ((paramBoolean1) && (paramLong1 >= 0L) && (paramLong2 >= 0L))
      {
        ((w)localObject1).BI(((float)paramLong1 * ((w)localObject1).BXV.lqb));
        ((w)localObject1).BJ(((float)paramLong2 * ((w)localObject1).BXV.lqb));
      }
      for (;;)
      {
        paramLong1 = ((float)(((w)localObject1).BXV.HWI - ((w)localObject1).BXV.HWH) / ((w)localObject1).BXV.lqb);
        ((w)localObject1).BXU.targetDuration = paramLong1;
        if (paramBoolean2)
        {
          this.BXi = null;
          this.BXh = -1;
        }
        localObject1 = com.tencent.mm.videocomposition.b.LJo;
        localObject2 = (Iterable)this.BXf;
        localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(((w)((Iterator)localObject2).next()).BXV);
        }
        ((w)localObject1).BI(this.BXj);
        ((w)localObject1).BJ(this.BXk);
      }
      b.a.iW((List)localObject1);
    }
    this.BWB = new v((List)this.BXf);
    this.BWB.BF(this.BXa);
    Object localObject1 = this.BWB;
    Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.BYT;
    ((v)localObject1).a(com.tencent.mm.plugin.vlog.model.local.a.ewb());
    this.BWB.ir(this.BWV, this.BWW);
    AppMethodBeat.o(191190);
  }
  
  public final void ap(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191189);
    this.BWB.aq(paramLong1, paramLong2);
    AppMethodBeat.o(191189);
  }
  
  public final void bI(float paramFloat)
  {
    AppMethodBeat.i(191188);
    w localw = this.BXi;
    if (localw != null)
    {
      localw.setPlayRate(paramFloat);
      localw.BXV.fCr();
    }
    localw = (w)d.a.j.jm((List)this.BWB.BXJ);
    if (localw != null)
    {
      localw.setPlayRate(paramFloat);
      localw.BXV.fCr();
      this.BWB.aq(localw.BXV.startTimeMs, localw.BXV.hlm);
      AppMethodBeat.o(191188);
      return;
    }
    AppMethodBeat.o(191188);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(191192);
    x localx = this.BXc;
    localx.BYa = null;
    com.tencent.mm.kernel.g.ajj().b(1469, (com.tencent.mm.ak.f)localx);
    com.tencent.mm.kernel.g.ajj().b(2972, (com.tencent.mm.ak.f)localx);
    AppMethodBeat.o(191192);
  }
  
  public final List<bxx> dwg()
  {
    AppMethodBeat.i(191186);
    List localList = this.BXc.dwg();
    AppMethodBeat.o(191186);
    return localList;
  }
  
  public final v evA()
  {
    return this.BWB;
  }
  
  public final boolean evB()
  {
    return this.BXg >= 0;
  }
  
  public final w evC()
  {
    return this.BXi;
  }
  
  public final boolean evx()
  {
    return this.BWR;
  }
  
  public final void evy()
  {
    AppMethodBeat.i(191184);
    Iterator localIterator = ((Iterable)this.BWQ).iterator();
    if (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      g localg = localw.BXT;
      float f;
      if (localg.gR.isIdentity())
      {
        f = localw.BXR * 1.0F / localw.BXQ;
        this.BWY.round(localg.qfO);
        if (f <= this.BWY.height() / this.BWY.width()) {
          break label305;
        }
        f = (this.BWY.width() * 1.0F / localw.BXQ * localw.BXR - this.BWY.height()) / 2.0F;
        localg.qfO.top = ((int)(this.BWY.top - f));
        localg.qfO.bottom = ((int)(f + this.BWY.bottom));
      }
      for (;;)
      {
        this.BWY.round(localg.hpa);
        m.a(localg.gR, new RectF(0.0F, 0.0F, localw.BXQ, localw.BXR), new RectF(localg.qfO));
        localg.qfO.offset(0, -(int)this.BWZ.top);
        localw.BXV.hpa.set(localg.qfO);
        localg.tVV = m.e(localg.gR);
        localg.aXE = (localg.tVV * 5.0F);
        localg.aXF = (localg.tVV * 0.25F);
        localw.BXV.LJk = true;
        break;
        label305:
        f = (this.BWY.height() * 1.0F / localw.BXR * localw.BXQ - this.BWY.width()) / 2.0F;
        localg.qfO.left = ((int)(this.BWY.left - f));
        localg.qfO.right = ((int)(f + this.BWY.right));
      }
    }
    AppMethodBeat.o(191184);
  }
  
  public final Size evz()
  {
    AppMethodBeat.i(191185);
    Size localSize = new Size(this.BWV, this.BWW);
    AppMethodBeat.o(191185);
    return localSize;
  }
  
  public final void iq(int paramInt1, int paramInt2)
  {
    this.BWV = paramInt1;
    this.BWW = paramInt2;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/GenerateVlogRespBody;", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.b<avq, z>
  {
    a(o paramo)
    {
      super();
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.MultiMediaModel$setup$2", f="MultiMediaModel.kt", gkn={79}, m="invokeSuspend")
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  public static final class b
    extends d.d.b.a.j
    implements d.g.a.m<ah, d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    Object oqW;
    
    public b(o paramo, List paramList1, List paramList2, List paramList3, d paramd)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(191182);
      p.h(paramd, "completion");
      paramd = new b(this.BXn, this.BXo, this.BXp, this.BXq, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(191182);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(191181);
      d.d.a.a locala = d.d.a.a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(191181);
        throw paramObject;
      case 0: 
        paramObject = this.ocz;
        this.BXn.BWO.clear();
        this.BXn.rNe.clear();
        this.BXn.BWP.clear();
        this.BXn.BWQ.clear();
        this.BXn.BWO.addAll((Collection)this.BXo);
        this.BXn.rNe.addAll((Collection)this.BXp);
        localObject1 = this.BXn.BWP;
        Object localObject2 = s.BXA;
        Object localObject3 = this.BXo;
        localObject2 = this.BXp;
        List localList = this.BXq;
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
            d.a.j.gkd();
          }
          localObject4 = (String)localObject4;
          Object localObject5 = (Integer)d.a.j.F((List)localObject2, i);
          if (localObject5 == null) {}
          while (((Integer)localObject5).intValue() != 2)
          {
            localObject5 = s.BXA;
            p.h(localObject4, "path");
            localObject5 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject5).inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile((String)localObject4, (BitmapFactory.Options)localObject5);
            int n = s.a.aEF((String)localObject4);
            int m = ((BitmapFactory.Options)localObject5).outWidth;
            int k = ((BitmapFactory.Options)localObject5).outHeight;
            if ((n == 90) || (n == 270))
            {
              m = ((BitmapFactory.Options)localObject5).outHeight;
              k = ((BitmapFactory.Options)localObject5).outWidth;
            }
            localObject4 = new k(m, k, (String)localObject4);
            ((s)localObject4).BXz = ((Number)localList.get(i)).intValue();
            localLinkedList.add(localObject4);
            i = j;
            break;
          }
          localObject5 = s.BXA;
          localObject4 = s.a.aEG((String)localObject4);
          if (localObject4 != null)
          {
            ((s)localObject4).BXz = ((Number)localList.get(i)).intValue();
            localLinkedList.add(localObject4);
            i = j;
          }
          else
          {
            i = j;
          }
        }
        ((LinkedList)localObject1).addAll((Collection)localLinkedList);
        localObject1 = this.BXn;
        localObject2 = (Iterable)this.BXn.BWP;
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
              ((o)localObject1).BWR = bool;
              localObject1 = this.BXn;
              localObject2 = (Iterable)this.BXn.BWP;
              if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {
                break label812;
              }
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                if (!((s)((Iterator)localObject2).next() instanceof ac))
                {
                  bool = false;
                  ((o)localObject1).BWS = bool;
                  localObject1 = this.BXn;
                  localObject2 = com.tencent.mm.plugin.vlog.util.a.CmB;
                  i = ((s)this.BXn.BWP.get(0)).width;
                  f2 = ((s)this.BXn.BWP.get(0)).height * 1.0F / i;
                  if (f2 <= com.tencent.mm.plugin.vlog.util.a.exN()) {
                    break label818;
                  }
                  f1 = com.tencent.mm.plugin.vlog.util.a.exN();
                }
              }
            }
          }
        }
        for (;;)
        {
          ((o)localObject1).BWX = f1;
          localObject1 = this.BXn.BWQ;
          localObject2 = s.BXA;
          localObject2 = (List)this.BXn.BWP;
          this.ocA = paramObject;
          this.oqW = localObject1;
          this.label = 1;
          paramObject = kotlinx.coroutines.g.a((d.d.f)az.gzR(), (d.g.a.m)new s.a.a((List)localObject2, null), this);
          if (paramObject != locala) {
            break label937;
          }
          AppMethodBeat.o(191181);
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
      Object localObject1 = (LinkedList)this.oqW;
      label937:
      for (;;)
      {
        ((LinkedList)localObject1).addAll((Collection)paramObject);
        paramObject = (w)d.a.j.F((List)this.BXn.BWQ, 0);
        if (paramObject != null)
        {
          localObject1 = com.tencent.mm.videocomposition.a.LJa;
          paramObject = a.a.a(paramObject.BXV);
          paramObject.setSize(63, 112);
          paramObject.b(d.a.j.listOf(d.d.b.a.b.FW(0L)), (d.g.a.m)new a(this));
          paramObject = z.Nhr;
          AppMethodBeat.o(191181);
          return paramObject;
        }
        AppMethodBeat.o(191181);
        return null;
      }
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(191183);
      paramObject1 = ((b)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(191183);
      return paramObject1;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/vlog/model/MultiMediaModel$setup$2$3$1"})
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