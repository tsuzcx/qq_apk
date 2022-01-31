package com.tencent.mm.sdk.platformtools;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ar
{
  public static as uhe = null;
  
  public static String Ga(String paramString)
  {
    return ge(paramString, null);
  }
  
  public static String Zs(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (!bk.aaa(paramString).booleanValue()) {
      return paramString;
    }
    new ar();
    String str1 = "86";
    Object localObject = paramString;
    if (paramString.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = ge(str2, null);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    return formatNumber(str1, (String)localObject);
  }
  
  public static String Zt(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    return paramString.replaceAll("[\\.\\-\\ ]", "").trim();
  }
  
  public static String Zu(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    return paramString.replace("+", "");
  }
  
  public static String Zv(String paramString)
  {
    String str;
    if (bk.bl(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.startsWith("+"));
    return "+" + paramString;
  }
  
  private static String am(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = Pattern.compile(paramString1).matcher(paramString3);
    if (paramString1.find()) {
      paramString3 = paramString1.replaceAll(paramString2);
    }
    return paramString3;
  }
  
  private static int dp(String paramString, int paramInt)
  {
    Pattern localPattern = Pattern.compile(paramString);
    paramString = "1";
    int i = 0;
    while ((i < paramInt) && (!localPattern.matcher(paramString).find()))
    {
      paramString = paramString + "1";
      i += 1;
    }
    return i + 1;
  }
  
  public static String formatNumber(String paramString1, String paramString2)
  {
    Object localObject;
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      localObject = paramString2;
      return localObject;
    }
    if (uhe == null) {
      uhe = new as();
    }
    Iterator localIterator1 = uhe.uhf.iterator();
    as.a locala;
    String str;
    int n;
    int k;
    label371:
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
            locala = (as.a)localIterator1.next();
          } while ((locala.uhh == null) || (!paramString1.trim().toLowerCase().equals(locala.uhh.trim().toLowerCase())) || (locala.uhk == null));
          str = Zt(paramString2);
          if (str != null)
          {
            localObject = str;
            if (str.length() > locala.uhi) {
              break;
            }
          }
          localIterator2 = locala.uhk.iterator();
        }
        localObject = (as.b)localIterator2.next();
        if (!bk.bl(((as.b)localObject).uhl)) {
          break label520;
        }
        if (locala.uhk.size() <= 1) {
          break label371;
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        m = str.length();
      } while (m > dp(((as.b)localObject).uhn, locala.uhj));
      while (localStringBuffer.toString().length() < locala.uhj) {
        localStringBuffer.append("0");
      }
      paramString1 = am(((as.b)localObject).uhn, ((as.b)localObject).uhm, localStringBuffer.toString());
      i = 0;
      j = 0;
      for (;;)
      {
        localObject = paramString1;
        if (i >= paramString1.length()) {
          break;
        }
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
      paramString1 = new StringBuffer();
      paramString1.append(str);
      m = str.length();
      while (paramString1.toString().length() < locala.uhj) {
        paramString1.append("0");
      }
      paramString1 = am(((as.b)localObject).uhn, ((as.b)localObject).uhm, paramString1.toString());
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
      return paramString1;
    } while (!Pattern.compile(((as.b)localObject).uhl).matcher(str).lookingAt());
    label520:
    paramString1 = new StringBuffer();
    paramString1.append(str);
    int m = str.length();
    while (paramString1.toString().length() < locala.uhj) {
      paramString1.append(str.charAt(m - 1));
    }
    paramString1 = am(((as.b)localObject).uhn, ((as.b)localObject).uhm, paramString1.toString());
    int i = 0;
    int j = 0;
    for (;;)
    {
      localObject = paramString1;
      if (i >= paramString1.length()) {
        break;
      }
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
    return paramString2;
  }
  
  public static String ge(String paramString1, String paramString2)
  {
    paramString1 = Zt(paramString1).replace("+", "");
    if (uhe == null) {
      uhe = new as();
    }
    int i;
    if (bk.bl(paramString2))
    {
      paramString2 = uhe.uhf.iterator();
      do
      {
        do
        {
          if (!paramString2.hasNext()) {
            break;
          }
          localObject = (as.a)paramString2.next();
        } while (!paramString1.startsWith(((as.a)localObject).uhh));
        i = paramString1.length() - ((as.a)localObject).uhh.length();
      } while ((i < ((as.a)localObject).uhi) || (i > ((as.a)localObject).uhj));
      y.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { ((as.a)localObject).uhh, ((as.a)localObject).uhg, Integer.valueOf(((as.a)localObject).uhj), Integer.valueOf(((as.a)localObject).uhj) });
      return ((as.a)localObject).uhh;
    }
    Object localObject = uhe.uhf.iterator();
    while (((Iterator)localObject).hasNext())
    {
      as.a locala = (as.a)((Iterator)localObject).next();
      if (paramString1.startsWith(locala.uhh))
      {
        i = paramString1.length() - locala.uhh.length();
        if ((i >= locala.uhi) && (i <= locala.uhj) && (paramString2.equalsIgnoreCase(locala.uhg)))
        {
          y.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { locala.uhh, locala.uhg, Integer.valueOf(locala.uhj), Integer.valueOf(locala.uhj) });
          return locala.uhh;
        }
      }
    }
    return null;
  }
  
  public static String gf(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return "";
    }
    return paramString1 + "（+" + paramString2 + "）";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ar
 * JD-Core Version:    0.7.0.1
 */