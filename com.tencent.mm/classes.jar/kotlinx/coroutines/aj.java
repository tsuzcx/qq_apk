package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"})
public enum aj
{
  static
  {
    AppMethodBeat.i(118175);
    aj localaj1 = new aj("DEFAULT", 0);
    Ofd = localaj1;
    aj localaj2 = new aj("LAZY", 1);
    Ofe = localaj2;
    aj localaj3 = new aj("ATOMIC", 2);
    Off = localaj3;
    aj localaj4 = new aj("UNDISPATCHED", 3);
    Ofg = localaj4;
    Ofh = new aj[] { localaj1, localaj2, localaj3, localaj4 };
    AppMethodBeat.o(118175);
  }
  
  private aj() {}
  
  public final boolean gzE()
  {
    return (aj)this == Ofe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.aj
 * JD-Core Version:    0.7.0.1
 */