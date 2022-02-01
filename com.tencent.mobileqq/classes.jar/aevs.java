import Wallet.AcsPullMsgRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import java.util.ArrayList;

public class aevs
  implements aewl
{
  public aevs(ReminderListFragment paramReminderListFragment) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = (AcsPullMsgRsp)paramBundle.getSerializable("rsp");
      if (paramBundle != null)
      {
        paramBundle = paramBundle.msgs;
        if ((paramBundle != null) && (!paramBundle.isEmpty()))
        {
          ArrayList localArrayList = new ArrayList(paramBundle.size());
          ReminderListFragment.a(this.a, paramBundle, localArrayList, true);
          return;
        }
        ReminderListFragment.b(this.a);
        return;
      }
      ReminderListFragment.b(this.a);
      return;
    }
    ReminderListFragment.a(this.a, amtj.a(2131712493));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevs
 * JD-Core Version:    0.7.0.1
 */