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

public class aidj
  implements View.OnClickListener
{
  public aidj(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    aiez localaiez = (aiez)paramView.getTag();
    String str;
    boolean bool;
    if ((localaiez != null) && (localaiez.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localaiez.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localaiez.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label236;
      }
      str = ((Friends)localaiez.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localaiez.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localaiez.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label262;
        }
        bool = this.a.a.a(localaiez.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localaiez.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localaiez.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label287;
          }
          paramView.setContentDescription(localaiez.d.getText().toString() + ajya.a(2131704953));
        }
      }
    }
    for (;;)
    {
      this.a.c();
      if (AppSetting.d) {
        paramView.postDelayed(new FriendTabView.3.1(this, paramView), 2000L);
      }
      return;
      label236:
      if (!(localaiez.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localaiez.jdField_a_of_type_JavaLangObject).name;
      break;
      label262:
      bool = this.a.a.a(localaiez.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label287:
      paramView.setContentDescription(localaiez.d.getText().toString() + ajya.a(2131704954));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidj
 * JD-Core Version:    0.7.0.1
 */