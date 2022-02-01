import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class alds
  extends RecentConfig<QQAppInterface, RecentUserBaseData>
{
  public void recentMenuFlagDispatchRegister()
  {
    this.recentMenuFlagDispatch = new RecentMenuFlagDispatch();
    this.recentMenuFlagDispatch.register(aldt.class);
    this.recentMenuFlagDispatch.register(aldu.class);
    this.recentMenuFlagDispatch.prepare();
  }
  
  public void recentStatusIconRegister()
  {
    this.recentStatusIconDispatch = new RecentStatusIconDispatch();
    this.recentStatusIconDispatch.register(alea.class);
    this.recentStatusIconDispatch.register(aldw.class);
    this.recentStatusIconDispatch.register(aldy.class);
    this.recentStatusIconDispatch.register(aldx.class);
    this.recentStatusIconDispatch.register(aldz.class);
    this.recentStatusIconDispatch.register(aldv.class);
    this.recentStatusIconDispatch.prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alds
 * JD-Core Version:    0.7.0.1
 */