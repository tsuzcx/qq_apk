package com.tencent.mm.protocal;

public abstract class c$g
{
  protected String NAME = "noName";
  protected String whx = "";
  protected int why = -1;
  protected boolean whz = false;
  
  public c$g() {}
  
  public c$g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.NAME = paramString1;
    this.whx = paramString2;
    this.why = paramInt;
    this.whz = paramBoolean;
  }
  
  public final String dql()
  {
    return this.whx;
  }
  
  public final int dqm()
  {
    return this.why;
  }
  
  public final boolean dqn()
  {
    return this.whz;
  }
  
  public final String getName()
  {
    return this.NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.g
 * JD-Core Version:    0.7.0.1
 */