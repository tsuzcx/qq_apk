import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaxf
  implements View.OnClickListener
{
  public aaxf(TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    TroopGiftPanel.a(this.a).setSelected(false);
    this.a.a.a(-1);
    TroopGiftPanel.b(this.a).setSelected(true);
    ((TextView)TroopGiftPanel.b(this.a).findViewById(2131379875)).setTextColor(Color.parseColor("#ffff5b84"));
    TroopGiftPanel.b(this.a).findViewById(2131381067).setVisibility(0);
    ((TextView)TroopGiftPanel.a(this.a).findViewById(2131379874)).setTextColor(Color.parseColor("#ff878b99"));
    TroopGiftPanel.a(this.a).findViewById(2131381073).setVisibility(8);
    this.a.onTabSelected(this.a.h, TroopGiftPanel.c);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaxf
 * JD-Core Version:    0.7.0.1
 */