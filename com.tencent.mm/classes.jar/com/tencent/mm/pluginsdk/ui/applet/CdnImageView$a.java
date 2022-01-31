package com.tencent.mm.pluginsdk.ui.applet;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class CdnImageView$a
  implements Runnable
{
  private ah handler;
  private String url;
  
  CdnImageView$a(String paramString, ah paramah)
  {
    this.url = paramString;
    this.handler = paramah;
  }
  
  public final void run()
  {
    byte[] arrayOfByte = bk.ZV(this.url);
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("k_data", arrayOfByte);
    localBundle.putString("k_url", this.url);
    localMessage.setData(localBundle);
    this.handler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView.a
 * JD-Core Version:    0.7.0.1
 */