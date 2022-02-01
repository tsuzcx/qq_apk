package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneFormater
{
  private static final String TAG = "MicroMsg.PhoneFormater";
  public static PhoneFormaterConfig config = null;
  
  public static String countryCodeWithPlus(String paramString)
  {
    AppMethodBeat.i(157766);
    if (Util.isNullOrNil(paramString))
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
  
  public static String countryNameWithCode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157767);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157767);
      return "";
    }
    paramString1 = paramString1 + "（+" + paramString2 + "）";
    AppMethodBeat.o(157767);
    return paramString1;
  }
  
  public static String extractCountryCode(String paramString)
  {
    AppMethodBeat.i(157762);
    paramString = extractCountryCode(paramString, null);
    AppMethodBeat.o(157762);
    return paramString;
  }
  
  public static String extractCountryCode(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157761);
    paramString1 = pureNumber(paramString1).replace("+", "");
    if (config == null) {
      config = new PhoneFormaterConfig();
    }
    int i;
    if (Util.isNullOrNil(paramString2))
    {
      paramString2 = config.contryList.iterator();
      do
      {
        do
        {
          if (!paramString2.hasNext()) {
            break;
          }
          localObject = (PhoneFormaterConfig.Country)paramString2.next();
        } while (!paramString1.startsWith(((PhoneFormaterConfig.Country)localObject).countrycode));
        i = paramString1.length() - ((PhoneFormaterConfig.Country)localObject).countrycode.length();
      } while ((i < ((PhoneFormaterConfig.Country)localObject).minlen) || (i > ((PhoneFormaterConfig.Country)localObject).maxlen));
      Log.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { ((PhoneFormaterConfig.Country)localObject).countrycode, ((PhoneFormaterConfig.Country)localObject).isocode, Integer.valueOf(((PhoneFormaterConfig.Country)localObject).maxlen), Integer.valueOf(((PhoneFormaterConfig.Country)localObject).maxlen) });
      paramString1 = ((PhoneFormaterConfig.Country)localObject).countrycode;
      AppMethodBeat.o(157761);
      return paramString1;
    }
    Object localObject = config.contryList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PhoneFormaterConfig.Country localCountry = (PhoneFormaterConfig.Country)((Iterator)localObject).next();
      if (paramString1.startsWith(localCountry.countrycode))
      {
        i = paramString1.length() - localCountry.countrycode.length();
        if ((i >= localCountry.minlen) && (i <= localCountry.maxlen) && (paramString2.equalsIgnoreCase(localCountry.isocode)))
        {
          Log.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", new Object[] { localCountry.countrycode, localCountry.isocode, Integer.valueOf(localCountry.maxlen), Integer.valueOf(localCountry.maxlen) });
          paramString1 = localCountry.countrycode;
          AppMethodBeat.o(157761);
          return paramString1;
        }
      }
    }
    AppMethodBeat.o(157761);
    return null;
  }
  
  private String format(String paramString1, String paramString2, String paramString3)
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
  
  public static String formatMobileString(String paramString)
  {
    AppMethodBeat.i(157763);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    if (!Util.isPhoneNumber(paramString).booleanValue())
    {
      AppMethodBeat.o(157763);
      return paramString;
    }
    PhoneFormater localPhoneFormater = new PhoneFormater();
    String str1 = "86";
    Object localObject = paramString;
    if (paramString.startsWith("+"))
    {
      String str2 = paramString.replace("+", "");
      paramString = extractCountryCode(str2);
      str1 = paramString;
      localObject = str2;
      if (paramString != null)
      {
        localObject = str2.substring(paramString.length());
        str1 = paramString;
      }
    }
    paramString = localPhoneFormater.formatNumber(str1, (String)localObject);
    AppMethodBeat.o(157763);
    return paramString;
  }
  
  private int getMatchLenght(String paramString, int paramInt)
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
  
  public static String pureCountryCode(String paramString)
  {
    AppMethodBeat.i(157765);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157765);
      return "";
    }
    paramString = paramString.replace("+", "");
    AppMethodBeat.o(157765);
    return paramString;
  }
  
  public static String pureCountryName(String paramString)
  {
    AppMethodBeat.i(230366);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(230366);
      return "";
    }
    int i = paramString.indexOf("（+");
    if (i >= 0)
    {
      paramString = paramString.substring(0, i);
      AppMethodBeat.o(230366);
      return paramString;
    }
    AppMethodBeat.o(230366);
    return paramString;
  }
  
  public static String pureNumber(String paramString)
  {
    AppMethodBeat.i(157764);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(157764);
      return "";
    }
    paramString = paramString.replaceAll("[\\.\\-\\ ]", "").trim();
    AppMethodBeat.o(157764);
    return paramString;
  }
  
  public String formatNumber(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157768);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(157768);
      return paramString2;
    }
    if (config == null) {
      config = new PhoneFormaterConfig();
    }
    Iterator localIterator1 = config.contryList.iterator();
    PhoneFormaterConfig.Country localCountry;
    String str;
    PhoneFormaterConfig.Format localFormat;
    int n;
    int k;
    label556:
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
            localCountry = (PhoneFormaterConfig.Country)localIterator1.next();
          } while ((localCountry.countrycode == null) || (!paramString1.trim().toLowerCase().equals(localCountry.countrycode.trim().toLowerCase())) || (localCountry.formatList == null));
          str = pureNumber(paramString2);
          if ((str != null) && (str.length() > localCountry.minlen))
          {
            AppMethodBeat.o(157768);
            return str;
          }
          localIterator2 = localCountry.formatList.iterator();
        }
        localFormat = (PhoneFormaterConfig.Format)localIterator2.next();
        if (!Util.isNullOrNil(localFormat.leading)) {
          break label556;
        }
        if (localCountry.formatList.size() <= 1) {
          break;
        }
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        m = str.length();
      } while (m > getMatchLenght(localFormat.formatregex, localCountry.maxlen));
      while (localStringBuffer.toString().length() < localCountry.maxlen) {
        localStringBuffer.append("0");
      }
      paramString1 = format(localFormat.formatregex, localFormat.pattern, localStringBuffer.toString());
      j = 0;
      i = 0;
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
      while (paramString1.toString().length() < localCountry.maxlen) {
        paramString1.append("0");
      }
      paramString1 = format(localFormat.formatregex, localFormat.pattern, paramString1.toString());
      j = 0;
      i = 0;
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
    } while (!Pattern.compile(localFormat.leading).matcher(str).lookingAt());
    paramString1 = new StringBuffer();
    paramString1.append(str);
    int m = str.length();
    while (paramString1.toString().length() < localCountry.maxlen) {
      paramString1.append(str.charAt(m - 1));
    }
    paramString1 = format(localFormat.formatregex, localFormat.pattern, paramString1.toString());
    int j = 0;
    int i = 0;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.PhoneFormater
 * JD-Core Version:    0.7.0.1
 */