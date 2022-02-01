package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.al.n;

public abstract class b
  extends n
{
  protected int AFI;
  protected String Ky;
  protected int mScene;
  
  public final int ehC()
  {
    return this.AFI;
  }
  
  public abstract String ehF();
  
  public final String getQuery()
  {
    return this.Ky;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.b
 * JD-Core Version:    0.7.0.1
 */