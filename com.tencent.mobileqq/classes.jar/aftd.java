import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class aftd
  implements View.OnClickListener
{
  public aftd(TroopInfoActivity paramTroopInfoActivity, XListView paramXListView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopInfoActivity.b = null;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftd
 * JD-Core Version:    0.7.0.1
 */