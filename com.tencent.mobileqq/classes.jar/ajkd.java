import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajkd
  implements View.OnClickListener
{
  public ajkd(SimpleSlidingIndicator paramSimpleSlidingIndicator, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.e == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.e >= 0) && (SimpleSlidingIndicator.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator) != null)) {
      SimpleSlidingIndicator.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator).b(this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_Int, true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkd
 * JD-Core Version:    0.7.0.1
 */