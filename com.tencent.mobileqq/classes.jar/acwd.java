import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;

public class acwd
  implements Runnable
{
  public acwd(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void run()
  {
    MPFileVerifyPwdView.b(this.a).setEnabled(true);
    MPFileVerifyPwdView.b(this.a).setTextColor(Color.parseColor("#00a5e0"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwd
 * JD-Core Version:    0.7.0.1
 */