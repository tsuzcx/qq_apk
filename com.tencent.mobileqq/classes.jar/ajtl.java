import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;

public final class ajtl
  implements Runnable
{
  public void run()
  {
    IndividuationUrlHelper.a(BaseApplicationImpl.sApplication.getRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajtl
 * JD-Core Version:    0.7.0.1
 */