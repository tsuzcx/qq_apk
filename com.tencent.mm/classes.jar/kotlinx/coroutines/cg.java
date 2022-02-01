package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "handleJobException", "exception", "", "kotlinx-coroutines-core"})
class cg
  extends a<z>
{
  public cg(f paramf, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
    AppMethodBeat.i(118146);
    AppMethodBeat.o(118146);
  }
  
  protected final boolean B(Throwable paramThrowable)
  {
    AppMethodBeat.i(190698);
    ae.b(this.NHt, paramThrowable);
    AppMethodBeat.o(190698);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.cg
 * JD-Core Version:    0.7.0.1
 */