package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;
import java.nio.charset.Charset;

final class af$26
  extends c<ug>
{
  af$26(af paramaf)
  {
    AppMethodBeat.i(160668);
    this.__eventId = ug.class.getName().hashCode();
    AppMethodBeat.o(160668);
  }
  
  private static boolean dIk()
  {
    AppMethodBeat.i(176266);
    com.tencent.mm.plugin.sns.lucky.a.g.dGP();
    ah.a locala = ah.a.GHS;
    i locali = new i();
    try
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agR().agA().set(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
      AppMethodBeat.o(176266);
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + localIOException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af.26
 * JD-Core Version:    0.7.0.1
 */