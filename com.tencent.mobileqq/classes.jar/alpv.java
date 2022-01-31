import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class alpv
  extends bead
{
  alpv(alpu paramalpu) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    parambeae = parambeae.a();
    if ((parambeae.containsKey("version")) && (parambeae.containsKey("json_name")))
    {
      int i = parambeae.getInt("version", -1);
      parambeae = parambeae.getString("json_name");
      if (bdrh.e.d.equals(parambeae))
      {
        Object localObject = new File(this.a.a.getApplication().getApplicationContext().getFilesDir(), bdrh.e.a);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = bdhb.a((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              bdrh.a(this.a.a.getApplication().getApplicationContext(), parambeae, i);
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
              parambeae = this.a.a.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              parambeae.edit().putBoolean("enableX5Report", bool1).commit();
              parambeae.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              alpu.a(this.a, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception parambeae)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + parambeae.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpv
 * JD-Core Version:    0.7.0.1
 */