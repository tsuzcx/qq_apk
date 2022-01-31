import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.now.enter.NowEnterManager;
import com.tencent.mobileqq.now.enter.NowEnterManager.WebProcessBindCallback;
import com.tencent.mobileqq.now.enter.NowFestivalEnterFragment;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;

public class agen
  implements NowEnterManager.WebProcessBindCallback
{
  public agen(NowFestivalEnterFragment paramNowFestivalEnterFragment) {}
  
  public void a()
  {
    ((NowEnterManager)NowFestivalEnterFragment.a(this.a).app.getManager(264)).b(NowFestivalEnterFragment.a(this.a));
    long l = System.currentTimeMillis() - NowFestivalEnterFragment.a(this.a);
    if (QLog.isColorLevel())
    {
      QLog.i("NowFestivalEnterFragment", 2, "preStartWebProcess, startTime=" + NowFestivalEnterFragment.a(this.a));
      QLog.i("NowFestivalEnterFragment", 2, "preStartWebProcess onBind, cost=" + l + "ms");
      QLog.i("NowFestivalEnterFragment", 2, "preStartWebProcess, web module is exist=" + WebProcessManager.c());
    }
    if (NowFestivalEnterFragment.a(this.a).isFinishing()) {}
    do
    {
      return;
      new ReportTask(NowFestivalEnterFragment.a(this.a).app).a("dc00899").b("Grp_AIO").c("year_icon").d("web_process_preload_cost").a(new String[] { String.valueOf(l) }).a();
      NowFestivalEnterFragment.c(this.a, true);
    } while ((!NowFestivalEnterFragment.b(this.a)) || (NowFestivalEnterFragment.c(this.a)));
    NowFestivalEnterFragment.a(this.a);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agen
 * JD-Core Version:    0.7.0.1
 */