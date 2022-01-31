import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.FriendTabView;
import com.tencent.mobileqq.activity.selectmember.FriendTabView.3.1;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;

public class ajzi
  implements View.OnClickListener
{
  public ajzi(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    akay localakay = (akay)paramView.getTag();
    String str;
    boolean bool;
    if ((localakay != null) && (localakay.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localakay.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localakay.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label236;
      }
      str = ((Friends)localakay.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localakay.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localakay.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label262;
        }
        bool = this.a.a.a(localakay.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localakay.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localakay.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label287;
          }
          paramView.setContentDescription(localakay.d.getText().toString() + alud.a(2131705337));
        }
      }
    }
    for (;;)
    {
      this.a.c();
      if (AppSetting.c) {
        paramView.postDelayed(new FriendTabView.3.1(this, paramView), 2000L);
      }
      return;
      label236:
      if (!(localakay.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localakay.jdField_a_of_type_JavaLangObject).name;
      break;
      label262:
      bool = this.a.a.a(localakay.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label287:
      paramView.setContentDescription(localakay.d.getText().toString() + alud.a(2131705338));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzi
 * JD-Core Version:    0.7.0.1
 */