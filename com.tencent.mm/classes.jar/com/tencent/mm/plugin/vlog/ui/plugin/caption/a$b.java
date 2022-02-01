package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.f;
import d.d.b.a.j;
import d.d.d;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import kotlinx.coroutines.ah;

@f(c="com.tencent.mm.plugin.vlog.ui.plugin.caption.EditCaptionDataManager$voiceTransLate$1", f="EditCaptionDataManager.kt", gkn={}, m="invokeSuspend")
@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class a$b
  extends j
  implements m<ah, d<? super z>, Object>
{
  int label;
  private ah ocz;
  
  a$b(a parama, int paramInt, d paramd)
  {
    super(paramd);
  }
  
  public final d<z> a(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(191912);
    p.h(paramd, "completion");
    paramd = new b(this.Chk, this.cAn, paramd);
    paramd.ocz = ((ah)paramObject);
    AppMethodBeat.o(191912);
    return paramd;
  }
  
  public final Object cR(Object paramObject)
  {
    AppMethodBeat.i(191911);
    paramObject = d.d.a.a.Nif;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(191911);
      throw paramObject;
    }
    a.a(this.Chk);
    a.a(this.Chk, this.cAn);
    paramObject = z.Nhr;
    AppMethodBeat.o(191911);
    return paramObject;
  }
  
  public final Object p(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(191913);
    paramObject1 = ((b)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
    AppMethodBeat.o(191913);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a.b
 * JD-Core Version:    0.7.0.1
 */