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
    AppMethodBeat.i(211151);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.aam(paramInt);
        }
        AppMethodBeat.o(211151);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.fjf().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(211151);
  }
  
  public static void a(MigrateResultCallback paramMigrateResultCallback, int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(211153);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.b(paramInt, new ExtStorageMigrateException(paramThrowable));
        }
        AppMethodBeat.o(211153);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.fjf().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(211153);
  }
  
  public static void b(MigrateResultCallback paramMigrateResultCallback, int paramInt)
  {
    AppMethodBeat.i(211152);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.aan(paramInt);
        }
        AppMethodBeat.o(211152);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.fjf().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(211152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.util.a
 * JD-Core Version:    0.7.0.1
 */