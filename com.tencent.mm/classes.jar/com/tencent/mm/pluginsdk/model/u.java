package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class u
{
  private static volatile u JVz = null;
  
  public static t A(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(109474);
    switch (paramInt)
    {
    default: 
      paramBundle = new r();
      AppMethodBeat.o(109474);
      return paramBundle;
    case 2: 
      paramBundle = new d(paramBundle);
      AppMethodBeat.o(109474);
      return paramBundle;
    }
    paramBundle = new y();
    AppMethodBeat.o(109474);
    return paramBundle;
  }
  
  public static int ahE(int paramInt)
  {
    AppMethodBeat.i(109475);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(109475);
      return 5;
    case 0: 
      paramInt = Util.getInt(com.tencent.mm.n.h.aqK().aj("QQBroswer", "RecommendCount"), 5);
      AppMethodBeat.o(109475);
      return paramInt;
    }
    AppMethodBeat.o(109475);
    return 2147483647;
  }
  
  public static void ahF(int paramInt)
  {
    AppMethodBeat.i(109476);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109476);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(10998, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(109476);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(11091, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public static void ahG(int paramInt)
  {
    AppMethodBeat.i(109477);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109477);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(10998, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(109477);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(11091, new Object[] { Integer.valueOf(1) });
    }
  }
  
  public static void ahH(int paramInt)
  {
    AppMethodBeat.i(109478);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109478);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(10998, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(109478);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(11091, new Object[] { Integer.valueOf(3) });
    }
  }
  
  public static void ahI(int paramInt)
  {
    AppMethodBeat.i(109479);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109479);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(10998, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(109479);
      return;
      com.tencent.mm.plugin.report.service.h.CyF.a(11091, new Object[] { Integer.valueOf(2) });
    }
  }
  
  public static u gmF()
  {
    AppMethodBeat.i(109473);
    if (JVz == null) {}
    try
    {
      if (JVz == null) {
        JVz = new u();
      }
      u localu = JVz;
      AppMethodBeat.o(109473);
      return localu;
    }
    finally
    {
      AppMethodBeat.o(109473);
    }
  }
  
  public static final class a
  {
    public int JVA;
    public int JVB;
    public String JVC;
    public int JVD;
    public String JVE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.u
 * JD-Core Version:    0.7.0.1
 */