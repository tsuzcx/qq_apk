package com.tencent.mm.pluginsdk.model.app;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.List;

final class e$2
  extends ak
{
  e$2(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(79243);
    paramMessage = (v)paramMessage.obj;
    r localr = new r(paramMessage.appId, paramMessage.fPp);
    if (this.vKW.vKU.contains(localr))
    {
      this.vKW.vKU.remove(localr);
      if (!a.cac().e(paramMessage.appId, paramMessage.data, paramMessage.fPp)) {
        ab.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
      }
    }
    while (this.vKW.qKd.size() > 0)
    {
      paramMessage = (r)this.vKW.qKd.remove(0);
      if (this.vKW.a(paramMessage))
      {
        this.vKW.vKU.add(paramMessage);
        AppMethodBeat.o(79243);
        return;
      }
    }
    AppMethodBeat.o(79243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.e.2
 * JD-Core Version:    0.7.0.1
 */