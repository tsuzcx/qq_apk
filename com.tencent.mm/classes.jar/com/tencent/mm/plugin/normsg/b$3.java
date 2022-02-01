package com.tencent.mm.plugin.normsg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;

final class b$3
  extends BroadcastReceiver
{
  b$3(b paramb) {}
  
  public final void onReceive(Context arg1, Intent paramIntent)
  {
    AppMethodBeat.i(224268);
    if (paramIntent == null)
    {
      ae.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g1.");
      AppMethodBeat.o(224268);
      return;
    }
    if (("android.intent.action.PACKAGE_REMOVED".equals(paramIntent.getAction())) && (paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false)))
    {
      ae.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g2.");
      AppMethodBeat.o(224268);
      return;
    }
    synchronized (b.a(this.wJl))
    {
      ae.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, invalidating sth.");
      b.a(this.wJl)[0] = null;
      b.b(this.wJl).clear();
      AppMethodBeat.o(224268);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.3
 * JD-Core Version:    0.7.0.1
 */