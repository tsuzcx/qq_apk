import android.os.Handler;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class aeig
  implements Runnable
{
  public aeig(EmoticonManager paramEmoticonManager, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 2, "parseCloudKeywordsJson:");
      }
      localJSONObject = VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "keywordList_2.json", true, null);
      if (localJSONObject == null)
      {
        QLog.d("EmoticonManager", 1, "parseCloudKeywordsJson json file not");
        return;
      }
      HashMap localHashMap = new HashMap();
      localJSONObject = localJSONObject.optJSONObject("keywords");
      if (localJSONObject == null)
      {
        QLog.d("EmoticonManager", 1, "parseCloudKeywordsJson json file keywords not exist");
        return;
      }
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject;
      if (QLog.isColorLevel())
      {
        QLog.e("EmoticonManager", 2, "parseCloudKeywordsJson error ,e = " + localException.getMessage());
        return;
        JSONArray localJSONArray1 = localJSONObject.names();
        int k = localJSONArray1.length();
        int i = 0;
        while (i < k)
        {
          String str = localJSONArray1.getString(i);
          JSONArray localJSONArray2 = localJSONObject.getJSONArray(str);
          int j = this.jdField_a_of_type_Int;
          if (this.jdField_a_of_type_Int == 3) {
            j = 2;
          }
          j = localJSONArray2.getInt(j);
          localException.put(str.toLowerCase(), Integer.valueOf(j));
          i += 1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.jdField_a_of_type_AndroidOsHandler.post(new aeih(this, localException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeig
 * JD-Core Version:    0.7.0.1
 */