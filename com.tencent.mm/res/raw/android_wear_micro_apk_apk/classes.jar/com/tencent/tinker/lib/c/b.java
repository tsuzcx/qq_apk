package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.Intent;
import java.io.File;

public final class b
  implements d
{
  private static boolean ank = false;
  protected final Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(File paramFile, Throwable paramThrowable)
  {
    com.tencent.tinker.lib.e.a.c("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", new Object[] { paramFile.getAbsolutePath(), paramThrowable.getMessage() });
    com.tencent.tinker.lib.e.a.a("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
    com.tencent.tinker.lib.e.a.a("Tinker.DefaultPatchReporter", paramThrowable, "tinker patch exception", new Object[0]);
    com.tencent.tinker.lib.d.a.E(this.context).oM();
    com.tencent.tinker.lib.d.a.E(this.context).d(paramFile);
  }
  
  public final void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    com.tencent.tinker.lib.e.a.c("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", new Object[] { paramFile.getAbsolutePath(), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if (!ank) {
      com.tencent.tinker.lib.e.d.I(this.context).oQ();
    }
  }
  
  public final void i(Intent paramIntent)
  {
    com.tencent.tinker.lib.e.a.c("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
    ank = false;
    com.tencent.tinker.lib.e.d.I(this.context).i(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.c.b
 * JD-Core Version:    0.7.0.1
 */