import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopFeedParserHelper;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ajjd
  implements HttpWebCgiAsyncTask.Callback
{
  public ajjd(TroopFeedsDataManager paramTroopFeedsDataManager) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("retcode") == 0) {
          break label687;
        }
        i = paramJSONObject.optInt("ec");
        if (i == 0) {
          break label687;
        }
        i = 0;
        if (i == 0)
        {
          if ((paramInt == 1000) || (paramInt == 1002))
          {
            TroopFeedsDataManager.e(this.a);
            this.a.notifyObservers(Integer.valueOf(103));
            if (paramInt == 1002) {
              this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager", 2, "cgi end(failed): " + System.currentTimeMillis());
          }
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle = paramBundle;
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "cgi end(suc): " + System.currentTimeMillis());
        }
        if (paramInt == 1000)
        {
          ThreadManager.getSubThreadHandler().post(new ajje(this, paramJSONObject));
          return;
        }
      }
      finally {}
      if (paramInt == 1002)
      {
        ThreadManager.getSubThreadHandler().post(new ajjf(this, paramJSONObject));
        return;
      }
      if (paramInt == 1003)
      {
        TroopFeedsDataManager.f(this.a);
        paramBundle = paramJSONObject.optJSONArray("inst");
        if ((paramBundle != null) && (paramBundle.length() > 0))
        {
          this.a.jdField_a_of_type_OrgJsonJSONObject = paramBundle.optJSONObject(0);
          this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
        }
        this.a.notifyObservers(Integer.valueOf(106));
        return;
      }
      Object localObject;
      JSONObject localJSONObject;
      if (paramInt == 1004)
      {
        localObject = paramJSONObject.optJSONArray("feeds");
        paramBundle = paramJSONObject.optJSONArray("inst");
        if ((localObject != null) && (((JSONArray)localObject).length() == 1))
        {
          localJSONObject = ((JSONArray)localObject).optJSONObject(0);
          this.a.b = localJSONObject;
          this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
          paramInt = 1;
        }
      }
      for (;;)
      {
        i = paramInt;
        if (paramBundle != null)
        {
          i = paramInt;
          if (paramBundle.length() > 0)
          {
            paramBundle = paramBundle.optJSONObject(0);
            long l2 = paramBundle.optLong("pubt");
            long l1 = 0L;
            if (this.a.b != null) {
              l1 = this.a.b.optLong("pubt");
            }
            i = paramInt;
            if (l2 > l1)
            {
              this.a.b = paramBundle;
              this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");
              i = 1;
            }
          }
        }
        if (i == 0) {
          break;
        }
        TroopFeedsDataManager.g(this.a);
        this.a.notifyObservers(Integer.valueOf(1007));
        return;
        if ((localObject != null) && (((JSONArray)localObject).length() == 2))
        {
          localJSONObject = ((JSONArray)localObject).optJSONObject(0);
          localObject = ((JSONArray)localObject).optJSONObject(1);
          if (localJSONObject.optLong("pubt") >= ((JSONObject)localObject).optLong("pubt")) {
            this.a.b = localJSONObject;
          }
          for (this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad");; this.a.jdField_a_of_type_Int = paramJSONObject.optInt("ad"))
          {
            paramInt = 1;
            break;
            this.a.b = ((JSONObject)localObject);
          }
          if ((paramInt != 1005) && (paramInt != 1006)) {
            break;
          }
          paramJSONObject = TroopFeedParserHelper.a(paramJSONObject, "" + this.a.jdField_a_of_type_JavaLangLong, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramBundle = (List)paramJSONObject[0];
          paramJSONObject = (List)paramJSONObject[1];
          this.a.jdField_a_of_type_JavaUtilList = paramJSONObject;
          TroopFeedsDataManager.h(this.a);
          if (paramInt == 1005)
          {
            this.a.notifyObservers(Integer.valueOf(1008));
            return;
          }
          this.a.notifyObservers(Integer.valueOf(1009));
          return;
        }
        paramInt = 0;
      }
      label687:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjd
 * JD-Core Version:    0.7.0.1
 */