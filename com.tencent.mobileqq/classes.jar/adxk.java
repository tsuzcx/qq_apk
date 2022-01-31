import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.hiboom.HiBoomItem;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public class adxk
  implements Runnable
{
  public adxk(HiBoomManager paramHiBoomManager, boolean paramBoolean) {}
  
  public void run()
  {
    ??? = FileUtils.a(VasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1000L, "xydata.qq.hifont.recommend.json", null, this.jdField_a_of_type_Boolean, null), -1);
    if (??? != null) {
      try
      {
        ??? = new JSONArray((String)???);
        this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager.jdField_a_of_type_JavaUtilVector.clear();
        int i = 0;
        while (i < ((JSONArray)???).length())
        {
          HiBoomItem localHiBoomItem = new HiBoomItem();
          JSONObject localJSONObject = ((JSONArray)???).getJSONObject(i);
          String str = localJSONObject.optString("id");
          if (TextUtils.isDigitsOnly(str)) {
            localHiBoomItem.jdField_a_of_type_Int = Integer.parseInt(str);
          }
          localHiBoomItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("name");
          localHiBoomItem.jdField_b_of_type_Int = localJSONObject.optInt("engine");
          localHiBoomItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("aio");
          this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager.jdField_a_of_type_JavaUtilVector.add(localHiBoomItem);
          i += 1;
        }
        synchronized (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          }
          return;
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("HiBoomFont.HiBoomManager", 1, "getRecommendListFromJSON error: ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxk
 * JD-Core Version:    0.7.0.1
 */