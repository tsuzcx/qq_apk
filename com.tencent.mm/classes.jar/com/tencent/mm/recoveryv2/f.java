package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
{
  public static void hS(Context paramContext)
  {
    AppMethodBeat.i(186179);
    i("MicroMsg.recovery.logger", "flush recovery log to file");
    Object localObject = h.c.hW(paramContext);
    ((h.c)localObject).flb();
    d.bL(paramContext).ux("RECOVERY");
    localObject = ((h.c)localObject).flc();
    paramContext = (Context)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramContext = "nothing";
    }
    ae.i("MicroMsg.recovery.logger", ">>>>> dump recovery internal log (:recovery) <<<<<");
    ae.i("MicroMsg.recovery.logger", "\n".concat(String.valueOf(paramContext)));
    ae.i("MicroMsg.recovery.logger", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
    ae.foo();
    AppMethodBeat.o(186179);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186176);
    ae.i(paramString1, paramString2);
    a.a.log(4, paramString1, paramString2);
    AppMethodBeat.o(186176);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186177);
    ae.w(paramString1, paramString2);
    a.a.log(5, paramString1, paramString2);
    AppMethodBeat.o(186177);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(186178);
    ae.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    a.w(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(186178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.f
 * JD-Core Version:    0.7.0.1
 */