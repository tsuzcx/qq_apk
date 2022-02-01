package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

public final class d
{
  public static e dTq()
  {
    AppMethodBeat.i(130840);
    dTr();
    Object localObject2 = aw.aKT(ai.eUX());
    if (localObject2 == null)
    {
      localObject1 = new e();
      AppMethodBeat.o(130840);
      return localObject1;
    }
    Object localObject1 = ((SharedPreferences)localObject2).getString("cpu_id", "");
    localObject2 = ((SharedPreferences)localObject2).getString("uid", "");
    if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil((String)localObject2)))
    {
      ac.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
      localObject1 = new e((String)localObject1, (String)localObject2);
      AppMethodBeat.o(130840);
      return localObject1;
    }
    ac.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
    localObject2 = a.fDm();
    if (localObject2 != null)
    {
      localObject1 = ((i)localObject2).znE;
      localObject2 = String.valueOf(((i)localObject2).uid);
      if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil((String)localObject2)))
      {
        jL((String)localObject1, (String)localObject2);
        localObject1 = new e((String)localObject1, (String)localObject2);
        AppMethodBeat.o(130840);
        return localObject1;
      }
    }
    localObject1 = new e();
    AppMethodBeat.o(130840);
    return localObject1;
  }
  
  public static void dTr()
  {
    AppMethodBeat.i(130841);
    aw localaw = aw.aKT(ai.eUX());
    String str1 = localaw.getString("cpu_id", null);
    String str2 = localaw.getString("uid", null);
    if ((bs.isNullOrNil(str1)) || (bs.isNullOrNil(str2)))
    {
      Object localObject = ai.eUY();
      if (localObject == null)
      {
        AppMethodBeat.o(130841);
        return;
      }
      String str3 = ((SharedPreferences)localObject).getString("cpu_id", null);
      localObject = ((SharedPreferences)localObject).getString("uid", null);
      ac.i("MicroMsg.SoterDeviceInfoManager", "transfer old cpuId: %s, old uid: %s", new Object[] { str1, str2 });
      localaw.putString("cpu_id", str3);
      localaw.putString("uid", (String)localObject);
      localaw.commit();
    }
    AppMethodBeat.o(130841);
  }
  
  public static void jL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130842);
    Object localObject = aw.aKT(ai.eUX());
    if (localObject == null)
    {
      AppMethodBeat.o(130842);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("cpu_id", paramString1);
    ((SharedPreferences.Editor)localObject).putString("uid", paramString2);
    ((SharedPreferences.Editor)localObject).commit();
    ac.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
    AppMethodBeat.o(130842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.d
 * JD-Core Version:    0.7.0.1
 */