package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import okhttp3.e;
import okhttp3.o;
import okhttp3.s;
import okhttp3.s.a;
import okhttp3.x;
import okhttp3.z;

public final class g
  implements s.a
{
  final o ajNE;
  public final x ajNQ;
  private final int ajNs;
  final okhttp3.internal.b.c ajPF;
  public final okhttp3.internal.b.g ajPO;
  final c ajPP;
  private int ajPQ;
  private final int connectTimeout;
  final e cqs;
  private final int index;
  private final List<s> interceptors;
  private final int readTimeout;
  
  public g(List<s> paramList, okhttp3.internal.b.g paramg, c paramc, okhttp3.internal.b.c paramc1, int paramInt1, x paramx, e parame, o paramo, int paramInt2, int paramInt3, int paramInt4)
  {
    this.interceptors = paramList;
    this.ajPF = paramc1;
    this.ajPO = paramg;
    this.ajPP = paramc;
    this.index = paramInt1;
    this.ajNQ = paramx;
    this.cqs = parame;
    this.ajNE = paramo;
    this.connectTimeout = paramInt2;
    this.readTimeout = paramInt3;
    this.ajNs = paramInt4;
  }
  
  public final z a(x paramx, okhttp3.internal.b.g paramg, c paramc, okhttp3.internal.b.c paramc1)
  {
    AppMethodBeat.i(186852);
    if (this.index >= this.interceptors.size())
    {
      paramx = new AssertionError();
      AppMethodBeat.o(186852);
      throw paramx;
    }
    this.ajPQ += 1;
    if ((this.ajPP != null) && (!this.ajPF.c(paramx.ajIN)))
    {
      paramx = new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
      AppMethodBeat.o(186852);
      throw paramx;
    }
    if ((this.ajPP != null) && (this.ajPQ > 1))
    {
      paramx = new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
      AppMethodBeat.o(186852);
      throw paramx;
    }
    paramx = new g(this.interceptors, paramg, paramc, paramc1, this.index + 1, paramx, this.cqs, this.ajNE, this.connectTimeout, this.readTimeout, this.ajNs);
    paramg = (s)this.interceptors.get(this.index);
    paramc1 = paramg.a(paramx);
    if ((paramc != null) && (this.index + 1 < this.interceptors.size()) && (paramx.ajPQ != 1))
    {
      paramx = new IllegalStateException("network interceptor " + paramg + " must call proceed() exactly once");
      AppMethodBeat.o(186852);
      throw paramx;
    }
    if (paramc1 == null)
    {
      paramx = new NullPointerException("interceptor " + paramg + " returned null");
      AppMethodBeat.o(186852);
      throw paramx;
    }
    if (paramc1.ajNR == null)
    {
      paramx = new IllegalStateException("interceptor " + paramg + " returned a response with no body");
      AppMethodBeat.o(186852);
      throw paramx;
    }
    AppMethodBeat.o(186852);
    return paramc1;
  }
  
  public final z c(x paramx)
  {
    AppMethodBeat.i(186834);
    paramx = a(paramx, this.ajPO, this.ajPP, this.ajPF);
    AppMethodBeat.o(186834);
    return paramx;
  }
  
  public final x kGV()
  {
    return this.ajNQ;
  }
  
  public final int kGW()
  {
    return this.connectTimeout;
  }
  
  public final int kGX()
  {
    return this.readTimeout;
  }
  
  public final int kGY()
  {
    return this.ajNs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.c.g
 * JD-Core Version:    0.7.0.1
 */