import android.app.Activity;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.activity.weather.SessionClearFragment.1.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class alfu
  implements anno
{
  public alfu(SessionClearFragment paramSessionClearFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SessionClearFragment", 2, "onLoadStart");
      this.a.a();
    }
  }
  
  public void a(List<anni> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onLoadFinish");
    }
    SessionClearFragment.a(this.a).runOnUiThread(new SessionClearFragment.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfu
 * JD-Core Version:    0.7.0.1
 */