package com.tencent.mm.plugin.patmsg;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(206914);
    ca localca = new ca();
    localca.setContent(MMApplicationContext.getContext().getString(2131765217));
    localca.setType(10000);
    localca.nv(0);
    localca.Cy(this.gMw);
    localca.setCreateTime(System.currentTimeMillis());
    Log.i("MicroMsg.PatMsgExtension", "insert pat failed msg %d", new Object[] { Long.valueOf(bp.x(localca)) });
    AppMethodBeat.o(206914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.3
 * JD-Core Version:    0.7.0.1
 */