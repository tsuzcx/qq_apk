package com.tencent.platform;

import android.content.Context;
import android.os.Bundle;
import com.tencent.pluginmanager.channel.BaseAbilityHelper;
import com.tencent.pluginmanager.channel.ChannelCallback;
import com.tencent.pluginmanager.channel.IPCHelper;
import com.tencent.pluginmanager.channel.listener.IBizReqListener;
import com.tencent.pluginmanager.channel.listener.ICsListener;
import com.tencent.pluginmanager.channel.listener.IDataReportListener;
import com.tencent.pluginmanager.channel.listener.IDownloadReqListener;
import com.tencent.pluginmanager.channel.listener.ILogListener;
import com.tencent.qqinterface.CommonCallback;
import com.tencent.qqinterface.DownloadCallback;
import com.tencent.qqinterface.IHostCallback;
import com.tencent.qqplugin.NowBizInterfaceHelper;
import com.tencent.util.IPlatformCallback;
import com.tencent.util.IPlatformInterface;

public class Platform
  implements IPlatformInterface
{
  private IBizReqListener mListener = new IBizReqListener()
  {
    public void onReceiveBizTask(int paramAnonymousInt, Bundle paramAnonymousBundle, ChannelCallback paramAnonymousChannelCallback)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return;
      case 22: 
        NowBizInterfaceHelper.showBiuComponent(paramAnonymousBundle);
        return;
      case 2: 
        NowBizInterfaceHelper.shareToQQ(paramAnonymousBundle);
        return;
      case 8: 
        NowBizInterfaceHelper.onEnterRoom(paramAnonymousBundle);
        return;
      case 7: 
        NowBizInterfaceHelper.onRoomActivityOnCreate(paramAnonymousBundle);
        return;
      }
      BaseAbilityHelper.reportData(paramAnonymousBundle);
    }
  };
  IPlatformCallback mPlatformCallback;
  
  public String getQTProxyServiceName()
  {
    return "com.tencent.proxyinner.plugin.loader.QTProxyService";
  }
  
  public void onEnter(Context paramContext, long paramLong, Bundle paramBundle) {}
  
  public void onPluginManagerCreate(Context paramContext, IPlatformCallback paramIPlatformCallback)
  {
    this.mPlatformCallback = paramIPlatformCallback;
    IPCHelper.addBizReqListener(this.mListener);
    com.tencent.util.e.a.a(new com.tencent.util.e.a.a()
    {
      public void print(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("level", paramAnonymousInt);
        localBundle.putString("tag", paramAnonymousString1);
        localBundle.putString("msg", paramAnonymousString2);
        BaseAbilityHelper.printLog(localBundle);
      }
    });
    com.tencent.util.g.a.a(new com.tencent.util.g.a.a()
    {
      public void report(Bundle paramAnonymousBundle)
      {
        BaseAbilityHelper.reportData(paramAnonymousBundle);
      }
    });
    com.tencent.util.c.b.a(new com.tencent.util.c.b.a()
    {
      public void download(String paramAnonymousString1, String paramAnonymousString2, Bundle paramAnonymousBundle, final com.tencent.util.c.a paramAnonymousa)
      {
        boolean bool = false;
        Bundle localBundle = new Bundle();
        localBundle.putString("url", paramAnonymousString1);
        localBundle.putString("path", paramAnonymousString2);
        if (paramAnonymousBundle == null)
        {
          paramAnonymousString1 = null;
          localBundle.putBundle("userdata", paramAnonymousString1);
          if (paramAnonymousBundle == null) {
            break label104;
          }
        }
        label104:
        for (int i = paramAnonymousBundle.getInt("action");; i = 0)
        {
          if ((i == 2) || (i == 2)) {
            bool = true;
          }
          localBundle.putBoolean("is_predownload", bool);
          BaseAbilityHelper.download(localBundle, new DownloadCallback()
          {
            public void onProgress(Bundle paramAnonymous2Bundle)
            {
              paramAnonymousa.a(paramAnonymous2Bundle.getLong("downloadSize"), paramAnonymous2Bundle.getLong("totalSize"));
            }
            
            public void onResult(Bundle paramAnonymous2Bundle)
            {
              com.tencent.util.e.a.a("NowPluginManager", " download onResult");
              paramAnonymousa.a(paramAnonymous2Bundle);
            }
            
            public void onStart()
            {
              paramAnonymousa.a();
            }
          });
          return;
          paramAnonymousString1 = paramAnonymousBundle.getBundle("userdata");
          break;
        }
      }
    });
    com.tencent.util.i.a.a(new com.tencent.util.i.a.a()
    {
      public void openWebView(String paramAnonymousString, Bundle paramAnonymousBundle)
      {
        Bundle localBundle = paramAnonymousBundle;
        if (paramAnonymousBundle == null) {
          localBundle = new Bundle();
        }
        localBundle.putString("url", paramAnonymousString);
        BaseAbilityHelper.openWebView(localBundle);
      }
    });
    com.tencent.util.a.a.a(new com.tencent.util.a.a.a()
    {
      public String getSelfUid()
      {
        return BaseAbilityHelper.getSelfUid();
      }
      
      public Bundle getTickets()
      {
        return BaseAbilityHelper.getTicket();
      }
    });
    com.tencent.util.h.a.a(new com.tencent.util.h.a.a()
    {
      public void jump(String paramAnonymousString)
      {
        BaseAbilityHelper.jumpAction(paramAnonymousString);
      }
    });
    com.tencent.util.f.b.a(new com.tencent.util.f.b.a()
    {
      public void getRecordInfo(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2, String paramAnonymousString3, final com.tencent.util.f.a paramAnonymousa)
      {
        paramAnonymousString2 = new Bundle();
        paramAnonymousString2.putString("fromId", paramAnonymousString1);
        paramAnonymousString2.putLong("roomId", paramAnonymousLong);
        NowBizInterfaceHelper.getRecordInfo(paramAnonymousString2, new CommonCallback()
        {
          public void onResult(Bundle paramAnonymous2Bundle)
          {
            if (paramAnonymousa != null) {
              paramAnonymousa.a(paramAnonymous2Bundle.getBoolean("isOnline"), paramAnonymous2Bundle.getString("videoUrl"), paramAnonymous2Bundle.getString("vid"), paramAnonymous2Bundle.getLong("timeConsume"), paramAnonymous2Bundle.getString("mqqApi"));
            }
          }
        });
      }
      
      public String getUrlByVid(String paramAnonymousString)
      {
        String str = "https://h5test.now.qq.com/h5/record.html?&_bid=2380&from=2";
        if (com.tencent.util.a.a()) {}
        for (;;)
        {
          return str + "&vid=" + paramAnonymousString;
          str = "https://now.qq.com/h5/record.html?&_bid=2380&from=2";
        }
      }
      
      public boolean isNeedGetRecord(Bundle paramAnonymousBundle)
      {
        if (!"1".equals(paramAnonymousBundle.getString("enter_record_if_finish", "1"))) {}
        for (;;)
        {
          return false;
          if (!paramAnonymousBundle.getString("shakespearetime", "").equals("1"))
          {
            String str = paramAnonymousBundle.getString("fromid");
            if ((str.equals("10001")) || (str.equals("10002"))) {}
            for (int i = 1; (i == 0) && (!paramAnonymousBundle.getString("roomtype", "").equals("8001")); i = 0) {
              return paramAnonymousBundle.getBoolean("need_record", true);
            }
          }
        }
      }
    });
    NowBizInterfaceHelper.setHostCallback(new IHostCallback()
    {
      public void killPluginProcess()
      {
        if (Platform.this.mPlatformCallback != null) {
          Platform.this.mPlatformCallback.killPluginProcess();
        }
      }
      
      public void notifyLoadingActivityBackPress()
      {
        if (Platform.this.mPlatformCallback != null) {
          Platform.this.mPlatformCallback.notifyLoadingActivityBackPress();
        }
      }
    });
    IPCHelper.addDataReportListener(new IDataReportListener()
    {
      public void onReportData(Bundle paramAnonymousBundle)
      {
        BaseAbilityHelper.reportData(paramAnonymousBundle);
      }
    });
    IPCHelper.addLogListener(new ILogListener()
    {
      public void onPrintLog(Bundle paramAnonymousBundle)
      {
        BaseAbilityHelper.printLog(paramAnonymousBundle);
      }
    });
    IPCHelper.addCsListener(new ICsListener()
    {
      public void onReceiveCsRequest(Bundle paramAnonymousBundle, final ChannelCallback paramAnonymousChannelCallback)
      {
        BaseAbilityHelper.sendCsTask(paramAnonymousBundle, new CommonCallback()
        {
          public void onResult(Bundle paramAnonymous2Bundle)
          {
            if (paramAnonymousChannelCallback != null) {
              paramAnonymousChannelCallback.responseToPlugin(paramAnonymous2Bundle);
            }
          }
        });
      }
    });
    IPCHelper.addDownloadReqListener(new IDownloadReqListener()
    {
      public void onDownload(Bundle paramAnonymousBundle, final ChannelCallback paramAnonymousChannelCallback)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("url", paramAnonymousBundle.getString("url"));
        localBundle.putString("path", paramAnonymousBundle.getString("filePath"));
        BaseAbilityHelper.download(localBundle, new DownloadCallback()
        {
          public void onProgress(Bundle paramAnonymous2Bundle)
          {
            long l1 = paramAnonymous2Bundle.getLong("downloadSize");
            long l2 = paramAnonymous2Bundle.getLong("totalSize");
            int i = paramAnonymous2Bundle.getInt("percent");
            paramAnonymous2Bundle.clear();
            paramAnonymous2Bundle.putInt("download_step", 1);
            paramAnonymous2Bundle.putLong("download_size", l1);
            paramAnonymous2Bundle.putLong("total_size", l2);
            paramAnonymous2Bundle.putInt("percent", i);
            paramAnonymousChannelCallback.responseToPlugin(paramAnonymous2Bundle);
          }
          
          public void onResult(Bundle paramAnonymous2Bundle)
          {
            int i = paramAnonymous2Bundle.getInt("errCode");
            int j = paramAnonymous2Bundle.getInt("httpCode");
            String str = paramAnonymous2Bundle.getString("errMsg");
            paramAnonymous2Bundle.clear();
            paramAnonymous2Bundle.putInt("err_code", i);
            if (i == 0) {
              paramAnonymous2Bundle.putInt("download_step", 2);
            }
            for (;;)
            {
              paramAnonymous2Bundle.putInt("download_retcode", j);
              paramAnonymous2Bundle.putString("download_errmsg", str);
              paramAnonymousChannelCallback.responseToPlugin(paramAnonymous2Bundle);
              return;
              paramAnonymous2Bundle.putInt("download_step", 3);
            }
          }
          
          public void onStart()
          {
            Bundle localBundle = new Bundle();
            localBundle.putInt("download_step", 0);
            paramAnonymousChannelCallback.responseToPlugin(localBundle);
          }
        });
      }
    });
  }
  
  public void onPluginManagerDestory()
  {
    this.mPlatformCallback = null;
    IPCHelper.removeAllListener();
  }
  
  public String pluginProcessName(Context paramContext)
  {
    return "com.tencent.mobileqq:troophomework";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.platform.Platform
 * JD-Core Version:    0.7.0.1
 */