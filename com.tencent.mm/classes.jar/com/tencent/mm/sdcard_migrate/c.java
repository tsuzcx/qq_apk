package com.tencent.mm.sdcard_migrate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.CancellationSignal;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.vfs.e;

@SuppressLint({"NewApi"})
public final class c
  implements a
{
  static
  {
    AppMethodBeat.i(211872);
    b.a(new c(), new String[] { "//extmig" });
    AppMethodBeat.o(211872);
  }
  
  public static void init() {}
  
  public final boolean a(final Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(211871);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      AppMethodBeat.o(211871);
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
        AppMethodBeat.o(211871);
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
    paramArrayOfString = new ExtStorageMigrateConfig.a(ExtStorageMigrateConfig.Itm);
    paramArrayOfString.Itp = bool1;
    ExtStorageMigrateRoutine.startMigration(paramContext, paramArrayOfString.fmW(), new ExtStorageMigrateTestCommand.1(this, paramContext));
    AppMethodBeat.o(211871);
    return true;
    new CancellationSignal();
    h.MqF.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211870);
        try
        {
          e.fSU().aB(0L, 0L);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211868);
              Toast.makeText(c.1.this.val$context, "Done.", 1).show();
              AppMethodBeat.o(211868);
            }
          });
          AppMethodBeat.o(211870);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", localThrowable, "[-] Error happened.", new Object[0]);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211869);
              Toast.makeText(c.1.this.val$context, "Error happened.", 1).show();
              AppMethodBeat.o(211869);
            }
          });
          AppMethodBeat.o(211870);
        }
      }
    });
    AppMethodBeat.o(211871);
    return true;
    ay.aRW("extmig_switch_storage").encode("is_routine_enabled", true);
    Toast.makeText(paramContext, "Switch on done.", 1).show();
    AppMethodBeat.o(211871);
    return true;
    ay.aRW("extmig_status_memo_storage").clear().commit();
    ay.aRW("extmig_switch_storage").clear().commit();
    Toast.makeText(paramContext, "Reset done.", 1).show();
    AppMethodBeat.o(211871);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.c
 * JD-Core Version:    0.7.0.1
 */