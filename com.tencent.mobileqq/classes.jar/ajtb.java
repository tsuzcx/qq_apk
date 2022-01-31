import android.content.Context;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface.TBSLogRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.TbsLogClient;
import mqq.os.MqqHandler;

public class ajtb
  extends TbsLogClient
{
  public ajtb(BrowserAppInterface paramBrowserAppInterface, Context paramContext)
  {
    super(paramContext);
  }
  
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2);
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void showLog(String paramString)
  {
    if (this.a.b == -1) {
      this.a.b = 0;
    }
    if (this.a.b == 1) {
      this.a.getHandler(BrowserAppInterface.class).post(new BrowserAppInterface.TBSLogRunnable(this.a, paramString));
    }
  }
  
  public void w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtb
 * JD-Core Version:    0.7.0.1
 */