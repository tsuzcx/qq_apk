import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class adbg
  extends adbf
{
  public adbg(adaa paramadaa, long paramLong)
  {
    super(paramadaa, 3, paramLong);
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
        addh.a(this.jdField_a_of_type_Adaa, localJSONObject);
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
    addh.a(this.jdField_a_of_type_Adaa, paramInt, "error " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbg
 * JD-Core Version:    0.7.0.1
 */