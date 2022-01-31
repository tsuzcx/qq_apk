import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;

public class ahsa
  implements DialogInterface.OnClickListener
{
  public ahsa(LoginView paramLoginView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.a.getText().toString();
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      this.a.b(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahsa
 * JD-Core Version:    0.7.0.1
 */