import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ahgf
  implements InvocationHandler
{
  public ahgm a;
  
  public ahgf(ahgm paramahgm)
  {
    this.a = paramahgm;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    QLog.i("springHb_SpringEntryManager", 2, "callbackInvocationHandler method: " + paramMethod.getName());
    try
    {
      paramObject = paramMethod.invoke(this.a, paramArrayOfObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      QLog.i("springHb_SpringEntryManager", 1, QLog.getStackTraceString(paramObject));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahgf
 * JD-Core Version:    0.7.0.1
 */