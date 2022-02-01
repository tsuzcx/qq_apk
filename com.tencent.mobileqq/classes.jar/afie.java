import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingMe.33.1;
import com.tencent.mobileqq.activity.QQSettingMe.33.2;
import com.tencent.mobileqq.activity.QQSettingMe.33.3;
import com.tencent.mobileqq.activity.QQSettingMe.33.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afie
  extends anuw
{
  public afie(QQSettingMe paramQQSettingMe) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((paramObject instanceof Card)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((Card)paramObject).uin)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.33.1(this));
        ThreadManager.post(new QQSettingMe.33.2(this), 5, null, true);
        return;
      }
    } while ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!(paramObject instanceof Card)) || (this.a.c) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((Card)paramObject).uin)));
    ThreadManager.post(new QQSettingMe.33.3(this, (Card)paramObject), 5, null, true);
  }
  
  protected void onGetMedal(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.c)) {
      QQSettingMe.a(this.a, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onGetMedal [%b, %b] medalSwitchDisable= ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.a.c), Boolean.valueOf(paramBoolean2) }));
    }
  }
  
  protected void onGetSignInInfo(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new QQSettingMe.33.4(this));
    }
  }
  
  protected void onSetMedal(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.c)) {
      QQSettingMe.a(this.a, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onSetMedal [%b %b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.a.c) }));
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (bhjx.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afie
 * JD-Core Version:    0.7.0.1
 */