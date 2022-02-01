import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;

public class ajes
  implements View.OnClickListener
{
  public ajes(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_clk", 0, 0, "", "", "", "");
    if (this.a.c != 3)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      TroopNotifyAndRecommendView.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      this.a.setType(3);
      this.a.c(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      TroopNotifyAndRecommendView.a(this.a).setVisibility(8);
      this.a.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
      this.a.setType(0);
      this.a.jdField_a_of_type_Ajdv.a(ajfn.c());
      this.a.jdField_a_of_type_Ajdv.a = bdgn.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_Ajdv.notifyDataSetChanged();
      this.a.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajes
 * JD-Core Version:    0.7.0.1
 */