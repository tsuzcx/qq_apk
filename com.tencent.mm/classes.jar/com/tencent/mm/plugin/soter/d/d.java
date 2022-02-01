package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

public final class d
{
  public static e gai()
  {
    AppMethodBeat.i(130840);
    gaj();
    Object localObject2 = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath());
    if (localObject2 == null)
    {
      localObject1 = new e();
      AppMethodBeat.o(130840);
      return localObject1;
    }
    Object localObject1 = ((SharedPreferences)localObject2).getString("cpu_id", "");
    localObject2 = ((SharedPreferences)localObject2).getString("uid", "");
    if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
    {
      Log.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
      localObject1 = new e((String)localObject1, (String)localObject2);
      AppMethodBeat.o(130840);
      return localObject1;
    }
    Log.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
    localObject2 = a.ioN();
    if (localObject2 != null)
    {
      localObject1 = ((i)localObject2).Lwz;
      localObject2 = String.valueOf(((i)localObject2).uid);
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2)))
      {
        lr((String)localObject1, (String)localObject2);
        localObject1 = new e((String)localObject1, (String)localObject2);
        AppMethodBeat.o(130840);
        return localObject1;
      }
    }
    localObject1 = new e();
    AppMethodBeat.o(130840);
    return localObject1;
  }
  
  public static void gaj()
  {
    AppMethodBeat.i(130841);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath());
    String str1 = localMultiProcessMMKV.getString("cpu_id", null);
    String str2 = localMultiProcessMMKV.getString("uid", null);
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
    {
      Object localObject = MMApplicationContext.getDefaultPreference();
      if (localObject == null)
      {
        AppMethodBeat.o(130841);
        return;
      }
      String str3 = ((SharedPreferences)localObject).getString("cpu_id", null);
      localObject = ((SharedPreferences)localObject).getString("uid", null);
      Log.i("MicroMsg.SoterDeviceInfoManager", "transfer old cpuId: %s, old uid: %s", new Object[] { str1, str2 });
      localMultiProcessMMKV.putString("cpu_id", str3);
      localMultiProcessMMKV.putString("uid", (String)localObject);
      localMultiProcessMMKV.commit();
    }
    AppMethodBeat.o(130841);
  }
  
  public static void lr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130842);
    Object localObject = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath());
    if (localObject == null)
    {
      AppMethodBeat.o(130842);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("cpu_id", paramString1);
    ((SharedPreferences.Editor)localObject).putString("uid", paramString2);
    ((SharedPreferences.Editor)localObject).commit();
    Log.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
    AppMethodBeat.o(130842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.d
 * JD-Core Version:    0.7.0.1
 */