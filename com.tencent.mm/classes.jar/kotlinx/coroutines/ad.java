package kotlinx.coroutines;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"})
public enum ad
{
  static
  {
    AppMethodBeat.i(118491);
    ad localad1 = new ad("DEFAULT", 0);
    CHB = localad1;
    ad localad2 = new ad("LAZY", 1);
    CHC = localad2;
    ad localad3 = new ad("ATOMIC", 2);
    CHD = localad3;
    ad localad4 = new ad("UNDISPATCHED", 3);
    CHE = localad4;
    CHF = new ad[] { localad1, localad2, localad3, localad4 };
    AppMethodBeat.o(118491);
  }
  
  private ad() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.ad
 * JD-Core Version:    0.7.0.1
 */