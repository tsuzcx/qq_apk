import Wallet.RedPackGrapInfo;
import android.animation.Animator;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetAvailableListListener;
import java.util.List;

public class agmf
  implements IRedPacket.OnGetAvailableListListener
{
  public agmf(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void OnGetAvailableList(List<RedPackGrapInfo> paramList)
  {
    if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
      TroopUnAccalimedRedPacketList.a(this.a).setVisibility(8);
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
        TroopUnAccalimedRedPacketList.a(this.a).setVisibility(8);
      }
      if (TroopUnAccalimedRedPacketList.a(this.a) != null)
      {
        TroopUnAccalimedRedPacketList.a(this.a).setVisibility(0);
        TroopUnAccalimedRedPacketList.a(this.a).setText(ajjy.a(2131650005));
      }
    }
    do
    {
      return;
      if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
        TroopUnAccalimedRedPacketList.a(this.a).setVisibility(0);
      }
      if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
        TroopUnAccalimedRedPacketList.a(this.a).setVisibility(8);
      }
      if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
        TroopUnAccalimedRedPacketList.a(this.a).a(paramList);
      }
    } while (TroopUnAccalimedRedPacketList.a(this.a) == null);
    TroopUnAccalimedRedPacketList.a(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agmf
 * JD-Core Version:    0.7.0.1
 */