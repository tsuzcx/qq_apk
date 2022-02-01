package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tx;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.j.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;
import java.nio.charset.Charset;

final class af$26
  extends c<tx>
{
  af$26(af paramaf)
  {
    AppMethodBeat.i(160668);
    this.__eventId = tx.class.getName().hashCode();
    AppMethodBeat.o(160668);
  }
  
  private static boolean dtM()
  {
    AppMethodBeat.i(176266);
    com.tencent.mm.plugin.sns.lucky.a.g.dsq();
    ae.a locala = ae.a.Fkd;
    i locali = new i();
    try
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afB().afk().set(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
      AppMethodBeat.o(176266);
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + localIOException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af.26
 * JD-Core Version:    0.7.0.1
 */