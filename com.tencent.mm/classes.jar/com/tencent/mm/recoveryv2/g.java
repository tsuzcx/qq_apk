package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
{
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202564);
    Log.i(paramString1, paramString2);
    a.i(paramString1, paramString2);
    AppMethodBeat.o(202564);
  }
  
  public static void jO(Context paramContext)
  {
    AppMethodBeat.i(202572);
    i("MicroMsg.recovery.logger", "flush recovery log to file");
    Object localObject = i.c.jS(paramContext);
    ((i.c)localObject).hqu();
    d.cc(paramContext).JC("RECOVERY");
    localObject = ((i.c)localObject).hqv();
    paramContext = (Context)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramContext = "nothing";
    }
    Log.i("MicroMsg.recovery.logger", ">>>>> dump recovery internal log (:recovery) <<<<<");
    Log.i("MicroMsg.recovery.logger", "\n".concat(String.valueOf(paramContext)));
    Log.i("MicroMsg.recovery.logger", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
    Log.appenderFlush();
    AppMethodBeat.o(202572);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202567);
    Log.w(paramString1, paramString2);
    a.w(paramString1, paramString2);
    AppMethodBeat.o(202567);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(202569);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    a.w(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(202569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.g
 * JD-Core Version:    0.7.0.1
 */