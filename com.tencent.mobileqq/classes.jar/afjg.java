import android.widget.TextView;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;

public class afjg
  extends TroopGiftCallback
{
  public afjg(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      NearbyProfileFragment.a(this.a).setText(String.format("获得%d礼物积分", new Object[] { Long.valueOf(paramLong) }));
      return;
    }
    NearbyProfileFragment.a(this.a).setText("我的礼物积分");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afjg
 * JD-Core Version:    0.7.0.1
 */