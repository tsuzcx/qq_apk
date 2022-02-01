import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class alce
{
  public static AtomicBoolean a;
  public static String[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "MI 3", "Coolpad 8675", "OPPO R7", "Redmi Note 2", "MX4", "vivo X5L", "m3 note", "PRO 6" };
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        if (Integer.valueOf(paramString).intValue() == 0)
        {
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideo.ProgressiveUtils", 2, "parseConfig(): config = " + paramString + ", sProgressiveEnable = " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
          }
          return;
        }
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        continue;
      }
      catch (Exception localException)
      {
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        continue;
      }
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alce
 * JD-Core Version:    0.7.0.1
 */