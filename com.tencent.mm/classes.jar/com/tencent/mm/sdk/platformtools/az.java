package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class az
{
  public static ba Gti = null;
  
  public static String aLb(String paramString)
  {
    AppMethodBeat.i(157763);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    if (!bs.aLH(paramString).booleanValue())
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    new az();
    String str1 = "86";
    Object localObject = paramString;
    if (paramString.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = ln(str2, null);
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
  
  public static String aLc(String paramString)
  {
    AppMethodBeat.i(157764);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157764);
      return "";
    }
    paramString = paramString.replaceAll("[\\.\\-\\ ]", "").trim();
    AppMethodBeat.o(157764);
    return paramString;
  }
  
  public static String aLd(String paramString)
  {
    AppMethodBeat.i(157765);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157765);
      return "";
    }
    paramString = paramString.replace("+", "");
    AppMethodBeat.o(157765);
    return paramString;
  }
  
  public static String aLe(String paramString)
  {
    AppMethodBeat.i(157766);
    if (bs.isNullOrNil(paramString))
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
  
  private static String aU(String paramString1, String paramString2, String paramString3)
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
  
  public static String ajo(String paramString)
  {
    AppMethodBeat.i(157762);
    paramString = ln(paramString, null);
    AppMethodBeat.o(157762);
    return paramString;
  }
  
  private static int fL(String paramString, int paramInt)
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
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157768);
      return paramString2;
    }
    if (Gti == null) {
      Gti = new ba();
    }
    Iterator localIterator1 = Gti.Gtj.iterator();
    ba.a locala;
    String str;
    ba.b localb;
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
            locala = (ba.a)localIterator1.next();
          } while ((locala.Gtl == null) || (!paramString1.trim().toLowerCase().equals(locala.Gtl.trim().toLowerCase())) || (locala.Gto == null));
          str = aLc(paramString2);
          if ((str != null) && (str.length() > locala.Gtm))
          {
            AppMethodBeat.o(157768);
            return str;
          }
          localIterator2 = locala.Gto.iterator();
        }
        localb = (ba.b)localIterator2.next();
        if (!bs.isNullOrNil(localb.Gtp)) {
          break label539;
        }
        if (locala.Gto.size() <= 1) {
          break;
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        m = str.length();
      } while (m > fL(localb.Gtr, locala.Gtn));
      while (localStringBuffer.toString().length() < locala.Gtn) {
        localStringBuffer.append("0");
      }
      paramString1 = aU(localb.Gtr, localb.Gtq, localStringBuffer.toString());
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
      while (paramString1.toString().length() < locala.Gtn) {
        paramString1.append("0");
      }
      paramString1 = aU(localb.Gtr, localb.Gtq, paramString1.toString());
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
    } while (!Pattern.compile(localb.Gtp).matcher(str).lookingAt());
    paramString1 = new StringBuffer();
    paramString1.append(str);
    int m = str.length();
    while (paramString1.toString().length() < locala.Gtn) {
      paramString1.append(str.charAt(m - 1));
    }
    paramString1 = aU(localb.Gtr, localb.Gtq, paramString1.toString());
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
  
  public static String ln(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157761);
    paramString1 = aLc(paramString1).replace("+", "");
    if (Gti == null) {
      Gti = new ba();
    }
    int i;
    if (bs.isNullOrNil(paramString2))
    {
      paramString2 = Gti.Gtj.iterator();
      do
      {
        do
        {
          if (!paramString2.hasNext()) {
            break;
          }
          localObject = (ba.a)paramString2.next();
        } while (!paramString1.startsWith(((ba.a)localObject).Gtl));
        i = paramString1.length() - ((ba.a)localObject).Gtl.length();
      } while ((i < ((ba.a)localObject).Gtm) || (i > ((ba.a)localObject).Gtn));
      ac.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { ((ba.a)localObject).Gtl, ((ba.a)localObject).Gtk, Integer.valueOf(((ba.a)localObject).Gtn), Integer.valueOf(((ba.a)localObject).Gtn) });
      paramString1 = ((ba.a)localObject).Gtl;
      AppMethodBeat.o(157761);
      return paramString1;
    }
    Object localObject = Gti.Gtj.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ba.a locala = (ba.a)((Iterator)localObject).next();
      if (paramString1.startsWith(locala.Gtl))
      {
        i = paramString1.length() - locala.Gtl.length();
        if ((i >= locala.Gtm) && (i <= locala.Gtn) && (paramString2.equalsIgnoreCase(locala.Gtk)))
        {
          ac.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { locala.Gtl, locala.Gtk, Integer.valueOf(locala.Gtn), Integer.valueOf(locala.Gtn) });
          paramString1 = locala.Gtl;
          AppMethodBeat.o(157761);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(157761);
    return null;
  }
  
  public static String lo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157767);
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.az
 * JD-Core Version:    0.7.0.1
 */