import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class acma
  extends aclx
{
  private boolean a(acjr paramacjr)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Acly.a() instanceof bgzq)) {
      localObject = (bgzq)this.jdField_a_of_type_Acly.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((bgzq)localObject).getShare();
    if (localObject == null) {
      return false;
    }
    ((aadf)localObject).a(paramacjr);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    bgzq localbgzq = null;
    if ((this.jdField_a_of_type_Acly.a() instanceof bgzq)) {
      localbgzq = (bgzq)this.jdField_a_of_type_Acly.a();
    }
    if (localbgzq == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Acju.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Acju.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbgzq.setSummary(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull acjr paramacjr)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        acmy.a(paramacjr, acjt.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      acmy.a(paramacjr, -1, "");
      continue;
      acmy.a(paramacjr, acjt.a);
      paramString = this.jdField_a_of_type_Acju.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      acmy.a(paramacjr, acjt.a);
      continue;
      if (a(paramacjr)) {
        acmy.a(paramacjr, acjt.a);
      } else {
        acmy.a(paramacjr, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acma
 * JD-Core Version:    0.7.0.1
 */