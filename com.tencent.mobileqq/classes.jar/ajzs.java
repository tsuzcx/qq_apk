import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;

class ajzs
  implements View.OnClickListener
{
  ajzs(ajzr paramajzr) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365304) {}
    ajzy localajzy;
    PhoneContact localPhoneContact;
    do
    {
      do
      {
        return;
        localajzy = (ajzy)paramView.getTag();
      } while ((localajzy == null) || (localajzy.jdField_a_of_type_AndroidWidgetCheckBox == null) || (localajzy.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null));
      localPhoneContact = localajzy.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    } while (!localajzy.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled());
    if (localajzy.jdField_a_of_type_JavaLangString.startsWith("+")) {}
    for (boolean bool = this.a.a.a.a(localajzy.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.a(localajzy.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
    {
      localajzy.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (!AppSetting.c) {
        break;
      }
      if (!localajzy.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label255;
      }
      if (!localajzy.jdField_a_of_type_Boolean) {
        break label216;
      }
      paramView.setContentDescription(localajzy.b.getText() + this.a.a.a.getString(2131719729));
      return;
    }
    label216:
    paramView.setContentDescription(localajzy.b.getText().toString() + alud.a(2131708390));
    return;
    label255:
    if (localajzy.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.a(localajzy.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localajzy.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localajzy.b.getText() + this.a.a.a.getString(i));
        return;
      }
      paramView.setContentDescription(localajzy.b.getText().toString() + alud.a(2131708387));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzs
 * JD-Core Version:    0.7.0.1
 */