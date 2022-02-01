package com.tencent.mm.plugin.nearlife.ui;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

final class LogoImageView$a
  implements Runnable
{
  private aq handler;
  private String url;
  
  LogoImageView$a(String paramString, aq paramaq)
  {
    this.url = paramString;
    this.handler = paramaq;
  }
  
  public final void run()
  {
    AppMethodBeat.i(26594);
    byte[] arrayOfByte = bu.aSF(this.url);
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