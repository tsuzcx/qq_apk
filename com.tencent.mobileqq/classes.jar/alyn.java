import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class alyn
  implements View.OnClickListener
{
  alyn(alym paramalym) {}
  
  public void onClick(View paramView)
  {
    alyo localalyo = (alyo)paramView.getTag();
    if (this.a.a.a.contains(localalyo.jdField_a_of_type_ComTencentMobileqqDataGroups))
    {
      this.a.a.a.remove(localalyo.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localalyo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.a.a.a(localalyo.jdField_a_of_type_ComTencentMobileqqDataGroups, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a.add(localalyo.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localalyo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.a.a.a(localalyo.jdField_a_of_type_ComTencentMobileqqDataGroups, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alyn
 * JD-Core Version:    0.7.0.1
 */