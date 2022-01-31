import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import mqq.os.MqqHandler;

public class akyo
  implements Runnable
{
  public akyo(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    String str = WorldCupShareFragment.b(this.a);
    ThreadManager.getUIHandler().post(new akyp(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyo
 * JD-Core Version:    0.7.0.1
 */