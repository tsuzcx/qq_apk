package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.Apn;

class br
  extends Thread
{
  br(WebView paramWebView, Context paramContext) {}
  
  public void run()
  {
    AppMethodBeat.i(139426);
    try
    {
      if (Apn.getApnType(this.a) == 3) {}
      for (boolean bool = true;; bool = false)
      {
        QbSdk.e = bool;
        QbSdk.f = System.currentTimeMillis();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.a.getApplicationContext().registerReceiver(WebView.e(), localIntentFilter);
        AppMethodBeat.o(139426);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(139426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.br
 * JD-Core Version:    0.7.0.1
 */