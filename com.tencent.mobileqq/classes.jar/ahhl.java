import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.SpringHbTranslucentBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ahhl
  extends BroadcastReceiver
{
  public ahhl(SpringHbTranslucentBrowserActivity paramSpringHbTranslucentBrowserActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    String str1 = "";
    for (;;)
    {
      try
      {
        String str2 = paramIntent.getAction();
        if ("ACTION_LOADING_ANIM_PLAY_FINISH".equals(str2))
        {
          QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onReceive out anim play end");
          SpringHbTranslucentBrowserActivity.c(this.a);
          i = 0;
          paramContext = str1;
          QLog.i("springHb_SpringHbTranslucentBrowserActivity", 2, "onReceive: action:" + str2 + ",businessId：" + i + ",viewId:" + j + ",extstr:" + paramContext);
          return;
        }
        if ("action_notify_view_update".equals(str2))
        {
          int k = paramIntent.getIntExtra("businessId", 0);
          int m = paramIntent.getIntExtra("viewId", 0);
          paramContext = str1;
          j = m;
          i = k;
          if (k != 23) {
            continue;
          }
          paramContext = str1;
          j = m;
          i = k;
          if (m != 1) {
            continue;
          }
          paramIntent = paramIntent.getStringExtra("extstr");
          paramContext = paramIntent;
          j = m;
          i = k;
          if (bbjw.a(paramIntent)) {
            continue;
          }
          paramContext = paramIntent;
          j = m;
          i = k;
          if (new JSONObject(paramIntent).optInt("loadfinished") != 1) {
            continue;
          }
          this.a.c();
          paramContext = paramIntent;
          j = m;
          i = k;
          continue;
        }
        int i = 0;
      }
      catch (Exception paramContext)
      {
        QLog.e("springHb_SpringHbTranslucentBrowserActivity", 1, "onReceive error", paramContext);
        return;
      }
      paramContext = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhl
 * JD-Core Version:    0.7.0.1
 */