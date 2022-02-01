import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aikb
  implements View.OnClickListener
{
  aikb(aijm paramaijm) {}
  
  public void onClick(View paramView)
  {
    if (!azhq.a().a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView)) {
      bhxv.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "aio");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikb
 * JD-Core Version:    0.7.0.1
 */