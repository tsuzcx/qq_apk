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

@f(c="com.tencent.mm.plugin.vlog.ui.plugin.caption.EditCaptionDataManager$voiceTransLate$1", f="EditCaptionDataManager.kt", gfL={}, m="invokeSuspend")
@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
final class a$b
  extends j
  implements m<ah, d<? super z>, Object>
{
  int label;
  private ah nWQ;
  
  a$b(a parama, int paramInt, d paramd)
  {
    super(paramd);
  }
  
  public final d<z> a(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(196453);
    p.h(paramd, "completion");
    paramd = new b(this.BPL, this.czG, paramd);
    paramd.nWQ = ((ah)paramObject);
    AppMethodBeat.o(196453);
    return paramd;
  }
  
  public final Object cQ(Object paramObject)
  {
    AppMethodBeat.i(196452);
    paramObject = d.d.a.a.MLc;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(196452);
      throw paramObject;
    }
    a.a(this.BPL);
    a.a(this.BPL, this.czG);
    paramObject = z.MKo;
    AppMethodBeat.o(196452);
    return paramObject;
  }
  
  public final Object p(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(196454);
    paramObject1 = ((b)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
    AppMethodBeat.o(196454);
    return paramObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a.b
 * JD-Core Version:    0.7.0.1
 */