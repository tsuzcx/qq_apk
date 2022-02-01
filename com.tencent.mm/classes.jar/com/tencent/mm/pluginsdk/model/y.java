package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.d;
import com.tencent.mm.sdk.platformtools.Util;

public final class y
{
  private static volatile y QVM = null;
  
  public static x C(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(109474);
    switch (paramInt)
    {
    default: 
      paramBundle = new v();
      AppMethodBeat.o(109474);
      return paramBundle;
    case 2: 
      paramBundle = new f(paramBundle);
      AppMethodBeat.o(109474);
      return paramBundle;
    }
    paramBundle = new ac();
    AppMethodBeat.o(109474);
    return paramBundle;
  }
  
  public static int apD(int paramInt)
  {
    AppMethodBeat.i(109475);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(109475);
      return 5;
    case 0: 
      paramInt = Util.getInt(com.tencent.mm.n.h.axd().ao("QQBroswer", "RecommendCount"), 5);
      AppMethodBeat.o(109475);
      return paramInt;
    }
    AppMethodBeat.o(109475);
    return 2147483647;
  }
  
  public static void apE(int paramInt)
  {
    AppMethodBeat.i(109476);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109476);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(10998, new Object[] { Integer.valueOf(0) });
      AppMethodBeat.o(109476);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(11091, new Object[] { Integer.valueOf(0) });
    }
  }
  
  public static void apF(int paramInt)
  {
    AppMethodBeat.i(109477);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109477);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(10998, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(109477);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(11091, new Object[] { Integer.valueOf(1) });
    }
  }
  
  public static void apG(int paramInt)
  {
    AppMethodBeat.i(109478);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109478);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(10998, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(109478);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(11091, new Object[] { Integer.valueOf(3) });
    }
  }
  
  public static void apH(int paramInt)
  {
    AppMethodBeat.i(109479);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(109479);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(10998, new Object[] { Integer.valueOf(2) });
      AppMethodBeat.o(109479);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(11091, new Object[] { Integer.valueOf(2) });
    }
  }
  
  public static y hhf()
  {
    AppMethodBeat.i(109473);
    if (QVM == null) {}
    try
    {
      if (QVM == null) {
        QVM = new y();
      }
      y localy = QVM;
      AppMethodBeat.o(109473);
      return localy;
    }
    finally
    {
      AppMethodBeat.o(109473);
    }
  }
  
  public static final class a
  {
    public int QVN;
    public int QVO;
    public String QVP;
    public int QVQ;
    public String QVR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.y
 * JD-Core Version:    0.7.0.1
 */