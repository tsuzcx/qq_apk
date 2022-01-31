import android.widget.LinearLayout;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;

public class adox
  implements Runnable
{
  public adox(LightReplyMenuManager paramLightReplyMenuManager) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adox
 * JD-Core Version:    0.7.0.1
 */