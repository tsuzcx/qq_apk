package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;

public enum a
{
  static
  {
    AppMethodBeat.i(145940);
    Fhx = new a("IML");
    Fhy = new a[] { Fhx };
    AppMethodBeat.o(145940);
  }
  
  private a() {}
  
  public static c a(Activity paramActivity, j paramj, k paramk, Handler paramHandler)
  {
    AppMethodBeat.i(145939);
    if (((paramj.FhV & 0x1) != 0) && (com.tencent.soter.core.a.fN(MMApplicationContext.getContext())))
    {
      paramActivity = new b(new WeakReference(paramActivity), paramj, paramk, paramHandler);
      AppMethodBeat.o(145939);
      return paramActivity;
    }
    Log.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[] { Byte.valueOf(paramj.FhV) });
    AppMethodBeat.o(145939);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.a
 * JD-Core Version:    0.7.0.1
 */