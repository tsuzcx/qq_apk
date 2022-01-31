import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aadv
  extends aads
{
  private boolean a(aabm paramaabm)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Aadt.a() instanceof bchr)) {
      localObject = (bchr)this.jdField_a_of_type_Aadt.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((bchr)localObject).a();
    if (localObject == null) {
      return false;
    }
    ((xmt)localObject).a(paramaabm);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    bchr localbchr = null;
    if ((this.jdField_a_of_type_Aadt.a() instanceof bchr)) {
      localbchr = (bchr)this.jdField_a_of_type_Aadt.a();
    }
    if (localbchr == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Aabp.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Aabp.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbchr.a(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabm paramaabm)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        aaet.a(paramaabm, aabo.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      aaet.a(paramaabm, -1, "");
      continue;
      aaet.a(paramaabm, aabo.a);
      paramString = this.jdField_a_of_type_Aabp.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      aaet.a(paramaabm, aabo.a);
      continue;
      if (a(paramaabm)) {
        aaet.a(paramaabm, aabo.a);
      } else {
        aaet.a(paramaabm, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadv
 * JD-Core Version:    0.7.0.1
 */