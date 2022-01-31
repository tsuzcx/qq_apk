import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;

public class achc
{
  public achc(ChatFragment paramChatFragment) {}
  
  public void a()
  {
    if ((ChatFragment.b()) && (this.a.jdField_a_of_type_Boolean))
    {
      bdjd.b("AIO_Start_cost", null);
      SuspendThreadManager.a().c();
      bdjd.a("AIO_onDrawView", "AIO_SysMsgCost");
      ChatFragment.a(this.a);
      if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1) == 1008)
      {
        String str = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
        bdel.a("pubAcc_aio_open", null, str);
        bdel.a("pubAcc_structMsg_display", null, str);
      }
      ChatFragment.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achc
 * JD-Core Version:    0.7.0.1
 */