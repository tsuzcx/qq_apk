import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aijv
  implements View.OnClickListener
{
  aijv(aijm paramaijm) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.M) {
      aean.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijv
 * JD-Core Version:    0.7.0.1
 */