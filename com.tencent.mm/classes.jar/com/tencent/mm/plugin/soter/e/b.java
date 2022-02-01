package com.tencent.mm.plugin.soter.e;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;

public final class b
{
  public static boolean AXo;
  public static int AXp;
  private static com.tencent.soter.core.d.e AXq;
  
  static
  {
    AppMethodBeat.i(130879);
    AXo = false;
    AXq = new com.tencent.soter.core.d.e()
    {
      public final void ejA()
      {
        AppMethodBeat.i(130873);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1104L, 8L, 1L, false);
        AppMethodBeat.o(130873);
      }
      
      public final void ejB()
      {
        AppMethodBeat.i(130874);
        ae.i("MicroMsg.SoterInitManager", "no service when calling");
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1104L, 9L, 1L, false);
        AppMethodBeat.o(130874);
      }
      
      public final void ejy()
      {
        AppMethodBeat.i(130870);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1104L, 5L, 1L, false);
        AppMethodBeat.o(130870);
      }
      
      public final void ejz()
      {
        AppMethodBeat.i(130872);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1104L, 7L, 1L, false);
        AppMethodBeat.o(130872);
      }
      
      public final void onServiceConnected()
      {
        AppMethodBeat.i(130871);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1104L, 6L, 1L, false);
        if (!com.tencent.soter.a.a.fZr()) {
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130869);
              if (!com.tencent.soter.a.a.fZr())
              {
                ae.i("MicroMsg.SoterInitManager", "bind service timeout, reinit");
                b.a(false, new b.1.1.1(this));
              }
              AppMethodBeat.o(130869);
            }
          }, 5000L);
        }
        AppMethodBeat.o(130871);
      }
    };
    AppMethodBeat.o(130879);
  }
  
  public static void a(boolean paramBoolean, com.tencent.mm.plugin.soter.d.g paramg)
  {
    AppMethodBeat.i(130877);
    ae.i("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.TRUE });
    try
    {
      long l = System.currentTimeMillis();
      com.tencent.soter.core.d.d.uid = Process.myUid();
      com.tencent.soter.core.a.a(AXq);
      com.tencent.mm.vending.g.g.L(Boolean.valueOf(paramBoolean), Boolean.TRUE).e(new a()).e(new d()).e(new c()).e(new e()).a(new d.a() {}).a(new d.b() {});
      AppMethodBeat.o(130877);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SoterInitManager", localException, "alvinluo exception when init soter: %s", new Object[] { localException.getMessage() });
      com.tencent.mm.plugin.soter.d.a.n(4, 1001, 1L);
      paramg.bb(-1, "system error");
      AppMethodBeat.o(130877);
    }
  }
  
  public static boolean ejw()
  {
    AppMethodBeat.i(130878);
    SharedPreferences localSharedPreferences = ak.fox();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(130878);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("init_success", false);
    AppMethodBeat.o(130878);
    return bool;
  }
  
  public static boolean ejx()
  {
    return (Build.VERSION.SDK_INT >= 28) && (!AXo) && (AXp == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b
 * JD-Core Version:    0.7.0.1
 */