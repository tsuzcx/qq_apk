package com.tencent.tmassistantsdk.logreport;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;

public class LogReportManager
{
  private static final Class<?>[] REPORT_MANAGERS = { DownloadReportManager.class, TipsInfoReportManager.class, UpdateInfoReportManager.class };
  private static final String TAG = "LogReportManager";
  private static LogReportManager mInstance = null;
  private final NetworkMonitorReceiver.INetworkChangedObserver mNetworkChangedObserver = new LogReportManager.1(this);
  
  private LogReportManager()
  {
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this.mNetworkChangedObserver);
  }
  
  public static LogReportManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new LogReportManager();
      }
      LogReportManager localLogReportManager = mInstance;
      return localLogReportManager;
    }
    finally {}
  }
  
  public void cancleReport()
  {
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
          y.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void destory()
  {
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
          y.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
      }
      else
      {
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.mNetworkChangedObserver);
        return;
      }
      i += 1;
    }
  }
  
  public void reportLog()
  {
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
          y.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
        if (localException.equals(UpdateInfoReportManager.class)) {
          UpdateInfoReportManager.getInstance().reportLogData();
        }
      }
      else
      {
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