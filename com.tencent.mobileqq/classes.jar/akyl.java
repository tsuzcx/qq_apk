import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import mqq.os.MqqHandler;

public class akyl
  implements Runnable
{
  public akyl(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    String str = WorldCupShareFragment.b(this.a);
    ThreadManager.getUIHandler().post(new akym(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyl
 * JD-Core Version:    0.7.0.1
 */