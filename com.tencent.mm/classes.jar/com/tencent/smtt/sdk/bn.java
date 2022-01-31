package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.smtt.utils.Apn;

class bn
  extends Thread
{
  bn(WebView paramWebView, Context paramContext) {}
  
  public void run()
  {
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
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.bn
 * JD-Core Version:    0.7.0.1
 */