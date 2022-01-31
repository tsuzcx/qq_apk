import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import mqq.app.AppRuntime;

public class abkw
  implements Runnable
{
  public abkw(BubbleDiyFetcher paramBubbleDiyFetcher) {}
  
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.a.b((QQAppInterface)localAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abkw
 * JD-Core Version:    0.7.0.1
 */