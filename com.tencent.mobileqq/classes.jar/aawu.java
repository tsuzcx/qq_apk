import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aawu
  implements AdapterView.OnItemClickListener
{
  public aawu(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.onTabSelected(0, paramInt);
    paramView.setSelected(true);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawu
 * JD-Core Version:    0.7.0.1
 */