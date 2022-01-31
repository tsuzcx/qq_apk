import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;

public class abwa
  implements TextWatcher
{
  public abwa(ClearEllipsisEditText paramClearEllipsisEditText) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((ClearEllipsisEditText.a(this.a)) && (!ClearEllipsisEditText.b(this.a))) {
      ClearEllipsisEditText.a(this.a, paramCharSequence.toString());
    }
    ClearEllipsisEditText.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abwa
 * JD-Core Version:    0.7.0.1
 */