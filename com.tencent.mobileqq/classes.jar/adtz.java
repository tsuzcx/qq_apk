import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader;
import com.tencent.mobileqq.intervideo.groupvideo.PluginLoadListener;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class adtz
  extends BroadcastReceiver
{
  public adtz(IVPluginLoader paramIVPluginLoader) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (IVPluginLoader.a(this.a)) {
      IVPluginLoader.a(this.a, j);
    }
    if (paramContext.equals(HuayangJsPlugin.a(IVPluginLoader.a(this.a))))
    {
      paramContext = (PluginLoadListener)IVPluginLoader.a(this.a).get();
      if (paramContext != null) {
        paramContext.a(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = IVPluginLoader.jdField_a_of_type_ArrayOfInt;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (IVPluginLoader.b(this.a)))
          {
            IVPluginLoader.a(this.a).unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
            IVPluginLoader.a(this.a, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((IVPluginLoader.c(this.a)) && (j == 4))
      {
        IVPluginLoader.a(this.a).unregisterReceiver(this.a.jdField_a_of_type_AndroidContentBroadcastReceiver);
        IVPluginLoader.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adtz
 * JD-Core Version:    0.7.0.1
 */