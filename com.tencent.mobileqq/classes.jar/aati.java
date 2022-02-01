import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class aati
  implements View.OnClickListener
{
  public aati(TroopGiftPanel paramTroopGiftPanel, aasl paramaasl, aasq paramaasq, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onClick(View paramView)
  {
    String str1 = this.jdField_a_of_type_Aasl.b;
    String str2 = this.jdField_a_of_type_Aasq.jdField_a_of_type_JavaLangString;
    float f = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getProgress();
    Iterator localIterator = this.jdField_a_of_type_Aasl.a.iterator();
    while (localIterator.hasNext())
    {
      aask localaask = (aask)localIterator.next();
      if ((f >= localaask.jdField_a_of_type_Float) && (f < localaask.b))
      {
        str1 = localaask.d;
        str2 = localaask.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(str1);
      bcst.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_top_click", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", "", str2);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aati
 * JD-Core Version:    0.7.0.1
 */