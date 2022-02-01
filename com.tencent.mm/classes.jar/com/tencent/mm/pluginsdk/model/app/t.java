package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

final class t
  implements Runnable
{
  private String appId = null;
  private int hSw = 0;
  private ao handler = null;
  private String url = null;
  
  public t(ao paramao, String paramString1, int paramInt, String paramString2)
  {
    this.handler = paramao;
    this.appId = paramString1;
    this.hSw = paramInt;
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
    Object localObject = bs.aLC(this.url);
    localObject = new x(this.appId, this.hSw, (byte[])localObject);
    Message localMessage = Message.obtain();
    localMessage.obj = localObject;
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(151793);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.t
 * JD-Core Version:    0.7.0.1
 */