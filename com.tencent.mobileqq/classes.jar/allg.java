import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class allg
  extends bdvu
{
  allg(allf paramallf) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    parambdvv = parambdvv.a();
    if ((parambdvv.containsKey("version")) && (parambdvv.containsKey("json_name")))
    {
      int i = parambdvv.getInt("version", -1);
      parambdvv = parambdvv.getString("json_name");
      if (bdmy.e.d.equals(parambdvv))
      {
        Object localObject = new File(this.a.a.getApplication().getApplicationContext().getFilesDir(), bdmy.e.a);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = bdcs.a((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              bdmy.a(this.a.a.getApplication().getApplicationContext(), parambdvv, i);
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update success!");
              }
              boolean bool1 = true;
              if (((JSONObject)localObject).has("enableX5Report"))
              {
                boolean bool2 = ((JSONObject)localObject).getBoolean("enableX5Report");
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  QLog.i("ClubContentUpdateHandler", 2, "json file got isEnableX5Report: " + bool2);
                  bool1 = bool2;
                }
              }
              parambdvv = this.a.a.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              parambdvv.edit().putBoolean("enableX5Report", bool1).commit();
              parambdvv.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              allf.a(this.a, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception parambdvv)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + parambdvv.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     allg
 * JD-Core Version:    0.7.0.1
 */