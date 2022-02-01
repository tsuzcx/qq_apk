package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.c;

public final class j
{
  private static final h[] ajMm;
  private static final h[] ajMn;
  public static final j ajMo;
  public static final j ajMp;
  public static final j ajMq;
  public static final j ajMr;
  final boolean ajMs;
  public final boolean ajMt;
  final String[] ajMu;
  final String[] ajMv;
  
  static
  {
    AppMethodBeat.i(186626);
    ajMm = new h[] { h.ajLZ, h.ajMa, h.ajMb, h.ajMc, h.ajMd, h.ajLL, h.ajLP, h.ajLM, h.ajLQ, h.ajLW, h.ajLV };
    ajMn = new h[] { h.ajLZ, h.ajMa, h.ajMb, h.ajMc, h.ajMd, h.ajLL, h.ajLP, h.ajLM, h.ajLQ, h.ajLW, h.ajLV, h.ajLw, h.ajLx, h.ajKU, h.ajKV, h.ajKs, h.ajKw, h.ajJW };
    ajMo = new a(true).a(ajMm).a(new ac[] { ac.ajOb, ac.ajOc }).kGE().kGF();
    ajMp = new a(true).a(ajMn).a(new ac[] { ac.ajOb, ac.ajOc, ac.ajOd, ac.ajOe }).kGE().kGF();
    ajMq = new a(true).a(ajMn).a(new ac[] { ac.ajOe }).kGE().kGF();
    ajMr = new a(false).kGF();
    AppMethodBeat.o(186626);
  }
  
  j(a parama)
  {
    this.ajMs = parama.ajMs;
    this.ajMu = parama.ajMu;
    this.ajMv = parama.ajMv;
    this.ajMt = parama.ajMt;
  }
  
  public final boolean a(SSLSocket paramSSLSocket)
  {
    AppMethodBeat.i(186631);
    if (!this.ajMs)
    {
      AppMethodBeat.o(186631);
      return false;
    }
    if ((this.ajMv != null) && (!c.b(c.dFE, this.ajMv, paramSSLSocket.getEnabledProtocols())))
    {
      AppMethodBeat.o(186631);
      return false;
    }
    if ((this.ajMu != null) && (!c.b(h.ajJO, this.ajMu, paramSSLSocket.getEnabledCipherSuites())))
    {
      AppMethodBeat.o(186631);
      return false;
    }
    AppMethodBeat.o(186631);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186641);
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(186641);
      return false;
    }
    if (paramObject == this)
    {
      AppMethodBeat.o(186641);
      return true;
    }
    paramObject = (j)paramObject;
    if (this.ajMs != paramObject.ajMs)
    {
      AppMethodBeat.o(186641);
      return false;
    }
    if (this.ajMs)
    {
      if (!Arrays.equals(this.ajMu, paramObject.ajMu))
      {
        AppMethodBeat.o(186641);
        return false;
      }
      if (!Arrays.equals(this.ajMv, paramObject.ajMv))
      {
        AppMethodBeat.o(186641);
        return false;
      }
      if (this.ajMt != paramObject.ajMt)
      {
        AppMethodBeat.o(186641);
        return false;
      }
    }
    AppMethodBeat.o(186641);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186648);
    int i = 17;
    int j;
    int k;
    if (this.ajMs)
    {
      j = Arrays.hashCode(this.ajMu);
      k = Arrays.hashCode(this.ajMv);
      if (!this.ajMt) {
        break label63;
      }
    }
    label63:
    for (i = 0;; i = 1)
    {
      i += ((j + 527) * 31 + k) * 31;
      AppMethodBeat.o(186648);
      return i;
    }
  }
  
  public final String toString()
  {
    Object localObject2 = null;
    AppMethodBeat.i(186654);
    if (!this.ajMs)
    {
      AppMethodBeat.o(186654);
      return "ConnectionSpec()";
    }
    Object localObject1;
    if (this.ajMu != null) {
      if (this.ajMu != null)
      {
        localObject1 = h.aq(this.ajMu);
        localObject1 = localObject1.toString();
        label49:
        if (this.ajMv == null) {
          break label137;
        }
        if (this.ajMv != null) {
          localObject2 = ac.aq(this.ajMv);
        }
      }
    }
    label137:
    for (localObject2 = localObject2.toString();; localObject2 = "[all enabled]")
    {
      localObject1 = "ConnectionSpec(cipherSuites=" + (String)localObject1 + ", tlsVersions=" + (String)localObject2 + ", supportsTlsExtensions=" + this.ajMt + ")";
      AppMethodBeat.o(186654);
      return localObject1;
      localObject1 = null;
      break;
      localObject1 = "[all enabled]";
      break label49;
    }
  }
  
  public static final class a
  {
    boolean ajMs;
    boolean ajMt;
    String[] ajMu;
    String[] ajMv;
    
    public a(j paramj)
    {
      this.ajMs = paramj.ajMs;
      this.ajMu = paramj.ajMu;
      this.ajMv = paramj.ajMv;
      this.ajMt = paramj.ajMt;
    }
    
    a(boolean paramBoolean)
    {
      this.ajMs = paramBoolean;
    }
    
    public final a a(ac... paramVarArgs)
    {
      AppMethodBeat.i(186578);
      if (!this.ajMs)
      {
        paramVarArgs = new IllegalStateException("no TLS versions for cleartext connections");
        AppMethodBeat.o(186578);
        throw paramVarArgs;
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].ajMe;
        i += 1;
      }
      paramVarArgs = as(arrayOfString);
      AppMethodBeat.o(186578);
      return paramVarArgs;
    }
    
    public final a a(h... paramVarArgs)
    {
      AppMethodBeat.i(186561);
      if (!this.ajMs)
      {
        paramVarArgs = new IllegalStateException("no cipher suites for cleartext connections");
        AppMethodBeat.o(186561);
        throw paramVarArgs;
      }
      String[] arrayOfString = new String[paramVarArgs.length];
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i].ajMe;
        i += 1;
      }
      paramVarArgs = ar(arrayOfString);
      AppMethodBeat.o(186561);
      return paramVarArgs;
    }
    
    public final a ar(String... paramVarArgs)
    {
      AppMethodBeat.i(186571);
      if (!this.ajMs)
      {
        paramVarArgs = new IllegalStateException("no cipher suites for cleartext connections");
        AppMethodBeat.o(186571);
        throw paramVarArgs;
      }
      if (paramVarArgs.length == 0)
      {
        paramVarArgs = new IllegalArgumentException("At least one cipher suite is required");
        AppMethodBeat.o(186571);
        throw paramVarArgs;
      }
      this.ajMu = ((String[])paramVarArgs.clone());
      AppMethodBeat.o(186571);
      return this;
    }
    
    public final a as(String... paramVarArgs)
    {
      AppMethodBeat.i(186587);
      if (!this.ajMs)
      {
        paramVarArgs = new IllegalStateException("no TLS versions for cleartext connections");
        AppMethodBeat.o(186587);
        throw paramVarArgs;
      }
      if (paramVarArgs.length == 0)
      {
        paramVarArgs = new IllegalArgumentException("At least one TLS version is required");
        AppMethodBeat.o(186587);
        throw paramVarArgs;
      }
      this.ajMv = ((String[])paramVarArgs.clone());
      AppMethodBeat.o(186587);
      return this;
    }
    
    public final a kGE()
    {
      AppMethodBeat.i(186597);
      if (!this.ajMs)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("no TLS extensions for cleartext connections");
        AppMethodBeat.o(186597);
        throw localIllegalStateException;
      }
      this.ajMt = true;
      AppMethodBeat.o(186597);
      return this;
    }
    
    public final j kGF()
    {
      AppMethodBeat.i(186605);
      j localj = new j(this);
      AppMethodBeat.o(186605);
      return localj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.j
 * JD-Core Version:    0.7.0.1
 */