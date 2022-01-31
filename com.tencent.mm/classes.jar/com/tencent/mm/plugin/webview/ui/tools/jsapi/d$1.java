package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class d$1
  extends ak
{
  d$1(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(8864);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(8864);
      return;
      paramMessage = (String)paramMessage.obj;
      if (!bo.isNullOrNil(paramMessage)) {
        d.b(this.voP).add(paramMessage);
      }
      d.c(this.voP);
      AppMethodBeat.o(8864);
      return;
      ab.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d.1
 * JD-Core Version:    0.7.0.1
 */