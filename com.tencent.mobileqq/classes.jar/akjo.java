import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

class akjo
  implements TextWatcher
{
  akjo(akjn paramakjn) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (this.a.b) {
      this.a.jdField_a_of_type_Akjx.a(paramEditable);
    }
    this.a.b = true;
    if (paramEditable.length() == 0)
    {
      this.a.findViewById(2131368209).setVisibility(8);
      return;
    }
    this.a.findViewById(2131368209).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjo
 * JD-Core Version:    0.7.0.1
 */