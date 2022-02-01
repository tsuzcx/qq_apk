import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;

public class afkb
  implements TextWatcher
{
  public afkb(RegisterPersonalInfoActivity paramRegisterPersonalInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramEditable.toString())) {
        RegisterPersonalInfoActivity.a(this.a).setEnabled(false);
      }
      while (RegisterPersonalInfoActivity.a(this.a) != null)
      {
        RegisterPersonalInfoActivity.a(this.a).b(RegisterPersonalInfoActivity.a(this.a).isEnabled());
        return;
        RegisterPersonalInfoActivity.a(this.a).setEnabled(true);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkb
 * JD-Core Version:    0.7.0.1
 */