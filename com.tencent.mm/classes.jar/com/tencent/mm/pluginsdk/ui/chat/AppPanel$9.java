package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.sdk.platformtools.Log;

final class AppPanel$9
  implements h
{
  AppPanel$9(AppPanel paramAppPanel) {}
  
  public final String getKey()
  {
    return "AppPanel_preMakeConnection";
  }
  
  public final void run()
  {
    AppMethodBeat.i(245339);
    f.bkh();
    Log.i("MicroMsg.AppPanel", "preMakeConnection ret:%d", new Object[] { Integer.valueOf(0) });
    AppPanel.hkZ();
    AppMethodBeat.o(245339);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.9
 * JD-Core Version:    0.7.0.1
 */