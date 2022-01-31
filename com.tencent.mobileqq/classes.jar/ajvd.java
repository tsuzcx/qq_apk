import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;

class ajvd
  implements View.OnClickListener
{
  ajvd(ajvc paramajvc) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365302) {}
    ajvj localajvj;
    PhoneContact localPhoneContact;
    do
    {
      do
      {
        return;
        localajvj = (ajvj)paramView.getTag();
      } while ((localajvj == null) || (localajvj.jdField_a_of_type_AndroidWidgetCheckBox == null) || (localajvj.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null));
      localPhoneContact = localajvj.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    } while (!localajvj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled());
    if (localajvj.jdField_a_of_type_JavaLangString.startsWith("+")) {}
    for (boolean bool = this.a.a.a.a(localajvj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.a(localajvj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
    {
      localajvj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (!AppSetting.c) {
        break;
      }
      if (!localajvj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label255;
      }
      if (!localajvj.jdField_a_of_type_Boolean) {
        break label216;
      }
      paramView.setContentDescription(localajvj.b.getText() + this.a.a.a.getString(2131719717));
      return;
    }
    label216:
    paramView.setContentDescription(localajvj.b.getText().toString() + alpo.a(2131708378));
    return;
    label255:
    if (localajvj.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.a(localajvj.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localajvj.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localajvj.b.getText() + this.a.a.a.getString(i));
        return;
      }
      paramView.setContentDescription(localajvj.b.getText().toString() + alpo.a(2131708375));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvd
 * JD-Core Version:    0.7.0.1
 */