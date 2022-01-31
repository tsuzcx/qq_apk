import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.ProcessInfoUtil;
import com.tencent.qphone.base.util.QLog;

public final class ahrj
  implements Runnable
{
  public ahrj(String paramString) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = ProcessInfoUtil.a();
    int i;
    if (localSharedPreferences != null)
    {
      i = ProcessInfoUtil.a(BaseApplicationImpl.getContext(), this.a);
      if (i != -1) {
        break label27;
      }
    }
    label27:
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      localSharedPreferences.edit().putInt("pid" + this.a, i);
      localSharedPreferences.edit().putLong("start_time" + this.a, l).apply();
    } while (!QLog.isColorLevel());
    QLog.d("ProcessUtils", 2, "recordProcessStart - " + this.a + ":" + i + "|" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahrj
 * JD-Core Version:    0.7.0.1
 */