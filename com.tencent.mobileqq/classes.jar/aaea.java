import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class aaea
  implements aadw
{
  aadx jdField_a_of_type_Aadx;
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
          aaeb localaaeb = new aaeb(this);
          BaseApplicationImpl.getContext().registerReceiver(localaaeb, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = localaaeb;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(aadx paramaadx)
  {
    this.jdField_a_of_type_Aadx = paramaadx;
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    a();
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("type", paramInt);
    localBundle.putString("appid", paramString2);
    aabo.a(2, localBundle, null);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a();
    Bundle localBundle = new Bundle();
    localBundle.putString("key", paramString1);
    localBundle.putInt("type", paramInt);
    localBundle.putString("appid", paramString2);
    localBundle.putString("api", paramString3);
    aabo.a(3, localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaea
 * JD-Core Version:    0.7.0.1
 */