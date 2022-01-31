import android.os.Bundle;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.TimeoutObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.qphone.base.util.QLog;

public class abvp
  implements EmojiIPCAlarmer.TimeoutObserver
{
  public abvp(WebIPCOperator paramWebIPCOperator) {}
  
  public void a(int paramInt)
  {
    abvr localabvr = this.a.a(paramInt);
    if (localabvr != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.EmoWebIPCOperator", 2, "on req timeout seq: " + paramInt);
      }
      Bundle localBundle = new Bundle();
      this.a.a(localBundle, 1001);
      localabvr.a.putBundle("response", localBundle);
      this.a.a(new abvq(this, localabvr));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abvp
 * JD-Core Version:    0.7.0.1
 */