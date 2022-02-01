package com.tencent.mm.plugin.sns.model;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.za;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.k.i;
import com.tencent.mm.plugin.sns.lucky.a.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;
import java.nio.charset.Charset;

class SnsCore$37
  extends IListener<za>
{
  SnsCore$37(al paramal, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(309514);
    this.__eventId = za.class.getName().hashCode();
    AppMethodBeat.o(309514);
  }
  
  private static boolean hgY()
  {
    AppMethodBeat.i(309519);
    g.hfm();
    at.a locala = at.a.acMd;
    i locali = new i();
    try
    {
      h.baF();
      h.baE().ban().set(locala, new String(locali.toByteArray(), Charset.forName("ISO-8859-1")));
      AppMethodBeat.o(309519);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.SnsCore.37
 * JD-Core Version:    0.7.0.1
 */