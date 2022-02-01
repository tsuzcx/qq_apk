package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bs;

public final class t
{
  private static volatile t Dhz = null;
  
  public static int Wr(int paramInt)
  {
    AppMethodBeat.i(109475);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(109475);
      return 5;
    case 0: 
      paramInt = bs.getInt(g.ZZ().ag("QQBroswer", "RecommendCount"), 5);
      AppMethodBeat.o(109475);
      return paramInt;
    }
    AppMethodBeat.o(109475);
    return 2147483647;
  }
  
  public static void Ws(int paramInt)
  {
    AppMethodBeat.i(109476);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109476);
      return;
      h.wUl.f(10998, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(109476);
      return;
      h.wUl.f(11091, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public static void Wt(int paramInt)
  {
    AppMethodBeat.i(109477);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109477);
      return;
      h.wUl.f(10998, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(109477);
      return;
      h.wUl.f(11091, new Object[] { Integer.valueOf(1) });
    }
  }
  
  public static void Wu(int paramInt)
  {
    AppMethodBeat.i(109478);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109478);
      return;
      h.wUl.f(10998, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(109478);
      return;
      h.wUl.f(11091, new Object[] { Integer.valueOf(3) });
    }
  }
  
  public static void Wv(int paramInt)
  {
    AppMethodBeat.i(109479);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109479);
      return;
      h.wUl.f(10998, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(109479);
      return;
      h.wUl.f(11091, new Object[] { Integer.valueOf(2) });
    }
  }
  
  public static t eKN()
  {
    AppMethodBeat.i(109473);
    if (Dhz == null) {}
    try
    {
      if (Dhz == null) {
        Dhz = new t();
      }
      t localt = Dhz;
      AppMethodBeat.o(109473);
      return localt;
    }
    finally
    {
      AppMethodBeat.o(109473);
    }
  }
  
  public static s z(int paramInt, Bundle paramBundle)
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
  
  public static final class a
  {
    public int DhA;
    public int DhB;
    public String DhC;
    public int DhD;
    public String DhE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.t
 * JD-Core Version:    0.7.0.1
 */