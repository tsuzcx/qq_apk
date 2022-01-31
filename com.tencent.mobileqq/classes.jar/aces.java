import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AssistantSettingActivity;

public class aces
  extends Handler
{
  public aces(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (!this.a.isFinishing())
      {
        this.a.jdField_a_of_type_Bety.a(this.a.getString(2131690862));
        this.a.jdField_a_of_type_Bety.d(2130849126);
        this.a.jdField_a_of_type_Bety.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_Bety == null) || (!this.a.jdField_a_of_type_Bety.isShowing()));
    this.a.jdField_a_of_type_Bety.cancel();
    this.a.jdField_a_of_type_Bety.a(this.a.getString(2131690864));
    this.a.jdField_a_of_type_Bety.c(true);
    this.a.jdField_a_of_type_Bety.a(false);
    this.a.jdField_a_of_type_Bety.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aces
 * JD-Core Version:    0.7.0.1
 */