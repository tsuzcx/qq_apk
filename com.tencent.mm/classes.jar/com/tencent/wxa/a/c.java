package com.tencent.wxa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.b.a;
import io.flutter.plugin.a.j;

public final class c
  extends com.tencent.wxa.b
{
  public final b.a a(j paramj)
  {
    AppMethodBeat.i(224821);
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
        paramj = ivs();
        AppMethodBeat.o(224821);
        return paramj;
        if (str.equals("updatePopGestureEnable")) {
          i = 0;
        }
        break;
      }
    }
    boolean bool = ((Boolean)paramj.ZZe).booleanValue();
    paramj = com.tencent.wxa.c.ivt();
    if (paramj.ZYK != null) {
      paramj.ZYK.bZ(bool);
    }
    paramj = eO(Boolean.TRUE);
    AppMethodBeat.o(224821);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wxa.a.c
 * JD-Core Version:    0.7.0.1
 */