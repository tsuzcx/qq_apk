package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/CoroutineStart;", "", "(Ljava/lang/String;I)V", "isLazy", "", "isLazy$annotations", "()V", "()Z", "invoke", "", "T", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"})
public enum ak
{
  static
  {
    AppMethodBeat.i(118175);
    ak localak1 = new ak("DEFAULT", 0);
    TTX = localak1;
    ak localak2 = new ak("LAZY", 1);
    TTY = localak2;
    ak localak3 = new ak("ATOMIC", 2);
    TTZ = localak3;
    ak localak4 = new ak("UNDISPATCHED", 3);
    TUa = localak4;
    TUb = new ak[] { localak1, localak2, localak3, localak4 };
    AppMethodBeat.o(118175);
  }
  
  private ak() {}
  
  public final boolean hMJ()
  {
    return (ak)this == TTY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.ak
 * JD-Core Version:    0.7.0.1
 */