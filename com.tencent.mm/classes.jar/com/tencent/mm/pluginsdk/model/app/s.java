package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class s
  implements Runnable
{
  private String appId = null;
  private int ezA = 0;
  private ah handler = null;
  private String url = null;
  
  public s(ah paramah, String paramString1, int paramInt, String paramString2)
  {
    this.handler = paramah;
    this.appId = paramString1;
    this.ezA = paramInt;
    this.url = paramString2;
  }
  
  public final void run()
  {
    if ((this.appId == null) || (this.appId.length() == 0) || (this.url == null) || (this.url.length() == 0)) {
      return;
    }
    Object localObject = bk.ZV(this.url);
    localObject = new v(this.appId, this.ezA, (byte[])localObject);
    Message localMessage = Message.obtain();
    localMessage.obj = localObject;
    this.handler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.s
 * JD-Core Version:    0.7.0.1
 */