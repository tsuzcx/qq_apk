import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahaf
  implements View.OnClickListener
{
  public ahaf(ArkAppView paramArkAppView, ArkViewModel paramArkViewModel) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentArkArkViewModel != null) {
      this.jdField_a_of_type_ComTencentArkArkViewModel.reinitArkContainer();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahaf
 * JD-Core Version:    0.7.0.1
 */