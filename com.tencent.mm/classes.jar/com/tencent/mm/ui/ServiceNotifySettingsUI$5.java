package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apq;

final class ServiceNotifySettingsUI$5
  implements Runnable
{
  ServiceNotifySettingsUI$5(ServiceNotifySettingsUI paramServiceNotifySettingsUI, apq paramapq) {}
  
  public final void run()
  {
    AppMethodBeat.i(29854);
    if (ServiceNotifySettingsUI.b(this.zeQ) == 1)
    {
      ServiceNotifySettingsUI.a(this.zeQ, this.zeU.xfu);
      AppMethodBeat.o(29854);
      return;
    }
    ServiceNotifySettingsUI.a(this.zeQ, this.zeU.wvd);
    AppMethodBeat.o(29854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.5
 * JD-Core Version:    0.7.0.1
 */