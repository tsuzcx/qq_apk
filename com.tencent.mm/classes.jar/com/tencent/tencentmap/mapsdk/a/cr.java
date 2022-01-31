package com.tencent.tencentmap.mapsdk.a;

import java.util.HashMap;
import java.util.Map;

public final class cr
  extends dc
  implements Cloneable
{
  private static Map<Integer, byte[]> b;
  public Map<Integer, byte[]> a = null;
  
  public final void a(da paramda)
  {
    if (b == null)
    {
      b = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      b.put(Integer.valueOf(0), arrayOfByte);
    }
    this.a = ((Map)paramda.a(b, 0, true));
  }
  
  public final void a(db paramdb)
  {
    paramdb.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.cr
 * JD-Core Version:    0.7.0.1
 */