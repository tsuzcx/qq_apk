package com.tencent.mm.wallet_core.c;

public final class c
{
  public String aox;
  public int errCode;
  public int errType;
  public int wAk = 0;
  
  public c()
  {
    this.errType = 0;
    this.errCode = 0;
    this.aox = "";
    this.wAk = 0;
  }
  
  public c(int paramInt1, int paramInt2, String paramString)
  {
    f(paramInt1, paramInt2, paramString, 0);
  }
  
  public final void f(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.aox = paramString;
    this.wAk = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.c
 * JD-Core Version:    0.7.0.1
 */