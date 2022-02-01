package com.tencent.mm.sdk.vendor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;

public class Oppo
{
  private static final String TAG = "MicroMsg.Vendor.Oppo";
  public static Boolean _isUnDefaultFont = null;
  
  public static boolean isUnDefaultFont()
  {
    AppMethodBeat.i(153483);
    boolean bool;
    if (_isUnDefaultFont != null)
    {
      bool = _isUnDefaultFont.booleanValue();
      AppMethodBeat.o(153483);
      return bool;
    }
    _isUnDefaultFont = Boolean.FALSE;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT <= 29) {
          continue;
        }
        localObject = "oplus.content.res.OplusFontUtils";
        localObject = Class.forName((String)localObject);
        _isUnDefaultFont = Boolean.valueOf(((Class)localObject).getField("isFlipFontUsed").getBoolean(localObject));
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.printErrStackTrace("MicroMsg.Vendor.Oppo", localException, "", new Object[0]);
        continue;
        AppMethodBeat.o(153483);
      }
      if (_isUnDefaultFont == null) {
        continue;
      }
      bool = _isUnDefaultFont.booleanValue();
      AppMethodBeat.o(153483);
      return bool;
      localObject = "oppo.content.res.OppoFontUtils";
    }
    return false;
  }
  
  public static boolean oppohasCutOut(Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.vendor.Oppo
 * JD-Core Version:    0.7.0.1
 */