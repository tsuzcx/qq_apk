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

public class ahqv
  implements View.OnClickListener
{
  public ahqv(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    ahsj localahsj = (ahsj)paramView.getTag();
    String str;
    boolean bool;
    if ((localahsj != null) && (localahsj.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localahsj.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localahsj.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label256;
      }
      str = ((Friends)localahsj.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localahsj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localahsj.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label330;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localahsj.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        if (localahsj.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Ayky.b();
        }
        localahsj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localahsj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label353;
          }
          paramView.setContentDescription(localahsj.d.getText().toString() + ajjy.a(2131639160));
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
      if ((localahsj.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        str = ((PhoneContact)localahsj.jdField_a_of_type_JavaLangObject).name;
        break;
      }
      if (!(localahsj.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
        break;
      }
      paramView = (RelationTroopEntity)localahsj.jdField_a_of_type_JavaLangObject;
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f(paramView.troopInfo.troopuin);
      this.a.jdField_a_of_type_Ayky.d();
      return;
      label330:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localahsj.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label353:
      paramView.setContentDescription(localahsj.d.getText().toString() + ajjy.a(2131639159));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahqv
 * JD-Core Version:    0.7.0.1
 */