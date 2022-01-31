package com.tencent.mm.sdk.h;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

public final class d
{
  public static boolean duR()
  {
    boolean bool1 = false;
    AppMethodBeat.i(154711);
    try
    {
      Class localClass = Class.forName("oppo.content.res.OppoFontUtils");
      boolean bool2 = localClass.getField("isFlipFontUsed").getBoolean(localClass);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Vendor.Oppo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(154711);
    return bool1;
  }
  
  public static boolean ht(Context paramContext)
  {
    AppMethodBeat.i(65376);
    if (paramContext == null)
    {
      AppMethodBeat.o(65376);
      return false;
    }
    boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    AppMethodBeat.o(65376);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.d
 * JD-Core Version:    0.7.0.1
 */