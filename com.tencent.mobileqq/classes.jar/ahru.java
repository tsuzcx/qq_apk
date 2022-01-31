import android.text.Editable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.qphone.base.util.QLog;

public class ahru
  implements View.OnFocusChangeListener
{
  public ahru(LoginView paramLoginView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView) {
      if (true == paramBoolean)
      {
        this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setSelection(this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.length());
        if (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing()) {
          this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
        }
        if ((this.a.b != null) && (this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length() > 0)) {
          this.a.b.setVisibility(0);
        }
        this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setSelection(this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().length());
        if (!ahre.a(ahre.a)) {}
      }
    }
    while (paramView != this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText)
    {
      return;
      if ((LoginView.a(this.a).isActive(this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView)) && (QLog.isColorLevel())) {
        QLog.d("InputMethodRelativeLayout", 2, "isActive(mAutoTextAccount)");
      }
      this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHint("");
      return;
      if ((this.a.b != null) && (this.a.b.isShown())) {
        this.a.b.setVisibility(8);
      }
      paramView = new SpannableString(ajyc.a(2131707562));
      paramView.setSpan(new AbsoluteSizeSpan(17, true), 0, paramView.length(), 33);
      this.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHint(paramView);
      return;
    }
    if (true == paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().length());
      this.a.c.setVisibility(0);
      if (LoginView.a(this.a).isActive(this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText)) {
        LoginView.a(this.a).showSoftInput(this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, 2);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHint("");
      return;
    }
    this.a.c.setVisibility(8);
    paramView = new SpannableString(ajyc.a(2131706354));
    paramView.setSpan(new AbsoluteSizeSpan(17, true), 0, paramView.length(), 33);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHint(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahru
 * JD-Core Version:    0.7.0.1
 */