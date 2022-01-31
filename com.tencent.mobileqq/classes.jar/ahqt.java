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

public class ahqt
  implements View.OnClickListener
{
  public ahqt(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    ahsj localahsj = (ahsj)paramView.getTag();
    String str;
    boolean bool;
    if ((localahsj != null) && (localahsj.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localahsj.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localahsj.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label236;
      }
      str = ((Friends)localahsj.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localahsj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localahsj.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label262;
        }
        bool = this.a.a.a(localahsj.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localahsj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localahsj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label287;
          }
          paramView.setContentDescription(localahsj.d.getText().toString() + ajjy.a(2131639157));
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
      if (!(localahsj.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localahsj.jdField_a_of_type_JavaLangObject).name;
      break;
      label262:
      bool = this.a.a.a(localahsj.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label287:
      paramView.setContentDescription(localahsj.d.getText().toString() + ajjy.a(2131639158));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahqt
 * JD-Core Version:    0.7.0.1
 */