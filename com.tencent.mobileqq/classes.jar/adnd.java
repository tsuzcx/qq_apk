import com.tencent.qphone.base.util.QLog;

public class adnd
{
  public static adnc a(Class<? extends adnc> paramClass, adnb paramadnb)
  {
    if (paramClass == adoc.class) {
      paramClass = new adoc();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramadnb);
      }
      return paramClass;
      if (paramClass == adoi.class) {
        paramClass = new adoi();
      } else {
        try
        {
          adnc localadnc = (adnc)paramClass.newInstance();
          paramClass = localadnc;
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
 * Qualified Name:     adnd
 * JD-Core Version:    0.7.0.1
 */