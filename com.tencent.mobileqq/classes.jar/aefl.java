import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.mobileqq.medalwall.MedalWallMng;

public class aefl
  implements Runnable
{
  public aefl(MedalGuideView paramMedalGuideView) {}
  
  public void run()
  {
    try
    {
      ((MedalWallMng)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(249)).a(1, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefl
 * JD-Core Version:    0.7.0.1
 */