package com.tencent.mm.wallet_core;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import java.util.Locale;
import java.util.Map;

public final class b
{
  private static b AVB;
  
  public static b dRI()
  {
    AppMethodBeat.i(49006);
    if (AVB == null) {
      AVB = new b();
    }
    b localb = AVB;
    AppMethodBeat.o(49006);
    return localb;
  }
  
  public static boolean dRJ()
  {
    AppMethodBeat.i(49007);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100368");
    if ((localc.isValid()) && ("1".equals(localc.dvN().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(49007);
        return true;
      }
      AppMethodBeat.o(49007);
      return false;
    }
  }
  
  public static boolean dRK()
  {
    AppMethodBeat.i(49008);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100370");
    if ((localc.isValid()) && ("1".equals(localc.dvN().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(49008);
        return true;
      }
      AppMethodBeat.o(49008);
      return false;
    }
  }
  
  public static boolean dRL()
  {
    AppMethodBeat.i(142610);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100369");
    if ((localc.isValid()) && ("1".equals(localc.dvN().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      ab.i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", new Object[] { Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(142610);
        return true;
      }
      AppMethodBeat.o(142610);
      return false;
    }
  }
  
  private static boolean dRM()
  {
    AppMethodBeat.i(142611);
    String str2 = Build.BRAND;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str1 = str1.toLowerCase(Locale.ENGLISH);
    if (((str1.contains("huawei")) || (str1.contains("honor"))) && (Build.VERSION.SDK_INT == 23))
    {
      ab.i("MicroMsg.TenPaySdkAbTest", "bingo isHuaWeiM brand %s", new Object[] { str1 });
      AppMethodBeat.o(142611);
      return true;
    }
    AppMethodBeat.o(142611);
    return false;
  }
  
  public static boolean dpQ()
  {
    AppMethodBeat.i(142612);
    int i = ((Integer)g.RL().Ru().get(ac.a.yLQ, Integer.valueOf(0))).intValue();
    boolean bool = ((a)g.E(a.class)).a(a.a.lVb, false);
    ab.i("MicroMsg.TenPaySdkAbTest", "isKindaEnable configval %s svrConfig %s isHuaWeiM %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Boolean.valueOf(dRM()) });
    if (i == 1)
    {
      AppMethodBeat.o(142612);
      return true;
    }
    if (i == 2)
    {
      AppMethodBeat.o(142612);
      return false;
    }
    if (bool)
    {
      AppMethodBeat.o(142612);
      return true;
    }
    if ((f.IS_FLAVOR_RED) || (f.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(142612);
      return true;
    }
    AppMethodBeat.o(142612);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b
 * JD-Core Version:    0.7.0.1
 */