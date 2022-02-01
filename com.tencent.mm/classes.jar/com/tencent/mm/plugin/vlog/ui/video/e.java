package com.tencent.mm.plugin.vlog.ui.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.plugin.vlog.model.z.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.a.v;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel;", "", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropRect", "Landroid/graphics/Rect;", "maxDuration", "", "maxHeight", "", "maxWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playingList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "createCompositionFromSource", "", "editTrack", "editIndex", "start", "end", "getCropByScaleType", "track", "scaleType", "Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel$VideoScaleType;", "getCropRect", "getCurrentComposition", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "", "isSizeValid", "", "setMaxDuration", "setNormalSize", "width", "height", "setTrackCrop", "type", "setUpModel", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "VideoScaleType", "plugin-vlog_release"})
public final class e
{
  long MMU;
  final LinkedList<String> NlX;
  final LinkedList<z> NlY;
  final LinkedList<ad> NlZ;
  ac Nlb;
  final LinkedList<ad> Nmm;
  final String TAG;
  final Rect kXj;
  volatile int maxHeight;
  volatile int maxWidth;
  final LinkedList<Integer> wTn;
  
  public e()
  {
    AppMethodBeat.i(235192);
    this.TAG = "MicroMsg.MediaModel";
    this.NlX = new LinkedList();
    this.wTn = new LinkedList();
    this.NlY = new LinkedList();
    this.NlZ = new LinkedList();
    this.kXj = new Rect();
    this.Nlb = new ac((List)v.aaAd);
    this.Nmm = new LinkedList();
    AppMethodBeat.o(235192);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(235190);
    p.k(parama, "type");
    Iterator localIterator = ((Iterable)this.NlZ).iterator();
    if (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      switch (f.$EnumSwitchMapping$0[parama.ordinal()])
      {
      }
      int i;
      do
      {
        for (;;)
        {
          localad.Nng.kXj.set(this.kXj);
          localad.Nnd.kXj.set(this.kXj);
          localad.Nnd.vcr.set(this.kXj);
          break;
          Log.i(this.TAG, "FIT_CENTER, sourceWidth: " + localad.Nna + ", sourceHeight: " + localad.Nnb + ",maxWidth: " + this.maxWidth + ", maxHeight: " + this.maxHeight);
          if ((localad.Nnb != 0) && (localad.Nna != 0) && (this.maxHeight != 0) && (this.maxWidth != 0)) {
            if (localad.Nna * this.maxHeight > this.maxWidth * localad.Nnb)
            {
              f = this.maxWidth / (localad.Nna * 1.0F);
              i = kotlin.h.a.dm((this.maxHeight - localad.Nnb * f) * 0.5F);
              this.kXj.top += i;
              this.kXj.bottom -= i;
              Log.i(this.TAG, "FIT_CENTER, scale: " + f + ", dy: " + i);
            }
            else
            {
              f = this.maxHeight / (localad.Nnb * 1.0F);
              i = kotlin.h.a.dm((this.maxWidth - localad.Nna * f) * 0.5F);
              this.kXj.left += i;
              this.kXj.right -= i;
              Log.i(this.TAG, "FIT_CENTER, scale: " + f + ", dx: " + i);
              continue;
              Log.i(this.TAG, "CENTER_CROP, sourceWidth: " + localad.Nna + ", sourceHeight: " + localad.Nnb + ", maxWidth: " + this.maxWidth + ", maxHeight: " + this.maxHeight);
              if ((localad.Nnb != 0) && (localad.Nna != 0) && (this.maxHeight != 0) && (this.maxWidth != 0)) {
                if (localad.Nna * this.maxHeight > this.maxWidth * localad.Nnb)
                {
                  f = this.maxHeight / (localad.Nnb * 1.0F);
                  i = kotlin.h.a.dm((this.maxWidth - localad.Nna * f) * 0.5F);
                  this.kXj.left += i;
                  this.kXj.right -= i;
                  Log.i(this.TAG, "CENTER_CROP, scale: " + f + ", dx: " + i);
                }
                else
                {
                  f = this.maxWidth / (localad.Nna * 1.0F);
                  i = kotlin.h.a.dm((this.maxHeight - localad.Nnb * f) * 0.5F);
                  this.kXj.top += i;
                  this.kXj.bottom -= i;
                  Log.i(this.TAG, "CENTER_CROP, scale: " + f + ", dy: " + i);
                }
              }
            }
          }
        }
        Log.i(this.TAG, "CENTER_INSIDE, sourceWidth: " + localad.Nna + ", sourceHeight: " + localad.Nnb + ", maxWidth: " + this.maxWidth + ", maxHeight: " + this.maxHeight);
      } while ((localad.Nnb == 0) || (localad.Nna == 0) || (this.maxHeight == 0) || (this.maxWidth == 0));
      if ((localad.Nna <= this.maxWidth) && (localad.Nnb <= this.maxHeight)) {}
      for (float f = 1.0F;; f = Math.min(this.maxWidth / (localad.Nna * 1.0F), this.maxHeight / (localad.Nnb * 1.0F)))
      {
        i = kotlin.h.a.dm((this.maxWidth - localad.Nna * f) * 0.5F);
        int j = kotlin.h.a.dm((this.maxHeight - localad.Nnb * f) * 0.5F);
        this.kXj.left += i;
        this.kXj.right -= i;
        this.kXj.top += j;
        this.kXj.bottom -= j;
        Log.i(this.TAG, "CENTER_INSIDE, scale: " + f + ", dx: " + i + ", dy: " + j);
        break;
      }
    }
    AppMethodBeat.o(235190);
  }
  
  public final void aP(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(235191);
    if (this.Nmm.size() > 0)
    {
      localObject1 = this.Nmm.get(0);
      p.j(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      ((ad)localObject1).Sn(paramLong1);
      ((ad)localObject1).So(paramLong2);
      localObject1 = b.YHY;
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
    this.Nlb.kH(this.maxWidth, this.maxHeight);
    AppMethodBeat.o(235191);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel$VideoScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "FIT_CENTER", "plugin-vlog_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(223685);
      a locala1 = new a("CENTER_CROP", 0);
      NFF = locala1;
      a locala2 = new a("CENTER_INSIDE", 1);
      NFG = locala2;
      a locala3 = new a("FIT_CENTER", 2);
      NFH = locala3;
      NFI = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(223685);
    }
    
    private a() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends kotlin.d.b.a.j
    implements m<ak, d<? super Boolean>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    b(e parame, List paramList1, List paramList2, List paramList3, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(241289);
      p.k(paramd, "completion");
      paramd = new b(this.NFJ, this.Nmv, this.Nmw, this.Nmx, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(241289);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(241290);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(241290);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(241288);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      LinkedList localLinkedList;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(241288);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        this.NFJ.NlX.clear();
        this.NFJ.wTn.clear();
        this.NFJ.NlY.clear();
        this.NFJ.NlZ.clear();
        this.NFJ.NlX.addAll((Collection)this.Nmv);
        this.NFJ.wTn.addAll((Collection)this.Nmw);
        localLinkedList = this.NFJ.NlY;
        Object localObject = z.NmH;
        localLinkedList.addAll((Collection)z.a.e(this.Nmv, this.Nmw, this.Nmx));
        localLinkedList = this.NFJ.NlZ;
        localObject = z.NmH;
        localObject = (List)this.NFJ.NlY;
        this.L$0 = paramObject;
        this.oDA = localLinkedList;
        this.label = 1;
        localObject = z.a.a((List)localObject, this);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(241288);
          return locala;
        }
        break;
      case 1: 
        localLinkedList = (LinkedList)this.oDA;
        ResultKt.throwOnFailure(paramObject);
      }
      boolean bool = localLinkedList.addAll((Collection)paramObject);
      AppMethodBeat.o(241288);
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.e
 * JD-Core Version:    0.7.0.1
 */