import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aian
  implements View.OnClickListener
{
  aian(ahzy paramahzy) {}
  
  public void onClick(View paramView)
  {
    if (!ayox.a().a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView)) {
      bgxr.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "aio");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aian
 * JD-Core Version:    0.7.0.1
 */