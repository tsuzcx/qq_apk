import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class alsn
  implements View.OnClickListener
{
  alsn(alsl paramalsl, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Alsl.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Alsl.a.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_Alsl.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.removeTextChangedListener(this.jdField_a_of_type_Alsl.a.b);
    this.jdField_a_of_type_Alsl.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Alsl.a.jdField_c_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_Alsl.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_Alsl.a.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Alsl.a.jdField_a_of_type_Int);
    ImageView localImageView;
    if (!LoginView.i(this.jdField_a_of_type_Alsl.a))
    {
      LoginView.i(this.jdField_a_of_type_Alsl.a, true);
      this.jdField_a_of_type_Alsl.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localImageView = this.jdField_a_of_type_Alsl.a.jdField_c_of_type_AndroidWidgetImageView;
      if ((!LoginView.d(this.jdField_a_of_type_Alsl.a)) && (!LoginView.e(this.jdField_a_of_type_Alsl.a)) && (!LoginView.f(this.jdField_a_of_type_Alsl.a)) && (!LoginView.g(this.jdField_a_of_type_Alsl.a))) {
        break label390;
      }
    }
    label390:
    for (int i = 2130846982;; i = 2130844711)
    {
      localImageView.setImageResource(i);
      this.jdField_a_of_type_Alsl.a.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anzj.a(2131705248));
      LoginView.a(this.jdField_a_of_type_Alsl.a, localSimpleAccount);
      this.jdField_a_of_type_Alsl.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Alsl.a.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_Alsl.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_a_of_type_Alsl.a.b);
      this.jdField_a_of_type_Alsl.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_Alsl.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Alsl.a.jdField_c_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_Alsl.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.clearFocus();
      this.jdField_a_of_type_Alsl.a.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_Alsl.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a().setVisibility(8);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alsn
 * JD-Core Version:    0.7.0.1
 */