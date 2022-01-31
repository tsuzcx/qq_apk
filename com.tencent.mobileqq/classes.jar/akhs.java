import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;

public final class akhs
  implements Runnable
{
  public void run()
  {
    IndividuationUrlHelper.a(BaseApplicationImpl.sApplication.getRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhs
 * JD-Core Version:    0.7.0.1
 */