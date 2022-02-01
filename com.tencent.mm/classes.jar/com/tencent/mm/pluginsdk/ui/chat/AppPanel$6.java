package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.sdk.platformtools.ad;

final class AppPanel$6
  implements h
{
  AppPanel$6(AppPanel paramAppPanel) {}
  
  public final String getKey()
  {
    return "AppPanel_preMakeConnection";
  }
  
  public final void run()
  {
    AppMethodBeat.i(204876);
    f.awM();
    ad.i("MicroMsg.AppPanel", "preMakeConnection ret:%d", new Object[] { Integer.valueOf(0) });
    AppPanel.eyL();
    AppMethodBeat.o(204876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.6
 * JD-Core Version:    0.7.0.1
 */