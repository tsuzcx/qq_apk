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

public class ajzk
  implements View.OnClickListener
{
  public ajzk(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    akay localakay = (akay)paramView.getTag();
    String str;
    boolean bool;
    if ((localakay != null) && (localakay.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localakay.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localakay.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label256;
      }
      str = ((Friends)localakay.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localakay.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localakay.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label330;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localakay.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        if (localakay.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Bboi.b();
        }
        localakay.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localakay.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label353;
          }
          paramView.setContentDescription(localakay.d.getText().toString() + alud.a(2131705340));
        }
      }
    }
    for (;;)
    {
      this.a.f();
      if (AppSetting.c) {
        paramView.postDelayed(new FriendTeamListInnerFrame.2.1(this, paramView), 2000L);
      }
      return;
      label256:
      if ((localakay.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        str = ((PhoneContact)localakay.jdField_a_of_type_JavaLangObject).name;
        break;
      }
      if (!(localakay.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
        break;
      }
      paramView = (RelationTroopEntity)localakay.jdField_a_of_type_JavaLangObject;
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f(paramView.troopInfo.troopuin);
      this.a.jdField_a_of_type_Bboi.d();
      return;
      label330:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localakay.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label353:
      paramView.setContentDescription(localakay.d.getText().toString() + alud.a(2131705339));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzk
 * JD-Core Version:    0.7.0.1
 */