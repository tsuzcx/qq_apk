import android.text.TextUtils;
import java.util.List;

public class aaxw
{
  private static aaxx jdField_a_of_type_Aaxx = new aaxx();
  private aaxr jdField_a_of_type_Aaxr = new aaxq();
  private aaxr b = new aaxz();
  
  public static aaxw a()
  {
    return (aaxw)jdField_a_of_type_Aaxx.getInstance();
  }
  
  public awdu a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_Aaxr.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public awdw a(awdu paramawdu, long paramLong)
  {
    Object localObject;
    if (paramawdu == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramawdu.a();
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
      paramawdu = (awdw)localList.get(i);
      localObject = (awdw)localList.get(i + 1);
      if ((paramLong < paramawdu.a) || (((awdw)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramawdu;
      if (paramawdu != null) {
        break;
      }
      return (awdw)localList.get(j - 1);
      i += 1;
      break label43;
      paramawdu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaxw
 * JD-Core Version:    0.7.0.1
 */