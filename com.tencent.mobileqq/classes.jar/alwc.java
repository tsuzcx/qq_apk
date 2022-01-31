import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqconnect.wtlogin.Login;

public class alwc
  implements TextView.OnEditorActionListener
{
  public alwc(Login paramLogin) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      this.a.b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alwc
 * JD-Core Version:    0.7.0.1
 */