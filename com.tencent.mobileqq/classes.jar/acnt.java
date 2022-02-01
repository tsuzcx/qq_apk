import com.tencent.ad.tangram.log.AdLogAdapter;
import com.tencent.qphone.base.util.QLog;

public final class acnt
  implements AdLogAdapter
{
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2, paramThrowable);
    }
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnt
 * JD-Core Version:    0.7.0.1
 */