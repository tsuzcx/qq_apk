import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class aaar
{
  private static volatile aaap jdField_a_of_type_Aaap;
  private static final String jdField_a_of_type_JavaLangString = aaar.class.getName();
  private static String b;
  private static String c;
  
  public static aaap a()
  {
    if (jdField_a_of_type_Aaap == null) {}
    try
    {
      if (jdField_a_of_type_Aaap == null)
      {
        if (b == null) {
          b = BaseApplicationImpl.getApplication().getPackageName();
        }
        if (c == null) {
          c = BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath();
        }
        jdField_a_of_type_Aaap = new aaas(b, c);
      }
      yuk.b(jdField_a_of_type_JavaLangString, "init FileCache");
      return jdField_a_of_type_Aaap;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaar
 * JD-Core Version:    0.7.0.1
 */