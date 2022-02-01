package okhttp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.c;
import okhttp3.internal.c.d;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class k
{
  private static final Pattern ajMw;
  private static final Pattern ajMx;
  private static final Pattern ajMy;
  private static final Pattern ajMz;
  private final long ajMA;
  private final boolean ajMB;
  private final boolean ajMC;
  private final boolean ajMD;
  private final boolean cWw;
  private final String domain;
  public final String name;
  private final String path;
  public final String value;
  
  static
  {
    AppMethodBeat.i(186711);
    ajMw = Pattern.compile("(\\d{2,4})[^\\d]*");
    ajMx = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    ajMy = Pattern.compile("(\\d{1,2})[^\\d]*");
    ajMz = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    AppMethodBeat.o(186711);
  }
  
  private k(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.name = paramString1;
    this.value = paramString2;
    this.ajMA = paramLong;
    this.domain = paramString3;
    this.path = paramString4;
    this.cWw = paramBoolean1;
    this.ajMB = paramBoolean2;
    this.ajMD = paramBoolean3;
    this.ajMC = paramBoolean4;
  }
  
  public static List<k> a(r paramr, q paramq)
  {
    AppMethodBeat.i(186703);
    List localList = paramq.bKk("Set-Cookie");
    paramq = null;
    int j = localList.size();
    int i = 0;
    if (i < j)
    {
      Object localObject = (String)localList.get(i);
      localObject = a(System.currentTimeMillis(), paramr, (String)localObject);
      if (localObject == null) {
        break label117;
      }
      if (paramq != null) {
        break label114;
      }
      paramq = new ArrayList();
      label71:
      paramq.add(localObject);
    }
    label114:
    label117:
    for (;;)
    {
      i += 1;
      break;
      if (paramq != null)
      {
        paramr = Collections.unmodifiableList(paramq);
        AppMethodBeat.o(186703);
        return paramr;
      }
      paramr = Collections.emptyList();
      AppMethodBeat.o(186703);
      return paramr;
      break label71;
    }
  }
  
  private static k a(long paramLong, r paramr, String paramString)
  {
    AppMethodBeat.i(186672);
    int i9 = paramString.length();
    int i = c.a(paramString, 0, i9, ';');
    int j = c.a(paramString, 0, i, '=');
    if (j == i)
    {
      AppMethodBeat.o(186672);
      return null;
    }
    String str1 = c.bz(paramString, 0, j);
    if ((str1.isEmpty()) || (c.bKA(str1) != -1))
    {
      AppMethodBeat.o(186672);
      return null;
    }
    String str2 = c.bz(paramString, j + 1, i);
    if (c.bKA(str2) != -1)
    {
      AppMethodBeat.o(186672);
      return null;
    }
    long l1 = 253402300799999L;
    long l2 = -1L;
    Object localObject1 = null;
    Object localObject4 = null;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = true;
    boolean bool1 = false;
    i += 1;
    int i10;
    Object localObject5;
    Object localObject2;
    if (i < i9)
    {
      i10 = c.a(paramString, i, i9, ';');
      j = c.a(paramString, i, i10, '=');
      localObject5 = c.bz(paramString, i, j);
      if (j < i10)
      {
        localObject2 = c.bz(paramString, j + 1, i10);
        label202:
        if (!((String)localObject5).equalsIgnoreCase("expires")) {
          break label846;
        }
      }
    }
    for (;;)
    {
      int i2;
      int m;
      int i1;
      int k;
      label846:
      Object localObject3;
      try
      {
        int i11 = ((String)localObject2).length();
        i2 = f((String)localObject2, 0, i11, false);
        j = -1;
        m = -1;
        i1 = -1;
        k = -1;
        int n = -1;
        i = -1;
        localObject5 = ajMz.matcher((CharSequence)localObject2);
        if (i2 < i11)
        {
          int i8 = f((String)localObject2, i2 + 1, i11, true);
          ((Matcher)localObject5).region(i2, i8);
          if ((j == -1) && (((Matcher)localObject5).usePattern(ajMz).matches()))
          {
            i3 = Integer.parseInt(((Matcher)localObject5).group(1));
            i5 = Integer.parseInt(((Matcher)localObject5).group(2));
            i7 = Integer.parseInt(((Matcher)localObject5).group(3));
            i6 = k;
            i4 = n;
            i2 = i;
            i8 = f((String)localObject2, i8 + 1, i11, false);
            i = i2;
            n = i4;
            k = i6;
            i1 = i7;
            m = i5;
            j = i3;
            i2 = i8;
            continue;
            localObject2 = "";
            break label202;
          }
          if ((k == -1) && (((Matcher)localObject5).usePattern(ajMy).matches()))
          {
            i6 = Integer.parseInt(((Matcher)localObject5).group(1));
            i2 = i;
            i4 = n;
            i7 = i1;
            i5 = m;
            i3 = j;
            continue;
          }
          if ((n == -1) && (((Matcher)localObject5).usePattern(ajMx).matches()))
          {
            String str3 = ((Matcher)localObject5).group(1).toLowerCase(Locale.US);
            i4 = ajMx.pattern().indexOf(str3) / 4;
            i2 = i;
            i6 = k;
            i7 = i1;
            i5 = m;
            i3 = j;
            continue;
          }
          i2 = i;
          int i4 = n;
          int i6 = k;
          int i7 = i1;
          int i5 = m;
          int i3 = j;
          if (i != -1) {
            continue;
          }
          i2 = i;
          i4 = n;
          i6 = k;
          i7 = i1;
          i5 = m;
          i3 = j;
          if (!((Matcher)localObject5).usePattern(ajMw).matches()) {
            continue;
          }
          i2 = Integer.parseInt(((Matcher)localObject5).group(1));
          i4 = n;
          i6 = k;
          i7 = i1;
          i5 = m;
          i3 = j;
          continue;
          if (i2 < 1601)
          {
            localObject2 = new IllegalArgumentException();
            AppMethodBeat.o(186672);
            throw ((Throwable)localObject2);
          }
          if (n != -1) {
            break label1385;
          }
          localObject2 = new IllegalArgumentException();
          AppMethodBeat.o(186672);
          throw ((Throwable)localObject2);
          localObject2 = new IllegalArgumentException();
          AppMethodBeat.o(186672);
          throw ((Throwable)localObject2);
          localObject2 = new IllegalArgumentException();
          AppMethodBeat.o(186672);
          throw ((Throwable)localObject2);
          localObject2 = new IllegalArgumentException();
          AppMethodBeat.o(186672);
          throw ((Throwable)localObject2);
          localObject2 = new IllegalArgumentException();
          AppMethodBeat.o(186672);
          throw ((Throwable)localObject2);
          localObject2 = new GregorianCalendar(c.ajOt);
          ((Calendar)localObject2).setLenient(false);
          ((Calendar)localObject2).set(1, i2);
          ((Calendar)localObject2).set(2, n - 1);
          ((Calendar)localObject2).set(5, k);
          ((Calendar)localObject2).set(11, j);
          ((Calendar)localObject2).set(12, m);
          ((Calendar)localObject2).set(13, i1);
          ((Calendar)localObject2).set(14, 0);
          long l3 = ((Calendar)localObject2).getTimeInMillis();
          l1 = l3;
          bool1 = true;
          break label1376;
          if (((String)localObject5).equalsIgnoreCase("max-age")) {
            try
            {
              l3 = bKi((String)localObject2);
              l2 = l3;
              bool1 = true;
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
          if (!((String)localObject5).equalsIgnoreCase("domain")) {}
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException1) {}
      try
      {
        if (localNumberFormatException.endsWith("."))
        {
          localObject3 = new IllegalArgumentException();
          AppMethodBeat.o(186672);
          throw ((Throwable)localObject3);
        }
        localObject5 = localObject3;
        if (((String)localObject3).startsWith(".")) {
          localObject5 = ((String)localObject3).substring(1);
        }
        localObject3 = c.bKy((String)localObject5);
        if (localObject3 == null)
        {
          localObject3 = new IllegalArgumentException();
          AppMethodBeat.o(186672);
          throw ((Throwable)localObject3);
        }
        bool2 = false;
        localObject1 = localObject3;
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        break label1376;
      }
      if (((String)localObject5).equalsIgnoreCase("path"))
      {
        localObject4 = localObject3;
      }
      else if (((String)localObject5).equalsIgnoreCase("secure"))
      {
        bool4 = true;
      }
      else if (((String)localObject5).equalsIgnoreCase("httponly"))
      {
        bool3 = true;
        break label1376;
        if (l2 == -9223372036854775808L)
        {
          paramLong = -9223372036854775808L;
          paramString = paramr.host;
          if (localObject1 == null)
          {
            localObject1 = paramString;
            if ((paramString.length() == ((String)localObject1).length()) || (PublicSuffixDatabase.kIr().bKN((String)localObject1) != null)) {
              continue;
            }
            AppMethodBeat.o(186672);
            return null;
          }
        }
        else
        {
          if (l2 == -1L) {
            continue;
          }
          if (l2 <= 9223372036854775L)
          {
            l1 = 1000L * l2;
            l1 += paramLong;
            if (l1 >= paramLong)
            {
              paramLong = l1;
              if (l1 <= 253402300799999L) {
                continue;
              }
            }
            paramLong = 253402300799999L;
            continue;
          }
          l1 = 9223372036854775807L;
          continue;
        }
        if (paramString.equals(localObject1))
        {
          i = 1;
          if (i == 0)
          {
            AppMethodBeat.o(186672);
            return null;
          }
        }
        else
        {
          if ((paramString.endsWith((String)localObject1)) && (paramString.charAt(paramString.length() - ((String)localObject1).length() - 1) == '.') && (!c.bKB(paramString)))
          {
            i = 1;
            continue;
          }
          i = 0;
          continue;
        }
        continue;
        if ((localObject4 == null) || (!localObject4.startsWith("/")))
        {
          paramr = paramr.kGQ();
          i = paramr.lastIndexOf('/');
          if (i != 0)
          {
            paramr = paramr.substring(0, i);
            paramr = new k(str1, str2, paramLong, (String)localObject1, paramr, bool4, bool3, bool2, bool1);
            AppMethodBeat.o(186672);
            return paramr;
          }
          paramr = "/";
          continue;
        }
        paramr = localObject4;
        continue;
        paramLong = l1;
        continue;
      }
      else
      {
        break label1376;
        continue;
        if ((i < 70) || (i > 99)) {
          continue;
        }
        i += 1900;
        i2 = i;
        if (i < 0) {
          continue;
        }
        i2 = i;
        if (i > 69) {
          continue;
        }
        i2 = i + 2000;
        continue;
      }
      label1376:
      i = i10 + 1;
      break;
      label1385:
      if ((k > 0) && (k <= 31)) {
        if ((j >= 0) && (j <= 23)) {
          if ((m >= 0) && (m <= 59)) {
            if (i1 >= 0) {
              if (i1 <= 59) {}
            }
          }
        }
      }
    }
  }
  
  private static long bKi(String paramString)
  {
    AppMethodBeat.i(186694);
    try
    {
      long l = Long.parseLong(paramString);
      if (l <= 0L)
      {
        AppMethodBeat.o(186694);
        return -9223372036854775808L;
      }
      AppMethodBeat.o(186694);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramString.matches("-?\\d+"))
      {
        if (paramString.startsWith("-"))
        {
          AppMethodBeat.o(186694);
          return -9223372036854775808L;
        }
        AppMethodBeat.o(186694);
        return 9223372036854775807L;
      }
      AppMethodBeat.o(186694);
      throw localNumberFormatException;
    }
  }
  
  private static int f(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(186684);
    while (paramInt1 < paramInt2)
    {
      int i = paramString.charAt(paramInt1);
      if (((i < 32) && (i != 9)) || (i >= 127) || ((i >= 48) && (i <= 57)) || ((i >= 97) && (i <= 122)) || ((i >= 65) && (i <= 90)) || (i == 58))
      {
        i = 1;
        if (paramBoolean) {
          break label119;
        }
      }
      label119:
      for (int j = 1;; j = 0)
      {
        if (i != j) {
          break label125;
        }
        AppMethodBeat.o(186684);
        return paramInt1;
        i = 0;
        break;
      }
      label125:
      paramInt1 += 1;
    }
    AppMethodBeat.o(186684);
    return paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186734);
    if (!(paramObject instanceof k))
    {
      AppMethodBeat.o(186734);
      return false;
    }
    paramObject = (k)paramObject;
    if ((paramObject.name.equals(this.name)) && (paramObject.value.equals(this.value)) && (paramObject.domain.equals(this.domain)) && (paramObject.path.equals(this.path)) && (paramObject.ajMA == this.ajMA) && (paramObject.cWw == this.cWw) && (paramObject.ajMB == this.ajMB) && (paramObject.ajMC == this.ajMC) && (paramObject.ajMD == this.ajMD))
    {
      AppMethodBeat.o(186734);
      return true;
    }
    AppMethodBeat.o(186734);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(186747);
    int n = this.name.hashCode();
    int i1 = this.value.hashCode();
    int i2 = this.domain.hashCode();
    int i3 = this.path.hashCode();
    int i4 = (int)(this.ajMA ^ this.ajMA >>> 32);
    int i;
    int j;
    label78:
    int k;
    if (this.cWw)
    {
      i = 0;
      if (!this.ajMB) {
        break label157;
      }
      j = 0;
      if (!this.ajMC) {
        break label162;
      }
      k = 0;
      label87:
      if (!this.ajMD) {
        break label167;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(186747);
      return (k + (j + (i + (((((n + 527) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31) * 31) * 31) * 31 + m;
      i = 1;
      break;
      label157:
      j = 1;
      break label78;
      label162:
      k = 1;
      break label87;
      label167:
      m = 1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186723);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.name);
    ((StringBuilder)localObject).append('=');
    ((StringBuilder)localObject).append(this.value);
    if (this.ajMC)
    {
      if (this.ajMA != -9223372036854775808L) {
        break label147;
      }
      ((StringBuilder)localObject).append("; max-age=0");
    }
    for (;;)
    {
      if (!this.ajMD)
      {
        ((StringBuilder)localObject).append("; domain=");
        ((StringBuilder)localObject).append(this.domain);
      }
      ((StringBuilder)localObject).append("; path=").append(this.path);
      if (this.cWw) {
        ((StringBuilder)localObject).append("; secure");
      }
      if (this.ajMB) {
        ((StringBuilder)localObject).append("; httponly");
      }
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(186723);
      return localObject;
      label147:
      ((StringBuilder)localObject).append("; expires=").append(d.d(new Date(this.ajMA)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     okhttp3.k
 * JD-Core Version:    0.7.0.1
 */