import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.PhoneContactTabView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class alab
  implements View.OnClickListener
{
  alab(alaa paramalaa) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365619) {}
    alaf localalaf;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localalaf = (alaf)paramView.getTag();
      if ((localalaf != null) && (localalaf.jdField_a_of_type_AndroidWidgetCheckBox != null) && (localalaf.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null))
      {
        PhoneContact localPhoneContact = localalaf.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (localalaf.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())
        {
          if (localalaf.jdField_a_of_type_JavaLangString.startsWith("+")) {}
          for (boolean bool = this.a.a.a.onListViewItemClick(localalaf.jdField_a_of_type_JavaLangString, localPhoneContact.name, 4, "-1", localPhoneContact.mobileNo);; bool = this.a.a.a.onListViewItemClick(localalaf.jdField_a_of_type_JavaLangString, localPhoneContact.name, 0, "-1", localPhoneContact.mobileNo))
          {
            localalaf.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
            if (!AppSetting.c) {
              break;
            }
            if (!localalaf.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
              break label266;
            }
            if (!localalaf.jdField_a_of_type_Boolean) {
              break label225;
            }
            paramView.setContentDescription(localalaf.b.getText() + this.a.a.a.getString(2131718095));
            break;
          }
          label225:
          paramView.setContentDescription(localalaf.b.getText().toString() + amtj.a(2131707108));
        }
      }
    }
    label266:
    if (localalaf.jdField_a_of_type_Boolean) {}
    for (int i = this.a.a.a.getCheckPhoneNumberResId(localalaf.jdField_a_of_type_JavaLangString);; i = 0)
    {
      if ((localalaf.jdField_a_of_type_Boolean) && (i != 0))
      {
        paramView.setContentDescription(localalaf.b.getText() + this.a.a.a.getString(i));
        break;
      }
      paramView.setContentDescription(localalaf.b.getText().toString() + amtj.a(2131707105));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alab
 * JD-Core Version:    0.7.0.1
 */