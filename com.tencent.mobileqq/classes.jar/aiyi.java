import android.text.Editable;
import android.text.TextWatcher;

class aiyi
  implements TextWatcher
{
  aiyi(aiyh paramaiyh) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.jdField_a_of_type_Aixy.a().f())
    {
      paramEditable = paramEditable.toString();
      this.a.jdField_a_of_type_Aixy.a().a(paramEditable);
      if (this.a.jdField_a_of_type_Aixv != null) {
        this.a.jdField_a_of_type_Aixv.a(paramEditable);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyi
 * JD-Core Version:    0.7.0.1
 */