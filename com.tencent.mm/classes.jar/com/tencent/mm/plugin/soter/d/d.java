package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

public final class d
{
  public static e bKR()
  {
    Object localObject = ae.cqS();
    if (localObject == null) {
      return new e();
    }
    String str = ((SharedPreferences)localObject).getString("cpu_id", "");
    localObject = ((SharedPreferences)localObject).getString("uid", "");
    if ((!bk.bl(str)) && (!bk.bl((String)localObject)))
    {
      y.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
      return new e(str, (String)localObject);
    }
    y.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
    localObject = a.cPm();
    if (localObject != null)
    {
      str = ((i)localObject).psl;
      localObject = String.valueOf(((i)localObject).uid);
      if ((!bk.bl(str)) && (!bk.bl((String)localObject)))
      {
        fb(str, (String)localObject);
        return new e(str, (String)localObject);
      }
    }
    return new e();
  }
  
  public static void fb(String paramString1, String paramString2)
  {
    Object localObject = ae.cqS();
    if (localObject == null) {
      return;
    }
    y.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("cpu_id", paramString1);
    ((SharedPreferences.Editor)localObject).putString("uid", paramString2);
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.d
 * JD-Core Version:    0.7.0.1
 */