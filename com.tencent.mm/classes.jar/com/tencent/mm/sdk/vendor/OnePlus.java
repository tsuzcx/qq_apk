package com.tencent.mm.sdk.vendor;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class OnePlus
{
  private static String TAG = "MicroMsg.Vendor.OnePlus";
  private static Boolean ifOnePlus = null;
  
  public static boolean isOnePlus()
  {
    AppMethodBeat.i(177603);
    if (ifOnePlus == null)
    {
      String str = Build.BRAND;
      Log.i(TAG, "Build.BRAND = %s", new Object[] { str });
      if (!str.toLowerCase().contains("oneplus")) {
        break label63;
      }
    }
    label63:
    for (ifOnePlus = Boolean.TRUE;; ifOnePlus = Boolean.FALSE)
    {
      boolean bool = ifOnePlus.booleanValue();
      AppMethodBeat.o(177603);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.OnePlus
 * JD-Core Version:    0.7.0.1
 */