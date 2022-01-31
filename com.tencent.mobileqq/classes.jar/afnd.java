import com.tencent.mobileqq.now.enter.NowFestivalEnterFragment;
import com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager;

public class afnd
  implements Runnable
{
  public afnd(NowFestivalEnterFragment paramNowFestivalEnterFragment) {}
  
  public void run()
  {
    NowAnswerPreloadManager.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afnd
 * JD-Core Version:    0.7.0.1
 */