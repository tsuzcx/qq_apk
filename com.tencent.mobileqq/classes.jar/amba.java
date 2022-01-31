import cooperation.qzone.CloseGuard.Reporter;
import cooperation.qzone.util.QZLog;

public final class amba
  implements CloseGuard.Reporter
{
  public void a(String paramString, Throwable paramThrowable)
  {
    QZLog.e("QZLog", paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amba
 * JD-Core Version:    0.7.0.1
 */