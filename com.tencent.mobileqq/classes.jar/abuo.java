import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class abuo
  extends abul
{
  private boolean a(absf paramabsf)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Abum.a() instanceof behg)) {
      localObject = (behg)this.jdField_a_of_type_Abum.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((behg)localObject).a();
    if (localObject == null) {
      return false;
    }
    ((zbj)localObject).a(paramabsf);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    behg localbehg = null;
    if ((this.jdField_a_of_type_Abum.a() instanceof behg)) {
      localbehg = (behg)this.jdField_a_of_type_Abum.a();
    }
    if (localbehg == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Absi.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Absi.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbehg.a(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        abvm.a(paramabsf, absh.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      abvm.a(paramabsf, -1, "");
      continue;
      abvm.a(paramabsf, absh.a);
      paramString = this.jdField_a_of_type_Absi.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      abvm.a(paramabsf, absh.a);
      continue;
      if (a(paramabsf)) {
        abvm.a(paramabsf, absh.a);
      } else {
        abvm.a(paramabsf, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abuo
 * JD-Core Version:    0.7.0.1
 */