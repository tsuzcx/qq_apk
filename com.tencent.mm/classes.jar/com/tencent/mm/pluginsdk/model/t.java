package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class t
{
  private static volatile t EMk = null;
  
  public static s A(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(109474);
    switch (paramInt)
    {
    default: 
      paramBundle = new q();
      AppMethodBeat.o(109474);
      return paramBundle;
    case 2: 
      paramBundle = new c(paramBundle);
      AppMethodBeat.o(109474);
      return paramBundle;
    }
    paramBundle = new x();
    AppMethodBeat.o(109474);
    return paramBundle;
  }
  
  public static int Ym(int paramInt)
  {
    AppMethodBeat.i(109475);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(109475);
      return 5;
    case 0: 
      paramInt = bt.getInt(com.tencent.mm.n.g.acB().ah("QQBroswer", "RecommendCount"), 5);
      AppMethodBeat.o(109475);
      return paramInt;
    }
    AppMethodBeat.o(109475);
    return 2147483647;
  }
  
  public static void Yn(int paramInt)
  {
    AppMethodBeat.i(109476);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109476);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(10998, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(109476);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(11091, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public static void Yo(int paramInt)
  {
    AppMethodBeat.i(109477);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109477);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(10998, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(109477);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(11091, new Object[] { Integer.valueOf(1) });
    }
  }
  
  public static void Yp(int paramInt)
  {
    AppMethodBeat.i(109478);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109478);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(10998, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(109478);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(11091, new Object[] { Integer.valueOf(3) });
    }
  }
  
  public static void Yq(int paramInt)
  {
    AppMethodBeat.i(109479);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109479);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(10998, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(109479);
      return;
      com.tencent.mm.plugin.report.service.g.yhR.f(11091, new Object[] { Integer.valueOf(2) });
    }
  }
  
  public static t eZH()
  {
    AppMethodBeat.i(109473);
    if (EMk == null) {}
    try
    {
      if (EMk == null) {
        EMk = new t();
      }
      t localt = EMk;
      AppMethodBeat.o(109473);
      return localt;
    }
    finally
    {
      AppMethodBeat.o(109473);
    }
  }
  
  public static final class a
  {
    public int EMl;
    public int EMm;
    public String EMn;
    public int EMo;
    public String EMp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.t
 * JD-Core Version:    0.7.0.1
 */