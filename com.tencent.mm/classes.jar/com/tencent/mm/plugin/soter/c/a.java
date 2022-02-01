package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.WeakReference;

public enum a
{
  static
  {
    AppMethodBeat.i(145940);
    znh = new a("IML");
    zni = new a[] { znh };
    AppMethodBeat.o(145940);
  }
  
  private a() {}
  
  public static c a(Activity paramActivity, j paramj, k paramk, Handler paramHandler)
  {
    AppMethodBeat.i(145939);
    if (((paramj.znG & 0x1) != 0) && (com.tencent.soter.core.a.fb(ai.getContext())))
    {
      paramActivity = new b(new WeakReference(paramActivity), paramj, paramk, paramHandler);
      AppMethodBeat.o(145939);
      return paramActivity;
    }
    ac.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[] { Byte.valueOf(paramj.znG) });
    AppMethodBeat.o(145939);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.a
 * JD-Core Version:    0.7.0.1
 */