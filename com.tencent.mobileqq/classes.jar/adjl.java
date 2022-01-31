import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoWebPlugin;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class adjl
  extends BroadcastReceiver
{
  public adjl(GVideoWebPlugin paramGVideoWebPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    int k;
    int i;
    if (paramContext.equals(HuayangJsPlugin.a("com.tencent.od")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoWebPlugin", 2, "state:" + j);
      }
      paramContext = IVPluginLoader.a;
      k = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      if ((i >= k) || ((j == paramContext[i]) && (GVideoWebPlugin.a(this.a).isShowing()))) {}
      try
      {
        GVideoWebPlugin.a(this.a).dismiss();
        label105:
        i += 1;
        continue;
        return;
      }
      catch (Throwable paramIntent)
      {
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adjl
 * JD-Core Version:    0.7.0.1
 */