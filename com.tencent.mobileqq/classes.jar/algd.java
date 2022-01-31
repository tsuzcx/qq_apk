import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import mqq.os.MqqHandler;

public class algd
  implements Runnable
{
  public algd(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    String str = WorldCupShareFragment.b(this.a);
    ThreadManager.getUIHandler().post(new alge(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algd
 * JD-Core Version:    0.7.0.1
 */