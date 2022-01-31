package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.plugin.fts.a.a.l;
import java.util.List;

public abstract class a<T>
{
  protected String bVk;
  protected int qVZ;
  
  public a(String paramString)
  {
    this.bVk = paramString;
    this.qVZ = 2147483647;
  }
  
  public abstract void da(List<l> paramList);
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof a)) {
        break;
      }
      paramObject = (a)paramObject;
      if ((this.bVk == paramObject.bVk) || ((this.bVk != null) && (this.bVk.equalsIgnoreCase(paramObject.bVk)))) {}
      for (int i = 1; (paramObject.qVZ != this.qVZ) || (i == 0); i = 0) {
        return false;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.a
 * JD-Core Version:    0.7.0.1
 */