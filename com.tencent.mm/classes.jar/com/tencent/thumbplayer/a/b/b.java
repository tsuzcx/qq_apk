package com.tencent.thumbplayer.a.b;

import com.tencent.thumbplayer.a.b.b.c;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;

public abstract class b
  implements a
{
  protected com.tencent.thumbplayer.a.b.a.a ahGe;
  
  public b(com.tencent.thumbplayer.a.b.a.a parama)
  {
    this.ahGe = parama;
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
    switch (this.ahGe.ahGi)
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
    int j = 0;
    int k = this.ahGe.ahGi;
    int i;
    if (paramb1.ahGk == 0) {
      i = a(paramb);
    }
    label144:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return i;
                    i = j;
                  } while (!kaa());
                  i = j;
                  switch (k)
                  {
                  case 1: 
                  case 3: 
                  default: 
                    return 0;
                  case 0: 
                    if (paramb1.ahGk != 1) {
                      break label144;
                    }
                    i = j;
                  }
                } while (!b(paramb));
                return 2;
                i = j;
              } while (paramb1.ahGk != 2);
              i = j;
            } while (!c(paramb));
            return 1;
            i = j;
          } while (paramb1.ahGk != 1);
          i = j;
        } while (!b(paramb));
        return 2;
        i = j;
      } while (paramb1.ahGk != 2);
      i = j;
    } while (!c(paramb));
    return 1;
  }
  
  public int[] jZZ()
  {
    switch (this.ahGe.ahGh)
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
  
  protected boolean kaa()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.b.b
 * JD-Core Version:    0.7.0.1
 */