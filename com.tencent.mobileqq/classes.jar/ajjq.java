import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

class ajjq
  implements View.OnClickListener
{
  ajjq(ajjo paramajjo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this.jdField_a_of_type_Ajjo.a.b);
    this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.removeTextChangedListener(this.jdField_a_of_type_Ajjo.a.jdField_c_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramView = (SimpleAccount)this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_Int);
    ImageView localImageView;
    if (!LoginView.h(this.jdField_a_of_type_Ajjo.a))
    {
      LoginView.i(this.jdField_a_of_type_Ajjo.a, true);
      this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localImageView = this.jdField_a_of_type_Ajjo.a.jdField_c_of_type_AndroidWidgetImageView;
      if ((!LoginView.d(this.jdField_a_of_type_Ajjo.a)) && (!LoginView.e(this.jdField_a_of_type_Ajjo.a)) && (!LoginView.f(this.jdField_a_of_type_Ajjo.a))) {
        break label368;
      }
    }
    label368:
    for (int i = 2130846451;; i = 2130844232)
    {
      localImageView.setImageResource(i);
      this.jdField_a_of_type_Ajjo.a.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131706738));
      LoginView.a(this.jdField_a_of_type_Ajjo.a, paramView);
      this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.jdField_a_of_type_Ajjo.a.b);
      this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
      this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_Ajjo.a.jdField_c_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
      this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
      this.jdField_a_of_type_Ajjo.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a().setVisibility(8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjq
 * JD-Core Version:    0.7.0.1
 */