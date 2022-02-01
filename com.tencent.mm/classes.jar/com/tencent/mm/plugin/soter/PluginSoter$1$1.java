package com.tencent.mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.on;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

final class PluginSoter$1$1
  implements g
{
  PluginSoter$1$1(PluginSoter.1 param1) {}
  
  public final void bg(int paramInt, String paramString)
  {
    AppMethodBeat.i(130781);
    Log.i("MicroMsg.PluginSoter", "init finish: %s, %s", new Object[] { Integer.valueOf(paramInt), paramString });
    on localon = new on();
    localon.dUC.errCode = paramInt;
    localon.dUC.errMsg = paramString;
    EventCenter.instance.publish(localon);
    AppMethodBeat.o(130781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter.1.1
 * JD-Core Version:    0.7.0.1
 */