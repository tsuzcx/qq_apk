package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"})
public enum am
{
  static
  {
    AppMethodBeat.i(118175);
    am localam1 = new am("DEFAULT", 0);
    abwA = localam1;
    am localam2 = new am("LAZY", 1);
    abwB = localam2;
    am localam3 = new am("ATOMIC", 2);
    abwC = localam3;
    am localam4 = new am("UNDISPATCHED", 3);
    abwD = localam4;
    abwE = new am[] { localam1, localam2, localam3, localam4 };
    AppMethodBeat.o(118175);
  }
  
  private am() {}
  
  public final boolean iRf()
  {
    return (am)this == abwB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.am
 * JD-Core Version:    0.7.0.1
 */