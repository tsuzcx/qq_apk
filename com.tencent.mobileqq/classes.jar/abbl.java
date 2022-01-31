import android.os.Message;
import com.tencent.mobileqq.activity.FontSettingActivity;
import mqq.os.MqqHandler;

public class abbl
  extends MqqHandler
{
  public abbl(FontSettingActivity paramFontSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (16711697 == paramMessage.what)
    {
      ajwe.a(this.a, FontSettingActivity.a(this.a), false);
      this.a.c = true;
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abbl
 * JD-Core Version:    0.7.0.1
 */