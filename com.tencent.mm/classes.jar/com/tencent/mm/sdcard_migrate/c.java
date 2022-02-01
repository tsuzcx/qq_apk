package com.tencent.mm.sdcard_migrate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.CancellationSignal;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

@SuppressLint({"NewApi"})
public final class c
  implements a
{
  static
  {
    AppMethodBeat.i(191664);
    b.a(new c(), new String[] { "//extmig" });
    AppMethodBeat.o(191664);
  }
  
  public static void init() {}
  
  public final boolean a(final Context paramContext, String[] paramArrayOfString, String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(191660);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      AppMethodBeat.o(191660);
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
        AppMethodBeat.o(191660);
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
    paramArrayOfString = new ExtStorageMigrateConfig.a(ExtStorageMigrateConfig.UUm);
    paramArrayOfString.UUp = bool1;
    ExtStorageMigrateRoutine.startMigration(paramContext, paramArrayOfString.hsI(), new ExtStorageMigrateTestCommand.1(this, paramContext));
    AppMethodBeat.o(191660);
    return true;
    new CancellationSignal();
    com.tencent.e.h.ZvG.bh(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192458);
        try
        {
          com.tencent.mm.vfs.h.iWH().bh(0L, 0L);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192195);
              Toast.makeText(c.1.this.val$context, "Done.", 1).show();
              AppMethodBeat.o(192195);
            }
          });
          AppMethodBeat.o(192458);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", localThrowable, "[-] Error happened.", new Object[0]);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192364);
              Toast.makeText(c.1.this.val$context, "Error happened.", 1).show();
              AppMethodBeat.o(192364);
            }
          });
          AppMethodBeat.o(192458);
        }
      }
    });
    AppMethodBeat.o(191660);
    return true;
    MultiProcessMMKV.getMMKV("extmig_switch_storage").encode("is_routine_enabled", true);
    Toast.makeText(paramContext, "Switch on done.", 1).show();
    AppMethodBeat.o(191660);
    return true;
    MultiProcessMMKV.getMMKV("extmig_status_memo_storage").clear().commit();
    MultiProcessMMKV.getMMKV("extmig_switch_storage").clear().commit();
    Toast.makeText(paramContext, "Reset done.", 1).show();
    AppMethodBeat.o(191660);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.c
 * JD-Core Version:    0.7.0.1
 */