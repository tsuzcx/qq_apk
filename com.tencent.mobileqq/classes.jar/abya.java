import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class abya
  extends abxz
{
  public abya(abwu paramabwu, long paramLong)
  {
    super(paramabwu, 3, paramLong);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.sensor.location", 2, "onLocationFinish: errCode=" + paramInt + ", info=" + paramSosoLbsInfo + ", isActive=" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramInt == 0)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("nation", paramSosoLbsInfo.a.c);
        localJSONObject.put("province", paramSosoLbsInfo.a.d);
        localJSONObject.put("city", paramSosoLbsInfo.a.e);
        localJSONObject.put("district", paramSosoLbsInfo.a.g);
        acab.a(this.jdField_a_of_type_Abwu, localJSONObject);
        return;
      }
      catch (JSONException paramSosoLbsInfo)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("DoraemonOpenAPI.sensor", 2, paramSosoLbsInfo.getMessage(), paramSosoLbsInfo);
          }
        }
      }
    }
    acab.a(this.jdField_a_of_type_Abwu, paramInt, "error " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abya
 * JD-Core Version:    0.7.0.1
 */