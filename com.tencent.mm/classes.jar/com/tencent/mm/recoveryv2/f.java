package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
{
  public static void hM(Context paramContext)
  {
    AppMethodBeat.i(192855);
    i("MicroMsg.recovery.logger", "flush recovery log to file");
    paramContext = h.c.hQ(paramContext);
    paramContext.fhj();
    String str = paramContext.fhk();
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = "nothing";
    }
    ad.i("MicroMsg.recovery.logger", ">>>>>>>>>> dump recovery internal log: <<<<<<<<<<");
    ad.i("MicroMsg.recovery.logger", "\n".concat(String.valueOf(paramContext)));
    ad.i("MicroMsg.recovery.logger", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<");
    AppMethodBeat.o(192855);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192852);
    ad.i(paramString1, paramString2);
    a.a.log(4, paramString1, paramString2);
    AppMethodBeat.o(192852);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192853);
    ad.w(paramString1, paramString2);
    a.a.log(5, paramString1, paramString2);
    AppMethodBeat.o(192853);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(192854);
    ad.printErrStackTrace(paramString1, paramThrowable, paramString2, new Object[0]);
    a.w(paramString1, paramString2, paramThrowable);
    AppMethodBeat.o(192854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.f
 * JD-Core Version:    0.7.0.1
 */