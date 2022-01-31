package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.h.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.nio.charset.Charset;

final class ag$25
  extends c<sd>
{
  ag$25(ag paramag)
  {
    AppMethodBeat.i(36459);
    this.__eventId = sd.class.getName().hashCode();
    AppMethodBeat.o(36459);
  }
  
  private static boolean cpt()
  {
    AppMethodBeat.i(36460);
    com.tencent.mm.plugin.sns.lucky.a.g.cnW();
    ac.a locala = ac.a.yBH;
    i locali = new i();
    try
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
      AppMethodBeat.o(36460);
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + localIOException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag.25
 * JD-Core Version:    0.7.0.1
 */