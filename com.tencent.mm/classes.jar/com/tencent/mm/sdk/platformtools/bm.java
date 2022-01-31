package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.TimeZone;

public final class bm
{
  public static boolean csh()
  {
    Object localObject1 = x.e(ae.getContext().getSharedPreferences(ae.cqR(), 0));
    Object localObject2 = x.cqJ();
    if (((String)localObject1).equals("language_default")) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!((String)localObject1).equals("zh_CN")) {
        return true;
      }
      localObject1 = TimeZone.getDefault();
      localObject2 = TimeZone.getTimeZone("GMT+08:00");
      if (((TimeZone)localObject1).getRawOffset() != ((TimeZone)localObject2).getRawOffset()) {
        return true;
      }
      localObject1 = (TelephonyManager)ae.getContext().getSystemService("phone");
      if (localObject1 != null)
      {
        localObject1 = ((TelephonyManager)localObject1).getNetworkCountryIso();
        if ((!bk.bl((String)localObject1)) && (!((String)localObject1).contains("cn")) && (!((String)localObject1).contains("CN"))) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bm
 * JD-Core Version:    0.7.0.1
 */