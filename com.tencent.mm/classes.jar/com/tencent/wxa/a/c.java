package com.tencent.wxa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.a;
import com.tencent.wxa.a.a;
import com.tencent.wxa.b.b;
import io.flutter.plugin.a.j;

public final class c
  extends a
{
  public final a.a a(j paramj)
  {
    AppMethodBeat.i(206315);
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
        paramj = hrG();
        AppMethodBeat.o(206315);
        return paramj;
        if (str.equals("updatePopGestureEnable")) {
          i = 0;
        }
        break;
      }
    }
    boolean bool = ((Boolean)paramj.SxX).booleanValue();
    paramj = com.tencent.wxa.c.hrH();
    if (paramj.SxG != null) {
      paramj.SxG.bP(bool);
    }
    paramj = eI(Boolean.TRUE);
    AppMethodBeat.o(206315);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wxa.a.c
 * JD-Core Version:    0.7.0.1
 */