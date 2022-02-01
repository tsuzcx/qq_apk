package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"})
public enum ai
{
  static
  {
    AppMethodBeat.i(118175);
    ai localai1 = new ai("DEFAULT", 0);
    LRc = localai1;
    ai localai2 = new ai("LAZY", 1);
    LRd = localai2;
    ai localai3 = new ai("ATOMIC", 2);
    LRe = localai3;
    ai localai4 = new ai("UNDISPATCHED", 3);
    LRf = localai4;
    LRg = new ai[] { localai1, localai2, localai3, localai4 };
    AppMethodBeat.o(118175);
  }
  
  private ai() {}
  
  public final boolean gdC()
  {
    return (ai)this == LRd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.ai
 * JD-Core Version:    0.7.0.1
 */