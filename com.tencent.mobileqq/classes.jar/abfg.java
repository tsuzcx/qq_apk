import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class abfg
  implements nmg
{
  abfg(abff paramabff) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "-->offline:checkOfflineUp. result: " + paramString + ", code: " + paramInt);
    }
    if (paramInt == 9)
    {
      try
      {
        localObject = new JSONObject(paramString);
        paramString = (String)localObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject;
          localJSONException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("OfflinePluginQQ", 2, "-->offline:checkUp loaded err:" + paramString);
          }
          paramString = null;
        }
      }
      localObject = this.a.a.obtainMessage();
      ((Message)localObject).arg1 = 3;
      ((Message)localObject).obj = paramString;
      this.a.a.sendMessage((Message)localObject);
    }
    while (paramInt != -1) {
      return;
    }
    paramString = this.a.a.obtainMessage();
    paramString.arg1 = 2;
    this.a.a.sendMessage(paramString);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfg
 * JD-Core Version:    0.7.0.1
 */