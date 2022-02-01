import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxData;
import com.tencent.gdtad.views.form.textbox.GdtFormItemTextBoxView;

public class actb
  implements TextWatcher
{
  public actb(GdtFormItemTextBoxView paramGdtFormItemTextBoxView) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.a.a() == null) || (!this.a.a().isValid()) || (paramEditable == null))
    {
      acqy.d("GdtFormItemTextBoxView", "afterTextChanged error");
      return;
    }
    acqy.b("GdtFormItemTextBoxView", "afterTextChanged " + paramEditable.toString());
    this.a.a().content.text = paramEditable.toString();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actb
 * JD-Core Version:    0.7.0.1
 */