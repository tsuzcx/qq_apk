import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class adbh
  extends adbf
{
  public adbh(adaa paramadaa, long paramLong)
  {
    super(paramadaa, 0, paramLong);
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
      double d1 = paramSosoLbsInfo.mLocation.mLat02;
      double d2 = paramSosoLbsInfo.mLocation.mLon02;
      double d3 = paramSosoLbsInfo.mLocation.speed;
      double d4 = paramSosoLbsInfo.mLocation.accuracy;
      double d5 = paramSosoLbsInfo.mLocation.altitude;
      paramSosoLbsInfo = new JSONObject();
      try
      {
        paramSosoLbsInfo.put("latitude", d1);
        paramSosoLbsInfo.put("longitude", d2);
        paramSosoLbsInfo.put("speed", d3);
        paramSosoLbsInfo.put("accuracy", d4);
        paramSosoLbsInfo.put("altitude", d5);
        paramSosoLbsInfo.put("verticalAccuracy", 0.0D);
        paramSosoLbsInfo.put("horizontalAccuracy", d4);
        addh.a(this.jdField_a_of_type_Adaa, paramSosoLbsInfo);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("DoraemonOpenAPI.sensor", 2, localJSONException.getMessage(), localJSONException);
          }
        }
      }
    }
    addh.a(this.jdField_a_of_type_Adaa, paramInt, "error " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbh
 * JD-Core Version:    0.7.0.1
 */