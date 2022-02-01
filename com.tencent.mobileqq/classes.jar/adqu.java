import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class adqu
  extends aodm
{
  public adqu(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList)
  {
    if (!ChatSettingActivity.d(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onAddShieldList, mShieldByThis=" + ChatSettingActivity.d(this.a));
      }
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.g(this.a);
    paramList = this.a;
    ChatSettingActivity localChatSettingActivity = this.a;
    if (paramBoolean) {}
    for (int i = 2131718816;; i = 2131718805)
    {
      QQToast.a(paramList, 2, localChatSettingActivity.getString(i), 0).b(this.a.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onAddShieldList, isSuccess=" + paramBoolean + ", mShieldByThis=" + ChatSettingActivity.d(this.a) + ", mShieldUin=" + ChatSettingActivity.e(this.a) + ", mIsShield=" + ChatSettingActivity.a(this.a));
      }
      if (!paramBoolean) {
        break;
      }
      paramList = (awtp)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.e(this.a)))) {
        ChatSettingActivity.a(this.a, paramList.a(ChatSettingActivity.e(this.a)));
      }
      ChatSettingActivity.b(this.a);
      if (ChatSettingActivity.a(this.a))
      {
        this.a.jdField_a_of_type_Boolean = false;
        ChatSettingActivity.a(this.a);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onAddShieldList, mIsShield=" + ChatSettingActivity.a(this.a) + ", mIsFollowed=" + this.a.jdField_a_of_type_Boolean);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, List<Long> paramList)
  {
    if (!ChatSettingActivity.d(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.g(this.a);
    paramList = this.a;
    ChatSettingActivity localChatSettingActivity = this.a;
    if (paramBoolean) {}
    for (int i = 2131718804;; i = 2131718803)
    {
      QQToast.a(paramList, 2, localChatSettingActivity.getString(i), 0).b(this.a.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDeleteShieldList, isSuccess=" + paramBoolean);
      }
      if (!paramBoolean) {
        break;
      }
      paramList = (awtp)this.a.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.e(this.a)))) {
        ChatSettingActivity.a(this.a, paramList.a(ChatSettingActivity.e(this.a)));
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDeleteShieldList, mIsShield=" + ChatSettingActivity.a(this.a));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131718803, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqu
 * JD-Core Version:    0.7.0.1
 */