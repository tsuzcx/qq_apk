import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.qphone.base.util.QLog;

class ajyu
  implements TextWatcher
{
  private String jdField_a_of_type_JavaLangString = "";
  
  ajyu(ajyr paramajyr) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString().trim();
    if (TextUtils.isEmpty(paramEditable))
    {
      this.jdField_a_of_type_JavaLangString = "";
      ajyr.a(this.jdField_a_of_type_Ajyr).a();
      ajyr.a(this.jdField_a_of_type_Ajyr).setVisibility(8);
      ajyr.a(this.jdField_a_of_type_Ajyr).setVisibility(8);
      ajyr.a(this.jdField_a_of_type_Ajyr).setVisibility(8);
    }
    while (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramEditable)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageSearchDialog", 2, "afterTextChanged, mLastKeyword = " + this.jdField_a_of_type_JavaLangString + ",lastKeyWord:" + paramEditable);
    }
    this.jdField_a_of_type_JavaLangString = paramEditable;
    ajyr.a(this.jdField_a_of_type_Ajyr).setVisibility(0);
    this.jdField_a_of_type_Ajyr.a();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyu
 * JD-Core Version:    0.7.0.1
 */