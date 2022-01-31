import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class adya
  extends ContactBindObserver
{
  boolean jdField_a_of_type_Boolean = false;
  
  public adya(MyBusinessManager paramMyBusinessManager) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean2))
    {
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessManager.a.getManager(10)).a();
      if ((localRespondQueryQQBindingStat == null) || (TextUtils.isEmpty(localRespondQueryQQBindingStat.mobileNo))) {
        break label95;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "mybusiness ContactBindObserver onQueryBindState");
      }
      ((MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessManager.a.getManager(48)).a(localRespondQueryQQBindingStat.mobileNo, localRespondQueryQQBindingStat.type, "", false);
      this.jdField_a_of_type_Boolean = false;
    }
    label95:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PhoneContact", 2, "mybusiness bindInfo null ");
  }
  
  protected void c(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adya
 * JD-Core Version:    0.7.0.1
 */