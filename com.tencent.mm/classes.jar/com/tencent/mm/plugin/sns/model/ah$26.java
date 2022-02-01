package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;
import java.nio.charset.Charset;

final class ah$26
  extends c<vd>
{
  ah$26(ah paramah)
  {
    AppMethodBeat.i(160668);
    this.__eventId = vd.class.getName().hashCode();
    AppMethodBeat.o(160668);
  }
  
  private static boolean dXX()
  {
    AppMethodBeat.i(176266);
    com.tencent.mm.plugin.sns.lucky.a.g.dWC();
    am.a locala = am.a.IOH;
    i locali = new i();
    try
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
      AppMethodBeat.o(176266);
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + localIOException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ah.26
 * JD-Core Version:    0.7.0.1
 */