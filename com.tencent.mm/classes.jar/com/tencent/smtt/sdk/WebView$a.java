package com.tencent.smtt.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;

class WebView$a
  extends BroadcastReceiver
{
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        int i;
        long l;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
        {
          i = Apn.getApnType(???);
          l = System.currentTimeMillis();
        }
        synchronized (QbSdk.h)
        {
          if (QbSdk.e) {
            QbSdk.g += l - QbSdk.f;
          }
          QbSdk.f = l;
          TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.g + " apnType=" + i);
          if (i == 3)
          {
            bool = true;
            QbSdk.e = bool;
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable ???)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.a
 * JD-Core Version:    0.7.0.1
 */