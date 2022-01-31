package kotlinx.coroutines;

import a.c.e;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "cancelsParent", "getCancelsParent", "()Z", "handleJobException", "exception", "", "kotlinx-coroutines-core"})
class bp
  extends c<y>
{
  public bp(e parame, boolean paramBoolean)
  {
    super(parame, paramBoolean);
    AppMethodBeat.i(118463);
    AppMethodBeat.o(118463);
  }
  
  protected final boolean epU()
  {
    return true;
  }
  
  protected final void z(Throwable paramThrowable)
  {
    AppMethodBeat.i(118462);
    j.q(paramThrowable, "exception");
    z.b(this.CHm, paramThrowable);
    AppMethodBeat.o(118462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.bp
 * JD-Core Version:    0.7.0.1
 */