import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class adoy
  extends adnc
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull admy paramadmy)
  {
    paramString = this.a.a();
    if ((paramString == null) || (paramString.isFinishing()))
    {
      QLog.e("NavigateModule", 1, "execute activity is null or finish");
      return false;
    }
    Intent localIntent;
    switch (paramInt)
    {
    default: 
      return false;
    case 19: 
      paramJSONObject = paramJSONObject.optString("action", "");
      if ((paramJSONObject != null) && (paramJSONObject.startsWith("mqqapi:")))
      {
        localIntent = new Intent(paramString, JumpActivity.class);
        localIntent.setData(Uri.parse(paramJSONObject));
        paramString.startActivity(localIntent);
        adqf.a(paramadmy, adna.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      paramJSONObject = paramJSONObject.optString("url", "");
      localIntent = new Intent(paramString, QQBrowserActivity.class);
      localIntent.putExtra("url", paramJSONObject);
      paramString.startActivity(localIntent);
      adqf.a(paramadmy, adna.a);
      continue;
      adqf.a(paramadmy, -1, "scheme not support");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adoy
 * JD-Core Version:    0.7.0.1
 */