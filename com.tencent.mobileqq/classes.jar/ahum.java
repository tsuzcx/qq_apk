import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

public class ahum
  extends ConfigObserver
{
  public ahum(StatusManager paramStatusManager) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "onUpdateStatusActions " + paramBoolean + ", " + paramInt);
    }
    StatusManager.a(this.a, 0L);
    if (paramBoolean)
    {
      if (paramInt == 100)
      {
        StatusManager.b(this.a, System.currentTimeMillis());
        StatusManager.a(this.a).edit().putLong("k_update_time", StatusManager.a(this.a)).commit();
      }
      this.a.a(true);
    }
    if (StatusManager.a(this.a) != null)
    {
      Iterator localIterator = StatusManager.a(this.a).iterator();
      if (localIterator.hasNext())
      {
        IActionListener localIActionListener = (IActionListener)localIterator.next();
        if (paramBoolean) {}
        for (int i = 300;; i = 301)
        {
          localIActionListener.a(paramInt, i);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahum
 * JD-Core Version:    0.7.0.1
 */