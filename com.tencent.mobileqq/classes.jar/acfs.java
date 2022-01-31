import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;

public class acfs
  extends Handler
{
  public acfs(TroopAssisSettingActivity paramTroopAssisSettingActivity, Looper paramLooper)
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
    this.a.jdField_a_of_type_Aiqd.a(this.a.jdField_a_of_type_JavaUtilMap);
    this.a.jdField_a_of_type_Aiqd.notifyDataSetChanged();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfs
 * JD-Core Version:    0.7.0.1
 */