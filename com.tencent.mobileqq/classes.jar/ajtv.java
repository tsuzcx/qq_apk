import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class ajtv
  extends bbwf
{
  ajtv(ajtu paramajtu) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    parambbwg = parambbwg.a();
    if ((parambbwg.containsKey("version")) && (parambbwg.containsKey("json_name")))
    {
      int i = parambbwg.getInt("version", -1);
      parambbwg = parambbwg.getString("json_name");
      if (bbnq.e.d.equals(parambbwg))
      {
        Object localObject = new File(this.a.a.getApplication().getApplicationContext().getFilesDir(), bbnq.e.a);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = bbdj.a((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              bbnq.a(this.a.a.getApplication().getApplicationContext(), parambbwg, i);
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
              parambbwg = this.a.a.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              parambbwg.edit().putBoolean("enableX5Report", bool1).commit();
              parambbwg.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              ajtu.a(this.a, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception parambbwg)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + parambbwg.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtv
 * JD-Core Version:    0.7.0.1
 */