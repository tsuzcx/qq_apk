import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;

public final class akcf
  implements Runnable
{
  public void run()
  {
    FileUtils.a(BaseApplicationImpl.sApplication, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akcf
 * JD-Core Version:    0.7.0.1
 */