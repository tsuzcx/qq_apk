package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.d;
import com.tencent.mm.k.i;
import com.tencent.mm.sdk.platformtools.Util;

public final class aa
{
  private static volatile aa XRJ = null;
  
  public static z F(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(109474);
    switch (paramInt)
    {
    default: 
      paramBundle = new x();
      AppMethodBeat.o(109474);
      return paramBundle;
    case 2: 
      paramBundle = new h(paramBundle);
      AppMethodBeat.o(109474);
      return paramBundle;
    }
    paramBundle = new ae();
    AppMethodBeat.o(109474);
    return paramBundle;
  }
  
  public static int avI(int paramInt)
  {
    AppMethodBeat.i(109475);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(109475);
      return 5;
    case 0: 
      paramInt = Util.getInt(i.aRD().at("QQBroswer", "RecommendCount"), 5);
      AppMethodBeat.o(109475);
      return paramInt;
    }
    AppMethodBeat.o(109475);
    return 2147483647;
  }
  
  public static void avJ(int paramInt)
  {
    AppMethodBeat.i(109476);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109476);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(10998, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(109476);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11091, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public static void avK(int paramInt)
  {
    AppMethodBeat.i(109477);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109477);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(10998, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(109477);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11091, new Object[] { Integer.valueOf(1) });
    }
  }
  
  public static void avL(int paramInt)
  {
    AppMethodBeat.i(109478);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109478);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(10998, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(109478);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11091, new Object[] { Integer.valueOf(3) });
    }
  }
  
  public static void avM(int paramInt)
  {
    AppMethodBeat.i(109479);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109479);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(10998, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(109479);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.b(11091, new Object[] { Integer.valueOf(2) });
    }
  }
  
  public static aa iIe()
  {
    AppMethodBeat.i(109473);
    if (XRJ == null) {}
    try
    {
      if (XRJ == null) {
        XRJ = new aa();
      }
      aa localaa = XRJ;
      AppMethodBeat.o(109473);
      return localaa;
    }
    finally
    {
      AppMethodBeat.o(109473);
    }
  }
  
  public static final class a
  {
    public int XRK;
    public int XRL;
    public String XRM;
    public int XRN;
    public String XRO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.aa
 * JD-Core Version:    0.7.0.1
 */