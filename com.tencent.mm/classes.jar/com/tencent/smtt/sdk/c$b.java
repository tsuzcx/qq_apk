package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class c$b
{
  public int a = -1;
  public int b = -1;
  public String c = "";
  public long d = -1L;
  
  public String toString()
  {
    AppMethodBeat.i(219726);
    String str = "{seqId=" + this.a + ", code=" + this.b + ", extra='" + this.c + '\'' + ", expired=" + this.d + '}';
    AppMethodBeat.o(219726);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */