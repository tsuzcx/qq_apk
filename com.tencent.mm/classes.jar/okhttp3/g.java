package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.i;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class g
{
  public static final g ajJK;
  final Set<g.b> ajJL;
  final okhttp3.internal.i.c ajJM;
  
  static
  {
    AppMethodBeat.i(186639);
    ajJK = new g(new LinkedHashSet(new g.a().ajJN), null);
    AppMethodBeat.o(186639);
  }
  
  g(Set<g.b> paramSet, okhttp3.internal.i.c paramc)
  {
    this.ajJL = paramSet;
    this.ajJM = paramc;
  }
  
  public static String a(Certificate paramCertificate)
  {
    AppMethodBeat.i(186632);
    if (!(paramCertificate instanceof X509Certificate))
    {
      paramCertificate = new IllegalArgumentException("Certificate pinning requires X509 certificates");
      AppMethodBeat.o(186632);
      throw paramCertificate;
    }
    paramCertificate = "sha256/" + c((X509Certificate)paramCertificate).kIK();
    AppMethodBeat.o(186632);
    return paramCertificate;
  }
  
  private static i c(X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(186635);
    paramX509Certificate = i.ef(paramX509Certificate.getPublicKey().getEncoded()).bKS("SHA-256");
    AppMethodBeat.o(186635);
    return paramX509Certificate;
  }
  
  public final void ab(String paramString, List<Certificate> paramList)
  {
    int j = 0;
    AppMethodBeat.i(186666);
    List localList = Collections.emptyList();
    Object localObject = this.ajJL.iterator();
    if (((Iterator)localObject).hasNext())
    {
      ((Iterator)localObject).next();
      AppMethodBeat.o(186666);
      throw null;
    }
    if (localList.isEmpty())
    {
      AppMethodBeat.o(186666);
      return;
    }
    localObject = paramList;
    if (this.ajJM != null) {
      localObject = this.ajJM.M(paramList, paramString);
    }
    int k = ((List)localObject).size();
    int i = 0;
    while (i < k)
    {
      ((List)localObject).get(i);
      if (localList.size() > 0)
      {
        localList.get(0);
        AppMethodBeat.o(186666);
        throw null;
      }
      i += 1;
    }
    paramList = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
    k = ((List)localObject).size();
    i = 0;
    while (i < k)
    {
      X509Certificate localX509Certificate = (X509Certificate)((List)localObject).get(i);
      paramList.append("\n    ").append(a(localX509Certificate)).append(": ").append(localX509Certificate.getSubjectDN().getName());
      i += 1;
    }
    paramList.append("\n  Pinned certificates for ").append(paramString).append(":");
    k = localList.size();
    i = j;
    while (i < k)
    {
      paramString = (g.b)localList.get(i);
      paramList.append("\n    ").append(paramString);
      i += 1;
    }
    paramString = new SSLPeerUnverifiedException(paramList.toString());
    AppMethodBeat.o(186666);
    throw paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186649);
    if (paramObject == this)
    {
      AppMethodBeat.o(186649);
      return true;
    }
    if (((paramObject instanceof g)) && (okhttp3.internal.c.equal(this.ajJM, ((g)paramObject).ajJM)) && (this.ajJL.equals(((g)paramObject).ajJL)))
    {
      AppMethodBeat.o(186649);
      return true;
    }
    AppMethodBeat.o(186649);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186653);
    if (this.ajJM != null) {}
    for (int i = this.ajJM.hashCode();; i = 0)
    {
      int j = this.ajJL.hashCode();
      AppMethodBeat.o(186653);
      return i * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.g
 * JD-Core Version:    0.7.0.1
 */