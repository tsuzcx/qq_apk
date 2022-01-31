import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

class aldg
  implements ServiceConnection
{
  aldg(aldf paramaldf) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.a.jdField_a_of_type_Aleb = alec.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onServiceConnected configManager=" + this.a.jdField_a_of_type_Aleb);
    }
    if (this.a.jdField_a_of_type_Aleb != null) {}
    try
    {
      this.a.jdField_a_of_type_Aleb.a(this.a.jdField_a_of_type_Alen);
      this.a.jdField_a_of_type_Aleb.a(this.a.jdField_a_of_type_Alee);
      this.a.jdField_a_of_type_Aleb.a(aldf.a(this.a));
      this.a.jdField_a_of_type_Aleb.a(this.a.jdField_a_of_type_Alek);
      if (aldf.a(this.a) != -1) {
        this.a.jdField_a_of_type_Aleb.c(aldf.a(this.a));
      }
      if (aldf.a(this.a) != null) {
        aldf.a(this.a).sendEmptyMessage(0);
      }
      if (this.a.c)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = this.a.a();
        if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) && (aldf.a(this.a) != null))
        {
          paramComponentName = Message.obtain();
          paramComponentName.what = 1;
          paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
          aldf.a(this.a).sendMessage(paramComponentName);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = this.a.a();
      if (this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig != null) && (aldf.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlArEffectConfig;
        aldf.a(this.a).sendMessage(paramComponentName);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = this.a.a();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (aldf.a(this.a) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 9;
        paramComponentName.obj = this.a.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
        aldf.a(this.a).sendMessage(paramComponentName);
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
    if (this.a.jdField_a_of_type_Aleb != null) {}
    try
    {
      this.a.jdField_a_of_type_Aleb.b(this.a.jdField_a_of_type_Alen);
      this.a.jdField_a_of_type_Aleb.b(this.a.jdField_a_of_type_Alee);
      this.a.jdField_a_of_type_Aleb.b(aldf.a(this.a));
      this.a.jdField_a_of_type_Aleb.b(this.a.jdField_a_of_type_Alek);
      this.a.jdField_a_of_type_Aleb = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aldg
 * JD-Core Version:    0.7.0.1
 */