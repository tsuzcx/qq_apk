import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amcb
{
  public int a;
  
  public static amcb a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        amcb localamcb = new amcb();
        localamcb.a = new JSONObject(paramString).optInt("kDeviceManageShowMuteKey", 0);
        QLog.d("DeviceManageConfProcessor", 2, "confBean = " + localamcb.toString());
        return localamcb;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("DeviceManageConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("kDeviceManageShowMuteKey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcb
 * JD-Core Version:    0.7.0.1
 */