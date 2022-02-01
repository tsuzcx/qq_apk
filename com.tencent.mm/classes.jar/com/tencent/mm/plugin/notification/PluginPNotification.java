package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.af;

public class PluginPNotification
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(271919);
    af.aR("FailMsgFileCache", "FailMsgFileCache", 5);
    AppMethodBeat.o(271919);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(271920);
    if (paramg.bbA()) {
      pin(com.tencent.mm.plugin.notification.model.a.guP());
    }
    AppMethodBeat.o(271920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.PluginPNotification
 * JD-Core Version:    0.7.0.1
 */