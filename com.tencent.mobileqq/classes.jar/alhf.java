import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.ICloudAVEngine.ResultBundle;
import java.util.Date;

final class alhf
  extends alhj
{
  alhf(alhe paramalhe)
  {
    super(null);
  }
  
  public boolean a(String paramString, ICloudAVEngine.ResultBundle paramResultBundle)
  {
    if (this.a.size() >= this.a.maxSize())
    {
      alhe.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, "Cache not load completely.");
      }
      return false;
    }
    if (paramResultBundle.a > new Date().getTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Add cache entry, key: %s, %s", new Object[] { paramString, paramResultBundle.toString() }));
      }
      this.a.put(paramString, paramResultBundle);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("QSec.AVEngine", 2, String.format("Discard expired entry, key: %s, %s", new Object[] { paramString, paramResultBundle.toString() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alhf
 * JD-Core Version:    0.7.0.1
 */