import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class abzm
  implements abzi
{
  abzj jdField_a_of_type_Abzj;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      try
      {
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.mobileqq.Doraemon.monitor.update");
          localIntentFilter.addAction("com.tencent.mobileqq.Doraemon.monitor.update_batch");
          abzn localabzn = new abzn(this);
          BaseApplicationImpl.getContext().registerReceiver(localabzn, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = localabzn;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(abzj paramabzj)
  {
    this.jdField_a_of_type_Abzj = paramabzj;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    a();
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("type", paramInt);
    localBundle.putString("appid", paramString2);
    abxa.a(2, localBundle, null);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a();
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("type", paramInt);
    localBundle.putString("appid", paramString2);
    localBundle.putString("api", paramString3);
    abxa.a(3, localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzm
 * JD-Core Version:    0.7.0.1
 */