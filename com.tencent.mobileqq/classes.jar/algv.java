import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class algv
  implements View.OnClickListener
{
  algv(algt paramalgt, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Algt.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Algt.a.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_Algt.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this.jdField_a_of_type_Algt.a.b);
    this.jdField_a_of_type_Algt.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Algt.a.jdField_c_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_Algt.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_Algt.a.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Algt.a.jdField_a_of_type_Int);
    ImageView localImageView;
    if (!LoginView.h(this.jdField_a_of_type_Algt.a))
    {
      LoginView.i(this.jdField_a_of_type_Algt.a, true);
      this.jdField_a_of_type_Algt.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localImageView = this.jdField_a_of_type_Algt.a.jdField_c_of_type_AndroidWidgetImageView;
      if ((!LoginView.d(this.jdField_a_of_type_Algt.a)) && (!LoginView.e(this.jdField_a_of_type_Algt.a)) && (!LoginView.f(this.jdField_a_of_type_Algt.a))) {
        break label377;
      }
    }
    label377:
    for (int i = 2130846965;; i = 2130844697)
    {
      localImageView.setImageResource(i);
      this.jdField_a_of_type_Algt.a.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131705141));
      LoginView.a(this.jdField_a_of_type_Algt.a, localSimpleAccount);
      this.jdField_a_of_type_Algt.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Algt.a.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_Algt.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.jdField_a_of_type_Algt.a.b);
      this.jdField_a_of_type_Algt.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_Algt.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Algt.a.jdField_c_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_Algt.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
      this.jdField_a_of_type_Algt.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_Algt.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a().setVisibility(8);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algv
 * JD-Core Version:    0.7.0.1
 */