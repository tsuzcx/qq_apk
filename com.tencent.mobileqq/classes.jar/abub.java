import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class abub
  implements TextWatcher
{
  public abub(SubLoginActivity paramSubLoginActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() > 0) {
      if (SubLoginActivity.a(this.a) != null) {
        SubLoginActivity.a(this.a).setVisibility(0);
      }
    }
    while ((SubLoginActivity.a(this.a) == null) || (!SubLoginActivity.a(this.a).isShown())) {
      return;
    }
    SubLoginActivity.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abub
 * JD-Core Version:    0.7.0.1
 */