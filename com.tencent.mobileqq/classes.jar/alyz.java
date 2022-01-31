import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class alyz
  extends MqqHandler
{
  public alyz(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void removeCallbacksAndMessages(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("ThreadManager", 1, "global fileHandler cannot excute removeCallbacksAndMessages");
      return;
    }
    super.removeCallbacksAndMessages(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alyz
 * JD-Core Version:    0.7.0.1
 */