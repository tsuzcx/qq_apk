import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.AddAccountActivity;

public class adse
  implements TextWatcher
{
  public adse(AddAccountActivity paramAddAccountActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0) {
      if (this.a.a != null) {
        this.a.a.setVisibility(0);
      }
    }
    while ((this.a.a == null) || (!this.a.a.isShown())) {
      return;
    }
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adse
 * JD-Core Version:    0.7.0.1
 */