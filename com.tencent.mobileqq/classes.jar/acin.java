import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.widget.QQToast;

public class acin
  implements TextWatcher
{
  int jdField_a_of_type_Int = 0;
  String jdField_a_of_type_JavaLangString;
  
  public acin(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.getLineCount();
    if (i > 30)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        break label136;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      if (ExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment) == null) {
        ExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment, QQToast.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.getActivity(), "输入文字不要超过30行", 0));
      }
      if (!ExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).c()) {
        ExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment).a();
      }
      if (i != ExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment))
      {
        ExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment, i);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_Boolean = true;
      }
      return;
      label136:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.getLineCount() <= 30)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_JavaLangString = "";
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.jdField_a_of_type_JavaLangString.equals(paramCharSequence.toString())) && (!ExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment)))
    {
      ExtendFriendProfileEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment);
      return;
    }
    ExtendFriendProfileEditFragment.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acin
 * JD-Core Version:    0.7.0.1
 */