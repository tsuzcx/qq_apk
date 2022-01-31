import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class abzd
  extends abza
{
  private boolean a(abwu paramabwu)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Abzb.a() instanceof belp)) {
      localObject = (belp)this.jdField_a_of_type_Abzb.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((belp)localObject).a();
    if (localObject == null) {
      return false;
    }
    ((zfy)localObject).a(paramabwu);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    belp localbelp = null;
    if ((this.jdField_a_of_type_Abzb.a() instanceof belp)) {
      localbelp = (belp)this.jdField_a_of_type_Abzb.a();
    }
    if (localbelp == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Abwx.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Abwx.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbelp.a(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull abwu paramabwu)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        acab.a(paramabwu, abww.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      acab.a(paramabwu, -1, "");
      continue;
      acab.a(paramabwu, abww.a);
      paramString = this.jdField_a_of_type_Abwx.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      acab.a(paramabwu, abww.a);
      continue;
      if (a(paramabwu)) {
        acab.a(paramabwu, abww.a);
      } else {
        acab.a(paramabwu, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzd
 * JD-Core Version:    0.7.0.1
 */