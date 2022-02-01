import android.widget.Toast;
import com.tencent.mobileqq.activity.QuickLoginActivity;
import mqq.observer.AccountObserver;

public class afjd
  extends AccountObserver
{
  public afjd(QuickLoginActivity paramQuickLoginActivity) {}
  
  public void onLoginFailed(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2)
  {
    Toast.makeText(this.a.getApplicationContext(), "login failure! check you qq and password!", 0).show();
  }
  
  public void onLoginSuccess(String paramString1, String paramString2)
  {
    Toast.makeText(this.a.getApplicationContext(), "login suc", 0).show();
  }
  
  public void onLoginTimeout(String paramString)
  {
    Toast.makeText(this.a.getApplicationContext(), "login outtime", 0).show();
  }
  
  public void onUserCancel(String paramString)
  {
    Toast.makeText(this.a.getApplicationContext(), "login cancel", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjd
 * JD-Core Version:    0.7.0.1
 */