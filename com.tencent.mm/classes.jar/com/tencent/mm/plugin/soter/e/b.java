package com.tencent.mm.plugin.soter.e;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;

public final class b
{
  public static boolean znR;
  public static int znS;
  private static com.tencent.soter.core.d.e znT;
  
  static
  {
    AppMethodBeat.i(130879);
    znR = false;
    znT = new b.1();
    AppMethodBeat.o(130879);
  }
  
  public static void a(boolean paramBoolean, com.tencent.mm.plugin.soter.d.g paramg)
  {
    AppMethodBeat.i(130877);
    ac.i("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.TRUE });
    try
    {
      long l = System.currentTimeMillis();
      com.tencent.soter.core.d.d.uid = Process.myUid();
      com.tencent.soter.core.a.a(znT);
      com.tencent.mm.vending.g.g.J(Boolean.valueOf(paramBoolean), Boolean.TRUE).e(new a()).e(new d()).e(new c()).e(new e()).a(new d.a() {}).a(new d.b() {});
      AppMethodBeat.o(130877);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SoterInitManager", localException, "alvinluo exception when init soter: %s", new Object[] { localException.getMessage() });
      com.tencent.mm.plugin.soter.d.a.m(4, 1001, 1L);
      paramg.aZ(-1, "system error");
      AppMethodBeat.o(130877);
    }
  }
  
  public static boolean dTA()
  {
    AppMethodBeat.i(130878);
    SharedPreferences localSharedPreferences = ai.eUY();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(130878);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("init_success", false);
    AppMethodBeat.o(130878);
    return bool;
  }
  
  public static boolean dTB()
  {
    return (Build.VERSION.SDK_INT >= 28) && (!znR) && (znS == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b
 * JD-Core Version:    0.7.0.1
 */