package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  public int YUS;
  public int errCode;
  public String errMsg;
  public int errType;
  
  public e()
  {
    this.YUS = 0;
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.YUS = 0;
  }
  
  public e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(72742);
    this.YUS = 0;
    i(paramInt1, paramInt2, paramString, 0);
    AppMethodBeat.o(72742);
  }
  
  public final void i(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.YUS = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.e
 * JD-Core Version:    0.7.0.1
 */