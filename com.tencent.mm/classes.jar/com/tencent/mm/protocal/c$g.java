package com.tencent.mm.protocal;

public abstract class c$g
{
  protected String NAME = "noName";
  protected String soQ = "";
  protected int soR = -1;
  protected boolean soS = false;
  
  public c$g() {}
  
  public c$g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.NAME = paramString1;
    this.soQ = paramString2;
    this.soR = paramInt;
    this.soS = paramBoolean;
  }
  
  public final String coO()
  {
    return this.soQ;
  }
  
  public final int coP()
  {
    return this.soR;
  }
  
  public final boolean coQ()
  {
    return this.soS;
  }
  
  public final String getName()
  {
    return this.NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.g
 * JD-Core Version:    0.7.0.1
 */