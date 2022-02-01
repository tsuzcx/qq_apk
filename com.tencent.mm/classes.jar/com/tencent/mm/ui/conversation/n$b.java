package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n$b
{
  private long XDA = 0L;
  long XDB = 0L;
  long XDC = 0L;
  long XDy = 0L;
  private long XDz = 0L;
  
  public final String toString()
  {
    AppMethodBeat.i(270540);
    try
    {
      String str = String.format("total=%d, hit=%d [%.2f%%], reset,fill=%d, %d [%.2f%%], compare=%d [%.2f%%]", new Object[] { Long.valueOf(this.XDy), Long.valueOf(this.XDz), Float.valueOf((float)this.XDz * 100.0F / (float)this.XDy), Long.valueOf(this.XDA), Long.valueOf(this.XDB), Float.valueOf((float)this.XDA * 100.0F / (float)this.XDB), Long.valueOf(this.XDC), Float.valueOf((float)this.XDC * 100.0F / (float)this.XDy) });
      AppMethodBeat.o(270540);
      return str;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("total=").append(this.XDy).append("hit=").append(this.XDz).append("clearWindow=").append(this.XDA).append("fillWindow=").append(this.XDB).append("compare=").append(this.XDC);
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(270540);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.n.b
 * JD-Core Version:    0.7.0.1
 */