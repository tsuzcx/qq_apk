package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bb
{
  public static bc Izi = null;
  
  public static String aSe(String paramString)
  {
    AppMethodBeat.i(157763);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    if (!bu.aSK(paramString).booleanValue())
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    new bb();
    String str1 = "86";
    Object localObject = paramString;
    if (paramString.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = lT(str2, null);
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
  
  public static String aSf(String paramString)
  {
    AppMethodBeat.i(157764);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157764);
      return "";
    }
    paramString = paramString.replaceAll("[\\.\\-\\ ]", "").trim();
    AppMethodBeat.o(157764);
    return paramString;
  }
  
  public static String aSg(String paramString)
  {
    AppMethodBeat.i(157765);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157765);
      return "";
    }
    paramString = paramString.replace("+", "");
    AppMethodBeat.o(157765);
    return paramString;
  }
  
  public static String aSh(String paramString)
  {
    AppMethodBeat.i(157766);
    if (bu.isNullOrNil(paramString))
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
  
  public static String apd(String paramString)
  {
    AppMethodBeat.i(157762);
    paramString = lT(paramString, null);
    AppMethodBeat.o(157762);
    return paramString;
  }
  
  private static String be(String paramString1, String paramString2, String paramString3)
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
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157768);
      return paramString2;
    }
    if (Izi == null) {
      Izi = new bc();
    }
    Iterator localIterator1 = Izi.Izj.iterator();
    bc.a locala;
    String str;
    bc.b localb;
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
            locala = (bc.a)localIterator1.next();
          } while ((locala.Izl == null) || (!paramString1.trim().toLowerCase().equals(locala.Izl.trim().toLowerCase())) || (locala.Izo == null));
          str = aSf(paramString2);
          if ((str != null) && (str.length() > locala.Izm))
          {
            AppMethodBeat.o(157768);
            return str;
          }
          localIterator2 = locala.Izo.iterator();
        }
        localb = (bc.b)localIterator2.next();
        if (!bu.isNullOrNil(localb.Izp)) {
          break label539;
        }
        if (locala.Izo.size() <= 1) {
          break;
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        m = str.length();
      } while (m > gr(localb.Izr, locala.Izn));
      while (localStringBuffer.toString().length() < locala.Izn) {
        localStringBuffer.append("0");
      }
      paramString1 = be(localb.Izr, localb.Izq, localStringBuffer.toString());
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
      while (paramString1.toString().length() < locala.Izn) {
        paramString1.append("0");
      }
      paramString1 = be(localb.Izr, localb.Izq, paramString1.toString());
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
    } while (!Pattern.compile(localb.Izp).matcher(str).lookingAt());
    paramString1 = new StringBuffer();
    paramString1.append(str);
    int m = str.length();
    while (paramString1.toString().length() < locala.Izn) {
      paramString1.append(str.charAt(m - 1));
    }
    paramString1 = be(localb.Izr, localb.Izq, paramString1.toString());
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
  
  private static int gr(String paramString, int paramInt)
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
  
  public static String lT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157761);
    paramString1 = aSf(paramString1).replace("+", "");
    if (Izi == null) {
      Izi = new bc();
    }
    int i;
    if (bu.isNullOrNil(paramString2))
    {
      paramString2 = Izi.Izj.iterator();
      do
      {
        do
        {
          if (!paramString2.hasNext()) {
            break;
          }
          localObject = (bc.a)paramString2.next();
        } while (!paramString1.startsWith(((bc.a)localObject).Izl));
        i = paramString1.length() - ((bc.a)localObject).Izl.length();
      } while ((i < ((bc.a)localObject).Izm) || (i > ((bc.a)localObject).Izn));
      ae.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { ((bc.a)localObject).Izl, ((bc.a)localObject).Izk, Integer.valueOf(((bc.a)localObject).Izn), Integer.valueOf(((bc.a)localObject).Izn) });
      paramString1 = ((bc.a)localObject).Izl;
      AppMethodBeat.o(157761);
      return paramString1;
    }
    Object localObject = Izi.Izj.iterator();
    while (((Iterator)localObject).hasNext())
    {
      bc.a locala = (bc.a)((Iterator)localObject).next();
      if (paramString1.startsWith(locala.Izl))
      {
        i = paramString1.length() - locala.Izl.length();
        if ((i >= locala.Izm) && (i <= locala.Izn) && (paramString2.equalsIgnoreCase(locala.Izk)))
        {
          ae.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { locala.Izl, locala.Izk, Integer.valueOf(locala.Izn), Integer.valueOf(locala.Izn) });
          paramString1 = locala.Izl;
          AppMethodBeat.o(157761);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(157761);
    return null;
  }
  
  public static String lU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157767);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bb
 * JD-Core Version:    0.7.0.1
 */