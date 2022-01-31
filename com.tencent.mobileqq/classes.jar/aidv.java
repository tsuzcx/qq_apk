import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;

class aidv
  implements View.OnClickListener
{
  aidv(aidu paramaidu) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365218) {}
    aieb localaieb;
    PhoneContact localPhoneContact;
    do
    {
      do
      {
        return;
        localaieb = (aieb)paramView.getTag();
      } while ((localaieb == null) || (localaieb.jdField_a_of_type_AndroidWidgetCheckBox == null) || (localaieb.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null));
      localPhoneContact = localaieb.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    } while (!localaieb.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled());
    if (localaieb.jdField_a_of_type_JavaLangString.startsWith("+")) {}
    for (boolean bool = this.a.a.a.a(localaieb.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.a(localaieb.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
    {
      localaieb.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (!AppSetting.d) {
        break;
      }
      if (!localaieb.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label255;
      }
      if (!localaieb.jdField_a_of_type_Boolean) {
        break label216;
      }
      paramView.setContentDescription(localaieb.b.getText() + this.a.a.a.getString(2131719225));
      return;
    }
    label216:
    paramView.setContentDescription(localaieb.b.getText().toString() + ajyc.a(2131707995));
    return;
    label255:
    if (localaieb.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.a(localaieb.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localaieb.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localaieb.b.getText() + this.a.a.a.getString(i));
        return;
      }
      paramView.setContentDescription(localaieb.b.getText().toString() + ajyc.a(2131707992));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aidv
 * JD-Core Version:    0.7.0.1
 */