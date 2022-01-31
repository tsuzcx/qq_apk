package com.tencent.mm.plugin.webview.f;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import org.json.JSONObject;

final class d$1$1
  implements MessageQueue.IdleHandler
{
  d$1$1(d.1 param1, String paramString) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(10142);
    Looper.myQueue().removeIdleHandler(this);
    long l1 = System.currentTimeMillis();
    try
    {
      JSONObject localJSONObject = new JSONObject(this.uYw.substring(1, this.uYw.length() - 1).replace("\\\"", "\"")).optJSONObject("timing");
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long l2 = localJSONObject.optLong(str);
        this.vub.vua.aX(str, l2);
      }
      return false;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.WebViewPerformanceHelper", "fetchDocumentTime ex: %s", new Object[] { localException.getMessage() });
      this.vub.vua.dhe();
      ab.v("MicroMsg.WebViewPerformanceHelper", "onReceiveValue cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      AppMethodBeat.o(10142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.d.1.1
 * JD-Core Version:    0.7.0.1
 */