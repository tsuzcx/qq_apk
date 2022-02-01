package com.tencent.mm.protocal;

public abstract class c$g
{
  protected String CpA = "";
  protected int CpB = -1;
  protected boolean CpC = false;
  protected String NAME = "noName";
  
  public c$g() {}
  
  public c$g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.NAME = paramString1;
    this.CpA = paramString2;
    this.CpB = paramInt;
    this.CpC = paramBoolean;
  }
  
  public final String eBC()
  {
    return this.CpA;
  }
  
  public final int eBD()
  {
    return this.CpB;
  }
  
  public final boolean eBE()
  {
    return this.CpC;
  }
  
  public final String getName()
  {
    return this.NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.g
 * JD-Core Version:    0.7.0.1
 */