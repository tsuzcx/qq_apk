import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aipl
  implements View.OnClickListener
{
  aipl(aipj paramaipj) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.M) {
      bgpy.a(this.a.jdField_a_of_type_AndroidContentContext, null, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipl
 * JD-Core Version:    0.7.0.1
 */