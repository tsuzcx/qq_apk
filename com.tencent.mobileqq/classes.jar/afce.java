import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class afce
{
  private static afce jdField_a_of_type_Afce;
  public static alrb a;
  private static final String jdField_a_of_type_JavaLangString = DeviceProfileManager.DpcNames.aio_config.name();
  public boolean a;
  private String b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_Alrb = new afcf();
  }
  
  private afce()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    DeviceProfileManager.a(jdField_a_of_type_Alrb);
  }
  
  public static afce a()
  {
    if (jdField_a_of_type_Afce == null) {
      b(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIODrawerDpc", 2, "getInstance: " + jdField_a_of_type_Afce);
    }
    return jdField_a_of_type_Afce;
  }
  
  public static boolean a()
  {
    afce localafce = a();
    if (localafce != null) {
      return localafce.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  private static void b(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (jdField_a_of_type_Afce == null)
        {
          jdField_a_of_type_Afce = new afce();
          paramBoolean = true;
        }
        if (paramBoolean) {}
        try
        {
          Object localObject1 = DeviceProfileManager.b().a(jdField_a_of_type_JavaLangString);
          jdField_a_of_type_Afce.jdField_b_of_type_JavaLangString = ((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((String)localObject1).split("\\|");
            if (localObject1.length < 19) {
              break label243;
            }
            if (Integer.valueOf(localObject1[18]).intValue() != 1) {
              continue;
            }
            jdField_a_of_type_Afce.jdField_a_of_type_Boolean = true;
            if (localObject1.length < 20) {
              break label263;
            }
            if (Integer.valueOf(localObject1[19]).intValue() != 1) {
              break label253;
            }
            jdField_a_of_type_Afce.jdField_b_of_type_Boolean = true;
          }
        }
        catch (Exception localException)
        {
          long l2;
          QLog.d("AIODrawerDpc", 1, "load exp:" + localException.getMessage());
          jdField_a_of_type_Afce.jdField_a_of_type_Boolean = true;
          jdField_a_of_type_Afce.jdField_b_of_type_Boolean = true;
          continue;
        }
        if (QLog.isColorLevel())
        {
          l2 = System.currentTimeMillis();
          QLog.d("AIODrawerDpc", 2, "loadDpc: " + jdField_a_of_type_Afce + ", costMills: " + (l2 - l1));
        }
        return;
      }
      finally {}
      jdField_a_of_type_Afce.jdField_a_of_type_Boolean = false;
      continue;
      label243:
      jdField_a_of_type_Afce.jdField_a_of_type_Boolean = true;
      continue;
      label253:
      jdField_a_of_type_Afce.jdField_b_of_type_Boolean = false;
      continue;
      label263:
      jdField_a_of_type_Afce.jdField_b_of_type_Boolean = true;
    }
  }
  
  public static boolean b()
  {
    afce localafce = a();
    if (localafce != null) {
      return localafce.jdField_b_of_type_Boolean;
    }
    return true;
  }
  
  public String toString()
  {
    return "AIODrawerDpc{dpcValue='" + this.jdField_b_of_type_JavaLangString + '\'' + ", isSupport=" + this.jdField_a_of_type_Boolean + ", needPreInflate=" + this.jdField_b_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afce
 * JD-Core Version:    0.7.0.1
 */