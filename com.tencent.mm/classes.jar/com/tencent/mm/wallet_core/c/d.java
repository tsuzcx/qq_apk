package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public int AWM;
  public int errCode;
  public String errMsg;
  public int errType;
  
  public d()
  {
    this.AWM = 0;
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.AWM = 0;
  }
  
  public d(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(49037);
    this.AWM = 0;
    e(paramInt1, paramInt2, paramString, 0);
    AppMethodBeat.o(49037);
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.AWM = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.d
 * JD-Core Version:    0.7.0.1
 */