import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;

class ahrd
  implements View.OnClickListener
{
  ahrd(ahrc paramahrc) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131299650) {}
    ahrj localahrj;
    PhoneContact localPhoneContact;
    do
    {
      do
      {
        return;
        localahrj = (ahrj)paramView.getTag();
      } while ((localahrj == null) || (localahrj.jdField_a_of_type_AndroidWidgetCheckBox == null) || (localahrj.jdField_a_of_type_ComTencentMobileqqDataPhoneContact == null));
      localPhoneContact = localahrj.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
    } while (!localahrj.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled());
    if (localahrj.jdField_a_of_type_JavaLangString.startsWith("+")) {}
    for (boolean bool = this.a.a.a.a(localahrj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.a(localahrj.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
    {
      localahrj.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if (!AppSetting.c) {
        break;
      }
      if (!localahrj.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break label255;
      }
      if (!localahrj.jdField_a_of_type_Boolean) {
        break label216;
      }
      paramView.setContentDescription(localahrj.b.getText() + this.a.a.a.getString(2131653396));
      return;
    }
    label216:
    paramView.setContentDescription(localahrj.b.getText().toString() + ajjy.a(2131642210));
    return;
    label255:
    if (localahrj.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.a(localahrj.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localahrj.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localahrj.b.getText() + this.a.a.a.getString(i));
        return;
      }
      paramView.setContentDescription(localahrj.b.getText().toString() + ajjy.a(2131642207));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahrd
 * JD-Core Version:    0.7.0.1
 */