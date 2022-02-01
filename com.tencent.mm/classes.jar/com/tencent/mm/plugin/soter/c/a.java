package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.model.g;
import com.tencent.mm.plugin.soter.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public enum a
{
  static
  {
    AppMethodBeat.i(145940);
    RZB = new a("IML");
    RZC = new a[] { RZB };
    AppMethodBeat.o(145940);
  }
  
  private a() {}
  
  public static c a(Activity paramActivity, g paramg, h paramh, Handler paramHandler)
  {
    AppMethodBeat.i(145939);
    if (((paramg.RZZ & 0x1) != 0) && (com.tencent.soter.core.a.hC(MMApplicationContext.getContext())))
    {
      paramActivity = new b(new WeakReference(paramActivity), paramg, paramh, paramHandler);
      AppMethodBeat.o(145939);
      return paramActivity;
    }
    Log.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[] { Byte.valueOf(paramg.RZZ) });
    AppMethodBeat.o(145939);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.a
 * JD-Core Version:    0.7.0.1
 */