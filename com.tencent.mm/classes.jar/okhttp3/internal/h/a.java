package okhttp3.internal.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

public final class a
  extends ProxySelector
{
  public final void connectFailed(URI paramURI, SocketAddress paramSocketAddress, IOException paramIOException) {}
  
  public final List<Proxy> select(URI paramURI)
  {
    AppMethodBeat.i(186727);
    if (paramURI == null)
    {
      paramURI = new IllegalArgumentException("uri must not be null");
      AppMethodBeat.o(186727);
      throw paramURI;
    }
    paramURI = Collections.singletonList(Proxy.NO_PROXY);
    AppMethodBeat.o(186727);
    return paramURI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.h.a
 * JD-Core Version:    0.7.0.1
 */