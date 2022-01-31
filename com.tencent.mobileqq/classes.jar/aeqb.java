import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aeqb
  extends BroadcastReceiver
{
  aeqb(aeqa paramaeqa) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("callback");
    int i = paramIntent.getIntExtra("bless_type", 0);
    int j = paramIntent.getIntExtra("bless_num", 0);
    paramContext = new JSONObject();
    try
    {
      paramContext.put("bless_type", i);
      paramContext.put("bless_num", j);
      if (QLog.isColorLevel()) {
        QLog.i("BlessJsApiPlugin", 2, String.format("call blessWebView, blesstype:%d, member:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      }
      if (i != 2) {}
    }
    catch (JSONException localJSONException)
    {
      try
      {
        str1 = paramIntent.getStringExtra("bless_ptv_url");
        String str2 = paramIntent.getStringExtra("bless_ptv_uuid");
        String str3 = paramIntent.getStringExtra("bless_ptv_md5");
        paramIntent = paramIntent.getStringExtra("bless_ptv_nick");
        paramContext.put("bless_ptv_url", str1);
        paramContext.put("bless_ptv_uuid", str2);
        paramContext.put("bless_ptv_md5", str3);
        paramContext.put("bless_ptv_nick", paramIntent);
        this.a.callJs(aeqa.a(), new String[] { paramContext.toString() });
        return;
        localJSONException = localJSONException;
        localJSONException.printStackTrace();
      }
      catch (JSONException paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
      if (i == 3)
      {
        this.a.callJs(aeqa.a(), new String[] { paramContext.toString() });
        return;
      }
      this.a.callJs(str1, new String[] { paramContext.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aeqb
 * JD-Core Version:    0.7.0.1
 */