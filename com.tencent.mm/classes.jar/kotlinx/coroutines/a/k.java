package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Channel", "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "getOrElse", "T", "Lkotlinx/coroutines/channels/ChannelResult;", "onFailure", "", "Lkotlin/ParameterName;", "name", "exception", "getOrElse-WpGqRn0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onClosed", "action", "onClosed-WpGqRn0", "onFailure-WpGqRn0", "onSuccess", "value", "onSuccess-WpGqRn0", "kotlinx-coroutines-core"}, k=2, mv={1, 5, 1}, xi=48)
public final class k
{
  private static <E> h<E> a(int paramInt, g paramg)
  {
    int i = 1;
    AppMethodBeat.i(189282);
    switch (paramInt)
    {
    default: 
      if ((paramInt == 1) && (paramg == g.ajxy)) {
        paramg = (a)new r(null);
      }
      break;
    }
    for (;;)
    {
      paramg = (h)paramg;
      AppMethodBeat.o(189282);
      return paramg;
      if (paramg == g.ajxx) {}
      for (paramg = (a)new z(null);; paramg = (a)new e(1, paramg, null))
      {
        paramg = (h)paramg;
        AppMethodBeat.o(189282);
        return paramg;
      }
      if (paramg == g.ajxx) {}
      for (paramInt = i; paramInt == 0; paramInt = 0)
      {
        paramg = (Throwable)new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        AppMethodBeat.o(189282);
        throw paramg;
      }
      paramg = new r(null);
      continue;
      paramg = new s(null);
      continue;
      if (paramg == g.ajxx) {
        h.a locala = h.ajxB;
      }
      for (paramInt = h.a.kDo();; paramInt = 1)
      {
        paramg = new e(paramInt, paramg, null);
        break;
      }
      paramg = (a)new e(paramInt, paramg, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.k
 * JD-Core Version:    0.7.0.1
 */