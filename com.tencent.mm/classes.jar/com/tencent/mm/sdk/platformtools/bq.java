package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

public final class bq
{
  public static boolean duf()
  {
    AppMethodBeat.i(115249);
    Object localObject1 = ah.getContext().getSharedPreferences(ah.dsP(), 0);
    ah.getContext();
    localObject1 = aa.g((SharedPreferences)localObject1);
    Object localObject2 = aa.dsG();
    if (((String)localObject1).equals("language_default")) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!((String)localObject1).equals("zh_CN"))
      {
        AppMethodBeat.o(115249);
        return true;
      }
      localObject1 = TimeZone.getDefault();
      localObject2 = TimeZone.getTimeZone("GMT+08:00");
      if (((TimeZone)localObject1).getRawOffset() != ((TimeZone)localObject2).getRawOffset())
      {
        AppMethodBeat.o(115249);
        return true;
      }
      localObject1 = (TelephonyManager)ah.getContext().getSystemService("phone");
      if (localObject1 != null)
      {
        localObject1 = ((TelephonyManager)localObject1).getNetworkCountryIso();
        if ((!bo.isNullOrNil((String)localObject1)) && (!((String)localObject1).contains("cn")) && (!((String)localObject1).contains("CN")))
        {
          AppMethodBeat.o(115249);
          return true;
        }
      }
      AppMethodBeat.o(115249);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bq
 * JD-Core Version:    0.7.0.1
 */