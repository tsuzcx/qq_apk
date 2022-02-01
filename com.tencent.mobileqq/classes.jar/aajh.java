import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aajh
  implements View.OnClickListener
{
  public aajh(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    TroopGiftPanel.b(this.a).setSelected(false);
    this.a.a.a(-1);
    TroopGiftPanel.a(this.a).setSelected(true);
    ((TextView)TroopGiftPanel.b(this.a).findViewById(2131379959)).setTextColor(Color.parseColor("#ff878b99"));
    TroopGiftPanel.b(this.a).findViewById(2131381144).setVisibility(8);
    ((TextView)TroopGiftPanel.a(this.a).findViewById(2131379958)).setTextColor(Color.parseColor("#ffff5b84"));
    TroopGiftPanel.a(this.a).findViewById(2131381150).setVisibility(0);
    this.a.onTabSelected(this.a.h, TroopGiftPanel.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajh
 * JD-Core Version:    0.7.0.1
 */