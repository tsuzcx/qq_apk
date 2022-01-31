import com.tencent.qphone.base.util.QLog;

public class aabn
{
  public static aabm a(Class<? extends aabm> paramClass, aabl paramaabl)
  {
    if (paramClass == aacm.class) {
      paramClass = new aacm();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramaabl);
      }
      return paramClass;
      if (paramClass == aacs.class) {
        paramClass = new aacs();
      } else {
        try
        {
          aabm localaabm = (aabm)paramClass.newInstance();
          paramClass = localaabm;
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
 * Qualified Name:     aabn
 * JD-Core Version:    0.7.0.1
 */