import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.QQSettingMe.34.1;
import com.tencent.mobileqq.activity.QQSettingMe.34.2;
import com.tencent.mobileqq.activity.QQSettingMe.34.3;
import com.tencent.mobileqq.activity.QQSettingMe.34.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aeaw
  extends CardObserver
{
  public aeaw(QQSettingMe paramQQSettingMe) {}
  
  public void onAnonymousSettingMeRedPoint(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onAnonymousSettingMeRedPoint success=%s enable=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    if ((paramBoolean1) && (this.a.c)) {
      QQSettingMe.a(this.a, false);
    }
  }
  
  public void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((paramObject instanceof Card)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((Card)paramObject).uin)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.34.1(this));
        ThreadManager.post(new QQSettingMe.34.2(this), 5, null, true);
        return;
      }
    } while ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!(paramObject instanceof Card)) || (this.a.c) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((Card)paramObject).uin)));
    ThreadManager.post(new QQSettingMe.34.3(this, (Card)paramObject), 5, null, true);
  }
  
  public void onGetMedal(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.a.c)) {
      QQSettingMe.a(this.a, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onGetMedal [%b, %b] medalSwitchDisable= ", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(this.a.c), Boolean.valueOf(paramBoolean2) }));
    }
  }
  
  public void onGetSignInInfo(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new QQSettingMe.34.4(this));
    }
  }
  
  public void onSetMedal(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.c)) {
      QQSettingMe.a(this.a, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, String.format("onSetMedal [%b %b]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.a.c) }));
    }
  }
  
  public void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (bftf.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeaw
 * JD-Core Version:    0.7.0.1
 */