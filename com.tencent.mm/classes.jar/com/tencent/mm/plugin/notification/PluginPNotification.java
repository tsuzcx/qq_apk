package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.ab;

public class PluginPNotification
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(279496);
    ab.aE("FailMsgFileCache", "FailMsgFileCache", 5);
    AppMethodBeat.o(279496);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(279498);
    if (paramg.aIE()) {
      pin(com.tencent.mm.plugin.notification.d.a.fky());
    }
    AppMethodBeat.o(279498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.PluginPNotification
 * JD-Core Version:    0.7.0.1
 */