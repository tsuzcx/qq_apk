package com.tencent.mm.pluginsdk.ui.applet;

import android.os.Bundle;
import android.os.Message;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

final class CdnImageView$a
  implements h
{
  private aq handler;
  private String url;
  
  CdnImageView$a(String paramString, aq paramaq)
  {
    this.url = paramString;
    this.handler = paramaq;
  }
  
  public final String getKey()
  {
    return "CdnImageView_download";
  }
  
  public final void run()
  {
    AppMethodBeat.i(152165);
    byte[] arrayOfByte = bu.aSF(this.url);
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("k_data", arrayOfByte);
    localBundle.putString("k_url", this.url);
    localMessage.setData(localBundle);
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(152165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView.a
 * JD-Core Version:    0.7.0.1
 */