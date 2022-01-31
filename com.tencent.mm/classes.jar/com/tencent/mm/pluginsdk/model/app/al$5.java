package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;

final class al$5
  extends c<ho>
{
  al$5(al paramal)
  {
    AppMethodBeat.i(27417);
    this.__eventId = ho.class.getName().hashCode();
    AppMethodBeat.o(27417);
  }
  
  private static boolean a(ho paramho)
  {
    AppMethodBeat.i(153694);
    for (;;)
    {
      try
      {
        e locale = g.Nq();
        if (locale != null) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        int i = 0;
        continue;
      }
      paramho.cwI.cqs = i;
      AppMethodBeat.o(153694);
      return false;
      i = bo.getInt(g.Nq().getValue("AndroidUseUnicodeEmoji"), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al.5
 * JD-Core Version:    0.7.0.1
 */