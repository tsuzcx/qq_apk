import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.GetUrlRsp;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.ItemVersion;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.SCPreloadOrReport;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.SyncVCRRsp;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.UpdateInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.VCR;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class akpt
  extends VasExtensionObserver
{
  public akpt(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  protected void r(boolean paramBoolean, Object paramObject)
  {
    int j = 0;
    JSONObject localJSONObject1;
    if (paramBoolean)
    {
      paramObject = (VasQuickUpdateManager.SyncVCRRsp)paramObject;
      localJSONObject1 = new JSONObject();
    }
    do
    {
      try
      {
        localJSONObject1.put("cookie", paramObject.jdField_a_of_type_Long);
        localJSONObject1.put("seq", paramObject.jdField_c_of_type_Long);
        localJSONObject1.put("polltime", paramObject.jdField_b_of_type_Int);
        localJSONObject1.put("syncSwitch", paramObject.jdField_c_of_type_Int);
        Object localObject1 = new JSONArray();
        int i = 0;
        Object localObject3;
        while (i < paramObject.jdField_a_of_type_JavaUtilList.size())
        {
          localObject2 = (VasQuickUpdateManager.VCR)paramObject.jdField_a_of_type_JavaUtilList.get(i);
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("bid", ((VasQuickUpdateManager.VCR)localObject2).jdField_b_of_type_Long);
          ((JSONObject)localObject3).put("scid", ((VasQuickUpdateManager.VCR)localObject2).jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject3).put("optype", ((VasQuickUpdateManager.VCR)localObject2).jdField_a_of_type_Int);
          ((JSONObject)localObject3).put("version", ((VasQuickUpdateManager.VCR)localObject2).jdField_b_of_type_JavaLangString);
          ((JSONArray)localObject1).put(localObject3);
          i += 1;
        }
        localJSONObject1.put("vcr_list", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("plver", paramObject.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.jdField_a_of_type_Long);
        Object localObject2 = new JSONArray();
        i = 0;
        JSONObject localJSONObject2;
        while (i < paramObject.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.jdField_a_of_type_JavaUtilList.size())
        {
          localObject3 = (VasQuickUpdateManager.ItemVersion)paramObject.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.jdField_a_of_type_JavaUtilList.get(i);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("bid", ((VasQuickUpdateManager.ItemVersion)localObject3).jdField_a_of_type_Long);
          localJSONObject2.put("scid", ((VasQuickUpdateManager.ItemVersion)localObject3).jdField_a_of_type_JavaLangString);
          localJSONObject2.put("flag", ((VasQuickUpdateManager.ItemVersion)localObject3).jdField_b_of_type_Long);
          ((JSONArray)localObject2).put(localJSONObject2);
          i += 1;
        }
        ((JSONObject)localObject1).put("item_list", localObject2);
        localJSONObject1.put("preload", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("rpver", paramObject.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.jdField_a_of_type_Long);
        localObject2 = new JSONArray();
        i = j;
        while (i < paramObject.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.jdField_a_of_type_JavaUtilList.size())
        {
          localObject3 = (VasQuickUpdateManager.ItemVersion)paramObject.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.jdField_a_of_type_JavaUtilList.get(i);
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("bid", ((VasQuickUpdateManager.ItemVersion)localObject3).jdField_a_of_type_Long);
          localJSONObject2.put("scid", ((VasQuickUpdateManager.ItemVersion)localObject3).jdField_a_of_type_JavaLangString);
          ((JSONArray)localObject2).put(localJSONObject2);
          i += 1;
        }
        ((JSONObject)localObject1).put("item_list", localObject2);
        localJSONObject1.put("report", localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "onQuickUpdateSync data = " + localJSONObject1.toString());
        }
        if (this.a.a != null) {
          this.a.a.onPbMsgRecv(0, VasExtensionHandler.e, localJSONObject1.toString());
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync error: ", localException);
        } while (this.a.a == null);
        paramObject = "{\"cookie\":" + paramObject.jdField_a_of_type_Long + "}";
        this.a.a.onPbMsgRecv(-1, VasExtensionHandler.e, paramObject);
        return;
      }
      paramObject = (akpw)paramObject;
      QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateSync result = " + paramObject.jdField_b_of_type_Long + " cookie = " + paramObject.jdField_a_of_type_Long);
    } while (this.a.a == null);
    String str = "{\"cookie\":" + paramObject.jdField_a_of_type_Long + "}";
    this.a.a.onPbMsgRecv((int)paramObject.jdField_b_of_type_Long, VasExtensionHandler.e, str);
  }
  
  protected void s(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      paramObject = (VasQuickUpdateManager.GetUrlRsp)paramObject;
    }
    do
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("cookie", paramObject.jdField_a_of_type_Long);
        JSONArray localJSONArray = new JSONArray();
        int i = 0;
        while (i < paramObject.jdField_a_of_type_JavaUtilList.size())
        {
          VasQuickUpdateManager.UpdateInfo localUpdateInfo = (VasQuickUpdateManager.UpdateInfo)paramObject.jdField_a_of_type_JavaUtilList.get(i);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("bid", localUpdateInfo.jdField_a_of_type_Long);
          localJSONObject2.put("scid", localUpdateInfo.jdField_a_of_type_JavaLangString);
          localJSONObject2.put("dst_version", localUpdateInfo.jdField_b_of_type_JavaLangString);
          localJSONObject2.put("src_version", localUpdateInfo.jdField_c_of_type_JavaLangString);
          localJSONObject2.put("delta_mode", localUpdateInfo.jdField_a_of_type_Int);
          localJSONObject2.put("storage_mode", localUpdateInfo.jdField_b_of_type_Int);
          localJSONObject2.put("compress_mode", localUpdateInfo.jdField_c_of_type_Int);
          localJSONObject2.put("url", localUpdateInfo.jdField_d_of_type_JavaLangString);
          localJSONObject2.put("filesize", localUpdateInfo.jdField_b_of_type_Long);
          localJSONObject2.put("filecontent", localUpdateInfo.e);
          localJSONObject2.put("code", localUpdateInfo.jdField_d_of_type_Int);
          localJSONArray.put(localJSONObject2);
          i += 1;
        }
        localJSONObject1.put("update_list", localJSONArray);
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateManager", 2, "onQuickUpdateGetUrl data = " + localJSONObject1.toString());
        }
        if (this.a.a != null) {
          this.a.a.onPbMsgRecv(0, VasExtensionHandler.g, localJSONObject1.toString());
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl error: ", localException);
        } while (this.a.a == null);
        str = "{\"cookie\":" + paramObject.jdField_a_of_type_Long + "}";
        this.a.a.onPbMsgRecv((int)paramObject.jdField_b_of_type_Long, VasExtensionHandler.g, str);
        return;
      }
      paramObject = (akpw)paramObject;
      QLog.e("VasQuickUpdateManager", 1, "onQuickUpdateGetUrl result = " + paramObject.jdField_b_of_type_Long + " cookie = " + paramObject.jdField_a_of_type_Long);
    } while (this.a.a == null);
    String str = "{\"cookie\":" + paramObject.jdField_a_of_type_Long + "}";
    this.a.a.onPbMsgRecv((int)paramObject.jdField_b_of_type_Long, VasExtensionHandler.g, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpt
 * JD-Core Version:    0.7.0.1
 */