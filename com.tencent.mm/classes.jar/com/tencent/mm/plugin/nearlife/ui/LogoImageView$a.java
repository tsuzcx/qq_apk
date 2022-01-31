package com.tencent.mm.plugin.nearlife.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class LogoImageView$a
  implements Runnable
{
  private ak handler;
  private String url;
  
  LogoImageView$a(String paramString, ak paramak)
  {
    this.url = paramString;
    this.handler = paramak;
  }
  
  public final void run()
  {
    AppMethodBeat.i(22969);
    byte[] arrayOfByte = bo.apZ(this.url);
    Message localMessage = Message.obtain();
    localMessage.obj = arrayOfByte;
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(22969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LogoImageView.a
 * JD-Core Version:    0.7.0.1
 */