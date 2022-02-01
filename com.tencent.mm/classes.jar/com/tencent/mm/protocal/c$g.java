package com.tencent.mm.protocal;

public abstract class c$g
{
  protected String FFx = "";
  protected int FFy = -1;
  protected boolean FFz = false;
  protected String NAME = "noName";
  
  public c$g() {}
  
  public c$g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.NAME = paramString1;
    this.FFx = paramString2;
    this.FFy = paramInt;
    this.FFz = paramBoolean;
  }
  
  public final String fjR()
  {
    return this.FFx;
  }
  
  public final int fjS()
  {
    return this.FFy;
  }
  
  public final boolean fjT()
  {
    return this.FFz;
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