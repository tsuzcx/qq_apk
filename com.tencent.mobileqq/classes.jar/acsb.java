import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AssistantSettingActivity;

public class acsb
  extends Handler
{
  public acsb(AssistantSettingActivity paramAssistantSettingActivity) {}
  
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
        this.a.jdField_a_of_type_Bhht.a(this.a.getString(2131690749));
        this.a.jdField_a_of_type_Bhht.d(2130849594);
        this.a.jdField_a_of_type_Bhht.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_Bhht == null) || (!this.a.jdField_a_of_type_Bhht.isShowing()));
    this.a.jdField_a_of_type_Bhht.cancel();
    this.a.jdField_a_of_type_Bhht.a(this.a.getString(2131690751));
    this.a.jdField_a_of_type_Bhht.c(true);
    this.a.jdField_a_of_type_Bhht.a(false);
    this.a.jdField_a_of_type_Bhht.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsb
 * JD-Core Version:    0.7.0.1
 */