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

public class aidn
  implements View.OnClickListener
{
  public aidn(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    aifb localaifb = (aifb)paramView.getTag();
    String str;
    boolean bool;
    if ((localaifb != null) && (localaifb.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localaifb.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localaifb.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label256;
      }
      str = ((Friends)localaifb.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localaifb.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localaifb.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label330;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaifb.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        if (localaifb.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Azlo.b();
        }
        localaifb.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.d)
        {
          if (!localaifb.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label353;
          }
          paramView.setContentDescription(localaifb.d.getText().toString() + ajyc.a(2131704945));
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
      if ((localaifb.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        str = ((PhoneContact)localaifb.jdField_a_of_type_JavaLangObject).name;
        break;
      }
      if (!(localaifb.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
        break;
      }
      paramView = (RelationTroopEntity)localaifb.jdField_a_of_type_JavaLangObject;
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f(paramView.troopInfo.troopuin);
      this.a.jdField_a_of_type_Azlo.d();
      return;
      label330:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localaifb.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label353:
      paramView.setContentDescription(localaifb.d.getText().toString() + ajyc.a(2131704944));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidn
 * JD-Core Version:    0.7.0.1
 */