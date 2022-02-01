import android.text.Editable;
import android.text.TextWatcher;

class ahst
  implements TextWatcher
{
  ahst(ahss paramahss) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.jdField_a_of_type_Ahsj.a().f())
    {
      paramEditable = paramEditable.toString();
      this.a.jdField_a_of_type_Ahsj.a().a(paramEditable);
      if (this.a.jdField_a_of_type_Ahsg != null) {
        this.a.jdField_a_of_type_Ahsg.a(paramEditable);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahst
 * JD-Core Version:    0.7.0.1
 */