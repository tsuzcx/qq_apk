import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class amau
{
  private alvn jdField_a_of_type_Alvn = new amaw(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new amav(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public amau(String paramString)
  {
    try
    {
      this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString));
      paramString = new IntentFilter();
      paramString.addAction("com.tencent.mobileqq.addLbsObserver");
      paramString.addAction("com.tencent.mobileqq.removeLbsObserver");
      paramString.addAction("com.tencent.mobileqq.getStreetViewUrl");
      paramString.addAction("com.tencent.mobileqq.unregisterReceiver");
      paramString.addAction("com.tencent.mobileqq.getLbsShareSearch");
      paramString.addAction("com.tencent.mobileqq.getLbsShareShop");
      paramString.addAction("com.tencent.mobileqq.getShareShopDetail");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("QQMapActivityProxy", 2, "QQMapActivityProxy-create, registerReceiver:" + hashCode() + ", " + this.jdField_a_of_type_AndroidContentBroadcastReceiver.hashCode());
      }
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQMapActivityProxy", 2, "AccountNotMatchException " + paramString.toString());
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivityProxy", 2, "onDestory,  hashCode=" + hashCode());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alvn);
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("QQMapActivityProxy", 2, "onDestory, mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amau
 * JD-Core Version:    0.7.0.1
 */