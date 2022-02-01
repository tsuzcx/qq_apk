package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import d.a.j;
import d.d.a.a;
import d.d.b.a.e;
import d.d.b.a.i;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ag;
import kotlinx.coroutines.f;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "", "width", "", "height", "type", "fromCamera", "(IIII)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "getHeight", "setHeight", "getType", "setType", "getWidth", "setWidth", "Companion", "plugin-vlog_release"})
public class n
{
  public static final n.a AnJ;
  private static final String TAG = "MicroMsg.SourceMaterial";
  int AnI;
  int height;
  private int type;
  int width;
  
  static
  {
    AppMethodBeat.i(207551);
    AnJ = new n.a((byte)0);
    TAG = "MicroMsg.SourceMaterial";
    AppMethodBeat.o(207551);
  }
  
  private n(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramInt3;
    this.AnI = 0;
  }
  
  @e(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2", f="SourceMaterial.kt", l={151}, m="invokeSuspend")
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a$a
    extends i
    implements m<ag, d.d.d<? super List<? extends u>>, Object>
  {
    int label;
    Object nIC;
    private ag nvs;
    Object nvt;
    
    a$a(List paramList, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(207547);
      k.h(paramd, "completion");
      paramd = new a(this.AnK, paramd);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(207547);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(207546);
      Object localObject2 = a.KUd;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(207546);
        throw paramObject;
      case 0: 
        paramObject = this.nvs;
        localObject3 = (Iterable)this.AnK;
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((Collection)localObject1).add(f.a(paramObject, null, (m)new n.a.a.a((n)((Iterator)localObject3).next(), null), 3));
        }
        localObject1 = (List)localObject1;
        localObject3 = (Collection)localObject1;
        this.nvt = paramObject;
        this.nIC = localObject1;
        this.label = 1;
        localObject1 = kotlinx.coroutines.d.a((Collection)localObject3, this);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(207546);
          return localObject2;
        }
        break;
      }
      paramObject = (Iterable)paramObject;
      k.h(paramObject, "$this$filterNotNull");
      Object localObject1 = (List)j.a(paramObject, (Collection)new ArrayList());
      paramObject = (Iterable)localObject1;
      int i = 0;
      localObject2 = paramObject.iterator();
      long l1 = 0L;
      if (((Iterator)localObject2).hasNext())
      {
        paramObject = ((Iterator)localObject2).next();
        if (i < 0) {
          j.fOc();
        }
        localObject3 = (u)paramObject;
        int j = ((Number)Integer.valueOf(i)).intValue();
        paramObject = (n)this.AnK.get(j);
        switch (((u)localObject3).type)
        {
        default: 
          b.i(n.access$getTAG$cp(), "unknown track type:" + ((u)localObject3).type);
          label358:
          if ((paramObject.width > 1080) || (paramObject.height > 1280))
          {
            float f = Math.max(paramObject.width * 1.0F / 1080.0F, paramObject.height * 1.0F / 1280.0F);
            ((u)localObject3).AoA = ((int)(paramObject.width / f));
            ((u)localObject3).AoB = ((int)(paramObject.height / f));
            ((u)localObject3).AoC = f;
          }
          break;
        }
        for (;;)
        {
          l1 = ((u)localObject3).getDurationMs() + l1;
          i += 1;
          break;
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoSource");
            AppMethodBeat.o(207546);
            throw paramObject;
          }
          paramObject = (n)paramObject;
          if (((aa)paramObject).duration > 60000L) {}
          for (long l2 = 60000L;; l2 = ((aa)paramObject).duration)
          {
            ((u)localObject3).bvf = l1;
            ((u)localObject3).gOz = (l1 + l2);
            ((u)localObject3).Aox = 0L;
            ((u)localObject3).Aoy = l2;
            ((u)localObject3).Aoz = ((aa)paramObject).duration;
            ((u)localObject3).AoE.type = 2;
            ((u)localObject3).AoE.originDuration = ((aa)paramObject).duration;
            ((u)localObject3).AoE.targetDuration = ((aa)paramObject).duration;
            break;
          }
          if (paramObject == null)
          {
            paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ImageSource");
            AppMethodBeat.o(207546);
            throw paramObject;
          }
          paramObject = (n)paramObject;
          ((u)localObject3).bvf = l1;
          ((u)localObject3).gOz = (4000L + l1);
          ((u)localObject3).Aox = 0L;
          ((u)localObject3).Aoy = 4000L;
          ((u)localObject3).Aoz = 4000L;
          ((u)localObject3).AoE.type = 1;
          ((u)localObject3).AoE.originDuration = 4000L;
          ((u)localObject3).AoE.targetDuration = 4000L;
          break label358;
          ((u)localObject3).AoA = paramObject.width;
          ((u)localObject3).AoB = paramObject.height;
        }
      }
      AppMethodBeat.o(207546);
      return localObject1;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(207548);
      paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(207548);
      return paramObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.n
 * JD-Core Version:    0.7.0.1
 */