package okhttp3.internal.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.c;

public final class d
  implements HostnameVerifier
{
  public static final d ajSO;
  
  static
  {
    AppMethodBeat.i(186781);
    ajSO = new d();
    AppMethodBeat.o(186781);
  }
  
  private static List<String> a(X509Certificate paramX509Certificate, int paramInt)
  {
    AppMethodBeat.i(186756);
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null)
      {
        paramX509Certificate = Collections.emptyList();
        AppMethodBeat.o(186756);
        return paramX509Certificate;
      }
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        Object localObject = (List)paramX509Certificate.next();
        if ((localObject != null) && (((List)localObject).size() >= 2))
        {
          Integer localInteger = (Integer)((List)localObject).get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            localObject = (String)((List)localObject).get(1);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      AppMethodBeat.o(186756);
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      paramX509Certificate = Collections.emptyList();
      AppMethodBeat.o(186756);
      return paramX509Certificate;
    }
    return localArrayList;
  }
  
  public static boolean a(String paramString, X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(186726);
    if (c.bKB(paramString))
    {
      bool = b(paramString, paramX509Certificate);
      AppMethodBeat.o(186726);
      return bool;
    }
    boolean bool = c(paramString, paramX509Certificate);
    AppMethodBeat.o(186726);
    return bool;
  }
  
  private static boolean b(String paramString, X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(186732);
    paramX509Certificate = a(paramX509Certificate, 7);
    int j = paramX509Certificate.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equalsIgnoreCase((String)paramX509Certificate.get(i)))
      {
        AppMethodBeat.o(186732);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(186732);
    return false;
  }
  
  private static boolean c(String paramString, X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(186737);
    paramString = paramString.toLowerCase(Locale.US);
    paramX509Certificate = a(paramX509Certificate, 2).iterator();
    while (paramX509Certificate.hasNext()) {
      if (rG(paramString, (String)paramX509Certificate.next()))
      {
        AppMethodBeat.o(186737);
        return true;
      }
    }
    AppMethodBeat.o(186737);
    return false;
  }
  
  public static List<String> e(X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(186745);
    List localList = a(paramX509Certificate, 7);
    paramX509Certificate = a(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList.size() + paramX509Certificate.size());
    localArrayList.addAll(localList);
    localArrayList.addAll(paramX509Certificate);
    AppMethodBeat.o(186745);
    return localArrayList;
  }
  
  private static boolean rG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186774);
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString1.startsWith(".")) || (paramString1.endsWith("..")))
    {
      AppMethodBeat.o(186774);
      return false;
    }
    if ((paramString2 == null) || (paramString2.length() == 0) || (paramString2.startsWith(".")) || (paramString2.endsWith("..")))
    {
      AppMethodBeat.o(186774);
      return false;
    }
    String str = paramString1;
    if (!paramString1.endsWith(".")) {
      str = paramString1 + '.';
    }
    paramString1 = paramString2;
    if (!paramString2.endsWith(".")) {
      paramString1 = paramString2 + '.';
    }
    paramString1 = paramString1.toLowerCase(Locale.US);
    if (!paramString1.contains("*"))
    {
      boolean bool = str.equals(paramString1);
      AppMethodBeat.o(186774);
      return bool;
    }
    if ((!paramString1.startsWith("*.")) || (paramString1.indexOf('*', 1) != -1))
    {
      AppMethodBeat.o(186774);
      return false;
    }
    if (str.length() < paramString1.length())
    {
      AppMethodBeat.o(186774);
      return false;
    }
    if ("*.".equals(paramString1))
    {
      AppMethodBeat.o(186774);
      return false;
    }
    paramString1 = paramString1.substring(1);
    if (!str.endsWith(paramString1))
    {
      AppMethodBeat.o(186774);
      return false;
    }
    int i = str.length() - paramString1.length();
    if ((i > 0) && (str.lastIndexOf('.', i - 1) != -1))
    {
      AppMethodBeat.o(186774);
      return false;
    }
    AppMethodBeat.o(186774);
    return true;
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    AppMethodBeat.i(186787);
    try
    {
      boolean bool = a(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      AppMethodBeat.o(186787);
      return bool;
    }
    catch (SSLException paramString)
    {
      AppMethodBeat.o(186787);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.internal.i.d
 * JD-Core Version:    0.7.0.1
 */