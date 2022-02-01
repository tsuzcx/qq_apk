import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class alpj
  extends RecentConfig<QQAppInterface, RecentUserBaseData>
{
  public void recentMenuFlagDispatchRegister()
  {
    this.recentMenuFlagDispatch = new RecentMenuFlagDispatch();
    this.recentMenuFlagDispatch.register(alpk.class);
    this.recentMenuFlagDispatch.register(alpl.class);
    this.recentMenuFlagDispatch.prepare();
  }
  
  public void recentStatusIconRegister()
  {
    this.recentStatusIconDispatch = new RecentStatusIconDispatch();
    this.recentStatusIconDispatch.register(alps.class);
    this.recentStatusIconDispatch.register(alpn.class);
    this.recentStatusIconDispatch.register(alpp.class);
    this.recentStatusIconDispatch.register(alpq.class);
    this.recentStatusIconDispatch.register(alpo.class);
    this.recentStatusIconDispatch.register(alpr.class);
    this.recentStatusIconDispatch.register(alpm.class);
    this.recentStatusIconDispatch.prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alpj
 * JD-Core Version:    0.7.0.1
 */