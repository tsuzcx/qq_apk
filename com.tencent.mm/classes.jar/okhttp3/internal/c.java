package okhttp3.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.ab;
import j.f;
import j.i;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.q;
import okhttp3.q.a;
import okhttp3.r;
import okhttp3.y;
import okhttp3.y.1;

public final class c
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final String[] EMPTY_STRING_ARRAY;
  public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
  public static final Charset UTF_8;
  public static final okhttp3.aa ajOi;
  public static final y ajOj;
  private static final i ajOk;
  private static final i ajOl;
  private static final i ajOm;
  private static final i ajOn;
  private static final i ajOo;
  private static final Charset ajOp = Charset.forName("UTF-16BE");
  private static final Charset ajOq = Charset.forName("UTF-16LE");
  private static final Charset ajOr = Charset.forName("UTF-32BE");
  private static final Charset ajOs = Charset.forName("UTF-32LE");
  public static final TimeZone ajOt = TimeZone.getTimeZone("GMT");
  private static final Method ajOu;
  private static final Pattern ajOv;
  public static final Comparator<String> dFE = new c.1();
  
  static
  {
    AppMethodBeat.i(187181);
    EMPTY_BYTE_ARRAY = new byte[0];
    EMPTY_STRING_ARRAY = new String[0];
    ajOi = okhttp3.aa.ea(EMPTY_BYTE_ARRAY);
    Object localObject1 = EMPTY_BYTE_ARRAY;
    int i = localObject1.length;
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("content == null");
      AppMethodBeat.o(187181);
      throw ((Throwable)localObject1);
    }
    bU(localObject1.length, i);
    ajOj = new y.1(i, (byte[])localObject1);
    ajOk = i.bKV("efbbbf");
    ajOl = i.bKV("feff");
    ajOm = i.bKV("fffe");
    ajOn = i.bKV("0000ffff");
    ajOo = i.bKV("ffff0000");
    UTF_8 = Charset.forName("UTF-8");
    try
    {
      localObject1 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
      ajOu = (Method)localObject1;
      ajOv = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
      AppMethodBeat.o(187181);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public static int N(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    AppMethodBeat.i(186926);
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar)
      {
        AppMethodBeat.o(186926);
        return paramInt1;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(186926);
    return paramInt2;
  }
  
  public static int a(Comparator<String> paramComparator, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(186869);
    int i = 0;
    int j = paramArrayOfString.length;
    while (i < j)
    {
      if (paramComparator.compare(paramArrayOfString[i], paramString) == 0)
      {
        AppMethodBeat.o(186869);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(186869);
    return -1;
  }
  
  public static String a(r paramr, boolean paramBoolean)
  {
    AppMethodBeat.i(186858);
    if (paramr.host.contains(":")) {}
    for (String str = "[" + paramr.host + "]"; (paramBoolean) || (paramr.port != r.bKo(paramr.scheme)); str = paramr.host)
    {
      paramr = str + ":" + paramr.port;
      AppMethodBeat.o(186858);
      return paramr;
    }
    AppMethodBeat.o(186858);
    return str;
  }
  
  public static boolean a(j.aa paramaa, int paramInt, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(186796);
    long l2 = System.nanoTime();
    long l1;
    if (paramaa.kHm().kIR()) {
      l1 = paramaa.kHm().kIS() - l2;
    }
    for (;;)
    {
      paramaa.kHm().Cn(Math.min(l1, paramTimeUnit.toNanos(paramInt)) + l2);
      try
      {
        paramTimeUnit = new f();
        while (paramaa.a(paramTimeUnit, 8192L) != -1L) {
          paramTimeUnit.clear();
        }
      }
      catch (InterruptedIOException paramTimeUnit)
      {
        if (l1 == 9223372036854775807L) {
          paramaa.kHm().kIU();
        }
        for (;;)
        {
          AppMethodBeat.o(186796);
          return false;
          l1 = 9223372036854775807L;
          break;
          if (l1 == 9223372036854775807L) {
            paramaa.kHm().kIU();
          }
          for (;;)
          {
            AppMethodBeat.o(186796);
            return true;
            paramaa.kHm().Cn(l1 + l2);
          }
          paramaa.kHm().Cn(l1 + l2);
        }
      }
      finally
      {
        if (l1 != 9223372036854775807L) {
          break label208;
        }
      }
    }
    paramaa.kHm().kIU();
    for (;;)
    {
      AppMethodBeat.o(186796);
      throw paramTimeUnit;
      label208:
      paramaa.kHm().Cn(l1 + l2);
    }
  }
  
  public static boolean a(j.aa paramaa, TimeUnit paramTimeUnit)
  {
    AppMethodBeat.i(186782);
    try
    {
      boolean bool = a(paramaa, 100, paramTimeUnit);
      AppMethodBeat.o(186782);
      return bool;
    }
    catch (IOException paramaa)
    {
      AppMethodBeat.o(186782);
    }
    return false;
  }
  
  public static boolean a(AssertionError paramAssertionError)
  {
    AppMethodBeat.i(186862);
    if ((paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed")))
    {
      AppMethodBeat.o(186862);
      return true;
    }
    AppMethodBeat.o(186862);
    return false;
  }
  
  public static String[] a(Comparator<? super String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(186832);
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfString1.length;
    int i = 0;
    if (i < k)
    {
      String str = paramArrayOfString1[i];
      int m = paramArrayOfString2.length;
      int j = 0;
      for (;;)
      {
        if (j < m)
        {
          if (paramComparator.compare(str, paramArrayOfString2[j]) == 0) {
            localArrayList.add(str);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    paramComparator = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(186832);
    return paramComparator;
  }
  
  public static <T> List<T> au(T... paramVarArgs)
  {
    AppMethodBeat.i(186818);
    paramVarArgs = Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
    AppMethodBeat.o(186818);
    return paramVarArgs;
  }
  
  public static boolean b(Comparator<String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(186845);
    if ((paramArrayOfString1 == null) || (paramArrayOfString2 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2.length == 0))
    {
      AppMethodBeat.o(186845);
      return false;
    }
    int k = paramArrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str = paramArrayOfString1[i];
      int m = paramArrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        if (paramComparator.compare(str, paramArrayOfString2[j]) == 0)
        {
          AppMethodBeat.o(186845);
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(186845);
    return false;
  }
  
  private static InetAddress bA(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187154);
    byte[] arrayOfByte = new byte[16];
    int j = 0;
    int i = -1;
    int m = -1;
    int k = paramInt1;
    paramInt1 = m;
    if (k < paramInt2)
    {
      if (j == 16)
      {
        AppMethodBeat.o(187154);
        return null;
      }
      if ((k + 2 <= paramInt2) && (paramString.regionMatches(k, "::", 0, 2)))
      {
        if (i != -1)
        {
          AppMethodBeat.o(187154);
          return null;
        }
        k += 2;
        paramInt1 = j + 2;
        if (k != paramInt2) {
          break label570;
        }
        paramInt2 = paramInt1;
        j = paramInt1;
        paramInt1 = paramInt2;
      }
    }
    for (;;)
    {
      if (j != 16) {
        if (paramInt1 == -1)
        {
          AppMethodBeat.o(187154);
          return null;
          if (j == 0) {
            break label564;
          }
          if (paramString.regionMatches(k, ":", 0, 1)) {
            paramInt1 = k + 1;
          }
        }
      }
      for (;;)
      {
        m = 0;
        k = paramInt1;
        for (;;)
        {
          if (k < paramInt2)
          {
            n = N(paramString.charAt(k));
            if (n != -1)
            {
              m = (m << 4) + n;
              k += 1;
              continue;
              if (paramString.regionMatches(k, ".", 0, 1))
              {
                int i1 = j - 2;
                m = i1;
                k = paramInt1;
                if (k < paramInt2) {
                  if (m == 16) {
                    paramInt1 = 0;
                  }
                }
                for (;;)
                {
                  if (paramInt1 != 0) {
                    break label414;
                  }
                  AppMethodBeat.o(187154);
                  return null;
                  paramInt1 = k;
                  if (m != i1)
                  {
                    if (paramString.charAt(k) != '.') {
                      paramInt1 = 0;
                    } else {
                      paramInt1 = k + 1;
                    }
                  }
                  else
                  {
                    n = 0;
                    k = paramInt1;
                    for (;;)
                    {
                      if (k >= paramInt2) {
                        break label366;
                      }
                      int i2 = paramString.charAt(k);
                      if ((i2 < 48) || (i2 > 57)) {
                        break label366;
                      }
                      if ((n == 0) && (paramInt1 != k))
                      {
                        paramInt1 = 0;
                        break;
                      }
                      n = n * 10 + i2 - 48;
                      if (n > 255)
                      {
                        paramInt1 = 0;
                        break;
                      }
                      k += 1;
                    }
                    label366:
                    if (k - paramInt1 == 0)
                    {
                      paramInt1 = 0;
                    }
                    else
                    {
                      arrayOfByte[m] = ((byte)n);
                      m += 1;
                      break;
                      if (m != i1 + 4) {
                        paramInt1 = 0;
                      } else {
                        paramInt1 = 1;
                      }
                    }
                  }
                }
                label414:
                j += 2;
                paramInt1 = i;
                break;
              }
              AppMethodBeat.o(187154);
              return null;
            }
          }
        }
        int n = k - paramInt1;
        if ((n == 0) || (n > 4))
        {
          AppMethodBeat.o(187154);
          return null;
        }
        n = j + 1;
        arrayOfByte[j] = ((byte)(m >>> 8 & 0xFF));
        j = n + 1;
        arrayOfByte[n] = ((byte)(m & 0xFF));
        break;
        System.arraycopy(arrayOfByte, paramInt1, arrayOfByte, 16 - (j - paramInt1), j - paramInt1);
        Arrays.fill(arrayOfByte, paramInt1, 16 - j + paramInt1, (byte)0);
        try
        {
          paramString = InetAddress.getByAddress(arrayOfByte);
          AppMethodBeat.o(187154);
          return paramString;
        }
        catch (UnknownHostException paramString)
        {
          paramString = new AssertionError();
          AppMethodBeat.o(187154);
          throw paramString;
        }
        label564:
        paramInt1 = k;
        continue;
        label570:
        i = paramInt1;
        j = paramInt1;
        paramInt1 = k;
      }
      paramInt1 = i;
    }
  }
  
  public static int bKA(String paramString)
  {
    AppMethodBeat.i(187076);
    int i = 0;
    int j = paramString.length();
    while (i < j)
    {
      int k = paramString.charAt(i);
      if ((k <= 31) || (k >= 127))
      {
        AppMethodBeat.o(187076);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(187076);
    return -1;
  }
  
  public static boolean bKB(String paramString)
  {
    AppMethodBeat.i(187082);
    boolean bool = ajOv.matcher(paramString).matches();
    AppMethodBeat.o(187082);
    return bool;
  }
  
  public static String bKy(String paramString)
  {
    int i2 = 0;
    AppMethodBeat.i(187055);
    if (paramString.contains(":"))
    {
      if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {}
      for (Object localObject = bA(paramString, 1, paramString.length() - 1); localObject == null; localObject = bA(paramString, 0, paramString.length()))
      {
        AppMethodBeat.o(187055);
        return null;
      }
      localObject = ((InetAddress)localObject).getAddress();
      if (localObject.length == 16)
      {
        int j = -1;
        int i = 0;
        int k = 0;
        int m;
        while (i < localObject.length)
        {
          m = i;
          while ((m < 16) && (localObject[m] == 0) && (localObject[(m + 1)] == 0)) {
            m += 2;
          }
          int i3 = m - i;
          int i1 = k;
          int n = j;
          if (i3 > k)
          {
            i1 = k;
            n = j;
            if (i3 >= 4)
            {
              i1 = i3;
              n = i;
            }
          }
          i = m + 2;
          k = i1;
          j = n;
        }
        paramString = new f();
        i = i2;
        while (i < localObject.length) {
          if (i == j)
          {
            paramString.aNg(58);
            m = i + k;
            i = m;
            if (m == 16)
            {
              paramString.aNg(58);
              i = m;
            }
          }
          else
          {
            if (i > 0) {
              paramString.aNg(58);
            }
            paramString.Cl((localObject[i] & 0xFF) << 8 | localObject[(i + 1)] & 0xFF);
            i += 2;
          }
        }
        paramString = paramString.kIG();
        AppMethodBeat.o(187055);
        return paramString;
      }
      paramString = new AssertionError("Invalid IPv6 address: '" + paramString + "'");
      AppMethodBeat.o(187055);
      throw paramString;
    }
    try
    {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      boolean bool = paramString.isEmpty();
      if (bool)
      {
        AppMethodBeat.o(187055);
        return null;
      }
      bool = bKz(paramString);
      if (bool)
      {
        AppMethodBeat.o(187055);
        return null;
      }
      AppMethodBeat.o(187055);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(187055);
    }
    return null;
  }
  
  private static boolean bKz(String paramString)
  {
    AppMethodBeat.i(187068);
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j <= 31) || (j >= 127))
      {
        AppMethodBeat.o(187068);
        return true;
      }
      if (" #%/:?@[\\]".indexOf(j) != -1)
      {
        AppMethodBeat.o(187068);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(187068);
    return false;
  }
  
  public static void bU(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(186749);
    if (((0L | paramLong2) < 0L) || (0L > paramLong1) || (paramLong1 - 0L < paramLong2))
    {
      ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
      AppMethodBeat.o(186749);
      throw localArrayIndexOutOfBoundsException;
    }
    AppMethodBeat.o(186749);
  }
  
  public static int bx(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186880);
    while (paramInt1 < paramInt2)
    {
      switch (paramString.charAt(paramInt1))
      {
      default: 
        AppMethodBeat.o(186880);
        return paramInt1;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(186880);
    return paramInt2;
  }
  
  public static int by(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186904);
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      switch (paramString.charAt(paramInt2))
      {
      default: 
        AppMethodBeat.o(186904);
        return paramInt2 + 1;
      }
      paramInt2 -= 1;
    }
    AppMethodBeat.o(186904);
    return paramInt1;
  }
  
  public static String bz(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186913);
    paramInt1 = bx(paramString, paramInt1, paramInt2);
    paramString = paramString.substring(paramInt1, by(paramString, paramInt1, paramInt2));
    AppMethodBeat.o(186913);
    return paramString;
  }
  
  public static AssertionError c(String paramString, Exception paramException)
  {
    AppMethodBeat.i(187091);
    paramString = new AssertionError(paramString);
    try
    {
      paramString.initCause(paramException);
      label21:
      AppMethodBeat.o(187091);
      return paramString;
    }
    catch (IllegalStateException paramException)
    {
      break label21;
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(186763);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(186763);
        return;
      }
      catch (RuntimeException paramCloseable)
      {
        AppMethodBeat.o(186763);
        throw paramCloseable;
      }
      catch (Exception paramCloseable) {}
    }
    AppMethodBeat.o(186763);
  }
  
  public static void closeQuietly(Socket paramSocket)
  {
    AppMethodBeat.i(186776);
    if (paramSocket != null) {
      try
      {
        paramSocket.close();
        AppMethodBeat.o(186776);
        return;
      }
      catch (AssertionError paramSocket)
      {
        if (!a(paramSocket))
        {
          AppMethodBeat.o(186776);
          throw paramSocket;
        }
        AppMethodBeat.o(186776);
        return;
      }
      catch (RuntimeException paramSocket)
      {
        if ("bio == null".equals(paramSocket.getMessage()))
        {
          AppMethodBeat.o(186776);
          return;
        }
        AppMethodBeat.o(186776);
        throw paramSocket;
      }
      catch (Exception paramSocket) {}
    }
    AppMethodBeat.o(186776);
  }
  
  public static <K, V> Map<K, V> dG(Map<K, V> paramMap)
  {
    AppMethodBeat.i(186811);
    if (paramMap.isEmpty())
    {
      paramMap = Collections.emptyMap();
      AppMethodBeat.o(186811);
      return paramMap;
    }
    paramMap = Collections.unmodifiableMap(new LinkedHashMap(paramMap));
    AppMethodBeat.o(186811);
    return paramMap;
  }
  
  public static void e(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    AppMethodBeat.i(186740);
    if (ajOu != null) {}
    try
    {
      ajOu.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      AppMethodBeat.o(186740);
      return;
    }
    catch (IllegalAccessException paramThrowable1)
    {
      AppMethodBeat.o(186740);
      return;
    }
    catch (InvocationTargetException paramThrowable1)
    {
      label36:
      break label36;
    }
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(186757);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(186757);
      return true;
    }
    AppMethodBeat.o(186757);
    return false;
  }
  
  public static String format(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(187086);
    paramString = String.format(Locale.US, paramString, paramVarArgs);
    AppMethodBeat.o(187086);
    return paramString;
  }
  
  public static String[] g(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(186876);
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    AppMethodBeat.o(186876);
    return arrayOfString;
  }
  
  public static X509TrustManager kHl()
  {
    AppMethodBeat.i(187163);
    try
    {
      Object localObject1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject1).init(null);
      localObject1 = ((TrustManagerFactory)localObject1).getTrustManagers();
      if ((localObject1.length != 1) || (!(localObject1[0] instanceof X509TrustManager)))
      {
        localObject1 = new IllegalStateException("Unexpected default trust managers:" + Arrays.toString((Object[])localObject1));
        AppMethodBeat.o(187163);
        throw ((Throwable)localObject1);
      }
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localObject2 = c("No System TLS", localGeneralSecurityException);
      AppMethodBeat.o(187163);
      throw ((Throwable)localObject2);
    }
    Object localObject2 = (X509TrustManager)localObject2[0];
    AppMethodBeat.o(187163);
    return localObject2;
  }
  
  public static <T> List<T> pj(List<T> paramList)
  {
    AppMethodBeat.i(186802);
    paramList = Collections.unmodifiableList(new ArrayList(paramList));
    AppMethodBeat.o(186802);
    return paramList;
  }
  
  public static q pk(List<okhttp3.internal.e.c> paramList)
  {
    AppMethodBeat.i(187168);
    q.a locala = new q.a();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      okhttp3.internal.e.c localc = (okhttp3.internal.e.c)paramList.next();
      a.ajOh.a(locala, localc.ajQr.kIJ(), localc.ajQs.kIJ());
    }
    paramList = locala.kGM();
    AppMethodBeat.o(187168);
    return paramList;
  }
  
  public static ThreadFactory threadFactory(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(186822);
    paramString = new c.2(paramString, paramBoolean);
    AppMethodBeat.o(186822);
    return paramString;
  }
  
  public static int u(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(186919);
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1)
      {
        AppMethodBeat.o(186919);
        return paramInt1;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(186919);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.c
 * JD-Core Version:    0.7.0.1
 */