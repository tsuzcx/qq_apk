package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.c;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class r
{
  private static volatile r vKH = null;
  
  public static q B(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(125830);
    switch (paramInt)
    {
    default: 
      paramBundle = new o();
      AppMethodBeat.o(125830);
      return paramBundle;
    case 2: 
      paramBundle = new a(paramBundle);
      AppMethodBeat.o(125830);
      return paramBundle;
    }
    paramBundle = new v();
    AppMethodBeat.o(125830);
    return paramBundle;
  }
  
  public static int Lv(int paramInt)
  {
    AppMethodBeat.i(125831);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(125831);
      return 5;
    case 0: 
      paramInt = bo.getInt(g.Nr().R("QQBroswer", "RecommendCount"), 5);
      AppMethodBeat.o(125831);
      return paramInt;
    }
    AppMethodBeat.o(125831);
    return 2147483647;
  }
  
  public static void Lw(int paramInt)
  {
    AppMethodBeat.i(125832);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125832);
      return;
      h.qsU.e(10998, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(125832);
      return;
      h.qsU.e(11091, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public static void Lx(int paramInt)
  {
    AppMethodBeat.i(125833);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125833);
      return;
      h.qsU.e(10998, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(125833);
      return;
      h.qsU.e(11091, new Object[] { Integer.valueOf(1) });
    }
  }
  
  public static void Ly(int paramInt)
  {
    AppMethodBeat.i(125834);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125834);
      return;
      h.qsU.e(10998, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(125834);
      return;
      h.qsU.e(11091, new Object[] { Integer.valueOf(3) });
    }
  }
  
  public static void Lz(int paramInt)
  {
    AppMethodBeat.i(125835);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(125835);
      return;
      h.qsU.e(10998, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(125835);
      return;
      h.qsU.e(11091, new Object[] { Integer.valueOf(2) });
    }
  }
  
  public static r dlm()
  {
    AppMethodBeat.i(125829);
    if (vKH == null) {}
    try
    {
      if (vKH == null) {
        vKH = new r();
      }
      r localr = vKH;
      AppMethodBeat.o(125829);
      return localr;
    }
    finally
    {
      AppMethodBeat.o(125829);
    }
  }
  
  public static final class a
  {
    public int vKI;
    public int vKJ;
    public String vKK;
    public int vKL;
    public String vKM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.r
 * JD-Core Version:    0.7.0.1
 */