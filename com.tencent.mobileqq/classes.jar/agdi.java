import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;

public class agdi
  implements Runnable
{
  public agdi(ProfileHeaderView paramProfileHeaderView) {}
  
  public void run()
  {
    ((MedalWallMng)this.a.a.getManager(249)).a(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agdi
 * JD-Core Version:    0.7.0.1
 */