import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alsi
  implements View.OnClickListener
{
  alsi(alsh paramalsh) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365544) {}
    also localalso;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localalso = (also)paramView.getTag();
      if ((localalso != null) && (localalso.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localalso.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        PhoneContact localPhoneContact = localalso.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (localalso.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
        {
          if (localalso.jdField_a_of_type_JavaLangString.startsWith("+")) {}
          for (boolean bool = this.a.a.a.a(localalso.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.a(localalso.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
          {
            localalso.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
            if (!AppSetting.c) {
              break;
            }
            if (!localalso.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label266;
            }
            if (!localalso.jdField_a_of_type_Boolean) {
              break label225;
            }
            paramView.setContentDescription(localalso.b.getText() + this.a.a.a.getString(2131717726));
            break;
          }
          label225:
          paramView.setContentDescription(localalso.b.getText().toString() + anni.a(2131706767));
        }
      }
    }
    label266:
    if (localalso.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.a(localalso.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localalso.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localalso.b.getText() + this.a.a.a.getString(i));
        break;
      }
      paramView.setContentDescription(localalso.b.getText().toString() + anni.a(2131706764));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsi
 * JD-Core Version:    0.7.0.1
 */