package com.tencent.mm.plugin.websearch.a.a;

import com.tencent.mm.plugin.fts.a.a.m;
import java.util.List;

public abstract class a<T>
{
  protected int DDd;
  protected String query;
  
  public a(String paramString)
  {
    this.query = paramString;
    this.DDd = 2147483647;
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
      for (int i = 1; (paramObject.DDd != this.DDd) || (i == 0); i = 0) {
        return false;
      }
    }
    return false;
  }
  
  public abstract void gR(List<m> paramList);
  
  public int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.a.a
 * JD-Core Version:    0.7.0.1
 */