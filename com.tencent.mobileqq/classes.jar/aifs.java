import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aifs
  implements View.OnClickListener
{
  aifs(aifq paramaifq) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.M) {
      bfpx.a(this.a.jdField_a_of_type_AndroidContentContext, null, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifs
 * JD-Core Version:    0.7.0.1
 */