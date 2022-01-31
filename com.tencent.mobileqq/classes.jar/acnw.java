import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;

public class acnw
  implements Runnable
{
  public acnw(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void run()
  {
    MPFileVerifyPwdView.b(this.a).setEnabled(true);
    MPFileVerifyPwdView.b(this.a).setTextColor(Color.parseColor("#00a5e0"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnw
 * JD-Core Version:    0.7.0.1
 */