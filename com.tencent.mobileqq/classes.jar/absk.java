import com.tencent.qphone.base.util.QLog;

public class absk
{
  public static absj a(Class<? extends absj> paramClass, absi paramabsi)
  {
    if (paramClass == abtj.class) {
      paramClass = new abtj();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramabsi);
      }
      return paramClass;
      if (paramClass == abtp.class) {
        paramClass = new abtp();
      } else {
        try
        {
          absj localabsj = (absj)paramClass.newInstance();
          paramClass = localabsj;
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
 * Qualified Name:     absk
 * JD-Core Version:    0.7.0.1
 */