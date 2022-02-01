package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qx;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;

public final class b
{
  public static boolean Sak;
  public static int Sal;
  private static com.tencent.soter.core.d.e Sam;
  
  static
  {
    AppMethodBeat.i(130879);
    Sak = false;
    Sam = new com.tencent.soter.core.d.e()
    {
      public final void dFw()
      {
        AppMethodBeat.i(130871);
        h.OAn.idkeyStat(1104L, 6L, 1L, false);
        if (!com.tencent.soter.a.a.jYp()) {
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(130869);
              if (!com.tencent.soter.a.a.jYp())
              {
                Log.i("MicroMsg.SoterInitManager", "bind service timeout, reinit");
                b.a(false, new com.tencent.mm.plugin.soter.model.d()
                {
                  public final void bL(int paramAnonymous3Int, String paramAnonymous3String)
                  {
                    AppMethodBeat.i(130868);
                    Log.i("MicroMsg.SoterInitManager", "init finish: %s, %s", new Object[] { Integer.valueOf(paramAnonymous3Int), paramAnonymous3String });
                    qx localqx = new qx();
                    localqx.hTW.errCode = paramAnonymous3Int;
                    localqx.hTW.errMsg = paramAnonymous3String;
                    localqx.publish();
                    AppMethodBeat.o(130868);
                  }
                });
              }
              AppMethodBeat.o(130869);
            }
          }, 5000L);
        }
        AppMethodBeat.o(130871);
      }
      
      public final void htL()
      {
        AppMethodBeat.i(130870);
        h.OAn.idkeyStat(1104L, 5L, 1L, false);
        AppMethodBeat.o(130870);
      }
      
      public final void htM()
      {
        AppMethodBeat.i(130872);
        h.OAn.idkeyStat(1104L, 7L, 1L, false);
        AppMethodBeat.o(130872);
      }
      
      public final void htN()
      {
        AppMethodBeat.i(130873);
        h.OAn.idkeyStat(1104L, 8L, 1L, false);
        AppMethodBeat.o(130873);
      }
      
      public final void htO()
      {
        AppMethodBeat.i(130874);
        Log.i("MicroMsg.SoterInitManager", "no service when calling");
        h.OAn.idkeyStat(1104L, 9L, 1L, false);
        AppMethodBeat.o(130874);
      }
    };
    AppMethodBeat.o(130879);
  }
  
  public static void a(boolean paramBoolean, com.tencent.mm.plugin.soter.model.d paramd)
  {
    AppMethodBeat.i(130877);
    Log.i("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.TRUE });
    try
    {
      long l = System.currentTimeMillis();
      com.tencent.soter.core.d.d.uid = Process.myUid();
      com.tencent.soter.core.a.a(Sam);
      g.S(Boolean.valueOf(paramBoolean), Boolean.TRUE).e(new a()).e(new d()).e(new c()).e(new e()).a(new d.a() {}).a(new d.b() {});
      AppMethodBeat.o(130877);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SoterInitManager", localException, "alvinluo exception when init soter: %s", new Object[] { localException.getMessage() });
      com.tencent.mm.plugin.soter.model.a.w(4, 1001, 1L);
      paramd.bL(-1, "system error");
      AppMethodBeat.o(130877);
    }
  }
  
  public static boolean htJ()
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
  
  public static boolean htK()
  {
    return (Build.VERSION.SDK_INT >= 28) && (!Sak) && (Sal == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.d.b
 * JD-Core Version:    0.7.0.1
 */