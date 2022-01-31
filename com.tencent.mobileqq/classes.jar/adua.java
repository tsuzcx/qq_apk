import android.content.Context;
import android.content.Intent;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.Monitor;

public class adua
  implements adul
{
  public adua(HuayangDowanloadHelper paramHuayangDowanloadHelper) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    Intent localIntent = new Intent(HuayangJsPlugin.a(HuayangDowanloadHelper.a(this.a)));
    localIntent.putExtra("key_state", paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      HuayangDowanloadHelper.a(this.a).sendBroadcast(localIntent);
      return;
      localIntent.putExtra("key_totalSize", ((Long)paramVarArgs[0]).longValue());
      continue;
      paramInt = ((Integer)paramVarArgs[0]).intValue();
      localIntent.putExtra("key_totalSize", ((Long)paramVarArgs[1]).longValue());
      localIntent.putExtra("key_progress", paramInt);
      continue;
      localIntent.putExtra("key_installedplugin", (InstalledPlugin)paramVarArgs[0]);
      if (HuayangJsPlugin.a(HuayangDowanloadHelper.a(this.a)))
      {
        Monitor.a("2691709");
      }
      else if (HuayangJsPlugin.b(HuayangDowanloadHelper.a(this.a)))
      {
        Monitor.a("2597857");
        continue;
        localIntent.putExtra("key_error_msg", (String)paramVarArgs[0]);
        if (HuayangJsPlugin.a(HuayangDowanloadHelper.a(this.a)))
        {
          Monitor.a("2691710");
        }
        else if (HuayangJsPlugin.b(HuayangDowanloadHelper.a(this.a)))
        {
          Monitor.a("2597858");
          continue;
          if ("download".equals(HuayangDowanloadHelper.b(this.a)))
          {
            InstalledPlugin localInstalledPlugin = (InstalledPlugin)paramVarArgs[0];
            boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
            HuayangDowanloadHelper.a(this.a, localInstalledPlugin, bool);
          }
          if (HuayangJsPlugin.a(HuayangDowanloadHelper.a(this.a)))
          {
            Monitor.a("2691703");
          }
          else if (HuayangJsPlugin.b(HuayangDowanloadHelper.a(this.a)))
          {
            Monitor.a("2597720");
            continue;
            localIntent.putExtra("key_error_msg", (String)paramVarArgs[0]);
            if (HuayangJsPlugin.a(HuayangDowanloadHelper.a(this.a))) {
              Monitor.a("2691704");
            } else if (HuayangJsPlugin.b(HuayangDowanloadHelper.a(this.a))) {
              Monitor.a("2597721");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adua
 * JD-Core Version:    0.7.0.1
 */