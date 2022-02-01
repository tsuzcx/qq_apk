import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class aadn<T, E extends aadu>
  implements aadq<T, E>
{
  private static Map<String, Object> a = new ConcurrentHashMap();
  
  public abstract long a(T paramT);
  
  public abstract T a(T paramT1, T paramT2);
  
  public abstract String a(T paramT);
  
  public void a(T paramT, E paramE)
  {
    if ((paramT == null) || (paramE == null)) {}
    for (;;)
    {
      return;
      for (;;)
      {
        String str;
        try
        {
          for (;;)
          {
            str = a(paramT);
            boolean bool = TextUtils.isEmpty(str);
            if (bool) {
              break label140;
            }
            try
            {
              localObject = a.get(str);
              if (localObject != null) {
                break label115;
              }
              QLog.d(a(paramT), 4, "preReq is null");
              a.put(str, paramT);
              aayz.b(str, a(paramT), new aado(this, str, paramE));
            }
            catch (Exception paramT)
            {
              QLog.d(a(), 1, paramT.getMessage());
            }
          }
          break;
        }
        finally {}
        label115:
        Object localObject = a(localObject, paramT);
        a.put(str, localObject);
      }
      label140:
      paramE.a(paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadn
 * JD-Core Version:    0.7.0.1
 */