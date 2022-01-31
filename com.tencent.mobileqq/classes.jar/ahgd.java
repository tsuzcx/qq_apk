import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ahgd
  implements InvocationHandler
{
  public ahgk a;
  
  public ahgd(ahgk paramahgk)
  {
    this.a = paramahgk;
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
 * Qualified Name:     ahgd
 * JD-Core Version:    0.7.0.1
 */