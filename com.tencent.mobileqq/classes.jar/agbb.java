import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;

public class agbb
  implements DialogInterface.OnClickListener
{
  public agbb(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new bdlf(this.a.app).a("dc00899").b("Grp_banned").c("Grp_AIO").d("clk_cancel").a(new String[] { this.a.sessionInfo.curFriendUin }).a();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbb
 * JD-Core Version:    0.7.0.1
 */