package com.tencent.mm.protocal;

public abstract class c$g
{
  protected String KyD = "";
  protected int KyE = -1;
  protected boolean KyF = false;
  protected String NAME = "noName";
  
  public c$g() {}
  
  public c$g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.NAME = paramString1;
    this.KyD = paramString2;
    this.KyE = paramInt;
    this.KyF = paramBoolean;
  }
  
  public final String getName()
  {
    return this.NAME;
  }
  
  public final String gts()
  {
    return this.KyD;
  }
  
  public final int gtt()
  {
    return this.KyE;
  }
  
  public final boolean gtu()
  {
    return this.KyF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.g
 * JD-Core Version:    0.7.0.1
 */