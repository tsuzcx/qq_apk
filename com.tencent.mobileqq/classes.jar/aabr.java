import com.tencent.qphone.base.util.QLog;

public class aabr
{
  public static aabq a(Class<? extends aabq> paramClass, aabp paramaabp)
  {
    if (paramClass == aacq.class) {
      paramClass = new aacq();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramaabp);
      }
      return paramClass;
      if (paramClass == aacw.class) {
        paramClass = new aacw();
      } else {
        try
        {
          aabq localaabq = (aabq)paramClass.newInstance();
          paramClass = localaabq;
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
 * Qualified Name:     aabr
 * JD-Core Version:    0.7.0.1
 */