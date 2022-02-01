package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class f
{
  public int errCode;
  public String errMsg;
  
  public f(int paramInt)
  {
    AppMethodBeat.i(88661);
    this.errCode = paramInt;
    switch (this.errCode)
    {
    case 1: 
    default: 
      this.errMsg = "errmsg not specified";
      AppMethodBeat.o(88661);
      return;
    case 0: 
      this.errMsg = "ok";
      AppMethodBeat.o(88661);
      return;
    }
    this.errMsg = "device not support soter";
    AppMethodBeat.o(88661);
  }
  
  public f(int paramInt, String paramString)
  {
    this(paramInt);
    AppMethodBeat.i(88660);
    if (!g.isNullOrNil(paramString)) {
      this.errMsg = paramString;
    }
    AppMethodBeat.o(88660);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof f)) && (((f)paramObject).errCode == this.errCode);
  }
  
  public final boolean isSuccess()
  {
    return this.errCode == 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(88662);
    String str = "SoterCoreResult{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + '}';
    AppMethodBeat.o(88662);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.soter.core.c.f
 * JD-Core Version:    0.7.0.1
 */