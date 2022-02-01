import android.text.TextUtils;
import java.util.List;

public class abbz
{
  private static abca jdField_a_of_type_Abca = new abca();
  private abbu jdField_a_of_type_Abbu = new abbt();
  private abbu b = new abcc();
  
  public static abbz a()
  {
    return (abbz)jdField_a_of_type_Abca.getInstance();
  }
  
  public awwm a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Abbu.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public awwo a(awwm paramawwm, long paramLong)
  {
    Object localObject;
    if (paramawwm == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramawwm.a();
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
      paramawwm = (awwo)localList.get(i);
      localObject = (awwo)localList.get(i + 1);
      if ((paramLong < paramawwm.a) || (((awwo)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramawwm;
      if (paramawwm != null) {
        break;
      }
      return (awwo)localList.get(j - 1);
      i += 1;
      break label43;
      paramawwm = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abbz
 * JD-Core Version:    0.7.0.1
 */