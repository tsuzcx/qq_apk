import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajeh
  implements View.OnClickListener
{
  public ajeh(SearchBaseActivity paramSearchBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    if (this.a.h != 1) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeh
 * JD-Core Version:    0.7.0.1
 */