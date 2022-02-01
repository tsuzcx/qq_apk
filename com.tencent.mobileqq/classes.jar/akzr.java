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

public class akzr
  implements View.OnClickListener
{
  public akzr(FriendTabView paramFriendTabView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("FriendTabView", 2, "----->onBuddyListClick");
    alan localalan = (alan)paramView.getTag();
    String str;
    boolean bool;
    if ((localalan != null) && (localalan.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localalan.jdField_a_of_type_JavaLangObject != null))
    {
      str = "";
      if (!(localalan.jdField_a_of_type_JavaLangObject instanceof Friends)) {
        break label243;
      }
      str = ((Friends)localalan.jdField_a_of_type_JavaLangObject).getFriendNickWithAlias();
      if (localalan.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
      {
        if (!localalan.jdField_a_of_type_JavaLangString.startsWith("+")) {
          break label269;
        }
        bool = this.a.a.onListViewItemClick(localalan.jdField_a_of_type_JavaLangString, str, 4, "-1", "");
        label110:
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendTabView", 2, "----->onBuddyListClick = " + bool);
        }
        localalan.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        if (AppSetting.c)
        {
          if (!localalan.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            break label294;
          }
          paramView.setContentDescription(localalan.d.getText().toString() + amtj.a(2131704069));
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
      if (!(localalan.jdField_a_of_type_JavaLangObject instanceof PhoneContact)) {
        break;
      }
      str = ((PhoneContact)localalan.jdField_a_of_type_JavaLangObject).name;
      break;
      label269:
      bool = this.a.a.onListViewItemClick(localalan.jdField_a_of_type_JavaLangString, str, 0, "-1", "");
      break label110;
      label294:
      paramView.setContentDescription(localalan.d.getText().toString() + amtj.a(2131704070));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzr
 * JD-Core Version:    0.7.0.1
 */