package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ba
{
  public static bb IeX = null;
  
  public static String aQH(String paramString)
  {
    AppMethodBeat.i(157763);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    if (!bt.aRn(paramString).booleanValue())
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    new ba();
    String str1 = "86";
    Object localObject = paramString;
    if (paramString.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = lM(str2, null);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = formatNumber(str1, (String)localObject);
    AppMethodBeat.o(157763);
    return paramString;
  }
  
  public static String aQI(String paramString)
  {
    AppMethodBeat.i(157764);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157764);
      return "";
    }
    paramString = paramString.replaceAll("[\\.\\-\\ ]", "").trim();
    AppMethodBeat.o(157764);
    return paramString;
  }
  
  public static String aQJ(String paramString)
  {
    AppMethodBeat.i(157765);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157765);
      return "";
    }
    paramString = paramString.replace("+", "");
    AppMethodBeat.o(157765);
    return paramString;
  }
  
  public static String aQK(String paramString)
  {
    AppMethodBeat.i(157766);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157766);
      return "";
    }
    if (paramString.startsWith("+"))
    {
      AppMethodBeat.o(157766);
      return paramString;
    }
    paramString = "+".concat(String.valueOf(paramString));
    AppMethodBeat.o(157766);
    return paramString;
  }
  
  public static String aob(String paramString)
  {
    AppMethodBeat.i(157762);
    paramString = lM(paramString, null);
    AppMethodBeat.o(157762);
    return paramString;
  }
  
  private static String bd(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(157770);
    paramString1 = Pattern.compile(paramString1).matcher(paramString3);
    if (paramString1.find())
    {
      paramString1 = paramString1.replaceAll(paramString2);
      AppMethodBeat.o(157770);
      return paramString1;
    }
    AppMethodBeat.o(157770);
    return paramString3;
  }
  
  public static String formatNumber(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157768);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157768);
      return paramString2;
    }
    if (IeX == null) {
      IeX = new bb();
    }
    Iterator localIterator1 = IeX.IeY.iterator();
    bb.a locala;
    String str;
    bb.b localb;
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
            locala = (bb.a)localIterator1.next();
          } while ((locala.Ifa == null) || (!paramString1.trim().toLowerCase().equals(locala.Ifa.trim().toLowerCase())) || (locala.Ifd == null));
          str = aQI(paramString2);
          if ((str != null) && (str.length() > locala.Ifb))
          {
            AppMethodBeat.o(157768);
            return str;
          }
          localIterator2 = locala.Ifd.iterator();
        }
        localb = (bb.b)localIterator2.next();
        if (!bt.isNullOrNil(localb.Ife)) {
          break label539;
        }
        if (locala.Ifd.size() <= 1) {
          break;
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        m = str.length();
      } while (m > gi(localb.Ifg, locala.Ifc));
      while (localStringBuffer.toString().length() < locala.Ifc) {
        localStringBuffer.append("0");
      }
      paramString1 = bd(localb.Ifg, localb.Iff, localStringBuffer.toString());
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
      AppMethodBeat.o(157768);
      return paramString1;
      paramString1 = new StringBuffer();
      paramString1.append(str);
      m = str.length();
      while (paramString1.toString().length() < locala.Ifc) {
        paramString1.append("0");
      }
      paramString1 = bd(localb.Ifg, localb.Iff, paramString1.toString());
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
      AppMethodBeat.o(157768);
      return paramString1;
    } while (!Pattern.compile(localb.Ife).matcher(str).lookingAt());
    paramString1 = new StringBuffer();
    paramString1.append(str);
    int m = str.length();
    while (paramString1.toString().length() < locala.Ifc) {
      paramString1.append(str.charAt(m - 1));
    }
    paramString1 = bd(localb.Ifg, localb.Iff, paramString1.toString());
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
    AppMethodBeat.o(157768);
    return paramString1;
    AppMethodBeat.o(157768);
    return paramString2;
  }
  
  private static int gi(String paramString, int paramInt)
  {
    AppMethodBeat.i(157769);
    Pattern localPattern = Pattern.compile(paramString);
    paramString = "1";
    int i = 0;
    while ((i < paramInt) && (!localPattern.matcher(paramString).find()))
    {
      paramString = paramString + "1";
      i += 1;
    }
    AppMethodBeat.o(157769);
    return i + 1;
  }
  
  public static String lM(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157761);
    paramString1 = aQI(paramString1).replace("+", "");
    if (IeX == null) {
      IeX = new bb();
    }
    int i;
    if (bt.isNullOrNil(paramString2))
    {
      paramString2 = IeX.IeY.iterator();
      do
      {
        do
        {
          if (!paramString2.hasNext()) {
            break;
          }
          localObject = (bb.a)paramString2.next();
        } while (!paramString1.startsWith(((bb.a)localObject).Ifa));
        i = paramString1.length() - ((bb.a)localObject).Ifa.length();
      } while ((i < ((bb.a)localObject).Ifb) || (i > ((bb.a)localObject).Ifc));
      ad.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { ((bb.a)localObject).Ifa, ((bb.a)localObject).IeZ, Integer.valueOf(((bb.a)localObject).Ifc), Integer.valueOf(((bb.a)localObject).Ifc) });
      paramString1 = ((bb.a)localObject).Ifa;
      AppMethodBeat.o(157761);
      return paramString1;
    }
    Object localObject = IeX.IeY.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bb.a locala = (bb.a)((Iterator)localObject).next();
      if (paramString1.startsWith(locala.Ifa))
      {
        i = paramString1.length() - locala.Ifa.length();
        if ((i >= locala.Ifb) && (i <= locala.Ifc) && (paramString2.equalsIgnoreCase(locala.IeZ)))
        {
          ad.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { locala.Ifa, locala.IeZ, Integer.valueOf(locala.Ifc), Integer.valueOf(locala.Ifc) });
          paramString1 = locala.Ifa;
          AppMethodBeat.o(157761);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(157761);
    return null;
  }
  
  public static String lN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157767);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157767);
      return "";
    }
    paramString1 = paramString1 + "（+" + paramString2 + "）";
    AppMethodBeat.o(157767);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ba
 * JD-Core Version:    0.7.0.1
 */