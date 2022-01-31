import com.tencent.common.app.AppInterface;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class altf
  implements Runnable
{
  public altf(QidianManager paramQidianManager, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentQidianQidianManager.a.getApp().getBaseContext(), new BmqqAccountType(this.jdField_a_of_type_JavaLangString, 6));
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "isQidianMaster get user detail in main thread");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altf
 * JD-Core Version:    0.7.0.1
 */