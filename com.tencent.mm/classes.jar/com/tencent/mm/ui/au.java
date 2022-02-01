package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aaz;
import com.tencent.mm.sdk.event.EventCenter;

public final class au
{
  public static void eb(int paramInt, String paramString)
  {
    AppMethodBeat.i(141491);
    if (EventCenter.instance != null)
    {
      aaz localaaz = new aaz();
      localaaz.ieD.className = paramString;
      localaaz.ieD.ieE = paramInt;
      localaaz.publish();
    }
    AppMethodBeat.o(141491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.au
 * JD-Core Version:    0.7.0.1
 */