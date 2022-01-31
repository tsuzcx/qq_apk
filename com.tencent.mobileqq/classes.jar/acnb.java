import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.qphone.base.util.BaseApplication;

public class acnb
  implements Runnable
{
  public acnb(OnlineFileSessionCenter paramOnlineFileSessionCenter, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    OnlineFileSessionCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter, new acnc(this));
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(OnlineFileSessionCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreOnlineFileSessionCenter), localIntentFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acnb
 * JD-Core Version:    0.7.0.1
 */