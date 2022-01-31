package org.c.f;

import java.util.Random;

public final class d
  implements c
{
  private d.a xuX = new d.a();
  
  private static Long cVh()
  {
    return Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() / 1000L);
  }
  
  public final String cVg()
  {
    return String.valueOf(cVh());
  }
  
  public final String getNonce()
  {
    return String.valueOf(cVh().longValue() + Integer.valueOf(new Random().nextInt()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.c.f.d
 * JD-Core Version:    0.7.0.1
 */