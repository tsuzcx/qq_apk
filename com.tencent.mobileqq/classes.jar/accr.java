import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.TimeoutObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.qphone.base.util.QLog;

public class accr
  implements EmojiIPCAlarmer.TimeoutObserver
{
  public accr(WebIPCOperator paramWebIPCOperator) {}
  
  public void a(int paramInt)
  {
    acct localacct = this.a.a(paramInt);
    if (localacct != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localacct.a.putBundle("response", localBundle);
      this.a.a(new accs(this, localacct));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     accr
 * JD-Core Version:    0.7.0.1
 */