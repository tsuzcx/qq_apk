import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alfr
  implements View.OnClickListener
{
  public alfr(ChooseItemView paramChooseItemView, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a.a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a();
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfr
 * JD-Core Version:    0.7.0.1
 */