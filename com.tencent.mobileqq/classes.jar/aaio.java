import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.IArConfigListener;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArRemoteCallback;
import com.tencent.qphone.base.util.QLog;

public class aaio
  implements IArConfigListener
{
  public aaio(ArConfigService paramArConfigService) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramInt);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
    ArConfigUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, paramInt);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramLong1, paramLong2);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(null, null, paramARCommonConfigInfo);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException paramARCommonConfigInfo)
    {
      paramARCommonConfigInfo.printStackTrace();
    }
  }
  
  public void a(ArConfigInfo paramArConfigInfo)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(paramArConfigInfo, null, null);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException paramArConfigInfo)
    {
      paramArConfigInfo.printStackTrace();
    }
  }
  
  public void a(ArEffectConfig paramArEffectConfig)
  {
    if (ArConfigService.a(this.a) != null) {}
    try
    {
      int j = ArConfigService.a(this.a).beginBroadcast();
      int i = 0;
      while (i < j)
      {
        ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a(null, paramArEffectConfig, null);
        i += 1;
      }
      ArConfigService.a(this.a).finishBroadcast();
      return;
    }
    catch (RemoteException paramArEffectConfig)
    {
      paramArEffectConfig.printStackTrace();
    }
  }
  
  public void b()
  {
    if (ArConfigService.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess before sync");
      }
      synchronized (this.a.jdField_a_of_type_JavaLangObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess  sync start");
        }
        int j = ArConfigService.a(this.a).beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              ((IArRemoteCallback)ArConfigService.a(this.a).getBroadcastItem(i)).a();
              i += 1;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                localRemoteException.printStackTrace();
              }
            }
          }
        }
      }
      ArConfigService.a(this.a).finishBroadcast();
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess  sync end");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArConfig_ArConfigService", 2, "onDownloadSuccess after sync");
      }
      ArConfigUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaio
 * JD-Core Version:    0.7.0.1
 */