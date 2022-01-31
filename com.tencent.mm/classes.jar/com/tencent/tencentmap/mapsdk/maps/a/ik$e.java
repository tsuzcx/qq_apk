package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.map.lib.element.j;

class ik$e
{
  private int a;
  private iu b;
  private j c;
  private int d;
  private int e;
  private Rect f;
  private int g;
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/tencentmap/mapsdk/maps/a/ik$e:g	I
    //   6: istore_1
    //   7: iload_1
    //   8: iconst_2
    //   9: if_icmpne +9 -> 18
    //   12: iconst_1
    //   13: istore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_2
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_2
    //   20: goto -6 -> 14
    //   23: astore_3
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	e
    //   6	4	1	i	int
    //   13	7	2	bool	boolean
    //   23	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	23	finally
  }
  
  public void b()
  {
    try
    {
      this.g = 2;
      this.a = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean c()
  {
    return this.g == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ik.e
 * JD-Core Version:    0.7.0.1
 */