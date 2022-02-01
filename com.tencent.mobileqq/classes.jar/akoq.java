import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class akoq
  implements PopupWindow.OnDismissListener
{
  public akoq(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onDismiss()
  {
    RedPacketManager.getInstance().onActiveAccount();
    if ((TroopUnAccalimedRedPacketList.a(this.a) != null) && (akot.a(TroopUnAccalimedRedPacketList.a(this.a)) != null))
    {
      akot.a(TroopUnAccalimedRedPacketList.a(this.a)).clear();
      TroopUnAccalimedRedPacketList.a(this.a).notifyDataSetChanged();
    }
    if ((!TroopUnAccalimedRedPacketList.a(this.a)) && (TroopUnAccalimedRedPacketList.a(this.a) != null)) {
      akww.a(TroopUnAccalimedRedPacketList.a(this.a), TroopUnAccalimedRedPacketList.a(this.a).getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.keyback", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akoq
 * JD-Core Version:    0.7.0.1
 */