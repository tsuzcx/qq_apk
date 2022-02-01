package com.tencent.mm.pluginsdk.ui.applet;

import android.os.Bundle;
import android.os.Message;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

final class CdnImageView$a
  implements h
{
  private MMHandler handler;
  private String url;
  
  CdnImageView$a(String paramString, MMHandler paramMMHandler)
  {
    this.url = paramString;
    this.handler = paramMMHandler;
  }
  
  public final String getKey()
  {
    return "CdnImageView_download";
  }
  
  public final void run()
  {
    AppMethodBeat.i(152165);
    byte[] arrayOfByte = Util.httpGet(this.url);
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("k_data", arrayOfByte);
    localBundle.putString("k_url", this.url);
    localMessage.setData(localBundle);
    this.handler.sendMessage(localMessage);
    AppMethodBeat.o(152165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.CdnImageView.a
 * JD-Core Version:    0.7.0.1
 */