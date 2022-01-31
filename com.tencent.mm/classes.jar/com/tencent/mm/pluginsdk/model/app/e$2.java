package com.tencent.mm.pluginsdk.model.app;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class e$2
  extends ah
{
  e$2(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    paramMessage = (v)paramMessage.obj;
    r localr = new r(paramMessage.appId, paramMessage.ezA);
    if (this.rTZ.rTX.contains(localr))
    {
      this.rTZ.rTX.remove(localr);
      if (!a.brn().e(paramMessage.appId, paramMessage.data, paramMessage.ezA)) {
        y.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
      }
    }
    while (this.rTZ.nVU.size() > 0)
    {
      paramMessage = (r)this.rTZ.nVU.remove(0);
      if (this.rTZ.a(paramMessage)) {
        this.rTZ.rTX.add(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.e.2
 * JD-Core Version:    0.7.0.1
 */