package com.tencent.mm.sdk.h;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
{
  private static Boolean Gwh = null;
  private static String TAG = "MicroMsg.Vendor.OnePlus";
  
  public static boolean eWN()
  {
    AppMethodBeat.i(177603);
    if (Gwh == null)
    {
      String str = Build.BRAND;
      ac.i(TAG, "Build.BRAND = %s", new Object[] { str });
      if (!str.toLowerCase().contains("oneplus")) {
        break label63;
      }
    }
    label63:
    for (Gwh = Boolean.TRUE;; Gwh = Boolean.FALSE)
    {
      boolean bool = Gwh.booleanValue();
      AppMethodBeat.o(177603);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.d
 * JD-Core Version:    0.7.0.1
 */