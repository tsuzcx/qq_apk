import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.qsec.QSecFramework.IGoingUpHandler;

public class alhy
  implements QSecFramework.IGoingUpHandler
{
  public alhy(QSecFramework paramQSecFramework) {}
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if (paramInt1 != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSecFramework", 2, String.format("Native msg, cookie: %08X, delay: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      if (paramInt2 != 0) {
        QSecFramework.a(this.a).sendMessageDelayed(QSecFramework.a(this.a).obtainMessage(1, paramInt1, 0), paramInt2 * 1000);
      }
    }
    else
    {
      return 0;
    }
    QSecFramework.a(this.a).sendMessage(QSecFramework.a(this.a).obtainMessage(1, paramInt1, 0));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhy
 * JD-Core Version:    0.7.0.1
 */