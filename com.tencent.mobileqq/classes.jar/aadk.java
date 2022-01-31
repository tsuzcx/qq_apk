import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.RemoteArConfigManager;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.mobileqq.ar.aidl.IArConfigManager;
import com.tencent.mobileqq.ar.aidl.IArConfigManager.Stub;
import com.tencent.qphone.base.util.QLog;

public class aadk
  implements ServiceConnection
{
  public aadk(RemoteArConfigManager paramRemoteArConfigManager) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = IArConfigManager.Stub.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onServiceConnected configManager=" + this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArRemoteCallback);
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArFaceCallback);
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.a(RemoteArConfigManager.a(this.a));
      if (RemoteArConfigManager.a(this.a) != -1) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(RemoteArConfigManager.a(this.a));
      }
      if (RemoteArConfigManager.a(this.a) != null) {
        RemoteArConfigManager.a(this.a).sendEmptyMessage(0);
      }
      if (this.a.c)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = this.a.a();
        if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) && (RemoteArConfigManager.a(this.a) != null))
        {
          paramComponentName = Message.obtain();
          paramComponentName.what = 1;
          paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
          RemoteArConfigManager.a(this.a).sendMessage(paramComponentName);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) && (RemoteArConfigManager.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
        RemoteArConfigManager.a(this.a).sendMessage(paramComponentName);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = this.a.a();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (RemoteArConfigManager.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 9;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
        RemoteArConfigManager.a(this.a).sendMessage(paramComponentName);
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "registerArCallback: " + paramComponentName.getMessage());
        }
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager != null) {}
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArRemoteCallback);
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArFaceCallback);
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager.b(RemoteArConfigManager.a(this.a));
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlIArConfigManager = null;
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "unregisterCallback: " + paramComponentName.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aadk
 * JD-Core Version:    0.7.0.1
 */