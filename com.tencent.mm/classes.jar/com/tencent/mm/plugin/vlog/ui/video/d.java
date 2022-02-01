package com.tencent.mm.plugin.vlog.ui.video;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.i;
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
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel;", "", "()V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropRect", "Landroid/graphics/Rect;", "maxDuration", "", "maxHeight", "", "maxWidth", "pathList", "Ljava/util/LinkedList;", "getPathList", "()Ljava/util/LinkedList;", "playingList", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sourceList", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "sourceTrackList", "typeList", "getTypeList", "createCompositionFromSource", "", "editTrack", "editIndex", "start", "end", "getCropByScaleType", "track", "scaleType", "Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel$VideoScaleType;", "getCropRect", "getCurrentComposition", "getNormalSize", "Landroid/util/Size;", "getSourceTrack", "", "isSizeValid", "", "setMaxDuration", "setNormalSize", "width", "height", "setTrackCrop", "type", "setUpModel", "paths", "types", "sourceFrom", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "VideoScaleType", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  final LinkedList<Integer> ApQ;
  final Rect Gl;
  final String TAG;
  ac TYA;
  final LinkedList<String> TZD;
  final LinkedList<z> TZE;
  final LinkedList<ad> TZF;
  final LinkedList<ad> TZS;
  long Tzj;
  volatile int maxHeight;
  volatile int maxWidth;
  
  public d()
  {
    AppMethodBeat.i(281888);
    this.TAG = "MicroMsg.MediaModel";
    this.TZD = new LinkedList();
    this.ApQ = new LinkedList();
    this.TZE = new LinkedList();
    this.TZF = new LinkedList();
    this.Gl = new Rect();
    this.TYA = new ac((List)ab.aivy);
    this.TZS = new LinkedList();
    AppMethodBeat.o(281888);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(281902);
    s.u(parama, "type");
    Iterator localIterator = ((Iterable)this.TZF).iterator();
    if (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      switch (b.$EnumSwitchMapping$0[parama.ordinal()])
      {
      }
      int i;
      do
      {
        for (;;)
        {
          localad.UaI.Gl.set(this.Gl);
          localad.UaF.Gl.set(this.Gl);
          localad.UaF.yok.set(this.Gl);
          break;
          Log.i(this.TAG, "FIT_CENTER, sourceWidth: " + localad.UaC + ", sourceHeight: " + localad.UaD + ",maxWidth: " + this.maxWidth + ", maxHeight: " + this.maxHeight);
          if ((localad.UaD != 0) && (localad.UaC != 0) && (this.maxHeight != 0) && (this.maxWidth != 0)) {
            if (localad.UaC * this.maxHeight > this.maxWidth * localad.UaD)
            {
              f = this.maxWidth / (localad.UaC * 1.0F);
              i = kotlin.h.a.eH((this.maxHeight - localad.UaD * f) * 0.5F);
              this.Gl.top += i;
              this.Gl.bottom -= i;
              Log.i(this.TAG, "FIT_CENTER, scale: " + f + ", dy: " + i);
            }
            else
            {
              f = this.maxHeight / (localad.UaD * 1.0F);
              i = kotlin.h.a.eH((this.maxWidth - localad.UaC * f) * 0.5F);
              this.Gl.left += i;
              this.Gl.right -= i;
              Log.i(this.TAG, "FIT_CENTER, scale: " + f + ", dx: " + i);
              continue;
              Log.i(this.TAG, "CENTER_CROP, sourceWidth: " + localad.UaC + ", sourceHeight: " + localad.UaD + ", maxWidth: " + this.maxWidth + ", maxHeight: " + this.maxHeight);
              if ((localad.UaD != 0) && (localad.UaC != 0) && (this.maxHeight != 0) && (this.maxWidth != 0)) {
                if (localad.UaC * this.maxHeight > this.maxWidth * localad.UaD)
                {
                  f = this.maxHeight / (localad.UaD * 1.0F);
                  i = kotlin.h.a.eH((this.maxWidth - localad.UaC * f) * 0.5F);
                  this.Gl.left += i;
                  this.Gl.right -= i;
                  Log.i(this.TAG, "CENTER_CROP, scale: " + f + ", dx: " + i);
                }
                else
                {
                  f = this.maxWidth / (localad.UaC * 1.0F);
                  i = kotlin.h.a.eH((this.maxHeight - localad.UaD * f) * 0.5F);
                  this.Gl.top += i;
                  this.Gl.bottom -= i;
                  Log.i(this.TAG, "CENTER_CROP, scale: " + f + ", dy: " + i);
                }
              }
            }
          }
        }
        Log.i(this.TAG, "CENTER_INSIDE, sourceWidth: " + localad.UaC + ", sourceHeight: " + localad.UaD + ", maxWidth: " + this.maxWidth + ", maxHeight: " + this.maxHeight);
      } while ((localad.UaD == 0) || (localad.UaC == 0) || (this.maxHeight == 0) || (this.maxWidth == 0));
      if ((localad.UaC <= this.maxWidth) && (localad.UaD <= this.maxHeight)) {}
      for (float f = 1.0F;; f = Math.min(this.maxWidth / (localad.UaC * 1.0F), this.maxHeight / (localad.UaD * 1.0F)))
      {
        i = kotlin.h.a.eH((this.maxWidth - localad.UaC * f) * 0.5F);
        int j = kotlin.h.a.eH((this.maxHeight - localad.UaD * f) * 0.5F);
        this.Gl.left += i;
        this.Gl.right -= i;
        this.Gl.top += j;
        this.Gl.bottom -= j;
        Log.i(this.TAG, "CENTER_INSIDE, scale: " + f + ", dx: " + i + ", dy: " + j);
        break;
      }
    }
    AppMethodBeat.o(281902);
  }
  
  public final void bB(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(281913);
    if (this.TZS.size() > 0)
    {
      localObject1 = this.TZS.get(0);
      s.s(localObject1, "playingList[editIndex]");
      localObject1 = (ad)localObject1;
      ((ad)localObject1).wB(paramLong1);
      ((ad)localObject1).wC(paramLong2);
      localObject1 = b.agDF;
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
    this.TYA.mu(this.maxWidth, this.maxHeight);
    AppMethodBeat.o(281913);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/video/MediaModel$VideoScaleType;", "", "(Ljava/lang/String;I)V", "CENTER_CROP", "CENTER_INSIDE", "FIT_CENTER", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(281867);
      UrL = new a("CENTER_CROP", 0);
      UrM = new a("CENTER_INSIDE", 1);
      UrN = new a("FIT_CENTER", 2);
      UrO = new a[] { UrL, UrM, UrN };
      AppMethodBeat.o(281867);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super Boolean>, Object>
  {
    Object L$0;
    int label;
    
    c(d paramd, List<String> paramList, List<Integer> paramList1, List<Integer> paramList2, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(281875);
      paramObject = (kotlin.d.d)new c(this.UrP, this.QFQ, this.Uab, this.Uac, paramd);
      AppMethodBeat.o(281875);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(281868);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(281868);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        this.UrP.TZD.clear();
        this.UrP.ApQ.clear();
        this.UrP.TZE.clear();
        this.UrP.TZF.clear();
        this.UrP.TZD.addAll((Collection)this.QFQ);
        this.UrP.ApQ.addAll((Collection)this.Uab);
        paramObject = this.UrP.TZE;
        localObject1 = z.Uai;
        paramObject.addAll((Collection)z.a.e(this.QFQ, this.Uab, this.Uac));
        localObject1 = this.UrP.TZF;
        paramObject = z.Uai;
        paramObject = (List)this.UrP.TZE;
        Object localObject2 = (kotlin.d.d)this;
        this.L$0 = localObject1;
        this.label = 1;
        localObject2 = z.a.b(paramObject, (kotlin.d.d)localObject2);
        paramObject = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(281868);
          return locala;
        }
        break;
      case 1: 
        localObject1 = (LinkedList)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      boolean bool = ((LinkedList)localObject1).addAll((Collection)paramObject);
      AppMethodBeat.o(281868);
      return Boolean.valueOf(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.d
 * JD-Core Version:    0.7.0.1
 */