package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlinx.coroutines.internal.af;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface h<E>
  extends ab<E>, x<E>
{
  public static final a ajxB = a.ajxC;
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/Channel$Factory;", "", "()V", "BUFFERED", "", "CHANNEL_DEFAULT_CAPACITY", "getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core", "()I", "CONFLATED", "DEFAULT_BUFFER_PROPERTY_NAME", "", "OPTIONAL_CHANNEL", "RENDEZVOUS", "UNLIMITED", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final int ajxD;
    
    static
    {
      AppMethodBeat.i(189271);
      ajxC = new a();
      ajxD = af.z("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
      AppMethodBeat.o(189271);
    }
    
    public static int kDo()
    {
      return ajxD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.h
 * JD-Core Version:    0.7.0.1
 */