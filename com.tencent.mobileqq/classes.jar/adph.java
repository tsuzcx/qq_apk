import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class adph
  extends adpe
{
  private boolean a(admy paramadmy)
  {
    Object localObject = null;
    if ((this.jdField_a_of_type_Adpf.a() instanceof bito)) {
      localObject = (bito)this.jdField_a_of_type_Adpf.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = ((bito)localObject).getShare();
    if (localObject == null) {
      return false;
    }
    ((abgu)localObject).a(paramadmy);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    bito localbito = null;
    if ((this.jdField_a_of_type_Adpf.a() instanceof bito)) {
      localbito = (bito)this.jdField_a_of_type_Adpf.a();
    }
    if (localbito == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_Adnb.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_Adnb.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localbito.setSummary(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull admy paramadmy)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        adqf.a(paramadmy, adna.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      adqf.a(paramadmy, -1, "");
      continue;
      adqf.a(paramadmy, adna.a);
      paramString = this.jdField_a_of_type_Adnb.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      adqf.a(paramadmy, adna.a);
      continue;
      if (a(paramadmy)) {
        adqf.a(paramadmy, adna.a);
      } else {
        adqf.a(paramadmy, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adph
 * JD-Core Version:    0.7.0.1
 */