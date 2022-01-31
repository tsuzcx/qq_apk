import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.FriendTeamListInnerFrame.2.1;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;

public class aidl
  implements View.OnClickListener
{
  public aidl(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    aiez localaiez = (aiez)paramView.getTag();
    String str;
    boolean bool;
    if ((localaiez != null) && (localaiez.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localaiez.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localaiez.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label256;
      }
      str = ((Friends)localaiez.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localaiez.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localaiez.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label330;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaiez.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        if (localaiez.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Azlq.b();
        }
        localaiez.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localaiez.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label353;
          }
          paramView.setContentDescription(localaiez.d.getText().toString() + ajya.a(2131704956));
        }
      }
    }
    for (;;)
    {
      this.a.f();
      if (AppSetting.d) {
        paramView.postDelayed(new FriendTeamListInnerFrame.2.1(this, paramView), 2000L);
      }
      return;
      label256:
      if ((localaiez.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        str = ((PhoneContact)localaiez.jdField_a_of_type_JavaLangObject).name;
        break;
      }
      if (!(localaiez.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
        break;
      }
      paramView = (RelationTroopEntity)localaiez.jdField_a_of_type_JavaLangObject;
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f(paramView.troopInfo.troopuin);
      this.a.jdField_a_of_type_Azlq.d();
      return;
      label330:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaiez.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label353:
      paramView.setContentDescription(localaiez.d.getText().toString() + ajya.a(2131704955));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidl
 * JD-Core Version:    0.7.0.1
 */