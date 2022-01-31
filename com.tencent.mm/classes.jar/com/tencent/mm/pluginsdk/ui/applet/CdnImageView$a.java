package com.tencent.mm.pluginsdk.ui.applet;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class CdnImageView$a
  implements Runnable
{
  private ak handler;
  private String url;
  
  CdnImageView$a(String paramString, ak paramak)
  {
    this.url = paramString;
    this.handler = paramak;
  }
  
  public final void run()
  {
    AppMethodBeat.i(79717);
    byte[] arrayOfByte = bo.apZ(this.url);
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("k_data", arrayOfByte);
    localBundle.putString("k_url", this.url);
    localMessage.setData(localBundle);
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(79717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView.a
 * JD-Core Version:    0.7.0.1
 */