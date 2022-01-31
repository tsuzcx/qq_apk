import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.qphone.base.util.QLog;

public class aimv
  implements View.OnClickListener
{
  public aimv(ContactListAdapter paramContactListAdapter) {}
  
  public void onClick(View paramView)
  {
    QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick");
    aind localaind = (aind)paramView.getTag();
    String str;
    boolean bool;
    if ((localaind != null) && (localaind.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localaind.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localaind.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label231;
      }
      str = ((Friends)localaind.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localaind.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localaind.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label257;
        }
        bool = this.a.a.a(localaind.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("createNewTroop.ContactListAdapter", 2, "----->onBuddyListClick = " + bool);
        }
        localaind.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.b)
        {
          if (!localaind.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label280;
          }
          paramView.setContentDescription(localaind.d.getText().toString() + "已选中");
        }
      }
    }
    for (;;)
    {
      this.a.a();
      if (AppSetting.b) {
        paramView.postDelayed(new aimw(this, paramView), 2000L);
      }
      return;
      label231:
      if (!(localaind.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localaind.jdField_a_of_type_JavaLangObject).name;
      break;
      label257:
      bool = this.a.a.a(localaind.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label280:
      paramView.setContentDescription(localaind.d.getText().toString() + "未选中");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aimv
 * JD-Core Version:    0.7.0.1
 */