package com.tencent.mm.protocal;

public abstract class c$g
{
  protected String FmZ = "";
  protected int Fna = -1;
  protected boolean Fnb = false;
  protected String NAME = "noName";
  
  public c$g() {}
  
  public c$g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.NAME = paramString1;
    this.FmZ = paramString2;
    this.Fna = paramInt;
    this.Fnb = paramBoolean;
  }
  
  public final String fgb()
  {
    return this.FmZ;
  }
  
  public final int fgc()
  {
    return this.Fna;
  }
  
  public final boolean fgd()
  {
    return this.Fnb;
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