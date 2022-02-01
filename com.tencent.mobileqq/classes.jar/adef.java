import com.tencent.qphone.base.util.QLog;

public class adef
{
  public static adee a(Class<? extends adee> paramClass, aded paramaded)
  {
    if (paramClass == adfe.class) {
      paramClass = new adfe();
    }
    for (;;)
    {
      if (paramClass != null) {
        paramClass.a(paramaded);
      }
      return paramClass;
      if (paramClass == adfk.class) {
        paramClass = new adfk();
      } else {
        try
        {
          adee localadee = (adee)paramClass.newInstance();
          paramClass = localadee;
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
 * Qualified Name:     adef
 * JD-Core Version:    0.7.0.1
 */