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

public final class LocaleUtil
{
  public static final String ARABIC = "ar";
  public static final String CHINA = "zh_CN";
  public static final String ENGLISH = "en";
  public static final String FRENCH = "fr";
  public static final String GERMAN = "de";
  public static final String HONGKONG = "zh_HK";
  public static final String INDONESIAN = "id";
  public static final String INDONESIAN_NEWNAME = "in";
  public static final String ITALIAN = "it";
  public static final String JAPANESE = "ja";
  public static final String KOREAN = "ko";
  public static final String LANGUAGE_DEFAULT = "language_default";
  public static final String LANGUAGE_KEY = "language_key";
  public static final String LAO = "lo";
  public static final String MALAY = "ms";
  public static final String MYANMAR = "my";
  public static final String PORTUGUESE = "pt";
  public static final String RUSSIAN = "ru";
  public static final String SPANISH = "es";
  private static final String TAG = "MicroMsg.LocaleUtil";
  public static final String TAIWAN = "zh_TW";
  public static final String THAI = "th";
  public static final String TURKEY = "tr";
  public static final String VIETNAMESE = "vi";
  static final String _LANGUAGE_DEFAULT = "language_default";
  public static Locale sysDefaultLocale;
  
  static
  {
    AppMethodBeat.i(125269);
    loadCurrentSystemLocale();
    AppMethodBeat.o(125269);
  }
  
  private static String filterLanguage(String paramString)
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
    if (WeChatSomeFeatureSwitch.temporaryBlockMinorLanguage())
    {
      AppMethodBeat.o(125261);
      return paramString;
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
  
  public static String getApplicationLanguage()
  {
    AppMethodBeat.i(125262);
    String str = Util.nullAsNil(SystemProperty.getProperty("language_key"));
    if ((str.length() > 0) && (!str.equals("language_default")))
    {
      AppMethodBeat.o(125262);
      return str;
    }
    str = filterLanguage("en");
    AppMethodBeat.o(125262);
    return str;
  }
  
  public static String getCurrentCountryCode()
  {
    AppMethodBeat.i(125260);
    String str = Locale.getDefault().getCountry().trim();
    AppMethodBeat.o(125260);
    return str;
  }
  
  public static String getCurrentLanguage(Context paramContext)
  {
    AppMethodBeat.i(125266);
    paramContext = loadApplicationLanguageSettings(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    String str = getApplicationLanguage();
    if (paramContext.equalsIgnoreCase("language_default")) {
      paramContext = str;
    }
    for (;;)
    {
      AppMethodBeat.o(125266);
      return paramContext;
    }
  }
  
  public static String getLanguageName(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200900);
    String[] arrayOfString1 = paramContext.getResources().getStringArray(paramInt1);
    String str = loadApplicationLanguageSettings(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    if (str == null)
    {
      paramContext = paramContext.getString(paramInt2);
      AppMethodBeat.o(200900);
      return paramContext;
    }
    String[] arrayOfString2 = LocaleGen.LOCALES;
    int j = arrayOfString2.length;
    int i = 0;
    paramInt1 = 0;
    while (i < j)
    {
      if (arrayOfString2[i].equals(str))
      {
        paramContext = arrayOfString1[paramInt1];
        AppMethodBeat.o(200900);
        return paramContext;
      }
      i += 1;
      paramInt1 += 1;
    }
    paramContext = paramContext.getString(paramInt2);
    AppMethodBeat.o(200900);
    return paramContext;
  }
  
  public static Locale initLanguage(Context paramContext)
  {
    AppMethodBeat.i(125268);
    Object localObject = loadApplicationLanguage(paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), paramContext);
    if (((String)localObject).equals("language_default"))
    {
      updateApplicationResourceLocale(paramContext, Locale.ENGLISH);
      paramContext = Locale.getDefault();
      AppMethodBeat.o(125268);
      return paramContext;
    }
    localObject = transLanguageToLocale((String)localObject);
    updateApplicationResourceLocale(paramContext, (Locale)localObject);
    AppMethodBeat.o(125268);
    return localObject;
  }
  
  public static boolean isChineseAppLang()
  {
    AppMethodBeat.i(125254);
    String str = getApplicationLanguage();
    if ((str.equals("zh_CN")) || (str.equals("zh_TW")) || (str.equals("zh_HK")))
    {
      AppMethodBeat.o(125254);
      return true;
    }
    AppMethodBeat.o(125254);
    return false;
  }
  
  public static boolean isChineseSysLang()
  {
    AppMethodBeat.i(200895);
    if ((Locale.getDefault().equals(Locale.CHINA)) || (Locale.getDefault().equals(Locale.TAIWAN)) || (Locale.getDefault().toString().startsWith(Locale.CHINESE.toString())))
    {
      AppMethodBeat.o(200895);
      return true;
    }
    AppMethodBeat.o(200895);
    return false;
  }
  
  public static boolean isLanguageSupported(String paramString)
  {
    AppMethodBeat.i(200894);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(200894);
      return false;
    }
    if ((paramString.equalsIgnoreCase("zh_TW")) || (paramString.equalsIgnoreCase("zh_HK")) || (paramString.equalsIgnoreCase("zh_CN")) || (paramString.equalsIgnoreCase("en")) || (paramString.equalsIgnoreCase("th")) || (paramString.equals("id")) || (paramString.equals("in")) || (paramString.equals("vi")) || (paramString.equalsIgnoreCase("pt")) || (paramString.equalsIgnoreCase("es")) || (paramString.equalsIgnoreCase("ru")) || (paramString.equalsIgnoreCase("ar")) || (paramString.equalsIgnoreCase("ja")) || (paramString.equalsIgnoreCase("it")) || (paramString.equalsIgnoreCase("ko")) || (paramString.equalsIgnoreCase("ms")) || (paramString.equalsIgnoreCase("tr")) || (paramString.equalsIgnoreCase("de")) || (paramString.equalsIgnoreCase("fr")) || (paramString.equalsIgnoreCase("my")) || (paramString.equalsIgnoreCase("lo")))
    {
      AppMethodBeat.o(200894);
      return true;
    }
    AppMethodBeat.o(200894);
    return false;
  }
  
  public static boolean isSimplifiedChineseAppLang()
  {
    AppMethodBeat.i(125255);
    if (getApplicationLanguage().equals("zh_CN"))
    {
      AppMethodBeat.o(125255);
      return true;
    }
    AppMethodBeat.o(125255);
    return false;
  }
  
  public static boolean isTraditionalChineseAppLang()
  {
    AppMethodBeat.i(125256);
    if ((getApplicationLanguage().equals("zh_TW")) || (getApplicationLanguage().equals("zh_HK")))
    {
      AppMethodBeat.o(125256);
      return true;
    }
    AppMethodBeat.o(125256);
    return false;
  }
  
  public static String loadApplicationLanguage(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    AppMethodBeat.i(200897);
    paramSharedPreferences = Util.nullAsNil(paramSharedPreferences.getString("language_key", null));
    if ((paramSharedPreferences.length() > 0) && (!paramSharedPreferences.equals("language_default")))
    {
      SystemProperty.setProperty("language_key", paramSharedPreferences);
      AppMethodBeat.o(200897);
      return paramSharedPreferences;
    }
    paramSharedPreferences = filterLanguage("en");
    SystemProperty.setProperty("language_key", paramSharedPreferences);
    AppMethodBeat.o(200897);
    return paramSharedPreferences;
  }
  
  public static String loadApplicationLanguageSettings(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    AppMethodBeat.i(200898);
    paramSharedPreferences = Util.nullAsNil(paramSharedPreferences.getString("language_key", null));
    if (!Util.isNullOrNil(paramSharedPreferences))
    {
      AppMethodBeat.o(200898);
      return paramSharedPreferences;
    }
    AppMethodBeat.o(200898);
    return "language_default";
  }
  
  public static void loadCurrentSystemLocale()
  {
    AppMethodBeat.i(200896);
    if (Build.VERSION.SDK_INT < 24) {}
    for (sysDefaultLocale = Locale.getDefault();; sysDefaultLocale = LocaleList.getDefault().get(0))
    {
      Locale.setDefault(sysDefaultLocale);
      AppMethodBeat.o(200896);
      return;
    }
  }
  
  public static void saveApplicationLanguage(SharedPreferences paramSharedPreferences, Context paramContext, String paramString)
  {
    AppMethodBeat.i(200899);
    if (paramSharedPreferences.edit().putString("language_key", paramString).commit())
    {
      SystemProperty.setProperty("language_key", paramString);
      Log.w("MicroMsg.LocaleUtil", "save application lang as:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(200899);
      return;
    }
    Log.e("MicroMsg.LocaleUtil", "saving application lang failed");
    AppMethodBeat.o(200899);
  }
  
  public static Locale transLanguageToLocale(String paramString)
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
    if (WeChatSomeFeatureSwitch.temporaryBlockMinorLanguage())
    {
      paramString = Locale.ENGLISH;
      AppMethodBeat.o(125259);
      return paramString;
    }
    if ((paramString.equalsIgnoreCase("th")) || (paramString.equalsIgnoreCase("id")) || (paramString.equalsIgnoreCase("in")) || (paramString.equalsIgnoreCase("vi")) || (paramString.equalsIgnoreCase("pt")) || (paramString.equalsIgnoreCase("es")) || (paramString.equalsIgnoreCase("ru")) || (paramString.equalsIgnoreCase("ar")) || (paramString.equalsIgnoreCase("ja")) || (paramString.equalsIgnoreCase("it")) || (paramString.equalsIgnoreCase("ko")) || (paramString.equalsIgnoreCase("ms")) || (paramString.equalsIgnoreCase("tr")) || (paramString.equalsIgnoreCase("de")) || (paramString.equalsIgnoreCase("fr")) || (paramString.equalsIgnoreCase("my")) || (paramString.equalsIgnoreCase("lo")))
    {
      paramString = new Locale(paramString);
      AppMethodBeat.o(125259);
      return paramString;
    }
    Log.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = ".concat(String.valueOf(paramString)));
    paramString = Locale.ENGLISH;
    AppMethodBeat.o(125259);
    return paramString;
  }
  
  public static String transLocaleToLanguage(Locale paramLocale)
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
  
  public static void updateApplicationResourceLocale(Context paramContext, Locale paramLocale)
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
      WeChatBrands.updateLang(transLocaleToLanguage(paramLocale));
      AppMethodBeat.o(125257);
      return;
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.LocaleUtil", paramContext, "updateApplicationResourceLocale err~~~", new Object[0]);
      AppMethodBeat.o(125257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LocaleUtil
 * JD-Core Version:    0.7.0.1
 */