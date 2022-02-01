package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.y;

public class PluginPNotification
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(231767);
    y.at("FailMsgFileCache", "FailMsgFileCache", 7);
    AppMethodBeat.o(231767);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(231768);
    if (paramg.aBb()) {
      pin(com.tencent.mm.plugin.notification.d.a.eyT());
    }
    AppMethodBeat.o(231768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.PluginPNotification
 * JD-Core Version:    0.7.0.1
 */