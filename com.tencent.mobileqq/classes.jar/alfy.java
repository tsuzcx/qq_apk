import android.os.Handler;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.ar.config.WorldCupMgr.DownloadListener;
import com.tencent.mobileqq.worldcup.WorldCupShareFragment;
import com.tencent.qphone.base.util.QLog;

public class alfy
  implements WorldCupMgr.DownloadListener
{
  public alfy(WorldCupShareFragment paramWorldCupShareFragment) {}
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      QLog.i("WorldCupShareFragment", 1, "WL_DEBUG onDownloadProgress failed. error code = " + paramInt2);
      WorldCupMgr.a(WorldCupShareFragment.a(this.a)).b(this);
      WorldCupShareFragment.a(this.a).removeCallbacks(this.a.a);
      WorldCupShareFragment.b(this.a, true);
    }
    do
    {
      do
      {
        return;
        if ((paramInt2 < 0) || (paramInt2 > 99)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WorldCupShareFragment", 2, "WL_DEBUG onDownloadProgress download... progress = " + paramInt2);
      return;
    } while (paramInt2 != 100);
    QLog.i("WorldCupShareFragment", 1, "onDownloadProgress download successfully.");
    WorldCupMgr.a(WorldCupShareFragment.a(this.a)).b(this);
    WorldCupShareFragment.a(this.a).removeCallbacks(this.a.a);
    WorldCupShareFragment.b(this.a, true);
    WorldCupShareFragment.b(this.a, true, this.a.getView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfy
 * JD-Core Version:    0.7.0.1
 */