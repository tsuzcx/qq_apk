package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;

public enum a
{
  static
  {
    AppMethodBeat.i(145940);
    AFb = new a("IML");
    AFc = new a[] { AFb };
    AppMethodBeat.o(145940);
  }
  
  private a() {}
  
  public static c a(Activity paramActivity, j paramj, k paramk, Handler paramHandler)
  {
    AppMethodBeat.i(145939);
    if (((paramj.AFA & 0x1) != 0) && (com.tencent.soter.core.a.fe(aj.getContext())))
    {
      paramActivity = new b(new WeakReference(paramActivity), paramj, paramk, paramHandler);
      AppMethodBeat.o(145939);
      return paramActivity;
    }
    ad.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[] { Byte.valueOf(paramj.AFA) });
    AppMethodBeat.o(145939);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.a
 * JD-Core Version:    0.7.0.1
 */