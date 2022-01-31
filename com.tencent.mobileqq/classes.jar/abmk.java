import android.os.Bundle;
import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.DictLocalMetaInfo;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class abmk
  implements HttpWebCgiAsyncTask.Callback
{
  public abmk(WordMatchManager paramWordMatchManager) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    int i = 1;
    if (paramJSONObject != null) {}
    try
    {
      int j = paramJSONObject.getInt("retcode");
      if (j != 0) {
        i = 0;
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot cgi end(failed)| type:" + paramInt + ",time:" + System.currentTimeMillis());
        }
        this.a.a(false);
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      paramBundle = paramBundle;
      paramBundle.printStackTrace();
      paramBundle = new WordMatchManager.DictLocalMetaInfo();
      try
      {
        if (paramJSONObject.has("result"))
        {
          paramJSONObject = paramJSONObject.getJSONObject("result");
          if (paramJSONObject.has("id")) {
            paramBundle.c = paramJSONObject.getString("id");
          }
          if (paramJSONObject.has("md5")) {
            paramBundle.jdField_a_of_type_JavaLangString = paramJSONObject.getString("md5");
          }
          if (paramJSONObject.has("type")) {
            paramBundle.jdField_a_of_type_Int = paramJSONObject.getInt("type");
          }
          if (paramJSONObject.has("need_flag")) {
            paramBundle.jdField_b_of_type_Int = paramJSONObject.getInt("need_flag");
          }
          if (paramJSONObject.has("delay")) {
            paramBundle.jdField_a_of_type_Long = paramJSONObject.getLong("delay");
          }
          if (paramJSONObject.has("base_md5")) {
            paramBundle.jdField_b_of_type_JavaLangString = paramJSONObject.getString("base_md5");
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot parse json error | type:" + paramInt + ",time:" + System.currentTimeMillis());
          }
        }
        this.a.a(paramBundle);
      }
      if (QLog.isColorLevel()) {
        QLog.d(".business.sougou.DicFileDownloader", 2, "requestGetDictOrNot cgi end(success) | type:" + paramInt + ",time:" + System.currentTimeMillis());
      }
      if (paramBundle.jdField_a_of_type_Int != paramInt)
      {
        this.a.a(false);
        return;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abmk
 * JD-Core Version:    0.7.0.1
 */