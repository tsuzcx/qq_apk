import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aasw
  implements ows
{
  aasw(aast paramaast, JSONObject paramJSONObject, String paramString, Bundle paramBundle) {}
  
  public void a(long paramLong, boolean paramBoolean1, int paramInt1, @Nullable String paramString1, @Nullable String paramString2, int paramInt2, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      paramInt1 = 0;
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", paramInt1);
        this.jdField_a_of_type_OrgJsonJSONObject.put("commentId", paramString1);
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidOsBundle.putString("BUNDLE_KEY_JS_OBJ", this.jdField_a_of_type_OrgJsonJSONObject.toString());
        this.jdField_a_of_type_Aast.a.a(154, this.jdField_a_of_type_AndroidOsBundle);
        return;
        paramInt1 = -2;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult put create comment result error.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasw
 * JD-Core Version:    0.7.0.1
 */