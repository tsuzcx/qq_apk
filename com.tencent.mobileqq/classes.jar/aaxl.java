import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class aaxl
  implements View.OnClickListener
{
  public aaxl(TroopGiftPanel paramTroopGiftPanel, aawo paramaawo, aawt paramaawt, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onClick(View paramView)
  {
    String str1 = this.jdField_a_of_type_Aawo.b;
    String str2 = this.jdField_a_of_type_Aawt.jdField_a_of_type_JavaLangString;
    float f = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getProgress();
    Iterator localIterator = this.jdField_a_of_type_Aawo.a.iterator();
    while (localIterator.hasNext())
    {
      aawn localaawn = (aawn)localIterator.next();
      if ((f >= localaawn.jdField_a_of_type_Float) && (f < localaawn.b))
      {
        str1 = localaawn.d;
        str2 = localaawn.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(str1);
      bdll.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_top_click", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", "", str2);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaxl
 * JD-Core Version:    0.7.0.1
 */