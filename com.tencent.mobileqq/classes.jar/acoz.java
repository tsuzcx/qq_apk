import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class acoz
  extends MqqHandler
{
  public acoz(ChatSettingActivity paramChatSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    }
    Object localObject;
    boolean bool1;
    label308:
    label461:
    label757:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramMessage = (String)paramMessage.obj;
                ChatSettingActivity.a(this.a, paramMessage);
                return;
              } while (ChatSettingActivity.a(this.a) != 0);
              paramMessage = (String)paramMessage.obj;
            } while ((ChatSettingActivity.b(this.a) == null) || (paramMessage == null) || (!ChatSettingActivity.b(this.a).equals(paramMessage)));
            this.a.finish();
            return;
            StringBuilder localStringBuilder;
            if ((ChatSettingActivity.a(this.a) != 1001) && (ChatSettingActivity.a(this.a) != 10002)) {
              if (ChatSettingActivity.a(this.a) == 1006)
              {
                if (TextUtils.isEmpty(ChatSettingActivity.c(this.a))) {
                  ChatSettingActivity.b(this.a, false);
                }
              }
              else
              {
                paramMessage = (auac)this.a.app.getManager(16);
                if ((paramMessage != null) && (!TextUtils.isEmpty(ChatSettingActivity.d(this.a)))) {
                  ChatSettingActivity.a(this.a, paramMessage.a(ChatSettingActivity.d(this.a)));
                }
                if (QLog.isColorLevel())
                {
                  localObject = this.a.jdField_a_of_type_JavaLangString;
                  localStringBuilder = new StringBuilder().append("handleMessage, shieldMsgManger=");
                  if (paramMessage != null) {
                    break label461;
                  }
                  bool1 = true;
                  QLog.d((String)localObject, 2, bool1);
                }
              }
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "handleMessage, REFRESH_STRANGER_SHIELD_BUTTON, mIsShield=" + ChatSettingActivity.a(this.a) + ", mIsFollowed=" + this.a.jdField_a_of_type_Boolean + ", mShieldEnable=" + ChatSettingActivity.b(this.a));
              }
              ChatSettingActivity.b(this.a);
              return;
              paramMessage = bdgc.e(this.a.app, ChatSettingActivity.c(this.a));
              if (TextUtils.isEmpty(paramMessage))
              {
                ChatSettingActivity.b(this.a, false);
                break;
              }
              ChatSettingActivity.b(this.a, true);
              ChatSettingActivity.a(this.a, paramMessage);
              break;
              bool1 = false;
              break label308;
              paramMessage = (alto)this.a.app.getManager(51);
              if (paramMessage != null)
              {
                paramMessage = paramMessage.e(ChatSettingActivity.d(this.a));
                if (QLog.isColorLevel())
                {
                  localObject = this.a.jdField_a_of_type_JavaLangString;
                  localStringBuilder = new StringBuilder().append("handleMessage, f=");
                  if (paramMessage != null) {
                    break label574;
                  }
                }
                for (bool1 = true;; bool1 = false)
                {
                  QLog.d((String)localObject, 2, bool1);
                  if ((paramMessage == null) || (paramMessage.groupid != -1002)) {
                    break label579;
                  }
                  ChatSettingActivity.a(this.a, true);
                  break;
                }
                ChatSettingActivity.a(this.a, false);
              }
            }
            ChatSettingActivity.e(this.a);
            return;
            ChatSettingActivity.f(this.a);
            return;
          } while (!((String)paramMessage.obj).equals(ChatSettingActivity.b(this.a)));
          bool1 = FriendsStatusUtil.a(this.a.app, ChatSettingActivity.b(this.a), ChatSettingActivity.a(this.a));
        } while ((this.a.e == null) || (bool1 == this.a.e.a()));
        this.a.e.setOnCheckedChangeListener(null);
        this.a.e.setChecked(bool1);
        this.a.e.setOnCheckedChangeListener(this.a);
        return;
        localObject = (String)paramMessage.obj;
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (!((String)localObject).equals(ChatSettingActivity.b(this.a))));
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        if (bool1 == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) {
          break label833;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        if (paramMessage.arg1 != 1) {
          break label835;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        ((FormSwitchItem)localObject).setChecked(bool1);
        this.a.a();
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.a);
        return;
        bool1 = false;
        break label757;
        break;
      }
      localObject = (String)paramMessage.obj;
    } while ((this.a.b == null) || (!((String)localObject).equals(ChatSettingActivity.b(this.a))));
    label574:
    label579:
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      label884:
      if (bool1 == this.a.b.a()) {
        break label999;
      }
      this.a.b.setOnCheckedChangeListener(null);
      localObject = this.a.b;
      if (paramMessage.arg1 != 1) {
        break label1001;
      }
      bool1 = bool3;
      ((FormSwitchItem)localObject).setChecked(bool1);
      this.a.a();
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.a.b.a()) || (this.a.c.a())) {
        break label1006;
      }
    }
    for (;;)
    {
      label833:
      label835:
      paramMessage.setVisibility(i);
      label929:
      this.a.b.setOnCheckedChangeListener(this.a);
      return;
      bool1 = false;
      break label884;
      label999:
      break;
      label1001:
      bool1 = false;
      break label929;
      label1006:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acoz
 * JD-Core Version:    0.7.0.1
 */