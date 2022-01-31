import com.tencent.common.cache.ClearMemoryConfig;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.open.appcommon.Common;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class ahqp
  implements Runnable
{
  public ahqp(String paramString1, long paramLong1, long paramLong2, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (!"0".equals("345599"))
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("vcname", this.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("singleMemory", String.valueOf(this.jdField_a_of_type_Long));
        localJSONObject2.put("threshold", String.valueOf(this.jdField_b_of_type_Long));
        if (MemoryConfigs.a().a.a) {}
        for (Object localObject = "1";; localObject = "0")
        {
          localJSONObject2.put("clearFlag", localObject);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("p_id", MagnifierSDK.a());
          ((JSONObject)localObject).put("processname", Common.r());
          ((JSONObject)localObject).put("plugin", String.valueOf(9));
          localJSONObject1.put("minidumpdata", localJSONObject2);
          localJSONObject1.put("clientinfo", localObject);
          localJSONObject1.put("context", this.jdField_b_of_type_JavaLangString);
          localJSONObject1.put("newplugin", 109);
          ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, localJSONObject1, true, true, MagnifierSDK.jdField_a_of_type_Long));
          return;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LeakInspector", 2, localJSONException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ahqp
 * JD-Core Version:    0.7.0.1
 */