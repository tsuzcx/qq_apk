package okhttp3.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.i;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.internal.c;
import okhttp3.k;
import okhttp3.l;
import okhttp3.q;
import okhttp3.q.a;
import okhttp3.r;
import okhttp3.x;
import okhttp3.z;

public final class e
{
  private static final i ajPM;
  private static final i ajPN;
  
  static
  {
    AppMethodBeat.i(186875);
    ajPM = i.bKT("\"\\");
    ajPN = i.bKT("\t ,=");
    AppMethodBeat.o(186875);
  }
  
  public static int Y(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(186854);
    while ((paramInt < paramString1.length()) && (paramString2.indexOf(paramString1.charAt(paramInt)) == -1)) {
      paramInt += 1;
    }
    AppMethodBeat.o(186854);
    return paramInt;
  }
  
  public static void a(l paraml, r paramr, q paramq)
  {
    AppMethodBeat.i(186839);
    if (paraml == l.ajME)
    {
      AppMethodBeat.o(186839);
      return;
    }
    if (k.a(paramr, paramq).isEmpty())
    {
      AppMethodBeat.o(186839);
      return;
    }
    AppMethodBeat.o(186839);
  }
  
  public static boolean a(z paramz, q paramq, x paramx)
  {
    AppMethodBeat.i(186810);
    paramz = e(paramz.cnu).iterator();
    while (paramz.hasNext())
    {
      String str = (String)paramz.next();
      if (!c.equal(paramq.bKk(str), paramx.cnu.bKk(str)))
      {
        AppMethodBeat.o(186810);
        return false;
      }
    }
    AppMethodBeat.o(186810);
    return true;
  }
  
  private static long aWw(String paramString)
  {
    AppMethodBeat.i(186800);
    if (paramString == null)
    {
      AppMethodBeat.o(186800);
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      AppMethodBeat.o(186800);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(186800);
    }
    return -1L;
  }
  
  private static Set<String> e(q paramq)
  {
    AppMethodBeat.i(186825);
    Object localObject2 = Collections.emptySet();
    int k = paramq.ajMS.length / 2;
    int i = 0;
    while (i < k)
    {
      Object localObject3 = localObject2;
      if ("Vary".equalsIgnoreCase(paramq.aMS(i)))
      {
        localObject3 = paramq.aMT(i);
        Object localObject1 = localObject2;
        if (((Set)localObject2).isEmpty()) {
          localObject1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        }
        localObject2 = ((String)localObject3).split(",");
        int m = localObject2.length;
        int j = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (j >= m) {
            break;
          }
          ((Set)localObject1).add(localObject2[j].trim());
          j += 1;
        }
      }
      i += 1;
      localObject2 = localObject3;
    }
    AppMethodBeat.o(186825);
    return localObject2;
  }
  
  public static long f(z paramz)
  {
    AppMethodBeat.i(186793);
    long l = aWw(paramz.cnu.get("Content-Length"));
    AppMethodBeat.o(186793);
    return l;
  }
  
  public static boolean g(z paramz)
  {
    AppMethodBeat.i(186817);
    boolean bool = e(paramz.cnu).contains("*");
    AppMethodBeat.o(186817);
    return bool;
  }
  
  public static q h(z paramz)
  {
    AppMethodBeat.i(186836);
    q localq = paramz.ajNS.ajNQ.cnu;
    paramz = e(paramz.cnu);
    if (paramz.isEmpty())
    {
      paramz = new q.a().kGM();
      AppMethodBeat.o(186836);
      return paramz;
    }
    q.a locala = new q.a();
    int i = 0;
    int j = localq.ajMS.length / 2;
    while (i < j)
    {
      String str = localq.aMS(i);
      if (paramz.contains(str)) {
        locala.rB(str, localq.aMT(i));
      }
      i += 1;
    }
    paramz = locala.kGM();
    AppMethodBeat.o(186836);
    return paramz;
  }
  
  public static boolean i(z paramz)
  {
    AppMethodBeat.i(186848);
    if (paramz.ajNQ.method.equals("HEAD"))
    {
      AppMethodBeat.o(186848);
      return false;
    }
    int i = paramz.code;
    if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304))
    {
      AppMethodBeat.o(186848);
      return true;
    }
    if ((f(paramz) != -1L) || ("chunked".equalsIgnoreCase(paramz.bKv("Transfer-Encoding"))))
    {
      AppMethodBeat.o(186848);
      return true;
    }
    AppMethodBeat.o(186848);
    return false;
  }
  
  public static int jX(String paramString, int paramInt)
  {
    AppMethodBeat.i(186861);
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((i != 32) && (i != 9)) {
        break;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(186861);
    return paramInt;
  }
  
  public static int jY(String paramString, int paramInt)
  {
    AppMethodBeat.i(186870);
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 2147483647L)
      {
        AppMethodBeat.o(186870);
        return 2147483647;
      }
      if (l < 0L)
      {
        AppMethodBeat.o(186870);
        return 0;
      }
      paramInt = (int)l;
      AppMethodBeat.o(186870);
      return paramInt;
    }
    catch (NumberFormatException paramString)
    {
      AppMethodBeat.o(186870);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.c.e
 * JD-Core Version:    0.7.0.1
 */