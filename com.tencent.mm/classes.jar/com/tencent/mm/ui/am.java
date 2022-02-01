package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xy;
import com.tencent.mm.sdk.event.EventCenter;

public final class am
{
  public static void dl(int paramInt, String paramString)
  {
    AppMethodBeat.i(141491);
    if (EventCenter.instance != null)
    {
      xy localxy = new xy();
      localxy.eem.className = paramString;
      localxy.eem.een = paramInt;
      EventCenter.instance.publish(localxy);
    }
    AppMethodBeat.o(141491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.am
 * JD-Core Version:    0.7.0.1
 */