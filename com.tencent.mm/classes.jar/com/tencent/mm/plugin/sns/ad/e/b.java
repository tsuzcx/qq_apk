package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;

public final class b
{
  private static int lxZ;
  private static int lya;
  public p znm;
  public int zog;
  public int zoh;
  public long zoi;
  public long zoj;
  
  public static int dUU()
  {
    AppMethodBeat.i(219061);
    int i = 0;
    try
    {
      boolean bool = al.isDarkMode();
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("AdExposureParams", "getDarkModeStatus exp=" + localThrowable.toString());
      }
      AppMethodBeat.o(219061);
    }
    if (i != 0)
    {
      AppMethodBeat.o(219061);
      return 2;
    }
    return 1;
  }
  
  public static int getScreenHeight()
  {
    AppMethodBeat.i(219059);
    if (lya == 0) {}
    try
    {
      int[] arrayOfInt = an.gp(ak.getContext());
      lxZ = arrayOfInt[0];
      lya = arrayOfInt[1];
      int i = lya;
      AppMethodBeat.o(219059);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("AdExposureParams", "getScreenHeight exp=" + localThrowable.toString());
      }
    }
  }
  
  public static int getScreenWidth()
  {
    AppMethodBeat.i(219060);
    if (lxZ == 0) {}
    try
    {
      int[] arrayOfInt = an.gp(ak.getContext());
      lxZ = arrayOfInt[0];
      lya = arrayOfInt[1];
      int i = lxZ;
      AppMethodBeat.o(219060);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.e("AdExposureParams", "getScreenWidth exp=" + localThrowable.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.b
 * JD-Core Version:    0.7.0.1
 */