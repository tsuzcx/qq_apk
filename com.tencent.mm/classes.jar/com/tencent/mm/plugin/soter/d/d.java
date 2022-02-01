package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

public final class d
{
  public static e efE()
  {
    AppMethodBeat.i(130840);
    efF();
    Object localObject2 = ax.aQz(aj.fkC());
    if (localObject2 == null)
    {
      localObject1 = new e();
      AppMethodBeat.o(130840);
      return localObject1;
    }
    Object localObject1 = ((SharedPreferences)localObject2).getString("cpu_id", "");
    localObject2 = ((SharedPreferences)localObject2).getString("uid", "");
    if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject2)))
    {
      ad.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
      localObject1 = new e((String)localObject1, (String)localObject2);
      AppMethodBeat.o(130840);
      return localObject1;
    }
    ad.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
    localObject2 = a.fUE();
    if (localObject2 != null)
    {
      localObject1 = ((i)localObject2).AFy;
      localObject2 = String.valueOf(((i)localObject2).uid);
      if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject2)))
      {
        ka((String)localObject1, (String)localObject2);
        localObject1 = new e((String)localObject1, (String)localObject2);
        AppMethodBeat.o(130840);
        return localObject1;
      }
    }
    localObject1 = new e();
    AppMethodBeat.o(130840);
    return localObject1;
  }
  
  public static void efF()
  {
    AppMethodBeat.i(130841);
    ax localax = ax.aQz(aj.fkC());
    String str1 = localax.getString("cpu_id", null);
    String str2 = localax.getString("uid", null);
    if ((bt.isNullOrNil(str1)) || (bt.isNullOrNil(str2)))
    {
      Object localObject = aj.fkD();
      if (localObject == null)
      {
        AppMethodBeat.o(130841);
        return;
      }
      String str3 = ((SharedPreferences)localObject).getString("cpu_id", null);
      localObject = ((SharedPreferences)localObject).getString("uid", null);
      ad.i("MicroMsg.SoterDeviceInfoManager", "transfer old cpuId: %s, old uid: %s", new Object[] { str1, str2 });
      localax.putString("cpu_id", str3);
      localax.putString("uid", (String)localObject);
      localax.commit();
    }
    AppMethodBeat.o(130841);
  }
  
  public static void ka(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130842);
    Object localObject = ax.aQz(aj.fkC());
    if (localObject == null)
    {
      AppMethodBeat.o(130842);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("cpu_id", paramString1);
    ((SharedPreferences.Editor)localObject).putString("uid", paramString2);
    ((SharedPreferences.Editor)localObject).commit();
    ad.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
    AppMethodBeat.o(130842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.d
 * JD-Core Version:    0.7.0.1
 */