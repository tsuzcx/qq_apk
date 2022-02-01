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
    AppMethodBeat.i(257184);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.aye(paramInt);
        }
        AppMethodBeat.o(257184);
        return;
      }
      finally
      {
        ExtStorageMigrateMonitor.iSO().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(257184);
  }
  
  public static void a(MigrateResultCallback paramMigrateResultCallback, int paramInt, Throwable paramThrowable)
  {
    AppMethodBeat.i(257196);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.b(paramInt, new ExtStorageMigrateException(paramThrowable));
        }
        AppMethodBeat.o(257196);
        return;
      }
      finally
      {
        ExtStorageMigrateMonitor.iSO().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(257196);
  }
  
  public static void b(MigrateResultCallback paramMigrateResultCallback, int paramInt)
  {
    AppMethodBeat.i(257190);
    if (paramMigrateResultCallback != null) {
      try
      {
        if (paramMigrateResultCallback.asBinder().isBinderAlive()) {
          paramMigrateResultCallback.ayf(paramInt);
        }
        AppMethodBeat.o(257190);
        return;
      }
      finally
      {
        ExtStorageMigrateMonitor.iSO().printErrStackTrace("MicroMsg.MigrateResultCallbackHelper", paramMigrateResultCallback, "[-] Exception occurred.", new Object[0]);
      }
    }
    AppMethodBeat.o(257190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.util.a
 * JD-Core Version:    0.7.0.1
 */