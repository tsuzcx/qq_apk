package com.tencent.wax.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wax.a;
import com.tencent.wax.a.a;
import com.tencent.wax.b.b;
import com.tencent.wax.d;
import io.flutter.plugin.a.j;

public final class c
  extends a
{
  public final a.a a(j paramj)
  {
    AppMethodBeat.i(195502);
    String str = paramj.method;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramj = gdq();
        AppMethodBeat.o(195502);
        return paramj;
        if (str.equals("updatePopGestureEnable")) {
          i = 0;
        }
        break;
      }
    }
    boolean bool = ((Boolean)paramj.gtF).booleanValue();
    paramj = d.gdr();
    if (paramj.MHD != null) {
      paramj.MHD.nX(bool);
    }
    paramj = eC(Boolean.TRUE);
    AppMethodBeat.o(195502);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wax.a.c
 * JD-Core Version:    0.7.0.1
 */