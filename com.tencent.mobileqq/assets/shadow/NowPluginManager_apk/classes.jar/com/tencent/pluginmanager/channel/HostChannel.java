package com.tencent.pluginmanager.channel;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.now.channel.Data;
import com.tencent.now.channel.IHostInterface.Stub;

public abstract class HostChannel
  extends IHostInterface.Stub
{
  private static final String TAG = "HostChannel";
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  private void beaconReportData(Data paramData)
  {
    beaconReportData(paramData.target, paramData.bundle);
  }
  
  private void download(final Data paramData)
  {
    download(paramData.target, paramData.bundle, new ChannelCallback()
    {
      public void responseToPlugin(Bundle paramAnonymousBundle)
      {
        paramData.bundle = paramAnonymousBundle;
        HostChannel.this.sendToPlugin(paramData);
      }
    });
  }
  
  private void printLog(Data paramData)
  {
    printLog(paramData.target, paramData.bundle);
  }
  
  private void reportData(Data paramData)
  {
    reportData(paramData.target, paramData.bundle);
  }
  
  private void sendBizTask(final Data paramData)
  {
    sendBizTask(paramData.target, paramData.subCmd, paramData.bundle, new ChannelCallback()
    {
      public void responseToPlugin(Bundle paramAnonymousBundle)
      {
        paramData.bundle = paramAnonymousBundle;
        HostChannel.this.sendToPlugin(paramData);
      }
    });
  }
  
  private void sendCsTask(final Data paramData)
  {
    sendCsTask(paramData.target, paramData.bundle, new ChannelCallback()
    {
      public void responseToPlugin(Bundle paramAnonymousBundle)
      {
        paramData.bundle = paramAnonymousBundle;
        HostChannel.this.sendToPlugin(paramData);
      }
    });
  }
  
  public abstract void beaconReportData(String paramString, Bundle paramBundle);
  
  public abstract void download(String paramString, Bundle paramBundle, ChannelCallback paramChannelCallback);
  
  public abstract void handleCgiReq(Data paramData, ChannelCallback paramChannelCallback);
  
  public abstract void printLog(String paramString, Bundle paramBundle);
  
  public abstract void reportData(String paramString, Bundle paramBundle);
  
  public abstract void sendBizTask(String paramString, int paramInt, Bundle paramBundle, ChannelCallback paramChannelCallback);
  
  public abstract void sendCsTask(String paramString, Bundle paramBundle, ChannelCallback paramChannelCallback);
  
  public final void sendToHost(final Data paramData)
  {
    this.mMainHandler.post(new Runnable()
    {
      public void run()
      {
        try
        {
          Log.i("HostChannel", "sendToHost, cost=" + (System.currentTimeMillis() - paramData.bundle.getLong("t", 0L)) + "cmd=" + paramData.cmd + " subcmd=" + paramData.subCmd);
          if (paramData.cmd == 0)
          {
            HostChannel.this.printLog(paramData);
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            for (;;)
            {
              Log.e("HostChannel", "sendToHost--error--exception=" + localException.toString() + ";bundle=" + paramData.bundle);
            }
            if (paramData.cmd == 1)
            {
              HostChannel.this.reportData(paramData);
              return;
            }
            if (paramData.cmd == 2)
            {
              HostChannel.this.download(paramData);
              return;
            }
            if (paramData.cmd == 3)
            {
              HostChannel.this.sendCsTask(paramData);
              return;
            }
            if (paramData.cmd == 4)
            {
              HostChannel.this.sendBizTask(paramData);
              return;
            }
            if (paramData.cmd == 6)
            {
              HostChannel.this.handleCgiReq(paramData, new ChannelCallback()
              {
                public void responseToPlugin(Bundle paramAnonymous2Bundle)
                {
                  HostChannel.1.this.val$data.bundle = paramAnonymous2Bundle;
                  HostChannel.this.sendToPlugin(HostChannel.1.this.val$data);
                }
              });
              return;
            }
          } while (paramData.cmd != 7);
          HostChannel.this.beaconReportData(paramData);
        }
      }
    });
  }
  
  public final void sendToPlugin(Data paramData)
  {
    ChannelManager.getInstance().sendToPlugin(paramData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.pluginmanager.channel.HostChannel
 * JD-Core Version:    0.7.0.1
 */