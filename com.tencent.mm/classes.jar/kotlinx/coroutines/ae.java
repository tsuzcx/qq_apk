package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"})
public enum ae
{
  static
  {
    AppMethodBeat.i(118175);
    ae localae1 = new ae("DEFAULT", 0);
    KdA = localae1;
    ae localae2 = new ae("LAZY", 1);
    KdB = localae2;
    ae localae3 = new ae("ATOMIC", 2);
    KdC = localae3;
    ae localae4 = new ae("UNDISPATCHED", 3);
    KdD = localae4;
    KdE = new ae[] { localae1, localae2, localae3, localae4 };
    AppMethodBeat.o(118175);
  }
  
  private ae() {}
  
  public final boolean fKV()
  {
    return (ae)this == KdB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.ae
 * JD-Core Version:    0.7.0.1
 */