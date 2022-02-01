package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ba
{
  public static bb EVW = null;
  
  public static String aFK(String paramString)
  {
    AppMethodBeat.i(157763);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    if (!bt.aGq(paramString).booleanValue())
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
      paramString = kQ(str2, null);
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
  
  public static String aFL(String paramString)
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
  
  public static String aFM(String paramString)
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
  
  public static String aFN(String paramString)
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
  
  private static String aR(String paramString1, String paramString2, String paramString3)
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
  
  public static String aew(String paramString)
  {
    AppMethodBeat.i(157762);
    paramString = kQ(paramString, null);
    AppMethodBeat.o(157762);
    return paramString;
  }
  
  private static int fG(String paramString, int paramInt)
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
  
  public static String formatNumber(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157768);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157768);
      return paramString2;
    }
    if (EVW == null) {
      EVW = new bb();
    }
    Iterator localIterator1 = EVW.EVX.iterator();
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
          } while ((locala.EVZ == null) || (!paramString1.trim().toLowerCase().equals(locala.EVZ.trim().toLowerCase())) || (locala.EWc == null));
          str = aFL(paramString2);
          if ((str != null) && (str.length() > locala.EWa))
          {
            AppMethodBeat.o(157768);
            return str;
          }
          localIterator2 = locala.EWc.iterator();
        }
        localb = (bb.b)localIterator2.next();
        if (!bt.isNullOrNil(localb.EWd)) {
          break label539;
        }
        if (locala.EWc.size() <= 1) {
          break;
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        m = str.length();
      } while (m > fG(localb.EWf, locala.EWb));
      while (localStringBuffer.toString().length() < locala.EWb) {
        localStringBuffer.append("0");
      }
      paramString1 = aR(localb.EWf, localb.EWe, localStringBuffer.toString());
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
      while (paramString1.toString().length() < locala.EWb) {
        paramString1.append("0");
      }
      paramString1 = aR(localb.EWf, localb.EWe, paramString1.toString());
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
    } while (!Pattern.compile(localb.EWd).matcher(str).lookingAt());
    paramString1 = new StringBuffer();
    paramString1.append(str);
    int m = str.length();
    while (paramString1.toString().length() < locala.EWb) {
      paramString1.append(str.charAt(m - 1));
    }
    paramString1 = aR(localb.EWf, localb.EWe, paramString1.toString());
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
  
  public static String kQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157761);
    paramString1 = aFL(paramString1).replace("+", "");
    if (EVW == null) {
      EVW = new bb();
    }
    int i;
    if (bt.isNullOrNil(paramString2))
    {
      paramString2 = EVW.EVX.iterator();
      do
      {
        do
        {
          if (!paramString2.hasNext()) {
            break;
          }
          localObject = (bb.a)paramString2.next();
        } while (!paramString1.startsWith(((bb.a)localObject).EVZ));
        i = paramString1.length() - ((bb.a)localObject).EVZ.length();
      } while ((i < ((bb.a)localObject).EWa) || (i > ((bb.a)localObject).EWb));
      ad.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { ((bb.a)localObject).EVZ, ((bb.a)localObject).EVY, Integer.valueOf(((bb.a)localObject).EWb), Integer.valueOf(((bb.a)localObject).EWb) });
      paramString1 = ((bb.a)localObject).EVZ;
      AppMethodBeat.o(157761);
      return paramString1;
    }
    Object localObject = EVW.EVX.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bb.a locala = (bb.a)((Iterator)localObject).next();
      if (paramString1.startsWith(locala.EVZ))
      {
        i = paramString1.length() - locala.EVZ.length();
        if ((i >= locala.EWa) && (i <= locala.EWb) && (paramString2.equalsIgnoreCase(locala.EVY)))
        {
          ad.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { locala.EVZ, locala.EVY, Integer.valueOf(locala.EWb), Integer.valueOf(locala.EWb) });
          paramString1 = locala.EVZ;
          AppMethodBeat.o(157761);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(157761);
    return null;
  }
  
  public static String kR(String paramString1, String paramString2)
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