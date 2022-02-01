import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class adgj
  extends adgg
{
  private boolean a(adea paramadea)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Adgh.a() instanceof bhst)) {
      localObject = (bhst)this.jdField_a_of_type_Adgh.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((bhst)localObject).getShare();
    if (localObject == null) {
      return false;
    }
    ((abcr)localObject).a(paramadea);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    bhst localbhst = null;
    if ((this.jdField_a_of_type_Adgh.a() instanceof bhst)) {
      localbhst = (bhst)this.jdField_a_of_type_Adgh.a();
    }
    if (localbhst == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Aded.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Aded.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbhst.setSummary(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adea paramadea)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        adhh.a(paramadea, adec.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      adhh.a(paramadea, -1, "");
      continue;
      adhh.a(paramadea, adec.a);
      paramString = this.jdField_a_of_type_Aded.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      adhh.a(paramadea, adec.a);
      continue;
      if (a(paramadea)) {
        adhh.a(paramadea, adec.a);
      } else {
        adhh.a(paramadea, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgj
 * JD-Core Version:    0.7.0.1
 */