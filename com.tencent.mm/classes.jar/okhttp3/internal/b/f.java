package okhttp3.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.a;
import okhttp3.ab;
import okhttp3.e;
import okhttp3.internal.c;
import okhttp3.n;
import okhttp3.o;
import okhttp3.r;

public final class f
{
  final d ajMj;
  private final o ajNE;
  final a ajNZ;
  private List<Proxy> ajPv;
  private int ajPw;
  private List<InetSocketAddress> ajPx;
  private final List<ab> ajPy;
  private final e cqs;
  
  public f(a parama, d paramd, e parame, o paramo)
  {
    AppMethodBeat.i(186842);
    this.ajPv = Collections.emptyList();
    this.ajPx = Collections.emptyList();
    this.ajPy = new ArrayList();
    this.ajNZ = parama;
    this.ajMj = paramd;
    this.cqs = parame;
    this.ajNE = paramo;
    paramd = parama.ajIN;
    parama = parama.uuH;
    if (parama != null) {
      parama = Collections.singletonList(parama);
    }
    for (;;)
    {
      this.ajPv = parama;
      this.ajPw = 0;
      AppMethodBeat.o(186842);
      return;
      parama = this.ajNZ.ajIT.select(paramd.kGN());
      if ((parama != null) && (!parama.isEmpty())) {
        parama = c.pj(parama);
      } else {
        parama = c.au(new Proxy[] { Proxy.NO_PROXY });
      }
    }
  }
  
  private void a(Proxy paramProxy)
  {
    AppMethodBeat.i(186866);
    this.ajPx = new ArrayList();
    Object localObject;
    int i;
    if ((paramProxy.type() == Proxy.Type.DIRECT) || (paramProxy.type() == Proxy.Type.SOCKS))
    {
      localObject = this.ajNZ.ajIN.host;
      i = this.ajNZ.ajIN.port;
      if ((i <= 0) || (i > 65535))
      {
        paramProxy = new SocketException("No route to " + (String)localObject + ":" + i + "; port is out of range");
        AppMethodBeat.o(186866);
        throw paramProxy;
      }
    }
    else
    {
      localObject = paramProxy.address();
      if (!(localObject instanceof InetSocketAddress))
      {
        paramProxy = new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + localObject.getClass());
        AppMethodBeat.o(186866);
        throw paramProxy;
      }
      InetSocketAddress localInetSocketAddress = (InetSocketAddress)localObject;
      localObject = localInetSocketAddress.getAddress();
      if (localObject == null) {}
      for (localObject = localInetSocketAddress.getHostName();; localObject = ((InetAddress)localObject).getHostAddress())
      {
        i = localInetSocketAddress.getPort();
        break;
      }
    }
    if (paramProxy.type() == Proxy.Type.SOCKS)
    {
      this.ajPx.add(InetSocketAddress.createUnresolved((String)localObject, i));
      AppMethodBeat.o(186866);
      return;
    }
    paramProxy = this.ajNZ.ajIO.bKj((String)localObject);
    if (paramProxy.isEmpty())
    {
      paramProxy = new UnknownHostException(this.ajNZ.ajIO + " returned no addresses for " + (String)localObject);
      AppMethodBeat.o(186866);
      throw paramProxy;
    }
    int k = paramProxy.size();
    int j = 0;
    while (j < k)
    {
      localObject = (InetAddress)paramProxy.get(j);
      this.ajPx.add(new InetSocketAddress((InetAddress)localObject, i));
      j += 1;
    }
    AppMethodBeat.o(186866);
  }
  
  private boolean kHx()
  {
    AppMethodBeat.i(186849);
    if (this.ajPw < this.ajPv.size())
    {
      AppMethodBeat.o(186849);
      return true;
    }
    AppMethodBeat.o(186849);
    return false;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(186868);
    if ((kHx()) || (!this.ajPy.isEmpty()))
    {
      AppMethodBeat.o(186868);
      return true;
    }
    AppMethodBeat.o(186868);
    return false;
  }
  
  public final f.a kHw()
  {
    AppMethodBeat.i(186882);
    if (!hasNext())
    {
      localObject1 = new NoSuchElementException();
      AppMethodBeat.o(186882);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = new ArrayList();
    do
    {
      if (!kHx()) {
        break;
      }
      if (!kHx())
      {
        localObject1 = new SocketException("No route to " + this.ajNZ.ajIN.host + "; exhausted proxy configurations: " + this.ajPv);
        AppMethodBeat.o(186882);
        throw ((Throwable)localObject1);
      }
      Object localObject2 = this.ajPv;
      int i = this.ajPw;
      this.ajPw = (i + 1);
      localObject2 = (Proxy)((List)localObject2).get(i);
      a((Proxy)localObject2);
      int j = this.ajPx.size();
      i = 0;
      if (i < j)
      {
        ab localab = new ab(this.ajNZ, (Proxy)localObject2, (InetSocketAddress)this.ajPx.get(i));
        if (this.ajMj.c(localab)) {
          this.ajPy.add(localab);
        }
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject1).add(localab);
        }
      }
    } while (((List)localObject1).isEmpty());
    if (((List)localObject1).isEmpty())
    {
      ((List)localObject1).addAll(this.ajPy);
      this.ajPy.clear();
    }
    localObject1 = new f.a((List)localObject1);
    AppMethodBeat.o(186882);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.b.f
 * JD-Core Version:    0.7.0.1
 */