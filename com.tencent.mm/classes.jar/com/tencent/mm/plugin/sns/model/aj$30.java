package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xh;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.j.i;
import com.tencent.mm.plugin.sns.lucky.a.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;
import java.nio.charset.Charset;

final class aj$30
  extends IListener<xh>
{
  aj$30(aj paramaj)
  {
    AppMethodBeat.i(160671);
    this.__eventId = xh.class.getName().hashCode();
    AppMethodBeat.o(160671);
  }
  
  private static boolean fPe()
  {
    AppMethodBeat.i(215985);
    g.fNB();
    ar.a locala = ar.a.VkJ;
    i locali = new i();
    try
    {
      h.aHH();
      h.aHG().aHp().set(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
      AppMethodBeat.o(215985);
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + localIOException.getLocalizedMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj.30
 * JD-Core Version:    0.7.0.1
 */