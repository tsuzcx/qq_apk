package okhttp3.internal.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

public final class b
  implements e
{
  private final Map<X500Principal, Set<X509Certificate>> ajSN;
  
  public b(X509Certificate... paramVarArgs)
  {
    AppMethodBeat.i(186725);
    this.ajSN = new LinkedHashMap();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      X509Certificate localX509Certificate = paramVarArgs[i];
      X500Principal localX500Principal = localX509Certificate.getSubjectX500Principal();
      Set localSet = (Set)this.ajSN.get(localX500Principal);
      Object localObject = localSet;
      if (localSet == null)
      {
        localObject = new LinkedHashSet(1);
        this.ajSN.put(localX500Principal, localObject);
      }
      ((Set)localObject).add(localX509Certificate);
      i += 1;
    }
    AppMethodBeat.o(186725);
  }
  
  public final X509Certificate d(X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(186735);
    Object localObject = paramX509Certificate.getIssuerX500Principal();
    localObject = (Set)this.ajSN.get(localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(186735);
      return null;
    }
    localObject = ((Set)localObject).iterator();
    for (;;)
    {
      X509Certificate localX509Certificate;
      PublicKey localPublicKey;
      if (((Iterator)localObject).hasNext())
      {
        localX509Certificate = (X509Certificate)((Iterator)localObject).next();
        localPublicKey = localX509Certificate.getPublicKey();
      }
      try
      {
        paramX509Certificate.verify(localPublicKey);
        AppMethodBeat.o(186735);
        return localX509Certificate;
      }
      catch (Exception localException) {}
      AppMethodBeat.o(186735);
      return null;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186741);
    if (paramObject == this)
    {
      AppMethodBeat.o(186741);
      return true;
    }
    if (((paramObject instanceof b)) && (((b)paramObject).ajSN.equals(this.ajSN)))
    {
      AppMethodBeat.o(186741);
      return true;
    }
    AppMethodBeat.o(186741);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186743);
    int i = this.ajSN.hashCode();
    AppMethodBeat.o(186743);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.i.b
 * JD-Core Version:    0.7.0.1
 */