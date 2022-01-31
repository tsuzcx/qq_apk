import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.profile.VipProfileCardBaseActivity;

public class agbl
  extends Handler
{
  public agbl(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.a(paramMessage)) {}
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
      return;
    case 6: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)))
      {
        Toast.makeText(this.a.a.getApplicationContext(), (String)paramMessage.obj, 0).show();
        return;
      }
      Toast.makeText(this.a.a.getApplicationContext(), 2131436727, 0).show();
      return;
    case 7: 
      Toast.makeText(this.a.a.getApplicationContext(), 2131436729, 0).show();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbl
 * JD-Core Version:    0.7.0.1
 */