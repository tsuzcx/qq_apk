package com.tencent.mm.sdk.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;

public class b<R>
{
  private HashMap<String, LinkedList<R>> ap = new HashMap();
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      aam = bool;
      return;
    }
  }
  
  private boolean c(R paramR, String paramString)
  {
    boolean bool;
    if (paramR == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        LinkedList localLinkedList = (LinkedList)this.ap.get(paramString);
        if (localLinkedList != null)
        {
          bool = localLinkedList.remove(paramR);
          if ((bool) && (localLinkedList.size() == 0)) {
            this.ap.remove(paramString);
          }
          continue;
        }
        bool = false;
      }
      finally {}
    }
  }
  
  /* Error */
  public final R a(R paramR, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: invokespecial 53	com/tencent/mm/sdk/b/b:c	(Ljava/lang/Object;Ljava/lang/String;)Z
    //   8: pop
    //   9: aload_0
    //   10: getfield 29	com/tencent/mm/sdk/b/b:ap	Ljava/util/HashMap;
    //   13: aload_2
    //   14: invokevirtual 35	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 37	java/util/LinkedList
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +12 -> 34
    //   25: aload_1
    //   26: invokevirtual 45	java/util/LinkedList:size	()I
    //   29: istore_3
    //   30: iload_3
    //   31: ifgt +9 -> 40
    //   34: aconst_null
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: aload_1
    //   41: invokevirtual 57	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   44: astore_1
    //   45: goto -9 -> 36
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	b
    //   0	53	1	paramR	R
    //   0	53	2	paramString	String
    //   29	2	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	21	48	finally
    //   25	30	48	finally
    //   40	45	48	finally
  }
  
  public final boolean b(R paramR, String paramString)
  {
    try
    {
      if ((!aam) && (paramR == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    if ((!aam) && (TextUtils.isEmpty(paramString))) {
      throw new AssertionError();
    }
    LinkedList localLinkedList = (LinkedList)this.ap.get(paramString);
    if (localLinkedList == null)
    {
      HashMap localHashMap = this.ap;
      localLinkedList = new LinkedList();
      localHashMap.put(paramString, localLinkedList);
    }
    for (paramString = localLinkedList;; paramString = localLinkedList)
    {
      if (paramString.size() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramString.add(paramR);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b
 * JD-Core Version:    0.7.0.1
 */