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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alsa
  implements View.OnClickListener
{
  public alsa(FriendTeamListInnerFrame paramFriendTeamListInnerFrame) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick");
    alto localalto = (alto)paramView.getTag();
    Object localObject;
    boolean bool;
    if ((localalto != null) && (localalto.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localalto.jdField_a_of_type_JavaLangObject != null))
    {
      localObject = "";
      if (!(localalto.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label263;
      }
      localObject = ((Friends)localalto.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localalto.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localalto.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label339;
        }
        bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localalto.jdField_a_of_type_JavaLangString, (String)localObject, 4, "-1");
        label108:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTeamListInnerFrameNew", 2, "----->onBuddyListClick = " + bool);
        }
        if (localalto.jdField_a_of_type_Long == 1007L) {
          this.a.jdField_a_of_type_Beow.b();
        }
        localalto.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localalto.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label362;
          }
          paramView.setContentDescription(localalto.d.getText().toString() + anni.a(2131703736));
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
        if ((localalto.jdField_a_of_type_JavaLangObject instanceof PhoneContact))
        {
          localObject = ((PhoneContact)localalto.jdField_a_of_type_JavaLangObject).name;
          break;
        }
        if (!(localalto.jdField_a_of_type_JavaLangObject instanceof RelationTroopEntity)) {
          break;
        }
        localObject = (RelationTroopEntity)localalto.jdField_a_of_type_JavaLangObject;
        this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f(((RelationTroopEntity)localObject).troopInfo.troopuin);
        this.a.jdField_a_of_type_Beow.d();
      }
      label339:
      bool = this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localalto.jdField_a_of_type_JavaLangString, (String)localObject, 0, "-1");
      break label108;
      label362:
      paramView.setContentDescription(localalto.d.getText().toString() + anni.a(2131703735));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsa
 * JD-Core Version:    0.7.0.1
 */