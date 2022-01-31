package com.tencent.mm.pluginsdk.g.a.c;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public abstract class f<T extends f.b>
{
  final Map<String, f.b> rXo = new ConcurrentHashMap();
  final Map<String, Future<?>> rXp = new ConcurrentHashMap();
  
  /* Error */
  public final boolean Wj(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/tencent/mm/pluginsdk/g/a/c/f:rXp	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 38 2 0
    //   12: ifne +18 -> 30
    //   15: aload_0
    //   16: getfield 27	com/tencent/mm/pluginsdk/g/a/c/f:rXo	Ljava/util/Map;
    //   19: aload_1
    //   20: invokeinterface 38 2 0
    //   25: istore_2
    //   26: iload_2
    //   27: ifeq +9 -> 36
    //   30: iconst_1
    //   31: istore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_2
    //   38: goto -6 -> 32
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	f
    //   0	46	1	paramString	String
    //   25	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	26	41	finally
  }
  
  public abstract f.d a(T paramT);
  
  public final void b(T paramT)
  {
    this.rXo.put(paramT.cls(), paramT);
    clz().submit(a(paramT));
  }
  
  public abstract f<T>.a clz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.f
 * JD-Core Version:    0.7.0.1
 */