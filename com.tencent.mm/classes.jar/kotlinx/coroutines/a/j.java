package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.l;
import kotlinx.coroutines.bm;

@l(iBK={1, 1, 16}, iBL={"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt"})
public final class j
{
  public static final void a(t<?> paramt, Throwable paramThrowable)
  {
    Object localObject = null;
    CancellationException localCancellationException = null;
    AppMethodBeat.i(204575);
    if (paramThrowable != null) {
      if ((paramThrowable instanceof CancellationException)) {
        break label53;
      }
    }
    label53:
    for (localObject = localCancellationException;; localObject = paramThrowable)
    {
      localCancellationException = (CancellationException)localObject;
      localObject = localCancellationException;
      if (localCancellationException == null) {
        localObject = bm.c("Channel was consumed, consumer had failed", paramThrowable);
      }
      paramt.a((CancellationException)localObject);
      AppMethodBeat.o(204575);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.j
 * JD-Core Version:    0.7.0.1
 */