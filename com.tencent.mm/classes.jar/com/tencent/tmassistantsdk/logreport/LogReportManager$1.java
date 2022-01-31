package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;
import com.tencent.tmassistantsdk.util.TMLog;

class LogReportManager$1
  implements NetworkMonitorReceiver.INetworkChangedObserver
{
  LogReportManager$1(LogReportManager paramLogReportManager) {}
  
  public void onNetworkChanged()
  {
    AppMethodBeat.i(75817);
    TMLog.i("LogReportManager", "onNetworkChanged,netState:" + DownloadHelper.getNetStatus());
    Class[] arrayOfClass = LogReportManager.access$000();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        try
        {
          if (localClass.equals(DownloadReportManager.class)) {
            DownloadReportManager.getInstance().resetMaxReportCount();
          } else if (localClass.equals(TipsInfoReportManager.class)) {
            TipsInfoReportManager.getInstance().resetMaxReportCount();
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
      }
      else
      {
        if (DownloadHelper.isNetworkConncted()) {
          DownloadHelper.getNetStatus().equalsIgnoreCase("wifi");
        }
        AppMethodBeat.o(75817);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.LogReportManager.1
 * JD-Core Version:    0.7.0.1
 */