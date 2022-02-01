package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;

public final class b
{
  private static int pEj;
  private static int pEk;
  public int JDQ;
  public int JDR;
  public long JDS;
  public long JDT;
  public SnsInfo Jzk;
  
  public static int fKO()
  {
    AppMethodBeat.i(209659);
    int i = 0;
    try
    {
      boolean bool = ar.isDarkMode();
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AdExposureParams", "getDarkModeStatus exp=" + localThrowable.toString());
      }
      AppMethodBeat.o(209659);
    }
    if (i != 0)
    {
      AppMethodBeat.o(209659);
      return 2;
    }
    return 1;
  }
  
  public static int getScreenHeight()
  {
    AppMethodBeat.i(209654);
    if (pEk == 0) {}
    try
    {
      int[] arrayOfInt = ao.ib(MMApplicationContext.getContext());
      pEj = arrayOfInt[0];
      pEk = arrayOfInt[1];
      int i = pEk;
      AppMethodBeat.o(209654);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AdExposureParams", "getScreenHeight exp=" + localThrowable.toString());
      }
    }
  }
  
  public static int getScreenWidth()
  {
    AppMethodBeat.i(209656);
    if (pEj == 0) {}
    try
    {
      int[] arrayOfInt = ao.ib(MMApplicationContext.getContext());
      pEj = arrayOfInt[0];
      pEk = arrayOfInt[1];
      int i = pEj;
      AppMethodBeat.o(209656);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AdExposureParams", "getScreenWidth exp=" + localThrowable.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.b
 * JD-Core Version:    0.7.0.1
 */