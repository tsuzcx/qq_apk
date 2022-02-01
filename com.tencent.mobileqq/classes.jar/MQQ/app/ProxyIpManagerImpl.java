package mqq.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpChannel;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpInfo;
import com.tencent.msf.service.protocol.serverconfig.ProxyIpList;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class ProxyIpManagerImpl
  implements ProxyIpManager
{
  private static final int MSG_NOTIFY_PROXY_IP_CHANGED = 10000;
  private static final String SP_KEY_PROXYIP = "_key_proxyip_";
  private static final String TAG = "ProxyIpManagerImpl";
  private final AppRuntime mApp;
  private Handler mHandler = new ProxyIpManagerImpl.1(this, Looper.getMainLooper());
  private MsfStore mMsfStore;
  private ArrayList<ProxyIpList> mProxyIpCache;
  
  public ProxyIpManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mMsfStore = new MsfStore();
    this.mMsfStore.init(BaseApplication.getContext());
    reloadCache(this.mApp.getAccount(), true);
  }
  
  public List<ProxyIpManager.ProxyIp> getProxyIp(int paramInt)
  {
    if (!isMobileNetWork(this.mApp.getApplication()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Load local proxy ip failed, uin:");
      ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(this.mApp.getAccount()));
      ((StringBuilder)localObject1).append(" type: ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" reason: not mobile network!");
      QLog.d("ProxyIpManagerImpl", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    Object localObject1 = this.mProxyIpCache;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = this.mProxyIpCache.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ProxyIpList)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((ProxyIpList)localObject2).uService_type == paramInt))
        {
          if ((((ProxyIpList)localObject2).vIplist != null) && (((ProxyIpList)localObject2).vIplist.size() > 0))
          {
            localObject1 = new ArrayList();
            localObject2 = ((ProxyIpList)localObject2).vIplist.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              ProxyIpInfo localProxyIpInfo = (ProxyIpInfo)((Iterator)localObject2).next();
              ProxyIpManager.ProxyIp localProxyIp = new ProxyIpManager.ProxyIp();
              localProxyIp.type = localProxyIpInfo.uType;
              localProxyIp.ip = StringUtils.getIpAddrFromInt(localProxyIpInfo.uIp);
              localProxyIp.port = localProxyIpInfo.uPort;
              ((ArrayList)localObject1).add(localProxyIp);
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Load local proxy ip succ, uin: ");
            ((StringBuilder)localObject2).append(MsfSdkUtils.getShortUin(this.mApp.getAccount()));
            ((StringBuilder)localObject2).append(" type: ");
            ((StringBuilder)localObject2).append(paramInt);
            ((StringBuilder)localObject2).append(" iplist: ");
            ((StringBuilder)localObject2).append(((ArrayList)localObject1).toString());
            QLog.d("ProxyIpManagerImpl", 1, ((StringBuilder)localObject2).toString());
            return localObject1;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Load local proxy ip failed, uin: ");
          ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(this.mApp.getAccount()));
          ((StringBuilder)localObject1).append(" type: ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append(" reason: ip list is null!");
          QLog.d("ProxyIpManagerImpl", 1, ((StringBuilder)localObject1).toString());
          return null;
        }
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Load local proxy ip failed, uin: ");
    ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(this.mApp.getAccount()));
    ((StringBuilder)localObject1).append(" type: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(" reason: ip cache is null!");
    QLog.d("ProxyIpManagerImpl", 1, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public boolean isMobileNetWork(Context paramContext)
  {
    try
    {
      boolean bool = isMobileNetworkInfo(((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo());
      return bool;
    }
    catch (Exception paramContext)
    {
      label19:
      break label19;
    }
    return false;
  }
  
  public boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return false;
    }
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  public void onDestroy() {}
  
  public void reloadCache(String paramString, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.mApp.getAccount())))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("_key_proxyip_");
      ((StringBuilder)localObject1).append(this.mApp.getAccount());
      localObject1 = ((StringBuilder)localObject1).toString();
      try
      {
        MsfStore.getNativeConfigStore().loadConfig(this.mApp.getApplication(), false);
        localObject1 = MsfStore.getNativeConfigStore().getConfig((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new JceInputStream(HexUtil.hexStr2Bytes((String)localObject1));
          localObject2 = new ProxyIpChannel();
          ((ProxyIpChannel)localObject2).readFrom((JceInputStream)localObject1);
          if ((((ProxyIpChannel)localObject2).vProxy_iplists != null) && (((ProxyIpChannel)localObject2).vProxy_iplists.size() > 0))
          {
            this.mProxyIpCache = ((ProxyIpChannel)localObject2).vProxy_iplists;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Load local proxy ip failed, uin: ");
            ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(paramString));
            ((StringBuilder)localObject1).append(" Parsed proxy ip is empty");
            QLog.d("ProxyIpManagerImpl", 1, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          this.mProxyIpCache = null;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Load local proxy ip failed, uin: ");
          ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(paramString));
          ((StringBuilder)localObject1).append(" config is empty");
          QLog.d("ProxyIpManagerImpl", 1, ((StringBuilder)localObject1).toString());
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Load local proxy ip failed, uin: ");
        ((StringBuilder)localObject2).append(MsfSdkUtils.getShortUin(paramString));
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(localThrowable.getMessage());
        QLog.d("ProxyIpManagerImpl", 1, ((StringBuilder)localObject2).toString());
      }
      this.mHandler.sendEmptyMessageDelayed(10000, 100L);
      return;
    }
    QLog.d("ProxyIpManagerImpl", 1, "Load local proxy ip failed: uin is mismatch with app account");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.ProxyIpManagerImpl
 * JD-Core Version:    0.7.0.1
 */