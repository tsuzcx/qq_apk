package com.tencent.mm.plugin.r;

import com.tencent.mm.kernel.b.c;

public final class b
  implements c
{
  private static b mbV;
  
  public static b bhF()
  {
    try
    {
      if (mbV == null) {
        mbV = new b();
      }
      b localb = mbV;
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.r.b
 * JD-Core Version:    0.7.0.1
 */