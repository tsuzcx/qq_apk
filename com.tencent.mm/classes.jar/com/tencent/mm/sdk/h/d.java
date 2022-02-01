package com.tencent.mm.sdk.h;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  private static Boolean Iib = null;
  private static String TAG = "MicroMsg.Vendor.OnePlus";
  
  public static boolean fmx()
  {
    AppMethodBeat.i(177603);
    if (Iib == null)
    {
      String str = Build.BRAND;
      ad.i(TAG, "Build.BRAND = %s", new Object[] { str });
      if (!str.toLowerCase().contains("oneplus")) {
        break label63;
      }
    }
    label63:
    for (Iib = Boolean.TRUE;; Iib = Boolean.FALSE)
    {
      boolean bool = Iib.booleanValue();
      AppMethodBeat.o(177603);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.d
 * JD-Core Version:    0.7.0.1
 */