package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;

final class ChattingSendDataToDeviceUI$3$1
  implements Runnable
{
  ChattingSendDataToDeviceUI$3$1(ChattingSendDataToDeviceUI.3 param3, f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(30763);
    g.a(this.zAX.zAW.getBaseContext(), this.kZO.field_packageName, this.zAX.zAW.jMk, this.kZO.field_appId, this.kZO.field_openId, 0, null, null);
    AppMethodBeat.o(30763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.3.1
 * JD-Core Version:    0.7.0.1
 */