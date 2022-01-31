package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

public final class d
{
  public static e cyc()
  {
    AppMethodBeat.i(59333);
    dbY();
    Object localObject2 = as.apq(ah.dsP());
    if (localObject2 == null)
    {
      localObject1 = new e();
      AppMethodBeat.o(59333);
      return localObject1;
    }
    Object localObject1 = ((SharedPreferences)localObject2).getString("cpu_id", "");
    localObject2 = ((SharedPreferences)localObject2).getString("uid", "");
    if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil((String)localObject2)))
    {
      ab.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
      localObject1 = new e((String)localObject1, (String)localObject2);
      AppMethodBeat.o(59333);
      return localObject1;
    }
    ab.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
    localObject2 = a.dVh();
    if (localObject2 != null)
    {
      localObject1 = ((i)localObject2).son;
      localObject2 = String.valueOf(((i)localObject2).uid);
      if ((!bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil((String)localObject2)))
      {
        gJ((String)localObject1, (String)localObject2);
        localObject1 = new e((String)localObject1, (String)localObject2);
        AppMethodBeat.o(59333);
        return localObject1;
      }
    }
    localObject1 = new e();
    AppMethodBeat.o(59333);
    return localObject1;
  }
  
  public static void dbY()
  {
    AppMethodBeat.i(156848);
    as localas = as.apq(ah.dsP());
    String str1 = localas.getString("cpu_id", null);
    String str2 = localas.getString("uid", null);
    if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)))
    {
      Object localObject = ah.dsQ();
      if (localObject == null)
      {
        AppMethodBeat.o(156848);
        return;
      }
      String str3 = ((SharedPreferences)localObject).getString("cpu_id", null);
      localObject = ((SharedPreferences)localObject).getString("uid", null);
      ab.i("MicroMsg.SoterDeviceInfoManager", "transfer old cpuId: %s, old uid: %s", new Object[] { str1, str2 });
      localas.putString("cpu_id", str3);
      localas.putString("uid", (String)localObject);
      localas.commit();
    }
    AppMethodBeat.o(156848);
  }
  
  public static void gJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59334);
    Object localObject = as.apq(ah.dsP());
    if (localObject == null)
    {
      AppMethodBeat.o(59334);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("cpu_id", paramString1);
    ((SharedPreferences.Editor)localObject).putString("uid", paramString2);
    ((SharedPreferences.Editor)localObject).commit();
    ab.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
    AppMethodBeat.o(59334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.d
 * JD-Core Version:    0.7.0.1
 */