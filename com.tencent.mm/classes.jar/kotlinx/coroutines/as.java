package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public enum as
{
  static
  {
    AppMethodBeat.i(118175);
    ajvK = new as("DEFAULT", 0);
    ajvL = new as("LAZY", 1);
    ajvM = new as("ATOMIC", 2);
    ajvN = new as("UNDISPATCHED", 3);
    ajvO = new as[] { ajvK, ajvL, ajvM, ajvN };
    AppMethodBeat.o(118175);
  }
  
  private as() {}
  
  public final boolean kCa()
  {
    return this == ajvL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.as
 * JD-Core Version:    0.7.0.1
 */