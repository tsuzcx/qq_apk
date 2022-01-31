import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;

class aidt
  implements View.OnClickListener
{
  aidt(aids paramaids) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365217) {}
    aidz localaidz;
    PhoneContact localPhoneContact;
    do
    {
      do
      {
        return;
        localaidz = (aidz)paramView.getTag();
      } while ((localaidz == null) || (localaidz.jdField_a_of_type_AndroidWidgetCheckBox == null) || (localaidz.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null));
      localPhoneContact = localaidz.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    } while (!localaidz.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled());
    if (localaidz.jdField_a_of_type_JavaLangString.startsWith("+")) {}
    for (boolean bool = this.a.a.a.a(localaidz.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.a(localaidz.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
    {
      localaidz.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (!AppSetting.d) {
        break;
      }
      if (!localaidz.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label255;
      }
      if (!localaidz.jdField_a_of_type_Boolean) {
        break label216;
      }
      paramView.setContentDescription(localaidz.b.getText() + this.a.a.a.getString(2131719236));
      return;
    }
    label216:
    paramView.setContentDescription(localaidz.b.getText().toString() + ajya.a(2131708006));
    return;
    label255:
    if (localaidz.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.a(localaidz.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localaidz.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localaidz.b.getText() + this.a.a.a.getString(i));
        return;
      }
      paramView.setContentDescription(localaidz.b.getText().toString() + ajya.a(2131708003));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidt
 * JD-Core Version:    0.7.0.1
 */