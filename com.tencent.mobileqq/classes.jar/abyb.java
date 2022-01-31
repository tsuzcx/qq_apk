import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class abyb
  extends abxz
{
  public abyb(abwu paramabwu, long paramLong)
  {
    super(paramabwu, 0, paramLong);
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
      double d1 = paramSosoLbsInfo.a.jdField_a_of_type_Double;
      double d2 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
      double d3 = paramSosoLbsInfo.a.jdField_b_of_type_Float;
      double d4 = paramSosoLbsInfo.a.jdField_a_of_type_Float;
      double d5 = paramSosoLbsInfo.a.e;
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
        acab.a(this.jdField_a_of_type_Abwu, paramSosoLbsInfo);
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
    acab.a(this.jdField_a_of_type_Abwu, paramInt, "error " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyb
 * JD-Core Version:    0.7.0.1
 */