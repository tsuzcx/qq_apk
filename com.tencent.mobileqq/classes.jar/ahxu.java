import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class ahxu
  implements TextWatcher
{
  public ahxu(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetImageButton;
    if (str.equals("")) {}
    for (int i = 8;; i = 0)
    {
      paramEditable.setVisibility(i);
      if (this.a.f != ClassificationSearchActivity.c) {
        break;
      }
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(this.a.getResources().getString(2131690620));
      if (AppSetting.c) {
        this.a.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.a.jdField_a_of_type_AndroidWidgetButton.getText().toString());
      }
      if ((str.equals("")) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment != null))
      {
        if ((this.a.f != ClassificationSearchActivity.jdField_a_of_type_Int) && (this.a.f != ClassificationSearchActivity.d)) {
          break label219;
        }
        ClassificationSearchActivity.a(this.a);
      }
      return;
    }
    Button localButton = this.a.jdField_a_of_type_AndroidWidgetButton;
    if (!str.equals("")) {}
    for (paramEditable = this.a.getResources().getString(2131718003);; paramEditable = this.a.getResources().getString(2131690620))
    {
      localButton.setText(paramEditable);
      break;
    }
    label219:
    this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxu
 * JD-Core Version:    0.7.0.1
 */