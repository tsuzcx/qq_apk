import com.tencent.qphone.base.util.QLog;

public class acjw
{
  public static acjv a(Class<? extends acjv> paramClass, acju paramacju)
  {
    if (paramClass == ackv.class) {
      paramClass = new ackv();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramacju);
      }
      return paramClass;
      if (paramClass == aclb.class) {
        paramClass = new aclb();
      } else {
        try
        {
          acjv localacjv = (acjv)paramClass.newInstance();
          paramClass = localacjv;
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
 * Qualified Name:     acjw
 * JD-Core Version:    0.7.0.1
 */