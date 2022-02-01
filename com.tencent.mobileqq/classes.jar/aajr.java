import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class aajr
  implements View.OnClickListener
{
  aajr(aajo paramaajo, TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Aajo.c();
    this.jdField_a_of_type_Aajo.b();
    if (this.jdField_a_of_type_Aajo.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c) {
      this.jdField_a_of_type_Aajo.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((BaseChatPie)this.jdField_a_of_type_Aajo.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b.get()).hideGiftPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajr
 * JD-Core Version:    0.7.0.1
 */