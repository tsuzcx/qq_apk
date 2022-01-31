import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import mqq.os.MqqHandler;

public class algg
  implements Runnable
{
  public algg(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    String str = WorldCupShareFragment.b(this.a);
    ThreadManager.getUIHandler().post(new algh(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algg
 * JD-Core Version:    0.7.0.1
 */