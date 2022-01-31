import android.text.TextUtils;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan;
import com.tencent.mobileqq.statistics.ReportController;

public class aeev
  implements Runnable
{
  public aeev(CUOpenCardGuideMng.CUOpenCardClickableSpan paramCUOpenCardClickableSpan) {}
  
  public void run()
  {
    String str;
    if (this.a.a == 1) {
      str = "0X8008124";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        ReportController.b(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      return;
      if (this.a.a == 2) {
        str = "0X8008126";
      } else if ((this.a.a == 3) || (this.a.a == 4)) {
        str = "0X800813E";
      } else {
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeev
 * JD-Core Version:    0.7.0.1
 */