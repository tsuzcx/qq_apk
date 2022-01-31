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

public class ajuv
  implements View.OnClickListener
{
  public ajuv(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    ajwj localajwj = (ajwj)paramView.getTag();
    String str;
    boolean bool;
    if ((localajwj != null) && (localajwj.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localajwj.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localajwj.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label256;
      }
      str = ((Friends)localajwj.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localajwj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localajwj.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label330;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localajwj.jdField_a_of_type_JavaLangString, str, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        if (localajwj.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Bbjz.b();
        }
        localajwj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localajwj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label353;
          }
          paramView.setContentDescription(localajwj.d.getText().toString() + alpo.a(2131705328));
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
      if ((localajwj.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
      {
        str = ((PhoneContact)localajwj.jdField_a_of_type_JavaLangObject).name;
        break;
      }
      if (!(localajwj.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
        break;
      }
      paramView = (RelationTroopEntity)localajwj.jdField_a_of_type_JavaLangObject;
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f(paramView.troopInfo.troopuin);
      this.a.jdField_a_of_type_Bbjz.d();
      return;
      label330:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localajwj.jdField_a_of_type_JavaLangString, str, 0, "-1");
      break label108;
      label353:
      paramView.setContentDescription(localajwj.d.getText().toString() + alpo.a(2131705327));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuv
 * JD-Core Version:    0.7.0.1
 */