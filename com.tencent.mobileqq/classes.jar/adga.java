import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class adga
  extends adee
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adea paramadea)
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
        adhh.a(paramadea, adec.a);
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
      adhh.a(paramadea, adec.a);
      continue;
      adhh.a(paramadea, -1, "scheme not support");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adga
 * JD-Core Version:    0.7.0.1
 */