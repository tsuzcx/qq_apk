package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;

public class LogReportManager
{
  private static final Class<?>[] REPORT_MANAGERS = { DownloadReportManager.class, TipsInfoReportManager.class, UpdateInfoReportManager.class };
  private static final String TAG = "LogReportManager";
  private static LogReportManager mInstance = null;
  private final NetworkMonitorReceiver.INetworkChangedObserver mNetworkChangedObserver;
  
  private LogReportManager()
  {
    AppMethodBeat.i(75819);
    this.mNetworkChangedObserver = new LogReportManager.1(this);
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this.mNetworkChangedObserver);
    AppMethodBeat.o(75819);
  }
  
  public static LogReportManager getInstance()
  {
    try
    {
      AppMethodBeat.i(75818);
      if (mInstance == null) {
        mInstance = new LogReportManager();
      }
      LogReportManager localLogReportManager = mInstance;
      AppMethodBeat.o(75818);
      return localLogReportManager;
    }
    finally {}
  }
  
  public void cancleReport()
  {
    AppMethodBeat.i(75822);
    Class[] arrayOfClass = REPORT_MANAGERS;
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
            DownloadReportManager.getInstance().cancleRequest();
          } else if (localClass.equals(TipsInfoReportManager.class)) {
            TipsInfoReportManager.getInstance().cancleRequest();
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
      }
      else
      {
        AppMethodBeat.o(75822);
        return;
      }
      i += 1;
    }
  }
  
  public void destory()
  {
    AppMethodBeat.i(75820);
    Class[] arrayOfClass = REPORT_MANAGERS;
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
            DownloadReportManager.getInstance().destroy();
          } else if (localClass.equals(TipsInfoReportManager.class)) {
            TipsInfoReportManager.getInstance().destroy();
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
      }
      else
      {
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.mNetworkChangedObserver);
        AppMethodBeat.o(75820);
        return;
      }
      i += 1;
    }
  }
  
  public void reportLog()
  {
    AppMethodBeat.i(75821);
    Class[] arrayOfClass = REPORT_MANAGERS;
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
            DownloadReportManager.getInstance().reportLogData();
          } else if (localClass.equals(TipsInfoReportManager.class)) {
            TipsInfoReportManager.getInstance().reportLogData();
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
        if (localException.equals(UpdateInfoReportManager.class)) {
          UpdateInfoReportManager.getInstance().reportLogData();
        }
      }
      else
      {
        AppMethodBeat.o(75821);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.LogReportManager
 * JD-Core Version:    0.7.0.1
 */