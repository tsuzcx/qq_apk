package com.tencent.mm.sdk.h;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
{
  private static Boolean ICm = null;
  private static String TAG = "MicroMsg.Vendor.OnePlus";
  
  public static boolean fqs()
  {
    AppMethodBeat.i(177603);
    if (ICm == null)
    {
      String str = Build.BRAND;
      ae.i(TAG, "Build.BRAND = %s", new Object[] { str });
      if (!str.toLowerCase().contains("oneplus")) {
        break label63;
      }
    }
    label63:
    for (ICm = Boolean.TRUE;; ICm = Boolean.FALSE)
    {
      boolean bool = ICm.booleanValue();
      AppMethodBeat.o(177603);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.d
 * JD-Core Version:    0.7.0.1
 */