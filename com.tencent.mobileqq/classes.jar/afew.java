import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;

public class afew
  extends TroopGiftCallback
{
  public afew(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      NearbyProfileDisplayTribePanel.c(this.a).setText(String.format("获得%d礼物积分", new Object[] { Long.valueOf(paramLong) }));
      return;
    }
    NearbyProfileDisplayTribePanel.c(this.a).setText("我的礼物积分");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afew
 * JD-Core Version:    0.7.0.1
 */