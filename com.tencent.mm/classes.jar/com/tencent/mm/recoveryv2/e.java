package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
{
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(237917);
    Log.i(paramString1, paramString2);
    k.b.a.log(4, paramString1, paramString2);
    AppMethodBeat.o(237917);
  }
  
  public static void lO(Context paramContext)
  {
    AppMethodBeat.i(237943);
    i("MicroMsg.recovery.logger", "flush recovery log to file");
    Object localObject = h.c.lU(paramContext);
    ((h.c)localObject).iQN();
    d.cO(paramContext).Ci("RECOVERY");
    localObject = ((h.c)localObject).iQO();
    paramContext = (Context)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramContext = "nothing";
    }
    Log.i("MicroMsg.recovery.logger", ">>>>> dump recovery internal log (:recovery) <<<<<");
    Log.i("MicroMsg.recovery.logger", "\n".concat(String.valueOf(paramContext)));
    Log.i("MicroMsg.recovery.logger", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
    Log.appenderFlush();
    AppMethodBeat.o(237943);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(237923);
    Log.w(paramString1, paramString2);
    k.b.a.log(5, paramString1, paramString2);
    AppMethodBeat.o(237923);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(237930);
    Log.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    k.b.w(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(237930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.e
 * JD-Core Version:    0.7.0.1
 */