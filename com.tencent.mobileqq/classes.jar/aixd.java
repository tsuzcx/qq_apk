import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;
import com.tencent.mobileqq.app.QQAppInterface;

public class aixd
  implements View.OnClickListener
{
  public aixd(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onClick(View paramView)
  {
    TroopUnAccalimedRedPacketList.a(this.a, true);
    if (TroopUnAccalimedRedPacketList.a(this.a) != null) {
      ajeu.a(TroopUnAccalimedRedPacketList.a(this.a), TroopUnAccalimedRedPacketList.a(this.a).getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.back", "", "");
    }
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixd
 * JD-Core Version:    0.7.0.1
 */