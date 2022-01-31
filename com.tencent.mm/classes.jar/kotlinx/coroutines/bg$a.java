package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
final class bg$a
  extends bf<bc>
{
  private final bg CIo;
  private final bg.b CIp;
  private final n CIq;
  private final Object CIr;
  
  public bg$a(bg parambg, bg.b paramb, n paramn, Object paramObject)
  {
    super((bc)paramn.CHo);
    AppMethodBeat.i(118573);
    this.CIo = parambg;
    this.CIp = paramb;
    this.CIq = paramn;
    this.CIr = paramObject;
    AppMethodBeat.o(118573);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118572);
    String str = "ChildCompletion[" + this.CIq + ", " + this.CIr + ']';
    AppMethodBeat.o(118572);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118570);
    bg.a(this.CIo, this.CIp, this.CIq, this.CIr);
    AppMethodBeat.o(118570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.bg.a
 * JD-Core Version:    0.7.0.1
 */