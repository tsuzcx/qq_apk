package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class s
  implements Runnable
{
  private String appId = null;
  private int fPp = 0;
  private ak handler = null;
  private String url = null;
  
  public s(ak paramak, String paramString1, int paramInt, String paramString2)
  {
    this.handler = paramak;
    this.appId = paramString1;
    this.fPp = paramInt;
    this.url = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(79362);
    if ((this.appId == null) || (this.appId.length() == 0) || (this.url == null) || (this.url.length() == 0))
    {
      AppMethodBeat.o(79362);
      return;
    }
    Object localObject = bo.apZ(this.url);
    localObject = new v(this.appId, this.fPp, (byte[])localObject);
    Message localMessage = Message.obtain();
    localMessage.obj = localObject;
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(79362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.s
 * JD-Core Version:    0.7.0.1
 */