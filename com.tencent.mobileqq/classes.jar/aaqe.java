import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;

public class aaqe
{
  public aaqe(ChatFragment paramChatFragment) {}
  
  public void a()
  {
    if ((ChatFragment.b()) && (this.a.jdField_a_of_type_Boolean))
    {
      bbkj.b("AIO_Start_cost", null);
      SuspendThreadManager.a().c();
      bbkj.a("AIO_onDrawView", "AIO_SysMsgCost");
      ChatFragment.a(this.a);
      if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1) == 1008)
      {
        String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
        bbfq.a("pubAcc_aio_open", null, str);
        bbfq.a("pubAcc_structMsg_display", null, str);
      }
      ChatFragment.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaqe
 * JD-Core Version:    0.7.0.1
 */