import Wallet.AcsPullMsgRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import java.util.ArrayList;

public class achr
  implements acih
{
  public achr(ReminderListFragment paramReminderListFragment) {}
  
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
    ReminderListFragment.a(this.a, ajjy.a(2131647590));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     achr
 * JD-Core Version:    0.7.0.1
 */