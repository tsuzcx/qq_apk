package com.tencent.pluginmanager.channel;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.now.channel.Data;
import com.tencent.pluginmanager.channel.listener.IBeaconDataReportListener;
import com.tencent.pluginmanager.channel.listener.IBizReqListener;
import com.tencent.pluginmanager.channel.listener.ICGIReqListener;
import com.tencent.pluginmanager.channel.listener.ICsListener;
import com.tencent.pluginmanager.channel.listener.IDataReportListener;
import com.tencent.pluginmanager.channel.listener.IDownloadReqListener;
import com.tencent.pluginmanager.channel.listener.ILogListener;
import com.tencent.pluginmanager.channel.log.ILogger;

public class IPCHelper
{
  public static void addBeaconDataReportListener(IBeaconDataReportListener paramIBeaconDataReportListener)
  {
    ChannelManager.getInstance().addBeaconDataReportListener(paramIBeaconDataReportListener);
  }
  
  public static void addBizReqListener(IBizReqListener paramIBizReqListener)
  {
    ChannelManager.getInstance().addBizReqListener(paramIBizReqListener);
  }
  
  public static void addCGIReqListener(ICGIReqListener paramICGIReqListener)
  {
    ChannelManager.getInstance().addCGIReqListener(paramICGIReqListener);
  }
  
  public static void addCsListener(ICsListener paramICsListener)
  {
    ChannelManager.getInstance().addCsListener(paramICsListener);
  }
  
  public static void addDataReportListener(IDataReportListener paramIDataReportListener)
  {
    ChannelManager.getInstance().addDataReportListener(paramIDataReportListener);
  }
  
  public static void addDownloadReqListener(IDownloadReqListener paramIDownloadReqListener)
  {
    ChannelManager.getInstance().addDownloadReqListener(paramIDownloadReqListener);
  }
  
  public static void addLogListener(ILogListener paramILogListener)
  {
    ChannelManager.getInstance().addLogListener(paramILogListener);
  }
  
  public static void pushToPlugin(int paramInt, Bundle paramBundle)
  {
    Data localData = new Data();
    localData.cmd = 5;
    localData.subCmd = paramInt;
    localData.bundle = paramBundle;
    ChannelManager.getInstance().sendToPlugin(localData);
  }
  
  public static void removeAllListener()
  {
    ChannelManager.getInstance().removeAllListener();
  }
  
  public static void removeBeaconDataReportListener(IBeaconDataReportListener paramIBeaconDataReportListener)
  {
    ChannelManager.getInstance().removeBeaconDataReportListener(paramIBeaconDataReportListener);
  }
  
  public static void removeBizReqListener(IBizReqListener paramIBizReqListener)
  {
    ChannelManager.getInstance().removeBizReqListener(paramIBizReqListener);
  }
  
  public static void removeCGIReqListener(ICGIReqListener paramICGIReqListener)
  {
    ChannelManager.getInstance().removeCGIReqListener(paramICGIReqListener);
  }
  
  public static void removeCsListener(ICsListener paramICsListener)
  {
    ChannelManager.getInstance().removeCsListener(paramICsListener);
  }
  
  public static void removeDataReportListener(IDataReportListener paramIDataReportListener)
  {
    ChannelManager.getInstance().removeDataReportListener(paramIDataReportListener);
  }
  
  public static void removeDownloadReqListener(IDownloadReqListener paramIDownloadReqListener)
  {
    ChannelManager.getInstance().removeDownloadReqListener(paramIDownloadReqListener);
  }
  
  public static void removeLogListener(ILogListener paramILogListener)
  {
    ChannelManager.getInstance().removeLogListener(paramILogListener);
  }
  
  public static void setBindler(IBinder paramIBinder)
  {
    ChannelManager.getInstance().setBindler(paramIBinder);
  }
  
  public static void setLogger(ILogger paramILogger)
  {
    ChannelManager.getInstance().setLogger(paramILogger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.pluginmanager.channel.IPCHelper
 * JD-Core Version:    0.7.0.1
 */