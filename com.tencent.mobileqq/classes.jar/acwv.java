import android.os.Message;
import com.tencent.mobileqq.activity.FontSettingActivity;
import mqq.os.MqqHandler;

public class acwv
  extends MqqHandler
{
  public acwv(FontSettingActivity paramFontSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (16711697 == paramMessage.what)
    {
      alsf.a(this.a, FontSettingActivity.a(this.a), false);
      this.a.c = true;
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwv
 * JD-Core Version:    0.7.0.1
 */