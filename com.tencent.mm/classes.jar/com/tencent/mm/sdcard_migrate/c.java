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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;

@SuppressLint({"NewApi"})
public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(195853);
    b.a(new c(), new String[] { "//extmig" });
    AppMethodBeat.o(195853);
  }
  
  public static void init() {}
  
  public final boolean a(final Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(195852);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      AppMethodBeat.o(195852);
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
        AppMethodBeat.o(195852);
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
    paramArrayOfString = new ExtStorageMigrateConfig.a(ExtStorageMigrateConfig.Gns);
    paramArrayOfString.Gnv = bool1;
    ExtStorageMigrateRoutine.startMigration(paramContext, paramArrayOfString.eTB(), new ExtStorageMigrateTestCommand.1(this, paramContext));
    AppMethodBeat.o(195852);
    return true;
    new CancellationSignal();
    h.JZN.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195851);
        try
        {
          com.tencent.mm.vfs.a.ghk().ax(0L, 0L);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195849);
              Toast.makeText(c.1.this.val$context, "Done.", 1).show();
              AppMethodBeat.o(195849);
            }
          });
          AppMethodBeat.o(195851);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", localThrowable, "[-] Error happened.", new Object[0]);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195850);
              Toast.makeText(c.1.this.val$context, "Error happened.", 1).show();
              AppMethodBeat.o(195850);
            }
          });
          AppMethodBeat.o(195851);
        }
      }
    });
    AppMethodBeat.o(195852);
    return true;
    aw.aKT("extmig_switch_storage").encode("is_routine_enabled", true);
    Toast.makeText(paramContext, "Switch on done.", 1).show();
    AppMethodBeat.o(195852);
    return true;
    aw.aKT("extmig_status_memo_storage").clear().commit();
    aw.aKT("extmig_switch_storage").clear().commit();
    Toast.makeText(paramContext, "Reset done.", 1).show();
    AppMethodBeat.o(195852);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.c
 * JD-Core Version:    0.7.0.1
 */