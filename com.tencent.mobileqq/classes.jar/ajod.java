import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class ajod
  implements Runnable
{
  public ajod(JumpAction paramJumpAction) {}
  
  public void run()
  {
    if (JumpAction.a(this.a) == null) {}
    String str;
    do
    {
      return;
      str = JumpAction.a(this.a).getCurrentAccountUin();
    } while (TextUtils.isEmpty(str));
    WebProcessManager.c(str, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajod
 * JD-Core Version:    0.7.0.1
 */