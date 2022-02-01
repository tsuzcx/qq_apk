package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;

public final class b
{
  private static int kWB;
  private static int kWC;
  public int xIp;
  public p xIq;
  public int xIr;
  public long xIs;
  public long xIt;
  
  public static int dFE()
  {
    AppMethodBeat.i(199957);
    int i = 0;
    try
    {
      boolean bool = aj.DT();
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("AdExposureParams", "getDarkModeStatus exp=" + localThrowable.toString());
      }
      AppMethodBeat.o(199957);
    }
    if (i != 0)
    {
      AppMethodBeat.o(199957);
      return 2;
    }
    return 1;
  }
  
  public static int getScreenHeight()
  {
    AppMethodBeat.i(199955);
    if (kWC == 0) {}
    try
    {
      int[] arrayOfInt = al.gg(ai.getContext());
      kWB = arrayOfInt[0];
      kWC = arrayOfInt[1];
      int i = kWC;
      AppMethodBeat.o(199955);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("AdExposureParams", "getScreenHeight exp=" + localThrowable.toString());
      }
    }
  }
  
  public static int getScreenWidth()
  {
    AppMethodBeat.i(199956);
    if (kWB == 0) {}
    try
    {
      int[] arrayOfInt = al.gg(ai.getContext());
      kWB = arrayOfInt[0];
      kWC = arrayOfInt[1];
      int i = kWB;
      AppMethodBeat.o(199956);
      return i;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("AdExposureParams", "getScreenWidth exp=" + localThrowable.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.b
 * JD-Core Version:    0.7.0.1
 */