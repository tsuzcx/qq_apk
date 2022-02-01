package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.u;

public class PluginPNotification
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(186484);
    u.ap("FailMsgFileCache", "FailMsgFileCache", 7);
    AppMethodBeat.o(186484);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(186485);
    if (paramg.akL()) {
      pin(com.tencent.mm.plugin.notification.d.a.dzm());
    }
    AppMethodBeat.o(186485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.PluginPNotification
 * JD-Core Version:    0.7.0.1
 */