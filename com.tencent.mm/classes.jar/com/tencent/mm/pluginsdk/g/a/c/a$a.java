package com.tencent.mm.pluginsdk.g.a.c;

public abstract class a$a<T extends a>
{
  protected String cqq;
  protected long fSm;
  protected int networkType;
  protected int priority;
  protected final String url;
  protected String vMK;
  protected int vMT;
  
  public a$a(String paramString)
  {
    this.url = paramString;
  }
  
  public final a<T> LM(int paramInt)
  {
    this.networkType = paramInt;
    return this;
  }
  
  public final a<T> LN(int paramInt)
  {
    this.vMT = paramInt;
    return this;
  }
  
  public final a<T> LO(int paramInt)
  {
    this.priority = paramInt;
    return this;
  }
  
  public final a<T> alK(String paramString)
  {
    this.vMK = paramString;
    return this;
  }
  
  public final a<T> alL(String paramString)
  {
    this.cqq = paramString;
    return this;
  }
  
  public final a<T> nA(long paramLong)
  {
    this.fSm = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */