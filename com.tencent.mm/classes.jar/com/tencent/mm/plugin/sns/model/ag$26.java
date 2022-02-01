package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uz;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;
import java.nio.charset.Charset;

final class ag$26
  extends c<uz>
{
  ag$26(ag paramag)
  {
    AppMethodBeat.i(160668);
    this.__eventId = uz.class.getName().hashCode();
    AppMethodBeat.o(160668);
  }
  
  private static boolean dUx()
  {
    AppMethodBeat.i(176266);
    com.tencent.mm.plugin.sns.lucky.a.g.dTc();
    al.a locala = al.a.Iuk;
    i locali = new i();
    try
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajC().ajl().set(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ag.26
 * JD-Core Version:    0.7.0.1
 */