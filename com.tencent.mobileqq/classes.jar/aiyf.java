import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.TribePostTitlePrefixPanelController;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.PrefixSelectedListener;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;

public class aiyf
  implements TribeTitlePrefixPanelView.PrefixSelectedListener
{
  private aiyf(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void a(TribeTitlePrefixPanelView.TitlePrefixItem paramTitlePrefixItem)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem = paramTitlePrefixItem;
    this.a.jdField_a_of_type_ComTencentMobileqqTribeTribePostTitlePrefixPanelController.b();
    this.a.e(true);
    ReportController.b(null, "dc00899", "Grp_tribe", "", "pub_page", "choose_prefix", 0, 0, this.a.r, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyf
 * JD-Core Version:    0.7.0.1
 */