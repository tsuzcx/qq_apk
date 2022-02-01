package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class ad
{
  public static Locale Ixw;
  
  static
  {
    AppMethodBeat.i(125269);
    if (Build.VERSION.SDK_INT < 24) {}
    for (Ixw = Locale.getDefault();; Ixw = LocaleList.getDefault().get(0))
    {
      Locale.setDefault(Ixw);
      AppMethodBeat.o(125269);
      return;
    }
  }
  
  public static void a(Context paramContext, Locale paramLocale)
  {
    AppMethodBeat.i(125257);
    try
    {
      paramContext = paramContext.getResources();
      Configuration localConfiguration = paramContext.getConfiguration();
      DisplayMetrics localDisplayMetrics = paramContext.getDisplayMetrics();
      localConfiguration.locale = paramLocale;
      paramContext.updateConfiguration(localConfiguration, localDisplayMetrics);
      Resources.getSystem().updateConfiguration(localConfiguration, localDisplayMetrics);
      AppMethodBeat.o(125257);
      return;
    }
    catch (Exception paramContext)
    {
      ae.printErrStackTrace("MicroMsg.LocaleUtil", paramContext, "updateApplicationResourceLocale err~~~", new Object[0]);
      AppMethodBeat.o(125257);
    }
  }
  
  public static Locale aRN(String paramString)
  {
    AppMethodBeat.i(125259);
    if (paramString.equals("zh_TW"))
    {
      paramString = Locale.TAIWAN;
      AppMethodBeat.o(125259);
      return paramString;
    }
    if (paramString.equals("zh_HK"))
    {
      paramString = new Locale("zh", "HK");
      AppMethodBeat.o(125259);
      return paramString;
    }
    if (paramString.equals("en"))
    {
      paramString = Locale.ENGLISH;
      AppMethodBeat.o(125259);
      return paramString;
    }
    if (paramString.equals("zh_CN"))
    {
      paramString = Locale.CHINA;
      AppMethodBeat.o(125259);
      return paramString;
    }
    if ((paramString.equalsIgnoreCase("th")) || (paramString.equalsIgnoreCase("id")) || (paramString.equalsIgnoreCase("in")) || (paramString.equalsIgnoreCase("vi")) || (paramString.equalsIgnoreCase("pt")) || (paramString.equalsIgnoreCase("es")) || (paramString.equalsIgnoreCase("ru")) || (paramString.equalsIgnoreCase("ar")) || (paramString.equalsIgnoreCase("ja")) || (paramString.equalsIgnoreCase("it")) || (paramString.equalsIgnoreCase("ko")) || (paramString.equalsIgnoreCase("ms")) || (paramString.equalsIgnoreCase("tr")) || (paramString.equalsIgnoreCase("de")) || (paramString.equalsIgnoreCase("fr")) || (paramString.equalsIgnoreCase("my")) || (paramString.equalsIgnoreCase("lo")))
    {
      paramString = new Locale(paramString);
      AppMethodBeat.o(125259);
      return paramString;
    }
    ae.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = ".concat(String.valueOf(paramString)));
    paramString = Locale.ENGLISH;
    AppMethodBeat.o(125259);
    return paramString;
  }
  
  private static String aRO(String paramString)
  {
    AppMethodBeat.i(125261);
    String str1 = Locale.getDefault().getLanguage().trim();
    String str2 = str1 + "_" + Locale.getDefault().getCountry().trim();
    if (str1.equals("en"))
    {
      AppMethodBeat.o(125261);
      return str1;
    }
    if (str2.equals("zh_TW"))
    {
      AppMethodBeat.o(125261);
      return "zh_TW";
    }
    if (str2.equals("zh_HK"))
    {
      AppMethodBeat.o(125261);
      return "zh_HK";
    }
    if (str2.equals("zh_CN"))
    {
      AppMethodBeat.o(125261);
      return "zh_CN";
    }
    if (str1.equals("th"))
    {
      AppMethodBeat.o(125261);
      return "th";
    }
    if (str1.equals("id"))
    {
      AppMethodBeat.o(125261);
      return "id";
    }
    if (str1.equals("in"))
    {
      AppMethodBeat.o(125261);
      return "id";
    }
    if (str1.equals("vi"))
    {
      AppMethodBeat.o(125261);
      return "vi";
    }
    if (str1.equals("pt"))
    {
      AppMethodBeat.o(125261);
      return "pt";
    }
    if (str1.equals("es"))
    {
      AppMethodBeat.o(125261);
      return "es";
    }
    if (str1.equals("ru"))
    {
      AppMethodBeat.o(125261);
      return "ru";
    }
    if (str1.equals("ar"))
    {
      AppMethodBeat.o(125261);
      return "ar";
    }
    if (str1.equals("ja"))
    {
      AppMethodBeat.o(125261);
      return "ja";
    }
    if (str1.equals("it"))
    {
      AppMethodBeat.o(125261);
      return "it";
    }
    if (str1.equals("ko"))
    {
      AppMethodBeat.o(125261);
      return "ko";
    }
    if (str1.equals("ms"))
    {
      AppMethodBeat.o(125261);
      return "ms";
    }
    if (str1.equals("tr"))
    {
      AppMethodBeat.o(125261);
      return "tr";
    }
    if (str1.equals("de"))
    {
      AppMethodBeat.o(125261);
      return "de";
    }
    if (str1.equals("fr"))
    {
      AppMethodBeat.o(125261);
      return "fr";
    }
    if (str1.equals("my"))
    {
      AppMethodBeat.o(125261);
      return "my";
    }
    if (str1.equals("lo"))
    {
      AppMethodBeat.o(125261);
      return "lo";
    }
    AppMethodBeat.o(125261);
    return paramString;
  }
  
  public static void c(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(125265);
    if (paramSharedPreferences.edit().putString("language_key", paramString).commit())
    {
      bq.setProperty("language_key", paramString);
      ae.w("MicroMsg.LocaleUtil", "save application lang as:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(125265);
      return;
    }
    ae.e("MicroMsg.LocaleUtil", "saving application lang failed");
    AppMethodBeat.o(125265);
  }
  
  public static String d(Locale paramLocale)
  {
    AppMethodBeat.i(125258);
    String str = paramLocale.getLanguage();
    if (str.equals("zh"))
    {
      paramLocale = str + "_" + paramLocale.getCountry().toUpperCase();
      AppMethodBeat.o(125258);
      return paramLocale;
    }
    AppMethodBeat.o(125258);
    return str;
  }
  
  public static String f(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(125263);
    paramSharedPreferences = bu.nullAsNil(paramSharedPreferences.getString("language_key", null));
    if ((paramSharedPreferences.length() > 0) && (!paramSharedPreferences.equals("language_default")))
    {
      bq.setProperty("language_key", paramSharedPreferences);
      AppMethodBeat.o(125263);
      return paramSharedPreferences;
    }
    paramSharedPreferences = aRO("en");
    bq.setProperty("language_key", paramSharedPreferences);
    AppMethodBeat.o(125263);
    return paramSharedPreferences;
  }
  
  public static boolean foi()
  {
    AppMethodBeat.i(125254);
    String str = fom();
    if ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK")))
    {
      AppMethodBeat.o(125254);
      return true;
    }
    AppMethodBeat.o(125254);
    return false;
  }
  
  public static boolean foj()
  {
    AppMethodBeat.i(125255);
    if (fom().equals("zh_CN"))
    {
      AppMethodBeat.o(125255);
      return true;
    }
    AppMethodBeat.o(125255);
    return false;
  }
  
  public static boolean fok()
  {
    AppMethodBeat.i(125256);
    if ((fom().equals("zh_TW")) || (fom().equals("zh_HK")))
    {
      AppMethodBeat.o(125256);
      return true;
    }
    AppMethodBeat.o(125256);
    return false;
  }
  
  public static String fol()
  {
    AppMethodBeat.i(125260);
    String str = Locale.getDefault().getCountry().trim();
    AppMethodBeat.o(125260);
    return str;
  }
  
  public static String fom()
  {
    AppMethodBeat.i(125262);
    String str = bu.nullAsNil(bq.getProperty("language_key"));
    if ((str.length() > 0) && (!str.equals("language_default")))
    {
      AppMethodBeat.o(125262);
      return str;
    }
    str = aRO("en");
    AppMethodBeat.o(125262);
    return str;
  }
  
  public static String g(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(125264);
    paramSharedPreferences = bu.nullAsNil(paramSharedPreferences.getString("language_key", null));
    if (!bu.isNullOrNil(paramSharedPreferences))
    {
      AppMethodBeat.o(125264);
      return paramSharedPreferences;
    }
    AppMethodBeat.o(125264);
    return "language_default";
  }
  
  public static String iR(Context paramContext)
  {
    AppMethodBeat.i(125266);
    paramContext = g(paramContext.getSharedPreferences(ak.fow(), 0));
    String str = fom();
    if (paramContext.equalsIgnoreCase("language_default")) {
      paramContext = str;
    }
    for (;;)
    {
      AppMethodBeat.o(125266);
      return paramContext;
    }
  }
  
  public static String iS(Context paramContext)
  {
    AppMethodBeat.i(125267);
    String[] arrayOfString1 = paramContext.getResources().getStringArray(2130903056);
    String str = g(paramContext.getSharedPreferences(ak.fow(), 0));
    if (str == null)
    {
      paramContext = paramContext.getString(2131755800);
      AppMethodBeat.o(125267);
      return paramContext;
    }
    String[] arrayOfString2 = ac.yXo;
    int k = arrayOfString2.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (arrayOfString2[j].equals(str))
      {
        paramContext = arrayOfString1[i];
        AppMethodBeat.o(125267);
        return paramContext;
      }
      j += 1;
      i += 1;
    }
    paramContext = paramContext.getString(2131755800);
    AppMethodBeat.o(125267);
    return paramContext;
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    AppMethodBeat.i(125268);
    Object localObject = f(paramContext.getSharedPreferences(ak.fow(), 0));
    if (((String)localObject).equals("language_default"))
    {
      a(paramContext, Locale.ENGLISH);
      paramContext = Locale.getDefault();
      AppMethodBeat.o(125268);
      return paramContext;
    }
    localObject = aRN((String)localObject);
    a(paramContext, (Locale)localObject);
    AppMethodBeat.o(125268);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ad
 * JD-Core Version:    0.7.0.1
 */