package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.plugin.fts.a.a.o;
import java.util.List;

public abstract class a<T>
{
  protected int Wre;
  protected String query;
  
  public a(String paramString, int paramInt)
  {
    this.query = paramString;
    this.Wre = 2147483647;
  }
  
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
      if ((this.query == paramObject.query) || ((this.query != null) && (this.query.equalsIgnoreCase(paramObject.query)))) {}
      for (int i = 1; (paramObject.Wre != this.Wre) || (i == 0); i = 0) {
        return false;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public abstract void mf(List<o> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.c.a.a
 * JD-Core Version:    0.7.0.1
 */