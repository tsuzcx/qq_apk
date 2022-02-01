package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

final class x
  implements Runnable
{
  private String appId = null;
  private MMHandler handler = null;
  private int qvo = 0;
  private String url = null;
  
  public x(MMHandler paramMMHandler, String paramString1, int paramInt, String paramString2)
  {
    this.handler = paramMMHandler;
    this.appId = paramString1;
    this.qvo = paramInt;
    this.url = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(151793);
    if ((this.appId == null) || (this.appId.length() == 0) || (this.url == null) || (this.url.length() == 0))
    {
      AppMethodBeat.o(151793);
      return;
    }
    Object localObject = Util.httpGet(this.url);
    localObject = new ab(this.appId, this.qvo, (byte[])localObject);
    Message localMessage = Message.obtain();
    localMessage.obj = localObject;
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(151793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.x
 * JD-Core Version:    0.7.0.1
 */