import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aaux
  extends BroadcastReceiver
{
  private aaux(ARMapManager paramARMapManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("portal_type_key", -1);
    paramIntent.getIntExtra("bc_seq", -1);
    paramContext = paramIntent.getStringExtra("portal_agrs");
    if (QLog.isColorLevel()) {
      QLog.i("ARMapManager", 2, "JSBroadcastReceiver, " + paramIntent.getExtras());
    }
    switch (i)
    {
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (!TextUtils.isEmpty(paramContext))
          {
            paramContext = new JSONObject(paramContext).getString("stid");
            if (!TextUtils.isEmpty(paramContext))
            {
              new String(Base64Util.decode(paramContext, 0));
              paramContext = BaseActivity.sTopActivity;
              return;
            }
          }
        }
        catch (Exception paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("ARMapManager", 2, "", paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaux
 * JD-Core Version:    0.7.0.1
 */