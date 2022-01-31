import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class ajft
  extends batl
{
  ajft(ajfs paramajfs) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    parambatm = parambatm.a();
    if ((parambatm.containsKey("version")) && (parambatm.containsKey("json_name")))
    {
      int i = parambatm.getInt("version", -1);
      parambatm = parambatm.getString("json_name");
      if (balu.e.d.equals(parambatm))
      {
        Object localObject = new File(this.a.a.getApplication().getApplicationContext().getFilesDir(), balu.e.a);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = bace.a((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              balu.a(this.a.a.getApplication().getApplicationContext(), parambatm, i);
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
              parambatm = this.a.a.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              parambatm.edit().putBoolean("enableX5Report", bool1).commit();
              parambatm.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              ajfs.a(this.a, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception parambatm)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + parambatm.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajft
 * JD-Core Version:    0.7.0.1
 */