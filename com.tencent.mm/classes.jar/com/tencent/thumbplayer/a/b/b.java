package com.tencent.thumbplayer.a.b;

import com.tencent.thumbplayer.a.b.b.c;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public abstract class b
  implements a
{
  protected com.tencent.thumbplayer.a.b.a.a ZBb;
  
  public b(com.tencent.thumbplayer.a.b.a.a parama)
  {
    this.ZBb = parama;
  }
  
  static boolean b(com.tencent.thumbplayer.a.b paramb)
  {
    return (TPNativeLibraryLoader.isLibLoaded()) && (c.d(paramb));
  }
  
  private static boolean c(com.tencent.thumbplayer.a.b paramb)
  {
    return c.e(paramb);
  }
  
  public int a(com.tencent.thumbplayer.a.b paramb)
  {
    int i = 2;
    switch (this.ZBb.ZBf)
    {
    default: 
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
          } while (b(paramb));
          return 0;
        } while (b(paramb));
        return 1;
        if (c(paramb)) {
          return 1;
        }
        return 0;
        if (c(paramb)) {
          return 1;
        }
      } while (TPNativeLibraryLoader.isLibLoaded());
      return 0;
    } while (b(paramb));
    return 1;
  }
  
  public int a(com.tencent.thumbplayer.a.b paramb, com.tencent.thumbplayer.a.b.a.b paramb1)
  {
    if (paramb1.ZBh == 0) {
      return a(paramb);
    }
    return 0;
  }
  
  public int[] iqE()
  {
    switch (this.ZBb.ZBe)
    {
    default: 
      return null;
    case 1: 
      return new int[] { 102 };
    case 2: 
      return new int[] { 102, 101 };
    case 3: 
      return new int[] { 101 };
    case 4: 
      return new int[] { 101, 102 };
    }
    return new int[] { 102, 101 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b
 * JD-Core Version:    0.7.0.1
 */