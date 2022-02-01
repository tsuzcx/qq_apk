import android.text.Editable;
import android.text.TextWatcher;

class ains
  implements TextWatcher
{
  ains(ainr paramainr) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.jdField_a_of_type_Aini.a().f())
    {
      paramEditable = paramEditable.toString();
      this.a.jdField_a_of_type_Aini.a().a(paramEditable);
      if (this.a.jdField_a_of_type_Ainf != null) {
        this.a.jdField_a_of_type_Ainf.a(paramEditable);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ains
 * JD-Core Version:    0.7.0.1
 */