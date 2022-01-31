package kotlinx.coroutines;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class n
  extends be<bg>
  implements m
{
  public final o CHo;
  
  public n(bg parambg, o paramo)
  {
    super((bc)parambg);
    AppMethodBeat.i(118512);
    this.CHo = paramo;
    AppMethodBeat.o(118512);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118511);
    String str = "ChildHandle[" + this.CHo + ']';
    AppMethodBeat.o(118511);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118508);
    this.CHo.a((bn)this.CIm);
    AppMethodBeat.o(118508);
  }
  
  public final boolean x(Throwable paramThrowable)
  {
    AppMethodBeat.i(118510);
    j.q(paramThrowable, "cause");
    bg localbg = (bg)this.CIm;
    j.q(paramThrowable, "cause");
    if (localbg.ed(paramThrowable))
    {
      AppMethodBeat.o(118510);
      return true;
    }
    AppMethodBeat.o(118510);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.n
 * JD-Core Version:    0.7.0.1
 */