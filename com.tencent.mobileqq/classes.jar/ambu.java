import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ambu
{
  public boolean a;
  
  public static ambu a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        ambu localambu = new ambu();
        localambu.a = new JSONObject(paramString).optBoolean("useParcelForBoot", false);
        QLog.d("BootOptimizeConfProcessor", 2, "confBean = " + localambu.toString());
        return localambu;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("BootOptimizeConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public String toString()
  {
    return "BootOptimizeConfigureBean{useParcelForBoot=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambu
 * JD-Core Version:    0.7.0.1
 */