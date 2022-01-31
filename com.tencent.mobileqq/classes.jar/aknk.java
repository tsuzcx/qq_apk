import java.util.ArrayList;
import java.util.List;

public abstract class aknk<T>
{
  protected final List<aknn> a = new ArrayList();
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	aknk:a	Ljava/util/List;
    //   6: invokeinterface 28 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	aknk
    //   11	13	1	bool	boolean
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	27	finally
  }
  
  public boolean a(aknn paramaknn)
  {
    try
    {
      boolean bool = this.a.remove(paramaknn);
      return bool;
    }
    finally
    {
      paramaknn = finally;
      throw paramaknn;
    }
  }
  
  public abstract boolean a(T paramT, float paramFloat);
  
  /* Error */
  public boolean a(List<aknn> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +27 -> 30
    //   6: aload_1
    //   7: invokeinterface 28 1 0
    //   12: ifne +18 -> 30
    //   15: aload_0
    //   16: getfield 17	aknk:a	Ljava/util/List;
    //   19: aload_1
    //   20: invokeinterface 39 2 0
    //   25: istore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iconst_0
    //   31: istore_2
    //   32: goto -6 -> 26
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	aknk
    //   0	40	1	paramList	List<aknn>
    //   25	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	26	35	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aknk
 * JD-Core Version:    0.7.0.1
 */