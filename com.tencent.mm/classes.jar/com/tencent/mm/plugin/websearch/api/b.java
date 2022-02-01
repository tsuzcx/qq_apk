package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ak.q;

public abstract class b
  extends q
{
  protected int IDq;
  protected String Nv;
  protected int mScene;
  
  public abstract String fXC();
  
  public final int fXz()
  {
    return this.IDq;
  }
  
  public final String getQuery()
  {
    return this.Nv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.b
 * JD-Core Version:    0.7.0.1
 */