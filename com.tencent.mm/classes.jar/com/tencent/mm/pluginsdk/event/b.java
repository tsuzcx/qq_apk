package com.tencent.mm.pluginsdk.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aai;

public final class b
{
  public static aai bpa(String paramString)
  {
    AppMethodBeat.i(151625);
    aai localaai = new aai();
    localaai.idM.hHC = 1;
    localaai.idM.eventId = paramString;
    localaai.publish();
    AppMethodBeat.o(151625);
    return localaai;
  }
  
  public static void bpb(String paramString)
  {
    AppMethodBeat.i(151626);
    aai localaai = new aai();
    localaai.idM.hHC = 2;
    localaai.idM.eventId = paramString;
    localaai.publish();
    AppMethodBeat.o(151626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.event.b
 * JD-Core Version:    0.7.0.1
 */