import android.app.Dialog;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class adhq
  implements Runnable
{
  public adhq(PresenceInterfaceImpl paramPresenceInterfaceImpl, String paramString) {}
  
  public void run()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqHotpicPresenceInterfaceImpl.a, 232, null, this.jdField_a_of_type_JavaLangString, new adhr(this), null);
    try
    {
      localQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PresenceInterfaceImpl", 2, "show dialog fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adhq
 * JD-Core Version:    0.7.0.1
 */