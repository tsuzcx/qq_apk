import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.qwallet.TroopUnAccalimedRedPacketList;

public class aisn
  implements View.OnClickListener
{
  public aisn(TroopUnAccalimedRedPacketList paramTroopUnAccalimedRedPacketList) {}
  
  public void onClick(View paramView)
  {
    TroopUnAccalimedRedPacketList.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisn
 * JD-Core Version:    0.7.0.1
 */