package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class gr
{
  public static gc a(Context paramContext)
  {
    AppMethodBeat.i(148025);
    paramContext = a(paramContext, null);
    AppMethodBeat.o(148025);
    return paramContext;
  }
  
  public static gc a(Context paramContext, gn paramgn)
  {
    AppMethodBeat.i(148024);
    paramContext = paramgn;
    if (paramgn == null) {
      paramContext = new go();
    }
    paramContext = new gc(new gk(paramContext));
    paramContext.a();
    AppMethodBeat.o(148024);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gr
 * JD-Core Version:    0.7.0.1
 */