package com.tencent.mm.sdk.h;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Field;

public final class e
{
  public static boolean fqt()
  {
    boolean bool1 = false;
    AppMethodBeat.i(153483);
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
        ae.printErrStackTrace("MicroMsg.Vendor.Oppo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(153483);
    return bool1;
  }
  
  public static boolean jy(Context paramContext)
  {
    AppMethodBeat.i(153482);
    if (paramContext == null)
    {
      AppMethodBeat.o(153482);
      return false;
    }
    boolean bool = paramContext.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    AppMethodBeat.o(153482);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.h.e
 * JD-Core Version:    0.7.0.1
 */