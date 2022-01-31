package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.u;

public class lm
{
  private static int a = 0;
  
  public static int a()
  {
    try
    {
      int i = a;
      return i;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    AppMethodBeat.i(149187);
    try
    {
      a = u.a(paramContext).b("handDrawMapVer");
      return;
    }
    finally
    {
      AppMethodBeat.o(149187);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(149188);
    try
    {
      a = paramInt;
      u.a(paramContext).a("handDrawMapVer", paramInt);
      return;
    }
    finally
    {
      AppMethodBeat.o(149188);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lm
 * JD-Core Version:    0.7.0.1
 */