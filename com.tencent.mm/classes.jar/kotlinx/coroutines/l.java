package kotlinx.coroutines;

import a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/AbstractContinuation;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/AbstractContinuation;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class l
  extends be<bc>
{
  public final a<?> CHn;
  
  public l(bc parambc, a<?> parama)
  {
    super(parambc);
    AppMethodBeat.i(118542);
    this.CHn = parama;
    AppMethodBeat.o(118542);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118541);
    String str = "ChildContinuation[" + this.CHn + ']';
    AppMethodBeat.o(118541);
    return str;
  }
  
  public final void v(Throwable paramThrowable)
  {
    AppMethodBeat.i(118539);
    paramThrowable = this.CHn;
    Throwable localThrowable = a.a(this.CIm);
    Object localObject;
    k localk;
    do
    {
      localObject = paramThrowable.CHh;
      if (!(localObject instanceof bm)) {
        break;
      }
      localk = new k((c)paramThrowable, localThrowable);
    } while (!paramThrowable.a((bm)localObject, localk, 0));
    AppMethodBeat.o(118539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     kotlinx.coroutines.l
 * JD-Core Version:    0.7.0.1
 */