package com.tencent.tmassistantsdk.logreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver;
import com.tencent.tmassistantsdk.downloadservice.NetworkMonitorReceiver.INetworkChangedObserver;
import com.tencent.tmassistantsdk.util.TMLog;

public class LogReportManager
{
  private static final Class<?>[] REPORT_MANAGERS = { DownloadReportManager.class, TipsInfoReportManager.class, UpdateInfoReportManager.class };
  private static final String TAG = "LogReportManager";
  private static LogReportManager mInstance = null;
  private final NetworkMonitorReceiver.INetworkChangedObserver mNetworkChangedObserver;
  
  private LogReportManager()
  {
    AppMethodBeat.i(102065);
    this.mNetworkChangedObserver = new NetworkMonitorReceiver.INetworkChangedObserver()
    {
      public void onNetworkChanged()
      {
        AppMethodBeat.i(102063);
        TMLog.i("LogReportManager", "onNetworkChanged,netState:" + DownloadHelper.getNetStatus());
        Class[] arrayOfClass = LogReportManager.REPORT_MANAGERS;
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
              Log.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
            }
          }
          else
          {
            if (DownloadHelper.isNetworkConncted()) {
              DownloadHelper.getNetStatus().equalsIgnoreCase("wifi");
            }
            AppMethodBeat.o(102063);
            return;
          }
          i += 1;
        }
      }
    };
    NetworkMonitorReceiver.getInstance().addNetworkChangedObserver(this.mNetworkChangedObserver);
    AppMethodBeat.o(102065);
  }
  
  public static LogReportManager getInstance()
  {
    try
    {
      AppMethodBeat.i(102064);
      if (mInstance == null) {
        mInstance = new LogReportManager();
      }
      LogReportManager localLogReportManager = mInstance;
      AppMethodBeat.o(102064);
      return localLogReportManager;
    }
    finally {}
  }
  
  public void cancleReport()
  {
    AppMethodBeat.i(102068);
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
          Log.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
      }
      else
      {
        AppMethodBeat.o(102068);
        return;
      }
      i += 1;
    }
  }
  
  public void destory()
  {
    AppMethodBeat.i(102066);
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
          Log.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
      }
      else
      {
        NetworkMonitorReceiver.getInstance().removeNetworkChangedObserver(this.mNetworkChangedObserver);
        AppMethodBeat.o(102066);
        return;
      }
      i += 1;
    }
  }
  
  public void reportLog()
  {
    AppMethodBeat.i(102067);
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
          Log.printErrStackTrace("LogReportManager", localException, "", new Object[0]);
        }
        if (localException.equals(UpdateInfoReportManager.class)) {
          UpdateInfoReportManager.getInstance().reportLogData();
        }
      }
      else
      {
        AppMethodBeat.o(102067);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.logreport.LogReportManager
 * JD-Core Version:    0.7.0.1
 */