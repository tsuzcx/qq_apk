package com.tencent.mm.plugin.nearlife.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

final class LogoImageView$a
  implements Runnable
{
  private ah handler;
  private String url;
  
  LogoImageView$a(String paramString, ah paramah)
  {
    this.url = paramString;
    this.handler = paramah;
  }
  
  public final void run()
  {
    byte[] arrayOfByte = bk.ZV(this.url);
    Message localMessage = Message.obtain();
    localMessage.obj = arrayOfByte;
    this.handler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LogoImageView.a
 * JD-Core Version:    0.7.0.1
 */