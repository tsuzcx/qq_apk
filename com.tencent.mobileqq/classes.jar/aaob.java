import android.text.TextUtils;
import com.tencent.gdtad.statistics.GdtCgiReportRunnable;
import com.tencent.mobileqq.app.ThreadManager;

public class aaob
{
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.post(new GdtCgiReportRunnable(paramString), 2, null, false);
    aanp.b("GDT_CGI_REPORT", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaob
 * JD-Core Version:    0.7.0.1
 */