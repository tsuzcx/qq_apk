import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.qphone.base.util.QLog;

public class ahdu
  implements Runnable
{
  public ahdu(QzoneContactsFeedManager paramQzoneContactsFeedManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneContactsFeedManager", 2, "updateQzoneFeeds:" + QzoneContactsFeedManager.a(this.a).getCurrentAccountUin());
    }
    Object localObject = QzoneContactsFeedManager.a(this.a);
    long l2 = ((SharedPreferences)localObject).getLong("last_click_time", 0L);
    long l1 = System.currentTimeMillis();
    l2 = l1 - l2;
    if (l2 < QzoneContactsFeedManager.a()) {
      return;
    }
    long l3 = this.a.a();
    if ((l3 <= 0L) || (l2 >= QzoneContactsFeedManager.b())) {
      this.a.b();
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("last_click_time", l1);
      if (Build.VERSION.SDK_INT >= 9) {
        break;
      }
      ((SharedPreferences.Editor)localObject).commit();
      return;
      this.a.a(l3, this.a.a());
    }
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdu
 * JD-Core Version:    0.7.0.1
 */