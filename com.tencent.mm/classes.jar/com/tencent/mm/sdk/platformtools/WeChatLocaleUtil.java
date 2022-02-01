package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.TimeZone;

public class WeChatLocaleUtil
{
  public static boolean isOverseasUser()
  {
    AppMethodBeat.i(243669);
    if (!Locale.getDefault().getCountry().equalsIgnoreCase("CN"))
    {
      AppMethodBeat.o(243669);
      return true;
    }
    Object localObject = TimeZone.getDefault();
    TimeZone localTimeZone = TimeZone.getTimeZone("GMT+08:00");
    if (((TimeZone)localObject).getRawOffset() != localTimeZone.getRawOffset())
    {
      AppMethodBeat.o(243669);
      return true;
    }
    localObject = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    if (localObject != null)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).contains("cn")) && (!((String)localObject).contains("CN")))
      {
        AppMethodBeat.o(243669);
        return true;
      }
    }
    AppMethodBeat.o(243669);
    return false;
  }
  
  public static boolean isOverseasUserByWechatLanguage()
  {
    AppMethodBeat.i(125286);
    Object localObject1 = LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
    Object localObject2 = LocaleUtil.getApplicationLanguage();
    if (((String)localObject1).equals("language_default")) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!((String)localObject1).equals("zh_CN"))
      {
        AppMethodBeat.o(125286);
        return true;
      }
      localObject1 = TimeZone.getDefault();
      localObject2 = TimeZone.getTimeZone("GMT+08:00");
      if (((TimeZone)localObject1).getRawOffset() != ((TimeZone)localObject2).getRawOffset())
      {
        AppMethodBeat.o(125286);
        return true;
      }
      localObject1 = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
      if (localObject1 != null)
      {
        localObject1 = ((TelephonyManager)localObject1).getNetworkCountryIso();
        if ((!Util.isNullOrNil((String)localObject1)) && (!((String)localObject1).contains("cn")) && (!((String)localObject1).contains("CN")))
        {
          AppMethodBeat.o(125286);
          return true;
        }
      }
      AppMethodBeat.o(125286);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatLocaleUtil
 * JD-Core Version:    0.7.0.1
 */