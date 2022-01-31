import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class abpf<T>
  implements abpe<T>
{
  private SparseArray<Class<? extends T>> a = new SparseArray();
  private SparseArray<T> b = new SparseArray();
  
  private T a(Class<? extends T> paramClass)
  {
    try
    {
      paramClass = paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      QLog.e("IntClassGeneratorImpl", 1, paramClass, new Object[0]);
    }
    return null;
  }
  
  /* Error */
  public T a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	abpf:b	Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual 47	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: areturn
    //   19: aload_0
    //   20: getfield 21	abpf:a	Landroid/util/SparseArray;
    //   23: iload_1
    //   24: invokevirtual 47	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   27: checkcast 29	java/lang/Class
    //   30: astore_2
    //   31: aload_2
    //   32: ifnonnull +8 -> 40
    //   35: aconst_null
    //   36: astore_2
    //   37: goto -22 -> 15
    //   40: aload_0
    //   41: aload_2
    //   42: invokespecial 49	abpf:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: ifnull -34 -> 15
    //   52: aload_0
    //   53: getfield 23	abpf:b	Landroid/util/SparseArray;
    //   56: iload_1
    //   57: aload_3
    //   58: invokevirtual 53	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   61: aload_3
    //   62: astore_2
    //   63: goto -48 -> 15
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	abpf
    //   0	71	1	paramInt	int
    //   10	53	2	localObject1	Object
    //   66	4	2	localObject2	Object
    //   45	17	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	66	finally
    //   19	31	66	finally
    //   40	46	66	finally
    //   52	61	66	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abpf
 * JD-Core Version:    0.7.0.1
 */