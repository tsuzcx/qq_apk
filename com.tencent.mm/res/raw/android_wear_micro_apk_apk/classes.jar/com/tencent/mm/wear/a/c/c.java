package com.tencent.mm.wear.a.c;

import android.os.Process;
import android.util.Log;
import com.tencent.mm.wear.app.b.h;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c
  implements e
{
  private f amB;
  private SimpleDateFormat amC;
  
  public c()
  {
    File localFile = new File(h.mW(), "log.log");
    if (localFile.length() > 5242880L) {
      localFile.delete();
    }
    this.amB = new f(localFile.getAbsolutePath());
    this.amC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
  }
  
  private String b(String paramString1, String paramString2, String paramString3)
  {
    String str = this.amC.format(new Date());
    return String.format("[%s][%s][%d][%d][%s]: %s\n​​", new Object[] { paramString1, paramString2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), str, paramString3 });
  }
  
  public final void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(b("E", paramString1, String.format(paramString2, paramVarArgs)), false);
  }
  
  public final void a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    paramString2 = String.format(paramString2, paramVarArgs);
    a(b("E", paramString1, paramString2 + "  " + Log.getStackTraceString(paramThrowable)), false);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    try
    {
      this.amB.a(paramString.getBytes(), paramBoolean);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(b("W", paramString1, String.format(paramString2, paramVarArgs)), false);
  }
  
  public final void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(b("I", paramString1, String.format(paramString2, paramVarArgs)), false);
  }
  
  public final void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(b("D", paramString1, String.format(paramString2, paramVarArgs)), false);
  }
  
  public final void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(b("V", paramString1, String.format(paramString2, paramVarArgs)), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.c.c
 * JD-Core Version:    0.7.0.1
 */