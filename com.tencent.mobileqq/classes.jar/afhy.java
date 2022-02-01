import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;

public class afhy
  extends Handler
{
  public afhy(TroopAssisSettingActivity paramTroopAssisSettingActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.jdField_a_of_type_Amfu.a(this.a.jdField_a_of_type_JavaUtilMap);
    this.a.jdField_a_of_type_Amfu.notifyDataSetChanged();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhy
 * JD-Core Version:    0.7.0.1
 */