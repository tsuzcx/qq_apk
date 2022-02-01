package com.tencent.mm.sdcard_migrate.util;

import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a;
import com.tencent.mm.sdcard_migrate.MigrateResultCallback;

public final class a
{
  public static void a(MigrateResultCallback paramMigrateResultCallback, int paramInt)
  {
    AppMethodBeat.i(196894);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.VY(paramInt);
        }
        AppMethodBeat.o(196894);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(196894);
  }
  
  public static void a(MigrateResultCallback paramMigrateResultCallback, int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(196896);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.b(paramInt, new ExtStorageMigrateException(paramThrowable));
        }
        AppMethodBeat.o(196896);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(196896);
  }
  
  public static void b(MigrateResultCallback paramMigrateResultCallback, int paramInt)
  {
    AppMethodBeat.i(196895);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.VZ(paramInt);
        }
        AppMethodBeat.o(196895);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.eEi().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(196895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.util.a
 * JD-Core Version:    0.7.0.1
 */