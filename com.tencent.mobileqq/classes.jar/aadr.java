import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aadr
  extends aado
{
  private boolean a(aabi paramaabi)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Aadp.a() instanceof bcif)) {
      localObject = (bcif)this.jdField_a_of_type_Aadp.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((bcif)localObject).a();
    if (localObject == null) {
      return false;
    }
    ((xmq)localObject).a(paramaabi);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    bcif localbcif = null;
    if ((this.jdField_a_of_type_Aadp.a() instanceof bcif)) {
      localbcif = (bcif)this.jdField_a_of_type_Aadp.a();
    }
    if (localbcif == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Aabl.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Aabl.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbcif.a(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabi paramaabi)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        aaep.a(paramaabi, aabk.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      aaep.a(paramaabi, -1, "");
      continue;
      aaep.a(paramaabi, aabk.a);
      paramString = this.jdField_a_of_type_Aabl.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      aaep.a(paramaabi, aabk.a);
      continue;
      if (a(paramaabi)) {
        aaep.a(paramaabi, aabk.a);
      } else {
        aaep.a(paramaabi, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadr
 * JD-Core Version:    0.7.0.1
 */