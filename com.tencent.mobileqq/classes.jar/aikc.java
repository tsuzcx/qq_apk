import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.6.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aikc
  implements View.OnClickListener
{
  aikc(aijm paramaijm) {}
  
  public void onClick(View paramView)
  {
    if (aijm.a(this.a).getVisibility() == 0) {
      ThreadManager.post(new FriendChatPie.6.1(this), 5, null, false);
    }
    agej.n = true;
    bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    agju.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikc
 * JD-Core Version:    0.7.0.1
 */