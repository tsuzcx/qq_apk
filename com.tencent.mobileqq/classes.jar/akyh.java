import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.qphone.base.util.QLog;

public class akyh
  implements Runnable
{
  public akyh(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void run()
  {
    QLog.i("WorldCupShareFragment", 2, "WL_DEBUG mResDownloadTimeoutRunnable.run");
    WorldCupMgr.a(WorldCupShareFragment.a(this.a)).b(WorldCupShareFragment.a(this.a));
    WorldCupShareFragment.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akyh
 * JD-Core Version:    0.7.0.1
 */