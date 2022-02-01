import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alxx
  implements View.OnClickListener
{
  alxx(alxw paramalxw) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365712) {}
    alyb localalyb;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localalyb = (alyb)paramView.getTag();
      if ((localalyb != null) && (localalyb.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localalyb.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        PhoneContact localPhoneContact = localalyb.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (localalyb.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
        {
          if (localalyb.jdField_a_of_type_JavaLangString.startsWith("+")) {}
          for (boolean bool = this.a.a.a.onListViewItemClick(localalyb.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.onListViewItemClick(localalyb.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
          {
            localalyb.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
            if (!AppSetting.c) {
              break;
            }
            if (!localalyb.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label266;
            }
            if (!localalyb.jdField_a_of_type_Boolean) {
              break label225;
            }
            paramView.setContentDescription(localalyb.b.getText() + this.a.a.a.getString(2131718480));
            break;
          }
          label225:
          paramView.setContentDescription(localalyb.b.getText().toString() + anvx.a(2131707455));
        }
      }
    }
    label266:
    if (localalyb.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.getCheckPhoneNumberResId(localalyb.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localalyb.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localalyb.b.getText() + this.a.a.a.getString(i));
        break;
      }
      paramView.setContentDescription(localalyb.b.getText().toString() + anvx.a(2131707452));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxx
 * JD-Core Version:    0.7.0.1
 */