package com.tencent.mm.plugin.nearlife.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

final class LogoImageView$a
  implements Runnable
{
  private ao handler;
  private String url;
  
  LogoImageView$a(String paramString, ao paramao)
  {
    this.url = paramString;
    this.handler = paramao;
  }
  
  public final void run()
  {
    AppMethodBeat.i(26594);
    byte[] arrayOfByte = bs.aLC(this.url);
    Message localMessage = Message.obtain();
    localMessage.obj = arrayOfByte;
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(26594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.LogoImageView.a
 * JD-Core Version:    0.7.0.1
 */