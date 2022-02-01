package com.tencent.mm.sdcard_migrate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.CancellationSignal;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;

@SuppressLint({"NewApi"})
public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(211088);
    b.a(new c(), new String[] { "//extmig" });
    AppMethodBeat.o(211088);
  }
  
  public static void init() {}
  
  public final boolean a(final Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(211087);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      AppMethodBeat.o(211087);
      return false;
    }
    paramString = paramArrayOfString[1];
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(211087);
        return false;
        if (paramString.equals("start"))
        {
          i = 0;
          continue;
          if (paramString.equals("maintain"))
          {
            i = 1;
            continue;
            if (paramString.equals("on"))
            {
              i = 2;
              continue;
              if (paramString.equals("reset")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    boolean bool1 = bool2;
    if (paramArrayOfString.length >= 3)
    {
      bool1 = bool2;
      if (paramArrayOfString[2] != null)
      {
        bool1 = bool2;
        if (paramArrayOfString[2].equalsIgnoreCase("fcp")) {
          bool1 = true;
        }
      }
    }
    paramArrayOfString = new ExtStorageMigrateConfig.a(ExtStorageMigrateConfig.HZf);
    paramArrayOfString.HZi = bool1;
    ExtStorageMigrateRoutine.startMigration(paramContext, paramArrayOfString.fje(), new ExtStorageMigrateTestCommand.1(this, paramContext));
    AppMethodBeat.o(211087);
    return true;
    new CancellationSignal();
    h.LTJ.aU(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211086);
        try
        {
          com.tencent.mm.vfs.a.gzU().aC(0L, 0L);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211084);
              Toast.makeText(c.1.this.val$context, "Done.", 1).show();
              AppMethodBeat.o(211084);
            }
          });
          AppMethodBeat.o(211086);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", localThrowable, "[-] Error happened.", new Object[0]);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211085);
              Toast.makeText(c.1.this.val$context, "Error happened.", 1).show();
              AppMethodBeat.o(211085);
            }
          });
          AppMethodBeat.o(211086);
        }
      }
    });
    AppMethodBeat.o(211087);
    return true;
    ax.aQz("extmig_switch_storage").encode("is_routine_enabled", true);
    Toast.makeText(paramContext, "Switch on done.", 1).show();
    AppMethodBeat.o(211087);
    return true;
    ax.aQz("extmig_status_memo_storage").clear().commit();
    ax.aQz("extmig_switch_storage").clear().commit();
    Toast.makeText(paramContext, "Reset done.", 1).show();
    AppMethodBeat.o(211087);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.c
 * JD-Core Version:    0.7.0.1
 */