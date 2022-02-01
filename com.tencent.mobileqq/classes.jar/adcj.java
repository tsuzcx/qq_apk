import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class adcj
  extends adcg
{
  private boolean a(adaa paramadaa)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Adch.a() instanceof biki)) {
      localObject = (biki)this.jdField_a_of_type_Adch.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((biki)localObject).getShare();
    if (localObject == null) {
      return false;
    }
    ((aasr)localObject).a(paramadaa);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    biki localbiki = null;
    if ((this.jdField_a_of_type_Adch.a() instanceof biki)) {
      localbiki = (biki)this.jdField_a_of_type_Adch.a();
    }
    if (localbiki == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Adad.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Adad.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbiki.setSummary(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adaa paramadaa)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        addh.a(paramadaa, adac.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      addh.a(paramadaa, -1, "");
      continue;
      addh.a(paramadaa, adac.a);
      paramString = this.jdField_a_of_type_Adad.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      addh.a(paramadaa, adac.a);
      continue;
      if (a(paramadaa)) {
        addh.a(paramadaa, adac.a);
      } else {
        addh.a(paramadaa, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcj
 * JD-Core Version:    0.7.0.1
 */