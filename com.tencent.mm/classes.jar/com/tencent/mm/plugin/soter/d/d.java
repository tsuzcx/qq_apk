package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

public final class d
{
  public static e ejm()
  {
    AppMethodBeat.i(130840);
    ejn();
    Object localObject2 = ay.aRW(ak.fow());
    if (localObject2 == null)
    {
      localObject1 = new e();
      AppMethodBeat.o(130840);
      return localObject1;
    }
    Object localObject1 = ((SharedPreferences)localObject2).getString("cpu_id", "");
    localObject2 = ((SharedPreferences)localObject2).getString("uid", "");
    if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil((String)localObject2)))
    {
      ae.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
      localObject1 = new e((String)localObject1, (String)localObject2);
      AppMethodBeat.o(130840);
      return localObject1;
    }
    ae.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
    localObject2 = a.fZd();
    if (localObject2 != null)
    {
      localObject1 = ((i)localObject2).AXb;
      localObject2 = String.valueOf(((i)localObject2).uid);
      if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil((String)localObject2)))
      {
        kh((String)localObject1, (String)localObject2);
        localObject1 = new e((String)localObject1, (String)localObject2);
        AppMethodBeat.o(130840);
        return localObject1;
      }
    }
    localObject1 = new e();
    AppMethodBeat.o(130840);
    return localObject1;
  }
  
  public static void ejn()
  {
    AppMethodBeat.i(130841);
    ay localay = ay.aRW(ak.fow());
    String str1 = localay.getString("cpu_id", null);
    String str2 = localay.getString("uid", null);
    if ((bu.isNullOrNil(str1)) || (bu.isNullOrNil(str2)))
    {
      Object localObject = ak.fox();
      if (localObject == null)
      {
        AppMethodBeat.o(130841);
        return;
      }
      String str3 = ((SharedPreferences)localObject).getString("cpu_id", null);
      localObject = ((SharedPreferences)localObject).getString("uid", null);
      ae.i("MicroMsg.SoterDeviceInfoManager", "transfer old cpuId: %s, old uid: %s", new Object[] { str1, str2 });
      localay.putString("cpu_id", str3);
      localay.putString("uid", (String)localObject);
      localay.commit();
    }
    AppMethodBeat.o(130841);
  }
  
  public static void kh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130842);
    Object localObject = ay.aRW(ak.fow());
    if (localObject == null)
    {
      AppMethodBeat.o(130842);
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("cpu_id", paramString1);
    ((SharedPreferences.Editor)localObject).putString("uid", paramString2);
    ((SharedPreferences.Editor)localObject).commit();
    ae.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
    AppMethodBeat.o(130842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.d
 * JD-Core Version:    0.7.0.1
 */