import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class akjz
{
  akpq jdField_a_of_type_Akpq = null;
  private akqf jdField_a_of_type_Akqf;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Akpq != null)
      {
        if (this.jdField_a_of_type_Akqf != null)
        {
          this.jdField_a_of_type_Akpq.b(this.jdField_a_of_type_Akqf);
          this.jdField_a_of_type_Akqf = null;
        }
        if (this.jdField_a_of_type_AndroidContentServiceConnection != null)
        {
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          this.jdField_a_of_type_AndroidContentServiceConnection = null;
        }
        this.jdField_a_of_type_Akpq = null;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.w(akkm.a, 1, "DownloadDependRes.clean, Exception", localException);
    }
  }
  
  void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (!ArConfigService.e(BaseApplicationImpl.getApplication().getRuntime()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(akkm.a, 1, "tryDownload, so未准备");
      }
      b();
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Akpq != null) {
      try
      {
        this.jdField_a_of_type_Akpq.c();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(akkm.a, 2, "downloadArSo Exception", localException);
        return;
      }
    }
    this.jdField_a_of_type_Akqf = new akka(this);
    this.jdField_a_of_type_AndroidContentServiceConnection = new akkb(this);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ArConfigService.class);
    boolean bool = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    QLog.w(akkm.a, 1, "bindServer, ret[" + bool + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akjz
 * JD-Core Version:    0.7.0.1
 */