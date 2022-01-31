package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import java.util.Locale;

public final class x
{
  public static Locale ueU;
  
  static
  {
    if (Build.VERSION.SDK_INT < 24) {}
    for (ueU = Locale.getDefault();; ueU = LocaleList.getDefault().get(0))
    {
      Locale.setDefault(ueU);
      return;
    }
  }
  
  public static boolean Zh(String paramString)
  {
    if (bk.bl(paramString)) {}
    while ((!paramString.equalsIgnoreCase("zh_TW")) && (!paramString.equalsIgnoreCase("zh_HK")) && (!paramString.equalsIgnoreCase("zh_CN")) && (!paramString.equalsIgnoreCase("en")) && (!paramString.equalsIgnoreCase("th")) && (!paramString.equals("id")) && (!paramString.equals("vi")) && (!paramString.equalsIgnoreCase("pt")) && (!paramString.equalsIgnoreCase("es")) && (!paramString.equalsIgnoreCase("ru")) && (!paramString.equalsIgnoreCase("ar")) && (!paramString.equalsIgnoreCase("ja")) && (!paramString.equalsIgnoreCase("it")) && (!paramString.equalsIgnoreCase("ko")) && (!paramString.equalsIgnoreCase("ms")) && (!paramString.equalsIgnoreCase("tr")) && (!paramString.equalsIgnoreCase("de")) && (!paramString.equalsIgnoreCase("fr")) && (!paramString.equalsIgnoreCase("my")) && (!paramString.equalsIgnoreCase("lo"))) {
      return false;
    }
    return true;
  }
  
  public static Locale Zi(String paramString)
  {
    if (paramString.equals("zh_TW")) {
      return Locale.TAIWAN;
    }
    if (paramString.equals("zh_HK")) {
      return new Locale("zh", "HK");
    }
    if (paramString.equals("en")) {
      return Locale.ENGLISH;
    }
    if (paramString.equals("zh_CN")) {
      return Locale.CHINA;
    }
    if ((paramString.equalsIgnoreCase("th")) || (paramString.equalsIgnoreCase("id")) || (paramString.equalsIgnoreCase("vi")) || (paramString.equalsIgnoreCase("pt")) || (paramString.equalsIgnoreCase("es")) || (paramString.equalsIgnoreCase("ru")) || (paramString.equalsIgnoreCase("ar")) || (paramString.equalsIgnoreCase("ja")) || (paramString.equalsIgnoreCase("it")) || (paramString.equalsIgnoreCase("ko")) || (paramString.equalsIgnoreCase("ms")) || (paramString.equalsIgnoreCase("tr")) || (paramString.equalsIgnoreCase("de")) || (paramString.equalsIgnoreCase("fr")) || (paramString.equalsIgnoreCase("my")) || (paramString.equalsIgnoreCase("lo"))) {
      return new Locale(paramString);
    }
    y.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = " + paramString);
    return Locale.ENGLISH;
  }
  
  private static String Zj(String paramString)
  {
    String str1 = Locale.getDefault().getLanguage().trim();
    String str2 = str1 + "_" + Locale.getDefault().getCountry().trim();
    if (str1.equals("en")) {
      paramString = str1;
    }
    do
    {
      return paramString;
      if (str2.equals("zh_TW")) {
        return "zh_TW";
      }
      if (str2.equals("zh_HK")) {
        return "zh_HK";
      }
      if (str2.equals("zh_CN")) {
        return "zh_CN";
      }
      if (str1.equals("th")) {
        return "th";
      }
      if (str1.equals("id")) {
        return "id";
      }
      if (str2.equals("in_ID")) {
        return "id";
      }
      if (str1.equals("vi")) {
        return "vi";
      }
      if (str1.equals("pt")) {
        return "pt";
      }
      if (str1.equals("es")) {
        return "es";
      }
      if (str1.equals("ru")) {
        return "ru";
      }
      if (str1.equals("ar")) {
        return "ar";
      }
      if (str1.equals("ja")) {
        return "ja";
      }
      if (str1.equals("it")) {
        return "it";
      }
      if (str1.equals("ko")) {
        return "ko";
      }
      if (str1.equals("ms")) {
        return "ms";
      }
      if (str1.equals("tr")) {
        return "tr";
      }
      if (str1.equals("de")) {
        return "de";
      }
      if (str1.equals("fr")) {
        return "fr";
      }
      if (str1.equals("my")) {
        return "my";
      }
    } while (!str1.equals("lo"));
    return "lo";
  }
  
  public static void a(Context paramContext, Locale paramLocale)
  {
    paramContext = paramContext.getResources();
    Configuration localConfiguration = paramContext.getConfiguration();
    DisplayMetrics localDisplayMetrics = paramContext.getDisplayMetrics();
    localConfiguration.locale = paramLocale;
    paramContext.updateConfiguration(localConfiguration, localDisplayMetrics);
    Resources.getSystem().updateConfiguration(localConfiguration, localDisplayMetrics);
  }
  
  public static void a(SharedPreferences paramSharedPreferences, String paramString)
  {
    if (paramSharedPreferences.edit().putString("language_key", paramString).commit())
    {
      bg.setProperty("language_key", paramString);
      y.w("MicroMsg.LocaleUtil", "save application lang as:" + paramString);
      return;
    }
    y.e("MicroMsg.LocaleUtil", "saving application lang failed");
  }
  
  public static String c(Locale paramLocale)
  {
    String str2 = paramLocale.getLanguage();
    String str1 = str2;
    if (str2.equals("zh")) {
      str1 = str2 + "_" + paramLocale.getCountry().toUpperCase();
    }
    return str1;
  }
  
  public static boolean cqF()
  {
    String str = cqJ();
    return (str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK"));
  }
  
  public static boolean cqG()
  {
    return cqJ().equals("zh_CN");
  }
  
  public static boolean cqH()
  {
    return (cqJ().equals("zh_TW")) || (cqJ().equals("zh_HK"));
  }
  
  public static String cqI()
  {
    return Locale.getDefault().getCountry().trim();
  }
  
  public static String cqJ()
  {
    String str = bk.pm(bg.getProperty("language_key"));
    if ((str.length() > 0) && (!str.equals("language_default"))) {
      return str;
    }
    return Zj("en");
  }
  
  public static String d(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = bk.pm(paramSharedPreferences.getString("language_key", null));
    if ((paramSharedPreferences.length() > 0) && (!paramSharedPreferences.equals("language_default")))
    {
      bg.setProperty("language_key", paramSharedPreferences);
      return paramSharedPreferences;
    }
    paramSharedPreferences = Zj("en");
    bg.setProperty("language_key", paramSharedPreferences);
    return paramSharedPreferences;
  }
  
  public static String e(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = bk.pm(paramSharedPreferences.getString("language_key", null));
    if (!bk.bl(paramSharedPreferences)) {
      return paramSharedPreferences;
    }
    return "language_default";
  }
  
  public static String fB(Context paramContext)
  {
    paramContext = e(paramContext.getSharedPreferences(ae.cqR(), 0));
    String str = cqJ();
    if (paramContext.equalsIgnoreCase("language_default")) {
      return str;
    }
    return paramContext;
  }
  
  public static String g(Context paramContext, int paramInt1, int paramInt2)
  {
    String[] arrayOfString1 = paramContext.getResources().getStringArray(paramInt1);
    String str = e(paramContext.getSharedPreferences(ae.cqR(), 0));
    if (str == null) {
      return paramContext.getString(paramInt2);
    }
    String[] arrayOfString2 = w.nUs;
    int j = arrayOfString2.length;
    int i = 0;
    paramInt1 = 0;
    while (i < j)
    {
      if (arrayOfString2[i].equals(str)) {
        return arrayOfString1[paramInt1];
      }
      i += 1;
      paramInt1 += 1;
    }
    return paramContext.getString(paramInt2);
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    Object localObject = d(paramContext.getSharedPreferences(ae.cqR(), 0));
    if (((String)localObject).equals("language_default"))
    {
      a(paramContext, Locale.ENGLISH);
      return Locale.getDefault();
    }
    localObject = Zi((String)localObject);
    a(paramContext, (Locale)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.x
 * JD-Core Version:    0.7.0.1
 */