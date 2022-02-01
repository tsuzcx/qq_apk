import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ackx
  extends ackw
{
  public ackx(acjr paramacjr, long paramLong)
  {
    super(paramacjr, 3, paramLong);
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
        localJSONObject.put("nation", paramSosoLbsInfo.mLocation.nation);
        localJSONObject.put("province", paramSosoLbsInfo.mLocation.province);
        localJSONObject.put("city", paramSosoLbsInfo.mLocation.city);
        localJSONObject.put("district", paramSosoLbsInfo.mLocation.district);
        acmy.a(this.jdField_a_of_type_Acjr, localJSONObject);
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
    acmy.a(this.jdField_a_of_type_Acjr, paramInt, "error " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackx
 * JD-Core Version:    0.7.0.1
 */