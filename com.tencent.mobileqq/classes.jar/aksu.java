import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

public class aksu
  extends BroadcastReceiver
{
  public aksu(SendHbActivity paramSendHbActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction())) && (SendHbActivity.a(this.a)) && ((this.a.a & 0x40) > 0)) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksu
 * JD-Core Version:    0.7.0.1
 */