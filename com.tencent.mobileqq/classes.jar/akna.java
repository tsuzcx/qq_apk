import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class akna
  extends RecentConfig<QQAppInterface, RecentUserBaseData>
{
  public void recentMenuFlagDispatchRegister()
  {
    this.recentMenuFlagDispatch = new RecentMenuFlagDispatch();
    this.recentMenuFlagDispatch.register(aknb.class);
    this.recentMenuFlagDispatch.register(aknc.class);
    this.recentMenuFlagDispatch.prepare();
  }
  
  public void recentStatusIconRegister()
  {
    this.recentStatusIconDispatch = new RecentStatusIconDispatch();
    this.recentStatusIconDispatch.register(aknj.class);
    this.recentStatusIconDispatch.register(akne.class);
    this.recentStatusIconDispatch.register(akng.class);
    this.recentStatusIconDispatch.register(aknh.class);
    this.recentStatusIconDispatch.register(aknf.class);
    this.recentStatusIconDispatch.register(akni.class);
    this.recentStatusIconDispatch.register(aknd.class);
    this.recentStatusIconDispatch.prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akna
 * JD-Core Version:    0.7.0.1
 */