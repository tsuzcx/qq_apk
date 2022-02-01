package com.tencent.mm.plugin.soter.e;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;

public final class b
{
  public static boolean Fig;
  public static int Fih;
  private static com.tencent.soter.core.d.e Fii;
  
  static
  {
    AppMethodBeat.i(130879);
    Fig = false;
    Fii = new com.tencent.soter.core.d.e()
    {
      public final void flY()
      {
        AppMethodBeat.i(130870);
        h.CyF.idkeyStat(1104L, 5L, 1L, false);
        AppMethodBeat.o(130870);
      }
      
      public final void flZ()
      {
        AppMethodBeat.i(130872);
        h.CyF.idkeyStat(1104L, 7L, 1L, false);
        AppMethodBeat.o(130872);
      }
      
      public final void fma()
      {
        AppMethodBeat.i(130873);
        h.CyF.idkeyStat(1104L, 8L, 1L, false);
        AppMethodBeat.o(130873);
      }
      
      public final void fmb()
      {
        AppMethodBeat.i(130874);
        Log.i("MicroMsg.SoterInitManager", "no service when calling");
        h.CyF.idkeyStat(1104L, 9L, 1L, false);
        AppMethodBeat.o(130874);
      }
      
      public final void onServiceConnected()
      {
        AppMethodBeat.i(130871);
        h.CyF.idkeyStat(1104L, 6L, 1L, false);
        if (!com.tencent.soter.a.a.hlC()) {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130869);
              if (!com.tencent.soter.a.a.hlC())
              {
                Log.i("MicroMsg.SoterInitManager", "bind service timeout, reinit");
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
    Log.i("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.TRUE });
    try
    {
      long l = System.currentTimeMillis();
      com.tencent.soter.core.d.d.uid = Process.myUid();
      com.tencent.soter.core.a.a(Fii);
      com.tencent.mm.vending.g.g.O(Boolean.valueOf(paramBoolean), Boolean.TRUE).e(new a()).e(new d()).e(new c()).e(new e()).a(new d.a() {}).a(new d.b() {});
      AppMethodBeat.o(130877);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SoterInitManager", localException, "alvinluo exception when init soter: %s", new Object[] { localException.getMessage() });
      com.tencent.mm.plugin.soter.d.a.n(4, 1001, 1L);
      paramg.bg(-1, "system error");
      AppMethodBeat.o(130877);
    }
  }
  
  public static boolean flW()
  {
    AppMethodBeat.i(130878);
    SharedPreferences localSharedPreferences = MMApplicationContext.getDefaultPreference();
    if (localSharedPreferences == null)
    {
      AppMethodBeat.o(130878);
      return false;
    }
    boolean bool = localSharedPreferences.getBoolean("init_success", false);
    AppMethodBeat.o(130878);
    return bool;
  }
  
  public static boolean flX()
  {
    return (Build.VERSION.SDK_INT >= 28) && (!Fig) && (Fih == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.e.b
 * JD-Core Version:    0.7.0.1
 */