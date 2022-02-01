import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class adbe<K, T>
  implements adbd<K, T>
{
  private Map<K, Class<? extends T>> a = new HashMap();
  private Map<K, T> b = new HashMap();
  
  private T a(Class<? extends T> paramClass)
  {
    try
    {
      paramClass = paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      QLog.e("MapClassGeneratorImpl", 1, paramClass, new Object[0]);
    }
    return null;
  }
  
  /* Error */
  public T a(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	adbe:b	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 49 2 0
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +7 -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: areturn
    //   21: aload_0
    //   22: getfield 21	adbe:a	Ljava/util/Map;
    //   25: aload_1
    //   26: invokeinterface 49 2 0
    //   31: checkcast 29	java/lang/Class
    //   34: astore_2
    //   35: aload_2
    //   36: ifnonnull +8 -> 44
    //   39: aconst_null
    //   40: astore_2
    //   41: goto -24 -> 17
    //   44: aload_0
    //   45: aload_2
    //   46: invokespecial 51	adbe:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   49: astore_3
    //   50: aload_3
    //   51: astore_2
    //   52: aload_3
    //   53: ifnull -36 -> 17
    //   56: aload_0
    //   57: getfield 23	adbe:b	Ljava/util/Map;
    //   60: aload_1
    //   61: aload_3
    //   62: invokeinterface 55 3 0
    //   67: pop
    //   68: aload_3
    //   69: astore_2
    //   70: goto -53 -> 17
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	adbe
    //   0	78	1	paramK	K
    //   12	58	2	localObject1	Object
    //   49	20	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	73	finally
    //   21	35	73	finally
    //   44	50	73	finally
    //   56	68	73	finally
  }
  
  public void a(K paramK, Class<? extends T> paramClass)
  {
    try
    {
      this.a.put(paramK, paramClass);
      return;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbe
 * JD-Core Version:    0.7.0.1
 */