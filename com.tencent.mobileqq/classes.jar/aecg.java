import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.GeneralSettingActivity;

public class aecg
  extends Handler
{
  public aecg(GeneralSettingActivity paramGeneralSettingActivity) {}
  
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
        this.a.jdField_a_of_type_Bisl.a(this.a.getString(2131690826));
        this.a.jdField_a_of_type_Bisl.d(2130849687);
        this.a.jdField_a_of_type_Bisl.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_Bisl == null) || (!this.a.jdField_a_of_type_Bisl.isShowing()));
    this.a.jdField_a_of_type_Bisl.cancel();
    this.a.jdField_a_of_type_Bisl.a(this.a.getString(2131690828));
    this.a.jdField_a_of_type_Bisl.c(true);
    this.a.jdField_a_of_type_Bisl.a(false);
    this.a.jdField_a_of_type_Bisl.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecg
 * JD-Core Version:    0.7.0.1
 */