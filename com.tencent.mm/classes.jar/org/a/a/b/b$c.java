package org.a.a.b;

import java.util.HashMap;
import java.util.Map;

class b$c
  implements b.a
{
  private final Map xsH = new HashMap();
  private final c xsI = new c();
  
  public final int ahp(String paramString)
  {
    paramString = this.xsH.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return ((Integer)paramString).intValue();
  }
  
  public final void h(String paramString, int paramInt)
  {
    this.xsH.put(paramString, new Integer(paramInt));
    this.xsI.n(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.a.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */