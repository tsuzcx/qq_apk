package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

public enum a
{
  static
  {
    AppMethodBeat.i(145940);
    AWE = new a("IML");
    AWF = new a[] { AWE };
    AppMethodBeat.o(145940);
  }
  
  private a() {}
  
  public static c a(Activity paramActivity, j paramj, k paramk, Handler paramHandler)
  {
    AppMethodBeat.i(145939);
    if (((paramj.AXd & 0x1) != 0) && (com.tencent.soter.core.a.fi(ak.getContext())))
    {
      paramActivity = new b(new WeakReference(paramActivity), paramj, paramk, paramHandler);
      AppMethodBeat.o(145939);
      return paramActivity;
    }
    ae.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[] { Byte.valueOf(paramj.AXd) });
    AppMethodBeat.o(145939);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.a
 * JD-Core Version:    0.7.0.1
 */