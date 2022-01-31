import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.7.1;
import com.tencent.mobileqq.app.ThreadManager;

public class aglt
  implements View.OnClickListener
{
  aglt(agld paramagld) {}
  
  public void onClick(View paramView)
  {
    if (agld.a(this.a).getVisibility() == 0) {
      ThreadManager.post(new FriendChatPie.7.1(this), 5, null, false);
    }
    aekt.n = true;
    azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    aepf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, null, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglt
 * JD-Core Version:    0.7.0.1
 */