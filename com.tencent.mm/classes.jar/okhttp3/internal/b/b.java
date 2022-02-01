package okhttp3.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.a;
import okhttp3.j;

public final class b
{
  private final List<j> ajIS;
  private int ajPi = 0;
  boolean ajPj;
  boolean ajnd;
  
  public b(List<j> paramList)
  {
    this.ajIS = paramList;
  }
  
  private boolean c(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(186847);
    int i = this.ajPi;
    while (i < this.ajIS.size())
    {
      if (((j)this.ajIS.get(i)).a(paramSSLSocket))
      {
        AppMethodBeat.o(186847);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(186847);
    return false;
  }
  
  public final j b(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(186859);
    int i = this.ajPi;
    int j = this.ajIS.size();
    j localj;
    if (i < j)
    {
      localj = (j)this.ajIS.get(i);
      if (localj.a(paramSSLSocket)) {
        this.ajPi = (i + 1);
      }
    }
    for (;;)
    {
      if (localj == null)
      {
        paramSSLSocket = new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.ajnd + ", modes=" + this.ajIS + ", supported protocols=" + Arrays.toString(paramSSLSocket.getEnabledProtocols()));
        AppMethodBeat.o(186859);
        throw paramSSLSocket;
        i += 1;
        break;
      }
      this.ajPj = c(paramSSLSocket);
      a.ajOh.a(localj, paramSSLSocket, this.ajnd);
      AppMethodBeat.o(186859);
      return localj;
      localj = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.b.b
 * JD-Core Version:    0.7.0.1
 */