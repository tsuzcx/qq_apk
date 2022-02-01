package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;

public final class b
{
  private static int ltA;
  private static int ltB;
  public int yXE;
  public p yXF;
  public int yXG;
  public long yXH;
  public long yXI;
  
  public static int dRw()
  {
    AppMethodBeat.i(197600);
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
        ad.e("AdExposureParams", "getDarkModeStatus exp=" + localThrowable.toString());
      }
      AppMethodBeat.o(197600);
    }
    if (i != 0)
    {
      AppMethodBeat.o(197600);
      return 2;
    }
    return 1;
  }
  
  public static int getScreenHeight()
  {
    AppMethodBeat.i(197598);
    if (ltB == 0) {}
    try
    {
      int[] arrayOfInt = am.gk(aj.getContext());
      ltA = arrayOfInt[0];
      ltB = arrayOfInt[1];
      int i = ltB;
      AppMethodBeat.o(197598);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("AdExposureParams", "getScreenHeight exp=" + localThrowable.toString());
      }
    }
  }
  
  public static int getScreenWidth()
  {
    AppMethodBeat.i(197599);
    if (ltA == 0) {}
    try
    {
      int[] arrayOfInt = am.gk(aj.getContext());
      ltA = arrayOfInt[0];
      ltB = arrayOfInt[1];
      int i = ltA;
      AppMethodBeat.o(197599);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.e("AdExposureParams", "getScreenWidth exp=" + localThrowable.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.b
 * JD-Core Version:    0.7.0.1
 */