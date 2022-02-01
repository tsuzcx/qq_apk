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
    AppMethodBeat.i(195914);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.Yh(paramInt);
        }
        AppMethodBeat.o(195914);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(195914);
  }
  
  public static void a(MigrateResultCallback paramMigrateResultCallback, int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(195916);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.b(paramInt, new ExtStorageMigrateException(paramThrowable));
        }
        AppMethodBeat.o(195916);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(195916);
  }
  
  public static void b(MigrateResultCallback paramMigrateResultCallback, int paramInt)
  {
    AppMethodBeat.i(195915);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.Yi(paramInt);
        }
        AppMethodBeat.o(195915);
        return;
      }
      catch (Throwable paramMigrateResultCallback)
      {
        ExtStorageMigrateMonitor.eTC().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(195915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.util.a
 * JD-Core Version:    0.7.0.1
 */