package com.tencent.mm.protocal;

public abstract class c$g
{
  protected String DHS = "";
  protected int DHT = -1;
  protected boolean DHU = false;
  protected String NAME = "noName";
  
  public c$g() {}
  
  public c$g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.NAME = paramString1;
    this.DHS = paramString2;
    this.DHT = paramInt;
    this.DHU = paramBoolean;
  }
  
  public final String eQX()
  {
    return this.DHS;
  }
  
  public final int eQY()
  {
    return this.DHT;
  }
  
  public final boolean eQZ()
  {
    return this.DHU;
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