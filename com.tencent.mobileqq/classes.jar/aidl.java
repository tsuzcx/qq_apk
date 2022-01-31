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

public class aidl
  implements View.OnClickListener
{
  public aidl(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    aifb localaifb = (aifb)paramView.getTag();
    String str;
    boolean bool;
    if ((localaifb != null) && (localaifb.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localaifb.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localaifb.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label236;
      }
      str = ((Friends)localaifb.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localaifb.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localaifb.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label262;
        }
        bool = this.a.a.a(localaifb.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localaifb.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localaifb.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label287;
          }
          paramView.setContentDescription(localaifb.d.getText().toString() + ajyc.a(2131704942));
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
      if (!(localaifb.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localaifb.jdField_a_of_type_JavaLangObject).name;
      break;
      label262:
      bool = this.a.a.a(localaifb.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label287:
      paramView.setContentDescription(localaifb.d.getText().toString() + ajyc.a(2131704943));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidl
 * JD-Core Version:    0.7.0.1
 */