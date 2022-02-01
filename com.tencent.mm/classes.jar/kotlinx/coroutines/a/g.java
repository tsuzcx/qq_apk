package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlinx.coroutines.internal.y;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"})
public abstract interface g<E>
  extends t<E>, x<E>
{
  public static final a abyq = a.abys;
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/channels/Channel$Factory;", "", "()V", "BUFFERED", "", "CHANNEL_DEFAULT_CAPACITY", "getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core", "()I", "CONFLATED", "DEFAULT_BUFFER_PROPERTY_NAME", "", "OPTIONAL_CHANNEL", "RENDEZVOUS", "UNLIMITED", "kotlinx-coroutines-core"})
  public static final class a
  {
    private static final int abyr;
    
    static
    {
      AppMethodBeat.i(204609);
      abys = new a();
      abyr = y.z("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
      AppMethodBeat.o(204609);
    }
    
    public static int iSw()
    {
      return abyr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a.g
 * JD-Core Version:    0.7.0.1
 */