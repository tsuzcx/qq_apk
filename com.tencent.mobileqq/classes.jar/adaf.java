import com.tencent.qphone.base.util.QLog;

public class adaf
{
  public static adae a(Class<? extends adae> paramClass, adad paramadad)
  {
    if (paramClass == adbe.class) {
      paramClass = new adbe();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramadad);
      }
      return paramClass;
      if (paramClass == adbk.class) {
        paramClass = new adbk();
      } else {
        try
        {
          adae localadae = (adae)paramClass.newInstance();
          paramClass = localadae;
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
 * Qualified Name:     adaf
 * JD-Core Version:    0.7.0.1
 */