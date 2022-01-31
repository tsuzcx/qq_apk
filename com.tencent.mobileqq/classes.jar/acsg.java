import Wallet.AcsPullMsgRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import java.util.ArrayList;

public class acsg
  implements acsw
{
  public acsg(ReminderListFragment paramReminderListFragment) {}
  
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
    ReminderListFragment.a(this.a, ajyc.a(2131713378));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acsg
 * JD-Core Version:    0.7.0.1
 */