import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;

public class ajfa
  implements View.OnClickListener
{
  public ajfa(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_clk", 0, 0, "", "", "", "");
    ajfn.a(false);
    TroopNotifyAndRecommendView.a(this.a).setVisibility(8);
    this.a.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
    if (this.a.jdField_c_of_type_Int != 2)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      }
      this.a.setType(2);
      this.a.b(true);
      ArrayList localArrayList = new ArrayList();
      this.a.jdField_a_of_type_Ajdv.b(localArrayList);
      this.a.jdField_a_of_type_Ajdv.a(ajfn.a());
      this.a.jdField_a_of_type_Ajdv.a = 0;
      this.a.jdField_a_of_type_Ajdv.notifyDataSetChanged();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.a.setType(0);
      this.a.b(false);
      this.a.jdField_a_of_type_Ajdv.a(ajfn.c());
      this.a.jdField_a_of_type_Ajdv.a = bdgn.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((this.a.jdField_c_of_type_JavaUtilList != null) && (this.a.jdField_c_of_type_JavaUtilList.size() > 0)) {
        this.a.jdField_a_of_type_Ajdv.b(this.a.jdField_c_of_type_JavaUtilList);
      }
      this.a.jdField_a_of_type_Ajdv.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfa
 * JD-Core Version:    0.7.0.1
 */