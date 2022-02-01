package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;

public final class b
{
  private static int pvg;
  private static int sJv;
  public SnsInfo PNI;
  public int PUQ = 0;
  public int PUR;
  public int PUS;
  public long PUU;
  public long PUV;
  
  public static int getScreenHeight()
  {
    AppMethodBeat.i(309905);
    if (pvg == 0) {}
    try
    {
      int[] arrayOfInt = ar.jR(MMApplicationContext.getContext());
      sJv = arrayOfInt[0];
      pvg = arrayOfInt[1];
      int i = pvg;
      AppMethodBeat.o(309905);
      return i;
    }
    finally
    {
      for (;;)
      {
        Log.e("AdExposureParams", "getScreenHeight exp=" + localObject.toString());
      }
    }
  }
  
  public static int getScreenWidth()
  {
    AppMethodBeat.i(309906);
    if (sJv == 0) {}
    try
    {
      int[] arrayOfInt = ar.jR(MMApplicationContext.getContext());
      sJv = arrayOfInt[0];
      pvg = arrayOfInt[1];
      int i = sJv;
      AppMethodBeat.o(309906);
      return i;
    }
    finally
    {
      for (;;)
      {
        Log.e("AdExposureParams", "getScreenWidth exp=" + localObject.toString());
      }
    }
  }
  
  public static int hbf()
  {
    AppMethodBeat.i(309908);
    int i = 0;
    try
    {
      boolean bool = aw.isDarkMode();
      i = bool;
    }
    finally
    {
      for (;;)
      {
        Log.e("AdExposureParams", "getDarkModeStatus exp=" + localObject.toString());
      }
      AppMethodBeat.o(309908);
    }
    if (i != 0)
    {
      AppMethodBeat.o(309908);
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.b
 * JD-Core Version:    0.7.0.1
 */