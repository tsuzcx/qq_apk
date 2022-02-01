import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class alar
  implements View.OnClickListener
{
  alar(alaq paramalaq) {}
  
  public void onClick(View paramView)
  {
    alas localalas = (alas)paramView.getTag();
    if (this.a.a.a.contains(localalas.jdField_a_of_type_ComTencentMobileqqDataGroups))
    {
      this.a.a.a.remove(localalas.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localalas.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.a.a.a(localalas.jdField_a_of_type_ComTencentMobileqqDataGroups, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a.a.add(localalas.jdField_a_of_type_ComTencentMobileqqDataGroups);
      localalas.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      this.a.a.a(localalas.jdField_a_of_type_ComTencentMobileqqDataGroups, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alar
 * JD-Core Version:    0.7.0.1
 */