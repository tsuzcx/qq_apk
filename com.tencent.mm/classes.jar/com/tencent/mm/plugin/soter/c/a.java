package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public enum a
{
  private a() {}
  
  public static c a(Activity paramActivity, j paramj, k paramk, Handler paramHandler)
  {
    if (((paramj.psn & 0x1) != 0) && (com.tencent.soter.core.a.hF(ae.getContext()))) {
      return new b(new WeakReference(paramActivity), paramj, paramk, paramHandler);
    }
    y.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", new Object[] { Byte.valueOf(paramj.psn) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.c.a
 * JD-Core Version:    0.7.0.1
 */