import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.leba.LebaFeedsAdapter;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayController;
import com.tencent.qphone.base.util.QLog;

public class adyo
  extends BroadcastReceiver
{
  public adyo(LebaFeedsAdapter paramLebaFeedsAdapter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "Broadcast onReceive " + paramContext);
    }
    if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
      LebaFeedsAdapter.b(this.a, false);
    }
    do
    {
      do
      {
        return;
        if (!"tencent.av.v2q.StartVideoChat".equals(paramContext)) {
          break;
        }
      } while (LebaFeedsAdapter.a(this.a) == null);
      LebaFeedsAdapter.a(this.a).d(true);
      return;
    } while ((!"tencent.av.v2q.StopVideoChat".equals(paramContext)) || (LebaFeedsAdapter.a(this.a) == null));
    LebaFeedsAdapter.a(this.a).d(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyo
 * JD-Core Version:    0.7.0.1
 */