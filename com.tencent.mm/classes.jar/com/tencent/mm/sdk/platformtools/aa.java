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

public final class aa
{
  public static Locale ynv;
  
  static
  {
    AppMethodBeat.i(115235);
    if (Build.VERSION.SDK_INT < 24) {}
    for (ynv = Locale.getDefault();; ynv = LocaleList.getDefault().get(0))
    {
      Locale.setDefault(ynv);
      AppMethodBeat.o(115235);
      return;
    }
  }
  
  public static void a(Context paramContext, Locale paramLocale)
  {
    AppMethodBeat.i(115223);
    try
    {
      paramContext = paramContext.getResources();
      Configuration localConfiguration = paramContext.getConfiguration();
      DisplayMetrics localDisplayMetrics = paramContext.getDisplayMetrics();
      localConfiguration.locale = paramLocale;
      paramContext.updateConfiguration(localConfiguration, localDisplayMetrics);
      Resources.getSystem().updateConfiguration(localConfiguration, localDisplayMetrics);
      AppMethodBeat.o(115223);
      return;
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.LocaleUtil", paramContext, "updateApplicationResourceLocale err~~~", new Object[0]);
      AppMethodBeat.o(115223);
    }
  }
  
  public static boolean apf(String paramString)
  {
    AppMethodBeat.i(115219);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(115219);
      return false;
    }
    if ((paramString.equalsIgnoreCase("zh_TW")) || (paramString.equalsIgnoreCase("zh_HK")) || (paramString.equalsIgnoreCase("zh_CN")) || (paramString.equalsIgnoreCase("en")) || (paramString.equalsIgnoreCase("th")) || (paramString.equals("id")) || (paramString.equals("in")) || (paramString.equals("vi")) || (paramString.equalsIgnoreCase("pt")) || (paramString.equalsIgnoreCase("es")) || (paramString.equalsIgnoreCase("ru")) || (paramString.equalsIgnoreCase("ar")) || (paramString.equalsIgnoreCase("ja")) || (paramString.equalsIgnoreCase("it")) || (paramString.equalsIgnoreCase("ko")) || (paramString.equalsIgnoreCase("ms")) || (paramString.equalsIgnoreCase("tr")) || (paramString.equalsIgnoreCase("de")) || (paramString.equalsIgnoreCase("fr")) || (paramString.equalsIgnoreCase("my")) || (paramString.equalsIgnoreCase("lo")))
    {
      AppMethodBeat.o(115219);
      return true;
    }
    AppMethodBeat.o(115219);
    return false;
  }
  
  public static Locale apg(String paramString)
  {
    AppMethodBeat.i(115225);
    if (paramString.equals("zh_TW"))
    {
      paramString = Locale.TAIWAN;
      AppMethodBeat.o(115225);
      return paramString;
    }
    if (paramString.equals("zh_HK"))
    {
      paramString = new Locale("zh", "HK");
      AppMethodBeat.o(115225);
      return paramString;
    }
    if (paramString.equals("en"))
    {
      paramString = Locale.ENGLISH;
      AppMethodBeat.o(115225);
      return paramString;
    }
    if (paramString.equals("zh_CN"))
    {
      paramString = Locale.CHINA;
      AppMethodBeat.o(115225);
      return paramString;
    }
    if ((paramString.equalsIgnoreCase("th")) || (paramString.equalsIgnoreCase("id")) || (paramString.equalsIgnoreCase("in")) || (paramString.equalsIgnoreCase("vi")) || (paramString.equalsIgnoreCase("pt")) || (paramString.equalsIgnoreCase("es")) || (paramString.equalsIgnoreCase("ru")) || (paramString.equalsIgnoreCase("ar")) || (paramString.equalsIgnoreCase("ja")) || (paramString.equalsIgnoreCase("it")) || (paramString.equalsIgnoreCase("ko")) || (paramString.equalsIgnoreCase("ms")) || (paramString.equalsIgnoreCase("tr")) || (paramString.equalsIgnoreCase("de")) || (paramString.equalsIgnoreCase("fr")) || (paramString.equalsIgnoreCase("my")) || (paramString.equalsIgnoreCase("lo")))
    {
      paramString = new Locale(paramString);
      AppMethodBeat.o(115225);
      return paramString;
    }
    ab.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = ".concat(String.valueOf(paramString)));
    paramString = Locale.ENGLISH;
    AppMethodBeat.o(115225);
    return paramString;
  }
  
  private static String aph(String paramString)
  {
    AppMethodBeat.i(115227);
    String str1 = Locale.getDefault().getLanguage().trim();
    String str2 = str1 + "_" + Locale.getDefault().getCountry().trim();
    if (str1.equals("en"))
    {
      AppMethodBeat.o(115227);
      return str1;
    }
    if (str2.equals("zh_TW"))
    {
      AppMethodBeat.o(115227);
      return "zh_TW";
    }
    if (str2.equals("zh_HK"))
    {
      AppMethodBeat.o(115227);
      return "zh_HK";
    }
    if (str2.equals("zh_CN"))
    {
      AppMethodBeat.o(115227);
      return "zh_CN";
    }
    if (str1.equals("th"))
    {
      AppMethodBeat.o(115227);
      return "th";
    }
    if (str1.equals("id"))
    {
      AppMethodBeat.o(115227);
      return "id";
    }
    if (str1.equals("in"))
    {
      AppMethodBeat.o(115227);
      return "id";
    }
    if (str1.equals("vi"))
    {
      AppMethodBeat.o(115227);
      return "vi";
    }
    if (str1.equals("pt"))
    {
      AppMethodBeat.o(115227);
      return "pt";
    }
    if (str1.equals("es"))
    {
      AppMethodBeat.o(115227);
      return "es";
    }
    if (str1.equals("ru"))
    {
      AppMethodBeat.o(115227);
      return "ru";
    }
    if (str1.equals("ar"))
    {
      AppMethodBeat.o(115227);
      return "ar";
    }
    if (str1.equals("ja"))
    {
      AppMethodBeat.o(115227);
      return "ja";
    }
    if (str1.equals("it"))
    {
      AppMethodBeat.o(115227);
      return "it";
    }
    if (str1.equals("ko"))
    {
      AppMethodBeat.o(115227);
      return "ko";
    }
    if (str1.equals("ms"))
    {
      AppMethodBeat.o(115227);
      return "ms";
    }
    if (str1.equals("tr"))
    {
      AppMethodBeat.o(115227);
      return "tr";
    }
    if (str1.equals("de"))
    {
      AppMethodBeat.o(115227);
      return "de";
    }
    if (str1.equals("fr"))
    {
      AppMethodBeat.o(115227);
      return "fr";
    }
    if (str1.equals("my"))
    {
      AppMethodBeat.o(115227);
      return "my";
    }
    if (str1.equals("lo"))
    {
      AppMethodBeat.o(115227);
      return "lo";
    }
    AppMethodBeat.o(115227);
    return paramString;
  }
  
  public static String c(Locale paramLocale)
  {
    AppMethodBeat.i(155675);
    String str = paramLocale.getLanguage();
    if (str.equals("zh"))
    {
      paramLocale = str + "_" + paramLocale.getCountry().toUpperCase();
      AppMethodBeat.o(155675);
      return paramLocale;
    }
    AppMethodBeat.o(155675);
    return str;
  }
  
  public static void c(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(115231);
    if (paramSharedPreferences.edit().putString("language_key", paramString).commit())
    {
      bk.setProperty("language_key", paramString);
      ab.w("MicroMsg.LocaleUtil", "save application lang as:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(115231);
      return;
    }
    ab.e("MicroMsg.LocaleUtil", "saving application lang failed");
    AppMethodBeat.o(115231);
  }
  
  public static boolean dsC()
  {
    AppMethodBeat.i(115220);
    String str = dsG();
    if ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK")))
    {
      AppMethodBeat.o(115220);
      return true;
    }
    AppMethodBeat.o(115220);
    return false;
  }
  
  public static boolean dsD()
  {
    AppMethodBeat.i(115221);
    if (dsG().equals("zh_CN"))
    {
      AppMethodBeat.o(115221);
      return true;
    }
    AppMethodBeat.o(115221);
    return false;
  }
  
  public static boolean dsE()
  {
    AppMethodBeat.i(115222);
    if ((dsG().equals("zh_TW")) || (dsG().equals("zh_HK")))
    {
      AppMethodBeat.o(115222);
      return true;
    }
    AppMethodBeat.o(115222);
    return false;
  }
  
  public static String dsF()
  {
    AppMethodBeat.i(115226);
    String str = Locale.getDefault().getCountry().trim();
    AppMethodBeat.o(115226);
    return str;
  }
  
  public static String dsG()
  {
    AppMethodBeat.i(115228);
    String str = bo.nullAsNil(bk.getProperty("language_key"));
    if ((str.length() > 0) && (!str.equals("language_default")))
    {
      AppMethodBeat.o(115228);
      return str;
    }
    str = aph("en");
    AppMethodBeat.o(115228);
    return str;
  }
  
  public static String f(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115229);
    paramSharedPreferences = bo.nullAsNil(paramSharedPreferences.getString("language_key", null));
    if ((paramSharedPreferences.length() > 0) && (!paramSharedPreferences.equals("language_default")))
    {
      bk.setProperty("language_key", paramSharedPreferences);
      AppMethodBeat.o(115229);
      return paramSharedPreferences;
    }
    paramSharedPreferences = aph("en");
    bk.setProperty("language_key", paramSharedPreferences);
    AppMethodBeat.o(115229);
    return paramSharedPreferences;
  }
  
  public static String g(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115230);
    paramSharedPreferences = bo.nullAsNil(paramSharedPreferences.getString("language_key", null));
    if (!bo.isNullOrNil(paramSharedPreferences))
    {
      AppMethodBeat.o(115230);
      return paramSharedPreferences;
    }
    AppMethodBeat.o(115230);
    return "language_default";
  }
  
  public static String gP(Context paramContext)
  {
    AppMethodBeat.i(115232);
    paramContext = g(paramContext.getSharedPreferences(ah.dsP(), 0));
    String str = dsG();
    if (paramContext.equalsIgnoreCase("language_default")) {
      paramContext = str;
    }
    for (;;)
    {
      AppMethodBeat.o(115232);
      return paramContext;
    }
  }
  
  public static String gQ(Context paramContext)
  {
    AppMethodBeat.i(115233);
    String[] arrayOfString1 = paramContext.getResources().getStringArray(2131755024);
    String str = g(paramContext.getSharedPreferences(ah.dsP(), 0));
    if (str == null)
    {
      paramContext = paramContext.getString(2131296984);
      AppMethodBeat.o(115233);
      return paramContext;
    }
    String[] arrayOfString2 = z.qIy;
    int k = arrayOfString2.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (arrayOfString2[j].equals(str))
      {
        paramContext = arrayOfString1[i];
        AppMethodBeat.o(115233);
        return paramContext;
      }
      j += 1;
      i += 1;
    }
    paramContext = paramContext.getString(2131296984);
    AppMethodBeat.o(115233);
    return paramContext;
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    AppMethodBeat.i(115234);
    Object localObject = f(paramContext.getSharedPreferences(ah.dsP(), 0));
    if (((String)localObject).equals("language_default"))
    {
      a(paramContext, Locale.ENGLISH);
      paramContext = Locale.getDefault();
      AppMethodBeat.o(115234);
      return paramContext;
    }
    localObject = apg((String)localObject);
    a(paramContext, (Locale)localObject);
    AppMethodBeat.o(115234);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aa
 * JD-Core Version:    0.7.0.1
 */