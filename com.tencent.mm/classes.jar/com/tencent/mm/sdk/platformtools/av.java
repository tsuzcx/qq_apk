package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class av
{
  public static aw ypi = null;
  
  public static String RC(String paramString)
  {
    AppMethodBeat.i(52203);
    paramString = jdMethod_if(paramString, null);
    AppMethodBeat.o(52203);
    return paramString;
  }
  
  private static String aD(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(52211);
    paramString1 = Pattern.compile(paramString1).matcher(paramString3);
    if (paramString1.find())
    {
      paramString1 = paramString1.replaceAll(paramString2);
      AppMethodBeat.o(52211);
      return paramString1;
    }
    AppMethodBeat.o(52211);
    return paramString3;
  }
  
  public static String apA(String paramString)
  {
    AppMethodBeat.i(52207);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52207);
      return "";
    }
    if (paramString.startsWith("+"))
    {
      AppMethodBeat.o(52207);
      return paramString;
    }
    paramString = "+".concat(String.valueOf(paramString));
    AppMethodBeat.o(52207);
    return paramString;
  }
  
  public static String apx(String paramString)
  {
    AppMethodBeat.i(52204);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52204);
      return paramString;
    }
    if (!bo.aqe(paramString).booleanValue())
    {
      AppMethodBeat.o(52204);
      return paramString;
    }
    new av();
    String str1 = "86";
    Object localObject = paramString;
    if (paramString.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = jdMethod_if(str2, null);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = formatNumber(str1, (String)localObject);
    AppMethodBeat.o(52204);
    return paramString;
  }
  
  public static String apy(String paramString)
  {
    AppMethodBeat.i(52205);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52205);
      return "";
    }
    paramString = paramString.replaceAll("[\\.\\-\\ ]", "").trim();
    AppMethodBeat.o(52205);
    return paramString;
  }
  
  public static String apz(String paramString)
  {
    AppMethodBeat.i(52206);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(52206);
      return "";
    }
    paramString = paramString.replace("+", "");
    AppMethodBeat.o(52206);
    return paramString;
  }
  
  private static int ew(String paramString, int paramInt)
  {
    AppMethodBeat.i(52210);
    Pattern localPattern = Pattern.compile(paramString);
    paramString = "1";
    int i = 0;
    while ((i < paramInt) && (!localPattern.matcher(paramString).find()))
    {
      paramString = paramString + "1";
      i += 1;
    }
    AppMethodBeat.o(52210);
    return i + 1;
  }
  
  public static String formatNumber(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52209);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(52209);
      return paramString2;
    }
    if (ypi == null) {
      ypi = new aw();
    }
    Iterator localIterator1 = ypi.ypj.iterator();
    aw.a locala;
    String str;
    aw.b localb;
    int n;
    int k;
    label539:
    do
    {
      StringBuffer localStringBuffer;
      do
      {
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            locala = (aw.a)localIterator1.next();
          } while ((locala.ypl == null) || (!paramString1.trim().toLowerCase().equals(locala.ypl.trim().toLowerCase())) || (locala.ypo == null));
          str = apy(paramString2);
          if ((str != null) && (str.length() > locala.ypm))
          {
            AppMethodBeat.o(52209);
            return str;
          }
          localIterator2 = locala.ypo.iterator();
        }
        localb = (aw.b)localIterator2.next();
        if (!bo.isNullOrNil(localb.ypp)) {
          break label539;
        }
        if (locala.ypo.size() <= 1) {
          break;
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        m = str.length();
      } while (m > ew(localb.ypr, locala.ypn));
      while (localStringBuffer.toString().length() < locala.ypn) {
        localStringBuffer.append("0");
      }
      paramString1 = aD(localb.ypr, localb.ypq, localStringBuffer.toString());
      i = 0;
      j = 0;
      while (i < paramString1.length())
      {
        n = paramString1.charAt(i);
        paramString2 = paramString1;
        if (j >= m) {
          paramString2 = paramString1.substring(0, i);
        }
        k = j;
        if (n != 32)
        {
          k = j;
          if (n != 45)
          {
            k = j;
            if (n != 12290) {
              k = j + 1;
            }
          }
        }
        i += 1;
        j = k;
        paramString1 = paramString2;
      }
      AppMethodBeat.o(52209);
      return paramString1;
      paramString1 = new StringBuffer();
      paramString1.append(str);
      m = str.length();
      while (paramString1.toString().length() < locala.ypn) {
        paramString1.append("0");
      }
      paramString1 = aD(localb.ypr, localb.ypq, paramString1.toString());
      i = 0;
      j = 0;
      while (i < paramString1.length())
      {
        n = paramString1.charAt(i);
        paramString2 = paramString1;
        if (j >= m) {
          paramString2 = paramString1.substring(0, i);
        }
        k = j;
        if (n != 32)
        {
          k = j;
          if (n != 45)
          {
            k = j;
            if (n != 12290) {
              k = j + 1;
            }
          }
        }
        i += 1;
        j = k;
        paramString1 = paramString2;
      }
      AppMethodBeat.o(52209);
      return paramString1;
    } while (!Pattern.compile(localb.ypp).matcher(str).lookingAt());
    paramString1 = new StringBuffer();
    paramString1.append(str);
    int m = str.length();
    while (paramString1.toString().length() < locala.ypn) {
      paramString1.append(str.charAt(m - 1));
    }
    paramString1 = aD(localb.ypr, localb.ypq, paramString1.toString());
    int i = 0;
    int j = 0;
    while (i < paramString1.length())
    {
      n = paramString1.charAt(i);
      paramString2 = paramString1;
      if (j >= m) {
        paramString2 = paramString1.substring(0, i);
      }
      k = j;
      if (n != 32)
      {
        k = j;
        if (n != 45)
        {
          k = j;
          if (n != 12290) {
            k = j + 1;
          }
        }
      }
      i += 1;
      j = k;
      paramString1 = paramString2;
    }
    AppMethodBeat.o(52209);
    return paramString1;
    AppMethodBeat.o(52209);
    return paramString2;
  }
  
  public static String jdMethod_if(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52202);
    paramString1 = apy(paramString1).replace("+", "");
    if (ypi == null) {
      ypi = new aw();
    }
    int i;
    if (bo.isNullOrNil(paramString2))
    {
      paramString2 = ypi.ypj.iterator();
      do
      {
        do
        {
          if (!paramString2.hasNext()) {
            break;
          }
          localObject = (aw.a)paramString2.next();
        } while (!paramString1.startsWith(((aw.a)localObject).ypl));
        i = paramString1.length() - ((aw.a)localObject).ypl.length();
      } while ((i < ((aw.a)localObject).ypm) || (i > ((aw.a)localObject).ypn));
      ab.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { ((aw.a)localObject).ypl, ((aw.a)localObject).ypk, Integer.valueOf(((aw.a)localObject).ypn), Integer.valueOf(((aw.a)localObject).ypn) });
      paramString1 = ((aw.a)localObject).ypl;
      AppMethodBeat.o(52202);
      return paramString1;
    }
    Object localObject = ypi.ypj.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aw.a locala = (aw.a)((Iterator)localObject).next();
      if (paramString1.startsWith(locala.ypl))
      {
        i = paramString1.length() - locala.ypl.length();
        if ((i >= locala.ypm) && (i <= locala.ypn) && (paramString2.equalsIgnoreCase(locala.ypk)))
        {
          ab.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { locala.ypl, locala.ypk, Integer.valueOf(locala.ypn), Integer.valueOf(locala.ypn) });
          paramString1 = locala.ypl;
          AppMethodBeat.o(52202);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(52202);
    return null;
  }
  
  public static String ig(String paramString1, String paramString2)
  {
    AppMethodBeat.i(52208);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(52208);
      return "";
    }
    paramString1 = paramString1 + "（+" + paramString2 + "）";
    AppMethodBeat.o(52208);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.av
 * JD-Core Version:    0.7.0.1
 */