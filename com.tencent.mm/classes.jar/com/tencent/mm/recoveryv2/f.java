package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193933);
    Log.i(paramString1, paramString2);
    a.a.log(4, paramString1, paramString2);
    AppMethodBeat.o(193933);
  }
  
  public static void iL(Context paramContext)
  {
    AppMethodBeat.i(193936);
    i("MicroMsg.recovery.logger", "flush recovery log to file");
    Object localObject = h.c.iP(paramContext);
    ((h.c)localObject).guM();
    d.cg(paramContext).CN("RECOVERY");
    localObject = ((h.c)localObject).guN();
    paramContext = (Context)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramContext = "nothing";
    }
    Log.i("MicroMsg.recovery.logger", ">>>>> dump recovery internal log (:recovery) <<<<<");
    Log.i("MicroMsg.recovery.logger", "\n".concat(String.valueOf(paramContext)));
    Log.i("MicroMsg.recovery.logger", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
    Log.appenderFlush();
    AppMethodBeat.o(193936);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193934);
    Log.w(paramString1, paramString2);
    a.a.log(5, paramString1, paramString2);
    AppMethodBeat.o(193934);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(193935);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    a.w(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(193935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.f
 * JD-Core Version:    0.7.0.1
 */