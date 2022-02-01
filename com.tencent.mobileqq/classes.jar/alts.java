import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class alts
  implements View.OnClickListener
{
  alts(altr paramaltr) {}
  
  public void onClick(View paramView)
  {
    altt localaltt = (altt)paramView.getTag();
    if (this.a.a.a.contains(localaltt.jdField_a_of_type_ComTencentMobileqqDataGroups))
    {
      this.a.a.a.remove(localaltt.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localaltt.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.a.a.a(localaltt.jdField_a_of_type_ComTencentMobileqqDataGroups, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a.add(localaltt.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localaltt.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.a.a.a(localaltt.jdField_a_of_type_ComTencentMobileqqDataGroups, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alts
 * JD-Core Version:    0.7.0.1
 */