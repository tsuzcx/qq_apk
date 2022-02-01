import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;

public class aalo
  extends BroadcastReceiver
{
  private aalo(SubscribePersonalDetailFragment paramSubscribePersonalDetailFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_reload_get_main_page")))
    {
      SubscribePersonalDetailFragment.b(this.a, false);
      aaak.a().a(new UserStateUpdateEvent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalo
 * JD-Core Version:    0.7.0.1
 */