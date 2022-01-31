import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup;
import java.util.List;

class ajwn
  implements View.OnClickListener
{
  ajwn(ajwm paramajwm) {}
  
  public void onClick(View paramView)
  {
    paramView = (ajwo)paramView.getTag();
    if (this.a.a.a.contains(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups))
    {
      this.a.a.a.remove(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.a.a.a(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups, false);
      return;
    }
    this.a.a.a.add(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups);
    paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    this.a.a.a(paramView.jdField_a_of_type_ComTencentMobileqqDataGroups, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwn
 * JD-Core Version:    0.7.0.1
 */