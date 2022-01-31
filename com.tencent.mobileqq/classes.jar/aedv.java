import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.od.LoadingUI;
import com.tencent.mobileqq.intervideo.od.ODLoadingActivity;

public class aedv
  extends BroadcastReceiver
{
  public aedv(ODLoadingActivity paramODLoadingActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals(HuayangJsPlugin.a("com.tencent.huayang"))) {
      switch (paramIntent.getIntExtra("key_state", -1))
      {
      }
    }
    while (!HuayangJsPlugin.b(this.a.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.c).equals(paramContext))
    {
      return;
      int i = paramIntent.getIntExtra("key_progress", 0);
      this.a.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a(i);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("正在努力加载...", true);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("下载失败，请重试!");
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI.a("加载失败，请重试!");
      Monitor.a("2694153");
      return;
      Monitor.a("2694152");
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedv
 * JD-Core Version:    0.7.0.1
 */