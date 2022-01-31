import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.intervideo.huayang.HuayangJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class adue
  extends Handler
{
  public adue(HuayangJsPlugin paramHuayangJsPlugin, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    if (i > 90) {
      return;
    }
    HuayangJsPlugin.a(this.a, "STATE_Loading:" + i);
    paramMessage = new JSONObject();
    try
    {
      paramMessage.putOpt("state", Integer.valueOf(4));
      paramMessage.putOpt("totalSize", Integer.valueOf(100));
      paramMessage.putOpt("pro", Integer.valueOf(i));
      this.a.callJs(this.a.a, new String[] { paramMessage.toString() });
      paramMessage = Message.obtain();
      paramMessage.arg1 = (i + 5);
      sendMessageDelayed(paramMessage, 500L);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adue
 * JD-Core Version:    0.7.0.1
 */