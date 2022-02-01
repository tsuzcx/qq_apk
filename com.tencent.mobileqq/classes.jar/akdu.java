import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class akdu
  implements TextWatcher
{
  akdu(akdt paramakdt) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (paramEditable.length() == 0)
    {
      this.a.jdField_b_of_type_JavaLangString = "";
      this.a.findViewById(2131368378).setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.a.jdField_a_of_type_Ajwt.a();
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    while (this.a.jdField_b_of_type_JavaLangString.equals(paramEditable)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "afterTextChanged, lastChangedKeyword = " + this.a.jdField_b_of_type_JavaLangString + ",lastKeyWord:" + paramEditable);
    }
    this.a.jdField_b_of_type_JavaLangString = paramEditable;
    this.a.findViewById(2131368378).setVisibility(0);
    this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.a.a();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdu
 * JD-Core Version:    0.7.0.1
 */