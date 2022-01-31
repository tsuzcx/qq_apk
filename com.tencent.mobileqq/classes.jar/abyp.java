import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.doutu.DoutuManager;

public final class abyp
  implements Runnable
{
  public void run()
  {
    DoutuManager.a(BaseApplicationImpl.getApplication().getBaseContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyp
 * JD-Core Version:    0.7.0.1
 */