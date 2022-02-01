package com.tencent.smtt.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;

class WebView$a
  extends BroadcastReceiver
{
  public void onReceive(Context arg1, Intent paramIntent)
  {
    AppMethodBeat.i(55494);
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
        synchronized (QbSdk.g)
        {
          if (QbSdk.d) {
            QbSdk.f += l - QbSdk.e;
          }
          QbSdk.e = l;
          TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.f + " apnType=" + i);
          if (i == 3)
          {
            bool = true;
            QbSdk.d = bool;
            AppMethodBeat.o(55494);
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable ???)
      {
        AppMethodBeat.o(55494);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.a
 * JD-Core Version:    0.7.0.1
 */