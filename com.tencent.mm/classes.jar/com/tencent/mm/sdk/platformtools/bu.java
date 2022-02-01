package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

public final class bu
{
  public static boolean eWq()
  {
    AppMethodBeat.i(125286);
    Object localObject1 = ai.getContext().getSharedPreferences(ai.eUX(), 0);
    ai.getContext();
    localObject1 = ab.g((SharedPreferences)localObject1);
    Object localObject2 = ab.eUO();
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
      localObject1 = (TelephonyManager)ai.getContext().getSystemService("phone");
      if (localObject1 != null)
      {
        localObject1 = ((TelephonyManager)localObject1).getNetworkCountryIso();
        if ((!bs.isNullOrNil((String)localObject1)) && (!((String)localObject1).contains("cn")) && (!((String)localObject1).contains("CN")))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bu
 * JD-Core Version:    0.7.0.1
 */