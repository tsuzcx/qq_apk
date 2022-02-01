import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;

public class ajqj
  implements View.OnClickListener
{
  public ajqj(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_clk", 0, 0, "", "", "", "");
    ajqw.a(false);
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
      this.a.jdField_a_of_type_Ajpe.b(localArrayList);
      this.a.jdField_a_of_type_Ajpe.a(ajqw.a());
      this.a.jdField_a_of_type_Ajpe.a = 0;
      this.a.jdField_a_of_type_Ajpe.notifyDataSetChanged();
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
      this.a.jdField_a_of_type_Ajpe.a(ajqw.c());
      this.a.jdField_a_of_type_Ajpe.a = bdzi.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((this.a.jdField_c_of_type_JavaUtilList != null) && (this.a.jdField_c_of_type_JavaUtilList.size() > 0)) {
        this.a.jdField_a_of_type_Ajpe.b(this.a.jdField_c_of_type_JavaUtilList);
      }
      this.a.jdField_a_of_type_Ajpe.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqj
 * JD-Core Version:    0.7.0.1
 */