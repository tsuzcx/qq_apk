package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.a.a;
import d.d.b.a.e;
import d.d.b.a.i;
import d.d.d;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import kotlinx.coroutines.ag;

@e(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2$requests$1$1", f="SourceMaterial.kt", l={150}, m="invokeSuspend")
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class n$a$a$a
  extends i
  implements m<ag, d<? super u>, Object>
{
  int label;
  private ag nvs;
  Object nvt;
  
  n$a$a$a(n paramn, d paramd)
  {
    super(paramd);
  }
  
  public final d<y> a(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(207544);
    k.h(paramd, "completion");
    paramd = new a(this.AnL, paramd);
    paramd.nvs = ((ag)paramObject);
    AppMethodBeat.o(207544);
    return paramd;
  }
  
  public final Object cO(Object paramObject)
  {
    AppMethodBeat.i(207543);
    a locala = a.KUd;
    Object localObject = paramObject;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(207543);
      throw paramObject;
    case 0: 
      paramObject = this.nvs;
      localObject = n.AnJ;
      localObject = this.AnL;
      this.nvt = paramObject;
      this.label = 1;
      if ((localObject instanceof aa)) {
        paramObject = new u(((aa)localObject).path, 2, ((n)localObject).AnI);
      }
      for (;;)
      {
        localObject = paramObject;
        if (paramObject != locala) {
          break;
        }
        AppMethodBeat.o(207543);
        return locala;
        if ((localObject instanceof h)) {
          paramObject = new u(((h)localObject).path, 1, ((n)localObject).AnI);
        } else {
          paramObject = null;
        }
      }
    }
    AppMethodBeat.o(207543);
    return localObject;
  }
  
  public final Object n(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(207545);
    paramObject1 = ((a)a(paramObject1, (d)paramObject2)).cO(y.KTp);
    AppMethodBeat.o(207545);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.n.a.a.a
 * JD-Core Version:    0.7.0.1
 */