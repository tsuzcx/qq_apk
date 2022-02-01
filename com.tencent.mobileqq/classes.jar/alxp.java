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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.createNewTroop.RelationTroopEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alxp
  implements View.OnClickListener
{
  public alxp(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    alyj localalyj = (alyj)paramView.getTag();
    Object localObject;
    boolean bool;
    if ((localalyj != null) && (localalyj.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localalyj.jdField_a_of_type_JavaLangObject != null))
    {
      localObject = "";
      if (!(localalyj.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label263;
      }
      localObject = ((Friends)localalyj.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localalyj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localalyj.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label339;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.onListViewItemClick(localalyj.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        if (localalyj.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Bfeq.b();
        }
        localalyj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localalyj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label362;
          }
          paramView.setContentDescription(localalyj.d.getText().toString() + anvx.a(2131704423));
        }
      }
    }
    for (;;)
    {
      this.a.f();
      if (AppSetting.c) {
        paramView.postDelayed(new FriendTeamListInnerFrame.2.1(this, paramView), 2000L);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label263:
        if ((localalyj.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
        {
          localObject = ((PhoneContact)localalyj.jdField_a_of_type_JavaLangObject).name;
          break;
        }
        if (!(localalyj.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
          break;
        }
        localObject = (RelationTroopEntity)localalyj.jdField_a_of_type_JavaLangObject;
        this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.onRelationTroopItemClick(((RelationTroopEntity)localObject).troopInfo.troopuin);
        this.a.jdField_a_of_type_Bfeq.d();
      }
      label339:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.onListViewItemClick(localalyj.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1");
      break label108;
      label362:
      paramView.setContentDescription(localalyj.d.getText().toString() + anvx.a(2131704422));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxp
 * JD-Core Version:    0.7.0.1
 */