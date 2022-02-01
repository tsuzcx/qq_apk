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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alxn
  implements View.OnClickListener
{
  public alxn(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    alyj localalyj = (alyj)paramView.getTag();
    String str;
    boolean bool;
    if ((localalyj != null) && (localalyj.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localalyj.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localalyj.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label243;
      }
      str = ((Friends)localalyj.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localalyj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localalyj.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label269;
        }
        bool = this.a.a.onListViewItemClick(localalyj.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localalyj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localalyj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label294;
          }
          paramView.setContentDescription(localalyj.d.getText().toString() + anvx.a(2131704420));
        }
      }
    }
    for (;;)
    {
      this.a.c();
      if (AppSetting.c) {
        paramView.postDelayed(new FriendTabView.3.1(this, paramView), 2000L);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label243:
      if (!(localalyj.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localalyj.jdField_a_of_type_JavaLangObject).name;
      break;
      label269:
      bool = this.a.a.onListViewItemClick(localalyj.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label294:
      paramView.setContentDescription(localalyj.d.getText().toString() + anvx.a(2131704421));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxn
 * JD-Core Version:    0.7.0.1
 */