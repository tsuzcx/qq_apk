package com.tencent.recovery.a;

import android.os.Process;
import android.util.Log;
import com.tencent.recovery.d.a;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c
  implements e
{
  private SimpleDateFormat amC;
  private boolean amE;
  private a amR;
  
  private String b(String paramString1, String paramString2, String paramString3)
  {
    String str = this.amC.format(new Date());
    return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[] { paramString1, paramString2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), str, paramString3 });
  }
  
  public final void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(b("E", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.amE) {
      Log.e(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
  
  public final void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    String str = String.format(paramString2, paramVarArgs);
    a(b("E", paramString1, str + "  " + Log.getStackTraceString(paramThrowable)), false);
    if (this.amE) {
      Log.e(paramString1, String.format(paramString2, paramVarArgs), paramThrowable);
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    this.amR.a(paramString.getBytes(), paramBoolean);
  }
  
  public final void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(b("I", paramString1, String.format(paramString2, paramVarArgs)), false);
    if (this.amE) {
      Log.d(paramString1, String.format(paramString2, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.recovery.a.c
 * JD-Core Version:    0.7.0.1
 */