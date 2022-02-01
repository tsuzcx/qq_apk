package com.tencent.mm.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
{
  public int agSM;
  public int errCode;
  public String errMsg;
  public int errType;
  
  public e()
  {
    this.agSM = 0;
    this.errType = 0;
    this.errCode = 0;
    this.errMsg = "";
    this.agSM = 0;
  }
  
  public e(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(72742);
    this.agSM = 0;
    g(paramInt1, paramInt2, paramString, 0);
    AppMethodBeat.o(72742);
  }
  
  public final void g(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.agSM = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.model.e
 * JD-Core Version:    0.7.0.1
 */