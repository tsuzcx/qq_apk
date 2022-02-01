package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.b.a;
import com.tencent.mm.videocomposition.e;
import d.d.a.a;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ah;

@d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2", f="SourceMaterial.kt", gfL={157}, m="invokeSuspend")
@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class s$a$a
  extends d.d.b.a.j
  implements m<ah, d.d.d<? super List<? extends w>>, Object>
{
  int label;
  private ah nWQ;
  Object nWR;
  Object olg;
  
  s$a$a(List paramList, d.d.d paramd)
  {
    super(paramd);
  }
  
  public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
  {
    AppMethodBeat.i(195753);
    p.h(paramd, "completion");
    paramd = new a(this.BGd, paramd);
    paramd.nWQ = ((ah)paramObject);
    AppMethodBeat.o(195753);
    return paramd;
  }
  
  public final Object cQ(Object paramObject)
  {
    AppMethodBeat.i(195752);
    Object localObject2 = a.MLc;
    Object localObject3;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(195752);
      throw paramObject;
    case 0: 
      paramObject = this.nWQ;
      localObject3 = (Iterable)this.BGd;
      localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add(kotlinx.coroutines.f.a(paramObject, null, (m)new a((s)((Iterator)localObject3).next(), null), 3));
      }
      localObject1 = (List)localObject1;
      localObject3 = (Collection)localObject1;
      this.nWR = paramObject;
      this.olg = localObject1;
      this.label = 1;
      localObject1 = kotlinx.coroutines.d.a((Collection)localObject3, this);
      paramObject = localObject1;
      if (localObject1 == localObject2)
      {
        AppMethodBeat.o(195752);
        return localObject2;
      }
      break;
    }
    paramObject = (Iterable)paramObject;
    p.h(paramObject, "$this$filterNotNull");
    Object localObject1 = (List)d.a.j.a(paramObject, (Collection)new ArrayList());
    paramObject = (Iterable)localObject1;
    int i = 0;
    localObject2 = paramObject.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramObject = ((Iterator)localObject2).next();
      int j = i + 1;
      if (i < 0) {
        d.a.j.gfB();
      }
      localObject3 = (w)paramObject;
      i = ((Number)Integer.valueOf(i)).intValue();
      paramObject = (s)this.BGd.get(i);
      long l2;
      long l1;
      switch (((w)localObject3).type)
      {
      default: 
        l2 = 0L;
        com.tencent.mm.audio.mix.h.b.i(s.access$getTAG$cp(), "unknown track type:" + ((w)localObject3).type);
        l1 = 0L;
      }
      for (;;)
      {
        ((w)localObject3).Bk(0L);
        ((w)localObject3).Bl(l2);
        ((w)localObject3).BGv.originDuration = l1;
        ((w)localObject3).BGv.targetDuration = l1;
        if ((paramObject.width <= 1080) && (paramObject.height <= 1280)) {
          break label620;
        }
        float f = Math.max(paramObject.width * 1.0F / 1080.0F, paramObject.height * 1.0F / 1280.0F);
        ((w)localObject3).BGr = ((int)(paramObject.width / f));
        ((w)localObject3).BGs = ((int)(paramObject.height / f));
        ((w)localObject3).BGt = f;
        i = j;
        break;
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoSource");
          AppMethodBeat.o(195752);
          throw paramObject;
        }
        paramObject = (s)paramObject;
        if (((ac)paramObject).duration > 60000L) {}
        for (l1 = 60000L;; l1 = ((ac)paramObject).duration)
        {
          long l3 = ((ac)paramObject).duration;
          ((w)localObject3).BGv.type = 2;
          l2 = l1;
          l1 = l3;
          break;
        }
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ImageSource");
          AppMethodBeat.o(195752);
          throw paramObject;
        }
        paramObject = (s)paramObject;
        l2 = 4000L;
        ((w)localObject3).BGv.type = 1;
        l1 = 4000L;
      }
      label620:
      ((w)localObject3).BGr = paramObject.width;
      ((w)localObject3).BGs = paramObject.height;
      i = j;
    }
    paramObject = com.tencent.mm.videocomposition.b.LmE;
    localObject2 = (Iterable)localObject1;
    paramObject = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramObject.add(((w)((Iterator)localObject2).next()).BGw);
    }
    b.a.iM((List)paramObject);
    AppMethodBeat.o(195752);
    return localObject1;
  }
  
  public final Object p(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(195754);
    paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cQ(z.MKo);
    AppMethodBeat.o(195754);
    return paramObject1;
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2$requests$1$1", f="SourceMaterial.kt", gfL={156}, m="invokeSuspend")
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends d.d.b.a.j
    implements m<ah, d.d.d<? super w>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    
    a(s params, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(195750);
      p.h(paramd, "completion");
      paramd = new a(this.BGe, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(195750);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(195749);
      a locala = a.MLc;
      Object localObject = paramObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(195749);
        throw paramObject;
      case 0: 
        paramObject = this.nWQ;
        localObject = s.BGc;
        localObject = this.BGe;
        this.nWR = paramObject;
        this.label = 1;
        if ((localObject instanceof ac))
        {
          paramObject = new w(((ac)localObject).path, 2, ((s)localObject).BGb);
          localObject = paramObject.BGw;
          e.LmI.b((com.tencent.mm.videocomposition.b)localObject);
        }
        for (;;)
        {
          localObject = paramObject;
          if (paramObject != locala) {
            break;
          }
          AppMethodBeat.o(195749);
          return locala;
          if ((localObject instanceof k))
          {
            paramObject = new w(((k)localObject).path, 1, ((s)localObject).BGb);
            localObject = paramObject.BGw;
            e.LmI.b((com.tencent.mm.videocomposition.b)localObject);
          }
          else
          {
            paramObject = null;
          }
        }
      }
      AppMethodBeat.o(195749);
      return localObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(195751);
      paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(195751);
      return paramObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.s.a.a
 * JD-Core Version:    0.7.0.1
 */