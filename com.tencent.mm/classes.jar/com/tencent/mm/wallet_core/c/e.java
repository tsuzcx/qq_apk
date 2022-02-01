package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public int JEL;
  public int errCode;
  public String errMsg;
  public int errType;
  
  public e()
  {
    this.JEL = 0;
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.JEL = 0;
  }
  
  public e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(72742);
    this.JEL = 0;
    e(paramInt1, paramInt2, paramString, 0);
    AppMethodBeat.o(72742);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.JEL = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */