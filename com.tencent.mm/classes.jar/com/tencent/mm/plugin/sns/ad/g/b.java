package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;

public final class b
{
  private static int mEX;
  private static int mEY;
  public SnsInfo DsC;
  public int Dus;
  public int Dut;
  public long Duu;
  public long Duv;
  
  public static int eXn()
  {
    AppMethodBeat.i(202032);
    int i = 0;
    try
    {
      boolean bool = ao.isDarkMode();
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("AdExposureParams", "getDarkModeStatus exp=" + localThrowable.toString());
      }
      AppMethodBeat.o(202032);
    }
    if (i != 0)
    {
      AppMethodBeat.o(202032);
      return 2;
    }
    return 1;
  }
  
  public static int getScreenHeight()
  {
    AppMethodBeat.i(202030);
    if (mEY == 0) {}
    try
    {
      int[] arrayOfInt = ap.ha(MMApplicationContext.getContext());
      mEX = arrayOfInt[0];
      mEY = arrayOfInt[1];
      int i = mEY;
      AppMethodBeat.o(202030);
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
    AppMethodBeat.i(202031);
    if (mEX == 0) {}
    try
    {
      int[] arrayOfInt = ap.ha(MMApplicationContext.getContext());
      mEX = arrayOfInt[0];
      mEY = arrayOfInt[1];
      int i = mEX;
      AppMethodBeat.o(202031);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.b
 * JD-Core Version:    0.7.0.1
 */