import android.widget.LinearLayout;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;

public class aekn
  implements Runnable
{
  public aekn(LightReplyMenuManager paramLightReplyMenuManager) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.setVisibility(8);
      LightReplyMenuManager.a(this.a, null);
      this.a.a = null;
      this.a.b = false;
      this.a.c = false;
      LightReplyMenuManager.a(this.a, false);
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekn
 * JD-Core Version:    0.7.0.1
 */