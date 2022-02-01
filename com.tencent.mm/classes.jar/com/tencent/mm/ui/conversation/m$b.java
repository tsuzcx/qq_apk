package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m$b
{
  long Qgt = 0L;
  private long Qgu = 0L;
  private long Qgv = 0L;
  long Qgw = 0L;
  long Qgx = 0L;
  
  public final String toString()
  {
    AppMethodBeat.i(234219);
    try
    {
      String str = String.format("total=%d, hit=%d [%.2f%%], reset,fill=%d, %d [%.2f%%], compare=%d [%.2f%%]", new Object[] { Long.valueOf(this.Qgt), Long.valueOf(this.Qgu), Float.valueOf((float)this.Qgu * 100.0F / (float)this.Qgt), Long.valueOf(this.Qgv), Long.valueOf(this.Qgw), Float.valueOf((float)this.Qgv * 100.0F / (float)this.Qgw), Long.valueOf(this.Qgx), Float.valueOf((float)this.Qgx * 100.0F / (float)this.Qgt) });
      AppMethodBeat.o(234219);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("total=").append(this.Qgt).append("hit=").append(this.Qgu).append("clearWindow=").append(this.Qgv).append("fillWindow=").append(this.Qgw).append("compare=").append(this.Qgx);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(234219);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.m.b
 * JD-Core Version:    0.7.0.1
 */