import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.TimeoutObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.qphone.base.util.QLog;

public class acks
  implements EmojiIPCAlarmer.TimeoutObserver
{
  public acks(WebIPCOperator paramWebIPCOperator) {}
  
  public void a(int paramInt)
  {
    acku localacku = this.a.a(paramInt);
    if (localacku != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localacku.a.putBundle("response", localBundle);
      this.a.a(new ackt(this, localacku));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acks
 * JD-Core Version:    0.7.0.1
 */