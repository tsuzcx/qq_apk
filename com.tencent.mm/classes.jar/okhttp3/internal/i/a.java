package okhttp3.internal.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class a
  extends c
{
  private final e ajSM;
  
  public a(e parame)
  {
    this.ajSM = parame;
  }
  
  private static boolean a(X509Certificate paramX509Certificate1, X509Certificate paramX509Certificate2)
  {
    AppMethodBeat.i(186720);
    if (!paramX509Certificate1.getIssuerDN().equals(paramX509Certificate2.getSubjectDN()))
    {
      AppMethodBeat.o(186720);
      return false;
    }
    try
    {
      paramX509Certificate1.verify(paramX509Certificate2.getPublicKey());
      AppMethodBeat.o(186720);
      return true;
    }
    catch (GeneralSecurityException paramX509Certificate1)
    {
      AppMethodBeat.o(186720);
    }
    return false;
  }
  
  public final List<Certificate> M(List<Certificate> paramList, String paramString)
  {
    AppMethodBeat.i(186733);
    paramList = new ArrayDeque(paramList);
    paramString = new ArrayList();
    paramString.add(paramList.removeFirst());
    int j = 0;
    int i = 0;
    if (j < 9)
    {
      X509Certificate localX509Certificate1 = (X509Certificate)paramString.get(paramString.size() - 1);
      Object localObject = this.ajSM.d(localX509Certificate1);
      if (localObject != null)
      {
        if ((paramString.size() > 1) || (!localX509Certificate1.equals(localObject))) {
          paramString.add(localObject);
        }
        if (a((X509Certificate)localObject, (X509Certificate)localObject))
        {
          AppMethodBeat.o(186733);
          return paramString;
        }
        i = 1;
      }
      for (;;)
      {
        j += 1;
        break;
        localObject = paramList.iterator();
        X509Certificate localX509Certificate2;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localX509Certificate2 = (X509Certificate)((Iterator)localObject).next();
        } while (!a(localX509Certificate1, localX509Certificate2));
        ((Iterator)localObject).remove();
        paramString.add(localX509Certificate2);
      }
      if (i != 0)
      {
        AppMethodBeat.o(186733);
        return paramString;
      }
      paramList = new SSLPeerUnverifiedException("Failed to find a trusted cert that signed ".concat(String.valueOf(localX509Certificate1)));
      AppMethodBeat.o(186733);
      throw paramList;
    }
    paramList = new SSLPeerUnverifiedException("Certificate chain too long: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(186733);
    throw paramList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186742);
    if (paramObject == this)
    {
      AppMethodBeat.o(186742);
      return true;
    }
    if (((paramObject instanceof a)) && (((a)paramObject).ajSM.equals(this.ajSM)))
    {
      AppMethodBeat.o(186742);
      return true;
    }
    AppMethodBeat.o(186742);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186738);
    int i = this.ajSM.hashCode();
    AppMethodBeat.o(186738);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.i.a
 * JD-Core Version:    0.7.0.1
 */