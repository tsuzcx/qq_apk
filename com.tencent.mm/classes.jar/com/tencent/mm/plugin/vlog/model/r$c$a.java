package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.composition.TAVClip;
import d.d.a.a;
import d.d.b.a.i;
import d.d.d;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.List;
import kotlinx.coroutines.ag;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/tavkit/composition/TAVClip;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/plugin/vlog/model/VLogComposition$asyncCreateComposition$2$requests$1$1"})
final class r$c$a
  extends i
  implements m<ag, d<? super List<? extends TAVClip>>, Object>
{
  int label;
  private ag nvs;
  
  r$c$a(u paramu, d paramd, r.c paramc, ag paramag)
  {
    super(paramd);
  }
  
  public final d<y> a(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(207569);
    k.h(paramd, "completion");
    paramd = new a(this.Aoe, paramd, this.Aof, this.Aog);
    paramd.nvs = ((ag)paramObject);
    AppMethodBeat.o(207569);
    return paramd;
  }
  
  public final Object cO(Object paramObject)
  {
    AppMethodBeat.i(207568);
    paramObject = a.KUd;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(207568);
      throw paramObject;
    }
    paramObject = r.c(this.Aoe);
    AppMethodBeat.o(207568);
    return paramObject;
  }
  
  public final Object n(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(207570);
    paramObject1 = ((a)a(paramObject1, (d)paramObject2)).cO(y.KTp);
    AppMethodBeat.o(207570);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.r.c.a
 * JD-Core Version:    0.7.0.1
 */