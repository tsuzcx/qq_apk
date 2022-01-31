package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ai.m;

public abstract class b
  extends m
{
  protected String DK;
  protected int mScene;
  protected int uIB;
  
  public abstract String act();
  
  public final int cZa()
  {
    return this.uIB;
  }
  
  public final String getQuery()
  {
    return this.DK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.b
 * JD-Core Version:    0.7.0.1
 */