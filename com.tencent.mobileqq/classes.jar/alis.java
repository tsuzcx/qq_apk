import com.tencent.mobileqq.activity.recent.config.RecentConfig;
import com.tencent.mobileqq.activity.recent.config.menu.RecentMenuFlagDispatch;
import com.tencent.mobileqq.activity.recent.config.statusIcon.RecentStatusIconDispatch;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;

public class alis
  extends RecentConfig<QQAppInterface, RecentUserBaseData>
{
  public void recentMenuFlagDispatchRegister()
  {
    this.recentMenuFlagDispatch = new RecentMenuFlagDispatch();
    this.recentMenuFlagDispatch.register(alit.class);
    this.recentMenuFlagDispatch.register(aliu.class);
    this.recentMenuFlagDispatch.prepare();
  }
  
  public void recentStatusIconRegister()
  {
    this.recentStatusIconDispatch = new RecentStatusIconDispatch();
    this.recentStatusIconDispatch.register(aljb.class);
    this.recentStatusIconDispatch.register(aliw.class);
    this.recentStatusIconDispatch.register(aliy.class);
    this.recentStatusIconDispatch.register(aliz.class);
    this.recentStatusIconDispatch.register(alix.class);
    this.recentStatusIconDispatch.register(alja.class);
    this.recentStatusIconDispatch.register(aliv.class);
    this.recentStatusIconDispatch.prepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alis
 * JD-Core Version:    0.7.0.1
 */