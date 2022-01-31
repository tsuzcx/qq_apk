import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.qphone.base.util.QLog;

public class algb
  implements Runnable
{
  public algb(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    WorldCupShareFragment.a(this.a, WorldCupShareFragment.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("WorldCupShareFragment", 2, String.format("delete video path, %s", new Object[] { WorldCupShareFragment.a(this.a) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     algb
 * JD-Core Version:    0.7.0.1
 */