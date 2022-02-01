import android.text.TextUtils;
import java.util.List;

public class aanw
{
  private static aanx jdField_a_of_type_Aanx = new aanx();
  private aanr jdField_a_of_type_Aanr = new aanq();
  private aanr b = new aanz();
  
  public static aanw a()
  {
    return (aanw)jdField_a_of_type_Aanx.getInstance();
  }
  
  public awpy a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Aanr.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public awqa a(awpy paramawpy, long paramLong)
  {
    Object localObject;
    if (paramawpy == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramawpy.a();
    if (localList == null) {
      return null;
    }
    int j = localList.size();
    if (j < 1) {
      return null;
    }
    int i = 0;
    label43:
    if (i < j - 1)
    {
      paramawpy = (awqa)localList.get(i);
      localObject = (awqa)localList.get(i + 1);
      if ((paramLong < paramawpy.a) || (((awqa)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramawpy;
      if (paramawpy != null) {
        break;
      }
      return (awqa)localList.get(j - 1);
      i += 1;
      break label43;
      paramawpy = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanw
 * JD-Core Version:    0.7.0.1
 */