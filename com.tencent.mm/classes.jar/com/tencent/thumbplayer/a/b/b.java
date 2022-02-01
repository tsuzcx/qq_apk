package com.tencent.thumbplayer.a.b;

import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public abstract class b
  implements a
{
  protected com.tencent.thumbplayer.a.b.a.a KeK;
  
  public b(com.tencent.thumbplayer.a.b.a.a parama)
  {
    this.KeK = parama;
  }
  
  private static boolean b(com.tencent.thumbplayer.a.b paramb)
  {
    return (TPNativeLibraryLoader.isLibLoaded()) && (com.tencent.thumbplayer.a.b.b.a.d(paramb));
  }
  
  private static boolean c(com.tencent.thumbplayer.a.b paramb)
  {
    return com.tencent.thumbplayer.a.b.b.a.e(paramb);
  }
  
  public final int a(com.tencent.thumbplayer.a.b paramb)
  {
    int i = 2;
    switch (this.KeK.KeM)
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
  
  public final int a(com.tencent.thumbplayer.a.b paramb, com.tencent.thumbplayer.a.b.a.b paramb1)
  {
    if (paramb1.KeN == 0) {
      return a(paramb);
    }
    return 0;
  }
  
  public final int[] fFb()
  {
    switch (this.KeK.KeL)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b
 * JD-Core Version:    0.7.0.1
 */