import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class alpp
{
  private static alpp jdField_a_of_type_Alpp;
  private static final String jdField_a_of_type_JavaLangString = DeviceProfileManager.DpcNames.headDpcCfg.name();
  private int jdField_a_of_type_Int = 1;
  private almm jdField_a_of_type_Almm = new alpq(this);
  
  private alpp()
  {
    DeviceProfileManager.a(this.jdField_a_of_type_Almm);
    a();
  }
  
  public static alpp a()
  {
    if (jdField_a_of_type_Alpp == null) {}
    try
    {
      if (jdField_a_of_type_Alpp == null) {
        jdField_a_of_type_Alpp = new alpp();
      }
      return jdField_a_of_type_Alpp;
    }
    finally {}
  }
  
  public void a()
  {
    String str = DeviceProfileManager.b().a(jdField_a_of_type_JavaLangString);
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length < 1) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("HeadDpcCfg", 2, String.format("loadConfig, mDualStackPrefIpv6: %s, dpc=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str }));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.d("HeadDpcCfg", 1, "loadConfig exception :" + localException.getMessage());
        this.jdField_a_of_type_Int = 1;
        continue;
      }
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public boolean a()
  {
    QLog.d("HeadDpcCfg", 1, String.format("preferIpv6 mDualStackPrefIpv6=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    return this.jdField_a_of_type_Int != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpp
 * JD-Core Version:    0.7.0.1
 */