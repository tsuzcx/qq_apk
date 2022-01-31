package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class d$1
  extends ah
{
  d$1(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (String)paramMessage.obj;
      if (!bk.bl(paramMessage)) {
        d.b(this.rxV).add(paramMessage);
      }
      d.c(this.rxV);
      return;
    }
    y.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.1
 * JD-Core Version:    0.7.0.1
 */