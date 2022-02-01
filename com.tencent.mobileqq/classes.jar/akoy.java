import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.qphone.base.util.QLog;

public class akoy
  extends BroadcastReceiver
{
  private akoy(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!"troop_hblist_broadcast_action".equals(paramIntent.getAction())) || (!TroopUnAccalimedRedPacketList.b(this.a))) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          i = paramIntent.getIntExtra("result_code", 0);
          int j = paramIntent.getIntExtra("grap_hb_state", 0);
          paramContext = paramIntent.getStringExtra("listid");
          if (QLog.isColorLevel()) {
            QLog.d(TroopUnAccalimedRedPacketList.b(), 2, "RedPacketRefreshReceiver|resultCode:" + i + "|listId: " + paramContext + "|grabHbState: " + j);
          }
          if (i != -20180322) {
            break;
          }
          if (TroopUnAccalimedRedPacketList.b(this.a) != null) {
            TroopUnAccalimedRedPacketList.b(this.a).setVisibility(8);
          }
        } while (TroopUnAccalimedRedPacketList.a(this.a) == null);
        TroopUnAccalimedRedPacketList.a(this.a).setVisibility(8);
        return;
      } while (i != -20180323);
      if (TroopUnAccalimedRedPacketList.b(this.a) != null) {
        TroopUnAccalimedRedPacketList.b(this.a).setVisibility(0);
      }
      if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
        TroopUnAccalimedRedPacketList.a(this.a).setVisibility(0);
      }
    } while ((TroopUnAccalimedRedPacketList.a(this.a) == null) || (TextUtils.isEmpty(paramContext)));
    TroopUnAccalimedRedPacketList.a(this.a).a(paramContext);
    akrp.a(TroopUnAccalimedRedPacketList.a(this.a), TroopUnAccalimedRedPacketList.a(this.a), paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoy
 * JD-Core Version:    0.7.0.1
 */