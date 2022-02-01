package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.c;

public final class a
{
  public final r ajIN;
  public final n ajIO;
  public final SocketFactory ajIP;
  public final b ajIQ;
  public final List<v> ajIR;
  public final List<j> ajIS;
  public final ProxySelector ajIT;
  public final SSLSocketFactory ajIU;
  public final HostnameVerifier ajIV;
  public final g ajIW;
  public final Proxy uuH;
  
  public a(String paramString, int paramInt, n paramn, SocketFactory paramSocketFactory, SSLSocketFactory paramSSLSocketFactory, HostnameVerifier paramHostnameVerifier, g paramg, b paramb, Proxy paramProxy, List<v> paramList, List<j> paramList1, ProxySelector paramProxySelector)
  {
    AppMethodBeat.i(186598);
    r.a locala = new r.a();
    if (paramSSLSocketFactory != null)
    {
      str = "https";
      if (!str.equalsIgnoreCase("http")) {
        break label72;
      }
      locala.scheme = "http";
    }
    for (;;)
    {
      if (paramString == null)
      {
        paramString = new NullPointerException("host == null");
        AppMethodBeat.o(186598);
        throw paramString;
        str = "http";
        break;
        label72:
        if (str.equalsIgnoreCase("https"))
        {
          locala.scheme = "https";
        }
        else
        {
          paramString = new IllegalArgumentException("unexpected scheme: ".concat(String.valueOf(str)));
          AppMethodBeat.o(186598);
          throw paramString;
        }
      }
    }
    String str = r.a.bv(paramString, 0, paramString.length());
    if (str == null)
    {
      paramString = new IllegalArgumentException("unexpected host: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(186598);
      throw paramString;
    }
    locala.host = str;
    if ((paramInt <= 0) || (paramInt > 65535))
    {
      paramString = new IllegalArgumentException("unexpected port: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(186598);
      throw paramString;
    }
    locala.port = paramInt;
    this.ajIN = locala.kGU();
    if (paramn == null)
    {
      paramString = new NullPointerException("dns == null");
      AppMethodBeat.o(186598);
      throw paramString;
    }
    this.ajIO = paramn;
    if (paramSocketFactory == null)
    {
      paramString = new NullPointerException("socketFactory == null");
      AppMethodBeat.o(186598);
      throw paramString;
    }
    this.ajIP = paramSocketFactory;
    if (paramb == null)
    {
      paramString = new NullPointerException("proxyAuthenticator == null");
      AppMethodBeat.o(186598);
      throw paramString;
    }
    this.ajIQ = paramb;
    if (paramList == null)
    {
      paramString = new NullPointerException("protocols == null");
      AppMethodBeat.o(186598);
      throw paramString;
    }
    this.ajIR = c.pj(paramList);
    if (paramList1 == null)
    {
      paramString = new NullPointerException("connectionSpecs == null");
      AppMethodBeat.o(186598);
      throw paramString;
    }
    this.ajIS = c.pj(paramList1);
    if (paramProxySelector == null)
    {
      paramString = new NullPointerException("proxySelector == null");
      AppMethodBeat.o(186598);
      throw paramString;
    }
    this.ajIT = paramProxySelector;
    this.uuH = paramProxy;
    this.ajIU = paramSSLSocketFactory;
    this.ajIV = paramHostnameVerifier;
    this.ajIW = paramg;
    AppMethodBeat.o(186598);
  }
  
  final boolean a(a parama)
  {
    AppMethodBeat.i(186630);
    if ((this.ajIO.equals(parama.ajIO)) && (this.ajIQ.equals(parama.ajIQ)) && (this.ajIR.equals(parama.ajIR)) && (this.ajIS.equals(parama.ajIS)) && (this.ajIT.equals(parama.ajIT)) && (c.equal(this.uuH, parama.uuH)) && (c.equal(this.ajIU, parama.ajIU)) && (c.equal(this.ajIV, parama.ajIV)) && (c.equal(this.ajIW, parama.ajIW)) && (this.ajIN.port == parama.ajIN.port))
    {
      AppMethodBeat.o(186630);
      return true;
    }
    AppMethodBeat.o(186630);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186604);
    if (((paramObject instanceof a)) && (this.ajIN.equals(((a)paramObject).ajIN)) && (a((a)paramObject)))
    {
      AppMethodBeat.o(186604);
      return true;
    }
    AppMethodBeat.o(186604);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(186619);
    int n = this.ajIN.hashCode();
    int i1 = this.ajIO.hashCode();
    int i2 = this.ajIQ.hashCode();
    int i3 = this.ajIR.hashCode();
    int i4 = this.ajIS.hashCode();
    int i5 = this.ajIT.hashCode();
    int i;
    int j;
    if (this.uuH != null)
    {
      i = this.uuH.hashCode();
      if (this.ajIU == null) {
        break label195;
      }
      j = this.ajIU.hashCode();
      label96:
      if (this.ajIV == null) {
        break label200;
      }
    }
    label195:
    label200:
    for (int k = this.ajIV.hashCode();; k = 0)
    {
      if (this.ajIW != null) {
        m = this.ajIW.hashCode();
      }
      AppMethodBeat.o(186619);
      return (k + (j + (i + ((((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label96;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186637);
    Object localObject = new StringBuilder("Address{").append(this.ajIN.host).append(":").append(this.ajIN.port);
    if (this.uuH != null) {
      ((StringBuilder)localObject).append(", proxy=").append(this.uuH);
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(186637);
      return localObject;
      ((StringBuilder)localObject).append(", proxySelector=").append(this.ajIT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.a
 * JD-Core Version:    0.7.0.1
 */