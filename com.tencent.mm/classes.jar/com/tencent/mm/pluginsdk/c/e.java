package com.tencent.mm.pluginsdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.sdk.event.EventCenter;

public final class e
{
  public static xi bdh(String paramString)
  {
    AppMethodBeat.i(151625);
    xi localxi = new xi();
    localxi.edC.dJY = 1;
    localxi.edC.edD = paramString;
    EventCenter.instance.publish(localxi);
    AppMethodBeat.o(151625);
    return localxi;
  }
  
  public static void bdi(String paramString)
  {
    AppMethodBeat.i(151626);
    xi localxi = new xi();
    localxi.edC.dJY = 2;
    localxi.edC.edD = paramString;
    EventCenter.instance.publish(localxi);
    AppMethodBeat.o(151626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.c.e
 * JD-Core Version:    0.7.0.1
 */