import android.os.Handler;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

public final class aekp
  implements IHttpCommunicatorListener
{
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    ReportLog.a().sendEmptyMessage(10000001);
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    ReportLog.a = false;
    ReportLog.a().sendEmptyMessage(10000001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekp
 * JD-Core Version:    0.7.0.1
 */