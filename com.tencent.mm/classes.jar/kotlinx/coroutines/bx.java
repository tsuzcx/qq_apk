package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "handleJobException", "exception", "", "kotlinx-coroutines-core"})
class bx
  extends a<y>
{
  public bx(f paramf, boolean paramBoolean)
  {
    super(paramf, paramBoolean);
    AppMethodBeat.i(118146);
    AppMethodBeat.o(118146);
  }
  
  protected final boolean z(Throwable paramThrowable)
  {
    AppMethodBeat.i(189981);
    aa.b(this.Kdd, paramThrowable);
    AppMethodBeat.o(189981);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bx
 * JD-Core Version:    0.7.0.1
 */