package com.tencent.mm.pluginsdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.yp;
import com.tencent.mm.sdk.event.EventCenter;

public final class e
{
  public static yp bpg(String paramString)
  {
    AppMethodBeat.i(151625);
    yp localyp = new yp();
    localyp.fXL.fCN = 1;
    localyp.fXL.fXM = paramString;
    EventCenter.instance.publish(localyp);
    AppMethodBeat.o(151625);
    return localyp;
  }
  
  public static void bph(String paramString)
  {
    AppMethodBeat.i(151626);
    yp localyp = new yp();
    localyp.fXL.fCN = 2;
    localyp.fXL.fXM = paramString;
    EventCenter.instance.publish(localyp);
    AppMethodBeat.o(151626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.d.e
 * JD-Core Version:    0.7.0.1
 */