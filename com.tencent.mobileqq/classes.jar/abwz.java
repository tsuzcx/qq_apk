import com.tencent.qphone.base.util.QLog;

public class abwz
{
  public static abwy a(Class<? extends abwy> paramClass, abwx paramabwx)
  {
    if (paramClass == abxy.class) {
      paramClass = new abxy();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramabwx);
      }
      return paramClass;
      if (paramClass == abye.class) {
        paramClass = new abye();
      } else {
        try
        {
          abwy localabwy = (abwy)paramClass.newInstance();
          paramClass = localabwy;
        }
        catch (Exception localException)
        {
          QLog.e("DoraemonOpenAPI.moduleFactory", 1, "newInstance error module=" + paramClass, localException);
          paramClass = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwz
 * JD-Core Version:    0.7.0.1
 */